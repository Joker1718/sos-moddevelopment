/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class NVTimelineSemaphore
/*     */ {
/*     */   public static final int GL_SEMAPHORE_TYPE_NV = 38323;
/*     */   public static final int GL_SEMAPHORE_TYPE_BINARY_NV = 38324;
/*     */   public static final int GL_SEMAPHORE_TYPE_TIMELINE_NV = 38325;
/*     */   public static final int GL_TIMELINE_SEMAPHORE_VALUE_NV = 38293;
/*     */   public static final int GL_MAX_TIMELINE_SEMAPHORE_VALUE_DIFFERENCE_NV = 38326;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
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
/*     */   protected NVTimelineSemaphore() {
/*  32 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCreateSemaphoresNV(@NativeType("GLuint *") IntBuffer semaphores) {
/*  42 */     nglCreateSemaphoresNV(semaphores.remaining(), MemoryUtil.memAddress(semaphores));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glCreateSemaphoresNV() {
/*  48 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  50 */       IntBuffer semaphores = stack.callocInt(1);
/*  51 */       nglCreateSemaphoresNV(1, MemoryUtil.memAddress(semaphores));
/*  52 */       return semaphores.get(0);
/*     */     } finally {
/*  54 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSemaphoreParameterivNV(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(params, 1);
/*     */     }
/*  68 */     nglSemaphoreParameterivNV(semaphore, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSemaphoreParameterivNV(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  78 */     if (Checks.CHECKS) {
/*  79 */       Checks.check(params, 1);
/*     */     }
/*  81 */     nglGetSemaphoreParameterivNV(semaphore, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCreateSemaphoresNV(@NativeType("GLuint *") int[] semaphores) {
/*  86 */     long __functionAddress = (GL.getICD()).glCreateSemaphoresNV;
/*  87 */     if (Checks.CHECKS) {
/*  88 */       Checks.check(__functionAddress);
/*     */     }
/*  90 */     JNI.callPV(semaphores.length, semaphores, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSemaphoreParameterivNV(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/*  95 */     long __functionAddress = (GL.getICD()).glSemaphoreParameterivNV;
/*  96 */     if (Checks.CHECKS) {
/*  97 */       Checks.check(__functionAddress);
/*  98 */       Checks.check(params, 1);
/*     */     } 
/* 100 */     JNI.callPV(semaphore, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSemaphoreParameterivNV(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 105 */     long __functionAddress = (GL.getICD()).glGetSemaphoreParameterivNV;
/* 106 */     if (Checks.CHECKS) {
/* 107 */       Checks.check(__functionAddress);
/* 108 */       Checks.check(params, 1);
/*     */     } 
/* 110 */     JNI.callPV(semaphore, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglCreateSemaphoresNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglSemaphoreParameterivNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSemaphoreParameterivNV(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVTimelineSemaphore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */