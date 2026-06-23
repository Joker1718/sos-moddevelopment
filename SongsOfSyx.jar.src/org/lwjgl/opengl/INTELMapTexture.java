/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class INTELMapTexture
/*     */ {
/*     */   public static final int GL_TEXTURE_MEMORY_LAYOUT_INTEL = 33791;
/*     */   public static final int GL_LAYOUT_DEFAULT_INTEL = 0;
/*     */   public static final int GL_LAYOUT_LINEAR_INTEL = 1;
/*     */   public static final int GL_LAYOUT_LINEAR_CPU_CACHED_INTEL = 2;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected INTELMapTexture() {
/*  31 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLbitfield") int access, @NativeType("GLint *") IntBuffer stride, @NativeType("GLenum *") IntBuffer layout) {
/*  52 */     if (Checks.CHECKS) {
/*  53 */       Checks.check(stride, 1);
/*  54 */       Checks.check(layout, 1);
/*     */     } 
/*  56 */     long __result = nglMapTexture2DINTEL(texture, level, access, MemoryUtil.memAddress(stride), MemoryUtil.memAddress(layout));
/*  57 */     return MemoryUtil.memByteBufferSafe(__result, getStride(stride) * GLChecks.getTexLevelParameteri(texture, 3553, level, 4097));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLbitfield") int access, @NativeType("GLint *") IntBuffer stride, @NativeType("GLenum *") IntBuffer layout, ByteBuffer old_buffer) {
/*  63 */     if (Checks.CHECKS) {
/*  64 */       Checks.check(stride, 1);
/*  65 */       Checks.check(layout, 1);
/*     */     } 
/*  67 */     long __result = nglMapTexture2DINTEL(texture, level, access, MemoryUtil.memAddress(stride), MemoryUtil.memAddress(layout));
/*  68 */     int length = getStride(stride) * GLChecks.getTexLevelParameteri(texture, 3553, level, 4097);
/*  69 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLbitfield") int access, @NativeType("GLint *") IntBuffer stride, @NativeType("GLenum *") IntBuffer layout, long length, ByteBuffer old_buffer) {
/*  75 */     if (Checks.CHECKS) {
/*  76 */       Checks.check(stride, 1);
/*  77 */       Checks.check(layout, 1);
/*     */     } 
/*  79 */     long __result = nglMapTexture2DINTEL(texture, level, access, MemoryUtil.memAddress(stride), MemoryUtil.memAddress(layout));
/*  80 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLbitfield") int access, @NativeType("GLint *") int[] stride, @NativeType("GLenum *") int[] layout) {
/*  86 */     long __functionAddress = (GL.getICD()).glMapTexture2DINTEL;
/*  87 */     if (Checks.CHECKS) {
/*  88 */       Checks.check(__functionAddress);
/*  89 */       Checks.check(stride, 1);
/*  90 */       Checks.check(layout, 1);
/*     */     } 
/*  92 */     long __result = JNI.callPPP(texture, level, access, stride, layout, __functionAddress);
/*  93 */     return MemoryUtil.memByteBufferSafe(__result, getStride(stride) * GLChecks.getTexLevelParameteri(texture, 3553, level, 4097));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLbitfield") int access, @NativeType("GLint *") int[] stride, @NativeType("GLenum *") int[] layout, ByteBuffer old_buffer) {
/*  99 */     long __functionAddress = (GL.getICD()).glMapTexture2DINTEL;
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.check(__functionAddress);
/* 102 */       Checks.check(stride, 1);
/* 103 */       Checks.check(layout, 1);
/*     */     } 
/* 105 */     long __result = JNI.callPPP(texture, level, access, stride, layout, __functionAddress);
/* 106 */     int length = getStride(stride) * GLChecks.getTexLevelParameteri(texture, 3553, level, 4097);
/* 107 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLbitfield") int access, @NativeType("GLint *") int[] stride, @NativeType("GLenum *") int[] layout, long length, ByteBuffer old_buffer) {
/* 113 */     long __functionAddress = (GL.getICD()).glMapTexture2DINTEL;
/* 114 */     if (Checks.CHECKS) {
/* 115 */       Checks.check(__functionAddress);
/* 116 */       Checks.check(stride, 1);
/* 117 */       Checks.check(layout, 1);
/*     */     } 
/* 119 */     long __result = JNI.callPPP(texture, level, access, stride, layout, __functionAddress);
/* 120 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
/*     */   }
/*     */   
/*     */   private static int getStride(IntBuffer stride) {
/* 124 */     return stride.get(stride.position());
/*     */   }
/*     */   
/*     */   private static int getStride(int[] stride) {
/* 128 */     return stride[0];
/*     */   }
/*     */   
/*     */   public static native void glSyncTextureINTEL(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glUnmapTexture2DINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native long nglMapTexture2DINTEL(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\INTELMapTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */