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
/*     */ public class NVTransformFeedback2
/*     */ {
/*     */   public static final int GL_TRANSFORM_FEEDBACK_NV = 36386;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED_NV = 36387;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE_NV = 36388;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BINDING_NV = 36389;
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
/*     */   protected NVTransformFeedback2() {
/*  29 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDeleteTransformFeedbacksNV(@NativeType("GLuint const *") IntBuffer ids) {
/*  44 */     nglDeleteTransformFeedbacksNV(ids.remaining(), MemoryUtil.memAddress(ids));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacksNV(@NativeType("GLuint const *") int id) {
/*  49 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  51 */       IntBuffer ids = stack.ints(id);
/*  52 */       nglDeleteTransformFeedbacksNV(1, MemoryUtil.memAddress(ids));
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
/*     */   public static void glGenTransformFeedbacksNV(@NativeType("GLuint *") IntBuffer ids) {
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(ids, 1);
/*     */     }
/*  68 */     nglGenTransformFeedbacksNV(ids.remaining(), MemoryUtil.memAddress(ids));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenTransformFeedbacksNV() {
/*  74 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  76 */       IntBuffer ids = stack.callocInt(1);
/*  77 */       nglGenTransformFeedbacksNV(1, MemoryUtil.memAddress(ids));
/*  78 */       return ids.get(0);
/*     */     } finally {
/*  80 */       stack.setPointer(stackPointer);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacksNV(@NativeType("GLuint const *") int[] ids) {
/* 107 */     long __functionAddress = (GL.getICD()).glDeleteTransformFeedbacksNV;
/* 108 */     if (Checks.CHECKS) {
/* 109 */       Checks.check(__functionAddress);
/*     */     }
/* 111 */     JNI.callPV(ids.length, ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacksNV(@NativeType("GLuint *") int[] ids) {
/* 116 */     long __functionAddress = (GL.getICD()).glGenTransformFeedbacksNV;
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.check(__functionAddress);
/* 119 */       Checks.check(ids, 1);
/*     */     } 
/* 121 */     JNI.callPV(ids.length, ids, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glBindTransformFeedbackNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteTransformFeedbacksNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenTransformFeedbacksNV(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsTransformFeedbackNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glPauseTransformFeedbackNV();
/*     */   
/*     */   public static native void glResumeTransformFeedbackNV();
/*     */   
/*     */   public static native void glDrawTransformFeedbackNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVTransformFeedback2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */