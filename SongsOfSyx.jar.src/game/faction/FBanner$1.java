/*     */ package game.faction;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements SPRITE
/*     */ {
/*     */   public int width() {
/* 139 */     return 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 144 */     return 24;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int nopeX, int Y1, int nopeY) {
/* 155 */     (SPRITES.icons()).m.circle_frame.render(r, X1, Y1);
/* 156 */     FBanner.this.background.bind();
/* 157 */     (SPRITES.icons()).m.circle_inner.render(r, X1, Y1);
/*     */     
/* 159 */     int sx = X1 + (width() - 12) / 2;
/* 160 */     int sy = Y1 + (height() - 12) / 2;
/*     */     
/* 162 */     for (int y = 0; y < 12; y++) {
/* 163 */       for (int x = 0; x < 12; x++) {
/* 164 */         if (FBanner.this.sprite.is(x, y)) {
/* 165 */           FBanner.this.foreground.render(r, sx + x, sx + x + 1, sy + y, sy + y + 1);
/* 166 */         } else if (FBanner.this.sprite.is(x, y, DIR.N) || FBanner.this.sprite.is(x, y, DIR.E)) {
/* 167 */           FBanner.this.border.render(r, sx + x, sx + x + 1, sy + y, sy + y + 1);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FBanner$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */