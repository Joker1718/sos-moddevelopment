/*    */ package view.main;
/*    */ 
/*    */ import view.interrupter.IDebugPanel;
/*    */ import view.interrupter.ILoadScreen;
/*    */ import view.interrupter.IPopup;
/*    */ import view.interrupter.IPromtScreen;
/*    */ import view.interrupter.IPromtYesNO;
/*    */ import view.interrupter.ITextInput;
/*    */ import view.interrupter.InterGuisection;
/*    */ import view.interrupter.InterManager;
/*    */ import view.menu.IMenu;
/*    */ import view.ui.message.Messages;
/*    */ 
/*    */ public class Interrupters
/*    */ {
/* 16 */   public final InterManager manager = new InterManager();
/* 17 */   public final IMenu menu = new IMenu(this.manager);
/* 18 */   public final ITextInput input = new ITextInput(this.manager);
/* 19 */   public final IPromtScreen fullScreen = new IPromtScreen(this.manager);
/* 20 */   public final IPromtYesNO yesNo = new IPromtYesNO(this.manager);
/*    */   
/*    */   public final IDebugPanel debugpanel;
/* 23 */   public final IMouseMessage mouseMessage = new IMouseMessage();
/* 24 */   public final InterGuisection section = new InterGuisection(this.manager);
/*    */   public final Messages messages;
/* 26 */   public final IPopup popup = new IPopup(this.manager);
/* 27 */   public final IPopup popup2 = new IPopup(this.manager);
/* 28 */   public final ILoadScreen load = new ILoadScreen(this.manager);
/*    */ 
/*    */ 
/*    */   
/*    */   public Interrupters() {
/* 33 */     this.messages = new Messages(this.manager);
/*    */ 
/*    */     
/* 36 */     this.debugpanel = new IDebugPanel(this.manager);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\main\Interrupters.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */