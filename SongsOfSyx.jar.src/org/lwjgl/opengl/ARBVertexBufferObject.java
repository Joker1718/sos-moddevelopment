/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBVertexBufferObject
/*     */ {
/*     */   public static final int GL_ARRAY_BUFFER_ARB = 34962;
/*     */   public static final int GL_ELEMENT_ARRAY_BUFFER_ARB = 34963;
/*     */   public static final int GL_ARRAY_BUFFER_BINDING_ARB = 34964;
/*     */   
/*     */   static {
/*  24 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING_ARB = 34965;
/*     */   
/*     */   public static final int GL_VERTEX_ARRAY_BUFFER_BINDING_ARB = 34966;
/*     */   
/*     */   public static final int GL_NORMAL_ARRAY_BUFFER_BINDING_ARB = 34967;
/*     */   
/*     */   public static final int GL_COLOR_ARRAY_BUFFER_BINDING_ARB = 34968;
/*     */   
/*     */   public static final int GL_INDEX_ARRAY_BUFFER_BINDING_ARB = 34969;
/*     */   
/*     */   public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING_ARB = 34970;
/*     */   
/*     */   public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING_ARB = 34971;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING_ARB = 34972;
/*     */   
/*     */   public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING_ARB = 34973;
/*     */   
/*     */   public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING_ARB = 34974;
/*     */   
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING_ARB = 34975;
/*     */   
/*     */   public static final int GL_STREAM_DRAW_ARB = 35040;
/*     */   
/*     */   public static final int GL_STREAM_READ_ARB = 35041;
/*     */   public static final int GL_STREAM_COPY_ARB = 35042;
/*     */   public static final int GL_STATIC_DRAW_ARB = 35044;
/*     */   public static final int GL_STATIC_READ_ARB = 35045;
/*     */   public static final int GL_STATIC_COPY_ARB = 35046;
/*     */   public static final int GL_DYNAMIC_DRAW_ARB = 35048;
/*     */   public static final int GL_DYNAMIC_READ_ARB = 35049;
/*     */   public static final int GL_DYNAMIC_COPY_ARB = 35050;
/*     */   public static final int GL_READ_ONLY_ARB = 35000;
/*     */   public static final int GL_WRITE_ONLY_ARB = 35001;
/*     */   public static final int GL_READ_WRITE_ARB = 35002;
/*     */   public static final int GL_BUFFER_SIZE_ARB = 34660;
/*     */   public static final int GL_BUFFER_USAGE_ARB = 34661;
/*     */   public static final int GL_BUFFER_ACCESS_ARB = 35003;
/*     */   public static final int GL_BUFFER_MAPPED_ARB = 35004;
/*     */   public static final int GL_BUFFER_MAP_POINTER_ARB = 35005;
/*     */   
/*     */   protected ARBVertexBufferObject() {
/*  70 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDeleteBuffersARB(@NativeType("GLuint const *") IntBuffer buffers) {
/*  85 */     nglDeleteBuffersARB(buffers.remaining(), MemoryUtil.memAddress(buffers));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteBuffersARB(@NativeType("GLuint const *") int buffer) {
/*  90 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  92 */       IntBuffer buffers = stack.ints(buffer);
/*  93 */       nglDeleteBuffersARB(1, MemoryUtil.memAddress(buffers));
/*     */     } finally {
/*  95 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenBuffersARB(@NativeType("GLuint *") IntBuffer buffers) {
/* 106 */     nglGenBuffersARB(buffers.remaining(), MemoryUtil.memAddress(buffers));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenBuffersARB() {
/* 112 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 114 */       IntBuffer buffers = stack.callocInt(1);
/* 115 */       nglGenBuffersARB(1, MemoryUtil.memAddress(buffers));
/* 116 */       return buffers.get(0);
/*     */     } finally {
/* 118 */       stack.setPointer(stackPointer);
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
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("GLsizeiptrARB") long size, @NativeType("GLenum") int usage) {
/* 135 */     nglBufferDataARB(target, size, 0L, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("void const *") ByteBuffer data, @NativeType("GLenum") int usage) {
/* 140 */     nglBufferDataARB(target, data.remaining(), MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("void const *") ShortBuffer data, @NativeType("GLenum") int usage) {
/* 145 */     nglBufferDataARB(target, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("void const *") IntBuffer data, @NativeType("GLenum") int usage) {
/* 150 */     nglBufferDataARB(target, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("void const *") FloatBuffer data, @NativeType("GLenum") int usage) {
/* 155 */     nglBufferDataARB(target, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("void const *") DoubleBuffer data, @NativeType("GLenum") int usage) {
/* 160 */     nglBufferDataARB(target, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void const *") ByteBuffer data) {
/* 170 */     nglBufferSubDataARB(target, offset, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void const *") ShortBuffer data) {
/* 175 */     nglBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void const *") IntBuffer data) {
/* 180 */     nglBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void const *") FloatBuffer data) {
/* 185 */     nglBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void const *") DoubleBuffer data) {
/* 190 */     nglBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void *") ByteBuffer data) {
/* 200 */     nglGetBufferSubDataARB(target, offset, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void *") ShortBuffer data) {
/* 205 */     nglGetBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void *") IntBuffer data) {
/* 210 */     nglGetBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void *") FloatBuffer data) {
/* 215 */     nglGetBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void *") DoubleBuffer data) {
/* 220 */     nglGetBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBufferARB(@NativeType("GLenum") int target, @NativeType("GLenum") int access) {
/* 231 */     long __result = nglMapBufferARB(target, access);
/* 232 */     return MemoryUtil.memByteBufferSafe(__result, glGetBufferParameteriARB(target, 34660));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBufferARB(@NativeType("GLenum") int target, @NativeType("GLenum") int access, ByteBuffer old_buffer) {
/* 238 */     long __result = nglMapBufferARB(target, access);
/* 239 */     int length = glGetBufferParameteriARB(target, 34660);
/* 240 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBufferARB(@NativeType("GLenum") int target, @NativeType("GLenum") int access, long length, ByteBuffer old_buffer) {
/* 246 */     long __result = nglMapBufferARB(target, access);
/* 247 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
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
/*     */   public static void glGetBufferParameterivARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.check(params, 1);
/*     */     }
/* 266 */     nglGetBufferParameterivARB(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetBufferParameteriARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 272 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 274 */       IntBuffer params = stack.callocInt(1);
/* 275 */       nglGetBufferParameterivARB(target, pname, MemoryUtil.memAddress(params));
/* 276 */       return params.get(0);
/*     */     } finally {
/* 278 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferPointervARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer params) {
/* 289 */     if (Checks.CHECKS) {
/* 290 */       Checks.check((CustomBuffer)params, 1);
/*     */     }
/* 292 */     nglGetBufferPointervARB(target, pname, MemoryUtil.memAddress((CustomBuffer)params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetBufferPointerARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 298 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 300 */       PointerBuffer params = stack.callocPointer(1);
/* 301 */       nglGetBufferPointervARB(target, pname, MemoryUtil.memAddress((CustomBuffer)params));
/* 302 */       return params.get(0);
/*     */     } finally {
/* 304 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteBuffersARB(@NativeType("GLuint const *") int[] buffers) {
/* 310 */     long __functionAddress = (GL.getICD()).glDeleteBuffersARB;
/* 311 */     if (Checks.CHECKS) {
/* 312 */       Checks.check(__functionAddress);
/*     */     }
/* 314 */     JNI.callPV(buffers.length, buffers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenBuffersARB(@NativeType("GLuint *") int[] buffers) {
/* 319 */     long __functionAddress = (GL.getICD()).glGenBuffersARB;
/* 320 */     if (Checks.CHECKS) {
/* 321 */       Checks.check(__functionAddress);
/*     */     }
/* 323 */     JNI.callPV(buffers.length, buffers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("void const *") short[] data, @NativeType("GLenum") int usage) {
/* 328 */     long __functionAddress = (GL.getICD()).glBufferDataARB;
/* 329 */     if (Checks.CHECKS) {
/* 330 */       Checks.check(__functionAddress);
/*     */     }
/* 332 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 1L, data, usage, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("void const *") int[] data, @NativeType("GLenum") int usage) {
/* 337 */     long __functionAddress = (GL.getICD()).glBufferDataARB;
/* 338 */     if (Checks.CHECKS) {
/* 339 */       Checks.check(__functionAddress);
/*     */     }
/* 341 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2L, data, usage, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("void const *") float[] data, @NativeType("GLenum") int usage) {
/* 346 */     long __functionAddress = (GL.getICD()).glBufferDataARB;
/* 347 */     if (Checks.CHECKS) {
/* 348 */       Checks.check(__functionAddress);
/*     */     }
/* 350 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2L, data, usage, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int target, @NativeType("void const *") double[] data, @NativeType("GLenum") int usage) {
/* 355 */     long __functionAddress = (GL.getICD()).glBufferDataARB;
/* 356 */     if (Checks.CHECKS) {
/* 357 */       Checks.check(__functionAddress);
/*     */     }
/* 359 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 3L, data, usage, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void const *") short[] data) {
/* 364 */     long __functionAddress = (GL.getICD()).glBufferSubDataARB;
/* 365 */     if (Checks.CHECKS) {
/* 366 */       Checks.check(__functionAddress);
/*     */     }
/* 368 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 1L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void const *") int[] data) {
/* 373 */     long __functionAddress = (GL.getICD()).glBufferSubDataARB;
/* 374 */     if (Checks.CHECKS) {
/* 375 */       Checks.check(__functionAddress);
/*     */     }
/* 377 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void const *") float[] data) {
/* 382 */     long __functionAddress = (GL.getICD()).glBufferSubDataARB;
/* 383 */     if (Checks.CHECKS) {
/* 384 */       Checks.check(__functionAddress);
/*     */     }
/* 386 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void const *") double[] data) {
/* 391 */     long __functionAddress = (GL.getICD()).glBufferSubDataARB;
/* 392 */     if (Checks.CHECKS) {
/* 393 */       Checks.check(__functionAddress);
/*     */     }
/* 395 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void *") short[] data) {
/* 400 */     long __functionAddress = (GL.getICD()).glGetBufferSubDataARB;
/* 401 */     if (Checks.CHECKS) {
/* 402 */       Checks.check(__functionAddress);
/*     */     }
/* 404 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 1L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void *") int[] data) {
/* 409 */     long __functionAddress = (GL.getICD()).glGetBufferSubDataARB;
/* 410 */     if (Checks.CHECKS) {
/* 411 */       Checks.check(__functionAddress);
/*     */     }
/* 413 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void *") float[] data) {
/* 418 */     long __functionAddress = (GL.getICD()).glGetBufferSubDataARB;
/* 419 */     if (Checks.CHECKS) {
/* 420 */       Checks.check(__functionAddress);
/*     */     }
/* 422 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int target, @NativeType("GLintptrARB") long offset, @NativeType("void *") double[] data) {
/* 427 */     long __functionAddress = (GL.getICD()).glGetBufferSubDataARB;
/* 428 */     if (Checks.CHECKS) {
/* 429 */       Checks.check(__functionAddress);
/*     */     }
/* 431 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameterivARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 436 */     long __functionAddress = (GL.getICD()).glGetBufferParameterivARB;
/* 437 */     if (Checks.CHECKS) {
/* 438 */       Checks.check(__functionAddress);
/* 439 */       Checks.check(params, 1);
/*     */     } 
/* 441 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glBindBufferARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteBuffersARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenBuffersARB(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsBufferARB(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglBufferDataARB(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native void nglBufferSubDataARB(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nglGetBufferSubDataARB(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nglMapBufferARB(int paramInt1, int paramInt2);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glUnmapBufferARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglGetBufferParameterivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetBufferPointervARB(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBVertexBufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */