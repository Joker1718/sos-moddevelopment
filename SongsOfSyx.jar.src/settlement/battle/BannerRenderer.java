/*     */ package settlement.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.VECTOR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public class BannerRenderer
/*     */ {
/*  26 */   private final ArrayList<Humanoid> bannerMen = new ArrayList(512);
/*     */   
/*  28 */   int period = 64;
/*  29 */   int periods = 16;
/*  30 */   int totL = this.period * this.periods;
/*  31 */   int totM = this.totL - 1;
/*     */   
/*  33 */   private final VectorImp vec = new VectorImp();
/*     */   
/*  35 */   private final int[] divSwayOff = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY * 2);
/*  36 */   private final int[] divLength = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY * 2);
/*  37 */   private final double[] winDir = new double[this.totL];
/*     */   
/*  39 */   private final byte[] offX = Alloc.bb(this.totL);
/*  40 */   private final double[] width = new double[this.totL];
/*     */   
/*  42 */   private byte[] nx = Alloc.bb(this.totL);
/*  43 */   private byte[] ny = Alloc.bb(this.totL);
/*  44 */   private byte[] nz = Alloc.bb(this.totL);
/*  45 */   private final byte na = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ColorImp col;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Rec bounds;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BannerRenderer() {
/* 132 */     this.col = new ColorImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     this.bounds = new Rec(); for (int pi = 0; pi < this.periods; pi++) { double h = (16.0F + RND.rFloat() * 24.0F); for (int k = 0; k < this.period; k++) { double d = k * 4.0D * Math.PI / this.period; this.offX[pi * this.period + k] = (byte)(int)(h * Math.sin(d)); double dn = 1.0D + Math.cos(d); this.vec.setAngle(dn); double nx = this.vec.nX(); double ny = this.vec.nY(); double nz = 1.0D; double l = Math.sqrt(nx * nx + ny * ny + nz * nz); nx /= l; ny /= l; nz /= l; this.nx[pi * this.period + k] = (byte)(int)(128.0D + 127.0D * nx); this.ny[pi * this.period + k] = (byte)(int)(128.0D + 127.0D * ny); this.nz[pi * this.period + k] = (byte)(int)(128.0D + 127.0D * nz); }  }  int i; for (i = 0; i < this.totL; i++) { int l = 16 + RND.rInt(this.period - 16); double h = RND.rFloat(4.0D); for (int k = 0; k < l && i < this.totL; k++) { double d = k / l; d = (Math.sin(d * Math.PI * 2.0D - 1.5707963267948966D) + 1.0D) / 2.0D; this.width[i] = h * d; i++; }  }  for (i = 0; i < this.period / 2; i++) { double d = i / this.period * 0.5D; this.width[this.totL - 1 - i] = (byte)(int)(this.width[this.totL - 1 - i] * d + this.width[0] * (1.0D - d)); }  for (i = 0; i < this.divSwayOff.length; i++) { this.divSwayOff[i] = RND.rInt(); this.divLength[i] = this.period / 4 + RND.rInt(this.period / 2); }  this.winDir[0] = 0.0D; double max = 0.1D + RND.rFloat(); double sp = 0.1D + RND.rFloat() * 0.1D; int j; for (j = 1; j < this.winDir.length; j++) { double n = this.winDir[j - 1] + sp; if (n <= 0.0D) { n = -n; max = 0.1D + RND.rFloat(); sp = 0.05D + RND.rFloat() * 0.05D; }
/*     */       else if (n >= max) { n = max - n - max; sp = -(0.05D + RND.rFloat() * 0.05D); }
/*     */        this.winDir[j] = n; }
/* 231 */      for (j = 0; j < this.nx.length; j++); } public void render(Renderer r, ShadowBatch s, float ds, RECTANGLE gamePixels, int offX, int offY) { s.setDistance2Ground(12.0D);
/* 232 */     s.setHeight(2);
/*     */     
/* 234 */     int offXs = offX - gamePixels.x1();
/* 235 */     int offYs = offY - gamePixels.y1();
/*     */     
/* 237 */     this.bounds.set(gamePixels);
/* 238 */     this.bounds.incr(offXs, offYs);
/*     */ 
/*     */ 
/*     */     
/* 242 */     for (Humanoid a : this.bannerMen) {
/*     */       
/* 244 */       if (a.isRemoved()) {
/*     */         continue;
/*     */       }
/* 247 */       Div d = a.division();
/*     */       
/* 249 */       if (d == null) {
/*     */         continue;
/*     */       }
/* 252 */       int x = a.body().cX() + offXs;
/* 253 */       int y = a.body().cY() + offYs;
/*     */       
/* 255 */       render(r, s, x, y, d, (VECTOR)a.speed, STATS.RAN().get(a.indu(), 8, 16), this.bounds);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     COLOR.unbind();
/* 268 */     this.bannerMen.clearSloppy(); }
/*     */ 
/*     */   
/*     */   void render(Renderer r, ShadowBatch s, int x, int y, Div div, VECTOR speed, int rran, Rec bounds) {
/*     */     x = (int)(x + speed.dir().xN() * 12.0D);
/*     */     y = (int)(y - speed.dir().yN() * 12.0D);
/*     */     COLOR.BROWN.bind();
/*     */     (SPRITES.cons()).BIG.line.render((SPRITE_RENDERER)r, 0, x - 32, y - 32);
/*     */     (SPRITES.cons()).BIG.line.render((SPRITE_RENDERER)s, 0, x - 32, y - 32);
/*     */     int ranoff = this.divSwayOff[div.index()] + rran;
/*     */     this.col.set((COLOR)(div.info.banner()).col);
/*     */     this.col.shadeSelf(0.75D + 0.5D * (rran >> 8 & 0xFF) / 255.0D);
/*     */     this.col.bind();
/*     */     double w = (SETT.WEATHER()).wind.getD();
/*     */     double wi = 1.0D - w;
/*     */     int si = ranoff + (int)(10.0D * TIME.currentSecond());
/*     */     double wd = this.winDir[si & this.totM];
/*     */     double xx = 0.5D - wi * (wd * 0.4D - 0.2D);
/*     */     double dx = -xx;
/*     */     double dy = 1.0D - xx;
/*     */     dx *= 64.0D * w * 6.0D;
/*     */     dy *= 64.0D * w * 6.0D;
/*     */     dx -= speed.x();
/*     */     dy -= speed.y();
/*     */     w = this.vec.set(dx, dy) / 384.0D;
/*     */     w = CLAMP.d(w, 0.0D, 1.0D);
/*     */     w = 0.4D + 0.6D * w;
/*     */     wi = 1.0D - w;
/*     */     int startI = ranoff + (int)(80.0D * TIME.currentSecond());
/*     */     int length = this.divLength[div.index()];
/*     */     int lll = 0;
/*     */     for (int k = -2; k <= 2; k++) {
/*     */       int ll = length - lll;
/*     */       lll++;
/*     */       for (int i = 0; i < ll; i++) {
/*     */         double d = i / length;
/*     */         int oi = (int)(startI - i * wi * 2.0D);
/*     */         oi &= this.totM;
/*     */         int rx = (int)(x + w * this.vec.nX() * i * 4.0D);
/*     */         int ry = (int)(y + w * this.vec.nY() * i * 4.0D);
/*     */         rx = (int)(rx + -this.vec.nY() * wi * d * this.offX[oi]);
/*     */         ry = (int)(ry + this.vec.nX() * wi * d * this.offX[oi]);
/*     */         double dh = this.width[oi];
/*     */         int ni = i * this.period + k + (int)(this.vec.nX() * 16.0D) & this.totM;
/*     */         int j = (int)(dh * 1.0D * k * this.vec.nX());
/*     */         int m = (int)(dh * 1.0D * k * this.vec.nY());
/*     */         int px = rx - m;
/*     */         int py = ry + j;
/*     */         if (bounds.holdsPoint(px, py)) {
/*     */           r.renderParticle(px, py, this.nx[ni], this.ny[ni], this.nz[ni], (byte)-1);
/*     */           if (k == 0)
/*     */             (SPRITES.icons()).s.dot.renderC((SPRITE_RENDERER)s, rx - m, ry + j); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void regBannerman(Humanoid h) {
/*     */     if (this.bannerMen.hasRoom())
/*     */       this.bannerMen.add(h); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\BannerRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */