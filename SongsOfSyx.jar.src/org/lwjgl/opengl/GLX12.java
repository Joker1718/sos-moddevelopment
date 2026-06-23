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
/*    */ public class GLX12
/*    */   extends GLX11
/*    */ {
/*    */   protected GLX12() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("Display *")
/*    */   public static long glXGetCurrentDisplay() {
/* 24 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetCurrentDisplay;
/* 25 */     if (Checks.CHECKS) {
/* 26 */       Checks.check(__functionAddress);
/*    */     }
/* 28 */     return JNI.callP(__functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLX12.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */