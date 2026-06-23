/*    */ package org.lwjgl.opengl;
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
/*    */ public class GLX14
/*    */   extends GLX13
/*    */ {
/*    */   public static final int GLX_SAMPLE_BUFFERS = 100000;
/*    */   public static final int GLX_SAMPLES = 100001;
/*    */   
/*    */   protected GLX14() {
/* 24 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglXGetProcAddress(long procName) {
/* 31 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetProcAddress;
/* 32 */     if (Checks.CHECKS) {
/* 33 */       Checks.check(__functionAddress);
/*    */     }
/* 35 */     return JNI.callPP(procName, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void *")
/*    */   public static long glXGetProcAddress(@NativeType("GLchar const *") ByteBuffer procName) {
/* 41 */     if (Checks.CHECKS) {
/* 42 */       Checks.checkNT1(procName);
/*    */     }
/* 44 */     return nglXGetProcAddress(MemoryUtil.memAddress(procName));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void *")
/*    */   public static long glXGetProcAddress(@NativeType("GLchar const *") CharSequence procName) {
/* 50 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 52 */       stack.nASCII(procName, true);
/* 53 */       long procNameEncoded = stack.getPointerAddress();
/* 54 */       return nglXGetProcAddress(procNameEncoded);
/*    */     } finally {
/* 56 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLX14.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */