/*    */ package settlement.misc.util;
/*    */ 
/*    */ 
/*    */ public interface FSERVICE
/*    */   extends FINDABLE
/*    */ {
/*    */   void consume();
/*    */   
/*    */   default void startUsing() {}
/*    */   
/*    */   default boolean hasQueue() {
/* 12 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\mis\\util\FSERVICE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */