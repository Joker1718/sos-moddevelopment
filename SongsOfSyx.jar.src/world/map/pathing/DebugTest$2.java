/*     */ package world.map.pathing;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 124 */     if (!(WORLD.PATH()).map.is.is(fromX, fromY) || !(WORLD.PATH()).map.is.is(tox, toy)) {
/* 125 */       return null;
/*     */     }
/* 127 */     GUTIL.flooder().init(WPATHING.class);
/*     */     
/* 129 */     GUTIL.flooder().pushSloppy(fromX, fromY, 0.0D);
/* 130 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 132 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 133 */       if (t.isSameAs(tox, toy)) {
/* 134 */         GUTIL.flooder().done();
/* 135 */         return t;
/*     */       } 
/* 137 */       process(t);
/*     */     } 
/*     */ 
/*     */     
/* 141 */     GUTIL.flooder().done();
/* 142 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(PathTile t) {
/* 147 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/* 148 */       DIR d = (DIR)DIR.ALL.get(di);
/* 149 */       int dx = t.x() + d.x();
/* 150 */       int dy = t.y() + d.y();
/* 151 */       if ((WORLD.PATH()).map.is.is(dx, dy))
/* 152 */         if ((WORLD.WATER()).isBig.is((COORDINATE)t)) {
/* 153 */           if (WORLD.WATER().canTravelToByBoat(t.x(), t.y(), d) || (WORLD.PATH()).map.is.is(dx, dy, d)) {
/* 154 */             GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance() * WPATHING.cost(t.x(), t.y(), d), t);
/*     */           }
/*     */         }
/* 157 */         else if ((WORLD.WATER()).isBig.is(dx, dy)) {
/* 158 */           if ((WORLD.PATH()).map.is.is(dx, dy))
/* 159 */             GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance() + 10.0D, t); 
/*     */         } else {
/* 161 */           GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance() * WPATHING.cost(t.x(), t.y(), d), t);
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\DebugTest$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */