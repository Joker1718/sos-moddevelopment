/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class EXTMemoryObject {
/*     */   public static final int GL_TEXTURE_TILING_EXT = 38272;
/*     */   public static final int GL_DEDICATED_MEMORY_OBJECT_EXT = 38273;
/*     */   public static final int GL_NUM_TILING_TYPES_EXT = 38274;
/*     */   public static final int GL_TILING_TYPES_EXT = 38275;
/*     */   public static final int GL_OPTIMAL_TILING_EXT = 38276;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_LINEAR_TILING_EXT = 38277;
/*     */ 
/*     */   
/*     */   public static final int GL_NUM_DEVICE_UUIDS_EXT = 38294;
/*     */ 
/*     */   
/*     */   public static final int GL_DEVICE_UUID_EXT = 38295;
/*     */ 
/*     */   
/*     */   public static final int GL_DRIVER_UUID_EXT = 38296;
/*     */ 
/*     */   
/*     */   public static final int GL_UUID_SIZE_EXT = 16;
/*     */ 
/*     */ 
/*     */   
/*     */   protected EXTMemoryObject() {
/*  41 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUnsignedBytevEXT(@NativeType("GLenum") int pname, @NativeType("GLubyte *") ByteBuffer data) {
/*  51 */     nglGetUnsignedBytevEXT(pname, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUnsignedBytei_vEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLubyte *") ByteBuffer data) {
/*  61 */     nglGetUnsignedBytei_vEXT(target, index, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteMemoryObjectsEXT(@NativeType("GLuint const *") IntBuffer memoryObjects) {
/*  71 */     nglDeleteMemoryObjectsEXT(memoryObjects.remaining(), MemoryUtil.memAddress(memoryObjects));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteMemoryObjectsEXT(@NativeType("GLuint const *") int memoryObject) {
/*  76 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  78 */       IntBuffer memoryObjects = stack.ints(memoryObject);
/*  79 */       nglDeleteMemoryObjectsEXT(1, MemoryUtil.memAddress(memoryObjects));
/*     */     } finally {
/*  81 */       stack.setPointer(stackPointer);
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
/*     */   public static void glCreateMemoryObjectsEXT(@NativeType("GLuint *") IntBuffer memoryObjects) {
/*  98 */     nglCreateMemoryObjectsEXT(memoryObjects.remaining(), MemoryUtil.memAddress(memoryObjects));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glCreateMemoryObjectsEXT() {
/* 104 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 106 */       IntBuffer memoryObjects = stack.callocInt(1);
/* 107 */       nglCreateMemoryObjectsEXT(1, MemoryUtil.memAddress(memoryObjects));
/* 108 */       return memoryObjects.get(0);
/*     */     } finally {
/* 110 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMemoryObjectParameterivEXT(@NativeType("GLuint") int memoryObject, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 121 */     if (Checks.CHECKS) {
/* 122 */       Checks.check(params, 1);
/*     */     }
/* 124 */     nglMemoryObjectParameterivEXT(memoryObject, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMemoryObjectParameteriEXT(@NativeType("GLuint") int memoryObject, @NativeType("GLenum") int pname, @NativeType("GLint const *") int param) {
/* 129 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 131 */       IntBuffer params = stack.ints(param);
/* 132 */       nglMemoryObjectParameterivEXT(memoryObject, pname, MemoryUtil.memAddress(params));
/*     */     } finally {
/* 134 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetMemoryObjectParameterivEXT(@NativeType("GLuint") int memoryObject, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check(params, 1);
/*     */     }
/* 148 */     nglGetMemoryObjectParameterivEXT(memoryObject, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetMemoryObjectParameteriEXT(@NativeType("GLuint") int memoryObject, @NativeType("GLenum") int pname) {
/* 154 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 156 */       IntBuffer params = stack.callocInt(1);
/* 157 */       nglGetMemoryObjectParameterivEXT(memoryObject, pname, MemoryUtil.memAddress(params));
/* 158 */       return params.get(0);
/*     */     } finally {
/* 160 */       stack.setPointer(stackPointer);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteMemoryObjectsEXT(@NativeType("GLuint const *") int[] memoryObjects) {
/* 226 */     long __functionAddress = (GL.getICD()).glDeleteMemoryObjectsEXT;
/* 227 */     if (Checks.CHECKS) {
/* 228 */       Checks.check(__functionAddress);
/*     */     }
/* 230 */     JNI.callPV(memoryObjects.length, memoryObjects, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCreateMemoryObjectsEXT(@NativeType("GLuint *") int[] memoryObjects) {
/* 235 */     long __functionAddress = (GL.getICD()).glCreateMemoryObjectsEXT;
/* 236 */     if (Checks.CHECKS) {
/* 237 */       Checks.check(__functionAddress);
/*     */     }
/* 239 */     JNI.callPV(memoryObjects.length, memoryObjects, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMemoryObjectParameterivEXT(@NativeType("GLuint") int memoryObject, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 244 */     long __functionAddress = (GL.getICD()).glMemoryObjectParameterivEXT;
/* 245 */     if (Checks.CHECKS) {
/* 246 */       Checks.check(__functionAddress);
/* 247 */       Checks.check(params, 1);
/*     */     } 
/* 249 */     JNI.callPV(memoryObject, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetMemoryObjectParameterivEXT(@NativeType("GLuint") int memoryObject, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 254 */     long __functionAddress = (GL.getICD()).glGetMemoryObjectParameterivEXT;
/* 255 */     if (Checks.CHECKS) {
/* 256 */       Checks.check(__functionAddress);
/* 257 */       Checks.check(params, 1);
/*     */     } 
/* 259 */     JNI.callPV(memoryObject, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglGetUnsignedBytevEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetUnsignedBytei_vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglDeleteMemoryObjectsEXT(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsMemoryObjectEXT(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglCreateMemoryObjectsEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMemoryObjectParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetMemoryObjectParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glTexStorageMem2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTexStorageMem2DMultisampleEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt6, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTexStorageMem3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTexStorageMem3DMultisampleEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt7, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glBufferStorageMemEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizeiptr") long paramLong1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong2);
/*     */   
/*     */   public static native void glTextureStorageMem2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTextureStorageMem2DMultisampleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt6, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTextureStorageMem3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTextureStorageMem3DMultisampleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt7, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glNamedBufferStorageMemEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizeiptr") long paramLong1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong2);
/*     */   
/*     */   public static native void glTexStorageMem1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTextureStorageMem1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint64") long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTMemoryObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */