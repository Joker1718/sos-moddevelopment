/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL33
/*     */   extends GL32 {
/*     */   public static final int GL_SRC1_COLOR = 35065;
/*     */   public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
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
/*     */   protected GL33() {
/*  50 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindFragDataLocationIndexed(int program, int colorNumber, int index, long name) {
/*  57 */     GL33C.nglBindFragDataLocationIndexed(program, colorNumber, index, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int program, @NativeType("GLuint") int colorNumber, @NativeType("GLuint") int index, @NativeType("GLchar const *") ByteBuffer name) {
/*  62 */     GL33C.glBindFragDataLocationIndexed(program, colorNumber, index, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int program, @NativeType("GLuint") int colorNumber, @NativeType("GLuint") int index, @NativeType("GLchar const *") CharSequence name) {
/*  67 */     GL33C.glBindFragDataLocationIndexed(program, colorNumber, index, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetFragDataIndex(int program, long name) {
/*  74 */     return GL33C.nglGetFragDataIndex(program, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetFragDataIndex(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/*  80 */     return GL33C.glGetFragDataIndex(program, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetFragDataIndex(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/*  86 */     return GL33C.glGetFragDataIndex(program, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenSamplers(int count, long samplers) {
/*  93 */     GL33C.nglGenSamplers(count, samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenSamplers(@NativeType("GLuint *") IntBuffer samplers) {
/*  98 */     GL33C.glGenSamplers(samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenSamplers() {
/* 104 */     return GL33C.glGenSamplers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteSamplers(int count, long samplers) {
/* 111 */     GL33C.nglDeleteSamplers(count, samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") IntBuffer samplers) {
/* 116 */     GL33C.glDeleteSamplers(samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") int sampler) {
/* 121 */     GL33C.glDeleteSamplers(sampler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsSampler(@NativeType("GLuint") int sampler) {
/* 129 */     return GL33C.glIsSampler(sampler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindSampler(@NativeType("GLuint") int unit, @NativeType("GLuint") int sampler) {
/* 136 */     GL33C.glBindSampler(unit, sampler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteri(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/* 143 */     GL33C.glSamplerParameteri(sampler, pname, param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterf(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat") float param) {
/* 150 */     GL33C.glSamplerParameterf(sampler, pname, param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameteriv(int sampler, int pname, long params) {
/* 157 */     GL33C.nglSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 162 */     GL33C.glSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameterfv(int sampler, int pname, long params) {
/* 169 */     GL33C.nglSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 174 */     GL33C.glSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameterIiv(int sampler, int pname, long params) {
/* 181 */     GL33C.nglSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 186 */     GL33C.glSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameterIuiv(int sampler, int pname, long params) {
/* 193 */     GL33C.nglSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint const *") IntBuffer params) {
/* 198 */     GL33C.glSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameteriv(int sampler, int pname, long params) {
/* 205 */     GL33C.nglGetSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 210 */     GL33C.glGetSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameteri(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 216 */     return GL33C.glGetSamplerParameteri(sampler, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameterfv(int sampler, int pname, long params) {
/* 223 */     GL33C.nglGetSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 228 */     GL33C.glGetSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetSamplerParameterf(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 234 */     return GL33C.glGetSamplerParameterf(sampler, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameterIiv(int sampler, int pname, long params) {
/* 241 */     GL33C.nglGetSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 246 */     GL33C.glGetSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameterIi(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 252 */     return GL33C.glGetSamplerParameterIi(sampler, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameterIuiv(int sampler, int pname, long params) {
/* 259 */     GL33C.nglGetSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 264 */     GL33C.glGetSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameterIui(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 270 */     return GL33C.glGetSamplerParameterIui(sampler, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glQueryCounter(@NativeType("GLuint") int id, @NativeType("GLenum") int target) {
/* 277 */     GL33C.glQueryCounter(id, target);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetQueryObjecti64v(int id, int pname, long params) {
/* 284 */     GL33C.nglGetQueryObjecti64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/* 289 */     GL33C.glGetQueryObjecti64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long params) {
/* 294 */     GL33C.glGetQueryObjecti64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjecti64(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 300 */     return GL33C.glGetQueryObjecti64(id, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetQueryObjectui64v(int id, int pname, long params) {
/* 307 */     GL33C.nglGetQueryObjectui64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") LongBuffer params) {
/* 312 */     GL33C.glGetQueryObjectui64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long params) {
/* 317 */     GL33C.glGetQueryObjectui64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjectui64(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 323 */     return GL33C.glGetQueryObjectui64(id, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribDivisor(@NativeType("GLuint") int index, @NativeType("GLuint") int divisor) {
/* 330 */     GL33C.glVertexAttribDivisor(index, divisor);
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
/*     */   public static void glVertexP2uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer value) {
/* 355 */     if (Checks.CHECKS) {
/* 356 */       Checks.check(value, 1);
/*     */     }
/* 358 */     nglVertexP2uiv(type, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer value) {
/* 368 */     if (Checks.CHECKS) {
/* 369 */       Checks.check(value, 1);
/*     */     }
/* 371 */     nglVertexP3uiv(type, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer value) {
/* 381 */     if (Checks.CHECKS) {
/* 382 */       Checks.check(value, 1);
/*     */     }
/* 384 */     nglVertexP4uiv(type, MemoryUtil.memAddress(value));
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
/*     */   public static void glTexCoordP1uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 414 */     if (Checks.CHECKS) {
/* 415 */       Checks.check(coords, 1);
/*     */     }
/* 417 */     nglTexCoordP1uiv(type, MemoryUtil.memAddress(coords));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP2uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 427 */     if (Checks.CHECKS) {
/* 428 */       Checks.check(coords, 1);
/*     */     }
/* 430 */     nglTexCoordP2uiv(type, MemoryUtil.memAddress(coords));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 440 */     if (Checks.CHECKS) {
/* 441 */       Checks.check(coords, 1);
/*     */     }
/* 443 */     nglTexCoordP3uiv(type, MemoryUtil.memAddress(coords));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 453 */     if (Checks.CHECKS) {
/* 454 */       Checks.check(coords, 1);
/*     */     }
/* 456 */     nglTexCoordP4uiv(type, MemoryUtil.memAddress(coords));
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
/*     */   public static void glMultiTexCoordP1uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 486 */     if (Checks.CHECKS) {
/* 487 */       Checks.check(coords, 1);
/*     */     }
/* 489 */     nglMultiTexCoordP1uiv(texture, type, MemoryUtil.memAddress(coords));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP2uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 499 */     if (Checks.CHECKS) {
/* 500 */       Checks.check(coords, 1);
/*     */     }
/* 502 */     nglMultiTexCoordP2uiv(texture, type, MemoryUtil.memAddress(coords));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP3uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 512 */     if (Checks.CHECKS) {
/* 513 */       Checks.check(coords, 1);
/*     */     }
/* 515 */     nglMultiTexCoordP3uiv(texture, type, MemoryUtil.memAddress(coords));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP4uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 525 */     if (Checks.CHECKS) {
/* 526 */       Checks.check(coords, 1);
/*     */     }
/* 528 */     nglMultiTexCoordP4uiv(texture, type, MemoryUtil.memAddress(coords));
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
/*     */   public static void glNormalP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 543 */     if (Checks.CHECKS) {
/* 544 */       Checks.check(coords, 1);
/*     */     }
/* 546 */     nglNormalP3uiv(type, MemoryUtil.memAddress(coords));
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
/*     */   public static void glColorP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer color) {
/* 566 */     if (Checks.CHECKS) {
/* 567 */       Checks.check(color, 1);
/*     */     }
/* 569 */     nglColorP3uiv(type, MemoryUtil.memAddress(color));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glColorP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer color) {
/* 579 */     if (Checks.CHECKS) {
/* 580 */       Checks.check(color, 1);
/*     */     }
/* 582 */     nglColorP4uiv(type, MemoryUtil.memAddress(color));
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
/*     */   public static void glSecondaryColorP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer color) {
/* 597 */     if (Checks.CHECKS) {
/* 598 */       Checks.check(color, 1);
/*     */     }
/* 600 */     nglSecondaryColorP3uiv(type, MemoryUtil.memAddress(color));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP1ui(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int value) {
/* 607 */     GL33C.glVertexAttribP1ui(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP2ui(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int value) {
/* 614 */     GL33C.glVertexAttribP2ui(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP3ui(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int value) {
/* 621 */     GL33C.glVertexAttribP3ui(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP4ui(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int value) {
/* 628 */     GL33C.glVertexAttribP4ui(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP1uiv(int index, int type, boolean normalized, long value) {
/* 635 */     GL33C.nglVertexAttribP1uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 640 */     GL33C.glVertexAttribP1uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP2uiv(int index, int type, boolean normalized, long value) {
/* 647 */     GL33C.nglVertexAttribP2uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 652 */     GL33C.glVertexAttribP2uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP3uiv(int index, int type, boolean normalized, long value) {
/* 659 */     GL33C.nglVertexAttribP3uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 664 */     GL33C.glVertexAttribP3uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP4uiv(int index, int type, boolean normalized, long value) {
/* 671 */     GL33C.nglVertexAttribP4uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 676 */     GL33C.glVertexAttribP4uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenSamplers(@NativeType("GLuint *") int[] samplers) {
/* 681 */     GL33C.glGenSamplers(samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") int[] samplers) {
/* 686 */     GL33C.glDeleteSamplers(samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 691 */     GL33C.glSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 696 */     GL33C.glSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 701 */     GL33C.glSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int[] params) {
/* 706 */     GL33C.glSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 711 */     GL33C.glGetSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 716 */     GL33C.glGetSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 721 */     GL33C.glGetSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 726 */     GL33C.glGetSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 731 */     GL33C.glGetQueryObjecti64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long[] params) {
/* 736 */     GL33C.glGetQueryObjectui64v(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP2uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] value) {
/* 741 */     long __functionAddress = (GL.getICD()).glVertexP2uiv;
/* 742 */     if (Checks.CHECKS) {
/* 743 */       Checks.check(__functionAddress);
/* 744 */       Checks.check(value, 1);
/*     */     } 
/* 746 */     JNI.callPV(type, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] value) {
/* 751 */     long __functionAddress = (GL.getICD()).glVertexP3uiv;
/* 752 */     if (Checks.CHECKS) {
/* 753 */       Checks.check(__functionAddress);
/* 754 */       Checks.check(value, 1);
/*     */     } 
/* 756 */     JNI.callPV(type, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] value) {
/* 761 */     long __functionAddress = (GL.getICD()).glVertexP4uiv;
/* 762 */     if (Checks.CHECKS) {
/* 763 */       Checks.check(__functionAddress);
/* 764 */       Checks.check(value, 1);
/*     */     } 
/* 766 */     JNI.callPV(type, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP1uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 771 */     long __functionAddress = (GL.getICD()).glTexCoordP1uiv;
/* 772 */     if (Checks.CHECKS) {
/* 773 */       Checks.check(__functionAddress);
/* 774 */       Checks.check(coords, 1);
/*     */     } 
/* 776 */     JNI.callPV(type, coords, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP2uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 781 */     long __functionAddress = (GL.getICD()).glTexCoordP2uiv;
/* 782 */     if (Checks.CHECKS) {
/* 783 */       Checks.check(__functionAddress);
/* 784 */       Checks.check(coords, 1);
/*     */     } 
/* 786 */     JNI.callPV(type, coords, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 791 */     long __functionAddress = (GL.getICD()).glTexCoordP3uiv;
/* 792 */     if (Checks.CHECKS) {
/* 793 */       Checks.check(__functionAddress);
/* 794 */       Checks.check(coords, 1);
/*     */     } 
/* 796 */     JNI.callPV(type, coords, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 801 */     long __functionAddress = (GL.getICD()).glTexCoordP4uiv;
/* 802 */     if (Checks.CHECKS) {
/* 803 */       Checks.check(__functionAddress);
/* 804 */       Checks.check(coords, 1);
/*     */     } 
/* 806 */     JNI.callPV(type, coords, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP1uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 811 */     long __functionAddress = (GL.getICD()).glMultiTexCoordP1uiv;
/* 812 */     if (Checks.CHECKS) {
/* 813 */       Checks.check(__functionAddress);
/* 814 */       Checks.check(coords, 1);
/*     */     } 
/* 816 */     JNI.callPV(texture, type, coords, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP2uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 821 */     long __functionAddress = (GL.getICD()).glMultiTexCoordP2uiv;
/* 822 */     if (Checks.CHECKS) {
/* 823 */       Checks.check(__functionAddress);
/* 824 */       Checks.check(coords, 1);
/*     */     } 
/* 826 */     JNI.callPV(texture, type, coords, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP3uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 831 */     long __functionAddress = (GL.getICD()).glMultiTexCoordP3uiv;
/* 832 */     if (Checks.CHECKS) {
/* 833 */       Checks.check(__functionAddress);
/* 834 */       Checks.check(coords, 1);
/*     */     } 
/* 836 */     JNI.callPV(texture, type, coords, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP4uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 841 */     long __functionAddress = (GL.getICD()).glMultiTexCoordP4uiv;
/* 842 */     if (Checks.CHECKS) {
/* 843 */       Checks.check(__functionAddress);
/* 844 */       Checks.check(coords, 1);
/*     */     } 
/* 846 */     JNI.callPV(texture, type, coords, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNormalP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 851 */     long __functionAddress = (GL.getICD()).glNormalP3uiv;
/* 852 */     if (Checks.CHECKS) {
/* 853 */       Checks.check(__functionAddress);
/* 854 */       Checks.check(coords, 1);
/*     */     } 
/* 856 */     JNI.callPV(type, coords, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] color) {
/* 861 */     long __functionAddress = (GL.getICD()).glColorP3uiv;
/* 862 */     if (Checks.CHECKS) {
/* 863 */       Checks.check(__functionAddress);
/* 864 */       Checks.check(color, 1);
/*     */     } 
/* 866 */     JNI.callPV(type, color, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] color) {
/* 871 */     long __functionAddress = (GL.getICD()).glColorP4uiv;
/* 872 */     if (Checks.CHECKS) {
/* 873 */       Checks.check(__functionAddress);
/* 874 */       Checks.check(color, 1);
/*     */     } 
/* 876 */     JNI.callPV(type, color, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] color) {
/* 881 */     long __functionAddress = (GL.getICD()).glSecondaryColorP3uiv;
/* 882 */     if (Checks.CHECKS) {
/* 883 */       Checks.check(__functionAddress);
/* 884 */       Checks.check(color, 1);
/*     */     } 
/* 886 */     JNI.callPV(type, color, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 891 */     GL33C.glVertexAttribP1uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 896 */     GL33C.glVertexAttribP2uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 901 */     GL33C.glVertexAttribP3uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 906 */     GL33C.glVertexAttribP4uiv(index, type, normalized, value);
/*     */   }
/*     */   
/*     */   public static native void glVertexP2ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glVertexP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glVertexP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglVertexP2uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexP3uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexP4uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glTexCoordP1ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glTexCoordP2ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glTexCoordP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glTexCoordP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglTexCoordP1uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglTexCoordP2uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglTexCoordP3uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglTexCoordP4uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoordP1ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glMultiTexCoordP2ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glMultiTexCoordP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glMultiTexCoordP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void nglMultiTexCoordP1uiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoordP2uiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoordP3uiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoordP4uiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glNormalP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglNormalP3uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glColorP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glColorP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglColorP3uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglColorP4uiv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glSecondaryColorP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglSecondaryColorP3uiv(int paramInt, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL33.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */