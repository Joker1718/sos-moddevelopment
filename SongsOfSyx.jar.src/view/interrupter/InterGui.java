/*    */ package view.interrupter;
/*    */ import snake2d.MButt;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.gui.misc.GBox;
/*    */ 
/*    */ public abstract class InterGui extends Interrupter {
/* 12 */   protected GuiSection section = new GuiSection();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 20 */     return !(!this.section.hover(mCoo) && !mCoo.isWithinRec((RECTANGLE)this.section.body()));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void mouseClick(MButt button) {
/* 25 */     if (button == MButt.LEFT) {
/* 26 */       this.section.click();
/* 27 */     } else if (button == MButt.RIGHT && back()) {
/* 28 */       deactivate();
/*    */     } 
/*    */   }
/*    */   
/*    */   protected boolean back() {
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean otherClick(MButt button) {
/* 38 */     if (button == MButt.RIGHT && !pinned()) {
/* 39 */       deactivate();
/* 40 */       return true;
/*    */     } 
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hoverTimer(GBox text) {
/* 47 */     this.section.hoverInfoGet((GUI_BOX)text);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, float ds) {
/* 52 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 53 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean update(float ds) {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */   public void deactivate() {
/* 62 */     hide();
/*    */   }
/*    */   
/*    */   public RECTANGLE body() {
/* 66 */     return (RECTANGLE)this.section.body();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\InterGui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */