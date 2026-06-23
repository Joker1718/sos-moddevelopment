/*     */ package util.spritecomposer;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.TileTexture;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ComposerThings
/*     */ {
/*     */   public static class IInit
/*     */   {
/*     */     public IInit(Path path, int width, int height) throws IOException {
/*  38 */       Resources.c.setSource(path, width, height);
/*  39 */       if (Resources.g == null)
/*  40 */         init(Resources.c, Resources.sources, Resources.dests); 
/*     */     }
/*     */     
/*     */     public IInit() throws IOException {
/*  44 */       if (Resources.g == null) {
/*  45 */         init(Resources.c, Resources.sources, Resources.dests);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected void init(ComposerUtil c, ComposerSources s, ComposerDests d) throws IOException {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class ITileSheet
/*     */   {
/*     */     protected ITileSheet() {}
/*     */ 
/*     */     
/*     */     protected ITileSheet(Path path, int width, int height) throws IOException {
/*  60 */       Resources.c.setSource(path, width, height);
/*     */     }
/*     */     
/*     */     static TILE_SHEET save(int scale, int tileSize, int startTile, int tiles, int tilesX) {
/*  64 */       Resources.p.mark("sheet");
/*  65 */       Resources.p.i(scale);
/*  66 */       Resources.p.i(tileSize);
/*  67 */       Resources.p.i(startTile);
/*  68 */       Resources.p.i(tiles);
/*  69 */       Resources.p.i(tilesX);
/*  70 */       return new TIleSheetPow2(scale, tileSize, startTile, tilesX, tiles);
/*     */     }
/*     */     
/*     */     private static TILE_SHEET read(FileGetter g) throws IOException {
/*  74 */       g.check("sheet");
/*  75 */       int scale = g.i();
/*  76 */       int tileSize = g.i();
/*  77 */       int startTile = g.i();
/*  78 */       int tiles = g.i();
/*  79 */       int tilesX = g.i();
/*  80 */       return new TIleSheetPow2(scale, tileSize, startTile, tilesX, tiles);
/*     */     }
/*     */     
/*     */     public TILE_SHEET get() throws IOException {
/*  84 */       if (Resources.g == null) {
/*  85 */         TILE_SHEET s = init(Resources.c, Resources.sources, Resources.dests);
/*  86 */         if (s == null) {
/*  87 */           save(1, 8, 0, 0, 0);
/*     */         }
/*  89 */         return s;
/*     */       } 
/*  91 */       return read(Resources.g);
/*     */     }
/*     */     
/*     */     protected abstract TILE_SHEET init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */   }
/*     */   
/*     */   public static abstract class ITileSprite implements SPRITE {
/*     */     private final int width;
/*     */     private final int height;
/*     */     private final TILE_SHEET sheet;
/*     */     
/*     */     protected ITileSprite(int width, int height, int scale) throws IOException {
/* 103 */       this.width = width * scale;
/* 104 */       this.height = height * scale;
/* 105 */       this.sheet = get();
/*     */     }
/*     */     
/*     */     protected ITileSprite(int width, int height, int scale, Path path, int w, int h) throws IOException {
/* 109 */       Resources.c.setSource(path, w, h);
/* 110 */       this.width = width * scale;
/* 111 */       this.height = height * scale;
/* 112 */       this.sheet = get();
/*     */     }
/*     */     
/*     */     public TILE_SHEET get() throws IOException {
/* 116 */       if (Resources.g == null) {
/* 117 */         return init(Resources.c, Resources.sources, Resources.dests);
/*     */       }
/* 119 */       return ComposerThings.ITileSheet.read(Resources.g);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract TILE_SHEET init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */     
/*     */     public int width() {
/* 126 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 131 */       return this.height;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 136 */       int i = 0;
/* 137 */       for (int y = 0; y < this.height; y += this.sheet.size()) {
/* 138 */         for (int x = 0; x < this.width; x += this.sheet.size()) {
/* 139 */           this.sheet.render(r, i, X1 + x, Y1 + y);
/* 140 */           i++;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 147 */       throw new RuntimeException("not supported!");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class ITileSheetL
/*     */   {
/*     */     protected ITileSheetL() {}
/*     */ 
/*     */     
/*     */     protected ITileSheetL(Path path, int width, int height) throws IOException {
/* 158 */       Resources.c.setSource(path, width, height);
/*     */     }
/*     */     
/*     */     public LIST<TILE_SHEET> get() throws IOException {
/* 162 */       if (Resources.g == null) {
/* 163 */         Resources.p.mark("list");
/* 164 */         int j = init(Resources.c, Resources.sources, Resources.dests);
/* 165 */         Resources.p.i(j);
/* 166 */         ArrayList<TILE_SHEET> arrayList = new ArrayList(j);
/* 167 */         for (int k = 0; k < j; k++) {
/* 168 */           arrayList.add(next(k, Resources.c, Resources.sources, Resources.dests));
/*     */         }
/* 170 */         Resources.p.mark("list");
/* 171 */         return (LIST<TILE_SHEET>)arrayList;
/*     */       } 
/*     */       
/* 174 */       Resources.g.check("list");
/* 175 */       int a = Resources.g.i();
/* 176 */       ArrayList<TILE_SHEET> res = new ArrayList(a);
/* 177 */       for (int i = 0; i < a; i++) {
/* 178 */         res.add(ComposerThings.ITileSheet.read(Resources.g));
/*     */       }
/* 180 */       Resources.g.check("list");
/* 181 */       return (LIST<TILE_SHEET>)res;
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract int init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */ 
/*     */     
/*     */     protected abstract TILE_SHEET next(int param1Int, ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class ITileSpriteL
/*     */   {
/*     */     public LIST<TILE_SHEET> get() throws IOException {
/* 195 */       if (Resources.g == null) {
/* 196 */         Resources.p.mark("list");
/* 197 */         int j = init(Resources.c, Resources.sources, Resources.dests);
/* 198 */         Resources.p.i(j);
/* 199 */         ArrayList<TILE_SHEET> arrayList = new ArrayList(j);
/* 200 */         for (int k = 0; k < j; k++) {
/* 201 */           arrayList.add(next(k, Resources.c, Resources.sources, Resources.dests));
/*     */         }
/* 203 */         Resources.p.mark("list");
/* 204 */         return (LIST<TILE_SHEET>)arrayList;
/*     */       } 
/*     */       
/* 207 */       Resources.g.check("list");
/* 208 */       int a = Resources.g.i();
/* 209 */       ArrayList<TILE_SHEET> res = new ArrayList(a);
/* 210 */       for (int i = 0; i < a; i++) {
/* 211 */         res.add(ComposerThings.ITileSheet.read(Resources.g));
/*     */       }
/* 213 */       Resources.g.check("list");
/* 214 */       return (LIST<TILE_SHEET>)res;
/*     */     }
/*     */     
/*     */     protected abstract int init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */     
/*     */     protected abstract TILE_SHEET next(int param1Int, ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests); }
/*     */   
/*     */   public static abstract class ITileTexture {
/*     */     private final int width;
/*     */     private final int height;
/*     */     
/*     */     protected ITileTexture(int width, int height) {
/* 226 */       this.width = width;
/* 227 */       this.height = height;
/*     */     }
/*     */     
/*     */     protected ITileTexture(int width, int height, Path path, int w, int h) throws IOException {
/* 231 */       Resources.c.setSource(path, w, h);
/* 232 */       this.width = width;
/* 233 */       this.height = height;
/*     */     }
/*     */     
/*     */     public TileTexture get() throws IOException {
/*     */       SpriteData d;
/* 238 */       if (Resources.g == null) {
/* 239 */         d = init(Resources.c, Resources.sources, Resources.dests, Resources.immi);
/*     */       } else {
/* 241 */         d = SpriteData.read(Resources.g);
/*     */       } 
/* 243 */       int dx = 0;
/* 244 */       if (Optimizer.get(24) != null)
/* 245 */         dx += (Optimizer.get(24)).tilesX * 24; 
/* 246 */       return new TileTexture(16, this.width, this.height, d.x1 + dx, d.y1);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract SpriteData init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests, ComposerTexturer param1ComposerTexturer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void init(Path path, int width, int height) throws IOException {
/* 255 */     if (Resources.g == null) {
/* 256 */       Resources.c.setSource(path, width, height);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class ISpriteData
/*     */   {
/*     */     protected ISpriteData() {}
/*     */ 
/*     */     
/*     */     protected ISpriteData(Path path, int width, int height) throws IOException {
/* 267 */       Resources.c.setSource(path, width, height);
/*     */     }
/*     */     
/*     */     public SpriteData get() throws IOException {
/* 271 */       if (Resources.g == null) {
/* 272 */         return init(Resources.c, Resources.sources, Resources.dests);
/*     */       }
/* 274 */       return SpriteData.read(Resources.g);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract SpriteData init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */   }
/*     */   
/*     */   public static abstract class INop
/*     */   {
/*     */     protected INop() {
/* 284 */       if (Resources.g == null) {
/* 285 */         init(Resources.c, Resources.sources, Resources.dests);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract void init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class ISpriteList
/*     */   {
/*     */     protected ISpriteList() {}
/*     */ 
/*     */     
/*     */     protected ISpriteList(Path path, int width, int height) throws IOException {
/* 300 */       Resources.c.setSource(path, width, height);
/*     */     }
/*     */     
/*     */     public SpriteData[] get() throws IOException {
/* 304 */       if (Resources.g == null) {
/* 305 */         Resources.p.mark("list");
/* 306 */         int j = init(Resources.c, Resources.sources, Resources.dests);
/* 307 */         Resources.p.i(j);
/* 308 */         SpriteData[] arrayOfSpriteData = new SpriteData[j];
/* 309 */         for (int k = 0; k < j; k++) {
/* 310 */           arrayOfSpriteData[k] = next(k, Resources.c, Resources.sources, Resources.dests);
/*     */         }
/* 312 */         Resources.p.mark("list");
/* 313 */         return arrayOfSpriteData;
/*     */       } 
/* 315 */       Resources.g.check("list");
/* 316 */       int a = Resources.g.i();
/* 317 */       SpriteData[] res = new SpriteData[a];
/* 318 */       for (int i = 0; i < a; i++) {
/* 319 */         res[i] = SpriteData.read(Resources.g);
/*     */       }
/* 321 */       Resources.g.check("list");
/* 322 */       return res;
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract int init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */ 
/*     */     
/*     */     protected abstract SpriteData next(int param1Int, ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */   }
/*     */   
/*     */   public static abstract class IColorSampler
/*     */   {
/*     */     protected IColorSampler() {}
/*     */     
/*     */     protected IColorSampler(Path path, int width, int height) throws IOException {
/* 337 */       Resources.c.setSource(path, width, height);
/*     */     }
/*     */     
/*     */     static COLOR save(int c) {
/* 341 */       int r = c >> 24 & 0xFF;
/* 342 */       int g = c >> 16 & 0xFF;
/* 343 */       int b = c >> 8 & 0xFF;
/* 344 */       Resources.p.i(r);
/* 345 */       Resources.p.i(g);
/* 346 */       Resources.p.i(b);
/* 347 */       return (COLOR)new ColorImp(r, g, b);
/*     */     }
/*     */ 
/*     */     
/*     */     public LIST<COLOR> get() throws IOException {
/* 352 */       if (Resources.g == null) {
/* 353 */         Resources.p.mark("color list");
/* 354 */         int j = init(Resources.c, Resources.sources, Resources.dests);
/* 355 */         Resources.p.i(j);
/* 356 */         ArrayList<COLOR> arrayList = new ArrayList(j);
/* 357 */         for (int k = 0; k < j; k++) {
/* 358 */           arrayList.add(next(k, Resources.c, Resources.sources, Resources.dests));
/*     */         }
/* 360 */         Resources.p.mark("list");
/* 361 */         return (LIST<COLOR>)arrayList;
/*     */       } 
/* 363 */       Resources.g.check("color list");
/* 364 */       int a = Resources.g.i();
/* 365 */       ArrayList<COLOR> res = new ArrayList(a);
/* 366 */       for (int i = 0; i < a; i++) {
/* 367 */         res.add(new ColorImp(Resources.g.i(), Resources.g.i(), Resources.g.i()));
/*     */       }
/* 369 */       Resources.g.check("list");
/* 370 */       return (LIST<COLOR>)res;
/*     */     }
/*     */     
/*     */     public LIST<COLOR> getHalf() throws IOException {
/* 374 */       if (Resources.g == null) {
/* 375 */         Resources.p.mark("color list");
/* 376 */         int j = init(Resources.c, Resources.sources, Resources.dests);
/* 377 */         Resources.p.i(j);
/* 378 */         ArrayList<COLOR> arrayList = new ArrayList(j);
/* 379 */         for (int k = 0; k < j; k++) {
/* 380 */           arrayList.add(next(k, Resources.c, Resources.sources, Resources.dests).shade(0.5D));
/*     */         }
/* 382 */         Resources.p.mark("list");
/* 383 */         return (LIST<COLOR>)arrayList;
/*     */       } 
/* 385 */       Resources.g.check("color list");
/* 386 */       int a = Resources.g.i();
/* 387 */       ArrayList<COLOR> res = new ArrayList(a);
/* 388 */       for (int i = 0; i < a; i++) {
/* 389 */         res.add(new ColorImp(Resources.g.i() / 2, Resources.g.i() / 2, Resources.g.i() / 2));
/*     */       }
/* 391 */       Resources.g.check("list");
/* 392 */       return (LIST<COLOR>)res;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract int init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract COLOR next(int param1Int, ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class IColorSamplerSingle
/*     */   {
/*     */     public COLOR get() throws IOException {
/* 408 */       if (Resources.g == null) {
/* 409 */         Resources.p.mark("color");
/* 410 */         return init(Resources.c, Resources.sources, Resources.dests);
/*     */       } 
/* 412 */       Resources.g.check("color");
/* 413 */       return (COLOR)new ColorImp(Resources.g.i(), Resources.g.i(), Resources.g.i());
/*     */     }
/*     */     
/*     */     public COLOR getHalf() throws IOException {
/* 417 */       if (Resources.g == null) {
/* 418 */         Resources.p.mark("color");
/* 419 */         return init(Resources.c, Resources.sources, Resources.dests);
/*     */       } 
/* 421 */       Resources.g.check("color");
/* 422 */       return (COLOR)new ColorImp((COLOR)new ColorImp(Resources.g.i() / 2, Resources.g.i() / 2, Resources.g.i() / 2));
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract COLOR init(ComposerUtil param1ComposerUtil, ComposerSources param1ComposerSources, ComposerDests param1ComposerDests);
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class IFont
/*     */   {
/*     */     protected IFont() {}
/*     */ 
/*     */     
/*     */     protected IFont(Path path) throws IOException {
/* 436 */       Resources.c.setSource(path);
/*     */     }
/*     */     
/*     */     public Font get(int trail) throws IOException {
/* 440 */       if (Resources.g == null) {
/* 441 */         return init(Resources.c, Resources.fonter);
/*     */       }
/* 443 */       return ComposerFonter.get(trail);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract Font init(ComposerUtil param1ComposerUtil, ComposerFonter param1ComposerFonter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ISprite
/*     */   {
/*     */     private static SPRITE.SpriteImp getSprite(int scale, SpriteData d) {
/* 456 */       short x1 = (short)d.x1;
/* 457 */       short x2 = (short)(d.x1 + d.width);
/* 458 */       short y1 = (short)d.y1;
/* 459 */       short y2 = (short)(d.y1 + d.height);
/* 460 */       short w = (short)(d.width * scale);
/* 461 */       short h = (short)(d.height * scale);
/* 462 */       return new SPRITE.SpriteImp(x1, x2, y1, y2, w, h);
/*     */     }
/*     */     
/*     */     public static SPRITE game(SpriteData d) {
/* 466 */       return (SPRITE)getSprite(4, d);
/*     */     }
/*     */     
/*     */     public static SPRITE gui(SpriteData d) {
/* 470 */       return (SPRITE)getSprite(1, d);
/*     */     }
/*     */     
/*     */     public static SPRITE normal(SpriteData d) {
/* 474 */       return (SPRITE)getSprite(2, d);
/*     */     }
/*     */     
/*     */     public static SPRITE scaled(SpriteData d, int scale) {
/* 478 */       return (SPRITE)getSprite(scale, d);
/*     */     }
/*     */     
/*     */     public static LIST<SPRITE> game(SpriteData[] data) {
/* 482 */       ArrayList<SPRITE> res = new ArrayList(data.length);
/* 483 */       for (int i = 0; i < data.length; i++)
/* 484 */         res.add(game(data[i])); 
/* 485 */       return (LIST<SPRITE>)res;
/*     */     }
/*     */     
/*     */     public static LIST<SPRITE> gui(SpriteData[] data) {
/* 489 */       ArrayList<SPRITE> res = new ArrayList(data.length);
/* 490 */       for (int i = 0; i < data.length; i++)
/* 491 */         res.add(gui(data[i])); 
/* 492 */       return (LIST<SPRITE>)res;
/*     */     }
/*     */     
/*     */     public static LIST<SPRITE> normal(SpriteData[] data) {
/* 496 */       ArrayList<SPRITE> res = new ArrayList(data.length);
/* 497 */       for (int i = 0; i < data.length; i++)
/* 498 */         res.add(normal(data[i])); 
/* 499 */       return (LIST<SPRITE>)res;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerThings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */