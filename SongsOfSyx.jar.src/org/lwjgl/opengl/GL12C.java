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
/*     */ public class GL12C extends GL11C {
/*     */   public static final int GL_ALIASED_LINE_WIDTH_RANGE = 33902;
/*     */   public static final int GL_SMOOTH_POINT_SIZE_RANGE = 2834;
/*     */   public static final int GL_SMOOTH_POINT_SIZE_GRANULARITY = 2835;
/*     */   public static final int GL_SMOOTH_LINE_WIDTH_RANGE = 2850;
/*     */   
/*     */   static {
/*  20 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_SMOOTH_LINE_WIDTH_GRANULARITY = 2851;
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_3D = 32874;
/*     */   
/*     */   public static final int GL_PACK_SKIP_IMAGES = 32875;
/*     */   
/*     */   public static final int GL_PACK_IMAGE_HEIGHT = 32876;
/*     */   
/*     */   public static final int GL_UNPACK_SKIP_IMAGES = 32877;
/*     */   
/*     */   public static final int GL_UNPACK_IMAGE_HEIGHT = 32878;
/*     */   
/*     */   public static final int GL_TEXTURE_3D = 32879;
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_3D = 32880;
/*     */   
/*     */   public static final int GL_TEXTURE_DEPTH = 32881;
/*     */   
/*     */   public static final int GL_TEXTURE_WRAP_R = 32882;
/*     */   
/*     */   public static final int GL_MAX_3D_TEXTURE_SIZE = 32883;
/*     */   
/*     */   public static final int GL_BGR = 32992;
/*     */   
/*     */   public static final int GL_BGRA = 32993;
/*     */   
/*     */   public static final int GL_UNSIGNED_BYTE_3_3_2 = 32818;
/*     */   
/*     */   public static final int GL_UNSIGNED_BYTE_2_3_3_REV = 33634;
/*     */   
/*     */   public static final int GL_UNSIGNED_SHORT_5_6_5 = 33635;
/*     */   
/*     */   public static final int GL_UNSIGNED_SHORT_5_6_5_REV = 33636;
/*     */   
/*     */   public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 32819;
/*     */   
/*     */   public static final int GL_UNSIGNED_SHORT_4_4_4_4_REV = 33637;
/*     */   
/*     */   public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 32820;
/*     */   
/*     */   public static final int GL_UNSIGNED_SHORT_1_5_5_5_REV = 33638;
/*     */   public static final int GL_UNSIGNED_INT_8_8_8_8 = 32821;
/*     */   public static final int GL_UNSIGNED_INT_8_8_8_8_REV = 33639;
/*     */   public static final int GL_UNSIGNED_INT_10_10_10_2 = 32822;
/*     */   public static final int GL_UNSIGNED_INT_2_10_10_10_REV = 33640;
/*     */   public static final int GL_CLAMP_TO_EDGE = 33071;
/*     */   public static final int GL_TEXTURE_MIN_LOD = 33082;
/*     */   public static final int GL_TEXTURE_MAX_LOD = 33083;
/*     */   public static final int GL_TEXTURE_BASE_LEVEL = 33084;
/*     */   public static final int GL_TEXTURE_MAX_LEVEL = 33085;
/*     */   public static final int GL_MAX_ELEMENTS_VERTICES = 33000;
/*     */   public static final int GL_MAX_ELEMENTS_INDICES = 33001;
/*     */   
/*     */   protected GL12C() {
/*  78 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  88 */     nglTexImage3D(target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  93 */     nglTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  98 */     nglTexImage3D(target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 103 */     nglTexImage3D(target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 108 */     nglTexImage3D(target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 113 */     nglTexImage3D(target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/* 123 */     nglTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/* 128 */     nglTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/* 133 */     nglTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 138 */     nglTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 143 */     nglTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 148 */     nglTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
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
/*     */   public static void glDrawRangeElements(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices) {
/* 163 */     nglDrawRangeElements(mode, start, end, count, type, indices);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElements(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices) {
/* 168 */     nglDrawRangeElements(mode, start, end, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElements(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") ByteBuffer indices) {
/* 173 */     nglDrawRangeElements(mode, start, end, indices.remaining(), 5121, MemoryUtil.memAddress(indices));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElements(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") ShortBuffer indices) {
/* 178 */     nglDrawRangeElements(mode, start, end, indices.remaining(), 5123, MemoryUtil.memAddress(indices));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElements(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") IntBuffer indices) {
/* 183 */     nglDrawRangeElements(mode, start, end, indices.remaining(), 5125, MemoryUtil.memAddress(indices));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 188 */     long __functionAddress = (GL.getICD()).glTexImage3D;
/* 189 */     if (Checks.CHECKS) {
/* 190 */       Checks.check(__functionAddress);
/*     */     }
/* 192 */     JNI.callPV(target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 197 */     long __functionAddress = (GL.getICD()).glTexImage3D;
/* 198 */     if (Checks.CHECKS) {
/* 199 */       Checks.check(__functionAddress);
/*     */     }
/* 201 */     JNI.callPV(target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 206 */     long __functionAddress = (GL.getICD()).glTexImage3D;
/* 207 */     if (Checks.CHECKS) {
/* 208 */       Checks.check(__functionAddress);
/*     */     }
/* 210 */     JNI.callPV(target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 215 */     long __functionAddress = (GL.getICD()).glTexImage3D;
/* 216 */     if (Checks.CHECKS) {
/* 217 */       Checks.check(__functionAddress);
/*     */     }
/* 219 */     JNI.callPV(target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 224 */     long __functionAddress = (GL.getICD()).glTexSubImage3D;
/* 225 */     if (Checks.CHECKS) {
/* 226 */       Checks.check(__functionAddress);
/*     */     }
/* 228 */     JNI.callPV(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 233 */     long __functionAddress = (GL.getICD()).glTexSubImage3D;
/* 234 */     if (Checks.CHECKS) {
/* 235 */       Checks.check(__functionAddress);
/*     */     }
/* 237 */     JNI.callPV(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 242 */     long __functionAddress = (GL.getICD()).glTexSubImage3D;
/* 243 */     if (Checks.CHECKS) {
/* 244 */       Checks.check(__functionAddress);
/*     */     }
/* 246 */     JNI.callPV(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexSubImage3D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 251 */     long __functionAddress = (GL.getICD()).glTexSubImage3D;
/* 252 */     if (Checks.CHECKS) {
/* 253 */       Checks.check(__functionAddress);
/*     */     }
/* 255 */     JNI.callPV(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglTexImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*     */   
/*     */   public static native void nglTexSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*     */   
/*     */   public static native void glCopyTexSubImage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9);
/*     */   
/*     */   public static native void nglDrawRangeElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL12C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */