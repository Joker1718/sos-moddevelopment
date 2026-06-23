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
/*     */ class null
/*     */   extends TGrowth.Grower
/*     */ {
/*     */   null(LISTE<TGrowth.Grower> $anonymous0) {
/* 125 */     super($anonymous0);
/*     */   }
/*     */   public void setRoots(int tx, int ty, double am) {
/* 128 */     if (am <= 0.0D) {
/* 129 */       (SETT.TERRAIN()).NADA.placeRaw(tx, ty);
/*     */     } else {
/* 131 */       (SETT.TERRAIN()).FLOWER.placeRaw(tx, ty);
/* 132 */       (SETT.TERRAIN()).FLOWER.amount.set(tx, ty, 1 + (int)(am * ((SETT.TERRAIN()).FLOWER.amount.max - 1)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double currentAmount(int tx, int ty) {
/* 139 */     return (SETT.TERRAIN()).FLOWER.amount.DM.get(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   void grow(int tx, int ty, double max) {
/* 144 */     double d = (SETT.TERRAIN()).FLOWER.amount.DM.get(tx, ty);
/* 145 */     if (max < d) {
/* 146 */       if ((SETT.TERRAIN()).FLOWER.is(tx, ty)) {
/* 147 */         (SETT.TERRAIN()).FLOWER.amount.increment(tx, ty, -1);
/*     */       }
/* 149 */     } else if (max > d) {
/* 150 */       if ((SETT.TERRAIN()).NADA.is(tx, ty)) {
/* 151 */         if (RND.oneIn(12)) {
/* 152 */           (SETT.TERRAIN()).FLOWER.amount.increment(tx, ty, 1);
/*     */         }
/* 154 */       } else if (SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared()) {
/* 155 */         (SETT.TERRAIN()).FLOWER.amount.increment(tx, ty, 1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\TGrowth$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */