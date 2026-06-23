/*    */ package util.data;
/*    */ 
/*    */ import snake2d.util.misc.CLAMP;
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
/*    */ public interface INTE
/*    */   extends INT, DOUBLE.DOUBLE_MUTABLE
/*    */ {
/*    */   default void inc(int i) {
/* 34 */     set(CLAMP.i(get() + i, min(), max()));
/*    */   }
/*    */ 
/*    */   
/*    */   default INTE incD(double d) {
/* 39 */     int i = (int)(max() * d);
/* 40 */     if (i == 0)
/* 41 */       if (d < 0.0D) {
/* 42 */         i = -1;
/*    */       } else {
/* 44 */         i = 1;
/* 45 */       }   inc(i);
/* 46 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   default DOUBLE.DOUBLE_MUTABLE setD(double d) {
/* 51 */     set((int)Math.ceil(d * max()));
/* 52 */     return this;
/*    */   }
/*    */   
/*    */   void set(int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\INT$INTE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */