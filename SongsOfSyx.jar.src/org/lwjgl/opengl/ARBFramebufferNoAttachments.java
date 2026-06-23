/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class ARBFramebufferNoAttachments
/*     */ {
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
/*     */   
/*     */   public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
/*     */   
/*     */   public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
/*     */   
/*     */   public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
/*     */   
/*     */   public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;
/*     */ 
/*     */   
/*     */   protected ARBFramebufferNoAttachments() {
/*  35 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFramebufferParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/*  42 */     GL43C.glFramebufferParameteri(target, pname, param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetFramebufferParameteriv(int target, int pname, long params) {
/*  49 */     GL43C.nglGetFramebufferParameteriv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  54 */     GL43C.glGetFramebufferParameteriv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetFramebufferParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  60 */     return GL43C.glGetFramebufferParameteri(target, pname);
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
/*     */   public static void glGetNamedFramebufferParameterivEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  75 */     if (Checks.CHECKS) {
/*  76 */       Checks.check(params, 1);
/*     */     }
/*  78 */     nglGetNamedFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetNamedFramebufferParameteriEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname) {
/*  84 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  86 */       IntBuffer params = stack.callocInt(1);
/*  87 */       nglGetNamedFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.memAddress(params));
/*  88 */       return params.get(0);
/*     */     } finally {
/*  90 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/*  96 */     GL43C.glGetFramebufferParameteriv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedFramebufferParameterivEXT(@NativeType("GLuint") int framebuffer, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 101 */     long __functionAddress = (GL.getICD()).glGetNamedFramebufferParameterivEXT;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(__functionAddress);
/* 104 */       Checks.check(params, 1);
/*     */     } 
/* 106 */     JNI.callPV(framebuffer, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glNamedFramebufferParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void nglGetNamedFramebufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBFramebufferNoAttachments.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */