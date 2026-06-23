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
/*     */ public class NVGPUShader5
/*     */ {
/*     */   public static final int GL_INT64_NV = 5134;
/*     */   public static final int GL_UNSIGNED_INT64_NV = 5135;
/*     */   public static final int GL_INT8_NV = 36832;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_INT8_VEC2_NV = 36833;
/*     */   
/*     */   public static final int GL_INT8_VEC3_NV = 36834;
/*     */   
/*     */   public static final int GL_INT8_VEC4_NV = 36835;
/*     */   public static final int GL_INT16_NV = 36836;
/*     */   public static final int GL_INT16_VEC2_NV = 36837;
/*     */   public static final int GL_INT16_VEC3_NV = 36838;
/*     */   public static final int GL_INT16_VEC4_NV = 36839;
/*     */   public static final int GL_INT64_VEC2_NV = 36841;
/*     */   public static final int GL_INT64_VEC3_NV = 36842;
/*     */   public static final int GL_INT64_VEC4_NV = 36843;
/*     */   public static final int GL_UNSIGNED_INT8_NV = 36844;
/*     */   public static final int GL_UNSIGNED_INT8_VEC2_NV = 36845;
/*     */   public static final int GL_UNSIGNED_INT8_VEC3_NV = 36846;
/*     */   public static final int GL_UNSIGNED_INT8_VEC4_NV = 36847;
/*     */   public static final int GL_UNSIGNED_INT16_NV = 36848;
/*     */   public static final int GL_UNSIGNED_INT16_VEC2_NV = 36849;
/*     */   public static final int GL_UNSIGNED_INT16_VEC3_NV = 36850;
/*     */   public static final int GL_UNSIGNED_INT16_VEC4_NV = 36851;
/*     */   public static final int GL_UNSIGNED_INT64_VEC2_NV = 36853;
/*     */   public static final int GL_UNSIGNED_INT64_VEC3_NV = 36854;
/*     */   public static final int GL_UNSIGNED_INT64_VEC4_NV = 36855;
/*     */   public static final int GL_FLOAT16_NV = 36856;
/*     */   public static final int GL_FLOAT16_VEC2_NV = 36857;
/*     */   public static final int GL_FLOAT16_VEC3_NV = 36858;
/*     */   public static final int GL_FLOAT16_VEC4_NV = 36859;
/*     */   
/*     */   protected NVGPUShader5() {
/*  52 */     throw new UnsupportedOperationException();
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
/*     */   public static void glUniform1i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/*  82 */     nglUniform1i64vNV(location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/*  92 */     nglUniform2i64vNV(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 102 */     nglUniform3i64vNV(location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 112 */     nglUniform4i64vNV(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
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
/*     */   public static void glUniform1ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 142 */     nglUniform1ui64vNV(location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT *") LongBuffer value) {
/* 152 */     nglUniform2ui64vNV(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 162 */     nglUniform3ui64vNV(location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 172 */     nglUniform4ui64vNV(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT *") LongBuffer params) {
/* 182 */     if (Checks.CHECKS) {
/* 183 */       Checks.check(params, 1);
/*     */     }
/* 185 */     nglGetUniformi64vNV(program, location, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformi64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 191 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 193 */       LongBuffer params = stack.callocLong(1);
/* 194 */       nglGetUniformi64vNV(program, location, MemoryUtil.memAddress(params));
/* 195 */       return params.get(0);
/*     */     } finally {
/* 197 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformui64vNV(int program, int location, long params) {
/* 205 */     NVShaderBufferLoad.nglGetUniformui64vNV(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT *") LongBuffer params) {
/* 210 */     NVShaderBufferLoad.glGetUniformui64vNV(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformui64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 216 */     return NVShaderBufferLoad.glGetUniformui64NV(program, location);
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
/*     */   public static void glProgramUniform1i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 246 */     nglProgramUniform1i64vNV(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 256 */     nglProgramUniform2i64vNV(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 266 */     nglProgramUniform3i64vNV(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 276 */     nglProgramUniform4i64vNV(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
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
/*     */   public static void glProgramUniform1ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 306 */     nglProgramUniform1ui64vNV(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 316 */     nglProgramUniform2ui64vNV(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 326 */     nglProgramUniform3ui64vNV(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 336 */     nglProgramUniform4ui64vNV(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 341 */     long __functionAddress = (GL.getICD()).glUniform1i64vNV;
/* 342 */     if (Checks.CHECKS) {
/* 343 */       Checks.check(__functionAddress);
/*     */     }
/* 345 */     JNI.callPV(location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 350 */     long __functionAddress = (GL.getICD()).glUniform2i64vNV;
/* 351 */     if (Checks.CHECKS) {
/* 352 */       Checks.check(__functionAddress);
/*     */     }
/* 354 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 359 */     long __functionAddress = (GL.getICD()).glUniform3i64vNV;
/* 360 */     if (Checks.CHECKS) {
/* 361 */       Checks.check(__functionAddress);
/*     */     }
/* 363 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 368 */     long __functionAddress = (GL.getICD()).glUniform4i64vNV;
/* 369 */     if (Checks.CHECKS) {
/* 370 */       Checks.check(__functionAddress);
/*     */     }
/* 372 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 377 */     long __functionAddress = (GL.getICD()).glUniform1ui64vNV;
/* 378 */     if (Checks.CHECKS) {
/* 379 */       Checks.check(__functionAddress);
/*     */     }
/* 381 */     JNI.callPV(location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT *") long[] value) {
/* 386 */     long __functionAddress = (GL.getICD()).glUniform2ui64vNV;
/* 387 */     if (Checks.CHECKS) {
/* 388 */       Checks.check(__functionAddress);
/*     */     }
/* 390 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 395 */     long __functionAddress = (GL.getICD()).glUniform3ui64vNV;
/* 396 */     if (Checks.CHECKS) {
/* 397 */       Checks.check(__functionAddress);
/*     */     }
/* 399 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 404 */     long __functionAddress = (GL.getICD()).glUniform4ui64vNV;
/* 405 */     if (Checks.CHECKS) {
/* 406 */       Checks.check(__functionAddress);
/*     */     }
/* 408 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT *") long[] params) {
/* 413 */     long __functionAddress = (GL.getICD()).glGetUniformi64vNV;
/* 414 */     if (Checks.CHECKS) {
/* 415 */       Checks.check(__functionAddress);
/* 416 */       Checks.check(params, 1);
/*     */     } 
/* 418 */     JNI.callPV(program, location, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT *") long[] params) {
/* 423 */     NVShaderBufferLoad.glGetUniformui64vNV(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 428 */     long __functionAddress = (GL.getICD()).glProgramUniform1i64vNV;
/* 429 */     if (Checks.CHECKS) {
/* 430 */       Checks.check(__functionAddress);
/*     */     }
/* 432 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 437 */     long __functionAddress = (GL.getICD()).glProgramUniform2i64vNV;
/* 438 */     if (Checks.CHECKS) {
/* 439 */       Checks.check(__functionAddress);
/*     */     }
/* 441 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 446 */     long __functionAddress = (GL.getICD()).glProgramUniform3i64vNV;
/* 447 */     if (Checks.CHECKS) {
/* 448 */       Checks.check(__functionAddress);
/*     */     }
/* 450 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 455 */     long __functionAddress = (GL.getICD()).glProgramUniform4i64vNV;
/* 456 */     if (Checks.CHECKS) {
/* 457 */       Checks.check(__functionAddress);
/*     */     }
/* 459 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 464 */     long __functionAddress = (GL.getICD()).glProgramUniform1ui64vNV;
/* 465 */     if (Checks.CHECKS) {
/* 466 */       Checks.check(__functionAddress);
/*     */     }
/* 468 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 473 */     long __functionAddress = (GL.getICD()).glProgramUniform2ui64vNV;
/* 474 */     if (Checks.CHECKS) {
/* 475 */       Checks.check(__functionAddress);
/*     */     }
/* 477 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 482 */     long __functionAddress = (GL.getICD()).glProgramUniform3ui64vNV;
/* 483 */     if (Checks.CHECKS) {
/* 484 */       Checks.check(__functionAddress);
/*     */     }
/* 486 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 491 */     long __functionAddress = (GL.getICD()).glProgramUniform4ui64vNV;
/* 492 */     if (Checks.CHECKS) {
/* 493 */       Checks.check(__functionAddress);
/*     */     }
/* 495 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glUniform1i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong);
/*     */   
/*     */   public static native void glUniform2i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glUniform3i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glUniform4i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3, @NativeType("GLint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglUniform1i64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform2i64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform3i64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform4i64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glUniform1ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void glUniform2ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glUniform3ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glUniform4ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3, @NativeType("GLuint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglUniform1ui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform2ui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform3ui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform4ui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformi64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform1i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong);
/*     */   
/*     */   public static native void glProgramUniform2i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glProgramUniform3i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glProgramUniform4i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3, @NativeType("GLint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglProgramUniform1i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform2i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform3i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform4i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform1ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void glProgramUniform2ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glProgramUniform3ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glProgramUniform4ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3, @NativeType("GLuint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglProgramUniform1ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform2ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform3ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform4ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVGPUShader5.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */