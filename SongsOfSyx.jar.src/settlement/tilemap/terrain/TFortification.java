/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.Faction;
/*     */ import game.faction.player.PlayerColors;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.thing.pointlight.LOS;
/*     */ import settlement.tilemap.TILE_FIXABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFortification
/*     */   implements MAPPED
/*     */ {
/*     */   private static final String KEY = "FORTIFICATION";
/*     */   private static final int SET = 16;
/*     */   private static final int DIAGONAL = 64;
/*     */   private static final int CORNERS = 128;
/*     */   private static final int BROKEN = 144;
/*     */   private static final int SINGLES = 208;
/*     */   private static final int FULLS = 224;
/*     */   private static final int DIA = 4096;
/*     */   private final TerrainClearing clear;
/*     */   public final Normal tile;
/*     */   public final TFortificationTileBroken broken;
/*     */   public final PlayerColors.PlayerColor tint;
/*     */   public final CharSequence desc;
/*     */   public double durability;
/*     */   public final TILE_SHEET sheet;
/*     */   public final RESOURCE resource;
/*     */   public final int resAmount;
/*     */   public int sHeight;
/*     */   private final int index;
/*     */   public final SoundRace sound;
/*     */   private final int height;
/*     */   private final String key;
/*     */   public final Lockable<Faction> reqs;
/*     */   public final RoomSprite rSprite;
/*     */   
/*     */   static RMAP<TFortification> make(Terrain t) throws IOException {
/*  85 */     String f = "FORTIFICATION".toLowerCase(Locale.ROOT);
/*  86 */     PATH gData = PATHS.INIT_SETTLEMENT().getFolder(f);
/*  87 */     PATH gSprite = PATHS.SPRITE_SETTLEMENT().getFolder(f);
/*  88 */     PATH gText = PATHS.TEXT_SETTLEMENT().getFolder(f);
/*     */     
/*  90 */     String[] keys = gData.getFiles();
/*  91 */     ArrayList arrayList = new ArrayList(keys.length);
/*  92 */     HashMap<String, TFortification> others = new HashMap<>(); byte b; int i; String[] arrayOfString1;
/*  93 */     for (i = (arrayOfString1 = keys).length, b = 0; b < i; ) { String key = arrayOfString1[b];
/*  94 */       Json data = new Json(gData.gets(key));
/*  95 */       Json text = new Json(gText.gets(key));
/*  96 */       String sp = data.value("SPRITE");
/*  97 */       if (others.containsKey(sp)) {
/*     */ 
/*     */       
/*     */       } else {
/*     */         
/* 102 */         final TILE_SHEET sheet = (new ComposerThings.ITileSheet(gSprite.get(sp), 576, 144)
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 106 */               s.house.init(0, 0, 4, 2, (ComposerDests.Dest)d.s16);
/* 107 */               s.house.setVar(0).paste(true);
/* 108 */               s.house.setVar(0).pasteRotated(2, true);
/* 109 */               s.house.setVar(1).paste(true);
/* 110 */               s.house.setVar(1).pasteRotated(2, true);
/* 111 */               s.house.setVar(2).paste(true);
/* 112 */               s.house.setVar(2).pasteRotated(2, true);
/* 113 */               s.house.setVar(3).paste(true);
/* 114 */               s.house.setVar(3).pasteRotated(2, true);
/*     */               
/* 116 */               s.house.setVar(0).setSkip(0, 1).pasteEdges(true);
/*     */               
/* 118 */               s.house.setVar(4).setSkip(0, 16).paste(true);
/* 119 */               s.house.setVar(4).pasteRotated(2, true);
/* 120 */               s.house.setVar(5).paste(true);
/* 121 */               s.house.setVar(5).pasteRotated(2, true);
/*     */               
/* 123 */               s.full.init(144, 72, 1, 1, 8, 1, d.s16);
/* 124 */               s.full.paste(true);
/* 125 */               s.full.pasteRotated(2, true);
/* 126 */               s.full.init(s.full.body().x1(), s.full.body().y2(), 1, 1, 8, 1, d.s16);
/* 127 */               s.full.paste(true);
/* 128 */               s.full.pasteRotated(2, true);
/*     */               
/* 130 */               return d.s16.saveGame();
/*     */             }
/* 132 */           }).get();
/*     */         
/* 134 */         SPRITE.Imp imp = new SPRITE.Imp(32)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 138 */               int XX = (X2 - X1) / 2;
/* 139 */               int YY = (Y2 - Y1) / 2;
/* 140 */               sheet.render(r, DIR.S.mask() | DIR.E.mask(), X1, X1 + XX, Y1, Y1 + YY);
/* 141 */               sheet.render(r, DIR.S.mask() | DIR.W.mask(), X1 + XX, X1 + XX * 2, Y1, Y1 + YY);
/* 142 */               sheet.render(r, DIR.N.mask() | DIR.E.mask(), X1, X1 + XX, Y1 + YY, Y1 + YY * 2);
/* 143 */               sheet.render(r, DIR.N.mask() | DIR.W.mask(), X1 + XX, X1 + XX * 2, Y1 + YY, Y1 + YY * 2);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/* 148 */         TFortification fort = new TFortification(key, t, (LISTE<TFortification>)arrayList, data, text, (SPRITE)imp, sheet);
/* 149 */         others.put(sp, fort);
/*     */       } 
/*     */       b++; }
/*     */     
/* 153 */     return new RMAP("FORTIFICATION", (LIST)arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TFortification(String key, Terrain t, LISTE<TFortification> all, Json data, Json text, SPRITE icon, TILE_SHEET sheet) {
/* 214 */     this.rSprite = new RoomSprite()
/*     */       {
/*     */         public int sData()
/*     */         {
/* 218 */           return 0;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 224 */           TFortification.this.tile.renderBelow(r, s, it, data);
/* 225 */           return false;
/*     */         }
/*     */         public RESOURCE clear1(int tx, int ty) { (SETT.TERRAIN()).NADA.placeFixed(tx, ty); return TFortification.this.resource; } public boolean can() { return true; } public int clearAll(int tx, int ty) { (SETT.TERRAIN()).NADA.placeFixed(tx, ty); return 1; } public SoundRace sound(int tx, int ty) { return TFortification.this.sound; } }; this.sheet = sheet; this.key = key; this.durability = data.d("DURABILITY", 0.0D, 1.0D) * 64.0D; this.desc = text.text("DESC"); this.resource = (RESOURCE)RESOURCES.map().read(data); this.resAmount = data.i("RESOURCE_AMOUNT"); this.sHeight = data.i("HEIGHT", 0, 20); this.height = (int)(Math.ceil(this.sHeight / 20.0D) * 10.0D); this.index = all.add(this); this.sound = AUDIO.race("BUILD_FORTIFICATION_" + key); this.tile = new Normal(key, t, data, text, icon, sheet, this); this.broken = new TFortificationTileBroken(key, t, data, text, icon, sheet, this); this.tint = new PlayerColors.PlayerColor(new ColorImp(data), "FORT_" + key, Dic.¤¤Fortifications, this.tile.name()); this.reqs = GVALUES.FACTION.LOCK.push("FORTIFICATION_" + key, this.tile.name(), this.desc, icon);
/*     */     this.clear = new TerrainClearing()
/*     */       {
/* 230 */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) { int res = 0;
/* 231 */           for (DIR d : DIR.ORTHO) {
/* 232 */             if (item.is(rx, ry, d)) {
/* 233 */               res |= d.mask();
/*     */             }
/*     */           } 
/* 236 */           int cor = 0;
/* 237 */           for (DIR d : DIR.NORTHO) {
/* 238 */             if (!item.is(rx, ry, d) && item.is(rx, ry, d.next(1)) && item.is(rx, ry, d.next(-1))) {
/* 239 */               cor |= d.mask();
/*     */             }
/*     */           } 
/* 242 */           res |= cor << 4;
/* 243 */           return (byte)res; }
/*     */         public boolean isStructure() { return true; }
/*     */         public void destroy(int tx, int ty) { TFortification.this.broken.placeFixed(tx, ty); }
/*     */         public double strength() { return TFortification.this.durability * 2500.0D; }
/*     */       };
/*     */   } public int index() {
/* 249 */     return this.index;
/*     */   }
/*     */   
/*     */   public static abstract class Tile
/*     */     extends Terrain.TerrainTile
/*     */     implements TerrainDiagonal.Diagonalizer
/*     */   {
/*     */     public final TFortification fort;
/*     */     
/*     */     Tile(String key, Terrain shared, CharSequence name, SPRITE icon, COLOR miniC, TFortification tFortification) {
/* 259 */       super(key, shared, name, icon, miniC);
/* 260 */       this.fort = tFortification;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean place(int tx, int ty) {
/* 266 */       boolean dia = (is(tx, ty) && (this.shared.data.get(tx, ty) & 0x1000) != 0);
/* 267 */       if (this.shared.get(tx, ty) == this.fort.tile || this.shared.get(tx, ty) == this.fort.broken) {
/* 268 */         dia |= getDia(tx, ty);
/*     */       }
/* 270 */       boolean full = (is(tx, ty) && (this.shared.data.get(tx, ty) & 0xF) == 15);
/*     */       
/* 272 */       placeRaw(tx, ty);
/* 273 */       int res = 0;
/* 274 */       for (DIR d : DIR.ORTHO) {
/* 275 */         if (j(tx, ty, d)) {
/* 276 */           res |= d.mask();
/*     */         }
/*     */       } 
/* 279 */       int cor = 0;
/* 280 */       for (DIR d : DIR.NORTHO) {
/* 281 */         if (!j(tx, ty, d) && j(tx, ty, d.next(1)) && j(tx, ty, d.next(-1))) {
/* 282 */           cor |= d.mask();
/*     */         }
/*     */       } 
/* 285 */       res |= cor << 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 293 */       if (res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.N)) {
/* 294 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.N);
/* 295 */         if (!(t instanceof Tile) && t.wallIsWally() && (res & DIR.N.mask()) != 0) {
/* 296 */           res |= 0x100;
/*     */         }
/*     */       } 
/* 299 */       if (res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.W)) {
/* 300 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.W);
/* 301 */         if (!(t instanceof Tile) && t.wallIsWally() && (res & DIR.W.mask()) != 0) {
/* 302 */           res |= 0x200;
/*     */         }
/*     */       } 
/*     */       
/* 306 */       this.shared.data.set(tx, ty, res);
/* 307 */       setDia(tx, ty, dia);
/* 308 */       return full ^ (((this.shared.data.get(tx, ty) & 0xF) == 15));
/*     */     }
/*     */ 
/*     */     
/*     */     boolean j(int tx, int ty, DIR d) {
/* 313 */       return !(!this.fort.tile.is(tx, ty, d) && !this.fort.broken.is(tx, ty, d) && !(SETT.TERRAIN()).FSTAIRS.is(tx, ty, d));
/*     */     }
/*     */ 
/*     */     
/*     */     boolean wallJoiner() {
/* 318 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean wallIsWally() {
/* 323 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isMassiveWall() {
/* 328 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 334 */       return false;
/*     */     }
/*     */     
/*     */     void renderEdges(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 338 */       int cor = data >> 4 & 0xF;
/* 339 */       if ((data & 0x100) != 0) {
/* 340 */         if ((data & DIR.W.mask()) == 0 || (cor & DIR.NW.mask()) != 0) {
/* 341 */           (SETT.TERRAIN()).wall_merge.render(r, 0, i.x(), i.y() - 4);
/*     */         } else {
/* 343 */           (SETT.TERRAIN()).wall_merge.render(r, 2, i.x(), i.y() - 4);
/* 344 */         }  if ((data & DIR.E.mask()) == 0 || (cor & DIR.NE.mask()) != 0) {
/* 345 */           (SETT.TERRAIN()).wall_merge.render(r, 1, i.x(), i.y() - 4);
/*     */         } else {
/* 347 */           (SETT.TERRAIN()).wall_merge.render(r, 3, i.x(), i.y() - 4);
/*     */         } 
/* 349 */       }  if ((data & 0x200) != 0) {
/* 350 */         if ((data & DIR.N.mask()) == 0 || (cor & DIR.NW.mask()) != 0) {
/* 351 */           (SETT.TERRAIN()).wall_merge.render(r, 5, i.x() - 4, i.y());
/*     */         } else {
/* 353 */           (SETT.TERRAIN()).wall_merge.render(r, 7, i.x() - 4, i.y());
/* 354 */         }  if ((data & DIR.S.mask()) == 0 || (cor & DIR.SW.mask()) != 0) {
/* 355 */           (SETT.TERRAIN()).wall_merge.render(r, 4, i.x() - 4, i.y());
/*     */         } else {
/* 357 */           (SETT.TERRAIN()).wall_merge.render(r, 6, i.x() - 4, i.y());
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setDia(int x, int y, boolean dia) {
/* 363 */       if (!is(x, y))
/*     */         return; 
/* 365 */       int data = this.shared.data.get(x, y);
/* 366 */       if (dia) {
/* 367 */         data |= 0x1000;
/*     */       } else {
/* 369 */         data &= 0xFFFFEFFF;
/* 370 */       }  this.shared.data.set(x, y, data);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean getDia(int tx, int ty) {
/* 375 */       if (!is(tx, ty))
/* 376 */         return false; 
/* 377 */       return ((this.shared.data.get(tx, ty) & 0x1000) != 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isPlacable(int tx, int ty) {
/* 382 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int miniDepth() {
/* 387 */       return 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean wantsFloorUnderneath(int tx, int ty) {
/* 392 */       return ((this.shared.data.get(tx, ty) & 0xF) != 15);
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class Normal
/*     */     extends Tile {
/*     */     Normal(String key, Terrain t, Json data, Json text, SPRITE icon, TILE_SHEET sheet, TFortification tFortification) {
/* 399 */       super("FORTIFICATION_" + key, t, text.text("NAME"), icon, (COLOR)new ColorImp(data, "MINIMAP_COLOR"), tFortification);
/*     */     }
/*     */ 
/*     */     
/*     */     public LOS los(int tx, int ty) {
/* 404 */       return ((getAvailability(tx, ty)).player < 0.0D) ? LOS.SOLID : LOS.OPEN;
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightEnd(int tx, int ty) {
/* 409 */       if ((this.shared.data.get(tx, ty) & 0xF) == 15)
/* 410 */         return this.fort.height; 
/* 411 */       return this.fort.height / 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightEnt(int tx, int ty) {
/* 416 */       return this.fort.height;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 421 */       int x = i.x();
/* 422 */       int y = i.y();
/* 423 */       int ran = i.ran();
/*     */       
/* 425 */       int code = data & 0xF;
/* 426 */       int c = code;
/*     */ 
/*     */       
/* 429 */       if (code == 0) {
/* 430 */         c = 208;
/* 431 */         c += ran & 0xF;
/* 432 */       } else if (code == 15) {
/* 433 */         c = 224;
/* 434 */         c += ran & 0xF;
/*     */       } else {
/* 436 */         c += (ran & 0x3) * 16;
/*     */       } 
/*     */       
/* 439 */       if ((data & 0x1000) != 0 && 
/* 440 */         code != 0 && code != 15) {
/* 441 */         c += 64;
/*     */       }
/*     */       
/* 444 */       renderEdges(r, s, i, data);
/* 445 */       this.fort.tint.color.bind();
/* 446 */       this.fort.sheet.render(r, c, x, y);
/* 447 */       s.setHeight(this.fort.sHeight).setDistance2Ground(0.0D);
/* 448 */       this.fort.sheet.render((SPRITE_RENDERER)s, c, x, y);
/*     */       
/* 450 */       int cor = data >> 4 & 0xF;
/* 451 */       if (cor != 0) {
/* 452 */         this.fort.sheet.render(r, 128 + cor, x, y);
/*     */       }
/* 454 */       COLOR.unbind();
/*     */       
/* 456 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public AVAILABILITY getAvailability(int x, int y) {
/* 461 */       int data = this.shared.data.get(x, y);
/* 462 */       if ((data & 0xF) == 15) {
/* 463 */         return AVAILABILITY.NORMAL;
/*     */       }
/* 465 */       return AVAILABILITY.SOLID;
/*     */     }
/*     */ 
/*     */     
/*     */     public TerrainClearing clearing() {
/* 470 */       return this.fort.clear;
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class TFortificationTileBroken
/*     */     extends Tile
/*     */     implements TILE_FIXABLE {
/* 477 */     final TerrainClearing clearing = new TerrainClearing()
/*     */       {
/*     */         
/*     */         public RESOURCE clear1(int tx, int ty)
/*     */         {
/* 482 */           TFortification.TFortificationTileBroken.this.shared.NADA.placeFixed(tx, ty);
/* 483 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean can() {
/* 488 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public int clearAll(int tx, int ty) {
/* 493 */           TFortification.TFortificationTileBroken.this.shared.NADA.placeFixed(tx, ty);
/* 494 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace sound(int tx, int ty) {
/* 499 */           return TFortification.TFortificationTileBroken.this.fort.sound;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isStructure() {
/* 504 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public double strength() {
/* 509 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean canDestroy(int tx, int ty) {
/* 514 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     TFortificationTileBroken(String key, Terrain t, Json data, Json text, SPRITE icon, TILE_SHEET sheet, TFortification tFortification) {
/* 520 */       super("FORTIFICATION_B_" + key, t, text.text("NAME") + " (" + text.text("NAME") + ")", icon, (COLOR)new ColorImp(data, "MINIMAP_COLOR"), tFortification);
/*     */     }
/*     */ 
/*     */     
/*     */     public LOS los(int tx, int ty) {
/* 525 */       return LOS.OPEN;
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightEnd(int tx, int ty) {
/* 530 */       return this.fort.height / 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightEnt(int tx, int ty) {
/* 535 */       return this.fort.height / 2;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean wallJoiner() {
/* 540 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean wallIsWally() {
/* 545 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isMassiveWall() {
/* 550 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 555 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 560 */       int x = i.x();
/* 561 */       int y = i.y();
/* 562 */       int ran = i.ran();
/*     */       
/* 564 */       int code = data & 0xF;
/* 565 */       int c = code;
/*     */ 
/*     */       
/* 568 */       if (code == 0) {
/* 569 */         c = 208;
/* 570 */         c += ran & 0xF;
/* 571 */       } else if (code == 15) {
/* 572 */         c = 224;
/* 573 */         c += ran & 0xF;
/*     */       } else {
/* 575 */         c += 144 + (ran & 0x3) * 16;
/*     */       } 
/*     */       
/* 578 */       renderEdges(r, s, i, data);
/* 579 */       this.fort.tint.color.bind();
/* 580 */       this.fort.sheet.render(r, c, x, y);
/* 581 */       s.setHeight(this.fort.sHeight / 2).setDistance2Ground(0.0D);
/* 582 */       this.fort.sheet.render((SPRITE_RENDERER)s, c, x, y);
/*     */       
/* 584 */       int cor = data >> 4 & 0xF;
/* 585 */       if (cor != 0) {
/* 586 */         this.fort.sheet.render(r, 128 + cor, x, y);
/*     */       }
/* 588 */       COLOR.unbind();
/*     */       
/* 590 */       if (code == 0 || code == 15) {
/*     */         
/* 592 */         OPACITY.O99.bind();
/* 593 */         this.fort.sheet.renderTextured((SETT.ROOMS()).util.filth.texture(0.75D, i.ran()), c, x, y);
/* 594 */         OPACITY.unbind();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 599 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public AVAILABILITY getAvailability(int x, int y) {
/* 604 */       return AVAILABILITY.NORMAL;
/*     */     }
/*     */ 
/*     */     
/*     */     public TerrainClearing clearing() {
/* 609 */       return this.clearing;
/*     */     }
/*     */ 
/*     */     
/*     */     public Job fixJob(int tx, int ty) {
/* 614 */       return (Job)(SETT.JOBS()).build_fort.all.get(this.fort.index());
/*     */     }
/*     */ 
/*     */     
/*     */     public Terrain.TerrainTile getTerrain(int tx, int ty) {
/* 619 */       return this.fort.tile;
/*     */     }
/*     */   }
/*     */   
/* 623 */   private static CharSequence ¤¤stairs = "Stairs";
/*     */   static {
/* 625 */     D.ts(TFortification.class);
/*     */   }
/*     */   
/*     */   public static final class Stairs
/*     */     extends Terrain.TerrainTile {
/*     */     private final TILE_SHEET stairC;
/*     */     private final TILE_SHEET stairEdge;
/*     */     TerrainClearing clear;
/*     */     
/*     */     static Stairs make(Terrain t) throws IOException {
/* 635 */       PATH gSprite = PATHS.SPRITE_SETTLEMENT().getFolder("fortification");
/*     */ 
/*     */       
/* 638 */       final TILE_SHEET stairC = (new ComposerThings.ITileSheet(gSprite.get("_Stairs"), 216, 28)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 642 */             s.full.init(0, 0, 1, 1, 6, 1, d.s16);
/* 643 */             s.full.setSkip(4, 1);
/* 644 */             s.full.paste(3, true);
/* 645 */             return d.s16.saveGame();
/*     */           }
/* 647 */         }).get();
/*     */       
/* 649 */       final TILE_SHEET stairEdge = (new ComposerThings.ITileSheet()
/*     */         {
/*     */ 
/*     */ 
/*     */           
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 656 */             s.full.setSkip(1, 5).pasteRotated(0, true);
/* 657 */             s.full.setSkip(1, 0).pasteRotated(0, true);
/*     */ 
/*     */             
/* 660 */             s.full.setSkip(1, 5).pasteRotated(1, true);
/* 661 */             s.full.setSkip(1, 0).pasteRotated(1, true);
/*     */ 
/*     */ 
/*     */             
/* 665 */             s.full.setSkip(1, 5).pasteRotated(2, true);
/* 666 */             s.full.setSkip(1, 0).pasteRotated(2, true);
/*     */ 
/*     */             
/* 669 */             s.full.setSkip(1, 5).pasteRotated(3, true);
/* 670 */             s.full.setSkip(1, 0).pasteRotated(3, true);
/*     */ 
/*     */             
/* 673 */             return d.s16.saveGame();
/*     */           }
/* 675 */         }).get();
/*     */       
/* 677 */       SPRITE.Imp imp = new SPRITE.Imp(32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 681 */             stairC.render(r, 8, X1, X1 + 16, Y1, Y1 + 16);
/* 682 */             stairC.render(r, 8, X1 + 16, X1 + 32, Y1, Y1 + 16);
/* 683 */             stairC.render(r, 0, X1, X1 + 16, Y1 + 16, Y1 + 32);
/* 684 */             stairC.render(r, 0, X1 + 16, X1 + 32, Y1 + 16, Y1 + 32);
/* 685 */             stairEdge.render(r, 5, X1, X1 + 16, Y1, Y1 + 16);
/* 686 */             stairEdge.render(r, 4, X1 + 16, X1 + 32, Y1, Y1 + 16);
/* 687 */             stairEdge.render(r, 0, X1, X1 + 16, Y1 + 16, Y1 + 32);
/* 688 */             stairEdge.render(r, 1, X1 + 16, X1 + 32, Y1 + 16, Y1 + 32);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 693 */       return new Stairs(t, stairC, stairEdge, (SPRITE)imp);
/*     */     }
/*     */     
/*     */     private Stairs(Terrain t, TILE_SHEET stairC, TILE_SHEET stairEdge, SPRITE icon) throws IOException
/*     */     {
/* 698 */       super("STAIRS", t, TFortification.¤¤stairs, icon, (COLOR)null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 769 */       this.clear = new TerrainClearing()
/*     */         {
/* 771 */           private final SoundRace sound = AUDIO.race("CLEAR_STAIRS");
/*     */ 
/*     */           
/*     */           public RESOURCE clear1(int tx, int ty) {
/* 775 */             TFortification.Stairs.this.shared.NADA.placeFixed(tx, ty);
/* 776 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean can() {
/* 781 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public int clearAll(int tx, int ty) {
/* 786 */             TFortification.Stairs.this.shared.NADA.placeFixed(tx, ty);
/* 787 */             return 1;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean isStructure() {
/* 792 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void destroy(int tx, int ty) {}
/*     */ 
/*     */           
/*     */           public double strength() {
/* 801 */             return 0.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public SoundRace sound(int tx, int ty) {
/* 806 */             return this.sound;
/*     */           }
/*     */           
/*     */           public boolean canDestroy(int tx, int ty)
/*     */           {
/* 811 */             return false; }
/*     */         }; this.stairC = stairC; this.stairEdge = stairEdge; } public boolean isPlacable(int tx, int ty) { return true; } protected boolean place(int tx, int ty) { placeRaw(tx, ty); DIR face = DIR.N; int r = 0; for (DIR d : DIR.ORTHO) { if (this.shared.get(tx, ty, d) instanceof TFortification.Tile && !(this.shared.get(tx, ty, d.perpendicular()) instanceof TFortification.Tile) && !is(tx, ty, d.perpendicular())) { face = d; break; }  r++; }  if (!is(tx, ty, face.next(-2))) r |= 0x4;  if (!is(tx, ty, face.next(2)))
/*     */         r |= 0x8;  this.shared.data.set(tx, ty, r); return false; }
/*     */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) { int o = data & 0x3; if ((data & 0x4) != 0)
/*     */         this.stairEdge.render(r, o * 2, i.x(), i.y());  if ((data & 0x8) != 0)
/*     */         this.stairEdge.render(r, o * 2 + 1, i.x(), i.y());  return false; }
/* 817 */     public TerrainClearing clearing() { return this.clear; } protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) { int o = (data & 0x3) * 4;
/*     */       this.stairC.render(r, o + (i.ran() & 0x3), i.x(), i.y());
/*     */       return false; } public AVAILABILITY getAvailability(int tx, int ty) {
/*     */       return AVAILABILITY.NORMAL;
/*     */     } public int miniDepth() {
/*     */       return 1;
/*     */     } }
/*     */   public String key() {
/* 825 */     return this.key;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFortification.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */