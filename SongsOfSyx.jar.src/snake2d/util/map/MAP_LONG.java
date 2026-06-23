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
/*     */ public interface MAP_LONG
/*     */ {
/*     */   default boolean is(int tile, long value) {
/*  14 */     return (get(tile) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean is(int tx, int ty, long value) {
/*  24 */     return (get(tx, ty) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean is(int tx, int ty, DIR d, long value) {
/*  35 */     return (get(tx, ty, d) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean is(COORDINATE c, long value) {
/*  44 */     return (get(c) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean is(COORDINATE c, DIR d, long value) {
/*  54 */     return (get(c, d) == value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long get(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long get(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default long get(int tx, int ty, DIR d) {
/*  80 */     return get(tx + d.x(), ty + d.y());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default long get(COORDINATE c) {
/*  89 */     return get(c.x(), c.y());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default long get(COORDINATE c, DIR d) {
/*  99 */     return get(c.x() + d.x(), c.y() + d.y());
/*     */   }
/*     */   
/*     */   default long max() {
/* 103 */     return Long.MAX_VALUE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_LONG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */