/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class NVGPUMulticast {
/*     */   public static final int GL_PER_GPU_STORAGE_BIT_NV = 2048;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_MULTICAST_GPUS_NV = 37562;
/*     */   
/*     */   public static final int GL_RENDER_GPU_MASK_NV = 38232;
/*     */   
/*     */   public static final int GL_PER_GPU_STORAGE_NV = 38216;
/*     */   
/*     */   public static final int GL_MULTICAST_PROGRAMMABLE_SAMPLE_LOCATION_NV = 38217;
/*     */   
/*     */   protected NVGPUMulticast() {
/*  32 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int gpuMask, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ByteBuffer data) {
/*  47 */     nglMulticastBufferSubDataNV(gpuMask, buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int gpuMask, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") ShortBuffer data) {
/*  52 */     nglMulticastBufferSubDataNV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int gpuMask, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") IntBuffer data) {
/*  57 */     nglMulticastBufferSubDataNV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int gpuMask, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") FloatBuffer data) {
/*  62 */     nglMulticastBufferSubDataNV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int gpuMask, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") DoubleBuffer data) {
/*  67 */     nglMulticastBufferSubDataNV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastFramebufferSampleLocationsfvNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int framebuffer, @NativeType("GLuint") int start, @NativeType("GLfloat const *") FloatBuffer v) {
/*  92 */     nglMulticastFramebufferSampleLocationsfvNV(gpu, framebuffer, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
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
/*     */   public static void glMulticastGetQueryObjectivNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check(params, 1);
/*     */     }
/* 115 */     nglMulticastGetQueryObjectivNV(gpu, id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glMulticastGetQueryObjectiNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 121 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 123 */       IntBuffer params = stack.callocInt(1);
/* 124 */       nglMulticastGetQueryObjectivNV(gpu, id, pname, MemoryUtil.memAddress(params));
/* 125 */       return params.get(0);
/*     */     } finally {
/* 127 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectuivNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 138 */     if (Checks.CHECKS) {
/* 139 */       Checks.check(params, 1);
/*     */     }
/* 141 */     nglMulticastGetQueryObjectuivNV(gpu, id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glMulticastGetQueryObjectuiNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 147 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 149 */       IntBuffer params = stack.callocInt(1);
/* 150 */       nglMulticastGetQueryObjectuivNV(gpu, id, pname, MemoryUtil.memAddress(params));
/* 151 */       return params.get(0);
/*     */     } finally {
/* 153 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjecti64vNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(params, 1);
/*     */     }
/* 167 */     nglMulticastGetQueryObjecti64vNV(gpu, id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glMulticastGetQueryObjecti64NV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 173 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 175 */       LongBuffer params = stack.callocLong(1);
/* 176 */       nglMulticastGetQueryObjecti64vNV(gpu, id, pname, MemoryUtil.memAddress(params));
/* 177 */       return params.get(0);
/*     */     } finally {
/* 179 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectui64vNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") LongBuffer params) {
/* 190 */     if (Checks.CHECKS) {
/* 191 */       Checks.check(params, 1);
/*     */     }
/* 193 */     nglMulticastGetQueryObjectui64vNV(gpu, id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glMulticastGetQueryObjectui64NV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 199 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 201 */       LongBuffer params = stack.callocLong(1);
/* 202 */       nglMulticastGetQueryObjectui64vNV(gpu, id, pname, MemoryUtil.memAddress(params));
/* 203 */       return params.get(0);
/*     */     } finally {
/* 205 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int gpuMask, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") short[] data) {
/* 211 */     long __functionAddress = (GL.getICD()).glMulticastBufferSubDataNV;
/* 212 */     if (Checks.CHECKS) {
/* 213 */       Checks.check(__functionAddress);
/*     */     }
/* 215 */     JNI.callPPPV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.length) << 1L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int gpuMask, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") int[] data) {
/* 220 */     long __functionAddress = (GL.getICD()).glMulticastBufferSubDataNV;
/* 221 */     if (Checks.CHECKS) {
/* 222 */       Checks.check(__functionAddress);
/*     */     }
/* 224 */     JNI.callPPPV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int gpuMask, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") float[] data) {
/* 229 */     long __functionAddress = (GL.getICD()).glMulticastBufferSubDataNV;
/* 230 */     if (Checks.CHECKS) {
/* 231 */       Checks.check(__functionAddress);
/*     */     }
/* 233 */     JNI.callPPPV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int gpuMask, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("void const *") double[] data) {
/* 238 */     long __functionAddress = (GL.getICD()).glMulticastBufferSubDataNV;
/* 239 */     if (Checks.CHECKS) {
/* 240 */       Checks.check(__functionAddress);
/*     */     }
/* 242 */     JNI.callPPPV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastFramebufferSampleLocationsfvNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int framebuffer, @NativeType("GLuint") int start, @NativeType("GLfloat const *") float[] v) {
/* 247 */     long __functionAddress = (GL.getICD()).glMulticastFramebufferSampleLocationsfvNV;
/* 248 */     if (Checks.CHECKS) {
/* 249 */       Checks.check(__functionAddress);
/*     */     }
/* 251 */     JNI.callPV(gpu, framebuffer, start, v.length >> 1, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectivNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 256 */     long __functionAddress = (GL.getICD()).glMulticastGetQueryObjectivNV;
/* 257 */     if (Checks.CHECKS) {
/* 258 */       Checks.check(__functionAddress);
/* 259 */       Checks.check(params, 1);
/*     */     } 
/* 261 */     JNI.callPV(gpu, id, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectuivNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 266 */     long __functionAddress = (GL.getICD()).glMulticastGetQueryObjectuivNV;
/* 267 */     if (Checks.CHECKS) {
/* 268 */       Checks.check(__functionAddress);
/* 269 */       Checks.check(params, 1);
/*     */     } 
/* 271 */     JNI.callPV(gpu, id, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjecti64vNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 276 */     long __functionAddress = (GL.getICD()).glMulticastGetQueryObjecti64vNV;
/* 277 */     if (Checks.CHECKS) {
/* 278 */       Checks.check(__functionAddress);
/* 279 */       Checks.check(params, 1);
/*     */     } 
/* 281 */     JNI.callPV(gpu, id, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectui64vNV(@NativeType("GLuint") int gpu, @NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long[] params) {
/* 286 */     long __functionAddress = (GL.getICD()).glMulticastGetQueryObjectui64vNV;
/* 287 */     if (Checks.CHECKS) {
/* 288 */       Checks.check(__functionAddress);
/* 289 */       Checks.check(params, 1);
/*     */     } 
/* 291 */     JNI.callPV(gpu, id, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glRenderGpuMaskNV(@NativeType("GLbitfield") int paramInt);
/*     */   
/*     */   public static native void nglMulticastBufferSubDataNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void glMulticastCopyBufferSubDataNV(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3);
/*     */   
/*     */   public static native void glMulticastCopyImageSubDataNV(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLuint") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLint") int paramInt11, @NativeType("GLint") int paramInt12, @NativeType("GLint") int paramInt13, @NativeType("GLint") int paramInt14, @NativeType("GLsizei") int paramInt15, @NativeType("GLsizei") int paramInt16, @NativeType("GLsizei") int paramInt17);
/*     */   
/*     */   public static native void glMulticastBlitFramebufferNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLbitfield") int paramInt11, @NativeType("GLenum") int paramInt12);
/*     */   
/*     */   public static native void nglMulticastFramebufferSampleLocationsfvNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void glMulticastBarrierNV();
/*     */   
/*     */   public static native void glMulticastWaitSyncNV(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2);
/*     */   
/*     */   public static native void nglMulticastGetQueryObjectivNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglMulticastGetQueryObjectuivNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglMulticastGetQueryObjecti64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglMulticastGetQueryObjectui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVGPUMulticast.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */