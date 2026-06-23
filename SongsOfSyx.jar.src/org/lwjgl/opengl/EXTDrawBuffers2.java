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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EXTDrawBuffers2
/*     */ {
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */   protected EXTDrawBuffers2() {
/*  22 */     throw new UnsupportedOperationException();
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
/*     */   public static void glGetBooleanIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLboolean *") ByteBuffer data) {
/*  37 */     if (Checks.CHECKS) {
/*  38 */       Checks.check(data, 1);
/*     */     }
/*  40 */     nglGetBooleanIndexedvEXT(target, index, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static boolean glGetBooleanIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/*  46 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  48 */       ByteBuffer data = stack.calloc(1);
/*  49 */       nglGetBooleanIndexedvEXT(target, index, MemoryUtil.memAddress(data));
/*  50 */       return (data.get(0) != 0);
/*     */     } finally {
/*  52 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer data) {
/*  63 */     if (Checks.CHECKS) {
/*  64 */       Checks.check(data, 1);
/*     */     }
/*  66 */     nglGetIntegerIndexedvEXT(target, index, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetIntegerIndexedEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/*  72 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  74 */       IntBuffer data = stack.callocInt(1);
/*  75 */       nglGetIntegerIndexedvEXT(target, index, MemoryUtil.memAddress(data));
/*  76 */       return data.get(0);
/*     */     } finally {
/*  78 */       stack.setPointer(stackPointer);
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
/*     */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint *") int[] data) {
/* 100 */     long __functionAddress = (GL.getICD()).glGetIntegerIndexedvEXT;
/* 101 */     if (Checks.CHECKS) {
/* 102 */       Checks.check(__functionAddress);
/* 103 */       Checks.check(data, 1);
/*     */     } 
/* 105 */     JNI.callPV(target, index, data, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glColorMaskIndexedEXT(@NativeType("GLuint") int paramInt, @NativeType("GLboolean") boolean paramBoolean1, @NativeType("GLboolean") boolean paramBoolean2, @NativeType("GLboolean") boolean paramBoolean3, @NativeType("GLboolean") boolean paramBoolean4);
/*     */   
/*     */   public static native void nglGetBooleanIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetIntegerIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glEnableIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glDisableIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsEnabledIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTDrawBuffers2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */