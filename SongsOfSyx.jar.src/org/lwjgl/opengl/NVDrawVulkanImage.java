/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVDrawVulkanImage
/*    */ {
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */   protected NVDrawVulkanImage() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
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
/*    */   @NativeType("VULKANPROCNV")
/*    */   public static long glGetVkProcAddrNV(@NativeType("GLchar const *") ByteBuffer name) {
/* 37 */     if (Checks.CHECKS) {
/* 38 */       Checks.checkNT1(name);
/*    */     }
/* 40 */     return nglGetVkProcAddrNV(MemoryUtil.memAddress(name));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("VULKANPROCNV")
/*    */   public static long glGetVkProcAddrNV(@NativeType("GLchar const *") CharSequence name) {
/* 46 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 48 */       stack.nASCII(name, true);
/* 49 */       long nameEncoded = stack.getPointerAddress();
/* 50 */       return nglGetVkProcAddrNV(nameEncoded);
/*    */     } finally {
/* 52 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native void glDrawVkImageNV(@NativeType("GLuint64") long paramLong, @NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4, @NativeType("GLfloat") float paramFloat5, @NativeType("GLfloat") float paramFloat6, @NativeType("GLfloat") float paramFloat7, @NativeType("GLfloat") float paramFloat8, @NativeType("GLfloat") float paramFloat9);
/*    */   
/*    */   public static native long nglGetVkProcAddrNV(long paramLong);
/*    */   
/*    */   public static native void glWaitVkSemaphoreNV(@NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glSignalVkSemaphoreNV(@NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glSignalVkFenceNV(@NativeType("GLuint64") long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVDrawVulkanImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */