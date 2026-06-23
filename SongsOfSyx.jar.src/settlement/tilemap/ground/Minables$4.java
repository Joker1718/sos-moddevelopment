/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import init.resources.Minable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements MAP_INTE
/*     */ {
/*     */   public int get(int tx, int ty) {
/* 179 */     if (SETT.IN_BOUNDS(tx, ty))
/* 180 */       return get(tx + ty * SETT.TWIDTH); 
/* 181 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(int tile) {
/* 186 */     return Minables.this.amount.get(tile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tx, int ty, int value) {
/* 193 */     if (SETT.IN_BOUNDS(tx, ty)) {
/* 194 */       set(tx + ty * SETT.TWIDTH, value);
/*     */     }
/*     */ 
/*     */     
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tile, int value) {
/* 203 */     Minable old = (Minable)Minables.this.getter.get(tile);
/* 204 */     if (value < 0)
/* 205 */       value = 0; 
/* 206 */     if (value > Minables.this.amount.maxValue()) {
/* 207 */       value = Minables.this.amount.maxValue();
/*     */     }
/* 209 */     Minables.this.amount.set(tile, value);
/* 210 */     if (Minables.this.getter.get(tile) != old)
/* 211 */       SETT.TILE_MAP().miniCUpdate(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/* 212 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Minables$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */