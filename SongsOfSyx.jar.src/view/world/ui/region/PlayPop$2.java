/*    */ package view.world.ui.region;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GMeter;
/*    */ import util.gui.misc.GStat;
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
/*    */ class null
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 58 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2) {
/* 62 */     double n = (RD.RACES()).population.get((Region)g.get());
/* 63 */     double nn = (RD.RACES()).popTarget.getD(g.get());
/* 64 */     double mm = Math.max(n, nn);
/* 65 */     n /= mm;
/* 66 */     nn /= mm;
/* 67 */     GMeter.renderDelta(rr, n, nn, X1, X2, Y1, Y2);
/* 68 */     s.adjust();
/* 69 */     X1 += 8;
/* 70 */     Y1 += (Y2 - Y1 - s.height()) / 2;
/* 71 */     OPACITY.O50.bind();
/* 72 */     COLOR.BLACK.render(rr, X1 - 1, X1 + s.width() + 2, Y1 + 2, Y1 + s.height() - 2);
/* 73 */     OPACITY.unbind();
/* 74 */     s.render(rr, X1, Y1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayPop$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */