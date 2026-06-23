/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EXTTimerQuery
/*     */ {
/*     */   public static final int GL_TIME_ELAPSED_EXT = 35007;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   protected EXTTimerQuery() {
/*  24 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64vEXT(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/*  34 */     if (Checks.CHECKS) {
/*  35 */       Checks.check(params, 1);
/*     */     }
/*  37 */     nglGetQueryObjecti64vEXT(id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64vEXT(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long params) {
/*  42 */     nglGetQueryObjecti64vEXT(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjecti64EXT(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/*  48 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  50 */       LongBuffer params = stack.callocLong(1);
/*  51 */       nglGetQueryObjecti64vEXT(id, pname, MemoryUtil.memAddress(params));
/*  52 */       return params.get(0);
/*     */     } finally {
/*  54 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64vEXT(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") LongBuffer params) {
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(params, 1);
/*     */     }
/*  68 */     nglGetQueryObjectui64vEXT(id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64vEXT(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long params) {
/*  73 */     nglGetQueryObjectui64vEXT(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjectui64EXT(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/*  79 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  81 */       LongBuffer params = stack.callocLong(1);
/*  82 */       nglGetQueryObjectui64vEXT(id, pname, MemoryUtil.memAddress(params));
/*  83 */       return params.get(0);
/*     */     } finally {
/*  85 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64vEXT(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/*  91 */     long __functionAddress = (GL.getICD()).glGetQueryObjecti64vEXT;
/*  92 */     if (Checks.CHECKS) {
/*  93 */       Checks.check(__functionAddress);
/*  94 */       Checks.check(params, 1);
/*     */     } 
/*  96 */     JNI.callPV(id, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64vEXT(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long[] params) {
/* 101 */     long __functionAddress = (GL.getICD()).glGetQueryObjectui64vEXT;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(__functionAddress);
/* 104 */       Checks.check(params, 1);
/*     */     } 
/* 106 */     JNI.callPV(id, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglGetQueryObjecti64vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetQueryObjectui64vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTTimerQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */