/*    */ package snake2d.util.map;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIMENSION;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ 
/*    */ public interface MAP_BOOLEAN
/*    */ {
/*    */   boolean is(int paramInt);
/*    */   
/*    */   boolean is(int paramInt1, int paramInt2);
/*    */   
/*    */   default boolean is(int tx, int ty, DIR d) {
/* 16 */     return is(tx + d.x(), ty + d.y());
/*    */   }
/*    */   
/*    */   default boolean is(COORDINATE c) {
/* 20 */     return is(c.x(), c.y());
/*    */   }
/*    */   
/*    */   default boolean is(COORDINATE c, DIR d) {
/* 24 */     return is(c.x() + d.x(), c.y() + d.y());
/*    */   }
/*    */   
/*    */   public static abstract class BooleanMap
/*    */     implements MAP_BOOLEAN {
/*    */     public final int width;
/*    */     public final RECTANGLE body;
/*    */     
/*    */     public BooleanMap(int width, int height) {
/* 33 */       this.width = width;
/* 34 */       this.body = (RECTANGLE)new Rec(width, height);
/*    */     }
/*    */     
/*    */     public BooleanMap(DIMENSION dim) {
/* 38 */       this.width = dim.width();
/* 39 */       this.body = (RECTANGLE)new Rec(dim.width(), dim.height());
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean is(int tx, int ty) {
/* 44 */       return (this.body.holdsPoint(tx, ty) && is(tx + ty * this.width));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static abstract class MAP_BOOLEAN_IMP
/*    */     implements MAP_BOOLEAN
/*    */   {
/*    */     private final int width;
/*    */     
/*    */     public MAP_BOOLEAN_IMP(int width) {
/* 55 */       this.width = width;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean is(int tx, int ty) {
/* 60 */       return is(tx + ty * this.width);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_BOOLEAN.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */