/*     */ package snake2d.util.map;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface MAP_DOUBLE
/*     */ {
/*     */   default boolean is(int tile, double value) {
/*  15 */     return (get(tile) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean is(int tx, int ty, double value) {
/*  25 */     return (get(tx, ty) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean is(int tx, int ty, DIR d, double value) {
/*  36 */     return (get(tx, ty, d) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean is(COORDINATE c, double value) {
/*  45 */     return (get(c) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean is(COORDINATE c, DIR d, double value) {
/*  55 */     return (get(c, d) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   double get(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   double get(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default double get(int tx, int ty, DIR d) {
/*  81 */     return get(tx + d.x(), ty + d.y());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default double get(COORDINATE c) {
/*  90 */     return get(c.x(), c.y());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default double get(COORDINATE c, DIR d) {
/* 100 */     return get(c.x() + d.x(), c.y() + d.y());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_DOUBLE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */