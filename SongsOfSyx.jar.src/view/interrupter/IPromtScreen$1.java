/*    */ package view.interrupter;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
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
/*    */   null(int $anonymous0, int $anonymous1) {
/* 21 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 25 */     IPromtScreen.this.c.bind();
/* 26 */     (UI.FONT()).H2.renderIn(r, (RECTANGLE)this.body, DIR.N, IPromtScreen.this.message);
/* 27 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IPromtScreen$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */