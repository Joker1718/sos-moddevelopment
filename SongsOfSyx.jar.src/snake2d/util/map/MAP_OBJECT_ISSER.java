/*    */ package snake2d.util.map;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
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
/*    */ public interface MAP_OBJECT_ISSER<T>
/*    */ {
/*    */   boolean is(int paramInt, T paramT);
/*    */   
/*    */   boolean is(int paramInt1, int paramInt2, T paramT);
/*    */   
/*    */   default boolean is(int tx, int ty, DIR d, T value) {
/* 32 */     return is(tx + d.x(), ty + d.y(), value);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default boolean is(COORDINATE c, T value) {
/* 41 */     return is(c.x(), c.y(), value);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default boolean is(COORDINATE c, DIR d, T value) {
/* 51 */     return is(c.x() + d.x(), c.y() + d.y(), value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_OBJECT_ISSER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */