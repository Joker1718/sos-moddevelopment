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
/*    */ public interface DOUBLE_MUTABLE
/*    */   extends DOUBLE
/*    */ {
/*    */   default DOUBLE_MUTABLE incD(double d) {
/* 19 */     setD(getD() + d);
/* 20 */     return this;
/*    */   }
/*    */   
/*    */   DOUBLE_MUTABLE setD(double paramDouble);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DOUBLE$DOUBLE_MUTABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */