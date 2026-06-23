/*     */ package settlement.entity.animal.spawning;
/*     */ 
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.entity.animal.Animals;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Generator
/*     */ {
/*  24 */   private final int radius = 8;
/*  25 */   private final Rec bounds = (new Rec((SETT.TWIDTH - 16), (SETT.THEIGHT - 16))).moveX1Y1(8.0D, 8.0D);
/*     */ 
/*     */   
/*     */   Generator(Animals as, CapitolArea carea, LIST<AnimalSpawnSpot> spots) {
/*  29 */     GUTIL.flooder().init(this);
/*     */     
/*  31 */     double[] terrains = new double[TERRAINS.ALL().size()];
/*     */     
/*  33 */     double tot = 0.0D;
/*  34 */     for (COORDINATE c : this.bounds) {
/*  35 */       double ff = getValue(c.x(), c.y());
/*  36 */       if (ff >= 0.0D) {
/*  37 */         tot += ff;
/*  38 */         if (valid(c.x(), c.y()))
/*  39 */           GUTIL.flooder().pushSloppy(c, ff * 0.0D - 5.0D + RND.rFloat()).setValue2(0.0D); 
/*     */       } 
/*  41 */       terrains[((TERRAIN)TERRAINS.sett.get(c.x(), c.y())).index()] = terrains[((TERRAIN)TERRAINS.sett.get(c.x(), c.y())).index()] + 1.0D;
/*     */     } 
/*     */     
/*  44 */     double area = (this.bounds.width() * this.bounds.height());
/*  45 */     tot /= area;
/*  46 */     tot = Math.pow(tot, 0.5D);
/*  47 */     for (TERRAIN t : TERRAINS.ALL()) {
/*  48 */       terrains[t.index()] = terrains[t.index()] / area;
/*     */     }
/*  50 */     double otot = 0.0D;
/*  51 */     double[] occ = new double[as.species.size()];
/*     */     
/*  53 */     for (AnimalSpecies a : as.species) {
/*     */       
/*  55 */       double o = 0.0D;
/*  56 */       for (TERRAIN t : TERRAINS.ALL())
/*  57 */         o += terrains[t.index()] * a.occurence(t); 
/*  58 */       o *= a.occurence(carea.climate());
/*  59 */       otot += o;
/*  60 */       occ[a.index()] = o;
/*     */     } 
/*     */     
/*  63 */     if (otot <= 0.0D) {
/*     */       return;
/*     */     }
/*     */     
/*  67 */     int[] amounts = Alloc.ii(as.species.size());
/*  68 */     int[] caveAmouts = Alloc.ii(as.species.size());
/*  69 */     for (AnimalSpecies a : as.species) {
/*  70 */       occ[a.index()] = occ[a.index()] / otot;
/*  71 */       double aa = occ[a.index()] * 75.0D * tot;
/*  72 */       int am = (int)aa;
/*  73 */       aa -= am;
/*  74 */       if (RND.rFloat() < aa) {
/*  75 */         am++;
/*     */       }
/*  77 */       amounts[a.index()] = am;
/*  78 */       caveAmouts[a.index()] = (int)(am * a.caveLiving);
/*     */     } 
/*     */     
/*  81 */     LinkedList<AnimalSpawnSpot> list = new LinkedList((Iterable)spots);
/*     */     
/*  83 */     while (GUTIL.flooder().hasMore() && !list.isEmpty()) {
/*  84 */       PathTile c = GUTIL.flooder().pollGreatest();
/*  85 */       if (c.getValue2() != 0.0F)
/*     */         continue; 
/*  87 */       if (!place(c.x(), c.y(), amounts, caveAmouts, list)) {
/*     */         break;
/*     */       }
/*     */     } 
/*  91 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean place(int x, int y, int[] amounts, int[] camounts, LinkedList<AnimalSpawnSpot> list) {
/*  96 */     int roff = RND.rInt((SETT.ANIMALS()).species.size());
/*     */     
/*  98 */     if (SETT.TERRAIN().get(x, y).roofIs()) {
/*  99 */       int j; for (j = 0; j < (SETT.ANIMALS()).species.size(); j++) {
/* 100 */         int k = (roff + j) % amounts.length;
/* 101 */         int am = camounts[k];
/* 102 */         if (am > 0) {
/* 103 */           AnimalSpawnSpot spot = (AnimalSpawnSpot)list.removeFirst();
/* 104 */           int a = place(x, y, (AnimalSpecies)(SETT.ANIMALS()).species.get(k), am, spot);
/* 105 */           if (a > 0) {
/* 106 */             spot.init(x, y, a, (AnimalSpecies)(SETT.ANIMALS()).species.get(k));
/*     */           } else {
/* 108 */             list.add(spot);
/* 109 */           }  camounts[k] = camounts[k] - a;
/* 110 */           amounts[k] = amounts[k] - a;
/* 111 */           return true;
/*     */         } 
/*     */       } 
/* 114 */       for (j = 0; j < (SETT.ANIMALS()).species.size(); j++) {
/* 115 */         if (amounts[j] > 0) {
/* 116 */           return true;
/*     */         }
/*     */       } 
/* 119 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 124 */     for (int i = 0; i < (SETT.ANIMALS()).species.size(); i++) {
/* 125 */       int k = (roff + i) % amounts.length;
/* 126 */       int am = amounts[k];
/* 127 */       if (am > 0) {
/* 128 */         AnimalSpawnSpot spot = (AnimalSpawnSpot)list.removeFirst();
/* 129 */         int a = place(x, y, (AnimalSpecies)(SETT.ANIMALS()).species.get(k), am, spot);
/* 130 */         if (a > 0) {
/* 131 */           spot.init(x, y, a, (AnimalSpecies)(SETT.ANIMALS()).species.get(k));
/*     */         } else {
/* 133 */           list.add(spot);
/* 134 */         }  amounts[k] = amounts[k] - a;
/* 135 */         return true;
/*     */       } 
/*     */     } 
/* 138 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private int place(int cx, int cy, AnimalSpecies animal, int am, AnimalSpawnSpot spot) {
/* 143 */     Rec rec = new Rec(16.0D);
/* 144 */     rec.moveC(cx, cy);
/*     */ 
/*     */     
/* 147 */     for (COORDINATE c : rec) {
/* 148 */       if (SETT.IN_BOUNDS(c)) {
/* 149 */         GUTIL.flooder().setValue2(c, 1.0D);
/*     */       }
/*     */     } 
/* 152 */     GUTIL.coos().set(0);
/*     */     
/* 154 */     int max = 40 + RND.rInt(20);
/* 155 */     if (max > am) {
/* 156 */       max = am;
/* 157 */     } else if (am - max < 5) {
/* 158 */       max = am;
/* 159 */     }  am = max;
/*     */     
/* 161 */     int a = 0;
/* 162 */     for (int i = 0; GUTIL.circle().radius(i) < 8 && a < am; i++) {
/* 163 */       if (RND.oneIn(3 + GUTIL.circle().radius(i))) {
/*     */         
/* 165 */         int x = cx + GUTIL.circle().get(i).x();
/* 166 */         int y = cy + GUTIL.circle().get(i).y();
/* 167 */         if (valid(x, y)) {
/*     */ 
/*     */           
/* 170 */           GUTIL.coos().get().set(x, y);
/* 171 */           GUTIL.coos().inc();
/* 172 */           a++;
/*     */         } 
/*     */       } 
/* 175 */     }  if (a >= am) {
/* 176 */       am = 0;
/* 177 */       int m = GUTIL.coos().getI();
/* 178 */       for (int j = 0; j < m; j++) {
/* 179 */         GUTIL.coos().set(j);
/* 180 */         int ax = GUTIL.coos().get().x() * 64 + 32;
/* 181 */         int ay = GUTIL.coos().get().y() * 64 + 32;
/* 182 */         Animal an = new Animal(ax, ay, animal, spot);
/* 183 */         if (!an.isRemoved())
/* 184 */           am++; 
/*     */       } 
/* 186 */       return am;
/*     */     } 
/* 188 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double getValue(int x, int y) {
/* 195 */     double ff = (SETT.GROUND()).MOISTURE_BASE.get(x, y);
/* 196 */     if (ff > 0.2D) {
/* 197 */       return 0.5D + (ff - 0.2D) / 1.6D;
/*     */     }
/* 199 */     return -1.0D;
/*     */   }
/*     */   
/*     */   private boolean valid(int x, int y) {
/* 203 */     if (!SETT.IN_BOUNDS(x, y))
/* 204 */       return false; 
/* 205 */     if (((SETT.PATH()).availability.get(x, y)).player < 0.0D)
/* 206 */       return false; 
/* 207 */     if ((SETT.TERRAIN()).WATER.is.is(x, y)) {
/* 208 */       return false;
/*     */     }
/* 210 */     double ff = (SETT.GROUND()).MOISTURE_BASE.get(x, y);
/* 211 */     if (ff > 0.2D) {
/* 212 */       return true;
/*     */     }
/* 214 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\spawning\Generator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */