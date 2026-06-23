/*    */ package world.map.regions.centre;
/*    */ 
/*    */ import snake2d.CORE;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.rnd.RND;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ 
/*    */ class Sparks
/*    */ {
/* 13 */   private static Sparks self = new Sparks();
/*    */   private static final int AMOUNT = 256;
/*    */   private static final int length = 128;
/*    */   private static final double duration = 10.0D;
/*    */   private static final double ticksPerTime = 12.8D;
/* 18 */   private final COLOR[] colors = new COLOR[256];
/* 19 */   private final byte[][] xs = new byte[128][256];
/* 20 */   private final byte[][] ys = new byte[128][256];
/* 21 */   private final byte[][] op = new byte[128][256];
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Sparks() {
/* 27 */     for (int i = 0; i < 256; i++) {
/* 28 */       this.colors[i] = (COLOR)(new ColorImp(60 + RND.rInt(20), 90 + RND.rInt0(20), 20 + RND.rInt(10))).shade(1.2D - RND.rExpo());
/*    */     }
/*    */     
/* 31 */     int aniLength = 25;
/*    */     
/* 33 */     for (int a = 0; a < 256; a++) {
/*    */       
/* 35 */       int current = RND.rInt(128);
/* 36 */       int tickCount = 25;
/* 37 */       double y = RND.rInt0(16);
/* 38 */       double x = RND.rInt0(16);
/*    */       
/* 40 */       double dvx = -0.05D * (80.0D + RND.rFloat(16.0D));
/* 41 */       double dvy = -0.05D * (80.0D + RND.rFloat(16.0D));
/*    */       
/* 43 */       double xsin = RND.rFloat(1.0D);
/* 44 */       double ysin = RND.rFloat(1.0D);
/* 45 */       double dsin = (RND.rFloat() / 128.0F);
/*    */       
/* 47 */       for (int t = 0; t < 128; t++) {
/* 48 */         tickCount--;
/* 49 */         if (tickCount < 0) {
/* 50 */           tickCount = 25;
/* 51 */           y = RND.rInt0(16);
/* 52 */           x = RND.rInt0(16);
/*    */         } 
/*    */         
/* 55 */         current %= 128;
/*    */ 
/*    */         
/* 58 */         this.op[current][a] = (byte)(int)(255.0D * (1.0D - t / 128.0D));
/* 59 */         this.xs[current][a] = (byte)(int)x;
/* 60 */         this.ys[current][a] = (byte)(int)y;
/*    */ 
/*    */         
/* 63 */         x += dvx * Math.sin(xsin);
/* 64 */         y += dvy * Math.sin(ysin);
/* 65 */         xsin += dsin;
/* 66 */         ysin += dsin;
/* 67 */         current++;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void render(int x, int y, int amount, int ran) {
/* 74 */     int t = (int)((VIEW.renderSecond() + ran / 10.0D) * 12.8D) & 0x7F;
/*    */ 
/*    */     
/* 77 */     for (int i = 0; i < amount; i++) {
/* 78 */       self.colors[ran + i & 0xFF].bind();
/* 79 */       CORE.renderer().renderParticle(x + self.xs[t][i], y + self.ys[t][i]);
/*    */     } 
/* 81 */     COLOR.unbind();
/* 82 */     OPACITY.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\Sparks.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */