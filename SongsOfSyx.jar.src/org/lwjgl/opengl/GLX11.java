/*    */ package org.lwjgl.opengl;
/*    */ 
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
/*    */ public class GLX11
/*    */   extends GLX
/*    */ {
/*    */   public static final int GLX_VENDOR = 1;
/*    */   public static final int GLX_VERSION = 2;
/*    */   public static final int GLX_EXTENSIONS = 3;
/*    */   
/*    */   protected GLX11() {
/* 24 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglXQueryExtensionsString(long display, int screen) {
/* 31 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryExtensionsString;
/* 32 */     if (Checks.CHECKS) {
/* 33 */       Checks.check(__functionAddress);
/* 34 */       Checks.check(display);
/*    */     } 
/* 36 */     return JNI.callPP(display, screen, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("char const *")
/*    */   public static String glXQueryExtensionsString(@NativeType("Display *") long display, int screen) {
/* 42 */     long __result = nglXQueryExtensionsString(display, screen);
/* 43 */     return MemoryUtil.memASCIISafe(__result);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglXGetClientString(long display, int name) {
/* 50 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetClientString;
/* 51 */     if (Checks.CHECKS) {
/* 52 */       Checks.check(__functionAddress);
/* 53 */       Checks.check(display);
/*    */     } 
/* 55 */     return JNI.callPP(display, name, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("char const *")
/*    */   public static String glXGetClientString(@NativeType("Display *") long display, int name) {
/* 61 */     long __result = nglXGetClientString(display, name);
/* 62 */     return MemoryUtil.memASCIISafe(__result);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglXQueryServerString(long display, int screen, int name) {
/* 69 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryServerString;
/* 70 */     if (Checks.CHECKS) {
/* 71 */       Checks.check(__functionAddress);
/* 72 */       Checks.check(display);
/*    */     } 
/* 74 */     return JNI.callPP(display, screen, name, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("char const *")
/*    */   public static String glXQueryServerString(@NativeType("Display *") long display, int screen, int name) {
/* 80 */     long __result = nglXQueryServerString(display, screen, name);
/* 81 */     return MemoryUtil.memASCIISafe(__result);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLX11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */