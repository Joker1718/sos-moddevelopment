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
/*     */ class null
/*     */   extends WTRAV.TravTile
/*     */ {
/*     */   null(String $anonymous0) {
/* 187 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public boolean isPossible(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d, boolean roaded) {
/* 191 */     if (!isPossible(fromX, fromY, roaded))
/* 192 */       return false; 
/* 193 */     if (to == WTRAV.LAND) {
/* 194 */       if (!WTRAV.LAND.isPossible(tx, ty, roaded))
/* 195 */         return false; 
/* 196 */       if (!d.isOrtho()) {
/* 197 */         if (isPossible(fromX, ty, false) && isPossible(tx, fromY, false)) {
/* 198 */           if (roaded)
/* 199 */             return !(!isPossible(fromX, ty, true) && !isPossible(tx, fromY, true)); 
/* 200 */           return true;
/*     */         } 
/* 202 */         return false;
/*     */       } 
/* 204 */       return true;
/* 205 */     }  if (to == WTRAV.HARBOUR) {
/* 206 */       return (d.isOrtho() && WTRAV.HARBOUR.isPossible(tx, ty, roaded));
/*     */     }
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPossible(int tx, int ty, boolean roaded) {
/* 213 */     if (!WORLD.IN_BOUNDS(tx, ty))
/* 214 */       return false; 
/* 215 */     if (WORLD.MOUNTAIN().coversTile(tx, ty))
/* 216 */       return false; 
/* 217 */     if ((WORLD.WATER()).isBig.is(tx, ty)) {
/* 218 */       return false;
/*     */     }
/* 220 */     if (roaded && (!WORLD.ROADS().is(tx, ty) || (WORLD.ROADS()).minified.is(tx, ty)))
/* 221 */       return false; 
/* 222 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int extraCost(WTRAV.TravTile to) {
/* 227 */     if (to == WTRAV.HARBOUR)
/* 228 */       return 10; 
/* 229 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void road(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d) {
/* 234 */     if (to == WTRAV.LAND || to == WTRAV.HARBOUR) {
/* 235 */       WORLD.ROADS().set(fromX, fromY, true);
/* 236 */       WORLD.ROADS().set(tx, ty, true);
/* 237 */       if (!d.isOrtho()) {
/* 238 */         if (isPossible(tx, fromY, true))
/*     */           return; 
/* 240 */         if (isPossible(fromX, ty, true)) {
/*     */           return;
/*     */         }
/* 243 */         if (isPossible(tx, fromY, false) && (WORLD.REGIONS()).map.get(tx, fromY) == (WORLD.REGIONS()).map.get(fromX, fromY)) {
/* 244 */           WORLD.ROADS().set(tx, fromY, true);
/* 245 */         } else if (isPossible(fromX, ty, false)) {
/* 246 */           WORLD.ROADS().set(fromX, ty, true);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\WTRAV$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */