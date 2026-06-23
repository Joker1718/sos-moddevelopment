/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class KHRRobustness {
/*     */   public static final int GL_NO_ERROR = 0;
/*     */   public static final int GL_GUILTY_CONTEXT_RESET = 33363;
/*     */   
/*     */   static {
/*  14 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
/*     */   
/*     */   public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;
/*     */   
/*     */   public static final int GL_CONTEXT_ROBUST_ACCESS = 37107;
/*     */   
/*     */   public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
/*     */   
/*     */   public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
/*     */   
/*     */   public static final int GL_NO_RESET_NOTIFICATION = 33377;
/*     */   
/*     */   public static final int GL_CONTEXT_LOST = 1287;
/*     */   
/*     */   protected KHRRobustness() {
/*  33 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLenum")
/*     */   public static int glGetGraphicsResetStatus() {
/*  41 */     return GL45C.glGetGraphicsResetStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, long pixels) {
/*  48 */     GL45C.nglReadnPixels(x, y, width, height, format, type, bufSize, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/*  53 */     GL45C.glReadnPixels(x, y, width, height, format, type, bufSize, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/*  58 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/*  63 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/*  68 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/*  73 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetnUniformfv(int program, int location, int bufSize, long params) {
/*  80 */     GL45C.nglGetnUniformfv(program, location, bufSize, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") FloatBuffer params) {
/*  85 */     GL45C.glGetnUniformfv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetnUniformf(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/*  91 */     return GL45C.glGetnUniformf(program, location);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetnUniformiv(int program, int location, int bufSize, long params) {
/*  98 */     GL45C.nglGetnUniformiv(program, location, bufSize, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") IntBuffer params) {
/* 103 */     GL45C.glGetnUniformiv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetnUniformi(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 109 */     return GL45C.glGetnUniformi(program, location);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetnUniformuiv(int program, int location, int bufSize, long params) {
/* 116 */     GL45C.nglGetnUniformuiv(program, location, bufSize, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformuiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") IntBuffer params) {
/* 121 */     GL45C.glGetnUniformuiv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetnUniformui(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 127 */     return GL45C.glGetnUniformui(program, location);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 132 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 137 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 142 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") float[] params) {
/* 147 */     GL45C.glGetnUniformfv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") int[] params) {
/* 152 */     GL45C.glGetnUniformiv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformuiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") int[] params) {
/* 157 */     GL45C.glGetnUniformuiv(program, location, params);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\KHRRobustness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */