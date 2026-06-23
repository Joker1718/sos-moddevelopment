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
/*    */ public interface MAP_BOOLEANE
/*    */   extends MAP_BOOLEAN
/*    */ {
/*    */   MAP_BOOLEANE set(int paramInt, boolean paramBoolean);
/*    */   
/*    */   MAP_BOOLEANE set(int paramInt1, int paramInt2, boolean paramBoolean);
/*    */   
/*    */   default MAP_BOOLEANE set(int tx, int ty, DIR d, boolean value) {
/* 26 */     return set(tx + d.x(), ty + d.y(), value);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default MAP_BOOLEANE set(COORDINATE c, boolean value) {
/* 35 */     return set(c.x(), c.y(), value);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default MAP_BOOLEANE set(COORDINATE c, DIR d, boolean value) {
/* 45 */     return set(c.x() + d.x(), c.y() + d.y(), value);
/*    */   }
/*    */   
/*    */   public static abstract class BooleanMapE
/*    */     extends MAP_BOOLEAN.BooleanMap
/*    */     implements MAP_BOOLEANE
/*    */   {
/*    */     public BooleanMapE(int width, int height) {
/* 53 */       super(width, height);
/*    */     }
/*    */ 
/*    */     
/*    */     public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 58 */       if (this.body.holdsPoint(tx, ty))
/* 59 */         set(tx + ty * this.width, value); 
/* 60 */       return this;
/*    */     }
/*    */     
/*    */     public void setAll(boolean value) {
/* 64 */       int a = this.body.height() * this.body.width();
/* 65 */       for (int i = 0; i < a; i++)
/* 66 */         set(i, value); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\map\MAP_BOOLEANE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */