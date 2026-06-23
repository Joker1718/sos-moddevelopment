/*    */ package settlement.tilemap.generator;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.PathGame;
/*    */ import util.GUTIL;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements PathGame.COST
/*    */ {
/*    */   public double getCost(int fromX, int fromY, int toX, int toY) {
/* 36 */     if ((SETT.TERRAIN()).WATER.BRIDGE.is(toX, toY)) {
/* 37 */       return 0.2D;
/*    */     }
/* 39 */     if (!SETT.TERRAIN().get(toX, toY).clearing().isEasilyCleared()) {
/* 40 */       return 25.0D;
/*    */     }
/*    */     
/* 43 */     if (GUTIL.flooder().getValue2(toX, toY) != 0.0F) {
/* 44 */       return 10.0D;
/*    */     }
/* 46 */     if (SETT.TERRAIN().get(toX, toY) != (SETT.TERRAIN()).NADA) {
/* 47 */       return 2.0D;
/*    */     }
/*    */     
/* 50 */     if (!GeneratorRoads.this.edge.is(toX, toY)) {
/* 51 */       return 2.0D;
/*    */     }
/* 53 */     if ((SETT.FLOOR()).getter.get(toX, toY) != null) {
/* 54 */       return 0.2D;
/*    */     }
/* 56 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorRoads$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */