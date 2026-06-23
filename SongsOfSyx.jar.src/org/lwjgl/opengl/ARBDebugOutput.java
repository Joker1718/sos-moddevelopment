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
/*     */ public class ARBDebugOutput
/*     */ {
/*     */   public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS_ARB = 33346;
/*     */   public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_ARB = 37187;
/*     */   public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_ARB = 37188;
/*     */   public static final int GL_DEBUG_LOGGED_MESSAGES_ARB = 37189;
/*     */   public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_ARB = 33347;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_DEBUG_CALLBACK_FUNCTION_ARB = 33348;
/*     */   
/*     */   public static final int GL_DEBUG_CALLBACK_USER_PARAM_ARB = 33349;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_API_ARB = 33350;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB = 33351;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_SHADER_COMPILER_ARB = 33352;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_THIRD_PARTY_ARB = 33353;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_APPLICATION_ARB = 33354;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_OTHER_ARB = 33355;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_ERROR_ARB = 33356;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB = 33357;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB = 33358;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_PORTABILITY_ARB = 33359;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_PERFORMANCE_ARB = 33360;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_OTHER_ARB = 33361;
/*     */   public static final int GL_DEBUG_SEVERITY_HIGH_ARB = 37190;
/*     */   public static final int GL_DEBUG_SEVERITY_MEDIUM_ARB = 37191;
/*     */   public static final int GL_DEBUG_SEVERITY_LOW_ARB = 37192;
/*     */   
/*     */   protected ARBDebugOutput() {
/*  57 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDebugMessageControlARB(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @NativeType("GLuint const *") IntBuffer ids, @NativeType("GLboolean") boolean enabled) {
/*  67 */     nglDebugMessageControlARB(source, type, severity, Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids), enabled);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageControlARB(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @NativeType("GLuint const *") int id, @NativeType("GLboolean") boolean enabled) {
/*  72 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  74 */       IntBuffer ids = stack.ints(id);
/*  75 */       nglDebugMessageControlARB(source, type, severity, 1, MemoryUtil.memAddress(ids), enabled);
/*     */     } finally {
/*  77 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDebugMessageInsertARB(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLuint") int id, @NativeType("GLenum") int severity, @NativeType("GLchar const *") ByteBuffer buf) {
/*  88 */     nglDebugMessageInsertARB(source, type, id, severity, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageInsertARB(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLuint") int id, @NativeType("GLenum") int severity, @NativeType("GLchar const *") CharSequence buf) {
/*  93 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  95 */       int bufEncodedLength = stack.nUTF8(buf, false);
/*  96 */       long bufEncoded = stack.getPointerAddress();
/*  97 */       nglDebugMessageInsertARB(source, type, id, severity, bufEncodedLength, bufEncoded);
/*     */     } finally {
/*  99 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDebugMessageCallbackARB(@NativeType("GLDEBUGPROCARB") GLDebugMessageARBCallbackI callback, @NativeType("void const *") long userParam) {
/* 110 */     nglDebugMessageCallbackARB(MemoryUtil.memAddressSafe((Pointer)callback), userParam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLogARB(@NativeType("GLuint") int count, @NativeType("GLenum *") IntBuffer sources, @NativeType("GLenum *") IntBuffer types, @NativeType("GLuint *") IntBuffer ids, @NativeType("GLenum *") IntBuffer severities, @NativeType("GLsizei *") IntBuffer lengths, @NativeType("GLchar *") ByteBuffer messageLog) {
/* 121 */     if (Checks.CHECKS) {
/* 122 */       Checks.checkSafe(sources, count);
/* 123 */       Checks.checkSafe(types, count);
/* 124 */       Checks.checkSafe(ids, count);
/* 125 */       Checks.checkSafe(severities, count);
/* 126 */       Checks.checkSafe(lengths, count);
/*     */     } 
/* 128 */     return nglGetDebugMessageLogARB(count, Checks.remainingSafe(messageLog), MemoryUtil.memAddressSafe(sources), MemoryUtil.memAddressSafe(types), MemoryUtil.memAddressSafe(ids), MemoryUtil.memAddressSafe(severities), MemoryUtil.memAddressSafe(lengths), MemoryUtil.memAddressSafe(messageLog));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageControlARB(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @NativeType("GLuint const *") int[] ids, @NativeType("GLboolean") boolean enabled) {
/* 133 */     long __functionAddress = (GL.getICD()).glDebugMessageControlARB;
/* 134 */     if (Checks.CHECKS) {
/* 135 */       Checks.check(__functionAddress);
/*     */     }
/* 137 */     JNI.callPV(source, type, severity, Checks.lengthSafe(ids), ids, enabled, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLogARB(@NativeType("GLuint") int count, @NativeType("GLenum *") int[] sources, @NativeType("GLenum *") int[] types, @NativeType("GLuint *") int[] ids, @NativeType("GLenum *") int[] severities, @NativeType("GLsizei *") int[] lengths, @NativeType("GLchar *") ByteBuffer messageLog) {
/* 143 */     long __functionAddress = (GL.getICD()).glGetDebugMessageLogARB;
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(__functionAddress);
/* 146 */       Checks.checkSafe(sources, count);
/* 147 */       Checks.checkSafe(types, count);
/* 148 */       Checks.checkSafe(ids, count);
/* 149 */       Checks.checkSafe(severities, count);
/* 150 */       Checks.checkSafe(lengths, count);
/*     */     } 
/* 152 */     return JNI.callPPPPPPI(count, Checks.remainingSafe(messageLog), sources, types, ids, severities, lengths, MemoryUtil.memAddressSafe(messageLog), __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglDebugMessageControlARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean);
/*     */   
/*     */   public static native void nglDebugMessageInsertARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*     */   
/*     */   public static native void nglDebugMessageCallbackARB(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nglGetDebugMessageLogARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBDebugOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */