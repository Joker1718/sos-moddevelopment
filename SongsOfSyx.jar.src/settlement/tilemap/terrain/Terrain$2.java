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
/*     */ class null
/*     */   implements MAP_INTE
/*     */ {
/*     */   public MAP_INTE set(int tile, int value) {
/* 108 */     if ((value & 0xFFFF0000) != 0)
/* 109 */       throw new RuntimeException(); 
/* 110 */     Terrain.this.datad[tile] = (short)value;
/*     */     
/* 112 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(int tile) {
/* 117 */     return Terrain.this.datad[tile] & 0xFFFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(int tx, int ty) {
/* 122 */     return get(tx + ty * SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tx, int ty, int value) {
/* 127 */     return set(tx + ty * SETT.TWIDTH, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\Terrain$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */