/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
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
/*    */ public class GLXSGIXSwapBarrier
/*    */ {
/*    */   protected GLXSGIXSwapBarrier() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glXBindSwapBarrierSGIX(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, int barrier) {
/* 26 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXBindSwapBarrierSGIX;
/* 27 */     if (Checks.CHECKS) {
/* 28 */       Checks.check(__functionAddress);
/* 29 */       Checks.check(display);
/* 30 */       Checks.check(drawable);
/*    */     } 
/* 32 */     JNI.callPPV(display, drawable, barrier, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int nglXQueryMaxSwapBarriersSGIX(long display, int screen, long max) {
/* 39 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryMaxSwapBarriersSGIX;
/* 40 */     if (Checks.CHECKS) {
/* 41 */       Checks.check(__functionAddress);
/* 42 */       Checks.check(display);
/*    */     } 
/* 44 */     return JNI.callPPI(display, screen, max, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("Bool")
/*    */   public static boolean glXQueryMaxSwapBarriersSGIX(@NativeType("Display *") long display, int screen, @NativeType("int *") IntBuffer max) {
/* 50 */     if (Checks.CHECKS) {
/* 51 */       Checks.check(max, 1);
/*    */     }
/* 53 */     return (nglXQueryMaxSwapBarriersSGIX(display, screen, MemoryUtil.memAddress(max)) != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("Bool")
/*    */   public static boolean glXQueryMaxSwapBarriersSGIX(@NativeType("Display *") long display, int screen, @NativeType("int *") int[] max) {
/* 59 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryMaxSwapBarriersSGIX;
/* 60 */     if (Checks.CHECKS) {
/* 61 */       Checks.check(__functionAddress);
/* 62 */       Checks.check(display);
/* 63 */       Checks.check(max, 1);
/*    */     } 
/* 65 */     return (JNI.callPPI(display, screen, max, __functionAddress) != 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXSGIXSwapBarrier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */