/*     */ package settlement.environment;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TileRayTracer;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LISTE;
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
/*     */ public class SettEnvMonument
/*     */ {
/*     */   private final All all;
/*     */   private final Degrade degrade;
/*     */   public MAP_BOOLEAN DEGRADE;
/*     */   private final Bitmap2D extra;
/*     */   
/*     */   private static boolean isBlocked(int tx, int ty) {
/*     */     if ((SETT.ROOMS()).map.blueprint.get(tx, ty) instanceof ROOM_MONUMENT)
/*     */       return false; 
/*     */     return SETT.LIGHTS().los().get(tx, ty).blocksEnv(tx, ty);
/*     */   }
/*     */   
/*     */   SettEnvMonument(LISTE<SettEnvMap.Updatable> all) {
/*  50 */     this.extra = new Bitmap2D((DIMENSION)new Rec(42.0D, 42.0D), false);
/*     */     this.all = new All(all);
/*     */     this.degrade = new Degrade(all);
/*  53 */     this.DEGRADE = (MAP_BOOLEAN)this.degrade.has; } public void addExtra(ROOM_MONUMENT m, FurnisherItem it, int x1, int y1) { this.extra.clear();
/*     */ 
/*     */     
/*  56 */     EUpdater.traces.checkInit();
/*     */     
/*  58 */     int ssx = x1 + it.width() / 2;
/*  59 */     int ssy = y1 + it.height() / 2; byte b; int i;
/*     */     TileRayTracer.Ray[] arrayOfRay;
/*  61 */     for (i = (arrayOfRay = EUpdater.traces.rays()).length, b = 0; b < i; ) { TileRayTracer.Ray r = arrayOfRay[b];
/*  62 */       for (int j = 0; j < r.size(); j++) {
/*  63 */         COORDINATE d = r.get(j);
/*  64 */         int sourceX = ssx;
/*  65 */         int sourceY = ssy;
/*  66 */         if ((it.width() & 0x1) == 0 && d.x() > 0)
/*  67 */           sourceX--; 
/*  68 */         if ((it.height() & 0x1) == 0 && d.y() > 0)
/*  69 */           sourceY--; 
/*  70 */         int dx = d.x() + sourceX;
/*  71 */         int dy = d.y() + sourceY;
/*     */         
/*  73 */         if (!SETT.IN_BOUNDS(dx, dy)) {
/*     */           break;
/*     */         }
/*  76 */         double rad = r.radius(j);
/*     */         
/*  78 */         if (rad >= m.radius(it)) {
/*     */           break;
/*     */         }
/*  81 */         if (EUpdater.traces.check(d))
/*     */         {
/*  83 */           this.extra.set(d.x() + sourceX - x1 + 16, d.y() + sourceY - y1 + 16, true);
/*     */         }
/*  85 */         if (isBlocked(dx, dy))
/*     */           break; 
/*     */       } 
/*     */       b++; }
/*     */      }
/*     */   
/*     */   public void changeUpgrade(int tx, int ty) {
/*     */     (SETT.ENV()).map.setChanged(tx, ty, this.all);
/*     */   }
/*     */   public void changeDegrade(int tx, int ty) {
/*     */     (SETT.ENV()).map.setChanged(tx, ty, this.degrade);
/*     */   }
/*     */   public int extra(int x1, int y1, int tx, int ty) {
/*  98 */     int ex = tx - x1 + 16;
/*  99 */     int ey = ty - y1 + 16;
/* 100 */     return this.extra.is(ex, ey) ? 1 : 0;
/*     */   }
/*     */   
/*     */   private class All
/*     */     extends SettEnvMap.Updatable {
/* 105 */     private final Bitmap2D has = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*     */     
/*     */     All(LISTE<SettEnvMap.Updatable> all) {
/* 108 */       super(all);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void update(RECTANGLE bounds, RECTANGLE area) {
/* 114 */       for (COORDINATE c : area) {
/* 115 */         if (SETT.IN_BOUNDS(c)) {
/* 116 */           this.has.set(c, false);
/* 117 */           for (ROOM_MONUMENT m : (SETT.ROOMS()).MONUMENTS.all) {
/* 118 */             m.mapData.set(c, 0);
/* 119 */             m.mapUpgrade.set(c, m.mapUpgrade.max());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 125 */       for (COORDINATE c : bounds) {
/* 126 */         trace2(c, area);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void trace2(COORDINATE source, RECTANGLE area) {
/* 138 */       Room ro = (Room)(SETT.ROOMS()).map.get(source);
/*     */       
/* 140 */       if (ro == null) {
/*     */         return;
/*     */       }
/* 143 */       if (!(ro.blueprint() instanceof ROOM_MONUMENT)) {
/*     */         return;
/*     */       }
/* 146 */       if (!isCentre(ro, source.x(), source.y(), source.x(), source.y())) {
/*     */         return;
/*     */       }
/*     */       
/* 150 */       ROOM_MONUMENT m = (ROOM_MONUMENT)ro.blueprint();
/*     */       
/* 152 */       int ra = (int)m.radius((FurnisherItem)(SETT.ROOMS()).fData.item.get(source.x(), source.y()));
/* 153 */       if (ra == 0)
/*     */         return; 
/* 155 */       if (!area.holdsPoint(source)) {
/* 156 */         if (Math.abs(area.cX() - source.x()) - ra > 8)
/*     */           return; 
/* 158 */         if (Math.abs(area.cY() - source.y()) - ra > 8) {
/*     */           return;
/*     */         }
/*     */       } 
/* 162 */       int up = ro.upgrade(source.x(), source.y());
/*     */       
/* 164 */       EUpdater.traces.checkInit();
/*     */       
/* 166 */       for (TileRayTracer.Ray r : EUpdater.rays(source.x(), source.y(), area)) {
/* 167 */         for (int i = 0; i < r.size() && 
/* 168 */           r.radius(i) < ra; i++) {
/*     */           
/* 170 */           COORDINATE d = r.get(i);
/*     */           
/* 172 */           int dx = d.x() + source.x();
/* 173 */           int dy = d.y() + source.y();
/* 174 */           if (area.holdsPoint(dx, dy) && EUpdater.traces.check(d)) {
/*     */             
/* 176 */             if (m.mapUpgrade.get(dx, dy) > up) {
/* 177 */               m.mapUpgrade.set(dx, dy, up);
/*     */             }
/* 179 */             if (m.mapData.get(dx, dy) < m.maxEnv())
/* 180 */               m.mapData.increment(dx, dy, 1); 
/* 181 */             this.has.set(dx, dy, true);
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 188 */           if (SettEnvMonument.isBlocked(dx, dy)) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean isCentre(Room ro, int dx, int dy, int sourceX, int sourceY) {
/* 197 */       int w = ro.width(dx, dy);
/* 198 */       int h = ro.height(dx, dy);
/* 199 */       int x1 = ro.x1(dx, dy);
/* 200 */       int y1 = ro.y1(dx, dy);
/* 201 */       int cx = x1 + w / 2;
/* 202 */       int cy = y1 + h / 2;
/*     */       
/* 204 */       if ((w & 0x1) == 0 && sourceX > cx)
/* 205 */         cx--; 
/* 206 */       if ((h & 0x1) == 0 && sourceY > cy)
/* 207 */         cy--; 
/* 208 */       return (dx == cx && dy == cy);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getBaseValue(int tx, int ty) {
/* 213 */       return (((SETT.ROOMS()).map.blueprintImp.get(tx, ty) instanceof ROOM_MONUMENT) ? true : false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean has(int tx, int ty) {
/* 218 */       return this.has.is(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clear() {
/* 223 */       for (ROOM_MONUMENT m : (SETT.ROOMS()).MONUMENTS.all) {
/* 224 */         m.mapData.clear();
/* 225 */         m.mapUpgrade.clear();
/*     */       } 
/* 227 */       this.has.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   private class Degrade
/*     */     extends SettEnvMap.Updatable
/*     */   {
/* 234 */     private final Bitmap2D has = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*     */     
/*     */     Degrade(LISTE<SettEnvMap.Updatable> all) {
/* 237 */       super(all);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getBaseValue(int tx, int ty) {
/* 242 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 243 */       if (r != null && r.blueprint() instanceof ROOM_MONUMENT) {
/* 244 */         return (r.degrader(tx, ty).isRealDegraded() ? true : false);
/*     */       }
/* 246 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void update(RECTANGLE bounds, RECTANGLE area) {
/* 251 */       for (COORDINATE c : area) {
/* 252 */         if (SETT.IN_BOUNDS(c)) {
/* 253 */           this.has.set(c, false);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 258 */       for (COORDINATE c : bounds) {
/* 259 */         int tx = c.x();
/* 260 */         int ty = c.y();
/* 261 */         Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 262 */         if (r != null && r.blueprint() instanceof ROOM_MONUMENT && 
/* 263 */           r.degrader(tx, ty).isRealDegraded()) {
/* 264 */           trace(tx, ty, area);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void trace(int sourceX, int sourceY, RECTANGLE area) {
/* 275 */       EUpdater.traces.checkInit();
/*     */       
/* 277 */       for (TileRayTracer.Ray r : EUpdater.rays(sourceX, sourceY, area)) {
/* 278 */         for (int i = 0; i < r.size(); i++) {
/* 279 */           COORDINATE d = r.get(i);
/* 280 */           int dx = d.x() + sourceX;
/* 281 */           int dy = d.y() + sourceY;
/*     */           
/* 283 */           if (SettEnvMonument.isBlocked(dx, dy)) {
/*     */             break;
/*     */           }
/* 286 */           if (area.holdsPoint(dx, dy) && !SettEnvMonument.isBlocked(dx, dy)) {
/* 287 */             this.has.set(dx, dy, true);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean has(int tx, int ty) {
/* 298 */       return this.has.is(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clear() {
/* 303 */       this.has.clear();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvMonument.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */