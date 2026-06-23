/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBGPUShaderFP64 {
/*     */   public static final int GL_DOUBLE_VEC2 = 36860;
/*     */   public static final int GL_DOUBLE_VEC3 = 36861;
/*     */   public static final int GL_DOUBLE_VEC4 = 36862;
/*     */   public static final int GL_DOUBLE_MAT2 = 36678;
/*     */   public static final int GL_DOUBLE_MAT3 = 36679;
/*     */   public static final int GL_DOUBLE_MAT4 = 36680;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_DOUBLE_MAT2x3 = 36681;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT2x4 = 36682;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT3x2 = 36683;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT3x4 = 36684;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT4x2 = 36685;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT4x3 = 36686;
/*     */   
/*     */   protected ARBGPUShaderFP64() {
/*  35 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform1d(@NativeType("GLint") int location, @NativeType("GLdouble") double x) {
/*  42 */     GL40C.glUniform1d(location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2d(@NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y) {
/*  49 */     GL40C.glUniform2d(location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3d(@NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z) {
/*  56 */     GL40C.glUniform3d(location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4d(@NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z, @NativeType("GLdouble") double w) {
/*  63 */     GL40C.glUniform4d(location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform1dv(int location, int count, long value) {
/*  70 */     GL40C.nglUniform1dv(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  75 */     GL40C.glUniform1dv(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform2dv(int location, int count, long value) {
/*  82 */     GL40C.nglUniform2dv(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  87 */     GL40C.glUniform2dv(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform3dv(int location, int count, long value) {
/*  94 */     GL40C.nglUniform3dv(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  99 */     GL40C.glUniform3dv(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform4dv(int location, int count, long value) {
/* 106 */     GL40C.nglUniform4dv(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 111 */     GL40C.glUniform4dv(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2dv(int location, int count, boolean transpose, long value) {
/* 118 */     GL40C.nglUniformMatrix2dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 123 */     GL40C.glUniformMatrix2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3dv(int location, int count, boolean transpose, long value) {
/* 130 */     GL40C.nglUniformMatrix3dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 135 */     GL40C.glUniformMatrix3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4dv(int location, int count, boolean transpose, long value) {
/* 142 */     GL40C.nglUniformMatrix4dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 147 */     GL40C.glUniformMatrix4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2x3dv(int location, int count, boolean transpose, long value) {
/* 154 */     GL40C.nglUniformMatrix2x3dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 159 */     GL40C.glUniformMatrix2x3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2x4dv(int location, int count, boolean transpose, long value) {
/* 166 */     GL40C.nglUniformMatrix2x4dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 171 */     GL40C.glUniformMatrix2x4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3x2dv(int location, int count, boolean transpose, long value) {
/* 178 */     GL40C.nglUniformMatrix3x2dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 183 */     GL40C.glUniformMatrix3x2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3x4dv(int location, int count, boolean transpose, long value) {
/* 190 */     GL40C.nglUniformMatrix3x4dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 195 */     GL40C.glUniformMatrix3x4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4x2dv(int location, int count, boolean transpose, long value) {
/* 202 */     GL40C.nglUniformMatrix4x2dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 207 */     GL40C.glUniformMatrix4x2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4x3dv(int location, int count, boolean transpose, long value) {
/* 214 */     GL40C.nglUniformMatrix4x3dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 219 */     GL40C.glUniformMatrix4x3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformdv(int program, int location, long params) {
/* 226 */     GL40C.nglGetUniformdv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") DoubleBuffer params) {
/* 231 */     GL40C.glGetUniformdv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static double glGetUniformd(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 237 */     return GL40C.glGetUniformd(program, location);
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
/*     */   public static void glProgramUniform1dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 267 */     nglProgramUniform1dvEXT(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 277 */     nglProgramUniform2dvEXT(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 287 */     nglProgramUniform3dvEXT(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 297 */     nglProgramUniform4dvEXT(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 307 */     nglProgramUniformMatrix2dvEXT(program, location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 317 */     nglProgramUniformMatrix3dvEXT(program, location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 327 */     nglProgramUniformMatrix4dvEXT(program, location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x3dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 337 */     nglProgramUniformMatrix2x3dvEXT(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x4dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 347 */     nglProgramUniformMatrix2x4dvEXT(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x2dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 357 */     nglProgramUniformMatrix3x2dvEXT(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x4dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 367 */     nglProgramUniformMatrix3x4dvEXT(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x2dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 377 */     nglProgramUniformMatrix4x2dvEXT(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x3dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 387 */     nglProgramUniformMatrix4x3dvEXT(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 392 */     GL40C.glUniform1dv(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 397 */     GL40C.glUniform2dv(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 402 */     GL40C.glUniform3dv(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 407 */     GL40C.glUniform4dv(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 412 */     GL40C.glUniformMatrix2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 417 */     GL40C.glUniformMatrix3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 422 */     GL40C.glUniformMatrix4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 427 */     GL40C.glUniformMatrix2x3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 432 */     GL40C.glUniformMatrix2x4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 437 */     GL40C.glUniformMatrix3x2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 442 */     GL40C.glUniformMatrix3x4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 447 */     GL40C.glUniformMatrix4x2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 452 */     GL40C.glUniformMatrix4x3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") double[] params) {
/* 457 */     GL40C.glGetUniformdv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 462 */     long __functionAddress = (GL.getICD()).glProgramUniform1dvEXT;
/* 463 */     if (Checks.CHECKS) {
/* 464 */       Checks.check(__functionAddress);
/*     */     }
/* 466 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 471 */     long __functionAddress = (GL.getICD()).glProgramUniform2dvEXT;
/* 472 */     if (Checks.CHECKS) {
/* 473 */       Checks.check(__functionAddress);
/*     */     }
/* 475 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 480 */     long __functionAddress = (GL.getICD()).glProgramUniform3dvEXT;
/* 481 */     if (Checks.CHECKS) {
/* 482 */       Checks.check(__functionAddress);
/*     */     }
/* 484 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 489 */     long __functionAddress = (GL.getICD()).glProgramUniform4dvEXT;
/* 490 */     if (Checks.CHECKS) {
/* 491 */       Checks.check(__functionAddress);
/*     */     }
/* 493 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 498 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2dvEXT;
/* 499 */     if (Checks.CHECKS) {
/* 500 */       Checks.check(__functionAddress);
/*     */     }
/* 502 */     JNI.callPV(program, location, value.length >> 2, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 507 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3dvEXT;
/* 508 */     if (Checks.CHECKS) {
/* 509 */       Checks.check(__functionAddress);
/*     */     }
/* 511 */     JNI.callPV(program, location, value.length / 9, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 516 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4dvEXT;
/* 517 */     if (Checks.CHECKS) {
/* 518 */       Checks.check(__functionAddress);
/*     */     }
/* 520 */     JNI.callPV(program, location, value.length >> 4, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x3dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 525 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2x3dvEXT;
/* 526 */     if (Checks.CHECKS) {
/* 527 */       Checks.check(__functionAddress);
/*     */     }
/* 529 */     JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x4dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 534 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2x4dvEXT;
/* 535 */     if (Checks.CHECKS) {
/* 536 */       Checks.check(__functionAddress);
/*     */     }
/* 538 */     JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x2dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 543 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3x2dvEXT;
/* 544 */     if (Checks.CHECKS) {
/* 545 */       Checks.check(__functionAddress);
/*     */     }
/* 547 */     JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x4dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 552 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3x4dvEXT;
/* 553 */     if (Checks.CHECKS) {
/* 554 */       Checks.check(__functionAddress);
/*     */     }
/* 556 */     JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x2dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 561 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4x2dvEXT;
/* 562 */     if (Checks.CHECKS) {
/* 563 */       Checks.check(__functionAddress);
/*     */     }
/* 565 */     JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x3dvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 570 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4x3dvEXT;
/* 571 */     if (Checks.CHECKS) {
/* 572 */       Checks.check(__functionAddress);
/*     */     }
/* 574 */     JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glProgramUniform1dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void glProgramUniform2dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void glProgramUniform3dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void glProgramUniform4dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*     */   
/*     */   public static native void nglProgramUniform1dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform2dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform3dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform4dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix2dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix3dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix4dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix2x3dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix2x4dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix3x2dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix3x4dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix4x2dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix4x3dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBGPUShaderFP64.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */