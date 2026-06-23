/*     */ package init.sprite.UI;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
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
/*     */ class null
/*     */   extends UIPanels.TitleBox
/*     */ {
/*     */   null(int $anonymous0) {
/*  88 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1, int width) {
/*  93 */     renderP(r, 0, x1 - this.height, y1);
/*  94 */     for (int w = 0; w + this.height < width; w++) {
/*  95 */       renderP(r, 1, x1 + w, y1);
/*     */     }
/*  97 */     renderP(r, 1, x1 + width - this.height, y1);
/*  98 */     renderP(r, 2, x1 + width, y1);
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderP(SPRITE_RENDERER r, int t, int x1, int y1) {
/* 103 */     ss.render(r, t * 2, x1, y1);
/* 104 */     ss.render(r, t * 2 + 1, x1 + 24, y1);
/* 105 */     ss.render(r, t * 2 + 6, x1, y1 + 24);
/* 106 */     ss.render(r, t * 2 + 7, x1 + 24, y1 + 24);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIPanels$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */