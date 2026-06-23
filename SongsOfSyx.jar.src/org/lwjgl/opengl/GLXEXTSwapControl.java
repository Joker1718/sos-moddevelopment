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
/*    */ public class GLXEXTSwapControl
/*    */ {
/*    */   public static final int GLX_SWAP_INTERVAL_EXT = 8433;
/*    */   public static final int GLX_MAX_SWAP_INTERVAL_EXT = 8434;
/*    */   
/*    */   protected GLXEXTSwapControl() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glXSwapIntervalEXT(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, int interval) {
/* 27 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXSwapIntervalEXT;
/* 28 */     if (Checks.CHECKS) {
/* 29 */       Checks.check(__functionAddress);
/* 30 */       Checks.check(display);
/* 31 */       Checks.check(drawable);
/*    */     } 
/* 33 */     JNI.callPPV(display, drawable, interval, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXEXTSwapControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */