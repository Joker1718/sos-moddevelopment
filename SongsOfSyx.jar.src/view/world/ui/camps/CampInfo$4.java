/*    */ package view.world.ui.camps;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GMeter;
/*    */ import world.entity.haven.WHavenType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 74 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 78 */     double d = type.reqsFrom.progress(null);
/* 79 */     if (d >= 1.0D) {
/* 80 */       GMeter.render(r, GMeter.C_BLUE, type.amount(), X1, X2, Y1, Y2);
/*    */     } else {
/* 82 */       GMeter.render(r, GMeter.C_ORANGE, d, X1, X2, Y1, Y2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\camps\CampInfo$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */