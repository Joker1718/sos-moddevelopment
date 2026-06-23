/*    */ package util.data;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface DOUBLE_OE<T>
/*    */   extends DOUBLE_O<T>
/*    */ {
/*    */   default DOUBLE_OE<T> incD(T t, double d) {
/* 13 */     setD(t, getD(t) + d);
/* 14 */     return this;
/*    */   }
/*    */   
/*    */   DOUBLE_OE<T> setD(T paramT, double paramDouble);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DOUBLE_O$DOUBLE_OE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */