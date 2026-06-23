/*    */ package view.ui.tech;
/*    */ 
/*    */ import init.constant.C;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
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
/*    */ class null
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0) {
/* 48 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 52 */     COLOR.WHITE15.render(r, 0, C.WIDTH(), 0, Tree.this.body().y1() - 16);
/* 53 */     if (Tree.this.dh > 0) {
/* 54 */       COLOR.WHITE15.render(r, Tree.this.body().x2() - 32, C.WIDTH(), 0, C.HEIGHT());
/*    */     }
/*    */     
/* 57 */     if (Tree.this.dw > 0)
/* 58 */       COLOR.WHITE15.render(r, 0, C.WIDTH(), Tree.this.body().y2() - 32, C.HEIGHT()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\Tree$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */