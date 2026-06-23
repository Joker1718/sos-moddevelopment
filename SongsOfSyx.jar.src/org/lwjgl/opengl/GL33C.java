/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL33C
/*     */   extends GL32C {
/*     */   public static final int GL_SRC1_COLOR = 35065;
/*     */   public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
/*     */   
/*     */   public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
/*     */   
/*     */   public static final int GL_ANY_SAMPLES_PASSED = 35887;
/*     */   
/*     */   public static final int GL_SAMPLER_BINDING = 35097;
/*     */   
/*     */   public static final int GL_RGB10_A2UI = 36975;
/*     */   
/*     */   public static final int GL_TEXTURE_SWIZZLE_R = 36418;
/*     */   
/*     */   public static final int GL_TEXTURE_SWIZZLE_G = 36419;
/*     */   
/*     */   public static final int GL_TEXTURE_SWIZZLE_B = 36420;
/*     */   
/*     */   public static final int GL_TEXTURE_SWIZZLE_A = 36421;
/*     */   
/*     */   public static final int GL_TEXTURE_SWIZZLE_RGBA = 36422;
/*     */   
/*     */   public static final int GL_TIME_ELAPSED = 35007;
/*     */   
/*     */   public static final int GL_TIMESTAMP = 36392;
/*     */   
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070;
/*     */   public static final int GL_INT_2_10_10_10_REV = 36255;
/*     */   
/*     */   protected GL33C() {
/*  51 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int program, @NativeType("GLuint") int colorNumber, @NativeType("GLuint") int index, @NativeType("GLchar const *") ByteBuffer name) {
/*  61 */     if (Checks.CHECKS) {
/*  62 */       Checks.checkNT1(name);
/*     */     }
/*  64 */     nglBindFragDataLocationIndexed(program, colorNumber, index, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int program, @NativeType("GLuint") int colorNumber, @NativeType("GLuint") int index, @NativeType("GLchar const *") CharSequence name) {
/*  69 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  71 */       stack.nASCII(name, true);
/*  72 */       long nameEncoded = stack.getPointerAddress();
/*  73 */       nglBindFragDataLocationIndexed(program, colorNumber, index, nameEncoded);
/*     */     } finally {
/*  75 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetFragDataIndex(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/*  87 */     if (Checks.CHECKS) {
/*  88 */       Checks.checkNT1(name);
/*     */     }
/*  90 */     return nglGetFragDataIndex(program, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetFragDataIndex(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/*  96 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  98 */       stack.nASCII(name, true);
/*  99 */       long nameEncoded = stack.getPointerAddress();
/* 100 */       return nglGetFragDataIndex(program, nameEncoded);
/*     */     } finally {
/* 102 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenSamplers(@NativeType("GLuint *") IntBuffer samplers) {
/* 113 */     nglGenSamplers(samplers.remaining(), MemoryUtil.memAddress(samplers));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenSamplers() {
/* 119 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 121 */       IntBuffer samplers = stack.callocInt(1);
/* 122 */       nglGenSamplers(1, MemoryUtil.memAddress(samplers));
/* 123 */       return samplers.get(0);
/*     */     } finally {
/* 125 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") IntBuffer samplers) {
/* 136 */     nglDeleteSamplers(samplers.remaining(), MemoryUtil.memAddress(samplers));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") int sampler) {
/* 141 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 143 */       IntBuffer samplers = stack.ints(sampler);
/* 144 */       nglDeleteSamplers(1, MemoryUtil.memAddress(samplers));
/*     */     } finally {
/* 146 */       stack.setPointer(stackPointer);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 178 */     if (Checks.CHECKS) {
/* 179 */       Checks.check(params, 1);
/*     */     }
/* 181 */     nglSamplerParameteriv(sampler, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 191 */     if (Checks.CHECKS) {
/* 192 */       Checks.check(params, 1);
/*     */     }
/* 194 */     nglSamplerParameterfv(sampler, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 204 */     if (Checks.CHECKS) {
/* 205 */       Checks.check(params, 1);
/*     */     }
/* 207 */     nglSamplerParameterIiv(sampler, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint const *") IntBuffer params) {
/* 217 */     if (Checks.CHECKS) {
/* 218 */       Checks.check(params, 1);
/*     */     }
/* 220 */     nglSamplerParameterIuiv(sampler, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 230 */     if (Checks.CHECKS) {
/* 231 */       Checks.check(params, 1);
/*     */     }
/* 233 */     nglGetSamplerParameteriv(sampler, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameteri(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 239 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 241 */       IntBuffer params = stack.callocInt(1);
/* 242 */       nglGetSamplerParameteriv(sampler, pname, MemoryUtil.memAddress(params));
/* 243 */       return params.get(0);
/*     */     } finally {
/* 245 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 256 */     if (Checks.CHECKS) {
/* 257 */       Checks.check(params, 1);
/*     */     }
/* 259 */     nglGetSamplerParameterfv(sampler, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetSamplerParameterf(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 265 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 267 */       FloatBuffer params = stack.callocFloat(1);
/* 268 */       nglGetSamplerParameterfv(sampler, pname, MemoryUtil.memAddress(params));
/* 269 */       return params.get(0);
/*     */     } finally {
/* 271 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 282 */     if (Checks.CHECKS) {
/* 283 */       Checks.check(params, 1);
/*     */     }
/* 285 */     nglGetSamplerParameterIiv(sampler, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameterIi(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 291 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 293 */       IntBuffer params = stack.callocInt(1);
/* 294 */       nglGetSamplerParameterIiv(sampler, pname, MemoryUtil.memAddress(params));
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
/*     */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 308 */     if (Checks.CHECKS) {
/* 309 */       Checks.check(params, 1);
/*     */     }
/* 311 */     nglGetSamplerParameterIuiv(sampler, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameterIui(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 317 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 319 */       IntBuffer params = stack.callocInt(1);
/* 320 */       nglGetSamplerParameterIuiv(sampler, pname, MemoryUtil.memAddress(params));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/* 339 */     if (Checks.CHECKS) {
/* 340 */       Checks.check(params, 1);
/*     */     }
/* 342 */     nglGetQueryObjecti64v(id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long params) {
/* 347 */     nglGetQueryObjecti64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjecti64(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 353 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 355 */       LongBuffer params = stack.callocLong(1);
/* 356 */       nglGetQueryObjecti64v(id, pname, MemoryUtil.memAddress(params));
/* 357 */       return params.get(0);
/*     */     } finally {
/* 359 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") LongBuffer params) {
/* 370 */     if (Checks.CHECKS) {
/* 371 */       Checks.check(params, 1);
/*     */     }
/* 373 */     nglGetQueryObjectui64v(id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long params) {
/* 378 */     nglGetQueryObjectui64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjectui64(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 384 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 386 */       LongBuffer params = stack.callocLong(1);
/* 387 */       nglGetQueryObjectui64v(id, pname, MemoryUtil.memAddress(params));
/* 388 */       return params.get(0);
/*     */     } finally {
/* 390 */       stack.setPointer(stackPointer);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 426 */     if (Checks.CHECKS) {
/* 427 */       Checks.check(value, 1);
/*     */     }
/* 429 */     nglVertexAttribP1uiv(index, type, normalized, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 439 */     if (Checks.CHECKS) {
/* 440 */       Checks.check(value, 1);
/*     */     }
/* 442 */     nglVertexAttribP2uiv(index, type, normalized, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 452 */     if (Checks.CHECKS) {
/* 453 */       Checks.check(value, 1);
/*     */     }
/* 455 */     nglVertexAttribP3uiv(index, type, normalized, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 465 */     if (Checks.CHECKS) {
/* 466 */       Checks.check(value, 1);
/*     */     }
/* 468 */     nglVertexAttribP4uiv(index, type, normalized, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenSamplers(@NativeType("GLuint *") int[] samplers) {
/* 473 */     long __functionAddress = (GL.getICD()).glGenSamplers;
/* 474 */     if (Checks.CHECKS) {
/* 475 */       Checks.check(__functionAddress);
/*     */     }
/* 477 */     JNI.callPV(samplers.length, samplers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") int[] samplers) {
/* 482 */     long __functionAddress = (GL.getICD()).glDeleteSamplers;
/* 483 */     if (Checks.CHECKS) {
/* 484 */       Checks.check(__functionAddress);
/*     */     }
/* 486 */     JNI.callPV(samplers.length, samplers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 491 */     long __functionAddress = (GL.getICD()).glSamplerParameteriv;
/* 492 */     if (Checks.CHECKS) {
/* 493 */       Checks.check(__functionAddress);
/* 494 */       Checks.check(params, 1);
/*     */     } 
/* 496 */     JNI.callPV(sampler, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 501 */     long __functionAddress = (GL.getICD()).glSamplerParameterfv;
/* 502 */     if (Checks.CHECKS) {
/* 503 */       Checks.check(__functionAddress);
/* 504 */       Checks.check(params, 1);
/*     */     } 
/* 506 */     JNI.callPV(sampler, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 511 */     long __functionAddress = (GL.getICD()).glSamplerParameterIiv;
/* 512 */     if (Checks.CHECKS) {
/* 513 */       Checks.check(__functionAddress);
/* 514 */       Checks.check(params, 1);
/*     */     } 
/* 516 */     JNI.callPV(sampler, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int[] params) {
/* 521 */     long __functionAddress = (GL.getICD()).glSamplerParameterIuiv;
/* 522 */     if (Checks.CHECKS) {
/* 523 */       Checks.check(__functionAddress);
/* 524 */       Checks.check(params, 1);
/*     */     } 
/* 526 */     JNI.callPV(sampler, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 531 */     long __functionAddress = (GL.getICD()).glGetSamplerParameteriv;
/* 532 */     if (Checks.CHECKS) {
/* 533 */       Checks.check(__functionAddress);
/* 534 */       Checks.check(params, 1);
/*     */     } 
/* 536 */     JNI.callPV(sampler, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 541 */     long __functionAddress = (GL.getICD()).glGetSamplerParameterfv;
/* 542 */     if (Checks.CHECKS) {
/* 543 */       Checks.check(__functionAddress);
/* 544 */       Checks.check(params, 1);
/*     */     } 
/* 546 */     JNI.callPV(sampler, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 551 */     long __functionAddress = (GL.getICD()).glGetSamplerParameterIiv;
/* 552 */     if (Checks.CHECKS) {
/* 553 */       Checks.check(__functionAddress);
/* 554 */       Checks.check(params, 1);
/*     */     } 
/* 556 */     JNI.callPV(sampler, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 561 */     long __functionAddress = (GL.getICD()).glGetSamplerParameterIuiv;
/* 562 */     if (Checks.CHECKS) {
/* 563 */       Checks.check(__functionAddress);
/* 564 */       Checks.check(params, 1);
/*     */     } 
/* 566 */     JNI.callPV(sampler, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 571 */     long __functionAddress = (GL.getICD()).glGetQueryObjecti64v;
/* 572 */     if (Checks.CHECKS) {
/* 573 */       Checks.check(__functionAddress);
/* 574 */       Checks.check(params, 1);
/*     */     } 
/* 576 */     JNI.callPV(id, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long[] params) {
/* 581 */     long __functionAddress = (GL.getICD()).glGetQueryObjectui64v;
/* 582 */     if (Checks.CHECKS) {
/* 583 */       Checks.check(__functionAddress);
/* 584 */       Checks.check(params, 1);
/*     */     } 
/* 586 */     JNI.callPV(id, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 591 */     long __functionAddress = (GL.getICD()).glVertexAttribP1uiv;
/* 592 */     if (Checks.CHECKS) {
/* 593 */       Checks.check(__functionAddress);
/* 594 */       Checks.check(value, 1);
/*     */     } 
/* 596 */     JNI.callPV(index, type, normalized, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 601 */     long __functionAddress = (GL.getICD()).glVertexAttribP2uiv;
/* 602 */     if (Checks.CHECKS) {
/* 603 */       Checks.check(__functionAddress);
/* 604 */       Checks.check(value, 1);
/*     */     } 
/* 606 */     JNI.callPV(index, type, normalized, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 611 */     long __functionAddress = (GL.getICD()).glVertexAttribP3uiv;
/* 612 */     if (Checks.CHECKS) {
/* 613 */       Checks.check(__functionAddress);
/* 614 */       Checks.check(value, 1);
/*     */     } 
/* 616 */     JNI.callPV(index, type, normalized, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 621 */     long __functionAddress = (GL.getICD()).glVertexAttribP4uiv;
/* 622 */     if (Checks.CHECKS) {
/* 623 */       Checks.check(__functionAddress);
/* 624 */       Checks.check(value, 1);
/*     */     } 
/* 626 */     JNI.callPV(index, type, normalized, value, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglBindFragDataLocationIndexed(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native int nglGetFragDataIndex(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenSamplers(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteSamplers(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsSampler(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glBindSampler(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glSamplerParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glSamplerParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void nglSamplerParameteriv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglSamplerParameterfv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglSamplerParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglSamplerParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSamplerParameteriv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSamplerParameterfv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSamplerParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSamplerParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glQueryCounter(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */   
/*     */   public static native void nglGetQueryObjecti64v(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetQueryObjectui64v(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glVertexAttribDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glVertexAttribP1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glVertexAttribP2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glVertexAttribP3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glVertexAttribP4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void nglVertexAttribP1uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribP2uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribP3uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribP4uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL33C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */