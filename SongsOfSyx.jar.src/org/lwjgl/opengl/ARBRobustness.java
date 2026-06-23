/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBRobustness
/*     */ {
/*     */   public static final int GL_GUILTY_CONTEXT_RESET_ARB = 33363;
/*     */   public static final int GL_INNOCENT_CONTEXT_RESET_ARB = 33364;
/*     */   public static final int GL_UNKNOWN_CONTEXT_RESET_ARB = 33365;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_RESET_NOTIFICATION_STRATEGY_ARB = 33366;
/*     */ 
/*     */   
/*     */   public static final int GL_LOSE_CONTEXT_ON_RESET_ARB = 33362;
/*     */   
/*     */   public static final int GL_NO_RESET_NOTIFICATION_ARB = 33377;
/*     */   
/*     */   public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT_ARB = 4;
/*     */ 
/*     */   
/*     */   protected ARBRobustness() {
/*  37 */     throw new UnsupportedOperationException();
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
/*     */   public static void glGetnMapdvARB(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLdouble *") DoubleBuffer data) {
/*  53 */     nglGetnMapdvARB(target, query, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static double glGetnMapdARB(@NativeType("GLenum") int target, @NativeType("GLenum") int query) {
/*  59 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  61 */       DoubleBuffer data = stack.callocDouble(1);
/*  62 */       nglGetnMapdvARB(target, query, 1, MemoryUtil.memAddress(data));
/*  63 */       return data.get(0);
/*     */     } finally {
/*  65 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnMapfvARB(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLfloat *") FloatBuffer data) {
/*  76 */     nglGetnMapfvARB(target, query, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetnMapfARB(@NativeType("GLenum") int target, @NativeType("GLenum") int query) {
/*  82 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  84 */       FloatBuffer data = stack.callocFloat(1);
/*  85 */       nglGetnMapfvARB(target, query, 1, MemoryUtil.memAddress(data));
/*  86 */       return data.get(0);
/*     */     } finally {
/*  88 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnMapivARB(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLint *") IntBuffer data) {
/*  99 */     nglGetnMapivARB(target, query, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetnMapiARB(@NativeType("GLenum") int target, @NativeType("GLenum") int query) {
/* 105 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 107 */       IntBuffer data = stack.callocInt(1);
/* 108 */       nglGetnMapivARB(target, query, 1, MemoryUtil.memAddress(data));
/* 109 */       return data.get(0);
/*     */     } finally {
/* 111 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnPixelMapfvARB(@NativeType("GLenum") int map, @NativeType("GLfloat *") FloatBuffer data) {
/* 122 */     nglGetnPixelMapfvARB(map, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnPixelMapuivARB(@NativeType("GLenum") int map, @NativeType("GLuint *") IntBuffer data) {
/* 132 */     nglGetnPixelMapuivARB(map, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnPixelMapusvARB(@NativeType("GLenum") int map, @NativeType("GLushort *") ShortBuffer data) {
/* 142 */     nglGetnPixelMapusvARB(map, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnPolygonStippleARB(@NativeType("GLsizei") int bufSize, @NativeType("GLubyte *") long pattern) {
/* 152 */     nglGetnPolygonStippleARB(bufSize, pattern);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnPolygonStippleARB(@NativeType("GLubyte *") ByteBuffer pattern) {
/* 157 */     nglGetnPolygonStippleARB(pattern.remaining(), MemoryUtil.memAddress(pattern));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long img) {
/* 167 */     nglGetnTexImageARB(tex, level, format, type, bufSize, img);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer img) {
/* 172 */     nglGetnTexImageARB(tex, level, format, type, img.remaining(), MemoryUtil.memAddress(img));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer img) {
/* 177 */     nglGetnTexImageARB(tex, level, format, type, img.remaining() << 1, MemoryUtil.memAddress(img));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer img) {
/* 182 */     nglGetnTexImageARB(tex, level, format, type, img.remaining() << 2, MemoryUtil.memAddress(img));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer img) {
/* 187 */     nglGetnTexImageARB(tex, level, format, type, img.remaining() << 2, MemoryUtil.memAddress(img));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer img) {
/* 192 */     nglGetnTexImageARB(tex, level, format, type, img.remaining() << 3, MemoryUtil.memAddress(img));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glReadnPixelsARB(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long data) {
/* 202 */     nglReadnPixelsARB(x, y, width, height, format, type, bufSize, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixelsARB(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer data) {
/* 207 */     nglReadnPixelsARB(x, y, width, height, format, type, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixelsARB(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer data) {
/* 212 */     nglReadnPixelsARB(x, y, width, height, format, type, data.remaining() << 1, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixelsARB(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer data) {
/* 217 */     nglReadnPixelsARB(x, y, width, height, format, type, data.remaining() << 2, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixelsARB(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer data) {
/* 222 */     nglReadnPixelsARB(x, y, width, height, format, type, data.remaining() << 2, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnColorTableARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long table) {
/* 232 */     nglGetnColorTableARB(target, format, type, bufSize, table);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnColorTableARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer table) {
/* 237 */     nglGetnColorTableARB(target, format, type, table.remaining(), MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnColorTableARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer table) {
/* 242 */     nglGetnColorTableARB(target, format, type, table.remaining() << 1, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnColorTableARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer table) {
/* 247 */     nglGetnColorTableARB(target, format, type, table.remaining() << 2, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnColorTableARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer table) {
/* 252 */     nglGetnColorTableARB(target, format, type, table.remaining() << 2, MemoryUtil.memAddress(table));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnConvolutionFilterARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long image) {
/* 262 */     nglGetnConvolutionFilterARB(target, format, type, bufSize, image);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnConvolutionFilterARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer image) {
/* 267 */     nglGetnConvolutionFilterARB(target, format, type, image.remaining(), MemoryUtil.memAddress(image));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnSeparableFilterARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int rowBufSize, @NativeType("void *") long row, @NativeType("GLsizei") int columnBufSize, @NativeType("void *") long column, @NativeType("void *") ByteBuffer span) {
/* 277 */     nglGetnSeparableFilterARB(target, format, type, rowBufSize, row, columnBufSize, column, MemoryUtil.memAddressSafe(span));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnSeparableFilterARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer row, @NativeType("void *") ByteBuffer column, @NativeType("void *") ByteBuffer span) {
/* 282 */     nglGetnSeparableFilterARB(target, format, type, row.remaining(), MemoryUtil.memAddress(row), column.remaining(), MemoryUtil.memAddress(column), MemoryUtil.memAddressSafe(span));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnHistogramARB(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long values) {
/* 292 */     nglGetnHistogramARB(target, reset, format, type, bufSize, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnHistogramARB(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer values) {
/* 297 */     nglGetnHistogramARB(target, reset, format, type, values.remaining(), MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnMinmaxARB(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long values) {
/* 307 */     nglGetnMinmaxARB(target, reset, format, type, bufSize, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnMinmaxARB(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer values) {
/* 312 */     nglGetnMinmaxARB(target, reset, format, type, values.remaining(), MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnCompressedTexImageARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLsizei") int bufSize, @NativeType("void *") long img) {
/* 322 */     nglGetnCompressedTexImageARB(target, level, bufSize, img);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnCompressedTexImageARB(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer img) {
/* 327 */     if (Checks.CHECKS && 
/* 328 */       Checks.DEBUG) {
/* 329 */       Checks.check(img, GL11.glGetTexLevelParameteri(target, level, 34464));
/*     */     }
/*     */     
/* 332 */     nglGetnCompressedTexImageARB(target, level, img.remaining(), MemoryUtil.memAddress(img));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnUniformfvARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") FloatBuffer params) {
/* 342 */     nglGetnUniformfvARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetnUniformfARB(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 348 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 350 */       FloatBuffer params = stack.callocFloat(1);
/* 351 */       nglGetnUniformfvARB(program, location, 1, MemoryUtil.memAddress(params));
/* 352 */       return params.get(0);
/*     */     } finally {
/* 354 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnUniformivARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") IntBuffer params) {
/* 365 */     nglGetnUniformivARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetnUniformiARB(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 371 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 373 */       IntBuffer params = stack.callocInt(1);
/* 374 */       nglGetnUniformivARB(program, location, 1, MemoryUtil.memAddress(params));
/* 375 */       return params.get(0);
/*     */     } finally {
/* 377 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnUniformuivARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") IntBuffer params) {
/* 388 */     nglGetnUniformuivARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetnUniformuiARB(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 394 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 396 */       IntBuffer params = stack.callocInt(1);
/* 397 */       nglGetnUniformuivARB(program, location, 1, MemoryUtil.memAddress(params));
/* 398 */       return params.get(0);
/*     */     } finally {
/* 400 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnUniformdvARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") DoubleBuffer params) {
/* 411 */     nglGetnUniformdvARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static double glGetnUniformdARB(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 417 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 419 */       DoubleBuffer params = stack.callocDouble(1);
/* 420 */       nglGetnUniformdvARB(program, location, 1, MemoryUtil.memAddress(params));
/* 421 */       return params.get(0);
/*     */     } finally {
/* 423 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnMapdvARB(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLdouble *") double[] data) {
/* 429 */     long __functionAddress = (GL.getICD()).glGetnMapdvARB;
/* 430 */     if (Checks.CHECKS) {
/* 431 */       Checks.check(__functionAddress);
/*     */     }
/* 433 */     JNI.callPV(target, query, data.length, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnMapfvARB(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLfloat *") float[] data) {
/* 438 */     long __functionAddress = (GL.getICD()).glGetnMapfvARB;
/* 439 */     if (Checks.CHECKS) {
/* 440 */       Checks.check(__functionAddress);
/*     */     }
/* 442 */     JNI.callPV(target, query, data.length, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnMapivARB(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLint *") int[] data) {
/* 447 */     long __functionAddress = (GL.getICD()).glGetnMapivARB;
/* 448 */     if (Checks.CHECKS) {
/* 449 */       Checks.check(__functionAddress);
/*     */     }
/* 451 */     JNI.callPV(target, query, data.length, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnPixelMapfvARB(@NativeType("GLenum") int map, @NativeType("GLfloat *") float[] data) {
/* 456 */     long __functionAddress = (GL.getICD()).glGetnPixelMapfvARB;
/* 457 */     if (Checks.CHECKS) {
/* 458 */       Checks.check(__functionAddress);
/*     */     }
/* 460 */     JNI.callPV(map, data.length, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnPixelMapuivARB(@NativeType("GLenum") int map, @NativeType("GLuint *") int[] data) {
/* 465 */     long __functionAddress = (GL.getICD()).glGetnPixelMapuivARB;
/* 466 */     if (Checks.CHECKS) {
/* 467 */       Checks.check(__functionAddress);
/*     */     }
/* 469 */     JNI.callPV(map, data.length, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnPixelMapusvARB(@NativeType("GLenum") int map, @NativeType("GLushort *") short[] data) {
/* 474 */     long __functionAddress = (GL.getICD()).glGetnPixelMapusvARB;
/* 475 */     if (Checks.CHECKS) {
/* 476 */       Checks.check(__functionAddress);
/*     */     }
/* 478 */     JNI.callPV(map, data.length, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] img) {
/* 483 */     long __functionAddress = (GL.getICD()).glGetnTexImageARB;
/* 484 */     if (Checks.CHECKS) {
/* 485 */       Checks.check(__functionAddress);
/*     */     }
/* 487 */     JNI.callPV(tex, level, format, type, img.length << 1, img, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] img) {
/* 492 */     long __functionAddress = (GL.getICD()).glGetnTexImageARB;
/* 493 */     if (Checks.CHECKS) {
/* 494 */       Checks.check(__functionAddress);
/*     */     }
/* 496 */     JNI.callPV(tex, level, format, type, img.length << 2, img, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] img) {
/* 501 */     long __functionAddress = (GL.getICD()).glGetnTexImageARB;
/* 502 */     if (Checks.CHECKS) {
/* 503 */       Checks.check(__functionAddress);
/*     */     }
/* 505 */     JNI.callPV(tex, level, format, type, img.length << 2, img, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnTexImageARB(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] img) {
/* 510 */     long __functionAddress = (GL.getICD()).glGetnTexImageARB;
/* 511 */     if (Checks.CHECKS) {
/* 512 */       Checks.check(__functionAddress);
/*     */     }
/* 514 */     JNI.callPV(tex, level, format, type, img.length << 3, img, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixelsARB(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] data) {
/* 519 */     long __functionAddress = (GL.getICD()).glReadnPixelsARB;
/* 520 */     if (Checks.CHECKS) {
/* 521 */       Checks.check(__functionAddress);
/*     */     }
/* 523 */     JNI.callPV(x, y, width, height, format, type, data.length << 1, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixelsARB(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] data) {
/* 528 */     long __functionAddress = (GL.getICD()).glReadnPixelsARB;
/* 529 */     if (Checks.CHECKS) {
/* 530 */       Checks.check(__functionAddress);
/*     */     }
/* 532 */     JNI.callPV(x, y, width, height, format, type, data.length << 2, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixelsARB(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] data) {
/* 537 */     long __functionAddress = (GL.getICD()).glReadnPixelsARB;
/* 538 */     if (Checks.CHECKS) {
/* 539 */       Checks.check(__functionAddress);
/*     */     }
/* 541 */     JNI.callPV(x, y, width, height, format, type, data.length << 2, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnColorTableARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] table) {
/* 546 */     long __functionAddress = (GL.getICD()).glGetnColorTableARB;
/* 547 */     if (Checks.CHECKS) {
/* 548 */       Checks.check(__functionAddress);
/*     */     }
/* 550 */     JNI.callPV(target, format, type, table.length << 1, table, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnColorTableARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] table) {
/* 555 */     long __functionAddress = (GL.getICD()).glGetnColorTableARB;
/* 556 */     if (Checks.CHECKS) {
/* 557 */       Checks.check(__functionAddress);
/*     */     }
/* 559 */     JNI.callPV(target, format, type, table.length << 2, table, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnColorTableARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] table) {
/* 564 */     long __functionAddress = (GL.getICD()).glGetnColorTableARB;
/* 565 */     if (Checks.CHECKS) {
/* 566 */       Checks.check(__functionAddress);
/*     */     }
/* 568 */     JNI.callPV(target, format, type, table.length << 2, table, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformfvARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") float[] params) {
/* 573 */     long __functionAddress = (GL.getICD()).glGetnUniformfvARB;
/* 574 */     if (Checks.CHECKS) {
/* 575 */       Checks.check(__functionAddress);
/*     */     }
/* 577 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformivARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") int[] params) {
/* 582 */     long __functionAddress = (GL.getICD()).glGetnUniformivARB;
/* 583 */     if (Checks.CHECKS) {
/* 584 */       Checks.check(__functionAddress);
/*     */     }
/* 586 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformuivARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") int[] params) {
/* 591 */     long __functionAddress = (GL.getICD()).glGetnUniformuivARB;
/* 592 */     if (Checks.CHECKS) {
/* 593 */       Checks.check(__functionAddress);
/*     */     }
/* 595 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformdvARB(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") double[] params) {
/* 600 */     long __functionAddress = (GL.getICD()).glGetnUniformdvARB;
/* 601 */     if (Checks.CHECKS) {
/* 602 */       Checks.check(__functionAddress);
/*     */     }
/* 604 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*     */   }
/*     */   
/*     */   @NativeType("GLenum")
/*     */   public static native int glGetGraphicsResetStatusARB();
/*     */   
/*     */   public static native void nglGetnMapdvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetnMapfvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetnMapivARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetnPixelMapfvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetnPixelMapuivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetnPixelMapusvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetnPolygonStippleARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetnTexImageARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*     */   
/*     */   public static native void nglReadnPixelsARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*     */   
/*     */   public static native void nglGetnColorTableARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglGetnConvolutionFilterARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglGetnSeparableFilterARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nglGetnHistogramARB(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglGetnMinmaxARB(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglGetnCompressedTexImageARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetnUniformfvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetnUniformivARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetnUniformuivARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetnUniformdvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBRobustness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */