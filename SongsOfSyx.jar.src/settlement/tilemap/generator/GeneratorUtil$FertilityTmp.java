/*    */ package settlement.tilemap.generator;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.map.MAP_DOUBLEE;
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
/*    */ class FertilityTmp
/*    */   implements MAP_DOUBLEE
/*    */ {
/* 57 */   private double[][] fer = new double[SETT.TWIDTH][SETT.TWIDTH];
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double get(int x, int y) {
/* 65 */     if (SETT.TILE_BOUNDS.holdsPoint(x, y))
/* 66 */       return this.fer[y][x]; 
/* 67 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(int tile) {
/* 72 */     throw new RuntimeException();
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_DOUBLEE set(int tile, double value) {
/* 77 */     throw new RuntimeException();
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 82 */     if (SETT.TILE_BOUNDS.holdsPoint(tx, ty))
/* 83 */       this.fer[ty][tx] = value; 
/* 84 */     return this;
/*    */   }
/*    */   
/*    */   public void target(int tx, int ty, double value, double delta) {
/* 88 */     this.fer[ty][tx] = value * delta + (1.0D - delta) * this.fer[ty][tx];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorUtil$FertilityTmp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */