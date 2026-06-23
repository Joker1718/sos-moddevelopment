/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import init.type.CLIMATES;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import settlement.main.SettlementGrid;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.terrain.WorldGround;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GeneratorGround
/*     */ {
/*     */   GeneratorGround(CapitolArea area, GeneratorUtil util) {
/*  27 */     forest(area, util);
/*     */     
/*  29 */     HeightMap h = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 128, 4);
/*     */     
/*  31 */     double v = 0.0D;
/*  32 */     int am = 0;
/*  33 */     for (COORDINATE c : area.tiles()) {
/*  34 */       v += ((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(c)).moisture();
/*  35 */       am++;
/*     */     } 
/*  37 */     v /= am;
/*  38 */     (SETT.GROUND()).baseMoisture.setD(v);
/*     */     
/*  40 */     v = 0.5D;
/*     */     
/*  42 */     GUTIL.flooder().init(this);
/*     */     
/*  44 */     GroundType worst = (area.climate() == CLIMATES.HOT()) ? (SETT.GROUND()).types.SAND : (SETT.GROUND()).types.INFERTILE;
/*     */     
/*  46 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  47 */       if ((SETT.GROUND()).types.NORMAL.is(c)) {
/*  48 */         if (h.get(c) < v / 2.0D) {
/*  49 */           worst.placeFixed(c.x(), c.y());
/*  50 */         } else if (h.get(c) < v) {
/*  51 */           (SETT.GROUND()).types.PASTURE.placeFixed(c.x(), c.y());
/*     */         } 
/*     */       }
/*  54 */       if (worst.is(c)) {
/*  55 */         GUTIL.flooder().pushSmaller(c, 0.0D);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  60 */     while (GUTIL.flooder().hasMore()) {
/*  61 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  62 */       double vv = (4.0D - t.getValue()) / 6.0D;
/*  63 */       if (vv < 0.0D)
/*     */         continue; 
/*  65 */       util.fer.increment((COORDINATE)t, -vv);
/*  66 */       for (DIR d : DIR.ALL) {
/*  67 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/*  68 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  73 */     GUTIL.flooder().done();
/*     */     
/*  75 */     for (COORDINATE c : new Rec(SETT.TILE_BOUNDS)) {
/*  76 */       double vv = util.fer.get(c.x(), c.y());
/*  77 */       (SETT.GROUND()).MOISTURE_BASE.set(c, vv);
/*     */     } 
/*     */ 
/*     */     
/*  81 */     SETT.GROUND().init();
/*     */   }
/*     */ 
/*     */   
/*     */   private void forest(CapitolArea area, GeneratorUtil util) {
/*  86 */     double value = util.json.d("FOREST_AMOUNT", 0.0D, 1.0D);
/*     */     
/*  88 */     HeightMap ma = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 32, 4);
/*     */     
/*  90 */     if (area.isBattle) {
/*  91 */       value *= 0.75D;
/*     */     }
/*     */     
/*  94 */     util.polly.checkInit();
/*     */     
/*  96 */     GUTIL.flooder().init(this);
/*     */     
/*  98 */     for (int i = 0; i < SETT.GRID.tiles().size(); i++) {
/*     */       
/* 100 */       SettlementGrid.Tile ut = SETT.GRID.tile(i);
/* 101 */       double wf = (WORLD.FOREST()).amount.get((COORDINATE)area.ts().get(i));
/* 102 */       int a = (int)Math.ceil(value * wf * 10.0D);
/* 103 */       while (a-- > 0) {
/* 104 */         int sx = ut.coo(DIR.W).x() + RND.rInt(SettlementGrid.QUAD_SIZE);
/* 105 */         int sy = ut.coo(DIR.N).y() + RND.rInt(SettlementGrid.QUAD_SIZE);
/*     */         
/* 107 */         int mm = (int)(5.0D + value * RND.rInt(10));
/* 108 */         while (mm-- > 0) {
/* 109 */           int x = sx + RND.rInt0(40);
/* 110 */           x = CLAMP.i(x, 0, SETT.TWIDTH);
/* 111 */           int y = sy + RND.rInt0(40);
/* 112 */           y = CLAMP.i(y, 0, SETT.THEIGHT);
/* 113 */           util.polly.checker.set(x, y, true);
/* 114 */           GUTIL.flooder().pushSloppy(x, y, 0.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 125 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 126 */       if (!(SETT.TERRAIN()).NADA.is((COORDINATE)t)) {
/*     */         continue;
/*     */       }
/* 129 */       (SETT.GROUND()).types.FOREST.placeFixed(t.x(), t.y());
/*     */       
/* 131 */       double v = t.getValue();
/*     */       
/* 133 */       if (util.polly.checker.is((COORDINATE)t)) {
/* 134 */         v = 0.0D;
/*     */       }
/*     */       
/* 137 */       if (v / 40.0D + ma.get((COORDINATE)t) > 1.0D) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       for (DIR d : DIR.ALL) {
/* 146 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 147 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, v + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     GUTIL.flooder().done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorGround.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */