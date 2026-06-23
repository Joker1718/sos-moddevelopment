/*      */ package world.map.terrain;
/*      */ 
/*      */ import game.debug.Profiler;
/*      */ import game.time.TIME;
/*      */ import init.constant.Config;
/*      */ import init.sprite.UI.UI;
/*      */ import init.type.TERRAINS;
/*      */ import java.io.IOException;
/*      */ import java.util.Arrays;
/*      */ import snake2d.Renderer;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.color.COLOR;
/*      */ import snake2d.util.color.ColorImp;
/*      */ import snake2d.util.datatypes.AREA;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.file.Alloc;
/*      */ import snake2d.util.file.FileGetter;
/*      */ import snake2d.util.file.FilePutter;
/*      */ import snake2d.util.file.Json;
/*      */ import snake2d.util.gui.clickable.CLICKABLE;
/*      */ import snake2d.util.map.MAP_BOOLEAN;
/*      */ import snake2d.util.map.MAP_OBJECT;
/*      */ import snake2d.util.sets.ArrayListGrower;
/*      */ import snake2d.util.sets.ArrayListResize;
/*      */ import snake2d.util.sets.Bitsmap1D;
/*      */ import snake2d.util.sets.LIST;
/*      */ import snake2d.util.sets.LinkedList;
/*      */ import snake2d.util.sprite.SPRITE;
/*      */ import util.gui.misc.GButt;
/*      */ import util.rendering.RenderData;
/*      */ import util.text.D;
/*      */ import view.tool.PLACABLE;
/*      */ import view.tool.PLACER_TYPE;
/*      */ import view.tool.PlacableMulti;
/*      */ import view.tool.ToolManager;
/*      */ import world.WORLD;
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
/*      */ public class WorldWater
/*      */   extends WorldTerrain.WorldTerrainResource
/*      */   implements MAP_OBJECT<WorldWater.WATER>
/*      */ {
/*   52 */   private final Bitsmap1D tiles = new Bitsmap1D(-1, 4, WORLD.TAREA());
/*      */   private final byte[] data;
/*   54 */   private final ArrayListResize<WATER> all = new ArrayListResize(255, 255);
/*   55 */   private final COLOR[] seasonColors = new COLOR[64];
/*   56 */   private final WorldWaterSprites sprites = new WorldWaterSprites();
/*      */   
/*   58 */   private static CharSequence ¤¤delta = "delta";
/*   59 */   private static CharSequence ¤¤normal = "normal";
/*   60 */   private static CharSequence ¤¤deep = "deep";
/*      */   
/*      */   static {
/*   63 */     D.ts(WorldWater.class);
/*      */   }
/*      */ 
/*      */   
/*   67 */   public final WATER NOTHING = new WATER(this, "clear") {
/*      */       private SPRITE icon;
/*      */       
/*      */       boolean render(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*   71 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       void pplace(int tx, int ty) {
/*   76 */         placeRaw(tx, ty);
/*      */       }
/*      */ 
/*      */       
/*      */       boolean coversCompleatly(int tile) {
/*   81 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*   86 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       boolean isFertile() {
/*   91 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       protected boolean canTravelTo(int data, DIR to) {
/*   96 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public SPRITE getIcon() {
/*  103 */         if (this.icon == null)
/*  104 */           this.icon = WorldWater.this.OCEAN.icon.twin((SPRITE)(UI.icons()).m.anti, DIR.C, 0); 
/*  105 */         return this.icon;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public PLACABLE getUndo() {
/*  111 */         return null;
/*      */       }
/*      */     };
/*      */   
/*      */   public final OpenSet LAKE;
/*      */   
/*      */   public final OpenSet OCEAN;
/*      */   
/*  119 */   public final WATER RIVER = new River();
/*  120 */   public final WATER RIVER_SMALL = new RiverSmall();
/*      */ 
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN isRivery;
/*      */ 
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN isDELTA;
/*      */ 
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN has;
/*      */ 
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN isBig;
/*      */ 
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN fertile;
/*      */ 
/*      */ 
/*      */   
/*      */   public MAP_BOOLEAN coversTile;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LIST<WATER> all() {
/*  150 */     return (LIST<WATER>)this.all;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void load(FileGetter saveFile) throws IOException {
/*  155 */     saveFile.bs(this.data);
/*  156 */     this.tiles.load(saveFile);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void save(FilePutter saveFile) {
/*  162 */     saveFile.bs(this.data);
/*  163 */     this.tiles.save(saveFile);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void clear() {
/*  168 */     this.tiles.setAll(0);
/*  169 */     Arrays.fill(this.data, (byte)0);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void update(double ds, Profiler prof) {
/*  174 */     this.sprites.update(ds);
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderShorelines(Renderer r, RenderData data, double season) {
/*  179 */     RenderData.RenderIterator it = data.onScreenTiles();
/*      */     
/*  181 */     while (it.has()) {
/*  182 */       ColorImp.TMP.bind();
/*  183 */       if (get(it.tx(), it.ty()).renderShore((SPRITE_RENDERER)r, dataGet(it.tile()), it)) {
/*  184 */         it.hiddenSet();
/*      */       }
/*  186 */       it.next();
/*      */     } 
/*  188 */     COLOR.unbind();
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderShorelines(Renderer r, RenderData.RenderIterator it) {
/*  193 */     if (get(it.tx(), it.ty()).renderShore((SPRITE_RENDERER)r, dataGet(it.tile()), it)) {
/*  194 */       it.hiddenSet();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void render(Renderer r, RenderData data, double season) {
/*  200 */     RenderData.RenderIterator it = data.onScreenTiles();
/*      */     
/*  202 */     int i = (int)(TIME.years().bitPartOf() * this.seasonColors.length);
/*  203 */     i %= this.seasonColors.length;
/*  204 */     ColorImp.TMP.interpolate(COLOR.WHITE100, this.seasonColors[i], season).bind();
/*  205 */     this.LAKE.update(i, (COLOR)ColorImp.TMP);
/*  206 */     this.OCEAN.update(i, (COLOR)ColorImp.TMP);
/*      */     
/*  208 */     while (it.has()) {
/*      */       
/*  210 */       if (get(it.tx(), it.ty()).render((SPRITE_RENDERER)r, dataGet(it.tile()), it)) {
/*  211 */         it.hiddenSet();
/*      */       }
/*  213 */       it.next();
/*      */     } 
/*  215 */     COLOR.unbind();
/*      */   }
/*      */ 
/*      */   
/*      */   private int dataGet(int tile) {
/*  220 */     return this.data[tile] & 0xFF;
/*      */   }
/*      */   
/*      */   private void dataSet(int tx, int ty, int d) {
/*  224 */     dataSet(tx + ty * WORLD.TWIDTH(), d);
/*      */   }
/*      */   
/*      */   private void dataSet(int tile, int d) {
/*  228 */     this.data[tile] = (byte)d;
/*      */   }
/*      */ 
/*      */   
/*      */   public WATER get(int tx, int ty) {
/*  233 */     if (!WORLD.IN_BOUNDS(tx, ty))
/*  234 */       return this.NOTHING; 
/*  235 */     return (WATER)this.all.get(this.tiles.get(tx + ty * WORLD.TWIDTH()));
/*      */   }
/*      */ 
/*      */   
/*      */   public WATER get(int tile) {
/*  240 */     return (WATER)this.all.get(this.tiles.get(tile));
/*      */   }
/*      */   
/*      */   public abstract class WATER
/*      */     extends PlacableMulti implements MAP_BOOLEAN {
/*      */     protected final int code;
/*      */     
/*      */     protected WATER(String name) {
/*  248 */       super(name);
/*  249 */       this.code = WorldWater.this.all.add(this);
/*      */     }
/*      */     
/*      */     abstract boolean coversCompleatly(int param1Int);
/*      */     
/*      */     void placeRaw(int tx, int ty) {
/*  255 */       if (WORLD.IN_BOUNDS(tx, ty)) {
/*  256 */         WorldWater.this.tiles.set(tx + ty * WORLD.TWIDTH(), this.code);
/*      */       }
/*      */     }
/*      */     
/*      */     public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  261 */       if (WORLD.IN_BOUNDS(tx, ty)) {
/*  262 */         int old = WorldWater.this.tiles.get(tx + ty * WORLD.TWIDTH());
/*  263 */         pplace(tx, ty);
/*  264 */         if (old != WorldWater.this.tiles.get(tx + ty * WORLD.TWIDTH())) {
/*  265 */           for (int i = 0; i < DIR.ALL.size(); i++) {
/*  266 */             DIR d = (DIR)DIR.ALL.get(i);
/*  267 */             WorldWater.this.get(tx + d.x(), ty + d.y()).pplace(tx + d.x(), ty + d.y());
/*  268 */             WORLD.changeTile(tx, ty);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     abstract void pplace(int param1Int1, int param1Int2);
/*      */ 
/*      */     
/*      */     final void place(int tx, int ty, DIR d) {
/*  279 */       pplace(tx + d.x(), ty + d.y());
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean is(int tile) {
/*  284 */       return (WorldWater.this.all.get(WorldWater.this.tiles.get(tile)) == this);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean is(int tx, int ty) {
/*  289 */       if (!WORLD.IN_BOUNDS(tx, ty))
/*  290 */         return false; 
/*  291 */       return is(tx + ty * WORLD.TWIDTH());
/*      */     }
/*      */     abstract boolean render(SPRITE_RENDERER param1SPRITE_RENDERER, int param1Int, RenderData.RenderIterator param1RenderIterator);
/*      */     
/*      */     boolean renderShore(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*  296 */       return false;
/*      */     }
/*      */     boolean rend2erMid(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*  299 */       return false;
/*      */     }
/*      */     
/*      */     abstract boolean isFertile();
/*      */     
/*      */     public PLACABLE getUndo() {
/*  305 */       return (PLACABLE)WorldWater.this.NOTHING;
/*      */     }
/*      */ 
/*      */     
/*      */     protected abstract boolean canTravelTo(int param1Int, DIR param1DIR);
/*      */   }
/*      */   
/*      */   public final class OpenSet
/*      */   {
/*      */     private final COLOR cShore;
/*      */     private final COLOR cWater;
/*  316 */     private final ColorImp col = new ColorImp();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final WorldWater.WATER normal;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final WorldWater.WATER deep;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final WorldWater.WATER delta;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final PLACABLE placer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final SPRITE icon;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final CharSequence name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MAP_BOOLEAN is;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MAP_BOOLEAN isOpen;
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
/*      */     void update(double ts, COLOR season) {
/*  408 */       this.col.set(this.cWater);
/*  409 */       this.col.multiply(season);
/*      */     }
/*      */     
/*  412 */     private OpenSet(String name, COLOR cShore, COLOR cWater, boolean isFertile) { this.is = new MAP_BOOLEAN()
/*      */         {
/*      */           public boolean is(int tx, int ty)
/*      */           {
/*  416 */             return !(!WorldWater.OpenSet.this.normal.is(tx, ty) && !WorldWater.OpenSet.this.deep.is(tx, ty) && !WorldWater.OpenSet.this.delta.is(tx, ty));
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean is(int tile) {
/*  421 */             return !(!WorldWater.OpenSet.this.normal.is(tile) && !WorldWater.OpenSet.this.deep.is(tile) && !WorldWater.OpenSet.this.delta.is(tile));
/*      */           }
/*      */         };
/*      */       
/*  425 */       this.isOpen = new MAP_BOOLEAN()
/*      */         {
/*      */           public boolean is(int tx, int ty)
/*      */           {
/*  429 */             return !(!WorldWater.OpenSet.this.normal.is(tx, ty) && !WorldWater.OpenSet.this.deep.is(tx, ty));
/*      */           }
/*      */           
/*      */           public boolean is(int tile)
/*      */           {
/*  434 */             return !(!WorldWater.OpenSet.this.normal.is(tile) && !WorldWater.OpenSet.this.deep.is(tile));
/*      */           } }; this.cShore = cShore;
/*      */       this.cWater = cWater;
/*      */       this.name = name;
/*      */       this.delta = new WorldWater.Delta(name + " (" + name + ")", this);
/*      */       this.normal = new WorldWater.Normal(name + " (" + name + ")", this, isFertile);
/*      */       this.deep = new WorldWater.Deep(name + " (" + name + ")", this, isFertile);
/*      */       this.icon = (SPRITE)new SPRITE.Imp(32) { public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { ((WorldWater.Normal)WorldWater.OpenSet.this.normal).renderIcon(r, X1, Y1, X2 - X1); } }
/*      */         ;
/*      */       this.placer = (PLACABLE)new PlacableMulti(name, "", this.icon) { LinkedList<CLICKABLE> butts; WorldWater.WATER current; public void place(int tx, int ty, AREA area, PLACER_TYPE type) { this.current.place(tx, ty, area, type);
/*      */             WORLD.MINIMAP().updateRegion(null); } public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) { return this.current.isPlacable(tx, ty, area, type); } public LIST<CLICKABLE> getAdditionalButt() { return (LIST<CLICKABLE>)this.butts; } public PLACABLE getUndo() { return (PLACABLE)(WorldWater.OpenSet.access$0(WorldWater.OpenSet.this)).NOTHING; } }
/*      */         ; } }
/*      */   private final class Normal extends WATER { private final WorldWater.OpenSet set; private final boolean fertile;
/*  447 */     private Normal(String name, WorldWater.OpenSet set, boolean fertile) { super(name);
/*  448 */       this.set = set;
/*  449 */       this.fertile = fertile; }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean coversCompleatly(int tile) {
/*  455 */       return (WorldWater.this.dataGet(tile) == 15);
/*      */     }
/*      */ 
/*      */     
/*      */     void pplace(int tx, int ty) {
/*  460 */       placeRaw(tx, ty);
/*  461 */       int res = 0;
/*  462 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  463 */         DIR d = (DIR)DIR.ORTHO.get(i);
/*  464 */         if (joins(tx, ty, d)) {
/*  465 */           res |= d.mask();
/*      */         }
/*      */       } 
/*  468 */       int edge = 0;
/*  469 */       for (int j = 0; j < DIR.NORTHO.size(); j++) {
/*  470 */         DIR d = (DIR)DIR.NORTHO.get(j);
/*  471 */         if (!joins(tx, ty, d) && joins(tx, ty, d.next(-1)) && joins(tx, ty, d.next(1))) {
/*  472 */           edge |= d.mask();
/*      */         }
/*      */       } 
/*  475 */       if (res == 15) {
/*  476 */         WORLD.MOUNTAIN().pClear(tx, ty);
/*  477 */         (WORLD.FOREST()).amount.set(tx, ty, 0.0D);
/*      */       } 
/*  479 */       res |= edge << 4;
/*  480 */       WorldWater.this.dataSet(tx, ty, res);
/*      */     }
/*      */     
/*      */     private boolean joins(int tx, int ty, DIR d) {
/*  484 */       return !(WORLD.IN_BOUNDS(tx, ty, d) && !is(tx, ty, d) && !this.set.deep.is(tx, ty, d) && !this.set.delta.is(tx, ty, d));
/*      */     }
/*      */ 
/*      */     
/*      */     boolean render(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*  489 */       int d = data & 0xF;
/*  490 */       int c = data >> 4 & 0xF;
/*  491 */       this.set.col.bind();
/*  492 */       WorldWater.this.sprites.render(r, it, d, c);
/*  493 */       return (data == 15);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean renderShore(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*  498 */       this.set.cShore.bind();
/*  499 */       int d = data & 0xF;
/*  500 */       int c = data >> 4 & 0xF;
/*  501 */       WorldWater.this.sprites.renderBackground(r, it, d, c);
/*  502 */       return (data == 15);
/*      */     }
/*      */ 
/*      */     
/*      */     public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  507 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isFertile() {
/*  512 */       return this.fertile;
/*      */     }
/*      */     
/*      */     public void renderIcon(SPRITE_RENDERER r, int x, int y, int dim) {
/*  516 */       this.set.cShore.bind();
/*  517 */       WorldWater.this.sprites.bgSingles.render(r, 0, x, x + dim, y, y + dim);
/*  518 */       WorldWater.this.sprites.bgSingles.render(r, 0, x, x + dim, y, y + dim);
/*  519 */       this.set.cWater.bind();
/*  520 */       WorldWater.this.sprites.sheetSingles.render(r, 0, x, x + dim, y, y + dim);
/*  521 */       COLOR.unbind();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean canTravelTo(int data, DIR to) {
/*  527 */       if (to.isOrtho())
/*  528 */         return ((data & to.mask()) != 0); 
/*  529 */       data >>>= 4;
/*  530 */       return ((data & to.mask()) == 0);
/*      */     } }
/*      */ 
/*      */   
/*      */   private final class Deep
/*      */     extends WATER
/*      */   {
/*      */     private final WorldWater.OpenSet set;
/*      */     private final boolean fertile;
/*      */     
/*      */     private Deep(String name, WorldWater.OpenSet set, boolean fertile) {
/*  541 */       super(name);
/*  542 */       this.set = set;
/*  543 */       this.fertile = fertile;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean coversCompleatly(int tile) {
/*  548 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     void pplace(int tx, int ty) {
/*  554 */       if (isPlacable(tx, ty, (AREA)null, (PLACER_TYPE)null) != null) {
/*  555 */         this.set.normal.pplace(tx, ty);
/*      */         
/*      */         return;
/*      */       } 
/*  559 */       placeRaw(tx, ty);
/*  560 */       int res = 0;
/*  561 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  562 */         DIR d = (DIR)DIR.ORTHO.get(i);
/*  563 */         if (!WORLD.IN_BOUNDS(tx, ty, d) || is(tx, ty, d)) {
/*  564 */           res |= d.mask();
/*      */         }
/*      */       } 
/*  567 */       WORLD.MOUNTAIN().pClear(tx, ty);
/*  568 */       (WORLD.FOREST()).amount.set(tx, ty, 0.0D);
/*  569 */       WorldWater.this.dataSet(tx, ty, res);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean render(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*  574 */       this.set.col.bind();
/*  575 */       WorldWater.this.sprites.renderDeep(r, it, data & 0xF);
/*  576 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  581 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/*  582 */         DIR d = (DIR)DIR.ALL.get(i);
/*  583 */         if (WORLD.IN_BOUNDS(tx, ty, d) && !is(tx, ty, d) && !this.set.normal.is(tx, ty, d))
/*  584 */           return ""; 
/*  585 */         if (this.set.delta.is(tx, ty))
/*  586 */           return ""; 
/*      */       } 
/*  588 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isFertile() {
/*  593 */       return this.fertile;
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean canTravelTo(int data, DIR to) {
/*  598 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   private final class River extends WATER {
/*      */     private final SPRITE iconSprite;
/*      */     
/*      */     private River() {
/*  606 */       super("river");
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
/*  670 */       this.iconSprite = (SPRITE)new SPRITE.Imp(32)
/*      */         {
/*      */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*      */           {
/*  674 */             (WorldWater.River.access$0(WorldWater.River.this)).LAKE.cShore.bind();
/*  675 */             (WorldWater.River.access$0(WorldWater.River.this)).sprites.riverBG.render(r, 0, X1, X2, Y1, Y2);
/*  676 */             (WorldWater.River.access$0(WorldWater.River.this)).LAKE.col.bind();
/*  677 */             (WorldWater.River.access$0(WorldWater.River.this)).sprites.riverFG.render(r, 0, X1, X2, Y1, Y2);
/*  678 */             COLOR.unbind();
/*      */           }
/*      */         };
/*      */     } boolean coversCompleatly(int tile) { return (WorldWater.this.dataGet(tile) == 15); } void pplace(int tx, int ty) { placeRaw(tx, ty); int res = 0; for (int i = 0; i < DIR.ORTHO.size(); i++) { DIR d = (DIR)DIR.ORTHO.get(i); if (!WORLD.IN_BOUNDS(tx, ty, d) || is(tx, ty, d)) { res |= d.mask(); } else if (WorldWater.this.LAKE.delta.is(tx, ty, d) || WorldWater.this.OCEAN.delta.is(tx, ty, d)) { int x = tx + d.x() * 2; int y = ty + d.y() * 2; if (WorldWater.this.OCEAN.normal.is(x, y) || WorldWater.this.LAKE.normal.is(x, y)) res |= d.mask();  }  }  if (res == 15) { WORLD.MOUNTAIN().pClear(tx, ty); (WORLD.FOREST()).amount.set(tx, ty, 0.0D); }  WorldWater.this.dataSet(tx, ty, res); } boolean render(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) { WorldWater.this.LAKE.col.bind(); WorldWater.this.sprites.riverFG.render(r, data + (it.ran() & 0x7) * 16, it.x(), it.y()); WorldWater.this.sprites.renderTexture(it); return false; } boolean renderShore(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) { WorldWater.this.LAKE.cShore.bind(); WorldWater.this.sprites.riverBG.render(r, data + (it.ran() & 0x7) * 16, it.x(), it.y()); return false; } public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) { return null; }
/*      */     boolean isFertile() { return true; }
/*      */     protected boolean canTravelTo(int data, DIR to) { if (to.isOrtho()) return ((data & to.mask()) != 0);  return !((data & to.mask()) == 0 && (data & to.next(1).mask()) == 0); }
/*  684 */     public SPRITE getIcon() { return this.iconSprite; }
/*      */   
/*      */   }
/*      */   
/*      */   private final class RiverSmall extends WATER
/*      */   {
/*      */     private final SPRITE iconSprite;
/*      */     
/*  692 */     private RiverSmall() { super("river small");
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
/*  777 */       this.iconSprite = (SPRITE)new SPRITE.Imp(32)
/*      */         {
/*      */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*      */           {
/*  781 */             (WorldWater.RiverSmall.access$0(WorldWater.RiverSmall.this)).LAKE.cShore.bind();
/*  782 */             (WorldWater.RiverSmall.access$0(WorldWater.RiverSmall.this)).sprites.riverSmallBG.render(r, 0, X1, X2, Y1, Y2);
/*  783 */             (WorldWater.RiverSmall.access$0(WorldWater.RiverSmall.this)).LAKE.col.bind();
/*  784 */             (WorldWater.RiverSmall.access$0(WorldWater.RiverSmall.this)).sprites.riverSmallFG.render(r, 0, X1, X2, Y1, Y2);
/*  785 */             COLOR.unbind();
/*      */           }
/*      */         }; }
/*      */     boolean coversCompleatly(int tile) { return false; } void pplace(int tx, int ty) { placeRaw(tx, ty); int res = 0; int other = 0; for (int i = 0; i < DIR.ORTHO.size(); i++) { DIR d = (DIR)DIR.ORTHO.get(i); if (!WORLD.IN_BOUNDS(tx, ty, d) || is(tx, ty, d)) { res |= d.mask(); } else if (WorldWater.this.get(tx, ty, d) != WorldWater.this.NOTHING) { res |= d.mask(); if (!is(tx, ty, d))
/*      */             other |= d.mask();  }  }  WorldWater.this.dataSet(tx, ty, res | other << 4); } boolean renderShore(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) { WorldWater.this.LAKE.cShore.bind(); int o = data >>> 4; data &= 0xF; WorldWater.this.sprites.riverSmallBG.render(r, data + (it.ran() & 0x7) * 16, it.x(), it.y()); if (o != 0)
/*      */         for (int i = 0; i < DIR.ORTHO.size(); i++) { DIR d = (DIR)DIR.ORTHO.get(i); if ((d.mask() & o) != 0) { int x = it.x() + d.x() * 64; int y = it.y() + d.y() * 64; int da = d.perpendicular().mask(); WorldWater.this.sprites.riverSmallBG.render(r, da + (it.ran() & 0x7) * 16, x, y); }  }   WorldWater.this.LAKE.col.bind(); WorldWater.this.sprites.riverSmallFG.render(r, data + (it.ran() & 0x7) * 16, it.x(), it.y()); if (o != 0)
/*  791 */         for (int i = 0; i < DIR.ORTHO.size(); i++) { DIR d = (DIR)DIR.ORTHO.get(i); if ((d.mask() & o) != 0) { int x = it.x() + d.x() * 64; int y = it.y() + d.y() * 64; int da = d.perpendicular().mask(); WorldWater.this.sprites.riverSmallFG.render(r, da + (it.ran() & 0x7) * 16, x, y); }  }   return false; } public SPRITE getIcon() { return this.iconSprite; }
/*      */      public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*      */       return null;
/*      */     } boolean isFertile() {
/*      */       return true;
/*      */     } boolean render(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*      */       return false;
/*      */     } protected boolean canTravelTo(int data, DIR to) {
/*      */       return false;
/*      */     } } private final class Delta extends WATER { private final WorldWater.OpenSet set; private Delta(String name, WorldWater.OpenSet set) {
/*  801 */       super(name);
/*  802 */       this.set = set;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean coversCompleatly(int tile) {
/*  807 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     void pplace(int tx, int ty) {
/*  812 */       if (isPlacable(tx, ty, null, null) != null) {
/*  813 */         this.set.normal.pplace(tx, ty);
/*      */         
/*      */         return;
/*      */       } 
/*  817 */       placeRaw(tx, ty);
/*  818 */       int res = 0;
/*  819 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  820 */         DIR d = (DIR)DIR.ORTHO.get(i);
/*  821 */         if (this.set.normal.is(tx, ty, d)) {
/*  822 */           res = i;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*  827 */       WorldWater.this.dataSet(tx, ty, res);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean render(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*  832 */       WorldWater.this.RIVER.render(r, ((DIR)DIR.ORTHO.get(data)).mask() | ((DIR)DIR.ORTHO.get(data)).perpendicular().mask(), it);
/*  833 */       this.set.col.bind();
/*  834 */       WorldWater.this.sprites.delta.render(r, data + (it.ran() & 0x3) * 4, it.x(), it.y());
/*  835 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean renderShore(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*  840 */       WorldWater.this.RIVER.renderShore(r, ((DIR)DIR.ORTHO.get(data)).mask() | ((DIR)DIR.ORTHO.get(data)).perpendicular().mask(), it);
/*  841 */       this.set.cShore.bind();
/*  842 */       WorldWater.this.sprites.deltaShore.render(r, data + (it.ran() & 0x3) * 4, it.x(), it.y());
/*  843 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  848 */       return (WorldWater.this.bordersCount(tx, ty, this.set.normal) == 1) ? null : "";
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isFertile() {
/*  853 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean canTravelTo(int data, DIR to) {
/*  858 */       int m = ((DIR)DIR.ORTHO.get(data)).mask() | ((DIR)DIR.ORTHO.get(data)).perpendicular().mask();
/*  859 */       return WorldWater.this.RIVER.canTravelTo(m, to);
/*      */     } }
/*      */ 
/*      */   
/*      */   WorldWater() throws IOException
/*      */   {
/*  865 */     this.isRivery = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty)
/*      */         {
/*  869 */           return !(!WorldWater.this.RIVER.is(tx, ty) && !WorldWater.this.LAKE.delta.is(tx, ty) && !WorldWater.this.OCEAN.delta.is(tx, ty));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean is(int tile) {
/*  874 */           return !(!WorldWater.this.RIVER.is(tile) && !WorldWater.this.LAKE.delta.is(tile) && !WorldWater.this.OCEAN.delta.is(tile));
/*      */         }
/*      */       };
/*      */     
/*  878 */     this.isDELTA = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty)
/*      */         {
/*  882 */           return WorldWater.this.get(tx, ty) instanceof WorldWater.Delta;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean is(int tile) {
/*  887 */           return WorldWater.this.get(tile) instanceof WorldWater.Delta;
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
/*  952 */     this.has = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty) {
/*  955 */           if (!WORLD.IN_BOUNDS(tx, ty))
/*  956 */             return false; 
/*  957 */           return !WorldWater.this.NOTHING.is(tx, ty);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean is(int tile) {
/*  962 */           return (WorldWater.this.all.get(WorldWater.this.tiles.get(tile)) != WorldWater.this.NOTHING);
/*      */         }
/*      */       };
/*      */     
/*  966 */     this.isBig = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty) {
/*  969 */           if (!WORLD.IN_BOUNDS(tx, ty))
/*  970 */             return false; 
/*  971 */           return (!WorldWater.this.NOTHING.is(tx, ty) && !WorldWater.this.RIVER_SMALL.is(tx, ty));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean is(int tile) {
/*  976 */           return (WorldWater.this.all.get(WorldWater.this.tiles.get(tile)) != WorldWater.this.NOTHING && WorldWater.this.all.get(WorldWater.this.tiles.get(tile)) != WorldWater.this.RIVER_SMALL);
/*      */         }
/*      */       };
/*      */     
/*  980 */     this.fertile = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty)
/*      */         {
/*  984 */           return WorldWater.this.get(tx, ty).isFertile();
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean is(int tile) {
/*  989 */           return ((WorldWater.WATER)WorldWater.this.all.get(WorldWater.this.tiles.get(tile))).isFertile();
/*      */         }
/*      */       };
/*      */     
/*  993 */     this.coversTile = new MAP_BOOLEAN()
/*      */       {
/*      */         public boolean is(int tx, int ty)
/*      */         {
/*  997 */           if (WORLD.IN_BOUNDS(tx, ty))
/*  998 */             return is(tx + ty * WORLD.TWIDTH()); 
/*  999 */           return false;
/*      */         }
/*      */         
/*      */         public boolean is(int tile)
/*      */         {
/* 1004 */           return ((WorldWater.WATER)WorldWater.this.all.get(WorldWater.this.tiles.get(tile))).coversCompleatly(tile); } }; Json js = Config.ConfigWorld.json("Water"); this.LAKE = new OpenSet("lake", (COLOR)new ColorImp(js, "COLOR_LAKE_SHORE"), (COLOR)new ColorImp(js, "COLOR_LAKE"), true); this.OCEAN = new OpenSet("ocean", (COLOR)new ColorImp(js, "COLOR_OCEAN_SHORE"), (COLOR)new ColorImp(js, "COLOR_OCEAN"), false); this.data = Alloc.bb(WORLD.TAREA()); this.all.trim(); ColorImp winter = new ColorImp(127, 100, 127); for (double i = 0.0D; i < this.seasonColors.length; i++) { ColorImp p = new ColorImp(); double d = i / (this.seasonColors.length - 1); if (d < 0.5D) { d *= 2.0D; }
/*      */       else
/*      */       { d = 1.0D - (d - 0.5D) * 2.0D; }
/*      */        p.interpolate(COLOR.WHITE100, (COLOR)winter, d); this.seasonColors[(int)i] = (COLOR)p; }
/*      */      } public boolean canTravelToByBoat(int sx, int sy, DIR d) { if (!this.isBig.is(sx, sy, d))
/*      */       return false;  WATER w = get(sx, sy); int dd = dataGet(sx + WORLD.TWIDTH() * sy); return w.canTravelTo(dd, d); }
/* 1010 */   public boolean borders(int x, int y, WATER terrain) { for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 1011 */       if (terrain.is(x, y, (DIR)DIR.ORTHO.get(i)))
/* 1012 */         return true; 
/*      */     } 
/* 1014 */     return false; } public boolean canCrossByLand(int fromX, int fromY, int toX, int toY) { if (!this.isBig.is(toX, toY)) return true;  if (this.RIVER_SMALL.is(fromX, fromY)) return true;  if (this.RIVER.is(fromX, fromY)) return (Math.abs(fromX - toX) + Math.abs(fromY - toY) <= 1 && !this.RIVER.is(toX, toY));  if (this.has.is(fromX, fromY))
/*      */       return false;  return true; }
/*      */   double add(WorldTerrainInfo info, int tx, int ty) { if (this.RIVER.is(tx, ty)) { info.add(TERRAINS.WET(), 0.5D); return 0.5D; }  if (this.RIVER_SMALL.is(tx, ty)) { info.add(TERRAINS.WET(), 0.25D); return 0.25D; }  if (this.OCEAN.delta.is(tx, ty)) { info.add(TERRAINS.WET(), 0.25D); info.add(TERRAINS.OCEAN(), 0.5D); return 0.75D; }  if (this.LAKE.delta.is(tx, ty)) { info.add(TERRAINS.WET(), 0.25D); info.add(TERRAINS.WET(), 0.5D); return 0.75D; }  if (this.OCEAN.isOpen.is(tx, ty)) { double m = 0.5D; for (DIR d : DIR.ORTHO) { if (this.OCEAN.is.is(tx, ty, d))
/*      */           m += 0.125D;  }  info.add(TERRAINS.OCEAN(), m); return m; }  if (this.LAKE.isOpen.is(tx, ty)) { double m = 0.5D; for (DIR d : DIR.ORTHO) { if (this.LAKE.is.is(tx, ty, d))
/*      */           m += 0.125D;  }  info.add(TERRAINS.WET(), m); return m; }  return 0.0D; }
/* 1019 */   public int bordersCount(int x, int y, WATER tiles) { int j = 0;
/* 1020 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 1021 */       if (tiles.is(x, y, (DIR)DIR.ORTHO.get(i)))
/* 1022 */         j++; 
/*      */     } 
/* 1024 */     return j; }
/*      */ 
/*      */ 
/*      */   
/*      */   public LIST<PLACABLE> placers(ToolManager tm) {
/* 1029 */     ArrayListGrower<PLACABLE> placers = new ArrayListGrower();
/*      */     
/* 1031 */     OpenSet[] os = {
/* 1032 */         this.LAKE, this.OCEAN }; byte b; int i;
/*      */     OpenSet[] arrayOfOpenSet1;
/* 1034 */     for (i = (arrayOfOpenSet1 = os).length, b = 0; b < i; ) { OpenSet o = arrayOfOpenSet1[b];
/* 1035 */       PlacableMulti placer = new PlacableMulti(o.name, "", o.icon, o)
/*      */         {
/*      */           LinkedList<CLICKABLE> butts;
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
/*      */           WorldWater.WATER current;
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
/*      */           public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 1076 */             this.current.place(tx, ty, area, type);
/*      */           }
/*      */ 
/*      */           
/*      */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 1081 */             return this.current.isPlacable(tx, ty, area, type);
/*      */           }
/*      */ 
/*      */           
/*      */           public LIST<CLICKABLE> getAdditionalButt() {
/* 1086 */             return (LIST<CLICKABLE>)this.butts;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public PLACABLE getUndo() {
/* 1092 */             return (PLACABLE)WorldWater.this.NOTHING;
/*      */           }
/*      */         };
/*      */ 
/*      */       
/* 1097 */       placers.add(placer);
/*      */       b++; }
/*      */     
/* 1100 */     placers.add(this.RIVER);
/* 1101 */     placers.add(this.RIVER_SMALL);
/* 1102 */     placers.add(this.NOTHING);
/* 1103 */     return (LIST<PLACABLE>)placers;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldWater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */