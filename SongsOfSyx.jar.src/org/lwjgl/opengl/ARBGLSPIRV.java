/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBGLSPIRV
/*    */ {
/*    */   public static final int GL_SHADER_BINARY_FORMAT_SPIR_V_ARB = 38225;
/*    */   public static final int GL_SPIR_V_BINARY_ARB = 38226;
/*    */   
/*    */   static {
/* 19 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBGLSPIRV() {
/* 26 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glSpecializeShaderARB(@NativeType("GLuint") int shader, @NativeType("GLchar const *") ByteBuffer pEntryPoint, @NativeType("GLuint const *") IntBuffer pConstantIndex, @NativeType("GLuint const *") IntBuffer pConstantValue) {
/* 36 */     if (Checks.CHECKS) {
/* 37 */       Checks.checkNT1(pEntryPoint);
/* 38 */       Checks.check(pConstantValue, pConstantIndex.remaining());
/*    */     } 
/* 40 */     nglSpecializeShaderARB(shader, MemoryUtil.memAddress(pEntryPoint), pConstantIndex.remaining(), MemoryUtil.memAddress(pConstantIndex), MemoryUtil.memAddress(pConstantValue));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glSpecializeShaderARB(@NativeType("GLuint") int shader, @NativeType("GLchar const *") CharSequence pEntryPoint, @NativeType("GLuint const *") IntBuffer pConstantIndex, @NativeType("GLuint const *") IntBuffer pConstantValue) {
/* 45 */     if (Checks.CHECKS) {
/* 46 */       Checks.check(pConstantValue, pConstantIndex.remaining());
/*    */     }
/* 48 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 50 */       stack.nUTF8(pEntryPoint, true);
/* 51 */       long pEntryPointEncoded = stack.getPointerAddress();
/* 52 */       nglSpecializeShaderARB(shader, pEntryPointEncoded, pConstantIndex.remaining(), MemoryUtil.memAddress(pConstantIndex), MemoryUtil.memAddress(pConstantValue));
/*    */     } finally {
/* 54 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glSpecializeShaderARB(@NativeType("GLuint") int shader, @NativeType("GLchar const *") ByteBuffer pEntryPoint, @NativeType("GLuint const *") int[] pConstantIndex, @NativeType("GLuint const *") int[] pConstantValue) {
/* 60 */     long __functionAddress = (GL.getICD()).glSpecializeShaderARB;
/* 61 */     if (Checks.CHECKS) {
/* 62 */       Checks.check(__functionAddress);
/* 63 */       Checks.checkNT1(pEntryPoint);
/* 64 */       Checks.check(pConstantValue, pConstantIndex.length);
/*    */     } 
/* 66 */     JNI.callPPPV(shader, MemoryUtil.memAddress(pEntryPoint), pConstantIndex.length, pConstantIndex, pConstantValue, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glSpecializeShaderARB(@NativeType("GLuint") int shader, @NativeType("GLchar const *") CharSequence pEntryPoint, @NativeType("GLuint const *") int[] pConstantIndex, @NativeType("GLuint const *") int[] pConstantValue) {
/* 71 */     long __functionAddress = (GL.getICD()).glSpecializeShaderARB;
/* 72 */     if (Checks.CHECKS) {
/* 73 */       Checks.check(__functionAddress);
/* 74 */       Checks.check(pConstantValue, pConstantIndex.length);
/*    */     } 
/* 76 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 78 */       stack.nUTF8(pEntryPoint, true);
/* 79 */       long pEntryPointEncoded = stack.getPointerAddress();
/* 80 */       JNI.callPPPV(shader, pEntryPointEncoded, pConstantIndex.length, pConstantIndex, pConstantValue, __functionAddress);
/*    */     } finally {
/* 82 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native void nglSpecializeShaderARB(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBGLSPIRV.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */