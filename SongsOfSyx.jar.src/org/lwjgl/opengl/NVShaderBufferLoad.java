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
/*     */ public class NVShaderBufferLoad
/*     */ {
/*     */   public static final int GL_BUFFER_GPU_ADDRESS_NV = 36637;
/*     */   public static final int GL_GPU_ADDRESS_NV = 36660;
/*     */   public static final int GL_MAX_SHADER_BUFFER_ADDRESS_NV = 36661;
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
/*     */   protected NVShaderBufferLoad() {
/*  28 */     throw new UnsupportedOperationException();
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
/*     */   public static void glGetBufferParameterui64vNV(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint64EXT *") LongBuffer params) {
/*  70 */     if (Checks.CHECKS) {
/*  71 */       Checks.check(params, 1);
/*     */     }
/*  73 */     nglGetBufferParameterui64vNV(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetBufferParameterui64NV(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  79 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  81 */       LongBuffer params = stack.callocLong(1);
/*  82 */       nglGetBufferParameterui64vNV(target, pname, MemoryUtil.memAddress(params));
/*  83 */       return params.get(0);
/*     */     } finally {
/*  85 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetNamedBufferParameterui64vNV(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLuint64EXT *") LongBuffer params) {
/*  96 */     if (Checks.CHECKS) {
/*  97 */       Checks.check(params, 1);
/*     */     }
/*  99 */     nglGetNamedBufferParameterui64vNV(buffer, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetNamedBufferParameterui64NV(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/* 105 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 107 */       LongBuffer params = stack.callocLong(1);
/* 108 */       nglGetNamedBufferParameterui64vNV(buffer, pname, MemoryUtil.memAddress(params));
/* 109 */       return params.get(0);
/*     */     } finally {
/* 111 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetIntegerui64vNV(@NativeType("GLenum") int value, @NativeType("GLuint64EXT *") LongBuffer result) {
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.check(result, 1);
/*     */     }
/* 125 */     nglGetIntegerui64vNV(value, MemoryUtil.memAddress(result));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetIntegerui64NV(@NativeType("GLenum") int value) {
/* 131 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 133 */       LongBuffer result = stack.callocLong(1);
/* 134 */       nglGetIntegerui64vNV(value, MemoryUtil.memAddress(result));
/* 135 */       return result.get(0);
/*     */     } finally {
/* 137 */       stack.setPointer(stackPointer);
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
/*     */   public static void glUniformui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 153 */     nglUniformui64vNV(location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT *") LongBuffer params) {
/* 163 */     if (Checks.CHECKS) {
/* 164 */       Checks.check(params, 1);
/*     */     }
/* 166 */     nglGetUniformui64vNV(program, location, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformui64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 172 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 174 */       LongBuffer params = stack.callocLong(1);
/* 175 */       nglGetUniformui64vNV(program, location, MemoryUtil.memAddress(params));
/* 176 */       return params.get(0);
/*     */     } finally {
/* 178 */       stack.setPointer(stackPointer);
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
/*     */   public static void glProgramUniformui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 194 */     nglProgramUniformui64vNV(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameterui64vNV(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint64EXT *") long[] params) {
/* 199 */     long __functionAddress = (GL.getICD()).glGetBufferParameterui64vNV;
/* 200 */     if (Checks.CHECKS) {
/* 201 */       Checks.check(__functionAddress);
/* 202 */       Checks.check(params, 1);
/*     */     } 
/* 204 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedBufferParameterui64vNV(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLuint64EXT *") long[] params) {
/* 209 */     long __functionAddress = (GL.getICD()).glGetNamedBufferParameterui64vNV;
/* 210 */     if (Checks.CHECKS) {
/* 211 */       Checks.check(__functionAddress);
/* 212 */       Checks.check(params, 1);
/*     */     } 
/* 214 */     JNI.callPV(buffer, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetIntegerui64vNV(@NativeType("GLenum") int value, @NativeType("GLuint64EXT *") long[] result) {
/* 219 */     long __functionAddress = (GL.getICD()).glGetIntegerui64vNV;
/* 220 */     if (Checks.CHECKS) {
/* 221 */       Checks.check(__functionAddress);
/* 222 */       Checks.check(result, 1);
/*     */     } 
/* 224 */     JNI.callPV(value, result, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 229 */     long __functionAddress = (GL.getICD()).glUniformui64vNV;
/* 230 */     if (Checks.CHECKS) {
/* 231 */       Checks.check(__functionAddress);
/*     */     }
/* 233 */     JNI.callPV(location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT *") long[] params) {
/* 238 */     long __functionAddress = (GL.getICD()).glGetUniformui64vNV;
/* 239 */     if (Checks.CHECKS) {
/* 240 */       Checks.check(__functionAddress);
/* 241 */       Checks.check(params, 1);
/*     */     } 
/* 243 */     JNI.callPV(program, location, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 248 */     long __functionAddress = (GL.getICD()).glProgramUniformui64vNV;
/* 249 */     if (Checks.CHECKS) {
/* 250 */       Checks.check(__functionAddress);
/*     */     }
/* 252 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glMakeBufferResidentNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */   
/*     */   public static native void glMakeBufferNonResidentNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsBufferResidentNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glMakeNamedBufferResidentNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */   
/*     */   public static native void glMakeNamedBufferNonResidentNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsNamedBufferResidentNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglGetBufferParameterui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetNamedBufferParameterui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetIntegerui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glUniformui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void nglUniformui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniformui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVShaderBufferLoad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */