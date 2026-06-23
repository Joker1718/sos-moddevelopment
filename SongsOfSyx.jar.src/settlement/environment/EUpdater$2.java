/*     */ package settlement.environment;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.GUTIL;
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
/*     */ class null
/*     */   extends EUpdater
/*     */ {
/*     */   public void update(SettEnvMap.SettEnv s, RECTANGLE bounds, RECTANGLE area) {
/* 265 */     for (COORDINATE c : area) {
/* 266 */       s.map.set(c.x() + c.y() * SETT.TWIDTH, 0);
/*     */     }
/* 268 */     GUTIL.flooder().init(this);
/* 269 */     flood2(GUTIL.flooder(), bounds, area, s);
/* 270 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void flood2(PathUtilOnline.Flooder f, RECTANGLE bounds, RECTANGLE area, SettEnvMap.SettEnv thing) {
/* 276 */     double r = 1.0D / thing.radius();
/*     */     
/* 278 */     for (COORDINATE c : bounds) {
/* 279 */       double b = thing.getBaseValue(c.x(), c.y()) * 16.0D;
/* 280 */       if (b > 0.0D) {
/* 281 */         f.pushGreater(c, b);
/*     */       }
/*     */     } 
/*     */     
/* 285 */     while (f.hasMore()) {
/* 286 */       PathTile t = f.pollGreatest();
/* 287 */       double value = t.getValue();
/*     */       
/* 289 */       for (DIR d : DIR.ALL) {
/* 290 */         int tx = t.x() + d.x();
/* 291 */         int ty = t.y() + d.y();
/* 292 */         if (bounds.holdsPoint(tx, ty)) {
/* 293 */           double v = value - d.tileDistance() * thing.getCost(tx, ty) * r;
/* 294 */           if (v > 0.0D) {
/* 295 */             f.pushGreater(tx, ty, v);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 301 */     for (COORDINATE c : area) {
/* 302 */       if (f.hasBeenPushed(c.x(), c.y())) {
/* 303 */         int v = (int)Math.ceil((thing.max * f.getValue(c)) * 0.0625D);
/* 304 */         v = CLAMP.i(v, 0, thing.max);
/* 305 */         thing.map.set(c.x() + c.y() * SETT.TWIDTH, v);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraView(RECTANGLE area, PathUtilOnline.Flooder f, SettEnvMap.SettEnv thing, double value, double radius, int tx, int ty, int approvedDirs) {
/* 313 */     double b = value;
/* 314 */     double dr = 0.0625D / radius * b;
/*     */     
/* 316 */     if (b > 0.0D) {
/* 317 */       GUTIL.flooder().pushSloppy(tx, ty, b);
/* 318 */       GUTIL.flooder().setValue2(tx, ty, dr);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 324 */     while (f.hasMore()) {
/* 325 */       PathTile t = f.pollGreatest();
/* 326 */       dr = t.getValue2();
/* 327 */       value = t.getValue();
/*     */       
/* 329 */       for (DIR d : DIR.ALL) {
/* 330 */         tx = t.x() + d.x();
/* 331 */         ty = t.y() + d.y();
/* 332 */         double v = value - dr * d.tileDistance() * thing.getCost(tx, ty);
/* 333 */         if (v > 0.0D && 
/* 334 */           f.pushGreater(tx, ty, v) != null) {
/* 335 */           f.setValue2(tx, ty, dr);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getExtraValue(SettEnvMap.SettEnv s, double g, int tx, int ty) {
/* 346 */     g = Math.max(g, GUTIL.flooder().getValue(tx, ty));
/* 347 */     return g;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\EUpdater$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */