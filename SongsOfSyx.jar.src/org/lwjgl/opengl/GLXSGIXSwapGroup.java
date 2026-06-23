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
/*    */ public class GLXSGIXSwapGroup
/*    */ {
/*    */   protected GLXSGIXSwapGroup() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glXJoinSwapGroupSGIX(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, @NativeType("GLXDrawable") long member) {
/* 23 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXJoinSwapGroupSGIX;
/* 24 */     if (Checks.CHECKS) {
/* 25 */       Checks.check(__functionAddress);
/* 26 */       Checks.check(display);
/* 27 */       Checks.check(drawable);
/*    */     } 
/* 29 */     JNI.callPPPV(display, drawable, member, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXSGIXSwapGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */