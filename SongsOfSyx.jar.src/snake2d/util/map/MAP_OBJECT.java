/*    */ package snake2d.util.map;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ public interface MAP_OBJECT<T>
/*    */   extends MAP_OBJECT_ISSER<T>, MAP_BOOLEAN
/*    */ {
/*    */   default boolean is(int tile) {
/* 10 */     return (get(tile) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   default boolean is(int tx, int ty) {
/* 15 */     return (get(tx, ty) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   default boolean is(int tile, T value) {
/* 20 */     return (get(tile) == value);
/*    */   }
/*    */ 
/*    */   
/*    */   default boolean is(int tx, int ty, T value) {
/* 25 */     return (get(tx, ty) == value);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   T get(int paramInt);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   T get(int paramInt1, int paramInt2);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default T get(int tx, int ty, DIR d) {
/* 51 */     return get(tx + d.x(), ty + d.y());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default T get(COORDINATE c) {
/* 60 */     return get(c.x(), c.y());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default T get(COORDINATE c, DIR d) {
/* 70 */     return get(c.x() + d.x(), c.y() + d.y());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_OBJECT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */