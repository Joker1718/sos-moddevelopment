/*     */ package settlement.room.service.hygine.well;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.ShadowBatch;
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
/*     */ class Founatain
/*     */ {
/* 263 */   private final int AM = 64;
/*     */   
/* 265 */   private byte[] xs = Alloc.bb(64);
/* 266 */   private byte[] ys = Alloc.bb(64);
/* 267 */   private double[] rans = new double[64];
/* 268 */   private COLOR[] cols = new COLOR[64];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Founatain() {
/* 274 */     for (int i = 0; i < 64; i++) {
/* 275 */       double rad = RND.rFloat() * Math.PI * 0.5D;
/* 276 */       double dx = Math.cos(rad);
/* 277 */       double dy = Math.sin(rad);
/* 278 */       this.xs[i] = (byte)(int)(dx * (16.0F + RND.rFloat() * 64.0F));
/* 279 */       this.ys[i] = (byte)(int)(dy * (16.0F + RND.rFloat() * 64.0F));
/* 280 */       this.rans[i] = (RND.rInt(128) + RND.rFloat());
/*     */     } 
/*     */     
/* 283 */     this.cols = (COLOR[])COLOR.interpolate((COLOR)new ColorImp(20, 60, 127), COLOR.WHITE100, 64);
/*     */   }
/*     */ 
/*     */   
/*     */   void render(SPRITE_RENDERER r, ShadowBatch s, int cx, int cy) {
/* 288 */     double time = TIME.currentSecond() * 1.5D;
/* 289 */     render(r, s, cx, cy, time, 1, 1);
/* 290 */     time += 0.3D;
/* 291 */     render(r, s, cx - 4, cy, time, -1, 1);
/* 292 */     time += 0.3D;
/* 293 */     render(r, s, cx, cy - 4, time, 1, -1);
/* 294 */     time += 0.3D;
/* 295 */     render(r, s, cx - 4, cy - 4, time, -1, -1);
/*     */   }
/*     */   void render(SPRITE_RENDERER r, ShadowBatch s, int cx, int cy, double time, int dx, int dy) {
/* 298 */     int a = 64;
/* 299 */     if (TIME.light().nightIs()) {
/* 300 */       a = (int)(a * (1.0D - TIME.light().partOf() * 10.0D));
/*     */     }
/* 302 */     for (int i = 0; i < a; i++) {
/* 303 */       double d = this.rans[i] + time;
/* 304 */       int k = (int)d;
/* 305 */       d -= k;
/* 306 */       int x = (int)(this.xs[i] * d);
/* 307 */       int y = (int)(this.ys[i] * d);
/* 308 */       this.cols[k & 0x3F].bind();
/* 309 */       CORE.renderer().renderParticle(cx + x * dx, cy + y * dy);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\well\Constructor$Founatain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */