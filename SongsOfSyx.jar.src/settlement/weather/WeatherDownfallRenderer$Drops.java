/*     */ package settlement.weather;
/*     */ 
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
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
/*     */ class Drops
/*     */ {
/* 219 */   private byte[] snowI = Alloc.bb(WeatherDownfallRenderer.amount);
/* 220 */   private byte[] snowX = Alloc.bb(WeatherDownfallRenderer.amount);
/* 221 */   private byte[] snowY = Alloc.bb(WeatherDownfallRenderer.amount);
/* 222 */   private COLOR[] colors = new COLOR[WeatherDownfallRenderer.amount >> 1];
/* 223 */   private COLOR[] colorsSnow = new COLOR[WeatherDownfallRenderer.amount >> 1];
/* 224 */   private double[] dx = new double[WeatherDownfallRenderer.amount];
/* 225 */   private double[] dy = new double[WeatherDownfallRenderer.amount];
/* 226 */   private short[] sx = new short[WeatherDownfallRenderer.amount];
/* 227 */   private short[] sy = new short[WeatherDownfallRenderer.amount];
/*     */   
/*     */   Drops() {
/*     */     int i;
/* 231 */     for (i = 0; i < WeatherDownfallRenderer.amount; i++) {
/* 232 */       this.dx[i] = 0.5D + RND.rFloat() * 0.5D;
/* 233 */       this.dy[i] = 0.5D + RND.rFloat() * 0.5D;
/* 234 */       this.sx[i] = RND.rShort(WeatherDownfallRenderer.squareSize);
/* 235 */       this.sy[i] = RND.rShort(WeatherDownfallRenderer.squareSize);
/*     */     } 
/*     */     
/* 238 */     for (i = 0; i < this.colors.length; i++) {
/* 239 */       int rg = 40 + RND.rInt(35);
/* 240 */       rg += 10;
/* 241 */       this.colors[i] = (COLOR)new ColorImp(rg, rg, rg + 20 + RND.rInt(30));
/*     */     } 
/*     */     
/* 244 */     for (i = 0; i < this.colorsSnow.length; i++) {
/* 245 */       int rg = 100 + RND.rInt(28);
/* 246 */       this.colorsSnow[i] = (COLOR)new ColorImp(rg, rg, rg);
/*     */     } 
/*     */     
/* 249 */     for (i = 0; i < WeatherDownfallRenderer.amount; i++) {
/* 250 */       double d = i;
/* 251 */       d /= WeatherDownfallRenderer.amount;
/* 252 */       d *= 6.283185307179586D;
/* 253 */       this.snowI[i] = (byte)RND.rInt();
/* 254 */       this.snowX[i] = (byte)(int)(64.0D * Math.cos(d));
/* 255 */       this.snowY[i] = (byte)(int)(64.0D * Math.cos(d + Math.PI));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherDownfallRenderer$Drops.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */