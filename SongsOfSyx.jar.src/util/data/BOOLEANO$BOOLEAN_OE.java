/*    */ package util.data;
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
/*    */ public interface BOOLEAN_OE<T>
/*    */   extends BOOLEANO<T>
/*    */ {
/*    */   BOOLEAN_OE<T> set(T paramT, boolean paramBoolean);
/*    */   
/*    */   default BOOLEAN_OE<T> toggle(T t) {
/* 25 */     return set(t, !is(t));
/*    */   }
/*    */   
/*    */   default BOOLEAN_OE<T> setOn(T t) {
/* 29 */     return set(t, true);
/*    */   }
/*    */   
/*    */   default BOOLEAN_OE<T> setOff(T t) {
/* 33 */     return set(t, false);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\BOOLEANO$BOOLEAN_OE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */