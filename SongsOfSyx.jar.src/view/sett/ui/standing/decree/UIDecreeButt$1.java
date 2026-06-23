/*    */ package view.sett.ui.standing.decree;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.gui.misc.GText;
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
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   private final GText t;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1) {
/* 35 */     super($anonymous0, $anonymous1);
/* 36 */     this.t = new GText((UI.FONT()).S, 8);
/*    */   }
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 39 */     (GCOLOR.T()).H1.bind();
/* 40 */     (UI.FONT()).H2.render(r, UIDecreeButt.¤¤title, X1, Y1);
/* 41 */     this.t.clear();
/* 42 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\decree\UIDecreeButt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */