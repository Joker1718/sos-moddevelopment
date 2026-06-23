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
/*    */ class null
/*    */   extends Sprite
/*    */ {
/*    */   null(float $anonymous0) {
/* 50 */     super($anonymous0);
/*    */   }
/*    */   public int getDir(Animal a, float ds) {
/* 53 */     return a.speed.dir().id();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getRow(Animal a, float ds) {
/* 58 */     if (a.isBaby())
/* 59 */       return 0; 
/* 60 */     return 24;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Sprite$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */