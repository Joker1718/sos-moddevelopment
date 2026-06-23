/*    */ package view.interrupter;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.MButt;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.text.D;
/*    */ import view.keyboard.KEYS;
/*    */ 
/*    */ public class ILoadScreen
/*    */   extends Interrupter {
/* 13 */   private static CharSequence ¤¤clickToContinue = "¤CLICK TO CONTINUE!";
/*    */   static {
/* 15 */     D.ts(ILoadScreen.class);
/*    */   }
/*    */   private final InterManager m;
/*    */   
/*    */   public ILoadScreen(InterManager manager) {
/* 20 */     pin();
/* 21 */     this.m = manager;
/*    */   }
/*    */   
/*    */   public void activate() {
/* 25 */     show(this.m);
/*    */   }
/*    */ 
/*    */   
/*    */   public void deactivate() {
/* 30 */     hide();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void hoverTimer(GBox text) {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, float ds) {
/* 41 */     SPRITES.loader().render(¤¤clickToContinue, true);
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void mouseClick(MButt button) {
/* 48 */     deactivate();
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 53 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean update(float ds) {
/* 59 */     if (MButt.LEFT.consumeClick()) {
/* 60 */       deactivate();
/*    */     }
/* 62 */     if (MButt.RIGHT.consumeClick()) {
/* 63 */       deactivate();
/*    */     }
/* 65 */     if (KEYS.anyDown())
/* 66 */       deactivate(); 
/* 67 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\ILoadScreen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */