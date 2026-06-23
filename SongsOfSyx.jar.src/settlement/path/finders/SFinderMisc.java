/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.GUTIL;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSingle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SFinderMisc
/*     */ {
/*     */   private final double max;
/*     */   
/*     */   protected SFinderMisc(int max) {
/*  30 */     this.max = max;
/*     */   }
/*     */   
/*     */   protected boolean has() {
/*  34 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract boolean isTile(int paramInt1, int paramInt2);
/*     */   
/*     */   public final boolean find(COORDINATE start, SPath path) {
/*  41 */     if (!has()) {
/*  42 */       return false;
/*     */     }
/*  44 */     if (isTile(start.x(), start.y())) {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     GUTIL.flooder().init(this);
/*  49 */     GUTIL.flooder().pushSloppy(start.x(), start.y(), 0.0D, null);
/*     */     
/*  51 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/*  53 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/*  55 */       if (isTile(t.x(), t.y())) {
/*  56 */         path.setDirect(start.x(), start.y(), t.x(), t.y(), t, true);
/*  57 */         GUTIL.flooder().done();
/*  58 */         return true;
/*     */       } 
/*     */       
/*  61 */       for (DIR d : DIR.ALL) {
/*     */         
/*  63 */         int dx = d.x() + t.x();
/*  64 */         int dy = d.y() + t.y();
/*  65 */         if (!SETT.IN_BOUNDS(dx, dy))
/*     */           continue; 
/*  67 */         if (!(SETT.PATH()).connectivity.is(dx, dy)) {
/*     */           continue;
/*     */         }
/*  70 */         double v = (SETT.PATH()).huristics.getCost(t.x(), t.y(), dx, dy);
/*  71 */         if (v < 0.0D)
/*     */           continue; 
/*  73 */         v *= d.tileDistance();
/*  74 */         v += t.getValue();
/*  75 */         if (v <= this.max)
/*  76 */           GUTIL.flooder().pushSmaller(dx, dy, v, t); 
/*     */       } 
/*     */     } 
/*  79 */     GUTIL.flooder().done();
/*     */     
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class FinderIdle
/*     */   {
/*  91 */     private final ArrayList<DIR> dirs = new ArrayList((Iterable)DIR.ALL);
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean find(COORDINATE start, SPath path, ENTITY e) {
/*  96 */       if (isGoodTileToStandOn(start.x(), start.y(), e)) {
/*  97 */         return false;
/*     */       }
/*     */       
/* 100 */       GUTIL.flooder().init(null);
/* 101 */       PathTile t = GUTIL.flooder().pushSloppy(start.x(), start.y(), 0.0D, null);
/*     */       
/* 103 */       while (GUTIL.flooder().hasMore()) {
/*     */         
/* 105 */         t = GUTIL.flooder().pollSmallest();
/*     */         
/* 107 */         if (isGoodTileToStandOn(t.x(), t.y(), e)) {
/* 108 */           path.setDirect(start.x(), start.y(), t.x(), t.y(), t, true);
/* 109 */           GUTIL.flooder().done();
/* 110 */           return true;
/*     */         } 
/*     */         
/* 113 */         for (DIR d : this.dirs) {
/*     */           
/* 115 */           int dx = d.x() + t.x();
/* 116 */           int dy = d.y() + t.y();
/* 117 */           if (!SETT.IN_BOUNDS(dx, dy))
/*     */             continue; 
/* 119 */           if (!(SETT.PATH()).connectivity.is(dx, dy)) {
/*     */             continue;
/*     */           }
/* 122 */           double v = (SETT.PATH()).huristics.getCost(t.x(), t.y(), dx, dy);
/* 123 */           if (v < 0.0D)
/*     */             continue; 
/* 125 */           v *= d.tileDistance();
/* 126 */           v += t.getValue();
/* 127 */           if (v <= 40.0D)
/* 128 */             GUTIL.flooder().pushSmaller(dx, dy, v, t); 
/*     */         } 
/*     */       } 
/* 131 */       GUTIL.flooder().done();
/*     */       
/* 133 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean isGoodTileToStandOn(int tx, int ty, ENTITY e) {
/* 138 */       if (((SETT.PATH()).availability.get(tx, ty)).player < 0.0D)
/* 139 */         return false; 
/* 140 */       if (((SETT.PATH()).availability.get(tx, ty)).player >= 2.0D)
/* 141 */         return false; 
/* 142 */       if ((SETT.JOBS()).getter.is(tx, ty))
/* 143 */         return false; 
/* 144 */       if (SETT.THINGS().getFirst(tx, ty) != null)
/* 145 */         return false; 
/* 146 */       if (SETT.ENTITIES().hasAtTile(e, tx, ty))
/* 147 */         return false; 
/* 148 */       if ((SETT.PATH()).huristics.getter.get(tx, ty) > 0.1D)
/* 149 */         return false; 
/* 150 */       if ((SETT.ROOMS()).map.is(tx, ty))
/* 151 */         return false; 
/* 152 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class FinderMiscWithoutDest
/*     */   {
/*     */     private final double max;
/*     */     
/*     */     protected FinderMiscWithoutDest(int max) {
/* 162 */       this.max = max;
/*     */     }
/*     */     
/*     */     protected boolean has() {
/* 166 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract boolean isTile(int param1Int1, int param1Int2);
/*     */     
/*     */     public final boolean find(COORDINATE start, SPath path) {
/* 173 */       if (!has()) {
/* 174 */         return false;
/*     */       }
/* 176 */       int sx = start.x();
/* 177 */       int sy = start.y();
/*     */       
/* 179 */       if (isTile(sx, sy)) {
/* 180 */         if (path != null) {
/* 181 */           path.request(sx, sy, sx, sy, false);
/* 182 */           return path.isSuccessful();
/*     */         } 
/* 184 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 188 */       for (DIR d : DIR.ORTHO) {
/* 189 */         if (isTile(sx + d.x(), sy + d.y())) {
/* 190 */           if (path != null) {
/* 191 */             path.request(sx, sy, sx + d.x(), sy + d.y(), false);
/* 192 */             return path.isSuccessful();
/*     */           } 
/* 194 */           return true;
/*     */         } 
/*     */       } 
/*     */       
/* 198 */       GUTIL.flooder().init(this);
/*     */       
/* 200 */       PathTile t = GUTIL.flooder().pushSloppy(sx, sy, 0.0D, null);
/*     */       
/* 202 */       while (GUTIL.flooder().hasMore()) {
/*     */         
/* 204 */         t = GUTIL.flooder().pollSmallest();
/*     */         
/* 206 */         for (DIR d : DIR.ALL) {
/*     */           
/* 208 */           int dx = d.x() + t.x();
/* 209 */           int dy = d.y() + t.y();
/* 210 */           if (!SETT.IN_BOUNDS(dx, dy))
/*     */             continue; 
/* 212 */           if (d.isOrtho() && 
/* 213 */             isTile(dx, dy)) {
/* 214 */             GUTIL.flooder().done();
/* 215 */             if (path != null) {
/* 216 */               path.setDirect(sx, sy, dx, dy, t, false);
/*     */             }
/* 218 */             return true;
/*     */           } 
/*     */ 
/*     */           
/* 222 */           double v = (SETT.PATH()).huristics.getCost(t.x(), t.y(), dx, dy);
/* 223 */           if (v < 0.0D)
/*     */             continue; 
/* 225 */           v *= d.tileDistance();
/* 226 */           v += t.getValue();
/* 227 */           if (v <= this.max)
/* 228 */             GUTIL.flooder().pushSmaller(dx, dy, v, t); 
/*     */         } 
/*     */       } 
/* 231 */       GUTIL.flooder().done();
/*     */ 
/*     */ 
/*     */       
/* 235 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class FinderArround
/*     */   {
/* 243 */     private Coo result = new Coo();
/*     */     
/*     */     FinderArround() {
/* 246 */       IDebugPanelSett.add((PLACABLE)new PlacableSingle("arround")
/*     */           {
/*     */             public void placeFirst(int tx, int ty)
/*     */             {
/* 250 */               COORDINATE c = SFinderMisc.FinderArround.this.find(tx, ty, 10.0D, (10 + RND.rInt(10)));
/* 251 */               if (c == null)
/* 252 */                 LOG.ln("nono"); 
/* 253 */               LOG.ln("" + c.x() + " " + c.x());
/*     */             }
/*     */ 
/*     */             
/*     */             public CharSequence isPlacable(int tx, int ty) {
/* 258 */               SComp0 sComp0 = (SETT.PATH()).comps.zero.get(tx, ty);
/* 259 */               if (sComp0 == null) {
/* 260 */                 return E;
/*     */               }
/* 262 */               return null;
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public COORDINATE find(int sx, int sy, double distMin, double distMax) {
/* 276 */       SComponent su = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/* 277 */       if (su == null)
/* 278 */         return null; 
/* 279 */       boolean found = false;
/* 280 */       double dd = distMin + RND.rFloat(distMax - distMin);
/* 281 */       GUTIL.flooder().init(this);
/* 282 */       PathTile t = GUTIL.flooder().close(sx, sy, 0.0D, null);
/*     */       
/* 284 */       for (DIR d : DIR.ALL) {
/* 285 */         found = push(t, d, su) | found;
/*     */       }
/*     */       
/* 288 */       while (GUTIL.flooder().hasMore()) {
/*     */         
/* 290 */         t = GUTIL.flooder().pollSmallest();
/*     */         
/* 292 */         if (t.getValue() >= dd) {
/* 293 */           GUTIL.flooder().done();
/* 294 */           return (COORDINATE)this.result;
/*     */         } 
/*     */         
/* 297 */         for (DIR d : DIR.ALL) {
/* 298 */           found = push(t, d, su) | found;
/*     */         }
/*     */       } 
/* 301 */       GUTIL.flooder().done();
/* 302 */       if (found) {
/* 303 */         return (COORDINATE)this.result;
/*     */       }
/* 305 */       return null;
/*     */     }
/*     */     
/*     */     private boolean push(PathTile t, DIR d, SComponent su) {
/* 309 */       int dx = d.x() + t.x();
/* 310 */       int dy = d.y() + t.y();
/* 311 */       if (!SETT.IN_BOUNDS(dx, dy))
/* 312 */         return false; 
/* 313 */       SComp0 sComp0 = (SETT.PATH()).comps.zero.get(dx, dy);
/* 314 */       if (sComp0 == null || sComp0.superCompTop() != su) {
/* 315 */         return false;
/*     */       }
/* 317 */       double v = d.tileDistance();
/* 318 */       if (v < 0.0D)
/* 319 */         return false; 
/* 320 */       v *= d.tileDistance() * RND.rFloat1(0.1D);
/* 321 */       v += t.getValue();
/* 322 */       GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + v, t);
/* 323 */       this.result.set(dx, dy);
/* 324 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Rnd
/*     */   {
/* 333 */     private Coo result = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public COORDINATE find(int sx, int sy, int r) {
/* 348 */       SCompFinder.SCompPath p = (SETT.PATH()).comps.pather.fill(sx, sy, r);
/*     */       
/* 350 */       if (p.path().size() == 0) {
/* 351 */         return null;
/*     */       }
/* 353 */       SComponent s = (SComponent)p.path().rnd();
/*     */       
/* 355 */       GUTIL.coos().set(0);
/*     */       
/* 357 */       r = s.level().size();
/*     */       
/* 359 */       int x1 = s.centreX() & (r - 1 ^ 0xFFFFFFFF);
/* 360 */       int y1 = s.centreY() & (r - 1 ^ 0xFFFFFFFF);
/*     */       
/* 362 */       for (int dy = 0; dy < r; dy++) {
/* 363 */         for (int dx = 0; dx < r; dx++) {
/* 364 */           int x = x1 + dx;
/* 365 */           int y = y1 + dy;
/* 366 */           if (s.is(x, y)) {
/* 367 */             GUTIL.coos().get().set(x, y);
/* 368 */             GUTIL.coos().inc();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 373 */       if (GUTIL.coos().getI() == 0) {
/* 374 */         this.result.set(s.centreX(), s.centreY());
/* 375 */         return (COORDINATE)this.result;
/*     */       } 
/*     */       
/* 378 */       this.result.set((COORDINATE)GUTIL.coos().set(RND.rInt(GUTIL.coos().getI())));
/* 379 */       return (COORDINATE)this.result;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderMisc.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */