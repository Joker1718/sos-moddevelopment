/*    */ package snake2d.util.datatypes;
/*    */ 
/*    */ public class Pendulum
/*    */ {
/*  5 */   private double current = -1.0D;
/*  6 */   private double min = -1.0D;
/*  7 */   private double max = 1.0D;
/*  8 */   private double factor = 1.0D;
/*  9 */   private double dir = 1.0D;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean update(double incr) {
/* 16 */     this.current += incr * this.factor * this.dir;
/* 17 */     boolean change = false;
/*    */     while (true) {
/* 19 */       while (this.current > this.max) {
/* 20 */         this.current = this.max - this.current - this.max;
/* 21 */         this.dir *= -1.0D;
/* 22 */         change = true;
/* 23 */       }  if (this.current < this.min) {
/* 24 */         this.current = this.min - this.current - this.min;
/* 25 */         this.dir *= -1.0D;
/* 26 */         change = true;
/*    */         continue;
/*    */       } 
/*    */       break;
/*    */     } 
/* 31 */     return change;
/*    */   }
/*    */   
/*    */   public Pendulum setFactor(double factor) {
/* 35 */     if (factor < 0.0D)
/* 36 */       throw new RuntimeException(" " + factor); 
/* 37 */     this.factor = factor;
/* 38 */     return this;
/*    */   }
/*    */   
/*    */   public Pendulum setMinMax(double min, double max) {
/* 42 */     this.min = min;
/* 43 */     if (min > max)
/* 44 */       throw new RuntimeException(); 
/* 45 */     if (max < 0.0D || max < min)
/* 46 */       throw new RuntimeException(); 
/* 47 */     this.max = max;
/* 48 */     if (this.current < min)
/* 49 */       this.current = min; 
/* 50 */     if (this.current > max)
/* 51 */       this.current = max; 
/* 52 */     return this;
/*    */   }
/*    */   
/*    */   public Pendulum setZero(double max) {
/* 56 */     return setMinMax(0.0D, max);
/*    */   }
/*    */   
/*    */   public Pendulum setMinMax(double bound) {
/* 60 */     setMinMax(-bound, bound);
/* 61 */     return this;
/*    */   }
/*    */   
/*    */   public double get() {
/* 65 */     return this.current;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\Pendulum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */