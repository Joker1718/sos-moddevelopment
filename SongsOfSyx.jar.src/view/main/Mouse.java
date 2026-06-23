/*    */ package view.main;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ public final class Mouse implements COORDINATE {
/* 13 */   private final Coo coo = new Coo();
/*    */   private final SPRITE sprites;
/*    */   private boolean hidden = false;
/* 16 */   private SPRITE overlay = null;
/*    */   
/*    */   Mouse() {
/* 19 */     this.sprites = (UI.decor()).mouse;
/*    */   }
/*    */ 
/*    */   
/*    */   void render(Renderer r, float ds) {
/* 24 */     if (this.hidden) {
/* 25 */       this.hidden = false;
/*    */       
/*    */       return;
/*    */     } 
/* 29 */     if (this.overlay == null && CLICKABLE.ClickableAbs.clickableHovered) {
/* 30 */       (UI.decor()).mouseHov.render((SPRITE_RENDERER)r, this.coo.x(), this.coo.y());
/*    */     } else {
/* 32 */       this.sprites.render((SPRITE_RENDERER)r, this.coo.x(), this.coo.y());
/* 33 */     }  if (this.overlay != null) {
/* 34 */       this.overlay.render((SPRITE_RENDERER)r, this.coo.x() + 10, this.coo.y());
/*    */     }
/* 36 */     this.overlay = null;
/* 37 */     CLICKABLE.ClickableAbs.clickableHovered = false;
/*    */   }
/*    */   
/*    */   public void setReplacement(SPRITE o) {
/* 41 */     this.overlay = o;
/*    */   }
/*    */   
/*    */   public void hide(boolean hide) {
/* 45 */     this.hidden = hide;
/*    */   }
/*    */ 
/*    */   
/*    */   public int x() {
/* 50 */     return this.coo.x();
/*    */   }
/*    */ 
/*    */   
/*    */   public int y() {
/* 55 */     return this.coo.y();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isWithinRec(RECTANGLE shape) {
/* 60 */     return this.coo.isWithinRec(shape);
/*    */   }
/*    */   
/*    */   Coo getCoo() {
/* 64 */     return this.coo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\main\Mouse.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */