/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
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
/*    */ public final class Callbacks
/*    */ {
/*    */   public static void glfwFreeCallbacks(@NativeType("GLFWwindow *") long window) {
/* 30 */     if (Checks.CHECKS) {
/* 31 */       Checks.check(window);
/*    */     }
/*    */     
/* 34 */     for (long callback : new long[] { GLFW.Functions.SetWindowPosCallback, GLFW.Functions.SetWindowSizeCallback, GLFW.Functions.SetWindowCloseCallback, GLFW.Functions.SetWindowRefreshCallback, GLFW.Functions.SetWindowFocusCallback, GLFW.Functions.SetWindowIconifyCallback, GLFW.Functions.SetWindowMaximizeCallback, GLFW.Functions.SetFramebufferSizeCallback, GLFW.Functions.SetWindowContentScaleCallback, GLFW.Functions.SetKeyCallback, GLFW.Functions.SetCharCallback, GLFW.Functions.SetCharModsCallback, GLFW.Functions.SetMouseButtonCallback, GLFW.Functions.SetCursorPosCallback, GLFW.Functions.SetCursorEnterCallback, GLFW.Functions.SetScrollCallback, GLFW.Functions.SetDropCallback }) {
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
/*    */ 
/*    */       
/* 53 */       long prevCB = JNI.invokePPP(window, 0L, callback);
/* 54 */       if (prevCB != 0L)
/* 55 */         Callback.free(prevCB); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\Callbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */