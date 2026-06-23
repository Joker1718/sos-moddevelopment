/*    */ package view.ui.profile;
/*    */ 
/*    */ import game.boosting.Boostable;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
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
/*    */   extends RENDEROBJ.RenderImp
/*    */ {
/*    */   GText h;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1, Boostable paramBoostable) {
/* 72 */     super($anonymous0, $anonymous1);
/* 73 */     this.h = (new GText((UI.FONT()).H2, paramBoostable.cat.name)).lablifySub();
/*    */   }
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 76 */     this.h.renderCY(r, body().x1() + 20, body().cY());
/* 77 */     GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UIBonus$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */