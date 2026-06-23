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
/*    */ public class WGLARBExtensionsString
/*    */ {
/*    */   protected WGLARBExtensionsString() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nwglGetExtensionsStringARB(long hdc) {
/* 26 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetExtensionsStringARB;
/* 27 */     if (Checks.CHECKS) {
/* 28 */       Checks.check(__functionAddress);
/* 29 */       Checks.check(hdc);
/*    */     } 
/* 31 */     return JNI.callPP(hdc, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("char const *")
/*    */   public static String wglGetExtensionsStringARB(@NativeType("HDC") long hdc) {
/* 37 */     long __result = nwglGetExtensionsStringARB(hdc);
/* 38 */     return MemoryUtil.memASCIISafe(__result);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLARBExtensionsString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */