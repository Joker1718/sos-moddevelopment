/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL46C
/*     */   extends GL45C
/*     */ {
/*     */   public static final int GL_PARAMETER_BUFFER = 33006;
/*     */   public static final int GL_PARAMETER_BUFFER_BINDING = 33007;
/*     */   public static final int GL_VERTICES_SUBMITTED = 33518;
/*     */   public static final int GL_PRIMITIVES_SUBMITTED = 33519;
/*     */   public static final int GL_VERTEX_SHADER_INVOCATIONS = 33520;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_TESS_CONTROL_SHADER_PATCHES = 33521;
/*     */   
/*     */   public static final int GL_TESS_EVALUATION_SHADER_INVOCATIONS = 33522;
/*     */   
/*     */   public static final int GL_GEOMETRY_SHADER_PRIMITIVES_EMITTED = 33523;
/*     */   
/*     */   public static final int GL_FRAGMENT_SHADER_INVOCATIONS = 33524;
/*     */   
/*     */   public static final int GL_COMPUTE_SHADER_INVOCATIONS = 33525;
/*     */   
/*     */   public static final int GL_CLIPPING_INPUT_PRIMITIVES = 33526;
/*     */   
/*     */   public static final int GL_CLIPPING_OUTPUT_PRIMITIVES = 33527;
/*     */   
/*     */   public static final int GL_POLYGON_OFFSET_CLAMP = 36379;
/*     */   
/*     */   public static final int GL_CONTEXT_FLAG_NO_ERROR_BIT = 8;
/*     */   
/*     */   public static final int GL_SHADER_BINARY_FORMAT_SPIR_V = 38225;
/*     */   
/*     */   public static final int GL_SPIR_V_BINARY = 38226;
/*     */   
/*     */   public static final int GL_SPIR_V_EXTENSIONS = 38227;
/*     */   
/*     */   public static final int GL_NUM_SPIR_V_EXTENSIONS = 38228;
/*     */   
/*     */   public static final int GL_TEXTURE_MAX_ANISOTROPY = 34046;
/*     */   
/*     */   public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY = 34047;
/*     */   
/*     */   public static final int GL_TRANSFORM_FEEDBACK_OVERFLOW = 33516;
/*     */   
/*     */   public static final int GL_TRANSFORM_FEEDBACK_STREAM_OVERFLOW = 33517;
/*     */   
/*     */   protected GL46C() {
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/*  70 */     if (Checks.CHECKS) {
/*  71 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 16 : stride));
/*     */     }
/*  73 */     nglMultiDrawArraysIndirectCount(mode, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/*  78 */     nglMultiDrawArraysIndirectCount(mode, indirect, drawcount, maxdrawcount, stride);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/*  83 */     if (Checks.CHECKS) {
/*  84 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 16 : stride) >> 2);
/*     */     }
/*  86 */     nglMultiDrawArraysIndirectCount(mode, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/*  96 */     if (Checks.CHECKS) {
/*  97 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 20 : stride));
/*     */     }
/*  99 */     nglMultiDrawElementsIndirectCount(mode, type, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 104 */     nglMultiDrawElementsIndirectCount(mode, type, indirect, drawcount, maxdrawcount, stride);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 109 */     if (Checks.CHECKS) {
/* 110 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 20 : stride) >> 2);
/*     */     }
/* 112 */     nglMultiDrawElementsIndirectCount(mode, type, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
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
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int shader, @NativeType("GLchar const *") ByteBuffer pEntryPoint, @NativeType("GLuint const *") IntBuffer pConstantIndex, @NativeType("GLuint const *") IntBuffer pConstantValue) {
/* 127 */     if (Checks.CHECKS) {
/* 128 */       Checks.checkNT1(pEntryPoint);
/* 129 */       Checks.checkSafe(pConstantValue, Checks.remainingSafe(pConstantIndex));
/*     */     } 
/* 131 */     nglSpecializeShader(shader, MemoryUtil.memAddress(pEntryPoint), Checks.remainingSafe(pConstantIndex), MemoryUtil.memAddressSafe(pConstantIndex), MemoryUtil.memAddressSafe(pConstantValue));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int shader, @NativeType("GLchar const *") CharSequence pEntryPoint, @NativeType("GLuint const *") IntBuffer pConstantIndex, @NativeType("GLuint const *") IntBuffer pConstantValue) {
/* 136 */     if (Checks.CHECKS) {
/* 137 */       Checks.checkSafe(pConstantValue, Checks.remainingSafe(pConstantIndex));
/*     */     }
/* 139 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 141 */       stack.nUTF8(pEntryPoint, true);
/* 142 */       long pEntryPointEncoded = stack.getPointerAddress();
/* 143 */       nglSpecializeShader(shader, pEntryPointEncoded, Checks.remainingSafe(pConstantIndex), MemoryUtil.memAddressSafe(pConstantIndex), MemoryUtil.memAddressSafe(pConstantValue));
/*     */     } finally {
/* 145 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int mode, @NativeType("void const *") int[] indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 151 */     long __functionAddress = (GL.getICD()).glMultiDrawArraysIndirectCount;
/* 152 */     if (Checks.CHECKS) {
/* 153 */       Checks.check(__functionAddress);
/* 154 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 16 : stride) >> 2);
/*     */     } 
/* 156 */     JNI.callPPV(mode, indirect, drawcount, maxdrawcount, stride, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") int[] indirect, @NativeType("GLintptr") long drawcount, @NativeType("GLsizei") int maxdrawcount, @NativeType("GLsizei") int stride) {
/* 161 */     long __functionAddress = (GL.getICD()).glMultiDrawElementsIndirectCount;
/* 162 */     if (Checks.CHECKS) {
/* 163 */       Checks.check(__functionAddress);
/* 164 */       Checks.check(indirect, maxdrawcount * ((stride == 0) ? 20 : stride) >> 2);
/*     */     } 
/* 166 */     JNI.callPPV(mode, type, indirect, drawcount, maxdrawcount, stride, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int shader, @NativeType("GLchar const *") ByteBuffer pEntryPoint, @NativeType("GLuint const *") int[] pConstantIndex, @NativeType("GLuint const *") int[] pConstantValue) {
/* 171 */     long __functionAddress = (GL.getICD()).glSpecializeShader;
/* 172 */     if (Checks.CHECKS) {
/* 173 */       Checks.check(__functionAddress);
/* 174 */       Checks.checkNT1(pEntryPoint);
/* 175 */       Checks.checkSafe(pConstantValue, Checks.lengthSafe(pConstantIndex));
/*     */     } 
/* 177 */     JNI.callPPPV(shader, MemoryUtil.memAddress(pEntryPoint), Checks.lengthSafe(pConstantIndex), pConstantIndex, pConstantValue, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int shader, @NativeType("GLchar const *") CharSequence pEntryPoint, @NativeType("GLuint const *") int[] pConstantIndex, @NativeType("GLuint const *") int[] pConstantValue) {
/* 182 */     long __functionAddress = (GL.getICD()).glSpecializeShader;
/* 183 */     if (Checks.CHECKS) {
/* 184 */       Checks.check(__functionAddress);
/* 185 */       Checks.checkSafe(pConstantValue, Checks.lengthSafe(pConstantIndex));
/*     */     } 
/* 187 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 189 */       stack.nUTF8(pEntryPoint, true);
/* 190 */       long pEntryPointEncoded = stack.getPointerAddress();
/* 191 */       JNI.callPPPV(shader, pEntryPointEncoded, Checks.lengthSafe(pConstantIndex), pConstantIndex, pConstantValue, __functionAddress);
/*     */     } finally {
/* 193 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static native void nglMultiDrawArraysIndirectCount(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3);
/*     */   
/*     */   public static native void nglMultiDrawElementsIndirectCount(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4);
/*     */   
/*     */   public static native void glPolygonOffsetClamp(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void nglSpecializeShader(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL46C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */