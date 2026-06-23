/*     */ package init.resources;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.Sheet;
/*     */ import init.sprite.game.SheetData;
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import java.util.HashMap;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ public final class GrowableSprite
/*     */ {
/*  35 */   private static final Swayer swayer = new Swayer();
/*  36 */   private static final Pollen[] pollen = new Pollen[79];
/*  37 */   private static int SET = 16;
/*     */   
/*  39 */   private static final Positions[] poss = new Positions[] { new Positions(0, 0), new Positions(16, 0), new Positions(0, 16) };
/*     */   private final TILE_SHEET sheet;
/*     */   
/*     */   static {
/*  43 */     for (int i = 0; i < pollen.length; i++) {
/*  44 */       pollen[i] = new Pollen();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final double wind;
/*     */ 
/*     */   
/*     */   private final double poll;
/*     */   
/*  55 */   private final COLOR[] cpollen = new COLOR[79];
/*     */   
/*  57 */   public final Part trunk = new Part(SET, 0.8D);
/*  58 */   public final Part growth = new Part(0, 1.0D);
/*     */   private static final double ri = 0.16666666666666666D;
/*     */   
/*     */   public GrowableSprite(String ssheet, double wind, double pollen, KeyMap<TILE_SHEET> sheetMap) throws IOException {
/*  62 */     if (!sheetMap.containsKey(ssheet)) {
/*  63 */       TILE_SHEET sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE().getFolder("resource").getFolder("growable").get(ssheet), 460, 34)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/*  67 */             s.singles.init(0, 0, 1, 1, 16, 2, (ComposerDests.Dest)d.s8);
/*  68 */             s.singles.paste(true);
/*  69 */             return d.s8.saveGame();
/*     */           }
/*  71 */         }).get();
/*  72 */       sheetMap.put(ssheet, sheet);
/*     */     } 
/*  74 */     this.sheet = (TILE_SHEET)sheetMap.get(ssheet);
/*     */     
/*  76 */     this.wind = wind;
/*  77 */     this.poll = pollen;
/*  78 */     setPollenColor((COLOR)new ColorImp(107, 107, 107));
/*     */   }
/*     */   
/*     */   public void setPollenColor(COLOR color) {
/*  82 */     for (int i = 0; i < this.cpollen.length; i++) {
/*  83 */       ColorImp col = new ColorImp();
/*  84 */       for (int c = 0; c < 3; c++)
/*  85 */         col.setComp(c, CLAMP.i(color.getComp(c) - RND.rInt(15), 0, color.getComp(c))); 
/*  86 */       this.cpollen[i] = (COLOR)col;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, double size, double tops) {
/*  93 */     i.countVegetation();
/*     */     
/*  95 */     double m = CLAMP.d((SETT.WEATHER()).moisture.getD() * 4.0D, 0.0D, 1.0D);
/*  96 */     double growth = (SETT.WEATHER()).growth.getD() * m * (2.0D + (i.ran() & 0x3));
/*  97 */     double ripe = (SETT.WEATHER()).growthRipe.getD();
/*     */ 
/*     */ 
/*     */     
/* 101 */     renderTrunk(r, s, i, growth, ripe * 2.0D, size);
/*     */     
/* 103 */     double ra = ripe * 2.5D - 0.16666666666666666D * (i.ran() >> 2 & 0x3);
/* 104 */     double t = CLAMP.d(tops * ra, 0.0D, tops);
/* 105 */     if (t > 0.0D) {
/* 106 */       if ((SETT.WEATHER()).growth.isAutumn()) {
/* 107 */         renderTop(r, s, i, ripe, 1.0D, t);
/*     */       } else {
/* 109 */         renderTop(r, s, i, 1.0D, (ripe - 0.5D) * 2.0D, t);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTrunk(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, double growth, double ripe, double size) {
/* 116 */     renderTrunk(0, r, s, i, growth, ripe, size);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTrunk(int pos, SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, double growth, double ripe, double size) {
/* 121 */     render(poss[pos & 0x3], r, s, i, this.trunk, growth, ripe, size);
/*     */   }
/*     */   
/*     */   public void renderTop(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, double growth, double ripe, double size) {
/* 125 */     renderTop(0, r, s, i, growth, ripe, size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTop(int pos, SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, double growth, double ripe, double size) {
/* 131 */     swayer.update();
/* 132 */     render(poss[pos & 0x3], r, s, i, this.growth, growth, ripe, size);
/* 133 */     if (this.poll > 0.0D && ripe * growth >= 1.0D) {
/* 134 */       int aa = (int)(8.0D * size * this.poll);
/* 135 */       int k = i.ran() & 0x3F;
/* 136 */       this.cpollen[k].bind();
/* 137 */       pollen[k].render(i.x(), i.y(), aa);
/*     */     } 
/* 139 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   private void render(Positions pos, SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, Part part, double growth, double ripe, double size) {
/* 143 */     swayer.update();
/* 144 */     part.set(growth, ripe);
/*     */     
/* 146 */     if (size <= 0.0D) {
/*     */       return;
/*     */     }
/* 149 */     int am = (int)(size * 8.0D);
/* 150 */     if (CORE.renderer().getZoomout() > 1)
/* 151 */       am >>= CORE.renderer().getZoomout() - 1; 
/* 152 */     am = CLAMP.i(1 + am, 0, 8);
/*     */     
/* 154 */     long ran = i.bigRan();
/*     */     
/* 156 */     int posI = (int)(ran & (pos.positionsX.length - 1));
/* 157 */     ran >>= 8L;
/*     */     
/* 159 */     int swayI = (int)(ran & 0x3FL);
/* 160 */     ran >>= 6L;
/*     */     
/* 162 */     int cr = i.ranGet(-1, -1);
/*     */     
/* 164 */     if (CORE.renderer().getZoomout() >= 2) {
/* 165 */       am = CLAMP.i(am, 0, 2);
/*     */     }
/* 167 */     for (int ii = 0; ii < am; ii++) {
/*     */       
/* 169 */       part.color[cr & 0xF].bind();
/* 170 */       cr >>= 4;
/* 171 */       int dx = i.x() + pos.x(posI, ii);
/* 172 */       int dy = i.y() + pos.y(posI, ii);
/* 173 */       int rr = (int)(ran & 0xFL);
/* 174 */       ran >>= 4L;
/*     */       
/* 176 */       int kk = swayI + ii & 0x3F;
/*     */       
/* 178 */       int xx = (int)(dx - 0.5D * part.sway * this.wind * swayer.dx[kk]);
/* 179 */       int yy = (int)(dy + 0.5D * part.sway * this.wind * swayer.dy[kk]);
/*     */ 
/*     */       
/* 182 */       int tile = part.off + rr;
/* 183 */       this.sheet.render(r, tile, xx, yy);
/* 184 */       s.setDistance2Ground(part.sheightoverGround * swayer.dz[kk]).setHeight((int)(part.sheight * swayer.dz[kk]));
/* 185 */       this.sheet.render((SPRITE_RENDERER)s, tile, xx, yy);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 190 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   private static class Swayer
/*     */   {
/* 195 */     private final int am = 64;
/* 196 */     private final byte[] dx = Alloc.bb(64);
/* 197 */     private final byte[] dy = Alloc.bb(64);
/*     */     
/* 199 */     private final double[] dz = new double[64];
/* 200 */     private double[] ran = new double[64];
/*     */     
/*     */     double dd;
/*     */     
/* 204 */     private double lastSecond = 0.0D;
/*     */     
/*     */     Swayer() {
/* 207 */       for (int i = 0; i < 64; i++) {
/* 208 */         this.dx[i] = (byte)RND.rInt(16);
/* 209 */         this.dy[i] = (byte)RND.rInt(16);
/* 210 */         this.ran[i] = RND.rFloat() * Math.PI * 2.0D;
/* 211 */         this.dz[i] = 0.1D + 0.9D * RND.rFloat();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void update() {
/* 218 */       if (TIME.currentSecond() == this.lastSecond) {
/*     */         return;
/*     */       }
/* 221 */       double ds = TIME.currentSecond() - this.lastSecond;
/* 222 */       this.lastSecond = TIME.currentSecond();
/*     */       
/* 224 */       this.dd += ds * Math.pow((SETT.WEATHER()).wind.getD(), 1.5D) * 4.0D;
/*     */       
/* 226 */       for (int i = 0; i < 64; i++) {
/* 227 */         double cos = Math.cos(this.dd + this.ran[i]);
/* 228 */         double a = this.dz[i] * 6.0D * cos;
/* 229 */         this.dx[i] = (byte)(int)a;
/* 230 */         this.dy[i] = (byte)(int)a;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class Pollen
/*     */   {
/*     */     private static final int ticks = 128;
/*     */     
/*     */     private static final int tmask = 127;
/*     */     
/*     */     private static final int amount = 8;
/*     */     
/*     */     private static final double time = 5.0D;
/*     */     private static final double ticksPerTime = 25.6D;
/* 246 */     private final byte[][] xs = new byte[128][8];
/* 247 */     private final byte[][] ys = new byte[128][8];
/*     */ 
/*     */     
/*     */     private Pollen() {
/* 251 */       for (int a = 0; a < 8; a++) {
/*     */         
/* 253 */         double dvx = -(96.0D + RND.rFloat(96.0D));
/* 254 */         double dvy = 96.0D + RND.rFloat0(24.0D);
/* 255 */         dvx /= 128.0D;
/* 256 */         dvy /= 128.0D;
/* 257 */         double y = RND.rInt(64);
/* 258 */         double x = RND.rInt(32);
/*     */         
/* 260 */         int tStart = RND.rInt(128);
/*     */         
/* 262 */         double xsin = RND.rFloat(1.0D);
/* 263 */         double ysin = RND.rFloat(1.0D);
/* 264 */         double dsin = (RND.rFloat() / 128.0F);
/*     */         
/* 266 */         for (int t = 0; t < 128; t++) {
/*     */           
/* 268 */           this.xs[tStart][a] = (byte)(int)x;
/* 269 */           this.ys[tStart][a] = (byte)(int)y;
/* 270 */           x += dvx * Math.sin(xsin);
/* 271 */           y += dvy * Math.sin(ysin);
/* 272 */           xsin += dsin;
/* 273 */           ysin += dsin;
/* 274 */           tStart++;
/* 275 */           tStart &= 0x7F;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private void render(int x, int y, int a) {
/* 281 */       int t = (int)(((SETT.WEATHER()).wind.time.getD() * 8.0D + TIME.currentSecond() * 0.5D) * 25.6D);
/* 282 */       t &= 0x7F;
/* 283 */       a = CLAMP.i(a, 0, 8);
/* 284 */       for (int i = 0; i < a; i++)
/* 285 */         CORE.renderer().renderParticle(x + this.xs[t][i], y + this.ys[t][i]); 
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class Positions
/*     */   {
/* 291 */     private byte[][] positionsX = new byte[64][8];
/* 292 */     private byte[][] positionsY = new byte[64][8];
/*     */     private static final int dPosition = 0;
/*     */     
/*     */     public Positions(int ddx, int ddy) {
/* 296 */       int D = 21;
/* 297 */       for (int i = 0; i < this.positionsX.length; i++) {
/* 298 */         int[] ss = { 0, 1, 2, 3, 4, 5, 6, 7 };
/*     */         int k;
/* 300 */         for (k = 0; k < ss.length; k++) {
/* 301 */           int i1 = RND.rInt(ss.length);
/* 302 */           int o = ss[i1];
/* 303 */           ss[i1] = ss[0];
/* 304 */           ss[0] = o;
/*     */         } 
/*     */ 
/*     */         
/* 308 */         k = 0;
/* 309 */         for (int dy = 0; dy < 3; dy++) {
/* 310 */           for (int dx = 0; dx < 3; dx++) {
/* 311 */             if (dx != 1 || dy != 1) {
/*     */               
/* 313 */               int x = ddx + dx * (21 - ddx) - 0 + RND.rInt(1);
/* 314 */               int y = ddy + dy * (21 - ddy) - 0 + RND.rInt(1);
/* 315 */               int s = ss[k];
/* 316 */               k++;
/* 317 */               this.positionsX[i][s] = (byte)x;
/* 318 */               this.positionsY[i][s] = (byte)y;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private int x(int ran, int i) {
/* 327 */       return this.positionsX[ran & 0x3F][i & 0x7];
/*     */     }
/*     */     
/*     */     private int y(int ran, int i) {
/* 331 */       return this.positionsY[ran & 0x3F][i & 0x7];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class Part {
/* 336 */     public double sheight = 4.0D;
/* 337 */     public double sheightoverGround = 4.0D;
/* 338 */     private ColorImp[] color = new ColorImp[16];
/*     */     
/* 340 */     public final ColorImp[] cdead = new ColorImp[16];
/* 341 */     public final ColorImp[] clive = new ColorImp[16];
/* 342 */     public final ColorImp[] cripe = new ColorImp[16];
/*     */     
/* 344 */     private double lastGrowth = -1.0D;
/* 345 */     private double lastRipe = -1.0D;
/*     */     private final int off;
/*     */     public double sway;
/*     */     
/*     */     private Part(int off, double sway) {
/* 350 */       this.off = off;
/* 351 */       this.sway = sway;
/* 352 */       for (int i = 0; i < this.color.length; i++) {
/* 353 */         this.color[i] = new ColorImp();
/* 354 */         this.cdead[i] = new ColorImp(50, 30, 10);
/* 355 */         this.clive[i] = new ColorImp(127, 127, 127);
/*     */ 
/*     */         
/* 358 */         this.cripe[i] = new ColorImp(127, 127, 127);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setColors(COLOR dead, COLOR live, COLOR ripe) {
/* 363 */       for (int i = 0; i < this.color.length; i++) {
/* 364 */         if (dead != null)
/* 365 */           this.cdead[i].set(dead); 
/* 366 */         if (live != null)
/* 367 */           this.clive[i].set(live); 
/* 368 */         if (ripe != null) {
/* 369 */           this.cripe[i].set(ripe);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void set(double growth, double ripe) {
/* 377 */       if (this.lastGrowth != growth || this.lastRipe != ripe) {
/* 378 */         growth = CLAMP.d(growth, 0.0D, 1.0D);
/* 379 */         ripe = CLAMP.d(ripe, 0.0D, 1.0D);
/* 380 */         for (int i = 0; i < this.color.length; i++) {
/* 381 */           ColorImp.TMP.interpolate((COLOR)this.clive[i], (COLOR)this.cripe[i], ripe);
/* 382 */           this.color[i].interpolate((COLOR)this.cdead[i], (COLOR)ColorImp.TMP, growth);
/*     */         } 
/* 384 */         this.lastGrowth = growth;
/* 385 */         this.lastRipe = ripe;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeSheet(String key) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private static class SSheet
/*     */     extends Sheet
/*     */   {
/* 400 */     private static final HashMap<SheetData, GrowableSprite.Part> datas = new HashMap<>();
/*     */     private ShadowBatch s;
/*     */     private final GrowableSprite sp;
/*     */     
/*     */     SSheet(SheetType type, String key, GrowableSprite sp) {
/* 405 */       super(type.sizeSize * 1, false, false);
/* 406 */       this.sp = sp;
/* 407 */       SPRITES.GAME().add(type, (LIST)new ArrayList(this), key);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/* 412 */       this.s = shadow;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/* 418 */       it.countVegetation();
/*     */       
/* 420 */       double m = CLAMP.d((SETT.WEATHER()).moisture.getD() * 4.0D, 0.0D, 1.0D);
/* 421 */       double growth = (SETT.WEATHER()).growth.getD() * m * (2.0D + (it.ran() & 0x3));
/* 422 */       double ripe = (SETT.WEATHER()).growthRipe.getD();
/*     */       
/* 424 */       if (this.s == null) {
/* 425 */         this.s = ShadowBatch.DUMMY;
/*     */       }
/* 427 */       double am = 1.0D - 0.8D * degrade;
/*     */       
/* 429 */       this.sp.renderTrunk(sr, this.s, it, growth, ripe * 2.0D, am);
/*     */       
/* 431 */       double ra = ripe * 2.5D - 0.16666666666666666D * (it.ran() >> 2 & 0x3);
/* 432 */       double t = CLAMP.d(am * ra, 0.0D, 1.0D);
/*     */       
/* 434 */       if (!datas.containsKey(da)) {
/* 435 */         GrowableSprite.Part p = new GrowableSprite.Part(0, 1.0D);
/* 436 */         for (int i = 0; i < p.cripe.length; i++) {
/* 437 */           p.cripe[i].set((COLOR)da.colors.getC(i));
/*     */         }
/* 439 */         datas.put(da, p);
/*     */       } 
/*     */       
/* 442 */       GrowableSprite.Part part = datas.get(da);
/*     */       
/* 444 */       if (t > 0.0D) {
/* 445 */         if ((SETT.WEATHER()).growth.isAutumn()) {
/* 446 */           this.sp.render(GrowableSprite.poss[0], sr, this.s, it, part, am, ripe, t);
/*     */         } else {
/* 448 */           this.sp.render(GrowableSprite.poss[0], sr, this.s, it, part, am, (ripe - 0.5D) * 2.0D, t);
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureCoords texture(int tile) {
/* 455 */       return COLOR.WHITE100.texture();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\GrowableSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */