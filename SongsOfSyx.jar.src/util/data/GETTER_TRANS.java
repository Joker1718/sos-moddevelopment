/*    */ package util.data;
/*    */ 
/*    */ import util.info.INFO;
/*    */ 
/*    */ public interface GETTER_TRANS<F, T>
/*    */ {
/*    */   T get(F paramF);
/*    */   
/*    */   default INFO info() {
/* 10 */     return null;
/*    */   }
/*    */   
/*    */   public static interface GETTER_TRANSE<F, T> extends GETTER_TRANS<F, T> {
/*    */     void set(F param1F, T param1T);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\GETTER_TRANS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */