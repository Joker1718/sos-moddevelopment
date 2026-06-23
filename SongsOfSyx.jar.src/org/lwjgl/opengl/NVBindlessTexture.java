/*     */ package org.lwjgl.opengl;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ public class NVBindlessTexture
/*     */ {
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */   protected NVBindlessTexture() {
/*  21 */     throw new UnsupportedOperationException();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformHandleui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer values) {
/*  74 */     nglUniformHandleui64vNV(location, values.remaining(), MemoryUtil.memAddress(values));
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
/*     */   public static void glProgramUniformHandleui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer values) {
/*  89 */     nglProgramUniformHandleui64vNV(program, location, values.remaining(), MemoryUtil.memAddress(values));
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
/*     */   public static void glUniformHandleui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] values) {
/* 106 */     long __functionAddress = (GL.getICD()).glUniformHandleui64vNV;
/* 107 */     if (Checks.CHECKS) {
/* 108 */       Checks.check(__functionAddress);
/*     */     }
/* 110 */     JNI.callPV(location, values.length, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformHandleui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] values) {
/* 115 */     long __functionAddress = (GL.getICD()).glProgramUniformHandleui64vNV;
/* 116 */     if (Checks.CHECKS) {
/* 117 */       Checks.check(__functionAddress);
/*     */     }
/* 119 */     JNI.callPV(program, location, values.length, values, __functionAddress);
/*     */   }
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetTextureHandleNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetTextureSamplerHandleNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glMakeTextureHandleResidentNV(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glMakeTextureHandleNonResidentNV(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetImageHandleNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4);
/*     */   
/*     */   public static native void glMakeImageHandleResidentNV(@NativeType("GLuint64") long paramLong, @NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glMakeImageHandleNonResidentNV(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glUniformHandleui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglUniformHandleui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniformHandleui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformHandleui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsTextureHandleResidentNV(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsImageHandleResidentNV(@NativeType("GLuint64") long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVBindlessTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */