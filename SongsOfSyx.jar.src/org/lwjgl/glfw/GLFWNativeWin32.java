/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.FunctionProvider;
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
/*    */ public class GLFWNativeWin32
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 26 */     public static final long GetWin32Adapter = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWin32Adapter");
/* 27 */     public static final long GetWin32Monitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWin32Monitor");
/* 28 */     public static final long GetWin32Window = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWin32Window");
/* 29 */     public static final long AttachWin32Window = APIUtil.apiGetFunctionAddressOptional(GLFW.getLibrary(), "glfwAttachWin32Window");
/*    */   }
/*    */ 
/*    */   
/*    */   protected GLFWNativeWin32() {
/* 34 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglfwGetWin32Adapter(long monitor) {
/* 41 */     long __functionAddress = Functions.GetWin32Adapter;
/* 42 */     if (Checks.CHECKS) {
/* 43 */       Checks.check(monitor);
/*    */     }
/* 45 */     return JNI.invokePP(monitor, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("char const *")
/*    */   public static String glfwGetWin32Adapter(@NativeType("GLFWmonitor *") long monitor) {
/* 51 */     long __result = nglfwGetWin32Adapter(monitor);
/* 52 */     return MemoryUtil.memUTF8Safe(__result);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglfwGetWin32Monitor(long monitor) {
/* 59 */     long __functionAddress = Functions.GetWin32Monitor;
/* 60 */     if (Checks.CHECKS) {
/* 61 */       Checks.check(monitor);
/*    */     }
/* 63 */     return JNI.invokePP(monitor, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("char const *")
/*    */   public static String glfwGetWin32Monitor(@NativeType("GLFWmonitor *") long monitor) {
/* 69 */     long __result = nglfwGetWin32Monitor(monitor);
/* 70 */     return MemoryUtil.memUTF8Safe(__result);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("HWND")
/*    */   public static long glfwGetWin32Window(@NativeType("GLFWwindow *") long window) {
/* 78 */     long __functionAddress = Functions.GetWin32Window;
/* 79 */     if (Checks.CHECKS) {
/* 80 */       Checks.check(window);
/*    */     }
/* 82 */     return JNI.invokePP(window, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLFWwindow *")
/*    */   public static long glfwAttachWin32Window(@NativeType("HWND") long handle, @NativeType("GLFWwindow *") long share) {
/* 90 */     long __functionAddress = Functions.AttachWin32Window;
/* 91 */     if (Checks.CHECKS) {
/* 92 */       Checks.check(__functionAddress);
/* 93 */       Checks.check(handle);
/*    */     } 
/* 95 */     return JNI.invokePPP(handle, share, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWNativeWin32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */