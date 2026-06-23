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
/*     */ public class ARBGPUShaderInt64
/*     */ {
/*     */   public static final int GL_INT64_ARB = 5134;
/*     */   public static final int GL_UNSIGNED_INT64_ARB = 5135;
/*     */   public static final int GL_INT64_VEC2_ARB = 36841;
/*     */   public static final int GL_INT64_VEC3_ARB = 36842;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_INT64_VEC4_ARB = 36843;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT64_VEC2_ARB = 36853;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT64_VEC3_ARB = 36854;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT64_VEC4_ARB = 36855;
/*     */   
/*     */   protected ARBGPUShaderInt64() {
/*  32 */     throw new UnsupportedOperationException();
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
/*     */   public static void glUniform1i64vARB(@NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer value) {
/*  47 */     nglUniform1i64vARB(location, value.remaining(), MemoryUtil.memAddress(value));
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
/*     */   public static void glProgramUniform1i64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer value) {
/*  62 */     nglProgramUniform1i64vARB(program, location, value.remaining(), MemoryUtil.memAddress(value));
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
/*     */   public static void glUniform2i64vARB(@NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer value) {
/*  77 */     nglUniform2i64vARB(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
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
/*     */   public static void glProgramUniform2i64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer value) {
/*  92 */     nglProgramUniform2i64vARB(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
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
/*     */   public static void glUniform3i64vARB(@NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer value) {
/* 107 */     nglUniform3i64vARB(location, value.remaining() / 3, MemoryUtil.memAddress(value));
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
/*     */   public static void glProgramUniform3i64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer value) {
/* 122 */     nglProgramUniform3i64vARB(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
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
/*     */   public static void glUniform4i64vARB(@NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer value) {
/* 137 */     nglUniform4i64vARB(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
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
/*     */   public static void glProgramUniform4i64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer value) {
/* 152 */     nglProgramUniform4i64vARB(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
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
/*     */   public static void glUniform1ui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer value) {
/* 167 */     nglUniform1ui64vARB(location, value.remaining(), MemoryUtil.memAddress(value));
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
/*     */   public static void glProgramUniform1ui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer value) {
/* 182 */     nglProgramUniform1ui64vARB(program, location, value.remaining(), MemoryUtil.memAddress(value));
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
/*     */   public static void glUniform2ui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer value) {
/* 197 */     nglUniform2ui64vARB(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
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
/*     */   public static void glProgramUniform2ui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer value) {
/* 212 */     nglProgramUniform2ui64vARB(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
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
/*     */   public static void glUniform3ui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer value) {
/* 227 */     nglUniform3ui64vARB(location, value.remaining() / 3, MemoryUtil.memAddress(value));
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
/*     */   public static void glProgramUniform3ui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer value) {
/* 242 */     nglProgramUniform3ui64vARB(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
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
/*     */   public static void glUniform4ui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer value) {
/* 257 */     nglUniform4ui64vARB(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
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
/*     */   public static void glProgramUniform4ui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") LongBuffer value) {
/* 272 */     nglProgramUniform4ui64vARB(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer params) {
/* 282 */     if (Checks.CHECKS) {
/* 283 */       Checks.check(params, 1);
/*     */     }
/* 285 */     nglGetUniformi64vARB(program, location, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformi64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 291 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 293 */       LongBuffer params = stack.callocLong(1);
/* 294 */       nglGetUniformi64vARB(program, location, MemoryUtil.memAddress(params));
/* 295 */       return params.get(0);
/*     */     } finally {
/* 297 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 *") LongBuffer params) {
/* 308 */     if (Checks.CHECKS) {
/* 309 */       Checks.check(params, 1);
/*     */     }
/* 311 */     nglGetUniformui64vARB(program, location, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 317 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 319 */       LongBuffer params = stack.callocLong(1);
/* 320 */       nglGetUniformui64vARB(program, location, MemoryUtil.memAddress(params));
/* 321 */       return params.get(0);
/*     */     } finally {
/* 323 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnUniformi64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") LongBuffer params) {
/* 334 */     nglGetnUniformi64vARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetnUniformi64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 340 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 342 */       LongBuffer params = stack.callocLong(1);
/* 343 */       nglGetnUniformi64vARB(program, location, 1, MemoryUtil.memAddress(params));
/* 344 */       return params.get(0);
/*     */     } finally {
/* 346 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnUniformui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 *") LongBuffer params) {
/* 357 */     nglGetnUniformui64vARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetnUniformui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 363 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 365 */       LongBuffer params = stack.callocLong(1);
/* 366 */       nglGetnUniformui64vARB(program, location, 1, MemoryUtil.memAddress(params));
/* 367 */       return params.get(0);
/*     */     } finally {
/* 369 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1i64vARB(@NativeType("GLint") int location, @NativeType("GLint64 *") long[] value) {
/* 375 */     long __functionAddress = (GL.getICD()).glUniform1i64vARB;
/* 376 */     if (Checks.CHECKS) {
/* 377 */       Checks.check(__functionAddress);
/*     */     }
/* 379 */     JNI.callPV(location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") long[] value) {
/* 384 */     long __functionAddress = (GL.getICD()).glProgramUniform1i64vARB;
/* 385 */     if (Checks.CHECKS) {
/* 386 */       Checks.check(__functionAddress);
/*     */     }
/* 388 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2i64vARB(@NativeType("GLint") int location, @NativeType("GLint64 *") long[] value) {
/* 393 */     long __functionAddress = (GL.getICD()).glUniform2i64vARB;
/* 394 */     if (Checks.CHECKS) {
/* 395 */       Checks.check(__functionAddress);
/*     */     }
/* 397 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") long[] value) {
/* 402 */     long __functionAddress = (GL.getICD()).glProgramUniform2i64vARB;
/* 403 */     if (Checks.CHECKS) {
/* 404 */       Checks.check(__functionAddress);
/*     */     }
/* 406 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3i64vARB(@NativeType("GLint") int location, @NativeType("GLint64 *") long[] value) {
/* 411 */     long __functionAddress = (GL.getICD()).glUniform3i64vARB;
/* 412 */     if (Checks.CHECKS) {
/* 413 */       Checks.check(__functionAddress);
/*     */     }
/* 415 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") long[] value) {
/* 420 */     long __functionAddress = (GL.getICD()).glProgramUniform3i64vARB;
/* 421 */     if (Checks.CHECKS) {
/* 422 */       Checks.check(__functionAddress);
/*     */     }
/* 424 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4i64vARB(@NativeType("GLint") int location, @NativeType("GLint64 *") long[] value) {
/* 429 */     long __functionAddress = (GL.getICD()).glUniform4i64vARB;
/* 430 */     if (Checks.CHECKS) {
/* 431 */       Checks.check(__functionAddress);
/*     */     }
/* 433 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") long[] value) {
/* 438 */     long __functionAddress = (GL.getICD()).glProgramUniform4i64vARB;
/* 439 */     if (Checks.CHECKS) {
/* 440 */       Checks.check(__functionAddress);
/*     */     }
/* 442 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1ui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] value) {
/* 447 */     long __functionAddress = (GL.getICD()).glUniform1ui64vARB;
/* 448 */     if (Checks.CHECKS) {
/* 449 */       Checks.check(__functionAddress);
/*     */     }
/* 451 */     JNI.callPV(location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] value) {
/* 456 */     long __functionAddress = (GL.getICD()).glProgramUniform1ui64vARB;
/* 457 */     if (Checks.CHECKS) {
/* 458 */       Checks.check(__functionAddress);
/*     */     }
/* 460 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] value) {
/* 465 */     long __functionAddress = (GL.getICD()).glUniform2ui64vARB;
/* 466 */     if (Checks.CHECKS) {
/* 467 */       Checks.check(__functionAddress);
/*     */     }
/* 469 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] value) {
/* 474 */     long __functionAddress = (GL.getICD()).glProgramUniform2ui64vARB;
/* 475 */     if (Checks.CHECKS) {
/* 476 */       Checks.check(__functionAddress);
/*     */     }
/* 478 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] value) {
/* 483 */     long __functionAddress = (GL.getICD()).glUniform3ui64vARB;
/* 484 */     if (Checks.CHECKS) {
/* 485 */       Checks.check(__functionAddress);
/*     */     }
/* 487 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] value) {
/* 492 */     long __functionAddress = (GL.getICD()).glProgramUniform3ui64vARB;
/* 493 */     if (Checks.CHECKS) {
/* 494 */       Checks.check(__functionAddress);
/*     */     }
/* 496 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64vARB(@NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] value) {
/* 501 */     long __functionAddress = (GL.getICD()).glUniform4ui64vARB;
/* 502 */     if (Checks.CHECKS) {
/* 503 */       Checks.check(__functionAddress);
/*     */     }
/* 505 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 const *") long[] value) {
/* 510 */     long __functionAddress = (GL.getICD()).glProgramUniform4ui64vARB;
/* 511 */     if (Checks.CHECKS) {
/* 512 */       Checks.check(__functionAddress);
/*     */     }
/* 514 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") long[] params) {
/* 519 */     long __functionAddress = (GL.getICD()).glGetUniformi64vARB;
/* 520 */     if (Checks.CHECKS) {
/* 521 */       Checks.check(__functionAddress);
/* 522 */       Checks.check(params, 1);
/*     */     } 
/* 524 */     JNI.callPV(program, location, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 *") long[] params) {
/* 529 */     long __functionAddress = (GL.getICD()).glGetUniformui64vARB;
/* 530 */     if (Checks.CHECKS) {
/* 531 */       Checks.check(__functionAddress);
/* 532 */       Checks.check(params, 1);
/*     */     } 
/* 534 */     JNI.callPV(program, location, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformi64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64 *") long[] params) {
/* 539 */     long __functionAddress = (GL.getICD()).glGetnUniformi64vARB;
/* 540 */     if (Checks.CHECKS) {
/* 541 */       Checks.check(__functionAddress);
/*     */     }
/* 543 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformui64vARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64 *") long[] params) {
/* 548 */     long __functionAddress = (GL.getICD()).glGetnUniformui64vARB;
/* 549 */     if (Checks.CHECKS) {
/* 550 */       Checks.check(__functionAddress);
/*     */     }
/* 552 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glUniform1i64ARB(@NativeType("GLint") int paramInt, @NativeType("GLint64") long paramLong);
/*     */   
/*     */   public static native void nglUniform1i64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform1i64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform1i64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform2i64ARB(@NativeType("GLint") int paramInt, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2);
/*     */   
/*     */   public static native void nglUniform2i64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform2i64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2);
/*     */   
/*     */   public static native void nglProgramUniform2i64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform3i64ARB(@NativeType("GLint") int paramInt, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2, @NativeType("GLint64") long paramLong3);
/*     */   
/*     */   public static native void nglUniform3i64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform3i64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2, @NativeType("GLint64") long paramLong3);
/*     */   
/*     */   public static native void nglProgramUniform3i64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform4i64ARB(@NativeType("GLint") int paramInt, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2, @NativeType("GLint64") long paramLong3, @NativeType("GLint64") long paramLong4);
/*     */   
/*     */   public static native void nglUniform4i64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform4i64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2, @NativeType("GLint64") long paramLong3, @NativeType("GLint64") long paramLong4);
/*     */   
/*     */   public static native void nglProgramUniform4i64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform1ui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglUniform1ui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform1ui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform1ui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform2ui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2);
/*     */   
/*     */   public static native void nglUniform2ui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform2ui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2);
/*     */   
/*     */   public static native void nglProgramUniform2ui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform3ui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2, @NativeType("GLuint64") long paramLong3);
/*     */   
/*     */   public static native void nglUniform3ui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform3ui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2, @NativeType("GLuint64") long paramLong3);
/*     */   
/*     */   public static native void nglProgramUniform3ui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform4ui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2, @NativeType("GLuint64") long paramLong3, @NativeType("GLuint64") long paramLong4);
/*     */   
/*     */   public static native void nglUniform4ui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform4ui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2, @NativeType("GLuint64") long paramLong3, @NativeType("GLuint64") long paramLong4);
/*     */   
/*     */   public static native void nglProgramUniform4ui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformi64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetnUniformi64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetnUniformui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBGPUShaderInt64.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */