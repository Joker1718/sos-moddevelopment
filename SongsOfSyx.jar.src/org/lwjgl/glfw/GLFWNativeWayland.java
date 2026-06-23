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
/*    */ public class GLFWNativeWayland
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 23 */     public static final long GetWaylandDisplay = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWaylandDisplay");
/* 24 */     public static final long GetWaylandMonitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWaylandMonitor");
/* 25 */     public static final long GetWaylandWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWaylandWindow");
/*    */   }
/*    */ 
/*    */   
/*    */   protected GLFWNativeWayland() {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("struct wl_display *")
/*    */   public static long glfwGetWaylandDisplay() {
/* 38 */     long __functionAddress = Functions.GetWaylandDisplay;
/* 39 */     return JNI.invokeP(__functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("struct wl_output *")
/*    */   public static long glfwGetWaylandMonitor(@NativeType("GLFWmonitor *") long monitor) {
/* 47 */     long __functionAddress = Functions.GetWaylandMonitor;
/* 48 */     if (Checks.CHECKS) {
/* 49 */       Checks.check(monitor);
/*    */     }
/* 51 */     return JNI.invokePP(monitor, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("struct wl_surface *")
/*    */   public static long glfwGetWaylandWindow(@NativeType("GLFWwindow *") long window) {
/* 59 */     long __functionAddress = Functions.GetWaylandWindow;
/* 60 */     if (Checks.CHECKS) {
/* 61 */       Checks.check(window);
/*    */     }
/* 63 */     return JNI.invokePP(window, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWNativeWayland.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */