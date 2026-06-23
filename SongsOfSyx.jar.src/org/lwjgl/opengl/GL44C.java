/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ public class GL44C
/*     */   extends GL43C {
/*     */   public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 33509;
/*     */   public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 33313;
/*     */   
/*     */   static {
/*  22 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BUFFER_BINDING = 35882;
/*     */   
/*     */   public static final int GL_MAP_PERSISTENT_BIT = 64;
/*     */   
/*     */   public static final int GL_MAP_COHERENT_BIT = 128;
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
/*     */   public static final int GL_MIRROR_CLAMP_TO_EDGE = 34627;
/*     */   
/*     */   protected GL44C() {
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("GLsizeiptr") long size, @NativeType("GLbitfield") int flags) {
/*  70 */     nglBufferStorage(target, size, 0L, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") ByteBuffer data, @NativeType("GLbitfield") int flags) {
/*  75 */     nglBufferStorage(target, data.remaining(), MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") ShortBuffer data, @NativeType("GLbitfield") int flags) {
/*  80 */     nglBufferStorage(target, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") IntBuffer data, @NativeType("GLbitfield") int flags) {
/*  85 */     nglBufferStorage(target, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") FloatBuffer data, @NativeType("GLbitfield") int flags) {
/*  90 */     nglBufferStorage(target, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") DoubleBuffer data, @NativeType("GLbitfield") int flags) {
/*  95 */     nglBufferStorage(target, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/* 105 */     nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/* 110 */     nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/* 115 */     nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/* 120 */     nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer data) {
/* 125 */     nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/* 135 */     nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/* 140 */     nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/* 145 */     nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/* 150 */     nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer data) {
/* 155 */     nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindBuffersBase(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers) {
/* 165 */     nglBindBuffersBase(target, first, Checks.remainingSafe(buffers), MemoryUtil.memAddressSafe(buffers));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindBuffersRange(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizeiptr const *") PointerBuffer sizes) {
/* 175 */     if (Checks.CHECKS) {
/* 176 */       Checks.checkSafe((CustomBuffer)offsets, Checks.remainingSafe(buffers));
/* 177 */       Checks.checkSafe((CustomBuffer)sizes, Checks.remainingSafe(buffers));
/*     */     } 
/* 179 */     nglBindBuffersRange(target, first, Checks.remainingSafe(buffers), MemoryUtil.memAddressSafe(buffers), MemoryUtil.memAddressSafe((Pointer)offsets), MemoryUtil.memAddressSafe((Pointer)sizes));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer textures) {
/* 189 */     nglBindTextures(first, Checks.remainingSafe(textures), MemoryUtil.memAddressSafe(textures));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindSamplers(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer samplers) {
/* 199 */     nglBindSamplers(first, Checks.remainingSafe(samplers), MemoryUtil.memAddressSafe(samplers));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindImageTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer textures) {
/* 209 */     nglBindImageTextures(first, Checks.remainingSafe(textures), MemoryUtil.memAddressSafe(textures));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindVertexBuffers(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") IntBuffer strides) {
/* 219 */     if (Checks.CHECKS) {
/* 220 */       Checks.checkSafe((CustomBuffer)offsets, Checks.remainingSafe(buffers));
/* 221 */       Checks.checkSafe(strides, Checks.remainingSafe(buffers));
/*     */     } 
/* 223 */     nglBindVertexBuffers(first, Checks.remainingSafe(buffers), MemoryUtil.memAddressSafe(buffers), MemoryUtil.memAddressSafe((Pointer)offsets), MemoryUtil.memAddressSafe(strides));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") short[] data, @NativeType("GLbitfield") int flags) {
/* 228 */     long __functionAddress = (GL.getICD()).glBufferStorage;
/* 229 */     if (Checks.CHECKS) {
/* 230 */       Checks.check(__functionAddress);
/*     */     }
/* 232 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 1L, data, flags, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") int[] data, @NativeType("GLbitfield") int flags) {
/* 237 */     long __functionAddress = (GL.getICD()).glBufferStorage;
/* 238 */     if (Checks.CHECKS) {
/* 239 */       Checks.check(__functionAddress);
/*     */     }
/* 241 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2L, data, flags, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") float[] data, @NativeType("GLbitfield") int flags) {
/* 246 */     long __functionAddress = (GL.getICD()).glBufferStorage;
/* 247 */     if (Checks.CHECKS) {
/* 248 */       Checks.check(__functionAddress);
/*     */     }
/* 250 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2L, data, flags, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") double[] data, @NativeType("GLbitfield") int flags) {
/* 255 */     long __functionAddress = (GL.getICD()).glBufferStorage;
/* 256 */     if (Checks.CHECKS) {
/* 257 */       Checks.check(__functionAddress);
/*     */     }
/* 259 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 3L, data, flags, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 264 */     long __functionAddress = (GL.getICD()).glClearTexSubImage;
/* 265 */     if (Checks.CHECKS) {
/* 266 */       Checks.check(__functionAddress);
/*     */     }
/* 268 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 273 */     long __functionAddress = (GL.getICD()).glClearTexSubImage;
/* 274 */     if (Checks.CHECKS) {
/* 275 */       Checks.check(__functionAddress);
/*     */     }
/* 277 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 282 */     long __functionAddress = (GL.getICD()).glClearTexSubImage;
/* 283 */     if (Checks.CHECKS) {
/* 284 */       Checks.check(__functionAddress);
/*     */     }
/* 286 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] data) {
/* 291 */     long __functionAddress = (GL.getICD()).glClearTexSubImage;
/* 292 */     if (Checks.CHECKS) {
/* 293 */       Checks.check(__functionAddress);
/*     */     }
/* 295 */     JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 300 */     long __functionAddress = (GL.getICD()).glClearTexImage;
/* 301 */     if (Checks.CHECKS) {
/* 302 */       Checks.check(__functionAddress);
/*     */     }
/* 304 */     JNI.callPV(texture, level, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 309 */     long __functionAddress = (GL.getICD()).glClearTexImage;
/* 310 */     if (Checks.CHECKS) {
/* 311 */       Checks.check(__functionAddress);
/*     */     }
/* 313 */     JNI.callPV(texture, level, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 318 */     long __functionAddress = (GL.getICD()).glClearTexImage;
/* 319 */     if (Checks.CHECKS) {
/* 320 */       Checks.check(__functionAddress);
/*     */     }
/* 322 */     JNI.callPV(texture, level, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] data) {
/* 327 */     long __functionAddress = (GL.getICD()).glClearTexImage;
/* 328 */     if (Checks.CHECKS) {
/* 329 */       Checks.check(__functionAddress);
/*     */     }
/* 331 */     JNI.callPV(texture, level, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersBase(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers) {
/* 336 */     long __functionAddress = (GL.getICD()).glBindBuffersBase;
/* 337 */     if (Checks.CHECKS) {
/* 338 */       Checks.check(__functionAddress);
/*     */     }
/* 340 */     JNI.callPV(target, first, Checks.lengthSafe(buffers), buffers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersRange(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizeiptr const *") PointerBuffer sizes) {
/* 345 */     long __functionAddress = (GL.getICD()).glBindBuffersRange;
/* 346 */     if (Checks.CHECKS) {
/* 347 */       Checks.check(__functionAddress);
/* 348 */       Checks.checkSafe((CustomBuffer)offsets, Checks.lengthSafe(buffers));
/* 349 */       Checks.checkSafe((CustomBuffer)sizes, Checks.lengthSafe(buffers));
/*     */     } 
/* 351 */     JNI.callPPPV(target, first, Checks.lengthSafe(buffers), buffers, MemoryUtil.memAddressSafe((Pointer)offsets), MemoryUtil.memAddressSafe((Pointer)sizes), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] textures) {
/* 356 */     long __functionAddress = (GL.getICD()).glBindTextures;
/* 357 */     if (Checks.CHECKS) {
/* 358 */       Checks.check(__functionAddress);
/*     */     }
/* 360 */     JNI.callPV(first, Checks.lengthSafe(textures), textures, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindSamplers(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] samplers) {
/* 365 */     long __functionAddress = (GL.getICD()).glBindSamplers;
/* 366 */     if (Checks.CHECKS) {
/* 367 */       Checks.check(__functionAddress);
/*     */     }
/* 369 */     JNI.callPV(first, Checks.lengthSafe(samplers), samplers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindImageTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] textures) {
/* 374 */     long __functionAddress = (GL.getICD()).glBindImageTextures;
/* 375 */     if (Checks.CHECKS) {
/* 376 */       Checks.check(__functionAddress);
/*     */     }
/* 378 */     JNI.callPV(first, Checks.lengthSafe(textures), textures, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindVertexBuffers(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") int[] strides) {
/* 383 */     long __functionAddress = (GL.getICD()).glBindVertexBuffers;
/* 384 */     if (Checks.CHECKS) {
/* 385 */       Checks.check(__functionAddress);
/* 386 */       Checks.checkSafe((CustomBuffer)offsets, Checks.lengthSafe(buffers));
/* 387 */       Checks.checkSafe(strides, Checks.lengthSafe(buffers));
/*     */     } 
/* 389 */     JNI.callPPPV(first, Checks.lengthSafe(buffers), buffers, MemoryUtil.memAddressSafe((Pointer)offsets), strides, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglBufferStorage(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native void nglClearTexSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*     */   
/*     */   public static native void nglClearTexImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglBindBuffersBase(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglBindBuffersRange(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nglBindTextures(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglBindSamplers(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglBindImageTextures(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglBindVertexBuffers(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL44C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */