/*     */ package world.map.terrain;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import util.GUTIL;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ import world.map.regions.centre.WorldCentrePlacablity;
/*     */ import world.map.road.WTRAV;
/*     */ 
/*     */ final class GeneratorValidator
/*     */   extends Bitmap2D {
/*  17 */   private final Bitmap2D tested = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*     */   
/*  19 */   private static CharSequence ¤¤noRoom = "There is no room for a single settlement on the map. Make sure there is at least one 3x3 area where a city can be.";
/*  20 */   private static CharSequence ¤¤notConnected = "This area is isolated by the terrain. Make sure there is an open path to this place.";
/*     */   
/*     */   static {
/*  23 */     D.ts(GeneratorValidator.class);
/*     */   }
/*     */   
/*     */   public GeneratorValidator(WORLD.WorldError error) {
/*  27 */     super((DIMENSION)WORLD.TBOUNDS(), false);
/*  28 */     Rec tBound = new Rec(WORLD.TBOUNDS());
/*     */     
/*  30 */     boolean hasOne = false;
/*     */     
/*  32 */     for (COORDINATE c : tBound) {
/*  33 */       if (WorldCentrePlacablity.terrainC(c.x(), c.y()) == null) {
/*  34 */         fill(c.x(), c.y());
/*  35 */         hasOne = true;
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  43 */     if (!hasOne) {
/*  44 */       if (error != null) {
/*  45 */         error.coo.set((WORLD.TWIDTH() / 2), (WORLD.THEIGHT() / 2));
/*  46 */         error.problem = ¤¤noRoom;
/*     */         
/*     */         return;
/*     */       } 
/*  50 */       GUTIL.flooder().init(this);
/*  51 */       PathTile t = GUTIL.flooder().pushSloppy(WORLD.TWIDTH() / 2, WORLD.THEIGHT() / 2, 0.0D);
/*  52 */       hasOne = true;
/*  53 */       t = GUTIL.flooder().pushSmaller(WORLD.TWIDTH() / 2 + 1, WORLD.THEIGHT() / 2 + 1, 0.0D, t);
/*  54 */       GUTIL.flooder().done();
/*     */       
/*  56 */       while (t != null) {
/*  57 */         WORLD.MOUNTAIN().pClear(t.x(), t.y());
/*  58 */         (WORLD.WATER()).NOTHING.placeRaw(t.x(), t.y());
/*  59 */         t = t.getParent();
/*     */       } 
/*  61 */       fill(WORLD.TWIDTH() / 2, WORLD.THEIGHT() / 2);
/*     */       
/*  63 */       if (!this.tested.is(WORLD.TWIDTH() / 2, WORLD.THEIGHT() / 2)) {
/*  64 */         throw new RuntimeException("WTF " + WORLD.MOUNTAIN().is(WORLD.TWIDTH() / 2, WORLD.THEIGHT() / 2) + " " + (WORLD.WATER()).isBig.is(WORLD.TWIDTH() / 2, WORLD.THEIGHT() / 2));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  70 */     for (COORDINATE c : tBound) {
/*  71 */       if (!this.tested.is(c) && WorldCentrePlacablity.terrainC(c.x(), c.y()) == null) {
/*  72 */         if (error != null) {
/*  73 */           error.coo.set(c);
/*  74 */           error.problem = ¤¤notConnected;
/*     */           return;
/*     */         } 
/*  77 */         connect(c);
/*  78 */         fill(c.x(), c.y());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void connect(COORDINATE c) {
/*  86 */     GUTIL.flooder().init(this);
/*  87 */     GUTIL.flooder().pushSloppy(c, 0.0D);
/*     */     
/*  89 */     while (GUTIL.flooder().hasMore()) {
/*  90 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  91 */       if (this.tested.is((COORDINATE)t)) {
/*     */         
/*  93 */         GUTIL.flooder().done();
/*  94 */         fix(t);
/*  95 */         GUTIL.flooder().reverse(t);
/*  96 */         fix(t);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 102 */       for (DIR d : DIR.ORTHO) {
/* 103 */         if (WORLD.IN_BOUNDS((COORDINATE)t, d)) {
/* 104 */           if (WTRAV.can(t.x(), t.y(), d, false)) {
/* 105 */             GUTIL.flooder().pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F), t); continue;
/*     */           } 
/* 107 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, (t.getValue() + 15.0F), t);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 113 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fill(int sx, int sy) {
/* 124 */     GUTIL.flooder().init(this);
/* 125 */     GUTIL.flooder().pushSloppy(sx, sy, 0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     while (GUTIL.flooder().hasMore()) {
/* 134 */       PathTile c = GUTIL.flooder().pollSmallest();
/*     */       
/* 136 */       this.tested.set((COORDINATE)c, true);
/*     */ 
/*     */       
/* 139 */       for (DIR d : DIR.ORTHO) {
/* 140 */         if (WORLD.IN_BOUNDS((COORDINATE)c, d) && WTRAV.can(c.x(), c.y(), d, false)) {
/* 141 */           GUTIL.flooder().pushSmaller((COORDINATE)c, d, (c.getValue() + 1.0F));
/*     */         }
/*     */       } 
/*     */     } 
/* 145 */     GUTIL.filler().done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fix(PathTile t) {
/* 151 */     if (t.getParent() == null) {
/* 152 */       WORLD.MOUNTAIN().pClear(t.x(), t.y());
/* 153 */       (WORLD.WATER()).NOTHING.placeRaw(t.x(), t.y());
/*     */       
/*     */       return;
/*     */     } 
/* 157 */     PathTile from = t;
/* 158 */     t = t.getParent();
/*     */     
/* 160 */     while (t != null) {
/* 161 */       DIR d = DIR.get((COORDINATE)from, (COORDINATE)t);
/* 162 */       if (!WTRAV.can(from.x(), from.y(), d, false)) {
/* 163 */         WORLD.MOUNTAIN().pClear(from.x(), from.y());
/* 164 */         (WORLD.WATER()).NOTHING.placeRaw(from.x(), from.y());
/* 165 */         WORLD.MOUNTAIN().pClear(t.x(), t.y());
/* 166 */         (WORLD.WATER()).NOTHING.placeRaw(t.x(), t.y());
/*     */       } 
/* 168 */       from = t;
/* 169 */       t = t.getParent();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\GeneratorValidator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */