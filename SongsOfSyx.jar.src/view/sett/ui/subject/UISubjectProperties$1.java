/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
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
/*    */   GText t;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1, CharSequence paramCharSequence) {
/* 88 */     super($anonymous0, $anonymous1);
/* 89 */     this.t = (new GText((UI.FONT()).H2, paramCharSequence)).lablify();
/*    */   }
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 92 */     this.t.renderCY(r, body().x1() + 16, this.body.cY());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectProperties$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */