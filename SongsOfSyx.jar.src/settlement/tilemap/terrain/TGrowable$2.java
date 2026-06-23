/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends TAmount
/*     */ {
/*     */   null(int $anonymous0, CharSequence $anonymous1) {
/*  89 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public int get(int tile) {
/*  93 */     if (SETT.TERRAIN().get(tile) == TGrowable.this) {
/*  94 */       return CLAMP.i(1 + TGrowable.bsize.get(TGrowable.this.shared.data.get(tile)), 1, this.max);
/*     */     }
/*  96 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tile, int value) {
/* 101 */     if (value <= 0) {
/* 102 */       if (SETT.TERRAIN().get(tile) == TGrowable.this)
/* 103 */         (SETT.TERRAIN()).NADA.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/*     */     } else {
/* 105 */       if (SETT.TERRAIN().get(tile) != TGrowable.this)
/* 106 */         TGrowable.this.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/* 107 */       int d = TGrowable.this.shared.data.get(tile);
/* 108 */       d = TGrowable.bsize.set(d, CLAMP.i(value - 1, 0, TGrowable.bsize.mask));
/* 109 */       TGrowable.this.shared.data.set(tile, d);
/*     */     } 
/* 111 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TGrowable$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */