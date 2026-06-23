/*     */ package world.map.road;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class GenPolish
/*     */ {
/*  20 */   public final Polymap polly = new Polymap(WORLD.TBOUNDS(), 6, 1.0D);
/*     */ 
/*     */   
/*     */   public GenPolish(ACTION util, MAP_DOUBLE infra) {
/*  24 */     removeUnusedRoads();
/*     */     
/*  26 */     for (Region r : WORLD.REGIONS().all()) {
/*  27 */       if (r.info.area() > 0) {
/*  28 */         randomRoad(r);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeUnusedRoads() {
/*  38 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  39 */       if ((WORLD.REGIONS()).cTile.is(c))
/*     */         continue; 
/*  41 */       boolean needed = false;
/*  42 */       boolean canBeRemoved = false;
/*     */       
/*  44 */       for (DIR d : DIR.ORTHO) {
/*  45 */         if (WORLD.ROADS().is(c, d) && WORLD.ROADS().is(c, d.next(2))) {
/*  46 */           if (!WORLD.ROADS().is(c, d.next(1)) || ((WORLD.REGIONS()).map.get(c) != null && (WORLD.REGIONS()).map.get(c) != (WORLD.REGIONS()).map.get(c, d))) {
/*  47 */             needed = true;
/*     */             break;
/*     */           } 
/*  50 */           canBeRemoved = true;
/*     */         } 
/*     */       } 
/*     */       
/*  54 */       if (!needed && canBeRemoved) {
/*  55 */         WORLD.ROADS().set(c, false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void randomRoad(Region r) {
/*  62 */     GUTIL.flooder().init(this);
/*  63 */     GUTIL.flooder().pushSloppy(r.info.cx(), r.info.cy(), 0.0D);
/*     */     
/*  65 */     int amount = (int)(r.info.area() * r.info.moisture());
/*     */     
/*  67 */     while (GUTIL.flooder().hasMore() && amount > 0) {
/*  68 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/*  70 */       if (r != (WORLD.REGIONS()).map.get((COORDINATE)t)) {
/*     */         continue;
/*     */       }
/*     */       
/*  74 */       for (DIR d : DIR.ALL) {
/*  75 */         if ((WORLD.REGIONS()).map.get((COORDINATE)t, d) != r);
/*     */       } 
/*     */ 
/*     */       
/*  79 */       if (!WORLD.ROADS().is((COORDINATE)t)) {
/*  80 */         WORLD.ROADS().set((COORDINATE)t, true);
/*  81 */         (WORLD.ROADS()).minified.set((COORDINATE)t, true);
/*  82 */         amount--;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  87 */       for (DIR d : DIR.ORTHO) {
/*  88 */         int dx = t.x() + d.x();
/*  89 */         int dy = t.y() + d.y();
/*  90 */         if (WORLD.IN_BOUNDS(dx, dy)) {
/*     */           
/*  92 */           if (WORLD.ROADS().is(dx, dy)) {
/*  93 */             GUTIL.flooder().pushSmaller(dx, dy, 0.0D);
/*     */           }
/*  95 */           double v = 1.0D;
/*  96 */           if (v >= 0.0D && this.polly.isEdge(dx, dy) && !(WORLD.WATER()).isBig.is(dx, dy)) {
/*  97 */             GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + v * d.tileDistance(), t);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 105 */     GUTIL.flooder().done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenPolish.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */