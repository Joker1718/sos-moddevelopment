/*    */ package settlement.tilemap.ground;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.TILE_SHEET;
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
/* 36 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 40 */     GroundType.this.tmps[8].bind();
/* 41 */     sheet.render(r, 0, X1, X1 + 16, Y1, Y1 + 16);
/* 42 */     sheet.render(r, 1, X1 + 16, X2, Y1, Y1 + 16);
/* 43 */     sheet.render(r, 2, X1, X1 + 16, Y1 + 16, Y2);
/* 44 */     sheet.render(r, 3, X1 + 16, X2, Y1 + 16, Y2);
/* 45 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\GroundType$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */