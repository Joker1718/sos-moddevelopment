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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WGLARBCreateContext
/*    */ {
/*    */   public static final int WGL_CONTEXT_MAJOR_VERSION_ARB = 8337;
/*    */   public static final int WGL_CONTEXT_MINOR_VERSION_ARB = 8338;
/*    */   public static final int WGL_CONTEXT_LAYER_PLANE_ARB = 8339;
/*    */   public static final int WGL_CONTEXT_FLAGS_ARB = 8340;
/*    */   public static final int WGL_CONTEXT_DEBUG_BIT_ARB = 1;
/*    */   public static final int WGL_CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;
/*    */   public static final int ERROR_INVALID_VERSION_ARB = 8341;
/*    */   
/*    */   protected WGLARBCreateContext() {
/* 33 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nwglCreateContextAttribsARB(long hdc, long shareContext, long attribList) {
/* 40 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglCreateContextAttribsARB;
/* 41 */     if (Checks.CHECKS) {
/* 42 */       Checks.check(__functionAddress);
/* 43 */       Checks.check(hdc);
/*    */     } 
/* 45 */     return JNI.callPPPP(hdc, shareContext, attribList, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("HGLRC")
/*    */   public static long wglCreateContextAttribsARB(@NativeType("HDC") long hdc, @NativeType("HGLRC") long shareContext, @NativeType("int const *") IntBuffer attribList) {
/* 51 */     if (Checks.CHECKS) {
/* 52 */       Checks.checkNTSafe(attribList);
/*    */     }
/* 54 */     return nwglCreateContextAttribsARB(hdc, shareContext, MemoryUtil.memAddressSafe(attribList));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("HGLRC")
/*    */   public static long wglCreateContextAttribsARB(@NativeType("HDC") long hdc, @NativeType("HGLRC") long shareContext, @NativeType("int const *") int[] attribList) {
/* 60 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglCreateContextAttribsARB;
/* 61 */     if (Checks.CHECKS) {
/* 62 */       Checks.check(__functionAddress);
/* 63 */       Checks.check(hdc);
/* 64 */       Checks.checkNTSafe(attribList);
/*    */     } 
/* 66 */     return JNI.callPPPP(hdc, shareContext, attribList, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLARBCreateContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */