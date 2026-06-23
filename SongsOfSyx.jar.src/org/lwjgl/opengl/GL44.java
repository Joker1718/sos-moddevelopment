/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL44 extends GL43 {
/*     */   public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 33509;
/*     */   public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 33313;
/*     */   public static final int GL_TEXTURE_BUFFER_BINDING = 35882;
/*     */   public static final int GL_MAP_PERSISTENT_BIT = 64;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_MAP_COHERENT_BIT = 128;
/*     */ 
/*     */   
/*     */   public static final int GL_DYNAMIC_STORAGE_BIT = 256;
/*     */   
/*     */   public static final int GL_CLIENT_STORAGE_BIT = 512;
/*     */   
/*     */   public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
/*     */   
/*     */   public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
/*     */   
/*     */   public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;
/*     */   
/*     */   public static final int GL_CLEAR_TEXTURE = 37733;
/*     */   
/*     */   public static final int GL_LOCATION_COMPONENT = 37706;
/*     */   
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX = 37707;
/*     */   
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE = 37708;
/*     */   
/*     */   public static final int GL_QUERY_RESULT_NO_WAIT = 37268;
/*     */   
/*     */   public static final int GL_QUERY_BUFFER = 37266;
/*     */   
/*     */   public static final int GL_QUERY_BUFFER_BINDING = 37267;
/*     */   
/*     */   public static final int GL_QUERY_BUFFER_BARRIER_BIT = 32768;
/*     */   
/*     */   public static final int GL_MIRROR_CLAMP_TO_EDGE = 34627;
/*     */ 
/*     */   
/*     */   protected GL44() {
/*  56 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBufferStorage(int target, long size, long data, int flags) {
/*  63 */     GL44C.nglBufferStorage(target, size, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("GLsizeiptr") long size, @NativeType("GLbitfield") int flags) {
/*  68 */     GL44C.glBufferStorage(target, size, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") ByteBuffer data, @NativeType("GLbitfield") int flags) {
/*  73 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") ShortBuffer data, @NativeType("GLbitfield") int flags) {
/*  78 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") IntBuffer data, @NativeType("GLbitfield") int flags) {
/*  83 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") FloatBuffer data, @NativeType("GLbitfield") int flags) {
/*  88 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") DoubleBuffer data, @NativeType("GLbitfield") int flags) {
/*  93 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long data) {
/* 100 */     GL44C.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/* 105 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/* 110 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/* 115 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/* 120 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer data) {
/* 125 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglClearTexImage(int texture, int level, int format, int type, long data) {
/* 132 */     GL44C.nglClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/* 137 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/* 142 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/* 147 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/* 152 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer data) {
/* 157 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindBuffersBase(int target, int first, int count, long buffers) {
/* 164 */     GL44C.nglBindBuffersBase(target, first, count, buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersBase(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers) {
/* 169 */     GL44C.glBindBuffersBase(target, first, buffers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindBuffersRange(int target, int first, int count, long buffers, long offsets, long sizes) {
/* 176 */     GL44C.nglBindBuffersRange(target, first, count, buffers, offsets, sizes);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersRange(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizeiptr const *") PointerBuffer sizes) {
/* 181 */     GL44C.glBindBuffersRange(target, first, buffers, offsets, sizes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindTextures(int first, int count, long textures) {
/* 188 */     GL44C.nglBindTextures(first, count, textures);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer textures) {
/* 193 */     GL44C.glBindTextures(first, textures);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindSamplers(int first, int count, long samplers) {
/* 200 */     GL44C.nglBindSamplers(first, count, samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindSamplers(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer samplers) {
/* 205 */     GL44C.glBindSamplers(first, samplers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindImageTextures(int first, int count, long textures) {
/* 212 */     GL44C.nglBindImageTextures(first, count, textures);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindImageTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer textures) {
/* 217 */     GL44C.glBindImageTextures(first, textures);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindVertexBuffers(int first, int count, long buffers, long offsets, long strides) {
/* 224 */     GL44C.nglBindVertexBuffers(first, count, buffers, offsets, strides);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindVertexBuffers(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") IntBuffer strides) {
/* 229 */     GL44C.glBindVertexBuffers(first, buffers, offsets, strides);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") short[] data, @NativeType("GLbitfield") int flags) {
/* 234 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") int[] data, @NativeType("GLbitfield") int flags) {
/* 239 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") float[] data, @NativeType("GLbitfield") int flags) {
/* 244 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") double[] data, @NativeType("GLbitfield") int flags) {
/* 249 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 254 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 259 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 264 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] data) {
/* 269 */     GL44C.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 274 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 279 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 284 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] data) {
/* 289 */     GL44C.glClearTexImage(texture, level, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersBase(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers) {
/* 294 */     GL44C.glBindBuffersBase(target, first, buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersRange(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizeiptr const *") PointerBuffer sizes) {
/* 299 */     GL44C.glBindBuffersRange(target, first, buffers, offsets, sizes);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] textures) {
/* 304 */     GL44C.glBindTextures(first, textures);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindSamplers(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] samplers) {
/* 309 */     GL44C.glBindSamplers(first, samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindImageTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] textures) {
/* 314 */     GL44C.glBindImageTextures(first, textures);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindVertexBuffers(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") int[] strides) {
/* 319 */     GL44C.glBindVertexBuffers(first, buffers, offsets, strides);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL44.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */