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
/*     */ class null
/*     */   extends LightModel
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/*  79 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   double flicker(LightModel.PointLight l, int radius) {
/*  83 */     l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/*  84 */     l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/*  85 */     double intense = (4.0F + RND.rExpo() * RND.rFloat0(0.800000011920929D));
/*  86 */     l.r = intense * 1.8D;
/*  87 */     l.g = intense * 0.9D;
/*  88 */     l.b = intense * 0.3D;
/*  89 */     l.radius = radius;
/*  90 */     l.falloff = 1.0D;
/*  91 */     l.z = (30 + RND.rInt0(5));
/*  92 */     return 0.025D + RND.rFloat(0.05000000074505806D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void renderSprite(int x1, int y1, int ran) {}
/*     */ 
/*     */ 
/*     */   
/*     */   void renderFlame(int tx, int ty, int x1, int y1, int ran) {
/* 102 */     flame(tx, ty, x1, y1, ran, (SETT.LIGHTS()).sprites.flame_big, 48);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LightModel$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */