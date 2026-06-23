/*     */ package snake2d.util.rnd;
/*     */ 
/*     */ import java.util.Random;
/*     */ import snake2d.Printer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RND
/*     */ {
/*  14 */   private static Random rnd = new Random();
/*  15 */   private static int seed = rnd.nextInt(); static {
/*  16 */     rnd = new Random(RND.seed);
/*  17 */     long seed = rnd.nextLong();
/*  18 */     Printer.ln("[RND] ---Initiating random, seed: " + seed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int rInt() {
/*  24 */     return rnd.nextInt();
/*     */   }
/*     */   
/*     */   public static boolean rBoolean() {
/*  28 */     return rnd.nextBoolean();
/*     */   }
/*     */   
/*     */   public static int rInt(int max) {
/*  32 */     return rnd.nextInt(max);
/*     */   }
/*     */   
/*     */   public static int rInt0(int dist) {
/*  36 */     if (dist == 0)
/*  37 */       return 0; 
/*  38 */     return -dist + rnd.nextInt(dist * 2 + 1);
/*     */   }
/*     */   
/*     */   public static float rFloat() {
/*  42 */     return rnd.nextFloat();
/*     */   }
/*     */   
/*     */   public static float rFloatP(float exponent) {
/*  46 */     float res = rFloat();
/*  47 */     while (exponent > 1.0F) {
/*  48 */       res *= res;
/*  49 */       exponent--;
/*     */     } 
/*  51 */     return res;
/*     */   }
/*     */   
/*     */   public static float rFloat(double d) {
/*  55 */     return (float)(rnd.nextFloat() * d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float rFloat1(double d) {
/*  64 */     return (float)(1.0D - d + rnd.nextFloat() * d * 2.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float rFloat0(double d) {
/*  73 */     return (float)(-d + rnd.nextFloat() * d * 2.0D);
/*     */   }
/*     */   
/*     */   public static boolean oneIn(int what) {
/*  77 */     if (what <= 1)
/*  78 */       return true; 
/*  79 */     return (rnd.nextInt(what) == what - 1);
/*     */   }
/*     */   
/*     */   public static boolean oneIn(double what) {
/*  83 */     return oneIn((int)what);
/*     */   }
/*     */   
/*     */   public static boolean oneInD(double what) {
/*  87 */     return (rFloat() * what < 1.0D);
/*     */   }
/*     */   
/*     */   public static short rShort(int upperBound) {
/*  91 */     return (short)rInt(upperBound);
/*     */   }
/*     */   
/*     */   public static short rShort() {
/*  95 */     return rShort(32767);
/*     */   }
/*     */   
/*     */   public static long rLong() {
/*  99 */     return rnd.nextLong();
/*     */   }
/*     */   
/*     */   public static float rExpo() {
/* 103 */     float f = rFloat();
/* 104 */     return f * f;
/*     */   }
/*     */   
/*     */   public static double rSign() {
/* 108 */     if (rBoolean())
/* 109 */       return 1.0D; 
/* 110 */     return -1.0D;
/*     */   }
/*     */   
/*     */   public static int seed() {
/* 114 */     return seed;
/*     */   }
/*     */   
/*     */   public static void setSeed(int seed) {
/* 118 */     RND.seed = seed;
/* 119 */     rnd.setSeed(seed);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\rnd\RND.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */