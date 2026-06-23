/*    */ package game.boosting;
/*    */ 
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ public class BoosterValue
/*    */   extends Booster {
/*    */   private final double from;
/*    */   private final double to;
/*    */   private final BValue value;
/*    */   
/*    */   public BoosterValue(BValue v, BSourceInfo info, double from, double to, boolean isMul) {
/* 12 */     super(info, isMul);
/* 13 */     this.from = from;
/* 14 */     this.to = to;
/* 15 */     this.value = v;
/*    */   }
/*    */   
/*    */   public BoosterValue(BValue v, BSourceInfo info, double to, boolean isMul) {
/* 19 */     super(info, isMul);
/* 20 */     this.value = v;
/* 21 */     this.to = to;
/*    */     
/* 23 */     if (isMul) {
/* 24 */       this.from = 1.0D;
/*    */     } else {
/* 26 */       this.from = 0.0D;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public double from() {
/* 32 */     return this.from;
/*    */   }
/*    */ 
/*    */   
/*    */   public double to() {
/* 37 */     return this.to;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getValue(double input) {
/* 42 */     input = CLAMP.d(input, 0.0D, 1.0D);
/* 43 */     return from() + input * (to() - from());
/*    */   }
/*    */ 
/*    */   
/*    */   protected double pget(BOOSTABLE_O o) {
/* 48 */     return o.boostableValue(this.value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BoosterValue.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */