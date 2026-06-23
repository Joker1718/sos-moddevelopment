/*     */ package world.map.road;
/*     */ 
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends WTRAV.TravTile
/*     */ {
/*     */   null(String $anonymous0) {
/* 255 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPossible(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d, boolean roaded) {
/* 261 */     if (!isPossible(fromX, fromY, roaded))
/* 262 */       return false; 
/* 263 */     if (to == WTRAV.LAND) {
/* 264 */       if (!d.isOrtho())
/* 265 */         return false; 
/* 266 */       return WTRAV.LAND.isPossible(tx, ty, roaded);
/*     */     } 
/* 268 */     if (to == WTRAV.WATER || to == this)
/* 269 */       return true; 
/* 270 */     if (roaded && WORLD.ROADS().is(fromX, fromY)) {
/* 271 */       return (to == WTRAV.LAND);
/*     */     }
/* 273 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPossible(int tx, int ty, boolean roaded) {
/* 278 */     if ((WORLD.WATER()).isBig.is(tx, ty) && canBe(tx, ty)) {
/* 279 */       if (roaded)
/* 280 */         return WORLD.ROADS().is(tx, ty); 
/* 281 */       return true;
/*     */     } 
/* 283 */     return false;
/*     */   }
/*     */   
/*     */   private boolean canBe(int tx, int ty) {
/* 287 */     if (WORLD.MOUNTAIN().coversTile(tx, ty))
/* 288 */       return false; 
/* 289 */     if ((WORLD.WATER()).isBig.is(tx, ty)) {
/* 290 */       return !(!ok(tx, ty, DIR.N) && !ok(tx, ty, DIR.E));
/*     */     }
/* 292 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean ok(int tx, int ty, DIR d) {
/* 297 */     return ((WORLD.WATER()).isBig.is(tx, ty, d) && (WORLD.WATER()).isBig.is(tx, ty, d.perpendicular()) && (!(WORLD.WATER()).isBig.is(tx, ty, d.next(2)) || !(WORLD.WATER()).isBig.is(tx, ty, d.perpendicular().next(2))));
/*     */   }
/*     */ 
/*     */   
/*     */   public void road(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d) {
/* 302 */     if (to == WTRAV.LAND)
/* 303 */       WORLD.ROADS().set(fromX, fromY, true); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\WTRAV$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */