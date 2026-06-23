/*    */ package settlement.thing.pointlight;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.rnd.RND;
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
/*    */   extends LightModel
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 20 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   double flicker(LightModel.PointLight l, int radius) {
/* 24 */     l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/* 25 */     l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/* 26 */     double intense = 5.0D + Math.pow(RND.rFloat0(0.8D), 3.0D);
/* 27 */     l.r = intense * 1.7D;
/* 28 */     l.g = intense * 0.8D;
/* 29 */     l.b = intense * 0.4D;
/* 30 */     l.radius = radius - RND.rInt(8);
/* 31 */     l.falloff = 1.0D;
/* 32 */     l.z = (30 + RND.rInt0(5));
/* 33 */     return (0.03F + RND.rFloat(0.05000000074505806D));
/*    */   }
/*    */ 
/*    */   
/*    */   void renderSprite(int x1, int y1, int ran) {
/* 38 */     (SETT.LIGHTS()).sprites.candle.renderC((SPRITE_RENDERER)CORE.renderer(), ran & 0x7, x1, y1);
/*    */   }
/*    */ 
/*    */   
/*    */   void renderFlame(int tx, int ty, int x1, int y1, int ran) {
/* 43 */     flame(tx, ty, x1, y1, ran, (SETT.LIGHTS()).sprites.flame_small, 2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected double intensity(int x, int y) {
/* 48 */     return super.intensity(x, y);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LightModel$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */