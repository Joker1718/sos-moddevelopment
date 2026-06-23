/*    */ package snake2d.util.map;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ public interface MAP_CLEARER
/*    */ {
/*    */   MAP_CLEARER clear(int paramInt);
/*    */   
/*    */   MAP_CLEARER clear(int paramInt1, int paramInt2);
/*    */   
/*    */   default MAP_CLEARER clear(int tx, int ty, DIR d) {
/* 13 */     return clear(tx + d.x(), ty + d.y());
/*    */   }
/*    */   
/*    */   default MAP_CLEARER clear(COORDINATE c) {
/* 17 */     return clear(c.x(), c.y());
/*    */   }
/*    */   
/*    */   default MAP_CLEARER clear(COORDINATE c, DIR d) {
/* 21 */     return clear(c.x() + d.x(), c.y() + d.y());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_CLEARER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */