/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComponent;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSingle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FinderArround
/*     */ {
/* 243 */   private Coo result = new Coo();
/*     */   
/*     */   FinderArround() {
/* 246 */     IDebugPanelSett.add((PLACABLE)new PlacableSingle("arround")
/*     */         {
/*     */           public void placeFirst(int tx, int ty)
/*     */           {
/* 250 */             COORDINATE c = SFinderMisc.FinderArround.this.find(tx, ty, 10.0D, (10 + RND.rInt(10)));
/* 251 */             if (c == null)
/* 252 */               LOG.ln("nono"); 
/* 253 */             LOG.ln("" + c.x() + " " + c.x());
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/* 258 */             SComp0 sComp0 = (SETT.PATH()).comps.zero.get(tx, ty);
/* 259 */             if (sComp0 == null) {
/* 260 */               return E;
/*     */             }
/* 262 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE find(int sx, int sy, double distMin, double distMax) {
/* 276 */     SComponent su = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/* 277 */     if (su == null)
/* 278 */       return null; 
/* 279 */     boolean found = false;
/* 280 */     double dd = distMin + RND.rFloat(distMax - distMin);
/* 281 */     GUTIL.flooder().init(this);
/* 282 */     PathTile t = GUTIL.flooder().close(sx, sy, 0.0D, null);
/*     */     
/* 284 */     for (DIR d : DIR.ALL) {
/* 285 */       found = push(t, d, su) | found;
/*     */     }
/*     */     
/* 288 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 290 */       t = GUTIL.flooder().pollSmallest();
/*     */       
/* 292 */       if (t.getValue() >= dd) {
/* 293 */         GUTIL.flooder().done();
/* 294 */         return (COORDINATE)this.result;
/*     */       } 
/*     */       
/* 297 */       for (DIR d : DIR.ALL) {
/* 298 */         found = push(t, d, su) | found;
/*     */       }
/*     */     } 
/* 301 */     GUTIL.flooder().done();
/* 302 */     if (found) {
/* 303 */       return (COORDINATE)this.result;
/*     */     }
/* 305 */     return null;
/*     */   }
/*     */   
/*     */   private boolean push(PathTile t, DIR d, SComponent su) {
/* 309 */     int dx = d.x() + t.x();
/* 310 */     int dy = d.y() + t.y();
/* 311 */     if (!SETT.IN_BOUNDS(dx, dy))
/* 312 */       return false; 
/* 313 */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(dx, dy);
/* 314 */     if (sComp0 == null || sComp0.superCompTop() != su) {
/* 315 */       return false;
/*     */     }
/* 317 */     double v = d.tileDistance();
/* 318 */     if (v < 0.0D)
/* 319 */       return false; 
/* 320 */     v *= d.tileDistance() * RND.rFloat1(0.1D);
/* 321 */     v += t.getValue();
/* 322 */     GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + v, t);
/* 323 */     this.result.set(dx, dy);
/* 324 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderMisc$FinderArround.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */