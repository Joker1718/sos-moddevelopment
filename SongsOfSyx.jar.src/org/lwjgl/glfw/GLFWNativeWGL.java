/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.FunctionProvider;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ import org.lwjgl.system.SharedLibrary;
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
/*    */ public class GLFWNativeWGL
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 27 */     public static final long GetWGLContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWGLContext");
/*    */   }
/*    */ 
/*    */   
/*    */   protected GLFWNativeWGL() {
/* 32 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("HGLRC")
/*    */   public static long glfwGetWGLContext(@NativeType("GLFWwindow *") long window) {
/* 40 */     long __functionAddress = Functions.GetWGLContext;
/* 41 */     if (Checks.CHECKS) {
/* 42 */       Checks.check(window);
/*    */     }
/* 44 */     return JNI.invokePP(window, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setPath(FunctionProvider sharedLibrary) {
/* 55 */     if (!(sharedLibrary instanceof SharedLibrary)) {
/* 56 */       APIUtil.apiLog("GLFW OpenGL path override not set: Function provider is not a shared library.");
/*    */       
/*    */       return;
/*    */     } 
/* 60 */     String path = ((SharedLibrary)sharedLibrary).getPath();
/* 61 */     if (path == null) {
/* 62 */       APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve the shared library path.");
/*    */       
/*    */       return;
/*    */     } 
/* 66 */     setPath(path);
/*    */   }
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
/*    */   public static void setPath(String path) {
/* 80 */     long override = GLFW.getLibrary().getFunctionAddress("_glfw_opengl_library");
/* 81 */     if (override == 0L) {
/* 82 */       APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve override symbol.");
/*    */       
/*    */       return;
/*    */     } 
/* 86 */     long a = MemoryUtil.memGetAddress(override);
/* 87 */     if (a != 0L) {
/* 88 */       MemoryUtil.nmemFree(a);
/*    */     }
/* 90 */     MemoryUtil.memPutAddress(override, (path == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(path)));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWNativeWGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */