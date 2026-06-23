/*    */ package view.ui.manage;
/*    */ 
/*    */ import init.constant.C;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public class IFullView
/*    */ {
/*    */   public static final int TOP_HEIGHT = 56;
/* 12 */   public static final int WIDTH = C.WIDTH() - 32;
/* 13 */   public static final int HEIGHT = C.HEIGHT() - 56 - 8;
/*    */   
/*    */   public final CharSequence title;
/*    */   public final SPRITE icon;
/* 17 */   protected GuiSection section = new GuiSection();
/*    */   
/*    */   public IFullView(CharSequence name, SPRITE icon) {
/* 20 */     this.title = name;
/* 21 */     this.icon = icon;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void activate() {
/* 29 */     (VIEW.UI()).manager.show(this);
/*    */   }
/*    */   
/*    */   public boolean back() {
/* 33 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 49 */     text.title(this.title);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\manage\IFullView.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */