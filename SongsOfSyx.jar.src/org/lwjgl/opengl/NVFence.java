/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVFence
/*     */ {
/*     */   public static final int GL_ALL_COMPLETED_NV = 34034;
/*     */   public static final int GL_FENCE_STATUS_NV = 34035;
/*     */   public static final int GL_FENCE_CONDITION_NV = 34036;
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
/*     */   protected NVFence() {
/*  28 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteFencesNV(@NativeType("GLuint const *") IntBuffer fences) {
/*  38 */     nglDeleteFencesNV(fences.remaining(), MemoryUtil.memAddress(fences));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteFencesNV(@NativeType("GLuint const *") int fence) {
/*  43 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  45 */       IntBuffer fences = stack.ints(fence);
/*  46 */       nglDeleteFencesNV(1, MemoryUtil.memAddress(fences));
/*     */     } finally {
/*  48 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenFencesNV(@NativeType("GLuint *") IntBuffer fences) {
/*  59 */     nglGenFencesNV(fences.remaining(), MemoryUtil.memAddress(fences));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenFencesNV() {
/*  65 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  67 */       IntBuffer fences = stack.callocInt(1);
/*  68 */       nglGenFencesNV(1, MemoryUtil.memAddress(fences));
/*  69 */       return fences.get(0);
/*     */     } finally {
/*  71 */       stack.setPointer(stackPointer);
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetFenceivNV(@NativeType("GLuint") int fence, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  94 */     if (Checks.CHECKS) {
/*  95 */       Checks.check(params, 1);
/*     */     }
/*  97 */     nglGetFenceivNV(fence, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetFenceiNV(@NativeType("GLuint") int fence, @NativeType("GLenum") int pname) {
/* 103 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 105 */       IntBuffer params = stack.callocInt(1);
/* 106 */       nglGetFenceivNV(fence, pname, MemoryUtil.memAddress(params));
/* 107 */       return params.get(0);
/*     */     } finally {
/* 109 */       stack.setPointer(stackPointer);
/*     */     } 
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
/*     */   public static void glDeleteFencesNV(@NativeType("GLuint const *") int[] fences) {
/* 125 */     long __functionAddress = (GL.getICD()).glDeleteFencesNV;
/* 126 */     if (Checks.CHECKS) {
/* 127 */       Checks.check(__functionAddress);
/*     */     }
/* 129 */     JNI.callPV(fences.length, fences, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenFencesNV(@NativeType("GLuint *") int[] fences) {
/* 134 */     long __functionAddress = (GL.getICD()).glGenFencesNV;
/* 135 */     if (Checks.CHECKS) {
/* 136 */       Checks.check(__functionAddress);
/*     */     }
/* 138 */     JNI.callPV(fences.length, fences, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFenceivNV(@NativeType("GLuint") int fence, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 143 */     long __functionAddress = (GL.getICD()).glGetFenceivNV;
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(__functionAddress);
/* 146 */       Checks.check(params, 1);
/*     */     } 
/* 148 */     JNI.callPV(fence, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglDeleteFencesNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenFencesNV(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsFenceNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glTestFenceNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglGetFenceivNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glFinishFenceNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glSetFenceNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVFence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */