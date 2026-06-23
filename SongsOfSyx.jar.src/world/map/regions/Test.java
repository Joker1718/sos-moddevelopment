/*    */ package world.map.regions;
/*    */ 
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ 
/*    */ class Test
/*    */ {
/*    */   public static void main(String[] args) {
/* 11 */     int tot = 500;
/* 12 */     Trans tr = null;
/* 13 */     T[] all = new T[500];
/* 14 */     for (int i = 0; i < all.length; i++) {
/* 15 */       all[i] = new T(RND.rFloatP(2.0F));
/*    */     }
/* 17 */     double ave = 0.0D;
/* 18 */     double max = 0.0D;
/* 19 */     double d1 = Double.MAX_VALUE; byte b; int j; T[] arrayOfT1;
/* 20 */     for (j = (arrayOfT1 = all).length, b = 0; b < j; ) { T t = arrayOfT1[b];
/* 21 */       ave += t.value;
/* 22 */       max = Math.max(max, t.value);
/* 23 */       d1 = Math.min(t.value, d1); b++; }
/*    */     
/* 25 */     ave /= 500.0D;
/*    */     
/* 27 */     tr = new Trans(ave, d1, max);
/*    */ 
/*    */     
/* 30 */     double a = 0.0D;
/* 31 */     double mi = Double.MAX_VALUE;
/* 32 */     double ma = 0.0D;
/* 33 */     for (j = (arrayOfT1 = all).length, b = 0; b < j; ) { T t = arrayOfT1[b];
/* 34 */       double v = tr.d(t.value);
/* 35 */       a += v;
/* 36 */       mi = Math.min(mi, v);
/* 37 */       ma = Math.max(v, ma); b++; }
/*    */     
/* 39 */     LOG.ln("" + a / 500.0D + " " + a / 500.0D + " " + mi);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static class T
/*    */   {
/*    */     public double value;
/*    */ 
/*    */     
/*    */     T(double value) {
/* 50 */       this.value = value;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private static class Trans
/*    */   {
/*    */     public final double weight;
/*    */     public final double ave;
/*    */     public final double max;
/*    */     
/*    */     public Trans(double ave, double min, double max) {
/* 62 */       this.ave = ave;
/* 63 */       this.max = max;
/*    */       
/* 65 */       double w = 1.0D - ave / max;
/* 66 */       this.weight = 1.0D / w;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     private double d(double v) {
/* 72 */       double m = this.weight * this.ave / this.max;
/* 73 */       double d = (1.0D - m + this.weight * v / this.max) / 2.0D;
/* 74 */       return CLAMP.d(d, 0.0D, 1.0D);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\Test.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */