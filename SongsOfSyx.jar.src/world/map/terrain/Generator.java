/*    */ package world.map.terrain;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.rnd.HeightMap;
/*    */ import snake2d.util.rnd.RND;
/*    */ import world.WORLD;
/*    */ import world.WorldGen;
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
/*    */ final class Generator
/*    */ {
/*    */   public Generator(WorldGen spec, ACTION loadprint) {
/* 22 */     generateAll(spec, loadprint);
/* 23 */     loadprint.exe();
/*    */     
/* 25 */     loadprint.exe();
/* 26 */     for (int y = 0; y < WORLD.THEIGHT(); y++) {
/* 27 */       for (int x = 0; x < WORLD.TWIDTH(); x++) {
/* 28 */         WORLD.WATER().get(x, y).pplace(x, y);
/* 29 */         WORLD.WATER().get(x, y - 1).pplace(x, y - 1);
/* 30 */         WORLD.WATER().get(x - 1, y).pplace(x - 1, y);
/* 31 */         WORLD.MOUNTAIN().fix(x, y);
/*    */       } 
/*    */     } 
/* 34 */     WORLD.MINIMAP().repaint();
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 39 */     WORLD.GROUND().clear();
/* 40 */     WORLD.MOUNTAIN().clear();
/* 41 */     WORLD.FOREST().clear();
/* 42 */     WORLD.WATER().clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public void generateAll(WorldGen spec, ACTION loadprint) {
/* 47 */     loadprint.exe();
/* 48 */     clear();
/* 49 */     RND.setSeed(spec.seed);
/*    */     
/* 51 */     loadprint.exe();
/*    */     
/* 53 */     HeightMap height = new HeightMap(WORLD.TWIDTH(), WORLD.THEIGHT(), WORLD.TWIDTH() / 8, 4);
/* 54 */     if (spec.map != null) {
/* 55 */       WorldGen.WorldGenMapType m = new WorldGen.WorldGenMapType(spec.map, WORLD.TWIDTH());
/*    */       
/* 57 */       for (COORDINATE c : WORLD.TBOUNDS()) {
/* 58 */         height.increment(c, m.h(c.x(), c.y(), WORLD.TWIDTH(), WORLD.THEIGHT()));
/*    */       }
/*    */     } else {
/*    */     
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 67 */     loadprint.exe();
/*    */     
/* 69 */     loadprint.exe();
/*    */     
/* 71 */     loadprint.exe();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 78 */     loadprint.exe();
/*    */     
/* 80 */     loadprint.exe();
/*    */ 
/*    */     
/* 83 */     for (int y = 0; y < WORLD.THEIGHT(); y++) {
/* 84 */       for (int x = 0; x < WORLD.TWIDTH(); x++) {
/* 85 */         WORLD.WATER().get(x, y).pplace(x, y);
/* 86 */         WORLD.WATER().get(x, y - 1).pplace(x, y - 1);
/* 87 */         WORLD.WATER().get(x - 1, y).pplace(x - 1, y);
/* 88 */         WORLD.MOUNTAIN().fix(x, y);
/*    */       } 
/*    */     } 
/*    */     
/* 92 */     float[][] fertility = new float[WORLD.THEIGHT()][WORLD.TWIDTH()];
/* 93 */     loadprint.exe();
/*    */     
/* 95 */     loadprint.exe();
/*    */     
/* 97 */     loadprint.exe();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\Generator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */