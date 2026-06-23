/*    */ package view.sett.ui.bottom;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import util.gui.misc.GBox;
/*    */ import view.interrupter.Interrupter;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ final class Inter extends Interrupter {
/*    */   private CLICKABLE panel;
/*    */   public CLICKABLE exp;
/* 17 */   private CLICKABLE DUMMY = (CLICKABLE)new GuiSection();
/*    */ 
/*    */ 
/*    */   
/*    */   private CLICKABLE trigger;
/*    */ 
/*    */ 
/*    */   
/*    */   void set(CLICKABLE trigger, CLICKABLE panel) {
/* 26 */     this.trigger = trigger;
/* 27 */     this.panel = panel;
/* 28 */     this.panel.body().moveY2(trigger.body().y1());
/* 29 */     this.panel.body().moveCX(trigger.body().cX());
/* 30 */     exp(trigger, this.DUMMY);
/* 31 */     show((VIEW.s()).uiManager);
/*    */   }
/*    */   
/*    */   void exp(CLICKABLE exbutt, CLICKABLE panel) {
/* 35 */     if (this.exp == panel)
/*    */       return; 
/* 37 */     this.exp = panel;
/* 38 */     this.exp.body().moveY1(this.panel.body().y1());
/* 39 */     this.exp.body().moveX1(this.panel.body().x2());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void hoverTimer(GBox text) {
/* 45 */     this.panel.hoverInfoGet((GUI_BOX)text);
/* 46 */     this.exp.hoverInfoGet((GUI_BOX)text);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void mouseClick(MButt button) {
/* 51 */     if (button == MButt.RIGHT) {
/* 52 */       hide();
/* 53 */     } else if (button == MButt.LEFT) {
/* 54 */       this.panel.click();
/* 55 */       this.exp.click();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hide() {
/* 62 */     super.hide();
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean otherClick(MButt butt) {
/* 67 */     hide();
/* 68 */     if (butt == MButt.RIGHT)
/* 69 */       return true; 
/* 70 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void otherAdd(Interrupter other) {
/* 75 */     hide();
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 80 */     boolean ret = this.panel.hover(mCoo);
/* 81 */     if (this.exp.hover(mCoo)) {
/* 82 */       ret = true;
/*    */     }
/*    */ 
/*    */     
/* 86 */     return ret;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, float ds) {
/* 91 */     this.trigger.selectTmp();
/* 92 */     this.panel.render((SPRITE_RENDERER)r, ds);
/* 93 */     this.exp.render((SPRITE_RENDERER)r, ds);
/* 94 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean update(float ds) {
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\Inter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */