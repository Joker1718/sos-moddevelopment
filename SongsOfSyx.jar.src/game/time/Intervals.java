/*     */ package game.time;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ public final class Intervals
/*     */   extends GAME.GameResource
/*     */ {
/*  14 */   private double i20 = 0.0D;
/*  15 */   private double i15 = 0.0D;
/*  16 */   private double i10 = 0.0D;
/*  17 */   private double i08 = 0.0D;
/*  18 */   private double i05 = 0.0D;
/*     */   
/*  20 */   private double i04 = 0.0D;
/*  21 */   private double i02 = 0.0D;
/*  22 */   private double i01 = 0.0D;
/*  23 */   private double i005 = 0.0D;
/*  24 */   private double ran = 0.0D;
/*  25 */   private double[] rans = new double[128];
/*     */   
/*     */   public Intervals() {
/*  28 */     super("INTER", true);
/*  29 */     for (int i = 0; i < this.rans.length; i++) {
/*  30 */       this.rans[i] = 0.1D + RND.rFloat();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/*  36 */     this.i20 += ds * 20.0D;
/*  37 */     this.i15 += ds * 15.0D;
/*  38 */     this.i10 += ds * 10.0D;
/*  39 */     this.i08 += ds * 8.0D;
/*  40 */     this.i05 += ds * 5.0D;
/*     */     
/*  42 */     this.i04 += ds * 4.0D;
/*  43 */     this.i02 += ds * 2.0D;
/*  44 */     this.i01 += ds;
/*  45 */     this.i005 += ds * 0.5D;
/*     */     
/*  47 */     int ri = (int)this.ran & 0x7F;
/*  48 */     this.ran += this.rans[ri] * ds;
/*     */   }
/*     */   
/*     */   public int get20() {
/*  52 */     return (int)this.i20;
/*     */   }
/*     */   
/*     */   public int get15() {
/*  56 */     return (int)this.i15;
/*     */   }
/*     */   
/*     */   public int get05() {
/*  60 */     return (int)this.i05;
/*     */   }
/*     */   
/*     */   public int get08() {
/*  64 */     return (int)this.i08;
/*     */   }
/*     */   
/*     */   public int get04() {
/*  68 */     return (int)this.i04;
/*     */   }
/*     */   
/*     */   public int get02() {
/*  72 */     return (int)this.i02;
/*     */   }
/*     */   
/*     */   public int get01() {
/*  76 */     return (int)this.i01;
/*     */   }
/*     */   
/*     */   public int get005() {
/*  80 */     return (int)this.i005;
/*     */   }
/*     */   
/*     */   public int get10() {
/*  84 */     return (int)this.i10;
/*     */   }
/*     */ 
/*     */   
/*     */   public double circle(double speed) {
/*  89 */     return circle(this.i01, speed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double circle(double second, double speed) {
/*  95 */     double d = speed * second;
/*  96 */     d -= (int)d;
/*     */     
/*  98 */     if (d < 0.5D) {
/*  99 */       return d * 2.0D;
/*     */     }
/* 101 */     return 1.0D - (d - 0.5D) * 2.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double circlePow(double second, double speed) {
/* 107 */     double d = speed * second;
/* 108 */     d -= (int)d;
/*     */     
/* 110 */     if (d < 0.5D) {
/* 111 */       return Math.pow(d * 2.0D, 2.0D);
/*     */     }
/* 113 */     return 1.0D - Math.pow((d - 0.5D) * 2.0D, 2.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public int ran(double speed, int ran) {
/* 118 */     int t = (int)(((ran & 0xFF) / 16.0D + this.ran) * speed);
/* 119 */     return t;
/*     */   }
/*     */   
/*     */   public int ranC(double speed, int ran, int max) {
/* 123 */     int t = ran(speed, ran);
/* 124 */     t %= max * 2;
/* 125 */     if (t > max) {
/* 126 */       t = max * 2 - t;
/*     */     }
/* 128 */     return t;
/*     */   }
/*     */   
/*     */   public static int get(double speed) {
/* 132 */     return (int)(GAME.intervals().get01() * speed);
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) {}
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\Intervals.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */