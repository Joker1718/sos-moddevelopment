/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBBufferStorage
/*     */ {
/*     */   public static final int GL_MAP_PERSISTENT_BIT = 64;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_MAP_COHERENT_BIT = 128;
/*     */   
/*     */   public static final int GL_DYNAMIC_STORAGE_BIT = 256;
/*     */   
/*     */   public static final int GL_CLIENT_STORAGE_BIT = 512;
/*     */   
/*     */   public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
/*     */   public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
/*     */   public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;
/*     */   
/*     */   protected ARBBufferStorage() {
/*  33 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBufferStorage(int target, long size, long data, int flags) {
/*  40 */     GL44C.nglBufferStorage(target, size, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("GLsizeiptr") long size, @NativeType("GLbitfield") int flags) {
/*  45 */     GL44C.glBufferStorage(target, size, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") ByteBuffer data, @NativeType("GLbitfield") int flags) {
/*  50 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") ShortBuffer data, @NativeType("GLbitfield") int flags) {
/*  55 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") IntBuffer data, @NativeType("GLbitfield") int flags) {
/*  60 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") FloatBuffer data, @NativeType("GLbitfield") int flags) {
/*  65 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") DoubleBuffer data, @NativeType("GLbitfield") int flags) {
/*  70 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("GLsizeiptr") long size, @NativeType("GLbitfield") int flags) {
/*  80 */     nglNamedBufferStorageEXT(buffer, size, 0L, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") ByteBuffer data, @NativeType("GLbitfield") int flags) {
/*  85 */     nglNamedBufferStorageEXT(buffer, data.remaining(), MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") ShortBuffer data, @NativeType("GLbitfield") int flags) {
/*  90 */     nglNamedBufferStorageEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") IntBuffer data, @NativeType("GLbitfield") int flags) {
/*  95 */     nglNamedBufferStorageEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") FloatBuffer data, @NativeType("GLbitfield") int flags) {
/* 100 */     nglNamedBufferStorageEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") DoubleBuffer data, @NativeType("GLbitfield") int flags) {
/* 105 */     nglNamedBufferStorageEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data), flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") short[] data, @NativeType("GLbitfield") int flags) {
/* 110 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") int[] data, @NativeType("GLbitfield") int flags) {
/* 115 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") float[] data, @NativeType("GLbitfield") int flags) {
/* 120 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int target, @NativeType("void const *") double[] data, @NativeType("GLbitfield") int flags) {
/* 125 */     GL44C.glBufferStorage(target, data, flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") short[] data, @NativeType("GLbitfield") int flags) {
/* 130 */     long __functionAddress = (GL.getICD()).glNamedBufferStorageEXT;
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(__functionAddress);
/*     */     }
/* 134 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 1L, data, flags, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") int[] data, @NativeType("GLbitfield") int flags) {
/* 139 */     long __functionAddress = (GL.getICD()).glNamedBufferStorageEXT;
/* 140 */     if (Checks.CHECKS) {
/* 141 */       Checks.check(__functionAddress);
/*     */     }
/* 143 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2L, data, flags, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") float[] data, @NativeType("GLbitfield") int flags) {
/* 148 */     long __functionAddress = (GL.getICD()).glNamedBufferStorageEXT;
/* 149 */     if (Checks.CHECKS) {
/* 150 */       Checks.check(__functionAddress);
/*     */     }
/* 152 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2L, data, flags, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int buffer, @NativeType("void const *") double[] data, @NativeType("GLbitfield") int flags) {
/* 157 */     long __functionAddress = (GL.getICD()).glNamedBufferStorageEXT;
/* 158 */     if (Checks.CHECKS) {
/* 159 */       Checks.check(__functionAddress);
/*     */     }
/* 161 */     JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3L, data, flags, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglNamedBufferStorageEXT(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBBufferStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */