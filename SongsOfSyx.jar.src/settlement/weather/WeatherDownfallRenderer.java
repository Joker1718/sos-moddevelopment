/*     */ package settlement.weather;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.settings.S;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.RGB;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class WeatherDownfallRenderer
/*     */ {
/*  19 */   private static int amount = 256;
/*  20 */   private static int squareSize = 512;
/*     */   
/*     */   private static final int speedMax = 600;
/*  23 */   private double speedAcc = (RND.rFloat() * 10000.0F);
/*  24 */   private final Drops drops = new Drops();
/*     */   
/*  26 */   private final Off[][] offs = new Off[16][16];
/*     */   
/*  28 */   private final SkyLayer[] layers = new SkyLayer[] { new SkyLayer(), new SkyLayer(), new SkyLayer(), new SkyLayer() };
/*     */ 
/*     */   
/*     */   public WeatherDownfallRenderer() {
/*  32 */     for (int i = 0; i < this.offs.length; i++) {
/*  33 */       for (int k = 0; k < this.offs.length; k++) {
/*  34 */         this.offs[i][k] = new Off();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Renderer r, float ds, RenderData data, int zoomout) {
/*  41 */     double rain = (SETT.WEATHER()).rain.getD();
/*     */ 
/*     */ 
/*     */     
/*  45 */     if (rain <= 0.0D) {
/*     */       return;
/*     */     }
/*  48 */     COLOR[] cs = this.drops.colors;
/*  49 */     boolean snow = (SETT.WEATHER()).snow.rainIsSnow();
/*  50 */     if (snow) {
/*  51 */       cs = this.drops.colorsSnow;
/*  52 */       this.speedAcc += ds * (1.0D + 600.0D * (SETT.WEATHER()).wind.getD());
/*     */     } else {
/*  54 */       this.speedAcc += 1.5D * ds * (300.0D + 600.0D * (SETT.WEATHER()).wind.getD());
/*     */     } 
/*  56 */     if (this.speedAcc < 0.0D) {
/*  57 */       this.speedAcc = 0.0D;
/*     */     }
/*  59 */     rain *= rain;
/*     */     
/*  61 */     int am = (int)Math.ceil(32.0D * rain);
/*  62 */     int smask = this.offs.length - 1;
/*  63 */     int amask = amount - 1;
/*  64 */     int cmask = (amount >> 1) - 1;
/*  65 */     int zs = 1;
/*  66 */     int ze = 2;
/*  67 */     if ((S.get()).graphics.get() == 0) {
/*  68 */       ze = 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     if (am < 0) {
/*     */       return;
/*     */     }
/*  80 */     int snowI = (int)(TIME.currentSecond() * amount / 4.0D);
/*     */     
/*  82 */     for (int z = zs; z <= ze; z++) {
/*  83 */       r.newLayer(false, z);
/*     */       
/*  85 */       ZoomLayer.init(data, zoomout, z);
/*  86 */       TIME.light().apply(ZoomLayer.absX1, ZoomLayer.absX2, ZoomLayer.absY1, ZoomLayer.absY2, RGB.WHITE);
/*     */       
/*  88 */       for (int li = 0; li < this.layers.length; li++) {
/*  89 */         this.layers[li].init(data, zoomout, z, 1.1D + 0.15D * li);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  96 */       for (int sy = 0; sy < (this.layers[0]).sqIH; sy++) {
/*  97 */         for (int sx = 0; sx < (this.layers[0]).sqIW; sx++) {
/*     */           
/*  99 */           int ranI = 0; byte b; int i; SkyLayer[] arrayOfSkyLayer;
/* 100 */           for (i = (arrayOfSkyLayer = this.layers).length, b = 0; b < i; ) { SkyLayer l = arrayOfSkyLayer[b];
/* 101 */             int startX = l.sqStartX + sx * squareSize;
/* 102 */             int startY = l.sqStartY + sy * squareSize;
/* 103 */             Off off = this.offs[l.sqIX + sx & smask][l.sqIY + sy & smask];
/* 104 */             for (int j = 0; j < am; j++) {
/*     */               
/* 106 */               int ra = j + ranI + off.offR & amask;
/* 107 */               int px = (int)(this.drops.dx[ra] * this.speedAcc) + off.offX;
/* 108 */               int py = (int)(this.drops.dy[ra] * this.speedAcc) + off.offY;
/* 109 */               px &= squareSize - 1;
/* 110 */               px = -px;
/* 111 */               py &= squareSize - 1;
/* 112 */               px += this.drops.sx[ra];
/* 113 */               py += this.drops.sy[ra];
/*     */               
/* 115 */               px += startX;
/* 116 */               py += startY;
/*     */               
/* 118 */               if (snow) {
/* 119 */                 px += this.drops.snowX[this.drops.snowI[ra] + snowI & amask];
/* 120 */                 py += this.drops.snowY[this.drops.snowI[ra + 1 & amask] + snowI & amask];
/*     */               } 
/*     */               
/* 123 */               if (px >= ZoomLayer.absX1 && py >= ZoomLayer.absY1 && px < ZoomLayer.absX2 && py <= ZoomLayer.absY2) {
/*     */                 
/* 125 */                 int tx = ZoomLayer.gx1 + (px << zoomout >> z) >> 6;
/* 126 */                 int ty = ZoomLayer.gy1 + (py << zoomout >> z) >> 6;
/* 127 */                 if (!SETT.TERRAIN().get(tx, ty).roofIs() && !SETT.TERRAIN().get(tx, ty).coversCompletely(tx, ty)) {
/*     */                   
/* 129 */                   cs[ra & cmask].bind();
/* 130 */                   CORE.renderer().renderParticle(px, py);
/* 131 */                   if (!snow)
/* 132 */                     CORE.renderer().renderParticle(px + CORE.renderer().pointsize(), py - CORE.renderer().pointsize()); 
/*     */                 } 
/*     */               } 
/*     */             } 
/* 136 */             ranI += 64;
/*     */             
/*     */             b++; }
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/* 143 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   private static class ZoomLayer { private static int absX1;
/*     */     private static int absY1;
/*     */     private static int absX2;
/*     */     private static int absY2;
/*     */     private static int gx1;
/*     */     private static int gy1;
/*     */     
/*     */     static void init(RenderData data, int zoomout, int z) {
/* 154 */       absX1 = data.absBounds().x1() >> zoomout << z;
/* 155 */       absY1 = data.absBounds().y1() >> zoomout << z;
/* 156 */       absX2 = data.absBounds().x2() >> zoomout << z;
/* 157 */       absY2 = data.absBounds().y2() >> zoomout << z;
/*     */ 
/*     */       
/* 160 */       gx1 = data.gBounds().x1() - data.absBounds().x1();
/* 161 */       gy1 = data.gBounds().y1() - data.absBounds().y1();
/*     */       
/* 163 */       if (data.gBounds().x1() < 0) {
/* 164 */         absX1 += -(data.gBounds().x1() >> zoomout << z);
/*     */       }
/* 166 */       if (data.gBounds().y1() < 0) {
/* 167 */         absY1 += -(data.gBounds().y1() >> zoomout << z);
/*     */       }
/* 169 */       if (data.gBounds().x2() > SETT.PWIDTH) {
/* 170 */         absX2 -= data.gBounds().x2() - SETT.PWIDTH >> zoomout << z;
/*     */       }
/* 172 */       if (data.gBounds().y2() > SETT.PHEIGHT)
/* 173 */         absY2 -= data.gBounds().y2() - SETT.PHEIGHT >> zoomout << z; 
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class SkyLayer {
/*     */     private int sqStartX;
/*     */     private int sqStartY;
/*     */     private int sqIX;
/*     */     private int sqIY;
/*     */     private int sqIW;
/*     */     private int sqIH;
/*     */     
/*     */     void init(RenderData data, int zoomout, int z, double skyzoom) {
/* 186 */       int skyX = (int)((data.gBounds().x1() + SETT.PWIDTH / 2) * skyzoom);
/* 187 */       int skyY = (int)((data.gBounds().y1() + SETT.PHEIGHT / 2) * skyzoom);
/*     */ 
/*     */       
/* 190 */       this.sqIX = skyX / WeatherDownfallRenderer.squareSize;
/* 191 */       this.sqIY = skyY / WeatherDownfallRenderer.squareSize;
/* 192 */       this.sqStartX = skyX % WeatherDownfallRenderer.squareSize;
/* 193 */       this.sqStartY = skyY % WeatherDownfallRenderer.squareSize;
/* 194 */       this.sqStartX = WeatherDownfallRenderer.ZoomLayer.absX1 - this.sqStartX;
/* 195 */       this.sqStartY = WeatherDownfallRenderer.ZoomLayer.absY1 - this.sqStartY;
/*     */ 
/*     */       
/* 198 */       this.sqIW = (int)Math.ceil((WeatherDownfallRenderer.squareSize / 2.0D + WeatherDownfallRenderer.ZoomLayer.absX2 - this.sqStartX) / WeatherDownfallRenderer.squareSize);
/* 199 */       this.sqIH = (int)Math.ceil((WeatherDownfallRenderer.squareSize / 2.0D + WeatherDownfallRenderer.ZoomLayer.absY2 - this.sqStartY) / WeatherDownfallRenderer.squareSize);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final class Off
/*     */   {
/* 209 */     private final int offX = RND.rInt(WeatherDownfallRenderer.squareSize);
/* 210 */     private final int offY = RND.rInt(WeatherDownfallRenderer.squareSize);
/* 211 */     private final int offR = RND.rInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Drops
/*     */   {
/* 219 */     private byte[] snowI = Alloc.bb(WeatherDownfallRenderer.amount);
/* 220 */     private byte[] snowX = Alloc.bb(WeatherDownfallRenderer.amount);
/* 221 */     private byte[] snowY = Alloc.bb(WeatherDownfallRenderer.amount);
/* 222 */     private COLOR[] colors = new COLOR[WeatherDownfallRenderer.amount >> 1];
/* 223 */     private COLOR[] colorsSnow = new COLOR[WeatherDownfallRenderer.amount >> 1];
/* 224 */     private double[] dx = new double[WeatherDownfallRenderer.amount];
/* 225 */     private double[] dy = new double[WeatherDownfallRenderer.amount];
/* 226 */     private short[] sx = new short[WeatherDownfallRenderer.amount];
/* 227 */     private short[] sy = new short[WeatherDownfallRenderer.amount];
/*     */     
/*     */     Drops() {
/*     */       int i;
/* 231 */       for (i = 0; i < WeatherDownfallRenderer.amount; i++) {
/* 232 */         this.dx[i] = 0.5D + RND.rFloat() * 0.5D;
/* 233 */         this.dy[i] = 0.5D + RND.rFloat() * 0.5D;
/* 234 */         this.sx[i] = RND.rShort(WeatherDownfallRenderer.squareSize);
/* 235 */         this.sy[i] = RND.rShort(WeatherDownfallRenderer.squareSize);
/*     */       } 
/*     */       
/* 238 */       for (i = 0; i < this.colors.length; i++) {
/* 239 */         int rg = 40 + RND.rInt(35);
/* 240 */         rg += 10;
/* 241 */         this.colors[i] = (COLOR)new ColorImp(rg, rg, rg + 20 + RND.rInt(30));
/*     */       } 
/*     */       
/* 244 */       for (i = 0; i < this.colorsSnow.length; i++) {
/* 245 */         int rg = 100 + RND.rInt(28);
/* 246 */         this.colorsSnow[i] = (COLOR)new ColorImp(rg, rg, rg);
/*     */       } 
/*     */       
/* 249 */       for (i = 0; i < WeatherDownfallRenderer.amount; i++) {
/* 250 */         double d = i;
/* 251 */         d /= WeatherDownfallRenderer.amount;
/* 252 */         d *= 6.283185307179586D;
/* 253 */         this.snowI[i] = (byte)RND.rInt();
/* 254 */         this.snowX[i] = (byte)(int)(64.0D * Math.cos(d));
/* 255 */         this.snowY[i] = (byte)(int)(64.0D * Math.cos(d + Math.PI));
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherDownfallRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */