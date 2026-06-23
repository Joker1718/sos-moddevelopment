/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.Sheet;
/*     */ import init.sprite.game.SheetData;
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.TileTexture;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TForest
/*     */ {
/*     */   public final Small SMALL;
/*     */   public final Medium MEDIUM;
/*     */   public final Big BIG;
/*     */   private final Sprites sprites;
/*  60 */   private static CharSequence ¤¤name = "¤Tree";
/*     */   
/*     */   public final SPRITE icon;
/*  63 */   private double clearAm = 0.0D;
/*     */   
/*     */   static {
/*  66 */     D.ts(TForest.class);
/*     */   }
/*  68 */   private final double[] mshades = new double[32];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MAX_AMOUNT = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TAmount amount;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTree(int tx, int ty) {
/* 114 */     return SETT.TERRAIN().get(tx, ty) instanceof Tree;
/*     */   }
/*     */   
/*     */   public boolean isTree(int tile) {
/* 118 */     return SETT.TERRAIN().get(tile) instanceof Tree;
/*     */   }
/*     */   
/*     */   void update(double ds) {
/* 122 */     this.sprites.update(ds);
/*     */   }
/*     */   
/*     */   TForest(Terrain t) throws IOException
/*     */   {
/* 127 */     this.amount = new TAmount(8, "Tree")
/*     */       {
/*     */ 
/*     */         
/*     */         public int get(int tile)
/*     */         {
/* 133 */           if (TForest.this.isTree(tile)) {
/* 134 */             return CLAMP.i(1 + ((SETT.TERRAIN()).data.get(tile) >> 8 & 0x7), 0, 4);
/*     */           }
/* 136 */           return 0; } private COLOR bg = (COLOR)new ColorImp(102, 87, 65); private COLOR bg2 = (COLOR)this.bg.shade(0.6D); private final int[] dx = new int[] { 0, 16, 16 }; }; this.sprites = new Sprites();
/*     */     this.SMALL = new Small(t);
/*     */     this.MEDIUM = new Medium(t);
/*     */     this.BIG = new Big(t);
/*     */     for (int i = 0; i < this.mshades.length; i++)
/*     */       this.mshades[i] = 0.8D + RND.rFloat(0.2D); 
/* 142 */     this.icon = (SPRITE)new SPRITE.Imp(32) { public MAP_INTE set(int tile, int value) { if (value <= 0) {
/* 143 */             if (TForest.this.isTree(tile)) {
/* 144 */               (SETT.TERRAIN()).NADA.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */             }
/*     */           } else {
/* 147 */             if (!TForest.this.isTree(tile)) {
/* 148 */               TForest.this.SMALL.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */             }
/*     */             
/* 151 */             value = CLAMP.i(value - 1, 0, 3);
/* 152 */             int d = (SETT.TERRAIN()).data.get(tile);
/*     */             
/* 154 */             d &= 0xFF;
/* 155 */             d |= value << 8;
/*     */             
/* 157 */             (SETT.TERRAIN()).data.set(tile, d);
/*     */           } 
/* 159 */           return this; } private final int[] dy = new int[] { 0, 0, 16, 16 }; public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { this.bg2.render(r, X1, X2, Y1, Y2); this.bg.render(r, X1 + 2, X2 - 2, Y1 + 2, Y2 - 2); for (int i = 0; i < 4; i++) {
/*     */             int x = X1 + this.dx[i]; int y = Y1 + this.dy[i]; int x2 = x + 16; int y2 = y + 16;
/*     */             ((COLOR)(SETT.TERRAIN()).colors.tree.fertile.get(0)).bind();
/*     */             TForest.this.sprites.smedium.render(r, i, x, x2, y, y2);
/*     */           } 
/*     */           COLOR.unbind(); } }; } public abstract class Tree extends Terrain.TerrainTile {
/* 165 */     private final TerrainClearing clearing = new TerrainClearing()
/*     */       {
/* 167 */         private SoundRace sound = AUDIO.race("CLEAR_TREE");
/*     */ 
/*     */ 
/*     */         
/*     */         public RESOURCE clear1(int tx, int ty) {
/* 172 */           int a = (TForest.Tree.access$0(TForest.Tree.this)).amount.get(tx, ty);
/* 173 */           if (a > 0) {
/*     */             
/* 175 */             if (a == 1) {
/* 176 */               (SETT.TERRAIN()).DECOR_WOOD.placeFixed(tx, ty);
/* 177 */               return RESOURCES.WOOD();
/*     */             } 
/* 179 */             (TForest.Tree.access$0(TForest.Tree.this)).amount.increment(tx, ty, -1);
/*     */           } else {
/* 181 */             GAME.Notify("what??? " + tx + " " + ty + " " + a);
/*     */           } 
/*     */           
/* 184 */           (TForest.Tree.access$0(TForest.Tree.this)).clearAm += 0.25D;
/* 185 */           if ((TForest.Tree.access$0(TForest.Tree.this)).clearAm >= 1.0D) {
/* 186 */             return RESOURCES.WOOD();
/*     */           }
/* 188 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean can() {
/* 193 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public int clearAll(int tx, int ty) {
/* 198 */           int a = (TForest.Tree.access$0(TForest.Tree.this)).amount.get(tx, ty);
/* 199 */           (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/* 200 */           return a;
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace sound(int tx, int ty) {
/* 205 */           return this.sound;
/*     */         }
/*     */ 
/*     */         
/*     */         public double strength() {
/* 210 */           return super.strength() * 4.0D;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean place(int tx, int ty) {
/* 219 */       TForest.this.isTree(tx, ty);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 226 */       if (!this.shared.TREES.BIG.tryPlace(tx, ty) && 
/* 227 */         !this.shared.TREES.MEDIUM.tryPlace(tx, ty))
/* 228 */         this.shared.TREES.SMALL.tryPlace(tx, ty); 
/* 229 */       TForest.this.amount.set(tx, ty, 4);
/*     */       
/* 231 */       return false;
/*     */     }
/*     */     
/*     */     protected Tree(Terrain shared, int i) {
/* 235 */       super("TREE_SIZE_" + i, shared, TForest.¤¤name, (SPRITE)(SPRITES.icons()).m.cancel, shared.colors.minimap.tree);
/*     */     }
/*     */ 
/*     */     
/*     */     public TerrainClearing clearing() {
/* 240 */       return this.clearing;
/*     */     }
/*     */ 
/*     */     
/*     */     public AVAILABILITY getAvailability(int x, int y) {
/* 245 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void unplace(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfo(GBox box, int tx, int ty) {
/* 255 */       box.add((SPRITE)RESOURCES.WOOD().icon());
/* 256 */       box.textLL((RESOURCES.WOOD()).name);
/* 257 */       box.tab(6);
/* 258 */       box.add((SPRITE)GFORMAT.i(box.text(), TForest.this.amount.get(tx, ty)));
/*     */     }
/*     */ 
/*     */     
/*     */     public int miniDepth() {
/* 263 */       return 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public TERRAIN terrain(int tx, int ty) {
/* 268 */       return TERRAINS.FOREST();
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightStart(int tx, int ty) {
/* 273 */       return 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightEnd(int tx, int ty) {
/* 278 */       return 4;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class Small
/*     */     extends Tree
/*     */   {
/*     */     private Small(Terrain shared) {
/* 289 */       super(shared, 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isPlacable(int tx, int ty) {
/* 294 */       return SETT.IN_BOUNDS(tx, ty);
/*     */     }
/*     */     
/*     */     private boolean tryPlace(int tx, int ty) {
/* 298 */       placeRaw(tx, ty);
/* 299 */       this.shared.data.set(tx, ty, RND.rInt(32));
/* 300 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 305 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 310 */       SheetType.c1X1 c1X1 = SheetType.s1x1;
/* 311 */       data &= 0xFF;
/* 312 */       SheetPair sheet = TForest.this.sprites.small;
/* 313 */       int tile = c1X1.tile(sheet, data, i.ran(), 0);
/* 314 */       sheet.s.render(sheet.d, i.x(), i.y(), i, r, tile, i.ran(), 0.0D);
/* 315 */       sheet.s.renderShadow(sheet.d, i.x(), i.y(), i, s, tile, i.ran());
/* 316 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 321 */       c.shadeSelf(TForest.this.mshades[x + y & TForest.this.mshades.length - 1]);
/* 322 */       return (COLOR)c;
/*     */     }
/*     */   }
/*     */   
/*     */   public class Medium
/*     */     extends Tree
/*     */   {
/*     */     private Medium(Terrain shared) {
/* 330 */       super(shared, 1);
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean tryPlace(int tx, int ty) {
/* 335 */       if (is(tx, ty)) {
/* 336 */         int i = this.shared.data.get(tx, ty) & 0x3;
/* 337 */         if (tryVar(tx, ty, i) >= 0) {
/* 338 */           return true;
/*     */         }
/*     */       } 
/* 341 */       for (int var = 0; var < 4; var++) {
/* 342 */         int i = tryVar(tx, ty, var);
/* 343 */         if (i >= 0) {
/* 344 */           super.placeRaw(tx, ty);
/* 345 */           this.shared.data.set(tx, ty, i);
/* 346 */           return true;
/*     */         } 
/*     */       } 
/* 349 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     private int tryVar(int tx, int ty, int var) {
/* 354 */       int rx = var % 2;
/* 355 */       int ry = var / 2;
/*     */       
/* 357 */       for (int ov = 0; ov < 4; ov++) {
/*     */         
/* 359 */         if (ov != var) {
/*     */ 
/*     */           
/* 362 */           int dx = ov % 2;
/* 363 */           int dy = ov / 2;
/* 364 */           dx -= rx;
/* 365 */           dy -= ry;
/* 366 */           int x = tx + dx;
/* 367 */           int y = ty + dy;
/*     */           
/* 369 */           if (!SETT.IN_BOUNDS(x, y))
/* 370 */             return -1; 
/* 371 */           if (!this.shared.TREES.SMALL.is(x, y) && (!is(x, y) || (this.shared.data.get(x, y) & 0x3) != ov)) {
/* 372 */             return -1;
/*     */           }
/*     */         } 
/*     */       } 
/* 376 */       return var;
/*     */     }
/*     */ 
/*     */     
/*     */     public void placeRaw(int tx, int ty) {
/* 381 */       if (this.shared.NADA.is(tx + 1, ty))
/* 382 */         this.shared.TREES.SMALL.placeRaw(tx + 1, ty); 
/* 383 */       if (this.shared.NADA.is(tx, ty + 1))
/* 384 */         this.shared.TREES.SMALL.placeRaw(tx, ty + 1); 
/* 385 */       if (this.shared.NADA.is(tx + 1, ty + 1))
/* 386 */         this.shared.TREES.SMALL.placeRaw(tx + 1, ty + 1); 
/* 387 */       placeFixed(tx, ty);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 393 */       data &= 0xFF;
/* 394 */       SheetType.cXxX type = SheetType.s2x2;
/* 395 */       SheetPair sheet = TForest.this.sprites.medium;
/*     */       
/* 397 */       int dx = type.dx(data);
/* 398 */       int dy = type.dy(data);
/* 399 */       int ran = i.ranGet(-dx, -dy);
/*     */       
/* 401 */       int tile = type.tile(sheet, data, ran, 0);
/* 402 */       sheet.s.render(sheet.d, i.x(), i.y(), i, r, tile, ran, 0.0D);
/* 403 */       s.setHeight(2).setDistance2Ground(5.0D);
/* 404 */       sheet.s.renderShadow(sheet.d, i.x(), i.y(), i, s, tile, ran);
/* 405 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 410 */       (SETT.TERRAIN()).BUSH.render(i, r, s, i.x(), i.y(), i.ran());
/* 411 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isPlacable(int tx, int ty) {
/* 416 */       return (SETT.IN_BOUNDS(tx, ty) && SETT.IN_BOUNDS(tx + 1, ty + 1));
/*     */     }
/*     */ 
/*     */     
/*     */     public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 421 */       int data = this.shared.data.get(x, y) & 0xFF;
/* 422 */       SheetType.cXxX type = SheetType.s2x2;
/* 423 */       c.shadeSelf(TForest.this.mshades[x - type.dx(data) + y - type.dy(data) & TForest.this.mshades.length - 1]);
/* 424 */       if (type.dy(data) + type.dx(data) == 0)
/* 425 */         c.shadeSelf(1.2D); 
/* 426 */       if (type.dy(data) * type.dx(data) == 1)
/* 427 */         c.shadeSelf(0.8D); 
/* 428 */       return (COLOR)c;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class Big
/*     */     extends Tree
/*     */   {
/*     */     private Big(Terrain shared) {
/* 437 */       super(shared, 2);
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean tryPlace(int tx, int ty) {
/* 442 */       if (is(tx, ty)) {
/* 443 */         int i = this.shared.data.get(tx, ty) & 0xF;
/* 444 */         if (tryVar(tx, ty, i) >= 0) {
/* 445 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 449 */       for (int var = 0; var < 9; var++) {
/* 450 */         int i = tryVar(tx, ty, var);
/* 451 */         if (i >= 0) {
/* 452 */           super.placeRaw(tx, ty);
/* 453 */           this.shared.data.set(tx, ty, i);
/* 454 */           return true;
/*     */         } 
/*     */       } 
/* 457 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void placeRaw(int tx, int ty) {
/* 463 */       this.shared.TREES.SMALL.placeRaw(tx + 1, ty);
/* 464 */       this.shared.TREES.SMALL.placeRaw(tx + 2, ty);
/* 465 */       this.shared.TREES.SMALL.placeRaw(tx, ty + 1);
/* 466 */       this.shared.TREES.SMALL.placeRaw(tx + 1, ty + 1);
/* 467 */       this.shared.TREES.SMALL.placeRaw(tx + 2, ty + 1);
/* 468 */       this.shared.TREES.SMALL.placeRaw(tx, ty + 2);
/* 469 */       this.shared.TREES.SMALL.placeRaw(tx + 1, ty + 2);
/* 470 */       this.shared.TREES.SMALL.placeRaw(tx + 2, ty + 2);
/* 471 */       placeFixed(tx, ty);
/*     */     }
/*     */     
/*     */     private int tryVar(int tx, int ty, int var) {
/* 475 */       int rx = var % 3;
/* 476 */       int ry = var / 3;
/*     */       
/* 478 */       for (int ov = 0; ov < 9; ov++) {
/*     */         
/* 480 */         if (ov != var) {
/*     */ 
/*     */           
/* 483 */           int dx = ov % 3;
/* 484 */           int dy = ov / 3;
/* 485 */           dx -= rx;
/* 486 */           dy -= ry;
/* 487 */           int x = tx + dx;
/* 488 */           int y = ty + dy;
/*     */           
/* 490 */           if (!SETT.IN_BOUNDS(x, y))
/* 491 */             return -1; 
/* 492 */           if (!this.shared.TREES.SMALL.is(x, y))
/*     */           {
/* 494 */             if (!this.shared.TREES.MEDIUM.is(x, y))
/*     */             {
/* 496 */               if (!is(x, y) || (this.shared.data.get(x, y) & 0xF) != ov)
/*     */               {
/*     */                 
/* 499 */                 return -1; }  }  } 
/*     */         } 
/*     */       } 
/* 502 */       return var;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isPlacable(int tx, int ty) {
/* 507 */       return (SETT.IN_BOUNDS(tx, ty) && SETT.IN_BOUNDS(tx + 2, ty + 2));
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 512 */       SheetType.cXxX type = SheetType.s3x3;
/* 513 */       SheetPair sheet = TForest.this.sprites.big;
/* 514 */       data &= 0xFF;
/* 515 */       int dx = type.dx(data);
/* 516 */       int dy = type.dy(data);
/* 517 */       int ran = i.ranGet(-dx, -dy);
/*     */       
/* 519 */       int tile = type.tile(sheet.s, sheet.d, data, ran, 0);
/* 520 */       sheet.s.render(sheet.d, i.x(), i.y(), i, r, tile, ran, 0.0D);
/* 521 */       s.setHeight(8).setDistance2Ground(20.0D);
/* 522 */       sheet.s.renderShadow(sheet.d, i.x(), i.y(), i, s, tile, ran);
/* 523 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 528 */       (SETT.TERRAIN()).BUSH.render(i, r, s, i.x(), i.y(), i.ran());
/* 529 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 534 */       int data = this.shared.data.get(x, y) & 0xFF;
/* 535 */       SheetType.cXxX type = SheetType.s3x3;
/* 536 */       c.shadeSelf(TForest.this.mshades[x - type.dx(data) + y - type.dy(data) & TForest.this.mshades.length - 1]);
/* 537 */       double s = 1.0D;
/* 538 */       if (type.dx(data) == 0)
/* 539 */         s = 1.4D; 
/* 540 */       if (type.dy(data) == 2)
/* 541 */         s = 0.8D; 
/* 542 */       if (type.dx(data) == 2)
/* 543 */         s = 0.8D; 
/* 544 */       if (type.dy(data) == 0)
/* 545 */         s = 1.4D; 
/* 546 */       c.shadeSelf(s);
/* 547 */       return (COLOR)c;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class Sprites
/*     */   {
/*     */     private final TILE_SHEET ssmall;
/*     */     private final TILE_SHEET smedium;
/*     */     private final SheetPair small;
/*     */     private final SheetPair medium;
/*     */     private final SheetPair big;
/* 559 */     private final TForestTop top = new TForestTop();
/* 560 */     private final TForestLeafs leafs = new TForestLeafs();
/* 561 */     private final Swayer swayer = new Swayer();
/*     */ 
/*     */     
/*     */     private Sprites() throws IOException {
/* 565 */       Path p = PATHS.SPRITE_SETTLEMENT_MAP().get("Tree");
/*     */       
/* 567 */       this.ssmall = (new ComposerThings.ITileSheet(p, 720, 296)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 571 */             ComposerDests.Tile t = d.s16;
/* 572 */             s.singles.init(0, 0, 1, 1, 16, 1, (ComposerDests.Dest)t);
/* 573 */             s.singles.paste(1, true);
/* 574 */             return t.saveGame();
/*     */           }
/* 576 */         }).get();
/*     */ 
/*     */       
/* 579 */       this.smedium = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 583 */             ComposerDests.Tile t = d.s16;
/* 584 */             s.combo.init(0, s.singles.body().y2(), 8, 2, 2, (ComposerDests.Dest)t);
/* 585 */             for (int i = 0; i < 16; i++) {
/* 586 */               s.combo.setVar(i).paste(1, true);
/*     */             }
/* 588 */             return t.saveGame();
/*     */           }
/* 590 */         }).get();
/*     */       
/* 592 */       TILE_SHEET large = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 596 */             ComposerDests.Tile t = d.s16;
/*     */             
/* 598 */             s.combo.init(0, s.combo.body().y2(), 6, 3, 3, (ComposerDests.Dest)t);
/* 599 */             for (int i = 0; i < 16; i++) {
/* 600 */               s.combo.setVar(i).paste(1, true);
/*     */             }
/*     */             
/* 603 */             return t.saveGame();
/*     */           }
/* 605 */         }).get();
/*     */       
/* 607 */       this.small = make((SheetType)SheetType.s1x1, this.ssmall);
/* 608 */       this.small.d.shadowLength = 5;
/* 609 */       this.small.d.shadowHeight = 2;
/*     */       
/* 611 */       this.medium = make((SheetType)SheetType.s2x2, this.smedium);
/* 612 */       this.medium.d.shadowLength = 10;
/* 613 */       this.medium.d.shadowHeight = 6;
/* 614 */       this.big = make((SheetType)SheetType.s3x3, large);
/* 615 */       this.big.d.shadowLength = 10;
/* 616 */       this.big.d.shadowHeight = 6;
/*     */     }
/*     */ 
/*     */     
/*     */     public void update(double ds) {
/* 621 */       this.top.update(ds);
/* 622 */       this.leafs.update(ds);
/* 623 */       this.swayer.update();
/*     */     }
/*     */     
/*     */     private SheetPair make(SheetType type, TILE_SHEET sh) {
/* 627 */       FSheet fSheet = new FSheet(type, sh);
/* 628 */       ArrayList<Sheet> shh = new ArrayList(fSheet);
/* 629 */       SPRITES.GAME().add(type, (LIST)shh, "_TREE");
/* 630 */       return new SheetPair((Sheet)shh.get(0), new SheetData());
/*     */     }
/*     */     
/*     */     private static class FSheet extends Sheet.Imp {
/*     */       private final ColorImp col;
/*     */       
/*     */       public FSheet(SheetType type, TILE_SHEET s) {
/* 637 */         super(type, s, false);
/*     */ 
/*     */         
/* 640 */         this.col = new ColorImp();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/* 646 */         int ran = random;
/* 647 */         int colI = ran >> 7 & 0x1F;
/* 648 */         int swI = ran >> 10 & 0x3F;
/*     */ 
/*     */         
/* 651 */         if (degrade > 0.0D) {
/*     */           
/* 653 */           this.col.interpolate((SETT.TERRAIN()).colors.tree.get(random), (SETT.TERRAIN()).colors.tree.dry(random), degrade);
/*     */         } else {
/* 655 */           this.col.set((SETT.TERRAIN()).colors.tree.get(random));
/*     */         } 
/* 657 */         this.col.bind();
/* 658 */         x += (SETT.TERRAIN()).TREES.sprites.swayer.dx[swI];
/* 659 */         y -= (SETT.TERRAIN()).TREES.sprites.swayer.dy[swI];
/* 660 */         int offX = it.oX() + (SETT.TERRAIN()).TREES.sprites.swayer.dx[swI];
/* 661 */         int offY = it.oY() - (SETT.TERRAIN()).TREES.sprites.swayer.dy[swI];
/*     */         
/* 663 */         it.setOff(offX, offY);
/* 664 */         this.sheet.render(sr, tile, x, y);
/* 665 */         if ((S.get()).graphics.get() > 0) {
/* 666 */           (SETT.TERRAIN()).TREES.sprites.top.render(x, y, sr, 0, it, colI);
/* 667 */           (SETT.TERRAIN()).TREES.sprites.leafs.render(x, y, it.ran());
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 672 */         COLOR.unbind();
/* 673 */         it.countVegetation();
/* 674 */         it.countVegetation();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/* 680 */         super.renderShadow(da, x, y, it, shadow, tile, random);
/*     */       }
/*     */     }
/*     */     
/*     */     private static class TForestLeafs
/*     */     {
/*     */       private static final int AMOUNT = 32;
/*     */       private final LeafTile[] tiles;
/* 688 */       private double time = (RND.rFloat() * 10000.0F);
/* 689 */       private int t = 0;
/* 690 */       private int am = 4;
/*     */       
/*     */       private TForestLeafs() {
/* 693 */         this.tiles = new LeafTile[32];
/* 694 */         for (int i = 0; i < 32; i++) {
/* 695 */           this.tiles[i] = new LeafTile();
/*     */         }
/* 697 */         update(0.0D);
/*     */       }
/*     */       
/*     */       public void render(int x, int y, int ran) {
/* 701 */         this.tiles[ran & 0x1F].render(x, y, this.t, this.am);
/*     */       }
/*     */ 
/*     */       
/*     */       void update(double ds) {
/* 706 */         this.am = 4;
/* 707 */         if (SETT.WEATHER() != null) {
/* 708 */           this.time += ds * (1.0D + 3.0D * (SETT.WEATHER()).wind.getD());
/* 709 */           double winter = 1.0D - (SETT.WEATHER()).growth.getD();
/* 710 */           if (winter > 0.5D && !(SETT.WEATHER()).growth.isAutumn()) {
/* 711 */             this.am = (int)((1.0D - (winter - 0.5D) * 2.0D) * 4.0D);
/*     */           }
/*     */         } 
/*     */         
/* 715 */         if (this.time > 10000.0D)
/* 716 */           this.time -= 10000.0D; 
/* 717 */         this.t = (int)(this.time * 12.8D) & 0x7F;
/*     */       }
/*     */ 
/*     */       
/*     */       private static class LeafTile
/*     */       {
/*     */         private static final int ticks = 128;
/*     */         
/*     */         private static final int tmask = 127;
/*     */         private static final int amount = 4;
/*     */         private static final double time = 10.0D;
/*     */         private static final double ticksPerTime = 12.8D;
/* 729 */         private final byte[][] xs = new byte[128][4];
/* 730 */         private final byte[][] ys = new byte[128][4];
/* 731 */         private final int ran = RND.rInt(32);
/*     */ 
/*     */         
/*     */         private LeafTile() {
/* 735 */           for (int a = 0; a < 4; a++) {
/*     */             
/* 737 */             double dvx = -(384.0F + RND.rFloat(384.0D));
/* 738 */             double dvy = (384.0F + RND.rFloat0(96.0D));
/* 739 */             dvx /= 128.0D;
/* 740 */             dvy /= 128.0D;
/* 741 */             double y = RND.rInt(64);
/* 742 */             double x = RND.rInt(32);
/*     */             
/* 744 */             int tStart = RND.rInt(128);
/* 745 */             int tStop = 8 + RND.rInt(24);
/*     */             
/* 747 */             double xsin = RND.rFloat(1.0D);
/*     */ 
/*     */             
/* 750 */             double ysin = RND.rFloat(1.0D);
/* 751 */             double dsin = (RND.rFloat() / 128.0F);
/*     */             
/* 753 */             for (int t = 0; t < 128; t++) {
/*     */               
/* 755 */               this.xs[tStart][a] = (byte)(int)x;
/* 756 */               this.ys[tStart][a] = (byte)(int)y;
/*     */ 
/*     */               
/* 759 */               tStop--;
/* 760 */               if (tStop >= 0) {
/* 761 */                 x += dvx * Math.sin(xsin);
/* 762 */                 y += dvy * Math.sin(ysin);
/* 763 */                 xsin += dsin;
/* 764 */                 ysin += dsin;
/*     */               } 
/* 766 */               tStart++;
/* 767 */               tStart &= 0x7F;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         private void render(int x, int y, int t, int amount) {
/* 774 */           byte[] xs = this.xs[t];
/* 775 */           byte[] ys = this.ys[t];
/*     */           
/* 777 */           for (int i = 0; i < amount; i++) {
/* 778 */             (SETT.TERRAIN()).colors.tree.get(this.ran).bind();
/* 779 */             CORE.renderer().renderParticle(x + xs[i], y + ys[i]);
/*     */           } 
/* 781 */           COLOR.unbind();
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static final class TForestTop
/*     */     {
/* 790 */       private final int max = 32;
/* 791 */       private final double[] speeds = new double[32];
/* 792 */       private final double[] speedsMax = new double[32];
/*     */       
/* 794 */       private final TileTexture.TileTextureScroller[] dis = new TileTexture.TileTextureScroller[32];
/*     */       
/*     */       public TForestTop() {
/* 797 */         for (int i = 0; i < 32; i++) {
/* 798 */           this.speedsMax[i] = 0.5D + RND.rFloat();
/* 799 */           this.speeds[i] = 0.5D + RND.rFloat();
/* 800 */           this.dis[i] = (SPRITES.textures()).dis_low.scroller(72.0D, -66.0D);
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       void update(double ds) {
/* 808 */         for (int i = 0; i < 32; i++) {
/* 809 */           if (this.speeds[i] > this.speedsMax[i]) {
/* 810 */             this.speeds[i] = this.speeds[i] - this.speedsMax[i] * ds * 0.2D;
/* 811 */             if (this.speeds[i] < this.speedsMax[i])
/* 812 */               this.speedsMax[i] = 0.5D + RND.rFloat(); 
/* 813 */           } else if (this.speeds[i] <= this.speedsMax[i]) {
/* 814 */             this.speeds[i] = this.speeds[i] + this.speedsMax[i] * ds * 0.2D;
/* 815 */             if (this.speeds[i] >= this.speedsMax[i])
/* 816 */               this.speedsMax[i] = 0.5D + RND.rFloat(); 
/*     */           } 
/* 818 */           this.dis[i].update(ds * this.speeds[i] * (SETT.WEATHER()).wind.getD());
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void render(int x, int y, SPRITE_RENDERER r, int tile, RenderData.RenderIterator i, int ran) {
/* 826 */         ran &= 0x1F;
/* 827 */         OPACITY.O50.bind();
/* 828 */         TextureCoords t = (SPRITES.textures()).dots.get(i.tx(), i.ty(), 0.0D, 0.0D);
/* 829 */         TextureCoords d = this.dis[ran].get(i.tx(), i.ty());
/* 830 */         CORE.renderer().renderDisplaced(x, x + 64, y, y + 64, d, t);
/* 831 */         OPACITY.unbind();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private static class Swayer
/*     */     {
/* 838 */       private final int am = 64;
/* 839 */       private final byte[] dx = Alloc.bb(64);
/* 840 */       private final byte[] dy = Alloc.bb(64);
/*     */       
/* 842 */       private final double[] dz = new double[64];
/* 843 */       private double[] ran = new double[64];
/*     */       
/*     */       double dd;
/*     */       
/* 847 */       private double lastSecond = 0.0D;
/*     */       
/*     */       Swayer() {
/* 850 */         for (int i = 0; i < 64; i++) {
/* 851 */           this.dx[i] = (byte)RND.rInt(16);
/* 852 */           this.dy[i] = (byte)RND.rInt(16);
/* 853 */           this.ran[i] = RND.rFloat() * Math.PI * 2.0D;
/* 854 */           this.dz[i] = 0.1D + 0.9D * RND.rFloat();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void update() {
/* 861 */         if (TIME.currentSecond() == this.lastSecond) {
/*     */           return;
/*     */         }
/* 864 */         double ds = TIME.currentSecond() - this.lastSecond;
/* 865 */         this.lastSecond = TIME.currentSecond();
/*     */         
/* 867 */         double d = ((SETT.WEATHER()).wind.getD() - 0.4D) / 0.4D;
/* 868 */         if (d < 0.0D) {
/* 869 */           d = 0.0D;
/*     */         }
/* 871 */         this.dd += ds * d * 4.0D;
/*     */         
/* 873 */         for (int i = 0; i < 64; i++) {
/* 874 */           double cos = Math.cos(this.dd + this.ran[i]);
/* 875 */           double a = this.dz[i] * 4.0D * cos;
/* 876 */           this.dx[i] = (byte)(int)a;
/* 877 */           this.dy[i] = (byte)(int)a;
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TForest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */