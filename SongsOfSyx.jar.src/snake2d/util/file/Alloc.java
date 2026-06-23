/*     */ package snake2d.util.file;
/*     */ 
/*     */ 
/*     */ public final class Alloc
/*     */ {
/*     */   public static boolean debug = false;
/*     */   
/*     */   public static int[] ii(int size) {
/*   9 */     if (debug) {
/*  10 */       (new RuntimeException(size)).printStackTrace();
/*     */     }
/*  12 */     return new int[size];
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[][] i2(int size) {
/*  17 */     if (debug) {
/*  18 */       (new RuntimeException(size)).printStackTrace();
/*     */     }
/*  20 */     return new int[size][];
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[][] i2(int a, int b) {
/*  25 */     if (debug) {
/*  26 */       (new RuntimeException(a * b)).printStackTrace();
/*     */     }
/*  28 */     return new int[a][b];
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[][][] i3(int size) {
/*  33 */     if (debug) {
/*  34 */       (new RuntimeException(size)).printStackTrace();
/*     */     }
/*  36 */     return new int[size][][];
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] bb(int size) {
/*  41 */     if (debug) {
/*  42 */       (new RuntimeException(size)).printStackTrace();
/*     */     }
/*  44 */     return new byte[size];
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[][] b2(int size) {
/*  49 */     if (debug) {
/*  50 */       (new RuntimeException(size)).printStackTrace();
/*     */     }
/*  52 */     return new byte[size][];
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[][] b2(int a, int b) {
/*  57 */     if (debug) {
/*  58 */       (new RuntimeException(a * b)).printStackTrace();
/*     */     }
/*  60 */     return new byte[a][b];
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[][][] b3(int size) {
/*  65 */     if (debug) {
/*  66 */       (new RuntimeException(size)).printStackTrace();
/*     */     }
/*  68 */     return new byte[size][][];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] cc(int size) {
/*  74 */     if (debug) {
/*  75 */       (new RuntimeException(size)).printStackTrace();
/*     */     }
/*  77 */     return new char[size];
/*     */   }
/*     */ 
/*     */   
/*     */   public static char[][] c2(int size) {
/*  82 */     if (debug) {
/*  83 */       (new RuntimeException(size)).printStackTrace();
/*     */     }
/*  85 */     return new char[size][];
/*     */   }
/*     */ 
/*     */   
/*     */   public static char[][] c2(int a, int b) {
/*  90 */     if (debug) {
/*  91 */       (new RuntimeException(a * b)).printStackTrace();
/*     */     }
/*  93 */     return new char[a][b];
/*     */   }
/*     */ 
/*     */   
/*     */   public static char[][][] c3(int size) {
/*  98 */     if (debug) {
/*  99 */       (new RuntimeException(size)).printStackTrace();
/*     */     }
/* 101 */     return new char[size][][];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\Alloc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */