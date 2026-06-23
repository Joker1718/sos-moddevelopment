/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FinderIdle
/*     */ {
/*  91 */   private final ArrayList<DIR> dirs = new ArrayList((Iterable)DIR.ALL);
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean find(COORDINATE start, SPath path, ENTITY e) {
/*  96 */     if (isGoodTileToStandOn(start.x(), start.y(), e)) {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     GUTIL.flooder().init(null);
/* 101 */     PathTile t = GUTIL.flooder().pushSloppy(start.x(), start.y(), 0.0D, null);
/*     */     
/* 103 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 105 */       t = GUTIL.flooder().pollSmallest();
/*     */       
/* 107 */       if (isGoodTileToStandOn(t.x(), t.y(), e)) {
/* 108 */         path.setDirect(start.x(), start.y(), t.x(), t.y(), t, true);
/* 109 */         GUTIL.flooder().done();
/* 110 */         return true;
/*     */       } 
/*     */       
/* 113 */       for (DIR d : this.dirs) {
/*     */         
/* 115 */         int dx = d.x() + t.x();
/* 116 */         int dy = d.y() + t.y();
/* 117 */         if (!SETT.IN_BOUNDS(dx, dy))
/*     */           continue; 
/* 119 */         if (!(SETT.PATH()).connectivity.is(dx, dy)) {
/*     */           continue;
/*     */         }
/* 122 */         double v = (SETT.PATH()).huristics.getCost(t.x(), t.y(), dx, dy);
/* 123 */         if (v < 0.0D)
/*     */           continue; 
/* 125 */         v *= d.tileDistance();
/* 126 */         v += t.getValue();
/* 127 */         if (v <= 40.0D)
/* 128 */           GUTIL.flooder().pushSmaller(dx, dy, v, t); 
/*     */       } 
/*     */     } 
/* 131 */     GUTIL.flooder().done();
/*     */     
/* 133 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isGoodTileToStandOn(int tx, int ty, ENTITY e) {
/* 138 */     if (((SETT.PATH()).availability.get(tx, ty)).player < 0.0D)
/* 139 */       return false; 
/* 140 */     if (((SETT.PATH()).availability.get(tx, ty)).player >= 2.0D)
/* 141 */       return false; 
/* 142 */     if ((SETT.JOBS()).getter.is(tx, ty))
/* 143 */       return false; 
/* 144 */     if (SETT.THINGS().getFirst(tx, ty) != null)
/* 145 */       return false; 
/* 146 */     if (SETT.ENTITIES().hasAtTile(e, tx, ty))
/* 147 */       return false; 
/* 148 */     if ((SETT.PATH()).huristics.getter.get(tx, ty) > 0.1D)
/* 149 */       return false; 
/* 150 */     if ((SETT.ROOMS()).map.is(tx, ty))
/* 151 */       return false; 
/* 152 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderMisc$FinderIdle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */