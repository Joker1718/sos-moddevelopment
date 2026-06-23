/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FinderMiscWithoutDest
/*     */ {
/*     */   private final double max;
/*     */   
/*     */   protected FinderMiscWithoutDest(int max) {
/* 162 */     this.max = max;
/*     */   }
/*     */   
/*     */   protected boolean has() {
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract boolean isTile(int paramInt1, int paramInt2);
/*     */   
/*     */   public final boolean find(COORDINATE start, SPath path) {
/* 173 */     if (!has()) {
/* 174 */       return false;
/*     */     }
/* 176 */     int sx = start.x();
/* 177 */     int sy = start.y();
/*     */     
/* 179 */     if (isTile(sx, sy)) {
/* 180 */       if (path != null) {
/* 181 */         path.request(sx, sy, sx, sy, false);
/* 182 */         return path.isSuccessful();
/*     */       } 
/* 184 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 188 */     for (DIR d : DIR.ORTHO) {
/* 189 */       if (isTile(sx + d.x(), sy + d.y())) {
/* 190 */         if (path != null) {
/* 191 */           path.request(sx, sy, sx + d.x(), sy + d.y(), false);
/* 192 */           return path.isSuccessful();
/*     */         } 
/* 194 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 198 */     GUTIL.flooder().init(this);
/*     */     
/* 200 */     PathTile t = GUTIL.flooder().pushSloppy(sx, sy, 0.0D, null);
/*     */     
/* 202 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 204 */       t = GUTIL.flooder().pollSmallest();
/*     */       
/* 206 */       for (DIR d : DIR.ALL) {
/*     */         
/* 208 */         int dx = d.x() + t.x();
/* 209 */         int dy = d.y() + t.y();
/* 210 */         if (!SETT.IN_BOUNDS(dx, dy))
/*     */           continue; 
/* 212 */         if (d.isOrtho() && 
/* 213 */           isTile(dx, dy)) {
/* 214 */           GUTIL.flooder().done();
/* 215 */           if (path != null) {
/* 216 */             path.setDirect(sx, sy, dx, dy, t, false);
/*     */           }
/* 218 */           return true;
/*     */         } 
/*     */ 
/*     */         
/* 222 */         double v = (SETT.PATH()).huristics.getCost(t.x(), t.y(), dx, dy);
/* 223 */         if (v < 0.0D)
/*     */           continue; 
/* 225 */         v *= d.tileDistance();
/* 226 */         v += t.getValue();
/* 227 */         if (v <= this.max)
/* 228 */           GUTIL.flooder().pushSmaller(dx, dy, v, t); 
/*     */       } 
/*     */     } 
/* 231 */     GUTIL.flooder().done();
/*     */ 
/*     */ 
/*     */     
/* 235 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderMisc$FinderMiscWithoutDest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */