/*    */ package org.lwjgl.system;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface FunctionProviderLocal
/*    */   extends FunctionProvider
/*    */ {
/*    */   default long getFunctionAddress(long handle, CharSequence functionName) {
/* 16 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 17 */       return getFunctionAddress(handle, stack.ASCII(functionName));
/*    */     } 
/*    */   }
/*    */   
/*    */   long getFunctionAddress(long paramLong, ByteBuffer paramByteBuffer);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\FunctionProviderLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */