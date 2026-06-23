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
/*    */ public interface MAP_PLACER
/*    */   extends MAP_BOOLEAN, MAP_SETTER, MAP_CLEARER
/*    */ {
/*    */   default MAP_PLACER clear(int tx, int ty, DIR d) {
/* 16 */     return clear(tx + d.x(), ty + d.y());
/*    */   }
/*    */ 
/*    */   
/*    */   default MAP_PLACER clear(COORDINATE c) {
/* 21 */     return clear(c.x(), c.y());
/*    */   }
/*    */ 
/*    */   
/*    */   default MAP_PLACER clear(COORDINATE c, DIR d) {
/* 26 */     return clear(c.x() + d.x(), c.y() + d.y());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default MAP_PLACER set(int tx, int ty, DIR d) {
/* 37 */     return set(tx + d.x(), ty + d.y());
/*    */   }
/*    */ 
/*    */   
/*    */   default MAP_PLACER set(COORDINATE c) {
/* 42 */     return set(c.x(), c.y());
/*    */   }
/*    */ 
/*    */   
/*    */   default MAP_PLACER set(COORDINATE c, DIR d) {
/* 47 */     return set(c.x() + d.x(), c.y() + d.y());
/*    */   }
/*    */   
/*    */   MAP_PLACER clear(int paramInt);
/*    */   
/*    */   MAP_PLACER clear(int paramInt1, int paramInt2);
/*    */   
/*    */   MAP_PLACER set(int paramInt);
/*    */   
/*    */   MAP_PLACER set(int paramInt1, int paramInt2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_PLACER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */