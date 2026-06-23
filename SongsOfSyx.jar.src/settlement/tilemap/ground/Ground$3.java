/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements MAP_DOUBLEE
/*     */ {
/*     */   public double get(int tx, int ty) {
/* 240 */     if (SETT.IN_BOUNDS(tx, ty))
/* 241 */       return get(tx + ty * SETT.TWIDTH); 
/* 242 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(int tile) {
/* 247 */     return Ground.this.mapMoistureCurrent.get(tile) * 0.06666666666666667D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 253 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/* 254 */       return this;
/*     */     }
/* 256 */     int v = CLAMP.i((int)Math.round(value * 15.0D), 0, 15);
/* 257 */     int tile = tx + ty * SETT.TWIDTH;
/* 258 */     int o = Ground.this.mapMoistureCurrent.get(tile);
/* 259 */     if (v != o) {
/* 260 */       Ground.this.mapMoistureCurrent.set(tile, v);
/* 261 */       Ground.this.update(tx, ty);
/* 262 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 263 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 264 */         if (SETT.IN_BOUNDS(tx, ty, d)) {
/* 265 */           Ground.this.update(tx + d.x(), ty + d.y());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 270 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_DOUBLEE set(int tile, double value) {
/* 275 */     return set(tile % SETT.TWIDTH, (tile / SETT.TWIDTH));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Ground$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */