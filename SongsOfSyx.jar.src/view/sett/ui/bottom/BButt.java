/*    */ package view.sett.ui.bottom;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Text;
/*    */ import util.gui.misc.GButt;
/*    */ 
/*    */ class BButt
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   public static final int HEIGHT = 44;
/*    */   public static final int WIDTH = 350;
/*    */   
/*    */   public BButt(SPRITE icon, CharSequence label) {
/* 15 */     super((SPRITE)(new Text((UI.FONT()).H2, label)).setMaxWidth(300).setMultipleLines(false));
/* 16 */     SPRITE.Wrap wrap = new SPRITE.Wrap(icon, 32, 32);
/* 17 */     icon((SPRITE)wrap);
/* 18 */     setDim(350, 44);
/*    */   }
/*    */   
/*    */   public BButt(SPRITE icon, CharSequence label, int dwidth) {
/* 22 */     super((SPRITE)(new Text((UI.FONT()).H2, label)).setMaxWidth(300 - dwidth).setMultipleLines(false));
/* 23 */     SPRITE.Wrap wrap = new SPRITE.Wrap(icon, 32, 32);
/* 24 */     icon((SPRITE)wrap);
/* 25 */     setDim(350 - dwidth, 44);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\BButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */