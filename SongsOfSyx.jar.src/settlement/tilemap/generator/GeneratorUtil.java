/*    */ package settlement.tilemap.generator;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.map.MAP_BOOLEANE;
/*    */ import snake2d.util.map.MAP_DOUBLEE;
/*    */ import snake2d.util.rnd.HeightMap;
/*    */ import snake2d.util.rnd.Polymap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class GeneratorUtil
/*    */ {
/* 17 */   final HeightMap height = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 128, 4);
/* 18 */   final FertilityTmp fer = new FertilityTmp();
/* 19 */   final Polymap polly = new Polymap(SETT.TWIDTH, SETT.THEIGHT);
/*    */   final Json json;
/* 21 */   final Checker checker = new Checker();
/*    */   
/*    */   GeneratorUtil() {
/* 24 */     this.json = (new Json((PATHS.CONFIG()).init.gets("GenerationSettlement"))).json("GENERATION");
/*    */   }
/*    */   
/*    */   static class Checker
/*    */     extends MAP_BOOLEANE.BooleanMapE {
/*    */     private final short[] checks;
/* 30 */     private short sI = 0;
/*    */     
/*    */     public Checker() {
/* 33 */       super(SETT.TWIDTH, SETT.THEIGHT);
/* 34 */       this.checks = new short[SETT.THEIGHT * SETT.TWIDTH];
/*    */     }
/*    */ 
/*    */     
/*    */     public MAP_BOOLEANE set(int tile, boolean value) {
/* 39 */       this.checks[tile] = (short)(value ? this.sI : (this.sI - 1));
/* 40 */       return (MAP_BOOLEANE)this;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean is(int tile) {
/* 46 */       return (this.checks[tile] == this.sI);
/*    */     }
/*    */     
/*    */     void init() {
/* 50 */       this.sI = (short)(this.sI + 1);
/*    */     }
/*    */   }
/*    */   
/*    */   static class FertilityTmp
/*    */     implements MAP_DOUBLEE
/*    */   {
/* 57 */     private double[][] fer = new double[SETT.TWIDTH][SETT.TWIDTH];
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public double get(int x, int y) {
/* 65 */       if (SETT.TILE_BOUNDS.holdsPoint(x, y))
/* 66 */         return this.fer[y][x]; 
/* 67 */       return 0.0D;
/*    */     }
/*    */ 
/*    */     
/*    */     public double get(int tile) {
/* 72 */       throw new RuntimeException();
/*    */     }
/*    */ 
/*    */     
/*    */     public MAP_DOUBLEE set(int tile, double value) {
/* 77 */       throw new RuntimeException();
/*    */     }
/*    */ 
/*    */     
/*    */     public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 82 */       if (SETT.TILE_BOUNDS.holdsPoint(tx, ty))
/* 83 */         this.fer[ty][tx] = value; 
/* 84 */       return this;
/*    */     }
/*    */     
/*    */     public void target(int tx, int ty, double value, double delta) {
/* 88 */       this.fer[ty][tx] = value * delta + (1.0D - delta) * this.fer[ty][tx];
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */