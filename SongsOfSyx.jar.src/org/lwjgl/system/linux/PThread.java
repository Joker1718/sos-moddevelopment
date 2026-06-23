/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PThread
/*    */ {
/*    */   static {
/* 12 */     Library.initialize();
/*    */   }
/*    */   protected PThread() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   @NativeType("pthread_t")
/*    */   public static native long pthread_self();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\PThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */