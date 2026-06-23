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
/*     */ public interface MAP_INTE
/*     */   extends MAP_INT
/*     */ {
/*     */   MAP_INTE set(int paramInt1, int paramInt2);
/*     */   
/*     */   MAP_INTE set(int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   default MAP_INTE set(int tx, int ty, DIR d, int value) {
/*  26 */     return set(tx + d.x(), ty + d.y(), value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_INTE set(COORDINATE c, int value) {
/*  35 */     return set(c.x(), c.y(), value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_INTE set(COORDINATE c, DIR d, int value) {
/*  45 */     return set(c.x() + d.x(), c.y() + d.y(), value);
/*     */   }
/*     */   
/*     */   default MAP_INTE increment(int tile, int value) {
/*  49 */     return set(tile, get(tile) + value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_INTE increment(int tx, int ty, int value) {
/*  59 */     return set(tx, ty, get(tx, ty) + value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_INTE increment(int tx, int ty, DIR d, int value) {
/*  70 */     return set(tx + d.x(), ty + d.y(), get(tx, ty, d) + value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_INTE increment(COORDINATE c, int value) {
/*  79 */     return set(c.x(), c.y(), get(c) + value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MAP_INTE increment(COORDINATE c, DIR d, int value) {
/*  89 */     return set(c.x() + d.x(), c.y() + d.y(), get(c, d) + value);
/*     */   }
/*     */   
/*     */   public static abstract class INT_MAPEImp
/*     */     implements MAP_INTE {
/*     */     private final int width;
/*     */     private final int height;
/*     */     
/*     */     public INT_MAPEImp(int width, int height) {
/*  98 */       this.width = width;
/*  99 */       this.height = height;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int get(int tx, int ty) {
/* 105 */       if (tx >= 0 && tx < this.width && ty >= 0 && ty < this.height)
/* 106 */         return get(tx + ty * this.width); 
/* 107 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public MAP_INTE set(int tx, int ty, int value) {
/* 112 */       if (tx >= 0 && tx < this.width && ty >= 0 && ty < this.height)
/* 113 */         set(tx + ty * this.width, value); 
/* 114 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_INTE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */