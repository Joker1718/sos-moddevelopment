/*     */ package settlement.environment;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TileRayTracer;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.misc.IntChecker;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class EUpdater
/*     */ {
/*  26 */   static final TileRayTracer traces = new TileRayTracer(16);
/*  27 */   private static final IntChecker rCheck = new IntChecker((traces.rays()).length);
/*  28 */   private static final ArrayList<TileRayTracer.Ray> rays = new ArrayList((traces.rays()).length);
/*     */   
/*     */   private static final int MAXR = 15;
/*  31 */   private static final Rec eArea = new Rec();
/*  32 */   private static final Rec eArea2 = new Rec();
/*  33 */   private static int aI = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   public static EUpdater tracer = new EUpdater()
/*     */     {
/*     */       
/*     */       public void update(SettEnvMap.SettEnv s, RECTANGLE bounds, RECTANGLE area)
/*     */       {
/*  45 */         for (COORDINATE c : area) {
/*  46 */           if (SETT.IN_BOUNDS(c)) {
/*  47 */             s.map.set(c.x() + c.y() * SETT.TWIDTH, 0);
/*  48 */             GUTIL.flooder().setValue2(c, 0.0D);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/*  53 */         for (COORDINATE c : bounds) {
/*  54 */           if (EUpdater.tracetest(area, s, c)) {
/*  55 */             EUpdater.trace(c.x(), c.y(), s, area);
/*     */           }
/*     */         } 
/*     */         
/*  59 */         for (COORDINATE c : area) {
/*  60 */           int v = (int)Math.ceil(GUTIL.flooder().getValue2(c.x(), c.y()));
/*  61 */           v = CLAMP.i(v, 0, s.max);
/*     */           
/*  63 */           s.map.set(c.x() + c.y() * SETT.TWIDTH, v);
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void addExtraView(RECTANGLE area, PathUtilOnline.Flooder f, SettEnvMap.SettEnv thing, double value, double radius, int tx, int ty, int approvedDirs) {
/*  73 */         if (EUpdater.aI != VIEW.RI()) {
/*  74 */           EUpdater.aI = VIEW.RI();
/*  75 */           for (COORDINATE c : area) {
/*  76 */             if (SETT.IN_BOUNDS(c))
/*  77 */               GUTIL.flooder().setValue2(c, 0.0D); 
/*     */           } 
/*  79 */           EUpdater.eArea.set(area);
/*     */         } else {
/*  81 */           EUpdater.eArea2.set((RECTANGLE)EUpdater.eArea);
/*  82 */           EUpdater.eArea.unify(area);
/*  83 */           for (COORDINATE c : EUpdater.eArea) {
/*  84 */             if (SETT.IN_BOUNDS(c) && !EUpdater.eArea2.holdsPoint(c))
/*  85 */               GUTIL.flooder().setValue2(c, 0.0D); 
/*     */           } 
/*     */         } 
/*  88 */         if (SETT.IN_BOUNDS(tx, ty)) {
/*  89 */           EUpdater.trace(tx, ty, thing, value, radius, area, approvedDirs);
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public double getExtraValue(SettEnvMap.SettEnv s, double g, int tx, int ty) {
/* 148 */         if (EUpdater.aI != VIEW.RI())
/* 149 */           return g; 
/* 150 */         if (!EUpdater.eArea.holdsPoint(tx, ty)) {
/* 151 */           return g;
/*     */         }
/*     */         
/* 154 */         double d = Math.ceil(g * s.max + Math.ceil(GUTIL.flooder().getValue2(tx, ty))) * s.maxI;
/* 155 */         return d;
/*     */       }
/*     */     };
/*     */   
/*     */   public abstract void update(SettEnvMap.SettEnv paramSettEnv, RECTANGLE paramRECTANGLE1, RECTANGLE paramRECTANGLE2);
/*     */   
/*     */   private static boolean tracetest(RECTANGLE area, SettEnvMap.SettEnv s, COORDINATE c) {
/* 162 */     int ra = (int)(s.getRadius(c.x(), c.y()) * 15.0D);
/* 163 */     if (ra == 0)
/* 164 */       return false; 
/* 165 */     if (s.getBaseValue(c.x(), c.y()) == 0.0D)
/* 166 */       return false; 
/* 167 */     if (area.holdsPoint(c))
/* 168 */       return true; 
/* 169 */     if (Math.abs(area.cX() - c.x()) - ra > 8)
/* 170 */       return false; 
/* 171 */     if (Math.abs(area.cY() - c.y()) - ra > 8)
/* 172 */       return false; 
/* 173 */     return true;
/*     */   }
/*     */   public abstract void addExtraView(RECTANGLE paramRECTANGLE, PathUtilOnline.Flooder paramFlooder, SettEnvMap.SettEnv paramSettEnv, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   private static void trace(int sourceX, int sourceY, SettEnvMap.SettEnv s, RECTANGLE area) {
/* 178 */     trace(sourceX, sourceY, s, s.getBaseValue(sourceX, sourceY), s.getRadius(sourceX, sourceY), area, s.dirs(sourceX, sourceY));
/*     */   }
/*     */   
/*     */   public abstract double getExtraValue(SettEnvMap.SettEnv paramSettEnv, double paramDouble, int paramInt1, int paramInt2);
/*     */   
/*     */   private static void trace(int sourceX, int sourceY, SettEnvMap.SettEnv s, double value, double radius, RECTANGLE area, int approvedDir) {
/* 184 */     radius = (int)(radius * 15.0D);
/*     */     
/* 186 */     traces.checkInit();
/*     */     
/* 188 */     for (TileRayTracer.Ray r : rays(sourceX, sourceY, area)) {
/*     */       
/* 190 */       if ((approvedDir & (DIR.get(r.get(r.size() - 1))).bit) == 0) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 195 */       double cost = 0.0D;
/* 196 */       for (int i = 0; i < r.size(); i++) {
/* 197 */         COORDINATE d = r.get(i);
/* 198 */         int dx = d.x() + sourceX;
/* 199 */         int dy = d.y() + sourceY;
/* 200 */         if (!SETT.IN_BOUNDS(dx, dy))
/*     */           break; 
/* 202 */         if (r.radius(i) + cost >= radius) {
/*     */           break;
/*     */         }
/* 205 */         if (area.holdsPoint(dx, dy) && 
/* 206 */           traces.check(d)) {
/* 207 */           double rv = (radius - r.radius(i) - cost) / radius;
/* 208 */           double vv = value * rv;
/* 209 */           double v = GUTIL.flooder().getValue2(dx, dy) + vv * s.max;
/* 210 */           GUTIL.flooder().setValue2(dx, dy, v);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 215 */         cost += s.getCost(dx, dy) - 1.0D;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static LIST<TileRayTracer.Ray> rays(int sourceX, int sourceY, RECTANGLE area) {
/* 224 */     rays.clear();
/*     */     
/* 226 */     if (area.touches(sourceX, sourceY)) {
/* 227 */       rays.add((Object[])traces.rays());
/* 228 */       return (LIST<TileRayTracer.Ray>)rays;
/*     */     } 
/*     */     
/* 231 */     rCheck.init();
/*     */     
/* 233 */     int y1 = area.y1() - sourceY;
/* 234 */     int y2 = area.y2() - sourceY;
/* 235 */     for (int x = area.x1(); x < area.x2(); x++) {
/* 236 */       int dx = x - sourceX; byte b; int i; TileRayTracer.Ray[] arrayOfRay;
/* 237 */       for (i = (arrayOfRay = traces.rays(dx, y1)).length, b = 0; b < i; ) { TileRayTracer.Ray r = arrayOfRay[b];
/* 238 */         if (!rCheck.isSetAndSet(r.index))
/* 239 */           rays.add(r);  b++; }
/* 240 */        for (i = (arrayOfRay = traces.rays(dx, y2)).length, b = 0; b < i; ) { TileRayTracer.Ray r = arrayOfRay[b];
/* 241 */         if (!rCheck.isSetAndSet(r.index))
/* 242 */           rays.add(r);  b++; }
/*     */     
/*     */     } 
/* 245 */     int x1 = area.x1() - sourceX;
/* 246 */     int x2 = area.x2() - sourceX;
/*     */     
/* 248 */     for (int y = area.y1(); y <= area.y2(); y++) {
/* 249 */       int dy = y - sourceY; byte b; int i; TileRayTracer.Ray[] arrayOfRay;
/* 250 */       for (i = (arrayOfRay = traces.rays(x1, dy)).length, b = 0; b < i; ) { TileRayTracer.Ray r = arrayOfRay[b];
/* 251 */         if (!rCheck.isSetAndSet(r.index))
/* 252 */           rays.add(r);  b++; }
/* 253 */        for (i = (arrayOfRay = traces.rays(x2, dy)).length, b = 0; b < i; ) { TileRayTracer.Ray r = arrayOfRay[b];
/* 254 */         if (!rCheck.isSetAndSet(r.index))
/* 255 */           rays.add(r);  b++; }
/*     */     
/* 257 */     }  return (LIST<TileRayTracer.Ray>)rays;
/*     */   }
/*     */ 
/*     */   
/* 261 */   public static EUpdater flooder = new EUpdater()
/*     */     {
/*     */       public void update(SettEnvMap.SettEnv s, RECTANGLE bounds, RECTANGLE area)
/*     */       {
/* 265 */         for (COORDINATE c : area) {
/* 266 */           s.map.set(c.x() + c.y() * SETT.TWIDTH, 0);
/*     */         }
/* 268 */         GUTIL.flooder().init(this);
/* 269 */         flood2(GUTIL.flooder(), bounds, area, s);
/* 270 */         GUTIL.flooder().done();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       private void flood2(PathUtilOnline.Flooder f, RECTANGLE bounds, RECTANGLE area, SettEnvMap.SettEnv thing) {
/* 276 */         double r = 1.0D / thing.radius();
/*     */         
/* 278 */         for (COORDINATE c : bounds) {
/* 279 */           double b = thing.getBaseValue(c.x(), c.y()) * 16.0D;
/* 280 */           if (b > 0.0D) {
/* 281 */             f.pushGreater(c, b);
/*     */           }
/*     */         } 
/*     */         
/* 285 */         while (f.hasMore()) {
/* 286 */           PathTile t = f.pollGreatest();
/* 287 */           double value = t.getValue();
/*     */           
/* 289 */           for (DIR d : DIR.ALL) {
/* 290 */             int tx = t.x() + d.x();
/* 291 */             int ty = t.y() + d.y();
/* 292 */             if (bounds.holdsPoint(tx, ty)) {
/* 293 */               double v = value - d.tileDistance() * thing.getCost(tx, ty) * r;
/* 294 */               if (v > 0.0D) {
/* 295 */                 f.pushGreater(tx, ty, v);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 301 */         for (COORDINATE c : area) {
/* 302 */           if (f.hasBeenPushed(c.x(), c.y())) {
/* 303 */             int v = (int)Math.ceil((thing.max * f.getValue(c)) * 0.0625D);
/* 304 */             v = CLAMP.i(v, 0, thing.max);
/* 305 */             thing.map.set(c.x() + c.y() * SETT.TWIDTH, v);
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void addExtraView(RECTANGLE area, PathUtilOnline.Flooder f, SettEnvMap.SettEnv thing, double value, double radius, int tx, int ty, int approvedDirs) {
/* 313 */         double b = value;
/* 314 */         double dr = 0.0625D / radius * b;
/*     */         
/* 316 */         if (b > 0.0D) {
/* 317 */           GUTIL.flooder().pushSloppy(tx, ty, b);
/* 318 */           GUTIL.flooder().setValue2(tx, ty, dr);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 324 */         while (f.hasMore()) {
/* 325 */           PathTile t = f.pollGreatest();
/* 326 */           dr = t.getValue2();
/* 327 */           value = t.getValue();
/*     */           
/* 329 */           for (DIR d : DIR.ALL) {
/* 330 */             tx = t.x() + d.x();
/* 331 */             ty = t.y() + d.y();
/* 332 */             double v = value - dr * d.tileDistance() * thing.getCost(tx, ty);
/* 333 */             if (v > 0.0D && 
/* 334 */               f.pushGreater(tx, ty, v) != null) {
/* 335 */               f.setValue2(tx, ty, dr);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public double getExtraValue(SettEnvMap.SettEnv s, double g, int tx, int ty) {
/* 346 */         g = Math.max(g, GUTIL.flooder().getValue(tx, ty));
/* 347 */         return g;
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\EUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */