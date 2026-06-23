/*    */ package init.type;
/*    */ 
/*    */ import init.race.Race;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   null(int $anonymous0, int $anonymous1) {
/* 68 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2) {
/* 72 */     double scale = (Y2 - Y1) / height();
/* 73 */     (race.appearance()).icon.renderCScaled(rr, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2, (int)scale);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HCLASS_RACE$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */