/*    */ package world.map.terrain;
/*    */ 
/*    */ import snake2d.PathTile;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.rnd.HeightMap;
/*    */ import util.GUTIL;
/*    */ import world.WORLD;
/*    */ import world.WorldGen;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class GeneratorMountains
/*    */ {
/* 17 */   private final int pen = WORLD.TAREA();
/*    */ 
/*    */   
/*    */   GeneratorMountains(HeightMap height, WorldGen spec) {
/* 21 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 22 */       if (height.get(c) > 0.75D) {
/* 23 */         WORLD.MOUNTAIN().placeRaw(c.x(), c.y()); continue;
/*    */       } 
/* 25 */       WORLD.MOUNTAIN().pClear(c.x(), c.y());
/*    */     } 
/*    */ 
/*    */     
/* 29 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 30 */       GUTIL.flooder().setValue2(c, 0.0D);
/*    */     }
/*    */     
/* 33 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 34 */       if (WORLD.MOUNTAIN().getHeight(c.x(), c.y()) == 0) {
/* 35 */         fill(c.x(), c.y());
/*    */ 
/*    */         
/*    */         break;
/*    */       } 
/*    */     } 
/*    */     
/* 42 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 43 */       if (WORLD.MOUNTAIN().getHeight(c.x(), c.y()) == 0 && GUTIL.flooder().getValue2(c.x(), c.y()) == 0.0F) {
/* 44 */         connect(c.x(), c.y());
/* 45 */         fill(c.x(), c.y());
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void fill(int sx, int sy) {
/* 51 */     GUTIL.flooder().init(this);
/* 52 */     GUTIL.flooder().pushSloppy(sx, sy, 0.0D);
/* 53 */     while (GUTIL.flooder().hasMore()) {
/* 54 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 55 */       t.setValue2(1.0D);
/* 56 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 57 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 58 */         int dx = t.x() + d.x();
/* 59 */         int dy = t.y() + d.y();
/* 60 */         if (WORLD.IN_BOUNDS(dx, dy))
/*    */         {
/* 62 */           if (WORLD.MOUNTAIN().getHeight(dx, dy) <= 0)
/*    */           {
/* 64 */             if (GUTIL.flooder().getValue2(dx, dy) != 1.0F)
/*    */             {
/* 66 */               GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance(), t); }  } 
/*    */         }
/*    */       } 
/*    */     } 
/* 70 */     GUTIL.flooder().done();
/*    */   }
/*    */   
/*    */   private void connect(int sx, int sy) {
/* 74 */     GUTIL.flooder().init(this);
/* 75 */     GUTIL.flooder().pushSloppy(sx, sy, 0.0D);
/*    */     
/* 77 */     while (GUTIL.flooder().hasMore()) {
/* 78 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 79 */       if (t.getValue2() == 1.0F) {
/* 80 */         GUTIL.flooder().done();
/* 81 */         while (t != null) {
/* 82 */           WORLD.MOUNTAIN().pClear(t.x(), t.y());
/* 83 */           t = t.getParent();
/*    */         } 
/*    */         return;
/*    */       } 
/* 87 */       for (DIR d : DIR.ORTHO) {
/* 88 */         if (WORLD.IN_BOUNDS((COORDINATE)t, d)) {
/* 89 */           double v = ((WORLD.MOUNTAIN().getHeight(t.x() + d.x(), t.y() + d.y()) > 0) ? this.pen : true);
/* 90 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + v * d.tileDistance(), t);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 95 */     GUTIL.flooder().done();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\GeneratorMountains.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */