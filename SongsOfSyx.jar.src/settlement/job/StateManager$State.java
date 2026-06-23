/*    */ package settlement.job;
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
/*    */ enum State
/*    */ {
/* 17 */   DORMANT, RESERVABLE, RESERVED, BLOCKED;
/*    */   static {
/* 19 */     all = values();
/*    */   }
/*    */   
/*    */   static State[] all;
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\StateManager$State.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */