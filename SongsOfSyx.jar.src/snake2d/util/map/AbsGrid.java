/*    */ package snake2d.util.map;
/*    */ 
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ public class AbsGrid
/*    */ {
/*    */   private final GridTile[][] quadrants;
/*    */   public final LIST<GridTile> all;
/*    */   public final RECTANGLE bounds;
/*    */   public final int qMaxX;
/*    */   public final int qMaxY;
/*    */   public final int gridSize;
/*    */   public final MAP_OBJECT<GridTile> map;
/*    */   
/*    */   public AbsGrid(int mapSizeX, int mapSizeY, int gridSize) {
/* 64 */     this.map = new MAP_OBJECT<GridTile>()
/*    */       {
/*    */         public AbsGrid.GridTile get(int tx, int ty)
/*    */         {
/* 68 */           if (!AbsGrid.this.bounds.holdsPoint(tx, ty))
/* 69 */             return null; 
/* 70 */           return AbsGrid.this.quadrants[ty / AbsGrid.this.gridSize][tx / AbsGrid.this.gridSize];
/*    */         }
/*    */ 
/*    */         
/*    */         public AbsGrid.GridTile get(int tile) {
/* 75 */           return get(tile % AbsGrid.this.bounds.width(), tile / AbsGrid.this.bounds.width());
/*    */         }
/*    */       };
/*    */     this.gridSize = gridSize;
/*    */     this.qMaxX = mapSizeX / gridSize;
/*    */     this.qMaxY = mapSizeY / gridSize;
/*    */     this.bounds = (RECTANGLE)new Rec(mapSizeX, mapSizeY);
/*    */     this.quadrants = new GridTile[this.qMaxX][this.qMaxY];
/*    */     ArrayList<GridTile> quadrantsI = new ArrayList(this.qMaxX * this.qMaxY);
/*    */     int in = 0;
/*    */     for (int y = 0; y < this.quadrants.length; y++) {
/*    */       for (int x = 0; x < (this.quadrants[0]).length; x++) {
/*    */         int x1 = x * gridSize;
/*    */         int x2 = CLAMP.i(x1 + gridSize, 0, mapSizeX);
/*    */         int y1 = y * gridSize;
/*    */         int y2 = CLAMP.i(y1 + gridSize, 0, mapSizeY);
/*    */         GridTile t = new GridTile(in, x1, x2, y1, y2);
/*    */         quadrantsI.add(t);
/*    */         this.quadrants[y][x] = t;
/*    */         in++;
/*    */       } 
/*    */     } 
/*    */     this.all = (LIST<GridTile>)quadrantsI;
/*    */   }
/*    */   
/*    */   public static final class GridTile extends Rec {
/*    */     private static final long serialVersionUID = 1L;
/*    */     public final int index;
/*    */     
/*    */     GridTile(int index, int x1, int x2, int y1, int y2) {
/*    */       super(x1, x2, y1, y2);
/*    */       this.index = index;
/*    */     }
/*    */   }
/*    */   
/*    */   public GridTile get(int index) {
/*    */     return (GridTile)this.all.get(index);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\AbsGrid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */