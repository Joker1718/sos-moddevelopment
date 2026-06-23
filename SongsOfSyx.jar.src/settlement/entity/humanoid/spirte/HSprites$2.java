/*     */ package settlement.entity.humanoid.spirte;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends HSprite.Standing
/*     */ {
/*     */   private final double[] ex;
/*     */   
/*     */   null(double $anonymous0, boolean $anonymous1, int... $anonymous2) {
/*  70 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  89 */       .ex = new double[] { -0.5D, 0.5D, 1.0D, 0.5D, -0.5D, 0.0D, 0.0D, 0.0D };
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick(Humanoid a, double ds) {
/*  94 */     a.spriteTimer = (float)(a.spriteTimer + ds * 20.0D * a.speed.magnitudeRelative());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/*  99 */     double i = this.ex[(int)timer];
/*     */     
/* 101 */     STATS.EQUIP().renderExtra(a, dir, r, s, i, x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\spirte\HSprites$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */