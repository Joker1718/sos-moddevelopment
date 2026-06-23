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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final int[] ex;
/*     */   
/*     */   null(double $anonymous0, boolean $anonymous1, int... $anonymous2) {
/* 136 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     this
/*     */ 
/*     */ 
/*     */       
/* 147 */       .ex = new int[] { 1, 2, 2, 1 };
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 152 */     int i = this.ex[(int)timer];
/*     */     
/* 154 */     STATS.EQUIP().renderExtra(a, dir, r, s, this.ex[i], x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void tick(Humanoid a, double ds) {
/* 160 */     a.spriteTimer = (float)(a.spriteTimer + ds * 20.0D * a.speed.magnitudeRelative());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\spirte\HSprites$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */