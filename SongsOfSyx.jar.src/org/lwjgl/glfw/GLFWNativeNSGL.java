/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.FunctionProvider;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GLFWNativeNSGL
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 28 */     public static final long GetNSGLContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetNSGLContext");
/*    */   }
/*    */ 
/*    */   
/*    */   protected GLFWNativeNSGL() {
/* 33 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("id")
/*    */   public static long glfwGetNSGLContext(@NativeType("GLFWwindow *") long window) {
/* 41 */     long __functionAddress = Functions.GetNSGLContext;
/* 42 */     if (Checks.CHECKS) {
/* 43 */       Checks.check(window);
/*    */     }
/* 45 */     return JNI.invokePP(window, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWNativeNSGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */