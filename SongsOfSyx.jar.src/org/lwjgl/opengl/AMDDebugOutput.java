/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AMDDebugOutput
/*     */ {
/*     */   public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_AMD = 37187;
/*     */   public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_AMD = 37188;
/*     */   public static final int GL_DEBUG_LOGGED_MESSAGES_AMD = 37189;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_DEBUG_SEVERITY_HIGH_AMD = 37190;
/*     */   
/*     */   public static final int GL_DEBUG_SEVERITY_MEDIUM_AMD = 37191;
/*     */   
/*     */   public static final int GL_DEBUG_SEVERITY_LOW_AMD = 37192;
/*     */   
/*     */   public static final int GL_DEBUG_CATEGORY_API_ERROR_AMD = 37193;
/*     */   
/*     */   public static final int GL_DEBUG_CATEGORY_WINDOW_SYSTEM_AMD = 37194;
/*     */   
/*     */   public static final int GL_DEBUG_CATEGORY_DEPRECATION_AMD = 37195;
/*     */   
/*     */   public static final int GL_DEBUG_CATEGORY_UNDEFINED_BEHAVIOR_AMD = 37196;
/*     */   public static final int GL_DEBUG_CATEGORY_PERFORMANCE_AMD = 37197;
/*     */   public static final int GL_DEBUG_CATEGORY_SHADER_COMPILER_AMD = 37198;
/*     */   public static final int GL_DEBUG_CATEGORY_APPLICATION_AMD = 37199;
/*     */   public static final int GL_DEBUG_CATEGORY_OTHER_AMD = 37200;
/*     */   
/*     */   protected AMDDebugOutput() {
/*  44 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDebugMessageEnableAMD(@NativeType("GLenum") int category, @NativeType("GLenum") int severity, @NativeType("GLuint const *") IntBuffer ids, @NativeType("GLboolean") boolean enabled) {
/*  54 */     nglDebugMessageEnableAMD(category, severity, Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids), enabled);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageEnableAMD(@NativeType("GLenum") int category, @NativeType("GLenum") int severity, @NativeType("GLuint const *") int id, @NativeType("GLboolean") boolean enabled) {
/*  59 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  61 */       IntBuffer ids = stack.ints(id);
/*  62 */       nglDebugMessageEnableAMD(category, severity, 1, MemoryUtil.memAddress(ids), enabled);
/*     */     } finally {
/*  64 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDebugMessageInsertAMD(@NativeType("GLenum") int category, @NativeType("GLenum") int severity, @NativeType("GLuint") int id, @NativeType("GLchar const *") ByteBuffer buf) {
/*  75 */     nglDebugMessageInsertAMD(category, severity, id, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageInsertAMD(@NativeType("GLenum") int category, @NativeType("GLenum") int severity, @NativeType("GLuint") int id, @NativeType("GLchar const *") CharSequence buf) {
/*  80 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  82 */       int bufEncodedLength = stack.nUTF8(buf, false);
/*  83 */       long bufEncoded = stack.getPointerAddress();
/*  84 */       nglDebugMessageInsertAMD(category, severity, id, bufEncodedLength, bufEncoded);
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
/*     */   public static void glDebugMessageCallbackAMD(@NativeType("GLDEBUGPROCAMD") GLDebugMessageAMDCallbackI callback, @NativeType("void *") long userParam) {
/*  97 */     nglDebugMessageCallbackAMD(MemoryUtil.memAddressSafe((Pointer)callback), userParam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLogAMD(@NativeType("GLuint") int count, @NativeType("GLenum *") IntBuffer categories, @NativeType("GLenum *") IntBuffer severities, @NativeType("GLuint *") IntBuffer ids, @NativeType("GLsizei *") IntBuffer lengths, @NativeType("GLchar *") ByteBuffer messageLog) {
/* 108 */     if (Checks.CHECKS) {
/* 109 */       Checks.checkSafe(categories, count);
/* 110 */       Checks.checkSafe(severities, count);
/* 111 */       Checks.checkSafe(ids, count);
/* 112 */       Checks.checkSafe(lengths, count);
/*     */     } 
/* 114 */     return nglGetDebugMessageLogAMD(count, Checks.remainingSafe(messageLog), MemoryUtil.memAddressSafe(categories), MemoryUtil.memAddressSafe(severities), MemoryUtil.memAddressSafe(ids), MemoryUtil.memAddressSafe(lengths), MemoryUtil.memAddressSafe(messageLog));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageEnableAMD(@NativeType("GLenum") int category, @NativeType("GLenum") int severity, @NativeType("GLuint const *") int[] ids, @NativeType("GLboolean") boolean enabled) {
/* 119 */     long __functionAddress = (GL.getICD()).glDebugMessageEnableAMD;
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(__functionAddress);
/*     */     }
/* 123 */     JNI.callPV(category, severity, Checks.lengthSafe(ids), ids, enabled, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLogAMD(@NativeType("GLuint") int count, @NativeType("GLenum *") int[] categories, @NativeType("GLenum *") int[] severities, @NativeType("GLuint *") int[] ids, @NativeType("GLsizei *") int[] lengths, @NativeType("GLchar *") ByteBuffer messageLog) {
/* 129 */     long __functionAddress = (GL.getICD()).glGetDebugMessageLogAMD;
/* 130 */     if (Checks.CHECKS) {
/* 131 */       Checks.check(__functionAddress);
/* 132 */       Checks.checkSafe(categories, count);
/* 133 */       Checks.checkSafe(severities, count);
/* 134 */       Checks.checkSafe(ids, count);
/* 135 */       Checks.checkSafe(lengths, count);
/*     */     } 
/* 137 */     return JNI.callPPPPPI(count, Checks.remainingSafe(messageLog), categories, severities, ids, lengths, MemoryUtil.memAddressSafe(messageLog), __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglDebugMessageEnableAMD(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean);
/*     */   
/*     */   public static native void nglDebugMessageInsertAMD(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglDebugMessageCallbackAMD(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nglGetDebugMessageLogAMD(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\AMDDebugOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */