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
/*    */ public class GLFWNativeCocoa
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 23 */     public static final long GetCocoaMonitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetCocoaMonitor");
/* 24 */     public static final long GetCocoaWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetCocoaWindow");
/* 25 */     public static final long GetCocoaView = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetCocoaView");
/*    */   }
/*    */ 
/*    */   
/*    */   protected GLFWNativeCocoa() {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("CGDirectDisplayID")
/*    */   public static int glfwGetCocoaMonitor(@NativeType("GLFWmonitor *") long monitor) {
/* 38 */     long __functionAddress = Functions.GetCocoaMonitor;
/* 39 */     if (Checks.CHECKS) {
/* 40 */       Checks.check(monitor);
/*    */     }
/* 42 */     return JNI.invokePI(monitor, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("id")
/*    */   public static long glfwGetCocoaWindow(@NativeType("GLFWwindow *") long window) {
/* 50 */     long __functionAddress = Functions.GetCocoaWindow;
/* 51 */     if (Checks.CHECKS) {
/* 52 */       Checks.check(window);
/*    */     }
/* 54 */     return JNI.invokePP(window, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("id")
/*    */   public static long glfwGetCocoaView(@NativeType("GLFWwindow *") long window) {
/* 62 */     long __functionAddress = Functions.GetCocoaView;
/* 63 */     if (Checks.CHECKS) {
/* 64 */       Checks.check(window);
/*    */     }
/* 66 */     return JNI.invokePP(window, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWNativeCocoa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */