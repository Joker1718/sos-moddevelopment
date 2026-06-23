/*    */ package view.ui.tech;
/*    */ 
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 50 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 54 */     UITechTree.this.currentTree = tree;
/* 55 */     UITechTree.this.swit.set((RENDEROBJ)tree);
/* 56 */     UITechTree.this.filter.text().clear();
/* 57 */     super.clickA();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 62 */     selectedSet((UITechTree.this.swit.current() == tree));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\UITechTree$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */