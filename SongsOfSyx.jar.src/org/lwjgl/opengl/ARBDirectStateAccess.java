/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class ARBDirectStateAccess
/*      */ {
/*      */   public static final int GL_TEXTURE_TARGET = 4102;
/*      */   public static final int GL_QUERY_TARGET = 33514;
/*      */   
/*      */   static {
/*   18 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ARBDirectStateAccess() {
/*   25 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateTransformFeedbacks(int n, long ids) {
/*   32 */     GL45C.nglCreateTransformFeedbacks(n, ids);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") IntBuffer ids) {
/*   37 */     GL45C.glCreateTransformFeedbacks(ids);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTransformFeedbacks() {
/*   43 */     return GL45C.glCreateTransformFeedbacks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTransformFeedbackBufferBase(@NativeType("GLuint") int xfb, @NativeType("GLuint") int index, @NativeType("GLuint") int buffer) {
/*   50 */     GL45C.glTransformFeedbackBufferBase(xfb, index, buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTransformFeedbackBufferRange(@NativeType("GLuint") int xfb, @NativeType("GLuint") int index, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size) {
/*   57 */     GL45C.glTransformFeedbackBufferRange(xfb, index, buffer, offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbackiv(int xfb, int pname, long param) {
/*   64 */     GL45C.nglGetTransformFeedbackiv(xfb, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/*   69 */     GL45C.glGetTransformFeedbackiv(xfb, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname) {
/*   75 */     return GL45C.glGetTransformFeedbacki(xfb, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbacki_v(int xfb, int pname, int index, long param) {
/*   82 */     GL45C.nglGetTransformFeedbacki_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer param) {
/*   87 */     GL45C.glGetTransformFeedbacki_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/*   93 */     return GL45C.glGetTransformFeedbacki(xfb, pname, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbacki64_v(int xfb, int pname, int index, long param) {
/*  100 */     GL45C.nglGetTransformFeedbacki64_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") LongBuffer param) {
/*  105 */     GL45C.glGetTransformFeedbacki64_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetTransformFeedbacki64(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/*  111 */     return GL45C.glGetTransformFeedbacki64(xfb, pname, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateBuffers(int n, long buffers) {
/*  118 */     GL45C.nglCreateBuffers(n, buffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") IntBuffer buffers) {
/*  123 */     GL45C.glCreateBuffers(buffers);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateBuffers() {
/*  129 */     return GL45C.glCreateBuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedBufferStorage(int buffer, long size, long data, int flags) {
/*  136 */     GL45C.nglNamedBufferStorage(buffer, size, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("GLsizeiptr") long size, @NativeType("GLbitfield") int flags) {
/*  141 */     GL45C.glNamedBufferStorage(buffer, size, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") ByteBuffer data, @NativeType("GLbitfield") int flags) {
/*  146 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") ShortBuffer data, @NativeType("GLbitfield") int flags) {
/*  151 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") IntBuffer data, @NativeType("GLbitfield") int flags) {
/*  156 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") FloatBuffer data, @NativeType("GLbitfield") int flags) {
/*  161 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") DoubleBuffer data, @NativeType("GLbitfield") int flags) {
/*  166 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedBufferData(int buffer, long size, long data, int usage) {
/*  173 */     GL45C.nglNamedBufferData(buffer, size, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int usage) {
/*  178 */     GL45C.glNamedBufferData(buffer, size, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") ByteBuffer data, @NativeType("GLenum") int usage) {
/*  183 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") ShortBuffer data, @NativeType("GLenum") int usage) {
/*  188 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") IntBuffer data, @NativeType("GLenum") int usage) {
/*  193 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") LongBuffer data, @NativeType("GLenum") int usage) {
/*  198 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") FloatBuffer data, @NativeType("GLenum") int usage) {
/*  203 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") DoubleBuffer data, @NativeType("GLenum") int usage) {
/*  208 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedBufferSubData(int buffer, long offset, long size, long data) {
/*  215 */     GL45C.nglNamedBufferSubData(buffer, offset, size, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ByteBuffer data) {
/*  220 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ShortBuffer data) {
/*  225 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") IntBuffer data) {
/*  230 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") LongBuffer data) {
/*  235 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") FloatBuffer data) {
/*  240 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") DoubleBuffer data) {
/*  245 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyNamedBufferSubData(@NativeType("GLuint") int readBuffer, @NativeType("GLuint") int writeBuffer, @NativeType("GLintptr") long readOffset, @NativeType("GLintptr") long writeOffset, @NativeType("GLsizeiptr") long size) {
/*  252 */     GL45C.glCopyNamedBufferSubData(readBuffer, writeBuffer, readOffset, writeOffset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedBufferData(int buffer, int internalformat, int format, int type, long data) {
/*  259 */     GL45C.nglClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  264 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  269 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  274 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  279 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, long data) {
/*  286 */     GL45C.nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  291 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  296 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  301 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  306 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapNamedBuffer(int buffer, int access) {
/*  313 */     return GL45C.nglMapNamedBuffer(buffer, access);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access) {
/*  319 */     return GL45C.glMapNamedBuffer(buffer, access);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access, ByteBuffer old_buffer) {
/*  325 */     return GL45C.glMapNamedBuffer(buffer, access, old_buffer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int access, long length, ByteBuffer old_buffer) {
/*  331 */     return GL45C.glMapNamedBuffer(buffer, access, length, old_buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapNamedBufferRange(int buffer, long offset, long length, int access) {
/*  338 */     return GL45C.nglMapNamedBufferRange(buffer, offset, length, access);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access) {
/*  344 */     return GL45C.glMapNamedBufferRange(buffer, offset, length, access);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access, ByteBuffer old_buffer) {
/*  350 */     return GL45C.glMapNamedBufferRange(buffer, offset, length, access, old_buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glUnmapNamedBuffer(@NativeType("GLuint") int buffer) {
/*  358 */     return GL45C.glUnmapNamedBuffer(buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFlushMappedNamedBufferRange(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length) {
/*  365 */     GL45C.glFlushMappedNamedBufferRange(buffer, offset, length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferParameteriv(int buffer, int pname, long params) {
/*  372 */     GL45C.nglGetNamedBufferParameteriv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  377 */     GL45C.glGetNamedBufferParameteriv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedBufferParameteri(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/*  383 */     return GL45C.glGetNamedBufferParameteri(buffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferParameteri64v(int buffer, int pname, long params) {
/*  390 */     GL45C.nglGetNamedBufferParameteri64v(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/*  395 */     GL45C.glGetNamedBufferParameteri64v(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferParameteri64(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/*  401 */     return GL45C.glGetNamedBufferParameteri64(buffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferPointerv(int buffer, int pname, long params) {
/*  408 */     GL45C.nglGetNamedBufferPointerv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferPointerv(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer params) {
/*  413 */     GL45C.glGetNamedBufferPointerv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferPointer(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname) {
/*  419 */     return GL45C.glGetNamedBufferPointer(buffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferSubData(int buffer, long offset, long size, long data) {
/*  426 */     GL45C.nglGetNamedBufferSubData(buffer, offset, size, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") ByteBuffer data) {
/*  431 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") ShortBuffer data) {
/*  436 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") IntBuffer data) {
/*  441 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") LongBuffer data) {
/*  446 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") FloatBuffer data) {
/*  451 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") DoubleBuffer data) {
/*  456 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateFramebuffers(int n, long framebuffers) {
/*  463 */     GL45C.nglCreateFramebuffers(n, framebuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") IntBuffer framebuffers) {
/*  468 */     GL45C.glCreateFramebuffers(framebuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateFramebuffers() {
/*  474 */     return GL45C.glCreateFramebuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferRenderbuffer(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int renderbuffertarget, @NativeType("GLuint") int renderbuffer) {
/*  481 */     GL45C.glNamedFramebufferRenderbuffer(framebuffer, attachment, renderbuffertarget, renderbuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferParameteri(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/*  488 */     GL45C.glNamedFramebufferParameteri(framebuffer, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferTexture(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLuint") int texture, @NativeType("GLint") int level) {
/*  495 */     GL45C.glNamedFramebufferTexture(framebuffer, attachment, texture, level);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferTextureLayer(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int layer) {
/*  502 */     GL45C.glNamedFramebufferTextureLayer(framebuffer, attachment, texture, level, layer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffer(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buf) {
/*  509 */     GL45C.glNamedFramebufferDrawBuffer(framebuffer, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedFramebufferDrawBuffers(int framebuffer, int n, long bufs) {
/*  516 */     GL45C.nglNamedFramebufferDrawBuffers(framebuffer, n, bufs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer bufs) {
/*  521 */     GL45C.glNamedFramebufferDrawBuffers(framebuffer, bufs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int buf) {
/*  526 */     GL45C.glNamedFramebufferDrawBuffers(framebuffer, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferReadBuffer(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int src) {
/*  533 */     GL45C.glNamedFramebufferReadBuffer(framebuffer, src);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglInvalidateNamedFramebufferData(int framebuffer, int numAttachments, long attachments) {
/*  540 */     GL45C.nglInvalidateNamedFramebufferData(framebuffer, numAttachments, attachments);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer attachments) {
/*  545 */     GL45C.glInvalidateNamedFramebufferData(framebuffer, attachments);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int attachment) {
/*  550 */     GL45C.glInvalidateNamedFramebufferData(framebuffer, attachment);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, long attachments, int x, int y, int width, int height) {
/*  557 */     GL45C.nglInvalidateNamedFramebufferSubData(framebuffer, numAttachments, attachments, x, y, width, height);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") IntBuffer attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  562 */     GL45C.glInvalidateNamedFramebufferSubData(framebuffer, attachments, x, y, width, height);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int attachment, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  567 */     GL45C.glInvalidateNamedFramebufferSubData(framebuffer, attachment, x, y, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, long value) {
/*  574 */     GL45C.nglClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") IntBuffer value) {
/*  579 */     GL45C.glClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, long value) {
/*  586 */     GL45C.nglClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") IntBuffer value) {
/*  591 */     GL45C.glClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, long value) {
/*  598 */     GL45C.nglClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat const *") FloatBuffer value) {
/*  603 */     GL45C.glClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfi(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat") float depth, @NativeType("GLint") int stencil) {
/*  610 */     GL45C.glClearNamedFramebufferfi(framebuffer, buffer, drawbuffer, depth, stencil);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBlitNamedFramebuffer(@NativeType("GLuint") int readFramebuffer, @NativeType("GLuint") int drawFramebuffer, @NativeType("GLint") int srcX0, @NativeType("GLint") int srcY0, @NativeType("GLint") int srcX1, @NativeType("GLint") int srcY1, @NativeType("GLint") int dstX0, @NativeType("GLint") int dstY0, @NativeType("GLint") int dstX1, @NativeType("GLint") int dstY1, @NativeType("GLbitfield") int mask, @NativeType("GLenum") int filter) {
/*  617 */     GL45C.glBlitNamedFramebuffer(readFramebuffer, drawFramebuffer, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glCheckNamedFramebufferStatus(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int target) {
/*  625 */     return GL45C.glCheckNamedFramebufferStatus(framebuffer, target);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedFramebufferParameteriv(int framebuffer, int pname, long params) {
/*  632 */     GL45C.nglGetNamedFramebufferParameteriv(framebuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  637 */     GL45C.glGetNamedFramebufferParameteriv(framebuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferParameteri(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname) {
/*  643 */     return GL45C.glGetNamedFramebufferParameteri(framebuffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, long params) {
/*  650 */     GL45C.nglGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  655 */     GL45C.glGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferAttachmentParameteri(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname) {
/*  661 */     return GL45C.glGetNamedFramebufferAttachmentParameteri(framebuffer, attachment, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateRenderbuffers(int n, long renderbuffers) {
/*  668 */     GL45C.nglCreateRenderbuffers(n, renderbuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") IntBuffer renderbuffers) {
/*  673 */     GL45C.glCreateRenderbuffers(renderbuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateRenderbuffers() {
/*  679 */     return GL45C.glCreateRenderbuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedRenderbufferStorage(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  686 */     GL45C.glNamedRenderbufferStorage(renderbuffer, internalformat, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedRenderbufferStorageMultisample(@NativeType("GLuint") int renderbuffer, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  693 */     GL45C.glNamedRenderbufferStorageMultisample(renderbuffer, samples, internalformat, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedRenderbufferParameteriv(int renderbuffer, int pname, long params) {
/*  700 */     GL45C.nglGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  705 */     GL45C.glGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedRenderbufferParameteri(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname) {
/*  711 */     return GL45C.glGetNamedRenderbufferParameteri(renderbuffer, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateTextures(int target, int n, long textures) {
/*  718 */     GL45C.nglCreateTextures(target, n, textures);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int target, @NativeType("GLuint *") IntBuffer textures) {
/*  723 */     GL45C.glCreateTextures(target, textures);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTextures(@NativeType("GLenum") int target) {
/*  729 */     return GL45C.glCreateTextures(target);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureBuffer(@NativeType("GLuint") int texture, @NativeType("GLenum") int internalformat, @NativeType("GLuint") int buffer) {
/*  736 */     GL45C.glTextureBuffer(texture, internalformat, buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureBufferRange(@NativeType("GLuint") int texture, @NativeType("GLenum") int internalformat, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size) {
/*  743 */     GL45C.glTextureBufferRange(texture, internalformat, buffer, offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage1D(@NativeType("GLuint") int texture, @NativeType("GLsizei") int levels, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width) {
/*  750 */     GL45C.glTextureStorage1D(texture, levels, internalformat, width);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage2D(@NativeType("GLuint") int texture, @NativeType("GLsizei") int levels, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  757 */     GL45C.glTextureStorage2D(texture, levels, internalformat, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage3D(@NativeType("GLuint") int texture, @NativeType("GLsizei") int levels, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth) {
/*  764 */     GL45C.glTextureStorage3D(texture, levels, internalformat, width, height, depth);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage2DMultisample(@NativeType("GLuint") int texture, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLboolean") boolean fixedsamplelocations) {
/*  771 */     GL45C.glTextureStorage2DMultisample(texture, samples, internalformat, width, height, fixedsamplelocations);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage3DMultisample(@NativeType("GLuint") int texture, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLboolean") boolean fixedsamplelocations) {
/*  778 */     GL45C.glTextureStorage3DMultisample(texture, samples, internalformat, width, height, depth, fixedsamplelocations);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, long pixels) {
/*  785 */     GL45C.nglTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  790 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  795 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  800 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  805 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  810 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  815 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels) {
/*  822 */     GL45C.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  827 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  832 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  837 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  842 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  847 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  852 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long pixels) {
/*  859 */     GL45C.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  864 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  869 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  874 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  879 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  884 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  889 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, long data) {
/*  896 */     GL45C.nglCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  901 */     GL45C.glCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/*  906 */     GL45C.glCompressedTextureSubImage1D(texture, level, xoffset, width, format, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data) {
/*  913 */     GL45C.nglCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  918 */     GL45C.glCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/*  923 */     GL45C.glCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data) {
/*  930 */     GL45C.nglCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLsizei") int imageSize, @NativeType("void const *") long data) {
/*  935 */     GL45C.glCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer data) {
/*  940 */     GL45C.glCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width) {
/*  947 */     GL45C.glCopyTextureSubImage1D(texture, level, xoffset, x, y, width);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  954 */     GL45C.glCopyTextureSubImage2D(texture, level, xoffset, yoffset, x, y, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  961 */     GL45C.glCopyTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, x, y, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterf(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat") float param) {
/*  968 */     GL45C.glTextureParameterf(texture, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterfv(int texture, int pname, long params) {
/*  975 */     GL45C.nglTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/*  980 */     GL45C.glTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameteri(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/*  987 */     GL45C.glTextureParameteri(texture, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterIiv(int texture, int pname, long params) {
/*  994 */     GL45C.nglTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/*  999 */     GL45C.glTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIi(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") int param) {
/* 1004 */     GL45C.glTextureParameterIi(texture, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterIuiv(int texture, int pname, long params) {
/* 1011 */     GL45C.nglTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint const *") IntBuffer params) {
/* 1016 */     GL45C.glTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIui(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int param) {
/* 1021 */     GL45C.glTextureParameterIui(texture, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameteriv(int texture, int pname, long params) {
/* 1028 */     GL45C.nglTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 1033 */     GL45C.glTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenerateTextureMipmap(@NativeType("GLuint") int texture) {
/* 1040 */     GL45C.glGenerateTextureMipmap(texture);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindTextureUnit(@NativeType("GLuint") int unit, @NativeType("GLuint") int texture) {
/* 1047 */     GL45C.glBindTextureUnit(unit, texture);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureImage(int texture, int level, int format, int type, int bufSize, long pixels) {
/* 1054 */     GL45C.nglGetTextureImage(texture, level, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1059 */     GL45C.glGetTextureImage(texture, level, format, type, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 1064 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 1069 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 1074 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 1079 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/* 1084 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetCompressedTextureImage(int texture, int level, int bufSize, long pixels) {
/* 1091 */     GL45C.nglGetCompressedTextureImage(texture, level, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLsizei") int bufSize, @NativeType("void *") long pixels) {
/* 1096 */     GL45C.glGetCompressedTextureImage(texture, level, bufSize, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("void *") ByteBuffer pixels) {
/* 1101 */     GL45C.glGetCompressedTextureImage(texture, level, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureLevelParameterfv(int texture, int level, int pname, long params) {
/* 1108 */     GL45C.nglGetTextureLevelParameterfv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1113 */     GL45C.glGetTextureLevelParameterfv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureLevelParameterf(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 1119 */     return GL45C.glGetTextureLevelParameterf(texture, level, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureLevelParameteriv(int texture, int level, int pname, long params) {
/* 1126 */     GL45C.nglGetTextureLevelParameteriv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1131 */     GL45C.glGetTextureLevelParameteriv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureLevelParameteri(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 1137 */     return GL45C.glGetTextureLevelParameteri(texture, level, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterfv(int texture, int pname, long params) {
/* 1144 */     GL45C.nglGetTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1149 */     GL45C.glGetTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureParameterf(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1155 */     return GL45C.glGetTextureParameterf(texture, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterIiv(int texture, int pname, long params) {
/* 1162 */     GL45C.nglGetTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1167 */     GL45C.glGetTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIi(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1173 */     return GL45C.glGetTextureParameterIi(texture, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterIuiv(int texture, int pname, long params) {
/* 1180 */     GL45C.nglGetTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 1185 */     GL45C.glGetTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIui(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1191 */     return GL45C.glGetTextureParameterIui(texture, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameteriv(int texture, int pname, long params) {
/* 1198 */     GL45C.nglGetTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1203 */     GL45C.glGetTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameteri(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname) {
/* 1209 */     return GL45C.glGetTextureParameteri(texture, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateVertexArrays(int n, long arrays) {
/* 1216 */     GL45C.nglCreateVertexArrays(n, arrays);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") IntBuffer arrays) {
/* 1221 */     GL45C.glCreateVertexArrays(arrays);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateVertexArrays() {
/* 1227 */     return GL45C.glCreateVertexArrays();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisableVertexArrayAttrib(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index) {
/* 1234 */     GL45C.glDisableVertexArrayAttrib(vaobj, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnableVertexArrayAttrib(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index) {
/* 1241 */     GL45C.glEnableVertexArrayAttrib(vaobj, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayElementBuffer(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int buffer) {
/* 1248 */     GL45C.glVertexArrayElementBuffer(vaobj, buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffer(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int bindingindex, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizei") int stride) {
/* 1255 */     GL45C.glVertexArrayVertexBuffer(vaobj, bindingindex, buffer, offset, stride);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexArrayVertexBuffers(int vaobj, int first, int count, long buffers, long offsets, long strides) {
/* 1262 */     GL45C.nglVertexArrayVertexBuffers(vaobj, first, count, buffers, offsets, strides);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") IntBuffer strides) {
/* 1267 */     GL45C.glVertexArrayVertexBuffers(vaobj, first, buffers, offsets, strides);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribFormat(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int relativeoffset) {
/* 1274 */     GL45C.glVertexArrayAttribFormat(vaobj, attribindex, size, type, normalized, relativeoffset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribIFormat(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLuint") int relativeoffset) {
/* 1281 */     GL45C.glVertexArrayAttribIFormat(vaobj, attribindex, size, type, relativeoffset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribLFormat(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLuint") int relativeoffset) {
/* 1288 */     GL45C.glVertexArrayAttribLFormat(vaobj, attribindex, size, type, relativeoffset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribBinding(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int attribindex, @NativeType("GLuint") int bindingindex) {
/* 1295 */     GL45C.glVertexArrayAttribBinding(vaobj, attribindex, bindingindex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayBindingDivisor(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int bindingindex, @NativeType("GLuint") int divisor) {
/* 1302 */     GL45C.glVertexArrayBindingDivisor(vaobj, bindingindex, divisor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayiv(int vaobj, int pname, long param) {
/* 1309 */     GL45C.nglGetVertexArrayiv(vaobj, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/* 1314 */     GL45C.glGetVertexArrayiv(vaobj, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayi(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname) {
/* 1320 */     return GL45C.glGetVertexArrayi(vaobj, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayIndexediv(int vaobj, int index, int pname, long param) {
/* 1327 */     GL45C.nglGetVertexArrayIndexediv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer param) {
/* 1332 */     GL45C.glGetVertexArrayIndexediv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayIndexedi(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1338 */     return GL45C.glGetVertexArrayIndexedi(vaobj, index, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayIndexed64iv(int vaobj, int index, int pname, long param) {
/* 1345 */     GL45C.nglGetVertexArrayIndexed64iv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer param) {
/* 1350 */     GL45C.glGetVertexArrayIndexed64iv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexArrayIndexed64i(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1356 */     return GL45C.glGetVertexArrayIndexed64i(vaobj, index, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateSamplers(int n, long samplers) {
/* 1363 */     GL45C.nglCreateSamplers(n, samplers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") IntBuffer samplers) {
/* 1368 */     GL45C.glCreateSamplers(samplers);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateSamplers() {
/* 1374 */     return GL45C.glCreateSamplers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateProgramPipelines(int n, long pipelines) {
/* 1381 */     GL45C.nglCreateProgramPipelines(n, pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") IntBuffer pipelines) {
/* 1386 */     GL45C.glCreateProgramPipelines(pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateProgramPipelines() {
/* 1392 */     return GL45C.glCreateProgramPipelines();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateQueries(int target, int n, long ids) {
/* 1399 */     GL45C.nglCreateQueries(target, n, ids);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int target, @NativeType("GLuint *") IntBuffer ids) {
/* 1404 */     GL45C.glCreateQueries(target, ids);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateQueries(@NativeType("GLenum") int target) {
/* 1410 */     return GL45C.glCreateQueries(target);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjecti64v(@NativeType("GLuint") int id, @NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLintptr") long offset) {
/* 1417 */     GL45C.glGetQueryBufferObjecti64v(id, buffer, pname, offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjectiv(@NativeType("GLuint") int id, @NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLintptr") long offset) {
/* 1424 */     GL45C.glGetQueryBufferObjectiv(id, buffer, pname, offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjectui64v(@NativeType("GLuint") int id, @NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLintptr") long offset) {
/* 1431 */     GL45C.glGetQueryBufferObjectui64v(id, buffer, pname, offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjectuiv(@NativeType("GLuint") int id, @NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLintptr") long offset) {
/* 1438 */     GL45C.glGetQueryBufferObjectuiv(id, buffer, pname, offset);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") int[] ids) {
/* 1443 */     GL45C.glCreateTransformFeedbacks(ids);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 1448 */     GL45C.glGetTransformFeedbackiv(xfb, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint *") int[] param) {
/* 1453 */     GL45C.glGetTransformFeedbacki_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int xfb, @NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") long[] param) {
/* 1458 */     GL45C.glGetTransformFeedbacki64_v(xfb, pname, index, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") int[] buffers) {
/* 1463 */     GL45C.glCreateBuffers(buffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") short[] data, @NativeType("GLbitfield") int flags) {
/* 1468 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") int[] data, @NativeType("GLbitfield") int flags) {
/* 1473 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") float[] data, @NativeType("GLbitfield") int flags) {
/* 1478 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int buffer, @NativeType("void const *") double[] data, @NativeType("GLbitfield") int flags) {
/* 1483 */     GL45C.glNamedBufferStorage(buffer, data, flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") short[] data, @NativeType("GLenum") int usage) {
/* 1488 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") int[] data, @NativeType("GLenum") int usage) {
/* 1493 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") long[] data, @NativeType("GLenum") int usage) {
/* 1498 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") float[] data, @NativeType("GLenum") int usage) {
/* 1503 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("void const *") double[] data, @NativeType("GLenum") int usage) {
/* 1508 */     GL45C.glNamedBufferData(buffer, data, usage);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") short[] data) {
/* 1513 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") int[] data) {
/* 1518 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") long[] data) {
/* 1523 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") float[] data) {
/* 1528 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") double[] data) {
/* 1533 */     GL45C.glNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 1538 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 1543 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 1548 */     GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 1553 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 1558 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 1563 */     GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1568 */     GL45C.glGetNamedBufferParameteriv(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int buffer, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 1573 */     GL45C.glGetNamedBufferParameteri64v(buffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") short[] data) {
/* 1578 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") int[] data) {
/* 1583 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") long[] data) {
/* 1588 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") float[] data) {
/* 1593 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void *") double[] data) {
/* 1598 */     GL45C.glGetNamedBufferSubData(buffer, offset, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") int[] framebuffers) {
/* 1603 */     GL45C.glCreateFramebuffers(framebuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] bufs) {
/* 1608 */     GL45C.glNamedFramebufferDrawBuffers(framebuffer, bufs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] attachments) {
/* 1613 */     GL45C.glInvalidateNamedFramebufferData(framebuffer, attachments);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int framebuffer, @NativeType("GLenum const *") int[] attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 1618 */     GL45C.glInvalidateNamedFramebufferSubData(framebuffer, attachments, x, y, width, height);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") int[] value) {
/* 1623 */     GL45C.glClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") int[] value) {
/* 1628 */     GL45C.glClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat const *") float[] value) {
/* 1633 */     GL45C.glClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1638 */     GL45C.glGetNamedFramebufferParameteriv(framebuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1643 */     GL45C.glGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") int[] renderbuffers) {
/* 1648 */     GL45C.glCreateRenderbuffers(renderbuffers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int renderbuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1653 */     GL45C.glGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int target, @NativeType("GLuint *") int[] textures) {
/* 1658 */     GL45C.glCreateTextures(target, textures);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 1663 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 1668 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 1673 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 1678 */     GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 1683 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 1688 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 1693 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 1698 */     GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 1703 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 1708 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 1713 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 1718 */     GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 1723 */     GL45C.glTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 1728 */     GL45C.glTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int[] params) {
/* 1733 */     GL45C.glTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 1738 */     GL45C.glTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 1743 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 1748 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 1753 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 1758 */     GL45C.glGetTextureImage(texture, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 1763 */     GL45C.glGetTextureLevelParameterfv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1768 */     GL45C.glGetTextureLevelParameteriv(texture, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 1773 */     GL45C.glGetTextureParameterfv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1778 */     GL45C.glGetTextureParameterIiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 1783 */     GL45C.glGetTextureParameterIuiv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int texture, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1788 */     GL45C.glGetTextureParameteriv(texture, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") int[] arrays) {
/* 1793 */     GL45C.glCreateVertexArrays(arrays);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") int[] strides) {
/* 1798 */     GL45C.glVertexArrayVertexBuffers(vaobj, first, buffers, offsets, strides);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int vaobj, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 1803 */     GL45C.glGetVertexArrayiv(vaobj, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] param) {
/* 1808 */     GL45C.glGetVertexArrayIndexediv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] param) {
/* 1813 */     GL45C.glGetVertexArrayIndexed64iv(vaobj, index, pname, param);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") int[] samplers) {
/* 1818 */     GL45C.glCreateSamplers(samplers);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") int[] pipelines) {
/* 1823 */     GL45C.glCreateProgramPipelines(pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int target, @NativeType("GLuint *") int[] ids) {
/* 1828 */     GL45C.glCreateQueries(target, ids);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBDirectStateAccess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */