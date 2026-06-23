/*     */ package world.map.regions;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.regions.centre.WorldCentrePlacablity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RegionInfo
/*     */ {
/*  31 */   private static int[] countTerrain = Alloc.ii(TERRAINS.ALL().size());
/*     */ 
/*     */   
/*  34 */   private static double bi = 0.00392156862745098D;
/*     */   
/*     */   public static final int nameSize = 24;
/*  37 */   private final Str name = new Str(24);
/*     */   private int area;
/*  39 */   private final Rec bounds = new Rec();
/*     */   
/*     */   private short cx;
/*  42 */   private final byte[] climateTerrMin = Alloc.bb(1 + TERRAINS.ALL().size()); private short cy;
/*     */   private byte fertility;
/*     */   private static Averages ave;
/*     */   
/*     */   public RegionInfo() {
/*  47 */     ave = null;
/*  48 */     clear();
/*     */   }
/*     */   
/*     */   void save(FilePutter f) {
/*  52 */     this.name.save(f);
/*  53 */     f.s(this.cx).s(this.cy);
/*  54 */     this.bounds.save(f);
/*  55 */     f.i(this.area);
/*  56 */     f.b(this.fertility);
/*  57 */     f.bs(this.climateTerrMin);
/*     */   }
/*     */   
/*     */   void load(FileGetter f) throws IOException {
/*  61 */     this.name.load(f);
/*  62 */     this.cx = f.s();
/*  63 */     this.cy = f.s();
/*  64 */     this.bounds.load(f);
/*  65 */     this.area = f.i();
/*  66 */     this.fertility = f.b();
/*  67 */     f.bs(this.climateTerrMin);
/*  68 */     ave = null;
/*     */   }
/*     */   
/*     */   void clear() {
/*  72 */     this.name.clear();
/*  73 */     this.cx = -1;
/*  74 */     this.cy = -1;
/*  75 */     this.bounds.clear();
/*  76 */     this.area = 0;
/*  77 */     this.fertility = 0;
/*  78 */     Arrays.fill(this.climateTerrMin, (byte)0);
/*  79 */     ave = null;
/*     */   }
/*     */   
/*     */   public Str name() {
/*  83 */     return this.name;
/*     */   }
/*     */   
/*     */   public int cx() {
/*  87 */     return this.cx;
/*     */   }
/*     */   
/*     */   public int cy() {
/*  91 */     return this.cy;
/*     */   }
/*     */   
/*     */   void centreSet(int tx, int ty) {
/*  95 */     this.cx = (short)tx;
/*  96 */     this.cy = (short)ty;
/*  97 */     (WORLD.REGIONS()).dirty = true;
/*     */   }
/*     */   
/*     */   public int area() {
/* 101 */     return this.area;
/*     */   }
/*     */   
/*     */   public RECTANGLE bounds() {
/* 105 */     return (RECTANGLE)this.bounds;
/*     */   }
/*     */   
/*     */   public double moisture() {
/* 109 */     return (this.fertility & 0xFF) * bi;
/*     */   }
/*     */   
/*     */   public double climate(CLIMATE c) {
/* 113 */     double ci = climateI();
/*     */     
/* 115 */     if ((int)ci == c.index())
/* 116 */       return 1.0D - ci - (int)ci; 
/* 117 */     if ((int)ci == c.index() - 1)
/* 118 */       return ci - (int)ci; 
/* 119 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public double climateI() {
/* 123 */     return ((CLIMATES.ALL().size() - 1) * (this.climateTerrMin[0] & 0xFF)) * bi;
/*     */   }
/*     */   
/*     */   public double terrain(TERRAIN c) {
/* 127 */     return (this.climateTerrMin[1 + c.index()] & 0xFF) * bi;
/*     */   }
/*     */   
/*     */   public boolean init(int sx, int sy, RECTANGLE body) {
/* 131 */     ave = null;
/* 132 */     (WORLD.REGIONS()).dirty = true;
/* 133 */     double climate = 0.0D;
/* 134 */     Arrays.fill(countTerrain, 0);
/*     */     
/* 136 */     double fertility = 0.0D;
/*     */     
/* 138 */     if (((Region)(WORLD.REGIONS()).map.get(sx, sy)).info != this) {
/* 139 */       throw new RuntimeException();
/*     */     }
/* 141 */     Region a = (Region)(WORLD.REGIONS()).map.get(sx, sy);
/*     */     
/* 143 */     this.bounds.moveX1Y1(sx, sy).setDim(1.0D);
/* 144 */     this.area = 0;
/*     */     
/* 146 */     for (COORDINATE c : body) {
/* 147 */       if (!(WORLD.REGIONS()).map.is(c, a)) {
/*     */         continue;
/*     */       }
/* 150 */       climate += ((CLIMATE)(WORLD.CLIMATE()).getter.get(c)).index();
/* 151 */       countTerrain[((TERRAIN)TERRAINS.world.get(c)).index()] = countTerrain[((TERRAIN)TERRAINS.world.get(c)).index()] + 1;
/* 152 */       fertility += WORLD.MOISTURE().get(c.x(), c.y());
/* 153 */       this.area++;
/* 154 */       this.bounds.unify(c.x(), c.y());
/*     */     } 
/*     */     
/* 157 */     Rec tmp = new Rec((RECTANGLE)this.bounds);
/* 158 */     tmp.incr(-1.0D, -1.0D).incrW(2.0D).incrH(2.0D);
/*     */ 
/*     */     
/* 161 */     GUTIL.flooder().init(this);
/* 162 */     for (COORDINATE c : tmp) {
/* 163 */       if (!(WORLD.REGIONS()).map.is(c, a)) {
/* 164 */         GUTIL.flooder().pushSloppy(c.x(), c.y(), 0.0D);
/*     */       }
/*     */     } 
/*     */     
/* 168 */     PathTile centre = null;
/* 169 */     PathTile backup = null;
/* 170 */     while (GUTIL.flooder().hasMore()) {
/* 171 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/* 173 */       if ((WORLD.REGIONS()).map.is((COORDINATE)t, a)) {
/* 174 */         if (WorldCentrePlacablity.regionC(t.x(), t.y()) == null) {
/* 175 */           centre = t; break;
/*     */         } 
/* 177 */         if (WorldCentrePlacablity.regionMiniC(t.x(), t.y()) == null) {
/* 178 */           for (int y = t.y() - 1; y < t.y() + 3; y++) {
/* 179 */             for (int x = t.x() - 1; x < t.x() + 3; x++)
/*     */             {
/* 181 */               backup = t;
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 187 */       for (DIR d : DIR.ALL) {
/* 188 */         if ((WORLD.REGIONS()).map.is((COORDINATE)t, d, a))
/* 189 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance()); 
/*     */       } 
/*     */     } 
/* 192 */     GUTIL.flooder().done();
/*     */     
/* 194 */     if (centre == null) {
/* 195 */       centre = backup;
/* 196 */       if (backup == null || !(WORLD.REGIONS()).player.is((COORDINATE)backup)) {
/* 197 */         return false;
/*     */       }
/*     */     } 
/* 200 */     if ((WORLD.REGIONS()).map.get(this.cx, this.cy) != a || WorldCentrePlacablity.regionC(this.cx, this.cy) != null) {
/* 201 */       centreSet(centre.x(), centre.y());
/*     */     }
/*     */     
/* 204 */     climate /= (this.area * (CLIMATES.ALL().size() - 1));
/* 205 */     climate = CLAMP.d(climate, 0.0D, 1.0D);
/* 206 */     this.climateTerrMin[0] = (byte)(int)(255.0D * climate);
/*     */     
/* 208 */     for (int i = 0; i < countTerrain.length; i++) {
/* 209 */       this.climateTerrMin[1 + i] = (byte)(int)(255.0D * countTerrain[i] / this.area);
/*     */     }
/* 211 */     this.fertility = (byte)(int)(255.0D * fertility / this.area);
/* 212 */     Arrays.fill(countTerrain, 0);
/* 213 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RegValue vFer() {
/* 218 */     if (ave == null)
/* 219 */       ave = new Averages(); 
/* 220 */     return ave.fertility;
/*     */   }
/*     */   
/*     */   public static RegValue vArea() {
/* 224 */     if (ave == null)
/* 225 */       ave = new Averages(); 
/* 226 */     return ave.area;
/*     */   }
/*     */   
/*     */   public static RegValue vTerrain(TERRAIN t) {
/* 230 */     if (ave == null)
/* 231 */       ave = new Averages(); 
/* 232 */     return ave.terrains[t.index()];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class Averages
/*     */   {
/* 239 */     public final RegionInfo.RegValue[] terrains = new RegionInfo.RegValue[TERRAINS.ALL().size()];
/*     */     public final RegionInfo.RegValue fertility;
/*     */     public final RegionInfo.RegValue area;
/*     */     private static boolean log = false;
/*     */     
/*     */     Averages() {
/* 245 */       RegionInfo.ave = this;
/* 246 */       if (log) {
/* 247 */         GAME.Notify("here");
/*     */       }
/* 249 */       this.fertility = new RegionInfo.RegValue()
/*     */         {
/*     */           public double rawAI(Region reg)
/*     */           {
/* 253 */             double f = 0.1D + reg.info.moisture();
/* 254 */             double a = reg.info.area;
/* 255 */             return f * f * a;
/*     */           }
/*     */ 
/*     */           
/*     */           public double raw(Region reg) {
/* 260 */             return reg.info.moisture();
/*     */           }
/*     */         };
/*     */       
/* 264 */       log(this.fertility, "fertility");
/*     */ 
/*     */ 
/*     */       
/* 268 */       this.area = new RegionInfo.RegValue()
/*     */         {
/*     */           public double rawAI(Region reg)
/*     */           {
/* 272 */             double f = 0.1D + reg.info.moisture();
/* 273 */             double a = reg.info.area;
/* 274 */             return f * a * a;
/*     */           }
/*     */ 
/*     */           
/*     */           public double raw(Region reg) {
/* 279 */             return reg.info.area;
/*     */           }
/*     */         };
/*     */       
/* 283 */       log(this.area, "area");
/*     */ 
/*     */       
/* 286 */       for (int i = 0; i < TERRAINS.ALL().size(); i++) {
/* 287 */         final TERRAIN t = (TERRAIN)TERRAINS.ALL().get(i);
/* 288 */         this.terrains[i] = new RegionInfo.RegValue()
/*     */           {
/*     */             public double rawAI(Region reg)
/*     */             {
/* 292 */               double f = 0.25D + reg.info.moisture();
/* 293 */               return (0.5D + reg.info.terrain(t)) * reg.info.area * f;
/*     */             }
/*     */ 
/*     */             
/*     */             public double raw(Region reg) {
/* 298 */               return reg.info.terrain(t);
/*     */             }
/*     */           };
/*     */         
/* 302 */         log(this.terrains[i], "t " + t.key);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void log(RegionInfo.RegValue trans, String name) {
/* 307 */       if (!log)
/*     */         return; 
/* 309 */       LOG.ln(name);
/* 310 */       double ave = 0.0D;
/* 311 */       double ma = 0.0D;
/* 312 */       double mi = 1.0D;
/* 313 */       double mv = 0.0D;
/* 314 */       double miv = Double.MAX_VALUE;
/*     */       int ri;
/* 316 */       for (ri = 0; ri < WORLD.REGIONS().active().size(); ri++) {
/* 317 */         Region reg = (Region)WORLD.REGIONS().active().get(ri);
/* 318 */         double d = trans.getAi(reg);
/* 319 */         ave += d;
/* 320 */         ma = Math.max(d, ma);
/* 321 */         mi = Math.min(d, mi);
/* 322 */         mv = Math.max(mv, trans.rawAI(reg));
/* 323 */         miv = Math.min(miv, trans.rawAI(reg));
/*     */       } 
/* 325 */       ave /= WORLD.REGIONS().active().size();
/* 326 */       LOG.ln("AVE: " + (int)(100.0D * ave));
/* 327 */       LOG.ln("MIN: " + (int)(100.0D * mi));
/* 328 */       LOG.ln("MAX: " + (int)(100.0D * ma));
/* 329 */       LOG.ln("VVV: " + trans.getAi(miv) + " -> " + trans.getAi(mv));
/*     */       
/* 331 */       ave = 0.0D;
/* 332 */       ma = 0.0D;
/* 333 */       mi = 1.0D;
/* 334 */       mv = 0.0D;
/* 335 */       for (ri = 0; ri < WORLD.REGIONS().active().size(); ri++) {
/* 336 */         Region reg = (Region)WORLD.REGIONS().active().get(ri);
/* 337 */         double d = trans.get(reg);
/* 338 */         ave += d;
/* 339 */         ma = Math.max(d, ma);
/* 340 */         mi = Math.min(d, mi);
/* 341 */         mv = Math.max(mv, trans.raw(reg));
/*     */       } 
/* 343 */       ave /= WORLD.REGIONS().active().size();
/*     */       
/* 345 */       LOG.ln("AVE: " + (int)(100.0D * ave));
/* 346 */       LOG.ln("MIN: " + (int)(100.0D * mi));
/* 347 */       LOG.ln("MAX: " + (int)(100.0D * ma));
/* 348 */       LOG.ln("VVV: " + trans.get(mi) + " -> " + trans.get(ma));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class RegValue
/*     */   {
/*     */     public final double weight;
/*     */     
/*     */     public final double ave;
/*     */     public final double aveAI;
/*     */     public final double max;
/*     */     
/*     */     public RegValue() {
/* 362 */       double ave = 0.0D;
/* 363 */       double aveAI = 0.0D;
/* 364 */       double ma = 0.0D;
/*     */       
/* 366 */       for (int ri = 0; ri < WORLD.REGIONS().active().size(); ri++) {
/* 367 */         Region reg = (Region)WORLD.REGIONS().active().get(ri);
/* 368 */         double v = raw(reg);
/* 369 */         ave += v;
/* 370 */         aveAI += rawAI(reg);
/* 371 */         ma = Math.max(v, ma);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 376 */       this.ave = ave / WORLD.REGIONS().active().size();
/* 377 */       this.aveAI = aveAI / WORLD.REGIONS().active().size();
/* 378 */       this.max = ma;
/* 379 */       if (RegionInfo.Averages.log) {
/* 380 */         LOG.ln("" + this.ave + " " + this.ave);
/*     */       }
/* 382 */       double w = 1.0D - this.ave / this.max;
/* 383 */       this.weight = 1.0D / w;
/*     */     }
/*     */     
/*     */     public abstract double raw(Region param1Region);
/*     */     
/*     */     public abstract double rawAI(Region param1Region);
/*     */     
/*     */     public double getAi(double v) {
/* 391 */       return v / this.aveAI;
/*     */     }
/*     */     
/*     */     public double getAi(Region reg) {
/* 395 */       return getAi(rawAI(reg));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double get(double v) {
/* 404 */       return CLAMP.d(Math.sqrt(v / this.max), 0.0D, 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(Region reg) {
/* 409 */       return get(raw(reg));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\RegionInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */