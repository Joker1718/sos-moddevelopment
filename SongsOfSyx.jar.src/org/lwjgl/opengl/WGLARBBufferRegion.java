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
/*    */ public class WGLARBBufferRegion
/*    */ {
/*    */   public static final int WGL_FRONT_COLOR_BUFFER_BIT_ARB = 1;
/*    */   public static final int WGL_BACK_COLOR_BUFFER_BIT_ARB = 2;
/*    */   public static final int WGL_DEPTH_BUFFER_BIT_ARB = 4;
/*    */   public static final int WGL_STENCIL_BUFFER_BIT_ARB = 8;
/*    */   
/*    */   protected WGLARBBufferRegion() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("HANDLE")
/*    */   public static long wglCreateBufferRegionARB(@NativeType("HDC") long hdc, int layerPlane, @NativeType("UINT") int type) {
/* 30 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglCreateBufferRegionARB;
/* 31 */     if (Checks.CHECKS) {
/* 32 */       Checks.check(__functionAddress);
/* 33 */       Checks.check(hdc);
/*    */     } 
/* 35 */     return JNI.callPP(hdc, layerPlane, type, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("VOID")
/*    */   public static void wglDeleteBufferRegionARB(@NativeType("HANDLE") long region) {
/* 43 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDeleteBufferRegionARB;
/* 44 */     if (Checks.CHECKS) {
/* 45 */       Checks.check(__functionAddress);
/* 46 */       Checks.check(region);
/*    */     } 
/* 48 */     JNI.callPV(region, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("BOOL")
/*    */   public static boolean wglSaveBufferRegionARB(@NativeType("HANDLE") long region, int x, int y, int width, int height) {
/* 56 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglSaveBufferRegionARB;
/* 57 */     if (Checks.CHECKS) {
/* 58 */       Checks.check(__functionAddress);
/* 59 */       Checks.check(region);
/*    */     } 
/* 61 */     return (JNI.callPI(region, x, y, width, height, __functionAddress) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("BOOL")
/*    */   public static boolean wglRestoreBufferRegionARB(@NativeType("HANDLE") long region, int x, int y, int width, int height, int xSrc, int ySrc) {
/* 69 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglRestoreBufferRegionARB;
/* 70 */     if (Checks.CHECKS) {
/* 71 */       Checks.check(__functionAddress);
/* 72 */       Checks.check(region);
/*    */     } 
/* 74 */     return (JNI.callPI(region, x, y, width, height, xSrc, ySrc, __functionAddress) != 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLARBBufferRegion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */