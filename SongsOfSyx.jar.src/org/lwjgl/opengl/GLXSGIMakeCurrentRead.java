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
/*    */ public class GLXSGIMakeCurrentRead
/*    */ {
/*    */   protected GLXSGIMakeCurrentRead() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("Bool")
/*    */   public static boolean glXMakeCurrentReadSGI(@NativeType("Display *") long display, @NativeType("GLXDrawable") long draw, @NativeType("GLXDrawable") long read, @NativeType("GLXContext") long ctx) {
/* 24 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXMakeCurrentReadSGI;
/* 25 */     if (Checks.CHECKS) {
/* 26 */       Checks.check(__functionAddress);
/* 27 */       Checks.check(display);
/*    */     } 
/* 29 */     return (JNI.callPPPPI(display, draw, read, ctx, __functionAddress) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLXDrawable")
/*    */   public static long glXGetCurrentReadDrawableSGI() {
/* 37 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetCurrentReadDrawableSGI;
/* 38 */     if (Checks.CHECKS) {
/* 39 */       Checks.check(__functionAddress);
/*    */     }
/* 41 */     return JNI.callP(__functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXSGIMakeCurrentRead.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */