/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.TileTexture;
/*     */ import util.rendering.RenderData;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class GrassRenderer
/*     */ {
/*     */   private final TILE_SHEET sheet;
/*     */   private final TILE_SHEET sheetMask;
/*     */   private final TILE_SHEET moss;
/*     */   private final Colors colors;
/*  38 */   private final TileTexture.TileTextureScroller dis2 = (SPRITES.textures()).dis_low.scroller(72.0D, -66.0D);
/*     */   private final Grass grass;
/*     */   private static final int SET = 16;
/*  41 */   private final int[] tts = new int[] { 
/*  42 */       -1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7 };
/*     */ 
/*     */   
/*  45 */   private final OPACITY[] op = new OPACITY[15];
/*     */   public GrassRenderer(Grass grass) throws IOException {
/*  47 */     for (int i = 0; i < 15; i++) {
/*  48 */       int p = (int)(100.0D * (i + 1.0D) / 15.0D);
/*  49 */       this.op[i] = (OPACITY)new OpacityImp(p);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     this.grass = grass;
/*     */ 
/*     */     
/*  58 */     this.colors = new Colors();
/*     */     
/*  60 */     this.sheetMask = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  64 */           ComposerDests.Tile t = d.s24;
/*  65 */           ComposerSources.Full f = s.full;
/*  66 */           f.init(0, f.body().y2(), 1, 1, 4, 4, t);
/*  67 */           f.setVar(0).paste(true);
/*  68 */           return t.saveGame();
/*     */         }
/*  71 */       }).get();
/*     */     
/*  73 */     this.sheet = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  77 */           ComposerDests.Tile t = d.s24;
/*  78 */           ComposerSources.Singles f = s.singles;
/*  79 */           f.init(0, s.full.body().y2(), 1, 1, 16, 8, (ComposerDests.Dest)t);
/*  80 */           f.setVar(0).paste(true);
/*  81 */           return t.saveGame();
/*     */         }
/*  84 */       }).get();
/*     */     
/*  86 */     this.moss = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT_MAP().get("Moss"), 792, 108)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  90 */           ComposerDests.Tile t = d.s24;
/*  91 */           ComposerSources.Full f = s.full;
/*  92 */           f.init(0, 0, 1, 1, 16, 4, t);
/*  93 */           f.setVar(0).paste(true);
/*  94 */           return t.saveGame();
/*     */         }
/*  97 */       }).get();
/*     */   }
/*     */   
/*     */   void update(double ds) {
/* 101 */     this.colors.update(ds);
/* 102 */     double w = Math.pow((SETT.WEATHER()).wind.getD(), 1.5D) * 0.5D;
/* 103 */     if (w > 0.1D) {
/* 104 */       this.dis2.update(ds * w);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(double ds, Renderer r, RenderData data) {
/* 110 */     RenderData.RenderIterator it = data.onScreenTiles(1, 1, 1, 1);
/*     */     
/* 112 */     while (it.has()) {
/*     */       
/* 114 */       render(it, r);
/* 115 */       it.next();
/*     */     } 
/* 117 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(RenderData.RenderIterator it, Renderer r) {
/* 123 */     int tx = it.tx();
/* 124 */     int ty = it.ty();
/* 125 */     int px = it.x();
/* 126 */     int py = it.y();
/* 127 */     int ran = it.ran();
/* 128 */     int tile = it.tile();
/*     */     
/* 130 */     if (!pRender(r, tx, ty, px, py, ran, tile))
/*     */     {
/*     */ 
/*     */       
/* 134 */       if ((SETT.TERRAIN()).diagonal.is(it.tx(), it.ty()))
/*     */       {
/* 136 */         for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 137 */           int dx = it.tx() + ((DIR)DIR.NORTHO.get(i)).x();
/* 138 */           int dy = it.ty() + ((DIR)DIR.NORTHO.get(i)).y();
/* 139 */           if (this.grass.currentI.get(dx, dy) > 0 && this.grass.currentI.get(it.tx(), dy) > 0 && this.grass.currentI.get(dx, it.ty()) > 0) {
/*     */             
/* 141 */             it.setOff((int)(((DIR)DIR.NORTHO.get(i)).xN() * -32.0D), (int)(((DIR)DIR.NORTHO.get(i)).yN() * -32.0D));
/* 142 */             pRender(r, dx, dy, (int)(px + ((DIR)DIR.NORTHO.get(i)).xN() * 32.0D), (int)(py + ((DIR)DIR.NORTHO.get(i)).yN() * 32.0D), it.ran(), dx + dy * SETT.TWIDTH);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean pRender(Renderer r, int tx, int ty, int px, int py, int ran, int tile) {
/* 154 */     int colC = this.grass.currentI.get(tile);
/* 155 */     int c = this.tts[colC];
/*     */     
/* 157 */     if (colC == 1)
/* 158 */       c -= ran & 0x3; 
/* 159 */     if (colC == 2)
/* 160 */       c -= ran & 0x1; 
/* 161 */     if (colC == 3) {
/* 162 */       c -= ran & 0x1;
/*     */     }
/* 164 */     if (colC == 5) {
/* 165 */       c -= ran & 0x1;
/*     */     }
/*     */     
/* 168 */     ran >>= 2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     if (c >= 0) {
/*     */       
/* 175 */       int m = (SETT.MINERALS()).amountInt.get(tile) >> 2;
/* 176 */       c = CLAMP.i(c - m, 0, c);
/*     */ 
/*     */       
/* 179 */       int d = ((ran & 0x7) - 7) * 4;
/* 180 */       ran >>= 3;
/* 181 */       int x = px + d;
/* 182 */       d = ((ran & 0x7) - 7) * 4;
/* 183 */       ran >>= 3;
/* 184 */       int y = py + d;
/* 185 */       if (SETT.TERRAIN().get(tile).roofIs()) {
/* 186 */         COLOR.unbind();
/* 187 */         c = c + 1 >> 3;
/* 188 */         this.moss.render((SPRITE_RENDERER)r, c * 16 + (ran & 0xF), x, y);
/*     */       } else {
/* 190 */         this.colors.get(colC - 1, ran).bind();
/*     */         
/* 192 */         this.sheet.render((SPRITE_RENDERER)r, c * 16 + (ran & 0xF), x, y);
/*     */ 
/*     */ 
/*     */         
/* 196 */         this.op[colC - 1].bind();
/* 197 */         TextureCoords t = (SPRITES.textures()).dots.get(tx, ty, 0.0D, 0.0D);
/*     */         
/* 199 */         CORE.renderer().renderDisplaced(px, px + 64, py, py + 64, 0.4D, this.dis2.get(tx, ty), t);
/* 200 */         OPACITY.unbind();
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 207 */       return true;
/*     */     } 
/* 209 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public COLOR color(int ran) {
/* 215 */     return this.colors.get(4, ran);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class Colors
/*     */   {
/*     */     private static final int RAN = 4;
/* 222 */     private final COLOR[][] c_base = new COLOR[15][4];
/* 223 */     private final ColorImp[][] c_current = new ColorImp[15][4];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final COLOR dry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final COLOR winter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final ColorImp tmp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private COLOR get(int c, int ran) {
/* 289 */       return (COLOR)this.c_current[c][ran & 0x3];
/*     */     }
/*     */     
/*     */     void update(double ds) {
/* 293 */       double m = (SETT.WEATHER()).moisture.getD();
/* 294 */       if (m < 0.25D) {
/* 295 */         m = 0.05D;
/* 296 */       } else if (m < 0.5D) {
/* 297 */         m -= 0.25D;
/* 298 */         m /= 0.25D;
/* 299 */         m = CLAMP.d(m, 0.05D, 1.0D);
/*     */       } else {
/* 301 */         m = 1.0D;
/*     */       } 
/* 303 */       set(m, 1.0D - (SETT.WEATHER()).growth.getD());
/*     */     }
/*     */     
/* 306 */     Colors() throws IOException { this.tmp = new ColorImp(); COLOR fertile = (new ComposerThings.IColorSamplerSingle() { protected COLOR init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.init(0, 0, 1, 1, 8, 1, d.s24); return s.full.sample(); } }
/*     */         ).getHalf(); COLOR infertile = (new ComposerThings.IColorSamplerSingle() { protected COLOR init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.setSkip(1, 1); return s.full.sample(); } }
/*     */         ).getHalf(); this.dry = (new ComposerThings.IColorSamplerSingle() { protected COLOR init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.setSkip(1, 2); return s.full.sample(); } }
/* 309 */         ).getHalf(); this.winter = (new ComposerThings.IColorSamplerSingle() { protected COLOR init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.setSkip(1, 3); return s.full.sample(); } }).getHalf(); int skip = 5; ColorImp[] arrayOfColorImp = COLOR.interpolate(infertile, fertile, 11); for (int i = 0; i < 15; i++) { ColorImp colorImp = arrayOfColorImp[CLAMP.i(i - skip, 0, i)]; this.c_base[i][0] = (COLOR)colorImp; this.c_current[i][0] = new ColorImp(this.c_base[i][0]); for (int k = 1; k < 4; k++) { this.c_base[i][k] = (COLOR)colorImp.shade(RND.rFloat1(0.05D)); this.c_current[i][k] = new ColorImp(this.c_base[i][k]); }  }  } private void set(double moist, double winter) { for (int a = 0; a < 15; a++) {
/* 310 */         for (int b = 0; b < 4; b++) {
/* 311 */           this.tmp.interpolate(this.dry, this.c_base[a][b], moist);
/* 312 */           this.c_current[a][b].interpolate((COLOR)this.tmp, this.winter, winter * 0.75D);
/*     */         } 
/*     */       }  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\GrassRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */