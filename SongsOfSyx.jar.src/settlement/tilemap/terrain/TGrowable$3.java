/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements MAP_BOOLEANE
/*     */ {
/*     */   public boolean is(int tx, int ty) {
/* 119 */     return is(tx + ty * SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 124 */     return (SETT.TERRAIN().get(tile) instanceof TGrowable && TGrowable.doJob.is(TGrowable.this.shared.data.get(tile)));
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 129 */     return set(tx + ty * SETT.TWIDTH, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_BOOLEANE set(int tile, boolean value) {
/* 134 */     TGrowable.this.shared.data.set(tile, TGrowable.doJob.set(TGrowable.this.shared.data.get(tile), value));
/* 135 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TGrowable$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */