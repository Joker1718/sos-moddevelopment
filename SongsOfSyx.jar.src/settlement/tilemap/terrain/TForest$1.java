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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 127 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(int tile) {
/* 133 */     if (TForest.this.isTree(tile)) {
/* 134 */       return CLAMP.i(1 + ((SETT.TERRAIN()).data.get(tile) >> 8 & 0x7), 0, 4);
/*     */     }
/* 136 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tile, int value) {
/* 142 */     if (value <= 0) {
/* 143 */       if (TForest.this.isTree(tile)) {
/* 144 */         (SETT.TERRAIN()).NADA.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */       }
/*     */     } else {
/* 147 */       if (!TForest.this.isTree(tile)) {
/* 148 */         TForest.this.SMALL.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */       }
/*     */       
/* 151 */       value = CLAMP.i(value - 1, 0, 3);
/* 152 */       int d = (SETT.TERRAIN()).data.get(tile);
/*     */       
/* 154 */       d &= 0xFF;
/* 155 */       d |= value << 8;
/*     */       
/* 157 */       (SETT.TERRAIN()).data.set(tile, d);
/*     */     } 
/* 159 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TForest$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */