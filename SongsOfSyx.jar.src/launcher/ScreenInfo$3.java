/*     */ package launcher;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileManager;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   Text t;
/*     */   
/*     */   null(Launcher paramLauncher) {
/* 124 */     this.t = (new Text(paramLauncher.res.font, "info@songsofsyx.com")).setScale(1.0D);
/*     */     
/* 126 */     this.body.setDim((DIMENSION)this.t);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 130 */     if (isHovered) {
/* 131 */       clinkH.bind();
/*     */     } else {
/* 133 */       clink.bind();
/* 134 */     }  this.t.render(r, (RECTANGLE)this.body);
/* 135 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 140 */     FileManager.sendEmail("info@songsofsyx.com", "Greetings, oh great dev", "Inquiry");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenInfo$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */