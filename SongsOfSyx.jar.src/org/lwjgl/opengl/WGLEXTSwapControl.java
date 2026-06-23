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
/*    */ public class WGLEXTSwapControl
/*    */ {
/*    */   protected WGLEXTSwapControl() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("BOOL")
/*    */   public static boolean wglSwapIntervalEXT(int interval) {
/* 24 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglSwapIntervalEXT;
/* 25 */     if (Checks.CHECKS) {
/* 26 */       Checks.check(__functionAddress);
/*    */     }
/* 28 */     return (JNI.callI(interval, __functionAddress) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int wglGetSwapIntervalEXT() {
/* 35 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetSwapIntervalEXT;
/* 36 */     if (Checks.CHECKS) {
/* 37 */       Checks.check(__functionAddress);
/*    */     }
/* 39 */     return JNI.callI(__functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLEXTSwapControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */