/*     */ package settlement.room.spirit.grave;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.race.PERMISSION;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public abstract class GraveData
/*     */ {
/*  35 */   private static final double disturbanceRemove = 1.0D / (TIME.secondsPerDay() * 16);
/*  36 */   private int avai = 0;
/*  37 */   private int tot = 0;
/*     */   private int res;
/*  39 */   private int maxEmpl = 0;
/*     */   private double dist;
/*     */   private final RoomBlueprintIns<?> p;
/*  42 */   private final GraveDataClass[] classes = new GraveDataClass[HCLASSES.ALL().size()];
/*     */   
/*     */   private double upD;
/*     */   
/*     */   private final Grave grave;
/*     */   private final PERMISSION.Permission permission;
/*     */   private final StatStanding.StandingDef standingDef;
/*  49 */   private static CharSequence ¤¤Respect = "¤Respect";
/*  50 */   private static CharSequence ¤¤RespectD = "¤Respect is gained by furnishing your rooms properly and keeping it fully staffed.";
/*  51 */   private static CharSequence ¤¤Disturbance = "¤Grave Disturbance";
/*  52 */   private static CharSequence ¤¤DisturbanceD = "¤Disturbance happens when a occupied burial service is removed or broken. It will slowly decrease with time as subjects forget. Deactivate the room first and let the remains dissipate before removing them.";
/*  53 */   private static CharSequence ¤¤Burried = "¤Buried";
/*  54 */   private static CharSequence ¤¤BurriedD = "¤The amount of subjects successfully buried recently.";
/*  55 */   private static CharSequence ¤¤Corpses = "¤Failed";
/*  56 */   private static CharSequence ¤¤CorpsesD = "¤The amount of corpses that have failed to be buried recently.";
/*  57 */   private static CharSequence ¤¤Value = "¤Value";
/*  58 */   private static CharSequence ¤¤ValueD = "¤The value is the partition of successfully buried multiplied with respect and degrade.";
/*  59 */   private static CharSequence ¤¤Total = "¤Total Graves";
/*  60 */   private static CharSequence ¤¤TotalD = "¤Total amount of graves.";
/*  61 */   private static CharSequence ¤¤Available = "¤Available";
/*  62 */   private static CharSequence ¤¤AvailableD = "¤Available Graves."; public final int composeTime;
/*     */   public final INT_O<Room> available;
/*     */   
/*     */   static {
/*  66 */     D.ts(GraveData.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final INT_O<Room> total;
/*     */ 
/*     */   
/*     */   public final DOUBLE_O<Room> respect;
/*     */ 
/*     */   
/*     */   public DOUBLE disturbance;
/*     */ 
/*     */ 
/*     */   
/*     */   public PERMISSION permission() {
/*  82 */     return (PERMISSION)this.permission;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  87 */     file.i(this.avai);
/*  88 */     file.i(this.tot);
/*  89 */     file.i(this.res);
/*  90 */     file.d(this.dist);
/*  91 */     file.d(this.upD); byte b; int i; GraveDataClass[] arrayOfGraveDataClass;
/*  92 */     for (i = (arrayOfGraveDataClass = this.classes).length, b = 0; b < i; ) { GraveDataClass c = arrayOfGraveDataClass[b];
/*  93 */       c.saver.save(file); b++; }
/*  94 */      this.permission.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  99 */     this.avai = file.i();
/* 100 */     this.tot = file.i();
/* 101 */     this.res = file.i();
/* 102 */     this.dist = file.d();
/* 103 */     this.upD = file.d(); byte b; int j; GraveDataClass[] arrayOfGraveDataClass;
/* 104 */     for (j = (arrayOfGraveDataClass = this.classes).length, b = 0; b < j; ) { GraveDataClass c = arrayOfGraveDataClass[b];
/* 105 */       c.saver.load(file); b++; }
/* 106 */      this.permission.load(file);
/* 107 */     int res = 0;
/* 108 */     int tot = 0;
/* 109 */     for (int i = 0; i < this.p.instancesSize(); i++) {
/* 110 */       GraveInstance ins = (GraveInstance)this.p.getInstance(i);
/*     */ 
/*     */       
/* 113 */       if (ins.active()) {
/* 114 */         double r = respect(ins);
/* 115 */         int t = ins.total();
/* 116 */         res = (int)(res + r * t);
/* 117 */         tot += t;
/* 118 */         this.maxEmpl += ins.employees().max();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 123 */     this.res = res;
/* 124 */     this.tot = tot;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 130 */     this.avai = 0;
/* 131 */     this.tot = 0;
/* 132 */     this.res = 0;
/* 133 */     this.dist = 0.0D;
/* 134 */     this.upD = 0.0D;
/* 135 */     this.maxEmpl = 0; byte b; int i; GraveDataClass[] arrayOfGraveDataClass;
/* 136 */     for (i = (arrayOfGraveDataClass = this.classes).length, b = 0; b < i; ) { GraveDataClass c = arrayOfGraveDataClass[b];
/* 137 */       c.saver.clear();
/*     */       b++; }
/*     */   
/*     */   } public FSERVICE burrialService(int tx, int ty) {
/* 141 */     if (this.grave.get(tx, ty) != null)
/* 142 */       return this.grave.service; 
/* 143 */     return null;
/*     */   }
/*     */   
/*     */   Grave grave(int tx, int ty) {
/* 147 */     return this.grave.get(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public GRAVE_JOB work() {
/* 152 */     if (this.avai <= 0) {
/* 153 */       return null;
/*     */     }
/* 155 */     int max = blueprint().instancesSize();
/* 156 */     int ri = RND.rInt(max);
/*     */     
/* 158 */     for (int i = 0; i < blueprint().instancesSize(); i++) {
/* 159 */       RoomInstance ins = blueprint().getInstance((i + ri) % max);
/*     */       
/* 161 */       GRAVE_JOB j = work(ins);
/* 162 */       if (j != null) {
/* 163 */         return j;
/*     */       }
/*     */     } 
/* 166 */     GAME.Notify("strange!");
/*     */     
/* 168 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public GRAVE_JOB work(RoomInstance room) {
/* 173 */     GraveInstance ins = (GraveInstance)room;
/* 174 */     if (ins.available() <= 0)
/* 175 */       return null; 
/* 176 */     ins.jobs.searchAgain();
/* 177 */     GRAVE_JOB j = (GRAVE_JOB)ins.jobs.getReservableJob(null);
/* 178 */     if (j == null) {
/* 179 */       GAME.Notify("strange!!");
/* 180 */       return null;
/*     */     } 
/* 182 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public GRAVE_JOB work(int tx, int ty) {
/* 187 */     return this.grave.job(tx, ty);
/*     */   }
/*     */   
/*     */   void activate(GraveInstance i, int a, int tot) {
/* 191 */     this.avai += a;
/* 192 */     this.tot += tot;
/* 193 */     int res = (int)(respect(i) * tot);
/* 194 */     this.res += res;
/* 195 */     this.maxEmpl += i.employees().max();
/*     */   }
/*     */   
/*     */   void deactivate(GraveInstance i, int a, int tot) {
/* 199 */     this.avai -= a;
/* 200 */     this.tot -= tot;
/* 201 */     int res = (int)(respect(i) * tot);
/* 202 */     this.res -= res;
/* 203 */     this.maxEmpl -= i.employees().max();
/*     */   }
/*     */   
/*     */   void deactivate(GraveInstance i) {
/* 207 */     for (COORDINATE c : i.body()) {
/* 208 */       if (i.is(c)) {
/* 209 */         Grave g = this.grave.get(c.x(), c.y());
/* 210 */         if (g != null) {
/* 211 */           g.deactivate();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void dispose(GraveInstance i, int a, int tot) {
/* 218 */     this.dist += (tot - a);
/* 219 */     for (COORDINATE c : i.body()) {
/* 220 */       if (i.is(c)) {
/* 221 */         Grave g = this.grave.get(c.x(), c.y());
/* 222 */         if (g != null) {
/* 223 */           g.dispose();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public GraveDataClass get(HCLASS c) {
/* 230 */     return this.classes[c.index()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GraveData(RoomBlueprintIns<GraveInstance> p, RoomInitData init, int composeTime) {
/* 237 */     this.available = new INT_O<Room>()
/*     */       {
/* 239 */         private final INFO info = new INFO(GraveData.¤¤Available, GraveData.¤¤AvailableD);
/*     */ 
/*     */         
/*     */         public int min(Room r) {
/* 243 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Room r) {
/* 248 */           if (r == null)
/* 249 */             return GraveData.this.tot; 
/* 250 */           return ((GraveInstance)r).total();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(Room r) {
/* 255 */           if (r == null)
/* 256 */             return GraveData.this.avai; 
/* 257 */           return ((GraveInstance)r).available();
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/* 262 */           return this.info;
/*     */         }
/*     */       };
/*     */     
/* 266 */     this.total = new INT_O<Room>()
/*     */       {
/* 268 */         private final INFO info = new INFO(GraveData.¤¤Total, GraveData.¤¤TotalD);
/*     */ 
/*     */         
/*     */         public int min(Room r) {
/* 272 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Room r) {
/* 277 */           if (r == null)
/* 278 */             return GraveData.this.tot; 
/* 279 */           return ((GraveInstance)r).total();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(Room r) {
/* 284 */           if (r == null)
/* 285 */             return GraveData.this.tot; 
/* 286 */           return ((GraveInstance)r).total();
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/* 291 */           return this.info;
/*     */         }
/*     */       };
/*     */     
/* 295 */     this.respect = new DOUBLE_O<Room>()
/*     */       {
/* 297 */         private final INFO info = new INFO(GraveData.¤¤Respect, GraveData.¤¤RespectD);
/*     */ 
/*     */         
/*     */         public double getD(Room r) {
/* 301 */           if (r == null) {
/* 302 */             double re = 1.0D - GraveData.this.blueprint().degradeAverage();
/* 303 */             if (GraveData.this.tot > 0)
/* 304 */               re *= GraveData.this.res / GraveData.this.tot; 
/* 305 */             if (GraveData.this.maxEmpl > 0) {
/* 306 */               re *= GraveData.this.blueprint().employment().employed() / GraveData.this.maxEmpl;
/*     */             }
/*     */             
/* 309 */             return re;
/*     */           } 
/* 311 */           GraveInstance ins = (GraveInstance)r;
/* 312 */           double resp = GraveData.this.respect(ins);
/* 313 */           if (ins.active())
/* 314 */             resp *= ins.employees().employed() / ins.employees().max(); 
/* 315 */           resp *= 1.0D - ins.getDegrade();
/* 316 */           return resp;
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/* 321 */           return this.info;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 326 */     this.disturbance = new DOUBLE()
/*     */       {
/* 328 */         private final INFO info = new INFO(GraveData.¤¤Disturbance, GraveData.¤¤DisturbanceD);
/*     */ 
/*     */         
/*     */         public double getD() {
/* 332 */           double p = (STATS.POP()).POP.data(null).get(null);
/* 333 */           if (p == 0.0D)
/* 334 */             return ((GraveData.this.dist > 0.0D) ? true : false); 
/* 335 */           return CLAMP.d(100.0D * GraveData.this.dist / p, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/* 340 */           return this.info;
/*     */         }
/*     */       };
/*     */     this.p = p;
/*     */     this.standingDef = new StatStanding.StandingDef(init.data());
/*     */     this.grave = new Grave(p, this);
/*     */     for (HCLASS c : HCLASSES.ALL()) {
/*     */       this.classes[c.index()] = new GraveDataClass(c);
/*     */     }
/*     */     this.permission = new PERMISSION.Permission(p.info);
/*     */     this.composeTime = composeTime;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   
/*     */   public GRAVE_JOB requestAccessTile() {
/* 380 */     if (this.avai == 0 || this.p.instancesSize() == 0) {
/* 381 */       return null;
/*     */     }
/* 383 */     int i = RND.rInt(this.p.instancesSize());
/*     */     
/* 385 */     for (int k = 0; k < this.p.instancesSize(); k++) {
/*     */       
/* 387 */       int ii = (i + k) % this.p.instancesSize();
/* 388 */       GraveInstance ins = (GraveInstance)this.p.getInstance(ii);
/* 389 */       if (ins.active() && ins.available() > 0) {
/* 390 */         for (COORDINATE c : ins.body()) {
/* 391 */           if (ins.is(c)) {
/* 392 */             GRAVE_JOB g = this.grave.job(c.x(), c.y());
/* 393 */             if (g != null && g.jobReserveCanBe())
/*     */             {
/* 395 */               return g;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 400 */         GAME.Notify("nono");
/*     */       } 
/*     */     } 
/*     */     
/* 404 */     GAME.Notify("nonono");
/* 405 */     return null;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 425 */     double d = this.dist * disturbanceRemove;
/* 426 */     if (d < disturbanceRemove)
/* 427 */       d = disturbanceRemove; 
/* 428 */     this.dist -= d * ds;
/* 429 */     if (this.dist < 0.0D) {
/* 430 */       this.dist = 0.0D;
/*     */     }
/* 432 */     this.upD += ds;
/* 433 */     if (this.upD > TIME.secondsPerDay()) {
/* 434 */       this.upD -= TIME.secondsPerDay();
/* 435 */       for (HCLASS c : HCLASSES.ALL()) {
/* 436 */         this.classes[c.index()].update();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public StatStanding.StandingDef standingDef() {
/* 442 */     return this.standingDef;
/*     */   }
/*     */   
/*     */   public GraveInfo info(Room r, int i) {
/* 446 */     GraveInfo info = GraveInfo.get((GraveInstance)r, i);
/* 447 */     if (info.hasBody())
/* 448 */       return info; 
/* 449 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract double respect(GraveInstance paramGraveInstance);
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintIns<?> blueprint() {
/* 460 */     return this.p;
/*     */   }
/*     */   public static interface GRAVE_DATA_HOLDER {
/*     */     GraveData graveData(); }
/* 464 */   public final class GraveDataClass { private final double[] burr = new double[RACES.all().size()];
/* 465 */     private final double[] fails = new double[RACES.all().size()]; private final HCLASS cl;
/*     */     final SAVABLE saver;
/*     */     public DOUBLE_O<Race> burried;
/*     */     public DOUBLE_O<Race> failed;
/*     */     public DOUBLE_O<Race> value;
/*     */     
/*     */     GraveDataClass(HCLASS cl) {
/* 472 */       this.saver = new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/* 476 */             file.ds(GraveData.GraveDataClass.this.burr);
/* 477 */             file.ds(GraveData.GraveDataClass.this.fails);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/* 482 */             file.ds(GraveData.GraveDataClass.this.burr);
/* 483 */             file.ds(GraveData.GraveDataClass.this.fails);
/*     */           }
/*     */ 
/*     */           
/*     */           public void clear() {
/* 488 */             Arrays.fill(GraveData.GraveDataClass.this.burr, 0.0D);
/* 489 */             Arrays.fill(GraveData.GraveDataClass.this.fails, 0.0D);
/*     */           }
/*     */         };
/*     */       
/* 493 */       this.burried = new DOUBLE_O<Race>()
/*     */         {
/* 495 */           private final INFO info = new INFO(GraveData.¤¤Burried, GraveData.¤¤BurriedD);
/*     */ 
/*     */           
/*     */           public double getD(Race t) {
/* 499 */             if (t == null) {
/* 500 */               double m = 0.0D;
/* 501 */               for (Race r : RACES.all()) {
/* 502 */                 m += GraveData.GraveDataClass.this.burr[r.index];
/*     */               }
/* 504 */               if (m == 0.0D)
/* 505 */                 return 0.0D; 
/* 506 */               return m;
/*     */             } 
/* 508 */             return GraveData.GraveDataClass.this.burr[t.index];
/*     */           }
/*     */ 
/*     */           
/*     */           public INFO info() {
/* 513 */             return this.info;
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 518 */       this.failed = new DOUBLE_O<Race>()
/*     */         {
/* 520 */           private final INFO info = new INFO(GraveData.¤¤Corpses, GraveData.¤¤CorpsesD);
/*     */ 
/*     */           
/*     */           public double getD(Race t) {
/* 524 */             if (t == null) {
/* 525 */               double m = 0.0D;
/* 526 */               for (Race r : RACES.all()) {
/* 527 */                 m += GraveData.GraveDataClass.this.fails[r.index];
/*     */               }
/* 529 */               if (m == 0.0D)
/* 530 */                 return 0.0D; 
/* 531 */               return m;
/*     */             } 
/* 533 */             return GraveData.GraveDataClass.this.fails[t.index];
/*     */           }
/*     */ 
/*     */           
/*     */           public INFO info() {
/* 538 */             return this.info;
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 543 */       this.value = new DOUBLE_O<Race>()
/*     */         {
/* 545 */           private final INFO info = new INFO(GraveData.¤¤Value, GraveData.¤¤ValueD);
/*     */ 
/*     */           
/*     */           public double getD(Race t) {
/* 549 */             if (t == null) {
/* 550 */               double m = 0.0D;
/* 551 */               for (Race r : RACES.all()) {
/* 552 */                 m += GraveData.GraveDataClass.this.burr[r.index] * (STATS.POP()).POP.data(GraveData.GraveDataClass.this.cl).get(r);
/*     */               }
/* 554 */               if (m == 0.0D)
/* 555 */                 return 0.0D; 
/* 556 */               return m / (STATS.POP()).POP.data(GraveData.GraveDataClass.this.cl).get(null);
/*     */             } 
/*     */             
/* 559 */             double tot = GraveData.GraveDataClass.this.burr[t.index] + GraveData.GraveDataClass.this.fails[t.index];
/* 560 */             double res = 1.0D;
/* 561 */             if (tot != 0.0D)
/* 562 */               res = 1.0D - GraveData.GraveDataClass.this.fails[t.index] / tot; 
/* 563 */             res *= 1.0D - 0.5D * GraveData.GraveDataClass.access$0(GraveData.GraveDataClass.this).blueprint().degradeAverage();
/* 564 */             res *= 0.5D + 0.5D * (GraveData.GraveDataClass.access$0(GraveData.GraveDataClass.this)).respect.getD(null);
/*     */ 
/*     */             
/* 567 */             return CLAMP.d(res, 0.0D, 1.0D);
/*     */           }
/*     */ 
/*     */           
/*     */           public INFO info() {
/* 572 */             return this.info;
/*     */           }
/*     */         };
/*     */       this.cl = cl;
/*     */     }
/*     */     public void fail(ThingsCorpses.Corpse c, int delta) {
/* 578 */       this.fails[(c.indu().race()).index] = this.fails[(c.indu().race()).index] + delta;
/*     */     }
/*     */     
/*     */     void burry(ThingsCorpses.Corpse c) {
/* 582 */       this.burr[(c.indu().race()).index] = this.burr[(c.indu().race()).index] + 1.0D;
/*     */     }
/*     */     
/*     */     void update() {
/* 586 */       for (Race r : RACES.all()) {
/* 587 */         this.fails[r.index] = this.fails[r.index] - Math.max(this.fails[r.index] * 0.1D, 0.1D);
/* 588 */         if (this.fails[r.index] < 0.0D) {
/* 589 */           this.fails[r.index] = 0.0D;
/*     */         }
/* 591 */         this.burr[r.index] = this.burr[r.index] - Math.max(this.burr[r.index] * 0.1D, 0.1D);
/* 592 */         if (this.burr[r.index] < 0.0D)
/* 593 */           this.burr[r.index] = 0.0D; 
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\GraveData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */