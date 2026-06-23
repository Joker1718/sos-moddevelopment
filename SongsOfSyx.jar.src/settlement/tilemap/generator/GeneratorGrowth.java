/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.floor.TGrowth;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorGrowth
/*     */ {
/*  18 */   private final GG[] map = new GG[128];
/*     */   
/*     */   GeneratorGrowth() {
/*  21 */     HeightMap ferMap = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 8, 2);
/*     */     
/*  23 */     add((SETT.TILE_MAP()).growth.bush, 0.0D, 0.1D);
/*  24 */     add((SETT.TILE_MAP()).growth.tree, 0.1D, 0.25D);
/*  25 */     add((SETT.TILE_MAP()).growth.bush, 0.25D, 0.35D);
/*  26 */     fill(ferMap, (SETT.GROUND()).types.FOREST, 0.175D, 1.0D);
/*     */     
/*  28 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  29 */       double f = ferMap.get(c);
/*  30 */       int i = (int)(f * (this.map.length - 1));
/*  31 */       GG g = this.map[i];
/*  32 */       if (g != null) {
/*  33 */         double a = (f - g.from) / (g.to - g.from);
/*  34 */         g.g.set(c.x(), c.y(), a);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  39 */     ferMap = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 32, 2);
/*  40 */     fill(ferMap, (SETT.GROUND()).types.NORMAL, 1.0D, 0.2D);
/*  41 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*     */       
/*  43 */       double f = ferMap.get(c);
/*     */       
/*  45 */       if (f > 0.65D) {
/*  46 */         double a = (f - 0.65D) / 0.2D;
/*  47 */         a = CLAMP.d(a, 0.0D, 1.0D);
/*  48 */         TGrowth.Grower g = (SETT.TILE_MAP()).growth.flower;
/*  49 */         g.set(c.x(), c.y(), a);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  55 */     ferMap = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 16, 1);
/*  56 */     fill(ferMap, (SETT.GROUND()).types.PASTURE, 1.0D, 0.2D);
/*  57 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*     */       
/*  59 */       double f = ferMap.get(c);
/*     */       
/*  61 */       if (f > 0.7D) {
/*  62 */         double a = (f - 0.7D) / 0.2D;
/*  63 */         a = CLAMP.d(a, 0.0D, 1.0D);
/*  64 */         TGrowth.Grower g = (SETT.TILE_MAP()).growth.bush;
/*  65 */         g.set(c.x(), c.y(), a);
/*     */         continue;
/*     */       } 
/*  68 */       f = ferMap.get((c.x() + 64) % SETT.TWIDTH, (c.y() + 64) % SETT.THEIGHT);
/*  69 */       if (f > 0.8D) {
/*  70 */         double a = (f - 0.8D) / 0.15D;
/*  71 */         a = CLAMP.d(a, 0.0D, 1.0D);
/*  72 */         TGrowth.Grower g = (SETT.TILE_MAP()).growth.mushroom;
/*  73 */         g.set(c.x(), c.y(), a);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void add(TGrowth.Grower[] gs, TGrowth.Grower g, double amount) {
/*  83 */     int am = (int)Math.ceil(gs.length * amount);
/*  84 */     for (int i = 0; i < gs.length; i++) {
/*  85 */       if (gs[i] == null) {
/*  86 */         gs[i] = g;
/*  87 */         am--;
/*  88 */         if (am <= 0) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void fill(HeightMap ferMap, GroundType type, double to, double strength) {
/*  96 */     GUTIL.flooder().init(this);
/*  97 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  98 */       if (type.is(c)) {
/*  99 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*     */       }
/*     */     } 
/*     */     
/* 103 */     while (GUTIL.flooder().hasMore()) {
/* 104 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/* 106 */       double v = 1.0D - t.getValue() / 10.0D;
/* 107 */       if (v < 0.0D) {
/*     */         break;
/*     */       }
/* 110 */       double inc = to - ferMap.get((COORDINATE)t);
/* 111 */       inc *= strength * v;
/* 112 */       ferMap.increment((COORDINATE)t, inc);
/*     */       
/* 114 */       for (DIR d : DIR.ALL) {
/* 115 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 116 */           GUTIL.flooder().pushSloppy((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 121 */     GUTIL.flooder().done();
/*     */   }
/*     */   
/*     */   private void add(TGrowth.Grower g, double from, double to) {
/* 125 */     GG gg = new GG(g, from, to);
/* 126 */     int i = (int)(from * (this.map.length - 1));
/* 127 */     int t = (int)(to * (this.map.length - 1));
/* 128 */     for (; i < t; i++) {
/* 129 */       this.map[i] = gg;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class GG
/*     */   {
/*     */     public final TGrowth.Grower g;
/*     */     
/*     */     public final double from;
/*     */     
/*     */     public final double to;
/*     */     
/*     */     GG(TGrowth.Grower g, double from, double to) {
/* 143 */       this.g = g;
/* 144 */       this.from = from;
/* 145 */       this.to = to;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorGrowth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */