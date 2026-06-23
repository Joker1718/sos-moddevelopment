/*    */ package snake2d.util.map;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ public interface MAP_OBJECTE<T>
/*    */   extends MAP_OBJECT<T> {
/*    */   void set(int paramInt, T paramT);
/*    */   
/*    */   default void set(int tx, int ty, DIR d, T object) {
/* 11 */     set(tx + d.x(), ty + d.y(), object);
/*    */   } void set(int paramInt1, int paramInt2, T paramT);
/*    */   default void set(COORDINATE c, T object) {
/* 14 */     set(c.x(), c.y(), object);
/*    */   }
/*    */   
/*    */   default void set(COORDINATE c, DIR d, T object) {
/* 18 */     set(c.x() + d.x(), c.y() + d.y(), object);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_OBJECTE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */