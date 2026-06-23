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
/*    */ public class WGLEXTExtensionsString
/*    */ {
/*    */   protected WGLEXTExtensionsString() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nwglGetExtensionsStringEXT() {
/* 26 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetExtensionsStringEXT;
/* 27 */     if (Checks.CHECKS) {
/* 28 */       Checks.check(__functionAddress);
/*    */     }
/* 30 */     return JNI.callP(__functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("char const *")
/*    */   public static String wglGetExtensionsStringEXT() {
/* 36 */     long __result = nwglGetExtensionsStringEXT();
/* 37 */     return MemoryUtil.memASCIISafe(__result);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLEXTExtensionsString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */