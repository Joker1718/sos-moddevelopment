/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL21C
/*     */   extends GL20C
/*     */ {
/*     */   public static final int GL_FLOAT_MAT2x3 = 35685;
/*     */   public static final int GL_FLOAT_MAT2x4 = 35686;
/*     */   public static final int GL_FLOAT_MAT3x2 = 35687;
/*     */   public static final int GL_FLOAT_MAT3x4 = 35688;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_FLOAT_MAT4x2 = 35689;
/*     */   
/*     */   public static final int GL_FLOAT_MAT4x3 = 35690;
/*     */   
/*     */   public static final int GL_PIXEL_PACK_BUFFER = 35051;
/*     */   
/*     */   public static final int GL_PIXEL_UNPACK_BUFFER = 35052;
/*     */   
/*     */   public static final int GL_PIXEL_PACK_BUFFER_BINDING = 35053;
/*     */   
/*     */   public static final int GL_PIXEL_UNPACK_BUFFER_BINDING = 35055;
/*     */   
/*     */   public static final int GL_SRGB = 35904;
/*     */   
/*     */   public static final int GL_SRGB8 = 35905;
/*     */   
/*     */   public static final int GL_SRGB_ALPHA = 35906;
/*     */   
/*     */   public static final int GL_SRGB8_ALPHA8 = 35907;
/*     */   public static final int GL_COMPRESSED_SRGB = 35912;
/*     */   public static final int GL_COMPRESSED_SRGB_ALPHA = 35913;
/*     */   
/*     */   protected GL21C() {
/*  45 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  55 */     nglUniformMatrix2x3fv(location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  65 */     nglUniformMatrix3x2fv(location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  75 */     nglUniformMatrix2x4fv(location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  85 */     nglUniformMatrix4x2fv(location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  95 */     nglUniformMatrix3x4fv(location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 105 */     nglUniformMatrix4x3fv(location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 110 */     long __functionAddress = (GL.getICD()).glUniformMatrix2x3fv;
/* 111 */     if (Checks.CHECKS) {
/* 112 */       Checks.check(__functionAddress);
/*     */     }
/* 114 */     JNI.callPV(location, value.length / 6, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 119 */     long __functionAddress = (GL.getICD()).glUniformMatrix3x2fv;
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(__functionAddress);
/*     */     }
/* 123 */     JNI.callPV(location, value.length / 6, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 128 */     long __functionAddress = (GL.getICD()).glUniformMatrix2x4fv;
/* 129 */     if (Checks.CHECKS) {
/* 130 */       Checks.check(__functionAddress);
/*     */     }
/* 132 */     JNI.callPV(location, value.length >> 3, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 137 */     long __functionAddress = (GL.getICD()).glUniformMatrix4x2fv;
/* 138 */     if (Checks.CHECKS) {
/* 139 */       Checks.check(__functionAddress);
/*     */     }
/* 141 */     JNI.callPV(location, value.length >> 3, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 146 */     long __functionAddress = (GL.getICD()).glUniformMatrix3x4fv;
/* 147 */     if (Checks.CHECKS) {
/* 148 */       Checks.check(__functionAddress);
/*     */     }
/* 150 */     JNI.callPV(location, value.length / 12, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 155 */     long __functionAddress = (GL.getICD()).glUniformMatrix4x3fv;
/* 156 */     if (Checks.CHECKS) {
/* 157 */       Checks.check(__functionAddress);
/*     */     }
/* 159 */     JNI.callPV(location, value.length / 12, transpose, value, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglUniformMatrix2x3fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix3x2fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix2x4fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix4x2fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix3x4fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix4x3fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL21C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */