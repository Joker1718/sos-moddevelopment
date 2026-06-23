/*     */ package settlement.environment;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TileRayTracer;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.RECTANGLE;
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
/*     */ class Degrade
/*     */   extends SettEnvMap.Updatable
/*     */ {
/* 234 */   private final Bitmap2D has = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*     */   
/*     */   Degrade(LISTE<SettEnvMap.Updatable> all) {
/* 237 */     super(all);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getBaseValue(int tx, int ty) {
/* 242 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 243 */     if (r != null && r.blueprint() instanceof settlement.room.infra.monument.ROOM_MONUMENT) {
/* 244 */       return (r.degrader(tx, ty).isRealDegraded() ? true : false);
/*     */     }
/* 246 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(RECTANGLE bounds, RECTANGLE area) {
/* 251 */     for (COORDINATE c : area) {
/* 252 */       if (SETT.IN_BOUNDS(c)) {
/* 253 */         this.has.set(c, false);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 258 */     for (COORDINATE c : bounds) {
/* 259 */       int tx = c.x();
/* 260 */       int ty = c.y();
/* 261 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 262 */       if (r != null && r.blueprint() instanceof settlement.room.infra.monument.ROOM_MONUMENT && 
/* 263 */         r.degrader(tx, ty).isRealDegraded()) {
/* 264 */         trace(tx, ty, area);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void trace(int sourceX, int sourceY, RECTANGLE area) {
/* 275 */     EUpdater.traces.checkInit();
/*     */     
/* 277 */     for (TileRayTracer.Ray r : EUpdater.rays(sourceX, sourceY, area)) {
/* 278 */       for (int i = 0; i < r.size(); i++) {
/* 279 */         COORDINATE d = r.get(i);
/* 280 */         int dx = d.x() + sourceX;
/* 281 */         int dy = d.y() + sourceY;
/*     */         
/* 283 */         if (SettEnvMonument.isBlocked(dx, dy)) {
/*     */           break;
/*     */         }
/* 286 */         if (area.holdsPoint(dx, dy) && !SettEnvMonument.isBlocked(dx, dy)) {
/* 287 */           this.has.set(dx, dy, true);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean has(int tx, int ty) {
/* 298 */     return this.has.is(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 303 */     this.has.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvMonument$Degrade.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */