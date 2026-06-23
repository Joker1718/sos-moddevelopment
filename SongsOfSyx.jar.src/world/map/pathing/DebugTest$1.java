/*     */ package world.map.pathing;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.GUTIL;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements DebugTest.TEST
/*     */ {
/*     */   public PathTile make(boolean isShip, int fromX, int fromY, int tox, int toy) {
/*  91 */     if (!(WORLD.PATH()).map.is.is(fromX, fromY) || !(WORLD.PATH()).map.is.is(tox, toy)) {
/*  92 */       return null;
/*     */     }
/*     */     
/*  95 */     GUTIL.flooder().init(WPATHING.class);
/*  96 */     GUTIL.flooder().pushSloppy(fromX, fromY, 0.0D);
/*  97 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/*  99 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 100 */       if (t.isSameAs(tox, toy)) {
/* 101 */         GUTIL.flooder().done();
/* 102 */         return t;
/*     */       } 
/* 104 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 105 */         DIR d = (DIR)DIR.ALL.get(di);
/* 106 */         int dx = t.x() + d.x();
/* 107 */         int dy = t.y() + d.y();
/* 108 */         if ((WORLD.PATH()).map.is.is(dx, dy)) {
/* 109 */           GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance() * WPATHING.cost(t.x(), t.y(), d), t);
/*     */         }
/*     */       } 
/*     */     } 
/* 113 */     GUTIL.flooder().done();
/* 114 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\DebugTest$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */