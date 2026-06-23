/*     */ package settlement.thing.pointlight;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ public class FireSparks
/*     */ {
/*  11 */   private static FireSparks self = new FireSparks();
/*     */   private static final int AMOUNT = 256;
/*     */   private static final int length = 128;
/*     */   private static final double duration = 5.0D;
/*     */   private static final double ticksPerTime = 25.6D;
/*  16 */   private final COLOR[] colors = new COLOR[256];
/*  17 */   private final byte[][] xs = new byte[128][256];
/*  18 */   private final byte[][] ys = new byte[128][256];
/*  19 */   private double ani = RND.rInt();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FireSparks() {
/*  25 */     for (int i = 0; i < 256; i++) {
/*  26 */       this.colors[i] = (COLOR)(new ColorImp(110 + RND.rInt0(20), 80 + RND.rInt(10), 20 + RND.rInt(10))).shade(1.2D - RND.rExpo());
/*     */     }
/*     */     
/*  29 */     int aniLength = 25;
/*     */     
/*  31 */     for (int a = 0; a < 256; a++) {
/*     */       
/*  33 */       int current = RND.rInt(128);
/*  34 */       int tickCount = 25;
/*  35 */       double y = RND.rInt0(16);
/*  36 */       double x = RND.rInt0(16);
/*     */       
/*  38 */       double dvx = -0.05D * (80.0D + RND.rFloat(16.0D));
/*  39 */       double dvy = 0.05D * (80.0D + RND.rFloat(16.0D));
/*     */       
/*  41 */       double xsin = RND.rFloat(1.0D);
/*  42 */       double ysin = RND.rFloat(1.0D);
/*  43 */       double dsin = (RND.rFloat() / 128.0F);
/*     */ 
/*     */       
/*  46 */       for (int t = 0; t < 128; t++) {
/*  47 */         tickCount--;
/*  48 */         if (tickCount < 0) {
/*  49 */           tickCount = 25;
/*  50 */           y = RND.rInt0(16);
/*  51 */           x = RND.rInt0(16);
/*     */         } 
/*     */         
/*  54 */         current %= 128;
/*     */ 
/*     */ 
/*     */         
/*  58 */         this.xs[current][a] = (byte)(int)x;
/*  59 */         this.ys[current][a] = (byte)(int)y;
/*     */ 
/*     */         
/*  62 */         x += dvx * Math.sin(xsin);
/*  63 */         y += dvy * Math.sin(ysin);
/*  64 */         xsin += dsin;
/*  65 */         ysin += dsin;
/*  66 */         current++;
/*     */       } 
/*     */     } 
/*     */   }
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
/*     */   static void update(float ds) {
/*  84 */     self.ani += ds * 25.6D;
/*     */   }
/*     */   
/*     */   public static void render(int x, int y, int amount, int ran, double wind) {
/*  88 */     render(self.ani, x, y, amount, ran, wind);
/*     */   }
/*     */   
/*     */   public static void render(double ani, int x, int y, int amount, int ran, double wind) {
/*  92 */     int t = (int)ani & 0x7F;
/*     */     
/*  94 */     double d = 0.5D + 0.5D * wind;
/*     */     
/*  96 */     for (int i = 0; i < amount; i++) {
/*  97 */       self.colors[ran + i & 0xFF].bind();
/*  98 */       CORE.renderer().renderParticle(x + (int)(self.xs[t][i] * d), y + (int)(self.ys[t][i] * d));
/*     */     } 
/* 100 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\FireSparks.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */