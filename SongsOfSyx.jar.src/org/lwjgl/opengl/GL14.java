/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL14 extends GL13 {
/*     */   public static final int GL_GENERATE_MIPMAP = 33169;
/*     */   public static final int GL_GENERATE_MIPMAP_HINT = 33170;
/*     */   public static final int GL_CONSTANT_COLOR = 32769;
/*     */   
/*     */   static {
/*  20 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
/*     */   
/*     */   public static final int GL_CONSTANT_ALPHA = 32771;
/*     */   
/*     */   public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
/*     */   
/*     */   public static final int GL_BLEND_COLOR = 32773;
/*     */   
/*     */   public static final int GL_FUNC_ADD = 32774;
/*     */   
/*     */   public static final int GL_MIN = 32775;
/*     */   
/*     */   public static final int GL_MAX = 32776;
/*     */   
/*     */   public static final int GL_BLEND_EQUATION = 32777;
/*     */   
/*     */   public static final int GL_FUNC_SUBTRACT = 32778;
/*     */   
/*     */   public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
/*     */   
/*     */   public static final int GL_DEPTH_COMPONENT16 = 33189;
/*     */   
/*     */   public static final int GL_DEPTH_COMPONENT24 = 33190;
/*     */   
/*     */   public static final int GL_DEPTH_COMPONENT32 = 33191;
/*     */   
/*     */   public static final int GL_TEXTURE_DEPTH_SIZE = 34890;
/*     */   
/*     */   public static final int GL_DEPTH_TEXTURE_MODE = 34891;
/*     */   
/*     */   public static final int GL_TEXTURE_COMPARE_MODE = 34892;
/*     */   
/*     */   public static final int GL_TEXTURE_COMPARE_FUNC = 34893;
/*     */   
/*     */   public static final int GL_COMPARE_R_TO_TEXTURE = 34894;
/*     */   
/*     */   public static final int GL_FOG_COORDINATE_SOURCE = 33872;
/*     */   
/*     */   public static final int GL_FOG_COORDINATE = 33873;
/*     */   
/*     */   public static final int GL_FRAGMENT_DEPTH = 33874;
/*     */   
/*     */   public static final int GL_CURRENT_FOG_COORDINATE = 33875;
/*     */   
/*     */   public static final int GL_FOG_COORDINATE_ARRAY_TYPE = 33876;
/*     */   
/*     */   public static final int GL_FOG_COORDINATE_ARRAY_STRIDE = 33877;
/*     */   
/*     */   public static final int GL_FOG_COORDINATE_ARRAY_POINTER = 33878;
/*     */   
/*     */   public static final int GL_FOG_COORDINATE_ARRAY = 33879;
/*     */   
/*     */   public static final int GL_POINT_SIZE_MIN = 33062;
/*     */   
/*     */   public static final int GL_POINT_SIZE_MAX = 33063;
/*     */   
/*     */   public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064;
/*     */   
/*     */   public static final int GL_POINT_DISTANCE_ATTENUATION = 33065;
/*     */   
/*     */   public static final int GL_COLOR_SUM = 33880;
/*     */   
/*     */   public static final int GL_CURRENT_SECONDARY_COLOR = 33881;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_SIZE = 33882;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_TYPE = 33883;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE = 33884;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_POINTER = 33885;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY = 33886;
/*     */   
/*     */   public static final int GL_BLEND_DST_RGB = 32968;
/*     */   
/*     */   public static final int GL_BLEND_SRC_RGB = 32969;
/*     */   
/*     */   public static final int GL_BLEND_DST_ALPHA = 32970;
/*     */   public static final int GL_BLEND_SRC_ALPHA = 32971;
/*     */   public static final int GL_INCR_WRAP = 34055;
/*     */   public static final int GL_DECR_WRAP = 34056;
/*     */   public static final int GL_TEXTURE_FILTER_CONTROL = 34048;
/*     */   public static final int GL_TEXTURE_LOD_BIAS = 34049;
/*     */   public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045;
/*     */   public static final int GL_MIRRORED_REPEAT = 33648;
/*     */   
/*     */   protected GL14() {
/* 112 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlendColor(@NativeType("GLfloat") float red, @NativeType("GLfloat") float green, @NativeType("GLfloat") float blue, @NativeType("GLfloat") float alpha) {
/* 119 */     GL14C.glBlendColor(red, green, blue, alpha);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlendEquation(@NativeType("GLenum") int mode) {
/* 126 */     GL14C.glBlendEquation(mode);
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
/*     */   public static void glFogCoordfv(@NativeType("GLfloat const *") FloatBuffer coord) {
/* 146 */     if (Checks.CHECKS) {
/* 147 */       Checks.check(coord, 1);
/*     */     }
/* 149 */     nglFogCoordfv(MemoryUtil.memAddress(coord));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFogCoorddv(@NativeType("GLdouble const *") DoubleBuffer coord) {
/* 159 */     if (Checks.CHECKS) {
/* 160 */       Checks.check(coord, 1);
/*     */     }
/* 162 */     nglFogCoorddv(MemoryUtil.memAddress(coord));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFogCoordPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 172 */     nglFogCoordPointer(type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glFogCoordPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 177 */     nglFogCoordPointer(type, stride, pointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glFogCoordPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 182 */     nglFogCoordPointer(type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glFogCoordPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 187 */     nglFogCoordPointer(type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiDrawArrays(int mode, long first, long count, int drawcount) {
/* 194 */     GL14C.nglMultiDrawArrays(mode, first, count, drawcount);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArrays(@NativeType("GLenum") int mode, @NativeType("GLint const *") IntBuffer first, @NativeType("GLsizei const *") IntBuffer count) {
/* 199 */     GL14C.glMultiDrawArrays(mode, first, count);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiDrawElements(int mode, long count, int type, long indices, int drawcount) {
/* 206 */     GL14C.nglMultiDrawElements(mode, count, type, indices, drawcount);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElements(@NativeType("GLenum") int mode, @NativeType("GLsizei *") IntBuffer count, @NativeType("GLenum") int type, @NativeType("void const **") PointerBuffer indices) {
/* 211 */     GL14C.glMultiDrawElements(mode, count, type, indices);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPointParameterf(@NativeType("GLenum") int pname, @NativeType("GLfloat") float param) {
/* 218 */     GL14C.glPointParameterf(pname, param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPointParameteri(@NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/* 225 */     GL14C.glPointParameteri(pname, param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglPointParameterfv(int pname, long params) {
/* 232 */     GL14C.nglPointParameterfv(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPointParameterfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 237 */     GL14C.glPointParameterfv(pname, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglPointParameteriv(int pname, long params) {
/* 244 */     GL14C.nglPointParameteriv(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPointParameteriv(@NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 249 */     GL14C.glPointParameteriv(pname, params);
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
/*     */   public static void glSecondaryColor3bv(@NativeType("GLbyte const *") ByteBuffer v) {
/* 299 */     if (Checks.CHECKS) {
/* 300 */       Checks.check(v, 3);
/*     */     }
/* 302 */     nglSecondaryColor3bv(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3sv(@NativeType("GLshort const *") ShortBuffer v) {
/* 312 */     if (Checks.CHECKS) {
/* 313 */       Checks.check(v, 3);
/*     */     }
/* 315 */     nglSecondaryColor3sv(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3iv(@NativeType("GLint const *") IntBuffer v) {
/* 325 */     if (Checks.CHECKS) {
/* 326 */       Checks.check(v, 3);
/*     */     }
/* 328 */     nglSecondaryColor3iv(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3fv(@NativeType("GLfloat const *") FloatBuffer v) {
/* 338 */     if (Checks.CHECKS) {
/* 339 */       Checks.check(v, 3);
/*     */     }
/* 341 */     nglSecondaryColor3fv(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3dv(@NativeType("GLdouble const *") DoubleBuffer v) {
/* 351 */     if (Checks.CHECKS) {
/* 352 */       Checks.check(v, 3);
/*     */     }
/* 354 */     nglSecondaryColor3dv(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3ubv(@NativeType("GLubyte const *") ByteBuffer v) {
/* 364 */     if (Checks.CHECKS) {
/* 365 */       Checks.check(v, 3);
/*     */     }
/* 367 */     nglSecondaryColor3ubv(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3usv(@NativeType("GLushort const *") ShortBuffer v) {
/* 377 */     if (Checks.CHECKS) {
/* 378 */       Checks.check(v, 3);
/*     */     }
/* 380 */     nglSecondaryColor3usv(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3uiv(@NativeType("GLuint const *") IntBuffer v) {
/* 390 */     if (Checks.CHECKS) {
/* 391 */       Checks.check(v, 3);
/*     */     }
/* 393 */     nglSecondaryColor3uiv(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 403 */     nglSecondaryColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 408 */     nglSecondaryColorPointer(size, type, stride, pointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 413 */     nglSecondaryColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 418 */     nglSecondaryColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 423 */     nglSecondaryColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlendFuncSeparate(@NativeType("GLenum") int sfactorRGB, @NativeType("GLenum") int dfactorRGB, @NativeType("GLenum") int sfactorAlpha, @NativeType("GLenum") int dfactorAlpha) {
/* 430 */     GL14C.glBlendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
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
/*     */   public static void glWindowPos2iv(@NativeType("GLint const *") IntBuffer p) {
/* 460 */     if (Checks.CHECKS) {
/* 461 */       Checks.check(p, 2);
/*     */     }
/* 463 */     nglWindowPos2iv(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos2sv(@NativeType("GLshort const *") ShortBuffer p) {
/* 473 */     if (Checks.CHECKS) {
/* 474 */       Checks.check(p, 2);
/*     */     }
/* 476 */     nglWindowPos2sv(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos2fv(@NativeType("GLfloat const *") FloatBuffer p) {
/* 486 */     if (Checks.CHECKS) {
/* 487 */       Checks.check(p, 2);
/*     */     }
/* 489 */     nglWindowPos2fv(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos2dv(@NativeType("GLdouble const *") DoubleBuffer p) {
/* 499 */     if (Checks.CHECKS) {
/* 500 */       Checks.check(p, 2);
/*     */     }
/* 502 */     nglWindowPos2dv(MemoryUtil.memAddress(p));
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
/*     */   public static void glWindowPos3iv(@NativeType("GLint const *") IntBuffer p) {
/* 532 */     if (Checks.CHECKS) {
/* 533 */       Checks.check(p, 3);
/*     */     }
/* 535 */     nglWindowPos3iv(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos3sv(@NativeType("GLshort const *") ShortBuffer p) {
/* 545 */     if (Checks.CHECKS) {
/* 546 */       Checks.check(p, 3);
/*     */     }
/* 548 */     nglWindowPos3sv(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos3fv(@NativeType("GLfloat const *") FloatBuffer p) {
/* 558 */     if (Checks.CHECKS) {
/* 559 */       Checks.check(p, 3);
/*     */     }
/* 561 */     nglWindowPos3fv(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos3dv(@NativeType("GLdouble const *") DoubleBuffer p) {
/* 571 */     if (Checks.CHECKS) {
/* 572 */       Checks.check(p, 3);
/*     */     }
/* 574 */     nglWindowPos3dv(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glFogCoordfv(@NativeType("GLfloat const *") float[] coord) {
/* 579 */     long __functionAddress = (GL.getICD()).glFogCoordfv;
/* 580 */     if (Checks.CHECKS) {
/* 581 */       Checks.check(__functionAddress);
/* 582 */       Checks.check(coord, 1);
/*     */     } 
/* 584 */     JNI.callPV(coord, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glFogCoorddv(@NativeType("GLdouble const *") double[] coord) {
/* 589 */     long __functionAddress = (GL.getICD()).glFogCoorddv;
/* 590 */     if (Checks.CHECKS) {
/* 591 */       Checks.check(__functionAddress);
/* 592 */       Checks.check(coord, 1);
/*     */     } 
/* 594 */     JNI.callPV(coord, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArrays(@NativeType("GLenum") int mode, @NativeType("GLint const *") int[] first, @NativeType("GLsizei const *") int[] count) {
/* 599 */     GL14C.glMultiDrawArrays(mode, first, count);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElements(@NativeType("GLenum") int mode, @NativeType("GLsizei *") int[] count, @NativeType("GLenum") int type, @NativeType("void const **") PointerBuffer indices) {
/* 604 */     GL14C.glMultiDrawElements(mode, count, type, indices);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPointParameterfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 609 */     GL14C.glPointParameterfv(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPointParameteriv(@NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 614 */     GL14C.glPointParameteriv(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3sv(@NativeType("GLshort const *") short[] v) {
/* 619 */     long __functionAddress = (GL.getICD()).glSecondaryColor3sv;
/* 620 */     if (Checks.CHECKS) {
/* 621 */       Checks.check(__functionAddress);
/* 622 */       Checks.check(v, 3);
/*     */     } 
/* 624 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3iv(@NativeType("GLint const *") int[] v) {
/* 629 */     long __functionAddress = (GL.getICD()).glSecondaryColor3iv;
/* 630 */     if (Checks.CHECKS) {
/* 631 */       Checks.check(__functionAddress);
/* 632 */       Checks.check(v, 3);
/*     */     } 
/* 634 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3fv(@NativeType("GLfloat const *") float[] v) {
/* 639 */     long __functionAddress = (GL.getICD()).glSecondaryColor3fv;
/* 640 */     if (Checks.CHECKS) {
/* 641 */       Checks.check(__functionAddress);
/* 642 */       Checks.check(v, 3);
/*     */     } 
/* 644 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3dv(@NativeType("GLdouble const *") double[] v) {
/* 649 */     long __functionAddress = (GL.getICD()).glSecondaryColor3dv;
/* 650 */     if (Checks.CHECKS) {
/* 651 */       Checks.check(__functionAddress);
/* 652 */       Checks.check(v, 3);
/*     */     } 
/* 654 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3usv(@NativeType("GLushort const *") short[] v) {
/* 659 */     long __functionAddress = (GL.getICD()).glSecondaryColor3usv;
/* 660 */     if (Checks.CHECKS) {
/* 661 */       Checks.check(__functionAddress);
/* 662 */       Checks.check(v, 3);
/*     */     } 
/* 664 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3uiv(@NativeType("GLuint const *") int[] v) {
/* 669 */     long __functionAddress = (GL.getICD()).glSecondaryColor3uiv;
/* 670 */     if (Checks.CHECKS) {
/* 671 */       Checks.check(__functionAddress);
/* 672 */       Checks.check(v, 3);
/*     */     } 
/* 674 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2iv(@NativeType("GLint const *") int[] p) {
/* 679 */     long __functionAddress = (GL.getICD()).glWindowPos2iv;
/* 680 */     if (Checks.CHECKS) {
/* 681 */       Checks.check(__functionAddress);
/* 682 */       Checks.check(p, 2);
/*     */     } 
/* 684 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2sv(@NativeType("GLshort const *") short[] p) {
/* 689 */     long __functionAddress = (GL.getICD()).glWindowPos2sv;
/* 690 */     if (Checks.CHECKS) {
/* 691 */       Checks.check(__functionAddress);
/* 692 */       Checks.check(p, 2);
/*     */     } 
/* 694 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2fv(@NativeType("GLfloat const *") float[] p) {
/* 699 */     long __functionAddress = (GL.getICD()).glWindowPos2fv;
/* 700 */     if (Checks.CHECKS) {
/* 701 */       Checks.check(__functionAddress);
/* 702 */       Checks.check(p, 2);
/*     */     } 
/* 704 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2dv(@NativeType("GLdouble const *") double[] p) {
/* 709 */     long __functionAddress = (GL.getICD()).glWindowPos2dv;
/* 710 */     if (Checks.CHECKS) {
/* 711 */       Checks.check(__functionAddress);
/* 712 */       Checks.check(p, 2);
/*     */     } 
/* 714 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3iv(@NativeType("GLint const *") int[] p) {
/* 719 */     long __functionAddress = (GL.getICD()).glWindowPos3iv;
/* 720 */     if (Checks.CHECKS) {
/* 721 */       Checks.check(__functionAddress);
/* 722 */       Checks.check(p, 3);
/*     */     } 
/* 724 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3sv(@NativeType("GLshort const *") short[] p) {
/* 729 */     long __functionAddress = (GL.getICD()).glWindowPos3sv;
/* 730 */     if (Checks.CHECKS) {
/* 731 */       Checks.check(__functionAddress);
/* 732 */       Checks.check(p, 3);
/*     */     } 
/* 734 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3fv(@NativeType("GLfloat const *") float[] p) {
/* 739 */     long __functionAddress = (GL.getICD()).glWindowPos3fv;
/* 740 */     if (Checks.CHECKS) {
/* 741 */       Checks.check(__functionAddress);
/* 742 */       Checks.check(p, 3);
/*     */     } 
/* 744 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3dv(@NativeType("GLdouble const *") double[] p) {
/* 749 */     long __functionAddress = (GL.getICD()).glWindowPos3dv;
/* 750 */     if (Checks.CHECKS) {
/* 751 */       Checks.check(__functionAddress);
/* 752 */       Checks.check(p, 3);
/*     */     } 
/* 754 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glFogCoordf(@NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void glFogCoordd(@NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void nglFogCoordfv(long paramLong);
/*     */   
/*     */   public static native void nglFogCoorddv(long paramLong);
/*     */   
/*     */   public static native void nglFogCoordPointer(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glSecondaryColor3b(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3);
/*     */   
/*     */   public static native void glSecondaryColor3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glSecondaryColor3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glSecondaryColor3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glSecondaryColor3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void glSecondaryColor3ub(@NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3);
/*     */   
/*     */   public static native void glSecondaryColor3us(@NativeType("GLushort") short paramShort1, @NativeType("GLushort") short paramShort2, @NativeType("GLushort") short paramShort3);
/*     */   
/*     */   public static native void glSecondaryColor3ui(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void nglSecondaryColor3bv(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3sv(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3iv(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3fv(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3dv(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3ubv(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3usv(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3uiv(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColorPointer(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glWindowPos2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void glWindowPos2s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*     */   
/*     */   public static native void glWindowPos2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */   
/*     */   public static native void glWindowPos2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void nglWindowPos2iv(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos2sv(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos2fv(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos2dv(long paramLong);
/*     */   
/*     */   public static native void glWindowPos3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glWindowPos3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glWindowPos3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glWindowPos3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void nglWindowPos3iv(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos3sv(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos3fv(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos3dv(long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL14.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */