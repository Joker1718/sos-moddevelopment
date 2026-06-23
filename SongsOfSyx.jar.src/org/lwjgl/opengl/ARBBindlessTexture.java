/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBBindlessTexture
/*     */ {
/*     */   public static final int GL_UNSIGNED_INT64_ARB = 5135;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   protected ARBBindlessTexture() {
/*  24 */     throw new UnsupportedOperationException();
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
/*     */   public static void glUniformHandleui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer values) {
/*  77 */     nglUniformHandleui64vARB(location, values.remaining(), MemoryUtil.memAddress(values));
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
/*     */   public static void glProgramUniformHandleui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer values) {
/*  92 */     nglProgramUniformHandleui64vARB(program, location, values.remaining(), MemoryUtil.memAddress(values));
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
/*     */   public static void glVertexAttribL1ui64vARB(@NativeType("GLuint") int index, @NativeType("GLuint64 const *") LongBuffer v) {
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.check(v, 1);
/*     */     }
/* 122 */     nglVertexAttribL1ui64vARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLui64vARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") LongBuffer params) {
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check(params, 1);
/*     */     }
/* 135 */     nglGetVertexAttribLui64vARB(index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetVertexAttribLui64ARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 141 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 143 */       LongBuffer params = stack.callocLong(1);
/* 144 */       nglGetVertexAttribLui64vARB(index, pname, MemoryUtil.memAddress(params));
/* 145 */       return params.get(0);
/*     */     } finally {
/* 147 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformHandleui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] values) {
/* 153 */     long __functionAddress = (GL.getICD()).glUniformHandleui64vARB;
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(__functionAddress);
/*     */     }
/* 157 */     JNI.callPV(location, values.length, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformHandleui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] values) {
/* 162 */     long __functionAddress = (GL.getICD()).glProgramUniformHandleui64vARB;
/* 163 */     if (Checks.CHECKS) {
/* 164 */       Checks.check(__functionAddress);
/*     */     }
/* 166 */     JNI.callPV(program, location, values.length, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL1ui64vARB(@NativeType("GLuint") int index, @NativeType("GLuint64 const *") long[] v) {
/* 171 */     long __functionAddress = (GL.getICD()).glVertexAttribL1ui64vARB;
/* 172 */     if (Checks.CHECKS) {
/* 173 */       Checks.check(__functionAddress);
/* 174 */       Checks.check(v, 1);
/*     */     } 
/* 176 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLui64vARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long[] params) {
/* 181 */     long __functionAddress = (GL.getICD()).glGetVertexAttribLui64vARB;
/* 182 */     if (Checks.CHECKS) {
/* 183 */       Checks.check(__functionAddress);
/* 184 */       Checks.check(params, 1);
/*     */     } 
/* 186 */     JNI.callPV(index, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetTextureHandleARB(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetTextureSamplerHandleARB(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glMakeTextureHandleResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glMakeTextureHandleNonResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetImageHandleARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4);
/*     */   
/*     */   public static native void glMakeImageHandleResidentARB(@NativeType("GLuint64") long paramLong, @NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glMakeImageHandleNonResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glUniformHandleui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglUniformHandleui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniformHandleui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformHandleui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsTextureHandleResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsImageHandleResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glVertexAttribL1ui64ARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL1ui64vARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribLui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBBindlessTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */