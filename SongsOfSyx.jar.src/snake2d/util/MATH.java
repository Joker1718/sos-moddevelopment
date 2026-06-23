/*     */ package snake2d.util;
/*     */ 
/*     */ public final class MATH
/*     */ {
/*   5 */   public static final QuickPOW pow15 = new QuickPOW(1.5D, 64);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int mod(int a, int m) {
/*  12 */     int remainder = a % m;
/*  13 */     a = (remainder >> 31 & m) + remainder;
/*  14 */     return a;
/*     */   }
/*     */   
/*     */   public static double mod(double a, double b) {
/*  18 */     if (a < 0.0D) {
/*  19 */       a = -a;
/*  20 */       a %= b;
/*  21 */       a = b - a;
/*  22 */       return a;
/*  23 */     }  if (a > b)
/*  24 */       return a % b; 
/*  25 */     return a;
/*     */   }
/*     */   
/*     */   public static double distance(double from, double to, double max) {
/*  29 */     if (to < from)
/*  30 */       return max - from + to; 
/*  31 */     return to - from;
/*     */   }
/*     */   
/*     */   public static int distance(int start, int current, int max) {
/*  35 */     if (current < start)
/*  36 */       return max - start + current; 
/*  37 */     return current - start;
/*     */   }
/*     */   
/*     */   public static double distanceC(double from, double to, double max) {
/*  41 */     if (max <= 0.0D) {
/*  42 */       return 0.0D;
/*     */     }
/*  44 */     from = mod(from, max);
/*  45 */     to = mod(to, max);
/*     */     
/*  47 */     if (to < from) {
/*  48 */       return from - to;
/*     */     }
/*  50 */     return to - from;
/*     */   }
/*     */   
/*     */   public static int distanceC(int from, int to, int max) {
/*  54 */     from = mod(from, max);
/*  55 */     to = mod(to, max);
/*     */     
/*  57 */     if (to < from) {
/*  58 */       return from - to;
/*     */     }
/*  60 */     return to - from;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isWithin(double point, double from, double to) {
/*  65 */     if (from < to)
/*  66 */       return (point >= from && point < to); 
/*  67 */     return !(point < from && point >= to);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ETA(int now, int target, int timeCycle) {
/*  73 */     if (now <= target) {
/*  74 */       return target - now;
/*     */     }
/*  76 */     return timeCycle - now + target;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*  81 */     System.out.println(mod(-1.0D, 10.0D));
/*  82 */     System.out.println(distanceC(-1, 5, 10));
/*  83 */     System.out.println(distanceC(5, -1, 10));
/*     */     
/*  85 */     System.out.println(distance(5, 4, 16));
/*  86 */     System.out.println(distance(5, -1, 10));
/*     */ 
/*     */     
/*  89 */     System.out.println(ETA(12, 9, 16));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class QuickPOW
/*     */   {
/*     */     public final double pow;
/*     */ 
/*     */ 
/*     */     
/*     */     private final double[] pows;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public QuickPOW(double pow, int precistion) {
/* 107 */       this.pows = new double[precistion];
/* 108 */       this.pow = pow;
/* 109 */       for (int i = 0; i < precistion; i++) {
/* 110 */         double d = i / precistion;
/* 111 */         this.pows[i] = Math.pow(d, pow);
/*     */       } 
/*     */     }
/*     */     
/*     */     public double pow(double d) {
/* 116 */       int prec = this.pows.length - 1;
/* 117 */       double ii = d * prec;
/* 118 */       int i = (int)ii;
/* 119 */       if (i < 0)
/* 120 */         return 0.0D; 
/* 121 */       if (i >= prec) {
/* 122 */         return 1.0D;
/*     */       }
/* 124 */       ii -= i;
/* 125 */       double res = this.pows[i] * (1.0D - ii);
/* 126 */       res += this.pows[i + 1] * ii;
/*     */       
/* 128 */       return res;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\MATH.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */