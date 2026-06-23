/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBSync
/*     */ {
/*     */   public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
/*     */   public static final int GL_OBJECT_TYPE = 37138;
/*     */   public static final int GL_SYNC_CONDITION = 37139;
/*     */   
/*     */   static {
/*  16 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_SYNC_STATUS = 37140;
/*     */   
/*     */   public static final int GL_SYNC_FLAGS = 37141;
/*     */   
/*     */   public static final int GL_SYNC_FENCE = 37142;
/*     */   
/*     */   public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
/*     */   
/*     */   public static final int GL_UNSIGNALED = 37144;
/*     */   
/*     */   public static final int GL_SIGNALED = 37145;
/*     */   
/*     */   public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
/*     */   
/*     */   public static final long GL_TIMEOUT_IGNORED = -1L;
/*     */   
/*     */   public static final int GL_ALREADY_SIGNALED = 37146;
/*     */   
/*     */   public static final int GL_TIMEOUT_EXPIRED = 37147;
/*     */   
/*     */   public static final int GL_CONDITION_SATISFIED = 37148;
/*     */   
/*     */   public static final int GL_WAIT_FAILED = 37149;
/*     */   
/*     */   protected ARBSync() {
/*  45 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLsync")
/*     */   public static long glFenceSync(@NativeType("GLenum") int condition, @NativeType("GLbitfield") int flags) {
/*  53 */     return GL32C.glFenceSync(condition, flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nglIsSync(long sync) {
/*  60 */     return GL32C.nglIsSync(sync);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsSync(@NativeType("GLsync") long sync) {
/*  66 */     return GL32C.glIsSync(sync);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteSync(@NativeType("GLsync") long sync) {
/*  73 */     GL32C.glDeleteSync(sync);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglClientWaitSync(long sync, int flags, long timeout) {
/*  80 */     return GL32C.nglClientWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLenum")
/*     */   public static int glClientWaitSync(@NativeType("GLsync") long sync, @NativeType("GLbitfield") int flags, @NativeType("GLuint64") long timeout) {
/*  86 */     return GL32C.glClientWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglWaitSync(long sync, int flags, long timeout) {
/*  93 */     GL32C.nglWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWaitSync(@NativeType("GLsync") long sync, @NativeType("GLbitfield") int flags, @NativeType("GLuint64") long timeout) {
/*  98 */     GL32C.glWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetInteger64v(int pname, long params) {
/* 105 */     GL32C.nglGetInteger64v(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/* 110 */     GL32C.glGetInteger64v(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetInteger64(@NativeType("GLenum") int pname) {
/* 116 */     return GL32C.glGetInteger64(pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSynciv(long sync, int pname, int bufSize, long length, long values) {
/* 123 */     GL32C.nglGetSynciv(sync, pname, bufSize, length, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSynciv(@NativeType("GLsync") long sync, @NativeType("GLenum") int pname, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer values) {
/* 128 */     GL32C.glGetSynciv(sync, pname, length, values);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSynci(@NativeType("GLsync") long sync, @NativeType("GLenum") int pname, @NativeType("GLsizei *") IntBuffer length) {
/* 134 */     return GL32C.glGetSynci(sync, pname, length);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 139 */     GL32C.glGetInteger64v(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSynciv(@NativeType("GLsync") long sync, @NativeType("GLenum") int pname, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] values) {
/* 144 */     GL32C.glGetSynciv(sync, pname, length, values);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */