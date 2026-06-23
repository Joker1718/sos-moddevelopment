/*     */ package world.map.road;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ import world.WRenContext;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WorldRoads
/*     */   extends WORLD.WorldResource
/*     */   implements MAP_BOOLEANE
/*     */ {
/*     */   private COLOR[] rColors;
/*  42 */   private final Bitmap2D is = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*  43 */   private final Bitmap2D mini = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*  44 */   public final Bitmap2D bridge = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*  45 */   private final Bitsmap1D data = new Bitsmap1D(0, 4, WORLD.TAREA()); private final DIR[] dds; public final MAP_BOOLEAN harbour; public final MAP_BOOLEAN isBig; public final MAP_BOOLEANE minified;
/*  46 */   private final Bitmap2D miniHack = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false); public final MAP_BOOLEAN placable; public final MAP_BOOLEAN canBridge; private final WORLD.WorldResourceManager saver;
/*     */   
/*     */   public WorldRoads(WORLD data2) {
/*  49 */     super("roads", "ROADS");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     this.dds = new DIR[] { DIR.N, DIR.E };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 239 */     this.harbour = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 243 */           return (WorldRoads.this.is.is(tx, ty) && (WORLD.WATER()).isBig.is(tx, ty) && !WorldRoads.this.mini.is(tx, ty));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 248 */           return (WorldRoads.this.is.is(tile) && (WORLD.WATER()).isBig.is(tile) && !WorldRoads.this.mini.is(tile));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 253 */     this.isBig = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 257 */           return (WorldRoads.this.is.is(tx, ty) && !WorldRoads.this.mini.is(tx, ty));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 262 */           return (WorldRoads.this.is.is(tile) && !WorldRoads.this.mini.is(tile));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 267 */     this.minified = new MAP_BOOLEANE()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 271 */           return (WorldRoads.this.is.is(tx, ty) && WorldRoads.this.mini.is(tx, ty));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 276 */           return (WorldRoads.this.is.is(tile) && WorldRoads.this.mini.is(tile));
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 281 */           if (WorldRoads.this.is.is(tx, ty)) {
/* 282 */             WorldRoads.this.mini.set(tx, ty, value);
/* 283 */             WorldRoads.this.fix(tx, ty);
/*     */           } 
/* 285 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tile, boolean value) {
/* 290 */           int tx = tile % WORLD.TWIDTH();
/* 291 */           int ty = tile / WORLD.TWIDTH();
/* 292 */           return set(tx, ty, value);
/*     */         }
/*     */       };
/*     */     
/* 296 */     this.placable = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 300 */           if (WORLD.MOUNTAIN().coversTile(tx, ty)) {
/* 301 */             return false;
/*     */           }
/* 303 */           if ((WORLD.WATER()).isBig.is(tx, ty)) {
/*     */             
/* 305 */             if (!WorldRoads.this.hasLand(tx, ty))
/* 306 */               return false;  byte b; int i;
/*     */             DIR[] arrayOfDIR;
/* 308 */             for (i = (arrayOfDIR = WorldRoads.this.dds).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/* 309 */               if (WORLD.IN_BOUNDS(tx, ty, d) && WORLD.IN_BOUNDS(tx, ty, d.perpendicular()) && (WORLD.WATER()).isBig.is(tx, ty, d) && (WORLD.WATER()).isBig.is(tx, ty, d.perpendicular()))
/* 310 */                 return true; 
/*     */               b++; }
/*     */             
/* 313 */             return false;
/*     */           } 
/*     */           
/* 316 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 321 */           int tx = tile % WORLD.TWIDTH();
/* 322 */           int ty = tile / WORLD.TWIDTH();
/* 323 */           return is(tx, ty);
/*     */         }
/*     */       };
/*     */     
/* 327 */     this.canBridge = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 331 */           if (WORLD.MOUNTAIN().coversTile(tx, ty)) {
/* 332 */             return false;
/*     */           }
/* 334 */           if (!(WORLD.WATER()).isBig.is(tx, ty)) {
/* 335 */             return false;
/*     */           }
/* 337 */           if (!WorldRoads.this.hasLand(tx, ty))
/* 338 */             return false;  byte b; int i;
/*     */           DIR[] arrayOfDIR;
/* 340 */           for (i = (arrayOfDIR = WorldRoads.this.dds).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/* 341 */             if (WORLD.IN_BOUNDS(tx, ty, d) && (WORLD.WATER()).isBig.is(tx, ty, d)) {
/* 342 */               d = d.perpendicular();
/* 343 */               if (WORLD.IN_BOUNDS(tx, ty, d) && (WORLD.WATER()).isBig.is(tx, ty, d))
/* 344 */                 return true; 
/*     */             } 
/*     */             b++; }
/*     */           
/* 348 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 355 */           int tx = tile % WORLD.TWIDTH();
/* 356 */           int ty = tile / WORLD.TWIDTH();
/* 357 */           return is(tx, ty);
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
/* 372 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/* 374 */         final Placer placers = new Placer();
/*     */         
/*     */         public void save(FilePutter f) {
/* 377 */           WorldRoads.this.is.save(f);
/* 378 */           WorldRoads.this.mini.save(f);
/* 379 */           WorldRoads.this.data.save(f);
/* 380 */           WorldRoads.this.miniHack.save(f);
/* 381 */           WorldRoads.this.bridge.save(f);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter f) throws IOException {
/* 386 */           WorldRoads.this.is.load(f);
/* 387 */           WorldRoads.this.mini.load(f);
/* 388 */           WorldRoads.this.data.load(f);
/* 389 */           WorldRoads.this.miniHack.load(f);
/* 390 */           WorldRoads.this.bridge.load(f);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 395 */           WorldRoads.this.is.clear();
/* 396 */           WorldRoads.this.mini.clear();
/* 397 */           WorldRoads.this.data.clear();
/* 398 */           WorldRoads.this.miniHack.clear();
/* 399 */           WorldRoads.this.bridge.clear();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void validateInit(WORLD.WorldError error) {
/* 405 */           if (!WORLD.IN_BOUNDS((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy())) {
/* 406 */             error.problem = "The world has no player region centre";
/* 407 */             error.coo.set(WORLD.TBOUNDS().cX(), WORLD.TBOUNDS().cY());
/*     */             return;
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void generate(ACTION loadPrint) {
/* 417 */           clear();
/* 418 */           (new Gen()).generateAll((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy(), loadPrint);
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<PLACABLE> makePlacers(ToolManager tm)
/*     */         {
/* 424 */           return (LIST<PLACABLE>)this.placers.placers; }
/*     */       };
/*     */     Json j = Config.ConfigWorld.json("Road");
/*     */     ColorImp low = new ColorImp(j, "COLOR_SMALL");
/*     */     ColorImp hi = new ColorImp(j, "COLOR_BIG");
/*     */     this.rColors = (COLOR[])COLOR.interpolate((COLOR)low, (COLOR)hi, 16);
/*     */   } public WORLD.WorldResourceManager saver() {
/* 431 */     return this.saver;
/*     */   }
/*     */   
/*     */   public void render(WRenContext data, RenderData.RenderIterator it) {
/*     */     if (!this.is.is(it.tile()))
/*     */       return; 
/*     */     if (this.miniHack.is(it.tile())) {
/*     */       int m = 0;
/*     */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*     */         if (this.is.is(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(di)) && this.mini.is(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(di)))
/*     */           m |= ((DIR)DIR.ORTHO.get(di)).mask(); 
/*     */       } 
/*     */       this.rColors[0].bind();
/*     */       (WORLD.BUILDINGS()).sprites.roadsMini.render(data.r, m + 16 * (it.ran() & 0x7), it.x(), it.y());
/*     */     } 
/*     */     double d = levelRoad(it.tile());
/*     */     TILE_SHEET sheet = (WORLD.BUILDINGS()).sprites.roads;
/*     */     if (this.mini.is(it.tile())) {
/*     */       sheet = (WORLD.BUILDINGS()).sprites.roadsMini;
/*     */       d *= 0.25D;
/*     */     } else {
/*     */       d = 0.75D + 0.25D * d;
/*     */     } 
/*     */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */     this.rColors[(int)(d * 15.0D)].bind();
/*     */     sheet.render(data.r, this.data.get(it.tile()) + 16 * (it.ran() & 0x7), it.x(), it.y());
/*     */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   private double levelRoad(int tile) {
/*     */     Region reg = (Region)(WORLD.REGIONS()).map.get(tile);
/*     */     if (reg != null)
/*     */       return (RD.BUILDINGS()).levelRoad.get(reg); 
/*     */     return 0.0D;
/*     */   }
/*     */   
/*     */   public void renderBridge(WRenContext con, RenderData.RenderIterator it) {
/*     */     if (!this.is.is(it.tile()))
/*     */       return; 
/*     */     if (this.mini.is(it.tile()))
/*     */       return; 
/*     */     if (!(WORLD.WATER()).isBig.is(it.tile()))
/*     */       return; 
/*     */     if (this.bridge.is(it.tile()))
/*     */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*     */         DIR dIR = (DIR)DIR.ORTHO.get(di);
/*     */         if (!(WORLD.WATER()).isBig.is(it.tx(), it.ty(), dIR) && !(WORLD.WATER()).isBig.is(it.tx(), it.ty(), dIR.perpendicular()) && (WORLD.PATH()).map.isOnly(it.tx(), it.ty(), dIR)) {
/*     */           int level = (int)(levelRoad(it.tile()) * 4.0D);
/*     */           (WORLD.BUILDINGS()).sprites.bridge.render(con.r, level + di, it.x(), it.y());
/*     */           return;
/*     */         } 
/*     */       }  
/*     */     if ((WORLD.REGIONS()).cTile.is(it.tile()))
/*     */       return; 
/*     */     int data = this.data.get(it.tile());
/*     */     con.s.setDistance2Ground(0.0D).setHeight(1);
/*     */     DIR d = pDir(data).perpendicular();
/*     */     int x = it.x() - 16;
/*     */     int y = it.y() - 16;
/*     */     int tile = d.orthoID() * 16 + (it.ran() & 0x3);
/*     */     if (Integer.bitCount(data) != 1) {
/*     */       tile += 12;
/*     */     } else {
/*     */       Region r = (Region)(WORLD.REGIONS()).map.get(it.tile());
/*     */       if (r == null)
/*     */         tile += 8; 
/*     */       tile = (int)(tile + 3.0D * (1.0D - (RD.BUILDINGS()).levelRoad.get(r)));
/*     */     } 
/*     */     (WORLD.BUILDINGS()).sprites.harbour.render(con.r, tile, x, y);
/*     */     (WORLD.BUILDINGS()).sprites.harbour.render((SPRITE_RENDERER)con.s, tile, x, y);
/*     */   }
/*     */   
/*     */   private DIR pDir(int data) {
/*     */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*     */       DIR d = (DIR)DIR.ORTHO.get(i);
/*     */       if ((data & d.mask()) != 0)
/*     */         return d; 
/*     */     } 
/*     */     return DIR.N;
/*     */   }
/*     */   
/*     */   public boolean is(int tx, int ty) {
/*     */     if (WORLD.IN_BOUNDS(tx, ty))
/*     */       return is(tx + ty * WORLD.TWIDTH()); 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean is(int tile) {
/*     */     return this.is.is(tile);
/*     */   }
/*     */   
/*     */   public MAP_BOOLEANE set(int tile, boolean value) {
/*     */     int tx = tile % WORLD.TWIDTH();
/*     */     int ty = tile / WORLD.TWIDTH();
/*     */     return set(tx, ty, value);
/*     */   }
/*     */   
/*     */   public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/*     */     if (!WORLD.IN_BOUNDS(tx, ty))
/*     */       return this; 
/*     */     this.bridge.set(tx, ty, false);
/*     */     if (value == is(tx, ty) && !this.mini.is(tx, ty))
/*     */       return this; 
/*     */     this.mini.set(tx, ty, false);
/*     */     this.is.set(tx, ty, value);
/*     */     fix(tx, ty);
/*     */     return this;
/*     */   }
/*     */   
/*     */   private void fix(int tx, int ty) {
/*     */     for (int di = 0; di < DIR.ORTHOC.size(); di++) {
/*     */       DIR d = (DIR)DIR.ORTHOC.get(di);
/*     */       pfix(tx + d.x(), ty + d.y());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void pfix(int tx, int ty) {
/*     */     if (!this.is.is(tx, ty))
/*     */       return; 
/*     */     int m = 0;
/*     */     boolean min = this.mini.is(tx, ty);
/*     */     boolean hack = false;
/*     */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*     */       DIR d = (DIR)DIR.ORTHO.get(i);
/*     */       int dx = d.x() + tx;
/*     */       int dy = d.y() + ty;
/*     */       if (this.is.is(dx, dy))
/*     */         if (min != this.mini.is(dx, dy)) {
/*     */           hack = true;
/*     */         } else {
/*     */           m |= d.mask();
/*     */         }  
/*     */     } 
/*     */     this.data.set(tx + ty * WORLD.TWIDTH(), m);
/*     */     this.miniHack.set(tx, ty, hack);
/*     */   }
/*     */   
/*     */   private boolean hasLand(int tx, int ty) {
/*     */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*     */       DIR d = (DIR)DIR.ORTHO.get(di);
/*     */       if (WORLD.IN_BOUNDS(tx, ty, d) && !(WORLD.WATER()).isBig.is(tx, ty, d))
/*     */         return true; 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\WorldRoads.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */