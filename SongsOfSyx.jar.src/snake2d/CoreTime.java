/*    */ package snake2d;
/*    */ 
/*    */ public class CoreTime
/*    */ {
/*  5 */   private double secondsSinceFirstUpdate = 0.0D;
/*    */   private long nowMillis;
/*    */   private long nowNanos;
/*  8 */   private float zeroToOneToZero1s = 0.0F;
/*  9 */   private float zeroToOneToZero1sDir = 1.0F;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void update(float ds, long nowMillis, long nowNanos) {
/* 16 */     this.secondsSinceFirstUpdate += ds;
/* 17 */     this.nowMillis = nowMillis;
/* 18 */     this.nowNanos = nowNanos;
/*    */     
/* 20 */     this.zeroToOneToZero1s += this.zeroToOneToZero1sDir * ds;
/* 21 */     if (this.zeroToOneToZero1s > 1.0F) {
/* 22 */       this.zeroToOneToZero1s -= (int)this.zeroToOneToZero1s;
/* 23 */       this.zeroToOneToZero1s = 1.0F - this.zeroToOneToZero1s;
/* 24 */       this.zeroToOneToZero1sDir = -1.0F;
/* 25 */     } else if (this.zeroToOneToZero1s < 0.0F) {
/* 26 */       this.zeroToOneToZero1s *= -1.0F;
/* 27 */       this.zeroToOneToZero1sDir = 1.0F;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public double getSecondsSinceFirstUpdate() {
/* 33 */     return this.secondsSinceFirstUpdate;
/*    */   }
/*    */   
/*    */   public long getNowMillis() {
/* 37 */     return this.nowMillis;
/*    */   }
/*    */   
/*    */   public long getNowNanos() {
/* 41 */     return this.nowNanos;
/*    */   }
/*    */   
/*    */   public float getPendulum0To1s1() {
/* 45 */     return this.zeroToOneToZero1s;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\CoreTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */