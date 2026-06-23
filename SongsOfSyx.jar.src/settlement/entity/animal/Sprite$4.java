/*     */ package settlement.entity.animal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Sprite
/*     */ {
/*     */   private final int[] st;
/*     */   private final float fps = 8.0F;
/*     */   
/*     */   null(float $anonymous0) {
/* 100 */     super($anonymous0);
/* 101 */     this.st = new int[] { 24, 56 };
/* 102 */     this.fps = 8.0F;
/*     */   }
/*     */   public int getDir(Animal a, float ds) {
/* 105 */     return a.speed.dir().id();
/*     */   }
/*     */   
/*     */   protected int getRow(Animal a, float ds) {
/* 109 */     float t = a.spriteTimer += 8.0F * ds;
/* 110 */     if (t >= this.st.length) {
/* 111 */       t = 0.0F;
/* 112 */       a.spriteTimer = 0.0F;
/*     */     } 
/* 114 */     if (a.isBaby())
/* 115 */       return 0; 
/* 116 */     return this.st[(int)t];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Sprite$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */