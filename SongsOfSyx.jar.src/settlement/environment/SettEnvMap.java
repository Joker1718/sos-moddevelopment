/*     */ package settlement.environment;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BoostSpecs;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.race.bio.Opinion;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.AvailabilityListener;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Errors;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.QueueInteger;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SettEnvMap
/*     */ {
/*     */   public final SettEnv NOISE;
/*     */   public final SettEnv LIGHT;
/*     */   public final SettEnv SPACE;
/*     */   public final SettEnv WATER_SWEET;
/*     */   public final SettEnv WATER_SALT;
/*     */   public final SettEnv URBAN;
/*     */   public final SettEnv GUARD;
/*     */   public final SettEnv PUNISHMENT;
/*     */   public final SettEnvShape SHAPE;
/*     */   public final SettEnvMonument MONUMENT;
/*     */   public final RMAP<SettEnv> rmap;
/*     */   private final ArrayList<SettEnv> all;
/*  65 */   private final ArrayListGrower<Updatable> ups = new ArrayListGrower();
/*     */   
/*  67 */   private final Chunks chunks = new Chunks();
/*  68 */   private final Updater updater = new Updater();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RADIUS = 16;
/*     */ 
/*     */ 
/*     */   
/*     */   static final double maxRadiusI = 0.0625D;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SettEnvMap() throws IOException {
/*  83 */     PATH jp = PATHS.INIT().getFolder("settlement").getFolder("environment");
/*  84 */     PATH tp = PATHS.TEXT().getFolder("settlement").getFolder("environment");
/*     */     
/*  86 */     String[] keys = jp.getFiles();
/*     */     
/*  88 */     LinkedList<SettEnv> all = new LinkedList();
/*  89 */     KeyMap<SettEnv> kmap = new KeyMap();
/*     */     
/*  91 */     this.NOISE = new SettEnv((LISTE)this.ups, (LISTE)all, "_NOISE", jp, tp, 2, EUpdater.flooder)
/*     */       {
/*     */         public double getCost(int toX, int toY)
/*     */         {
/*  95 */           if (SETT.LIGHTS().los().get(toX, toY).blocksEnv(toX, toY))
/*  96 */             return 8.0D; 
/*  97 */           if (SETT.TERRAIN().get(toX, toY).roofIs())
/*  98 */             return 3.0D; 
/*  99 */           return 1.0D;
/*     */         }
/*     */       };
/*     */     
/* 103 */     kmap.put(this.NOISE.key, this.NOISE);
/* 104 */     this.LIGHT = new SettEnv((LISTE)this.ups, (LISTE)all, "_LIGHT", jp, tp, 2, EUpdater.tracer)
/*     */       {
/*     */         public double getCost(int toX, int toY)
/*     */         {
/* 108 */           return (SETT.LIGHTS().los().get(toX, toY).blocksEnv(toX, toY) ? 16 : true);
/*     */         }
/*     */       };
/* 111 */     kmap.put(this.LIGHT.key, this.LIGHT);
/* 112 */     this.SPACE = new SettEnv((LISTE)this.ups, (LISTE)all, "_SPACE", jp, tp, 4, EUpdater.flooder)
/*     */       {
/*     */         public double getCost(int toX, int toY)
/*     */         {
/* 116 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 121 */           return 1.0D - super.get(tile);
/*     */         }
/*     */ 
/*     */         
/*     */         public double getBaseValue(int tx, int ty) {
/* 126 */           return (((SETT.PATH()).availability.get(tx, ty)).tileCollide ? true : false);
/*     */         }
/*     */ 
/*     */         
/*     */         public double radius() {
/* 131 */           return 0.5D;
/*     */         }
/*     */ 
/*     */         
/*     */         double getRadius(int tx, int ty) {
/* 136 */           return 0.5D;
/*     */         }
/*     */       };
/* 139 */     kmap.put(this.SPACE.key, this.SPACE);
/*     */     
/* 141 */     this.URBAN = new SettEnv((LISTE)this.ups, (LISTE)all, "_URBANISATION", jp, tp, 1, EUpdater.flooder)
/*     */       {
/*     */         public double radius() {
/* 144 */           return 0.5D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double getBaseValue(int tx, int ty) {
/* 149 */           if ((SETT.ROOMS()).map.is(tx, ty)) {
/* 150 */             return 1.0D;
/*     */           }
/* 152 */           Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/*     */           
/* 154 */           if (t.clearing().isStructure()) {
/* 155 */             return 1.0D;
/*     */           }
/*     */           
/* 158 */           if ((SETT.FLOOR()).getter.get(tx, ty) != null)
/* 159 */             return 1.0D; 
/* 160 */           return 0.0D;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 165 */     this.GUARD = new SettEnv((LISTE)this.ups, (LISTE)all, "_GUARD", jp, tp, 4, EUpdater.tracer)
/*     */       {
/*     */         public double getCost(int toX, int toY)
/*     */         {
/* 169 */           return 1.0D;
/*     */         }
/*     */       };
/*     */     
/* 173 */     kmap.put(this.GUARD.key, this.GUARD);
/*     */     
/* 175 */     this.PUNISHMENT = new SettEnv((LISTE)this.ups, (LISTE)all, "_PUNISHMENT", jp, tp, 2, EUpdater.tracer)
/*     */       {
/*     */         public double getCost(int toX, int toY)
/*     */         {
/* 179 */           return 1.0D;
/*     */         }
/*     */       };
/*     */     
/* 183 */     kmap.put(this.PUNISHMENT.key, this.PUNISHMENT);
/*     */     
/* 185 */     this.WATER_SWEET = new SettEnv((LISTE)this.ups, (LISTE)all, "_WATER_SWEET", jp, tp, 4, EUpdater.flooder)
/*     */       {
/*     */         public double getCost(int toX, int toY)
/*     */         {
/* 189 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double getBaseValue(int tx, int ty) {
/* 194 */           if ((SETT.TERRAIN()).WATER.groundWater.is(tx, ty))
/* 195 */             return 1.0D; 
/* 196 */           return super.getBaseValue(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public double radius() {
/* 201 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         double getRadius(int tx, int ty) {
/* 206 */           return 1.0D;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 211 */     kmap.put(this.WATER_SWEET.key, this.WATER_SWEET);
/*     */     
/* 213 */     this.WATER_SALT = new SettEnv((LISTE)this.ups, (LISTE)all, "_WATER_SALT", jp, tp, 1, EUpdater.flooder)
/*     */       {
/*     */         public double getCost(int toX, int toY)
/*     */         {
/* 217 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double getBaseValue(int tx, int ty) {
/* 222 */           if ((SETT.TERRAIN()).WATER.groundWaterSalt.is(tx, ty))
/* 223 */             return 1.0D; 
/* 224 */           return super.getBaseValue(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public double radius() {
/* 229 */           return 1.0D;
/*     */         }
/*     */       };
/* 232 */     kmap.put(this.WATER_SALT.key, this.WATER_SALT);
/*     */     
/* 234 */     if (keys.length > 32 - all.size()) {
/* 235 */       throw new Errors.DataError("Too many environments declared, max is " + 32 - all.size(), jp.get());
/*     */     }
/* 237 */     this.all = new ArrayList((Iterable)all);
/*     */     
/* 239 */     kmap.expand();
/*     */     
/* 241 */     this.rmap = new RMAP("ENVIRONMENT", (LIST)all);
/*     */     
/* 243 */     this.SHAPE = new SettEnvShape((LISTE<Updatable>)this.ups);
/*     */     
/* 245 */     this.MONUMENT = new SettEnvMonument((LISTE<Updatable>)this.ups);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init() {
/* 252 */     for (Updatable s : this.ups) {
/* 253 */       s.clear();
/*     */     }
/*     */     
/* 256 */     this.chunks.clear();
/*     */     
/* 258 */     for (int ty = 0; ty < SETT.THEIGHT; ty++) {
/* 259 */       for (int tx = 0; tx < SETT.TWIDTH; tx++) {
/* 260 */         for (Updatable t : this.ups) {
/* 261 */           if (t.getBaseValue(tx, ty) > 0.0D) {
/* 262 */             this.chunks.change(tx, ty, t.bit);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 267 */     while (this.chunks.has()) {
/* 268 */       int m = this.chunks.nextMask();
/* 269 */       COORDINATE c = this.chunks.next();
/* 270 */       this.updater.update(c.x(), c.y(), m);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initWater() {
/* 277 */     this.WATER_SWEET.map.clear();
/* 278 */     this.chunks.clear();
/*     */     
/* 280 */     for (int ty = 0; ty < SETT.THEIGHT; ty++) {
/* 281 */       for (int tx = 0; tx < SETT.TWIDTH; tx++) {
/* 282 */         if (this.WATER_SWEET.getBaseValue(tx, ty) > 0.0D) {
/* 283 */           this.chunks.change(tx, ty, this.WATER_SWEET.bit);
/*     */         }
/*     */       } 
/*     */     } 
/* 287 */     while (this.chunks.has()) {
/* 288 */       int m = this.chunks.nextMask();
/* 289 */       COORDINATE c = this.chunks.next();
/* 290 */       this.updater.update(c.x(), c.y(), m);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setChanged(int tx, int ty) {
/* 295 */     this.chunks.change(tx, ty);
/*     */   }
/*     */   
/*     */   void setChanged(int tx, int ty, Updatable e) {
/* 299 */     this.chunks.change(tx, ty, e.bit);
/*     */   }
/*     */   
/*     */   public void setChanged(int tx, int ty, SettEnv e) {
/* 303 */     this.chunks.change(tx, ty, e.bit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 309 */     this.updater.update(ds);
/*     */   }
/*     */   
/*     */   public LIST<SettEnv> all() {
/* 313 */     return (LIST<SettEnv>)this.all;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SettEnvValue
/*     */   {
/* 319 */     private static final SettEnvValue self = new SettEnvValue();
/*     */     
/*     */     public double radius;
/*     */     public double value;
/*     */     public int approvedDirs;
/*     */     
/*     */     static SettEnvValue init() {
/* 326 */       self.approvedDirs = -1;
/* 327 */       return self;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static abstract class Updatable
/*     */   {
/*     */     final int bit;
/*     */ 
/*     */ 
/*     */     
/*     */     Updatable(LISTE<Updatable> all) {
/* 340 */       this.bit = 1 << all.size();
/* 341 */       all.add(this);
/*     */     }
/*     */     
/*     */     public abstract double getBaseValue(int param1Int1, int param1Int2);
/*     */     
/*     */     protected abstract void update(RECTANGLE param1RECTANGLE1, RECTANGLE param1RECTANGLE2);
/*     */     
/*     */     protected abstract boolean has(int param1Int1, int param1Int2);
/*     */     
/*     */     protected abstract void clear(); }
/*     */   
/*     */   public static class SettEnv extends Updatable implements MAP_DOUBLE, MAPPED {
/*     */     private final int index;
/* 354 */     private int extraI = -1;
/*     */     public final String key;
/*     */     public final double declineSpeed;
/*     */     public final BoostSpecs bonuses;
/*     */     public final StatStanding.StandingDef standing;
/*     */     final Bitsmap1D map;
/*     */     final int max;
/*     */     public final double maxI;
/*     */     private final EUpdater uper;
/*     */     public final SPRITE icon;
/*     */     public final Opinion op;
/*     */     public final INFO info;
/*     */     
/*     */     SettEnv(LISTE<SettEnvMap.Updatable> uall, LISTE<SettEnv> all, String key, PATH pj, PATH tj, int bits, EUpdater uper) throws IOException {
/* 368 */       super(uall);
/* 369 */       this.info = new INFO(new Json(tj.gets(key)));
/* 370 */       this.key = key;
/* 371 */       this.index = all.add(this);
/* 372 */       Json j = new Json(pj.gets(key));
/* 373 */       this.icon = (SPRITE)SPRITES.icons().get(j);
/* 374 */       this.declineSpeed = j.d("DECLINE_VALUE", 0.0D, 1.0D);
/* 375 */       this.bonuses = new BoostSpecs(this.info.name, (SPRITE)(UI.icons()).s.eye, false);
/* 376 */       this.bonuses.read(j, null);
/* 377 */       this.standing = new StatStanding.StandingDef(j);
/* 378 */       this.map = new Bitsmap1D(0, bits, SETT.TAREA);
/* 379 */       this.max = (1 << bits) - 1;
/* 380 */       this.maxI = 1.0D / this.max;
/* 381 */       this.uper = uper;
/* 382 */       this.op = new Opinion();
/* 383 */       this.op.read(new Json(tj.gets(key)));
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(int tile) {
/* 388 */       double v = this.map.get(tile) * this.maxI;
/*     */       
/* 390 */       if ((SETT.FLOOR()).getter.get(tile) != null && !(SETT.ROOMS()).map.is(tile))
/* 391 */         v += ((Floors.Floor)(SETT.FLOOR()).getter.get(tile)).envValue(this, tile); 
/* 392 */       return CLAMP.d(v, 0.0D, 1.0D);
/*     */     }
/*     */     
/*     */     public double getCost(int toX, int toY) {
/* 396 */       return (SETT.LIGHTS().los().get(toX, toY).blocksEnv(toX, toY) ? 16 : true);
/*     */     }
/*     */     
/*     */     double getRadius(int tx, int ty) {
/* 400 */       if ((SETT.ROOMS()).construction.isser.is(tx, ty) || (SETT.ROOMS()).placement.embryo.is(tx, ty))
/* 401 */         return 0.0D; 
/* 402 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 403 */       if (r != null && r.constructor() != null && r.constructor().envValue(this, SettEnvMap.SettEnvValue.init(), tx, ty)) {
/* 404 */         return SettEnvMap.SettEnvValue.self.radius;
/*     */       }
/* 406 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double getBaseValue(int tx, int ty) {
/* 411 */       if ((SETT.ROOMS()).construction.isser.is(tx, ty) || (SETT.ROOMS()).placement.embryo.is(tx, ty)) {
/* 412 */         return 0.0D;
/*     */       }
/* 414 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/*     */       
/* 416 */       if (r != null && !(SETT.ROOMS()).construction.isser.is(tx, ty) && r.constructor() != null && 
/* 417 */         r.constructor().envValue(this, SettEnvMap.SettEnvValue.init(), tx, ty)) {
/* 418 */         return SettEnvMap.SettEnvValue.self.value;
/*     */       }
/* 420 */       return 0.0D;
/*     */     }
/*     */     
/*     */     public int dirs(int tx, int ty) {
/* 424 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 425 */       if (r != null && r.constructor() != null && r.constructor().envValue(this, SettEnvMap.SettEnvValue.init(), tx, ty)) {
/* 426 */         return SettEnvMap.SettEnvValue.self.approvedDirs;
/*     */       }
/* 428 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(int tx, int ty) {
/* 433 */       if (!SETT.IN_BOUNDS(tx, ty))
/* 434 */         return 0.0D; 
/* 435 */       return get(tx + ty * SETT.TWIDTH);
/*     */     }
/*     */     
/*     */     public void addExtraView(double value, double radius, int tx, int ty, int approvedDirs) {
/* 439 */       GUTIL.flooder().init(this);
/* 440 */       (SETT.ENV()).map.updater.addExtraView(GUTIL.flooder(), this, value, radius, tx, ty, approvedDirs);
/* 441 */       GUTIL.flooder().done();
/*     */       
/* 443 */       this.extraI = GAME.updateI();
/*     */     }
/*     */     
/*     */     public double getView(int tx, int ty) {
/* 447 */       double g = get(tx, ty);
/* 448 */       if (this.extraI == GAME.updateI()) {
/* 449 */         g = this.uper.getExtraValue(this, g, tx, ty);
/* 450 */         g = CLAMP.d(g, 0.0D, 1.0D);
/*     */       } 
/*     */       
/* 453 */       return g;
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 458 */       return this.index;
/*     */     }
/*     */     
/*     */     public STAT stat() {
/* 462 */       return (STAT)(STATS.ACCESS()).ACCESS.all().get(this.index);
/*     */     }
/*     */     
/*     */     public int max() {
/* 466 */       return this.max;
/*     */     }
/*     */     
/*     */     public double radius() {
/* 470 */       return 1.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public String key() {
/* 475 */       return this.key;
/*     */     }
/*     */ 
/*     */     
/*     */     public void update(RECTANGLE bounds, RECTANGLE area) {
/* 480 */       this.uper.update(this, bounds, area);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean has(int tx, int ty) {
/* 486 */       return (this.map.get(tx + ty * SETT.TWIDTH) > 0);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clear() {
/* 491 */       this.map.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private final class Chunks
/*     */   {
/* 498 */     private final int mask = -16;
/* 499 */     private final int width = SETT.TWIDTH / 16;
/* 500 */     private final int size = this.width * SETT.THEIGHT / 16;
/*     */     
/* 502 */     private final Bitmap1D changed = new Bitmap1D(this.size, false);
/* 503 */     private final int[] upMasks = Alloc.ii(this.size);
/* 504 */     private final QueueInteger updatables = new QueueInteger(this.size + 1);
/* 505 */     private Coo coo = new Coo();
/*     */     
/*     */     private final Rec rr;
/*     */     
/*     */     private int pt;
/*     */ 
/*     */     
/*     */     public void change(int tx, int ty, int mask) {
/* 513 */       if (!SETT.IN_BOUNDS(tx, ty))
/*     */         return; 
/* 515 */       int x1 = tx - 16;
/* 516 */       int x2 = tx + 16;
/* 517 */       int y1 = ty - 16;
/* 518 */       int y2 = ty + 16;
/*     */       
/* 520 */       for (int y = y1; y <= y2; y += 16) {
/* 521 */         for (int x = x1; x <= x2; x += 16) {
/* 522 */           if (SETT.IN_BOUNDS(x, y)) {
/* 523 */             changeP(x, y, mask);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void changeP(int tx, int ty, int mask) {
/* 531 */       int c = getChunk(tx, ty);
/* 532 */       this.upMasks[c] = this.upMasks[c] | mask;
/* 533 */       if (!this.changed.get(c)) {
/* 534 */         this.changed.set(c, true);
/* 535 */         this.updatables.push(c);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private int getChunk(int tx, int ty) {
/* 541 */       tx &= 0xFFFFFFF0;
/* 542 */       ty &= 0xFFFFFFF0;
/* 543 */       int c = tx / 16 + this.width * ty / 16;
/* 544 */       return c;
/*     */     }
/*     */     Chunks() {
/* 547 */       this.rr = new Rec(5.0D, 5.0D);
/*     */     }
/*     */     
/*     */     public void change(int tx, int ty) {
/* 551 */       if (!SETT.IN_BOUNDS(tx, ty)) {
/*     */         return;
/*     */       }
/* 554 */       int m = 0;
/*     */       
/* 556 */       this.rr.moveC(tx, ty);
/*     */       
/* 558 */       for (SettEnvMap.Updatable e : SettEnvMap.this.ups) {
/* 559 */         if ((m & e.bit) != 0) {
/*     */           continue;
/*     */         }
/* 562 */         for (COORDINATE c : this.rr) {
/* 563 */           if (SETT.IN_BOUNDS(c) && (e.has(c.x(), c.y()) || e.getBaseValue(c.x(), c.y()) > 0.0D)) {
/* 564 */             m |= e.bit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 582 */       if (m != 0)
/* 583 */         change(tx, ty, m); 
/*     */     }
/*     */     
/*     */     void clear() {
/* 587 */       this.changed.clear();
/* 588 */       this.updatables.clear();
/* 589 */       Arrays.fill(this.upMasks, 0);
/*     */     }
/*     */     
/*     */     public boolean has() {
/* 593 */       return this.updatables.hasNext();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public COORDINATE next() {
/* 599 */       int x = this.pt % this.width;
/* 600 */       int y = this.pt / this.width;
/* 601 */       this.coo.set((16 * x), (16 * y));
/* 602 */       this.changed.set(this.pt, false);
/* 603 */       this.upMasks[this.pt] = 0;
/* 604 */       return (COORDINATE)this.coo;
/*     */     }
/*     */     
/*     */     public int nextMask() {
/* 608 */       this.pt = this.updatables.poll();
/* 609 */       return this.upMasks[this.pt];
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class Updater
/*     */   {
/* 616 */     private double timer = 0.0D;
/* 617 */     private double chunksPerTick = 1.0D;
/*     */     
/*     */     protected void update(double ds) {
/* 620 */       this.timer += this.chunksPerTick;
/* 621 */       if (this.timer < 1.0D)
/*     */         return; 
/* 623 */       int am = (int)this.timer;
/* 624 */       this.timer -= am;
/* 625 */       while (SettEnvMap.this.chunks.has() && am > 0) {
/* 626 */         int m = SettEnvMap.this.chunks.nextMask();
/* 627 */         COORDINATE c = SettEnvMap.this.chunks.next();
/* 628 */         update(c.x(), c.y(), m);
/* 629 */         am--;
/*     */       } 
/*     */     }
/*     */     
/* 633 */     private final Rec bounds = new Rec();
/* 634 */     private final Rec area = new Rec(16.0D);
/* 635 */     private final int MAXR = 15;
/*     */     
/*     */     private void update(int tx, int ty, int mask) {
/* 638 */       int x1 = CLAMP.i(tx - 16, 0, SETT.TWIDTH);
/* 639 */       int x2 = CLAMP.i(tx + 32, 0, SETT.TWIDTH);
/* 640 */       int y1 = CLAMP.i(ty - 16, 0, SETT.THEIGHT);
/* 641 */       int y2 = CLAMP.i(ty + 32, 0, SETT.THEIGHT);
/* 642 */       this.bounds.set(x1, x2, y1, y2);
/* 643 */       this.area.set(tx, CLAMP.i(tx + 16, 0, SETT.TWIDTH - 1), ty, CLAMP.i(ty + 16, 0, SETT.THEIGHT - 1));
/*     */       
/* 645 */       for (SettEnvMap.Updatable s : SettEnvMap.this.ups) {
/* 646 */         if ((s.bit & mask) == 0) {
/*     */           continue;
/*     */         }
/* 649 */         s.update((RECTANGLE)this.bounds, (RECTANGLE)this.area);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addExtraView(PathUtilOnline.Flooder f, SettEnvMap.SettEnv thing, double value, double radius, int tx, int ty, int approvedDirs) {
/* 657 */       if (value <= 0.0D) {
/*     */         return;
/*     */       }
/* 660 */       int rr = (int)Math.ceil(radius * 15.0D);
/* 661 */       this.area.set(CLAMP.i(tx - rr, 0, SETT.TWIDTH), CLAMP.i(tx + rr + 1, 0, SETT.TWIDTH - 1), CLAMP.i(ty - rr, 0, SETT.THEIGHT - 1), CLAMP.i(ty + 1 + rr, 0, SETT.THEIGHT));
/*     */       
/* 663 */       thing.uper.addExtraView((RECTANGLE)this.area, f, thing, value, radius, tx, ty, approvedDirs);
/*     */ 
/*     */       
/* 666 */       GUTIL.flooder().done();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */