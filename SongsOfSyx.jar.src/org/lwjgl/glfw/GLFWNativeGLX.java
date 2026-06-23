/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLFWNativeGLX
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  30 */     public static final long GetGLXContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetGLXContext");
/*  31 */     public static final long GetGLXWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetGLXWindow");
/*  32 */     public static final long GetGLXFBConfig = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetGLXFBConfig");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeGLX() {
/*  37 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glfwGetGLXContext(@NativeType("GLFWwindow *") long window) {
/*  45 */     long __functionAddress = Functions.GetGLXContext;
/*  46 */     if (Checks.CHECKS) {
/*  47 */       Checks.check(window);
/*     */     }
/*  49 */     return JNI.invokePP(window, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXWindow")
/*     */   public static long glfwGetGLXWindow(@NativeType("GLFWwindow *") long window) {
/*  57 */     long __functionAddress = Functions.GetGLXWindow;
/*  58 */     if (Checks.CHECKS) {
/*  59 */       Checks.check(window);
/*     */     }
/*  61 */     return JNI.invokePP(window, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglfwGetGLXFBConfig(long window, long config) {
/*  68 */     long __functionAddress = Functions.GetGLXFBConfig;
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.check(window);
/*     */     }
/*  72 */     return JNI.invokePPI(window, config, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean glfwGetGLXFBConfig(@NativeType("GLFWwindow *") long window, @NativeType("GLXFBConfig *") PointerBuffer config) {
/*  78 */     if (Checks.CHECKS) {
/*  79 */       Checks.check((CustomBuffer)config, 1);
/*     */     }
/*  81 */     return (nglfwGetGLXFBConfig(window, MemoryUtil.memAddress((CustomBuffer)config)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setPath(FunctionProvider sharedLibrary) {
/*  92 */     if (!(sharedLibrary instanceof SharedLibrary)) {
/*  93 */       APIUtil.apiLog("GLFW OpenGL path override not set: Function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/*  97 */     String path = ((SharedLibrary)sharedLibrary).getPath();
/*  98 */     if (path == null) {
/*  99 */       APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve the shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 104 */     setPath(path);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setPath(String path) {
/* 118 */     long override = GLFW.getLibrary().getFunctionAddress("_glfw_opengl_library");
/* 119 */     if (override == 0L) {
/* 120 */       APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve override symbol.");
/*     */       
/*     */       return;
/*     */     } 
/* 124 */     long a = MemoryUtil.memGetAddress(override);
/* 125 */     if (a != 0L) {
/* 126 */       MemoryUtil.nmemFree(a);
/*     */     }
/* 128 */     MemoryUtil.memPutAddress(override, (path == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(path)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWNativeGLX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */