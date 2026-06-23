/*     */ package settlement.thing.pointlight;
/*     */ 
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
/* 141 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   double flicker(LightModel.PointLight l, int radius) {
/* 145 */     l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/* 146 */     l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/* 147 */     double intense = (5.0F + RND.rExpo() * RND.rFloat0(0.20000000298023224D));
/* 148 */     l.r = intense * 1.3D;
/* 149 */     l.g = intense * 0.7D;
/* 150 */     l.b = intense * 0.3D;
/* 151 */     l.radius = radius;
/* 152 */     l.falloff = 0.4D;
/* 153 */     l.z = 20.0D;
/* 154 */     return 0.025D + RND.rFloat(0.05000000074505806D);
/*     */   }
/*     */   
/*     */   void renderSprite(int x1, int y1, int ran) {}
/*     */   
/*     */   void renderFlame(int tx, int ty, int cx, int cy, int ran) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LightModel$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */