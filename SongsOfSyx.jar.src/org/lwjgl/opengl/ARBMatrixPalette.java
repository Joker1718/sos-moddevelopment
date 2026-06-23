/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class ARBMatrixPalette
/*     */ {
/*     */   public static final int GL_MATRIX_PALETTE_ARB = 34880;
/*     */   public static final int GL_MAX_MATRIX_PALETTE_STACK_DEPTH_ARB = 34881;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_PALETTE_MATRICES_ARB = 34882;
/*     */   
/*     */   public static final int GL_CURRENT_PALETTE_MATRIX_ARB = 34883;
/*     */   
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_ARB = 34884;
/*     */   
/*     */   public static final int GL_CURRENT_MATRIX_INDEX_ARB = 34885;
/*     */   
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_SIZE_ARB = 34886;
/*     */   
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_TYPE_ARB = 34887;
/*     */   
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_ARB = 34888;
/*     */   
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_POINTER_ARB = 34889;
/*     */   
/*     */   protected ARBMatrixPalette() {
/*  39 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMatrixIndexuivARB(@NativeType("GLuint *") IntBuffer indices) {
/*  54 */     nglMatrixIndexuivARB(indices.remaining(), MemoryUtil.memAddress(indices));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexubvARB(@NativeType("GLubyte *") ByteBuffer indices) {
/*  64 */     nglMatrixIndexubvARB(indices.remaining(), MemoryUtil.memAddress(indices));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexusvARB(@NativeType("GLushort *") ShortBuffer indices) {
/*  74 */     nglMatrixIndexusvARB(indices.remaining(), MemoryUtil.memAddress(indices));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/*  84 */     nglMatrixIndexPointerARB(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/*  89 */     nglMatrixIndexPointerARB(size, type, stride, pointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int size, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/*  94 */     nglMatrixIndexPointerARB(size, 5121, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int size, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/*  99 */     nglMatrixIndexPointerARB(size, 5123, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int size, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 104 */     nglMatrixIndexPointerARB(size, 5125, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexuivARB(@NativeType("GLuint *") int[] indices) {
/* 109 */     long __functionAddress = (GL.getICD()).glMatrixIndexuivARB;
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(__functionAddress);
/*     */     }
/* 113 */     JNI.callPV(indices.length, indices, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexusvARB(@NativeType("GLushort *") short[] indices) {
/* 118 */     long __functionAddress = (GL.getICD()).glMatrixIndexusvARB;
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.check(__functionAddress);
/*     */     }
/* 122 */     JNI.callPV(indices.length, indices, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glCurrentPaletteMatrixARB(@NativeType("GLint") int paramInt);
/*     */   
/*     */   public static native void nglMatrixIndexuivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMatrixIndexubvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMatrixIndexusvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMatrixIndexPointerARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBMatrixPalette.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */