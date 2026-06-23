/*    */ package world.map.terrain;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
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
/* 59 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 63 */     COLOR.WHITE100.render(r, X1 - 1, X2, Y1 - 1, Y2);
/* 64 */     COLOR.BLACK.render(r, X1, X2 + 1, Y1, Y2 + 1);
/* 65 */     ((WorldGround.WGROUND)WorldGround.this.all.get(0)).col.bind();
/* 66 */     WorldGround.this.sprites.sheets[0].render(r, 0, X1, X2, Y1, Y2);
/* 67 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldGround$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */