/*    */ package view.interrupter;
/*    */ 
/*    */ import init.constant.C;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ 
/*    */ 
/*    */ public class ISidePanel
/*    */ {
/*    */   protected GuiSection section;
/*    */   protected CharSequence title;
/*    */   public static final int M = 8;
/*    */   static final int Y1 = 51;
/*    */   static final int Y2 = 91;
/* 14 */   public static final int HEIGHT = C.HEIGHT() - 91 - 8;
/*    */   
/*    */   ISidePanels last;
/*    */   
/*    */   public ISidePanel(GuiSection section) {
/* 19 */     this.section = section;
/*    */   }
/*    */   
/*    */   public ISidePanel() {
/* 23 */     this.section = new GuiSection();
/*    */   }
/*    */   
/*    */   public GuiSection section() {
/* 27 */     return this.section;
/*    */   }
/*    */   
/*    */   public void titleSet(CharSequence title) {
/* 31 */     this.title = title;
/*    */   }
/*    */   
/*    */   public CharSequence title() {
/* 35 */     return this.title;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(float ds) {}
/*    */ 
/*    */   
/*    */   public ISidePanels last() {
/* 43 */     return this.last;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void addAction() {}
/*    */ 
/*    */   
/*    */   protected boolean back() {
/* 51 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\ISidePanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */