/*     */ package init.resources;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ final class Pollen
/*     */ {
/*     */   private static final int ticks = 128;
/*     */   private static final int tmask = 127;
/*     */   private static final int amount = 8;
/*     */   private static final double time = 5.0D;
/*     */   private static final double ticksPerTime = 25.6D;
/* 246 */   private final byte[][] xs = new byte[128][8];
/* 247 */   private final byte[][] ys = new byte[128][8];
/*     */ 
/*     */   
/*     */   private Pollen() {
/* 251 */     for (int a = 0; a < 8; a++) {
/*     */       
/* 253 */       double dvx = -(96.0D + RND.rFloat(96.0D));
/* 254 */       double dvy = 96.0D + RND.rFloat0(24.0D);
/* 255 */       dvx /= 128.0D;
/* 256 */       dvy /= 128.0D;
/* 257 */       double y = RND.rInt(64);
/* 258 */       double x = RND.rInt(32);
/*     */       
/* 260 */       int tStart = RND.rInt(128);
/*     */       
/* 262 */       double xsin = RND.rFloat(1.0D);
/* 263 */       double ysin = RND.rFloat(1.0D);
/* 264 */       double dsin = (RND.rFloat() / 128.0F);
/*     */       
/* 266 */       for (int t = 0; t < 128; t++) {
/*     */         
/* 268 */         this.xs[tStart][a] = (byte)(int)x;
/* 269 */         this.ys[tStart][a] = (byte)(int)y;
/* 270 */         x += dvx * Math.sin(xsin);
/* 271 */         y += dvy * Math.sin(ysin);
/* 272 */         xsin += dsin;
/* 273 */         ysin += dsin;
/* 274 */         tStart++;
/* 275 */         tStart &= 0x7F;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void render(int x, int y, int a) {
/* 281 */     int t = (int)(((SETT.WEATHER()).wind.time.getD() * 8.0D + TIME.currentSecond() * 0.5D) * 25.6D);
/* 282 */     t &= 0x7F;
/* 283 */     a = CLAMP.i(a, 0, 8);
/* 284 */     for (int i = 0; i < a; i++)
/* 285 */       CORE.renderer().renderParticle(x + this.xs[t][i], y + this.ys[t][i]); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\GrowableSprite$Pollen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */