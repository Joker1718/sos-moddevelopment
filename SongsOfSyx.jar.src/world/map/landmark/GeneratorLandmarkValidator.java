/*     */ package world.map.landmark;
/*     */ 
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import util.GUTIL;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class GeneratorLandmarkValidator
/*     */ {
/*  22 */   private static CharSequence ¤¤error = "¤This landmark does not have a connected body. Landmarks must be connected. Landmark:";
/*     */   
/*     */   static {
/*  25 */     D.ts(GeneratorLandmarkValidator.class);
/*     */   }
/*     */   
/*  28 */   private final Rec work = new Rec();
/*     */   
/*     */   public GeneratorLandmarkValidator(WORLD.WorldError error) {
/*  31 */     Bitmap2D check = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*  32 */     Bitmap1D inited = new Bitmap1D(255, false);
/*     */     
/*  34 */     boolean hasOne = false;
/*     */     
/*  36 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       
/*  38 */       if (check.is(c)) {
/*     */         continue;
/*     */       }
/*  41 */       WorldLandmark m = (WorldLandmark)(WORLD.LANDMARKS()).setter.get(c);
/*     */       
/*  43 */       if (m == null) {
/*     */         continue;
/*     */       }
/*  46 */       if (inited.get(m.index())) {
/*  47 */         CharSequence prob = String.valueOf(¤¤error) + " ID: " + String.valueOf(¤¤error) + " , name: " + m.index();
/*  48 */         if (error != null) {
/*  49 */           error.coo.set(c);
/*  50 */           error.problem = prob;
/*     */           return;
/*     */         } 
/*  53 */         LOG.err(inited);
/*     */       } 
/*     */ 
/*     */       
/*  57 */       fill(c, check, m);
/*  58 */       inited.set(m.index(), true);
/*  59 */       hasOne = true;
/*     */     } 
/*     */     
/*  62 */     if (!hasOne && error != null) {
/*  63 */       error.warning = "No landmarks are on the current map.";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fill(COORDINATE start, Bitmap2D check, WorldLandmark a) {
/*  70 */     GUTIL.filler().init(this);
/*  71 */     (GUTIL.filler()).filler.set(start);
/*     */     
/*  73 */     int x1 = WORLD.TWIDTH();
/*  74 */     int x2 = -1;
/*  75 */     int y1 = WORLD.THEIGHT();
/*  76 */     int y2 = -1;
/*  77 */     int area = 0;
/*     */     
/*  79 */     while (GUTIL.filler().hasMore()) {
/*  80 */       COORDINATE c = GUTIL.filler().poll();
/*  81 */       if (!(WORLD.LANDMARKS()).setter.is(c, a)) {
/*  82 */         if (c.x() < x1)
/*  83 */           x1 = c.x(); 
/*  84 */         if (c.x() > x2)
/*  85 */           x2 = c.x(); 
/*  86 */         if (c.y() < y1)
/*  87 */           y1 = c.y(); 
/*  88 */         if (c.y() > y2)
/*  89 */           y2 = c.y();  continue;
/*     */       } 
/*  91 */       area++;
/*  92 */       check.set(c.x(), c.y(), true);
/*  93 */       for (DIR d : DIR.ORTHO) {
/*  94 */         if (WORLD.TBOUNDS().holdsPoint(c, d)) {
/*  95 */           (GUTIL.filler()).filler.set(c, d);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 101 */     GUTIL.filler().done();
/*     */ 
/*     */     
/* 104 */     GUTIL.flooder().init(this);
/* 105 */     this.work.set(x1, x2, y1, y2);
/* 106 */     int cx = this.work.cX();
/* 107 */     int cy = this.work.cY();
/* 108 */     int dist = Integer.MAX_VALUE;
/* 109 */     for (int y = y1; y <= y2; y++) {
/* 110 */       for (int x = x1; x <= x2; x++) {
/* 111 */         if (!(WORLD.LANDMARKS()).setter.is(x, y, a) || this.work.isOnEdge(x, y)) {
/* 112 */           GUTIL.flooder().pushSloppy(x, y, 0.0D);
/*     */         }
/*     */       } 
/*     */     } 
/* 116 */     PathTile t = null;
/* 117 */     while (GUTIL.flooder().hasMore()) {
/* 118 */       t = GUTIL.flooder().pollSmallest();
/*     */       
/* 120 */       if ((WORLD.LANDMARKS()).setter.is((COORDINATE)t, a) && 
/* 121 */         COORDINATE.tileDistance(t.x(), t.y(), this.work.cX(), this.work.cY()) < dist) {
/* 122 */         cx = t.x();
/* 123 */         cy = t.y();
/* 124 */         dist = (int)COORDINATE.tileDistance(t.x(), t.y(), this.work.cX(), this.work.cY());
/*     */       } 
/*     */ 
/*     */       
/* 128 */       for (DIR d : DIR.ORTHO) {
/* 129 */         if (this.work.holdsPoint((COORDINATE)t, d))
/* 130 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance()); 
/*     */       } 
/*     */     } 
/* 133 */     GUTIL.flooder().done();
/*     */     
/* 135 */     if (t.getValue() > 14.0F) {
/* 136 */       a.init(t.x(), t.y(), area, 3);
/* 137 */     } else if (t.getValue() > 8.0F) {
/* 138 */       a.init(t.x(), t.y(), area, 2);
/* 139 */     } else if (t.getValue() > 5.0F) {
/* 140 */       a.init(t.x(), t.y(), area, 1);
/*     */     } else {
/* 142 */       a.init(cx, cy, area, 0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\GeneratorLandmarkValidator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */