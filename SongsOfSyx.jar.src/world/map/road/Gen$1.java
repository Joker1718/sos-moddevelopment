/*    */ package world.map.road;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.map.MAP_DOUBLE;
/*    */ import snake2d.util.rnd.Polymap;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements MAP_DOUBLE
/*    */ {
/* 21 */   private final Polymap polly = new Polymap(WORLD.TBOUNDS(), 6, 1.0D);
/*    */   
/*    */   public double get(int dx, int dy) {
/* 24 */     double v = (0.4D + (this.polly.isEdge(dx, dy) ? 0.0D : 0.6D)) * getTerrainCost(dx, dy);
/* 25 */     Region r = (Region)(WORLD.REGIONS()).map.get(dx, dy);
/* 26 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 27 */       if (r != (WORLD.REGIONS()).map.get(dx, dy, (DIR)DIR.ORTHO.get(i))) {
/* 28 */         v *= 2.0D; break;
/*    */       } 
/*    */     } 
/* 31 */     if ((WORLD.WATER()).isBig.is(dx, dy)) {
/* 32 */       v *= 2.0D;
/* 33 */       if (!(WORLD.WATER()).coversTile.is(dx, dy)) {
/* 34 */         v *= 3.0D;
/*    */       }
/*    */     } 
/* 37 */     return v;
/*    */   }
/*    */   
/*    */   double getTerrainCost(int tx, int ty) {
/* 41 */     if ((WORLD.WATER()).isBig.is(tx, ty)) {
/* 42 */       return 1.0D;
/*    */     }
/* 44 */     if ((WORLD.MOUNTAIN()).heighter.get(tx, ty) >= 1)
/* 45 */       return 12.0D; 
/* 46 */     if ((WORLD.FOREST()).amount.get(tx, ty) == 1.0D)
/* 47 */       return 6.0D; 
/* 48 */     return 3.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double get(int tile) {
/* 54 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\Gen$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */