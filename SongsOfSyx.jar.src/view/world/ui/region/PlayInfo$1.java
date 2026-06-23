/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GMeter;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 69 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 74 */     double c = get(RD.HEALTH().getD(g.get()));
/* 75 */     double t = get((RD.HEALTH()).boostablee.get((BOOSTABLE_O)g.get()));
/*    */     
/* 77 */     GMeter.renderC(r, c, t, X1, X2, Y1, Y2);
/*    */     
/* 79 */     if ((RD.HEALTH()).outbreak.get((Region)g.get()) == 1) {
/* 80 */       Y1 -= 24;
/* 81 */       OPACITY.O25TO100.bind();
/* 82 */       (UI.icons()).m.disease.render(r, X1, Y1);
/* 83 */       OPACITY.unbind();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private double get(double d) {
/* 90 */     return CLAMP.d(d, 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayInfo$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */