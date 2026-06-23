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
/*     */ public class EXTSecondaryColor
/*     */ {
/*     */   public static final int GL_COLOR_SUM_EXT = 33880;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_CURRENT_SECONDARY_COLOR_EXT = 33881;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_SIZE_EXT = 33882;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_TYPE_EXT = 33883;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE_EXT = 33884;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_POINTER_EXT = 33885;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_EXT = 33886;
/*     */   
/*     */   protected EXTSecondaryColor() {
/*  33 */     throw new UnsupportedOperationException();
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
/*     */   public static void glSecondaryColor3bvEXT(@NativeType("GLbyte const *") ByteBuffer v) {
/*  83 */     if (Checks.CHECKS) {
/*  84 */       Checks.check(v, 3);
/*     */     }
/*  86 */     nglSecondaryColor3bvEXT(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3svEXT(@NativeType("GLshort const *") ShortBuffer v) {
/*  96 */     if (Checks.CHECKS) {
/*  97 */       Checks.check(v, 3);
/*     */     }
/*  99 */     nglSecondaryColor3svEXT(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3ivEXT(@NativeType("GLint const *") IntBuffer v) {
/* 109 */     if (Checks.CHECKS) {
/* 110 */       Checks.check(v, 3);
/*     */     }
/* 112 */     nglSecondaryColor3ivEXT(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3fvEXT(@NativeType("GLfloat const *") FloatBuffer v) {
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.check(v, 3);
/*     */     }
/* 125 */     nglSecondaryColor3fvEXT(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3dvEXT(@NativeType("GLdouble const *") DoubleBuffer v) {
/* 135 */     if (Checks.CHECKS) {
/* 136 */       Checks.check(v, 3);
/*     */     }
/* 138 */     nglSecondaryColor3dvEXT(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3ubvEXT(@NativeType("GLubyte const *") ByteBuffer v) {
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.check(v, 3);
/*     */     }
/* 151 */     nglSecondaryColor3ubvEXT(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3usvEXT(@NativeType("GLushort const *") ShortBuffer v) {
/* 161 */     if (Checks.CHECKS) {
/* 162 */       Checks.check(v, 3);
/*     */     }
/* 164 */     nglSecondaryColor3usvEXT(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3uivEXT(@NativeType("GLuint const *") IntBuffer v) {
/* 174 */     if (Checks.CHECKS) {
/* 175 */       Checks.check(v, 3);
/*     */     }
/* 177 */     nglSecondaryColor3uivEXT(MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 187 */     nglSecondaryColorPointerEXT(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 192 */     nglSecondaryColorPointerEXT(size, type, stride, pointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 197 */     nglSecondaryColorPointerEXT(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 202 */     nglSecondaryColorPointerEXT(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 207 */     nglSecondaryColorPointerEXT(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3svEXT(@NativeType("GLshort const *") short[] v) {
/* 212 */     long __functionAddress = (GL.getICD()).glSecondaryColor3svEXT;
/* 213 */     if (Checks.CHECKS) {
/* 214 */       Checks.check(__functionAddress);
/* 215 */       Checks.check(v, 3);
/*     */     } 
/* 217 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3ivEXT(@NativeType("GLint const *") int[] v) {
/* 222 */     long __functionAddress = (GL.getICD()).glSecondaryColor3ivEXT;
/* 223 */     if (Checks.CHECKS) {
/* 224 */       Checks.check(__functionAddress);
/* 225 */       Checks.check(v, 3);
/*     */     } 
/* 227 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3fvEXT(@NativeType("GLfloat const *") float[] v) {
/* 232 */     long __functionAddress = (GL.getICD()).glSecondaryColor3fvEXT;
/* 233 */     if (Checks.CHECKS) {
/* 234 */       Checks.check(__functionAddress);
/* 235 */       Checks.check(v, 3);
/*     */     } 
/* 237 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3dvEXT(@NativeType("GLdouble const *") double[] v) {
/* 242 */     long __functionAddress = (GL.getICD()).glSecondaryColor3dvEXT;
/* 243 */     if (Checks.CHECKS) {
/* 244 */       Checks.check(__functionAddress);
/* 245 */       Checks.check(v, 3);
/*     */     } 
/* 247 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3usvEXT(@NativeType("GLushort const *") short[] v) {
/* 252 */     long __functionAddress = (GL.getICD()).glSecondaryColor3usvEXT;
/* 253 */     if (Checks.CHECKS) {
/* 254 */       Checks.check(__functionAddress);
/* 255 */       Checks.check(v, 3);
/*     */     } 
/* 257 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3uivEXT(@NativeType("GLuint const *") int[] v) {
/* 262 */     long __functionAddress = (GL.getICD()).glSecondaryColor3uivEXT;
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.check(__functionAddress);
/* 265 */       Checks.check(v, 3);
/*     */     } 
/* 267 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") short[] pointer) {
/* 272 */     long __functionAddress = (GL.getICD()).glSecondaryColorPointerEXT;
/* 273 */     if (Checks.CHECKS) {
/* 274 */       Checks.check(__functionAddress);
/*     */     }
/* 276 */     JNI.callPV(size, type, stride, pointer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") int[] pointer) {
/* 281 */     long __functionAddress = (GL.getICD()).glSecondaryColorPointerEXT;
/* 282 */     if (Checks.CHECKS) {
/* 283 */       Checks.check(__functionAddress);
/*     */     }
/* 285 */     JNI.callPV(size, type, stride, pointer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") float[] pointer) {
/* 290 */     long __functionAddress = (GL.getICD()).glSecondaryColorPointerEXT;
/* 291 */     if (Checks.CHECKS) {
/* 292 */       Checks.check(__functionAddress);
/*     */     }
/* 294 */     JNI.callPV(size, type, stride, pointer, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glSecondaryColor3bEXT(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3);
/*     */   
/*     */   public static native void glSecondaryColor3sEXT(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glSecondaryColor3iEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glSecondaryColor3fEXT(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glSecondaryColor3dEXT(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void glSecondaryColor3ubEXT(@NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3);
/*     */   
/*     */   public static native void glSecondaryColor3usEXT(@NativeType("GLushort") short paramShort1, @NativeType("GLushort") short paramShort2, @NativeType("GLushort") short paramShort3);
/*     */   
/*     */   public static native void glSecondaryColor3uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void nglSecondaryColor3bvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3svEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3ivEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3fvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3dvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3ubvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3usvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3uivEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColorPointerEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTSecondaryColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */