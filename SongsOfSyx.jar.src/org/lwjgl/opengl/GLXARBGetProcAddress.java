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
/*    */ public class GLXARBGetProcAddress
/*    */ {
/*    */   protected GLXARBGetProcAddress() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglXGetProcAddressARB(long procName) {
/* 27 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetProcAddressARB;
/* 28 */     if (Checks.CHECKS) {
/* 29 */       Checks.check(__functionAddress);
/*    */     }
/* 31 */     return JNI.callPP(procName, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void *")
/*    */   public static long glXGetProcAddressARB(@NativeType("GLchar const *") ByteBuffer procName) {
/* 37 */     if (Checks.CHECKS) {
/* 38 */       Checks.checkNT1(procName);
/*    */     }
/* 40 */     return nglXGetProcAddressARB(MemoryUtil.memAddress(procName));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void *")
/*    */   public static long glXGetProcAddressARB(@NativeType("GLchar const *") CharSequence procName) {
/* 46 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 48 */       stack.nASCII(procName, true);
/* 49 */       long procNameEncoded = stack.getPointerAddress();
/* 50 */       return nglXGetProcAddressARB(procNameEncoded);
/*    */     } finally {
/* 52 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXARBGetProcAddress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */