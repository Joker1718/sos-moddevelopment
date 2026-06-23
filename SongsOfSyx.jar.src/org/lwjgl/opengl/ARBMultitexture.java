/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBMultitexture
/*     */ {
/*     */   public static final int GL_TEXTURE0_ARB = 33984;
/*     */   public static final int GL_TEXTURE1_ARB = 33985;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE2_ARB = 33986;
/*     */   
/*     */   public static final int GL_TEXTURE3_ARB = 33987;
/*     */   
/*     */   public static final int GL_TEXTURE4_ARB = 33988;
/*     */   
/*     */   public static final int GL_TEXTURE5_ARB = 33989;
/*     */   public static final int GL_TEXTURE6_ARB = 33990;
/*     */   public static final int GL_TEXTURE7_ARB = 33991;
/*     */   public static final int GL_TEXTURE8_ARB = 33992;
/*     */   public static final int GL_TEXTURE9_ARB = 33993;
/*     */   public static final int GL_TEXTURE10_ARB = 33994;
/*     */   public static final int GL_TEXTURE11_ARB = 33995;
/*     */   public static final int GL_TEXTURE12_ARB = 33996;
/*     */   public static final int GL_TEXTURE13_ARB = 33997;
/*     */   public static final int GL_TEXTURE14_ARB = 33998;
/*     */   public static final int GL_TEXTURE15_ARB = 33999;
/*     */   public static final int GL_TEXTURE16_ARB = 34000;
/*     */   public static final int GL_TEXTURE17_ARB = 34001;
/*     */   public static final int GL_TEXTURE18_ARB = 34002;
/*     */   public static final int GL_TEXTURE19_ARB = 34003;
/*     */   public static final int GL_TEXTURE20_ARB = 34004;
/*     */   public static final int GL_TEXTURE21_ARB = 34005;
/*     */   public static final int GL_TEXTURE22_ARB = 34006;
/*     */   public static final int GL_TEXTURE23_ARB = 34007;
/*     */   public static final int GL_TEXTURE24_ARB = 34008;
/*     */   public static final int GL_TEXTURE25_ARB = 34009;
/*     */   public static final int GL_TEXTURE26_ARB = 34010;
/*     */   public static final int GL_TEXTURE27_ARB = 34011;
/*     */   public static final int GL_TEXTURE28_ARB = 34012;
/*     */   public static final int GL_TEXTURE29_ARB = 34013;
/*     */   public static final int GL_TEXTURE30_ARB = 34014;
/*     */   public static final int GL_TEXTURE31_ARB = 34015;
/*     */   public static final int GL_ACTIVE_TEXTURE_ARB = 34016;
/*     */   public static final int GL_CLIENT_ACTIVE_TEXTURE_ARB = 34017;
/*     */   public static final int GL_MAX_TEXTURE_UNITS_ARB = 34018;
/*     */   
/*     */   protected ARBMultitexture() {
/*  60 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMultiTexCoord1fvARB(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") FloatBuffer v) {
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.check(v, 1);
/*     */     }
/* 103 */     nglMultiTexCoord1fvARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1svARB(@NativeType("GLenum") int texture, @NativeType("GLshort const *") ShortBuffer v) {
/* 113 */     if (Checks.CHECKS) {
/* 114 */       Checks.check(v, 1);
/*     */     }
/* 116 */     nglMultiTexCoord1svARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1ivARB(@NativeType("GLenum") int texture, @NativeType("GLint const *") IntBuffer v) {
/* 126 */     if (Checks.CHECKS) {
/* 127 */       Checks.check(v, 1);
/*     */     }
/* 129 */     nglMultiTexCoord1ivARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1dvARB(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 139 */     if (Checks.CHECKS) {
/* 140 */       Checks.check(v, 1);
/*     */     }
/* 142 */     nglMultiTexCoord1dvARB(texture, MemoryUtil.memAddress(v));
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
/*     */   public static void glMultiTexCoord2fvARB(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") FloatBuffer v) {
/* 172 */     if (Checks.CHECKS) {
/* 173 */       Checks.check(v, 2);
/*     */     }
/* 175 */     nglMultiTexCoord2fvARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2svARB(@NativeType("GLenum") int texture, @NativeType("GLshort const *") ShortBuffer v) {
/* 185 */     if (Checks.CHECKS) {
/* 186 */       Checks.check(v, 2);
/*     */     }
/* 188 */     nglMultiTexCoord2svARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2ivARB(@NativeType("GLenum") int texture, @NativeType("GLint const *") IntBuffer v) {
/* 198 */     if (Checks.CHECKS) {
/* 199 */       Checks.check(v, 2);
/*     */     }
/* 201 */     nglMultiTexCoord2ivARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2dvARB(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 211 */     if (Checks.CHECKS) {
/* 212 */       Checks.check(v, 2);
/*     */     }
/* 214 */     nglMultiTexCoord2dvARB(texture, MemoryUtil.memAddress(v));
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
/*     */   public static void glMultiTexCoord3fvARB(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") FloatBuffer v) {
/* 244 */     if (Checks.CHECKS) {
/* 245 */       Checks.check(v, 3);
/*     */     }
/* 247 */     nglMultiTexCoord3fvARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3svARB(@NativeType("GLenum") int texture, @NativeType("GLshort const *") ShortBuffer v) {
/* 257 */     if (Checks.CHECKS) {
/* 258 */       Checks.check(v, 3);
/*     */     }
/* 260 */     nglMultiTexCoord3svARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3ivARB(@NativeType("GLenum") int texture, @NativeType("GLint const *") IntBuffer v) {
/* 270 */     if (Checks.CHECKS) {
/* 271 */       Checks.check(v, 3);
/*     */     }
/* 273 */     nglMultiTexCoord3ivARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3dvARB(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 283 */     if (Checks.CHECKS) {
/* 284 */       Checks.check(v, 3);
/*     */     }
/* 286 */     nglMultiTexCoord3dvARB(texture, MemoryUtil.memAddress(v));
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
/*     */   public static void glMultiTexCoord4fvARB(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") FloatBuffer v) {
/* 316 */     if (Checks.CHECKS) {
/* 317 */       Checks.check(v, 4);
/*     */     }
/* 319 */     nglMultiTexCoord4fvARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4svARB(@NativeType("GLenum") int texture, @NativeType("GLshort const *") ShortBuffer v) {
/* 329 */     if (Checks.CHECKS) {
/* 330 */       Checks.check(v, 4);
/*     */     }
/* 332 */     nglMultiTexCoord4svARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4ivARB(@NativeType("GLenum") int texture, @NativeType("GLint const *") IntBuffer v) {
/* 342 */     if (Checks.CHECKS) {
/* 343 */       Checks.check(v, 4);
/*     */     }
/* 345 */     nglMultiTexCoord4ivARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4dvARB(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 355 */     if (Checks.CHECKS) {
/* 356 */       Checks.check(v, 4);
/*     */     }
/* 358 */     nglMultiTexCoord4dvARB(texture, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1fvARB(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") float[] v) {
/* 363 */     long __functionAddress = (GL.getICD()).glMultiTexCoord1fvARB;
/* 364 */     if (Checks.CHECKS) {
/* 365 */       Checks.check(__functionAddress);
/* 366 */       Checks.check(v, 1);
/*     */     } 
/* 368 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1svARB(@NativeType("GLenum") int texture, @NativeType("GLshort const *") short[] v) {
/* 373 */     long __functionAddress = (GL.getICD()).glMultiTexCoord1svARB;
/* 374 */     if (Checks.CHECKS) {
/* 375 */       Checks.check(__functionAddress);
/* 376 */       Checks.check(v, 1);
/*     */     } 
/* 378 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1ivARB(@NativeType("GLenum") int texture, @NativeType("GLint const *") int[] v) {
/* 383 */     long __functionAddress = (GL.getICD()).glMultiTexCoord1ivARB;
/* 384 */     if (Checks.CHECKS) {
/* 385 */       Checks.check(__functionAddress);
/* 386 */       Checks.check(v, 1);
/*     */     } 
/* 388 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1dvARB(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") double[] v) {
/* 393 */     long __functionAddress = (GL.getICD()).glMultiTexCoord1dvARB;
/* 394 */     if (Checks.CHECKS) {
/* 395 */       Checks.check(__functionAddress);
/* 396 */       Checks.check(v, 1);
/*     */     } 
/* 398 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2fvARB(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") float[] v) {
/* 403 */     long __functionAddress = (GL.getICD()).glMultiTexCoord2fvARB;
/* 404 */     if (Checks.CHECKS) {
/* 405 */       Checks.check(__functionAddress);
/* 406 */       Checks.check(v, 2);
/*     */     } 
/* 408 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2svARB(@NativeType("GLenum") int texture, @NativeType("GLshort const *") short[] v) {
/* 413 */     long __functionAddress = (GL.getICD()).glMultiTexCoord2svARB;
/* 414 */     if (Checks.CHECKS) {
/* 415 */       Checks.check(__functionAddress);
/* 416 */       Checks.check(v, 2);
/*     */     } 
/* 418 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2ivARB(@NativeType("GLenum") int texture, @NativeType("GLint const *") int[] v) {
/* 423 */     long __functionAddress = (GL.getICD()).glMultiTexCoord2ivARB;
/* 424 */     if (Checks.CHECKS) {
/* 425 */       Checks.check(__functionAddress);
/* 426 */       Checks.check(v, 2);
/*     */     } 
/* 428 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2dvARB(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") double[] v) {
/* 433 */     long __functionAddress = (GL.getICD()).glMultiTexCoord2dvARB;
/* 434 */     if (Checks.CHECKS) {
/* 435 */       Checks.check(__functionAddress);
/* 436 */       Checks.check(v, 2);
/*     */     } 
/* 438 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3fvARB(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") float[] v) {
/* 443 */     long __functionAddress = (GL.getICD()).glMultiTexCoord3fvARB;
/* 444 */     if (Checks.CHECKS) {
/* 445 */       Checks.check(__functionAddress);
/* 446 */       Checks.check(v, 3);
/*     */     } 
/* 448 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3svARB(@NativeType("GLenum") int texture, @NativeType("GLshort const *") short[] v) {
/* 453 */     long __functionAddress = (GL.getICD()).glMultiTexCoord3svARB;
/* 454 */     if (Checks.CHECKS) {
/* 455 */       Checks.check(__functionAddress);
/* 456 */       Checks.check(v, 3);
/*     */     } 
/* 458 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3ivARB(@NativeType("GLenum") int texture, @NativeType("GLint const *") int[] v) {
/* 463 */     long __functionAddress = (GL.getICD()).glMultiTexCoord3ivARB;
/* 464 */     if (Checks.CHECKS) {
/* 465 */       Checks.check(__functionAddress);
/* 466 */       Checks.check(v, 3);
/*     */     } 
/* 468 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3dvARB(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") double[] v) {
/* 473 */     long __functionAddress = (GL.getICD()).glMultiTexCoord3dvARB;
/* 474 */     if (Checks.CHECKS) {
/* 475 */       Checks.check(__functionAddress);
/* 476 */       Checks.check(v, 3);
/*     */     } 
/* 478 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4fvARB(@NativeType("GLenum") int texture, @NativeType("GLfloat const *") float[] v) {
/* 483 */     long __functionAddress = (GL.getICD()).glMultiTexCoord4fvARB;
/* 484 */     if (Checks.CHECKS) {
/* 485 */       Checks.check(__functionAddress);
/* 486 */       Checks.check(v, 4);
/*     */     } 
/* 488 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4svARB(@NativeType("GLenum") int texture, @NativeType("GLshort const *") short[] v) {
/* 493 */     long __functionAddress = (GL.getICD()).glMultiTexCoord4svARB;
/* 494 */     if (Checks.CHECKS) {
/* 495 */       Checks.check(__functionAddress);
/* 496 */       Checks.check(v, 4);
/*     */     } 
/* 498 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4ivARB(@NativeType("GLenum") int texture, @NativeType("GLint const *") int[] v) {
/* 503 */     long __functionAddress = (GL.getICD()).glMultiTexCoord4ivARB;
/* 504 */     if (Checks.CHECKS) {
/* 505 */       Checks.check(__functionAddress);
/* 506 */       Checks.check(v, 4);
/*     */     } 
/* 508 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4dvARB(@NativeType("GLenum") int texture, @NativeType("GLdouble const *") double[] v) {
/* 513 */     long __functionAddress = (GL.getICD()).glMultiTexCoord4dvARB;
/* 514 */     if (Checks.CHECKS) {
/* 515 */       Checks.check(__functionAddress);
/* 516 */       Checks.check(v, 4);
/*     */     } 
/* 518 */     JNI.callPV(texture, v, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glActiveTextureARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glClientActiveTextureARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glMultiTexCoord1fARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void glMultiTexCoord1sARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort);
/*     */   
/*     */   public static native void glMultiTexCoord1iARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void glMultiTexCoord1dARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void nglMultiTexCoord1fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord1svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord1ivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord1dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord2fARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */   
/*     */   public static native void glMultiTexCoord2sARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*     */   
/*     */   public static native void glMultiTexCoord2iARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glMultiTexCoord2dARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void nglMultiTexCoord2fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord2svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord2ivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord2dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord3fARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glMultiTexCoord3sARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glMultiTexCoord3iARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glMultiTexCoord3dARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void nglMultiTexCoord3fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord3svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord3ivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord3dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord4fARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*     */   
/*     */   public static native void glMultiTexCoord4sARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*     */   
/*     */   public static native void glMultiTexCoord4iARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void glMultiTexCoord4dARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*     */   
/*     */   public static native void nglMultiTexCoord4fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord4svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord4ivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord4dvARB(int paramInt, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBMultitexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */