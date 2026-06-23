/*     */ package world.map.pathing;
/*     */ 
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ class DebugTest
/*     */ {
/*     */   public DebugTest() {
/*  17 */     ArrayCooShort coos = new ArrayCooShort(WORLD.TAREA());
/*  18 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  19 */       if ((WORLD.PATH()).map.is.is(c)) {
/*  20 */         coos.get().set(c);
/*  21 */         coos.inc();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  26 */     int max = coos.getI();
/*  27 */     test("mixed", coos, max);
/*     */     
/*  29 */     coos.set(0);
/*  30 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  31 */       Region r = (Region)(WORLD.REGIONS()).map.get(c);
/*  32 */       if (r != null && (WORLD.PATH()).map.is.is(c) && c.isSameAs(r.cx(), r.cy())) {
/*  33 */         coos.get().set(c);
/*  34 */         coos.inc();
/*     */       } 
/*     */     } 
/*     */     
/*  38 */     test("capitols", coos, max);
/*     */   }
/*     */ 
/*     */   
/*     */   private void test(String title, ArrayCooShort coos, int max) {
/*  43 */     LOG.ln(title);
/*  44 */     test("simple", this.simple, coos, max, 1000);
/*  45 */     test("normal", this.make, coos, max, 1000);
/*  46 */     test("fancy", this.makeFancy, coos, max, 1000);
/*     */   }
/*     */   
/*     */   private void test(String title, TEST test, ArrayCooShort coos, int max, int amount) {
/*  50 */     long now = System.currentTimeMillis();
/*  51 */     int fails = 0;
/*  52 */     int diff1 = 0;
/*  53 */     int diff2 = 0;
/*  54 */     for (int i = 0; i < amount; i++) {
/*     */       
/*  56 */       coos.set(RND.rInt(max));
/*  57 */       int sx = coos.get().x();
/*  58 */       int sy = coos.get().y();
/*     */       
/*  60 */       coos.set(RND.rInt(max));
/*  61 */       int dx = coos.get().x();
/*  62 */       int dy = coos.get().y();
/*     */       
/*  64 */       PathTile t = test.make(WORLD.WATER().is(sx, sy), sx, sy, dx, dy);
/*  65 */       if (t == null) {
/*  66 */         fails++;
/*     */       } else {
/*  68 */         if (!t.isSameAs(dx, dy)) {
/*  69 */           diff1++;
/*     */         }
/*  71 */         while (t.getParent() != null) {
/*  72 */           t = t.getParent();
/*     */         }
/*     */         
/*  75 */         if (!t.isSameAs(sx, sy))
/*  76 */           diff2++; 
/*     */       } 
/*     */     } 
/*  79 */     LOG.ln(title + " " + title + " " + System.currentTimeMillis() - now + " " + fails + " " + diff1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   public final TEST simple = new TEST()
/*     */     {
/*     */       
/*     */       public PathTile make(boolean isShip, int fromX, int fromY, int tox, int toy)
/*     */       {
/*  91 */         if (!(WORLD.PATH()).map.is.is(fromX, fromY) || !(WORLD.PATH()).map.is.is(tox, toy)) {
/*  92 */           return null;
/*     */         }
/*     */         
/*  95 */         GUTIL.flooder().init(WPATHING.class);
/*  96 */         GUTIL.flooder().pushSloppy(fromX, fromY, 0.0D);
/*  97 */         while (GUTIL.flooder().hasMore()) {
/*     */           
/*  99 */           PathTile t = GUTIL.flooder().pollSmallest();
/* 100 */           if (t.isSameAs(tox, toy)) {
/* 101 */             GUTIL.flooder().done();
/* 102 */             return t;
/*     */           } 
/* 104 */           for (int di = 0; di < DIR.ALL.size(); di++) {
/* 105 */             DIR d = (DIR)DIR.ALL.get(di);
/* 106 */             int dx = t.x() + d.x();
/* 107 */             int dy = t.y() + d.y();
/* 108 */             if ((WORLD.PATH()).map.is.is(dx, dy)) {
/* 109 */               GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance() * WPATHING.cost(t.x(), t.y(), d), t);
/*     */             }
/*     */           } 
/*     */         } 
/* 113 */         GUTIL.flooder().done();
/* 114 */         return null;
/*     */       }
/*     */     };
/*     */   
/* 118 */   public final TEST make = new TEST()
/*     */     {
/*     */ 
/*     */       
/*     */       public PathTile make(boolean isShip, int fromX, int fromY, int tox, int toy)
/*     */       {
/* 124 */         if (!(WORLD.PATH()).map.is.is(fromX, fromY) || !(WORLD.PATH()).map.is.is(tox, toy)) {
/* 125 */           return null;
/*     */         }
/* 127 */         GUTIL.flooder().init(WPATHING.class);
/*     */         
/* 129 */         GUTIL.flooder().pushSloppy(fromX, fromY, 0.0D);
/* 130 */         while (GUTIL.flooder().hasMore()) {
/*     */           
/* 132 */           PathTile t = GUTIL.flooder().pollSmallest();
/* 133 */           if (t.isSameAs(tox, toy)) {
/* 134 */             GUTIL.flooder().done();
/* 135 */             return t;
/*     */           } 
/* 137 */           process(t);
/*     */         } 
/*     */ 
/*     */         
/* 141 */         GUTIL.flooder().done();
/* 142 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       private void process(PathTile t) {
/* 147 */         for (int di = 0; di < DIR.ALL.size(); di++) {
/* 148 */           DIR d = (DIR)DIR.ALL.get(di);
/* 149 */           int dx = t.x() + d.x();
/* 150 */           int dy = t.y() + d.y();
/* 151 */           if ((WORLD.PATH()).map.is.is(dx, dy)) {
/* 152 */             if ((WORLD.WATER()).isBig.is((COORDINATE)t)) {
/* 153 */               if (WORLD.WATER().canTravelToByBoat(t.x(), t.y(), d) || (WORLD.PATH()).map.is.is(dx, dy, d)) {
/* 154 */                 GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance() * WPATHING.cost(t.x(), t.y(), d), t);
/*     */               }
/*     */             }
/* 157 */             else if ((WORLD.WATER()).isBig.is(dx, dy)) {
/* 158 */               if ((WORLD.PATH()).map.is.is(dx, dy))
/* 159 */                 GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance() + 10.0D, t); 
/*     */             } else {
/* 161 */               GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance() * WPATHING.cost(t.x(), t.y(), d), t);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 173 */   public final TEST makeFancy = new TEST()
/*     */     {
/*     */       
/*     */       public PathTile make(boolean isShip, int fromX, int fromY, int tox, int toy)
/*     */       {
/* 178 */         PathTile t = WORLD.PATH().path(fromX, fromY, tox, toy);
/* 179 */         if (t == null) {
/* 180 */           LOG.ln("" + fromX + " " + fromX + " " + fromY + " " + tox);
/*     */         }
/* 182 */         return t;
/*     */       }
/*     */     };
/*     */   
/*     */   static interface TEST {
/*     */     PathTile make(boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\DebugTest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */