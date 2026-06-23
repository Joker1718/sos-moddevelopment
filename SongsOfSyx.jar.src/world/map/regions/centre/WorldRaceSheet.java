/*     */ package world.map.regions.centre;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import world.WORLD;
/*     */ import world.WRenContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldRaceSheet
/*     */ {
/*  28 */   private static KeyMap<TILE_SHEET> map = new KeyMap();
/*  29 */   private static KeyMap<WallSteriods> mapW = new KeyMap();
/*     */ 
/*     */   
/*     */   public final Town town;
/*     */ 
/*     */   
/*     */   public final Village village;
/*     */ 
/*     */   
/*     */   public final WallSteriods walls;
/*     */ 
/*     */   
/*     */   public final WallSteriods walls_village;
/*     */ 
/*     */   
/*     */   public final Overlay overlay;
/*     */   
/*     */   public final Terrain terrain;
/*     */   
/*     */   public final Farm farm;
/*     */ 
/*     */   
/*     */   public WorldRaceSheet(Json json) throws IOException {
/*  52 */     PATH getter = (PATHS.WORLD()).sprite.getFolder("centre");
/*     */     
/*  54 */     this.town = new Town(getter, json);
/*  55 */     this.village = new Village(getter, json);
/*  56 */     this.walls = new WallSteriods(6, "WALL", getter, json);
/*  57 */     this.walls_village = new WallSteriods(4, "WALL_VILLAGE", getter, json);
/*  58 */     this.overlay = new Overlay(getter, json);
/*  59 */     this.terrain = new Terrain(getter, json);
/*  60 */     this.farm = new Farm(getter, json);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Town
/*     */   {
/*     */     public final TILE_SHEET sheet;
/*     */     public final COLOR color;
/*     */     public static final int maxSize = 3;
/*     */     
/*     */     public Town(PATH getter, Json json) throws IOException {
/*  71 */       String t = "TOWN";
/*  72 */       String f = json.value(t);
/*  73 */       String k = t + "_" + t;
/*  74 */       if (WorldRaceSheet.map.containsKey(k)) {
/*  75 */         this.sheet = (TILE_SHEET)WorldRaceSheet.map.get(k);
/*     */       } else {
/*  77 */         this.sheet = (new ComposerThings.ITileSheet(getter.getFolder("town").get(f), 460, 62)
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/*  81 */               s.singles.init(0, 0, 1, 1, 16, 4, (ComposerDests.Dest)d.s8);
/*  82 */               s.singles.paste(true);
/*  83 */               return d.s8.saveGame();
/*     */             }
/*  85 */           }).get();
/*  86 */         WorldRaceSheet.map.put(k, this.sheet);
/*     */       } 
/*  88 */       this.color = (COLOR)new ColorImp(json, t + "_COLOR");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, ShadowBatch s, int size, int ran, int x, int y) {
/*  95 */       size = CLAMP.i(size, 0, 3);
/*  96 */       this.color.bind();
/*  97 */       this.sheet.render(r, 16 * size + (ran & 0xF), x, y);
/*  98 */       this.sheet.render((SPRITE_RENDERER)s, 16 * size + (ran & 0xF), x, y);
/*  99 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Village
/*     */   {
/*     */     public final TILE_SHEET sheet;
/*     */     public final COLOR color;
/*     */     public static final int ranI = 31;
/*     */     
/*     */     public Village(PATH getter, Json json) throws IOException {
/* 111 */       String t = "VILLAGE";
/* 112 */       String f = json.value(t);
/* 113 */       String k = t + "_" + t;
/* 114 */       if (WorldRaceSheet.map.containsKey(k)) {
/* 115 */         this.sheet = (TILE_SHEET)WorldRaceSheet.map.get(k);
/*     */       } else {
/* 117 */         this.sheet = (new ComposerThings.ITileSheet(getter.getFolder("village").get(f), 460, 34)
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 121 */               s.singles.init(0, 0, 1, 1, 16, 2, (ComposerDests.Dest)d.s8);
/* 122 */               s.singles.paste(true);
/* 123 */               return d.s8.saveGame();
/*     */             }
/* 125 */           }).get();
/* 126 */         WorldRaceSheet.map.put(k, this.sheet);
/*     */       } 
/* 128 */       this.color = (COLOR)new ColorImp(json, t + "_COLOR");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, ShadowBatch s, int ran, int x, int y) {
/* 135 */       ran &= 0x1F;
/* 136 */       this.color.bind();
/* 137 */       this.sheet.render(r, ran, x, y);
/* 138 */       s.setHeight(1).setDistance2Ground(0.0D);
/* 139 */       this.sheet.render((SPRITE_RENDERER)s, ran, x, y);
/* 140 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Overlay
/*     */   {
/*     */     public final TILE_SHEET sheet;
/*     */     public final COLOR color;
/*     */     public static final int maxSize = 3;
/*     */     
/*     */     public Overlay(PATH getter, Json json) throws IOException {
/* 152 */       String t = "OVERLAY";
/* 153 */       String f = json.value(t);
/* 154 */       String k = t + "_" + t;
/* 155 */       if (WorldRaceSheet.map.containsKey(k)) {
/* 156 */         this.sheet = (TILE_SHEET)WorldRaceSheet.map.get(k);
/*     */       } else {
/* 158 */         this.sheet = (new ComposerThings.ITileSheet(getter.getFolder("overlay").get(f), 236, 34)
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 162 */               s.singles.init(0, 0, 1, 1, 8, 2, (ComposerDests.Dest)d.s8);
/* 163 */               s.singles.paste(true);
/* 164 */               return d.s8.saveGame();
/*     */             }
/* 166 */           }).get();
/* 167 */         WorldRaceSheet.map.put(k, this.sheet);
/*     */       } 
/* 169 */       this.color = (COLOR)new ColorImp(json, t + "_COLOR");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(WRenContext con, int ran, int x, int y) {
/* 176 */       this.color.bind();
/* 177 */       this.sheet.render(con.r, ran & 0xF, x, y);
/* 178 */       this.sheet.render((SPRITE_RENDERER)con.s, ran & 0xF, x, y);
/* 179 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class WallSteriods
/*     */   {
/*     */     private static final int VARS = 5;
/*     */     
/*     */     private final Size[] sizes;
/*     */     
/*     */     public final COLOR color;
/*     */     
/*     */     public static final int maxSize = 4;
/*     */     private final int sh;
/* 194 */     private final SPRITE_RENDERER[] rens = new SPRITE_RENDERER[2];
/*     */     
/*     */     public WallSteriods(int shadow, String t, PATH getter, Json json) throws IOException {
/* 197 */       String f = json.value(t);
/* 198 */       String k = "WALL_" + f;
/* 199 */       this.sh = shadow;
/* 200 */       this.color = (COLOR)new ColorImp(json, t + "_COLOR");
/* 201 */       if (WorldRaceSheet.mapW.containsKey(k)) {
/* 202 */         this.sizes = ((WallSteriods)WorldRaceSheet.mapW.get(k)).sizes;
/*     */         return;
/*     */       } 
/* 205 */       this.sizes = new Size[5];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 216 */       for (int i = 0; i < 5; i++)
/* 217 */         this.sizes[i] = new Size(i); 
/* 218 */       WorldRaceSheet.mapW.put(k, this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(WRenContext con, double size, int dim, int cx, int cy) {
/* 225 */       this.color.bind();
/* 226 */       con.s.setHard();
/* 227 */       con.s.setHeight(this.sh).setDistance2Ground(0.0D);
/*     */       
/* 229 */       this.rens[0] = con.r;
/* 230 */       this.rens[1] = (SPRITE_RENDERER)con.s;
/* 231 */       Size s = this.sizes[CLAMP.i((int)Math.round(size * 5.0D - 1.0D), 0, 4)];
/*     */       
/* 233 */       int dd = 32;
/* 234 */       int x1 = cx - dim;
/* 235 */       int y1 = cy - dim;
/* 236 */       dim = dim * 2 - dd;
/* 237 */       int x2 = x1 + dim;
/* 238 */       int y2 = y1 + dim;
/* 239 */       for (int i = 0; i < this.rens.length; i++) {
/* 240 */         SPRITE_RENDERER r = this.rens[i];
/*     */         
/* 242 */         int off = i * 8;
/* 243 */         double am = (dim - dd * 3.0D) / (dd * 2);
/*     */         
/* 245 */         for (int k = 0; k <= am; k++) {
/*     */           
/* 247 */           int kk = dd + k * dd;
/*     */ 
/*     */           
/* 250 */           s.walls.render(r, 0 + off, x1 + kk, y1);
/* 251 */           s.walls.render(r, 1 + off, x2 - kk, y1);
/*     */           
/* 253 */           s.walls.render(r, 2 + off, x1, y1 + kk);
/* 254 */           s.walls.render(r, 3 + off, x2, y1 + kk);
/*     */           
/* 256 */           s.walls.render(r, 4 + off, x1, y2 - kk);
/* 257 */           s.walls.render(r, 5 + off, x2, y2 - kk);
/*     */           
/* 259 */           s.walls.render(r, 6 + off, x1 + kk, y2);
/* 260 */           s.walls.render(r, 7 + off, x2 - kk, y2);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 268 */         off = i * 4;
/* 269 */         s.corners.render(r, 0 + off, x1, y1);
/* 270 */         s.corners.render(r, 1 + off, x2, y1);
/* 271 */         s.corners.render(r, 2 + off, x1, y2);
/* 272 */         s.corners.render(r, 3 + off, x2, y2);
/*     */ 
/*     */         
/* 275 */         off = i * 8;
/* 276 */         s.gate.render(r, 0 + off, cx - dd, y1);
/* 277 */         s.gate.render(r, 1 + off, cx, y1);
/* 278 */         s.gate.render(r, 2 + off, x1, cy - dd);
/* 279 */         s.gate.render(r, 3 + off, x1, cy);
/* 280 */         s.gate.render(r, 4 + off, x2, cy - dd);
/* 281 */         s.gate.render(r, 5 + off, x2, cy);
/* 282 */         s.gate.render(r, 6 + off, cx - dd, y2);
/* 283 */         s.gate.render(r, 7 + off, cx, y2);
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static class Size
/*     */     {
/* 304 */       private final TILE_SHEET corners = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 308 */             ComposerSources.Full f = s.full;
/* 309 */             for (int i = 0; i <= 1; i++) {
/* 310 */               f.setVar(var + 5 * i);
/* 311 */               f.setSkip(1, 0).paste(true);
/* 312 */               f.setSkip(1, 5).paste(true);
/* 313 */               f.setSkip(1, 30).paste(true);
/* 314 */               f.setSkip(1, 35).paste(true);
/*     */             } 
/*     */             
/* 317 */             return d.s8.saveGame();
/*     */           }
/* 320 */         }).get();
/*     */       
/* 322 */       private final TILE_SHEET gate = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 326 */             ComposerSources.Full f = s.full;
/* 327 */             for (int i = 0; i <= 1; i++) {
/* 328 */               f.setVar(var + 5 * i);
/* 329 */               f.setSkip(1, 2).paste(true);
/* 330 */               f.setSkip(1, 3).paste(true);
/* 331 */               f.setSkip(1, 12).paste(true);
/* 332 */               f.setSkip(1, 18).paste(true);
/* 333 */               f.setSkip(1, 17).paste(true);
/* 334 */               f.setSkip(1, 23).paste(true);
/* 335 */               f.setSkip(1, 32).paste(true);
/* 336 */               f.setSkip(1, 33).paste(true);
/*     */             } 
/*     */             
/* 339 */             return d.s8.saveGame();
/*     */           }
/* 342 */         }).get();
/*     */       
/* 344 */       private final TILE_SHEET walls = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 348 */             ComposerSources.Full f = s.full;
/* 349 */             for (int i = 0; i <= 1; i++) {
/* 350 */               f.setVar(var + 5 * i);
/* 351 */               f.setSkip(1, 1).paste(true);
/* 352 */               f.setSkip(1, 4).paste(true);
/* 353 */               f.setSkip(1, 6).paste(true);
/* 354 */               f.setSkip(1, 11).paste(true);
/* 355 */               f.setSkip(1, 24).paste(true);
/* 356 */               f.setSkip(1, 29).paste(true);
/* 357 */               f.setSkip(1, 31).paste(true);
/* 358 */               f.setSkip(1, 34).paste(true);
/*     */             } 
/*     */             
/* 361 */             return d.s8.saveGame();
/*     */           }
/* 364 */         }).get();
/*     */ 
/*     */       
/*     */       Size(final int var) throws IOException {}
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Terrain
/*     */   {
/*     */     public final TILE_SHEET sheet;
/*     */     
/*     */     public final COLOR color;
/*     */     
/*     */     public Terrain(PATH getter, Json json) throws IOException {
/* 379 */       String t = "TERRAIN";
/* 380 */       String f = json.value(t);
/* 381 */       String k = t + "_" + t;
/* 382 */       if (WorldRaceSheet.map.containsKey(k)) {
/* 383 */         this.sheet = (TILE_SHEET)WorldRaceSheet.map.get(k);
/*     */       } else {
/* 385 */         this.sheet = (new ComposerThings.ITileSheet(getter.getFolder("terrain").get(f), 152, 76)
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 389 */               ComposerDests.Tile t = d.s16;
/* 390 */               ComposerSources.Full f = s.full;
/* 391 */               f.init(0, 0, 1, 1, 4, 4, t);
/* 392 */               f.paste(true);
/* 393 */               return t.saveGame();
/*     */             }
/* 395 */           }).get();
/* 396 */         WorldRaceSheet.map.put(k, this.sheet);
/*     */       } 
/* 398 */       this.color = (COLOR)new ColorImp(json, t + "_COLOR");
/*     */     }
/*     */     
/*     */     public void render(WRenContext con, int mask, int ran, int x, int y) {
/* 402 */       this.color.bind();
/* 403 */       int tile = ran & 0xF;
/* 404 */       (WORLD.BUILDINGS()).sprites.terrainStencil.renderTextured(this.sheet.getTexture(tile), mask, x, y);
/* 405 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Farm
/*     */   {
/*     */     public final TILE_SHEET sheet;
/*     */     public final LIST<ColorImp> color;
/*     */     
/*     */     public Farm(PATH getter, Json json) throws IOException {
/* 416 */       String t = "FARM";
/* 417 */       String f = json.value(t);
/* 418 */       String k = t + "_" + t;
/* 419 */       if (WorldRaceSheet.map.containsKey(k)) {
/* 420 */         this.sheet = (TILE_SHEET)WorldRaceSheet.map.get(k);
/*     */       } else {
/* 422 */         this.sheet = (new ComposerThings.ITileSheet(getter.getFolder("farm").get(f), 364, 50)
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 426 */               s.singles.init(0, 0, 1, 1, 8, 2, (ComposerDests.Dest)d.s16);
/* 427 */               s.singles.paste(true);
/* 428 */               return d.s16.saveGame();
/*     */             }
/* 430 */           }).get();
/* 431 */         WorldRaceSheet.map.put(k, this.sheet);
/*     */       } 
/* 433 */       this.color = ColorImp.cols(json, t + "_COLOR");
/*     */     }
/*     */     
/*     */     public void render(WRenContext con, int ran, int x, int y) {
/* 437 */       ((ColorImp)this.color.getC(ran)).bind();
/* 438 */       int tile = ran >> 8 & 0xF;
/* 439 */       this.sheet.render(con.r, tile, x, y);
/* 440 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\WorldRaceSheet.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */