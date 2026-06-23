/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class EXTGPUShader4
/*     */ {
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER_EXT = 35069;
/*     */   public static final int GL_SAMPLER_1D_ARRAY_EXT = 36288;
/*     */   public static final int GL_SAMPLER_2D_ARRAY_EXT = 36289;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLER_BUFFER_EXT = 36290;
/*     */   
/*     */   public static final int GL_SAMPLER_1D_ARRAY_SHADOW_EXT = 36291;
/*     */   
/*     */   public static final int GL_SAMPLER_2D_ARRAY_SHADOW_EXT = 36292;
/*     */   
/*     */   public static final int GL_SAMPLER_CUBE_SHADOW_EXT = 36293;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_VEC2_EXT = 36294;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_VEC3_EXT = 36295;
/*     */   public static final int GL_UNSIGNED_INT_VEC4_EXT = 36296;
/*     */   public static final int GL_INT_SAMPLER_1D_EXT = 36297;
/*     */   public static final int GL_INT_SAMPLER_2D_EXT = 36298;
/*     */   public static final int GL_INT_SAMPLER_3D_EXT = 36299;
/*     */   public static final int GL_INT_SAMPLER_CUBE_EXT = 36300;
/*     */   public static final int GL_INT_SAMPLER_2D_RECT_EXT = 36301;
/*     */   public static final int GL_INT_SAMPLER_1D_ARRAY_EXT = 36302;
/*     */   public static final int GL_INT_SAMPLER_2D_ARRAY_EXT = 36303;
/*     */   public static final int GL_INT_SAMPLER_BUFFER_EXT = 36304;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_1D_EXT = 36305;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_EXT = 36306;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_3D_EXT = 36307;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_EXT = 36308;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT_EXT = 36309;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY_EXT = 36310;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY_EXT = 36311;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_EXT = 36312;
/*     */   public static final int GL_MIN_PROGRAM_TEXEL_OFFSET_EXT = 35076;
/*     */   public static final int GL_MAX_PROGRAM_TEXEL_OFFSET_EXT = 35077;
/*     */   
/*     */   protected EXTGPUShader4() {
/*  55 */     throw new UnsupportedOperationException();
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
/*     */   public static void glVertexAttribI1ivEXT(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/* 105 */     if (Checks.CHECKS) {
/* 106 */       Checks.check(v, 1);
/*     */     }
/* 108 */     nglVertexAttribI1ivEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI2ivEXT(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/* 118 */     if (Checks.CHECKS) {
/* 119 */       Checks.check(v, 2);
/*     */     }
/* 121 */     nglVertexAttribI2ivEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI3ivEXT(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(v, 3);
/*     */     }
/* 134 */     nglVertexAttribI3ivEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4ivEXT(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(v, 4);
/*     */     }
/* 147 */     nglVertexAttribI4ivEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI1uivEXT(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/* 157 */     if (Checks.CHECKS) {
/* 158 */       Checks.check(v, 1);
/*     */     }
/* 160 */     nglVertexAttribI1uivEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI2uivEXT(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/* 170 */     if (Checks.CHECKS) {
/* 171 */       Checks.check(v, 2);
/*     */     }
/* 173 */     nglVertexAttribI2uivEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI3uivEXT(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/* 183 */     if (Checks.CHECKS) {
/* 184 */       Checks.check(v, 3);
/*     */     }
/* 186 */     nglVertexAttribI3uivEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4uivEXT(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/* 196 */     if (Checks.CHECKS) {
/* 197 */       Checks.check(v, 4);
/*     */     }
/* 199 */     nglVertexAttribI4uivEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4bvEXT(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/* 209 */     if (Checks.CHECKS) {
/* 210 */       Checks.check(v, 4);
/*     */     }
/* 212 */     nglVertexAttribI4bvEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4svEXT(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/* 222 */     if (Checks.CHECKS) {
/* 223 */       Checks.check(v, 4);
/*     */     }
/* 225 */     nglVertexAttribI4svEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4ubvEXT(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/* 235 */     if (Checks.CHECKS) {
/* 236 */       Checks.check(v, 4);
/*     */     }
/* 238 */     nglVertexAttribI4ubvEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4usvEXT(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/* 248 */     if (Checks.CHECKS) {
/* 249 */       Checks.check(v, 4);
/*     */     }
/* 251 */     nglVertexAttribI4usvEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 261 */     nglVertexAttribIPointerEXT(index, size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 266 */     nglVertexAttribIPointerEXT(index, size, type, stride, pointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 271 */     nglVertexAttribIPointerEXT(index, size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 276 */     nglVertexAttribIPointerEXT(index, size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribIivEXT(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 286 */     if (Checks.CHECKS) {
/* 287 */       Checks.check(params, 4);
/*     */     }
/* 289 */     nglGetVertexAttribIivEXT(index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetVertexAttribIiEXT(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 295 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 297 */       IntBuffer params = stack.callocInt(1);
/* 298 */       nglGetVertexAttribIivEXT(index, pname, MemoryUtil.memAddress(params));
/* 299 */       return params.get(0);
/*     */     } finally {
/* 301 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribIuivEXT(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 312 */     if (Checks.CHECKS) {
/* 313 */       Checks.check(params, 4);
/*     */     }
/* 315 */     nglGetVertexAttribIuivEXT(index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetVertexAttribIuiEXT(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 321 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 323 */       IntBuffer params = stack.callocInt(1);
/* 324 */       nglGetVertexAttribIuivEXT(index, pname, MemoryUtil.memAddress(params));
/* 325 */       return params.get(0);
/*     */     } finally {
/* 327 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformuivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") IntBuffer params) {
/* 338 */     if (Checks.CHECKS) {
/* 339 */       Checks.check(params, 1);
/*     */     }
/* 341 */     nglGetUniformuivEXT(program, location, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformuiEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 347 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 349 */       IntBuffer params = stack.callocInt(1);
/* 350 */       nglGetUniformuivEXT(program, location, MemoryUtil.memAddress(params));
/* 351 */       return params.get(0);
/*     */     } finally {
/* 353 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindFragDataLocationEXT(@NativeType("GLuint") int program, @NativeType("GLuint") int color, @NativeType("GLchar const *") ByteBuffer name) {
/* 364 */     if (Checks.CHECKS) {
/* 365 */       Checks.checkNT1(name);
/*     */     }
/* 367 */     nglBindFragDataLocationEXT(program, color, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindFragDataLocationEXT(@NativeType("GLuint") int program, @NativeType("GLuint") int color, @NativeType("GLchar const *") CharSequence name) {
/* 372 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 374 */       stack.nASCII(name, true);
/* 375 */       long nameEncoded = stack.getPointerAddress();
/* 376 */       nglBindFragDataLocationEXT(program, color, nameEncoded);
/*     */     } finally {
/* 378 */       stack.setPointer(stackPointer);
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
/*     */   public static int glGetFragDataLocationEXT(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/* 390 */     if (Checks.CHECKS) {
/* 391 */       Checks.checkNT1(name);
/*     */     }
/* 393 */     return nglGetFragDataLocationEXT(program, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetFragDataLocationEXT(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/* 399 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 401 */       stack.nASCII(name, true);
/* 402 */       long nameEncoded = stack.getPointerAddress();
/* 403 */       return nglGetFragDataLocationEXT(program, nameEncoded);
/*     */     } finally {
/* 405 */       stack.setPointer(stackPointer);
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
/*     */   public static void glUniform1uivEXT(@NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 436 */     nglUniform1uivEXT(location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2uivEXT(@NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 446 */     nglUniform2uivEXT(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3uivEXT(@NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 456 */     nglUniform3uivEXT(location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4uivEXT(@NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 466 */     nglUniform4uivEXT(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI1ivEXT(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 471 */     long __functionAddress = (GL.getICD()).glVertexAttribI1ivEXT;
/* 472 */     if (Checks.CHECKS) {
/* 473 */       Checks.check(__functionAddress);
/* 474 */       Checks.check(v, 1);
/*     */     } 
/* 476 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI2ivEXT(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 481 */     long __functionAddress = (GL.getICD()).glVertexAttribI2ivEXT;
/* 482 */     if (Checks.CHECKS) {
/* 483 */       Checks.check(__functionAddress);
/* 484 */       Checks.check(v, 2);
/*     */     } 
/* 486 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI3ivEXT(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 491 */     long __functionAddress = (GL.getICD()).glVertexAttribI3ivEXT;
/* 492 */     if (Checks.CHECKS) {
/* 493 */       Checks.check(__functionAddress);
/* 494 */       Checks.check(v, 3);
/*     */     } 
/* 496 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4ivEXT(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 501 */     long __functionAddress = (GL.getICD()).glVertexAttribI4ivEXT;
/* 502 */     if (Checks.CHECKS) {
/* 503 */       Checks.check(__functionAddress);
/* 504 */       Checks.check(v, 4);
/*     */     } 
/* 506 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI1uivEXT(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 511 */     long __functionAddress = (GL.getICD()).glVertexAttribI1uivEXT;
/* 512 */     if (Checks.CHECKS) {
/* 513 */       Checks.check(__functionAddress);
/* 514 */       Checks.check(v, 1);
/*     */     } 
/* 516 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI2uivEXT(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 521 */     long __functionAddress = (GL.getICD()).glVertexAttribI2uivEXT;
/* 522 */     if (Checks.CHECKS) {
/* 523 */       Checks.check(__functionAddress);
/* 524 */       Checks.check(v, 2);
/*     */     } 
/* 526 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI3uivEXT(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 531 */     long __functionAddress = (GL.getICD()).glVertexAttribI3uivEXT;
/* 532 */     if (Checks.CHECKS) {
/* 533 */       Checks.check(__functionAddress);
/* 534 */       Checks.check(v, 3);
/*     */     } 
/* 536 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4uivEXT(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 541 */     long __functionAddress = (GL.getICD()).glVertexAttribI4uivEXT;
/* 542 */     if (Checks.CHECKS) {
/* 543 */       Checks.check(__functionAddress);
/* 544 */       Checks.check(v, 4);
/*     */     } 
/* 546 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4svEXT(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 551 */     long __functionAddress = (GL.getICD()).glVertexAttribI4svEXT;
/* 552 */     if (Checks.CHECKS) {
/* 553 */       Checks.check(__functionAddress);
/* 554 */       Checks.check(v, 4);
/*     */     } 
/* 556 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4usvEXT(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 561 */     long __functionAddress = (GL.getICD()).glVertexAttribI4usvEXT;
/* 562 */     if (Checks.CHECKS) {
/* 563 */       Checks.check(__functionAddress);
/* 564 */       Checks.check(v, 4);
/*     */     } 
/* 566 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") short[] pointer) {
/* 571 */     long __functionAddress = (GL.getICD()).glVertexAttribIPointerEXT;
/* 572 */     if (Checks.CHECKS) {
/* 573 */       Checks.check(__functionAddress);
/*     */     }
/* 575 */     JNI.callPV(index, size, type, stride, pointer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") int[] pointer) {
/* 580 */     long __functionAddress = (GL.getICD()).glVertexAttribIPointerEXT;
/* 581 */     if (Checks.CHECKS) {
/* 582 */       Checks.check(__functionAddress);
/*     */     }
/* 584 */     JNI.callPV(index, size, type, stride, pointer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribIivEXT(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 589 */     long __functionAddress = (GL.getICD()).glGetVertexAttribIivEXT;
/* 590 */     if (Checks.CHECKS) {
/* 591 */       Checks.check(__functionAddress);
/* 592 */       Checks.check(params, 4);
/*     */     } 
/* 594 */     JNI.callPV(index, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribIuivEXT(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 599 */     long __functionAddress = (GL.getICD()).glGetVertexAttribIuivEXT;
/* 600 */     if (Checks.CHECKS) {
/* 601 */       Checks.check(__functionAddress);
/* 602 */       Checks.check(params, 4);
/*     */     } 
/* 604 */     JNI.callPV(index, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformuivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") int[] params) {
/* 609 */     long __functionAddress = (GL.getICD()).glGetUniformuivEXT;
/* 610 */     if (Checks.CHECKS) {
/* 611 */       Checks.check(__functionAddress);
/* 612 */       Checks.check(params, 1);
/*     */     } 
/* 614 */     JNI.callPV(program, location, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1uivEXT(@NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 619 */     long __functionAddress = (GL.getICD()).glUniform1uivEXT;
/* 620 */     if (Checks.CHECKS) {
/* 621 */       Checks.check(__functionAddress);
/*     */     }
/* 623 */     JNI.callPV(location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2uivEXT(@NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 628 */     long __functionAddress = (GL.getICD()).glUniform2uivEXT;
/* 629 */     if (Checks.CHECKS) {
/* 630 */       Checks.check(__functionAddress);
/*     */     }
/* 632 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3uivEXT(@NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 637 */     long __functionAddress = (GL.getICD()).glUniform3uivEXT;
/* 638 */     if (Checks.CHECKS) {
/* 639 */       Checks.check(__functionAddress);
/*     */     }
/* 641 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4uivEXT(@NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 646 */     long __functionAddress = (GL.getICD()).glUniform4uivEXT;
/* 647 */     if (Checks.CHECKS) {
/* 648 */       Checks.check(__functionAddress);
/*     */     }
/* 650 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glVertexAttribI1iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void glVertexAttribI2iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glVertexAttribI3iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glVertexAttribI4iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void glVertexAttribI1uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glVertexAttribI2uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glVertexAttribI3uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glVertexAttribI4uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void nglVertexAttribI1ivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI2ivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI3ivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4ivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI1uivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI2uivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI3uivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4uivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4bvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4svEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4ubvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4usvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribIPointerEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribIivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribIuivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformuivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglBindFragDataLocationEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native int nglGetFragDataLocationEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glUniform1uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glUniform2uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glUniform3uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*     */   
/*     */   public static native void glUniform4uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5);
/*     */   
/*     */   public static native void nglUniform1uivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform2uivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform3uivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform4uivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTGPUShader4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */