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
/*    */ 
/*    */ public class WGLNVDelayBeforeSwap
/*    */ {
/*    */   protected WGLNVDelayBeforeSwap() {
/* 18 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("BOOL")
/*    */   public static boolean wglDelayBeforeSwapNV(@NativeType("HDC") long hDC, @NativeType("GLfloat") float seconds) {
/* 26 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDelayBeforeSwapNV;
/* 27 */     if (Checks.CHECKS) {
/* 28 */       Checks.check(__functionAddress);
/* 29 */       Checks.check(hDC);
/*    */     } 
/* 31 */     return (JNI.callPI(hDC, seconds, __functionAddress) != 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLNVDelayBeforeSwap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */