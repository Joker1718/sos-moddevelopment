/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends SPRITE.Imp
/*     */ {
/*     */   null(int $anonymous0) {
/* 119 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 123 */     COLOR.WHITE200.bind();
/* 124 */     rr(r, X1 - 1, X2 - 1, Y1 - 1, Y2 - 1);
/* 125 */     COLOR.unbind();
/* 126 */     rr(r, X1, X2, Y1, Y2);
/*     */   }
/*     */   
/*     */   private void rr(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 130 */     int c = 16 * (X2 - X1) / 32;
/*     */     
/* 132 */     mountain_ceiling.render(r, DIR.SE.mask(), X1, X1 + c, Y1, Y1 + c);
/* 133 */     mountain_ceiling.render(r, DIR.SW.mask(), X1 + c, X1 + c * 2, Y1, Y1 + c);
/* 134 */     mountain_ceiling.render(r, DIR.NE.mask(), X1, X1 + c, Y1 + c, Y1 + c * 2);
/* 135 */     mountain_ceiling.render(r, DIR.NW.mask(), X1 + c, X1 + c * 2, Y1 + c, Y1 + c * 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMountain$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */