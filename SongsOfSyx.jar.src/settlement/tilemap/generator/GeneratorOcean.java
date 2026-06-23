/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import settlement.main.SettlementGrid;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ class GeneratorOcean
/*     */ {
/*     */   private final HeightMap height;
/*     */   private final GeneratorUtil.FertilityTmp fer;
/*     */   private final double table;
/*  27 */   private final int MARGIN = (int)(SettlementGrid.QUAD_SIZE / 2.2D);
/*     */   
/*  29 */   private final double MAX_VALUE = this.MARGIN;
/*  30 */   private final double ferValue = -3.0D;
/*     */   
/*     */   GeneratorOcean(CapitolArea area, GeneratorUtil util) {
/*  33 */     this.table = area.getWatertabe();
/*  34 */     (SETT.TERRAIN()).WATER.groundWaterSalt.clear();
/*  35 */     this.fer = util.fer;
/*  36 */     this.height = util.height;
/*     */     
/*  38 */     GUTIL.flooder().init(this);
/*     */     
/*  40 */     for (int i = 0; i < SETT.GRID.tiles().size(); i++) {
/*  41 */       COORDINATE c = (COORDINATE)area.ts().get(i);
/*  42 */       SettlementGrid.Tile ut = SETT.GRID.tile(i);
/*  43 */       if ((WORLD.WATER()).OCEAN.is.is(c)) {
/*  44 */         add(ut.coo(DIR.C).x(), ut.coo(DIR.C).y());
/*  45 */         for (DIR d : DIR.ORTHO) {
/*  46 */           if ((WORLD.WATER()).OCEAN.is.is(c, d)) {
/*  47 */             add(ut.coo(d).x(), ut.coo(d).y());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  53 */     boolean has = GUTIL.flooder().hasMore();
/*     */     
/*  55 */     generateWater(this.MAX_VALUE);
/*     */     
/*  57 */     GUTIL.flooder().done();
/*     */     
/*  59 */     if (has) {
/*  60 */       smooth();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void smooth() {
/*  66 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  67 */       GUTIL.flooder().setValue2(c, 0.0D);
/*     */     }
/*     */     
/*  70 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  71 */       if ((SETT.TERRAIN()).WATER.SHALLOW.is(c) && (SETT.TERRAIN()).WATER.groundWaterSalt.is(c)) {
/*  72 */         smooth(c);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void smooth(COORDINATE start) {
/*  80 */     if (GUTIL.flooder().getValue(start) != 0.0F) {
/*     */       return;
/*     */     }
/*  83 */     GUTIL.flooder().init(this);
/*  84 */     GUTIL.flooder().pushSloppy(start, 0.0D);
/*     */     
/*  86 */     int am = 0;
/*     */     
/*  88 */     while (GUTIL.flooder().hasMore()) {
/*  89 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  90 */       if (!(SETT.TERRAIN()).WATER.is.is((COORDINATE)t)) {
/*  91 */         GUTIL.flooder().done();
/*     */         return;
/*     */       } 
/*  94 */       GUTIL.flooder().setValue2((COORDINATE)t, 1.0D);
/*  95 */       if ((SETT.TERRAIN()).WATER.SHALLOW.is((COORDINATE)t) && (SETT.TERRAIN()).WATER.groundWaterSalt.is((COORDINATE)t)) {
/*  96 */         am++;
/*     */         
/*  98 */         for (DIR d : DIR.ORTHO) {
/*  99 */           if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 100 */             GUTIL.flooder().pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     GUTIL.flooder().done();
/*     */     
/* 108 */     if (am > 100) {
/*     */       return;
/*     */     }
/*     */     
/* 112 */     GUTIL.flooder().init(this);
/* 113 */     GUTIL.flooder().pushSloppy(start, 0.0D);
/*     */     
/* 115 */     while (GUTIL.flooder().hasMore()) {
/* 116 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 117 */       if ((SETT.TERRAIN()).WATER.SHALLOW.is((COORDINATE)t) && (SETT.TERRAIN()).WATER.groundWaterSalt.is((COORDINATE)t)) {
/* 118 */         (SETT.TERRAIN()).WATER.DEEP.placeRaw(t.x(), t.y());
/*     */         
/* 120 */         for (DIR d : DIR.ORTHO) {
/* 121 */           if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 122 */             GUTIL.flooder().pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 129 */     GUTIL.flooder().done();
/*     */   }
/*     */   
/*     */   private void place(int x, int y) {
/* 133 */     (SETT.TERRAIN()).WATER.DEEP.placeRaw(x, y);
/* 134 */     (SETT.TERRAIN()).WATER.groundWaterSalt.set(x, y, true);
/* 135 */     this.fer.increment(x, y, -3.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   private void add(int x, int y) {
/* 140 */     PathTile t = GUTIL.flooder().pushSloppy(x, y, 0.0D);
/* 141 */     if (t != null) {
/* 142 */       t.setValue2(0.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void generateWater(double max) {
/* 148 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     
/* 150 */     while (f.hasMore()) {
/*     */       
/* 152 */       PathTile t = f.pollSmallest();
/* 153 */       if (t.getValue() >= max) {
/*     */         break;
/*     */       }
/* 156 */       if (t.getValue() > 4.5D * max / 5.0D) {
/* 157 */         (SETT.TERRAIN()).WATER.SHALLOW.placeRaw(t.x(), t.y());
/* 158 */         (SETT.TERRAIN()).WATER.groundWaterSalt.set((COORDINATE)t, true);
/* 159 */         this.fer.increment(t.x(), t.y(), -3.0D);
/*     */       } else {
/* 161 */         place(t.x(), t.y());
/*     */       } 
/*     */       
/* 164 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 165 */         int x = t.x() + ((DIR)DIR.ALL.get(i)).x();
/* 166 */         int y = t.y() + ((DIR)DIR.ALL.get(i)).y();
/*     */         
/* 168 */         if (SETT.IN_BOUNDS(x, y)) {
/* 169 */           double d = ((DIR)DIR.ALL.get(i)).tileDistance();
/* 170 */           double radius = t.getValue2() + d;
/* 171 */           float h = (float)this.height.get(x, y);
/* 172 */           double value = 0.8D * radius;
/* 173 */           value += max * h * h * h;
/* 174 */           if (value > max)
/* 175 */             value = max; 
/* 176 */           if (h < this.table)
/* 177 */             value = 0.0D; 
/* 178 */           PathTile t2 = GUTIL.flooder().pushSloppy(x, y, (float)value);
/* 179 */           if (t2 != null) {
/* 180 */             t2.setValue2((float)radius);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 186 */     double delta = 15.0D;
/* 187 */     max += delta;
/*     */     
/* 189 */     while (f.hasMore()) {
/*     */       
/* 191 */       PathTile t = f.pollSmallest();
/* 192 */       double v = t.getValue();
/* 193 */       if (v >= max) {
/*     */         break;
/*     */       }
/* 196 */       double dd = 1.0D - (v - max + delta) / delta;
/* 197 */       if (dd < 0.0D)
/* 198 */         dd = 0.0D; 
/* 199 */       if (dd > 1.0D)
/* 200 */         dd = 1.0D; 
/* 201 */       double fe = dd * -3.0D * (0.7D + 0.3D * RND.rFloat());
/*     */ 
/*     */       
/* 204 */       double r = max - t.getValue2();
/* 205 */       if (r < 8.0D) {
/* 206 */         (SETT.TERRAIN()).WATER.groundWaterSalt.set((COORDINATE)t, true);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 211 */       this.fer.increment(t.x(), t.y(), fe);
/* 212 */       if (this.fer.get(t.x(), t.y()) < 0.1D) {
/* 213 */         (SETT.GROUND()).types.SAND.placeFixed(t.x(), t.y());
/*     */       }
/* 215 */       if (RND.oneIn(100.0D - 95.0D * dd) && (SETT.TERRAIN()).NADA.is((COORDINATE)t)) {
/* 216 */         (SETT.TERRAIN()).DECOR_BEACH.placeRaw(t.x(), t.y());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 223 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 224 */         int x = t.x() + ((DIR)DIR.ALL.get(i)).x();
/* 225 */         int y = t.y() + ((DIR)DIR.ALL.get(i)).y();
/*     */         
/* 227 */         if (SETT.IN_BOUNDS(x, y)) {
/* 228 */           double d = ((DIR)DIR.ALL.get(i)).tileDistance();
/* 229 */           double radius = t.getValue2() + d;
/* 230 */           float h = (float)this.height.get(x, y);
/* 231 */           double value = 0.8D * radius;
/* 232 */           value += max * h * h * h;
/* 233 */           if (value > max)
/* 234 */             value = max; 
/* 235 */           PathTile t2 = GUTIL.flooder().pushSloppy(x, y, (float)value);
/* 236 */           if (t2 != null)
/* 237 */             t2.setValue2((float)radius); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorOcean.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */