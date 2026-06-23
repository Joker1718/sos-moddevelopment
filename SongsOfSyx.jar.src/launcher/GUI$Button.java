/*    */ package launcher;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Button
/*    */   extends CLICKABLE.ClickableAbs
/*    */ {
/*    */   protected final SPRITE s;
/*    */   
/*    */   public Button(SPRITE s) {
/* 44 */     this.s = s;
/* 45 */     this.body.setWidth((s.width() + 10)).setHeight((s.height() + 10));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 53 */     GUI.c_border.renderFrame(r, (RECTANGLE)this.body, 0, 1);
/* 54 */     COLOR.BLACK.render(r, (RECTANGLE)this.body, -1);
/* 55 */     (isHovered ? COLOR.WHITE35 : COLOR.WHITE15).render(r, (RECTANGLE)this.body, -4);
/*    */ 
/*    */     
/* 58 */     if (isSelected) {
/* 59 */       COLOR.WHITE100.renderFrame(r, (RECTANGLE)this.body, -2, 2);
/*    */     }
/*    */ 
/*    */     
/* 63 */     this.s.renderCY(r, body().x1() + 5, body().cY());
/*    */     
/* 65 */     if (!isActive) {
/* 66 */       OPACITY.O50.bind();
/* 67 */       COLOR.BLACK.render(r, (RECTANGLE)this.body, -4);
/* 68 */       OPACITY.unbind();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\GUI$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */