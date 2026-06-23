/*     */ package launcher;
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
/*     */ class BigCloud
/*     */   extends GUI.LSprite
/*     */ {
/*     */   private static final float ySpeed = -55.0F;
/*     */   private static final float xSpeed = 38.0F;
/*     */   private final float scale;
/*     */   
/*     */   BigCloud(float scale) {
/* 135 */     super(paramBG.sprites[RND.rInt(paramBG.sprites.length)], 0.0F, 0.0F);
/* 136 */     body().scale(scale, scale);
/* 137 */     this.scale = scale;
/* 138 */     reIni();
/*     */   }
/*     */   
/*     */   void update(float ms) {
/* 142 */     body().incrY((-55.0F * this.scale * this.scale * ms));
/* 143 */     body().incrX((38.0F * this.scale * ms));
/*     */   }
/*     */   
/*     */   void reIni() {
/* 147 */     body().moveX1((-BG.this.quadBounds.width() + 2 * RND.rInt(BG.this.quadBounds.width())));
/* 148 */     body().moveY1(BG.this.quadBounds.y2());
/* 149 */     getOpacity().set(RND.rInt(255));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\BG$BigCloud.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */