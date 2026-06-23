/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorFish
/*     */ {
/*     */   private MAP_BOOLEAN is;
/*     */   
/*     */   GeneratorFish(CapitolArea area, GeneratorUtil util) {
/* 269 */     this.is = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 273 */           return !(!(SETT.TERRAIN()).WATER.DEEP.is(tx, ty) && !(SETT.TERRAIN()).WATER.BRIDGE.is(tx, ty));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 279 */           return false;
/*     */         }
/*     */       };
/*     */     smoothDepth();
/*     */     smooth();
/*     */     makeFish();
/*     */   }
/*     */   
/*     */   private void smooth() {
/*     */     for (COORDINATE c : SETT.TILE_BOUNDS)
/*     */       GUTIL.flooder().setValue2(c, 0.0D); 
/*     */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*     */       if ((SETT.TERRAIN()).WATER.SHALLOW.is(c))
/*     */         smooth(c); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void smooth(COORDINATE start) {
/*     */     if (GUTIL.flooder().getValue(start) != 0.0F)
/*     */       return; 
/*     */     GUTIL.flooder().init(this);
/*     */     GUTIL.flooder().pushSloppy(start, 0.0D);
/*     */     int am = 0;
/*     */     while (GUTIL.flooder().hasMore()) {
/*     */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       if (!(SETT.TERRAIN()).WATER.is.is((COORDINATE)t)) {
/*     */         GUTIL.flooder().done();
/*     */         return;
/*     */       } 
/*     */       GUTIL.flooder().setValue2((COORDINATE)t, 1.0D);
/*     */       if ((SETT.TERRAIN()).WATER.SHALLOW.is((COORDINATE)t)) {
/*     */         am++;
/*     */         for (DIR d : DIR.ORTHO) {
/*     */           if (SETT.IN_BOUNDS((COORDINATE)t, d))
/*     */             GUTIL.flooder().pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F)); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     GUTIL.flooder().done();
/*     */     if (am > 100)
/*     */       return; 
/*     */     GUTIL.flooder().init(this);
/*     */     GUTIL.flooder().pushSloppy(start, 0.0D);
/*     */     while (GUTIL.flooder().hasMore()) {
/*     */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       if ((SETT.TERRAIN()).WATER.SHALLOW.is((COORDINATE)t) && (SETT.TERRAIN()).WATER.groundWaterSalt.is((COORDINATE)t)) {
/*     */         (SETT.TERRAIN()).WATER.DEEP.placeRaw(t.x(), t.y());
/*     */         for (DIR d : DIR.ORTHO) {
/*     */           if (SETT.IN_BOUNDS((COORDINATE)t, d))
/*     */             GUTIL.flooder().pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F)); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     GUTIL.flooder().done();
/*     */   }
/*     */   
/*     */   private void smoothDepth() {
/*     */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     for (COORDINATE c : SETT.TILE_BOUNDS)
/*     */       f.setValue2(c, 0.0D); 
/*     */     for (int y = 0; y < SETT.THEIGHT; y++) {
/*     */       for (int x = 0; x < SETT.TWIDTH; x++)
/*     */         smooth(x, y); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void smooth(int sx, int sy) {
/*     */     if (!this.is.is(sx, sy))
/*     */       return; 
/*     */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     if (f.getValue2(sx, sy) != 0.0F)
/*     */       return; 
/*     */     f.init(this);
/*     */     f.pushSloppy(sx, sy, 0.0D);
/*     */     double tiles = 0.0D;
/*     */     double edgeValue = (SETT.TAREA * 2);
/*     */     while (f.hasMore()) {
/*     */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       f.setValue2((COORDINATE)t, 1.0D);
/*     */       if (t.getValue() >= edgeValue)
/*     */         break; 
/*     */       tiles++;
/*     */       for (DIR d : DIR.ORTHO) {
/*     */         if (SETT.IN_BOUNDS((COORDINATE)t, d))
/*     */           f.pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F) + (this.is.is((COORDINATE)t, d) ? 0.0D : edgeValue)); 
/*     */       } 
/*     */     } 
/*     */     if (tiles < 50.0D) {
/*     */       f.done();
/*     */       f.init(this);
/*     */       f.pushSloppy(sx, sy, 0.0D);
/*     */       while (f.hasMore()) {
/*     */         PathTile t = GUTIL.flooder().pollSmallest();
/*     */         (SETT.TERRAIN()).WATER.SHALLOW.placeRaw(t.x(), t.y());
/*     */         for (DIR d : DIR.ORTHO) {
/*     */           if (SETT.IN_BOUNDS((COORDINATE)t, d) && this.is.is((COORDINATE)t, d))
/*     */             f.pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F)); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     while (f.hasMore()) {
/*     */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       int am = 0;
/*     */       if (this.is.is((COORDINATE)t)) {
/*     */         for (DIR d : DIR.ORTHO) {
/*     */           if ((SETT.TERRAIN()).WATER.SHALLOW.is((COORDINATE)t, d))
/*     */             am++; 
/*     */         } 
/*     */         if (am >= 2)
/*     */           (SETT.TERRAIN()).WATER.SHALLOW.placeRaw(t.x(), t.y()); 
/*     */       } 
/*     */     } 
/*     */     f.done();
/*     */   }
/*     */   
/*     */   private void makeFish() {
/*     */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     (SETT.TERRAIN()).WATER.deepSeaFishSpot.clear();
/*     */     (SETT.TERRAIN()).WATER.fishAmount.clear();
/*     */     for (COORDINATE c : SETT.TILE_BOUNDS)
/*     */       f.setValue2(c, 0.0D); 
/*     */     for (int y = 0; y < SETT.THEIGHT; y++) {
/*     */       for (int x = 0; x < SETT.TWIDTH; x++)
/*     */         make(x, y); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void make(int sx, int sy) {
/*     */     if (!this.is.is(sx, sy))
/*     */       return; 
/*     */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     if (f.getValue2(sx, sy) != 0.0F)
/*     */       return; 
/*     */     f.init(this);
/*     */     f.pushSloppy(sx, sy, 0.0D);
/*     */     double tiles = 0.0D;
/*     */     double edgeValue = (SETT.TAREA * 2);
/*     */     while (f.hasMore()) {
/*     */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       f.setValue2((COORDINATE)t, 1.0D);
/*     */       if (t.getValue() >= edgeValue)
/*     */         break; 
/*     */       tiles += (SETT.TERRAIN()).WATER.groundWaterSalt.is(sx, sy) ? 1.0D : 0.5D;
/*     */       for (DIR d : DIR.ORTHO) {
/*     */         if (SETT.IN_BOUNDS((COORDINATE)t, d))
/*     */           f.pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F) + (this.is.is((COORDINATE)t, d) ? 0.0D : edgeValue)); 
/*     */       } 
/*     */     } 
/*     */     double am = tiles / 200.0D;
/*     */     am = Math.min(am, f.pushed());
/*     */     double delta = f.pushed() / am;
/*     */     double de = RND.rFloat() * delta;
/*     */     double amount = 2.0D * (SETT.TERRAIN()).WATER.fishAmount.max() / delta;
/*     */     while (f.hasMore()) {
/*     */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       f.setValue2((COORDINATE)t, 1.0D);
/*     */       de--;
/*     */       int vv = (int)amount;
/*     */       if (RND.rFloat() < amount - vv)
/*     */         vv++; 
/*     */       vv = CLAMP.i(vv, 0, (SETT.TERRAIN()).WATER.fishAmount.max());
/*     */       (SETT.TERRAIN()).WATER.fishAmount.set((COORDINATE)t, vv);
/*     */       if (de <= 0.0D) {
/*     */         (SETT.TERRAIN()).WATER.deepSeaFishSpot.set((COORDINATE)t, true);
/*     */         de += RND.rFloat() * delta;
/*     */       } 
/*     */     } 
/*     */     f.done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorFish.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */