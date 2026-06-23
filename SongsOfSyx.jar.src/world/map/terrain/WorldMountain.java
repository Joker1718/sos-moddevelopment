/*     */ package world.map.terrain;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Arrays;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_INT;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldMountain
/*     */   extends WorldTerrain.WorldTerrainResource
/*     */ {
/*     */   private byte[] data;
/*  51 */   private static byte NOTHING = -1;
/*  52 */   private final TILE_SHEET sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE_WORLD_MAP().get("Mountain"), 576, 316)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  56 */         ComposerDests.Tile t = d.s16;
/*  57 */         s.house2.init(0, 0, 3, 3, (ComposerDests.Dest)t);
/*     */         
/*  59 */         s.house2.setVar(0).paste(2, true);
/*  60 */         s.house2.setVar(1).paste(2, true);
/*  61 */         s.house2.setVar(2).paste(1, true);
/*     */         
/*  63 */         s.house2.setVar(3).paste(2, true);
/*  64 */         s.house2.setVar(4).paste(2, true);
/*  65 */         s.house2.setVar(5).paste(1, true);
/*     */         
/*  67 */         s.house2.setVar(6).paste(true);
/*  68 */         s.house2.setVar(7).paste(true);
/*  69 */         s.house2.setVar(8).paste(1, true);
/*     */         
/*  71 */         s.full.init(0, s.house2.body().y2(), 1, 1, 16, 3, t);
/*  72 */         s.full.setSkip(16, 0).paste(1, true);
/*  73 */         s.full.setSkip(4, 16).paste(3, true);
/*  74 */         return t.saveGame();
/*     */       }
/*  77 */     }).get();
/*     */ 
/*     */   
/*     */   private static final int SET = 16;
/*     */   private static final int EDGES = 0;
/*     */   private static final int FULLS = 128;
/*     */   private static final int TOPS = 256;
/*     */   private static final int SINGLES = 320;
/*     */   private static final int SINGLES_FULLS = 352;
/*     */   private static final int MAX_HEIGHT = 15;
/*  87 */   private final COLOR[] colors = (COLOR[])COLOR.interpolate((COLOR)new ColorImp(80, 80, 80), (COLOR)new ColorImp(210, 210, 210), 15);
/*  88 */   private final Bitmap1D top = new Bitmap1D(WORLD.TAREA(), false);
/*     */ 
/*     */   
/*     */   public final SPRITE icon;
/*     */ 
/*     */   
/*     */   int snowHeightI;
/*     */ 
/*     */   
/*     */   private final DIR[] checks;
/*     */ 
/*     */   
/*     */   private final boolean[] centres;
/*     */ 
/*     */   
/*     */   public MAP_BOOLEAN haser;
/*     */   
/*     */   public MAP_INT heighter;
/*     */   
/*     */   public final AreaTileMountain area;
/*     */ 
/*     */   
/*     */   private abstract class Placable
/*     */     extends PlacableMulti
/*     */   {
/*     */     public Placable(CharSequence name, SPRITE icon) {
/* 114 */       super(name, "", icon);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/* 120 */       super.renderPlaceHolder(r, mask, x + 32, y + 32, tx, ty, area, type, isPlacable, areaIsPlacable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void set(int tx, int ty, int value) {
/* 127 */     this.data[tx + ty * WORLD.TWIDTH()] = (byte)(this.data[tx + ty * WORLD.TWIDTH()] & 0xF0);
/* 128 */     this.data[tx + ty * WORLD.TWIDTH()] = (byte)(this.data[tx + ty * WORLD.TWIDTH()] | value & 0xF);
/* 129 */     WORLD.changeTile(tx, ty);
/*     */   }
/*     */   
/*     */   private int get(int tile) {
/* 133 */     return this.data[tile] & 0xF;
/*     */   }
/*     */   
/*     */   private int height(int tx, int ty) {
/* 137 */     return height(tx + ty * WORLD.TWIDTH());
/*     */   }
/*     */   
/*     */   private int height(int tile) {
/* 141 */     return this.data[tile] >> 4 & 0xF;
/*     */   }
/*     */   
/*     */   private void heightSet(int tile, int h) {
/* 145 */     if (h > 14) {
/* 146 */       h = 14;
/* 147 */     } else if (h < 0) {
/* 148 */       h = 0;
/* 149 */     }  h <<= 4;
/* 150 */     this.data[tile] = (byte)(this.data[tile] & 0xF);
/* 151 */     this.data[tile] = (byte)(this.data[tile] | h);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean has(int tile) {
/* 156 */     return (this.data[tile] != NOTHING);
/*     */   }
/*     */   
/*     */   public void pClear(int tx, int ty) {
/* 160 */     if (WORLD.IN_BOUNDS(tx, ty)) {
/* 161 */       this.data[tx + ty * WORLD.TWIDTH()] = NOTHING;
/*     */     }
/*     */   }
/*     */   
/*     */   void placeRaw(int tx, int ty) {
/* 166 */     if (WORLD.IN_BOUNDS(tx, ty)) {
/* 167 */       this.data[tx + ty * WORLD.TWIDTH()] = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isp(int tx, int ty) {
/* 172 */     if (WORLD.IN_BOUNDS(tx, ty)) {
/* 173 */       return (this.data[tx + ty * WORLD.TWIDTH()] != NOTHING);
/*     */     }
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isp(int tx, int ty, DIR d) {
/* 181 */     return isp(tx + d.x(), ty + d.y());
/*     */   }
/*     */ 
/*     */   
/*     */   void fix(int tx, int ty) {
/* 186 */     if (!isp(tx, ty)) {
/*     */       return;
/*     */     }
/* 189 */     setHeight(tx, ty);
/* 190 */     GUTIL.flooder().init(this);
/* 191 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 192 */       if (isp(tx, ty, (DIR)DIR.ALL.get(i))) {
/* 193 */         GUTIL.flooder().pushSloppy(tx, ty, (DIR)DIR.ALL.get(i), 0.0D);
/*     */       }
/*     */     } 
/*     */     
/* 197 */     while (GUTIL.flooder().hasMore()) {
/* 198 */       PathTile t = GUTIL.flooder().pollAndReopen();
/* 199 */       if (!setHeight(t.x(), t.y()))
/*     */         continue; 
/* 201 */       for (int k = 0; k < DIR.ALL.size(); k++) {
/* 202 */         if (isp(t.x(), t.y(), (DIR)DIR.ALL.get(k))) {
/* 203 */           GUTIL.flooder().pushSloppy(t.x(), t.y(), (DIR)DIR.ALL.get(k), 0.0D);
/*     */         }
/*     */       } 
/*     */     } 
/* 207 */     GUTIL.flooder().done();
/*     */     
/* 209 */     int h = getHeight(tx, ty);
/* 210 */     int da = get(tx + ty * WORLD.TWIDTH());
/* 211 */     int j = tx + ty * WORLD.TWIDTH();
/* 212 */     this.top.set(j, true);
/* 213 */     for (DIR d : DIR.ORTHO) {
/* 214 */       if (WORLD.IN_BOUNDS(tx, ty, d) && (d.mask() & da) != 0 && getHeight(tx + d.x(), ty + d.y()) > h && (get(j + d.x() + d.y() * WORLD.TWIDTH()) & 0xF) != 0) {
/* 215 */         this.top.set(tx + ty * WORLD.TWIDTH(), false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void sink(int tx, int ty) {
/* 222 */     if (!isp(tx, ty)) {
/*     */       return;
/*     */     }
/* 225 */     int h = height(tx, ty);
/* 226 */     int newHeight = h - 1;
/* 227 */     if (newHeight < 0)
/* 228 */       newHeight = 0; 
/* 229 */     heightSet(tx + ty * WORLD.TWIDTH(), newHeight);
/*     */     
/* 231 */     GUTIL.flooder().init(this);
/* 232 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 233 */       if (isp(tx, ty, (DIR)DIR.ALL.get(i))) {
/* 234 */         GUTIL.flooder().pushSloppy(tx, ty, (DIR)DIR.ALL.get(i), 0.0D);
/*     */       }
/*     */     } 
/*     */     
/* 238 */     while (GUTIL.flooder().hasMore()) {
/* 239 */       PathTile t = GUTIL.flooder().pollAndReopen();
/* 240 */       if ((tx == t.x() && ty == t.y()) || !setHeight(t.x(), t.y()))
/*     */         continue; 
/* 242 */       for (int j = 0; j < DIR.ALL.size(); j++) {
/* 243 */         if (isp(t.x(), t.y(), (DIR)DIR.ALL.get(j))) {
/* 244 */           GUTIL.flooder().pushSloppy(t.x(), t.y(), (DIR)DIR.ALL.get(j), 0.0D);
/*     */         }
/*     */       } 
/*     */     } 
/* 248 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean setHeight(int tx, int ty) {
/* 253 */     int height = getHeight(tx, ty);
/*     */     
/* 255 */     if (!neigboursTerrain(tx, ty)) {
/* 256 */       int lowest = 15;
/*     */       
/* 258 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 259 */         DIR d = (DIR)DIR.ALL.get(i);
/* 260 */         int h = getHeight(tx, ty, d);
/* 261 */         if (h < lowest) {
/* 262 */           lowest = h;
/*     */         }
/*     */       } 
/*     */       
/* 266 */       if (height != lowest + 1 && height != 15) {
/* 267 */         heightSet(tx + ty * WORLD.TWIDTH(), lowest);
/* 268 */         return true;
/*     */       } 
/*     */     } else {
/* 271 */       heightSet(tx + ty * WORLD.TWIDTH(), 0);
/*     */     } 
/*     */     
/* 274 */     set(tx, ty, getJoin(tx, ty));
/*     */ 
/*     */     
/* 277 */     return false;
/*     */   }
/*     */   
/*     */   private int getJoin(int tx, int ty) {
/* 281 */     int height = getHeight(tx, ty);
/* 282 */     int res = 0;
/*     */     
/* 284 */     for (DIR d : DIR.NORTHO) {
/* 285 */       int x = tx + (d.x() + 1) / 2;
/* 286 */       int y = ty + (d.y() + 1) / 2;
/* 287 */       if (!(WORLD.WATER()).has.is(x, y) && 
/* 288 */         getHeight(tx, ty, d) >= height && getHeight(tx, ty, d.next(-1)) >= height && getHeight(tx, ty, d.next(1)) >= height) {
/* 289 */         res |= d.mask();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 294 */     return res;
/*     */   }
/*     */   
/*     */   public int getHeight(int tx, int ty) {
/* 298 */     if (!WORLD.IN_BOUNDS(tx, ty))
/* 299 */       return 15; 
/* 300 */     if (!isp(tx, ty))
/* 301 */       return 0; 
/* 302 */     if (neigboursTerrain(tx, ty))
/* 303 */       return 1; 
/* 304 */     return 1 + height(tx, ty);
/*     */   }
/*     */   
/*     */   private boolean neigboursTerrain(int tx, int ty) {
/* 308 */     return !(!(WORLD.WATER()).has.is(tx, ty) && !(WORLD.WATER()).has.is(tx + 1, ty + 1) && !(WORLD.WATER()).has.is(tx + 1, ty) && !(WORLD.WATER()).has.is(tx, ty + 1));
/*     */   }
/*     */   
/*     */   private int getHeight(int tx, int ty, DIR d) {
/* 312 */     return getHeight(tx + d.x(), ty + d.y());
/*     */   }
/*     */   
/*     */   double getHeightNormalized(int tx, int ty) {
/* 316 */     return getHeight(tx, ty) / 15.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/* 321 */     saveFile.bs(this.data);
/* 322 */     this.top.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/* 327 */     saveFile.bs(this.data);
/* 328 */     this.top.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 333 */     Arrays.fill(this.data, NOTHING);
/* 334 */     this.top.setAll(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, ShadowBatch s, RenderData data) {
/* 342 */     RenderData.RenderIterator it = data.onScreenTiles(1, 0, 1, 0);
/*     */     
/* 344 */     this.snowHeightI = TIME.seasons().bitCurrent();
/*     */     
/* 346 */     while (it.has()) {
/*     */       
/* 348 */       if (has(it.tile())) {
/* 349 */         int t = get(it.tile());
/* 350 */         int h = height(it.tile());
/* 351 */         this.colors[Math.max(h - 1, 0)].bind();
/* 352 */         int ran = it.ran();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 362 */         int x = it.x() + 32;
/* 363 */         int y = it.y() + 32;
/* 364 */         if (t == 0) {
/* 365 */           if (h == 0) {
/* 366 */             this.colors[h].bind();
/* 367 */             this.sheet.render(r, 320 + (ran & 0x1F), x, y);
/*     */           } else {
/*     */             
/* 370 */             this.sheet.render(r, 352 + (ran & 0xF), x, y);
/* 371 */             if (h > 2) {
/* 372 */               render(h, 15, ran, 352 + (ran & 0xF), x, y);
/*     */             }
/*     */           }
/*     */         
/* 376 */         } else if (h == 0) {
/* 377 */           this.sheet.render(r, t + 0 + (ran & 0x7) * 16, x, y);
/*     */         } else {
/* 379 */           int tile = t + 128 + (ran & 0x7) * 16;
/* 380 */           this.sheet.render(r, tile, x, y);
/* 381 */           render(h, t, ran, tile, x, y);
/*     */ 
/*     */           
/* 384 */           this.colors[h].bind();
/* 385 */           tile = t + 256 + (ran & 0x3) * 16;
/* 386 */           this.sheet.render(r, tile, x, y);
/* 387 */           render(h, t, ran, tile, x, y);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 394 */         if (h >= 2) {
/* 395 */           it.hiddenSet();
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 400 */       it.next();
/*     */     } 
/* 402 */     COLOR.unbind();
/*     */   } private void render(int h, int rot, int ran, int tile, int x, int y) {} public boolean coversTile(int tx, int ty) {
/*     */     if ((WORLD.WATER()).has.is(tx, ty))
/*     */       return false; 
/*     */     if (getHeight(tx, ty) == 0 && (get(tx + ty * WORLD.TWIDTH()) & DIR.NW.mask()) == 0)
/*     */       return false; 
/*     */     byte b;
/*     */     int i;
/*     */     DIR[] arrayOfDIR;
/*     */     for (i = (arrayOfDIR = this.checks).length, b = 0; b < i; ) {
/*     */       DIR d = arrayOfDIR[b];
/*     */       int x = tx + d.x();
/*     */       int y = ty + d.y();
/*     */       int j = x + y * WORLD.TWIDTH();
/*     */       if (WORLD.IN_BOUNDS(x, y))
/*     */         if (!has(j))
/*     */           return false;  
/*     */       b++;
/*     */     } 
/*     */     return true;
/*     */   } public boolean is(int tx, int ty) {
/*     */     return !(!is(tx, ty, DIR.NW) && !is(tx - 1, ty, DIR.NE) && !is(tx - 1, ty - 1, DIR.SE) && !is(tx, ty - 1, DIR.SW));
/*     */   } private boolean is(int tx, int ty, DIR d) {
/*     */     if (!isp(tx, ty))
/*     */       return false; 
/*     */     if (getHeight(tx, ty) > 1)
/*     */       return true; 
/*     */     int m = get(tx + ty * WORLD.TWIDTH());
/*     */     return !((m & d.mask()) <= 0 && !this.centres[m]);
/* 431 */   } WorldMountain() throws IOException { this.checks = new DIR[] { DIR.C, DIR.W, DIR.NW, DIR.N };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 454 */     this
/* 455 */       .centres = new boolean[] { true, true, true, true, true, true, true, true };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 467 */     this.haser = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 471 */           return (WORLD.IN_BOUNDS(tx, ty) && WorldMountain.this.is(tx, ty));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 476 */           int tx = tile % WORLD.TWIDTH();
/* 477 */           int ty = tile / WORLD.TWIDTH();
/* 478 */           return is(tx, ty);
/*     */         }
/*     */       };
/*     */     
/* 482 */     this.heighter = new MAP_INT()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/* 486 */           int h = 16; byte b; int i; DIR[] arrayOfDIR;
/* 487 */           for (i = (arrayOfDIR = WorldMountain.this.checks).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/* 488 */             int x = tx + d.x();
/* 489 */             int y = ty + d.y();
/* 490 */             if (WORLD.IN_BOUNDS(x, y)) {
/*     */               
/* 492 */               int j = x + y * WORLD.TWIDTH();
/* 493 */               if (WorldMountain.this.has(j))
/* 494 */               { h = Math.min(h, WorldMountain.this.height(j) + 1); }
/*     */               else
/* 496 */               { return 0; } 
/*     */             }  b++; }
/* 498 */            return h;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/* 503 */           return get(tile % WORLD.TWIDTH(), tile / WORLD.TWIDTH());
/*     */         }
/*     */       };
/*     */     
/* 507 */     this.area = new AreaTileMountain();
/*     */     this.data = Alloc.bb(WORLD.TAREA());
/*     */     for (int i = 0; i < this.data.length; i++)
/*     */       this.data[i] = NOTHING; 
/*     */     this.icon = (SPRITE)new SPRITE.Imp(32) {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { int d = (Y2 - Y1) / 2;
/*     */           WorldMountain.this.sheet.render(r, 0 + DIR.SE.mask(), X1, X1 + d, Y1, Y1 + d);
/*     */           WorldMountain.this.sheet.render(r, 0 + DIR.SW.mask(), X1 + d, X1 + d * 2, Y1, Y1 + d);
/*     */           WorldMountain.this.sheet.render(r, 0 + DIR.NE.mask(), X1, X1 + d, Y1 + d, Y1 + d * 2);
/*     */           WorldMountain.this.sheet.render(r, 0 + DIR.NW.mask(), X1 + d, X1 + d * 2, Y1 + d, Y1 + d * 2); }
/* 517 */       }; } public static final class AreaTileMountain { public boolean is(int tx, int ty, DIR d) { if (d == DIR.C)
/* 518 */         return ispp(tx, ty, DIR.NW); 
/* 519 */       if (d == DIR.N)
/* 520 */         return ispp(tx, ty - 1, DIR.W); 
/* 521 */       if (d == DIR.NE)
/* 522 */         return ispp(tx, ty - 1, DIR.C); 
/* 523 */       if (d == DIR.E)
/* 524 */         return ispp(tx, ty, DIR.N); 
/* 525 */       if (d == DIR.SE)
/* 526 */         return ispp(tx, ty, DIR.C); 
/* 527 */       if (d == DIR.S)
/* 528 */         return ispp(tx, ty, DIR.W); 
/* 529 */       if (d == DIR.SW)
/* 530 */         return ispp(tx - 1, ty, DIR.C); 
/* 531 */       if (d == DIR.W) {
/* 532 */         return ispp(tx - 1, ty, DIR.N);
/*     */       }
/* 534 */       return ispp(tx - 1, ty - 1, DIR.C); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean ispp(int tx, int ty, DIR d) {
/* 542 */       if (!WORLD.MOUNTAIN().isp(tx, ty))
/* 543 */         return false; 
/* 544 */       if (WORLD.MOUNTAIN().getHeight(tx, ty) > 1)
/* 545 */         return true; 
/* 546 */       int m = WORLD.MOUNTAIN().get(tx + ty * WORLD.TWIDTH());
/* 547 */       if (d == DIR.C)
/* 548 */         return (WORLD.MOUNTAIN()).centres[m]; 
/* 549 */       if (d.isOrtho()) {
/* 550 */         return ((m & d.next(1).mask()) > 0 && (m & d.next(-1).mask()) > 0);
/*     */       }
/* 552 */       return ((m & d.mask()) > 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean borders(int tx, int ty, DIR d) {
/* 558 */       if (d == DIR.C) {
/* 559 */         throw new RuntimeException();
/*     */       }
/* 561 */       if (d == DIR.N)
/* 562 */         return WORLD.MOUNTAIN().is(tx, ty - 1, DIR.NW); 
/* 563 */       if (d == DIR.NE)
/* 564 */         return WORLD.MOUNTAIN().is(tx, ty - 1, DIR.NE); 
/* 565 */       if (d == DIR.E)
/* 566 */         return WORLD.MOUNTAIN().is(tx, ty, DIR.NE); 
/* 567 */       if (d == DIR.SE)
/* 568 */         return WORLD.MOUNTAIN().is(tx, ty, DIR.SE); 
/* 569 */       if (d == DIR.S)
/* 570 */         return WORLD.MOUNTAIN().is(tx, ty, DIR.SW); 
/* 571 */       if (d == DIR.SW)
/* 572 */         return WORLD.MOUNTAIN().is(tx - 1, ty, DIR.SW); 
/* 573 */       if (d == DIR.W) {
/* 574 */         return WORLD.MOUNTAIN().is(tx - 1, ty, DIR.NW);
/*     */       }
/* 576 */       return WORLD.MOUNTAIN().is(tx - 1, ty - 1, DIR.NW);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   double add(WorldTerrainInfo info, int tx, int ty) {
/* 584 */     if (is(tx, ty)) {
/* 585 */       double m = 0.0D;
/* 586 */       for (DIR d : DIR.ALLC) {
/* 587 */         if (is(tx, ty, d))
/* 588 */           m++; 
/*     */       } 
/* 590 */       m /= DIR.ALLC.size();
/* 591 */       info.add(TERRAINS.MOUNTAIN(), m);
/* 592 */       return m;
/*     */     } 
/* 594 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public void clear(int tx, int ty) {
/* 598 */     pClear(tx, ty);
/* 599 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 600 */       fix(tx + ((DIR)DIR.ALL.get(i)).x(), ty + ((DIR)DIR.ALL.get(i)).y());
/*     */     }
/* 602 */     WORLD.MINIMAP().update(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<PLACABLE> placers(ToolManager tm) {
/* 608 */     ArrayListGrower<PLACABLE> placers = new ArrayListGrower();
/*     */     
/* 610 */     final Placable clear = new Placable(this, "clear mountain", this.icon.twin((SPRITE)(UI.icons()).m.anti, DIR.C, 0))
/*     */       {
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 614 */           return WorldMountain.this.isp(tx, ty) ? null : "";
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 619 */           WorldMountain.this.pClear(tx, ty);
/* 620 */           for (int i = 0; i < DIR.ALL.size(); i++) {
/* 621 */             WorldMountain.this.fix(tx + ((DIR)DIR.ALL.get(i)).x(), ty + ((DIR)DIR.ALL.get(i)).y());
/*     */           }
/* 623 */           WORLD.MINIMAP().update(tx, ty);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 628 */     Placable placable2 = new Placable(this, "mountain", this.icon)
/*     */       {
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 632 */           return WORLD.IN_BOUNDS(tx, ty) ? null : "";
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 637 */           if (!WorldMountain.this.isp(tx, ty)) {
/* 638 */             WorldMountain.this.placeRaw(tx, ty);
/* 639 */             WorldMountain.this.fix(tx, ty);
/* 640 */             for (int i = 0; i < DIR.ALL.size(); i++) {
/* 641 */               WorldMountain.this.fix(tx + ((DIR)DIR.ALL.get(i)).x(), ty + ((DIR)DIR.ALL.get(i)).y());
/*     */             }
/* 643 */             WORLD.MINIMAP().update(tx, ty);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/* 649 */           return clear;
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 654 */           return WorldMountain.this.icon;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 659 */     Placable placable3 = new Placable(this, "sink mountain", this.icon.twin((SPRITE)(UI.icons()).m.arrow_down, DIR.S, 0))
/*     */       {
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 663 */           return WorldMountain.this.isp(tx, ty) ? null : "";
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 668 */           WorldMountain.this.sink(tx, ty);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 673 */     placers.add(placable2);
/* 674 */     placers.add(placable3);
/* 675 */     placers.add(placable1);
/* 676 */     return (LIST<PLACABLE>)placers;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldMountain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */