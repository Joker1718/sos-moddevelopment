/*     */ package world.map.terrain;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.text.Dic;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGround
/*     */   extends WorldTerrain.WorldTerrainResource
/*     */ {
/*  50 */   private final Bitsmap1D rotData = new Bitsmap1D(0, 4, WORLD.TAREA());
/*  51 */   private final Bitsmap1D ids = new Bitsmap1D(0, 4, WORLD.TAREA());
/*     */   
/*     */   private final LIST<WGROUND> all;
/*  54 */   private final COLOR[] seasonColors = new COLOR[64];
/*     */   
/*  56 */   public final WorldGroundSprites sprites = new WorldGroundSprites();
/*     */ 
/*     */   
/*  59 */   public final SPRITE icon = (SPRITE)new SPRITE.Imp(32)
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */       {
/*  63 */         COLOR.WHITE100.render(r, X1 - 1, X2, Y1 - 1, Y2);
/*  64 */         COLOR.BLACK.render(r, X1, X2 + 1, Y1, Y2 + 1);
/*  65 */         ((WorldGround.WGROUND)WorldGround.this.all.get(0)).col.bind();
/*  66 */         WorldGround.this.sprites.sheets[0].render(r, 0, X1, X2, Y1, Y2);
/*  67 */         COLOR.unbind();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final WGROUND PATCHED_GRASS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_DOUBLE moisture;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_OBJECT<WGROUND> getter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<WGROUND> all() {
/* 139 */     return this.all;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {
/* 144 */     this.rotData.save(f);
/* 145 */     this.ids.save(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/* 150 */     this.rotData.load(f);
/* 151 */     this.ids.load(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 156 */     this.ids.setAll(this.all.size() / 2);
/* 157 */     this.rotData.setAll(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderInit(double season) {
/* 162 */     int i = (int)(TIME.years().bitPartOf() * this.seasonColors.length);
/* 163 */     i %= this.seasonColors.length;
/*     */     
/* 165 */     ColorImp.TMP.interpolate(COLOR.WHITE100, this.seasonColors[i], season).bind();
/* 166 */     for (WGROUND g : this.all) {
/* 167 */       g.colImp.set(g.col);
/* 168 */       g.colImp.multiply((COLOR)ColorImp.TMP);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, RenderData.RenderIterator it) {
/* 175 */     WGROUND g = (WGROUND)this.all.get(this.ids.get(it.tile()));
/* 176 */     int d = this.rotData.get(it.tile());
/* 177 */     Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 178 */     if (reg != null) {
/*     */       
/* 180 */       double ii = (RD.DEVASTATION()).current.getD(reg);
/* 181 */       if (ii > 0.25D) {
/* 182 */         g.cdeva[(int)((ii - 0.1D) * g.cdeva.length)].bind();
/* 183 */         int i = (int)((ii - 0.25D) * 2.0D);
/* 184 */         this.sprites.renderNormal(this.sprites.cracked[i], (SPRITE_RENDERER)r, it.x(), it.y(), this.sprites.ran(it.tx(), it.ty()));
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 189 */     TILE_SHEET over = g.over;
/*     */ 
/*     */ 
/*     */     
/* 193 */     if (d == 15) {
/* 194 */       g.colImp.bind();
/* 195 */       this.sprites.renderNormal(over, (SPRITE_RENDERER)r, it.x(), it.y(), this.sprites.ran(it.tx(), it.ty()));
/*     */     } else {
/*     */       
/* 198 */       WGROUND bg = (WGROUND)this.all.get(g.bg);
/* 199 */       bg.colImp.bind();
/* 200 */       this.sprites.renderNormal(bg.over, (SPRITE_RENDERER)r, it.x(), it.y(), this.sprites.ran(it.tx(), it.ty()));
/* 201 */       if (g != bg) {
/* 202 */         g.colImp.bind();
/* 203 */         this.sprites.renderStenciled(over, (SPRITE_RENDERER)r, it.x(), it.y(), d, this.sprites.ran(it.tx(), it.ty()), it.ran());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   WorldGround() throws IOException {
/* 209 */     this.moisture = new MAP_DOUBLE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/* 213 */           if (!WORLD.IN_BOUNDS(tx, ty))
/* 214 */             return 0.5D; 
/* 215 */           return ((WorldGround.WGROUND)WorldGround.this.getter.get(tx, ty)).moisture();
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 220 */           return ((WorldGround.WGROUND)WorldGround.this.getter.get(tile)).moisture();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 297 */     this.getter = new MAP_OBJECT<WGROUND>()
/*     */       {
/*     */         public WorldGround.WGROUND get(int tx, int ty)
/*     */         {
/* 301 */           if (!WORLD.IN_BOUNDS(tx, ty))
/* 302 */             return null; 
/* 303 */           return get(tx + ty * WORLD.TWIDTH());
/*     */         }
/*     */         
/*     */         public WorldGround.WGROUND get(int tile)
/*     */         {
/* 308 */           return (WorldGround.WGROUND)WorldGround.this.all.get(WorldGround.this.ids.get(tile)); } }; int am = 9; int pg = 4; ArrayList<WGROUND> all = new ArrayList(16); Json json = Config.ConfigWorld.json("Ground"); COLOR[] cols = new COLOR[9]; LIST<ColorImp> source = ColorImp.cols(json, "COLOR"); for (int i = 0; i < cols.length; i++) { double d1 = i; d1 /= (cols.length - 1); d1 *= (source.size() - 1); int fi = (int)d1; double inter = d1 - fi; if (fi < source.size() - 1) { cols[i] = (COLOR)(new ColorImp()).interpolate((COLOR)source.get(fi), (COLOR)source.get(fi + 1), inter); }
/*     */       else { cols[i] = (COLOR)source.get(fi); }
/*     */        }
/*     */      ColorImp[] arrayOfColorImp = COLOR.interpolate((COLOR)new ColorImp(json, "COLOR_DEVASTATED_WET"), (COLOR)new ColorImp(json, "COLOR_DEVASTATED_DRY"), 9); for (int j = 0; j < 9; j++) { float f = (float)(1.0D - j / 8.0D); f = (float)Math.pow(f, 2.0D); int bg = (j < 4) ? (j + 1) : (j - 1); if (j == 4)
/*     */         bg = 4;  TILE_SHEET sh = this.sprites.sheets[(this.sprites.sheets.length - 1) * j / 8]; }
/*     */      this.PATCHED_GRASS = (WGROUND)all.get(4); this.all = (LIST<WGROUND>)all; ColorImp winter = new ColorImp(90, 105, 127); for (double d = 0.0D; d < this.seasonColors.length; d++) { ColorImp p = new ColorImp(); double d1 = d / (this.seasonColors.length - 1); if (d1 < 0.5D) { d1 *= 2.0D; }
/*     */       else
/*     */       { d1 = 1.0D - (d1 - 0.5D) * 2.0D; }
/*     */        p.interpolate(COLOR.WHITE100, (COLOR)winter, CLAMP.c(d1 + 0.75D + 0.125D, 1.0D)); this.seasonColors[(int)d] = (COLOR)p; }
/*     */      this.ids.setAll(all.size() / 2);
/*     */   } public void renderStencil(SPRITE_RENDERER r, int x, int y, int tile, int ran) { this.sprites.stencil.render(r, tile + 16 * (ran & 0x3), x, y); } private void set(int tx, int ty, int code, int data) { int t = tx + ty * WORLD.TWIDTH(); this.rotData.set(t, data); this.ids.set(t, code); WORLD.changeTile(tx, ty); } public class WGROUND extends PlacableMulti {
/* 319 */     protected final double moisture; private final ColorImp colImp = new ColorImp(); protected final int code; private final int bg; private final COLOR col;
/*     */     private final COLOR[] cdeva;
/*     */     private final TILE_SHEET over;
/*     */     
/*     */     protected WGROUND(LISTE<WGROUND> all, String name, double moisture, int bg, COLOR col, TILE_SHEET sheet, COLOR deva) {
/* 324 */       super(name);
/* 325 */       this.code = all.add(this);
/* 326 */       this.moisture = moisture;
/* 327 */       this.bg = bg;
/* 328 */       this.col = col;
/* 329 */       this.cdeva = new COLOR[8];
/* 330 */       for (int i = 0; i < this.cdeva.length; i++) {
/* 331 */         this.cdeva[i] = (COLOR)(new ColorImp()).interpolate(col, deva, (i + 1.0D) / this.cdeva.length);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 336 */       this.over = sheet;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean place(int tx, int ty) {
/* 351 */       int res = 0;
/*     */       
/* 353 */       if (this.bg < WorldGround.this.PATCHED_GRASS.code) {
/* 354 */         for (int j = 0; j < DIR.ORTHO.size(); j++) {
/* 355 */           DIR d = (DIR)DIR.ORTHO.get(j);
/* 356 */           if (WORLD.IN_BOUNDS(tx, ty, d)) {
/*     */ 
/*     */             
/* 359 */             WGROUND neigh = (WGROUND)WorldGround.this.getter.get(tx + d.x(), ty + d.y());
/*     */             
/* 361 */             if (neigh.code > this.bg) {
/* 362 */               ((WGROUND)WorldGround.this.all.get(this.bg)).place(tx, ty);
/* 363 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/* 367 */       } else if (this.bg > WorldGround.this.PATCHED_GRASS.code) {
/*     */         
/* 369 */         for (int j = 0; j < DIR.ORTHO.size(); j++) {
/* 370 */           DIR d = (DIR)DIR.ORTHO.get(j);
/* 371 */           if (WORLD.IN_BOUNDS(tx, ty, d)) {
/*     */ 
/*     */             
/* 374 */             WGROUND neigh = (WGROUND)WorldGround.this.getter.get(tx + d.x(), ty + d.y());
/*     */             
/* 376 */             if (neigh.code < this.bg) {
/* 377 */               ((WGROUND)WorldGround.this.all.get(this.bg)).place(tx, ty);
/* 378 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 384 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 385 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 386 */         if (!WORLD.IN_BOUNDS(tx, ty, d)) {
/* 387 */           res |= d.mask();
/*     */         } else {
/*     */           
/* 390 */           WGROUND neigh = (WGROUND)WorldGround.this.getter.get(tx + d.x(), ty + d.y());
/*     */           
/* 392 */           if (neigh.bg == this.code || neigh.code == this.code) {
/* 393 */             res |= d.mask();
/*     */           }
/*     */         } 
/*     */       } 
/* 397 */       WorldGround.this.set(tx, ty, this.code, res);
/*     */       
/* 399 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 404 */       if (!WORLD.IN_BOUNDS(tx, ty))
/*     */         return; 
/* 406 */       WGROUND old = (WGROUND)WorldGround.this.getter.get(tx, ty);
/* 407 */       place(tx, ty);
/* 408 */       if (old != WorldGround.this.getter.get(tx, ty)) {
/* 409 */         for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 410 */           DIR d = (DIR)DIR.ORTHO.get(i);
/* 411 */           if (WORLD.IN_BOUNDS(tx, ty, d)) {
/* 412 */             ((WGROUND)WorldGround.this.getter.get(tx + d.x(), ty + d.y())).place(tx + d.x(), ty + d.y(), area, type);
/*     */           }
/*     */         } 
/*     */       }
/*     */     }
/*     */     
/*     */     final void placeRaw(int tx, int ty) {
/* 419 */       WorldGround.this.set(tx, ty, this.code, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 425 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE getIcon() {
/* 430 */       return (SPRITE)(SPRITES.icons()).m.cancel;
/*     */     }
/*     */     
/*     */     public boolean is(int tx, int ty) {
/* 434 */       return (WORLD.IN_BOUNDS(tx, ty) && this.code == WorldGround.this.ids.get(tx + ty * WORLD.TWIDTH()));
/*     */     }
/*     */ 
/*     */     
/*     */     public double moisture() {
/* 439 */       return this.moisture;
/*     */     }
/*     */     
/*     */     public WGROUND fallback() {
/* 443 */       return WorldGround.this.PATCHED_GRASS;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<PLACABLE> placers(ToolManager tm) {
/* 450 */     ArrayListGrower<PLACABLE> pp = new ArrayListGrower();
/*     */     
/* 452 */     pp.add(new PlacableMulti(Dic.¤¤ground) {
/* 453 */           WorldGround.WGROUND g = (WorldGround.WGROUND)WorldGround.this.all.get(0);
/* 454 */           final LinkedList<CLICKABLE> butts = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 475 */             this.g.place(tx, ty, area, type);
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 480 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public SPRITE getIcon() {
/* 485 */             return WorldGround.this.icon;
/*     */           }
/*     */ 
/*     */           
/*     */           public LIST<CLICKABLE> getAdditionalButt() {
/* 490 */             return (LIST<CLICKABLE>)this.butts;
/*     */           }
/*     */         });
/*     */     
/* 494 */     return (LIST<PLACABLE>)pp;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldGround.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */