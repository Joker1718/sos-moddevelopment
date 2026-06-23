/*     */ package world.map.terrain;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldForest
/*     */   extends WorldTerrain.WorldTerrainResource
/*     */ {
/*  54 */   private final Bitsmap1D data = new Bitsmap1D(0, 4, WORLD.TAREA());
/*     */   
/*     */   private static final int SET = 16;
/*     */   
/*     */   private static final int max = 3;
/*     */   
/*     */   private static final int colorA = 64;
/*     */   
/*     */   public final SPRITE icon;
/*  63 */   private final Sprites sprites = new Sprites();
/*     */   
/*     */   public final MAP_DOUBLEE amount;
/*     */   
/*     */   public final MAP_BOOLEAN is;
/*     */   
/*     */   public final MAP_BOOLEAN placable;
/*     */   
/*     */   private int[] cols;
/*     */ 
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/*     */     this.data.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/*     */     this.data.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   WorldForest(WORLD m) throws IOException {
/*  85 */     this.amount = new MAP_DOUBLEE()
/*     */       {
/*  87 */         private final double amI = 0.3333333333333333D;
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/*  91 */           return WorldForest.this.data.get(tile) * 0.3333333333333333D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tx, int ty) {
/*  96 */           if (WORLD.IN_BOUNDS(tx, ty))
/*  97 */             return get(tx + ty * WORLD.TWIDTH()); 
/*  98 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 103 */           WorldForest.this.data.set(tile, CLAMP.i((int)Math.ceil(value * 3.0D), 0, 3));
/* 104 */           WORLD.changeTile(tile % WORLD.TWIDTH(), tile / WORLD.TWIDTH());
/* 105 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 110 */           if (WORLD.IN_BOUNDS(tx, ty))
/* 111 */             set(tx + ty * WORLD.TWIDTH(), value); 
/* 112 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 116 */     this.is = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty) {
/* 119 */           return (WorldForest.this.amount.get(tx, ty) > 0.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 124 */           return (WorldForest.this.amount.get(tile) > 0.0D);
/*     */         }
/*     */       };
/*     */     
/* 128 */     this.placable = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 132 */           if (!WORLD.IN_BOUNDS(tx, ty)) {
/* 133 */             return false;
/*     */           }
/* 135 */           if ((WORLD.WATER()).coversTile.is(tx, ty))
/* 136 */             return false; 
/* 137 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 142 */           return is(tile % WORLD.TWIDTH(), tile / WORLD.TWIDTH());
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
/* 166 */     this.cols = Alloc.ii(3); this.icon = (SPRITE)new SPRITE.Imp(32) { public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { int t = 32; COLOR.WHITE100.bind(); WorldForest.this.sprites.bg.render(r, t, X1 - 1, X2 - 1, Y1 - 1, Y2 - 1);
/*     */           COLOR.BLACK.bind();
/*     */           WorldForest.this.sprites.bg.render(r, t, X1 + 1, X2 + 1, Y1 + 1, Y2 + 1);
/*     */           WorldForest.this.sprites.colors[0][0].bind();
/*     */           WorldForest.this.sprites.bg.render(r, t, X1, X2, Y1, Y2);
/*     */           WorldForest.this.sprites.sheet.render(r, t, X1, X2, Y1, Y2);
/*     */           COLOR.unbind(); } };
/* 173 */   } public void render(SPRITE_RENDERER r, ShadowBatch s, RenderData data) { for (CLIMATE z : CLIMATES.ALL()) {
/* 174 */       this.cols[z.index()] = (int)(48.0D + z.getPartOfYear() * 64.0D) % 64;
/*     */     }
/*     */     
/* 177 */     int off = 16;
/* 178 */     int rMask = 63;
/*     */     
/* 180 */     RenderData.RenderIterator it = data.onScreenTiles(1, 1, 1, 0);
/* 181 */     s.setHeight(4);
/* 182 */     s.setDistance2Ground(0.0D);
/* 183 */     s.setSoft();
/* 184 */     while (it.has()) {
/* 185 */       int t = this.data.get(it.tile());
/* 186 */       if ((WORLD.REGIONS()).isCentre.is(it.tx(), it.ty())) {
/* 187 */         it.next();
/*     */         
/*     */         continue;
/*     */       } 
/* 191 */       if (t != 0) {
/*     */         
/* 193 */         int x = it.x() - off;
/* 194 */         int y = it.y() - off;
/*     */ 
/*     */         
/* 197 */         t--;
/*     */         
/* 199 */         if (WORLD.ROADS().is(it.tile()) && !(WORLD.ROADS()).minified.is(it.tile())) {
/* 200 */           t = CLAMP.i(t / (2 + (it.ran() & 0x3)), 0, 8);
/* 201 */           DIR d = (DIR)DIR.NORTHO.get(it.ran() >> 8 & 0x3);
/* 202 */           x += d.x() * 32;
/* 203 */           y += d.y() * 32;
/*     */         } 
/*     */         
/* 206 */         t *= 16;
/* 207 */         t += it.ran() & 0xF;
/*     */         
/* 209 */         this.sprites.colors[this.cols[((CLIMATE)(WORLD.CLIMATE()).getter.get(it.tile())).index()]][it.ran() & rMask].bind();
/*     */         
/* 211 */         this.sprites.sheet.render(r, t, x, y);
/*     */       } 
/*     */       
/* 214 */       it.next();
/*     */     } 
/*     */     
/* 217 */     CORE.renderer().newLayer(true, CORE.renderer().getZoomout());
/*     */     
/* 219 */     it = data.onScreenTiles(2, 2, 2, 0);
/* 220 */     while (it.has()) {
/* 221 */       int t = this.data.get(it.tile());
/* 222 */       if ((WORLD.REGIONS()).isCentre.is(it.tx(), it.ty())) {
/* 223 */         it.next();
/*     */         
/*     */         continue;
/*     */       } 
/* 227 */       if (t != 0) {
/*     */         
/* 229 */         int x = it.x() - off;
/* 230 */         int y = it.y() - off;
/*     */ 
/*     */         
/* 233 */         t--;
/*     */         
/* 235 */         if (WORLD.ROADS().is(it.tile()) && !(WORLD.ROADS()).minified.is(it.tile())) {
/* 236 */           t = CLAMP.i(t / (2 + (it.ran() & 0x3)), 0, 8);
/* 237 */           DIR d = (DIR)DIR.NORTHO.get(it.ran() >> 8 & 0x3);
/* 238 */           x += d.x() * 32;
/* 239 */           y += d.y() * 32;
/* 240 */         } else if (t >= 3) {
/* 241 */           it.hiddenSet();
/*     */         } 
/* 243 */         t *= 16;
/* 244 */         t += it.ran() & 0xF;
/*     */         
/* 246 */         this.sprites.colors[this.cols[((CLIMATE)(WORLD.CLIMATE()).getter.get(it.tile())).index()]][it.ran() & rMask].bind();
/*     */         
/* 248 */         this.sprites.bg.render(r, t, x, y);
/* 249 */         this.sprites.bg.render((SPRITE_RENDERER)s, t, x, y);
/*     */       } 
/*     */       
/* 252 */       it.next();
/*     */     } 
/*     */     
/* 255 */     COLOR.unbind(); }
/*     */    protected void clear() {
/*     */     this.data.setAll(0);
/*     */   } protected void update(double ds, Profiler prof) {}
/*     */   double add(WorldTerrainInfo info, int tx, int ty) {
/* 260 */     info.add(TERRAINS.FOREST(), this.amount.get(tx, ty));
/* 261 */     return this.amount.get(tx, ty);
/*     */   }
/*     */   
/*     */   private static class Sprites
/*     */   {
/*     */     private static final int colorA = 64;
/* 267 */     private final COLOR[][] colors = new COLOR[64][64];
/*     */     
/* 269 */     public final TILE_SHEET bg = (new ComposerThings.ITileSheet(PATHS.SPRITE_WORLD_MAP().get("Forest"), 972, 280)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 272 */           ComposerDests.Tile t = d.s24;
/* 273 */           s.singles.init(0, 0, 1, 1, 16, 6, (ComposerDests.Dest)t);
/* 274 */           for (int i = 0; i < 3; i++)
/* 275 */             s.singles.setSkip(i * 16, 16).paste(true); 
/* 276 */           return t.saveGame();
/*     */         }
/* 279 */       }).get();
/*     */     
/* 281 */     public final TILE_SHEET sheet = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 284 */           ComposerDests.Tile t = d.s24;
/* 285 */           for (int i = 0; i < 3; i++)
/* 286 */             s.singles.setSkip((i + 3) * 16, 16).paste(true); 
/* 287 */           return t.saveGame();
/*     */         }
/* 290 */       }).get();
/*     */ 
/*     */     
/*     */     Sprites() throws IOException {
/* 294 */       ColorImp wa = new ColorImp();
/* 295 */       ColorImp wb = new ColorImp();
/*     */       
/* 297 */       int seasons = 4;
/* 298 */       double stepsPerSeason = 16.0D;
/*     */       
/* 300 */       int randoms = 4;
/* 301 */       double stepsPerRandom = 16.0D;
/* 302 */       LIST<COLOR> cols = (new ComposerThings.IColorSampler()
/*     */         {
/*     */           protected COLOR next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 306 */             return s.singles.setSkip(i, 1).sample();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 311 */             s.singles.init(0, s.singles.body().y2(), 1, 1, 4, 4, (ComposerDests.Dest)d.s16);
/* 312 */             return 16;
/*     */           }
/* 314 */         }).getHalf();
/* 315 */       for (double y = 0.0D; y < 64.0D; y++) {
/*     */         
/* 317 */         int seasonFrom = (int)Math.floor(y / 16.0D);
/* 318 */         int seasonTo = (int)Math.ceil(y / 16.0D);
/* 319 */         seasonTo %= 4;
/* 320 */         double seasonDelta = (y - seasonFrom * 16.0D) / 16.0D;
/* 321 */         for (double r = 0.0D; r < 64.0D; r++) {
/* 322 */           int ranFrom = (int)Math.floor(r / 16.0D);
/* 323 */           int ranTo = (int)Math.ceil(r / 16.0D);
/* 324 */           ranTo %= 4;
/* 325 */           double ranDelta = (r - ranFrom * 16.0D) / 16.0D;
/*     */           
/* 327 */           wa.interpolate((COLOR)cols.get(seasonFrom * 4 + ranFrom), (COLOR)cols.get(seasonFrom * 4 + ranTo), 
/* 328 */               ranDelta);
/* 329 */           wb.interpolate((COLOR)cols.get(seasonTo * 4 + ranFrom), (COLOR)cols.get(seasonTo * 4 + ranTo), 
/* 330 */               ranDelta);
/* 331 */           ColorImp res = new ColorImp();
/* 332 */           res.interpolate((COLOR)wa, (COLOR)wb, seasonDelta);
/* 333 */           this.colors[(int)y][(int)r] = (COLOR)res;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<PLACABLE> placers(ToolManager tm) {
/* 342 */     ArrayListGrower<PLACABLE> placers = new ArrayListGrower();
/*     */     
/* 344 */     final PlacableMulti CLEAR = new PlacableMulti("clear forest", "", this.icon.twin((SPRITE)(UI.icons()).m.anti, DIR.C, 0))
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 348 */           WorldForest.this.amount.set(tx, ty, 0.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 353 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 357 */     placers.add(new PlacableMulti("forest")
/*     */         {
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/* 361 */             return WorldForest.this.placable.is(tx, ty) ? null : "";
/*     */           }
/*     */ 
/*     */           
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 366 */             int i = tx + ty * WORLD.TWIDTH();
/* 367 */             WorldForest.this.data.set(i, CLAMP.i(WorldForest.this.data.get(i) + 1, 0, 3));
/*     */           }
/*     */ 
/*     */           
/*     */           public PLACABLE getUndo() {
/* 372 */             return CLEAR;
/*     */           }
/*     */ 
/*     */           
/*     */           public SPRITE getIcon() {
/* 377 */             return WorldForest.this.icon;
/*     */           }
/*     */         });
/*     */     
/* 381 */     placers.add(placableMulti);
/*     */     
/* 383 */     return (LIST<PLACABLE>)placers;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldForest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */