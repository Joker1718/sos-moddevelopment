/*    */ package world.map.regions;
/*    */ 
/*    */ import snake2d.util.misc.CLAMP;
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
/*    */ class Trans
/*    */ {
/*    */   public final double weight;
/*    */   public final double ave;
/*    */   public final double max;
/*    */   
/*    */   public Trans(double ave, double min, double max) {
/* 62 */     this.ave = ave;
/* 63 */     this.max = max;
/*    */     
/* 65 */     double w = 1.0D - ave / max;
/* 66 */     this.weight = 1.0D / w;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private double d(double v) {
/* 72 */     double m = this.weight * this.ave / this.max;
/* 73 */     double d = (1.0D - m + this.weight * v / this.max) / 2.0D;
/* 74 */     return CLAMP.d(d, 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\Test$Trans.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */