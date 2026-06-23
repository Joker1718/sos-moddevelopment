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
/*     */ public class ARBClearTexture
/*     */ {
/*     */   public static final int GL_CLEAR_TEXTURE = 37733;
/*     */   
/*     */   static {
/*  16 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   protected ARBClearTexture() {
/*  21 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long data) {
/*  28 */     GL44C.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  33 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  38 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  43 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  48 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer data) {
/*  53 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglClearTexImage(int texture, int level, int format, int type, long data) {
/*  60 */     GL44C.nglClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  65 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  70 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  75 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  80 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer data) {
/*  85 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/*  90 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/*  95 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 100 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] data) {
/* 105 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 110 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 115 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 120 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] data) {
/* 125 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBClearTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */