/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBTextureCompression
/*     */ {
/*     */   public static final int GL_COMPRESSED_ALPHA_ARB = 34025;
/*     */   public static final int GL_COMPRESSED_LUMINANCE_ARB = 34026;
/*     */   public static final int GL_COMPRESSED_LUMINANCE_ALPHA_ARB = 34027;
/*     */   public static final int GL_COMPRESSED_INTENSITY_ARB = 34028;
/*     */   public static final int GL_COMPRESSED_RGB_ARB = 34029;
/*     */   
/*     */   static {
/*  17 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_COMPRESSED_RGBA_ARB = 34030;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_COMPRESSION_HINT_ARB = 34031;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE_ARB = 34464;
/*     */   
/*     */   public static final int GL_TEXTURE_COMPRESSED_ARB = 34465;
/*     */   
/*     */   public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS_ARB = 34466;
/*     */   
/*     */   public static final int GL_COMPRESSED_TEXTURE_FORMATS_ARB = 34467;
/*     */ 
/*     */   
/*     */   protected ARBTextureCompression() {
/*  38 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage3DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  48 */     nglCompressedTexImage3DARB(target, level, internalformat, width, height, depth, border, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage3DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void const *") ByteBuffer data) {
/*  53 */     nglCompressedTexImage3DARB(target, level, internalformat, width, height, depth, 0, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage2DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  63 */     nglCompressedTexImage2DARB(target, level, internalformat, width, height, border, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage2DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("void const *") ByteBuffer data) {
/*  68 */     nglCompressedTexImage2DARB(target, level, internalformat, width, height, 0, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage1DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  78 */     nglCompressedTexImage1DARB(target, level, internalformat, width, border, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexImage1DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("void const *") ByteBuffer data) {
/*  83 */     nglCompressedTexImage1DARB(target, level, internalformat, width, 0, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage3DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  93 */     nglCompressedTexSubImage3DARB(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage3DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/*  98 */     nglCompressedTexSubImage3DARB(target, level, xoffset, yoffset, zoffset, width, height, depth, format, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage2DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 108 */     nglCompressedTexSubImage2DARB(target, level, xoffset, yoffset, width, height, format, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage2DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 113 */     nglCompressedTexSubImage2DARB(target, level, xoffset, yoffset, width, height, format, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage1DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 123 */     nglCompressedTexSubImage1DARB(target, level, xoffset, width, format, imageSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompressedTexSubImage1DARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 128 */     nglCompressedTexSubImage1DARB(target, level, xoffset, width, format, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTexImageARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer pixels) {
/* 138 */     if (Checks.CHECKS && 
/* 139 */       Checks.DEBUG) {
/* 140 */       Checks.check(pixels, GL11.glGetTexLevelParameteri(target, level, 34464));
/*     */     }
/*     */     
/* 143 */     nglGetCompressedTexImageARB(target, level, MemoryUtil.memAddress(pixels));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTexImageARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") long pixels) {
/* 148 */     nglGetCompressedTexImageARB(target, level, pixels);
/*     */   }
/*     */   
/*     */   public static native void nglCompressedTexImage3DARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexImage2DARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexImage1DARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexSubImage3DARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexSubImage2DARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexSubImage1DARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*     */   
/*     */   public static native void nglGetCompressedTexImageARB(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTextureCompression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */