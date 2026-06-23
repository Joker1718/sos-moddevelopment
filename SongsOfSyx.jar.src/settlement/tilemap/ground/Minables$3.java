/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import init.resources.Minable;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
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
/*     */ class null
/*     */   implements MAP_OBJECTE<Minable>
/*     */ {
/*     */   public Minable get(int tile) {
/* 142 */     if (Minables.this.amount.get(tile) == 0)
/* 143 */       return null; 
/* 144 */     return (Minable)RESOURCES.minables().getAt(Minables.this.types.get(tile));
/*     */   }
/*     */ 
/*     */   
/*     */   public Minable get(int tx, int ty) {
/* 149 */     return get(tx + ty * SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int tile, Minable object) {
/* 154 */     Minable old = get(tile);
/*     */     
/* 156 */     if (object == null) {
/* 157 */       Minables.this.amount.set(tile, 0);
/*     */     } else {
/* 159 */       Minables.this.types.set(tile, object.index);
/* 160 */       Minables.this.amount.set(tile, 1);
/*     */     } 
/*     */     
/* 163 */     if (object != old) {
/* 164 */       SETT.TILE_MAP().miniCUpdate(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */     }
/*     */   }
/*     */   
/*     */   public void set(int tx, int ty, Minable object) {
/* 169 */     if (SETT.IN_BOUNDS(tx, ty))
/* 170 */       set(tx + ty * SETT.TWIDTH, object); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Minables$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */