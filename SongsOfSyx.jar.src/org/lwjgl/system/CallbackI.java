/*    */ package org.lwjgl.system;
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
/*    */ public interface CallbackI
/*    */   extends Pointer
/*    */ {
/*    */   Callback.Descriptor getDescriptor();
/*    */   
/*    */   default long address() {
/* 23 */     return Upcalls.upcallCreate(getDescriptor(), this);
/*    */   }
/*    */   
/*    */   void callback(long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\CallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */