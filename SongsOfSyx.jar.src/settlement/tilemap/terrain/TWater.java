/*      */ package settlement.tilemap.terrain;
/*      */ 
/*      */ import game.audio.AUDIO;
/*      */ import game.audio.SoundRace;
/*      */ import game.time.TIME;
/*      */ import init.paths.PATHS;
/*      */ import init.resources.RESOURCE;
/*      */ import init.settings.S;
/*      */ import init.sprite.SPRITES;
/*      */ import init.sprite.game.SheetPair;
/*      */ import init.sprite.game.SheetType;
/*      */ import init.type.TERRAIN;
/*      */ import init.type.TERRAINS;
/*      */ import java.io.IOException;
/*      */ import java.nio.file.Path;
/*      */ import settlement.main.SETT;
/*      */ import settlement.misc.util.FINDABLE;
/*      */ import settlement.path.AVAILABILITY;
/*      */ import settlement.tilemap.floor.Floors;
/*      */ import settlement.tilemap.ground.GroundType;
/*      */ import snake2d.CORE;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.MATH;
/*      */ import snake2d.util.bit.Bits;
/*      */ import snake2d.util.color.COLOR;
/*      */ import snake2d.util.color.ColorImp;
/*      */ import snake2d.util.color.OPACITY;
/*      */ import snake2d.util.color.OpacityImp;
/*      */ import snake2d.util.datatypes.AREA;
/*      */ import snake2d.util.datatypes.DIMENSION;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.file.Alloc;
/*      */ import snake2d.util.file.Json;
/*      */ import snake2d.util.map.MAP_BOOLEAN;
/*      */ import snake2d.util.map.MAP_DOUBLE;
/*      */ import snake2d.util.map.MAP_OBJECT;
/*      */ import snake2d.util.misc.CLAMP;
/*      */ import snake2d.util.sets.Bitmap2D;
/*      */ import snake2d.util.sets.Bitsmap2D;
/*      */ import snake2d.util.sets.LIST;
/*      */ import snake2d.util.sprite.SPRITE;
/*      */ import snake2d.util.sprite.TILE_SHEET;
/*      */ import snake2d.util.sprite.TextureCoords;
/*      */ import snake2d.util.sprite.TileTexture;
/*      */ import util.GUTIL;
/*      */ import util.gui.misc.GBox;
/*      */ import util.rendering.RenderData;
/*      */ import util.rendering.ShadowBatch;
/*      */ import util.spritecomposer.ComposerDests;
/*      */ import util.spritecomposer.ComposerSources;
/*      */ import util.spritecomposer.ComposerThings;
/*      */ import util.spritecomposer.ComposerUtil;
/*      */ import util.text.D;
/*      */ import view.sett.IDebugPanelSett;
/*      */ import view.tool.PLACABLE;
/*      */ import view.tool.PLACER_TYPE;
/*      */ import view.tool.PlacableMulti;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TWater
/*      */ {
/*      */   private final Sprites sprites;
/*   69 */   protected static String ¤¤name = "¤Water";
/*   70 */   protected static String ¤¤nameDeep = "¤Deep Water";
/*   71 */   protected static String ¤¤nameBridge = "¤Bridge"; public final Terrain.TerrainTile DEEP; public final Terrain.TerrainTile SHALLOW; public final Terrain.TerrainTile BRIDGE; private final Terrain shared;
/*      */   
/*      */   static {
/*   74 */     D.ts(TWater.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   82 */   private static final Bits bradius = new Bits(61440);
/*   83 */   private final int reserveBit = 256;
/*      */ 
/*      */   
/*   86 */   private int iceI = 0;
/*      */   
/*   88 */   public final Bitmap2D groundWater = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*   89 */   public final Bitmap2D groundWaterSalt = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*   90 */   public final Bitmap2D deepSeaFishSpot = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*   91 */   public final Bitsmap2D fishAmount = new Bitsmap2D(0, 4, (DIMENSION)SETT.TILE_BOUNDS);
/*      */ 
/*      */ 
/*      */   
/*      */   public MAP_DOUBLE radius;
/*      */ 
/*      */ 
/*      */   
/*      */   public final MAP_OBJECT<FINDABLE> service;
/*      */ 
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN open;
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN ice;
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN deepIs;
/*      */ 
/*      */   
/*      */   private final Minimap mini;
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN is;
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN isW;
/*      */ 
/*      */ 
/*      */   
/*      */   private void placer(final Bitmap2D map, String name) {
/*  123 */     final PlacableMulti undo = new PlacableMulti(name + " undo")
/*      */       {
/*      */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*      */         {
/*  127 */           map.set(tx, ty, false);
/*      */         }
/*      */ 
/*      */         
/*      */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  132 */           return map.is(tx, ty) ? null : E;
/*      */         }
/*      */       };
/*      */     
/*  136 */     PlacableMulti placableMulti2 = new PlacableMulti(name)
/*      */       {
/*      */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*      */         {
/*  140 */           map.set(tx, ty, true);
/*      */         }
/*      */ 
/*      */         
/*      */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  145 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         public PLACABLE getUndo() {
/*  150 */           return undo;
/*      */         }
/*      */       };
/*      */     
/*  154 */     IDebugPanelSett.add((PLACABLE)placableMulti2);
/*      */   }
/*      */   
/*      */   private static abstract class Clear
/*      */     extends TerrainClearing
/*      */   {
/*  160 */     private final SoundRace sound = AUDIO.race("CLEAR_WATER");
/*      */     
/*      */     public int clearAll(int tx, int ty) {
/*  163 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public SoundRace sound(int tx, int ty) {
/*  168 */       return this.sound;
/*      */     }
/*      */ 
/*      */     
/*      */     public double strength() {
/*  173 */       return 128000.0D;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEasilyCleared() {
/*  178 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public TWater(Terrain t) throws IOException {
/*  183 */     this.radius = new MAP_DOUBLE()
/*      */       {
/*  185 */         private final double ri = 0.0625D;
/*      */ 
/*      */         
/*      */         public double get(int tx, int ty) {
/*  189 */           if (SETT.IN_BOUNDS(tx, ty))
/*  190 */             return get(tx + ty * SETT.TWIDTH); 
/*  191 */           return 0.0D;
/*      */         }
/*      */ 
/*      */         
/*      */         public double get(int tile) {
/*  196 */           return (TWater.bradius.get(TWater.this.shared.data.get(tile)) + 1) * 0.0625D;
/*      */         }
/*      */       };
/*      */     
/*  200 */     this.service = new MAP_OBJECT<FINDABLE>() { private int sx;
/*      */         private int sy;
/*      */         
/*  203 */         private final FINDABLE service = new FINDABLE()
/*      */           {
/*      */             public int y()
/*      */             {
/*  207 */               return TWater.null.this.sy;
/*      */             }
/*      */ 
/*      */             
/*      */             public int x() {
/*  212 */               return TWater.null.this.sx;
/*      */             }
/*      */ 
/*      */             
/*      */             public boolean findableReservedIs() {
/*  217 */               return (((TWater.null.access$2(TWater.null.this)).shared.data.get(TWater.null.this.sx, TWater.null.this.sy) & 0x100) == 256);
/*      */             }
/*      */ 
/*      */             
/*      */             public boolean findableReservedCanBe() {
/*  222 */               return (((TWater.null.access$2(TWater.null.this)).shared.data.get(TWater.null.this.sx, TWater.null.this.sy) & 0x100) != 256);
/*      */             }
/*      */ 
/*      */             
/*      */             public void findableReserveCancel() {
/*  227 */               if (findableReservedIs()) {
/*  228 */                 (SETT.PATH()).finders.water.report(TWater.null.this.sx, TWater.null.this.sy, 1);
/*      */               }
/*      */               
/*  231 */               (TWater.null.access$2(TWater.null.this)).shared.data.set(TWater.null.this.sx, TWater.null.this.sy, (TWater.null.access$2(TWater.null.this)).shared.data.get(TWater.null.this.sx, TWater.null.this.sy) & 0xFFFFFEFF);
/*      */             }
/*      */ 
/*      */             
/*      */             public void findableReserve() {
/*  236 */               if (findableReservedCanBe()) {
/*  237 */                 (SETT.PATH()).finders.water.report(TWater.null.this.sx, TWater.null.this.sy, -1);
/*      */               }
/*      */               
/*  240 */               (TWater.null.access$2(TWater.null.this)).shared.data.set(TWater.null.this.sx, TWater.null.this.sy, (TWater.null.access$2(TWater.null.this)).shared.data.get(TWater.null.this.sx, TWater.null.this.sy) | 0x100);
/*      */             }
/*      */           };
/*      */         
/*      */         public FINDABLE get(int tile) {
/*  245 */           return get(tile % SETT.TWIDTH, tile / SETT.THEIGHT);
/*      */         }
/*      */         
/*      */         public FINDABLE get(int tx, int ty) {
/*  249 */           if (TWater.this.SHALLOW.is(tx, ty)) {
/*  250 */             int d = TWater.this.shared.data.get(tx, ty);
/*  251 */             if ((d & 0xF) == 15) {
/*  252 */               this.sx = tx;
/*  253 */               this.sy = ty;
/*  254 */               return this.service;
/*      */             } 
/*      */           } 
/*  257 */           return null;
/*      */         } }
/*      */       ;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  280 */     this.open = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty)
/*      */         {
/*  284 */           if (TWater.this.SHALLOW.is(tx, ty)) {
/*  285 */             return ((TWater.this.shared.data.get(tx, ty) & 0xF) == 15);
/*      */           }
/*  287 */           return TWater.this.DEEP.is(tx, ty);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean is(int tile) {
/*  292 */           if (TWater.this.SHALLOW.is(tile)) {
/*  293 */             return ((TWater.this.shared.data.get(tile) & 0xF) == 15);
/*      */           }
/*  295 */           return TWater.this.DEEP.is(tile);
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  320 */     this.ice = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty)
/*      */         {
/*  324 */           return (TWater.this.iceI > (GUTIL.ran2().get(tx + ty * SETT.TWIDTH) & 0xFFFF));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean is(int tile) {
/*  329 */           return (TWater.this.iceI > (GUTIL.ran2().get(tile) & 0xFFFF));
/*      */         }
/*      */       };
/*      */     
/*  333 */     this.deepIs = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty)
/*      */         {
/*  337 */           return !(!TWater.this.DEEP.is(tx, ty) && !TWater.this.BRIDGE.is(tx, ty));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean is(int tile) {
/*  342 */           return !(!TWater.this.DEEP.is(tile) && !TWater.this.BRIDGE.is(tile));
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  355 */     this.mini = new Minimap();
/*      */     
/*  357 */     this.is = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty)
/*      */         {
/*  361 */           return !(!TWater.this.SHALLOW.is(tx, ty) && !TWater.this.DEEP.is(tx, ty) && !TWater.this.BRIDGE.is(tx, ty));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean is(int tile) {
/*  366 */           return !(!TWater.this.SHALLOW.is(tile) && !TWater.this.DEEP.is(tile) && !TWater.this.BRIDGE.is(tile));
/*      */         }
/*      */       };
/*      */     
/*  370 */     this.isW = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty)
/*      */         {
/*  374 */           return !(!TWater.this.SHALLOW.is(tx, ty) && !TWater.this.DEEP.is(tx, ty));
/*      */         }
/*      */         
/*      */         public boolean is(int tile)
/*      */         {
/*  379 */           return !(!TWater.this.SHALLOW.is(tile) && !TWater.this.DEEP.is(tile)); } }; this.sprites = new Sprites(); this.DEEP = new Deep(t); this.SHALLOW = new Shallow(t); this.BRIDGE = new Bridge(t); this.shared = t; placer(this.groundWater, "Water Fresh"); placer(this.groundWaterSalt, "Water Salt"); placer(this.deepSeaFishSpot, "Water deep sea spot");
/*      */   } private boolean setRadiusAndData(int old, int data, int x, int y) { double am = 0.0D; int i = 0; while (GUTIL.circle().radius(i) < 4) {
/*      */       int dx = x + GUTIL.circle().get(i).x(); int dy = y + GUTIL.circle().get(i).y(); if (this.is.is(dx, dy))
/*      */         am++;  i++;
/*      */     }  int ra = (int)(15.0D * CLAMP.d(2.0D * am / i, 0.0D, 1.0D)); int n = bradius.set(data, ra);
/*      */     this.shared.data.set(x, y, n);
/*  385 */     return (bradius.get(old) != bradius.get(n)); } public void renderOverlayed(RenderData.RenderIterator i) { this.sprites.renderTexture(i); }
/*      */   private int getCode(int x, int y) { int m = 0; for (DIR d : DIR.ORTHO) { if (this.is.is(x + d.x(), y + d.y()) || !SETT.IN_BOUNDS(x, y, d))
/*      */         m |= d.mask();  }  return m; }
/*      */   private int getCodeCorner(int m, int x, int y) { int c = 0; for (DIR d : DIR.NORTHO) { if ((m & d.next(-1).mask()) != 0 && (m & d.next(1).mask()) != 0 && !this.is.is(x + d.x(), y + d.y()))
/*      */         c |= d.mask();  }  return c; } public void renderIce(RenderData.RenderIterator i, int mask) { this.sprites.renderIce(mask, 0, i); } void update(double ds) { this.sprites.update(ds); this.iceI = (int)((SETT.WEATHER()).ice.getD() * 131071.0D) * (S.get()).downpour.get(); } private static class Minimap
/*      */   {
/*  391 */     private final int w = 64;
/*  392 */     private final int h = 32;
/*  393 */     private byte[][] values = new byte[32][64];
/*      */ 
/*      */     
/*      */     Minimap() {
/*  397 */       for (int i = 0; i < 32; i++) {
/*  398 */         drawWave(i, (byte)(24 - (i & 0x3) * 16));
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     private void drawWave(int sy, byte v) {
/*  404 */       double period = 5.0D;
/*  405 */       double bend = 3.0D;
/*      */       
/*  407 */       for (int i = 0; i < 64; i++) {
/*  408 */         int x = i;
/*  409 */         double d = period * i / 64.0D * Math.PI;
/*  410 */         int y = sy + (int)(bend * Math.sin(d));
/*  411 */         y &= 0x1F;
/*  412 */         this.values[y][x] = (byte)(this.values[y][x] + v);
/*      */       } 
/*      */     }
/*      */     
/*      */     COLOR miniCPimp(ColorImp c, int x, int y, boolean northern, boolean southern) {
/*  417 */       x &= 0x3F;
/*  418 */       y &= 0x1F;
/*  419 */       if (this.values[y][x] != 0) {
/*  420 */         double v = 1.0D - 0.5D * this.values[y][x] / 128.0D;
/*  421 */         c.shadeSelf(v);
/*      */       } 
/*  423 */       return (COLOR)c;
/*      */     }
/*      */   }
/*      */   
/*      */   private final class Shallow
/*      */     extends Terrain.TerrainTile {
/*      */     private final LIST<SheetPair> ontop;
/*      */     private TerrainClearing clearing;
/*      */     
/*      */     private Shallow(Terrain t) throws IOException {
/*  433 */       super("WATER_SHALLOW", t, TWater.¤¤name, TWater.this.sprites.icon, t.colors.minimap.water);
/*      */ 
/*      */ 
/*      */       
/*  437 */       this.clearing = new TWater.Clear()
/*      */         {
/*      */           
/*      */           public RESOURCE clear1(int tx, int ty)
/*      */           {
/*  442 */             TWater.Shallow.this.shared.NADA.placeFixed(tx, ty);
/*  443 */             return null;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean can() {
/*  448 */             return true;
/*      */           }
/*      */         };
/*      */       this.ontop = SPRITES.GAME().sheets((SheetType)SheetType.s1x1, (new Json((PATHS.CONFIG()).init.gets("SETT_MAP_DECORATION"))).json("WATER_SWEET_1X1"));
/*      */     }
/*      */     
/*      */     void unplace(int tx, int ty) {
/*  455 */       if (TWater.this.service.get(tx, ty) != null && ((FINDABLE)TWater.this.service.get(tx, ty)).findableReservedCanBe()) {
/*  456 */         (SETT.PATH()).finders.water.report(tx, ty, -1);
/*      */       }
/*      */     }
/*      */     
/*      */     public TerrainClearing clearing() {
/*  461 */       return this.clearing;
/*      */     }
/*      */ 
/*      */     
/*      */     public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/*  466 */       return TWater.this.mini.miniCPimp(c, x, y, northern, southern);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isPlacable(int tx, int ty) {
/*  471 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean place(int x, int y) {
/*  478 */       if (SETT.IN_BOUNDS(x, y)) {
/*  479 */         return setCode(x, y);
/*      */       }
/*  481 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean setCode(int x, int y) {
/*  487 */       int old = this.shared.data.get(x, y);
/*  488 */       placeRaw(x, y);
/*  489 */       int c = getCode(x, y);
/*  490 */       c |= getCodeCorner(c, x, y) << 4;
/*  491 */       for (DIR d : DIR.ORTHO) {
/*  492 */         if (TWater.this.DEEP.is(x + d.x(), y + d.y()) || TWater.this.BRIDGE.is(x + d.x(), y + d.y())) {
/*      */           break;
/*      */         }
/*      */       } 
/*  496 */       boolean ret = TWater.this.setRadiusAndData(old, c, x, y);
/*  497 */       if (TWater.this.service.get(x, y) != null && ((FINDABLE)TWater.this.service.get(x, y)).findableReservedCanBe())
/*  498 */         (SETT.PATH()).finders.water.report(x, y, 1); 
/*  499 */       return ret;
/*      */     }
/*      */     
/*      */     private int getCode(int x, int y) {
/*  503 */       int m = 0;
/*  504 */       for (DIR d : DIR.ORTHO) {
/*  505 */         if (TWater.this.is.is(x + d.x(), y + d.y()) || !SETT.IN_BOUNDS(x, y, d))
/*  506 */           m |= d.mask(); 
/*      */       } 
/*  508 */       return m;
/*      */     }
/*      */ 
/*      */     
/*      */     private int getCodeCorner(int m, int x, int y) {
/*  513 */       int c = 0;
/*  514 */       for (DIR d : DIR.NORTHO) {
/*  515 */         if ((m & d.next(-1).mask()) != 0 && (m & d.next(1).mask()) != 0 && !TWater.this.is.is(x + d.x(), y + d.y())) {
/*  516 */           c |= d.mask();
/*      */         }
/*      */       } 
/*  519 */       return c;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  525 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  530 */       TWater.this.sprites.render(data & 0xF, data >> 4 & 0xF, i, (COLOR)TWater.this.sprites.shore, (COLOR)TWater.this.sprites.normal);
/*  531 */       TWater.this.sprites.renderTexture(i);
/*  532 */       COLOR.unbind();
/*  533 */       i.countWater();
/*      */       
/*  535 */       return ((data & 0xF) == 15);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean renderMid(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, int data) {
/*  541 */       TWater.this.sprites.above(data, 0, it);
/*  542 */       if (isIce(it.tile())) {
/*  543 */         int m = 0;
/*  544 */         for (DIR d : DIR.ORTHO) {
/*  545 */           if (isIce(it, d) || !SETT.IN_BOUNDS(it.tx(), it.ty(), d))
/*  546 */             m |= d.mask(); 
/*      */         } 
/*  548 */         TWater.this.sprites.renderIce(m, 0, it);
/*  549 */         return (m == 15);
/*  550 */       }  if ((data & 0xF) == 15 && TWater.this.groundWater.is(it.tile()) && (GUTIL.ran2().get(it.tile()) & 0x7) == 0) {
/*      */         
/*  552 */         if (this.ontop.size() == 0) {
/*  553 */           return false;
/*      */         }
/*  555 */         int ran = it.ran();
/*  556 */         SheetPair sheet = (SheetPair)this.ontop.getC(ran);
/*  557 */         if (sheet == null)
/*  558 */           return false; 
/*  559 */         (SETT.TERRAIN()).colors.tree.get(it.ran()).bind();
/*      */         
/*  561 */         ran >>= 4;
/*      */         
/*  563 */         int frame = sheet.d.frame(it.ran(), 1.0D);
/*  564 */         int tile = SheetType.s1x1.tile(sheet.s, sheet.d, 0, frame, ran & 0x3);
/*      */         
/*  566 */         int x = it.x();
/*  567 */         int y = it.y();
/*      */         
/*  569 */         ran = GUTIL.ran2().get(it.tile());
/*  570 */         double sp = 10.0D / (1 + (ran & 0xF));
/*  571 */         ran >>= 4;
/*  572 */         int f = (ran & 0xF) + (int)(sp * TIME.currentSecond());
/*  573 */         ran >>= 4;
/*  574 */         int df = MATH.distanceC(8, f, 16);
/*  575 */         x += df;
/*      */         
/*  577 */         sp = 10.0D / (1 + (ran & 0xF));
/*  578 */         ran >>= 4;
/*  579 */         f = (ran & 0xF) + (int)(sp * TIME.currentSecond());
/*  580 */         ran >>= 4;
/*  581 */         df = MATH.distanceC(8, f, 16);
/*  582 */         y += df;
/*      */ 
/*      */ 
/*      */         
/*  586 */         sheet.s.render(sheet.d, x, y, it, r, tile, ran, 0.0D);
/*  587 */         COLOR.unbind();
/*  588 */         if (s != null)
/*  589 */           sheet.s.renderShadow(sheet.d, x, y, it, s, tile, ran); 
/*  590 */         return false;
/*      */       } 
/*      */       
/*  593 */       return false;
/*      */     }
/*      */     
/*      */     private boolean isIce(RenderData.RenderIterator i, DIR d) {
/*  597 */       return (is(i.tx(), i.ty(), d) && isIce(i.tx() + d.x(), i.ty() + d.y()));
/*      */     }
/*      */     
/*      */     private boolean isIce(int tx, int ty) {
/*  601 */       return (TWater.this.iceI > (GUTIL.ran1().get(tx + ty * SETT.TWIDTH) & 0xFFFF) && !(SETT.ROOMS()).map.is(tx, ty));
/*      */     }
/*      */     
/*      */     private boolean isIce(int tile) {
/*  605 */       return (TWater.this.iceI > (GUTIL.ran1().get(tile) & 0xFFFF) && !(SETT.ROOMS()).map.is(tile));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AVAILABILITY getAvailability(int x, int y) {
/*  614 */       return AVAILABILITY.PENALTY3;
/*      */     }
/*      */ 
/*      */     
/*      */     public void hoverInfo(GBox box, int tx, int ty) {
/*  619 */       super.hoverInfo(box, tx, ty);
/*  620 */       if ((S.get()).developer) {
/*  621 */         box.add((SPRITE)box.text().add(TWater.this.radius.get(tx, ty)));
/*      */       }
/*      */     }
/*      */     
/*      */     public TERRAIN terrain(int tx, int ty) {
/*  626 */       if (TWater.this.groundWaterSalt.is(tx, ty))
/*  627 */         return TERRAINS.OCEAN(); 
/*  628 */       return TERRAINS.WET();
/*      */     }
/*      */   }
/*      */   
/*      */   private abstract class DeepAbs
/*      */     extends Terrain.TerrainTile {
/*      */     DeepAbs(String key, Terrain t, CharSequence name, COLOR mini) {
/*  635 */       super(key, t, name, TWater.this.sprites.icon, mini);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean place(int x, int y) {
/*  641 */       int old = this.shared.data.get(x, y);
/*  642 */       placeRaw(x, y);
/*  643 */       int m = 0;
/*  644 */       boolean sh = false;
/*  645 */       for (DIR d : DIR.ORTHO) {
/*  646 */         if (joins(x + d.x(), y + d.y()) || !SETT.IN_BOUNDS(x, y, d)) {
/*  647 */           m |= d.mask(); continue;
/*  648 */         }  if (TWater.this.SHALLOW.is(x + d.x(), y + d.y())) {
/*  649 */           sh = true;
/*      */         }
/*      */       } 
/*  652 */       int c = 0;
/*  653 */       for (DIR d : DIR.NORTHO) {
/*  654 */         if ((m & d.next(-1).mask()) != 0 && (m & d.next(1).mask()) != 0 && !joins(x + d.x(), y + d.y())) {
/*  655 */           c |= d.mask();
/*      */         }
/*      */       } 
/*  658 */       m |= c << 4;
/*  659 */       if (sh)
/*  660 */         m |= 0x100; 
/*  661 */       return TWater.this.setRadiusAndData(old, m, x, y);
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean joins(int tx, int ty) {
/*  666 */       return SETT.TERRAIN().get(tx, ty) instanceof DeepAbs;
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  671 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  676 */       int d = 0;
/*  677 */       if ((data & 0x100) != 0) {
/*  678 */         d = TWater.this.getCode(i.tx(), i.ty());
/*  679 */         int c = TWater.this.getCodeCorner(d, i.tx(), i.ty());
/*  680 */         TWater.this.sprites.render(d, c, i, (COLOR)TWater.this.sprites.shore, (COLOR)TWater.this.sprites.normal);
/*      */       } 
/*      */       
/*  683 */       TWater.this.sprites.render(data & 0xF, data >> 4 & 0xF, i, (COLOR)TWater.this.sprites.normal, (COLOR)TWater.this.sprites.deep);
/*  684 */       TWater.this.sprites.renderTexture(i);
/*  685 */       COLOR.unbind();
/*  686 */       i.countWater();
/*      */       
/*  688 */       return (((data | d) & 0xF) == 15);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isPlacable(int tx, int ty) {
/*  693 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int miniDepth() {
/*  699 */       return 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public TERRAIN terrain(int tx, int ty) {
/*  704 */       if (TWater.this.groundWaterSalt.is(tx, ty))
/*  705 */         return TERRAINS.OCEAN(); 
/*  706 */       return TERRAINS.WET();
/*      */     }
/*      */   }
/*      */   
/*      */   private final class Deep extends DeepAbs {
/*      */     private TerrainClearing clearing;
/*      */     
/*      */     Deep(Terrain t) {
/*  714 */       super("WATER_DEEP", t, TWater.¤¤nameDeep, t.colors.minimap.water_deep);
/*      */ 
/*      */ 
/*      */       
/*  718 */       this.clearing = new TWater.Clear()
/*      */         {
/*      */           
/*      */           public RESOURCE clear1(int tx, int ty)
/*      */           {
/*  723 */             (TWater.Deep.access$0(TWater.Deep.this)).BRIDGE.placeFixed(tx, ty);
/*  724 */             return null;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean can() {
/*  729 */             return true;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean canDestroy(int tx, int ty) {
/*  734 */             return true;
/*      */           }
/*      */ 
/*      */           
/*      */           public void destroy(int tx, int ty) {
/*  739 */             (TWater.Deep.access$0(TWater.Deep.this)).BRIDGE.placeFixed(tx, ty);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean needs() {
/*  744 */             return true;
/*      */           }
/*      */         };
/*      */     }
/*      */     
/*      */     public AVAILABILITY getAvailability(int x, int y) {
/*  750 */       return AVAILABILITY.NOT_ACCESSIBLE;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isPlacable(int tx, int ty) {
/*  755 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public TerrainClearing clearing() {
/*  760 */       return this.clearing;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int miniDepth() {
/*  766 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/*  772 */       if ((this.shared.data.get(x, y) & 0x100) != 0) {
/*  773 */         c.interpolate((COLOR)c, TWater.this.SHALLOW.miniC, 0.5D);
/*      */       }
/*  775 */       return TWater.this.mini.miniCPimp(c, x, y, northern, southern);
/*      */     } }
/*      */   
/*      */   private final class Bridge extends DeepAbs {
/*      */     private TerrainClearing clearing;
/*      */     
/*      */     Bridge(Terrain t) {
/*  782 */       super("WATER_BRIDGE", t, TWater.¤¤nameDeep, null);
/*      */ 
/*      */ 
/*      */       
/*  786 */       this.clearing = new TWater.Clear()
/*      */         {
/*      */           
/*      */           public RESOURCE clear1(int tx, int ty)
/*      */           {
/*  791 */             (TWater.Bridge.access$0(TWater.Bridge.this)).DEEP.placeFixed(tx, ty);
/*  792 */             return null;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean can() {
/*  797 */             return false;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean canDestroy(int tx, int ty) {
/*  802 */             return false;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean needs() {
/*  807 */             return true;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean renderMid(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  816 */       if ((SETT.FLOOR()).getter.get(i.tile()) == null) {
/*  817 */         GroundType d = (GroundType)(SETT.GROUND()).MAP.get(i.tile());
/*  818 */         d.col(i.tile()).bind();
/*  819 */         TextureCoords tex = SETT.GROUND().getTexture(i.tile(), i.ran());
/*  820 */         TWater.this.sprites.single_stencil.renderTextured(tex, i.ran() & 0xF, i.x(), i.y());
/*  821 */         TWater.this.sprites.bridgeRaw.render(r, i.ran() & 0xF, i.x(), i.y());
/*  822 */         OPACITY.O99.bind();
/*  823 */         TWater.this.sprites.bridgeRaw.renderTextured(tex, i.ran() & 0xF, i.x(), i.y());
/*  824 */         OPACITY.unbind();
/*  825 */         COLOR.unbind();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  840 */         SETT.FLOOR().renderSimple(r, i, (Floors.Floor)(SETT.FLOOR()).getter.get(i.tile()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  858 */         return true;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  865 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  882 */       if ((SETT.FLOOR()).getter.get(i.tile()) == null)
/*  883 */         return false; 
/*  884 */       int mask = 0;
/*      */       
/*  886 */       for (DIR d : DIR.ORTHO) {
/*  887 */         if (is(i.tx(), i.ty(), d) || !(SETT.PATH()).solidity.is(i.tx(), i.ty(), d)) {
/*  888 */           mask |= d.mask();
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  909 */       TWater.this.sprites.bridge.render(r, mask, i.x(), i.y());
/*      */ 
/*      */ 
/*      */       
/*  913 */       s.setDistance2Ground(0.0D).setHeight(4);
/*  914 */       TWater.this.sprites.bridge.render((SPRITE_RENDERER)s, mask, i.x(), i.y());
/*      */       
/*  916 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AVAILABILITY getAvailability(int x, int y) {
/*  925 */       return AVAILABILITY.NORMAL;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isPlacable(int tx, int ty) {
/*  930 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public TerrainClearing clearing() {
/*  935 */       return this.clearing;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int miniDepth() {
/*  941 */       return 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/*  946 */       return null;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class Sprites
/*      */   {
/*      */     private final TILE_SHEET stencil;
/*      */     private final TILE_SHEET animation;
/*      */     private final TILE_SHEET animation_corner;
/*      */     private final TILE_SHEET single_stencil;
/*      */     private final TILE_SHEET single_animation;
/*      */     private final TILE_SHEET ice;
/*      */     private final TILE_SHEET ice_fulls;
/*      */     private final TILE_SHEET edge;
/*      */     private final TILE_SHEET bridgeRaw;
/*      */     private final TILE_SHEET bridge;
/*  963 */     public final ColorImp shore = new ColorImp(10, 40, 100);
/*  964 */     public final ColorImp normal = this.shore.shade(0.5D);
/*  965 */     public final ColorImp deep = this.normal.shade(0.5D);
/*      */     
/*  967 */     private short shoreOff = 0;
/*      */     
/*      */     private double waterTimer;
/*      */     private int shoreDir;
/*  971 */     private final TileTexture.TileTextureScroller dis1 = (SPRITES.textures()).dis_big.scroller(1.1D, -1.1D);
/*  972 */     private final TileTexture.TileTextureScroller dis2 = (SPRITES.textures()).dis_tiny.scroller(-0.8D, 0.8D);
/*  973 */     private final TileTexture.TileTextureScroller tex1 = (SPRITES.textures()).bumps.scroller(-1.0D, -1.0D);
/*  974 */     private final TileTexture.TileTextureScroller tex2 = (SPRITES.textures()).water.scroller(1.5D, 1.5D);
/*  975 */     private final OpacityImp o2 = new OpacityImp(63);
/*      */     
/*  977 */     private final int[] offs = Alloc.ii(16);
/*      */     
/*      */     final SPRITE icon;
/*      */ 
/*      */     
/*      */     Sprites() throws IOException {
/*  983 */       for (int i = 0; i < this.offs.length; i++) {
/*  984 */         int k = i;
/*  985 */         if (i > 7) {
/*  986 */           k = 7 - i - 7;
/*  987 */           if (k < 0)
/*  988 */             k = 0; 
/*      */         } 
/*  990 */         this.offs[i] = k;
/*      */       } 
/*      */       
/*  993 */       this.stencil = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT_MAP().get("Water"), 576, 300)
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/*  997 */             s.house.init(0, 0, 4, 1, (ComposerDests.Dest)d.s16);
/*  998 */             for (int i = 0; i < 4; i++)
/*  999 */               s.house.setVar(i).paste(true); 
/* 1000 */             return d.s16.saveGame();
/*      */           }
/* 1003 */         }).get();
/*      */       
/* 1005 */       this.animation = (new ComposerThings.ITileSheet()
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/* 1009 */             s.house.init(0, s.house.body().y2(), 4, 2, (ComposerDests.Dest)d.s16);
/* 1010 */             for (int i = 0; i < 8; i++)
/* 1011 */               s.house.setVar(i).paste(true); 
/* 1012 */             return d.s16.saveGame();
/*      */           }
/* 1015 */         }).get();
/*      */       
/* 1017 */       this.animation_corner = (new ComposerThings.ITileSheet()
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/* 1021 */             for (int i = 0; i < 8; i += 2) {
/* 1022 */               s.house.setVar(i).pasteEdges(true);
/*      */             }
/* 1024 */             return d.s16.saveGame();
/*      */           }
/* 1027 */         }).get();
/*      */       
/* 1029 */       this.single_stencil = (new ComposerThings.ITileSheet()
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/* 1033 */             s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, d.s16);
/* 1034 */             s.full.paste(true);
/* 1035 */             return d.s16.saveGame();
/*      */           }
/* 1038 */         }).get();
/*      */       
/* 1040 */       this.single_animation = (new ComposerThings.ITileSheet()
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/* 1044 */             s.full.init(0, s.full.body().y2(), 1, 1, 16, 1, d.s16);
/* 1045 */             s.full.paste(true);
/* 1046 */             return d.s16.saveGame();
/*      */           }
/* 1049 */         }).get();
/*      */ 
/*      */       
/* 1052 */       this.ice = (new ComposerThings.ITileSheet()
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/* 1056 */             s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)d.s16);
/* 1057 */             for (int i = 0; i < 4; i++)
/* 1058 */               s.house.setVar(i).paste(true); 
/* 1059 */             return d.s16.saveGame();
/*      */           }
/* 1062 */         }).get();
/*      */       
/* 1064 */       this.ice_fulls = (new ComposerThings.ITileSheet()
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/* 1068 */             s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, d.s16);
/* 1069 */             s.full.paste(true);
/* 1070 */             return d.s16.saveGame();
/*      */           }
/* 1073 */         }).get();
/*      */       
/* 1075 */       this.edge = (new ComposerThings.ITileSheet()
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/* 1079 */             s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)d.s16);
/* 1080 */             for (int i = 0; i < 4; i++)
/* 1081 */               s.house.setVar(i).paste(true); 
/* 1082 */             return d.s16.saveGame();
/*      */           }
/* 1085 */         }).get();
/*      */       
/* 1087 */       this.bridgeRaw = (new ComposerThings.ITileSheet()
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/* 1091 */             s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, d.s16);
/* 1092 */             s.full.paste(true);
/* 1093 */             return d.s16.saveGame();
/*      */           }
/* 1096 */         }).get();
/*      */       
/* 1098 */       this.bridge = (new ComposerThings.ITileSheet()
/*      */         {
/*      */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */           {
/* 1102 */             s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)d.s16);
/* 1103 */             s.house.setVar(0).paste(true);
/* 1104 */             s.house.setVar(1).paste(true);
/* 1105 */             s.house.setVar(2).pasteEdges(true);
/* 1106 */             s.house.setVar(3).pasteEdges(true);
/*      */             
/* 1108 */             return d.s16.saveGame();
/*      */           }
/* 1111 */         }).get();
/*      */       
/* 1113 */       this.icon = (SPRITE)new SPRITE.Imp(32)
/*      */         {
/* 1115 */           final int[] dx = new int[] { 0, 16, 16 };
/* 1116 */           final int[] dy = new int[] { 0, 0, 16, 16 };
/* 1117 */           final int[] mm = new int[] { DIR.S.mask() | DIR.E.mask(), DIR.S.mask() | DIR.W.mask(), DIR.N.mask() | DIR.E.mask(), DIR.N.mask() | DIR.W.mask() };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 1124 */             for (int i = 0; i < 4; i++) {
/* 1125 */               int x = X1 + this.dx[i];
/* 1126 */               int y = Y1 + this.dy[i];
/* 1127 */               int x2 = x + 16;
/* 1128 */               int y2 = y + 16;
/* 1129 */               int t = this.mm[i];
/* 1130 */               TWater.Sprites.this.normal.bind();
/* 1131 */               TWater.Sprites.this.stencil.render(r, t, x, x2, y, y2);
/* 1132 */               (SETT.GROUND()).types.NORMAL.miniC.bind();
/* 1133 */               TWater.Sprites.this.edge.render(r, t, x, x2, y, y2);
/*      */             } 
/*      */ 
/*      */             
/* 1137 */             COLOR.unbind();
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void update(double ds) {
/* 1145 */       this.waterTimer += ds;
/* 1146 */       if (this.waterTimer > 0.20000000298023224D) {
/* 1147 */         this.waterTimer -= 0.20000000298023224D;
/* 1148 */         this.shoreOff = (short)(this.shoreOff + this.shoreDir);
/* 1149 */         if (this.shoreOff >= 7) {
/* 1150 */           this.shoreDir = -1;
/* 1151 */         } else if (this.shoreOff == 0) {
/* 1152 */           this.shoreDir = 1;
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1157 */       double wx = ds * (1.0D + (SETT.WEATHER()).wind.getD() * 6.0D) * (SETT.WEATHER()).wind.dirX();
/* 1158 */       double wy = ds * (1.0D + (SETT.WEATHER()).wind.getD() * 6.0D) * (SETT.WEATHER()).wind.dirY();
/* 1159 */       this.dis1.update(ds);
/* 1160 */       this.dis2.update((SETT.WEATHER()).wind.dirX() * ds * 0.8D, (SETT.WEATHER()).wind.dirY() * ds * 0.8D);
/* 1161 */       this.tex1.update(ds);
/* 1162 */       this.tex2.update(-wx * 1.5D, -wy * 1.2D);
/*      */       
/* 1164 */       this.shore.interpolate((SETT.TERRAIN()).colors.waternormal, (SETT.TERRAIN()).colors.waterWinter, 1.0D - (SETT.WEATHER()).growth.getD());
/* 1165 */       this.normal.set((COLOR)this.shore).shadeSelf(0.5D);
/* 1166 */       this.deep.set((COLOR)this.normal).shadeSelf(0.75D);
/*      */     }
/*      */ 
/*      */     
/*      */     public void renderIce(int mask, int corner, RenderData.RenderIterator it) {
/* 1171 */       int ran = it.ran();
/* 1172 */       int x = it.x();
/* 1173 */       int y = it.y();
/*      */       
/* 1175 */       if (mask == 15) {
/* 1176 */         this.ice_fulls.render((SPRITE_RENDERER)CORE.renderer(), ran & 0xF, x, y);
/*      */       } else {
/* 1178 */         this.ice.render((SPRITE_RENDERER)CORE.renderer(), (ran & 0x3) * 16 + mask, x, y);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void render(int mask, int corner, RenderData.RenderIterator it, COLOR cForeGround, COLOR bg) {
/* 1184 */       int ran = it.ran();
/* 1185 */       int x = it.x();
/* 1186 */       int y = it.y();
/*      */       
/* 1188 */       if (mask == 0) {
/* 1189 */         bg.bind();
/* 1190 */         int t = ran & 0xF;
/* 1191 */         this.single_stencil.render((SPRITE_RENDERER)CORE.renderer(), t, x, y);
/* 1192 */         cForeGround.bind();
/* 1193 */         this.single_stencil.renderTextured(this.single_animation.getTexture(t), t, x, y);
/*      */       } else {
/* 1195 */         int stenI = (ran & 0x3) * 16 + mask;
/*      */ 
/*      */         
/* 1198 */         ran >>= 2;
/* 1199 */         int off = (int)(TIME.currentSecond() * 5.0D);
/* 1200 */         off += -1 + (ran & 0x3);
/* 1201 */         off &= 0xF;
/* 1202 */         off = this.offs[off];
/*      */         
/* 1204 */         int texI = off * 16 + mask;
/*      */         
/* 1206 */         bg.bind();
/* 1207 */         this.stencil.render((SPRITE_RENDERER)CORE.renderer(), stenI, x, y);
/*      */         
/* 1209 */         cForeGround.bind();
/* 1210 */         if (mask != 15) {
/* 1211 */           this.stencil.renderTextured(this.animation.getTexture(texI), stenI, x, y);
/*      */         }
/*      */         
/* 1214 */         if (corner != 0) {
/* 1215 */           this.animation_corner.render((SPRITE_RENDERER)CORE.renderer(), 16 * off / 2 + corner, x, y);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void above(int mask, int corner, RenderData.RenderIterator it) {
/* 1222 */       int ran = it.ran();
/* 1223 */       int x = it.x();
/* 1224 */       int y = it.y();
/*      */       
/* 1226 */       mask &= 0xF;
/*      */       
/* 1228 */       if (mask == 15) {
/*      */         return;
/*      */       }
/* 1231 */       int stenI = (ran & 0x3) * 16 + mask;
/*      */ 
/*      */ 
/*      */       
/* 1235 */       TextureCoords tex = SETT.GROUND().getTexture(it.tile(), it.ran());
/* 1236 */       ((GroundType)(SETT.GROUND()).MAP.get(it.tile())).col(it.tile()).bind();
/* 1237 */       this.edge.renderTextured(tex, stenI, x, y);
/* 1238 */       COLOR.unbind();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     void renderTexture(RenderData.RenderIterator i) {
/* 1244 */       if ((S.get()).graphics.get() == 0) {
/*      */         return;
/*      */       }
/* 1247 */       this.normal.bind();
/* 1248 */       this.o2.bind();
/*      */       
/* 1250 */       CORE.renderer().renderDisplace(this.dis1.x1(i.tx() + 4), this.dis1.y1(i.ty() + 4), this.tex1.x1(i.tx() + 2), this.tex1.y1(i.ty() + 2), 
/* 1251 */           16, 16, 16.0D, 
/* 1252 */           i.x(), i.x() + 64, i.y(), i.y() + 64);
/*      */       
/* 1254 */       CORE.renderer().renderDisplace(this.dis1.x1(i.tx() + 4), this.dis1.y1(i.ty() + 4), this.tex1.x1(i.tx() + 2), this.tex1.y1(i.ty() + 2), 
/* 1255 */           16, 16, 16.0D, 
/* 1256 */           i.x(), i.x() + 64, i.y(), i.y() + 64);
/* 1257 */       COLOR.unbind();
/* 1258 */       OPACITY.O25.bind();
/*      */       
/* 1260 */       CORE.renderer().renderDisplace(this.dis2.x1(i.tx()), this.dis2.y1(i.ty()), this.tex2.x1(i.tx()), this.tex2.y1(i.ty()), 
/* 1261 */           16, 16, 8.0D, 
/* 1262 */           i.x(), i.x() + 64, i.y(), i.y() + 64);
/*      */       
/* 1264 */       OPACITY.unbind();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TWater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */