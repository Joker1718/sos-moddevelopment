/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBImaging
/*     */ {
/*     */   public static final int GL_COLOR_TABLE = 32976;
/*     */   public static final int GL_POST_CONVOLUTION_COLOR_TABLE = 32977;
/*     */   public static final int GL_POST_COLOR_MATRIX_COLOR_TABLE = 32978;
/*     */   public static final int GL_PROXY_COLOR_TABLE = 32979;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_PROXY_POST_CONVOLUTION_COLOR_TABLE = 32980;
/*     */   
/*     */   public static final int GL_PROXY_POST_COLOR_MATRIX_COLOR_TABLE = 32981;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_SCALE = 32982;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_BIAS = 32983;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_FORMAT = 32984;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_WIDTH = 32985;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_RED_SIZE = 32986;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_GREEN_SIZE = 32987;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_BLUE_SIZE = 32988;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_ALPHA_SIZE = 32989;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_LUMINANCE_SIZE = 32990;
/*     */   
/*     */   public static final int GL_COLOR_TABLE_INTENSITY_SIZE = 32991;
/*     */   
/*     */   public static final int GL_TABLE_TOO_LARGE = 32817;
/*     */   
/*     */   public static final int GL_CONVOLUTION_1D = 32784;
/*     */   
/*     */   public static final int GL_CONVOLUTION_2D = 32785;
/*     */   
/*     */   public static final int GL_SEPARABLE_2D = 32786;
/*     */   
/*     */   public static final int GL_CONVOLUTION_BORDER_MODE = 32787;
/*     */   
/*     */   public static final int GL_CONVOLUTION_FILTER_SCALE = 32788;
/*     */   
/*     */   public static final int GL_CONVOLUTION_FILTER_BIAS = 32789;
/*     */   
/*     */   public static final int GL_REDUCE = 32790;
/*     */   
/*     */   public static final int GL_CONVOLUTION_FORMAT = 32791;
/*     */   
/*     */   public static final int GL_CONVOLUTION_WIDTH = 32792;
/*     */   
/*     */   public static final int GL_CONVOLUTION_HEIGHT = 32793;
/*     */   
/*     */   public static final int GL_MAX_CONVOLUTION_WIDTH = 32794;
/*     */   
/*     */   public static final int GL_MAX_CONVOLUTION_HEIGHT = 32795;
/*     */   
/*     */   public static final int GL_POST_CONVOLUTION_RED_SCALE = 32796;
/*     */   
/*     */   public static final int GL_POST_CONVOLUTION_GREEN_SCALE = 32797;
/*     */   
/*     */   public static final int GL_POST_CONVOLUTION_BLUE_SCALE = 32798;
/*     */   
/*     */   public static final int GL_POST_CONVOLUTION_ALPHA_SCALE = 32799;
/*     */   
/*     */   public static final int GL_POST_CONVOLUTION_RED_BIAS = 32800;
/*     */   
/*     */   public static final int GL_POST_CONVOLUTION_GREEN_BIAS = 32801;
/*     */   
/*     */   public static final int GL_POST_CONVOLUTION_BLUE_BIAS = 32802;
/*     */   
/*     */   public static final int GL_POST_CONVOLUTION_ALPHA_BIAS = 32803;
/*     */   
/*     */   public static final int GL_CONSTANT_BORDER = 33105;
/*     */   
/*     */   public static final int GL_REPLICATE_BORDER = 33107;
/*     */   
/*     */   public static final int GL_CONVOLUTION_BORDER_COLOR = 33108;
/*     */   
/*     */   public static final int GL_COLOR_MATRIX = 32945;
/*     */   
/*     */   public static final int GL_COLOR_MATRIX_STACK_DEPTH = 32946;
/*     */   
/*     */   public static final int GL_MAX_COLOR_MATRIX_STACK_DEPTH = 32947;
/*     */   
/*     */   public static final int GL_POST_COLOR_MATRIX_RED_SCALE = 32948;
/*     */   
/*     */   public static final int GL_POST_COLOR_MATRIX_GREEN_SCALE = 32949;
/*     */   
/*     */   public static final int GL_POST_COLOR_MATRIX_BLUE_SCALE = 32950;
/*     */   
/*     */   public static final int GL_POST_COLOR_MATRIX_ALPHA_SCALE = 32951;
/*     */   
/*     */   public static final int GL_POST_COLOR_MATRIX_RED_BIAS = 32952;
/*     */   public static final int GL_POST_COLOR_MATRIX_GREEN_BIAS = 32953;
/*     */   public static final int GL_POST_COLOR_MATRIX_BLUE_BIAS = 32954;
/*     */   public static final int GL_POST_COLOR_MATRIX_ALPHA_BIAS = 32955;
/*     */   public static final int GL_HISTOGRAM = 32804;
/*     */   public static final int GL_PROXY_HISTOGRAM = 32805;
/*     */   public static final int GL_HISTOGRAM_WIDTH = 32806;
/*     */   public static final int GL_HISTOGRAM_FORMAT = 32807;
/*     */   public static final int GL_HISTOGRAM_RED_SIZE = 32808;
/*     */   public static final int GL_HISTOGRAM_GREEN_SIZE = 32809;
/*     */   public static final int GL_HISTOGRAM_BLUE_SIZE = 32810;
/*     */   public static final int GL_HISTOGRAM_ALPHA_SIZE = 32811;
/*     */   public static final int GL_HISTOGRAM_LUMINANCE_SIZE = 32812;
/*     */   public static final int GL_HISTOGRAM_SINK = 32813;
/*     */   public static final int GL_MINMAX = 32814;
/*     */   public static final int GL_MINMAX_FORMAT = 32815;
/*     */   public static final int GL_MINMAX_SINK = 32816;
/*     */   public static final int GL_CONSTANT_COLOR = 32769;
/*     */   public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
/*     */   public static final int GL_CONSTANT_ALPHA = 32771;
/*     */   public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
/*     */   public static final int GL_BLEND_COLOR = 32773;
/*     */   public static final int GL_FUNC_ADD = 32774;
/*     */   public static final int GL_MIN = 32775;
/*     */   public static final int GL_MAX = 32776;
/*     */   public static final int GL_BLEND_EQUATION = 32777;
/*     */   public static final int GL_FUNC_SUBTRACT = 32778;
/*     */   public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
/*     */   
/*     */   protected ARBImaging() {
/* 141 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer table) {
/* 151 */     nglColorTable(target, internalformat, width, format, type, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long table) {
/* 156 */     nglColorTable(target, internalformat, width, format, type, table);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer table) {
/* 161 */     nglColorTable(target, internalformat, width, format, type, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer table) {
/* 166 */     nglColorTable(target, internalformat, width, format, type, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer table) {
/* 171 */     nglColorTable(target, internalformat, width, format, type, MemoryUtil.memAddress(table));
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
/*     */   public static void glColorTableParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 186 */     if (Checks.CHECKS) {
/* 187 */       Checks.check(params, 4);
/*     */     }
/* 189 */     nglColorTableParameteriv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glColorTableParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check(params, 4);
/*     */     }
/* 202 */     nglColorTableParameterfv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer table) {
/* 212 */     nglGetColorTable(target, format, type, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long table) {
/* 217 */     nglGetColorTable(target, format, type, table);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer table) {
/* 222 */     nglGetColorTable(target, format, type, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer table) {
/* 227 */     nglGetColorTable(target, format, type, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer table) {
/* 232 */     nglGetColorTable(target, format, type, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetColorTableParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 242 */     if (Checks.CHECKS) {
/* 243 */       Checks.check(params, 4);
/*     */     }
/* 245 */     nglGetColorTableParameteriv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetColorTableParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 251 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 253 */       IntBuffer params = stack.callocInt(1);
/* 254 */       nglGetColorTableParameteriv(target, pname, MemoryUtil.memAddress(params));
/* 255 */       return params.get(0);
/*     */     } finally {
/* 257 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetColorTableParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 268 */     if (Checks.CHECKS) {
/* 269 */       Checks.check(params, 4);
/*     */     }
/* 271 */     nglGetColorTableParameterfv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetColorTableParameterf(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 277 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 279 */       FloatBuffer params = stack.callocFloat(1);
/* 280 */       nglGetColorTableParameterfv(target, pname, MemoryUtil.memAddress(params));
/* 281 */       return params.get(0);
/*     */     } finally {
/* 283 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glColorSubTable(@NativeType("GLenum") int target, @NativeType("GLsizei") int start, @NativeType("GLsizei") int count, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/* 294 */     nglColorSubTable(target, start, count, format, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorSubTable(@NativeType("GLenum") int target, @NativeType("GLsizei") int start, @NativeType("GLsizei") int count, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long data) {
/* 299 */     nglColorSubTable(target, start, count, format, type, data);
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
/*     */   public static void glConvolutionFilter1D(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/* 314 */     nglConvolutionFilter1D(target, internalformat, width, format, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glConvolutionFilter1D(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long data) {
/* 319 */     nglConvolutionFilter1D(target, internalformat, width, format, type, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glConvolutionFilter2D(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/* 329 */     nglConvolutionFilter2D(target, internalformat, width, height, format, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glConvolutionFilter2D(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long data) {
/* 334 */     nglConvolutionFilter2D(target, internalformat, width, height, format, type, data);
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
/*     */   public static void glGetConvolutionFilter(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer image) {
/* 354 */     nglGetConvolutionFilter(target, format, type, MemoryUtil.memAddress(image));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetConvolutionFilter(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long image) {
/* 359 */     nglGetConvolutionFilter(target, format, type, image);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSeparableFilter2D(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer row, @NativeType("void const *") ByteBuffer column) {
/* 369 */     nglSeparableFilter2D(target, internalformat, width, height, format, type, MemoryUtil.memAddress(row), MemoryUtil.memAddress(column));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSeparableFilter2D(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long row, @NativeType("void const *") long column) {
/* 374 */     nglSeparableFilter2D(target, internalformat, width, height, format, type, row, column);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSeparableFilter(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer row, @NativeType("void *") ByteBuffer column, @NativeType("void *") ByteBuffer span) {
/* 384 */     nglGetSeparableFilter(target, format, type, MemoryUtil.memAddress(row), MemoryUtil.memAddress(column), MemoryUtil.memAddressSafe(span));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSeparableFilter(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long row, @NativeType("void *") long column, @NativeType("void *") ByteBuffer span) {
/* 389 */     nglGetSeparableFilter(target, format, type, row, column, MemoryUtil.memAddressSafe(span));
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
/*     */   public static void glConvolutionParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 404 */     if (Checks.CHECKS) {
/* 405 */       Checks.check(params, 4);
/*     */     }
/* 407 */     nglConvolutionParameteriv(target, pname, MemoryUtil.memAddress(params));
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
/*     */   public static void glConvolutionParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 422 */     if (Checks.CHECKS) {
/* 423 */       Checks.check(params, 4);
/*     */     }
/* 425 */     nglConvolutionParameterfv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetConvolutionParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 435 */     if (Checks.CHECKS) {
/* 436 */       Checks.check(params, 4);
/*     */     }
/* 438 */     nglGetConvolutionParameteriv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetConvolutionParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 444 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 446 */       IntBuffer params = stack.callocInt(1);
/* 447 */       nglGetConvolutionParameteriv(target, pname, MemoryUtil.memAddress(params));
/* 448 */       return params.get(0);
/*     */     } finally {
/* 450 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetConvolutionParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 461 */     if (Checks.CHECKS) {
/* 462 */       Checks.check(params, 4);
/*     */     }
/* 464 */     nglGetConvolutionParameterfv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetConvolutionParameterf(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 470 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 472 */       FloatBuffer params = stack.callocFloat(1);
/* 473 */       nglGetConvolutionParameterfv(target, pname, MemoryUtil.memAddress(params));
/* 474 */       return params.get(0);
/*     */     } finally {
/* 476 */       stack.setPointer(stackPointer);
/*     */     } 
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
/*     */   public static void glGetHistogram(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer values) {
/* 497 */     nglGetHistogram(target, reset, format, type, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetHistogram(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long values) {
/* 502 */     nglGetHistogram(target, reset, format, type, values);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetHistogramParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 512 */     if (Checks.CHECKS) {
/* 513 */       Checks.check(params, 1);
/*     */     }
/* 515 */     nglGetHistogramParameteriv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetHistogramParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 521 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 523 */       IntBuffer params = stack.callocInt(1);
/* 524 */       nglGetHistogramParameteriv(target, pname, MemoryUtil.memAddress(params));
/* 525 */       return params.get(0);
/*     */     } finally {
/* 527 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetHistogramParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 538 */     if (Checks.CHECKS) {
/* 539 */       Checks.check(params, 1);
/*     */     }
/* 541 */     nglGetHistogramParameterfv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetHistogramParameterf(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 547 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 549 */       FloatBuffer params = stack.callocFloat(1);
/* 550 */       nglGetHistogramParameterfv(target, pname, MemoryUtil.memAddress(params));
/* 551 */       return params.get(0);
/*     */     } finally {
/* 553 */       stack.setPointer(stackPointer);
/*     */     } 
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
/*     */   public static void glGetMinmax(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer values) {
/* 574 */     nglGetMinmax(target, reset, format, type, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetMinmax(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long values) {
/* 579 */     nglGetMinmax(target, reset, format, type, values);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetMinmaxParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 589 */     if (Checks.CHECKS) {
/* 590 */       Checks.check(params, 1);
/*     */     }
/* 592 */     nglGetMinmaxParameteriv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetMinmaxParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 598 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 600 */       IntBuffer params = stack.callocInt(1);
/* 601 */       nglGetMinmaxParameteriv(target, pname, MemoryUtil.memAddress(params));
/* 602 */       return params.get(0);
/*     */     } finally {
/* 604 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetMinmaxParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 615 */     if (Checks.CHECKS) {
/* 616 */       Checks.check(params, 1);
/*     */     }
/* 618 */     nglGetMinmaxParameterfv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetMinmaxParameterf(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 624 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 626 */       FloatBuffer params = stack.callocFloat(1);
/* 627 */       nglGetMinmaxParameterfv(target, pname, MemoryUtil.memAddress(params));
/* 628 */       return params.get(0);
/*     */     } finally {
/* 630 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlendColor(@NativeType("GLfloat") float red, @NativeType("GLfloat") float green, @NativeType("GLfloat") float blue, @NativeType("GLfloat") float alpha) {
/* 638 */     GL14C.glBlendColor(red, green, blue, alpha);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlendEquation(@NativeType("GLenum") int mode) {
/* 645 */     GL14C.glBlendEquation(mode);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] table) {
/* 650 */     long __functionAddress = (GL.getICD()).glColorTable;
/* 651 */     if (Checks.CHECKS) {
/* 652 */       Checks.check(__functionAddress);
/*     */     }
/* 654 */     JNI.callPV(target, internalformat, width, format, type, table, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] table) {
/* 659 */     long __functionAddress = (GL.getICD()).glColorTable;
/* 660 */     if (Checks.CHECKS) {
/* 661 */       Checks.check(__functionAddress);
/*     */     }
/* 663 */     JNI.callPV(target, internalformat, width, format, type, table, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] table) {
/* 668 */     long __functionAddress = (GL.getICD()).glColorTable;
/* 669 */     if (Checks.CHECKS) {
/* 670 */       Checks.check(__functionAddress);
/*     */     }
/* 672 */     JNI.callPV(target, internalformat, width, format, type, table, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorTableParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 677 */     long __functionAddress = (GL.getICD()).glColorTableParameteriv;
/* 678 */     if (Checks.CHECKS) {
/* 679 */       Checks.check(__functionAddress);
/* 680 */       Checks.check(params, 4);
/*     */     } 
/* 682 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorTableParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 687 */     long __functionAddress = (GL.getICD()).glColorTableParameterfv;
/* 688 */     if (Checks.CHECKS) {
/* 689 */       Checks.check(__functionAddress);
/* 690 */       Checks.check(params, 4);
/*     */     } 
/* 692 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] table) {
/* 697 */     long __functionAddress = (GL.getICD()).glGetColorTable;
/* 698 */     if (Checks.CHECKS) {
/* 699 */       Checks.check(__functionAddress);
/*     */     }
/* 701 */     JNI.callPV(target, format, type, table, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] table) {
/* 706 */     long __functionAddress = (GL.getICD()).glGetColorTable;
/* 707 */     if (Checks.CHECKS) {
/* 708 */       Checks.check(__functionAddress);
/*     */     }
/* 710 */     JNI.callPV(target, format, type, table, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] table) {
/* 715 */     long __functionAddress = (GL.getICD()).glGetColorTable;
/* 716 */     if (Checks.CHECKS) {
/* 717 */       Checks.check(__functionAddress);
/*     */     }
/* 719 */     JNI.callPV(target, format, type, table, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetColorTableParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 724 */     long __functionAddress = (GL.getICD()).glGetColorTableParameteriv;
/* 725 */     if (Checks.CHECKS) {
/* 726 */       Checks.check(__functionAddress);
/* 727 */       Checks.check(params, 4);
/*     */     } 
/* 729 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetColorTableParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 734 */     long __functionAddress = (GL.getICD()).glGetColorTableParameterfv;
/* 735 */     if (Checks.CHECKS) {
/* 736 */       Checks.check(__functionAddress);
/* 737 */       Checks.check(params, 4);
/*     */     } 
/* 739 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glConvolutionParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 744 */     long __functionAddress = (GL.getICD()).glConvolutionParameteriv;
/* 745 */     if (Checks.CHECKS) {
/* 746 */       Checks.check(__functionAddress);
/* 747 */       Checks.check(params, 4);
/*     */     } 
/* 749 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glConvolutionParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 754 */     long __functionAddress = (GL.getICD()).glConvolutionParameterfv;
/* 755 */     if (Checks.CHECKS) {
/* 756 */       Checks.check(__functionAddress);
/* 757 */       Checks.check(params, 4);
/*     */     } 
/* 759 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetConvolutionParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 764 */     long __functionAddress = (GL.getICD()).glGetConvolutionParameteriv;
/* 765 */     if (Checks.CHECKS) {
/* 766 */       Checks.check(__functionAddress);
/* 767 */       Checks.check(params, 4);
/*     */     } 
/* 769 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetConvolutionParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 774 */     long __functionAddress = (GL.getICD()).glGetConvolutionParameterfv;
/* 775 */     if (Checks.CHECKS) {
/* 776 */       Checks.check(__functionAddress);
/* 777 */       Checks.check(params, 4);
/*     */     } 
/* 779 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetHistogramParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 784 */     long __functionAddress = (GL.getICD()).glGetHistogramParameteriv;
/* 785 */     if (Checks.CHECKS) {
/* 786 */       Checks.check(__functionAddress);
/* 787 */       Checks.check(params, 1);
/*     */     } 
/* 789 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetHistogramParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 794 */     long __functionAddress = (GL.getICD()).glGetHistogramParameterfv;
/* 795 */     if (Checks.CHECKS) {
/* 796 */       Checks.check(__functionAddress);
/* 797 */       Checks.check(params, 1);
/*     */     } 
/* 799 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetMinmaxParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 804 */     long __functionAddress = (GL.getICD()).glGetMinmaxParameteriv;
/* 805 */     if (Checks.CHECKS) {
/* 806 */       Checks.check(__functionAddress);
/* 807 */       Checks.check(params, 1);
/*     */     } 
/* 809 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetMinmaxParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 814 */     long __functionAddress = (GL.getICD()).glGetMinmaxParameterfv;
/* 815 */     if (Checks.CHECKS) {
/* 816 */       Checks.check(__functionAddress);
/* 817 */       Checks.check(params, 1);
/*     */     } 
/* 819 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglColorTable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*     */   
/*     */   public static native void glCopyColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*     */   
/*     */   public static native void nglColorTableParameteriv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglColorTableParameterfv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetColorTable(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetColorTableParameteriv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetColorTableParameterfv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglColorSubTable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*     */   
/*     */   public static native void glCopyColorSubTable(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*     */   
/*     */   public static native void nglConvolutionFilter1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*     */   
/*     */   public static native void nglConvolutionFilter2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*     */   
/*     */   public static native void glCopyConvolutionFilter1D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*     */   
/*     */   public static native void glCopyConvolutionFilter2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*     */   
/*     */   public static native void nglGetConvolutionFilter(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglSeparableFilter2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetSeparableFilter(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void glConvolutionParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void nglConvolutionParameteriv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glConvolutionParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void nglConvolutionParameterfv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetConvolutionParameteriv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetConvolutionParameterfv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glHistogram(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean);
/*     */   
/*     */   public static native void glResetHistogram(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglGetHistogram(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetHistogramParameteriv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetHistogramParameterfv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glMinmax(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean);
/*     */   
/*     */   public static native void glResetMinmax(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglGetMinmax(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetMinmaxParameteriv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetMinmaxParameterfv(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBImaging.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */