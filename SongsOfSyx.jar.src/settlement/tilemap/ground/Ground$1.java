/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_OBJECTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements MAP_OBJECTE<GroundType>
/*     */ {
/*     */   public GroundType get(int tile) {
/* 156 */     return Ground.this.types.ALL[Ground.this.mapTypes.get(tile)];
/*     */   }
/*     */ 
/*     */   
/*     */   public GroundType get(int tx, int ty) {
/* 161 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 162 */       return Ground.this.types.NORMAL; 
/* 163 */     return Ground.this.types.ALL[Ground.this.mapTypes.get(tx + ty * SETT.TWIDTH)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int tile, GroundType object) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int x, int y, GroundType object) {
/* 173 */     if (!SETT.IN_BOUNDS(x, y))
/*     */       return; 
/* 175 */     GroundType old = get(x, y);
/* 176 */     Ground.this.mapTypes.set(x + y * SETT.TWIDTH, object.index);
/* 177 */     if (old != object) {
/* 178 */       Ground.this.update(x, y);
/* 179 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 180 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 181 */         if (SETT.IN_BOUNDS(x, y, d))
/* 182 */           Ground.this.update(x + d.x(), y + d.y()); 
/*     */       } 
/* 184 */       SETT.TILE_MAP().miniCUpdate(x, y);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Ground$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */