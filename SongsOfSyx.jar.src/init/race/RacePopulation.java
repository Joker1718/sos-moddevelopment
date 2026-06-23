/*    */ package init.race;
/*    */ 
/*    */ import init.type.CLIMATE;
/*    */ import init.type.CLIMATES;
/*    */ import init.type.TERRAIN;
/*    */ import init.type.TERRAINS;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ public final class RacePopulation
/*    */ {
/*    */   public final double growth;
/*    */   public final double max;
/*    */   private final double[] climates;
/*    */   private final double maxClimate;
/*    */   private final double[] terrains;
/*    */   private final double maxTerrain;
/*    */   
/*    */   RacePopulation(Json json) {
/* 20 */     if (!json.has("POPULATION")) {
/* 21 */       this.max = 1.0D;
/* 22 */       this.climates = new double[CLIMATES.ALL().size()];
/* 23 */       this.terrains = new double[TERRAINS.ALL().size()];
/* 24 */       this.maxClimate = 0.0D;
/* 25 */       this.maxTerrain = 0.0D;
/* 26 */       this.growth = 1.0E-4D;
/*    */     } else {
/* 28 */       json = json.json("POPULATION");
/* 29 */       this.max = json.d("MAX", 0.0D, 1.0D);
/* 30 */       this.climates = CLIMATES.MAP().readFill(json, 1.0D);
/* 31 */       double m = 0.0D; byte b; int i; double[] arrayOfDouble;
/* 32 */       for (i = (arrayOfDouble = this.climates).length, b = 0; b < i; ) { double c = arrayOfDouble[b];
/* 33 */         m = Math.max(c, m); b++; }
/* 34 */        this.maxClimate = m;
/* 35 */       this.terrains = TERRAINS.MAP().readFill(json, 100.0D);
/* 36 */       m = 0.0D;
/* 37 */       for (i = (arrayOfDouble = this.terrains).length, b = 0; b < i; ) { double c = arrayOfDouble[b];
/* 38 */         m = Math.max(c, m); b++; }
/* 39 */        this.maxTerrain = m;
/* 40 */       this.growth = json.d("GROWTH", 1.0E-4D, 1.0D);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public double climate(CLIMATE c) {
/* 46 */     return this.climates[c.index()];
/*    */   }
/*    */   
/*    */   public double terrain(TERRAIN c) {
/* 50 */     return this.terrains[c.index()];
/*    */   }
/*    */   
/*    */   public double maxClimate() {
/* 54 */     return this.maxClimate;
/*    */   }
/*    */   
/*    */   public double maxTerrain() {
/* 58 */     return this.maxTerrain;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RacePopulation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */