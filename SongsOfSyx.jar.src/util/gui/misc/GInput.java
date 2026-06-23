/*    */ package util.gui.misc;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.Mouse;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import snake2d.util.sprite.text.StringInputSprite;
/*    */ import util.colors.GCOLOR;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public class GInput extends CLICKABLE.ClickableAbs {
/*    */   private final StringInputSprite input;
/*    */   private boolean dragging = false;
/*    */   
/*    */   public GInput(StringInputSprite input) {
/* 18 */     this.input = input;
/*    */     
/* 20 */     int w = (input.font()).maxCWidth * (input.text().length() + input.text().spaceLeft());
/* 21 */     this.body.setWidth((w + 12));
/* 22 */     this.body.setHeight((input.height() + 12));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 29 */     GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body);
/*    */ 
/*    */     
/* 32 */     this.input.renAction();
/* 33 */     if (Mouse.currentClicked == this) {
/* 34 */       this.input.listen();
/*    */     }
/* 36 */     if (isHovered || Mouse.currentClicked == this) {
/* 37 */       (GCOLOR.UI()).NORMAL.hovered.render(r, (RECTANGLE)body());
/*    */     }
/*    */     
/* 40 */     int x1 = body().x1() + 6;
/* 41 */     int y1 = body().y1() + (body().height() - this.input.height()) / 2;
/*    */     
/* 43 */     this.dragging &= MButt.LEFT.isDown();
/*    */     
/* 45 */     if (this.dragging) {
/* 46 */       this.input.select(VIEW.mouse().x() - x1);
/*    */     }
/*    */     
/* 49 */     this.input.render(r, x1, y1);
/*    */     
/* 51 */     GCOLOR.UI().border().renderFrame(r, (RECTANGLE)this.body, 0, 2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean click() {
/* 57 */     if (super.click()) {
/* 58 */       Mouse.currentClicked = (CLICKABLE)this;
/* 59 */       if (!this.input.listening() || MButt.LEFT.isDouble()) {
/* 60 */         this.input.listen();
/* 61 */         this.input.selectAll();
/* 62 */         this.dragging = false;
/*    */       } else {
/* 64 */         this.dragging = true;
/*    */         
/* 66 */         this.input.click(VIEW.mouse().x() - body().x1() - 6);
/* 67 */         return true;
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public void focus() {
/* 77 */     Mouse.currentClicked = (CLICKABLE)this;
/* 78 */     this.input.listen();
/* 79 */     this.input.selectAll();
/*    */   }
/*    */   
/*    */   public void listen() {
/* 83 */     Mouse.currentClicked = (CLICKABLE)this;
/* 84 */     this.input.listen();
/*    */   }
/*    */   
/*    */   public Str text() {
/* 88 */     return this.input.text();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GInput.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */