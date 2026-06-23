/*    */ package view.sett.ui.noble;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.nobility.NobleOffice;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class BB
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   private final NobleOffice o;
/*    */   
/*    */   BB(NobleOffice o) {
/* 50 */     super(o.icon.huge);
/* 51 */     this.o = o;
/* 52 */     pad(4, 4);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 57 */     selectedSet((NobleAssigns.this.n.office() == this.o));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 63 */     GAME.NOBLE().setOffice(NobleAssigns.this.n, this.o);
/* 64 */     (VIEW.inters()).popup.close();
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 69 */     this.o.hover(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\noble\NobleAssigns$BB.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */