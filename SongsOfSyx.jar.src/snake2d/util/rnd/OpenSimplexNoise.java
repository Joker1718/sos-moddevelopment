/*     */ package snake2d.util.rnd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpenSimplexNoise
/*     */ {
/*     */   private static final double STRETCH_CONSTANT_2D = -0.211324865405187D;
/*     */   private static final double SQUISH_CONSTANT_2D = 0.366025403784439D;
/*     */   private static final double NORM_CONSTANT_2D = 47.0D;
/*     */   private static final long DEFAULT_SEED = 0L;
/*     */   private short[] perm;
/*     */   
/*     */   public OpenSimplexNoise() {
/*  32 */     this(0L);
/*     */   }
/*     */   
/*     */   public OpenSimplexNoise(short[] perm) {
/*  36 */     this.perm = perm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OpenSimplexNoise(long seed) {
/*  46 */     this.perm = new short[256];
/*     */     
/*  48 */     short[] source = new short[256];
/*  49 */     for (short s = 0; s < 256; s = (short)(s + 1))
/*  50 */       source[s] = s; 
/*  51 */     seed = seed * 6364136223846793005L + 1442695040888963407L;
/*  52 */     seed = seed * 6364136223846793005L + 1442695040888963407L;
/*  53 */     seed = seed * 6364136223846793005L + 1442695040888963407L;
/*  54 */     for (int i = 255; i >= 0; i--) {
/*  55 */       seed = seed * 6364136223846793005L + 1442695040888963407L;
/*  56 */       int r = (int)((seed + 31L) % (i + 1));
/*  57 */       if (r < 0)
/*  58 */         r += i + 1; 
/*  59 */       this.perm[i] = source[r];
/*  60 */       source[r] = source[i];
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double eval(double x, double y) {
/*     */     double dx_ext, dy_ext;
/*     */     int xsv_ext, ysv_ext;
/*  68 */     double stretchOffset = (x + y) * -0.211324865405187D;
/*  69 */     double xs = x + stretchOffset;
/*  70 */     double ys = y + stretchOffset;
/*     */ 
/*     */     
/*  73 */     int xsb = fastFloor(xs);
/*  74 */     int ysb = fastFloor(ys);
/*     */ 
/*     */     
/*  77 */     double squishOffset = (xsb + ysb) * 0.366025403784439D;
/*  78 */     double xb = xsb + squishOffset;
/*  79 */     double yb = ysb + squishOffset;
/*     */ 
/*     */     
/*  82 */     double xins = xs - xsb;
/*  83 */     double yins = ys - ysb;
/*     */ 
/*     */     
/*  86 */     double inSum = xins + yins;
/*     */ 
/*     */     
/*  89 */     double dx0 = x - xb;
/*  90 */     double dy0 = y - yb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     double value = 0.0D;
/*     */ 
/*     */     
/*  99 */     double dx1 = dx0 - 1.0D - 0.366025403784439D;
/* 100 */     double dy1 = dy0 - 0.0D - 0.366025403784439D;
/* 101 */     double attn1 = 2.0D - dx1 * dx1 - dy1 * dy1;
/* 102 */     if (attn1 > 0.0D) {
/* 103 */       attn1 *= attn1;
/* 104 */       value += attn1 * attn1 * extrapolate(xsb + 1, ysb + 0, dx1, dy1);
/*     */     } 
/*     */ 
/*     */     
/* 108 */     double dx2 = dx0 - 0.0D - 0.366025403784439D;
/* 109 */     double dy2 = dy0 - 1.0D - 0.366025403784439D;
/* 110 */     double attn2 = 2.0D - dx2 * dx2 - dy2 * dy2;
/* 111 */     if (attn2 > 0.0D) {
/* 112 */       attn2 *= attn2;
/* 113 */       value += attn2 * attn2 * extrapolate(xsb + 0, ysb + 1, dx2, dy2);
/*     */     } 
/*     */     
/* 116 */     if (inSum <= 1.0D) {
/* 117 */       double zins = 1.0D - inSum;
/* 118 */       if (zins > xins || zins > yins) {
/* 119 */         if (xins > yins) {
/* 120 */           xsv_ext = xsb + 1;
/* 121 */           ysv_ext = ysb - 1;
/* 122 */           dx_ext = dx0 - 1.0D;
/* 123 */           dy_ext = dy0 + 1.0D;
/*     */         } else {
/* 125 */           xsv_ext = xsb - 1;
/* 126 */           ysv_ext = ysb + 1;
/* 127 */           dx_ext = dx0 + 1.0D;
/* 128 */           dy_ext = dy0 - 1.0D;
/*     */         } 
/*     */       } else {
/* 131 */         xsv_ext = xsb + 1;
/* 132 */         ysv_ext = ysb + 1;
/* 133 */         dx_ext = dx0 - 1.0D - 0.732050807568878D;
/* 134 */         dy_ext = dy0 - 1.0D - 0.732050807568878D;
/*     */       } 
/*     */     } else {
/* 137 */       double zins = 2.0D - inSum;
/* 138 */       if (zins < xins || zins < yins) {
/* 139 */         if (xins > yins) {
/* 140 */           xsv_ext = xsb + 2;
/* 141 */           ysv_ext = ysb + 0;
/* 142 */           dx_ext = dx0 - 2.0D - 0.732050807568878D;
/* 143 */           dy_ext = dy0 + 0.0D - 0.732050807568878D;
/*     */         } else {
/* 145 */           xsv_ext = xsb + 0;
/* 146 */           ysv_ext = ysb + 2;
/* 147 */           dx_ext = dx0 + 0.0D - 0.732050807568878D;
/* 148 */           dy_ext = dy0 - 2.0D - 0.732050807568878D;
/*     */         } 
/*     */       } else {
/* 151 */         dx_ext = dx0;
/* 152 */         dy_ext = dy0;
/* 153 */         xsv_ext = xsb;
/* 154 */         ysv_ext = ysb;
/*     */       } 
/* 156 */       xsb++;
/* 157 */       ysb++;
/* 158 */       dx0 = dx0 - 1.0D - 0.732050807568878D;
/* 159 */       dy0 = dy0 - 1.0D - 0.732050807568878D;
/*     */     } 
/*     */ 
/*     */     
/* 163 */     double attn0 = 2.0D - dx0 * dx0 - dy0 * dy0;
/* 164 */     if (attn0 > 0.0D) {
/* 165 */       attn0 *= attn0;
/* 166 */       value += attn0 * attn0 * extrapolate(xsb, ysb, dx0, dy0);
/*     */     } 
/*     */ 
/*     */     
/* 170 */     double attn_ext = 2.0D - dx_ext * dx_ext - dy_ext * dy_ext;
/* 171 */     if (attn_ext > 0.0D) {
/* 172 */       attn_ext *= attn_ext;
/* 173 */       value += attn_ext * attn_ext * extrapolate(xsv_ext, ysv_ext, dx_ext, dy_ext);
/*     */     } 
/*     */     
/* 176 */     return value / 47.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   private double extrapolate(int xsb, int ysb, double dx, double dy) {
/* 181 */     int index = this.perm[this.perm[xsb & 0xFF] + ysb & 0xFF] & 0xE;
/* 182 */     return gradients2D[index] * dx + 
/* 183 */       gradients2D[index + 1] * dy;
/*     */   }
/*     */   
/*     */   private static int fastFloor(double x) {
/* 187 */     int xi = (int)x;
/* 188 */     return (x < xi) ? (xi - 1) : xi;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 193 */   private static byte[] gradients2D = new byte[] { 
/* 194 */       5, 2, 2, 5, 
/* 195 */       -5, 2, -2, 5, 
/* 196 */       5, -2, 2, -5, 
/* 197 */       -5, -2, -2, -5 };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\rnd\OpenSimplexNoise.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */