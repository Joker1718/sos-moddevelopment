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
/*     */ class null
/*     */   extends TGrowth.Grower
/*     */ {
/*     */   null(LISTE<TGrowth.Grower> $anonymous0) {
/*  77 */     super($anonymous0);
/*     */   }
/*     */   public void setRoots(int tx, int ty, double am) {
/*  80 */     if (am > 0.2D) {
/*  81 */       (SETT.TERRAIN()).TREES.SMALL.placeRaw(tx, ty);
/*  82 */       (SETT.TERRAIN()).TREES.amount.DM.set(tx, ty, am);
/*     */     }
/*  84 */     else if (am > 0.0D) {
/*  85 */       (SETT.TERRAIN()).BUSH.placeFixed(tx, ty);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double currentAmount(int tx, int ty) {
/*  92 */     return 0.8D + RND.rFloat() * 0.2D;
/*     */   }
/*     */ 
/*     */   
/*     */   void grow(int tx, int ty, double max) {
/*  97 */     if (max <= 0.0D) {
/*  98 */       if ((SETT.TERRAIN()).TREES.isTree(tx, ty)) {
/*  99 */         (SETT.TERRAIN()).TREES.amount.increment(tx, ty, -1);
/* 100 */         if ((SETT.TERRAIN()).NADA.is(tx, ty)) {
/* 101 */           (SETT.TERRAIN()).BUSH.placeFixed(tx, ty);
/*     */         }
/* 103 */       } else if ((SETT.TERRAIN()).BUSH.is(tx, ty) && RND.oneIn(4)) {
/* 104 */         if (RND.oneIn(8)) {
/* 105 */           (SETT.TERRAIN()).DECOR_WOOD.placeFixed(tx, ty);
/*     */         } else {
/* 107 */           (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/*     */         } 
/*     */       } 
/* 110 */     } else if ((SETT.TERRAIN()).TREES.isTree(tx, ty)) {
/* 111 */       if (RND.oneIn(16))
/* 112 */         (SETT.TERRAIN()).TREES.amount.increment(tx, ty, 1); 
/* 113 */     } else if ((SETT.TERRAIN()).BUSH.is(tx, ty)) {
/* 114 */       if (max > 0.2D && RND.oneIn(48)) {
/* 115 */         (SETT.TERRAIN()).TREES.SMALL.placeFixed(tx, ty);
/* 116 */         (SETT.TERRAIN()).TREES.amount.set(tx, ty, 1);
/*     */       } 
/* 118 */     } else if (SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared()) {
/* 119 */       (SETT.TERRAIN()).BUSH.placeFixed(tx, ty);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\TGrowth$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */