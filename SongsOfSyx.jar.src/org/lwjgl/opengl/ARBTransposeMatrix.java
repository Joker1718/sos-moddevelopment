/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBTransposeMatrix
/*     */ {
/*     */   public static final int GL_TRANSPOSE_MODELVIEW_MATRIX_ARB = 34019;
/*     */   public static final int GL_TRANSPOSE_PROJECTION_MATRIX_ARB = 34020;
/*     */   public static final int GL_TRANSPOSE_TEXTURE_MATRIX_ARB = 34021;
/*     */   public static final int GL_TRANSPOSE_COLOR_MATRIX_ARB = 34022;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBTransposeMatrix() {
/*  27 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixfARB(@NativeType("GLfloat const *") FloatBuffer m) {
/*  37 */     if (Checks.CHECKS) {
/*  38 */       Checks.check(m, 16);
/*     */     }
/*  40 */     nglLoadTransposeMatrixfARB(MemoryUtil.memAddress(m));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixdARB(@NativeType("GLdouble const *") DoubleBuffer m) {
/*  50 */     if (Checks.CHECKS) {
/*  51 */       Checks.check(m, 16);
/*     */     }
/*  53 */     nglLoadTransposeMatrixdARB(MemoryUtil.memAddress(m));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixfARB(@NativeType("GLfloat const *") FloatBuffer m) {
/*  63 */     if (Checks.CHECKS) {
/*  64 */       Checks.check(m, 16);
/*     */     }
/*  66 */     nglMultTransposeMatrixfARB(MemoryUtil.memAddress(m));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixdARB(@NativeType("GLdouble const *") DoubleBuffer m) {
/*  76 */     if (Checks.CHECKS) {
/*  77 */       Checks.check(m, 16);
/*     */     }
/*  79 */     nglMultTransposeMatrixdARB(MemoryUtil.memAddress(m));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixfARB(@NativeType("GLfloat const *") float[] m) {
/*  84 */     long __functionAddress = (GL.getICD()).glLoadTransposeMatrixfARB;
/*  85 */     if (Checks.CHECKS) {
/*  86 */       Checks.check(__functionAddress);
/*  87 */       Checks.check(m, 16);
/*     */     } 
/*  89 */     JNI.callPV(m, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixdARB(@NativeType("GLdouble const *") double[] m) {
/*  94 */     long __functionAddress = (GL.getICD()).glLoadTransposeMatrixdARB;
/*  95 */     if (Checks.CHECKS) {
/*  96 */       Checks.check(__functionAddress);
/*  97 */       Checks.check(m, 16);
/*     */     } 
/*  99 */     JNI.callPV(m, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixfARB(@NativeType("GLfloat const *") float[] m) {
/* 104 */     long __functionAddress = (GL.getICD()).glMultTransposeMatrixfARB;
/* 105 */     if (Checks.CHECKS) {
/* 106 */       Checks.check(__functionAddress);
/* 107 */       Checks.check(m, 16);
/*     */     } 
/* 109 */     JNI.callPV(m, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixdARB(@NativeType("GLdouble const *") double[] m) {
/* 114 */     long __functionAddress = (GL.getICD()).glMultTransposeMatrixdARB;
/* 115 */     if (Checks.CHECKS) {
/* 116 */       Checks.check(__functionAddress);
/* 117 */       Checks.check(m, 16);
/*     */     } 
/* 119 */     JNI.callPV(m, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglLoadTransposeMatrixfARB(long paramLong);
/*     */   
/*     */   public static native void nglLoadTransposeMatrixdARB(long paramLong);
/*     */   
/*     */   public static native void nglMultTransposeMatrixfARB(long paramLong);
/*     */   
/*     */   public static native void nglMultTransposeMatrixdARB(long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTransposeMatrix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */