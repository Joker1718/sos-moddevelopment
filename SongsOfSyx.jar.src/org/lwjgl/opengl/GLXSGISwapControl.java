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
/*    */ public class GLXSGISwapControl
/*    */ {
/*    */   protected GLXSGISwapControl() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glXSwapIntervalSGI(int interval) {
/* 24 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXSwapIntervalSGI;
/* 25 */     if (Checks.CHECKS) {
/* 26 */       Checks.check(__functionAddress);
/*    */     }
/* 28 */     return JNI.callI(interval, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXSGISwapControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */