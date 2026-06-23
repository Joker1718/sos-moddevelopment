/*    */ package settlement.entity.humanoid.spirte;
/*    */ 
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends HSprite.Standing
/*    */ {
/*    */   null(double $anonymous0, boolean $anonymous1, int... $anonymous2) {
/* 43 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   boolean baby(Induvidual in) {
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 51 */     int ss = (a.race().appearance().sheet(a)).sheet.sheet.size() / 2;
/* 52 */     int cx = x + ss;
/* 53 */     int cy = y + ss;
/* 54 */     int dx = cx + (int)((a.race()).physics.hitBoxsize() * 0.5D * dir.xN());
/* 55 */     int dy = cy + (int)((a.race()).physics.hitBoxsize() * 0.5D * dir.yN());
/* 56 */     a.race().appearance().renderBaby((SPRITE_RENDERER)r, dx, dy, dir.id(), STATS.RAN().get(a, 4));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\spirte\HSprites$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */