/*     */ package settlement.room.main;
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
/*     */ class null
/*     */   implements MAP_INTE
/*     */ {
/*     */   public int get(int tx, int ty) {
/*  88 */     if (SETT.IN_BOUNDS(tx, ty))
/*  89 */       return get(tx + ty * SETT.TWIDTH); 
/*  90 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(int tile) {
/*  95 */     return MapDataF.this.itemI[tile] & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tx, int ty, int value) {
/* 100 */     if (SETT.IN_BOUNDS(tx, ty)) {
/* 101 */       return set(tx + ty * SETT.TWIDTH, value);
/*     */     }
/* 103 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_INTE set(int tile, int value) {
/* 108 */     MapDataF.this.itemI[tile] = (byte)value;
/* 109 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\MapDataF$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */