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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface MAP_DOUBLEE
/*     */   extends MAP_DOUBLE
/*     */ {
/*     */   MAP_DOUBLEE set(int paramInt, double paramDouble);
/*     */   
/*     */   MAP_DOUBLEE set(int paramInt1, int paramInt2, double paramDouble);
/*     */   
/*     */   default MAP_DOUBLEE set(int tx, int ty, DIR d, double value) {
/*  28 */     return set(tx + d.x(), ty + d.y(), value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_DOUBLEE set(COORDINATE c, double value) {
/*  37 */     return set(c.x(), c.y(), value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_DOUBLEE set(COORDINATE c, DIR d, double value) {
/*  47 */     return set(c.x() + d.x(), c.y() + d.y(), value);
/*     */   }
/*     */   
/*     */   default MAP_DOUBLEE increment(int tile, double value) {
/*  51 */     return set(tile, get(tile) + value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_DOUBLEE increment(int tx, int ty, double value) {
/*  61 */     return set(tx, ty, get(tx, ty) + value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_DOUBLEE increment(int tx, int ty, DIR d, double value) {
/*  72 */     return set(tx + d.x(), ty + d.y(), get(tx, ty, d) + value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_DOUBLEE increment(COORDINATE c, double value) {
/*  81 */     return set(c.x(), c.y(), get(c) + value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_DOUBLEE increment(COORDINATE c, DIR d, double value) {
/*  91 */     return set(c.x() + d.x(), c.y() + d.y(), get(c, d) + value);
/*     */   }
/*     */   
/*     */   public static abstract class DoubleMapImp
/*     */     implements MAP_DOUBLEE {
/*     */     private final int width;
/*     */     private final int height;
/*     */     
/*     */     public DoubleMapImp(int width, int height) {
/* 100 */       this.width = width;
/* 101 */       this.height = height;
/*     */     }
/*     */     
/*     */     public double get(int tx, int ty) {
/* 105 */       if (tx < 0 || tx >= this.width || ty < 0 || ty >= this.height)
/* 106 */         return 0.0D; 
/* 107 */       return get(tx + ty * this.width);
/*     */     }
/*     */ 
/*     */     
/*     */     public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 112 */       if (tx < 0 || tx >= this.width || ty < 0 || ty >= this.height)
/* 113 */         return this; 
/* 114 */       set(tx + ty * this.width, value);
/* 115 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_DOUBLEE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */