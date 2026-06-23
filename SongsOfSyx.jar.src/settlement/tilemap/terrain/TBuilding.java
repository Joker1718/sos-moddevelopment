/*      */ package settlement.tilemap.terrain;
/*      */ 
/*      */ import game.audio.AUDIO;
/*      */ import game.audio.SoundRace;
/*      */ import init.paths.PATH;
/*      */ import init.paths.PATHS;
/*      */ import init.resources.RESOURCE;
/*      */ import init.structure.STRUCTURES;
/*      */ import init.structure.Structure;
/*      */ import java.io.IOException;
/*      */ import java.nio.file.Path;
/*      */ import java.util.HashMap;
/*      */ import settlement.job.Job;
/*      */ import settlement.job.JobBuildStructure;
/*      */ import settlement.main.SETT;
/*      */ import settlement.path.AVAILABILITY;
/*      */ import settlement.room.main.Room;
/*      */ import settlement.thing.pointlight.LOS;
/*      */ import settlement.tilemap.TILE_FIXABLE;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.color.COLOR;
/*      */ import snake2d.util.datatypes.AREA;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.file.Json;
/*      */ import snake2d.util.map.MAP_BOOLEAN;
/*      */ import snake2d.util.sets.ArrayList;
/*      */ import snake2d.util.sets.LIST;
/*      */ import snake2d.util.sprite.SPRITE;
/*      */ import snake2d.util.sprite.TILE_SHEET;
/*      */ import util.rendering.RenderData;
/*      */ import util.rendering.ShadowBatch;
/*      */ import util.spritecomposer.ComposerDests;
/*      */ import util.spritecomposer.ComposerSources;
/*      */ import util.spritecomposer.ComposerThings;
/*      */ import util.spritecomposer.ComposerUtil;
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
/*      */ 
/*      */ 
/*      */ public final class TBuilding
/*      */ {
/*      */   public final Structure structure;
/*      */   private final SPRITE iconWall;
/*      */   private final SPRITE iconCeiling;
/*      */   public final SPRITE iconCombo;
/*      */   private final TILE_SHEET spriteWall;
/*      */   private final TILE_SHEET spriteOpening;
/*      */   private final TILE_SHEET spriteCeiling;
/*      */   public final Wall wall;
/*      */   final Wall broken;
/*      */   public final Ceiling roof;
/*      */   public final SoundRace sound;
/*      */   public final MAP_BOOLEAN isser;
/*      */   
/*      */   public static final class TBuildings
/*      */   {
/*      */     public final TBuilding MUD;
/*      */     private final ArrayList<TBuilding> all;
/*      */     
/*      */     TBuildings(Terrain terrain) throws IOException {
/*   71 */       PATHS.ResFolder f = STRUCTURES.path();
/*   72 */       HashMap<String, TBuilding> others = new HashMap<>();
/*      */       
/*   74 */       TBuilding[] all = new TBuilding[STRUCTURES.all().size()];
/*      */ 
/*      */       
/*   77 */       for (Structure s : STRUCTURES.all()) {
/*   78 */         Json d = new Json(f.init.gets(s.key));
/*   79 */         PATH sprite = f.sprite;
/*   80 */         TBuilding b = new TBuilding(s, terrain, d, sprite, others);
/*   81 */         all[s.index()] = b;
/*      */       } 
/*      */       
/*   84 */       this.MUD = all[STRUCTURES.mud().index()];
/*   85 */       this.all = new ArrayList((Object[])all);
/*      */     }
/*      */     
/*      */     public TBuilding get(Structure s) {
/*   89 */       return (TBuilding)this.all.get(s.index());
/*      */     }
/*      */     
/*      */     public LIST<TBuilding> all() {
/*   93 */       return (LIST<TBuilding>)this.all;
/*      */     }
/*      */   }
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
/*      */   TBuilding(Structure structure, Terrain t, Json data, PATH sg, HashMap<String, TBuilding> otherSprites) throws IOException {
/*  272 */     this.isser = new MAP_BOOLEAN() { protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { ComposerDests.Tile t = d.s16; s.house.init(0, 0, 4, 2, (ComposerDests.Dest)t); s.house.setVar(0).paste(1, true); s.house.setVar(1).pasteRotated(2, true); s.house.setVar(1).pasteRotated(3, true); s.house.setVar(2).paste(1, true); s.house.setVar(3).pasteRotated(2, true); s.house.setVar(3).pasteRotated(3, true); s.house.setVar(4).paste(1, true); s.house.setVar(5).pasteRotated(2, true); s.house.setVar(5).pasteRotated(3, true); s.house.setVar(0).pasteEdges(true); s.house.setVar(1).pasteEdges(true); s.house.setVar(2).pasteEdges(true); s.house.setVar(3).pasteEdges(true); s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, t); s.full.paste(true); s.full.init(0, s.full.body().y2(), 1, 1, 16, 1, t); s.full.paste(true); return t.saveGame(); }
/*      */       }).get(); this.spriteOpening = (new ComposerThings.ITileSheet() { protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { ComposerDests.Tile t = d.s16; s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)t); s.house.setVar(0).paste(true); s.house.setVar(1).paste(true); s.house.setVar(2).paste(true); s.house.setVar(3).paste(true); s.house.setVar(0).pasteEdges(true); s.house.setVar(1).pasteEdges(true); s.house.setVar(2).pasteEdges(true); s.house.setVar(3).pasteEdges(true); s.full.init(0, s.house.body().y2(), 1, 1, 8, 1, t);
/*      */           s.full.setSkip(8, 0).paste(2, true);
/*      */           return t.saveGame(); }
/*  276 */         public boolean is(int tx, int ty) { return !(!TBuilding.this.wall.is(tx, ty) && !TBuilding.this.roof.is(tx, ty)); } }).get(); this.spriteCeiling = (new ComposerThings.ITileSheet() { protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { ComposerDests.Tile t = d.s16; s.house.init(0, s.full.body().y2(), 2, 1, (ComposerDests.Dest)t); for (int i = 0; i < 2; i++) { s.house.setVar(i); s.house.setSkip(0, 16).paste(1, true); }  s.house.setVar(0); s.house.setSkip(0, 1).pasteEdges(true); s.house.setVar(1).setSkip(0, 1).paste(true); return t.saveGame(); } }
/*      */       ).get(); otherSprites.put(s, this); this.iconCombo = (SPRITE)new SPRITE.Imp(32) { public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { TBuilding.this.spriteOpening.render(r, DIR.S.mask() | DIR.E.mask(), X1, X1 + 16, Y1, Y1 + 16); TBuilding.this.spriteOpening.render(r, DIR.S.mask() | DIR.W.mask(), X1 + 16, X1 + 32, Y1, Y1 + 16); TBuilding.this.spriteOpening.render(r, DIR.N.mask() | DIR.E.mask(), X1, X1 + 16, Y1 + 16, Y1 + 32); TBuilding.this.spriteOpening.render(r, DIR.N.mask() | DIR.W.mask(), X1 + 16, X1 + 32, Y1 + 16, Y1 + 32); } }; this.structure = structure; String s = data.value("SPRITE"); this.sound = AUDIO.race("BUILD_STRUCTURE_" + structure.key); if (otherSprites.containsKey(s)) { TBuilding o = otherSprites.get(s); this.iconWall = o.iconWall; this.iconCeiling = o.iconCeiling; this.iconCombo = o.iconCombo; this.spriteOpening = o.spriteOpening; this.spriteCeiling = o.spriteCeiling; this.spriteWall = o.spriteWall; }
/*      */     else { this.spriteWall = (new ComposerThings.ITileSheet(sg.get(s), 576, 372) {
/*      */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { TBuilding.this.spriteWall.render(r, DIR.S.mask() | DIR.E.mask(), X1, X1 + 16, Y1, Y1 + 16); TBuilding.this.spriteWall.render(r, DIR.S.mask() | DIR.W.mask(), X1 + 16, X1 + 32, Y1, Y1 + 16); TBuilding.this.spriteWall.render(r, DIR.N.mask() | DIR.E.mask(), X1, X1 + 16, Y1 + 16, Y1 + 32); TBuilding.this.spriteWall.render(r, DIR.N.mask() | DIR.W.mask(), X1 + 16, X1 + 32, Y1 + 16, Y1 + 32); } }; this.iconCeiling = (SPRITE)new SPRITE.Imp(32) {
/*      */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { TBuilding.this.spriteCeiling.render(r, DIR.N.mask() | DIR.W.mask(), X1, X1 + 16, Y1, Y1 + 16); TBuilding.this.spriteCeiling.render(r, DIR.N.mask() | DIR.E.mask(), X1 + 16, X1 + 32, Y1, Y1 + 16); TBuilding.this.spriteCeiling.render(r, DIR.S.mask() | DIR.W.mask(), X1, X1 + 16, Y1 + 16, Y1 + 32); TBuilding.this.spriteCeiling.render(r, DIR.S.mask() | DIR.E.mask(), X1 + 16, X1 + 32, Y1 + 16, Y1 + 32); } }
/*  281 */         ; this.iconWall = (SPRITE)new SPRITE.Imp(32) { public boolean is(int tile) { return !(!TBuilding.this.wall.is(tile) && !TBuilding.this.roof.is(tile)); }
/*      */         }; }  this.wall = new WallFull("BUILDING_" + structure.key, t); this.broken = new WallBroken("BUILDING_BROKEN" + structure.key, t); this.roof = new Ceiling("BUILDING_CEILING" + structure.key, t); PlacableMulti placableMulti = new PlacableMulti(structure.name) { public void place(int tx, int ty, AREA a, PLACER_TYPE t) { if (tx > a.body().x1() && tx < a.body().x2() - 1 && ty > a.body().y1() && ty < a.body().y2() - 1) { if (TBuilding.this.roof.isPlacable(tx, ty)) { TBuilding.this.roof.placeFixed(tx, ty); (SETT.GRASS()).current.set(tx, ty, 0.0D); }
/*      */              }
/*      */           else if (Math.abs(tx - a.body().cX()) < 2) { if (TBuilding.this.roof.isPlacable(tx, ty)) { TBuilding.this.roof.placeFixed(tx, ty); (SETT.GRASS()).current.set(tx, ty, 0.0D); }
/*      */              }
/*      */           else if (Math.abs(ty - a.body().cY()) < 2) { if (TBuilding.this.roof.isPlacable(tx, ty)) { TBuilding.this.roof.placeFixed(tx, ty); (SETT.GRASS()).current.set(tx, ty, 0.0D); }
/*      */              }
/*      */           else if (TBuilding.this.wall.isPlacable(tx, ty)) { TBuilding.this.wall.placeFixed(tx, ty); (SETT.GRASS()).current.set(tx, ty, 0.0D); }
/*      */            } public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) { return (!TBuilding.this.roof.is(tx, ty) && TBuilding.this.wall.isPlacable(tx, ty)) ? null : ""; } }; IDebugPanelSett.add("room", (PLACABLE)placableMulti);
/*  290 */   } public abstract class BuildingComponent extends Terrain.TerrainTile { protected BuildingComponent(String key, Terrain t, CharSequence name, SPRITE icon, COLOR c, RESOURCE needed) { super(key, t, name, icon, c);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  295 */       this.clearing = new TerrainClearing()
/*      */         {
/*      */           public RESOURCE clear1(int tx, int ty)
/*      */           {
/*  299 */             TBuilding.BuildingComponent.this.shared.NADA.placeFixed(tx, ty);
/*  300 */             return TBuilding.BuildingComponent.this.needed;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean can() {
/*  305 */             return true;
/*      */           }
/*      */ 
/*      */           
/*      */           public int clearAll(int tx, int ty) {
/*  310 */             TBuilding.BuildingComponent.this.shared.NADA.placeFixed(tx, ty);
/*  311 */             return 1;
/*      */           }
/*      */ 
/*      */           
/*      */           public SoundRace sound(int tx, int ty) {
/*  316 */             return (TBuilding.BuildingComponent.access$0(TBuilding.BuildingComponent.this)).sound;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean isStructure() {
/*  321 */             return true;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean canDestroy(int tx, int ty) {
/*  326 */             return false;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public void destroy(int tx, int ty) {}
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isEasilyCleared() {
/*  336 */             return false;
/*      */           }
/*      */         };
/*      */       this.needed = needed; }
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
/*      */     private final RESOURCE needed;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TerrainClearing clearing;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TerrainClearing clearing() {
/*  372 */       return this.clearing;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final TBuilding building() {
/*  378 */       return TBuilding.this;
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   public class Wall
/*      */     extends BuildingComponent
/*      */     implements TerrainDiagonal.Diagonalizer
/*      */   {
/*      */     private static final int SET = 16;
/*      */     private final TILE_SHEET sheet;
/*  389 */     private final int DIAGONAL = 64;
/*  390 */     private final int BROKEN = 128;
/*  391 */     private final int CORNERS = 192;
/*  392 */     private final int CORNERS_FAT = 208;
/*  393 */     private final int CORNERS_DIA = 224;
/*  394 */     private final int CORNERS_FAT_DIA = 240;
/*  395 */     private final int SINGLES = 256;
/*  396 */     private final int FULLS = 272;
/*      */     private final boolean broken;
/*  398 */     private int DIA = 8192;
/*  399 */     private int FAT = 16384;
/*      */     
/*      */     private Wall(String key, Terrain t, boolean broken) {
/*  402 */       super(key, t, TBuilding.this.structure.nameWall, TBuilding.this.iconWall, (COLOR)TBuilding.this.structure.miniColor.shade(0.9D), TBuilding.this.structure.resource);
/*  403 */       this.broken = broken;
/*  404 */       this.sheet = TBuilding.this.spriteWall;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean place(int x, int y) {
/*  410 */       boolean dia = (this.shared.get(x, y) instanceof TerrainDiagonal.Diagonalizer && ((TerrainDiagonal.Diagonalizer)this.shared.get(x, y)).getDia(x, y));
/*  411 */       placeRaw(x, y);
/*      */       
/*  413 */       int res = 0;
/*  414 */       if (isFat(x, y)) {
/*  415 */         res |= this.FAT;
/*  416 */         for (DIR d : DIR.ORTHO) {
/*  417 */           if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/*  418 */             res |= d.mask() | d.next(2).mask(); 
/*      */         } 
/*      */       } else {
/*  421 */         for (DIR d : DIR.ORTHO) {
/*  422 */           if (!isFat(x + d.x(), y + d.y()) && joins(x, y, d)) {
/*  423 */             res |= d.mask();
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  429 */       int cor = 0;
/*  430 */       for (DIR d : DIR.NORTHO) {
/*  431 */         if (!joins(x, y, d) && (res & d.next(1).mask()) != 0 && (res & d.next(-1).mask()) != 0)
/*  432 */           cor |= d.mask(); 
/*      */       } 
/*  434 */       res |= cor << 4;
/*      */       
/*  436 */       if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.N)) {
/*  437 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.N);
/*  438 */         if (t != this && t != TBuilding.this.roof.opening && t.wallIsWally() && t != TBuilding.this.broken && !t.roofIs() && (res & DIR.N.mask()) != 0) {
/*  439 */           res |= 0x100;
/*      */         }
/*      */       } 
/*  442 */       if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.W)) {
/*  443 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.W);
/*  444 */         if (t != this && t != TBuilding.this.roof.opening && t != TBuilding.this.broken && t.wallIsWally() && !t.roofIs() && (res & DIR.W.mask()) != 0) {
/*  445 */           res |= 0x200;
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
/*  459 */       this.shared.data.set(x, y, res);
/*  460 */       setDia(x, y, dia);
/*  461 */       return false;
/*      */     }
/*      */     
/*      */     private boolean joins(int x, int y, DIR d) {
/*  465 */       x += d.x();
/*  466 */       y += d.y();
/*  467 */       if (!SETT.IN_BOUNDS(x, y))
/*  468 */         return false; 
/*  469 */       return TBuilding.jwall.is(x, y);
/*      */     }
/*      */     
/*      */     private boolean isFat(int x, int y) {
/*  473 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  474 */         DIR d = (DIR)DIR.ORTHO.get(di);
/*  475 */         if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/*  476 */           return true; 
/*      */       } 
/*  478 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isMassiveWall() {
/*  483 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  489 */       int code = data & 0xF;
/*  490 */       int cor = data >> 4 & 0xF;
/*  491 */       if (cor != 0) {
/*  492 */         if ((data & this.FAT) == 0) {
/*  493 */           cor += 192;
/*      */         } else {
/*  495 */           cor += 208;
/*  496 */         }  if ((data & this.DIA) != 0)
/*  497 */           cor += 32; 
/*      */       } 
/*  499 */       TBuilding.this.structure.tint.color.bind();
/*  500 */       if (code == 15) {
/*  501 */         int c = 272 + (i.ran() & 0x7);
/*  502 */         if (this.broken) {
/*  503 */           c += 8;
/*      */         }
/*  505 */         this.sheet.render(r, c, i.x(), i.y());
/*  506 */         if (cor != 0) {
/*      */           
/*  508 */           s.setHeight(3).setDistance2Ground(8.0D);
/*  509 */           this.sheet.render((SPRITE_RENDERER)s, c, i.x(), i.y());
/*  510 */           this.sheet.render(r, cor, i.x(), i.y());
/*      */         } 
/*  512 */         COLOR.unbind();
/*  513 */         renderEdges(r, s, i, data);
/*  514 */         return !this.broken;
/*      */       } 
/*      */       
/*  517 */       if (code == 0) {
/*  518 */         s.setHeight(3).setDistance2Ground(8.0D);
/*      */         
/*  520 */         int c = ((data & this.DIA) != 0) ? 4 : 0;
/*  521 */         c += i.ran() & 0x3;
/*  522 */         c += 256;
/*  523 */         if (this.broken)
/*  524 */           c += 8; 
/*  525 */         this.sheet.render(r, c, i.x(), i.y());
/*  526 */         this.sheet.render((SPRITE_RENDERER)s, c, i.x(), i.y());
/*      */       } else {
/*      */         
/*  529 */         int c = code + (i.ran() & 0x3) * 16;
/*      */         
/*  531 */         if (this.broken) {
/*  532 */           c += 128;
/*  533 */           s.setHeight(0).setDistance2Ground(8.0D);
/*  534 */           this.sheet.render((SPRITE_RENDERER)s, c, i.x(), i.y());
/*  535 */         } else if ((data & this.DIA) != 0) {
/*  536 */           c += 64;
/*      */         } 
/*  538 */         s.setHeight(12).setDistance2Ground(0.0D);
/*  539 */         this.sheet.render(r, c, i.x(), i.y());
/*  540 */         this.sheet.render((SPRITE_RENDERER)s, c, i.x(), i.y());
/*      */         
/*  542 */         if (cor != 0) {
/*  543 */           this.sheet.render(r, cor, i.x(), i.y());
/*      */         }
/*      */ 
/*      */         
/*  547 */         renderEdges(r, s, i, data);
/*      */       } 
/*  549 */       COLOR.unbind();
/*      */       
/*  551 */       return false;
/*      */     }
/*      */     
/*      */     private void renderEdges(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  555 */       int cor = data >> 4 & 0xF;
/*  556 */       if ((data & 0x100) != 0) {
/*  557 */         if ((data & DIR.W.mask()) == 0 || (cor & DIR.NW.mask()) != 0) {
/*  558 */           (SETT.TERRAIN()).wall_merge.render(r, 0, i.x(), i.y() - 4);
/*      */         } else {
/*  560 */           (SETT.TERRAIN()).wall_merge.render(r, 2, i.x(), i.y() - 4);
/*  561 */         }  if ((data & DIR.E.mask()) == 0 || (cor & DIR.NE.mask()) != 0) {
/*  562 */           (SETT.TERRAIN()).wall_merge.render(r, 1, i.x(), i.y() - 4);
/*      */         } else {
/*  564 */           (SETT.TERRAIN()).wall_merge.render(r, 3, i.x(), i.y() - 4);
/*      */         } 
/*  566 */       }  if ((data & 0x200) != 0) {
/*  567 */         if ((data & DIR.N.mask()) == 0 || (cor & DIR.NW.mask()) != 0) {
/*  568 */           (SETT.TERRAIN()).wall_merge.render(r, 5, i.x() - 4, i.y());
/*      */         } else {
/*  570 */           (SETT.TERRAIN()).wall_merge.render(r, 7, i.x() - 4, i.y());
/*  571 */         }  if ((data & DIR.S.mask()) == 0 || (cor & DIR.SW.mask()) != 0) {
/*  572 */           (SETT.TERRAIN()).wall_merge.render(r, 4, i.x() - 4, i.y());
/*      */         } else {
/*  574 */           (SETT.TERRAIN()).wall_merge.render(r, 6, i.x() - 4, i.y());
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  581 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public AVAILABILITY getAvailability(int x, int y) {
/*  586 */       return this.broken ? null : AVAILABILITY.SOLID;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isPlacable(int tx, int ty) {
/*  591 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean wallJoiner() {
/*  596 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean wallIsWally() {
/*  601 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public int miniDepth() {
/*  606 */       return 2;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setDia(int x, int y, boolean dia) {
/*  611 */       if (!is(x, y))
/*      */         return; 
/*  613 */       int data = this.shared.data.get(x, y);
/*  614 */       if (dia) {
/*  615 */         data |= this.DIA;
/*      */       } else {
/*  617 */         data &= this.DIA ^ 0xFFFFFFFF;
/*  618 */       }  this.shared.data.set(x, y, data);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean getDia(int tx, int ty) {
/*  623 */       if (!is(tx, ty))
/*  624 */         return false; 
/*  625 */       return ((this.shared.data.get(tx, ty) & this.DIA) != 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public int heightEnd(int tx, int ty) {
/*  630 */       return 3;
/*      */     }
/*      */ 
/*      */     
/*      */     public LOS los(int tx, int ty) {
/*  635 */       return LOS.SOLID;
/*      */     }
/*      */     
/*      */     public boolean isFull(int tx, int ty) {
/*  639 */       int data = this.shared.data.get(tx, ty);
/*  640 */       return ((data & 0xF) == 15 && (data >> 4 & 0xF) == 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean coversCompletely(int tx, int ty) {
/*  645 */       return ((this.shared.data.get(tx, ty) & 0xF) == 15);
/*      */     }
/*      */ 
/*      */     
/*      */     void unplace(int tx, int ty) {
/*  650 */       if (!(SETT.ROOMS()).map.is(tx, ty)) {
/*  651 */         (SETT.FLOOR()).clearer.clear(tx, ty);
/*      */       }
/*      */     }
/*      */     
/*      */     public boolean wantsFloorUnderneath(int tx, int ty) {
/*  656 */       return ((this.shared.data.get(tx, ty) & 0xF) != 15);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class WallFull
/*      */     extends Wall
/*      */   {
/*  664 */     final TerrainClearing clearing = new TerrainClearing()
/*      */       {
/*      */         public RESOURCE clear1(int tx, int ty)
/*      */         {
/*  668 */           TBuilding.WallFull.this.shared.NADA.placeFixed(tx, ty);
/*  669 */           return (TBuilding.WallFull.access$0(TBuilding.WallFull.this)).structure.resource;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean can() {
/*  674 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public int clearAll(int tx, int ty) {
/*  679 */           TBuilding.WallFull.this.shared.NADA.placeFixed(tx, ty);
/*  680 */           return 1;
/*      */         }
/*      */ 
/*      */         
/*      */         public SoundRace sound(int tx, int ty) {
/*  685 */           return (TBuilding.WallFull.access$0(TBuilding.WallFull.this)).sound;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean isStructure() {
/*  690 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public void destroy(int tx, int ty) {
/*  695 */           (TBuilding.WallFull.access$0(TBuilding.WallFull.this)).broken.placeFixed(tx, ty);
/*      */         }
/*      */ 
/*      */         
/*      */         public double strength() {
/*  700 */           return (TBuilding.WallFull.access$0(TBuilding.WallFull.this)).structure.durability * 20.0D;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean canDestroy(int tx, int ty) {
/*  705 */           return true;
/*      */         }
/*      */       };
/*      */ 
/*      */     
/*      */     private WallFull(String key, Terrain t) {
/*  711 */       super(key, t, false);
/*      */     }
/*      */ 
/*      */     
/*      */     public TerrainClearing clearing() {
/*  716 */       return this.clearing;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class WallBroken
/*      */     extends Wall
/*      */     implements TILE_FIXABLE
/*      */   {
/*  725 */     final TerrainClearing clearing = new TerrainClearing()
/*      */       {
/*      */         
/*      */         public RESOURCE clear1(int tx, int ty)
/*      */         {
/*  730 */           TBuilding.WallBroken.this.shared.NADA.placeFixed(tx, ty);
/*  731 */           return (TBuilding.WallBroken.access$0(TBuilding.WallBroken.this)).structure.resource;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean can() {
/*  736 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public int clearAll(int tx, int ty) {
/*  741 */           TBuilding.WallBroken.this.shared.NADA.placeFixed(tx, ty);
/*  742 */           return 1;
/*      */         }
/*      */ 
/*      */         
/*      */         public SoundRace sound(int tx, int ty) {
/*  747 */           return (TBuilding.WallBroken.access$0(TBuilding.WallBroken.this)).sound;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean isStructure() {
/*  752 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public double strength() {
/*  757 */           return 0.0D;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean canDestroy(int tx, int ty) {
/*  762 */           return false;
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private WallBroken(String key, Terrain t) {
/*  770 */       super(key, t, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public Job fixJob(int tx, int ty) {
/*  775 */       return ((JobBuildStructure)(SETT.JOBS()).build_structure.get(TBuilding.this.structure.index())).wall;
/*      */     }
/*      */ 
/*      */     
/*      */     public TerrainClearing clearing() {
/*  780 */       return this.clearing;
/*      */     }
/*      */ 
/*      */     
/*      */     public Terrain.TerrainTile getTerrain(int tx, int ty) {
/*  785 */       return TBuilding.this.wall;
/*      */     }
/*      */ 
/*      */     
/*      */     public LOS los(int tx, int ty) {
/*  790 */       return LOS.CEILING;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class Ceiling
/*      */     extends BuildingComponent
/*      */   {
/*      */     private static final int SET = 16;
/*      */     
/*      */     private final TILE_SHEET sheet;
/*      */     private final int SHEET_CORNER;
/*      */     private final int SHEET_SHADOW;
/*      */     private final Opening opening;
/*      */     
/*      */     private Ceiling(String key, Terrain t) {
/*  806 */       super(key + "_CEILING", t, TBuilding.this.structure.nameCeiling, TBuilding.this.iconCeiling, TBuilding.this.structure.miniColor, TBuilding.this.structure.resource);
/*  807 */       this.sheet = TBuilding.this.spriteCeiling;
/*  808 */       this.SHEET_CORNER = 64;
/*  809 */       this.SHEET_SHADOW = this.SHEET_CORNER + 16;
/*  810 */       this.opening = new Opening(key, t);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean place(int x, int y) {
/*  816 */       if (this.opening.isPlacable(x, y)) {
/*  817 */         return this.opening.place(x, y);
/*      */       }
/*  819 */       boolean was = (this.shared.get(x, y) == this);
/*  820 */       placeRaw(x, y);
/*  821 */       int data = 0;
/*  822 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  823 */         DIR d = (DIR)DIR.ORTHO.get(i);
/*  824 */         if (joins(x, y, d)) {
/*  825 */           data |= d.mask();
/*      */         }
/*      */       } 
/*      */       
/*  829 */       data = setCorners(x, y, data);
/*  830 */       data = shadowSet(x, y, data);
/*      */       
/*  832 */       this.shared.data.set(x, y, data);
/*  833 */       if (!(SETT.ROOMS()).map.is(x, y) && !was)
/*  834 */         (SETT.FLOOR()).clearer.clear(x, y); 
/*  835 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     private int setCorners(int x, int y, int res) {
/*  840 */       int corner = 0;
/*  841 */       for (int i = 0; i < DIR.NORTHO.size(); i++) {
/*  842 */         DIR d = (DIR)DIR.NORTHO.get(i);
/*  843 */         if (joins(x, y, d) && !joins(x, y, d.next(-1)) && !joins(x, y, d.next(1))) {
/*  844 */           corner |= d.mask();
/*      */         }
/*      */       } 
/*  847 */       res |= corner << 4;
/*  848 */       return res;
/*      */     }
/*      */     
/*      */     private int shadowSet(int x, int y, int res) {
/*  852 */       int s = 0;
/*  853 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  854 */         if (TBuilding.jwall.is(x, y, (DIR)DIR.ORTHO.get(i))) {
/*  855 */           s |= ((DIR)DIR.ORTHO.get(i)).mask();
/*      */         }
/*      */       } 
/*  858 */       res |= s << 8;
/*      */       
/*  860 */       return res;
/*      */     }
/*      */     
/*      */     private int shadowGet(int data) {
/*  864 */       return data >> 8 & 0xF;
/*      */     }
/*      */     
/*      */     private int getCorners(int data) {
/*  868 */       return data >> 4 & 0xF;
/*      */     }
/*      */     
/*      */     private int getData(int data, RenderData.RenderIterator i) {
/*  872 */       int res = data & 0xF;
/*  873 */       Room r = (SETT.ROOMS()).map.get(i.tx(), i.ty());
/*  874 */       if (r != null && r.constructor() != null && r.constructor().mustBeIndoors()) {
/*  875 */         for (DIR d : DIR.ORTHO) {
/*  876 */           if (!r.isSame(i.tx(), i.ty(), i.tx() + d.x(), i.ty() + d.y()) && 
/*  877 */             !(SETT.TERRAIN().get(i.tx() + d.x(), i.ty() + d.y()) instanceof Opening)) {
/*  878 */             res |= d.mask();
/*      */           }
/*      */         } 
/*      */       } else {
/*  882 */         for (DIR d : DIR.ORTHO) {
/*  883 */           r = (Room)(SETT.ROOMS()).map.get(i.tx(), i.ty(), d);
/*  884 */           if (r != null && r.constructor() != null && r.constructor().mustBeIndoors()) {
/*  885 */             res |= d.mask();
/*      */           }
/*      */         } 
/*      */       } 
/*  889 */       return res;
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
/*      */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  902 */       int a = getData(data, i);
/*  903 */       if (a != 0) {
/*  904 */         int j = a + (i.ran() & 0x3) * 16;
/*  905 */         this.sheet.render(r, j, i.x(), i.y());
/*      */       } 
/*      */       
/*  908 */       a = getCorners(data);
/*  909 */       if (a != 0) {
/*  910 */         this.sheet.render(r, this.SHEET_CORNER + a, i.x(), i.y());
/*      */       }
/*      */       
/*  913 */       a = shadowGet(data);
/*      */ 
/*      */       
/*  916 */       s.setDistance2Ground(0.0D).setHeight(2);
/*  917 */       this.sheet.render((SPRITE_RENDERER)s, this.SHEET_SHADOW, i.x(), i.y());
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
/*  929 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  934 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public AVAILABILITY getAvailability(int x, int y) {
/*  939 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isPlacable(int tx, int ty) {
/*  948 */       return true;
/*      */     }
/*      */     
/*      */     private boolean joins(int x, int y, DIR d) {
/*  952 */       return ((Terrain.TerrainTile)this.shared.get(x, y, d)).wallIsWally();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean is(int tx, int ty) {
/*  957 */       return !(!super.is(tx, ty) && !this.opening.is(tx, ty));
/*      */     }
/*      */ 
/*      */     
/*      */     boolean wallJoiner() {
/*  962 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean wallIsWally() {
/*  967 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean roofIs() {
/*  972 */       return true;
/*      */     }
/*      */     
/*      */     public class Opening
/*      */       extends TBuilding.BuildingComponent implements TerrainDiagonal.Diagonalizer {
/*      */       private static final int SET = 16;
/*      */       private final TILE_SHEET sheet;
/*      */       private final TILE_SHEET shadow;
/*  980 */       private final int CORNERS = 64;
/*  981 */       private final int SINGLES = 128;
/*  982 */       private final int DIA = 4096;
/*  983 */       private final int FAT = 8192;
/*      */       
/*      */       private Opening(String key, Terrain t) {
/*  986 */         super(key + "_OPENING", t, (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).structure.nameCeiling, (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).iconCeiling, (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).structure.miniColor, (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).structure.resource);
/*  987 */         this.sheet = (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).spriteOpening;
/*  988 */         this.shadow = (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).spriteWall;
/*      */       }
/*      */ 
/*      */       
/*      */       protected boolean place(int x, int y) {
/*  993 */         if (!isPlacable(x, y)) {
/*  994 */           return TBuilding.Ceiling.this.place(x, y);
/*      */         }
/*      */         
/*  997 */         boolean dia = (this.shared.get(x, y) instanceof TerrainDiagonal.Diagonalizer && ((TerrainDiagonal.Diagonalizer)this.shared.get(x, y)).getDia(x, y));
/*  998 */         placeRaw(x, y);
/*      */         
/* 1000 */         int res = 0;
/*      */         
/* 1002 */         if (isFat(x, y)) {
/* 1003 */           res |= 0x2000;
/* 1004 */           for (DIR d : DIR.ORTHO) {
/* 1005 */             if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/* 1006 */               res |= d.mask() | d.next(2).mask(); 
/*      */           } 
/*      */         } else {
/* 1009 */           for (DIR d : DIR.ORTHO) {
/* 1010 */             if (!isFat(x + d.x(), y + d.y()) && joins(x, y, d)) {
/* 1011 */               res |= d.mask();
/*      */             }
/*      */           } 
/*      */         } 
/* 1015 */         int cor = 0;
/* 1016 */         for (DIR d : DIR.NORTHO) {
/* 1017 */           if (!joins(x, y, d) && (res & d.next(1).mask()) != 0 && (res & d.next(-1).mask()) != 0)
/* 1018 */             cor |= d.mask(); 
/*      */         } 
/* 1020 */         res |= cor << 8;
/*      */         
/* 1022 */         if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.N)) {
/* 1023 */           Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.N);
/* 1024 */           if (t != this && t != (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall && t.wallIsWally() && !t.roofIs()) {
/* 1025 */             if ((res & DIR.NW.mask()) != 0)
/* 1026 */               res |= 0x20; 
/* 1027 */             if ((res & DIR.NE.mask()) != 0)
/* 1028 */               res |= 0x10; 
/*      */           } 
/*      */         } 
/* 1031 */         if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.W)) {
/* 1032 */           Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.W);
/* 1033 */           if (t != this && t != (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall && t.wallIsWally() && !t.roofIs()) {
/* 1034 */             if ((res & DIR.SW.mask()) != 0)
/* 1035 */               res |= 0x80; 
/* 1036 */             if ((res & DIR.NW.mask()) != 0) {
/* 1037 */               res |= 0x40;
/*      */             }
/*      */           } 
/*      */         } 
/* 1041 */         this.shared.data.set(x, y, res);
/* 1042 */         setDia(x, y, dia);
/* 1043 */         return false;
/*      */       }
/*      */       
/*      */       private boolean isFat(int x, int y) {
/* 1047 */         for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 1048 */           DIR d = (DIR)DIR.ORTHO.get(di);
/* 1049 */           if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/* 1050 */             return true; 
/*      */         } 
/* 1052 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 1059 */         int tile = data & 0xF;
/* 1060 */         int cor = data >> 8 & 0xF;
/* 1061 */         (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).structure.tint.color.bind();
/* 1062 */         if (tile == 0) {
/*      */ 
/*      */           
/* 1065 */           this.sheet.render(r, 128 + (i.ran() & 0xF), i.x(), i.y());
/* 1066 */           s.setHeight(3).setDistance2Ground(0.0D);
/* 1067 */           (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall.getClass(); this.shadow.render((SPRITE_RENDERER)s, 256, i.x(), i.y());
/*      */         }
/*      */         else {
/*      */           
/* 1071 */           int j = tile + (i.ran() & 0x1) * 16;
/* 1072 */           if (tile != 15 && (data & 0x1000) != 0)
/* 1073 */             j += 32; 
/* 1074 */           if (tile != 15)
/* 1075 */             this.sheet.render(r, j, i.x(), i.y()); 
/* 1076 */           s.setHeight(12).setDistance2Ground(0.0D);
/* 1077 */           if (tile == 15) {
/* 1078 */             (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall.getClass(); this.shadow.render((SPRITE_RENDERER)s, 272, i.x(), i.y());
/*      */           } else {
/* 1080 */             (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall.getClass(); this.shadow.render((SPRITE_RENDERER)s, tile + (((data & 0x1000) != 0) ? 64 : 0), i.x(), i.y());
/*      */           } 
/* 1082 */           if (cor != 0) {
/* 1083 */             int c = cor + 64 + (((data & 0x2000) != 0) ? 16 : 0);
/* 1084 */             this.sheet.render(r, c + (((data & 0x1000) != 0) ? 32 : 0), i.x(), i.y());
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1092 */         COLOR.unbind();
/*      */         
/* 1094 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       private boolean joins(int tx, int ty, DIR d) {
/* 1099 */         return TBuilding.jwall.is(tx, ty, d);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 1105 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public AVAILABILITY getAvailability(int x, int y) {
/* 1110 */         return null;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isPlacable(int tx, int ty) {
/* 1116 */         for (int i = 0; i < DIR.ALL.size(); i++) {
/* 1117 */           DIR d = (DIR)DIR.ALL.get(i);
/* 1118 */           if (!TBuilding.jwall.is(tx, ty, d)) {
/* 1119 */             return true;
/*      */           }
/*      */         } 
/*      */         
/* 1123 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       boolean wallJoiner() {
/* 1128 */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean wallIsWally() {
/* 1133 */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean roofIs() {
/* 1138 */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public void setDia(int x, int y, boolean dia) {
/* 1143 */         if (!is(x, y))
/*      */           return; 
/* 1145 */         int data = this.shared.data.get(x, y);
/* 1146 */         if (dia) {
/* 1147 */           data |= 0x1000;
/*      */         } else {
/* 1149 */           data &= 0xFFFFEFFF;
/* 1150 */         }  this.shared.data.set(x, y, data);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean getDia(int tx, int ty) {
/* 1155 */         if (!is(tx, ty))
/* 1156 */           return false; 
/* 1157 */         return ((this.shared.data.get(tx, ty) & 0x1000) != 0);
/*      */       }
/*      */ 
/*      */       
/*      */       public int heightStart(int tx, int ty) {
/* 1162 */         return 3;
/*      */       }
/*      */ 
/*      */       
/*      */       public int heightEnd(int tx, int ty) {
/* 1167 */         return 5;
/*      */       }
/*      */ 
/*      */       
/*      */       public LOS los(int tx, int ty) {
/* 1172 */         return LOS.CEILING;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void unplace(int tx, int ty) {}
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean wantsFloorUnderneath(int tx, int ty) {
/* 1183 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int heightStart(int tx, int ty) {
/* 1190 */       return 3;
/*      */     }
/*      */ 
/*      */     
/*      */     public int heightEnd(int tx, int ty) {
/* 1195 */       return 5;
/*      */     }
/*      */ 
/*      */     
/*      */     public LOS los(int tx, int ty) {
/* 1200 */       return LOS.CEILING;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1208 */   private static final MAP_BOOLEAN jwall = new MAP_BOOLEAN()
/*      */     {
/*      */       public boolean is(int tx, int ty)
/*      */       {
/* 1212 */         if (SETT.TERRAIN().get(tx, ty).wallJoiner())
/* 1213 */           return true; 
/* 1214 */         Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 1215 */         return (r != null && r.wallJoiner());
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean is(int tile) {
/* 1220 */         return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*      */       }
/*      */     };
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TBuilding.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */