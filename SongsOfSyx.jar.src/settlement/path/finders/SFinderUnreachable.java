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
/*     */ public final class SFinderUnreachable
/*     */ {
/*     */   public boolean find(COORDINATE start, SPath path, int maxDistance) {
/*  22 */     if ((SETT.TERRAIN()).WATER.open.is(start.x(), start.y())) {
/*  23 */       return findWater(start, path, maxDistance);
/*     */     }
/*  25 */     if ((SETT.PATH()).connectivity.is(start)) {
/*  26 */       return false;
/*     */     }
/*     */     
/*  29 */     int tx = start.x();
/*  30 */     int ty = start.y();
/*     */     
/*  32 */     GUTIL.flooder().init(this);
/*  33 */     PathTile t = GUTIL.flooder().pushSloppy(tx, ty, 0.0D);
/*     */ 
/*     */     
/*  36 */     while (GUTIL.flooder().hasMore()) {
/*  37 */       t = GUTIL.flooder().pollSmallest();
/*     */       
/*  39 */       if ((SETT.PATH()).connectivity.is((COORDINATE)t)) {
/*  40 */         GUTIL.flooder().done();
/*  41 */         path.setDirect(start.x(), start.y(), t.x(), t.y(), t, true);
/*  42 */         return true;
/*     */       } 
/*  44 */       if (t.getValue() > maxDistance) {
/*     */         continue;
/*     */       }
/*  47 */       for (DIR d : DIR.ALL) {
/*  48 */         double v = t.getValue();
/*  49 */         tx = t.x() + d.x();
/*  50 */         ty = t.y() + d.y();
/*     */         
/*  52 */         if (isPassable(t.x(), t.y(), d)) {
/*  53 */           GUTIL.flooder().pushSloppy(tx, ty, v + d.tileDistance(), t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  59 */     GUTIL.flooder().done();
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findWater(COORDINATE start, SPath path, int maxDistance) {
/*  67 */     int tx = start.x();
/*  68 */     int ty = start.y();
/*  69 */     if (isLand(tx, ty)) {
/*  70 */       path.request(tx, ty, tx, ty, false);
/*  71 */       return path.isSuccessful();
/*     */     } 
/*     */     
/*  74 */     GUTIL.flooder().init(this);
/*  75 */     PathTile t = GUTIL.flooder().pushSloppy(tx, ty, 0.0D);
/*     */     
/*  77 */     int bx = -1;
/*  78 */     int by = -1;
/*     */     
/*  80 */     PathTile backup = null;
/*     */     
/*  82 */     while (GUTIL.flooder().hasMore()) {
/*  83 */       t = GUTIL.flooder().pollSmallest();
/*  84 */       if (isLand(t.x(), t.y())) {
/*  85 */         if ((SETT.PATH()).connectivity.is((COORDINATE)t)) {
/*  86 */           GUTIL.flooder().done();
/*  87 */           path.setDirect(start.x(), start.y(), t.x(), t.y(), t, true);
/*  88 */           return true;
/*     */         } 
/*  90 */         bx = t.x();
/*  91 */         by = t.y();
/*     */       }
/*  93 */       else if (!(SETT.PATH()).solidity.is((COORDINATE)t) && backup == null) {
/*  94 */         backup = t;
/*  95 */       }  if (t.getValue() > maxDistance) {
/*     */         break;
/*     */       }
/*  98 */       for (DIR d : DIR.ALL) {
/*  99 */         double v = t.getValue();
/* 100 */         tx = t.x() + d.x();
/* 101 */         ty = t.y() + d.y();
/*     */         
/* 103 */         if (isPassable(t.x(), t.y(), d)) {
/* 104 */           GUTIL.flooder().pushSloppy(tx, ty, v + d.tileDistance(), t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 109 */     if (bx != -1) {
/* 110 */       t = GUTIL.flooder().get(bx, by);
/* 111 */       GUTIL.flooder().done();
/* 112 */       path.setDirect(start.x(), start.y(), t.x(), t.y(), t, true);
/* 113 */       return true;
/*     */     } 
/* 115 */     GUTIL.flooder().done();
/* 116 */     if (backup != null) {
/* 117 */       path.setDirect(start.x(), start.y(), backup.x(), backup.y(), backup, true);
/* 118 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isPassable(int tx, int ty, DIR d) {
/* 127 */     if (!SETT.IN_BOUNDS(tx + d.x(), ty) || ((SETT.PATH()).availability.get(tx + d.x(), ty)).tileCollide)
/* 128 */       return false; 
/* 129 */     if (!SETT.IN_BOUNDS(tx, ty + d.y()) || ((SETT.PATH()).availability.get(tx, ty + d.y())).tileCollide)
/* 130 */       return false; 
/* 131 */     if (!SETT.IN_BOUNDS(tx + d.x(), ty + d.y()) || ((SETT.PATH()).availability.get(tx + d.x(), ty + d.y())).tileCollide)
/* 132 */       return false; 
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isLand(int tx, int ty) {
/* 137 */     return (!isWater(tx, ty) && !(SETT.PATH()).solidity.is(tx, ty));
/*     */   }
/*     */   
/*     */   private boolean isWater(int tx, int ty) {
/* 141 */     return (SETT.ENTITIES()).submerged.is(tx, ty);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderUnreachable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */