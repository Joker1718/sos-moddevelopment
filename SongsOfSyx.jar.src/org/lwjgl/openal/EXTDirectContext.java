/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTDirectContext
/*    */ {
/*    */   protected EXTDirectContext() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nalcGetProcAddress2(long device, long funcName) {
/* 27 */     long __functionAddress = (ALC.getICD()).alcGetProcAddress2;
/* 28 */     if (Checks.CHECKS) {
/* 29 */       Checks.check(__functionAddress);
/*    */     }
/* 31 */     return JNI.invokePPP(device, funcName, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCvoid *")
/*    */   public static long alcGetProcAddress2(@NativeType("ALCdevice *") long device, @NativeType("ALchar const *") ByteBuffer funcName) {
/* 37 */     if (Checks.CHECKS) {
/* 38 */       Checks.checkNT1(funcName);
/*    */     }
/* 40 */     return nalcGetProcAddress2(device, MemoryUtil.memAddress(funcName));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCvoid *")
/*    */   public static long alcGetProcAddress2(@NativeType("ALCdevice *") long device, @NativeType("ALchar const *") CharSequence funcName) {
/* 46 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 48 */       stack.nASCII(funcName, true);
/* 49 */       long funcNameEncoded = stack.getPointerAddress();
/* 50 */       return nalcGetProcAddress2(device, funcNameEncoded);
/*    */     } finally {
/* 52 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\EXTDirectContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */