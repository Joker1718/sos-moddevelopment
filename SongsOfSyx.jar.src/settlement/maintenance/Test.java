/*     */ package settlement.maintenance;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.food.fish.ROOM_FISHERY;
/*     */ import settlement.room.industry.mine.ROOM_MINE;
/*     */ import settlement.room.industry.refiner.ROOM_REFINER;
/*     */ import settlement.room.industry.woodcutter.ROOM_WOODCUTTER;
/*     */ import settlement.room.industry.workshop.ROOM_WORKSHOP;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ 
/*     */ class Test
/*     */ {
/*  21 */   private double[] acc = new double[RESOURCES.ALL().size()];
/*     */   
/*  23 */   private final double rate = 0.015625D;
/*  24 */   private final Bitmap1D check = new Bitmap1D((SETT.ROOMS()).AMOUNT_OF_BLUEPRINTS, false);
/*     */ 
/*     */   
/*     */   Test() {
/*  28 */     Arrays.fill(this.acc, Double.MAX_VALUE);
/*  29 */     for (RESOURCE res : RESOURCES.ALL()) {
/*  30 */       double v = (SETT.RECIPES()).ratesV.bestRecipe(res.tr()).manpowerTotal();
/*  31 */       this.acc[res.index()] = v;
/*  32 */       l(res.key + "\t" + res.key);
/*     */     } 
/*     */     
/*  35 */     l("");
/*     */ 
/*     */     
/*  38 */     for (ROOM_MINE m : (SETT.ROOMS()).MINES) {
/*     */       
/*  40 */       double[][] arrayOfDouble = {
/*  41 */           { 1.0D, 1.0D / ((FurnisherItemGroup)m.constructor().groups().get(1)).stat(2) }
/*     */         };
/*  43 */       print((RoomBlueprintIns<?>)m, arrayOfDouble);
/*     */     } 
/*     */ 
/*     */     
/*  47 */     l("");
/*     */     
/*  49 */     for (ROOM_REFINER m : (SETT.ROOMS()).REFINERS) {
/*  50 */       double[][] arrayOfDouble = { { 0.0D, 1.0D / ((FurnisherItemGroup)m.constructor().groups().get(0)).stat(0) }, { 2.0D, 1.0D / ((FurnisherItemGroup)m.constructor().groups().get(2)).stat(1) } };
/*     */       
/*  52 */       print((RoomBlueprintIns<?>)m, arrayOfDouble);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  57 */     l("");
/*     */ 
/*     */     
/*  60 */     for (ROOM_WORKSHOP m : (SETT.ROOMS()).WORKSHOPS) {
/*     */       
/*  62 */       double[][] arrayOfDouble = { { 1.0D, 1.0D / ((FurnisherItemGroup)m.constructor().groups().get(1)).stat(0) }, { 2.0D, 1.0D / ((FurnisherItemGroup)m.constructor().groups().get(2)).stat(1) } };
/*     */       
/*  64 */       print((RoomBlueprintIns<?>)m, arrayOfDouble);
/*     */     } 
/*     */ 
/*     */     
/*  68 */     l("");
/*     */ 
/*     */     
/*  71 */     for (ROOM_FISHERY m : (SETT.ROOMS()).FISHERIES) {
/*     */       
/*  73 */       double[][] arrayOfDouble = { { 1.0D, 1.0D / ((FurnisherItemGroup)m.constructor().groups().get(1)).stat(2) } };
/*     */       
/*  75 */       print((RoomBlueprintIns<?>)m, arrayOfDouble);
/*     */     } 
/*     */ 
/*     */     
/*  79 */     l("");
/*     */ 
/*     */     
/*  82 */     ROOM_WOODCUTTER rOOM_WOODCUTTER = (SETT.ROOMS()).WOOD_CUTTER;
/*  83 */     double[][] groups = { { 1.0D, 1.0D / ((FurnisherItemGroup)rOOM_WOODCUTTER.constructor().groups().get(1)).stat(1) } };
/*  84 */     print((RoomBlueprintIns<?>)rOOM_WOODCUTTER, groups);
/*     */ 
/*     */     
/*  87 */     for (RoomBlueprint bb : SETT.ROOMS().all()) {
/*  88 */       if (this.check.get(bb.index()))
/*     */         continue; 
/*  90 */       if (bb instanceof RoomBlueprintImp) {
/*  91 */         RoomBlueprintImp b = (RoomBlueprintImp)bb;
/*     */         
/*  93 */         double max = 0.0D;
/*  94 */         for (FurnisherItemGroup i : b.constructor().groups()) {
/*  95 */           for (int j = 0; j <= b.upgrades().max(); j++) {
/*  96 */             double m = 0.0D;
/*  97 */             for (int ri = 0; ri < b.constructor().resources(); ri++) {
/*  98 */               m += i.cost(ri, ri) * this.acc[b.constructor().resource(ri).index()];
/*     */             }
/* 100 */             m /= (i.item(0, 0)).area;
/* 101 */             max = Math.max(max, m);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 106 */         for (int uI = 0; uI <= b.upgrades().max(); uI++) {
/* 107 */           double m = 0.0D;
/* 108 */           for (int ri = 0; ri < b.constructor().resources(); ri++) {
/* 109 */             m += b.constructor().areaCost(ri, uI) * this.acc[b.constructor().resource(ri).index()];
/*     */           }
/* 111 */           max = Math.max(max, m);
/*     */         } 
/* 113 */         l(b.key + " " + b.key);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void print(RoomBlueprintIns<?> m, double[][] groups) {
/* 122 */     this.check.set(m.index(), true);
/* 123 */     l(m.key + " " + m.key);
/* 124 */     String res = "";
/* 125 */     for (int i = 0; i < m.constructor().resources(); i++) {
/* 126 */       res = res + res + " " + String.valueOf(m.constructor().resource(i)) + " | ";
/*     */     }
/*     */ 
/*     */     
/* 130 */     l("    res: " + res);
/*     */     
/* 132 */     res = ""; byte b; int k; double[][] arrayOfDouble;
/* 133 */     for (k = (arrayOfDouble = groups).length, b = 0; b < k; ) { double[] gi = arrayOfDouble[b];
/* 134 */       FurnisherItemGroup g = (FurnisherItemGroup)m.constructor().groups().get((int)gi[0]);
/* 135 */       res = res + res + " " + String.valueOf(g.name) + " | "; b++; }
/*     */     
/* 137 */     l("    items: : " + res);
/* 138 */     double prev = 0.0D;
/*     */     
/* 140 */     for (int j = 0; j <= m.upgrades().max(); j++) {
/*     */       
/* 142 */       double bo = m.upgrades().boost(j);
/* 143 */       if (j > 0)
/* 144 */         bo -= m.upgrades().boost(j - 1); 
/* 145 */       double mm = 0.0D; byte b1; int n; double[][] arrayOfDouble1;
/* 146 */       for (n = (arrayOfDouble1 = groups).length, b1 = 0; b1 < n; ) { double[] gi = arrayOfDouble1[b1];
/* 147 */         FurnisherItemGroup g = (FurnisherItemGroup)m.constructor().groups().get((int)gi[0]);
/*     */         
/* 149 */         for (int ri = 0; ri < m.constructor().resources(); ri++)
/*     */         {
/* 151 */           mm += g.cost(ri, j) * gi[1] * this.acc[m.constructor().resource(ri).index()];
/*     */         }
/*     */         b1++; }
/*     */       
/* 155 */       mm *= m.degradeRate();
/* 156 */       mm -= prev;
/* 157 */       prev += mm;
/*     */       
/* 159 */       if (j == 0)
/* 160 */         bo = 1.0D; 
/* 161 */       double d = mm / bo;
/*     */ 
/*     */       
/* 164 */       l("  #" + j + ": " + dd(100.0D * d * 0.015625D) + "%");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void l(String s) {
/* 171 */     LOG.err(s);
/*     */   }
/*     */   
/*     */   private static String dd(double d) {
/* 175 */     return String.format("%.2f", new Object[] { Double.valueOf(d) });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\maintenance\Test.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */