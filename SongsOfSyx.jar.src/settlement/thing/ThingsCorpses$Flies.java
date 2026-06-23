/*     */ package settlement.thing;
/*     */ 
/*     */ import game.GAME;
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Alloc;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Flies
/*     */ {
/* 269 */   private final int frames = 64;
/* 270 */   private final int flies = 64;
/* 271 */   private final int dim = 128;
/* 272 */   private final byte[] positions = Alloc.bb(8192);
/*     */ 
/*     */   
/*     */   Flies() {
/* 276 */     for (int f = 0; f < 64; f++) {
/* 277 */       int x = (int)(RND.rFloat0(1.0D) * RND.rFloat() * 128.0F);
/* 278 */       int y = (int)(RND.rFloat0(1.0D) * RND.rFloat() * 128.0F);
/* 279 */       double dx = (RND.rFloat() * 1.0F * (RND.rBoolean() ? true : -1));
/* 280 */       double dy = (RND.rFloat() * 1.0F * (RND.rBoolean() ? true : -1)); int k;
/* 281 */       for (k = 0; k <= 32; k++) {
/* 282 */         int i = f * 64 * 2 + k * 2;
/* 283 */         this.positions[i] = (byte)x;
/* 284 */         this.positions[i + 1] = (byte)y;
/* 285 */         x = (int)(x + RND.rInt0(3) + dx);
/* 286 */         y = (int)(y + RND.rInt0(3) + dy);
/* 287 */         dx += RND.rFloat0(1.0D);
/* 288 */         dy += RND.rFloat0(1.0D);
/* 289 */         if (x > 128)
/* 290 */           x -= 4; 
/* 291 */         if (y > 128)
/* 292 */           y -= 4; 
/*     */       } 
/* 294 */       for (k = 1; k < 32; k++) {
/* 295 */         int o = f * 64 * 2 + (32 - k) * 2;
/* 296 */         int n = f * 64 * 2 + (32 + k) * 2;
/* 297 */         this.positions[n] = this.positions[o];
/* 298 */         this.positions[n + 1] = this.positions[o + 1];
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void render(int ran, int amount, int x, int y) {
/* 305 */     if (amount <= 0)
/*     */       return; 
/* 307 */     COLOR.WHITE20.bind();
/* 308 */     ran &= 0x3F;
/* 309 */     for (int i = 0; i < amount; i++) {
/*     */       
/* 311 */       int k = ran * 64 * 2;
/* 312 */       k += (GAME.intervals().get20() + i * 20) % 64 * 2;
/* 313 */       CORE.renderer().renderParticle(x + this.positions[k], y + this.positions[k + 1]);
/*     */       
/* 315 */       ran++;
/* 316 */       ran &= 0x3F;
/*     */     } 
/*     */     
/* 319 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsCorpses$Flies.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */