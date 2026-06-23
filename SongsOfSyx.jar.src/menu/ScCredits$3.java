/*    */ package menu;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.text.Font;
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
/*    */   null(int $anonymous0, int $anonymous1) {
/* 77 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 81 */     GUI.COLORS.label.bind();
/* 82 */     Font f = (UI.FONT()).M;
/* 83 */     int x = body().cX() - wi / 2 + 25;
/* 84 */     for (int i = from; i < to; i++) {
/* 85 */       f.render(r, nn[i], x, body().y1());
/* 86 */       x += f.getDim(nn[i]).x() + 50;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScCredits$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */