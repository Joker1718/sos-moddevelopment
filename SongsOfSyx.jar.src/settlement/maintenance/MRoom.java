/*     */ package settlement.maintenance;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MRoom
/*     */   extends MType
/*     */ {
/*  19 */   private static double MIN_JOBS = 4.0D;
/*  20 */   private static final Bits extraBit = new Bits(-2147483648);
/*  21 */   private static final Bits jobsPlaced = new Bits(2130706432);
/*  22 */   private static final Bits secret = new Bits(15);
/*  23 */   private static final Bits tot = new Bits(16777200);
/*  24 */   private static final int jobSize = tot.mask / 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean validate(int tx, int ty) {
/*  38 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/*  39 */     if (room != null) {
/*  40 */       ROOM_DEGRADER deg = room.degrader(tx, ty);
/*  41 */       if (deg == null || isBlocked(tx, ty, room)) {
/*  42 */         return false;
/*     */       }
/*  44 */       return true;
/*     */     } 
/*  46 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isBlocked(int tx, int ty, Room room) {
/*  50 */     if (room.isBadMaintenanceTile(tx, ty))
/*  51 */       return true; 
/*  52 */     for (DIR d : DIR.ORTHO) {
/*  53 */       int dx = tx + d.x();
/*  54 */       int dy = ty + d.y();
/*  55 */       if (!SETT.IN_BOUNDS(dx, dy)) {
/*     */         continue;
/*     */       }
/*  58 */       if (room.isSame(tx, ty, dx, dy)) {
/*  59 */         if (((SETT.PATH()).availability.get(dx, dy)).player <= AVAILABILITY.ROOM.player && ((SETT.PATH()).availability.get(dx, dy)).player > 0.0D)
/*  60 */           return false;  continue;
/*  61 */       }  if (((SETT.PATH()).availability.get(dx, dy)).player > 0.0D) {
/*  62 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  66 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean degrade(int tx, int ty, int tile, double rate) {
/*  72 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/*  73 */     if (room == null) {
/*  74 */       return false;
/*     */     }
/*  76 */     ROOM_DEGRADER deg = room.degrader(tx, ty);
/*  77 */     if (deg == null) {
/*  78 */       return true;
/*     */     }
/*  80 */     double r = deg.rate(rate);
/*  81 */     if (locked(room, tx, ty))
/*  82 */       r *= 3.0D; 
/*  83 */     inc(tx, ty, r / room.area(tx, ty));
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void vandalize(int tx, int ty) {
/*  90 */     inc(tx, ty, MIN_JOBS);
/*     */   }
/*     */   
/*  93 */   private static double min = (tot.mask >> 2);
/*  94 */   private static double II = 1.0D / (tot.mask - min);
/*     */   
/*     */   public static double degrade(int data) {
/*  97 */     double w = tot.get(data);
/*  98 */     if (w > min) {
/*  99 */       w -= min;
/* 100 */       w *= II;
/*     */       
/* 102 */       return w;
/*     */     } 
/* 104 */     return 0.0D;
/*     */   }
/*     */   
/*     */   private void inc(int tx, int ty, double am) {
/* 108 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 109 */     ROOM_DEGRADER deg = room.degrader(tx, ty);
/*     */     
/* 111 */     int jz = jobSize(room.area(tx, ty));
/*     */     
/* 113 */     double d = jz * am;
/* 114 */     int dd = (int)d;
/* 115 */     if (d > 0.0D) {
/* 116 */       if (RND.rFloat() < dd - d) {
/* 117 */         dd++;
/*     */       }
/* 119 */     } else if (RND.rFloat() < -(dd - d)) {
/* 120 */       dd--;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     if (dd != 0) {
/*     */       
/* 128 */       int data = deg.getData();
/*     */       
/* 130 */       int a = tot.get(data) + dd + secret.get(data) * jz;
/* 131 */       int s = CLAMP.i(a / jz, 0, 4);
/* 132 */       a -= s * jz;
/*     */       
/* 134 */       a = CLAMP.i(a, 0, tot.mask);
/*     */       
/* 136 */       data = tot.set(data, a);
/* 137 */       data = secret.set(data, s);
/* 138 */       set(deg, data);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int jobSize(int area) {
/* 147 */     return (int)Math.ceil((jobSize / area));
/*     */   }
/*     */ 
/*     */   
/*     */   public int shouldPlaceResource(int tx, int ty) {
/* 152 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 153 */     if (room == null)
/* 154 */       return 0; 
/* 155 */     ROOM_DEGRADER deg = room.degrader(tx, ty);
/* 156 */     if (deg == null) {
/* 157 */       return 0;
/*     */     }
/* 159 */     if (deg.resSize() == 0) {
/* 160 */       return 0;
/*     */     }
/* 162 */     double am = 0.0D;
/* 163 */     for (int ri = 0; ri < deg.resSize(); ri++) {
/* 164 */       am += deg.resAmount(ri);
/*     */     }
/*     */     
/* 167 */     double rr = ROOM_DEGRADER.rate(1.0D, 1.0D, 1.0D, am, room.area(tx, ty));
/* 168 */     double rrw = rr - ROOM_DEGRADER.rate(1.0D, 1.0D, 1.0D, 0.0D, room.area(tx, ty));
/*     */     
/* 170 */     if (rrw > rr * RND.rFloat()) {
/* 171 */       double lim = am * RND.rFloat();
/* 172 */       am = 0.0D;
/* 173 */       for (int i = 0; i < deg.resSize(); i++) {
/* 174 */         int a = deg.resAmount(i);
/* 175 */         if (a > 0) {
/* 176 */           am += deg.resAmount(i);
/* 177 */           if (am >= lim && a > 0) {
/* 178 */             return i + 1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public double resRate(int tx, int ty, int ri) {
/* 189 */     if (ri == 0)
/* 190 */       return 0.0D; 
/* 191 */     ri--;
/*     */     
/* 193 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 194 */     if (room != null) {
/* 195 */       ROOM_DEGRADER deg = room.degrader(tx, ty);
/* 196 */       if (deg != null) {
/* 197 */         if (ri >= deg.resSize())
/* 198 */           return 0.0D; 
/* 199 */         return ROOM_DEGRADER.rateResource(1.0D, deg.base(), room.isolation(tx, ty), deg.resAmount(ri)) / room.area(tx, ty);
/*     */       } 
/*     */     } 
/* 202 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void maintain(int tx, int ty) {
/* 207 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/*     */     
/* 209 */     ROOM_DEGRADER deg = room.degrader(tx, ty);
/* 210 */     if (deg == null) {
/* 211 */       GAME.Notify("MAINTENANCE" + tx + " " + ty);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 217 */     inc(tx, ty, -1.0D);
/* 218 */     set(deg, jobsPlaced.inc(deg.getData(), -1));
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE res(int tx, int ty, int ri) {
/* 223 */     if (ri == 0)
/* 224 */       return null; 
/* 225 */     ri--;
/* 226 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 227 */     if (room != null && 
/* 228 */       room.constructor() != null && room.constructor().resources() > 0) {
/* 229 */       return room.constructor().resource(ri % room.constructor().resources());
/*     */     }
/*     */     
/* 232 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldPlace(int tx, int ty, boolean was) {
/* 237 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 238 */     ROOM_DEGRADER deg = room.degrader(tx, ty);
/* 239 */     int data = deg.getData();
/*     */     
/* 241 */     if (isBlocked(tx, ty, room)) {
/* 242 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 246 */     if (locked(room, tx, ty)) {
/* 247 */       return false;
/*     */     }
/* 249 */     if (jobsPlaced.isMaximum(data)) {
/* 250 */       return false;
/*     */     }
/* 252 */     int jobs = tot.get(data) / jobSize(room.area(tx, ty));
/*     */     
/* 254 */     if (was) {
/* 255 */       jobs += secret.get(data);
/*     */     }
/*     */     
/* 258 */     if (jobsPlaced.get(data) >= jobs) {
/* 259 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 263 */     data = jobsPlaced.inc(data, 1);
/* 264 */     set(deg, data);
/*     */     
/* 266 */     return true;
/*     */   }
/*     */   
/*     */   private boolean locked(Room room, int tx, int ty) {
/* 270 */     if (!(room.constructor().blue()).reqs.passes(FACTIONS.player()))
/* 271 */       return true; 
/* 272 */     if (room.upgrade(tx, ty) > 0 && !room.constructor().blue().upgrades().requires(room.upgrade(tx, ty)).passes(FACTIONS.player()))
/* 273 */       return true; 
/* 274 */     return false;
/*     */   }
/*     */   
/*     */   public static int jobs(int data, int area) {
/* 278 */     return secret.get(data) + tot.get(data) / jobSize(area);
/*     */   }
/*     */   
/*     */   public static void initRoom(Room room, int rx, int ry) {
/* 282 */     ROOM_DEGRADER deg = room.degrader(rx, ry);
/* 283 */     if (deg == null)
/*     */       return; 
/* 285 */     int data = deg.getData();
/* 286 */     data = jobsPlaced.set(data, 0);
/* 287 */     set(deg, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public double degrade(int tx, int ty) {
/* 292 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 293 */     ROOM_DEGRADER deg = room.degrader(tx, ty);
/* 294 */     return deg.get();
/*     */   }
/*     */   
/*     */   private static void set(ROOM_DEGRADER deg, int data) {
/* 298 */     double d = degrade(data);
/* 299 */     boolean changed = false;
/* 300 */     if (d > 0.5D) {
/* 301 */       if (extraBit.get(data) == 0) {
/* 302 */         data = extraBit.set(data, 1);
/* 303 */         changed = true;
/*     */       } 
/* 305 */     } else if (d == 0.0D && 
/* 306 */       extraBit.get(data) == 1) {
/* 307 */       data = extraBit.set(data, 0);
/* 308 */       changed = true;
/*     */     } 
/*     */     
/* 311 */     deg.setData(data, changed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean degradeReal(int data) {
/* 317 */     return (extraBit.get(data) == 1);
/*     */   }
/*     */   
/*     */   public static double secretDegrade(int data) {
/* 321 */     return tot.get(data) / tot.mask;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\maintenance\MRoom.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */