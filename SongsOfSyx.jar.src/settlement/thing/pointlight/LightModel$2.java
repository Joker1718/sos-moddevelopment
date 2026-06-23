/*    */ package settlement.thing.pointlight;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 52 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   double flicker(LightModel.PointLight l, int radius) {
/* 56 */     l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/* 57 */     l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/* 58 */     double intense = (4.0F + RND.rExpo() * RND.rFloat0(0.800000011920929D));
/* 59 */     l.r = intense * 1.8D;
/* 60 */     l.g = intense * 0.9D;
/* 61 */     l.b = intense * 0.4D;
/* 62 */     l.radius = radius - RND.rInt(8);
/* 63 */     l.falloff = 1.0D;
/* 64 */     l.z = (30 + RND.rInt0(5));
/* 65 */     return 0.025D + RND.rFloat(0.05000000074505806D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void renderSprite(int x1, int y1, int ran) {}
/*    */ 
/*    */ 
/*    */   
/*    */   void renderFlame(int tx, int ty, int x1, int y1, int ran) {
/* 75 */     flame(tx, ty, x1, y1, ran, (SETT.LIGHTS()).sprites.flame_medium, 24);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LightModel$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */