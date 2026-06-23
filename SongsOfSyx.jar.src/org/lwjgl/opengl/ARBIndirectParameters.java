/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBIndirectParameters
/*    */ {
/*    */   public static final int GL_PARAMETER_BUFFER_ARB = 33006;
/*    */   public static final int GL_PARAMETER_BUFFER_BINDING_ARB = 33007;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBIndirectParameters() {
/* 25 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirectCountARB(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 35 */     if (Checks.CHECKS) {
/* 36 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 16 : stride));
/*    */     }
/* 38 */     nglMultiDrawArraysIndirectCountARB(mode, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirectCountARB(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 43 */     nglMultiDrawArraysIndirectCountARB(mode, indirect, drawcount, maxdrawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirectCountARB(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 48 */     if (Checks.CHECKS) {
/* 49 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 16 : stride) >> 2);
/*    */     }
/* 51 */     nglMultiDrawArraysIndirectCountARB(mode, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirectCountARB(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 61 */     if (Checks.CHECKS) {
/* 62 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 20 : stride));
/*    */     }
/* 64 */     nglMultiDrawElementsIndirectCountARB(mode, type, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirectCountARB(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 69 */     nglMultiDrawElementsIndirectCountARB(mode, type, indirect, drawcount, maxdrawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirectCountARB(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 74 */     if (Checks.CHECKS) {
/* 75 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 20 : stride) >> 2);
/*    */     }
/* 77 */     nglMultiDrawElementsIndirectCountARB(mode, type, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirectCountARB(@NativeType("GLenum") int mode, @NativeType("void const *") int[] indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 82 */     long __functionAddress = (GL.getICD()).glMultiDrawArraysIndirectCountARB;
/* 83 */     if (Checks.CHECKS) {
/* 84 */       Checks.check(__functionAddress);
/* 85 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 16 : stride) >> 2);
/*    */     } 
/* 87 */     JNI.callPPV(mode, indirect, drawcount, maxdrawcount, stride, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirectCountARB(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") int[] indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 92 */     long __functionAddress = (GL.getICD()).glMultiDrawElementsIndirectCountARB;
/* 93 */     if (Checks.CHECKS) {
/* 94 */       Checks.check(__functionAddress);
/* 95 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 20 : stride) >> 2);
/*    */     } 
/* 97 */     JNI.callPPV(mode, type, indirect, drawcount, maxdrawcount, stride, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglMultiDrawArraysIndirectCountARB(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3);
/*    */   
/*    */   public static native void nglMultiDrawElementsIndirectCountARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBIndirectParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */