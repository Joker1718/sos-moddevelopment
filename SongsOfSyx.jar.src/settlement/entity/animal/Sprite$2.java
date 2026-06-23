/*    */ package settlement.entity.animal;
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
/*    */   extends Sprite
/*    */ {
/*    */   private final int[] rows;
/*    */   private final float fps = 25.0F;
/*    */   
/*    */   null(float $anonymous0) {
/* 63 */     super($anonymous0);
/* 64 */     this.rows = new int[] { 24, 32, 40 };
/* 65 */     this.fps = 25.0F;
/*    */   }
/*    */   public int getDir(Animal a, float ds) {
/* 68 */     return a.speed.dir().id();
/*    */   }
/*    */   
/*    */   protected int getRow(Animal a, float ds) {
/* 72 */     if (a.speed.magnitude() == 0.0D) {
/* 73 */       if (a.isBaby()) {
/* 74 */         return 0;
/*    */       }
/* 76 */       return 24;
/* 77 */     }  float t = a.spriteTimer = (float)(a.spriteTimer + (25.0F * ds) * a.speed.magnitudeRelative());
/* 78 */     if (t >= this.rows.length) {
/* 79 */       t = 0.0F;
/* 80 */       a.spriteTimer = 0.0F;
/*    */     } 
/* 82 */     if (a.isBaby())
/* 83 */       return this.rows[(int)t] - 24; 
/* 84 */     return this.rows[(int)t];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Sprite$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */