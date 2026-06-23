/*    */ package init.sprite.UI;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0) {
/* 62 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 69 */     for (int i = 0; i < sps.size(); i++) {
/* 70 */       SPRITE ic = (SPRITE)sps.get(i);
/* 71 */       int d = X2 - X1 - (X2 - X1) * ic.width() / width();
/* 72 */       d /= 2;
/*    */       
/* 74 */       OPACITY.O66.bind();
/* 75 */       COLOR.BLACK.bind();
/* 76 */       ic.render(r, X1 + d + 3, X2 - d + 3, Y1 + d + 3, Y2 - d + 3);
/* 77 */       COLOR.unbind();
/* 78 */       OPACITY.unbind();
/* 79 */       ic.render(r, X1 + d, X2 - d, Y1 + d, Y2 - d);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\Icons$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */