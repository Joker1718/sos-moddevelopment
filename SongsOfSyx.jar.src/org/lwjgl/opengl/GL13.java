/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL13
/*     */   extends GL12 {
/*     */   public static final int GL_COMPRESSED_ALPHA = 34025;
/*     */   public static final int GL_COMPRESSED_LUMINANCE = 34026;
/*     */   public static final int GL_COMPRESSED_LUMINANCE_ALPHA = 34027;
/*     */   
/*     */   static {
/*  20 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_COMPRESSED_INTENSITY = 34028;
/*     */   
/*     */   public static final int GL_COMPRESSED_RGB = 34029;
/*     */   
/*     */   public static final int GL_COMPRESSED_RGBA = 34030;
/*     */   
/*     */   public static final int GL_TEXTURE_COMPRESSION_HINT = 34031;
/*     */   
/*     */   public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 34464;
/*     */   
/*     */   public static final int GL_TEXTURE_COMPRESSED = 34465;
/*     */   
/*     */   public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466;
/*     */   
/*     */   public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467;
/*     */   
/*     */   public static final int GL_NORMAL_MAP = 34065;
/*     */   
/*     */   public static final int GL_REFLECTION_MAP = 34066;
/*     */   
/*     */   public static final int GL_TEXTURE_CUBE_MAP = 34067;
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068;
/*     */   
/*     */   public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069;
/*     */   
/*     */   public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070;
/*     */   
/*     */   public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071;
/*     */   
/*     */   public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072;
/*     */   
/*     */   public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073;
/*     */   
/*     */   public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074;
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_CUBE_MAP = 34075;
/*     */   
/*     */   public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076;
/*     */   
/*     */   public static final int GL_MULTISAMPLE = 32925;
/*     */   
/*     */   public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926;
/*     */   
/*     */   public static final int GL_SAMPLE_ALPHA_TO_ONE = 32927;
/*     */   
/*     */   public static final int GL_SAMPLE_COVERAGE = 32928;
/*     */   
/*     */   public static final int GL_MULTISAMPLE_BIT = 536870912;
/*     */   
/*     */   public static final int GL_SAMPLE_BUFFERS = 32936;
/*     */   
/*     */   public static final int GL_SAMPLES = 32937;
/*     */   
/*     */   public static final int GL_SAMPLE_COVERAGE_VALUE = 32938;
/*     */   
/*     */   public static final int GL_SAMPLE_COVERAGE_INVERT = 32939;
/*     */   
/*     */   public static final int GL_TEXTURE0 = 33984;
/*     */   
/*     */   public static final int GL_TEXTURE1 = 33985;
/*     */   
/*     */   public static final int GL_TEXTURE2 = 33986;
/*     */   
/*     */   public static final int GL_TEXTURE3 = 33987;
/*     */   
/*     */   public static final int GL_TEXTURE4 = 33988;
/*     */   
/*     */   public static final int GL_TEXTURE5 = 33989;
/*     */   
/*     */   public static final int GL_TEXTURE6 = 33990;
/*     */   
/*     */   public static final int GL_TEXTURE7 = 33991;
/*     */   public static final int GL_TEXTURE8 = 33992;
/*     */   public static final int GL_TEXTURE9 = 33993;
/*     */   public static final int GL_TEXTURE10 = 33994;
/*     */   public static final int GL_TEXTURE11 = 33995;
/*     */   public static final int GL_TEXTURE12 = 33996;
/*     */   public static final int GL_TEXTURE13 = 33997;
/*     */   public static final int GL_TEXTURE14 = 33998;
/*     */   public static final int GL_TEXTURE15 = 33999;
/*     */   public static final int GL_TEXTURE16 = 34000;
/*     */   public static final int GL_TEXTURE17 = 34001;
/*     */   public static final int GL_TEXTURE18 = 34002;
/*     */   public static final int GL_TEXTURE19 = 34003;
/*     */   public static final int GL_TEXTURE20 = 34004;
/*     */   public static final int GL_TEXTURE21 = 34005;
/*     */   public static final int GL_TEXTURE22 = 34006;
/*     */   public static final int GL_TEXTURE23 = 34007;
/*     */   public static final int GL_TEXTURE24 = 34008;
/*     */   public static final int GL_TEXTURE25 = 34009;
/*     */   public static final int GL_TEXTURE26 = 34010;
/*     */   public static final int GL_TEXTURE27 = 34011;
/*     */   public static final int GL_TEXTURE28 = 34012;
/*     */   public static final int GL_TEXTURE29 = 34013;
/*     */   public static final int GL_TEXTURE30 = 34014;
/*     */   public static final int GL_TEXTURE31 = 34015;
/*     */   public static final int GL_ACTIVE_TEXTURE = 34016;
/*     */   public static final int GL_CLIENT_ACTIVE_TEXTURE = 34017;
/*     */   public static final int GL_MAX_TEXTURE_UNITS = 34018;
/*     */   public static final int GL_COMBINE = 34160;
/*     */   public static final int GL_COMBINE_RGB = 34161;
/*     */   public static final int GL_COMBINE_ALPHA = 34162;
/*     */   public static final int GL_SOURCE0_RGB = 34176;
/*     */   public static final int GL_SOURCE1_RGB = 34177;
/*     */   public static final int GL_SOURCE2_RGB = 34178;
/*     */   public static final int GL_SOURCE0_ALPHA = 34184;
/*     */   public static final int GL_SOURCE1_ALPHA = 34185;
/*     */   public static final int GL_SOURCE2_ALPHA = 34186;
/*     */   public static final int GL_OPERAND0_RGB = 34192;
/*     */   public static final int GL_OPERAND1_RGB = 34193;
/*     */   public static final int GL_OPERAND2_RGB = 34194;
/*     */   public static final int GL_OPERAND0_ALPHA = 34200;
/*     */   public static final int GL_OPERAND1_ALPHA = 34201;
/*     */   public static final int GL_OPERAND2_ALPHA = 34202;
/*     */   public static final int GL_RGB_SCALE = 34163;
/*     */   public static final int GL_ADD_SIGNED = 34164;
/*     */   public static final int GL_INTERPOLATE = 34165;
/*     */   public static final int GL_SUBTRACT = 34023;
/*     */   public static final int GL_CONSTANT = 34166;
/*     */   public static final int GL_PRIMARY_COLOR = 34167;
/*     */   public static final int GL_PREVIOUS = 34168;
/*     */   public static final int GL_DOT3_RGB = 34478;
/*     */   public static final int GL_DOT3_RGBA = 34479;
/*     */   public static final int GL_CLAMP_TO_BORDER = 33069;
/*     */   public static final int GL_TRANSPOSE_MODELVIEW_MATRIX = 34019;
/*     */   public static final int GL_TRANSPOSE_PROJECTION_MATRIX = 34020;
/*     */   public static final int GL_TRANSPOSE_TEXTURE_MATRIX = 34021;
/*     */   public static final int GL_TRANSPOSE_COLOR_MATRIX = 34022;
/*     */   
/*     */   protected GL13() {
/* 155 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, long data) {
/* 162 */     GL13C.nglCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 167 */     GL13C.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("void const *") ByteBuffer data) {
/* 172 */     GL13C.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, long data) {
/* 179 */     GL13C.nglCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 184 */     GL13C.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("void const *") ByteBuffer data) {
/* 189 */     GL13C.glCompressedTexImage2D(target, level, internalformat, width, height, border, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, long data) {
/* 196 */     GL13C.nglCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 201 */     GL13C.glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("void const *") ByteBuffer data) {
/* 206 */     GL13C.glCompressedTexImage1D(target, level, internalformat, width, border, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data) {
/* 213 */     GL13C.nglCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 218 */     GL13C.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 223 */     GL13C.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data) {
/* 230 */     GL13C.nglCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 235 */     GL13C.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 240 */     GL13C.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, long data) {
/* 247 */     GL13C.nglCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 252 */     GL13C.glCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 257 */     GL13C.glCompressedTexSubImage1D(target, level, xoffset, width, format, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetCompressedTexImage(int target, int level, long pixels) {
/* 264 */     GL13C.nglGetCompressedTexImage(target, level, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTexImage(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer pixels) {
/* 269 */     GL13C.glGetCompressedTexImage(target, level, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTexImage(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") long pixels) {
/* 274 */     GL13C.glGetCompressedTexImage(target, level, pixels);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSampleCoverage(@NativeType("GLfloat") float value, @NativeType("GLboolean") boolean invert) {
/* 281 */     GL13C.glSampleCoverage(value, invert);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glActiveTexture(@NativeType("GLenum") int texture) {
/* 288 */     GL13C.glActiveTexture(texture);
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
/*     */   public static void glMultiTexCoord1fv(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") FloatBuffer v) {
/* 323 */     if (Checks.CHECKS) {
/* 324 */       Checks.check(v, 1);
/*     */     }
/* 326 */     nglMultiTexCoord1fv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1sv(@NativeType("GLenum") int texture, @NativeType("GLshort const *") ShortBuffer v) {
/* 336 */     if (Checks.CHECKS) {
/* 337 */       Checks.check(v, 1);
/*     */     }
/* 339 */     nglMultiTexCoord1sv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1iv(@NativeType("GLenum") int texture, @NativeType("GLint const *") IntBuffer v) {
/* 349 */     if (Checks.CHECKS) {
/* 350 */       Checks.check(v, 1);
/*     */     }
/* 352 */     nglMultiTexCoord1iv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1dv(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 362 */     if (Checks.CHECKS) {
/* 363 */       Checks.check(v, 1);
/*     */     }
/* 365 */     nglMultiTexCoord1dv(texture, MemoryUtil.memAddress(v));
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
/*     */   public static void glMultiTexCoord2fv(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") FloatBuffer v) {
/* 395 */     if (Checks.CHECKS) {
/* 396 */       Checks.check(v, 2);
/*     */     }
/* 398 */     nglMultiTexCoord2fv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2sv(@NativeType("GLenum") int texture, @NativeType("GLshort const *") ShortBuffer v) {
/* 408 */     if (Checks.CHECKS) {
/* 409 */       Checks.check(v, 2);
/*     */     }
/* 411 */     nglMultiTexCoord2sv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2iv(@NativeType("GLenum") int texture, @NativeType("GLint const *") IntBuffer v) {
/* 421 */     if (Checks.CHECKS) {
/* 422 */       Checks.check(v, 2);
/*     */     }
/* 424 */     nglMultiTexCoord2iv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2dv(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 434 */     if (Checks.CHECKS) {
/* 435 */       Checks.check(v, 2);
/*     */     }
/* 437 */     nglMultiTexCoord2dv(texture, MemoryUtil.memAddress(v));
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
/*     */   public static void glMultiTexCoord3fv(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") FloatBuffer v) {
/* 467 */     if (Checks.CHECKS) {
/* 468 */       Checks.check(v, 3);
/*     */     }
/* 470 */     nglMultiTexCoord3fv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3sv(@NativeType("GLenum") int texture, @NativeType("GLshort const *") ShortBuffer v) {
/* 480 */     if (Checks.CHECKS) {
/* 481 */       Checks.check(v, 3);
/*     */     }
/* 483 */     nglMultiTexCoord3sv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3iv(@NativeType("GLenum") int texture, @NativeType("GLint const *") IntBuffer v) {
/* 493 */     if (Checks.CHECKS) {
/* 494 */       Checks.check(v, 3);
/*     */     }
/* 496 */     nglMultiTexCoord3iv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3dv(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 506 */     if (Checks.CHECKS) {
/* 507 */       Checks.check(v, 3);
/*     */     }
/* 509 */     nglMultiTexCoord3dv(texture, MemoryUtil.memAddress(v));
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
/*     */   public static void glMultiTexCoord4fv(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") FloatBuffer v) {
/* 539 */     if (Checks.CHECKS) {
/* 540 */       Checks.check(v, 4);
/*     */     }
/* 542 */     nglMultiTexCoord4fv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4sv(@NativeType("GLenum") int texture, @NativeType("GLshort const *") ShortBuffer v) {
/* 552 */     if (Checks.CHECKS) {
/* 553 */       Checks.check(v, 4);
/*     */     }
/* 555 */     nglMultiTexCoord4sv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4iv(@NativeType("GLenum") int texture, @NativeType("GLint const *") IntBuffer v) {
/* 565 */     if (Checks.CHECKS) {
/* 566 */       Checks.check(v, 4);
/*     */     }
/* 568 */     nglMultiTexCoord4iv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4dv(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 578 */     if (Checks.CHECKS) {
/* 579 */       Checks.check(v, 4);
/*     */     }
/* 581 */     nglMultiTexCoord4dv(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixf(@NativeType("GLfloat const *") FloatBuffer m) {
/* 591 */     if (Checks.CHECKS) {
/* 592 */       Checks.check(m, 16);
/*     */     }
/* 594 */     nglLoadTransposeMatrixf(MemoryUtil.memAddress(m));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixd(@NativeType("GLdouble const *") DoubleBuffer m) {
/* 604 */     if (Checks.CHECKS) {
/* 605 */       Checks.check(m, 16);
/*     */     }
/* 607 */     nglLoadTransposeMatrixd(MemoryUtil.memAddress(m));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixf(@NativeType("GLfloat const *") FloatBuffer m) {
/* 617 */     if (Checks.CHECKS) {
/* 618 */       Checks.check(m, 16);
/*     */     }
/* 620 */     nglMultTransposeMatrixf(MemoryUtil.memAddress(m));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixd(@NativeType("GLdouble const *") DoubleBuffer m) {
/* 630 */     if (Checks.CHECKS) {
/* 631 */       Checks.check(m, 16);
/*     */     }
/* 633 */     nglMultTransposeMatrixd(MemoryUtil.memAddress(m));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1fv(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") float[] v) {
/* 638 */     long __functionAddress = (GL.getICD()).glMultiTexCoord1fv;
/* 639 */     if (Checks.CHECKS) {
/* 640 */       Checks.check(__functionAddress);
/* 641 */       Checks.check(v, 1);
/*     */     } 
/* 643 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1sv(@NativeType("GLenum") int texture, @NativeType("GLshort const *") short[] v) {
/* 648 */     long __functionAddress = (GL.getICD()).glMultiTexCoord1sv;
/* 649 */     if (Checks.CHECKS) {
/* 650 */       Checks.check(__functionAddress);
/* 651 */       Checks.check(v, 1);
/*     */     } 
/* 653 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1iv(@NativeType("GLenum") int texture, @NativeType("GLint const *") int[] v) {
/* 658 */     long __functionAddress = (GL.getICD()).glMultiTexCoord1iv;
/* 659 */     if (Checks.CHECKS) {
/* 660 */       Checks.check(__functionAddress);
/* 661 */       Checks.check(v, 1);
/*     */     } 
/* 663 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1dv(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") double[] v) {
/* 668 */     long __functionAddress = (GL.getICD()).glMultiTexCoord1dv;
/* 669 */     if (Checks.CHECKS) {
/* 670 */       Checks.check(__functionAddress);
/* 671 */       Checks.check(v, 1);
/*     */     } 
/* 673 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2fv(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") float[] v) {
/* 678 */     long __functionAddress = (GL.getICD()).glMultiTexCoord2fv;
/* 679 */     if (Checks.CHECKS) {
/* 680 */       Checks.check(__functionAddress);
/* 681 */       Checks.check(v, 2);
/*     */     } 
/* 683 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2sv(@NativeType("GLenum") int texture, @NativeType("GLshort const *") short[] v) {
/* 688 */     long __functionAddress = (GL.getICD()).glMultiTexCoord2sv;
/* 689 */     if (Checks.CHECKS) {
/* 690 */       Checks.check(__functionAddress);
/* 691 */       Checks.check(v, 2);
/*     */     } 
/* 693 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2iv(@NativeType("GLenum") int texture, @NativeType("GLint const *") int[] v) {
/* 698 */     long __functionAddress = (GL.getICD()).glMultiTexCoord2iv;
/* 699 */     if (Checks.CHECKS) {
/* 700 */       Checks.check(__functionAddress);
/* 701 */       Checks.check(v, 2);
/*     */     } 
/* 703 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2dv(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") double[] v) {
/* 708 */     long __functionAddress = (GL.getICD()).glMultiTexCoord2dv;
/* 709 */     if (Checks.CHECKS) {
/* 710 */       Checks.check(__functionAddress);
/* 711 */       Checks.check(v, 2);
/*     */     } 
/* 713 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3fv(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") float[] v) {
/* 718 */     long __functionAddress = (GL.getICD()).glMultiTexCoord3fv;
/* 719 */     if (Checks.CHECKS) {
/* 720 */       Checks.check(__functionAddress);
/* 721 */       Checks.check(v, 3);
/*     */     } 
/* 723 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3sv(@NativeType("GLenum") int texture, @NativeType("GLshort const *") short[] v) {
/* 728 */     long __functionAddress = (GL.getICD()).glMultiTexCoord3sv;
/* 729 */     if (Checks.CHECKS) {
/* 730 */       Checks.check(__functionAddress);
/* 731 */       Checks.check(v, 3);
/*     */     } 
/* 733 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3iv(@NativeType("GLenum") int texture, @NativeType("GLint const *") int[] v) {
/* 738 */     long __functionAddress = (GL.getICD()).glMultiTexCoord3iv;
/* 739 */     if (Checks.CHECKS) {
/* 740 */       Checks.check(__functionAddress);
/* 741 */       Checks.check(v, 3);
/*     */     } 
/* 743 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3dv(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") double[] v) {
/* 748 */     long __functionAddress = (GL.getICD()).glMultiTexCoord3dv;
/* 749 */     if (Checks.CHECKS) {
/* 750 */       Checks.check(__functionAddress);
/* 751 */       Checks.check(v, 3);
/*     */     } 
/* 753 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4fv(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") float[] v) {
/* 758 */     long __functionAddress = (GL.getICD()).glMultiTexCoord4fv;
/* 759 */     if (Checks.CHECKS) {
/* 760 */       Checks.check(__functionAddress);
/* 761 */       Checks.check(v, 4);
/*     */     } 
/* 763 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4sv(@NativeType("GLenum") int texture, @NativeType("GLshort const *") short[] v) {
/* 768 */     long __functionAddress = (GL.getICD()).glMultiTexCoord4sv;
/* 769 */     if (Checks.CHECKS) {
/* 770 */       Checks.check(__functionAddress);
/* 771 */       Checks.check(v, 4);
/*     */     } 
/* 773 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4iv(@NativeType("GLenum") int texture, @NativeType("GLint const *") int[] v) {
/* 778 */     long __functionAddress = (GL.getICD()).glMultiTexCoord4iv;
/* 779 */     if (Checks.CHECKS) {
/* 780 */       Checks.check(__functionAddress);
/* 781 */       Checks.check(v, 4);
/*     */     } 
/* 783 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4dv(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") double[] v) {
/* 788 */     long __functionAddress = (GL.getICD()).glMultiTexCoord4dv;
/* 789 */     if (Checks.CHECKS) {
/* 790 */       Checks.check(__functionAddress);
/* 791 */       Checks.check(v, 4);
/*     */     } 
/* 793 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixf(@NativeType("GLfloat const *") float[] m) {
/* 798 */     long __functionAddress = (GL.getICD()).glLoadTransposeMatrixf;
/* 799 */     if (Checks.CHECKS) {
/* 800 */       Checks.check(__functionAddress);
/* 801 */       Checks.check(m, 16);
/*     */     } 
/* 803 */     JNI.callPV(m, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixd(@NativeType("GLdouble const *") double[] m) {
/* 808 */     long __functionAddress = (GL.getICD()).glLoadTransposeMatrixd;
/* 809 */     if (Checks.CHECKS) {
/* 810 */       Checks.check(__functionAddress);
/* 811 */       Checks.check(m, 16);
/*     */     } 
/* 813 */     JNI.callPV(m, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixf(@NativeType("GLfloat const *") float[] m) {
/* 818 */     long __functionAddress = (GL.getICD()).glMultTransposeMatrixf;
/* 819 */     if (Checks.CHECKS) {
/* 820 */       Checks.check(__functionAddress);
/* 821 */       Checks.check(m, 16);
/*     */     } 
/* 823 */     JNI.callPV(m, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixd(@NativeType("GLdouble const *") double[] m) {
/* 828 */     long __functionAddress = (GL.getICD()).glMultTransposeMatrixd;
/* 829 */     if (Checks.CHECKS) {
/* 830 */       Checks.check(__functionAddress);
/* 831 */       Checks.check(m, 16);
/*     */     } 
/* 833 */     JNI.callPV(m, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glClientActiveTexture(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glMultiTexCoord1f(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void glMultiTexCoord1s(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort);
/*     */   
/*     */   public static native void glMultiTexCoord1i(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void glMultiTexCoord1d(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void nglMultiTexCoord1fv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord1sv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord1iv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord1dv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord2f(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */   
/*     */   public static native void glMultiTexCoord2s(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*     */   
/*     */   public static native void glMultiTexCoord2i(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glMultiTexCoord2d(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void nglMultiTexCoord2fv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord2sv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord2iv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord2dv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord3f(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glMultiTexCoord3s(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glMultiTexCoord3i(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glMultiTexCoord3d(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void nglMultiTexCoord3fv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord3sv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord3iv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord3dv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord4f(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*     */   
/*     */   public static native void glMultiTexCoord4s(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*     */   
/*     */   public static native void glMultiTexCoord4i(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void glMultiTexCoord4d(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*     */   
/*     */   public static native void nglMultiTexCoord4fv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord4sv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord4iv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord4dv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglLoadTransposeMatrixf(long paramLong);
/*     */   
/*     */   public static native void nglLoadTransposeMatrixd(long paramLong);
/*     */   
/*     */   public static native void nglMultTransposeMatrixf(long paramLong);
/*     */   
/*     */   public static native void nglMultTransposeMatrixd(long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL13.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */