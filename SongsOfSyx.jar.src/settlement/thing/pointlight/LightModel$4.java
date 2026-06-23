/*     */ package settlement.thing.pointlight;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends LightModel
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 108 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   double flicker(LightModel.PointLight l, int radius) {
/* 112 */     l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/* 113 */     l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/* 114 */     double intense = 2.5D + Math.pow(RND.rFloat0(0.8D), 3.0D);
/* 115 */     l.r = intense * 1.7D;
/* 116 */     l.g = intense * 0.8D;
/* 117 */     l.b = intense * 0.3D;
/* 118 */     l.radius = radius;
/* 119 */     l.falloff = 1.0D;
/* 120 */     l.z = 15.0D;
/* 121 */     return (0.03F + RND.rFloat(0.05000000074505806D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void renderSprite(int x1, int y1, int ran) {}
/*     */ 
/*     */ 
/*     */   
/*     */   void renderFlame(int tx, int ty, int cx, int cy, int ran) {
/* 132 */     flame(tx, ty, cx, cy, ran, (SETT.LIGHTS()).sprites.flame_big, 48);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double intensity(int x, int y) {
/* 137 */     return 1.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LightModel$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */