/*    */ package settlement.thing.projectiles;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.sets.ArrayListInt;
/*    */ 
/*    */ 
/*    */ 
/*    */ class Map
/*    */ {
/*    */   private final Quad[][] quadrants;
/*    */   private final int qMaxX;
/*    */   private final int qMaxY;
/*    */   static final int gridSize = 1024;
/* 15 */   static final int gridScroll = Integer.numberOfTrailingZeros(1024);
/*    */   public Map(int mapSizeX, int mapSizeY) {
/* 17 */     this.qMaxX = mapSizeX / 1024;
/* 18 */     this.qMaxY = mapSizeY / 1024;
/*    */     
/* 20 */     this.quadrants = new Quad[this.qMaxX][this.qMaxY];
/*    */     
/* 22 */     for (int y = 0; y < this.quadrants.length; y++) {
/* 23 */       for (int x = 0; x < (this.quadrants[0]).length; x++) {
/* 24 */         this.quadrants[y][x] = new Quad(x, y);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void add(int e) {
/* 32 */     PData.Data d = (SETT.PROJS()).data.data(e);
/*    */     
/* 34 */     int gridX = d.qx();
/* 35 */     int gridY = d.qy();
/* 36 */     this.quadrants[gridY][gridX].add(e);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean contains(int e) {
/* 42 */     PData.Data d = (SETT.PROJS()).data.data(e);
/*    */     
/* 44 */     int gridX = d.qx();
/* 45 */     int gridY = d.qy();
/* 46 */     return this.quadrants[gridY][gridX].contains(e);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void remove(int e) {
/* 52 */     PData.Data d = (SETT.PROJS()).data.data(e);
/*    */     
/* 54 */     int gridX = d.qx();
/* 55 */     int gridY = d.qy();
/* 56 */     this.quadrants[gridY][gridX].remove(e);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void fill(RECTANGLE bounds, ArrayListInt result) {
/* 62 */     int qx1 = bounds.x1() / 1024;
/* 63 */     if (qx1 < 0)
/* 64 */       qx1 = 0; 
/* 65 */     int qy1 = bounds.y1() / 1024;
/* 66 */     if (qy1 < 0)
/* 67 */       qy1 = 0; 
/* 68 */     int qx2 = bounds.x2() / 1024;
/* 69 */     if (qx2 >= this.qMaxX)
/* 70 */       qx2 = this.qMaxX - 1; 
/* 71 */     int qy2 = bounds.y2() / 1024;
/* 72 */     if (qy2 >= this.qMaxY) {
/* 73 */       qy2 = this.qMaxY - 1;
/*    */     }
/* 75 */     for (int y = qy1; y <= qy2; y++) {
/* 76 */       for (int x = qx1; x <= qx2; x++) {
/* 77 */         this.quadrants[y][x].fill(bounds, result);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   void clear() {
/* 84 */     for (int y = 0; y < this.quadrants.length; y++) {
/* 85 */       for (int x = 0; x < (this.quadrants[0]).length; x++)
/* 86 */         this.quadrants[y][x].clear(); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Map.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */