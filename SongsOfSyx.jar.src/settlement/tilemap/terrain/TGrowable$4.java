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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 143 */     return CLAMP.i(TGrowable.bfruit.get(TGrowable.this.shared.data.get(tx, ty)), 0, TGrowable.this.size.get(tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(int tile) {
/* 148 */     return CLAMP.i(TGrowable.bfruit.get(TGrowable.this.shared.data.get(tile)), 0, TGrowable.this.size.get(tile));
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tx, int ty, int value) {
/* 153 */     return set(tx + ty * SETT.TWIDTH, value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tile, int value) {
/* 159 */     value = CLAMP.i(value, 0, 15);
/*     */     
/* 161 */     int data = TGrowable.this.shared.data.get(tile);
/*     */     
/* 163 */     if (!TGrowable.this.is(tile)) {
/* 164 */       TGrowable.this.size.set(tile, value);
/* 165 */       TGrowable.this.shared.data.set(tile, TGrowable.bfruit.set(data, value));
/* 166 */       return this;
/*     */     } 
/*     */     
/* 169 */     value = CLAMP.i(value, 0, TGrowable.this.size.get(tile));
/* 170 */     int old = TGrowable.bfruit.get(data);
/* 171 */     TGrowable.this.shared.data.set(tile, TGrowable.bfruit.set(data, value));
/* 172 */     if (old == 0 && value > 0 && TGrowable.doJob.is(data) && (SETT.JOBS()).getter.get(tile) == null) {
/* 173 */       boolean b = (SETT.JOBS()).planMode.is();
/* 174 */       (SETT.JOBS()).planMode.set(false);
/* 175 */       (SETT.JOBS()).clearss.food.placer().place(tile % SETT.TWIDTH, tile / SETT.TWIDTH, null, null);
/* 176 */       (SETT.JOBS()).planMode.set(b);
/*     */     } 
/* 178 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TGrowable$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */