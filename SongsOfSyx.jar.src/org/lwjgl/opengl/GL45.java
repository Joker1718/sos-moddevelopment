/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL45
/*      */   extends GL44
/*      */ {
/*      */   public static final int GL_NEGATIVE_ONE_TO_ONE = 37726;
/*      */   public static final int GL_ZERO_TO_ONE = 37727;
/*      */   
/*      */   static {
/*   23 */     GL.initialize();
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
/*      */   protected GL45() {
/*   67 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClipControl(@NativeType("GLenum") int origin, @NativeType("GLenum") int depth) {
/*   74 */     GL45C.glClipControl(origin, depth);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateTransformFeedbacks(int n, long ids) {
/*   81 */     GL45C.nglCreateTransformFeedbacks(n, ids);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") IntBuffer ids) {
/*   86 */     GL45C.glCreateTransformFeedbacks(ids);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTransformFeedbacks() {
/*   92 */     return GL45C.glCreateTransformFeedbacks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTransformFeedbackBufferBase(@NativeType("GLuint") int xfb, @NativeType("GLuint") int index, @NativeType("GLuint") int buffer) {
/*   99 */     GL45C.glTransformFeedbackBufferBase(xfb, index, buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTransformFeedbackBufferRange(@NativeType("GLuint") int xfb, @NativeType("GLuint") int index, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size) {
/*  106 */     GL45C.glTransformFeedbackBufferRange(xfb, index, buffer, offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbackiv(int xfb, int pname, long param) {
/*  113 */     GL45C.nglGetTransformFeedbackiv(xfb, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/*  118 */     GL45C.glGetTransformFeedbackiv(xfb, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname) {
/*  124 */     return GL45C.glGetTransformFeedbacki(xfb, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbacki_v(int xfb, int pname, int index, long param) {
/*  131 */     GL45C.nglGetTransformFeedbacki_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer param) {
/*  136 */     GL45C.glGetTransformFeedbacki_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/*  142 */     return GL45C.glGetTransformFeedbacki(xfb, pname, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbacki64_v(int xfb, int pname, int index, long param) {
/*  149 */     GL45C.nglGetTransformFeedbacki64_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") LongBuffer param) {
/*  154 */     GL45C.glGetTransformFeedbacki64_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetTransformFeedbacki64(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/*  160 */     return GL45C.glGetTransformFeedbacki64(xfb, pname, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateBuffers(int n, long buffers) {
/*  167 */     GL45C.nglCreateBuffers(n, buffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") IntBuffer buffers) {
/*  172 */     GL45C.glCreateBuffers(buffers);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateBuffers() {
/*  178 */     return GL45C.glCreateBuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedBufferStorage(int buffer, long size, long data, int flags) {
/*  185 */     GL45C.nglNamedBufferStorage(buffer, size, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("GLsizeiptr") long size, @NativeType("GLbitfield") int flags) {
/*  190 */     GL45C.glNamedBufferStorage(buffer, size, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") ByteBuffer data, @NativeType("GLbitfield") int flags) {
/*  195 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") ShortBuffer data, @NativeType("GLbitfield") int flags) {
/*  200 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") IntBuffer data, @NativeType("GLbitfield") int flags) {
/*  205 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") FloatBuffer data, @NativeType("GLbitfield") int flags) {
/*  210 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") DoubleBuffer data, @NativeType("GLbitfield") int flags) {
/*  215 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedBufferData(int buffer, long size, long data, int usage) {
/*  222 */     GL45C.nglNamedBufferData(buffer, size, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int usage) {
/*  227 */     GL45C.glNamedBufferData(buffer, size, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") ByteBuffer data, @NativeType("GLenum") int usage) {
/*  232 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") ShortBuffer data, @NativeType("GLenum") int usage) {
/*  237 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") IntBuffer data, @NativeType("GLenum") int usage) {
/*  242 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") LongBuffer data, @NativeType("GLenum") int usage) {
/*  247 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") FloatBuffer data, @NativeType("GLenum") int usage) {
/*  252 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") DoubleBuffer data, @NativeType("GLenum") int usage) {
/*  257 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedBufferSubData(int buffer, long offset, long size, long data) {
/*  264 */     GL45C.nglNamedBufferSubData(buffer, offset, size, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ByteBuffer data) {
/*  269 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ShortBuffer data) {
/*  274 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") IntBuffer data) {
/*  279 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") LongBuffer data) {
/*  284 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") FloatBuffer data) {
/*  289 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") DoubleBuffer data) {
/*  294 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyNamedBufferSubData(@NativeType("GLuint") int readBuffer, @NativeType("GLuint") int writeBuffer, @NativeType("GLintptr") long readOffset, @NativeType("GLintptr") long writeOffset, @NativeType("GLsizeiptr") long size) {
/*  301 */     GL45C.glCopyNamedBufferSubData(readBuffer, writeBuffer, readOffset, writeOffset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedBufferData(int buffer, int internalformat, int format, int type, long data) {
/*  308 */     GL45C.nglClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  313 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  318 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  323 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  328 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, long data) {
/*  335 */     GL45C.nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  340 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  345 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  350 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  355 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapNamedBuffer(int buffer, int access) {
/*  362 */     return GL45C.nglMapNamedBuffer(buffer, access);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access) {
/*  368 */     return GL45C.glMapNamedBuffer(buffer, access);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access, ByteBuffer old_buffer) {
/*  374 */     return GL45C.glMapNamedBuffer(buffer, access, old_buffer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access, long length, ByteBuffer old_buffer) {
/*  380 */     return GL45C.glMapNamedBuffer(buffer, access, length, old_buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapNamedBufferRange(int buffer, long offset, long length, int access) {
/*  387 */     return GL45C.nglMapNamedBufferRange(buffer, offset, length, access);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access) {
/*  393 */     return GL45C.glMapNamedBufferRange(buffer, offset, length, access);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access, ByteBuffer old_buffer) {
/*  399 */     return GL45C.glMapNamedBufferRange(buffer, offset, length, access, old_buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glUnmapNamedBuffer(@NativeType("GLuint") int buffer) {
/*  407 */     return GL45C.glUnmapNamedBuffer(buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFlushMappedNamedBufferRange(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length) {
/*  414 */     GL45C.glFlushMappedNamedBufferRange(buffer, offset, length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferParameteriv(int buffer, int pname, long params) {
/*  421 */     GL45C.nglGetNamedBufferParameteriv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  426 */     GL45C.glGetNamedBufferParameteriv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedBufferParameteri(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/*  432 */     return GL45C.glGetNamedBufferParameteri(buffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferParameteri64v(int buffer, int pname, long params) {
/*  439 */     GL45C.nglGetNamedBufferParameteri64v(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/*  444 */     GL45C.glGetNamedBufferParameteri64v(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferParameteri64(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/*  450 */     return GL45C.glGetNamedBufferParameteri64(buffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferPointerv(int buffer, int pname, long params) {
/*  457 */     GL45C.nglGetNamedBufferPointerv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferPointerv(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer params) {
/*  462 */     GL45C.glGetNamedBufferPointerv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferPointer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/*  468 */     return GL45C.glGetNamedBufferPointer(buffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferSubData(int buffer, long offset, long size, long data) {
/*  475 */     GL45C.nglGetNamedBufferSubData(buffer, offset, size, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") ByteBuffer data) {
/*  480 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") ShortBuffer data) {
/*  485 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") IntBuffer data) {
/*  490 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") LongBuffer data) {
/*  495 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") FloatBuffer data) {
/*  500 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") DoubleBuffer data) {
/*  505 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateFramebuffers(int n, long framebuffers) {
/*  512 */     GL45C.nglCreateFramebuffers(n, framebuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") IntBuffer framebuffers) {
/*  517 */     GL45C.glCreateFramebuffers(framebuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateFramebuffers() {
/*  523 */     return GL45C.glCreateFramebuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferRenderbuffer(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int renderbuffertarget, @NativeType("GLuint") int renderbuffer) {
/*  530 */     GL45C.glNamedFramebufferRenderbuffer(framebuffer, attachment, renderbuffertarget, renderbuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferParameteri(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/*  537 */     GL45C.glNamedFramebufferParameteri(framebuffer, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferTexture(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLuint") int texture, @NativeType("GLint") int level) {
/*  544 */     GL45C.glNamedFramebufferTexture(framebuffer, attachment, texture, level);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferTextureLayer(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int layer) {
/*  551 */     GL45C.glNamedFramebufferTextureLayer(framebuffer, attachment, texture, level, layer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffer(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buf) {
/*  558 */     GL45C.glNamedFramebufferDrawBuffer(framebuffer, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedFramebufferDrawBuffers(int framebuffer, int n, long bufs) {
/*  565 */     GL45C.nglNamedFramebufferDrawBuffers(framebuffer, n, bufs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer bufs) {
/*  570 */     GL45C.glNamedFramebufferDrawBuffers(framebuffer, bufs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int buf) {
/*  575 */     GL45C.glNamedFramebufferDrawBuffers(framebuffer, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferReadBuffer(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int src) {
/*  582 */     GL45C.glNamedFramebufferReadBuffer(framebuffer, src);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglInvalidateNamedFramebufferData(int framebuffer, int numAttachments, long attachments) {
/*  589 */     GL45C.nglInvalidateNamedFramebufferData(framebuffer, numAttachments, attachments);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer attachments) {
/*  594 */     GL45C.glInvalidateNamedFramebufferData(framebuffer, attachments);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int attachment) {
/*  599 */     GL45C.glInvalidateNamedFramebufferData(framebuffer, attachment);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, long attachments, int x, int y, int width, int height) {
/*  606 */     GL45C.nglInvalidateNamedFramebufferSubData(framebuffer, numAttachments, attachments, x, y, width, height);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  611 */     GL45C.glInvalidateNamedFramebufferSubData(framebuffer, attachments, x, y, width, height);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int attachment, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  616 */     GL45C.glInvalidateNamedFramebufferSubData(framebuffer, attachment, x, y, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, long value) {
/*  623 */     GL45C.nglClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") IntBuffer value) {
/*  628 */     GL45C.glClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, long value) {
/*  635 */     GL45C.nglClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") IntBuffer value) {
/*  640 */     GL45C.glClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, long value) {
/*  647 */     GL45C.nglClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat const *") FloatBuffer value) {
/*  652 */     GL45C.glClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfi(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat") float depth, @NativeType("GLint") int stencil) {
/*  659 */     GL45C.glClearNamedFramebufferfi(framebuffer, buffer, drawbuffer, depth, stencil);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBlitNamedFramebuffer(@NativeType("GLuint") int readFramebuffer, @NativeType("GLuint") int drawFramebuffer, @NativeType("GLint") int srcX0, @NativeType("GLint") int srcY0, @NativeType("GLint") int srcX1, @NativeType("GLint") int srcY1, @NativeType("GLint") int dstX0, @NativeType("GLint") int dstY0, @NativeType("GLint") int dstX1, @NativeType("GLint") int dstY1, @NativeType("GLbitfield") int mask, @NativeType("GLenum") int filter) {
/*  666 */     GL45C.glBlitNamedFramebuffer(readFramebuffer, drawFramebuffer, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glCheckNamedFramebufferStatus(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int target) {
/*  674 */     return GL45C.glCheckNamedFramebufferStatus(framebuffer, target);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedFramebufferParameteriv(int framebuffer, int pname, long params) {
/*  681 */     GL45C.nglGetNamedFramebufferParameteriv(framebuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  686 */     GL45C.glGetNamedFramebufferParameteriv(framebuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferParameteri(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname) {
/*  692 */     return GL45C.glGetNamedFramebufferParameteri(framebuffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, long params) {
/*  699 */     GL45C.nglGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  704 */     GL45C.glGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferAttachmentParameteri(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname) {
/*  710 */     return GL45C.glGetNamedFramebufferAttachmentParameteri(framebuffer, attachment, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateRenderbuffers(int n, long renderbuffers) {
/*  717 */     GL45C.nglCreateRenderbuffers(n, renderbuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") IntBuffer renderbuffers) {
/*  722 */     GL45C.glCreateRenderbuffers(renderbuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateRenderbuffers() {
/*  728 */     return GL45C.glCreateRenderbuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedRenderbufferStorage(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  735 */     GL45C.glNamedRenderbufferStorage(renderbuffer, internalformat, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedRenderbufferStorageMultisample(@NativeType("GLuint") int renderbuffer, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  742 */     GL45C.glNamedRenderbufferStorageMultisample(renderbuffer, samples, internalformat, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedRenderbufferParameteriv(int renderbuffer, int pname, long params) {
/*  749 */     GL45C.nglGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  754 */     GL45C.glGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedRenderbufferParameteri(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname) {
/*  760 */     return GL45C.glGetNamedRenderbufferParameteri(renderbuffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateTextures(int target, int n, long textures) {
/*  767 */     GL45C.nglCreateTextures(target, n, textures);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int target, @NativeType("GLuint *") IntBuffer textures) {
/*  772 */     GL45C.glCreateTextures(target, textures);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTextures(@NativeType("GLenum") int target) {
/*  778 */     return GL45C.glCreateTextures(target);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureBuffer(@NativeType("GLuint") int texture, @NativeType("GLenum") int internalformat, @NativeType("GLuint") int buffer) {
/*  785 */     GL45C.glTextureBuffer(texture, internalformat, buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureBufferRange(@NativeType("GLuint") int texture, @NativeType("GLenum") int internalformat, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size) {
/*  792 */     GL45C.glTextureBufferRange(texture, internalformat, buffer, offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage1D(@NativeType("GLuint") int texture, @NativeType("GLsizei") int levels, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width) {
/*  799 */     GL45C.glTextureStorage1D(texture, levels, internalformat, width);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage2D(@NativeType("GLuint") int texture, @NativeType("GLsizei") int levels, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  806 */     GL45C.glTextureStorage2D(texture, levels, internalformat, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage3D(@NativeType("GLuint") int texture, @NativeType("GLsizei") int levels, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth) {
/*  813 */     GL45C.glTextureStorage3D(texture, levels, internalformat, width, height, depth);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage2DMultisample(@NativeType("GLuint") int texture, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLboolean") boolean fixedsamplelocations) {
/*  820 */     GL45C.glTextureStorage2DMultisample(texture, samples, internalformat, width, height, fixedsamplelocations);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage3DMultisample(@NativeType("GLuint") int texture, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLboolean") boolean fixedsamplelocations) {
/*  827 */     GL45C.glTextureStorage3DMultisample(texture, samples, internalformat, width, height, depth, fixedsamplelocations);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, long pixels) {
/*  834 */     GL45C.nglTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  839 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  844 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  849 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  854 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  859 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  864 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels) {
/*  871 */     GL45C.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  876 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  881 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  886 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  891 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  896 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  901 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long pixels) {
/*  908 */     GL45C.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  913 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  918 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  923 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  928 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  933 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  938 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, long data) {
/*  945 */     GL45C.nglCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  950 */     GL45C.glCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/*  955 */     GL45C.glCompressedTextureSubImage1D(texture, level, xoffset, width, format, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data) {
/*  962 */     GL45C.nglCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  967 */     GL45C.glCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/*  972 */     GL45C.glCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data) {
/*  979 */     GL45C.nglCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  984 */     GL45C.glCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/*  989 */     GL45C.glCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width) {
/*  996 */     GL45C.glCopyTextureSubImage1D(texture, level, xoffset, x, y, width);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 1003 */     GL45C.glCopyTextureSubImage2D(texture, level, xoffset, yoffset, x, y, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 1010 */     GL45C.glCopyTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, x, y, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterf(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat") float param) {
/* 1017 */     GL45C.glTextureParameterf(texture, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterfv(int texture, int pname, long params) {
/* 1024 */     GL45C.nglTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 1029 */     GL45C.glTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameteri(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/* 1036 */     GL45C.glTextureParameteri(texture, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterIiv(int texture, int pname, long params) {
/* 1043 */     GL45C.nglTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 1048 */     GL45C.glTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIi(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") int param) {
/* 1053 */     GL45C.glTextureParameterIi(texture, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterIuiv(int texture, int pname, long params) {
/* 1060 */     GL45C.nglTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint const *") IntBuffer params) {
/* 1065 */     GL45C.glTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIui(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int param) {
/* 1070 */     GL45C.glTextureParameterIui(texture, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameteriv(int texture, int pname, long params) {
/* 1077 */     GL45C.nglTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 1082 */     GL45C.glTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenerateTextureMipmap(@NativeType("GLuint") int texture) {
/* 1089 */     GL45C.glGenerateTextureMipmap(texture);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindTextureUnit(@NativeType("GLuint") int unit, @NativeType("GLuint") int texture) {
/* 1096 */     GL45C.glBindTextureUnit(unit, texture);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureImage(int texture, int level, int format, int type, int bufSize, long pixels) {
/* 1103 */     GL45C.nglGetTextureImage(texture, level, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1108 */     GL45C.glGetTextureImage(texture, level, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 1113 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 1118 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 1123 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 1128 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/* 1133 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetCompressedTextureImage(int texture, int level, int bufSize, long pixels) {
/* 1140 */     GL45C.nglGetCompressedTextureImage(texture, level, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1145 */     GL45C.glGetCompressedTextureImage(texture, level, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer pixels) {
/* 1150 */     GL45C.glGetCompressedTextureImage(texture, level, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureLevelParameterfv(int texture, int level, int pname, long params) {
/* 1157 */     GL45C.nglGetTextureLevelParameterfv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1162 */     GL45C.glGetTextureLevelParameterfv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureLevelParameterf(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 1168 */     return GL45C.glGetTextureLevelParameterf(texture, level, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureLevelParameteriv(int texture, int level, int pname, long params) {
/* 1175 */     GL45C.nglGetTextureLevelParameteriv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1180 */     GL45C.glGetTextureLevelParameteriv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureLevelParameteri(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 1186 */     return GL45C.glGetTextureLevelParameteri(texture, level, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterfv(int texture, int pname, long params) {
/* 1193 */     GL45C.nglGetTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1198 */     GL45C.glGetTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureParameterf(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1204 */     return GL45C.glGetTextureParameterf(texture, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterIiv(int texture, int pname, long params) {
/* 1211 */     GL45C.nglGetTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1216 */     GL45C.glGetTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIi(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1222 */     return GL45C.glGetTextureParameterIi(texture, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterIuiv(int texture, int pname, long params) {
/* 1229 */     GL45C.nglGetTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 1234 */     GL45C.glGetTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIui(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1240 */     return GL45C.glGetTextureParameterIui(texture, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameteriv(int texture, int pname, long params) {
/* 1247 */     GL45C.nglGetTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1252 */     GL45C.glGetTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameteri(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1258 */     return GL45C.glGetTextureParameteri(texture, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateVertexArrays(int n, long arrays) {
/* 1265 */     GL45C.nglCreateVertexArrays(n, arrays);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") IntBuffer arrays) {
/* 1270 */     GL45C.glCreateVertexArrays(arrays);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateVertexArrays() {
/* 1276 */     return GL45C.glCreateVertexArrays();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisableVertexArrayAttrib(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index) {
/* 1283 */     GL45C.glDisableVertexArrayAttrib(vaobj, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnableVertexArrayAttrib(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index) {
/* 1290 */     GL45C.glEnableVertexArrayAttrib(vaobj, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayElementBuffer(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int buffer) {
/* 1297 */     GL45C.glVertexArrayElementBuffer(vaobj, buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffer(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int bindingindex, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizei") int stride) {
/* 1304 */     GL45C.glVertexArrayVertexBuffer(vaobj, bindingindex, buffer, offset, stride);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexArrayVertexBuffers(int vaobj, int first, int count, long buffers, long offsets, long strides) {
/* 1311 */     GL45C.nglVertexArrayVertexBuffers(vaobj, first, count, buffers, offsets, strides);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") IntBuffer strides) {
/* 1316 */     GL45C.glVertexArrayVertexBuffers(vaobj, first, buffers, offsets, strides);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribFormat(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int relativeoffset) {
/* 1323 */     GL45C.glVertexArrayAttribFormat(vaobj, attribindex, size, type, normalized, relativeoffset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribIFormat(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLuint") int relativeoffset) {
/* 1330 */     GL45C.glVertexArrayAttribIFormat(vaobj, attribindex, size, type, relativeoffset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribLFormat(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLuint") int relativeoffset) {
/* 1337 */     GL45C.glVertexArrayAttribLFormat(vaobj, attribindex, size, type, relativeoffset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribBinding(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int attribindex, @NativeType("GLuint") int bindingindex) {
/* 1344 */     GL45C.glVertexArrayAttribBinding(vaobj, attribindex, bindingindex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayBindingDivisor(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int bindingindex, @NativeType("GLuint") int divisor) {
/* 1351 */     GL45C.glVertexArrayBindingDivisor(vaobj, bindingindex, divisor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayiv(int vaobj, int pname, long param) {
/* 1358 */     GL45C.nglGetVertexArrayiv(vaobj, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/* 1363 */     GL45C.glGetVertexArrayiv(vaobj, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayi(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname) {
/* 1369 */     return GL45C.glGetVertexArrayi(vaobj, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayIndexediv(int vaobj, int index, int pname, long param) {
/* 1376 */     GL45C.nglGetVertexArrayIndexediv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/* 1381 */     GL45C.glGetVertexArrayIndexediv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayIndexedi(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1387 */     return GL45C.glGetVertexArrayIndexedi(vaobj, index, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayIndexed64iv(int vaobj, int index, int pname, long param) {
/* 1394 */     GL45C.nglGetVertexArrayIndexed64iv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer param) {
/* 1399 */     GL45C.glGetVertexArrayIndexed64iv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexArrayIndexed64i(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1405 */     return GL45C.glGetVertexArrayIndexed64i(vaobj, index, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateSamplers(int n, long samplers) {
/* 1412 */     GL45C.nglCreateSamplers(n, samplers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") IntBuffer samplers) {
/* 1417 */     GL45C.glCreateSamplers(samplers);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateSamplers() {
/* 1423 */     return GL45C.glCreateSamplers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateProgramPipelines(int n, long pipelines) {
/* 1430 */     GL45C.nglCreateProgramPipelines(n, pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") IntBuffer pipelines) {
/* 1435 */     GL45C.glCreateProgramPipelines(pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateProgramPipelines() {
/* 1441 */     return GL45C.glCreateProgramPipelines();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateQueries(int target, int n, long ids) {
/* 1448 */     GL45C.nglCreateQueries(target, n, ids);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int target, @NativeType("GLuint *") IntBuffer ids) {
/* 1453 */     GL45C.glCreateQueries(target, ids);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateQueries(@NativeType("GLenum") int target) {
/* 1459 */     return GL45C.glCreateQueries(target);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjectiv(@NativeType("GLuint") int id, @NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLintptr") long offset) {
/* 1466 */     GL45C.glGetQueryBufferObjectiv(id, buffer, pname, offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjectuiv(@NativeType("GLuint") int id, @NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLintptr") long offset) {
/* 1473 */     GL45C.glGetQueryBufferObjectuiv(id, buffer, pname, offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjecti64v(@NativeType("GLuint") int id, @NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLintptr") long offset) {
/* 1480 */     GL45C.glGetQueryBufferObjecti64v(id, buffer, pname, offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjectui64v(@NativeType("GLuint") int id, @NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLintptr") long offset) {
/* 1487 */     GL45C.glGetQueryBufferObjectui64v(id, buffer, pname, offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMemoryBarrierByRegion(@NativeType("GLbitfield") int barriers) {
/* 1494 */     GL45C.glMemoryBarrierByRegion(barriers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, long pixels) {
/* 1501 */     GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1506 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 1511 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 1516 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 1521 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 1526 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/* 1531 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, long pixels) {
/* 1538 */     GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1543 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") ByteBuffer pixels) {
/* 1548 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") ShortBuffer pixels) {
/* 1553 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") IntBuffer pixels) {
/* 1558 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") FloatBuffer pixels) {
/* 1563 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") DoubleBuffer pixels) {
/* 1568 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureBarrier() {
/* 1575 */     GL45C.glTextureBarrier();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glGetGraphicsResetStatus() {
/* 1583 */     return GL45C.glGetGraphicsResetStatus();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMapdv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLdouble *") DoubleBuffer data) {
/* 1593 */     nglGetnMapdv(target, query, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetnMapd(@NativeType("GLenum") int target, @NativeType("GLenum") int query) {
/* 1599 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1601 */       DoubleBuffer data = stack.callocDouble(1);
/* 1602 */       nglGetnMapdv(target, query, 1, MemoryUtil.memAddress(data));
/* 1603 */       return data.get(0);
/*      */     } finally {
/* 1605 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMapfv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLfloat *") FloatBuffer data) {
/* 1616 */     nglGetnMapfv(target, query, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetnMapf(@NativeType("GLenum") int target, @NativeType("GLenum") int query) {
/* 1622 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1624 */       FloatBuffer data = stack.callocFloat(1);
/* 1625 */       nglGetnMapfv(target, query, 1, MemoryUtil.memAddress(data));
/* 1626 */       return data.get(0);
/*      */     } finally {
/* 1628 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMapiv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLint *") IntBuffer data) {
/* 1639 */     nglGetnMapiv(target, query, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetnMapi(@NativeType("GLenum") int target, @NativeType("GLenum") int query) {
/* 1645 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1647 */       IntBuffer data = stack.callocInt(1);
/* 1648 */       nglGetnMapiv(target, query, 1, MemoryUtil.memAddress(data));
/* 1649 */       return data.get(0);
/*      */     } finally {
/* 1651 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapfv(@NativeType("GLenum") int map, @NativeType("GLfloat *") FloatBuffer data) {
/* 1662 */     nglGetnPixelMapfv(map, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapuiv(@NativeType("GLenum") int map, @NativeType("GLuint *") IntBuffer data) {
/* 1672 */     nglGetnPixelMapuiv(map, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapusv(@NativeType("GLenum") int map, @NativeType("GLushort *") ShortBuffer data) {
/* 1682 */     nglGetnPixelMapusv(map, data.remaining(), MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPolygonStipple(@NativeType("GLsizei") int bufSize, @NativeType("GLubyte *") long pattern) {
/* 1692 */     nglGetnPolygonStipple(bufSize, pattern);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnPolygonStipple(@NativeType("GLubyte *") ByteBuffer pattern) {
/* 1697 */     nglGetnPolygonStipple(pattern.remaining(), MemoryUtil.memAddress(pattern));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnTexImage(int tex, int level, int format, int type, int bufSize, long img) {
/* 1704 */     GL45C.nglGetnTexImage(tex, level, format, type, bufSize, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long img) {
/* 1709 */     GL45C.glGetnTexImage(tex, level, format, type, bufSize, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer img) {
/* 1714 */     GL45C.glGetnTexImage(tex, level, format, type, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer img) {
/* 1719 */     GL45C.glGetnTexImage(tex, level, format, type, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer img) {
/* 1724 */     GL45C.glGetnTexImage(tex, level, format, type, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer img) {
/* 1729 */     GL45C.glGetnTexImage(tex, level, format, type, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer img) {
/* 1734 */     GL45C.glGetnTexImage(tex, level, format, type, img);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, long pixels) {
/* 1741 */     GL45C.nglReadnPixels(x, y, width, height, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1746 */     GL45C.glReadnPixels(x, y, width, height, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 1751 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 1756 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 1761 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 1766 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long table) {
/* 1776 */     nglGetnColorTable(target, format, type, bufSize, table);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer table) {
/* 1781 */     nglGetnColorTable(target, format, type, table.remaining(), MemoryUtil.memAddress(table));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer table) {
/* 1786 */     nglGetnColorTable(target, format, type, table.remaining() << 1, MemoryUtil.memAddress(table));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer table) {
/* 1791 */     nglGetnColorTable(target, format, type, table.remaining() << 2, MemoryUtil.memAddress(table));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer table) {
/* 1796 */     nglGetnColorTable(target, format, type, table.remaining() << 2, MemoryUtil.memAddress(table));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnConvolutionFilter(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long image) {
/* 1806 */     nglGetnConvolutionFilter(target, format, type, bufSize, image);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnConvolutionFilter(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer image) {
/* 1811 */     nglGetnConvolutionFilter(target, format, type, image.remaining(), MemoryUtil.memAddress(image));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnSeparableFilter(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int rowBufSize, @NativeType("void *") long row, @NativeType("GLsizei") int columnBufSize, @NativeType("void *") long column, @NativeType("void *") ByteBuffer span) {
/* 1821 */     nglGetnSeparableFilter(target, format, type, rowBufSize, row, columnBufSize, column, MemoryUtil.memAddressSafe(span));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnSeparableFilter(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer row, @NativeType("void *") ByteBuffer column, @NativeType("void *") ByteBuffer span) {
/* 1826 */     nglGetnSeparableFilter(target, format, type, row.remaining(), MemoryUtil.memAddress(row), column.remaining(), MemoryUtil.memAddress(column), MemoryUtil.memAddressSafe(span));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnHistogram(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long values) {
/* 1836 */     nglGetnHistogram(target, reset, format, type, bufSize, values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnHistogram(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer values) {
/* 1841 */     nglGetnHistogram(target, reset, format, type, values.remaining(), MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMinmax(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long values) {
/* 1851 */     nglGetnMinmax(target, reset, format, type, bufSize, values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnMinmax(@NativeType("GLenum") int target, @NativeType("GLboolean") boolean reset, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer values) {
/* 1856 */     nglGetnMinmax(target, reset, format, type, values.remaining(), MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnCompressedTexImage(int target, int level, int bufSize, long img) {
/* 1863 */     GL45C.nglGetnCompressedTexImage(target, level, bufSize, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnCompressedTexImage(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLsizei") int bufSize, @NativeType("void *") long img) {
/* 1868 */     GL45C.glGetnCompressedTexImage(target, level, bufSize, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnCompressedTexImage(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer img) {
/* 1873 */     GL45C.glGetnCompressedTexImage(target, level, img);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnUniformfv(int program, int location, int bufSize, long params) {
/* 1880 */     GL45C.nglGetnUniformfv(program, location, bufSize, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") FloatBuffer params) {
/* 1885 */     GL45C.glGetnUniformfv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetnUniformf(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 1891 */     return GL45C.glGetnUniformf(program, location);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnUniformdv(int program, int location, int bufSize, long params) {
/* 1898 */     GL45C.nglGetnUniformdv(program, location, bufSize, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") DoubleBuffer params) {
/* 1903 */     GL45C.glGetnUniformdv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetnUniformd(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 1909 */     return GL45C.glGetnUniformd(program, location);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnUniformiv(int program, int location, int bufSize, long params) {
/* 1916 */     GL45C.nglGetnUniformiv(program, location, bufSize, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") IntBuffer params) {
/* 1921 */     GL45C.glGetnUniformiv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetnUniformi(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 1927 */     return GL45C.glGetnUniformi(program, location);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnUniformuiv(int program, int location, int bufSize, long params) {
/* 1934 */     GL45C.nglGetnUniformuiv(program, location, bufSize, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformuiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") IntBuffer params) {
/* 1939 */     GL45C.glGetnUniformuiv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetnUniformui(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 1945 */     return GL45C.glGetnUniformui(program, location);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") int[] ids) {
/* 1950 */     GL45C.glCreateTransformFeedbacks(ids);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 1955 */     GL45C.glGetTransformFeedbackiv(xfb, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint *") int[] param) {
/* 1960 */     GL45C.glGetTransformFeedbacki_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") long[] param) {
/* 1965 */     GL45C.glGetTransformFeedbacki64_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") int[] buffers) {
/* 1970 */     GL45C.glCreateBuffers(buffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") short[] data, @NativeType("GLbitfield") int flags) {
/* 1975 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") int[] data, @NativeType("GLbitfield") int flags) {
/* 1980 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") float[] data, @NativeType("GLbitfield") int flags) {
/* 1985 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") double[] data, @NativeType("GLbitfield") int flags) {
/* 1990 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") short[] data, @NativeType("GLenum") int usage) {
/* 1995 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") int[] data, @NativeType("GLenum") int usage) {
/* 2000 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") long[] data, @NativeType("GLenum") int usage) {
/* 2005 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") float[] data, @NativeType("GLenum") int usage) {
/* 2010 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") double[] data, @NativeType("GLenum") int usage) {
/* 2015 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") short[] data) {
/* 2020 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") int[] data) {
/* 2025 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") long[] data) {
/* 2030 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") float[] data) {
/* 2035 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") double[] data) {
/* 2040 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 2045 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 2050 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 2055 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 2060 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 2065 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 2070 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2075 */     GL45C.glGetNamedBufferParameteriv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 2080 */     GL45C.glGetNamedBufferParameteri64v(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") short[] data) {
/* 2085 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") int[] data) {
/* 2090 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") long[] data) {
/* 2095 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") float[] data) {
/* 2100 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") double[] data) {
/* 2105 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") int[] framebuffers) {
/* 2110 */     GL45C.glCreateFramebuffers(framebuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] bufs) {
/* 2115 */     GL45C.glNamedFramebufferDrawBuffers(framebuffer, bufs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] attachments) {
/* 2120 */     GL45C.glInvalidateNamedFramebufferData(framebuffer, attachments);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 2125 */     GL45C.glInvalidateNamedFramebufferSubData(framebuffer, attachments, x, y, width, height);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") int[] value) {
/* 2130 */     GL45C.glClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") int[] value) {
/* 2135 */     GL45C.glClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat const *") float[] value) {
/* 2140 */     GL45C.glClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2145 */     GL45C.glGetNamedFramebufferParameteriv(framebuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2150 */     GL45C.glGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") int[] renderbuffers) {
/* 2155 */     GL45C.glCreateRenderbuffers(renderbuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2160 */     GL45C.glGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int target, @NativeType("GLuint *") int[] textures) {
/* 2165 */     GL45C.glCreateTextures(target, textures);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 2170 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 2175 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 2180 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 2185 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 2190 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 2195 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 2200 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 2205 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 2210 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 2215 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 2220 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 2225 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 2230 */     GL45C.glTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 2235 */     GL45C.glTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int[] params) {
/* 2240 */     GL45C.glTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 2245 */     GL45C.glTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 2250 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 2255 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 2260 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 2265 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 2270 */     GL45C.glGetTextureLevelParameterfv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2275 */     GL45C.glGetTextureLevelParameteriv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 2280 */     GL45C.glGetTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2285 */     GL45C.glGetTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 2290 */     GL45C.glGetTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 2295 */     GL45C.glGetTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") int[] arrays) {
/* 2300 */     GL45C.glCreateVertexArrays(arrays);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") int[] strides) {
/* 2305 */     GL45C.glVertexArrayVertexBuffers(vaobj, first, buffers, offsets, strides);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 2310 */     GL45C.glGetVertexArrayiv(vaobj, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 2315 */     GL45C.glGetVertexArrayIndexediv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] param) {
/* 2320 */     GL45C.glGetVertexArrayIndexed64iv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") int[] samplers) {
/* 2325 */     GL45C.glCreateSamplers(samplers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") int[] pipelines) {
/* 2330 */     GL45C.glCreateProgramPipelines(pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int target, @NativeType("GLuint *") int[] ids) {
/* 2335 */     GL45C.glCreateQueries(target, ids);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 2340 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 2345 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 2350 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 2355 */     GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") short[] pixels) {
/* 2360 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") int[] pixels) {
/* 2365 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") float[] pixels) {
/* 2370 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("void *") double[] pixels) {
/* 2375 */     GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnMapdv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLdouble *") double[] data) {
/* 2380 */     long __functionAddress = (GL.getICD()).glGetnMapdv;
/* 2381 */     if (Checks.CHECKS) {
/* 2382 */       Checks.check(__functionAddress);
/*      */     }
/* 2384 */     JNI.callPV(target, query, data.length, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnMapfv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLfloat *") float[] data) {
/* 2389 */     long __functionAddress = (GL.getICD()).glGetnMapfv;
/* 2390 */     if (Checks.CHECKS) {
/* 2391 */       Checks.check(__functionAddress);
/*      */     }
/* 2393 */     JNI.callPV(target, query, data.length, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnMapiv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLint *") int[] data) {
/* 2398 */     long __functionAddress = (GL.getICD()).glGetnMapiv;
/* 2399 */     if (Checks.CHECKS) {
/* 2400 */       Checks.check(__functionAddress);
/*      */     }
/* 2402 */     JNI.callPV(target, query, data.length, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapfv(@NativeType("GLenum") int map, @NativeType("GLfloat *") float[] data) {
/* 2407 */     long __functionAddress = (GL.getICD()).glGetnPixelMapfv;
/* 2408 */     if (Checks.CHECKS) {
/* 2409 */       Checks.check(__functionAddress);
/*      */     }
/* 2411 */     JNI.callPV(map, data.length, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapuiv(@NativeType("GLenum") int map, @NativeType("GLuint *") int[] data) {
/* 2416 */     long __functionAddress = (GL.getICD()).glGetnPixelMapuiv;
/* 2417 */     if (Checks.CHECKS) {
/* 2418 */       Checks.check(__functionAddress);
/*      */     }
/* 2420 */     JNI.callPV(map, data.length, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapusv(@NativeType("GLenum") int map, @NativeType("GLushort *") short[] data) {
/* 2425 */     long __functionAddress = (GL.getICD()).glGetnPixelMapusv;
/* 2426 */     if (Checks.CHECKS) {
/* 2427 */       Checks.check(__functionAddress);
/*      */     }
/* 2429 */     JNI.callPV(map, data.length, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] img) {
/* 2434 */     GL45C.glGetnTexImage(tex, level, format, type, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] img) {
/* 2439 */     GL45C.glGetnTexImage(tex, level, format, type, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] img) {
/* 2444 */     GL45C.glGetnTexImage(tex, level, format, type, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] img) {
/* 2449 */     GL45C.glGetnTexImage(tex, level, format, type, img);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 2454 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 2459 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 2464 */     GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] table) {
/* 2469 */     long __functionAddress = (GL.getICD()).glGetnColorTable;
/* 2470 */     if (Checks.CHECKS) {
/* 2471 */       Checks.check(__functionAddress);
/*      */     }
/* 2473 */     JNI.callPV(target, format, type, table.length << 1, table, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] table) {
/* 2478 */     long __functionAddress = (GL.getICD()).glGetnColorTable;
/* 2479 */     if (Checks.CHECKS) {
/* 2480 */       Checks.check(__functionAddress);
/*      */     }
/* 2482 */     JNI.callPV(target, format, type, table.length << 2, table, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] table) {
/* 2487 */     long __functionAddress = (GL.getICD()).glGetnColorTable;
/* 2488 */     if (Checks.CHECKS) {
/* 2489 */       Checks.check(__functionAddress);
/*      */     }
/* 2491 */     JNI.callPV(target, format, type, table.length << 2, table, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") float[] params) {
/* 2496 */     GL45C.glGetnUniformfv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") double[] params) {
/* 2501 */     GL45C.glGetnUniformdv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") int[] params) {
/* 2506 */     GL45C.glGetnUniformiv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformuiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") int[] params) {
/* 2511 */     GL45C.glGetnUniformuiv(program, location, params);
/*      */   }
/*      */   
/*      */   public static native void nglGetnMapdv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnMapfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnMapiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnPixelMapfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetnPixelMapuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetnPixelMapusv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetnPolygonStipple(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetnColorTable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnConvolutionFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnSeparableFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nglGetnHistogram(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnMinmax(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL45.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */