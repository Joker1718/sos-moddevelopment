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
/*     */ public class NVQueryResourceTag
/*     */ {
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */   protected NVQueryResourceTag() {
/*  22 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenQueryResourceTagNV(@NativeType("GLuint *") IntBuffer tagIds) {
/*  32 */     nglGenQueryResourceTagNV(tagIds.remaining(), MemoryUtil.memAddress(tagIds));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenQueryResourceTagNV() {
/*  38 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  40 */       IntBuffer tagIds = stack.callocInt(1);
/*  41 */       nglGenQueryResourceTagNV(1, MemoryUtil.memAddress(tagIds));
/*  42 */       return tagIds.get(0);
/*     */     } finally {
/*  44 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteQueryResourceTagNV(@NativeType("GLuint const *") IntBuffer tagIds) {
/*  55 */     nglDeleteQueryResourceTagNV(tagIds.remaining(), MemoryUtil.memAddress(tagIds));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueryResourceTagNV(@NativeType("GLuint const *") int tagId) {
/*  60 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  62 */       IntBuffer tagIds = stack.ints(tagId);
/*  63 */       nglDeleteQueryResourceTagNV(1, MemoryUtil.memAddress(tagIds));
/*     */     } finally {
/*  65 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glQueryResourceTagNV(@NativeType("GLuint") int tagId, @NativeType("GLchar const *") ByteBuffer tagString) {
/*  76 */     if (Checks.CHECKS) {
/*  77 */       Checks.checkNT1(tagString);
/*     */     }
/*  79 */     nglQueryResourceTagNV(tagId, MemoryUtil.memAddress(tagString));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glQueryResourceTagNV(@NativeType("GLuint") int tagId, @NativeType("GLchar const *") CharSequence tagString) {
/*  84 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  86 */       stack.nASCII(tagString, true);
/*  87 */       long tagStringEncoded = stack.getPointerAddress();
/*  88 */       nglQueryResourceTagNV(tagId, tagStringEncoded);
/*     */     } finally {
/*  90 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenQueryResourceTagNV(@NativeType("GLuint *") int[] tagIds) {
/*  96 */     long __functionAddress = (GL.getICD()).glGenQueryResourceTagNV;
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check(__functionAddress);
/*     */     }
/* 100 */     JNI.callPV(tagIds.length, tagIds, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueryResourceTagNV(@NativeType("GLuint const *") int[] tagIds) {
/* 105 */     long __functionAddress = (GL.getICD()).glDeleteQueryResourceTagNV;
/* 106 */     if (Checks.CHECKS) {
/* 107 */       Checks.check(__functionAddress);
/*     */     }
/* 109 */     JNI.callPV(tagIds.length, tagIds, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglGenQueryResourceTagNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteQueryResourceTagNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglQueryResourceTagNV(int paramInt, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVQueryResourceTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */