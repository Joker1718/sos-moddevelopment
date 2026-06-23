/*     */ package world.map.regions;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.rendering.RenderData;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WREGIONS
/*     */   extends WORLD.WorldResource
/*     */ {
/*  38 */   public static final COLOR cNone = (COLOR)new ColorImp(100, 100, 100);
/*     */   public static final int MAX = 1023;
/*  40 */   private final ArrayList<Region> areas = new ArrayList(1023);
/*  41 */   private final ArrayList<Region> active = new ArrayList(1023);
/*  42 */   final RegionMap pmap = new RegionMap();
/*     */   public final Region player;
/*  44 */   public final MAP_OBJECT<Region> map = (MAP_OBJECT<Region>)this.pmap;
/*  45 */   private final Bitmap2D edge = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*  46 */   private final Bitmap2D besige = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false); private final WORLD.WorldResourceManager saver; boolean dirty; public final MAP_BOOLEAN isCentre;
/*  47 */   private final Bitmap2D ctile = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false); public final MAP_OBJECT<Region> cTile; public final MAP_OBJECT<Region> centre; public final MAP_OBJECT<Faction> faction;
/*     */   public WREGIONS() {
/*  49 */     super("Regions", "REGIONS");
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
/*  68 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  72 */           WREGIONS.this.pmap.save(file);
/*  73 */           for (Region a : WREGIONS.this.areas) {
/*  74 */             a.save(file);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  81 */           WREGIONS.this.pmap.load(file);
/*  82 */           for (Region a : WREGIONS.this.areas) {
/*  83 */             a.load(file);
/*     */           }
/*  85 */           WREGIONS.this.dirty = true;
/*  86 */           WREGIONS.this.init();
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  91 */           WREGIONS.this.pmap.clear();
/*  92 */           for (Region r : WORLD.REGIONS().all()) {
/*  93 */             r.clear();
/*     */           }
/*  95 */           WREGIONS.this.active.clearSloppy();
/*  96 */           WREGIONS.this.active.add((Iterable)WREGIONS.this.areas);
/*  97 */           WORLD.MINIMAP().repaint();
/*  98 */           WREGIONS.this.dirty = true;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 103 */           return (LIST<PLACABLE>)new Placer();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void generate(ACTION loadPrint) {
/* 109 */           validateInit(null);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void validateInit(WORLD.WorldError error) {
/* 115 */           WREGIONS.this.init();
/*     */         }
/*     */       };
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
/* 164 */     this.dirty = true;
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
/* 192 */     this.isCentre = new MAP_BOOLEAN()
/*     */       {
/* 194 */         final int min = 1;
/* 195 */         final int max = 1;
/*     */         
/*     */         public boolean is(int tx, int ty) {
/* 198 */           Region r = (Region)WREGIONS.this.map.get(tx, ty);
/* 199 */           if (r != null) {
/* 200 */             int dx = tx - r.info.cx();
/* 201 */             int dy = ty - r.info.cy();
/* 202 */             return (dx >= -1 && dx <= 1 && dy >= -1 && dy <= 1);
/*     */           } 
/* 204 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 209 */           return is(tile % WORLD.TWIDTH(), tile / WORLD.TWIDTH());
/*     */         }
/*     */       };
/*     */     
/* 213 */     this.cTile = new MAP_OBJECT<Region>()
/*     */       {
/*     */         public Region get(int tile)
/*     */         {
/* 217 */           int tx = tile % WORLD.TWIDTH();
/* 218 */           int ty = tile / WORLD.TWIDTH();
/* 219 */           return get(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public Region get(int tx, int ty) {
/* 224 */           Region r = (Region)WREGIONS.this.map.get(tx, ty);
/* 225 */           if (r != null && r.cx() == tx && r.cy() == ty)
/* 226 */             return r; 
/* 227 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 233 */     this.centre = new MAP_OBJECT<Region>()
/*     */       {
/*     */         public Region get(int tile)
/*     */         {
/* 237 */           int tx = tile % WORLD.TWIDTH();
/* 238 */           int ty = tile / WORLD.TWIDTH();
/* 239 */           return get(tx, ty);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public Region get(int tx, int ty) {
/* 245 */           int min = 1;
/* 246 */           int max = 2;
/*     */           
/* 248 */           for (int dy = -1; dy < 2; dy++) {
/* 249 */             for (int dx = -1; dx < 2; dx++) {
/* 250 */               Region r = (Region)WREGIONS.this.map.get(tx + dx, ty + dy);
/* 251 */               if (r != null && r.cx() == tx + dx && r.cy() == ty + dy)
/* 252 */                 return r; 
/*     */             } 
/*     */           } 
/* 255 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 261 */     this.faction = new MAP_OBJECT<Faction>()
/*     */       {
/*     */         public Faction get(int tile) {
/* 264 */           Region reg = (Region)WREGIONS.this.map.get(tile);
/* 265 */           if (reg != null)
/* 266 */             return reg.faction(); 
/* 267 */           return null;
/*     */         }
/*     */         
/*     */         public Faction get(int tx, int ty)
/*     */         {
/* 272 */           if (!WORLD.IN_BOUNDS(tx, ty))
/* 273 */             return null; 
/* 274 */           return get(tx + ty * WORLD.TWIDTH()); } }; this.player = new Region(0);
/*     */     this.areas.add(this.player);
/*     */     for (int i = 1; i < 1023; i++) {
/*     */       Region r = new Region(i);
/*     */       this.areas.add(r);
/*     */     } 
/* 280 */     this.active.add((Iterable)this.areas); } public final void renderBorders(Renderer r, RenderData.RenderIterator it) { if (!border().is(it.tile())) {
/*     */       return;
/*     */     }
/*     */     
/* 284 */     Region a = (Region)this.map.get(it.tile());
/* 285 */     if (a != null) {
/* 286 */       int m = 0;
/* 287 */       for (DIR d : DIR.ORTHO) {
/* 288 */         if (!WORLD.IN_BOUNDS(it.tx(), it.ty(), d)) {
/* 289 */           m |= d.mask();
/*     */           continue;
/*     */         } 
/* 292 */         if (this.faction.get(it.tx(), it.ty(), d) == a.faction()) {
/* 293 */           m |= d.mask();
/*     */         }
/*     */       } 
/*     */       
/* 297 */       int c = 0;
/* 298 */       for (DIR d : DIR.NORTHO) {
/* 299 */         if (!WORLD.IN_BOUNDS(it.tx(), it.ty(), d)) {
/*     */           continue;
/*     */         }
/* 302 */         if (this.faction.get(it.tx(), it.ty(), d) != a.faction() && this.faction.get(it.tx(), it.ty(), d.next(1)) == a.faction() && this.faction.get(it.tx(), it.ty(), d.next(-1)) == a.faction()) {
/* 303 */           c |= d.mask();
/*     */         }
/*     */       } 
/*     */       
/* 307 */       if (m != 15 || c != 0) {
/* 308 */         if (a.faction() == null) {
/* 309 */           COLOR.WHITE35.bind();
/*     */         } else {
/* 311 */           a.faction().banner().colorBG().bind();
/* 312 */         }  OPACITY.O50.bind();
/* 313 */         (SPRITES.cons()).BIG.outline.render((SPRITE_RENDERER)r, m, c, it.x(), it.y());
/* 314 */         OPACITY.O75.bind();
/* 315 */         (SPRITES.cons()).BIG.dashed_hollow.render((SPRITE_RENDERER)r, m, c, it.x(), it.y());
/*     */       } 
/* 317 */       OPACITY.unbind();
/*     */     }  }
/*     */ 
/*     */   
/*     */   public Region getByIndex(int index) {
/*     */     return (Region)this.areas.get(index);
/*     */   }
/*     */   
/*     */   public LIST<Region> all() {
/*     */     return (LIST<Region>)this.areas;
/*     */   }
/*     */   
/*     */   private void init() {
/*     */     this.edge.clear();
/*     */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       Region r = (Region)this.map.get(c);
/*     */       for (DIR d : DIR.ALL) {
/*     */         if (WORLD.IN_BOUNDS(c, d) && this.map.get(c, d) != r) {
/*     */           this.edge.set(c, true);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     this.besige.clear();
/*     */     this.ctile.clear();
/*     */     Rec bb = new Rec(5.0D, 5.0D);
/*     */     for (Region reg : this.active) {
/*     */       bb.moveX1Y1(reg.cx(), reg.cy());
/*     */       bb.incr(-Math.ceil(1.5D), -Math.ceil(1.5D));
/*     */       for (COORDINATE c : bb) {
/*     */         if (WORLD.TBOUNDS().holdsPoint(c) && bb.isOnEdge(c.x(), c.y()))
/*     */           this.besige.set(c, true); 
/*     */       } 
/*     */       for (DIR d : DIR.ALLC)
/*     */         this.ctile.set(reg.cx(), reg.cy(), d, true); 
/*     */     } 
/*     */     WORLD.FOW().setDirty();
/*     */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public WORLD.WorldResourceManager saver() {
/*     */     return this.saver;
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler prof) {}
/*     */   
/*     */   public LIST<Region> active() {
/*     */     if (this.dirty) {
/*     */       this.dirty = false;
/*     */       this.active.clearSloppy();
/*     */       for (Region r : this.areas) {
/*     */         if (r.info.area() > 0 && this.map.get(r.cx(), r.cy()) == r)
/*     */           this.active.add(r); 
/*     */       } 
/*     */     } 
/*     */     return (LIST<Region>)this.active;
/*     */   }
/*     */   
/*     */   public MAP_BOOLEAN border() {
/*     */     return (MAP_BOOLEAN)this.edge;
/*     */   }
/*     */   
/*     */   public MAP_BOOLEAN centreEdgeTile() {
/*     */     return (MAP_BOOLEAN)this.besige;
/*     */   }
/*     */   
/*     */   public MAP_BOOLEAN centreTile() {
/*     */     return (MAP_BOOLEAN)this.ctile;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\WREGIONS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */