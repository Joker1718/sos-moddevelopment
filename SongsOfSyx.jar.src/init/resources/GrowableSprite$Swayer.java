/*     */ package init.resources;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
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
/*     */ class Swayer
/*     */ {
/* 195 */   private final int am = 64;
/* 196 */   private final byte[] dx = Alloc.bb(64);
/* 197 */   private final byte[] dy = Alloc.bb(64);
/*     */   
/* 199 */   private final double[] dz = new double[64];
/* 200 */   private double[] ran = new double[64];
/*     */   
/*     */   double dd;
/*     */   
/* 204 */   private double lastSecond = 0.0D;
/*     */   
/*     */   Swayer() {
/* 207 */     for (int i = 0; i < 64; i++) {
/* 208 */       this.dx[i] = (byte)RND.rInt(16);
/* 209 */       this.dy[i] = (byte)RND.rInt(16);
/* 210 */       this.ran[i] = RND.rFloat() * Math.PI * 2.0D;
/* 211 */       this.dz[i] = 0.1D + 0.9D * RND.rFloat();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update() {
/* 218 */     if (TIME.currentSecond() == this.lastSecond) {
/*     */       return;
/*     */     }
/* 221 */     double ds = TIME.currentSecond() - this.lastSecond;
/* 222 */     this.lastSecond = TIME.currentSecond();
/*     */     
/* 224 */     this.dd += ds * Math.pow((SETT.WEATHER()).wind.getD(), 1.5D) * 4.0D;
/*     */     
/* 226 */     for (int i = 0; i < 64; i++) {
/* 227 */       double cos = Math.cos(this.dd + this.ran[i]);
/* 228 */       double a = this.dz[i] * 6.0D * cos;
/* 229 */       this.dx[i] = (byte)(int)a;
/* 230 */       this.dy[i] = (byte)(int)a;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\GrowableSprite$Swayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */