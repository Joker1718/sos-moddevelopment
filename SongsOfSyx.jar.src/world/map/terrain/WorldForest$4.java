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
/* 67 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 71 */     int t = 32;
/* 72 */     COLOR.WHITE100.bind();
/* 73 */     WorldForest.this.sprites.bg.render(r, t, X1 - 1, X2 - 1, Y1 - 1, Y2 - 1);
/* 74 */     COLOR.BLACK.bind();
/* 75 */     WorldForest.this.sprites.bg.render(r, t, X1 + 1, X2 + 1, Y1 + 1, Y2 + 1);
/* 76 */     WorldForest.this.sprites.colors[0][0].bind();
/*    */     
/* 78 */     WorldForest.this.sprites.bg.render(r, t, X1, X2, Y1, Y2);
/* 79 */     WorldForest.this.sprites.sheet.render(r, t, X1, X2, Y1, Y2);
/* 80 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldForest$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */