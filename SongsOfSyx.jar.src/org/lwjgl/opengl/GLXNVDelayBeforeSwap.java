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
/*    */ public class GLXNVDelayBeforeSwap
/*    */ {
/*    */   protected GLXNVDelayBeforeSwap() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("Bool")
/*    */   public static boolean glXDelayBeforeSwapNV(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, @NativeType("GLfloat") float seconds) {
/* 24 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXDelayBeforeSwapNV;
/* 25 */     if (Checks.CHECKS) {
/* 26 */       Checks.check(__functionAddress);
/* 27 */       Checks.check(display);
/* 28 */       Checks.check(drawable);
/*    */     } 
/* 30 */     return (JNI.callPPI(display, drawable, seconds, __functionAddress) != 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXNVDelayBeforeSwap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */