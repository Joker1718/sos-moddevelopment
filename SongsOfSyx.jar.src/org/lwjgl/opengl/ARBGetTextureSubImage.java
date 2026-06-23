/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class ARBGetTextureSubImage
/*     */ {
/*     */   static {
/*  14 */     GL.initialize();
/*     */   }
/*     */   protected ARBGetTextureSubImage() {
/*  17 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, long pixels) {
/*  24 */     GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/*  29 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/*  34 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/*  39 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/*  44 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/*  49 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/*  54 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, long pixels) {
/*  61 */     GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/*  66 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") ByteBuffer pixels) {
/*  71 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") ShortBuffer pixels) {
/*  76 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") IntBuffer pixels) {
/*  81 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") FloatBuffer pixels) {
/*  86 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") DoubleBuffer pixels) {
/*  91 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/*  96 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 101 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 106 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 111 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") short[] pixels) {
/* 116 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") int[] pixels) {
/* 121 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") float[] pixels) {
/* 126 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") double[] pixels) {
/* 131 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBGetTextureSubImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */