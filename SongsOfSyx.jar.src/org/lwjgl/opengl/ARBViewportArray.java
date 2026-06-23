/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBViewportArray {
/*     */   public static final int GL_MAX_VIEWPORTS = 33371;
/*     */   public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;
/*     */   public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
/*     */   
/*     */   static {
/*  14 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
/*     */   
/*     */   public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
/*     */   
/*     */   public static final int GL_UNDEFINED_VERTEX = 33376;
/*     */ 
/*     */   
/*     */   protected ARBViewportArray() {
/*  26 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglViewportArrayv(int first, int count, long v) {
/*  33 */     GL41C.nglViewportArrayv(first, count, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glViewportArrayv(@NativeType("GLuint") int first, @NativeType("GLfloat const *") FloatBuffer v) {
/*  38 */     GL41C.glViewportArrayv(first, v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glViewportIndexedf(@NativeType("GLuint") int index, @NativeType("GLfloat") float x, @NativeType("GLfloat") float y, @NativeType("GLfloat") float w, @NativeType("GLfloat") float h) {
/*  45 */     GL41C.glViewportIndexedf(index, x, y, w, h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglViewportIndexedfv(int index, long v) {
/*  52 */     GL41C.nglViewportIndexedfv(index, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glViewportIndexedfv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  57 */     GL41C.glViewportIndexedfv(index, v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglScissorArrayv(int first, int count, long v) {
/*  64 */     GL41C.nglScissorArrayv(first, count, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glScissorArrayv(@NativeType("GLuint") int first, @NativeType("GLint const *") IntBuffer v) {
/*  69 */     GL41C.glScissorArrayv(first, v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glScissorIndexed(@NativeType("GLuint") int index, @NativeType("GLint") int left, @NativeType("GLint") int bottom, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  76 */     GL41C.glScissorIndexed(index, left, bottom, width, height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglScissorIndexedv(int index, long v) {
/*  83 */     GL41C.nglScissorIndexedv(index, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glScissorIndexedv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  88 */     GL41C.glScissorIndexedv(index, v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDepthRangeArrayv(int first, int count, long v) {
/*  95 */     GL41C.nglDepthRangeArrayv(first, count, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDepthRangeArrayv(@NativeType("GLuint") int first, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 100 */     GL41C.glDepthRangeArrayv(first, v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDepthRangeIndexed(@NativeType("GLuint") int index, @NativeType("GLdouble") double zNear, @NativeType("GLdouble") double zFar) {
/* 107 */     GL41C.glDepthRangeIndexed(index, zNear, zFar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetFloati_v(int target, int index, long data) {
/* 114 */     GL41C.nglGetFloati_v(target, index, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFloati_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer data) {
/* 119 */     GL41C.glGetFloati_v(target, index, data);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetFloati(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 125 */     return GL41C.glGetFloati(target, index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetDoublei_v(int target, int index, long data) {
/* 132 */     GL41C.nglGetDoublei_v(target, index, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetDoublei_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") DoubleBuffer data) {
/* 137 */     GL41C.glGetDoublei_v(target, index, data);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static double glGetDoublei(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 143 */     return GL41C.glGetDoublei(target, index);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glViewportArrayv(@NativeType("GLuint") int first, @NativeType("GLfloat const *") float[] v) {
/* 148 */     GL41C.glViewportArrayv(first, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glViewportIndexedfv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 153 */     GL41C.glViewportIndexedfv(index, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glScissorArrayv(@NativeType("GLuint") int first, @NativeType("GLint const *") int[] v) {
/* 158 */     GL41C.glScissorArrayv(first, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glScissorIndexedv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 163 */     GL41C.glScissorIndexedv(index, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDepthRangeArrayv(@NativeType("GLuint") int first, @NativeType("GLdouble const *") double[] v) {
/* 168 */     GL41C.glDepthRangeArrayv(first, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFloati_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] data) {
/* 173 */     GL41C.glGetFloati_v(target, index, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetDoublei_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") double[] data) {
/* 178 */     GL41C.glGetDoublei_v(target, index, data);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBViewportArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */