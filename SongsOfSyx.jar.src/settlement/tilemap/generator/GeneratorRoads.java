/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.util.Iterator;
/*     */ import settlement.entry.EntryPoints;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.road.WTRAV;
/*     */ 
/*     */ 
/*     */ final class GeneratorRoads
/*     */ {
/*  27 */   private final Bitmap2D edge = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*  28 */   private final PathGame.PathFancy path = new PathGame.PathFancy(5000);
/*  29 */   private final EntryPoints ees = (SETT.ENTRY()).points;
/*     */   
/*  31 */   final PathGame.COST cm = new PathGame.COST()
/*     */     {
/*     */       
/*     */       public double getCost(int fromX, int fromY, int toX, int toY)
/*     */       {
/*  36 */         if ((SETT.TERRAIN()).WATER.BRIDGE.is(toX, toY)) {
/*  37 */           return 0.2D;
/*     */         }
/*  39 */         if (!SETT.TERRAIN().get(toX, toY).clearing().isEasilyCleared()) {
/*  40 */           return 25.0D;
/*     */         }
/*     */         
/*  43 */         if (GUTIL.flooder().getValue2(toX, toY) != 0.0F) {
/*  44 */           return 10.0D;
/*     */         }
/*  46 */         if (SETT.TERRAIN().get(toX, toY) != (SETT.TERRAIN()).NADA) {
/*  47 */           return 2.0D;
/*     */         }
/*     */         
/*  50 */         if (!GeneratorRoads.this.edge.is(toX, toY)) {
/*  51 */           return 2.0D;
/*     */         }
/*  53 */         if ((SETT.FLOOR()).getter.get(toX, toY) != null) {
/*  54 */           return 0.2D;
/*     */         }
/*  56 */         return 1.0D;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GeneratorRoads(CapitolArea area) {
/*  64 */     Polymap polly = new Polymap(SETT.TWIDTH, SETT.THEIGHT, 8, 1.0D);
/*  65 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  66 */       this.edge.set(c, polly.isEdge(c.x(), c.y()));
/*  67 */       (SETT.MAINTENANCE()).disabled.set(c, false);
/*     */     } 
/*     */ 
/*     */     
/*  71 */     boolean[] isToActivate = new boolean[this.ees.all().size()];
/*  72 */     LinkedList<EntryPoints.EntryPoint> toActivate = new LinkedList();
/*  73 */     LinkedList<EntryPoints.EntryPoint> toFindOther = new LinkedList();
/*  74 */     for (EntryPoints.EntryPoint e : this.ees.all()) {
/*     */       
/*  76 */       int wx = area.tiles().x1() + e.wCooD().x();
/*  77 */       int wy = area.tiles().y1() + e.wCooD().y();
/*     */ 
/*     */       
/*  80 */       if ((WORLD.PATH()).map.can(wx, wy, e.dirOut)) {
/*     */         
/*  82 */         if (WTRAV.isGoodLandTile(wx, wy)) {
/*  83 */           isToActivate[e.index()] = true;
/*  84 */           toActivate.add(e); continue;
/*     */         } 
/*  86 */         toFindOther.add(e);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  92 */     for (EntryPoints.EntryPoint notFindable : toFindOther) {
/*     */       
/*  94 */       double dist = Double.MAX_VALUE;
/*  95 */       EntryPoints.EntryPoint best = null;
/*     */       
/*  97 */       int fx = area.tiles().x1() + notFindable.wCooD().x() + notFindable.dirOut.x();
/*  98 */       int fy = area.tiles().y1() + notFindable.wCooD().y() + notFindable.dirOut.y();
/*     */ 
/*     */       
/* 101 */       for (EntryPoints.EntryPoint e : this.ees.all()) {
/*     */         
/* 103 */         if (e == notFindable) {
/*     */           continue;
/*     */         }
/* 106 */         int wx = area.tiles().x1() + e.wCooD().x();
/* 107 */         int wy = area.tiles().y1() + e.wCooD().y();
/*     */         
/* 109 */         if (WTRAV.isGoodLandTile(wx, wy)) {
/* 110 */           double d = e.distanceValue(fx, fy);
/* 111 */           if (d < dist) {
/* 112 */             best = e;
/* 113 */             dist = d;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 118 */       if (best != null && !isToActivate[best.index()]) {
/* 119 */         isToActivate[best.index()] = true;
/* 120 */         toActivate.add(best);
/*     */       } 
/*     */     } 
/*     */     
/* 124 */     if (!area.isBattle && toActivate.size() == 0) {
/* 125 */       GAME.Warn("No active entry points exist");
/*     */     }
/* 127 */     for (EntryPoints.EntryPoint e : toActivate) {
/* 128 */       adjust(e);
/*     */     }
/*     */     
/* 131 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */ 
/*     */     
/* 134 */     f.init(this);
/* 135 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 136 */       if (!SETT.TERRAIN().get(c.x(), c.y()).clearing().isEasilyCleared()) {
/* 137 */         f.pushSloppy(c, 0.0D);
/* 138 */         f.setValue2(c, 1.0D); continue;
/*     */       } 
/* 140 */       f.setValue2(c, 0.0D);
/*     */     } 
/*     */     
/* 143 */     while (f.hasMore()) {
/* 144 */       PathTile t = f.pollSmallest();
/* 145 */       for (DIR d : DIR.ALL) {
/* 146 */         if (SETT.IN_BOUNDS((COORDINATE)t, d))
/* 147 */           f.setValue2(t.x(), t.y(), d, 1.0D); 
/*     */       } 
/*     */     } 
/* 150 */     f.done();
/*     */ 
/*     */     
/* 153 */     Coo start = new Coo((SETT.TWIDTH / 2), (SETT.THEIGHT / 2));
/*     */     
/* 155 */     f.init(this);
/* 156 */     f.pushSloppy(SETT.TWIDTH / 2, SETT.THEIGHT / 2, 0.0D);
/*     */     
/* 158 */     while (f.hasMore()) {
/* 159 */       PathTile t = f.pollSmallest();
/*     */       
/* 161 */       if (this.cm.getCost(0, 0, t.x(), t.y()) < 2.0D) {
/* 162 */         start.set((COORDINATE)t);
/*     */         
/*     */         break;
/*     */       } 
/* 166 */       for (DIR d : DIR.ORTHO) {
/* 167 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 168 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/* 172 */     f.done();
/*     */ 
/*     */     
/* 175 */     if (!area.isBattle && toActivate.size() == 0) {
/* 176 */       System.err.println("The city map did not generate any roads, and the city will be unplayable. Please send the save to info@songsofsyx.com");
/*     */     }
/* 178 */     for (EntryPoints.EntryPoint e : toActivate) {
/* 179 */       road((COORDINATE)start, e.coo());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void road(COORDINATE from, COORDINATE to) {
/* 189 */     int ox = from.x();
/* 190 */     int oy = to.x();
/* 191 */     if ((GUTIL.pathTools()).astar.getShortest(this.path, this.cm, from.x(), from.y(), to.x(), to.y())) {
/*     */       do {
/* 193 */         place(this.path.x(), this.path.y(), ox, oy);
/* 194 */         place(ox, oy, this.path.x(), this.path.y());
/* 195 */         ox = this.path.x();
/* 196 */         oy = this.path.y();
/* 197 */       } while (this.path.setNext());
/*     */ 
/*     */       
/* 200 */       place(from.x(), from.y(), from.x(), from.y());
/* 201 */       place(to.x(), to.y(), to.x(), to.y());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void place(int tx, int ty, int ox, int oy) {
/* 208 */     if ((SETT.TERRAIN()).WATER.is.is(tx, ty)) {
/* 209 */       placeWater(tx, ty, ox, oy);
/*     */     } else {
/* 211 */       placeRoad(tx, ty);
/* 212 */       for (DIR d : DIR.ALL) {
/* 213 */         if (!(SETT.TERRAIN()).WATER.is.is(tx, ty, d)) {
/* 214 */           placeRoad(tx + d.x(), ty + d.y());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void placeWater(int tx, int ty, int ox, int oy) {
/* 224 */     if (SETT.IN_BOUNDS(tx, ty)) {
/* 225 */       if ((SETT.TERRAIN()).WATER.SHALLOW.is(tx, ty) && RND.oneIn(8)) {
/* 226 */         (SETT.TERRAIN()).NADA.placeRaw(tx, ty);
/* 227 */       } else if ((SETT.TERRAIN()).WATER.DEEP.is(tx, ty)) {
/* 228 */         (SETT.TERRAIN()).WATER.BRIDGE.placeRaw(tx, ty);
/*     */         
/* 230 */         for (DIR d : DIR.ORTHO) {
/* 231 */           if (RND.oneIn(16) && (SETT.TERRAIN()).WATER.DEEP.is(tx + d.x(), ty + d.y()))
/* 232 */             (SETT.TERRAIN()).WATER.BRIDGE.placeRaw(tx + d.x(), ty + d.y()); 
/*     */         } 
/*     */       } 
/* 235 */       if ((SETT.TERRAIN()).WATER.DEEP.is(tx, oy))
/* 236 */         (SETT.TERRAIN()).WATER.BRIDGE.placeRaw(tx, oy); 
/* 237 */       if ((SETT.TERRAIN()).WATER.DEEP.is(ox, ty))
/* 238 */         (SETT.TERRAIN()).WATER.BRIDGE.placeRaw(ox, ty); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void placeRoad(int tx, int ty) {
/* 243 */     if (SETT.IN_BOUNDS(tx, ty) && !(SETT.TERRAIN()).WATER.is.is(tx, ty)) {
/* 244 */       (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/* 245 */       (SETT.FLOOR()).mainStartRoad.placeFixed(tx, ty);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void adjust(EntryPoints.EntryPoint e) {
/* 253 */     double bestV = Double.MAX_VALUE;
/* 254 */     int ox = e.body.cX();
/* 255 */     int oy = e.body.cY();
/* 256 */     Coo best = new Coo(ox, oy);
/*     */     
/* 258 */     Coo start = new Coo();
/*     */     
/* 260 */     null = e.body.iterator(); if (null.hasNext()) { COORDINATE c = null.next();
/* 261 */       start.set(c); }
/* 262 */      for (COORDINATE c : e
/*     */ 
/*     */       
/* 265 */       .body) {
/*     */       
/* 267 */       if (SETT.TERRAIN().get(c.x(), c.y()) == (SETT.TERRAIN()).NADA || 
/* 268 */         start.isSameAs(c)) {
/*     */         continue;
/*     */       }
/*     */       
/* 272 */       int cx = (start.x() + c.x()) / 2;
/* 273 */       int cy = (start.y() + c.y()) / 2;
/*     */       
/* 275 */       int size = Math.abs(start.x() - c.x()) + Math.abs(start.y() - c.y());
/* 276 */       size = CLAMP.i(size, 0, 8);
/* 277 */       int dist = Math.abs(cx - ox) + Math.abs(cy - oy);
/*     */       
/* 279 */       double v = dist;
/* 280 */       v /= (size + 1);
/* 281 */       if (v < bestV) {
/* 282 */         bestV = v;
/* 283 */         best.set(cx, cy);
/*     */       } 
/* 285 */       start.set(c);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 290 */     this.ees.map.set((COORDINATE)best, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorRoads.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */