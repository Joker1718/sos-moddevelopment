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
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface FunctionProvider
/*    */ {
/*    */   default long getFunctionAddress(CharSequence functionName) {
/* 17 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 18 */       return getFunctionAddress(stack.ASCII(functionName));
/*    */     } 
/*    */   }
/*    */   
/*    */   long getFunctionAddress(ByteBuffer paramByteBuffer);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\FunctionProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */