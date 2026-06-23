/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WGLARBMakeCurrentRead
/*    */ {
/*    */   public static final int ERROR_INVALID_PIXEL_TYPE_ARB = 8259;
/*    */   public static final int ERROR_INCOMPATIBLE_DEVICE_CONTEXTS_ARB = 8276;
/*    */   
/*    */   protected WGLARBMakeCurrentRead() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("BOOL")
/*    */   public static boolean wglMakeContextCurrentARB(@NativeType("HDC") long drawDC, @NativeType("HDC") long readDC, @NativeType("HGLRC") long hglrc) {
/* 28 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglMakeContextCurrentARB;
/* 29 */     if (Checks.CHECKS) {
/* 30 */       Checks.check(__functionAddress);
/* 31 */       Checks.check(drawDC);
/* 32 */       Checks.check(readDC);
/* 33 */       Checks.check(hglrc);
/*    */     } 
/* 35 */     return (JNI.callPPPI(drawDC, readDC, hglrc, __functionAddress) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("HDC")
/*    */   public static long wglGetCurrentReadDCARB() {
/* 43 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetCurrentReadDCARB;
/* 44 */     if (Checks.CHECKS) {
/* 45 */       Checks.check(__functionAddress);
/*    */     }
/* 47 */     return JNI.callP(__functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLARBMakeCurrentRead.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */