/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import java.nio.LongBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVXProgressFence
/*    */ {
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */   protected NVXProgressFence() {
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
/*    */   
/*    */   public static void glSignalSemaphoreui64NVX(@NativeType("GLuint") int signalGpu, @NativeType("GLuint const *") IntBuffer semaphoreArray, @NativeType("GLuint64 const *") LongBuffer fenceValueArray) {
/* 37 */     if (Checks.CHECKS) {
/* 38 */       Checks.check(fenceValueArray, semaphoreArray.remaining());
/*    */     }
/* 40 */     nglSignalSemaphoreui64NVX(signalGpu, semaphoreArray.remaining(), MemoryUtil.memAddress(semaphoreArray), MemoryUtil.memAddress(fenceValueArray));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glWaitSemaphoreui64NVX(@NativeType("GLuint") int waitGpu, @NativeType("GLuint const *") IntBuffer semaphoreArray, @NativeType("GLuint64 const *") LongBuffer fenceValueArray) {
/* 50 */     if (Checks.CHECKS) {
/* 51 */       Checks.check(fenceValueArray, semaphoreArray.remaining());
/*    */     }
/* 53 */     nglWaitSemaphoreui64NVX(waitGpu, semaphoreArray.remaining(), MemoryUtil.memAddress(semaphoreArray), MemoryUtil.memAddress(fenceValueArray));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glClientWaitSemaphoreui64NVX(@NativeType("GLuint const *") IntBuffer semaphoreArray, @NativeType("GLuint64 const *") LongBuffer fenceValueArray) {
/* 63 */     if (Checks.CHECKS) {
/* 64 */       Checks.check(fenceValueArray, semaphoreArray.remaining());
/*    */     }
/* 66 */     nglClientWaitSemaphoreui64NVX(semaphoreArray.remaining(), MemoryUtil.memAddress(semaphoreArray), MemoryUtil.memAddress(fenceValueArray));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glSignalSemaphoreui64NVX(@NativeType("GLuint") int signalGpu, @NativeType("GLuint const *") int[] semaphoreArray, @NativeType("GLuint64 const *") long[] fenceValueArray) {
/* 71 */     long __functionAddress = (GL.getICD()).glSignalSemaphoreui64NVX;
/* 72 */     if (Checks.CHECKS) {
/* 73 */       Checks.check(__functionAddress);
/* 74 */       Checks.check(fenceValueArray, semaphoreArray.length);
/*    */     } 
/* 76 */     JNI.callPPV(signalGpu, semaphoreArray.length, semaphoreArray, fenceValueArray, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glWaitSemaphoreui64NVX(@NativeType("GLuint") int waitGpu, @NativeType("GLuint const *") int[] semaphoreArray, @NativeType("GLuint64 const *") long[] fenceValueArray) {
/* 81 */     long __functionAddress = (GL.getICD()).glWaitSemaphoreui64NVX;
/* 82 */     if (Checks.CHECKS) {
/* 83 */       Checks.check(__functionAddress);
/* 84 */       Checks.check(fenceValueArray, semaphoreArray.length);
/*    */     } 
/* 86 */     JNI.callPPV(waitGpu, semaphoreArray.length, semaphoreArray, fenceValueArray, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glClientWaitSemaphoreui64NVX(@NativeType("GLuint const *") int[] semaphoreArray, @NativeType("GLuint64 const *") long[] fenceValueArray) {
/* 91 */     long __functionAddress = (GL.getICD()).glClientWaitSemaphoreui64NVX;
/* 92 */     if (Checks.CHECKS) {
/* 93 */       Checks.check(__functionAddress);
/* 94 */       Checks.check(fenceValueArray, semaphoreArray.length);
/*    */     } 
/* 96 */     JNI.callPPV(semaphoreArray.length, semaphoreArray, fenceValueArray, __functionAddress);
/*    */   }
/*    */   
/*    */   @NativeType("GLuint")
/*    */   public static native int glCreateProgressFenceNVX();
/*    */   
/*    */   public static native void nglSignalSemaphoreui64NVX(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void nglWaitSemaphoreui64NVX(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void nglClientWaitSemaphoreui64NVX(int paramInt, long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVXProgressFence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */