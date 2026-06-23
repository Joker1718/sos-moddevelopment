/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 154 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public int get(int tile) {
/* 158 */     if (SETT.TERRAIN().get(tile) == TFlower.this) {
/* 159 */       return 1 + (TFlower.this.shared.data.get(tile) & 0xF);
/*     */     }
/* 161 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tile, int value) {
/* 167 */     if (value == 0) {
/* 168 */       if (SETT.TERRAIN().get(tile) == TFlower.this)
/* 169 */         (SETT.TERRAIN()).NADA.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/*     */     } else {
/* 171 */       if (SETT.TERRAIN().get(tile) != TFlower.this)
/* 172 */         TFlower.this.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/* 173 */       TFlower.this.shared.data.set(tile, value - 1);
/*     */     } 
/* 175 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFlower$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */