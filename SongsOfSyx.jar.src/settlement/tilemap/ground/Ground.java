/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import init.resources.Minable;
/*     */ import init.settings.S;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.TileMap;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ import snake2d.util.map.MAP_OBJECTE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Ground
/*     */   extends TileMap.Resource
/*     */ {
/*  41 */   public static CharSequence ¤¤soilType = "Soil Type";
/*  42 */   public static CharSequence ¤¤moisture = "Moisture";
/*  43 */   public static CharSequence ¤¤moistureB = "Moisture (base)";
/*     */   
/*  45 */   private static CharSequence ¤¤moistureMap = "Moisture Map";
/*  46 */   private static CharSequence ¤¤moistureMApD = "The natural moisture content of the city map.";
/*     */   
/*     */   static {
/*  49 */     D.ts(Ground.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int MOISTURE_MAX = 15;
/*     */   public static final double MOISTURE_MAXI = 0.06666666666666667D;
/*     */   public final GroundTypes types;
/*  56 */   public final ColorImp dry = new ColorImp();
/*  57 */   public final ColorImp wet = new ColorImp();
/*     */   
/*  59 */   final Bitsmap1D mapTypes = new Bitsmap1D(0, 4, SETT.TAREA);
/*  60 */   final Bitsmap1D mapMoistureBase = new Bitsmap1D(0, 4, SETT.TAREA);
/*  61 */   final Bitsmap1D mapMoistureCurrent = new Bitsmap1D(0, 4, SETT.TAREA);
/*  62 */   private final Bitmap1D edge = new Bitmap1D(SETT.TAREA, false);
/*  63 */   public final Minables minerals = new Minables();
/*     */   
/*  65 */   public final DOUBLE.DoubleImp baseMoisture = new DOUBLE.DoubleImp();
/*     */   
/*     */   private double cc;
/*     */   
/*     */   public final MAP_OBJECTE<GroundType> MAP;
/*     */   public final MAP_DOUBLEE MOISTURE_BASE;
/*     */   public final MAP_DOUBLEE MOISTURE_CURRENT;
/*     */   public final MAP_DOUBLE MOISTURE_TOT;
/*     */   public final TileMap.SMinimapGetter minimap;
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/*  76 */     this.mapTypes.save(saveFile);
/*  77 */     this.mapMoistureBase.save(saveFile);
/*  78 */     this.mapMoistureCurrent.save(saveFile);
/*  79 */     this.dry.save(saveFile);
/*  80 */     this.wet.save(saveFile);
/*  81 */     this.minerals.save(saveFile);
/*  82 */     this.baseMoisture.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/*  87 */     this.mapTypes.load(saveFile);
/*  88 */     this.mapMoistureBase.load(saveFile);
/*  89 */     this.mapMoistureCurrent.load(saveFile);
/*  90 */     this.dry.load(saveFile);
/*  91 */     this.wet.load(saveFile);
/*  92 */     this.minerals.load(saveFile);
/*  93 */     this.baseMoisture.load(saveFile);
/*  94 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  95 */       setEdge(c.x(), c.y());
/*     */     }
/*  97 */     setColors((COLOR)this.dry, (COLOR)this.wet, 1.0D);
/*  98 */     this.cc = -1.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearAll() {
/* 104 */     this.mapTypes.clear();
/* 105 */     this.mapMoistureBase.clear();
/* 106 */     this.mapMoistureCurrent.clear();
/* 107 */     this.baseMoisture.setD(0.5D);
/*     */   }
/*     */   public Ground(TileMap m) throws IOException {
/* 110 */     this.cc = -1.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     this.MAP = new MAP_OBJECTE<GroundType>()
/*     */       {
/*     */         public GroundType get(int tile)
/*     */         {
/* 156 */           return Ground.this.types.ALL[Ground.this.mapTypes.get(tile)];
/*     */         }
/*     */ 
/*     */         
/*     */         public GroundType get(int tx, int ty) {
/* 161 */           if (!SETT.IN_BOUNDS(tx, ty))
/* 162 */             return Ground.this.types.NORMAL; 
/* 163 */           return Ground.this.types.ALL[Ground.this.mapTypes.get(tx + ty * SETT.TWIDTH)];
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(int tile, GroundType object) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(int x, int y, GroundType object) {
/* 173 */           if (!SETT.IN_BOUNDS(x, y))
/*     */             return; 
/* 175 */           GroundType old = get(x, y);
/* 176 */           Ground.this.mapTypes.set(x + y * SETT.TWIDTH, object.index);
/* 177 */           if (old != object) {
/* 178 */             Ground.this.update(x, y);
/* 179 */             for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 180 */               DIR d = (DIR)DIR.ORTHO.get(i);
/* 181 */               if (SETT.IN_BOUNDS(x, y, d))
/* 182 */                 Ground.this.update(x + d.x(), y + d.y()); 
/*     */             } 
/* 184 */             SETT.TILE_MAP().miniCUpdate(x, y);
/*     */           } 
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
/* 207 */     this.MOISTURE_BASE = new MAP_DOUBLEE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/* 211 */           if (SETT.IN_BOUNDS(tx, ty))
/* 212 */             return get(tx + ty * SETT.TWIDTH); 
/* 213 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 218 */           return Ground.this.mapMoistureBase.get(tile) * 0.06666666666666667D;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 223 */           if (SETT.IN_BOUNDS(tx, ty))
/* 224 */             set(tx + ty * SETT.TWIDTH, value); 
/* 225 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 230 */           int v = CLAMP.i((int)Math.round(value * 15.0D), 0, 15);
/* 231 */           Ground.this.mapMoistureBase.set(tile, v);
/* 232 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 236 */     this.MOISTURE_CURRENT = new MAP_DOUBLEE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/* 240 */           if (SETT.IN_BOUNDS(tx, ty))
/* 241 */             return get(tx + ty * SETT.TWIDTH); 
/* 242 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 247 */           return Ground.this.mapMoistureCurrent.get(tile) * 0.06666666666666667D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 253 */           if (!SETT.IN_BOUNDS(tx, ty)) {
/* 254 */             return this;
/*     */           }
/* 256 */           int v = CLAMP.i((int)Math.round(value * 15.0D), 0, 15);
/* 257 */           int tile = tx + ty * SETT.TWIDTH;
/* 258 */           int o = Ground.this.mapMoistureCurrent.get(tile);
/* 259 */           if (v != o) {
/* 260 */             Ground.this.mapMoistureCurrent.set(tile, v);
/* 261 */             Ground.this.update(tx, ty);
/* 262 */             for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 263 */               DIR d = (DIR)DIR.ORTHO.get(i);
/* 264 */               if (SETT.IN_BOUNDS(tx, ty, d)) {
/* 265 */                 Ground.this.update(tx + d.x(), ty + d.y());
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 270 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 275 */           return set(tile % SETT.TWIDTH, (tile / SETT.TWIDTH));
/*     */         }
/*     */       };
/*     */     
/* 279 */     this.MOISTURE_TOT = new MAP_DOUBLE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/* 283 */           if (SETT.IN_BOUNDS(tx, ty))
/* 284 */             return get(tx + ty * SETT.TWIDTH); 
/* 285 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 290 */           return Ground.this.MOISTURE_BASE.get(tile) + (SETT.ENV()).map.WATER_SWEET.get(tile) * 2.0D;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 427 */     this.minimap = new TileMap.SMinimapGetter()
/*     */       {
/*     */         public COLOR miniColorPimped(ColorImp origional, int x, int y, boolean northern, boolean southern)
/*     */         {
/* 431 */           if (Ground.this.minerals.getter.is(x, y)) {
/* 432 */             return Ground.this.minerals.miniC(origional, (COLOR)((GroundType)Ground.this.MAP.get(x, y)).miniC, x, y);
/*     */           }
/*     */           
/* 435 */           for (DIR d : DIR.ALL) {
/* 436 */             if ((SETT.TERRAIN()).WATER.is.is(x + d.x(), y + d.y()) || (SETT.TERRAIN()).MOUNTAIN.is(x + d.x(), y + d.y())) {
/* 437 */               origional.shadeSelf(0.75D);
/* 438 */               return (COLOR)origional;
/*     */             } 
/*     */           } 
/* 441 */           if (northern || southern)
/* 442 */             origional.shadeSelf(0.9D); 
/* 443 */           return (COLOR)origional;
/*     */         }
/*     */ 
/*     */         
/*     */         public COLOR miniC(int x, int y) {
/* 448 */           return (COLOR)((GroundType)Ground.this.MAP.get(x, y)).miniC;
/*     */         }
/*     */       };
/*     */     this.types = new GroundTypes();
/*     */     this.baseMoisture.info = new INFO(¤¤moistureMap, ¤¤moistureMApD);
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/*     */     double d = (SETT.WEATHER()).moisture.getD() * 0.4D;
/*     */     if (d != this.cc)
/*     */       setColors((COLOR)this.dry, (COLOR)this.wet, d); 
/*     */   }
/*     */   
/*     */   public void setColors(COLOR dry, COLOR wet, double moist) {
/*     */     this.cc = moist;
/*     */     byte b;
/*     */     int i;
/*     */     GroundType[] arrayOfGroundType;
/*     */     for (i = (arrayOfGroundType = this.types.ALL).length, b = 0; b < i; ) {
/*     */       GroundType t = arrayOfGroundType[b];
/*     */       t.setColors(dry, wet, moist);
/*     */       b++;
/*     */     } 
/*     */     this.dry.set(dry);
/*     */     this.wet.set(wet);
/*     */   }
/*     */   
/*     */   public void adjust(int tile, int tx, int ty) {
/*     */     int f = this.mapMoistureCurrent.get(tile);
/*     */     int n = (int)(this.mapMoistureBase.get(tile) + (SETT.ENV()).map.WATER_SWEET.get(tile) * 15.0D);
/*     */     n = CLAMP.i(n, 0, 15);
/*     */     if (f != n) {
/*     */       if (f < n) {
/*     */         f++;
/*     */       } else {
/*     */         f--;
/*     */       } 
/*     */       this.mapMoistureCurrent.set(tile, f);
/*     */       update(tx, ty);
/*     */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*     */         DIR d = (DIR)DIR.ORTHO.get(i);
/*     */         if (SETT.IN_BOUNDS(tx, ty, d))
/*     */           update(tx + d.x(), ty + d.y()); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void init() {
/*     */     (SETT.ENV()).map.initWater();
/*     */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*     */       int tile = c.x() + c.y() * SETT.TWIDTH;
/*     */       int n = (int)(this.mapMoistureBase.get(tile) + (SETT.ENV()).map.WATER_SWEET.get(tile) * 15.0D);
/*     */       n = CLAMP.i(n, 0, 15);
/*     */       this.mapMoistureCurrent.set(tile, n);
/*     */     } 
/*     */     for (COORDINATE c : SETT.TILE_BOUNDS)
/*     */       setEdge(c.x(), c.y()); 
/*     */   }
/*     */   
/*     */   private void setEdge(int tx, int ty) {
/*     */     GroundType g = (GroundType)this.MAP.get(tx, ty);
/*     */     int m = this.mapMoistureCurrent.get(tx + ty * SETT.TWIDTH);
/*     */     boolean set = false;
/*     */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*     */       int x = tx + ((DIR)DIR.ORTHO.get(di)).x();
/*     */       int y = ty + ((DIR)DIR.ORTHO.get(di)).y();
/*     */       if (joins(g, m, x, y)) {
/*     */         set = true;
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     this.edge.set(tx + ty * SETT.TWIDTH, set);
/*     */   }
/*     */   
/*     */   private boolean joins(GroundType g, int m, int x, int y) {
/*     */     if (SETT.IN_BOUNDS(x, y)) {
/*     */       int i2 = ((GroundType)this.MAP.get(x, y)).index;
/*     */       if (g.index < i2)
/*     */         return true; 
/*     */       return (g.index == i2 && m < this.mapMoistureCurrent.get(x + y * SETT.TWIDTH));
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private void update(int tx, int ty) {
/*     */     setEdge(tx, ty);
/*     */     SETT.TILE_MAP().miniCUpdate(tx, ty);
/*     */   }
/*     */   
/*     */   void render(Renderer r, RenderData.RenderIterator it) {
/*     */     int tile = it.tile();
/*     */     int ran = it.ran();
/*     */     int x = it.x();
/*     */     int y = it.y();
/*     */     GroundType g = (GroundType)this.MAP.get(tile);
/*     */     int m = this.mapMoistureCurrent.get(tile);
/*     */     g.tmps[m].bind();
/*     */     g.sheet.render((SPRITE_RENDERER)r, ran & 0x3F, x, y);
/*     */     if (this.edge.get(it.tile()))
/*     */       for (int di = 0; di < 4; di++) {
/*     */         DIR d = (DIR)DIR.ORTHO.get(di);
/*     */         int dx = it.tx() + d.x();
/*     */         int dy = it.ty() + d.y();
/*     */         if (SETT.IN_BOUNDS(dx, dy)) {
/*     */           GroundType g2 = (GroundType)this.MAP.get(dx, dy);
/*     */           int m2 = this.mapMoistureCurrent.get(dx + dy * SETT.TWIDTH);
/*     */           if (g.index < g2.index || (g.index == g2.index && m < m2)) {
/*     */             g2.tmps[m2].bind();
/*     */             ran >>= 4;
/*     */             DIR d2 = d.next(2);
/*     */             int t = it.tile() + d2.x() + d2.y() * SETT.TWIDTH;
/*     */             if (SETT.IN_BOUNDS(it.tx(), it.ty(), d2) && g2.index == this.mapTypes.get(t) && m2 == this.mapMoistureCurrent.get(t)) {
/*     */               this.types.c_masks.renderTextured(g2.sheet.getTexture(ran & 0x3F), 8 * d.orthoID() + (ran & 0x7), x, y);
/*     */             } else {
/*     */               this.types.s_masks.renderTextured(g2.sheet.getTexture(ran & 0x3F), 8 * d.orthoID() + (ran & 0x7), x, y);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }  
/*     */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   public void render(Renderer r, float ds, ShadowBatch s, RenderData data) {
/*     */     RenderData.RenderIterator i = data.onScreenTiles();
/*     */     while (i.has()) {
/*     */       render(r, i);
/*     */       this.minerals.render(r, i.tile(), i.ran(), i.x(), i.y());
/*     */       i.next();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMinerals(Renderer r, int tile, int ran, int x, int y) {
/*     */     this.minerals.render(r, tile, ran, x, y);
/*     */   }
/*     */   
/*     */   public TextureCoords getTexture(int tile, int ran) {
/*     */     return ((GroundType)this.MAP.get(tile)).sheet.getTexture(ran & 0xF);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, int tx, int ty) {
/*     */     GBox b = (GBox)box;
/*     */     b.textLL((CharSequence)Str.TMP.clear().add(¤¤soilType).add(':'));
/*     */     b.textL((CharSequence)b.text().add(((GroundType)this.MAP.get(tx, ty)).name));
/*     */     b.NL();
/*     */     b.text((CharSequence)b.text().add(((GroundType)this.MAP.get(tx, ty)).desc));
/*     */     b.NL(6);
/*     */     b.textLL(¤¤moisture);
/*     */     b.tab(6);
/*     */     b.add((SPRITE)GFORMAT.perc(b.text(), this.MOISTURE_TOT.get(tx, ty)));
/*     */     b.NL();
/*     */     b.textLL(¤¤moistureB);
/*     */     b.tab(6);
/*     */     b.add((SPRITE)GFORMAT.perc(b.text(), this.MOISTURE_BASE.get(tx, ty)));
/*     */     b.NL();
/*     */     if ((S.get()).developer) {
/*     */       b.textLL(Dic.¤¤High);
/*     */       b.tab(6);
/*     */       b.add((SPRITE)GFORMAT.perc(b.text(), this.MOISTURE_CURRENT.get(tx, ty)));
/*     */       b.sep();
/*     */     } 
/*     */     if (this.minerals.getter.is(tx, ty)) {
/*     */       b.add((SPRITE)((Minable)(SETT.MINERALS()).getter.get(tx, ty)).resource.icon());
/*     */       b.textLL(((Minable)(SETT.MINERALS()).getter.get(tx, ty)).name);
/*     */       b.tab(6);
/*     */       b.add((SPRITE)GFORMAT.percInc(b.text(), -0.1D + 0.2D * (SETT.MINERALS()).value.get(tx, ty)));
/*     */       b.sep();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Ground.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */