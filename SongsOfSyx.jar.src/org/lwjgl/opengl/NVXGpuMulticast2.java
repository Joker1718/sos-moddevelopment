/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVXGpuMulticast2
/*     */ {
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */   protected NVXGpuMulticast2() {
/*  21 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glAsyncCopyImageSubDataNVX(@NativeType("GLuint const *") IntBuffer waitSemaphoreArray, @NativeType("GLuint64 const *") LongBuffer waitValueArray, @NativeType("GLuint") int srcGpu, @NativeType("GLbitfield") int dstGpuMask, @NativeType("GLuint") int srcName, @NativeType("GLenum") int srcTarget, @NativeType("GLint") int srcLevel, @NativeType("GLint") int srcX, @NativeType("GLint") int srcY, @NativeType("GLint") int srcZ, @NativeType("GLuint") int dstName, @NativeType("GLenum") int dstTarget, @NativeType("GLint") int dstLevel, @NativeType("GLint") int dstX, @NativeType("GLint") int dstY, @NativeType("GLint") int dstZ, @NativeType("GLsizei") int srcWidth, @NativeType("GLsizei") int srcHeight, @NativeType("GLsizei") int srcDepth, @NativeType("GLuint const *") IntBuffer signalSemaphoreArray, @NativeType("GLuint64 const *") LongBuffer signalValueArray) {
/*  32 */     if (Checks.CHECKS) {
/*  33 */       Checks.check(waitValueArray, waitSemaphoreArray.remaining());
/*  34 */       Checks.check(signalValueArray, signalSemaphoreArray.remaining());
/*     */     } 
/*  36 */     return nglAsyncCopyImageSubDataNVX(waitSemaphoreArray.remaining(), MemoryUtil.memAddress(waitSemaphoreArray), MemoryUtil.memAddress(waitValueArray), srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth, signalSemaphoreArray.remaining(), MemoryUtil.memAddress(signalSemaphoreArray), MemoryUtil.memAddress(signalValueArray));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLsync")
/*     */   public static long glAsyncCopyBufferSubDataNVX(@NativeType("GLuint const *") IntBuffer waitSemaphoreArray, @NativeType("GLuint64 const *") LongBuffer fenceValueArray, @NativeType("GLuint") int readGpu, @NativeType("GLbitfield") int writeGpuMask, @NativeType("GLuint") int readBuffer, @NativeType("GLuint") int writeBuffer, @NativeType("GLintptr") long readOffset, @NativeType("GLintptr") long writeOffset, @NativeType("GLsizeiptr") long size, @NativeType("GLuint const *") IntBuffer signalSemaphoreArray, @NativeType("GLuint64 const *") LongBuffer signalValueArray) {
/*  47 */     if (Checks.CHECKS) {
/*  48 */       Checks.check(fenceValueArray, waitSemaphoreArray.remaining());
/*  49 */       Checks.check(signalValueArray, signalSemaphoreArray.remaining());
/*     */     } 
/*  51 */     return nglAsyncCopyBufferSubDataNVX(waitSemaphoreArray.remaining(), MemoryUtil.memAddress(waitSemaphoreArray), MemoryUtil.memAddress(fenceValueArray), readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size, signalSemaphoreArray.remaining(), MemoryUtil.memAddress(signalSemaphoreArray), MemoryUtil.memAddress(signalValueArray));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastViewportArrayvNVX(@NativeType("GLuint") int gpu, @NativeType("GLuint") int first, @NativeType("GLfloat const *") FloatBuffer v) {
/*  66 */     nglMulticastViewportArrayvNVX(gpu, first, v.remaining() >> 2, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastScissorArrayvNVX(@NativeType("GLuint") int gpu, @NativeType("GLuint") int first, @NativeType("GLint const *") IntBuffer v) {
/*  76 */     nglMulticastScissorArrayvNVX(gpu, first, v.remaining() >> 2, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glAsyncCopyImageSubDataNVX(@NativeType("GLuint const *") int[] waitSemaphoreArray, @NativeType("GLuint64 const *") long[] waitValueArray, @NativeType("GLuint") int srcGpu, @NativeType("GLbitfield") int dstGpuMask, @NativeType("GLuint") int srcName, @NativeType("GLenum") int srcTarget, @NativeType("GLint") int srcLevel, @NativeType("GLint") int srcX, @NativeType("GLint") int srcY, @NativeType("GLint") int srcZ, @NativeType("GLuint") int dstName, @NativeType("GLenum") int dstTarget, @NativeType("GLint") int dstLevel, @NativeType("GLint") int dstX, @NativeType("GLint") int dstY, @NativeType("GLint") int dstZ, @NativeType("GLsizei") int srcWidth, @NativeType("GLsizei") int srcHeight, @NativeType("GLsizei") int srcDepth, @NativeType("GLuint const *") int[] signalSemaphoreArray, @NativeType("GLuint64 const *") long[] signalValueArray) {
/*  87 */     long __functionAddress = (GL.getICD()).glAsyncCopyImageSubDataNVX;
/*  88 */     if (Checks.CHECKS) {
/*  89 */       Checks.check(__functionAddress);
/*  90 */       Checks.check(waitValueArray, waitSemaphoreArray.length);
/*  91 */       Checks.check(signalValueArray, signalSemaphoreArray.length);
/*     */     } 
/*  93 */     return JNI.callPPPPI(waitSemaphoreArray.length, waitSemaphoreArray, waitValueArray, srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth, signalSemaphoreArray.length, signalSemaphoreArray, signalValueArray, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLsync")
/*     */   public static long glAsyncCopyBufferSubDataNVX(@NativeType("GLuint const *") int[] waitSemaphoreArray, @NativeType("GLuint64 const *") long[] fenceValueArray, @NativeType("GLuint") int readGpu, @NativeType("GLbitfield") int writeGpuMask, @NativeType("GLuint") int readBuffer, @NativeType("GLuint") int writeBuffer, @NativeType("GLintptr") long readOffset, @NativeType("GLintptr") long writeOffset, @NativeType("GLsizeiptr") long size, @NativeType("GLuint const *") int[] signalSemaphoreArray, @NativeType("GLuint64 const *") long[] signalValueArray) {
/*  99 */     long __functionAddress = (GL.getICD()).glAsyncCopyBufferSubDataNVX;
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.check(__functionAddress);
/* 102 */       Checks.check(fenceValueArray, waitSemaphoreArray.length);
/* 103 */       Checks.check(signalValueArray, signalSemaphoreArray.length);
/*     */     } 
/* 105 */     return JNI.callPPPPPPPP(waitSemaphoreArray.length, waitSemaphoreArray, fenceValueArray, readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size, signalSemaphoreArray.length, signalSemaphoreArray, signalValueArray, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastViewportArrayvNVX(@NativeType("GLuint") int gpu, @NativeType("GLuint") int first, @NativeType("GLfloat const *") float[] v) {
/* 110 */     long __functionAddress = (GL.getICD()).glMulticastViewportArrayvNVX;
/* 111 */     if (Checks.CHECKS) {
/* 112 */       Checks.check(__functionAddress);
/*     */     }
/* 114 */     JNI.callPV(gpu, first, v.length >> 2, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastScissorArrayvNVX(@NativeType("GLuint") int gpu, @NativeType("GLuint") int first, @NativeType("GLint const *") int[] v) {
/* 119 */     long __functionAddress = (GL.getICD()).glMulticastScissorArrayvNVX;
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(__functionAddress);
/*     */     }
/* 123 */     JNI.callPV(gpu, first, v.length >> 2, v, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native int nglAsyncCopyImageSubDataNVX(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, int paramInt18, int paramInt19, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native long nglAsyncCopyBufferSubDataNVX(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong3, long paramLong4, long paramLong5, int paramInt6, long paramLong6, long paramLong7);
/*     */   
/*     */   public static native void glUploadGpuMaskNVX(@NativeType("GLbitfield") int paramInt);
/*     */   
/*     */   public static native void nglMulticastViewportArrayvNVX(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglMulticastScissorArrayvNVX(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glMulticastViewportPositionWScaleNVX(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVXGpuMulticast2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */