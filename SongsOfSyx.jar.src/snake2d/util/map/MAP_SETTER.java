/*    */ package snake2d.util.map;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ public interface MAP_SETTER
/*    */ {
/*    */   MAP_SETTER set(int paramInt);
/*    */   
/*    */   MAP_SETTER set(int paramInt1, int paramInt2);
/*    */   
/*    */   default MAP_SETTER set(int tx, int ty, DIR d) {
/* 13 */     return set(tx + d.x(), ty + d.y());
/*    */   }
/*    */   
/*    */   default MAP_SETTER set(COORDINATE c) {
/* 17 */     return set(c.x(), c.y());
/*    */   }
/*    */   
/*    */   default MAP_SETTER set(COORDINATE c, DIR d) {
/* 21 */     return set(c.x() + d.x(), c.y() + d.y());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_SETTER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */