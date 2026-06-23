/*    */ package settlement.room.main.copy;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
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
/*    */ class null
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0) {
/* 37 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 41 */     BSwap.this.current.iconBig().renderC(r, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2);
/* 42 */     (SPRITES.icons()).m.rotate.renderC(r, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\BSwap$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */