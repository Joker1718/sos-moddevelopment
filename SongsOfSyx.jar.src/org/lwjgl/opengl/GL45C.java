/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Pointer;
/*      */ 
/*      */ public class GL45C extends GL44C {
/*      */   public static final int GL_NEGATIVE_ONE_TO_ONE = 37726;
/*      */   public static final int GL_ZERO_TO_ONE = 37727;
/*      */   
/*      */   static {
/*   24 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_CLIP_ORIGIN = 37724;
/*      */   
/*      */   public static final int GL_CLIP_DEPTH_MODE = 37725;
/*      */   
/*      */   public static final int GL_QUERY_WAIT_INVERTED = 36375;
/*      */   
/*      */   public static final int GL_QUERY_NO_WAIT_INVERTED = 36376;
/*      */   
/*      */   public static final int GL_QUERY_BY_REGION_WAIT_INVERTED = 36377;
/*      */   
/*      */   public static final int GL_QUERY_BY_REGION_NO_WAIT_INVERTED = 36378;
/*      */   
/*      */   public static final int GL_MAX_CULL_DISTANCES = 33529;
/*      */   
/*      */   public static final int GL_MAX_COMBINED_CLIP_AND_CULL_DISTANCES = 33530;
/*      */   
/*      */   public static final int GL_TEXTURE_TARGET = 4102;
/*      */   
/*      */   public static final int GL_QUERY_TARGET = 33514;
/*      */   
/*      */   public static final int GL_CONTEXT_RELEASE_BEHAVIOR = 33531;
/*      */   
/*      */   public static final int GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 33532;
/*      */   
/*      */   public static final int GL_GUILTY_CONTEXT_RESET = 33363;
/*      */   
/*      */   public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
/*      */   
/*      */   public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;
/*      */   
/*      */   public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
/*      */   
/*      */   public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
/*      */   
/*      */   public static final int GL_NO_RESET_NOTIFICATION = 33377;
/*      */   
/*      */   public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT = 4;
/*      */   public static final int GL_CONTEXT_LOST = 1287;
/*      */   
/*      */   protected GL45C() {
/*   68 */     throw new UnsupportedOperationException();
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
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") IntBuffer ids) {
/*   83 */     nglCreateTransformFeedbacks(ids.remaining(), MemoryUtil.memAddress(ids));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTransformFeedbacks() {
/*   89 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*   91 */       IntBuffer ids = stack.callocInt(1);
/*   92 */       nglCreateTransformFeedbacks(1, MemoryUtil.memAddress(ids));
/*   93 */       return ids.get(0);
/*      */     } finally {
/*   95 */       stack.setPointer(stackPointer);
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
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/*  116 */     if (Checks.CHECKS) {
/*  117 */       Checks.check(param, 1);
/*      */     }
/*  119 */     nglGetTransformFeedbackiv(xfb, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname) {
/*  125 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  127 */       IntBuffer param = stack.callocInt(1);
/*  128 */       nglGetTransformFeedbackiv(xfb, pname, MemoryUtil.memAddress(param));
/*  129 */       return param.get(0);
/*      */     } finally {
/*  131 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer param) {
/*  142 */     if (Checks.CHECKS) {
/*  143 */       Checks.check(param, 1);
/*      */     }
/*  145 */     nglGetTransformFeedbacki_v(xfb, pname, index, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/*  151 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  153 */       IntBuffer param = stack.callocInt(1);
/*  154 */       nglGetTransformFeedbacki_v(xfb, pname, index, MemoryUtil.memAddress(param));
/*  155 */       return param.get(0);
/*      */     } finally {
/*  157 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") LongBuffer param) {
/*  168 */     if (Checks.CHECKS) {
/*  169 */       Checks.check(param, 1);
/*      */     }
/*  171 */     nglGetTransformFeedbacki64_v(xfb, pname, index, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetTransformFeedbacki64(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/*  177 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  179 */       LongBuffer param = stack.callocLong(1);
/*  180 */       nglGetTransformFeedbacki64_v(xfb, pname, index, MemoryUtil.memAddress(param));
/*  181 */       return param.get(0);
/*      */     } finally {
/*  183 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") IntBuffer buffers) {
/*  194 */     nglCreateBuffers(buffers.remaining(), MemoryUtil.memAddress(buffers));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateBuffers() {
/*  200 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  202 */       IntBuffer buffers = stack.callocInt(1);
/*  203 */       nglCreateBuffers(1, MemoryUtil.memAddress(buffers));
/*  204 */       return buffers.get(0);
/*      */     } finally {
/*  206 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("GLsizeiptr") long size, @NativeType("GLbitfield") int flags) {
/*  217 */     nglNamedBufferStorage(buffer, size, 0L, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") ByteBuffer data, @NativeType("GLbitfield") int flags) {
/*  222 */     nglNamedBufferStorage(buffer, data.remaining(), MemoryUtil.memAddress(data), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") ShortBuffer data, @NativeType("GLbitfield") int flags) {
/*  227 */     nglNamedBufferStorage(buffer, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") IntBuffer data, @NativeType("GLbitfield") int flags) {
/*  232 */     nglNamedBufferStorage(buffer, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") FloatBuffer data, @NativeType("GLbitfield") int flags) {
/*  237 */     nglNamedBufferStorage(buffer, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") DoubleBuffer data, @NativeType("GLbitfield") int flags) {
/*  242 */     nglNamedBufferStorage(buffer, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int usage) {
/*  252 */     nglNamedBufferData(buffer, size, 0L, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") ByteBuffer data, @NativeType("GLenum") int usage) {
/*  257 */     nglNamedBufferData(buffer, data.remaining(), MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") ShortBuffer data, @NativeType("GLenum") int usage) {
/*  262 */     nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") IntBuffer data, @NativeType("GLenum") int usage) {
/*  267 */     nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") LongBuffer data, @NativeType("GLenum") int usage) {
/*  272 */     nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") FloatBuffer data, @NativeType("GLenum") int usage) {
/*  277 */     nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") DoubleBuffer data, @NativeType("GLenum") int usage) {
/*  282 */     nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data), usage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ByteBuffer data) {
/*  292 */     nglNamedBufferSubData(buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ShortBuffer data) {
/*  297 */     nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") IntBuffer data) {
/*  302 */     nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") LongBuffer data) {
/*  307 */     nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") FloatBuffer data) {
/*  312 */     nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") DoubleBuffer data) {
/*  317 */     nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
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
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  332 */     nglClearNamedBufferData(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  337 */     nglClearNamedBufferData(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  342 */     nglClearNamedBufferData(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  347 */     nglClearNamedBufferData(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  357 */     nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  362 */     nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  367 */     nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  372 */     nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access) {
/*  383 */     long __result = nglMapNamedBuffer(buffer, access);
/*  384 */     return MemoryUtil.memByteBufferSafe(__result, glGetNamedBufferParameteri(buffer, 34660));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access, ByteBuffer old_buffer) {
/*  390 */     long __result = nglMapNamedBuffer(buffer, access);
/*  391 */     int length = glGetNamedBufferParameteri(buffer, 34660);
/*  392 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access, long length, ByteBuffer old_buffer) {
/*  398 */     long __result = nglMapNamedBuffer(buffer, access);
/*  399 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access) {
/*  410 */     long __result = nglMapNamedBufferRange(buffer, offset, length, access);
/*  411 */     return MemoryUtil.memByteBufferSafe(__result, (int)length);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access, ByteBuffer old_buffer) {
/*  417 */     long __result = nglMapNamedBufferRange(buffer, offset, length, access);
/*  418 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
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
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  439 */     if (Checks.CHECKS) {
/*  440 */       Checks.check(params, 1);
/*      */     }
/*  442 */     nglGetNamedBufferParameteriv(buffer, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedBufferParameteri(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/*  448 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  450 */       IntBuffer params = stack.callocInt(1);
/*  451 */       nglGetNamedBufferParameteriv(buffer, pname, MemoryUtil.memAddress(params));
/*  452 */       return params.get(0);
/*      */     } finally {
/*  454 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/*  465 */     if (Checks.CHECKS) {
/*  466 */       Checks.check(params, 1);
/*      */     }
/*  468 */     nglGetNamedBufferParameteri64v(buffer, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferParameteri64(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/*  474 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  476 */       LongBuffer params = stack.callocLong(1);
/*  477 */       nglGetNamedBufferParameteri64v(buffer, pname, MemoryUtil.memAddress(params));
/*  478 */       return params.get(0);
/*      */     } finally {
/*  480 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferPointerv(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer params) {
/*  491 */     if (Checks.CHECKS) {
/*  492 */       Checks.check((CustomBuffer)params, 1);
/*      */     }
/*  494 */     nglGetNamedBufferPointerv(buffer, pname, MemoryUtil.memAddress((CustomBuffer)params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferPointer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/*  500 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  502 */       PointerBuffer params = stack.callocPointer(1);
/*  503 */       nglGetNamedBufferPointerv(buffer, pname, MemoryUtil.memAddress((CustomBuffer)params));
/*  504 */       return params.get(0);
/*      */     } finally {
/*  506 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") ByteBuffer data) {
/*  517 */     nglGetNamedBufferSubData(buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") ShortBuffer data) {
/*  522 */     nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") IntBuffer data) {
/*  527 */     nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") LongBuffer data) {
/*  532 */     nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") FloatBuffer data) {
/*  537 */     nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") DoubleBuffer data) {
/*  542 */     nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") IntBuffer framebuffers) {
/*  552 */     nglCreateFramebuffers(framebuffers.remaining(), MemoryUtil.memAddress(framebuffers));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateFramebuffers() {
/*  558 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  560 */       IntBuffer framebuffers = stack.callocInt(1);
/*  561 */       nglCreateFramebuffers(1, MemoryUtil.memAddress(framebuffers));
/*  562 */       return framebuffers.get(0);
/*      */     } finally {
/*  564 */       stack.setPointer(stackPointer);
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
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer bufs) {
/*  600 */     nglNamedFramebufferDrawBuffers(framebuffer, bufs.remaining(), MemoryUtil.memAddress(bufs));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int buf) {
/*  605 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  607 */       IntBuffer bufs = stack.ints(buf);
/*  608 */       nglNamedFramebufferDrawBuffers(framebuffer, 1, MemoryUtil.memAddress(bufs));
/*      */     } finally {
/*  610 */       stack.setPointer(stackPointer);
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
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer attachments) {
/*  626 */     nglInvalidateNamedFramebufferData(framebuffer, attachments.remaining(), MemoryUtil.memAddress(attachments));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int attachment) {
/*  631 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  633 */       IntBuffer attachments = stack.ints(attachment);
/*  634 */       nglInvalidateNamedFramebufferData(framebuffer, 1, MemoryUtil.memAddress(attachments));
/*      */     } finally {
/*  636 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  647 */     nglInvalidateNamedFramebufferSubData(framebuffer, attachments.remaining(), MemoryUtil.memAddress(attachments), x, y, width, height);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int attachment, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  652 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  654 */       IntBuffer attachments = stack.ints(attachment);
/*  655 */       nglInvalidateNamedFramebufferSubData(framebuffer, 1, MemoryUtil.memAddress(attachments), x, y, width, height);
/*      */     } finally {
/*  657 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") IntBuffer value) {
/*  668 */     if (Checks.CHECKS) {
/*  669 */       Checks.check(value, 1);
/*      */     }
/*  671 */     nglClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") IntBuffer value) {
/*  681 */     if (Checks.CHECKS) {
/*  682 */       Checks.check(value, 4);
/*      */     }
/*  684 */     nglClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat const *") FloatBuffer value) {
/*  694 */     if (Checks.CHECKS) {
/*  695 */       Checks.check(value, 1);
/*      */     }
/*  697 */     nglClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, MemoryUtil.memAddress(value));
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
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  723 */     if (Checks.CHECKS) {
/*  724 */       Checks.check(params, 1);
/*      */     }
/*  726 */     nglGetNamedFramebufferParameteriv(framebuffer, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferParameteri(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname) {
/*  732 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  734 */       IntBuffer params = stack.callocInt(1);
/*  735 */       nglGetNamedFramebufferParameteriv(framebuffer, pname, MemoryUtil.memAddress(params));
/*  736 */       return params.get(0);
/*      */     } finally {
/*  738 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  749 */     if (Checks.CHECKS) {
/*  750 */       Checks.check(params, 1);
/*      */     }
/*  752 */     nglGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferAttachmentParameteri(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname) {
/*  758 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  760 */       IntBuffer params = stack.callocInt(1);
/*  761 */       nglGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, MemoryUtil.memAddress(params));
/*  762 */       return params.get(0);
/*      */     } finally {
/*  764 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") IntBuffer renderbuffers) {
/*  775 */     nglCreateRenderbuffers(renderbuffers.remaining(), MemoryUtil.memAddress(renderbuffers));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateRenderbuffers() {
/*  781 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  783 */       IntBuffer renderbuffers = stack.callocInt(1);
/*  784 */       nglCreateRenderbuffers(1, MemoryUtil.memAddress(renderbuffers));
/*  785 */       return renderbuffers.get(0);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  808 */     if (Checks.CHECKS) {
/*  809 */       Checks.check(params, 1);
/*      */     }
/*  811 */     nglGetNamedRenderbufferParameteriv(renderbuffer, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedRenderbufferParameteri(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname) {
/*  817 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  819 */       IntBuffer params = stack.callocInt(1);
/*  820 */       nglGetNamedRenderbufferParameteriv(renderbuffer, pname, MemoryUtil.memAddress(params));
/*  821 */       return params.get(0);
/*      */     } finally {
/*  823 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int target, @NativeType("GLuint *") IntBuffer textures) {
/*  834 */     nglCreateTextures(target, textures.remaining(), MemoryUtil.memAddress(textures));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTextures(@NativeType("GLenum") int target) {
/*  840 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  842 */       IntBuffer textures = stack.callocInt(1);
/*  843 */       nglCreateTextures(target, 1, MemoryUtil.memAddress(textures));
/*  844 */       return textures.get(0);
/*      */     } finally {
/*  846 */       stack.setPointer(stackPointer);
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
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  892 */     nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  897 */     nglTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  902 */     nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  907 */     nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  912 */     nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  917 */     nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  927 */     nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  932 */     nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  937 */     nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  942 */     nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  947 */     nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  952 */     nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  962 */     nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  967 */     nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  972 */     nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  977 */     nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  982 */     nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  987 */     nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  997 */     nglCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 1002 */     nglCompressedTextureSubImage1D(texture, level, xoffset, width, format, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1012 */     nglCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 1017 */     nglCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/* 1027 */     nglCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/* 1032 */     nglCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, data.remaining(), MemoryUtil.memAddress(data));
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
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 1062 */     if (Checks.CHECKS) {
/* 1063 */       Checks.check(params, 4);
/*      */     }
/* 1065 */     nglTextureParameterfv(texture, pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 1080 */     if (Checks.CHECKS) {
/* 1081 */       Checks.check(params, 1);
/*      */     }
/* 1083 */     nglTextureParameterIiv(texture, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIi(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") int param) {
/* 1088 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1090 */       IntBuffer params = stack.ints(param);
/* 1091 */       nglTextureParameterIiv(texture, pname, MemoryUtil.memAddress(params));
/*      */     } finally {
/* 1093 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint const *") IntBuffer params) {
/* 1104 */     if (Checks.CHECKS) {
/* 1105 */       Checks.check(params, 1);
/*      */     }
/* 1107 */     nglTextureParameterIuiv(texture, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIui(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int param) {
/* 1112 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1114 */       IntBuffer params = stack.ints(param);
/* 1115 */       nglTextureParameterIuiv(texture, pname, MemoryUtil.memAddress(params));
/*      */     } finally {
/* 1117 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 1128 */     if (Checks.CHECKS) {
/* 1129 */       Checks.check(params, 4);
/*      */     }
/* 1131 */     nglTextureParameteriv(texture, pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1151 */     nglGetTextureImage(texture, level, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 1156 */     nglGetTextureImage(texture, level, format, type, pixels.remaining(), MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 1161 */     nglGetTextureImage(texture, level, format, type, pixels.remaining() << 1, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 1166 */     nglGetTextureImage(texture, level, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 1171 */     nglGetTextureImage(texture, level, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/* 1176 */     nglGetTextureImage(texture, level, format, type, pixels.remaining() << 3, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1186 */     nglGetCompressedTextureImage(texture, level, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer pixels) {
/* 1191 */     if (Checks.CHECKS && 
/* 1192 */       Checks.DEBUG) {
/* 1193 */       Checks.check(pixels, glGetTextureLevelParameteri(texture, level, 34464));
/*      */     }
/*      */     
/* 1196 */     nglGetCompressedTextureImage(texture, level, pixels.remaining(), MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1206 */     if (Checks.CHECKS) {
/* 1207 */       Checks.check(params, 1);
/*      */     }
/* 1209 */     nglGetTextureLevelParameterfv(texture, level, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureLevelParameterf(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 1215 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1217 */       FloatBuffer params = stack.callocFloat(1);
/* 1218 */       nglGetTextureLevelParameterfv(texture, level, pname, MemoryUtil.memAddress(params));
/* 1219 */       return params.get(0);
/*      */     } finally {
/* 1221 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1232 */     if (Checks.CHECKS) {
/* 1233 */       Checks.check(params, 1);
/*      */     }
/* 1235 */     nglGetTextureLevelParameteriv(texture, level, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureLevelParameteri(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 1241 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1243 */       IntBuffer params = stack.callocInt(1);
/* 1244 */       nglGetTextureLevelParameteriv(texture, level, pname, MemoryUtil.memAddress(params));
/* 1245 */       return params.get(0);
/*      */     } finally {
/* 1247 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1258 */     if (Checks.CHECKS) {
/* 1259 */       Checks.check(params, 1);
/*      */     }
/* 1261 */     nglGetTextureParameterfv(texture, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureParameterf(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1267 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1269 */       FloatBuffer params = stack.callocFloat(1);
/* 1270 */       nglGetTextureParameterfv(texture, pname, MemoryUtil.memAddress(params));
/* 1271 */       return params.get(0);
/*      */     } finally {
/* 1273 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1284 */     if (Checks.CHECKS) {
/* 1285 */       Checks.check(params, 1);
/*      */     }
/* 1287 */     nglGetTextureParameterIiv(texture, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIi(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1293 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1295 */       IntBuffer params = stack.callocInt(1);
/* 1296 */       nglGetTextureParameterIiv(texture, pname, MemoryUtil.memAddress(params));
/* 1297 */       return params.get(0);
/*      */     } finally {
/* 1299 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 1310 */     if (Checks.CHECKS) {
/* 1311 */       Checks.check(params, 1);
/*      */     }
/* 1313 */     nglGetTextureParameterIuiv(texture, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIui(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1319 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1321 */       IntBuffer params = stack.callocInt(1);
/* 1322 */       nglGetTextureParameterIuiv(texture, pname, MemoryUtil.memAddress(params));
/* 1323 */       return params.get(0);
/*      */     } finally {
/* 1325 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1336 */     if (Checks.CHECKS) {
/* 1337 */       Checks.check(params, 1);
/*      */     }
/* 1339 */     nglGetTextureParameteriv(texture, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameteri(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1345 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1347 */       IntBuffer params = stack.callocInt(1);
/* 1348 */       nglGetTextureParameteriv(texture, pname, MemoryUtil.memAddress(params));
/* 1349 */       return params.get(0);
/*      */     } finally {
/* 1351 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") IntBuffer arrays) {
/* 1362 */     nglCreateVertexArrays(arrays.remaining(), MemoryUtil.memAddress(arrays));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateVertexArrays() {
/* 1368 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1370 */       IntBuffer arrays = stack.callocInt(1);
/* 1371 */       nglCreateVertexArrays(1, MemoryUtil.memAddress(arrays));
/* 1372 */       return arrays.get(0);
/*      */     } finally {
/* 1374 */       stack.setPointer(stackPointer);
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
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") IntBuffer strides) {
/* 1405 */     if (Checks.CHECKS) {
/* 1406 */       Checks.checkSafe((CustomBuffer)offsets, Checks.remainingSafe(buffers));
/* 1407 */       Checks.checkSafe(strides, Checks.remainingSafe(buffers));
/*      */     } 
/* 1409 */     nglVertexArrayVertexBuffers(vaobj, first, Checks.remainingSafe(buffers), MemoryUtil.memAddressSafe(buffers), MemoryUtil.memAddressSafe((Pointer)offsets), MemoryUtil.memAddressSafe(strides));
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
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/* 1444 */     if (Checks.CHECKS) {
/* 1445 */       Checks.check(param, 1);
/*      */     }
/* 1447 */     nglGetVertexArrayiv(vaobj, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayi(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname) {
/* 1453 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1455 */       IntBuffer param = stack.callocInt(1);
/* 1456 */       nglGetVertexArrayiv(vaobj, pname, MemoryUtil.memAddress(param));
/* 1457 */       return param.get(0);
/*      */     } finally {
/* 1459 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/* 1470 */     if (Checks.CHECKS) {
/* 1471 */       Checks.check(param, 1);
/*      */     }
/* 1473 */     nglGetVertexArrayIndexediv(vaobj, index, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayIndexedi(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1479 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1481 */       IntBuffer param = stack.callocInt(1);
/* 1482 */       nglGetVertexArrayIndexediv(vaobj, index, pname, MemoryUtil.memAddress(param));
/* 1483 */       return param.get(0);
/*      */     } finally {
/* 1485 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer param) {
/* 1496 */     if (Checks.CHECKS) {
/* 1497 */       Checks.check(param, 1);
/*      */     }
/* 1499 */     nglGetVertexArrayIndexed64iv(vaobj, index, pname, MemoryUtil.memAddress(param));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexArrayIndexed64i(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1505 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1507 */       LongBuffer param = stack.callocLong(1);
/* 1508 */       nglGetVertexArrayIndexed64iv(vaobj, index, pname, MemoryUtil.memAddress(param));
/* 1509 */       return param.get(0);
/*      */     } finally {
/* 1511 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") IntBuffer samplers) {
/* 1522 */     nglCreateSamplers(samplers.remaining(), MemoryUtil.memAddress(samplers));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateSamplers() {
/* 1528 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1530 */       IntBuffer samplers = stack.callocInt(1);
/* 1531 */       nglCreateSamplers(1, MemoryUtil.memAddress(samplers));
/* 1532 */       return samplers.get(0);
/*      */     } finally {
/* 1534 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") IntBuffer pipelines) {
/* 1545 */     nglCreateProgramPipelines(pipelines.remaining(), MemoryUtil.memAddress(pipelines));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateProgramPipelines() {
/* 1551 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1553 */       IntBuffer pipelines = stack.callocInt(1);
/* 1554 */       nglCreateProgramPipelines(1, MemoryUtil.memAddress(pipelines));
/* 1555 */       return pipelines.get(0);
/*      */     } finally {
/* 1557 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int target, @NativeType("GLuint *") IntBuffer ids) {
/* 1568 */     nglCreateQueries(target, ids.remaining(), MemoryUtil.memAddress(ids));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateQueries(@NativeType("GLenum") int target) {
/* 1574 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1576 */       IntBuffer ids = stack.callocInt(1);
/* 1577 */       nglCreateQueries(target, 1, MemoryUtil.memAddress(ids));
/* 1578 */       return ids.get(0);
/*      */     } finally {
/* 1580 */       stack.setPointer(stackPointer);
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
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1616 */     nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 1621 */     nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining(), MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 1626 */     nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining() << 1, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 1631 */     nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 1636 */     nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/* 1641 */     nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining() << 3, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1651 */     nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") ByteBuffer pixels) {
/* 1656 */     nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining(), MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") ShortBuffer pixels) {
/* 1661 */     nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining() << 1, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") IntBuffer pixels) {
/* 1666 */     nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") FloatBuffer pixels) {
/* 1671 */     nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") DoubleBuffer pixels) {
/* 1676 */     nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining() << 3, MemoryUtil.memAddress(pixels));
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
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long img) {
/* 1697 */     nglGetnTexImage(tex, level, format, type, bufSize, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer img) {
/* 1702 */     nglGetnTexImage(tex, level, format, type, img.remaining(), MemoryUtil.memAddress(img));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer img) {
/* 1707 */     nglGetnTexImage(tex, level, format, type, img.remaining() << 1, MemoryUtil.memAddress(img));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer img) {
/* 1712 */     nglGetnTexImage(tex, level, format, type, img.remaining() << 2, MemoryUtil.memAddress(img));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer img) {
/* 1717 */     nglGetnTexImage(tex, level, format, type, img.remaining() << 2, MemoryUtil.memAddress(img));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer img) {
/* 1722 */     nglGetnTexImage(tex, level, format, type, img.remaining() << 3, MemoryUtil.memAddress(img));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1732 */     nglReadnPixels(x, y, width, height, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 1737 */     nglReadnPixels(x, y, width, height, format, type, pixels.remaining(), MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 1742 */     nglReadnPixels(x, y, width, height, format, type, pixels.remaining() << 1, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 1747 */     nglReadnPixels(x, y, width, height, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 1752 */     nglReadnPixels(x, y, width, height, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnCompressedTexImage(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLsizei") int bufSize, @NativeType("void *") long img) {
/* 1762 */     nglGetnCompressedTexImage(target, level, bufSize, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnCompressedTexImage(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer img) {
/* 1767 */     if (Checks.CHECKS && 
/* 1768 */       Checks.DEBUG) {
/* 1769 */       Checks.check(img, GL11.glGetTexLevelParameteri(target, level, 34464));
/*      */     }
/*      */     
/* 1772 */     nglGetnCompressedTexImage(target, level, img.remaining(), MemoryUtil.memAddress(img));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") FloatBuffer params) {
/* 1782 */     nglGetnUniformfv(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetnUniformf(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 1788 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1790 */       FloatBuffer params = stack.callocFloat(1);
/* 1791 */       nglGetnUniformfv(program, location, 1, MemoryUtil.memAddress(params));
/* 1792 */       return params.get(0);
/*      */     } finally {
/* 1794 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") DoubleBuffer params) {
/* 1805 */     nglGetnUniformdv(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetnUniformd(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 1811 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1813 */       DoubleBuffer params = stack.callocDouble(1);
/* 1814 */       nglGetnUniformdv(program, location, 1, MemoryUtil.memAddress(params));
/* 1815 */       return params.get(0);
/*      */     } finally {
/* 1817 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") IntBuffer params) {
/* 1828 */     nglGetnUniformiv(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetnUniformi(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 1834 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1836 */       IntBuffer params = stack.callocInt(1);
/* 1837 */       nglGetnUniformiv(program, location, 1, MemoryUtil.memAddress(params));
/* 1838 */       return params.get(0);
/*      */     } finally {
/* 1840 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformuiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") IntBuffer params) {
/* 1851 */     nglGetnUniformuiv(program, location, params.remaining(), MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetnUniformui(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 1857 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1859 */       IntBuffer params = stack.callocInt(1);
/* 1860 */       nglGetnUniformuiv(program, location, 1, MemoryUtil.memAddress(params));
/* 1861 */       return params.get(0);
/*      */     } finally {
/* 1863 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") int[] ids) {
/* 1869 */     long __functionAddress = (GL.getICD()).glCreateTransformFeedbacks;
/* 1870 */     if (Checks.CHECKS) {
/* 1871 */       Checks.check(__functionAddress);
/*      */     }
/* 1873 */     JNI.callPV(ids.length, ids, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 1878 */     long __functionAddress = (GL.getICD()).glGetTransformFeedbackiv;
/* 1879 */     if (Checks.CHECKS) {
/* 1880 */       Checks.check(__functionAddress);
/* 1881 */       Checks.check(param, 1);
/*      */     } 
/* 1883 */     JNI.callPV(xfb, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint *") int[] param) {
/* 1888 */     long __functionAddress = (GL.getICD()).glGetTransformFeedbacki_v;
/* 1889 */     if (Checks.CHECKS) {
/* 1890 */       Checks.check(__functionAddress);
/* 1891 */       Checks.check(param, 1);
/*      */     } 
/* 1893 */     JNI.callPV(xfb, pname, index, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") long[] param) {
/* 1898 */     long __functionAddress = (GL.getICD()).glGetTransformFeedbacki64_v;
/* 1899 */     if (Checks.CHECKS) {
/* 1900 */       Checks.check(__functionAddress);
/* 1901 */       Checks.check(param, 1);
/*      */     } 
/* 1903 */     JNI.callPV(xfb, pname, index, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") int[] buffers) {
/* 1908 */     long __functionAddress = (GL.getICD()).glCreateBuffers;
/* 1909 */     if (Checks.CHECKS) {
/* 1910 */       Checks.check(__functionAddress);
/*      */     }
/* 1912 */     JNI.callPV(buffers.length, buffers, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") short[] data, @NativeType("GLbitfield") int flags) {
/* 1917 */     long __functionAddress = (GL.getICD()).glNamedBufferStorage;
/* 1918 */     if (Checks.CHECKS) {
/* 1919 */       Checks.check(__functionAddress);
/*      */     }
/* 1921 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 1L, data, flags, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") int[] data, @NativeType("GLbitfield") int flags) {
/* 1926 */     long __functionAddress = (GL.getICD()).glNamedBufferStorage;
/* 1927 */     if (Checks.CHECKS) {
/* 1928 */       Checks.check(__functionAddress);
/*      */     }
/* 1930 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2L, data, flags, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") float[] data, @NativeType("GLbitfield") int flags) {
/* 1935 */     long __functionAddress = (GL.getICD()).glNamedBufferStorage;
/* 1936 */     if (Checks.CHECKS) {
/* 1937 */       Checks.check(__functionAddress);
/*      */     }
/* 1939 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2L, data, flags, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") double[] data, @NativeType("GLbitfield") int flags) {
/* 1944 */     long __functionAddress = (GL.getICD()).glNamedBufferStorage;
/* 1945 */     if (Checks.CHECKS) {
/* 1946 */       Checks.check(__functionAddress);
/*      */     }
/* 1948 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3L, data, flags, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") short[] data, @NativeType("GLenum") int usage) {
/* 1953 */     long __functionAddress = (GL.getICD()).glNamedBufferData;
/* 1954 */     if (Checks.CHECKS) {
/* 1955 */       Checks.check(__functionAddress);
/*      */     }
/* 1957 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 1L, data, usage, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") int[] data, @NativeType("GLenum") int usage) {
/* 1962 */     long __functionAddress = (GL.getICD()).glNamedBufferData;
/* 1963 */     if (Checks.CHECKS) {
/* 1964 */       Checks.check(__functionAddress);
/*      */     }
/* 1966 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2L, data, usage, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") long[] data, @NativeType("GLenum") int usage) {
/* 1971 */     long __functionAddress = (GL.getICD()).glNamedBufferData;
/* 1972 */     if (Checks.CHECKS) {
/* 1973 */       Checks.check(__functionAddress);
/*      */     }
/* 1975 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3L, data, usage, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") float[] data, @NativeType("GLenum") int usage) {
/* 1980 */     long __functionAddress = (GL.getICD()).glNamedBufferData;
/* 1981 */     if (Checks.CHECKS) {
/* 1982 */       Checks.check(__functionAddress);
/*      */     }
/* 1984 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2L, data, usage, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") double[] data, @NativeType("GLenum") int usage) {
/* 1989 */     long __functionAddress = (GL.getICD()).glNamedBufferData;
/* 1990 */     if (Checks.CHECKS) {
/* 1991 */       Checks.check(__functionAddress);
/*      */     }
/* 1993 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3L, data, usage, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") short[] data) {
/* 1998 */     long __functionAddress = (GL.getICD()).glNamedBufferSubData;
/* 1999 */     if (Checks.CHECKS) {
/* 2000 */       Checks.check(__functionAddress);
/*      */     }
/* 2002 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 1L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") int[] data) {
/* 2007 */     long __functionAddress = (GL.getICD()).glNamedBufferSubData;
/* 2008 */     if (Checks.CHECKS) {
/* 2009 */       Checks.check(__functionAddress);
/*      */     }
/* 2011 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") long[] data) {
/* 2016 */     long __functionAddress = (GL.getICD()).glNamedBufferSubData;
/* 2017 */     if (Checks.CHECKS) {
/* 2018 */       Checks.check(__functionAddress);
/*      */     }
/* 2020 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") float[] data) {
/* 2025 */     long __functionAddress = (GL.getICD()).glNamedBufferSubData;
/* 2026 */     if (Checks.CHECKS) {
/* 2027 */       Checks.check(__functionAddress);
/*      */     }
/* 2029 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") double[] data) {
/* 2034 */     long __functionAddress = (GL.getICD()).glNamedBufferSubData;
/* 2035 */     if (Checks.CHECKS) {
/* 2036 */       Checks.check(__functionAddress);
/*      */     }
/* 2038 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 2043 */     long __functionAddress = (GL.getICD()).glClearNamedBufferData;
/* 2044 */     if (Checks.CHECKS) {
/* 2045 */       Checks.check(__functionAddress);
/*      */     }
/* 2047 */     JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 2052 */     long __functionAddress = (GL.getICD()).glClearNamedBufferData;
/* 2053 */     if (Checks.CHECKS) {
/* 2054 */       Checks.check(__functionAddress);
/*      */     }
/* 2056 */     JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 2061 */     long __functionAddress = (GL.getICD()).glClearNamedBufferData;
/* 2062 */     if (Checks.CHECKS) {
/* 2063 */       Checks.check(__functionAddress);
/*      */     }
/* 2065 */     JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 2070 */     long __functionAddress = (GL.getICD()).glClearNamedBufferSubData;
/* 2071 */     if (Checks.CHECKS) {
/* 2072 */       Checks.check(__functionAddress);
/*      */     }
/* 2074 */     JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 2079 */     long __functionAddress = (GL.getICD()).glClearNamedBufferSubData;
/* 2080 */     if (Checks.CHECKS) {
/* 2081 */       Checks.check(__functionAddress);
/*      */     }
/* 2083 */     JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 2088 */     long __functionAddress = (GL.getICD()).glClearNamedBufferSubData;
/* 2089 */     if (Checks.CHECKS) {
/* 2090 */       Checks.check(__functionAddress);
/*      */     }
/* 2092 */     JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2097 */     long __functionAddress = (GL.getICD()).glGetNamedBufferParameteriv;
/* 2098 */     if (Checks.CHECKS) {
/* 2099 */       Checks.check(__functionAddress);
/* 2100 */       Checks.check(params, 1);
/*      */     } 
/* 2102 */     JNI.callPV(buffer, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 2107 */     long __functionAddress = (GL.getICD()).glGetNamedBufferParameteri64v;
/* 2108 */     if (Checks.CHECKS) {
/* 2109 */       Checks.check(__functionAddress);
/* 2110 */       Checks.check(params, 1);
/*      */     } 
/* 2112 */     JNI.callPV(buffer, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") short[] data) {
/* 2117 */     long __functionAddress = (GL.getICD()).glGetNamedBufferSubData;
/* 2118 */     if (Checks.CHECKS) {
/* 2119 */       Checks.check(__functionAddress);
/*      */     }
/* 2121 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 1L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") int[] data) {
/* 2126 */     long __functionAddress = (GL.getICD()).glGetNamedBufferSubData;
/* 2127 */     if (Checks.CHECKS) {
/* 2128 */       Checks.check(__functionAddress);
/*      */     }
/* 2130 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") long[] data) {
/* 2135 */     long __functionAddress = (GL.getICD()).glGetNamedBufferSubData;
/* 2136 */     if (Checks.CHECKS) {
/* 2137 */       Checks.check(__functionAddress);
/*      */     }
/* 2139 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") float[] data) {
/* 2144 */     long __functionAddress = (GL.getICD()).glGetNamedBufferSubData;
/* 2145 */     if (Checks.CHECKS) {
/* 2146 */       Checks.check(__functionAddress);
/*      */     }
/* 2148 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") double[] data) {
/* 2153 */     long __functionAddress = (GL.getICD()).glGetNamedBufferSubData;
/* 2154 */     if (Checks.CHECKS) {
/* 2155 */       Checks.check(__functionAddress);
/*      */     }
/* 2157 */     JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") int[] framebuffers) {
/* 2162 */     long __functionAddress = (GL.getICD()).glCreateFramebuffers;
/* 2163 */     if (Checks.CHECKS) {
/* 2164 */       Checks.check(__functionAddress);
/*      */     }
/* 2166 */     JNI.callPV(framebuffers.length, framebuffers, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] bufs) {
/* 2171 */     long __functionAddress = (GL.getICD()).glNamedFramebufferDrawBuffers;
/* 2172 */     if (Checks.CHECKS) {
/* 2173 */       Checks.check(__functionAddress);
/*      */     }
/* 2175 */     JNI.callPV(framebuffer, bufs.length, bufs, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] attachments) {
/* 2180 */     long __functionAddress = (GL.getICD()).glInvalidateNamedFramebufferData;
/* 2181 */     if (Checks.CHECKS) {
/* 2182 */       Checks.check(__functionAddress);
/*      */     }
/* 2184 */     JNI.callPV(framebuffer, attachments.length, attachments, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 2189 */     long __functionAddress = (GL.getICD()).glInvalidateNamedFramebufferSubData;
/* 2190 */     if (Checks.CHECKS) {
/* 2191 */       Checks.check(__functionAddress);
/*      */     }
/* 2193 */     JNI.callPV(framebuffer, attachments.length, attachments, x, y, width, height, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") int[] value) {
/* 2198 */     long __functionAddress = (GL.getICD()).glClearNamedFramebufferiv;
/* 2199 */     if (Checks.CHECKS) {
/* 2200 */       Checks.check(__functionAddress);
/* 2201 */       Checks.check(value, 1);
/*      */     } 
/* 2203 */     JNI.callPV(framebuffer, buffer, drawbuffer, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") int[] value) {
/* 2208 */     long __functionAddress = (GL.getICD()).glClearNamedFramebufferuiv;
/* 2209 */     if (Checks.CHECKS) {
/* 2210 */       Checks.check(__functionAddress);
/* 2211 */       Checks.check(value, 4);
/*      */     } 
/* 2213 */     JNI.callPV(framebuffer, buffer, drawbuffer, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat const *") float[] value) {
/* 2218 */     long __functionAddress = (GL.getICD()).glClearNamedFramebufferfv;
/* 2219 */     if (Checks.CHECKS) {
/* 2220 */       Checks.check(__functionAddress);
/* 2221 */       Checks.check(value, 1);
/*      */     } 
/* 2223 */     JNI.callPV(framebuffer, buffer, drawbuffer, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2228 */     long __functionAddress = (GL.getICD()).glGetNamedFramebufferParameteriv;
/* 2229 */     if (Checks.CHECKS) {
/* 2230 */       Checks.check(__functionAddress);
/* 2231 */       Checks.check(params, 1);
/*      */     } 
/* 2233 */     JNI.callPV(framebuffer, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2238 */     long __functionAddress = (GL.getICD()).glGetNamedFramebufferAttachmentParameteriv;
/* 2239 */     if (Checks.CHECKS) {
/* 2240 */       Checks.check(__functionAddress);
/* 2241 */       Checks.check(params, 1);
/*      */     } 
/* 2243 */     JNI.callPV(framebuffer, attachment, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") int[] renderbuffers) {
/* 2248 */     long __functionAddress = (GL.getICD()).glCreateRenderbuffers;
/* 2249 */     if (Checks.CHECKS) {
/* 2250 */       Checks.check(__functionAddress);
/*      */     }
/* 2252 */     JNI.callPV(renderbuffers.length, renderbuffers, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2257 */     long __functionAddress = (GL.getICD()).glGetNamedRenderbufferParameteriv;
/* 2258 */     if (Checks.CHECKS) {
/* 2259 */       Checks.check(__functionAddress);
/* 2260 */       Checks.check(params, 1);
/*      */     } 
/* 2262 */     JNI.callPV(renderbuffer, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int target, @NativeType("GLuint *") int[] textures) {
/* 2267 */     long __functionAddress = (GL.getICD()).glCreateTextures;
/* 2268 */     if (Checks.CHECKS) {
/* 2269 */       Checks.check(__functionAddress);
/*      */     }
/* 2271 */     JNI.callPV(target, textures.length, textures, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 2276 */     long __functionAddress = (GL.getICD()).glTextureSubImage1D;
/* 2277 */     if (Checks.CHECKS) {
/* 2278 */       Checks.check(__functionAddress);
/*      */     }
/* 2280 */     JNI.callPV(texture, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 2285 */     long __functionAddress = (GL.getICD()).glTextureSubImage1D;
/* 2286 */     if (Checks.CHECKS) {
/* 2287 */       Checks.check(__functionAddress);
/*      */     }
/* 2289 */     JNI.callPV(texture, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 2294 */     long __functionAddress = (GL.getICD()).glTextureSubImage1D;
/* 2295 */     if (Checks.CHECKS) {
/* 2296 */       Checks.check(__functionAddress);
/*      */     }
/* 2298 */     JNI.callPV(texture, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 2303 */     long __functionAddress = (GL.getICD()).glTextureSubImage1D;
/* 2304 */     if (Checks.CHECKS) {
/* 2305 */       Checks.check(__functionAddress);
/*      */     }
/* 2307 */     JNI.callPV(texture, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 2312 */     long __functionAddress = (GL.getICD()).glTextureSubImage2D;
/* 2313 */     if (Checks.CHECKS) {
/* 2314 */       Checks.check(__functionAddress);
/*      */     }
/* 2316 */     JNI.callPV(texture, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 2321 */     long __functionAddress = (GL.getICD()).glTextureSubImage2D;
/* 2322 */     if (Checks.CHECKS) {
/* 2323 */       Checks.check(__functionAddress);
/*      */     }
/* 2325 */     JNI.callPV(texture, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 2330 */     long __functionAddress = (GL.getICD()).glTextureSubImage2D;
/* 2331 */     if (Checks.CHECKS) {
/* 2332 */       Checks.check(__functionAddress);
/*      */     }
/* 2334 */     JNI.callPV(texture, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 2339 */     long __functionAddress = (GL.getICD()).glTextureSubImage2D;
/* 2340 */     if (Checks.CHECKS) {
/* 2341 */       Checks.check(__functionAddress);
/*      */     }
/* 2343 */     JNI.callPV(texture, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 2348 */     long __functionAddress = (GL.getICD()).glTextureSubImage3D;
/* 2349 */     if (Checks.CHECKS) {
/* 2350 */       Checks.check(__functionAddress);
/*      */     }
/* 2352 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 2357 */     long __functionAddress = (GL.getICD()).glTextureSubImage3D;
/* 2358 */     if (Checks.CHECKS) {
/* 2359 */       Checks.check(__functionAddress);
/*      */     }
/* 2361 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 2366 */     long __functionAddress = (GL.getICD()).glTextureSubImage3D;
/* 2367 */     if (Checks.CHECKS) {
/* 2368 */       Checks.check(__functionAddress);
/*      */     }
/* 2370 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 2375 */     long __functionAddress = (GL.getICD()).glTextureSubImage3D;
/* 2376 */     if (Checks.CHECKS) {
/* 2377 */       Checks.check(__functionAddress);
/*      */     }
/* 2379 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 2384 */     long __functionAddress = (GL.getICD()).glTextureParameterfv;
/* 2385 */     if (Checks.CHECKS) {
/* 2386 */       Checks.check(__functionAddress);
/* 2387 */       Checks.check(params, 4);
/*      */     } 
/* 2389 */     JNI.callPV(texture, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 2394 */     long __functionAddress = (GL.getICD()).glTextureParameterIiv;
/* 2395 */     if (Checks.CHECKS) {
/* 2396 */       Checks.check(__functionAddress);
/* 2397 */       Checks.check(params, 1);
/*      */     } 
/* 2399 */     JNI.callPV(texture, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int[] params) {
/* 2404 */     long __functionAddress = (GL.getICD()).glTextureParameterIuiv;
/* 2405 */     if (Checks.CHECKS) {
/* 2406 */       Checks.check(__functionAddress);
/* 2407 */       Checks.check(params, 1);
/*      */     } 
/* 2409 */     JNI.callPV(texture, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 2414 */     long __functionAddress = (GL.getICD()).glTextureParameteriv;
/* 2415 */     if (Checks.CHECKS) {
/* 2416 */       Checks.check(__functionAddress);
/* 2417 */       Checks.check(params, 4);
/*      */     } 
/* 2419 */     JNI.callPV(texture, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 2424 */     long __functionAddress = (GL.getICD()).glGetTextureImage;
/* 2425 */     if (Checks.CHECKS) {
/* 2426 */       Checks.check(__functionAddress);
/*      */     }
/* 2428 */     JNI.callPV(texture, level, format, type, pixels.length << 1, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 2433 */     long __functionAddress = (GL.getICD()).glGetTextureImage;
/* 2434 */     if (Checks.CHECKS) {
/* 2435 */       Checks.check(__functionAddress);
/*      */     }
/* 2437 */     JNI.callPV(texture, level, format, type, pixels.length << 2, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 2442 */     long __functionAddress = (GL.getICD()).glGetTextureImage;
/* 2443 */     if (Checks.CHECKS) {
/* 2444 */       Checks.check(__functionAddress);
/*      */     }
/* 2446 */     JNI.callPV(texture, level, format, type, pixels.length << 2, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 2451 */     long __functionAddress = (GL.getICD()).glGetTextureImage;
/* 2452 */     if (Checks.CHECKS) {
/* 2453 */       Checks.check(__functionAddress);
/*      */     }
/* 2455 */     JNI.callPV(texture, level, format, type, pixels.length << 3, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 2460 */     long __functionAddress = (GL.getICD()).glGetTextureLevelParameterfv;
/* 2461 */     if (Checks.CHECKS) {
/* 2462 */       Checks.check(__functionAddress);
/* 2463 */       Checks.check(params, 1);
/*      */     } 
/* 2465 */     JNI.callPV(texture, level, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2470 */     long __functionAddress = (GL.getICD()).glGetTextureLevelParameteriv;
/* 2471 */     if (Checks.CHECKS) {
/* 2472 */       Checks.check(__functionAddress);
/* 2473 */       Checks.check(params, 1);
/*      */     } 
/* 2475 */     JNI.callPV(texture, level, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 2480 */     long __functionAddress = (GL.getICD()).glGetTextureParameterfv;
/* 2481 */     if (Checks.CHECKS) {
/* 2482 */       Checks.check(__functionAddress);
/* 2483 */       Checks.check(params, 1);
/*      */     } 
/* 2485 */     JNI.callPV(texture, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2490 */     long __functionAddress = (GL.getICD()).glGetTextureParameterIiv;
/* 2491 */     if (Checks.CHECKS) {
/* 2492 */       Checks.check(__functionAddress);
/* 2493 */       Checks.check(params, 1);
/*      */     } 
/* 2495 */     JNI.callPV(texture, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 2500 */     long __functionAddress = (GL.getICD()).glGetTextureParameterIuiv;
/* 2501 */     if (Checks.CHECKS) {
/* 2502 */       Checks.check(__functionAddress);
/* 2503 */       Checks.check(params, 1);
/*      */     } 
/* 2505 */     JNI.callPV(texture, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2510 */     long __functionAddress = (GL.getICD()).glGetTextureParameteriv;
/* 2511 */     if (Checks.CHECKS) {
/* 2512 */       Checks.check(__functionAddress);
/* 2513 */       Checks.check(params, 1);
/*      */     } 
/* 2515 */     JNI.callPV(texture, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") int[] arrays) {
/* 2520 */     long __functionAddress = (GL.getICD()).glCreateVertexArrays;
/* 2521 */     if (Checks.CHECKS) {
/* 2522 */       Checks.check(__functionAddress);
/*      */     }
/* 2524 */     JNI.callPV(arrays.length, arrays, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") int[] strides) {
/* 2529 */     long __functionAddress = (GL.getICD()).glVertexArrayVertexBuffers;
/* 2530 */     if (Checks.CHECKS) {
/* 2531 */       Checks.check(__functionAddress);
/* 2532 */       Checks.checkSafe((CustomBuffer)offsets, Checks.lengthSafe(buffers));
/* 2533 */       Checks.checkSafe(strides, Checks.lengthSafe(buffers));
/*      */     } 
/* 2535 */     JNI.callPPPV(vaobj, first, Checks.lengthSafe(buffers), buffers, MemoryUtil.memAddressSafe((Pointer)offsets), strides, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 2540 */     long __functionAddress = (GL.getICD()).glGetVertexArrayiv;
/* 2541 */     if (Checks.CHECKS) {
/* 2542 */       Checks.check(__functionAddress);
/* 2543 */       Checks.check(param, 1);
/*      */     } 
/* 2545 */     JNI.callPV(vaobj, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 2550 */     long __functionAddress = (GL.getICD()).glGetVertexArrayIndexediv;
/* 2551 */     if (Checks.CHECKS) {
/* 2552 */       Checks.check(__functionAddress);
/* 2553 */       Checks.check(param, 1);
/*      */     } 
/* 2555 */     JNI.callPV(vaobj, index, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] param) {
/* 2560 */     long __functionAddress = (GL.getICD()).glGetVertexArrayIndexed64iv;
/* 2561 */     if (Checks.CHECKS) {
/* 2562 */       Checks.check(__functionAddress);
/* 2563 */       Checks.check(param, 1);
/*      */     } 
/* 2565 */     JNI.callPV(vaobj, index, pname, param, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") int[] samplers) {
/* 2570 */     long __functionAddress = (GL.getICD()).glCreateSamplers;
/* 2571 */     if (Checks.CHECKS) {
/* 2572 */       Checks.check(__functionAddress);
/*      */     }
/* 2574 */     JNI.callPV(samplers.length, samplers, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") int[] pipelines) {
/* 2579 */     long __functionAddress = (GL.getICD()).glCreateProgramPipelines;
/* 2580 */     if (Checks.CHECKS) {
/* 2581 */       Checks.check(__functionAddress);
/*      */     }
/* 2583 */     JNI.callPV(pipelines.length, pipelines, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int target, @NativeType("GLuint *") int[] ids) {
/* 2588 */     long __functionAddress = (GL.getICD()).glCreateQueries;
/* 2589 */     if (Checks.CHECKS) {
/* 2590 */       Checks.check(__functionAddress);
/*      */     }
/* 2592 */     JNI.callPV(target, ids.length, ids, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 2597 */     long __functionAddress = (GL.getICD()).glGetTextureSubImage;
/* 2598 */     if (Checks.CHECKS) {
/* 2599 */       Checks.check(__functionAddress);
/*      */     }
/* 2601 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.length << 1, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 2606 */     long __functionAddress = (GL.getICD()).glGetTextureSubImage;
/* 2607 */     if (Checks.CHECKS) {
/* 2608 */       Checks.check(__functionAddress);
/*      */     }
/* 2610 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.length << 2, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 2615 */     long __functionAddress = (GL.getICD()).glGetTextureSubImage;
/* 2616 */     if (Checks.CHECKS) {
/* 2617 */       Checks.check(__functionAddress);
/*      */     }
/* 2619 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.length << 2, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 2624 */     long __functionAddress = (GL.getICD()).glGetTextureSubImage;
/* 2625 */     if (Checks.CHECKS) {
/* 2626 */       Checks.check(__functionAddress);
/*      */     }
/* 2628 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.length << 3, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") short[] pixels) {
/* 2633 */     long __functionAddress = (GL.getICD()).glGetCompressedTextureSubImage;
/* 2634 */     if (Checks.CHECKS) {
/* 2635 */       Checks.check(__functionAddress);
/*      */     }
/* 2637 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.length << 1, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") int[] pixels) {
/* 2642 */     long __functionAddress = (GL.getICD()).glGetCompressedTextureSubImage;
/* 2643 */     if (Checks.CHECKS) {
/* 2644 */       Checks.check(__functionAddress);
/*      */     }
/* 2646 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.length << 2, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") float[] pixels) {
/* 2651 */     long __functionAddress = (GL.getICD()).glGetCompressedTextureSubImage;
/* 2652 */     if (Checks.CHECKS) {
/* 2653 */       Checks.check(__functionAddress);
/*      */     }
/* 2655 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.length << 2, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") double[] pixels) {
/* 2660 */     long __functionAddress = (GL.getICD()).glGetCompressedTextureSubImage;
/* 2661 */     if (Checks.CHECKS) {
/* 2662 */       Checks.check(__functionAddress);
/*      */     }
/* 2664 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.length << 3, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] img) {
/* 2669 */     long __functionAddress = (GL.getICD()).glGetnTexImage;
/* 2670 */     if (Checks.CHECKS) {
/* 2671 */       Checks.check(__functionAddress);
/*      */     }
/* 2673 */     JNI.callPV(tex, level, format, type, img.length << 1, img, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] img) {
/* 2678 */     long __functionAddress = (GL.getICD()).glGetnTexImage;
/* 2679 */     if (Checks.CHECKS) {
/* 2680 */       Checks.check(__functionAddress);
/*      */     }
/* 2682 */     JNI.callPV(tex, level, format, type, img.length << 2, img, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] img) {
/* 2687 */     long __functionAddress = (GL.getICD()).glGetnTexImage;
/* 2688 */     if (Checks.CHECKS) {
/* 2689 */       Checks.check(__functionAddress);
/*      */     }
/* 2691 */     JNI.callPV(tex, level, format, type, img.length << 2, img, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] img) {
/* 2696 */     long __functionAddress = (GL.getICD()).glGetnTexImage;
/* 2697 */     if (Checks.CHECKS) {
/* 2698 */       Checks.check(__functionAddress);
/*      */     }
/* 2700 */     JNI.callPV(tex, level, format, type, img.length << 3, img, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 2705 */     long __functionAddress = (GL.getICD()).glReadnPixels;
/* 2706 */     if (Checks.CHECKS) {
/* 2707 */       Checks.check(__functionAddress);
/*      */     }
/* 2709 */     JNI.callPV(x, y, width, height, format, type, pixels.length << 1, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 2714 */     long __functionAddress = (GL.getICD()).glReadnPixels;
/* 2715 */     if (Checks.CHECKS) {
/* 2716 */       Checks.check(__functionAddress);
/*      */     }
/* 2718 */     JNI.callPV(x, y, width, height, format, type, pixels.length << 2, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 2723 */     long __functionAddress = (GL.getICD()).glReadnPixels;
/* 2724 */     if (Checks.CHECKS) {
/* 2725 */       Checks.check(__functionAddress);
/*      */     }
/* 2727 */     JNI.callPV(x, y, width, height, format, type, pixels.length << 2, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") float[] params) {
/* 2732 */     long __functionAddress = (GL.getICD()).glGetnUniformfv;
/* 2733 */     if (Checks.CHECKS) {
/* 2734 */       Checks.check(__functionAddress);
/*      */     }
/* 2736 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") double[] params) {
/* 2741 */     long __functionAddress = (GL.getICD()).glGetnUniformdv;
/* 2742 */     if (Checks.CHECKS) {
/* 2743 */       Checks.check(__functionAddress);
/*      */     }
/* 2745 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") int[] params) {
/* 2750 */     long __functionAddress = (GL.getICD()).glGetnUniformiv;
/* 2751 */     if (Checks.CHECKS) {
/* 2752 */       Checks.check(__functionAddress);
/*      */     }
/* 2754 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformuiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") int[] params) {
/* 2759 */     long __functionAddress = (GL.getICD()).glGetnUniformuiv;
/* 2760 */     if (Checks.CHECKS) {
/* 2761 */       Checks.check(__functionAddress);
/*      */     }
/* 2763 */     JNI.callPV(program, location, params.length, params, __functionAddress);
/*      */   }
/*      */   
/*      */   public static native void glClipControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglCreateTransformFeedbacks(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glTransformFeedbackBufferBase(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glTransformFeedbackBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void nglGetTransformFeedbackiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTransformFeedbacki_v(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTransformFeedbacki64_v(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCreateBuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglNamedBufferStorage(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nglNamedBufferData(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nglNamedBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void glCopyNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3);
/*      */   
/*      */   public static native void nglClearNamedBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglClearNamedBufferSubData(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3);
/*      */   
/*      */   public static native long nglMapNamedBuffer(int paramInt1, int paramInt2);
/*      */   
/*      */   public static native long nglMapNamedBufferRange(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glUnmapNamedBuffer(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glFlushMappedNamedBufferRange(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void nglGetNamedBufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedBufferParameteri64v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedBufferPointerv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nglCreateFramebuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glNamedFramebufferRenderbuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glNamedFramebufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glNamedFramebufferTexture(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glNamedFramebufferTextureLayer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glNamedFramebufferDrawBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglNamedFramebufferDrawBuffers(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glNamedFramebufferReadBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglInvalidateNamedFramebufferData(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglInvalidateNamedFramebufferSubData(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
/*      */   
/*      */   public static native void nglClearNamedFramebufferiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglClearNamedFramebufferuiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglClearNamedFramebufferfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glClearNamedFramebufferfi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat") float paramFloat, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glBlitNamedFramebuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLbitfield") int paramInt11, @NativeType("GLenum") int paramInt12);
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glCheckNamedFramebufferStatus(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglGetNamedFramebufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCreateRenderbuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glNamedRenderbufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void glNamedRenderbufferStorageMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void nglGetNamedRenderbufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglCreateTextures(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTextureBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glTextureBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glTextureStorage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void glTextureStorage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void glTextureStorage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*      */   
/*      */   public static native void glTextureStorage2DMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glTextureStorage3DMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void nglTextureSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*      */   
/*      */   public static native void glCopyTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*      */   
/*      */   public static native void glCopyTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8);
/*      */   
/*      */   public static native void glCopyTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9);
/*      */   
/*      */   public static native void glTextureParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTextureParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTextureParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglTextureParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglTextureParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglTextureParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glGenerateTextureMipmap(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glBindTextureUnit(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglGetTextureImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglGetCompressedTextureImage(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureLevelParameterfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureLevelParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglCreateVertexArrays(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glDisableVertexArrayAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glEnableVertexArrayAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexArrayElementBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexArrayVertexBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void nglVertexArrayVertexBuffers(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void glVertexArrayAttribFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glVertexArrayAttribIFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glVertexArrayAttribLFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glVertexArrayAttribBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glVertexArrayBindingDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void nglGetVertexArrayiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayIndexediv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayIndexed64iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCreateSamplers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglCreateProgramPipelines(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglCreateQueries(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glGetQueryBufferObjectiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glGetQueryBufferObjectuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glGetQueryBufferObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glGetQueryBufferObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glMemoryBarrierByRegion(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void nglGetTextureSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void nglGetCompressedTextureSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void glTextureBarrier();
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glGetGraphicsResetStatus();
/*      */   
/*      */   public static native void nglGetnTexImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglReadnPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglGetnCompressedTexImage(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformdv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformuiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL45C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */