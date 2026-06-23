/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class EXTSemaphore
/*     */ {
/*     */   public static final int GL_NUM_DEVICE_UUIDS_EXT = 38294;
/*     */   public static final int GL_DEVICE_UUID_EXT = 38295;
/*     */   public static final int GL_DRIVER_UUID_EXT = 38296;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_UUID_SIZE_EXT = 16;
/*     */   
/*     */   public static final int GL_LAYOUT_GENERAL_EXT = 38285;
/*     */   
/*     */   public static final int GL_LAYOUT_COLOR_ATTACHMENT_EXT = 38286;
/*     */   
/*     */   public static final int GL_LAYOUT_DEPTH_STENCIL_ATTACHMENT_EXT = 38287;
/*     */   
/*     */   public static final int GL_LAYOUT_DEPTH_STENCIL_READ_ONLY_EXT = 38288;
/*     */   
/*     */   public static final int GL_LAYOUT_SHADER_READ_ONLY_EXT = 38289;
/*     */   public static final int GL_LAYOUT_TRANSFER_SRC_EXT = 38290;
/*     */   public static final int GL_LAYOUT_TRANSFER_DST_EXT = 38291;
/*     */   public static final int GL_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_EXT = 38192;
/*     */   public static final int GL_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_EXT = 38193;
/*     */   
/*     */   protected EXTSemaphore() {
/*  40 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUnsignedBytevEXT(int pname, long data) {
/*  47 */     EXTMemoryObject.nglGetUnsignedBytevEXT(pname, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUnsignedBytevEXT(@NativeType("GLenum") int pname, @NativeType("GLubyte *") ByteBuffer data) {
/*  52 */     EXTMemoryObject.glGetUnsignedBytevEXT(pname, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUnsignedBytei_vEXT(int target, int index, long data) {
/*  59 */     EXTMemoryObject.nglGetUnsignedBytei_vEXT(target, index, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUnsignedBytei_vEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLubyte *") ByteBuffer data) {
/*  64 */     EXTMemoryObject.glGetUnsignedBytei_vEXT(target, index, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenSemaphoresEXT(@NativeType("GLuint *") IntBuffer semaphores) {
/*  74 */     nglGenSemaphoresEXT(semaphores.remaining(), MemoryUtil.memAddress(semaphores));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenSemaphoresEXT() {
/*  80 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  82 */       IntBuffer semaphores = stack.callocInt(1);
/*  83 */       nglGenSemaphoresEXT(1, MemoryUtil.memAddress(semaphores));
/*  84 */       return semaphores.get(0);
/*     */     } finally {
/*  86 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteSemaphoresEXT(@NativeType("GLuint const *") IntBuffer semaphores) {
/*  97 */     nglDeleteSemaphoresEXT(semaphores.remaining(), MemoryUtil.memAddress(semaphores));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSemaphoresEXT(@NativeType("GLuint const *") int semaphore) {
/* 102 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 104 */       IntBuffer semaphores = stack.ints(semaphore);
/* 105 */       nglDeleteSemaphoresEXT(1, MemoryUtil.memAddress(semaphores));
/*     */     } finally {
/* 107 */       stack.setPointer(stackPointer);
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
/*     */   public static void glSemaphoreParameterui64vEXT(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname, @NativeType("GLuint64 const *") LongBuffer params) {
/* 124 */     if (Checks.CHECKS) {
/* 125 */       Checks.check(params, 1);
/*     */     }
/* 127 */     nglSemaphoreParameterui64vEXT(semaphore, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSemaphoreParameterui64EXT(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname, @NativeType("GLuint64 const *") long param) {
/* 132 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 134 */       LongBuffer params = stack.longs(param);
/* 135 */       nglSemaphoreParameterui64vEXT(semaphore, pname, MemoryUtil.memAddress(params));
/*     */     } finally {
/* 137 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSemaphoreParameterui64vEXT(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") LongBuffer params) {
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.check(params, 1);
/*     */     }
/* 151 */     nglGetSemaphoreParameterui64vEXT(semaphore, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetSemaphoreParameterui64EXT(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname) {
/* 157 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 159 */       LongBuffer params = stack.callocLong(1);
/* 160 */       nglGetSemaphoreParameterui64vEXT(semaphore, pname, MemoryUtil.memAddress(params));
/* 161 */       return params.get(0);
/*     */     } finally {
/* 163 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWaitSemaphoreEXT(@NativeType("GLuint") int semaphore, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLuint const *") IntBuffer textures, @NativeType("GLenum const *") IntBuffer srcLayouts) {
/* 174 */     if (Checks.CHECKS) {
/* 175 */       Checks.check(srcLayouts, textures.remaining());
/*     */     }
/* 177 */     nglWaitSemaphoreEXT(semaphore, buffers.remaining(), MemoryUtil.memAddress(buffers), textures.remaining(), MemoryUtil.memAddress(textures), MemoryUtil.memAddress(srcLayouts));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSignalSemaphoreEXT(@NativeType("GLuint") int semaphore, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLuint const *") IntBuffer textures, @NativeType("GLenum const *") IntBuffer dstLayouts) {
/* 187 */     if (Checks.CHECKS) {
/* 188 */       Checks.check(dstLayouts, textures.remaining());
/*     */     }
/* 190 */     nglSignalSemaphoreEXT(semaphore, buffers.remaining(), MemoryUtil.memAddress(buffers), textures.remaining(), MemoryUtil.memAddress(textures), MemoryUtil.memAddress(dstLayouts));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenSemaphoresEXT(@NativeType("GLuint *") int[] semaphores) {
/* 195 */     long __functionAddress = (GL.getICD()).glGenSemaphoresEXT;
/* 196 */     if (Checks.CHECKS) {
/* 197 */       Checks.check(__functionAddress);
/*     */     }
/* 199 */     JNI.callPV(semaphores.length, semaphores, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSemaphoresEXT(@NativeType("GLuint const *") int[] semaphores) {
/* 204 */     long __functionAddress = (GL.getICD()).glDeleteSemaphoresEXT;
/* 205 */     if (Checks.CHECKS) {
/* 206 */       Checks.check(__functionAddress);
/*     */     }
/* 208 */     JNI.callPV(semaphores.length, semaphores, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSemaphoreParameterui64vEXT(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname, @NativeType("GLuint64 const *") long[] params) {
/* 213 */     long __functionAddress = (GL.getICD()).glSemaphoreParameterui64vEXT;
/* 214 */     if (Checks.CHECKS) {
/* 215 */       Checks.check(__functionAddress);
/* 216 */       Checks.check(params, 1);
/*     */     } 
/* 218 */     JNI.callPV(semaphore, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSemaphoreParameterui64vEXT(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long[] params) {
/* 223 */     long __functionAddress = (GL.getICD()).glGetSemaphoreParameterui64vEXT;
/* 224 */     if (Checks.CHECKS) {
/* 225 */       Checks.check(__functionAddress);
/* 226 */       Checks.check(params, 1);
/*     */     } 
/* 228 */     JNI.callPV(semaphore, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWaitSemaphoreEXT(@NativeType("GLuint") int semaphore, @NativeType("GLuint const *") int[] buffers, @NativeType("GLuint const *") int[] textures, @NativeType("GLenum const *") int[] srcLayouts) {
/* 233 */     long __functionAddress = (GL.getICD()).glWaitSemaphoreEXT;
/* 234 */     if (Checks.CHECKS) {
/* 235 */       Checks.check(__functionAddress);
/* 236 */       Checks.check(srcLayouts, textures.length);
/*     */     } 
/* 238 */     JNI.callPPPV(semaphore, buffers.length, buffers, textures.length, textures, srcLayouts, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSignalSemaphoreEXT(@NativeType("GLuint") int semaphore, @NativeType("GLuint const *") int[] buffers, @NativeType("GLuint const *") int[] textures, @NativeType("GLenum const *") int[] dstLayouts) {
/* 243 */     long __functionAddress = (GL.getICD()).glSignalSemaphoreEXT;
/* 244 */     if (Checks.CHECKS) {
/* 245 */       Checks.check(__functionAddress);
/* 246 */       Checks.check(dstLayouts, textures.length);
/*     */     } 
/* 248 */     JNI.callPPPV(semaphore, buffers.length, buffers, textures.length, textures, dstLayouts, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglGenSemaphoresEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteSemaphoresEXT(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsSemaphoreEXT(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglSemaphoreParameterui64vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSemaphoreParameterui64vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglWaitSemaphoreEXT(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nglSignalSemaphoreEXT(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, long paramLong3);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTSemaphore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */