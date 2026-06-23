/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class EXTDirectStateAccess
/*      */ {
/*      */   public static final int GL_PROGRAM_MATRIX_EXT = 36397;
/*      */   public static final int GL_TRANSPOSE_PROGRAM_MATRIX_EXT = 36398;
/*      */   public static final int GL_PROGRAM_MATRIX_STACK_DEPTH_EXT = 36399;
/*      */   
/*      */   static {
/*   24 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected EXTDirectStateAccess() {
/*   32 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadfEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/*   52 */     if (Checks.CHECKS) {
/*   53 */       Checks.check(m, 16);
/*      */     }
/*   55 */     nglMatrixLoadfEXT(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoaddEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLdouble const *") DoubleBuffer m) {
/*   65 */     if (Checks.CHECKS) {
/*   66 */       Checks.check(m, 16);
/*      */     }
/*   68 */     nglMatrixLoaddEXT(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultfEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/*   78 */     if (Checks.CHECKS) {
/*   79 */       Checks.check(m, 16);
/*      */     }
/*   81 */     nglMatrixMultfEXT(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultdEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLdouble const *") DoubleBuffer m) {
/*   91 */     if (Checks.CHECKS) {
/*   92 */       Checks.check(m, 16);
/*      */     }
/*   94 */     nglMatrixMultdEXT(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer param) {
/*  164 */     if (Checks.CHECKS) {
/*  165 */       Checks.check(param, 4);
/*      */     }
/*  167 */     nglTextureParameterivEXT(texture, target, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfvEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer param) {
/*  182 */     if (Checks.CHECKS) {
/*  183 */       Checks.check(param, 4);
/*      */     }
/*  185 */     nglTextureParameterfvEXT(texture, target, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  195 */     nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  200 */     nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  205 */     nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  210 */     nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  215 */     nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  220 */     nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  230 */     nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  235 */     nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  240 */     nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  245 */     nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  250 */     nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  255 */     nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  265 */     nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  270 */     nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  275 */     nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  280 */     nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  285 */     nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  290 */     nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  300 */     nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  305 */     nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  310 */     nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  315 */     nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  320 */     nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  325 */     nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/*  355 */     nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long pixels) {
/*  360 */     nglGetTextureImageEXT(texture, target, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/*  365 */     nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/*  370 */     nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/*  375 */     nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/*  380 */     nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfvEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/*  390 */     if (Checks.CHECKS) {
/*  391 */       Checks.check(params, 1);
/*      */     }
/*  393 */     nglGetTextureParameterfvEXT(texture, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureParameterfEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  399 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  401 */       FloatBuffer params = stack.callocFloat(1);
/*  402 */       nglGetTextureParameterfvEXT(texture, target, pname, MemoryUtil.memAddress(params));
/*  403 */       return params.get(0);
/*      */     } finally {
/*  405 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  416 */     if (Checks.CHECKS) {
/*  417 */       Checks.check(params, 1);
/*      */     }
/*  419 */     nglGetTextureParameterivEXT(texture, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameteriEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  425 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  427 */       IntBuffer params = stack.callocInt(1);
/*  428 */       nglGetTextureParameterivEXT(texture, target, pname, MemoryUtil.memAddress(params));
/*  429 */       return params.get(0);
/*      */     } finally {
/*  431 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfvEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/*  442 */     if (Checks.CHECKS) {
/*  443 */       Checks.check(params, 1);
/*      */     }
/*  445 */     nglGetTextureLevelParameterfvEXT(texture, target, level, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureLevelParameterfEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/*  451 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  453 */       FloatBuffer params = stack.callocFloat(1);
/*  454 */       nglGetTextureLevelParameterfvEXT(texture, target, level, pname, MemoryUtil.memAddress(params));
/*  455 */       return params.get(0);
/*      */     } finally {
/*  457 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  468 */     if (Checks.CHECKS) {
/*  469 */       Checks.check(params, 1);
/*      */     }
/*  471 */     nglGetTextureLevelParameterivEXT(texture, target, level, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureLevelParameteriEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/*  477 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  479 */       IntBuffer params = stack.callocInt(1);
/*  480 */       nglGetTextureLevelParameterivEXT(texture, target, level, pname, MemoryUtil.memAddress(params));
/*  481 */       return params.get(0);
/*      */     } finally {
/*  483 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  494 */     nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  499 */     nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  504 */     nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  509 */     nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  514 */     nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  519 */     nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  529 */     nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  534 */     nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  539 */     nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  544 */     nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  549 */     nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  554 */     nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int texunit, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/*  574 */     nglMultiTexCoordPointerEXT(texunit, size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int texunit, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/*  579 */     nglMultiTexCoordPointerEXT(texunit, size, type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int texunit, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/*  584 */     nglMultiTexCoordPointerEXT(texunit, size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int texunit, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/*  589 */     nglMultiTexCoordPointerEXT(texunit, size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int texunit, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/*  594 */     nglMultiTexCoordPointerEXT(texunit, size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexEnvfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/*  609 */     if (Checks.CHECKS) {
/*  610 */       Checks.check(params, 4);
/*      */     }
/*  612 */     nglMultiTexEnvfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexEnvivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/*  627 */     if (Checks.CHECKS) {
/*  628 */       Checks.check(params, 4);
/*      */     }
/*  630 */     nglMultiTexEnvivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexGendvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLdouble const *") DoubleBuffer params) {
/*  645 */     if (Checks.CHECKS) {
/*  646 */       Checks.check(params, 4);
/*      */     }
/*  648 */     nglMultiTexGendvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexGenfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/*  663 */     if (Checks.CHECKS) {
/*  664 */       Checks.check(params, 4);
/*      */     }
/*  666 */     nglMultiTexGenfvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexGenivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/*  681 */     if (Checks.CHECKS) {
/*  682 */       Checks.check(params, 4);
/*      */     }
/*  684 */     nglMultiTexGenivEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexEnvfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/*  694 */     if (Checks.CHECKS) {
/*  695 */       Checks.check(params, 1);
/*      */     }
/*  697 */     nglGetMultiTexEnvfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetMultiTexEnvfEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  703 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  705 */       FloatBuffer params = stack.callocFloat(1);
/*  706 */       nglGetMultiTexEnvfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*  707 */       return params.get(0);
/*      */     } finally {
/*  709 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexEnvivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  720 */     if (Checks.CHECKS) {
/*  721 */       Checks.check(params, 1);
/*      */     }
/*  723 */     nglGetMultiTexEnvivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexEnviEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  729 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  731 */       IntBuffer params = stack.callocInt(1);
/*  732 */       nglGetMultiTexEnvivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*  733 */       return params.get(0);
/*      */     } finally {
/*  735 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGendvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/*  746 */     if (Checks.CHECKS) {
/*  747 */       Checks.check(params, 1);
/*      */     }
/*  749 */     nglGetMultiTexGendvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetMultiTexGendEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname) {
/*  755 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  757 */       DoubleBuffer params = stack.callocDouble(1);
/*  758 */       nglGetMultiTexGendvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
/*  759 */       return params.get(0);
/*      */     } finally {
/*  761 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGenfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/*  772 */     if (Checks.CHECKS) {
/*  773 */       Checks.check(params, 1);
/*      */     }
/*  775 */     nglGetMultiTexGenfvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetMultiTexGenfEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname) {
/*  781 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  783 */       FloatBuffer params = stack.callocFloat(1);
/*  784 */       nglGetMultiTexGenfvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
/*  785 */       return params.get(0);
/*      */     } finally {
/*  787 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGenivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  798 */     if (Checks.CHECKS) {
/*  799 */       Checks.check(params, 1);
/*      */     }
/*  801 */     nglGetMultiTexGenivEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexGeniEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname) {
/*  807 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  809 */       IntBuffer params = stack.callocInt(1);
/*  810 */       nglGetMultiTexGenivEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
/*  811 */       return params.get(0);
/*      */     } finally {
/*  813 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer param) {
/*  829 */     if (Checks.CHECKS) {
/*  830 */       Checks.check(param, 4);
/*      */     }
/*  832 */     nglMultiTexParameterivEXT(texunit, target, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer param) {
/*  847 */     if (Checks.CHECKS) {
/*  848 */       Checks.check(param, 4);
/*      */     }
/*  850 */     nglMultiTexParameterfvEXT(texunit, target, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  860 */     nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  865 */     nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  870 */     nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  875 */     nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  880 */     nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  885 */     nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  895 */     nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  900 */     nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  905 */     nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  910 */     nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  915 */     nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  920 */     nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  930 */     nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  935 */     nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  940 */     nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  945 */     nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  950 */     nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  955 */     nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  965 */     nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  970 */     nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  975 */     nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  980 */     nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  985 */     nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  990 */     nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 1020 */     nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long pixels) {
/* 1025 */     nglGetMultiTexImageEXT(texunit, target, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 1030 */     nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 1035 */     nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 1040 */     nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/* 1045 */     nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1055 */     if (Checks.CHECKS) {
/* 1056 */       Checks.check(params, 1);
/*      */     }
/* 1058 */     nglGetMultiTexParameterfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetMultiTexParameterfEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 1064 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1066 */       FloatBuffer params = stack.callocFloat(1);
/* 1067 */       nglGetMultiTexParameterfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/* 1068 */       return params.get(0);
/*      */     } finally {
/* 1070 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1081 */     if (Checks.CHECKS) {
/* 1082 */       Checks.check(params, 1);
/*      */     }
/* 1084 */     nglGetMultiTexParameterivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexParameteriEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 1090 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1092 */       IntBuffer params = stack.callocInt(1);
/* 1093 */       nglGetMultiTexParameterivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/* 1094 */       return params.get(0);
/*      */     } finally {
/* 1096 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexLevelParameterfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1107 */     if (Checks.CHECKS) {
/* 1108 */       Checks.check(params, 1);
/*      */     }
/* 1110 */     nglGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetMultiTexLevelParameterfEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 1116 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1118 */       FloatBuffer params = stack.callocFloat(1);
/* 1119 */       nglGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, MemoryUtil.memAddress(params));
/* 1120 */       return params.get(0);
/*      */     } finally {
/* 1122 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexLevelParameterivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1133 */     if (Checks.CHECKS) {
/* 1134 */       Checks.check(params, 1);
/*      */     }
/* 1136 */     nglGetMultiTexLevelParameterivEXT(texunit, target, level, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexLevelParameteriEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 1142 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1144 */       IntBuffer params = stack.callocInt(1);
/* 1145 */       nglGetMultiTexLevelParameterivEXT(texunit, target, level, pname, MemoryUtil.memAddress(params));
/* 1146 */       return params.get(0);
/*      */     } finally {
/* 1148 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/* 1159 */     nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/* 1164 */     nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/* 1169 */     nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 1174 */     nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 1179 */     nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 1184 */     nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/* 1194 */     nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/* 1199 */     nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/* 1204 */     nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 1209 */     nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 1214 */     nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 1219 */     nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFloatIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer params) {
/* 1254 */     if (Checks.CHECKS) {
/* 1255 */       Checks.check(params, 1);
/*      */     }
/* 1257 */     nglGetFloatIndexedvEXT(target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetFloatIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1263 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1265 */       FloatBuffer params = stack.callocFloat(1);
/* 1266 */       nglGetFloatIndexedvEXT(target, index, MemoryUtil.memAddress(params));
/* 1267 */       return params.get(0);
/*      */     } finally {
/* 1269 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoubleIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") DoubleBuffer params) {
/* 1280 */     if (Checks.CHECKS) {
/* 1281 */       Checks.check(params, 1);
/*      */     }
/* 1283 */     nglGetDoubleIndexedvEXT(target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetDoubleIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1289 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1291 */       DoubleBuffer params = stack.callocDouble(1);
/* 1292 */       nglGetDoubleIndexedvEXT(target, index, MemoryUtil.memAddress(params));
/* 1293 */       return params.get(0);
/*      */     } finally {
/* 1295 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPointerIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("void **") PointerBuffer params) {
/* 1306 */     if (Checks.CHECKS) {
/* 1307 */       Checks.check((CustomBuffer)params, 1);
/*      */     }
/* 1309 */     nglGetPointerIndexedvEXT(target, index, MemoryUtil.memAddress((CustomBuffer)params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetPointerIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1315 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1317 */       PointerBuffer params = stack.callocPointer(1);
/* 1318 */       nglGetPointerIndexedvEXT(target, index, MemoryUtil.memAddress((CustomBuffer)params));
/* 1319 */       return params.get(0);
/*      */     } finally {
/* 1321 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFloati_vEXT(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer params) {
/* 1332 */     if (Checks.CHECKS) {
/* 1333 */       Checks.check(params, 1);
/*      */     }
/* 1335 */     nglGetFloati_vEXT(pname, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetFloatiEXT(@NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/* 1341 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1343 */       FloatBuffer params = stack.callocFloat(1);
/* 1344 */       nglGetFloati_vEXT(pname, index, MemoryUtil.memAddress(params));
/* 1345 */       return params.get(0);
/*      */     } finally {
/* 1347 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_vEXT(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLdouble *") DoubleBuffer params) {
/* 1358 */     if (Checks.CHECKS) {
/* 1359 */       Checks.check(params, 1);
/*      */     }
/* 1361 */     nglGetDoublei_vEXT(pname, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetDoubleiEXT(@NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/* 1367 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1369 */       DoubleBuffer params = stack.callocDouble(1);
/* 1370 */       nglGetDoublei_vEXT(pname, index, MemoryUtil.memAddress(params));
/* 1371 */       return params.get(0);
/*      */     } finally {
/* 1373 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPointeri_vEXT(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("void **") PointerBuffer params) {
/* 1384 */     if (Checks.CHECKS) {
/* 1385 */       Checks.check((CustomBuffer)params, 1);
/*      */     }
/* 1387 */     nglGetPointeri_vEXT(pname, index, MemoryUtil.memAddress((CustomBuffer)params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetPointeriEXT(@NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/* 1393 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1395 */       PointerBuffer params = stack.callocPointer(1);
/* 1396 */       nglGetPointeri_vEXT(pname, index, MemoryUtil.memAddress((CustomBuffer)params));
/* 1397 */       return params.get(0);
/*      */     } finally {
/* 1399 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnableIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1407 */     EXTDrawBuffers2.glEnableIndexedEXT(target, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisableIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1414 */     EXTDrawBuffers2.glDisableIndexedEXT(target, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsEnabledIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1422 */     return EXTDrawBuffers2.glIsEnabledIndexedEXT(target, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetIntegerIndexedvEXT(int target, int index, long data) {
/* 1429 */     EXTDrawBuffers2.nglGetIntegerIndexedvEXT(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer data) {
/* 1434 */     EXTDrawBuffers2.glGetIntegerIndexedvEXT(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetIntegerIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1440 */     return EXTDrawBuffers2.glGetIntegerIndexedEXT(target, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetBooleanIndexedvEXT(int target, int index, long data) {
/* 1447 */     EXTDrawBuffers2.nglGetBooleanIndexedvEXT(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetBooleanIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLboolean *") ByteBuffer data) {
/* 1452 */     EXTDrawBuffers2.glGetBooleanIndexedvEXT(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static boolean glGetBooleanIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1458 */     return EXTDrawBuffers2.glGetBooleanIndexedEXT(target, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramStringEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer string) {
/* 1468 */     nglNamedProgramStringEXT(program, target, format, string.remaining(), MemoryUtil.memAddress(string));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameter4dvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer params) {
/* 1483 */     if (Checks.CHECKS) {
/* 1484 */       Checks.check(params, 4);
/*      */     }
/* 1486 */     nglNamedProgramLocalParameter4dvEXT(program, target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameter4fvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer params) {
/* 1501 */     if (Checks.CHECKS) {
/* 1502 */       Checks.check(params, 4);
/*      */     }
/* 1504 */     nglNamedProgramLocalParameter4fvEXT(program, target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterdvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") DoubleBuffer params) {
/* 1514 */     if (Checks.CHECKS) {
/* 1515 */       Checks.check(params, 4);
/*      */     }
/* 1517 */     nglGetNamedProgramLocalParameterdvEXT(program, target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterfvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer params) {
/* 1527 */     if (Checks.CHECKS) {
/* 1528 */       Checks.check(params, 4);
/*      */     }
/* 1530 */     nglGetNamedProgramLocalParameterfvEXT(program, target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1540 */     if (Checks.CHECKS) {
/* 1541 */       Checks.check(params, 1);
/*      */     }
/* 1543 */     nglGetNamedProgramivEXT(program, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedProgramiEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 1549 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1551 */       IntBuffer params = stack.callocInt(1);
/* 1552 */       nglGetNamedProgramivEXT(program, target, pname, MemoryUtil.memAddress(params));
/* 1553 */       return params.get(0);
/*      */     } finally {
/* 1555 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramStringEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("void *") ByteBuffer string) {
/* 1566 */     if (Checks.CHECKS && 
/* 1567 */       Checks.DEBUG) {
/* 1568 */       Checks.check(string, glGetNamedProgramiEXT(program, target, 34343));
/*      */     }
/*      */     
/* 1571 */     nglGetNamedProgramStringEXT(program, target, pname, MemoryUtil.memAddress(string));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1581 */     nglCompressedTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("void const *") ByteBuffer data) {
/* 1586 */     nglCompressedTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1596 */     nglCompressedTextureImage2DEXT(texture, target, level, internalformat, width, height, border, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("void const *") ByteBuffer data) {
/* 1601 */     nglCompressedTextureImage2DEXT(texture, target, level, internalformat, width, height, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1611 */     nglCompressedTextureImage1DEXT(texture, target, level, internalformat, width, border, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("void const *") ByteBuffer data) {
/* 1616 */     nglCompressedTextureImage1DEXT(texture, target, level, internalformat, width, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1626 */     nglCompressedTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 1631 */     nglCompressedTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1641 */     nglCompressedTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 1646 */     nglCompressedTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1656 */     nglCompressedTextureSubImage1DEXT(texture, target, level, xoffset, width, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 1661 */     nglCompressedTextureSubImage1DEXT(texture, target, level, xoffset, width, format, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer img) {
/* 1671 */     if (Checks.CHECKS && 
/* 1672 */       Checks.DEBUG) {
/* 1673 */       Checks.check(img, glGetTextureLevelParameteriEXT(texture, target, level, 34464));
/*      */     }
/*      */     
/* 1676 */     nglGetCompressedTextureImageEXT(texture, target, level, MemoryUtil.memAddress(img));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") long img) {
/* 1681 */     nglGetCompressedTextureImageEXT(texture, target, level, img);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1691 */     nglCompressedMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("void const *") ByteBuffer data) {
/* 1696 */     nglCompressedMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1706 */     nglCompressedMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("void const *") ByteBuffer data) {
/* 1711 */     nglCompressedMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1721 */     nglCompressedMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("void const *") ByteBuffer data) {
/* 1726 */     nglCompressedMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1736 */     nglCompressedMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 1741 */     nglCompressedMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1751 */     nglCompressedMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 1756 */     nglCompressedMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1766 */     nglCompressedMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 1771 */     nglCompressedMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer img) {
/* 1781 */     if (Checks.CHECKS && 
/* 1782 */       Checks.DEBUG) {
/* 1783 */       Checks.check(img, glGetMultiTexLevelParameteriEXT(texunit, target, level, 34464));
/*      */     }
/*      */     
/* 1786 */     nglGetCompressedMultiTexImageEXT(texunit, target, level, MemoryUtil.memAddress(img));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") long img) {
/* 1791 */     nglGetCompressedMultiTexImageEXT(texunit, target, level, img);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTransposefEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/* 1801 */     if (Checks.CHECKS) {
/* 1802 */       Checks.check(m, 16);
/*      */     }
/* 1804 */     nglMatrixLoadTransposefEXT(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTransposedEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLdouble const *") DoubleBuffer m) {
/* 1814 */     if (Checks.CHECKS) {
/* 1815 */       Checks.check(m, 16);
/*      */     }
/* 1817 */     nglMatrixLoadTransposedEXT(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTransposefEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/* 1827 */     if (Checks.CHECKS) {
/* 1828 */       Checks.check(m, 16);
/*      */     }
/* 1830 */     nglMatrixMultTransposefEXT(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTransposedEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLdouble const *") DoubleBuffer m) {
/* 1840 */     if (Checks.CHECKS) {
/* 1841 */       Checks.check(m, 16);
/*      */     }
/* 1843 */     nglMatrixMultTransposedEXT(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int usage) {
/* 1853 */     nglNamedBufferDataEXT(buffer, size, 0L, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") ByteBuffer data, @NativeType("GLenum") int usage) {
/* 1858 */     nglNamedBufferDataEXT(buffer, data.remaining(), MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") ShortBuffer data, @NativeType("GLenum") int usage) {
/* 1863 */     nglNamedBufferDataEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") IntBuffer data, @NativeType("GLenum") int usage) {
/* 1868 */     nglNamedBufferDataEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") FloatBuffer data, @NativeType("GLenum") int usage) {
/* 1873 */     nglNamedBufferDataEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") DoubleBuffer data, @NativeType("GLenum") int usage) {
/* 1878 */     nglNamedBufferDataEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ByteBuffer data) {
/* 1888 */     nglNamedBufferSubDataEXT(buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ShortBuffer data) {
/* 1893 */     nglNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") IntBuffer data) {
/* 1898 */     nglNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") FloatBuffer data) {
/* 1903 */     nglNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") DoubleBuffer data) {
/* 1908 */     nglNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access) {
/* 1919 */     long __result = nglMapNamedBufferEXT(buffer, access);
/* 1920 */     return MemoryUtil.memByteBufferSafe(__result, glGetNamedBufferParameteriEXT(buffer, 34660));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access, ByteBuffer old_buffer) {
/* 1926 */     long __result = nglMapNamedBufferEXT(buffer, access);
/* 1927 */     int length = glGetNamedBufferParameteriEXT(buffer, 34660);
/* 1928 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access, long length, ByteBuffer old_buffer) {
/* 1934 */     long __result = nglMapNamedBufferEXT(buffer, access);
/* 1935 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameterivEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1951 */     if (Checks.CHECKS) {
/* 1952 */       Checks.check(params, 1);
/*      */     }
/* 1954 */     nglGetNamedBufferParameterivEXT(buffer, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedBufferParameteriEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/* 1960 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1962 */       IntBuffer params = stack.callocInt(1);
/* 1963 */       nglGetNamedBufferParameterivEXT(buffer, pname, MemoryUtil.memAddress(params));
/* 1964 */       return params.get(0);
/*      */     } finally {
/* 1966 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") ByteBuffer data) {
/* 1977 */     nglGetNamedBufferSubDataEXT(buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") ShortBuffer data) {
/* 1982 */     nglGetNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") IntBuffer data) {
/* 1987 */     nglGetNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") FloatBuffer data) {
/* 1992 */     nglGetNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") DoubleBuffer data) {
/* 1997 */     nglGetNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2047 */     nglProgramUniform1fvEXT(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2057 */     nglProgramUniform2fvEXT(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2067 */     nglProgramUniform3fvEXT(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2077 */     nglProgramUniform4fvEXT(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1ivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 2087 */     nglProgramUniform1ivEXT(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2ivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 2097 */     nglProgramUniform2ivEXT(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3ivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 2107 */     nglProgramUniform3ivEXT(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4ivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 2117 */     nglProgramUniform4ivEXT(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2127 */     nglProgramUniformMatrix2fvEXT(program, location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2137 */     nglProgramUniformMatrix3fvEXT(program, location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2147 */     nglProgramUniformMatrix4fvEXT(program, location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2157 */     nglProgramUniformMatrix2x3fvEXT(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2167 */     nglProgramUniformMatrix3x2fvEXT(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2177 */     nglProgramUniformMatrix2x4fvEXT(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2187 */     nglProgramUniformMatrix4x2fvEXT(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2197 */     nglProgramUniformMatrix3x4fvEXT(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 2207 */     nglProgramUniformMatrix4x3fvEXT(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 2227 */     if (Checks.CHECKS) {
/* 2228 */       Checks.check(params, 4);
/*      */     }
/* 2230 */     nglTextureParameterIivEXT(texture, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint const *") IntBuffer params) {
/* 2240 */     if (Checks.CHECKS) {
/* 2241 */       Checks.check(params, 4);
/*      */     }
/* 2243 */     nglTextureParameterIuivEXT(texture, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 2253 */     if (Checks.CHECKS) {
/* 2254 */       Checks.check(params, 1);
/*      */     }
/* 2256 */     nglGetTextureParameterIivEXT(texture, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIiEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 2262 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2264 */       IntBuffer params = stack.callocInt(1);
/* 2265 */       nglGetTextureParameterIivEXT(texture, target, pname, MemoryUtil.memAddress(params));
/* 2266 */       return params.get(0);
/*      */     } finally {
/* 2268 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 2279 */     if (Checks.CHECKS) {
/* 2280 */       Checks.check(params, 1);
/*      */     }
/* 2282 */     nglGetTextureParameterIuivEXT(texture, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIuiEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 2288 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2290 */       IntBuffer params = stack.callocInt(1);
/* 2291 */       nglGetTextureParameterIuivEXT(texture, target, pname, MemoryUtil.memAddress(params));
/* 2292 */       return params.get(0);
/*      */     } finally {
/* 2294 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterIivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 2305 */     if (Checks.CHECKS) {
/* 2306 */       Checks.check(params, 4);
/*      */     }
/* 2308 */     nglMultiTexParameterIivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterIuivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint const *") IntBuffer params) {
/* 2318 */     if (Checks.CHECKS) {
/* 2319 */       Checks.check(params, 4);
/*      */     }
/* 2321 */     nglMultiTexParameterIuivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterIivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 2331 */     if (Checks.CHECKS) {
/* 2332 */       Checks.check(params, 1);
/*      */     }
/* 2334 */     nglGetMultiTexParameterIivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexParameterIiEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 2340 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2342 */       IntBuffer params = stack.callocInt(1);
/* 2343 */       nglGetMultiTexParameterIivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/* 2344 */       return params.get(0);
/*      */     } finally {
/* 2346 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterIuivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 2357 */     if (Checks.CHECKS) {
/* 2358 */       Checks.check(params, 1);
/*      */     }
/* 2360 */     nglGetMultiTexParameterIuivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexParameterIuiEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 2366 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2368 */       IntBuffer params = stack.callocInt(1);
/* 2369 */       nglGetMultiTexParameterIuivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
/* 2370 */       return params.get(0);
/*      */     } finally {
/* 2372 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 2403 */     nglProgramUniform1uivEXT(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 2413 */     nglProgramUniform2uivEXT(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 2423 */     nglProgramUniform3uivEXT(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 2433 */     nglProgramUniform4uivEXT(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameters4fvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer params) {
/* 2443 */     nglNamedProgramLocalParameters4fvEXT(program, target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameterI4ivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer params) {
/* 2458 */     if (Checks.CHECKS) {
/* 2459 */       Checks.check(params, 4);
/*      */     }
/* 2461 */     nglNamedProgramLocalParameterI4ivEXT(program, target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParametersI4ivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer params) {
/* 2471 */     nglNamedProgramLocalParametersI4ivEXT(program, target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameterI4uivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer params) {
/* 2486 */     if (Checks.CHECKS) {
/* 2487 */       Checks.check(params, 4);
/*      */     }
/* 2489 */     nglNamedProgramLocalParameterI4uivEXT(program, target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParametersI4uivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer params) {
/* 2499 */     nglNamedProgramLocalParametersI4uivEXT(program, target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterIivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer params) {
/* 2509 */     if (Checks.CHECKS) {
/* 2510 */       Checks.check(params, 4);
/*      */     }
/* 2512 */     nglGetNamedProgramLocalParameterIivEXT(program, target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterIuivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLuint *") IntBuffer params) {
/* 2522 */     if (Checks.CHECKS) {
/* 2523 */       Checks.check(params, 4);
/*      */     }
/* 2525 */     nglGetNamedProgramLocalParameterIuivEXT(program, target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameterivEXT(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 2540 */     if (Checks.CHECKS) {
/* 2541 */       Checks.check(params, 1);
/*      */     }
/* 2543 */     nglGetNamedRenderbufferParameterivEXT(renderbuffer, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedRenderbufferParameteriEXT(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname) {
/* 2549 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2551 */       IntBuffer params = stack.callocInt(1);
/* 2552 */       nglGetNamedRenderbufferParameterivEXT(renderbuffer, pname, MemoryUtil.memAddress(params));
/* 2553 */       return params.get(0);
/*      */     } finally {
/* 2555 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameterivEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 2602 */     if (Checks.CHECKS) {
/* 2603 */       Checks.check(params, 1);
/*      */     }
/* 2605 */     nglGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferAttachmentParameteriEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname) {
/* 2611 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2613 */       IntBuffer params = stack.callocInt(1);
/* 2614 */       nglGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, MemoryUtil.memAddress(params));
/* 2615 */       return params.get(0);
/*      */     } finally {
/* 2617 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFramebufferDrawBuffersEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer bufs) {
/* 2643 */     nglFramebufferDrawBuffersEXT(framebuffer, bufs.remaining(), MemoryUtil.memAddress(bufs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferParameterivEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/* 2658 */     if (Checks.CHECKS) {
/* 2659 */       Checks.check(param, 1);
/*      */     }
/* 2661 */     nglGetFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetFramebufferParameteriEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname) {
/* 2667 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2669 */       IntBuffer param = stack.callocInt(1);
/* 2670 */       nglGetFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.memAddress(param));
/* 2671 */       return param.get(0);
/*      */     } finally {
/* 2673 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIntegervEXT(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/* 2789 */     if (Checks.CHECKS) {
/* 2790 */       Checks.check(param, 1);
/*      */     }
/* 2792 */     nglGetVertexArrayIntegervEXT(vaobj, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayIntegerEXT(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname) {
/* 2798 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2800 */       IntBuffer param = stack.callocInt(1);
/* 2801 */       nglGetVertexArrayIntegervEXT(vaobj, pname, MemoryUtil.memAddress(param));
/* 2802 */       return param.get(0);
/*      */     } finally {
/* 2804 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayPointervEXT(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer param) {
/* 2815 */     if (Checks.CHECKS) {
/* 2816 */       Checks.check((CustomBuffer)param, 1);
/*      */     }
/* 2818 */     nglGetVertexArrayPointervEXT(vaobj, pname, MemoryUtil.memAddress((CustomBuffer)param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexArrayPointerEXT(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname) {
/* 2824 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2826 */       PointerBuffer param = stack.callocPointer(1);
/* 2827 */       nglGetVertexArrayPointervEXT(vaobj, pname, MemoryUtil.memAddress((CustomBuffer)param));
/* 2828 */       return param.get(0);
/*      */     } finally {
/* 2830 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIntegeri_vEXT(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/* 2841 */     if (Checks.CHECKS) {
/* 2842 */       Checks.check(param, 1);
/*      */     }
/* 2844 */     nglGetVertexArrayIntegeri_vEXT(vaobj, index, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayIntegeriEXT(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 2850 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2852 */       IntBuffer param = stack.callocInt(1);
/* 2853 */       nglGetVertexArrayIntegeri_vEXT(vaobj, index, pname, MemoryUtil.memAddress(param));
/* 2854 */       return param.get(0);
/*      */     } finally {
/* 2856 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayPointeri_vEXT(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer param) {
/* 2867 */     if (Checks.CHECKS) {
/* 2868 */       Checks.check((CustomBuffer)param, 1);
/*      */     }
/* 2870 */     nglGetVertexArrayPointeri_vEXT(vaobj, index, pname, MemoryUtil.memAddress((CustomBuffer)param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexArrayPointeriEXT(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 2876 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2878 */       PointerBuffer param = stack.callocPointer(1);
/* 2879 */       nglGetVertexArrayPointeri_vEXT(vaobj, index, pname, MemoryUtil.memAddress((CustomBuffer)param));
/* 2880 */       return param.get(0);
/*      */     } finally {
/* 2882 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRangeEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access) {
/* 2894 */     long __result = nglMapNamedBufferRangeEXT(buffer, offset, length, access);
/* 2895 */     return MemoryUtil.memByteBufferSafe(__result, (int)length);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRangeEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access, ByteBuffer old_buffer) {
/* 2901 */     long __result = nglMapNamedBufferRangeEXT(buffer, offset, length, access);
/* 2902 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadfEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 2912 */     long __functionAddress = (GL.getICD()).glMatrixLoadfEXT;
/* 2913 */     if (Checks.CHECKS) {
/* 2914 */       Checks.check(__functionAddress);
/* 2915 */       Checks.check(m, 16);
/*      */     } 
/* 2917 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoaddEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLdouble const *") double[] m) {
/* 2922 */     long __functionAddress = (GL.getICD()).glMatrixLoaddEXT;
/* 2923 */     if (Checks.CHECKS) {
/* 2924 */       Checks.check(__functionAddress);
/* 2925 */       Checks.check(m, 16);
/*      */     } 
/* 2927 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultfEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 2932 */     long __functionAddress = (GL.getICD()).glMatrixMultfEXT;
/* 2933 */     if (Checks.CHECKS) {
/* 2934 */       Checks.check(__functionAddress);
/* 2935 */       Checks.check(m, 16);
/*      */     } 
/* 2937 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultdEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLdouble const *") double[] m) {
/* 2942 */     long __functionAddress = (GL.getICD()).glMatrixMultdEXT;
/* 2943 */     if (Checks.CHECKS) {
/* 2944 */       Checks.check(__functionAddress);
/* 2945 */       Checks.check(m, 16);
/*      */     } 
/* 2947 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] param) {
/* 2952 */     long __functionAddress = (GL.getICD()).glTextureParameterivEXT;
/* 2953 */     if (Checks.CHECKS) {
/* 2954 */       Checks.check(__functionAddress);
/* 2955 */       Checks.check(param, 4);
/*      */     } 
/* 2957 */     JNI.callPV(texture, target, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfvEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] param) {
/* 2962 */     long __functionAddress = (GL.getICD()).glTextureParameterfvEXT;
/* 2963 */     if (Checks.CHECKS) {
/* 2964 */       Checks.check(__functionAddress);
/* 2965 */       Checks.check(param, 4);
/*      */     } 
/* 2967 */     JNI.callPV(texture, target, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 2972 */     long __functionAddress = (GL.getICD()).glTextureImage1DEXT;
/* 2973 */     if (Checks.CHECKS) {
/* 2974 */       Checks.check(__functionAddress);
/*      */     }
/* 2976 */     JNI.callPV(texture, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 2981 */     long __functionAddress = (GL.getICD()).glTextureImage1DEXT;
/* 2982 */     if (Checks.CHECKS) {
/* 2983 */       Checks.check(__functionAddress);
/*      */     }
/* 2985 */     JNI.callPV(texture, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 2990 */     long __functionAddress = (GL.getICD()).glTextureImage1DEXT;
/* 2991 */     if (Checks.CHECKS) {
/* 2992 */       Checks.check(__functionAddress);
/*      */     }
/* 2994 */     JNI.callPV(texture, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 2999 */     long __functionAddress = (GL.getICD()).glTextureImage1DEXT;
/* 3000 */     if (Checks.CHECKS) {
/* 3001 */       Checks.check(__functionAddress);
/*      */     }
/* 3003 */     JNI.callPV(texture, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3008 */     long __functionAddress = (GL.getICD()).glTextureImage2DEXT;
/* 3009 */     if (Checks.CHECKS) {
/* 3010 */       Checks.check(__functionAddress);
/*      */     }
/* 3012 */     JNI.callPV(texture, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3017 */     long __functionAddress = (GL.getICD()).glTextureImage2DEXT;
/* 3018 */     if (Checks.CHECKS) {
/* 3019 */       Checks.check(__functionAddress);
/*      */     }
/* 3021 */     JNI.callPV(texture, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3026 */     long __functionAddress = (GL.getICD()).glTextureImage2DEXT;
/* 3027 */     if (Checks.CHECKS) {
/* 3028 */       Checks.check(__functionAddress);
/*      */     }
/* 3030 */     JNI.callPV(texture, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3035 */     long __functionAddress = (GL.getICD()).glTextureImage2DEXT;
/* 3036 */     if (Checks.CHECKS) {
/* 3037 */       Checks.check(__functionAddress);
/*      */     }
/* 3039 */     JNI.callPV(texture, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3044 */     long __functionAddress = (GL.getICD()).glTextureSubImage1DEXT;
/* 3045 */     if (Checks.CHECKS) {
/* 3046 */       Checks.check(__functionAddress);
/*      */     }
/* 3048 */     JNI.callPV(texture, target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3053 */     long __functionAddress = (GL.getICD()).glTextureSubImage1DEXT;
/* 3054 */     if (Checks.CHECKS) {
/* 3055 */       Checks.check(__functionAddress);
/*      */     }
/* 3057 */     JNI.callPV(texture, target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3062 */     long __functionAddress = (GL.getICD()).glTextureSubImage1DEXT;
/* 3063 */     if (Checks.CHECKS) {
/* 3064 */       Checks.check(__functionAddress);
/*      */     }
/* 3066 */     JNI.callPV(texture, target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3071 */     long __functionAddress = (GL.getICD()).glTextureSubImage1DEXT;
/* 3072 */     if (Checks.CHECKS) {
/* 3073 */       Checks.check(__functionAddress);
/*      */     }
/* 3075 */     JNI.callPV(texture, target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3080 */     long __functionAddress = (GL.getICD()).glTextureSubImage2DEXT;
/* 3081 */     if (Checks.CHECKS) {
/* 3082 */       Checks.check(__functionAddress);
/*      */     }
/* 3084 */     JNI.callPV(texture, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3089 */     long __functionAddress = (GL.getICD()).glTextureSubImage2DEXT;
/* 3090 */     if (Checks.CHECKS) {
/* 3091 */       Checks.check(__functionAddress);
/*      */     }
/* 3093 */     JNI.callPV(texture, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3098 */     long __functionAddress = (GL.getICD()).glTextureSubImage2DEXT;
/* 3099 */     if (Checks.CHECKS) {
/* 3100 */       Checks.check(__functionAddress);
/*      */     }
/* 3102 */     JNI.callPV(texture, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3107 */     long __functionAddress = (GL.getICD()).glTextureSubImage2DEXT;
/* 3108 */     if (Checks.CHECKS) {
/* 3109 */       Checks.check(__functionAddress);
/*      */     }
/* 3111 */     JNI.callPV(texture, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 3116 */     long __functionAddress = (GL.getICD()).glGetTextureImageEXT;
/* 3117 */     if (Checks.CHECKS) {
/* 3118 */       Checks.check(__functionAddress);
/*      */     }
/* 3120 */     JNI.callPV(texture, target, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 3125 */     long __functionAddress = (GL.getICD()).glGetTextureImageEXT;
/* 3126 */     if (Checks.CHECKS) {
/* 3127 */       Checks.check(__functionAddress);
/*      */     }
/* 3129 */     JNI.callPV(texture, target, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 3134 */     long __functionAddress = (GL.getICD()).glGetTextureImageEXT;
/* 3135 */     if (Checks.CHECKS) {
/* 3136 */       Checks.check(__functionAddress);
/*      */     }
/* 3138 */     JNI.callPV(texture, target, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 3143 */     long __functionAddress = (GL.getICD()).glGetTextureImageEXT;
/* 3144 */     if (Checks.CHECKS) {
/* 3145 */       Checks.check(__functionAddress);
/*      */     }
/* 3147 */     JNI.callPV(texture, target, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfvEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 3152 */     long __functionAddress = (GL.getICD()).glGetTextureParameterfvEXT;
/* 3153 */     if (Checks.CHECKS) {
/* 3154 */       Checks.check(__functionAddress);
/* 3155 */       Checks.check(params, 1);
/*      */     } 
/* 3157 */     JNI.callPV(texture, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 3162 */     long __functionAddress = (GL.getICD()).glGetTextureParameterivEXT;
/* 3163 */     if (Checks.CHECKS) {
/* 3164 */       Checks.check(__functionAddress);
/* 3165 */       Checks.check(params, 1);
/*      */     } 
/* 3167 */     JNI.callPV(texture, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfvEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 3172 */     long __functionAddress = (GL.getICD()).glGetTextureLevelParameterfvEXT;
/* 3173 */     if (Checks.CHECKS) {
/* 3174 */       Checks.check(__functionAddress);
/* 3175 */       Checks.check(params, 1);
/*      */     } 
/* 3177 */     JNI.callPV(texture, target, level, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 3182 */     long __functionAddress = (GL.getICD()).glGetTextureLevelParameterivEXT;
/* 3183 */     if (Checks.CHECKS) {
/* 3184 */       Checks.check(__functionAddress);
/* 3185 */       Checks.check(params, 1);
/*      */     } 
/* 3187 */     JNI.callPV(texture, target, level, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3192 */     long __functionAddress = (GL.getICD()).glTextureImage3DEXT;
/* 3193 */     if (Checks.CHECKS) {
/* 3194 */       Checks.check(__functionAddress);
/*      */     }
/* 3196 */     JNI.callPV(texture, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3201 */     long __functionAddress = (GL.getICD()).glTextureImage3DEXT;
/* 3202 */     if (Checks.CHECKS) {
/* 3203 */       Checks.check(__functionAddress);
/*      */     }
/* 3205 */     JNI.callPV(texture, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3210 */     long __functionAddress = (GL.getICD()).glTextureImage3DEXT;
/* 3211 */     if (Checks.CHECKS) {
/* 3212 */       Checks.check(__functionAddress);
/*      */     }
/* 3214 */     JNI.callPV(texture, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3219 */     long __functionAddress = (GL.getICD()).glTextureImage3DEXT;
/* 3220 */     if (Checks.CHECKS) {
/* 3221 */       Checks.check(__functionAddress);
/*      */     }
/* 3223 */     JNI.callPV(texture, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3228 */     long __functionAddress = (GL.getICD()).glTextureSubImage3DEXT;
/* 3229 */     if (Checks.CHECKS) {
/* 3230 */       Checks.check(__functionAddress);
/*      */     }
/* 3232 */     JNI.callPV(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3237 */     long __functionAddress = (GL.getICD()).glTextureSubImage3DEXT;
/* 3238 */     if (Checks.CHECKS) {
/* 3239 */       Checks.check(__functionAddress);
/*      */     }
/* 3241 */     JNI.callPV(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3246 */     long __functionAddress = (GL.getICD()).glTextureSubImage3DEXT;
/* 3247 */     if (Checks.CHECKS) {
/* 3248 */       Checks.check(__functionAddress);
/*      */     }
/* 3250 */     JNI.callPV(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3255 */     long __functionAddress = (GL.getICD()).glTextureSubImage3DEXT;
/* 3256 */     if (Checks.CHECKS) {
/* 3257 */       Checks.check(__functionAddress);
/*      */     }
/* 3259 */     JNI.callPV(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int texunit, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") short[] pointer) {
/* 3264 */     long __functionAddress = (GL.getICD()).glMultiTexCoordPointerEXT;
/* 3265 */     if (Checks.CHECKS) {
/* 3266 */       Checks.check(__functionAddress);
/*      */     }
/* 3268 */     JNI.callPV(texunit, size, type, stride, pointer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int texunit, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") int[] pointer) {
/* 3273 */     long __functionAddress = (GL.getICD()).glMultiTexCoordPointerEXT;
/* 3274 */     if (Checks.CHECKS) {
/* 3275 */       Checks.check(__functionAddress);
/*      */     }
/* 3277 */     JNI.callPV(texunit, size, type, stride, pointer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int texunit, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") float[] pointer) {
/* 3282 */     long __functionAddress = (GL.getICD()).glMultiTexCoordPointerEXT;
/* 3283 */     if (Checks.CHECKS) {
/* 3284 */       Checks.check(__functionAddress);
/*      */     }
/* 3286 */     JNI.callPV(texunit, size, type, stride, pointer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexEnvfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 3291 */     long __functionAddress = (GL.getICD()).glMultiTexEnvfvEXT;
/* 3292 */     if (Checks.CHECKS) {
/* 3293 */       Checks.check(__functionAddress);
/* 3294 */       Checks.check(params, 4);
/*      */     } 
/* 3296 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexEnvivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 3301 */     long __functionAddress = (GL.getICD()).glMultiTexEnvivEXT;
/* 3302 */     if (Checks.CHECKS) {
/* 3303 */       Checks.check(__functionAddress);
/* 3304 */       Checks.check(params, 4);
/*      */     } 
/* 3306 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexGendvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLdouble const *") double[] params) {
/* 3311 */     long __functionAddress = (GL.getICD()).glMultiTexGendvEXT;
/* 3312 */     if (Checks.CHECKS) {
/* 3313 */       Checks.check(__functionAddress);
/* 3314 */       Checks.check(params, 4);
/*      */     } 
/* 3316 */     JNI.callPV(texunit, coord, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexGenfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 3321 */     long __functionAddress = (GL.getICD()).glMultiTexGenfvEXT;
/* 3322 */     if (Checks.CHECKS) {
/* 3323 */       Checks.check(__functionAddress);
/* 3324 */       Checks.check(params, 4);
/*      */     } 
/* 3326 */     JNI.callPV(texunit, coord, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexGenivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 3331 */     long __functionAddress = (GL.getICD()).glMultiTexGenivEXT;
/* 3332 */     if (Checks.CHECKS) {
/* 3333 */       Checks.check(__functionAddress);
/* 3334 */       Checks.check(params, 4);
/*      */     } 
/* 3336 */     JNI.callPV(texunit, coord, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexEnvfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 3341 */     long __functionAddress = (GL.getICD()).glGetMultiTexEnvfvEXT;
/* 3342 */     if (Checks.CHECKS) {
/* 3343 */       Checks.check(__functionAddress);
/* 3344 */       Checks.check(params, 1);
/*      */     } 
/* 3346 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexEnvivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 3351 */     long __functionAddress = (GL.getICD()).glGetMultiTexEnvivEXT;
/* 3352 */     if (Checks.CHECKS) {
/* 3353 */       Checks.check(__functionAddress);
/* 3354 */       Checks.check(params, 1);
/*      */     } 
/* 3356 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGendvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 3361 */     long __functionAddress = (GL.getICD()).glGetMultiTexGendvEXT;
/* 3362 */     if (Checks.CHECKS) {
/* 3363 */       Checks.check(__functionAddress);
/* 3364 */       Checks.check(params, 1);
/*      */     } 
/* 3366 */     JNI.callPV(texunit, coord, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGenfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 3371 */     long __functionAddress = (GL.getICD()).glGetMultiTexGenfvEXT;
/* 3372 */     if (Checks.CHECKS) {
/* 3373 */       Checks.check(__functionAddress);
/* 3374 */       Checks.check(params, 1);
/*      */     } 
/* 3376 */     JNI.callPV(texunit, coord, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGenivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 3381 */     long __functionAddress = (GL.getICD()).glGetMultiTexGenivEXT;
/* 3382 */     if (Checks.CHECKS) {
/* 3383 */       Checks.check(__functionAddress);
/* 3384 */       Checks.check(params, 1);
/*      */     } 
/* 3386 */     JNI.callPV(texunit, coord, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] param) {
/* 3391 */     long __functionAddress = (GL.getICD()).glMultiTexParameterivEXT;
/* 3392 */     if (Checks.CHECKS) {
/* 3393 */       Checks.check(__functionAddress);
/* 3394 */       Checks.check(param, 4);
/*      */     } 
/* 3396 */     JNI.callPV(texunit, target, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] param) {
/* 3401 */     long __functionAddress = (GL.getICD()).glMultiTexParameterfvEXT;
/* 3402 */     if (Checks.CHECKS) {
/* 3403 */       Checks.check(__functionAddress);
/* 3404 */       Checks.check(param, 4);
/*      */     } 
/* 3406 */     JNI.callPV(texunit, target, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3411 */     long __functionAddress = (GL.getICD()).glMultiTexImage1DEXT;
/* 3412 */     if (Checks.CHECKS) {
/* 3413 */       Checks.check(__functionAddress);
/*      */     }
/* 3415 */     JNI.callPV(texunit, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3420 */     long __functionAddress = (GL.getICD()).glMultiTexImage1DEXT;
/* 3421 */     if (Checks.CHECKS) {
/* 3422 */       Checks.check(__functionAddress);
/*      */     }
/* 3424 */     JNI.callPV(texunit, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3429 */     long __functionAddress = (GL.getICD()).glMultiTexImage1DEXT;
/* 3430 */     if (Checks.CHECKS) {
/* 3431 */       Checks.check(__functionAddress);
/*      */     }
/* 3433 */     JNI.callPV(texunit, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3438 */     long __functionAddress = (GL.getICD()).glMultiTexImage1DEXT;
/* 3439 */     if (Checks.CHECKS) {
/* 3440 */       Checks.check(__functionAddress);
/*      */     }
/* 3442 */     JNI.callPV(texunit, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3447 */     long __functionAddress = (GL.getICD()).glMultiTexImage2DEXT;
/* 3448 */     if (Checks.CHECKS) {
/* 3449 */       Checks.check(__functionAddress);
/*      */     }
/* 3451 */     JNI.callPV(texunit, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3456 */     long __functionAddress = (GL.getICD()).glMultiTexImage2DEXT;
/* 3457 */     if (Checks.CHECKS) {
/* 3458 */       Checks.check(__functionAddress);
/*      */     }
/* 3460 */     JNI.callPV(texunit, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3465 */     long __functionAddress = (GL.getICD()).glMultiTexImage2DEXT;
/* 3466 */     if (Checks.CHECKS) {
/* 3467 */       Checks.check(__functionAddress);
/*      */     }
/* 3469 */     JNI.callPV(texunit, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3474 */     long __functionAddress = (GL.getICD()).glMultiTexImage2DEXT;
/* 3475 */     if (Checks.CHECKS) {
/* 3476 */       Checks.check(__functionAddress);
/*      */     }
/* 3478 */     JNI.callPV(texunit, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3483 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage1DEXT;
/* 3484 */     if (Checks.CHECKS) {
/* 3485 */       Checks.check(__functionAddress);
/*      */     }
/* 3487 */     JNI.callPV(texunit, target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3492 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage1DEXT;
/* 3493 */     if (Checks.CHECKS) {
/* 3494 */       Checks.check(__functionAddress);
/*      */     }
/* 3496 */     JNI.callPV(texunit, target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3501 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage1DEXT;
/* 3502 */     if (Checks.CHECKS) {
/* 3503 */       Checks.check(__functionAddress);
/*      */     }
/* 3505 */     JNI.callPV(texunit, target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3510 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage1DEXT;
/* 3511 */     if (Checks.CHECKS) {
/* 3512 */       Checks.check(__functionAddress);
/*      */     }
/* 3514 */     JNI.callPV(texunit, target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3519 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage2DEXT;
/* 3520 */     if (Checks.CHECKS) {
/* 3521 */       Checks.check(__functionAddress);
/*      */     }
/* 3523 */     JNI.callPV(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3528 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage2DEXT;
/* 3529 */     if (Checks.CHECKS) {
/* 3530 */       Checks.check(__functionAddress);
/*      */     }
/* 3532 */     JNI.callPV(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3537 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage2DEXT;
/* 3538 */     if (Checks.CHECKS) {
/* 3539 */       Checks.check(__functionAddress);
/*      */     }
/* 3541 */     JNI.callPV(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3546 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage2DEXT;
/* 3547 */     if (Checks.CHECKS) {
/* 3548 */       Checks.check(__functionAddress);
/*      */     }
/* 3550 */     JNI.callPV(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 3555 */     long __functionAddress = (GL.getICD()).glGetMultiTexImageEXT;
/* 3556 */     if (Checks.CHECKS) {
/* 3557 */       Checks.check(__functionAddress);
/*      */     }
/* 3559 */     JNI.callPV(texunit, target, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 3564 */     long __functionAddress = (GL.getICD()).glGetMultiTexImageEXT;
/* 3565 */     if (Checks.CHECKS) {
/* 3566 */       Checks.check(__functionAddress);
/*      */     }
/* 3568 */     JNI.callPV(texunit, target, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 3573 */     long __functionAddress = (GL.getICD()).glGetMultiTexImageEXT;
/* 3574 */     if (Checks.CHECKS) {
/* 3575 */       Checks.check(__functionAddress);
/*      */     }
/* 3577 */     JNI.callPV(texunit, target, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 3582 */     long __functionAddress = (GL.getICD()).glGetMultiTexImageEXT;
/* 3583 */     if (Checks.CHECKS) {
/* 3584 */       Checks.check(__functionAddress);
/*      */     }
/* 3586 */     JNI.callPV(texunit, target, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 3591 */     long __functionAddress = (GL.getICD()).glGetMultiTexParameterfvEXT;
/* 3592 */     if (Checks.CHECKS) {
/* 3593 */       Checks.check(__functionAddress);
/* 3594 */       Checks.check(params, 1);
/*      */     } 
/* 3596 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 3601 */     long __functionAddress = (GL.getICD()).glGetMultiTexParameterivEXT;
/* 3602 */     if (Checks.CHECKS) {
/* 3603 */       Checks.check(__functionAddress);
/* 3604 */       Checks.check(params, 1);
/*      */     } 
/* 3606 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexLevelParameterfvEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 3611 */     long __functionAddress = (GL.getICD()).glGetMultiTexLevelParameterfvEXT;
/* 3612 */     if (Checks.CHECKS) {
/* 3613 */       Checks.check(__functionAddress);
/* 3614 */       Checks.check(params, 1);
/*      */     } 
/* 3616 */     JNI.callPV(texunit, target, level, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexLevelParameterivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 3621 */     long __functionAddress = (GL.getICD()).glGetMultiTexLevelParameterivEXT;
/* 3622 */     if (Checks.CHECKS) {
/* 3623 */       Checks.check(__functionAddress);
/* 3624 */       Checks.check(params, 1);
/*      */     } 
/* 3626 */     JNI.callPV(texunit, target, level, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3631 */     long __functionAddress = (GL.getICD()).glMultiTexImage3DEXT;
/* 3632 */     if (Checks.CHECKS) {
/* 3633 */       Checks.check(__functionAddress);
/*      */     }
/* 3635 */     JNI.callPV(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3640 */     long __functionAddress = (GL.getICD()).glMultiTexImage3DEXT;
/* 3641 */     if (Checks.CHECKS) {
/* 3642 */       Checks.check(__functionAddress);
/*      */     }
/* 3644 */     JNI.callPV(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3649 */     long __functionAddress = (GL.getICD()).glMultiTexImage3DEXT;
/* 3650 */     if (Checks.CHECKS) {
/* 3651 */       Checks.check(__functionAddress);
/*      */     }
/* 3653 */     JNI.callPV(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3658 */     long __functionAddress = (GL.getICD()).glMultiTexImage3DEXT;
/* 3659 */     if (Checks.CHECKS) {
/* 3660 */       Checks.check(__functionAddress);
/*      */     }
/* 3662 */     JNI.callPV(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 3667 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage3DEXT;
/* 3668 */     if (Checks.CHECKS) {
/* 3669 */       Checks.check(__functionAddress);
/*      */     }
/* 3671 */     JNI.callPV(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 3676 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage3DEXT;
/* 3677 */     if (Checks.CHECKS) {
/* 3678 */       Checks.check(__functionAddress);
/*      */     }
/* 3680 */     JNI.callPV(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 3685 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage3DEXT;
/* 3686 */     if (Checks.CHECKS) {
/* 3687 */       Checks.check(__functionAddress);
/*      */     }
/* 3689 */     JNI.callPV(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 3694 */     long __functionAddress = (GL.getICD()).glMultiTexSubImage3DEXT;
/* 3695 */     if (Checks.CHECKS) {
/* 3696 */       Checks.check(__functionAddress);
/*      */     }
/* 3698 */     JNI.callPV(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloatIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] params) {
/* 3703 */     long __functionAddress = (GL.getICD()).glGetFloatIndexedvEXT;
/* 3704 */     if (Checks.CHECKS) {
/* 3705 */       Checks.check(__functionAddress);
/* 3706 */       Checks.check(params, 1);
/*      */     } 
/* 3708 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoubleIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") double[] params) {
/* 3713 */     long __functionAddress = (GL.getICD()).glGetDoubleIndexedvEXT;
/* 3714 */     if (Checks.CHECKS) {
/* 3715 */       Checks.check(__functionAddress);
/* 3716 */       Checks.check(params, 1);
/*      */     } 
/* 3718 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloati_vEXT(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] params) {
/* 3723 */     long __functionAddress = (GL.getICD()).glGetFloati_vEXT;
/* 3724 */     if (Checks.CHECKS) {
/* 3725 */       Checks.check(__functionAddress);
/* 3726 */       Checks.check(params, 1);
/*      */     } 
/* 3728 */     JNI.callPV(pname, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_vEXT(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLdouble *") double[] params) {
/* 3733 */     long __functionAddress = (GL.getICD()).glGetDoublei_vEXT;
/* 3734 */     if (Checks.CHECKS) {
/* 3735 */       Checks.check(__functionAddress);
/* 3736 */       Checks.check(params, 1);
/*      */     } 
/* 3738 */     JNI.callPV(pname, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint *") int[] data) {
/* 3743 */     EXTDrawBuffers2.glGetIntegerIndexedvEXT(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameter4dvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] params) {
/* 3748 */     long __functionAddress = (GL.getICD()).glNamedProgramLocalParameter4dvEXT;
/* 3749 */     if (Checks.CHECKS) {
/* 3750 */       Checks.check(__functionAddress);
/* 3751 */       Checks.check(params, 4);
/*      */     } 
/* 3753 */     JNI.callPV(program, target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameter4fvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] params) {
/* 3758 */     long __functionAddress = (GL.getICD()).glNamedProgramLocalParameter4fvEXT;
/* 3759 */     if (Checks.CHECKS) {
/* 3760 */       Checks.check(__functionAddress);
/* 3761 */       Checks.check(params, 4);
/*      */     } 
/* 3763 */     JNI.callPV(program, target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterdvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") double[] params) {
/* 3768 */     long __functionAddress = (GL.getICD()).glGetNamedProgramLocalParameterdvEXT;
/* 3769 */     if (Checks.CHECKS) {
/* 3770 */       Checks.check(__functionAddress);
/* 3771 */       Checks.check(params, 4);
/*      */     } 
/* 3773 */     JNI.callPV(program, target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterfvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] params) {
/* 3778 */     long __functionAddress = (GL.getICD()).glGetNamedProgramLocalParameterfvEXT;
/* 3779 */     if (Checks.CHECKS) {
/* 3780 */       Checks.check(__functionAddress);
/* 3781 */       Checks.check(params, 4);
/*      */     } 
/* 3783 */     JNI.callPV(program, target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 3788 */     long __functionAddress = (GL.getICD()).glGetNamedProgramivEXT;
/* 3789 */     if (Checks.CHECKS) {
/* 3790 */       Checks.check(__functionAddress);
/* 3791 */       Checks.check(params, 1);
/*      */     } 
/* 3793 */     JNI.callPV(program, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTransposefEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 3798 */     long __functionAddress = (GL.getICD()).glMatrixLoadTransposefEXT;
/* 3799 */     if (Checks.CHECKS) {
/* 3800 */       Checks.check(__functionAddress);
/* 3801 */       Checks.check(m, 16);
/*      */     } 
/* 3803 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTransposedEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLdouble const *") double[] m) {
/* 3808 */     long __functionAddress = (GL.getICD()).glMatrixLoadTransposedEXT;
/* 3809 */     if (Checks.CHECKS) {
/* 3810 */       Checks.check(__functionAddress);
/* 3811 */       Checks.check(m, 16);
/*      */     } 
/* 3813 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTransposefEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 3818 */     long __functionAddress = (GL.getICD()).glMatrixMultTransposefEXT;
/* 3819 */     if (Checks.CHECKS) {
/* 3820 */       Checks.check(__functionAddress);
/* 3821 */       Checks.check(m, 16);
/*      */     } 
/* 3823 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTransposedEXT(@NativeType("GLenum") int matrixMode, @NativeType("GLdouble const *") double[] m) {
/* 3828 */     long __functionAddress = (GL.getICD()).glMatrixMultTransposedEXT;
/* 3829 */     if (Checks.CHECKS) {
/* 3830 */       Checks.check(__functionAddress);
/* 3831 */       Checks.check(m, 16);
/*      */     } 
/* 3833 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") short[] data, @NativeType("GLenum") int usage) {
/* 3838 */     long __functionAddress = (GL.getICD()).glNamedBufferDataEXT;
/* 3839 */     if (Checks.CHECKS) {
/* 3840 */       Checks.check(__functionAddress);
/*      */     }
/* 3842 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 1L, data, usage, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") int[] data, @NativeType("GLenum") int usage) {
/* 3847 */     long __functionAddress = (GL.getICD()).glNamedBufferDataEXT;
/* 3848 */     if (Checks.CHECKS) {
/* 3849 */       Checks.check(__functionAddress);
/*      */     }
/* 3851 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2L, data, usage, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") float[] data, @NativeType("GLenum") int usage) {
/* 3856 */     long __functionAddress = (GL.getICD()).glNamedBufferDataEXT;
/* 3857 */     if (Checks.CHECKS) {
/* 3858 */       Checks.check(__functionAddress);
/*      */     }
/* 3860 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2L, data, usage, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") double[] data, @NativeType("GLenum") int usage) {
/* 3865 */     long __functionAddress = (GL.getICD()).glNamedBufferDataEXT;
/* 3866 */     if (Checks.CHECKS) {
/* 3867 */       Checks.check(__functionAddress);
/*      */     }
/* 3869 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3L, data, usage, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") short[] data) {
/* 3874 */     long __functionAddress = (GL.getICD()).glNamedBufferSubDataEXT;
/* 3875 */     if (Checks.CHECKS) {
/* 3876 */       Checks.check(__functionAddress);
/*      */     }
/* 3878 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 1L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") int[] data) {
/* 3883 */     long __functionAddress = (GL.getICD()).glNamedBufferSubDataEXT;
/* 3884 */     if (Checks.CHECKS) {
/* 3885 */       Checks.check(__functionAddress);
/*      */     }
/* 3887 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") float[] data) {
/* 3892 */     long __functionAddress = (GL.getICD()).glNamedBufferSubDataEXT;
/* 3893 */     if (Checks.CHECKS) {
/* 3894 */       Checks.check(__functionAddress);
/*      */     }
/* 3896 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") double[] data) {
/* 3901 */     long __functionAddress = (GL.getICD()).glNamedBufferSubDataEXT;
/* 3902 */     if (Checks.CHECKS) {
/* 3903 */       Checks.check(__functionAddress);
/*      */     }
/* 3905 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameterivEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 3910 */     long __functionAddress = (GL.getICD()).glGetNamedBufferParameterivEXT;
/* 3911 */     if (Checks.CHECKS) {
/* 3912 */       Checks.check(__functionAddress);
/* 3913 */       Checks.check(params, 1);
/*      */     } 
/* 3915 */     JNI.callPV(buffer, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") short[] data) {
/* 3920 */     long __functionAddress = (GL.getICD()).glGetNamedBufferSubDataEXT;
/* 3921 */     if (Checks.CHECKS) {
/* 3922 */       Checks.check(__functionAddress);
/*      */     }
/* 3924 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 1L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") int[] data) {
/* 3929 */     long __functionAddress = (GL.getICD()).glGetNamedBufferSubDataEXT;
/* 3930 */     if (Checks.CHECKS) {
/* 3931 */       Checks.check(__functionAddress);
/*      */     }
/* 3933 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") float[] data) {
/* 3938 */     long __functionAddress = (GL.getICD()).glGetNamedBufferSubDataEXT;
/* 3939 */     if (Checks.CHECKS) {
/* 3940 */       Checks.check(__functionAddress);
/*      */     }
/* 3942 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") double[] data) {
/* 3947 */     long __functionAddress = (GL.getICD()).glGetNamedBufferSubDataEXT;
/* 3948 */     if (Checks.CHECKS) {
/* 3949 */       Checks.check(__functionAddress);
/*      */     }
/* 3951 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 3956 */     long __functionAddress = (GL.getICD()).glProgramUniform1fvEXT;
/* 3957 */     if (Checks.CHECKS) {
/* 3958 */       Checks.check(__functionAddress);
/*      */     }
/* 3960 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 3965 */     long __functionAddress = (GL.getICD()).glProgramUniform2fvEXT;
/* 3966 */     if (Checks.CHECKS) {
/* 3967 */       Checks.check(__functionAddress);
/*      */     }
/* 3969 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 3974 */     long __functionAddress = (GL.getICD()).glProgramUniform3fvEXT;
/* 3975 */     if (Checks.CHECKS) {
/* 3976 */       Checks.check(__functionAddress);
/*      */     }
/* 3978 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 3983 */     long __functionAddress = (GL.getICD()).glProgramUniform4fvEXT;
/* 3984 */     if (Checks.CHECKS) {
/* 3985 */       Checks.check(__functionAddress);
/*      */     }
/* 3987 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1ivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 3992 */     long __functionAddress = (GL.getICD()).glProgramUniform1ivEXT;
/* 3993 */     if (Checks.CHECKS) {
/* 3994 */       Checks.check(__functionAddress);
/*      */     }
/* 3996 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2ivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 4001 */     long __functionAddress = (GL.getICD()).glProgramUniform2ivEXT;
/* 4002 */     if (Checks.CHECKS) {
/* 4003 */       Checks.check(__functionAddress);
/*      */     }
/* 4005 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3ivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 4010 */     long __functionAddress = (GL.getICD()).glProgramUniform3ivEXT;
/* 4011 */     if (Checks.CHECKS) {
/* 4012 */       Checks.check(__functionAddress);
/*      */     }
/* 4014 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4ivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 4019 */     long __functionAddress = (GL.getICD()).glProgramUniform4ivEXT;
/* 4020 */     if (Checks.CHECKS) {
/* 4021 */       Checks.check(__functionAddress);
/*      */     }
/* 4023 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 4028 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2fvEXT;
/* 4029 */     if (Checks.CHECKS) {
/* 4030 */       Checks.check(__functionAddress);
/*      */     }
/* 4032 */     JNI.callPV(program, location, value.length >> 2, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 4037 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3fvEXT;
/* 4038 */     if (Checks.CHECKS) {
/* 4039 */       Checks.check(__functionAddress);
/*      */     }
/* 4041 */     JNI.callPV(program, location, value.length / 9, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 4046 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4fvEXT;
/* 4047 */     if (Checks.CHECKS) {
/* 4048 */       Checks.check(__functionAddress);
/*      */     }
/* 4050 */     JNI.callPV(program, location, value.length >> 4, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 4055 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2x3fvEXT;
/* 4056 */     if (Checks.CHECKS) {
/* 4057 */       Checks.check(__functionAddress);
/*      */     }
/* 4059 */     JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 4064 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3x2fvEXT;
/* 4065 */     if (Checks.CHECKS) {
/* 4066 */       Checks.check(__functionAddress);
/*      */     }
/* 4068 */     JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 4073 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2x4fvEXT;
/* 4074 */     if (Checks.CHECKS) {
/* 4075 */       Checks.check(__functionAddress);
/*      */     }
/* 4077 */     JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 4082 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4x2fvEXT;
/* 4083 */     if (Checks.CHECKS) {
/* 4084 */       Checks.check(__functionAddress);
/*      */     }
/* 4086 */     JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 4091 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3x4fvEXT;
/* 4092 */     if (Checks.CHECKS) {
/* 4093 */       Checks.check(__functionAddress);
/*      */     }
/* 4095 */     JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fvEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 4100 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4x3fvEXT;
/* 4101 */     if (Checks.CHECKS) {
/* 4102 */       Checks.check(__functionAddress);
/*      */     }
/* 4104 */     JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 4109 */     long __functionAddress = (GL.getICD()).glTextureParameterIivEXT;
/* 4110 */     if (Checks.CHECKS) {
/* 4111 */       Checks.check(__functionAddress);
/* 4112 */       Checks.check(params, 4);
/*      */     } 
/* 4114 */     JNI.callPV(texture, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int[] params) {
/* 4119 */     long __functionAddress = (GL.getICD()).glTextureParameterIuivEXT;
/* 4120 */     if (Checks.CHECKS) {
/* 4121 */       Checks.check(__functionAddress);
/* 4122 */       Checks.check(params, 4);
/*      */     } 
/* 4124 */     JNI.callPV(texture, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 4129 */     long __functionAddress = (GL.getICD()).glGetTextureParameterIivEXT;
/* 4130 */     if (Checks.CHECKS) {
/* 4131 */       Checks.check(__functionAddress);
/* 4132 */       Checks.check(params, 1);
/*      */     } 
/* 4134 */     JNI.callPV(texture, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuivEXT(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 4139 */     long __functionAddress = (GL.getICD()).glGetTextureParameterIuivEXT;
/* 4140 */     if (Checks.CHECKS) {
/* 4141 */       Checks.check(__functionAddress);
/* 4142 */       Checks.check(params, 1);
/*      */     } 
/* 4144 */     JNI.callPV(texture, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterIivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 4149 */     long __functionAddress = (GL.getICD()).glMultiTexParameterIivEXT;
/* 4150 */     if (Checks.CHECKS) {
/* 4151 */       Checks.check(__functionAddress);
/* 4152 */       Checks.check(params, 4);
/*      */     } 
/* 4154 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterIuivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int[] params) {
/* 4159 */     long __functionAddress = (GL.getICD()).glMultiTexParameterIuivEXT;
/* 4160 */     if (Checks.CHECKS) {
/* 4161 */       Checks.check(__functionAddress);
/* 4162 */       Checks.check(params, 4);
/*      */     } 
/* 4164 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterIivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 4169 */     long __functionAddress = (GL.getICD()).glGetMultiTexParameterIivEXT;
/* 4170 */     if (Checks.CHECKS) {
/* 4171 */       Checks.check(__functionAddress);
/* 4172 */       Checks.check(params, 1);
/*      */     } 
/* 4174 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterIuivEXT(@NativeType("GLenum") int texunit, @NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 4179 */     long __functionAddress = (GL.getICD()).glGetMultiTexParameterIuivEXT;
/* 4180 */     if (Checks.CHECKS) {
/* 4181 */       Checks.check(__functionAddress);
/* 4182 */       Checks.check(params, 1);
/*      */     } 
/* 4184 */     JNI.callPV(texunit, target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 4189 */     long __functionAddress = (GL.getICD()).glProgramUniform1uivEXT;
/* 4190 */     if (Checks.CHECKS) {
/* 4191 */       Checks.check(__functionAddress);
/*      */     }
/* 4193 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 4198 */     long __functionAddress = (GL.getICD()).glProgramUniform2uivEXT;
/* 4199 */     if (Checks.CHECKS) {
/* 4200 */       Checks.check(__functionAddress);
/*      */     }
/* 4202 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 4207 */     long __functionAddress = (GL.getICD()).glProgramUniform3uivEXT;
/* 4208 */     if (Checks.CHECKS) {
/* 4209 */       Checks.check(__functionAddress);
/*      */     }
/* 4211 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uivEXT(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 4216 */     long __functionAddress = (GL.getICD()).glProgramUniform4uivEXT;
/* 4217 */     if (Checks.CHECKS) {
/* 4218 */       Checks.check(__functionAddress);
/*      */     }
/* 4220 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameters4fvEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] params) {
/* 4225 */     long __functionAddress = (GL.getICD()).glNamedProgramLocalParameters4fvEXT;
/* 4226 */     if (Checks.CHECKS) {
/* 4227 */       Checks.check(__functionAddress);
/*      */     }
/* 4229 */     JNI.callPV(program, target, index, params.length >> 2, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameterI4ivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint const *") int[] params) {
/* 4234 */     long __functionAddress = (GL.getICD()).glNamedProgramLocalParameterI4ivEXT;
/* 4235 */     if (Checks.CHECKS) {
/* 4236 */       Checks.check(__functionAddress);
/* 4237 */       Checks.check(params, 4);
/*      */     } 
/* 4239 */     JNI.callPV(program, target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParametersI4ivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint const *") int[] params) {
/* 4244 */     long __functionAddress = (GL.getICD()).glNamedProgramLocalParametersI4ivEXT;
/* 4245 */     if (Checks.CHECKS) {
/* 4246 */       Checks.check(__functionAddress);
/*      */     }
/* 4248 */     JNI.callPV(program, target, index, params.length >> 2, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameterI4uivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLuint const *") int[] params) {
/* 4253 */     long __functionAddress = (GL.getICD()).glNamedProgramLocalParameterI4uivEXT;
/* 4254 */     if (Checks.CHECKS) {
/* 4255 */       Checks.check(__functionAddress);
/* 4256 */       Checks.check(params, 4);
/*      */     } 
/* 4258 */     JNI.callPV(program, target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParametersI4uivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLuint const *") int[] params) {
/* 4263 */     long __functionAddress = (GL.getICD()).glNamedProgramLocalParametersI4uivEXT;
/* 4264 */     if (Checks.CHECKS) {
/* 4265 */       Checks.check(__functionAddress);
/*      */     }
/* 4267 */     JNI.callPV(program, target, index, params.length >> 2, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterIivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint *") int[] params) {
/* 4272 */     long __functionAddress = (GL.getICD()).glGetNamedProgramLocalParameterIivEXT;
/* 4273 */     if (Checks.CHECKS) {
/* 4274 */       Checks.check(__functionAddress);
/* 4275 */       Checks.check(params, 4);
/*      */     } 
/* 4277 */     JNI.callPV(program, target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterIuivEXT(@NativeType("GLuint") int program, @NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLuint *") int[] params) {
/* 4282 */     long __functionAddress = (GL.getICD()).glGetNamedProgramLocalParameterIuivEXT;
/* 4283 */     if (Checks.CHECKS) {
/* 4284 */       Checks.check(__functionAddress);
/* 4285 */       Checks.check(params, 4);
/*      */     } 
/* 4287 */     JNI.callPV(program, target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameterivEXT(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 4292 */     long __functionAddress = (GL.getICD()).glGetNamedRenderbufferParameterivEXT;
/* 4293 */     if (Checks.CHECKS) {
/* 4294 */       Checks.check(__functionAddress);
/* 4295 */       Checks.check(params, 1);
/*      */     } 
/* 4297 */     JNI.callPV(renderbuffer, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameterivEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 4302 */     long __functionAddress = (GL.getICD()).glGetNamedFramebufferAttachmentParameterivEXT;
/* 4303 */     if (Checks.CHECKS) {
/* 4304 */       Checks.check(__functionAddress);
/* 4305 */       Checks.check(params, 1);
/*      */     } 
/* 4307 */     JNI.callPV(framebuffer, attachment, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glFramebufferDrawBuffersEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] bufs) {
/* 4312 */     long __functionAddress = (GL.getICD()).glFramebufferDrawBuffersEXT;
/* 4313 */     if (Checks.CHECKS) {
/* 4314 */       Checks.check(__functionAddress);
/*      */     }
/* 4316 */     JNI.callPV(framebuffer, bufs.length, bufs, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferParameterivEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 4321 */     long __functionAddress = (GL.getICD()).glGetFramebufferParameterivEXT;
/* 4322 */     if (Checks.CHECKS) {
/* 4323 */       Checks.check(__functionAddress);
/* 4324 */       Checks.check(param, 1);
/*      */     } 
/* 4326 */     JNI.callPV(framebuffer, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIntegervEXT(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 4331 */     long __functionAddress = (GL.getICD()).glGetVertexArrayIntegervEXT;
/* 4332 */     if (Checks.CHECKS) {
/* 4333 */       Checks.check(__functionAddress);
/* 4334 */       Checks.check(param, 1);
/*      */     } 
/* 4336 */     JNI.callPV(vaobj, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIntegeri_vEXT(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 4341 */     long __functionAddress = (GL.getICD()).glGetVertexArrayIntegeri_vEXT;
/* 4342 */     if (Checks.CHECKS) {
/* 4343 */       Checks.check(__functionAddress);
/* 4344 */       Checks.check(param, 1);
/*      */     } 
/* 4346 */     JNI.callPV(vaobj, index, pname, param, __functionAddress);
/*      */   }
/*      */   
/*      */   public static native void glClientAttribDefaultEXT(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void glPushClientAttribDefaultEXT(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void nglMatrixLoadfEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoaddEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultfEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultdEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glMatrixLoadIdentityEXT(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glMatrixRotatefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glMatrixRotatedEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glMatrixScalefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glMatrixScaledEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glMatrixTranslatefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glMatrixTranslatedEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glMatrixOrthoEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLdouble") double paramDouble5, @NativeType("GLdouble") double paramDouble6);
/*      */   
/*      */   public static native void glMatrixFrustumEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLdouble") double paramDouble5, @NativeType("GLdouble") double paramDouble6);
/*      */   
/*      */   public static native void glMatrixPushEXT(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glMatrixPopEXT(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glTextureParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglTextureParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glTextureParameterfEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTextureParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglTextureImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglTextureImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void glCopyTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8);
/*      */   
/*      */   public static native void glCopyTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLint") int paramInt9);
/*      */   
/*      */   public static native void glCopyTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7);
/*      */   
/*      */   public static native void glCopyTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9);
/*      */   
/*      */   public static native void nglGetTextureImageEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureLevelParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureLevelParameterivEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglTextureImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void glCopyTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLsizei") int paramInt10);
/*      */   
/*      */   public static native void glBindMultiTextureEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void nglMultiTexCoordPointerEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glMultiTexEnvfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglMultiTexEnvfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexEnviEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglMultiTexEnvivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexGendEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglMultiTexGendvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexGenfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglMultiTexGenfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexGeniEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglMultiTexGenivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexEnvfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexEnvivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexGendvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexGenfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexGenivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexParameteriEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglMultiTexParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexParameterfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglMultiTexParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexSubImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexSubImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void glCopyMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8);
/*      */   
/*      */   public static native void glCopyMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLint") int paramInt9);
/*      */   
/*      */   public static native void glCopyMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7);
/*      */   
/*      */   public static native void glCopyMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9);
/*      */   
/*      */   public static native void nglGetMultiTexImageEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexLevelParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexLevelParameterivEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexSubImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void glCopyMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLsizei") int paramInt10);
/*      */   
/*      */   public static native void glEnableClientStateIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDisableClientStateIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glEnableClientStateiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDisableClientStateiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglGetFloatIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetDoubleIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPointerIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetFloati_vEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetDoublei_vEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPointeri_vEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglNamedProgramStringEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glNamedProgramLocalParameter4dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameter4dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glNamedProgramLocalParameter4fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameter4fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramLocalParameterdvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramLocalParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramStringEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglGetCompressedTextureImageEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexSubImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexSubImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexSubImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglGetCompressedMultiTexImageEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoadTransposefEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoadTransposedEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultTransposefEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultTransposedEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglNamedBufferDataEXT(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nglNamedBufferSubDataEXT(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nglMapNamedBufferEXT(int paramInt1, int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glUnmapNamedBufferEXT(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglGetNamedBufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedBufferSubDataEXT(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void glProgramUniform1fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glProgramUniform2fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glProgramUniform3fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glProgramUniform4fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glProgramUniform1iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glProgramUniform2iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glProgramUniform3iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glProgramUniform4iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*      */   
/*      */   public static native void nglProgramUniform1fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform1ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x3fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x2fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x4fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x2fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x4fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x3fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void glTextureBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glMultiTexBufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void nglTextureParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglTextureParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glProgramUniform1uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glProgramUniform2uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glProgramUniform3uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glProgramUniform4uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6);
/*      */   
/*      */   public static native void nglProgramUniform1uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameters4fvEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glNamedProgramLocalParameterI4iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameterI4ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglNamedProgramLocalParametersI4ivEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glNamedProgramLocalParameterI4uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint") int paramInt7);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameterI4uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglNamedProgramLocalParametersI4uivEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramLocalParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramLocalParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glNamedRenderbufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void nglGetNamedRenderbufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glNamedRenderbufferStorageMultisampleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void glNamedRenderbufferStorageMultisampleCoverageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glCheckNamedFramebufferStatusEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glNamedFramebufferTexture1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glNamedFramebufferTexture2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glNamedFramebufferTexture3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*      */   
/*      */   public static native void glNamedFramebufferRenderbufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void nglGetNamedFramebufferAttachmentParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glGenerateTextureMipmapEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glGenerateMultiTexMipmapEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glFramebufferDrawBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglFramebufferDrawBuffersEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glFramebufferReadBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglGetFramebufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glNamedCopyBufferSubDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3);
/*      */   
/*      */   public static native void glNamedFramebufferTextureEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glNamedFramebufferTextureLayerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glNamedFramebufferTextureFaceEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5);
/*      */   
/*      */   public static native void glTextureRenderbufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glMultiTexRenderbufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glVertexArrayVertexOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayColorOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayEdgeFlagOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayIndexOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayNormalOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayTexCoordOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayMultiTexCoordOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayFogCoordOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArraySecondaryColorOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayVertexAttribOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt6, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayVertexAttribIOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glEnableVertexArrayEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glDisableVertexArrayEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glEnableVertexArrayAttribEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDisableVertexArrayAttribEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglGetVertexArrayIntegervEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayPointervEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayIntegeri_vEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayPointeri_vEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native long nglMapNamedBufferRangeEXT(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void glFlushMappedNamedBufferRangeEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTDirectStateAccess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */