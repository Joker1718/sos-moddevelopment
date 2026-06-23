/*     */ package world.map.buildings;
/*     */ 
/*     */ import init.type.CLIMATE;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.WORLD;
/*     */ import world.map.terrain.WorldGround;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class WorldGeneratorBuildings
/*     */ {
/*     */   public WorldGeneratorBuildings() {
/*  21 */     HeightMap map = new HeightMap(WORLD.TWIDTH(), WORLD.THEIGHT(), 16, 4);
/*     */     
/*  23 */     double max = 6.8D;
/*     */     
/*  25 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       
/*  27 */       (WORLD.BUILDINGS()).village.set(c, false);
/*     */       
/*  29 */       if ((WORLD.REGIONS()).isCentre.is(c))
/*     */         continue; 
/*  31 */       if ((WORLD.WATER()).coversTile.is(c)) {
/*     */         continue;
/*     */       }
/*  34 */       double connected = 0.0D;
/*  35 */       double freshWater = 0.0D;
/*     */       
/*  37 */       for (DIR d : DIR.ALL) {
/*  38 */         if (WORLD.ROADS().is(c, d))
/*  39 */           connected += 1.0D / d.tileDistance(); 
/*  40 */         if ((WORLD.WATER()).fertile.is(c, d)) {
/*  41 */           freshWater += 1.0D / d.tileDistance();
/*     */         }
/*     */       } 
/*  44 */       connected /= 6.8D;
/*  45 */       connected = Math.pow(connected, 0.5D);
/*     */       
/*  47 */       freshWater /= 6.8D;
/*  48 */       freshWater = Math.pow(freshWater, 0.5D);
/*     */       
/*  50 */       if (farm(c, connected, freshWater)) {
/*  51 */         (WORLD.BUILDINGS()).village.set(c.x(), c.y(), true);
/*     */         continue;
/*     */       } 
/*  54 */       if (village(c, connected, map)) {
/*  55 */         (WORLD.BUILDINGS()).village.set(c.x(), c.y(), true);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  62 */     WORLD.BUILDINGS().saver().clear();
/*     */   }
/*     */   
/*     */   public boolean village(COORDINATE c, double connectivity, HeightMap map) {
/*  66 */     if (WORLD.MOUNTAIN().coversTile(c.x(), c.y())) {
/*  67 */       return false;
/*     */     }
/*  69 */     double mul = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     double chance = 0.1D + 0.9D * connectivity;
/*  79 */     chance *= 0.25D + 2.5D * (((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(c)).moisture() - 0.25D) / 0.75D;
/*  80 */     chance *= map.get(c);
/*     */     
/*  82 */     chance += mul;
/*     */     
/*  84 */     return (RND.rFloat() < chance);
/*     */   }
/*     */   
/*     */   public boolean farm(COORDINATE c, double connectivity, double freshWater) {
/*  88 */     if (WORLD.MOUNTAIN().coversTile(c.x(), c.y())) {
/*  89 */       return false;
/*     */     }
/*  91 */     double ch = 1.0D * (((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(c)).moisture() - 0.25D) / 0.75D;
/*  92 */     ch *= 0.1D + 0.9D * (1.0D - ((CLIMATE)(WORLD.CLIMATE()).getter.get(c)).seasonChange);
/*  93 */     ch += freshWater * 0.5D + freshWater * RND.rFloat();
/*     */     
/*  95 */     if (Math.pow(RND.rFloat(), 2.0D) < ch) {
/*  96 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\buildings\WorldGeneratorBuildings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */