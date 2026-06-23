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
/*    */ public interface BOOLEAN_MUTABLE
/*    */   extends BOOLEAN
/*    */ {
/*    */   BOOLEAN_MUTABLE set(boolean paramBoolean);
/*    */   
/*    */   default BOOLEAN_MUTABLE toggle() {
/* 19 */     return set(!is());
/*    */   }
/*    */   
/*    */   default BOOLEAN_MUTABLE setOn() {
/* 23 */     return set(true);
/*    */   }
/*    */   
/*    */   default BOOLEAN_MUTABLE setOff() {
/* 27 */     return set(false);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\BOOLEAN$BOOLEAN_MUTABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */