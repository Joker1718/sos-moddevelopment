/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.thing.pointlight.LOS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.INFO;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TMountain
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private static final int SET = 16;
/*     */   private final int SINGLES;
/*     */   final Ceiling CAVE;
/*     */   private final TerrainClearing clear;
/*     */   private final TILE_SHEET sheet;
/*     */   private final Minimap mini;
/*     */   
/*     */   static TMountain make(Terrain t) throws IOException {
/*  49 */     final TILE_SHEET sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT().getFolder("map").get("Mountain"), 576, 256)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  53 */           ComposerDests.Tile t = d.s16;
/*  54 */           s.house2.init(0, 0, 3, 1, (ComposerDests.Dest)t);
/*  55 */           s.house2.setVar(0).paste(1, true);
/*  56 */           s.house2.setVar(1).paste(2, true);
/*  57 */           s.house2.setVar(2).paste(2, true);
/*     */           
/*  59 */           s.full.init(0, s.house2.body().y2(), 1, 1, 16, 1, t);
/*  60 */           s.full.setSkip(16, 0).paste(true);
/*     */ 
/*     */           
/*  63 */           return t.saveGame();
/*     */         }
/*  65 */       }).get();
/*     */     
/*  67 */     final TILE_SHEET mountain_ceiling = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  71 */           ComposerDests.Tile t = d.s16;
/*     */           
/*  73 */           s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)t);
/*  74 */           for (int i = 0; i < 3; i++) {
/*  75 */             s.house.setVar(i);
/*  76 */             s.house.setSkip(0, 16).paste(1, true);
/*     */           } 
/*  78 */           s.house.setVar(0);
/*  79 */           s.house.setSkip(0, 1).pasteEdges(true);
/*     */ 
/*     */           
/*  82 */           s.house.setVar(3).setSkip(0, 16).paste(true);
/*  83 */           s.house.setVar(3).setSkip(0, 1).pasteEdges(true);
/*     */           
/*  85 */           s.house2.init(0, s.house.body().y2(), 3, 1, (ComposerDests.Dest)t);
/*     */           
/*  87 */           s.house2.paste(true);
/*  88 */           s.house2.setVar(1).paste(true);
/*  89 */           s.house2.setVar(2).paste(1, true);
/*  90 */           s.full.init(0, s.house2.body().y2(), 1, 1, 16, 1, t);
/*  91 */           s.full.paste(true);
/*     */           
/*  93 */           return t.saveGame();
/*     */         }
/*  97 */       }).get();
/*     */     
/*  99 */     SPRITE.Imp imp1 = new SPRITE.Imp(32) {
/* 100 */         private COLOR bg = (COLOR)new ColorImp(102, 87, 65);
/* 101 */         private COLOR bg2 = (COLOR)this.bg.shade(0.6D);
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 104 */           this.bg2.render(r, X1, X2, Y1, Y2);
/* 105 */           this.bg.render(r, X1 + 2, X2 - 2, Y1 + 2, Y2 - 2);
/* 106 */           rr(r, X1, X2, Y1, Y2);
/*     */         }
/*     */         
/*     */         private void rr(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 110 */           int c = 16 * (X2 - X1) / 32;
/*     */           
/* 112 */           sheet.render(r, DIR.SE.mask(), X1, X1 + c, Y1, Y1 + c);
/* 113 */           sheet.render(r, DIR.SW.mask(), X1 + c, X1 + c * 2, Y1, Y1 + c);
/* 114 */           sheet.render(r, DIR.NE.mask(), X1, X1 + c, Y1 + c, Y1 + c * 2);
/* 115 */           sheet.render(r, DIR.NW.mask(), X1 + c, X1 + c * 2, Y1 + c, Y1 + c * 2);
/*     */         }
/*     */       };
/*     */     
/* 119 */     SPRITE.Imp imp2 = new SPRITE.Imp(32)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 123 */           COLOR.WHITE200.bind();
/* 124 */           rr(r, X1 - 1, X2 - 1, Y1 - 1, Y2 - 1);
/* 125 */           COLOR.unbind();
/* 126 */           rr(r, X1, X2, Y1, Y2);
/*     */         }
/*     */         
/*     */         private void rr(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 130 */           int c = 16 * (X2 - X1) / 32;
/*     */           
/* 132 */           mountain_ceiling.render(r, DIR.SE.mask(), X1, X1 + c, Y1, Y1 + c);
/* 133 */           mountain_ceiling.render(r, DIR.SW.mask(), X1 + c, X1 + c * 2, Y1, Y1 + c);
/* 134 */           mountain_ceiling.render(r, DIR.NE.mask(), X1, X1 + c, Y1 + c, Y1 + c * 2);
/* 135 */           mountain_ceiling.render(r, DIR.NW.mask(), X1 + c, X1 + c * 2, Y1 + c, Y1 + c * 2);
/*     */         }
/*     */       };
/*     */     
/* 139 */     return new TMountain(t, sheet, mountain_ceiling, (SPRITE)imp1, (SPRITE)imp2);
/*     */   }
/*     */   public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/*     */     return this.mini.miniCPimp(c, x, y, northern, southern);
/* 143 */   } TMountain(Terrain t, TILE_SHEET sheet, TILE_SHEET sheetC, SPRITE icon, SPRITE iconC) { super("MOUNTAIN", t, (new INFO(new Json(PATHS.TEXT().getFolder("settlement").getFolder("structure").gets("_MOUNTAIN")))).name, icon, t.colors.minimap.mountain);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     this.mini = new Minimap(); this.sheet = sheet; this.SINGLES = 128; this.CAVE = new Ceiling(t, sheetC, iconC); this.clear = new TerrainClearing() {
/*     */         private final SoundRace sound = AUDIO.race("CLEAR_MOUNTAIN");
/*     */         public RESOURCE clear1(int tx, int ty) { if (!TMountain.this.is(tx, ty)) { GAME.Notify("" + tx + " " + tx); return null; }  int a = TMountain.this.resourceGet(TMountain.this.shared.data.get(tx, ty)); RESOURCE res = (a % 4 == 0) ? RESOURCES.STONE() : null; a--; if (a < 0) { TMountain.this.shared.CAVE.placeFixed(tx, ty); return res; }  a = TMountain.this.resourceSet(TMountain.this.shared.data.get(tx, ty), a); TMountain.this.shared.data.set(tx, ty, a); return res; } public boolean can() { return true; } public int clearAll(int tx, int ty) { int a = 1 + TMountain.this.resourceGet(TMountain.this.shared.data.get(tx, ty)) / 4; TMountain.this.shared.CAVE.placeFixed(tx, ty); return a; } public SoundRace sound(int tx, int ty) { return this.sound; } public boolean isStructure() { return true; } public boolean canDestroy(int tx, int ty) { return true; } public void destroy(int tx, int ty) { TMountain.this.shared.CAVE.placeFixed(tx, ty); } public double strength() { return 64000.0D; }
/*     */       }; } private static class Minimap
/*     */   {
/* 220 */     private final int w = 64;
/* 221 */     private final int h = 32;
/* 222 */     private byte[][] values = new byte[32][64];
/*     */     
/*     */     Minimap() {
/* 225 */       for (int i = 0; i < 32; i += 4) {
/* 226 */         int sx = ((i & 0x4) != 0) ? 8 : 0;
/* 227 */         drawWave(sx, i, (byte)-50, 8);
/* 228 */         drawWave(sx, i + 1, (byte)40, 8);
/* 229 */         drawWave(sx, i + 2, (byte)30, 8);
/* 230 */         drawWave(sx, i + 3, (byte)20, 8);
/* 231 */         drawWave(sx, i + 4, (byte)10, 8);
/* 232 */         drawWave(sx, i + 5, (byte)5, 8);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void drawWave(int sx, int sy, byte v, int period) {
/* 242 */       for (int i = 0; i < 64; i++) {
/* 243 */         int x = i + sx & 0x3F;
/* 244 */         int y = i & period - 1;
/* 245 */         if ((i & period) != 0)
/* 246 */           y = period - y; 
/* 247 */         y += sy;
/* 248 */         y &= 0x1F;
/* 249 */         this.values[y][x] = v;
/*     */       } 
/*     */     }
/*     */     
/*     */     COLOR miniCPimp(ColorImp c, int tx, int ty, boolean northern, boolean southern) {
/* 254 */       int x = tx & 0x3F;
/* 255 */       int y = ty & 0x1F;
/* 256 */       if (this.values[y][x] != 0) {
/* 257 */         double v = 1.0D - 0.5D * this.values[y][x] / 128.0D;
/* 258 */         c.shadeSelf(v);
/*     */       } 
/*     */       
/* 261 */       if (northern != southern)
/* 262 */       { if (northern) {
/* 263 */           c.shadeSelf(1.5D);
/*     */         } else {
/* 265 */           c.shadeSelf(0.75D);
/*     */         }  }
/* 267 */       else { for (DIR d : DIR.ORTHO) {
/* 268 */           if ((SETT.TERRAIN()).CAVE.is(tx, ty, d)) {
/* 269 */             c.interpolate((COLOR)c, (SETT.TERRAIN()).CAVE.miniC, 0.5D);
/*     */             
/*     */             break;
/*     */           } 
/*     */         }  }
/*     */       
/* 275 */       return (COLOR)c;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TERRAIN terrain(int tx, int ty) {
/* 282 */     return TERRAINS.MOUNTAIN();
/*     */   }
/*     */ 
/*     */   
/*     */   public LOS los(int tx, int ty) {
/* 287 */     return LOS.SOLID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMassiveWall() {
/* 294 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/* 299 */     int am = resourceGet(this.shared.data.get(tx, ty));
/* 300 */     boolean was = is(tx, ty);
/*     */     
/* 302 */     placeRaw(tx, ty);
/* 303 */     int res = 0;
/* 304 */     for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 305 */       DIR d = (DIR)DIR.NORTHO.get(i);
/* 306 */       if (joins(tx, ty, d) && joins(tx, ty, d.next(-1)) && joins(tx, ty, d.next(1))) {
/* 307 */         res |= d.mask();
/*     */       }
/*     */     } 
/* 310 */     if (res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.N)) {
/* 311 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.N);
/* 312 */       if (t != this && t != this.CAVE.opening && t.wallIsWally() && !t.roofIs() && (res & DIR.NW.mask()) != 0) {
/* 313 */         res |= 0x10;
/*     */       }
/*     */     } 
/* 316 */     if (res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.W)) {
/* 317 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.W);
/* 318 */       if (t != this && t != this.CAVE.opening && t.wallIsWally() && !t.roofIs() && (res & DIR.NW.mask()) != 0) {
/* 319 */         res |= 0x20;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 324 */     if (was) {
/* 325 */       this.shared.data.set(tx, ty, resourceSet(res, am));
/*     */     } else {
/*     */       
/* 328 */       this.shared.data.set(tx, ty, resourceSet(res, 15));
/*     */     } 
/*     */ 
/*     */     
/* 332 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeRaw(int x, int y) {
/* 337 */     super.placeRaw(x, y);
/* 338 */     strengthSet(x, y, 15.0D);
/*     */   }
/*     */   
/*     */   private int resourceGet(int data) {
/* 342 */     return data >> 8 & 0xF;
/*     */   }
/*     */   
/*     */   public double strength(int tile) {
/* 346 */     return resourceGet(this.shared.data.get(tile)) / 15.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int resourceSet(int data, int amount) {
/* 352 */     if (amount > 15 || amount < 0)
/* 353 */       GAME.Notify("" + amount); 
/* 354 */     amount = CLAMP.i(amount, 0, 15);
/*     */     
/* 356 */     amount <<= 8;
/* 357 */     data &= 0xFF;
/* 358 */     data |= amount;
/* 359 */     return data;
/*     */   }
/*     */   
/*     */   public void strengthSet(int tx, int ty, double s) {
/* 363 */     if (is(tx, ty)) {
/* 364 */       int am = CLAMP.i((int)(s * 15.0D), 1, 15);
/* 365 */       int data = this.shared.data.get(tx, ty);
/* 366 */       data = resourceSet(data, am);
/* 367 */       this.shared.data.set(tx, ty, data);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box, int tx, int ty) {
/* 373 */     super.hoverInfo(box, tx, ty);
/* 374 */     int am = this.shared.data.get(tx, ty) >> 8 & 0xF;
/* 375 */     am = 1 + am / 4;
/* 376 */     box.setResource(RESOURCES.STONE(), am);
/*     */   }
/*     */   
/*     */   private boolean joins(int x, int y, DIR d) {
/* 380 */     x += d.x();
/* 381 */     y += d.y();
/* 382 */     if (!SETT.IN_BOUNDS(x, y))
/* 383 */       return true; 
/* 384 */     return this.shared.get(x, y).wallJoiner();
/*     */   }
/*     */ 
/*     */   
/*     */   boolean wallJoiner() {
/* 389 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean wallIsWally() {
/* 394 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isMountain(int tx, int ty) {
/* 398 */     return !(!is(tx, ty) && !this.CAVE.is(tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean coversCompletely(int tx, int ty) {
/* 403 */     return ((this.shared.data.get(tx, ty) & 0xF) == 15);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 408 */     i.countCave();
/* 409 */     int x = i.x();
/* 410 */     int y = i.y();
/* 411 */     int ran = i.ran();
/*     */     
/* 413 */     int code = data & 0xF;
/*     */     
/* 415 */     TILE_SHEET sheet = this.sheet;
/*     */     
/* 417 */     if (code == 15) {
/* 418 */       sheet.render(r, 15, x, y);
/* 419 */       return true;
/*     */     } 
/*     */     
/* 422 */     if (code == 0) {
/* 423 */       s.setHeight(3).setDistance2Ground(0.0D);
/* 424 */       int c = this.SINGLES + (ran & 0xF);
/* 425 */       sheet.render(r, c, x, y);
/* 426 */       sheet.render((SPRITE_RENDERER)s, c, x, y);
/*     */     } else {
/* 428 */       s.setHeight(10).setDistance2Ground(0.0D);
/* 429 */       int c = code + (ran & 0x7) * 16;
/* 430 */       sheet.render(r, c, x, y);
/* 431 */       sheet.render((SPRITE_RENDERER)s, c, x, y);
/* 432 */       renderEdges(r, s, i, data);
/*     */     } 
/*     */     
/* 435 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean wantsFloorUnderneath(int tx, int ty) {
/* 440 */     return ((this.shared.data.get(tx, ty) & 0xF) != 15);
/*     */   }
/*     */   
/*     */   private void renderEdges(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 444 */     int cor = data;
/* 445 */     if ((data & 0x10) != 0) {
/* 446 */       if ((cor & DIR.NW.mask()) == 0) {
/* 447 */         (SETT.TERRAIN()).wall_merge.render(r, 0, i.x(), i.y() - 4);
/*     */       } else {
/* 449 */         (SETT.TERRAIN()).wall_merge.render(r, 2, i.x(), i.y() - 4);
/* 450 */       }  if ((cor & DIR.NE.mask()) == 0) {
/* 451 */         (SETT.TERRAIN()).wall_merge.render(r, 1, i.x(), i.y() - 4);
/*     */       } else {
/* 453 */         (SETT.TERRAIN()).wall_merge.render(r, 3, i.x(), i.y() - 4);
/*     */       } 
/* 455 */     }  if ((data & 0x20) != 0) {
/* 456 */       if ((cor & DIR.NW.mask()) == 0) {
/* 457 */         (SETT.TERRAIN()).wall_merge.render(r, 5, i.x() - 4, i.y());
/*     */       } else {
/* 459 */         (SETT.TERRAIN()).wall_merge.render(r, 7, i.x() - 4, i.y());
/* 460 */       }  if ((cor & DIR.SW.mask()) == 0) {
/* 461 */         (SETT.TERRAIN()).wall_merge.render(r, 4, i.x() - 4, i.y());
/*     */       } else {
/* 463 */         (SETT.TERRAIN()).wall_merge.render(r, 6, i.x() - 4, i.y());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 470 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 475 */     return AVAILABILITY.SOLID;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 480 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/* 485 */     return this.clear;
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightStart(int tx, int ty) {
/* 490 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightEnd(int tx, int ty) {
/* 495 */     return 20;
/*     */   }
/*     */   
/*     */   public static class Ceiling
/*     */     extends Terrain.TerrainTile {
/*     */     private static final int SET = 16;
/*     */     private final TILE_SHEET sheet;
/*     */     private final int SHEET_CORNER;
/*     */     private final int SHEET_FIX;
/*     */     final Opening opening;
/*     */     private final TerrainClearing clear;
/*     */     
/*     */     private Ceiling(Terrain t, TILE_SHEET s, SPRITE icon) {
/* 508 */       super("CAVE", t, "cave", icon, (COLOR)t.colors.minimap.mountain.shade(1.5D));
/* 509 */       this.sheet = s;
/* 510 */       this.SHEET_CORNER = 96;
/* 511 */       this.SHEET_FIX = this.SHEET_CORNER + 16;
/* 512 */       this.opening = new Opening(t, this.sheet, icon, this.SHEET_FIX + 32);
/* 513 */       this.clear = new TerrainClearing()
/*     */         {
/*     */           
/*     */           public RESOURCE clear1(int tx, int ty)
/*     */           {
/* 518 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean can() {
/* 523 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public int clearAll(int tx, int ty) {
/* 528 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public SoundRace sound(int tx, int ty) {
/* 533 */             return null;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isStructure() {
/* 539 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean needs() {
/* 544 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean canDestroy(int tx, int ty) {
/* 549 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public double strength() {
/* 554 */             return 0.0D;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public TERRAIN terrain(int tx, int ty) {
/* 561 */       return TERRAINS.MOUNTAIN();
/*     */     }
/*     */ 
/*     */     
/*     */     public TerrainClearing clearing() {
/* 566 */       return this.clear;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean place(int x, int y) {
/* 572 */       if (this.opening.isPlacable(x, y)) {
/* 573 */         return this.opening.place(x, y);
/*     */       }
/*     */       
/* 576 */       placeRaw(x, y);
/* 577 */       int data = 0;
/* 578 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 579 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 580 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, d);
/* 581 */         if (t.wallIsWally()) {
/* 582 */           data |= d.mask();
/*     */         }
/*     */       } 
/*     */       
/* 586 */       data = setCorners(x, y, data);
/*     */       
/* 588 */       this.shared.data.set(x, y, data);
/* 589 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     private int setCorners(int x, int y, int res) {
/* 594 */       int corner = 0;
/* 595 */       for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 596 */         DIR d = (DIR)DIR.NORTHO.get(i);
/* 597 */         if (joins(x, y, d) && !joins(x, y, d.next(-1)) && !joins(x, y, d.next(1))) {
/* 598 */           corner |= d.mask();
/*     */         }
/*     */       } 
/* 601 */       res |= corner << 4;
/* 602 */       return res;
/*     */     }
/*     */     
/*     */     private boolean joins(int x, int y, DIR d) {
/* 606 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, d);
/* 607 */       return t.wallIsWally();
/*     */     }
/*     */ 
/*     */     
/*     */     private int getCorners(int data) {
/* 612 */       return data >> 4 & 0xF;
/*     */     }
/*     */     
/*     */     private int getData(int data, RenderData.RenderIterator i) {
/* 616 */       int res = data;
/* 617 */       Room r = (SETT.ROOMS()).map.get(i.tx(), i.ty());
/* 618 */       if (r != null)
/* 619 */         res |= 0x100; 
/* 620 */       if (r != null && r.constructor() != null && r.constructor().mustBeIndoors()) {
/* 621 */         res |= 0x100;
/* 622 */         for (DIR d : DIR.ORTHO) {
/* 623 */           if (!r.isSame(i.tx(), i.ty(), i.tx() + d.x(), i.ty() + d.y()))
/* 624 */             res |= d.mask(); 
/*     */         } 
/*     */       } else {
/* 627 */         for (DIR d : DIR.ORTHO) {
/* 628 */           r = (Room)(SETT.ROOMS()).map.get(i.tx(), i.ty(), d);
/* 629 */           if (r != null && r.constructor() != null && r.constructor().mustBeIndoors()) {
/* 630 */             res |= d.mask();
/* 631 */             res |= 0x100;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 636 */       return res;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 643 */       int x = i.x();
/* 644 */       int y = i.y();
/* 645 */       int ran = i.ran();
/*     */       
/* 647 */       data = getData(data, i);
/*     */       
/* 649 */       int a = data & 0xF;
/*     */       
/* 651 */       if ((data & 0x100) != 0) {
/* 652 */         if (a != 0) {
/* 653 */           int j = this.SHEET_FIX + a;
/* 654 */           this.sheet.render(r, j, x, y);
/*     */         } 
/*     */ 
/*     */         
/* 658 */         a = getCorners(data);
/* 659 */         if (a != 0) {
/* 660 */           this.sheet.render(r, this.SHEET_FIX + 16 + a, x, y);
/*     */         }
/*     */       } else {
/* 663 */         if (a != 0) {
/* 664 */           int j = a + ran % 5 * 16;
/* 665 */           this.sheet.render(r, j, x, y);
/*     */         } 
/*     */ 
/*     */         
/* 669 */         a = getCorners(data);
/* 670 */         if (a != 0) {
/* 671 */           this.sheet.render(r, this.SHEET_CORNER + a, x, y);
/*     */         }
/*     */       } 
/*     */       
/* 675 */       s.setDistance2Ground(0.0D).setHeight(0);
/* 676 */       if (!(SETT.OVERLAY()).added) {
/*     */         
/* 678 */         s.setHard();
/* 679 */         (SETT.TERRAIN()).MOUNTAIN.sheet.render((SPRITE_RENDERER)s, 15, x, y);
/* 680 */         s.setSoft();
/*     */       } else {
/* 682 */         s.setSoft();
/* 683 */         (SETT.TERRAIN()).MOUNTAIN.sheet.render((SPRITE_RENDERER)s, 15, x, y);
/*     */       } 
/* 685 */       i.countCave();
/* 686 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 692 */       return false;
/*     */     }
/*     */     
/*     */     public boolean canFix(int tx, int ty) {
/* 696 */       if (!super.is(tx, ty))
/* 697 */         return false; 
/* 698 */       int d = this.shared.data.get(tx, ty);
/* 699 */       return ((d & 0x100) == 0 && d != 0);
/*     */     }
/*     */     
/*     */     public void fix(int tx, int ty) {
/* 703 */       if (!is(tx, ty))
/*     */         return; 
/* 705 */       int d = this.shared.data.get(tx, ty);
/* 706 */       d |= 0x100;
/* 707 */       this.shared.data.set(tx, ty, d);
/*     */     }
/*     */ 
/*     */     
/*     */     public AVAILABILITY getAvailability(int x, int y) {
/* 712 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isPlacable(int tx, int ty) {
/* 717 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 718 */         DIR d = (DIR)DIR.ALL.get(i);
/* 719 */         if (!joins(tx, ty, d) && !is(tx, ty, d))
/* 720 */           return this.opening.isPlacable(tx, ty); 
/*     */       } 
/* 722 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean wallJoiner() {
/* 727 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean wallIsWally() {
/* 732 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean roofIs() {
/* 737 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public COLOR miniC(int x, int y) {
/* 742 */       if ((SETT.MINERALS()).getter.is(x, y))
/* 743 */         return (SETT.GROUND()).minimap.miniC(x, y); 
/* 744 */       return super.miniC(x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tx, int ty) {
/* 749 */       return !(!super.is(tx, ty) && !this.opening.is(tx, ty));
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightStart(int tx, int ty) {
/* 754 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightEnd(int tx, int ty) {
/* 759 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public LOS los(int tx, int ty) {
/* 764 */       return LOS.CEILING;
/*     */     }
/*     */     
/*     */     public class Opening
/*     */       extends Terrain.TerrainTile
/*     */     {
/*     */       private final TILE_SHEET sheet;
/*     */       private final int SHEET_START;
/*     */       private final int SINGLES;
/*     */       
/*     */       private Opening(Terrain t, TILE_SHEET sheet, SPRITE icon, int sheetStart) {
/* 775 */         super("CAVE_ENTRANCE", t, "cave entrance", icon, (COLOR)t.colors.minimap.mountain.shade(1.5D));
/* 776 */         this.sheet = sheet;
/* 777 */         this.SHEET_START = sheetStart;
/* 778 */         this.SINGLES = this.SHEET_START + 64;
/*     */       }
/*     */       
/*     */       private boolean joins(int x, int y, DIR d) {
/* 782 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, d);
/* 783 */         return !(!t.wallIsWally() && !t.roofIs());
/*     */       }
/*     */ 
/*     */       
/*     */       protected boolean place(int tx, int ty) {
/* 788 */         if (!isPlacable(tx, ty))
/* 789 */           return this.shared.CAVE.place(tx, ty); 
/* 790 */         placeRaw(tx, ty);
/*     */ 
/*     */         
/* 793 */         placeRaw(tx, ty);
/* 794 */         int res = 0;
/* 795 */         for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 796 */           DIR d = (DIR)DIR.NORTHO.get(i);
/* 797 */           if (joins(tx, ty, d) && joins(tx, ty, d.next(-1)) && joins(tx, ty, d.next(1))) {
/* 798 */             res |= d.mask();
/*     */           }
/*     */         } 
/* 801 */         if (res != 15 && res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.N)) {
/* 802 */           Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.N);
/* 803 */           if (t != this && t != this.shared.MOUNTAIN && t.wallIsWally() && !t.roofIs()) {
/* 804 */             if ((res & DIR.NW.mask()) != 0)
/* 805 */               res |= 0x20; 
/* 806 */             if ((res & DIR.NE.mask()) != 0)
/* 807 */               res |= 0x10; 
/*     */           } 
/*     */         } 
/* 810 */         if (res != 15 && res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.W)) {
/* 811 */           Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.W);
/* 812 */           if (t != this && t != this.shared.MOUNTAIN && t.wallIsWally() && !t.roofIs()) {
/* 813 */             if ((res & DIR.SW.mask()) != 0)
/* 814 */               res |= 0x80; 
/* 815 */             if ((res & DIR.NW.mask()) != 0) {
/* 816 */               res |= 0x40;
/*     */             }
/*     */           } 
/*     */         } 
/* 820 */         this.shared.data.set(tx, ty, res);
/* 821 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 827 */         int x = i.x();
/* 828 */         int y = i.y();
/* 829 */         int ran = i.ran();
/*     */         
/* 831 */         TILE_SHEET sheets = (SETT.TERRAIN()).MOUNTAIN.sheet;
/*     */ 
/*     */         
/* 834 */         int code = data & 0xF;
/* 835 */         if (code == 0) {
/* 836 */           s.setHeight(3).setDistance2Ground(0.0D);
/* 837 */           this.sheet.render(r, this.SINGLES + (ran & 0xF), x, y);
/* 838 */           sheets.render((SPRITE_RENDERER)s, this.shared.MOUNTAIN.SINGLES + (ran & 0xF), x, y);
/*     */         } else {
/* 840 */           s.setHeight(10).setDistance2Ground(0.0D);
/* 841 */           this.sheet.render(r, this.SHEET_START + code + (ran & 0x3) * 16, x, y);
/* 842 */           sheets.render((SPRITE_RENDERER)s, code + (ran & 0x3) * 16, x, y);
/* 843 */           if ((data & 0x30) != 0)
/* 844 */             (SETT.TERRAIN()).wall_merge.render(r, (data >> 4 & 0x3) - 1, i.x(), i.y() - 4); 
/* 845 */           if ((data & 0xC0) != 0)
/* 846 */             (SETT.TERRAIN()).wall_merge.render(r, (data >> 6 & 0x3) + 2, i.x() - 4, i.y()); 
/*     */         } 
/* 848 */         i.countCave();
/* 849 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 854 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public AVAILABILITY getAvailability(int x, int y) {
/* 859 */         return null;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isPlacable(int tx, int ty) {
/* 865 */         for (DIR d : DIR.ALL) {
/* 866 */           if (SETT.IN_BOUNDS(tx, ty, d) && !((Terrain.TerrainTile)this.shared.get(tx, ty, d)).wallIsWally() && !((Terrain.TerrainTile)this.shared.get(tx, ty, d)).roofIs())
/* 867 */             return true; 
/*     */         } 
/* 869 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       boolean wallJoiner() {
/* 874 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean wallIsWally() {
/* 879 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean roofIs() {
/* 884 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public TerrainClearing clearing() {
/* 890 */         return TMountain.Ceiling.this.clear;
/*     */       }
/*     */ 
/*     */       
/*     */       public TERRAIN terrain(int tx, int ty) {
/* 895 */         return TERRAINS.MOUNTAIN();
/*     */       }
/*     */ 
/*     */       
/*     */       public int heightStart(int tx, int ty) {
/* 900 */         return 3;
/*     */       }
/*     */ 
/*     */       
/*     */       public int heightEnd(int tx, int ty) {
/* 905 */         return 200;
/*     */       }
/*     */ 
/*     */       
/*     */       public LOS los(int tx, int ty) {
/* 910 */         return LOS.CEILING;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int miniDepth() {
/* 919 */     return 2;
/*     */   }
/*     */   
/*     */   public boolean isFilled(int tx, int ty) {
/* 923 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 924 */       if (!is(tx, ty, (DIR)DIR.ORTHO.get(di)))
/* 925 */         return false; 
/*     */     } 
/* 927 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMountain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */