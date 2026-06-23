/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import init.resources.Growable;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.floor.TGrowth;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ class GeneratorEdibles
/*     */ {
/*     */   GeneratorUtil util;
/*     */   
/*     */   GeneratorEdibles(CapitolArea area, GeneratorUtil util, LinkedList<COORDINATE> caves) {
/*  25 */     this.util = util;
/*     */     
/*  27 */     GUTIL.flooder().init(this);
/*  28 */     double fTot = 0.0D;
/*  29 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  30 */       double ff = getValue(c.x(), c.y());
/*  31 */       if (ff >= 0.1D) {
/*  32 */         fTot += ff;
/*  33 */         GUTIL.flooder().pushSloppy(c, RND.rFloat()).setValue2(0.0D);
/*     */       } 
/*     */     } 
/*     */     
/*  37 */     fTot /= SETT.TAREA;
/*  38 */     fTot = Math.pow(fTot, 0.5D);
/*  39 */     fTot *= util.json.d("EDIBLES_AMOUNT", 0.0D, 1.0D);
/*     */     
/*  41 */     LinkedList<Coo> spots = new LinkedList();
/*  42 */     util.polly.checkInit();
/*  43 */     while (GUTIL.flooder().hasMore()) {
/*  44 */       PathTile c = GUTIL.flooder().pollGreatest();
/*  45 */       if (util.polly.checker.is((COORDINATE)c))
/*     */         continue; 
/*  47 */       util.polly.checker.set((COORDINATE)c, true);
/*  48 */       spots.add(new Coo((COORDINATE)c));
/*     */     } 
/*     */     
/*  51 */     int[] amounts = Alloc.ii(RESOURCES.growable().all().size());
/*     */     
/*  53 */     fTot *= 4000.0D;
/*  54 */     fTot /= RESOURCES.growable().all().size();
/*     */     
/*  56 */     for (Growable g : RESOURCES.growable().all()) {
/*  57 */       amounts[g.index()] = (int)(Math.sqrt(g.growthValue) * g.availability(area.climate()) * fTot);
/*     */     }
/*     */     
/*  60 */     GUTIL.flooder().done();
/*     */     
/*  62 */     while (!spots.isEmpty()) {
/*  63 */       COORDINATE c = (COORDINATE)spots.removeFirst();
/*  64 */       if (!place(c.x(), c.y(), amounts)) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean place(int x, int y, int[] amounts) {
/*  71 */     int roff = RND.rInt(RESOURCES.growable().all().size());
/*     */     
/*  73 */     for (int i = 0; i < RESOURCES.growable().all().size(); i++) {
/*  74 */       int k = (roff + i) % amounts.length;
/*  75 */       int am = amounts[k];
/*  76 */       if (am > 0) {
/*  77 */         am -= mineralize(x, y, (TGrowable)(SETT.TERRAIN()).GROWABLES.get(k), am);
/*  78 */         amounts[k] = am;
/*  79 */         return true;
/*     */       } 
/*     */     } 
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   private double getValue(int x, int y) {
/*  86 */     if (!SETT.IN_BOUNDS(x, y))
/*  87 */       return -1.0D; 
/*  88 */     if (!(SETT.TERRAIN()).NADA.is(x, y))
/*  89 */       return -1.0D; 
/*  90 */     if ((SETT.MINERALS()).getter.is(x, y)) {
/*  91 */       return -1.0D;
/*     */     }
/*  93 */     double ff = (SETT.GROUND()).MOISTURE_BASE.get(x, y);
/*  94 */     if (ff > 0.2D) {
/*  95 */       ff -= 0.2D;
/*  96 */       ff /= 0.8D;
/*  97 */       return ff;
/*     */     } 
/*  99 */     return -1.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int mineralize(int x, int y, TGrowable g, int amount) {
/* 105 */     Rec bound = new Rec();
/* 106 */     bound.moveX1Y1(x, y);
/* 107 */     double base = getValue(x, y);
/* 108 */     if (base < 0.0D) {
/* 109 */       return 0;
/*     */     }
/* 111 */     double radius = 1.0D / (2.0F + RND.rFloat() * 10.0F);
/*     */     
/* 113 */     GUTIL.flooder().init(this);
/* 114 */     GUTIL.flooder().pushSloppy(x, y, 1.0D);
/*     */     
/* 116 */     double values = 0.0D;
/* 117 */     int size = 0;
/* 118 */     while (GUTIL.flooder().hasMore()) {
/* 119 */       PathTile t = GUTIL.flooder().pollGreatest();
/* 120 */       double v = getValue(t.x(), t.y());
/* 121 */       if (v < 0.0D)
/*     */         continue; 
/* 123 */       double pValue = t.getValue();
/*     */       
/* 125 */       size++;
/* 126 */       values += pValue * getValue(t.x(), t.y());
/* 127 */       bound.unify(t.x(), t.y());
/*     */       
/* 129 */       double dValue = (0.5D + Math.abs(base - v) * 32.0D) * radius;
/*     */       
/* 131 */       int di = RND.rInt(DIR.ALL.size());
/* 132 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 133 */         DIR d = (DIR)DIR.ALL.getC(i + di);
/* 134 */         double vv = pValue - dValue * d.tileDistance();
/* 135 */         if (SETT.IN_BOUNDS((COORDINATE)t, d) && vv > 0.0D) {
/* 136 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, vv);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     if (values <= 0.0D || size <= 0) {
/* 145 */       GUTIL.flooder().done();
/* 146 */       return 0;
/*     */     } 
/*     */     
/* 149 */     double value = 1.0D;
/* 150 */     values *= g.size.max;
/* 151 */     if (values > amount) {
/* 152 */       value = amount / values;
/*     */     }
/*     */     
/* 155 */     int total = 0;
/*     */     
/* 157 */     for (COORDINATE c : bound) {
/* 158 */       x = c.x();
/* 159 */       y = c.y();
/* 160 */       if (GUTIL.flooder().hasBeenPushed(x, y)) {
/* 161 */         double v = RND.rFloat1(0.2D) * value * GUTIL.flooder().getValue(x, y) * getValue(x, y);
/* 162 */         v *= g.size.max;
/* 163 */         int am = (int)v;
/* 164 */         double d = v - am;
/* 165 */         if (RND.rFloat() < d) {
/* 166 */           am++;
/*     */         }
/* 168 */         if (am > 0) {
/* 169 */           total += am;
/* 170 */           g.placeFixed(x, y);
/* 171 */           g.size.set(x, y, 1 + am);
/* 172 */           g.resource.set(x, y, 1 + am);
/* 173 */           ((TGrowth.Grower)(SETT.TILE_MAP()).growth.growable.get(g.growable.index())).set(x, y, am);
/* 174 */           this.util.fer.increment(x, y, 0.5D + v / g.size.max);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 180 */     GUTIL.flooder().done();
/*     */     
/* 182 */     if (total > 0 && amount < 3)
/* 183 */       return amount; 
/* 184 */     return total;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorEdibles.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */