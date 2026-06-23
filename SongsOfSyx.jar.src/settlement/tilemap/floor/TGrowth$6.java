/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ class null
/*     */   extends TGrowth.Grower
/*     */ {
/*     */   null(LISTE<TGrowth.Grower> $anonymous0) {
/* 161 */     super($anonymous0);
/*     */   }
/*     */   public void setRoots(int tx, int ty, double am) {
/* 164 */     if (am > 0.0D) {
/* 165 */       (SETT.TERRAIN()).BUSH.placeRaw(tx, ty);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double currentAmount(int tx, int ty) {
/* 171 */     return 0.8D + RND.rFloat() * 0.2D;
/*     */   }
/*     */ 
/*     */   
/*     */   void grow(int tx, int ty, double max) {
/* 176 */     if (max < 0.0D && (SETT.TERRAIN()).BUSH.is(tx, ty) && RND.oneIn(4)) {
/* 177 */       (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/* 178 */     } else if (max > 0.0D && SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared() && RND.oneIn(8)) {
/* 179 */       (SETT.TERRAIN()).BUSH.placeFixed(tx, ty);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\TGrowth$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */