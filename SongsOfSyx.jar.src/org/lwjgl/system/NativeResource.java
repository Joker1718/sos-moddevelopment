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
/*    */ public interface NativeResource
/*    */   extends AutoCloseable
/*    */ {
/*    */   void free();
/*    */   
/*    */   default void close() {
/* 20 */     free();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\NativeResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */