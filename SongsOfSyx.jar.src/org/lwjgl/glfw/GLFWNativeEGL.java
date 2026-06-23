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
/*     */ public class GLFWNativeEGL
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  30 */     public static final long GetEGLDisplay = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetEGLDisplay");
/*  31 */     public static final long GetEGLContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetEGLContext");
/*  32 */     public static final long GetEGLSurface = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetEGLSurface");
/*  33 */     public static final long GetEGLConfig = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetEGLConfig");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeEGL() {
/*  38 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("EGLDisplay")
/*     */   public static long glfwGetEGLDisplay() {
/*  46 */     long __functionAddress = Functions.GetEGLDisplay;
/*  47 */     return JNI.invokeP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("EGLContext")
/*     */   public static long glfwGetEGLContext(@NativeType("GLFWwindow *") long window) {
/*  55 */     long __functionAddress = Functions.GetEGLContext;
/*  56 */     if (Checks.CHECKS) {
/*  57 */       Checks.check(window);
/*     */     }
/*  59 */     return JNI.invokePP(window, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("EGLSurface")
/*     */   public static long glfwGetEGLSurface(@NativeType("GLFWwindow *") long window) {
/*  67 */     long __functionAddress = Functions.GetEGLSurface;
/*  68 */     if (Checks.CHECKS) {
/*  69 */       Checks.check(window);
/*     */     }
/*  71 */     return JNI.invokePP(window, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglfwGetEGLConfig(long window, long config) {
/*  78 */     long __functionAddress = Functions.GetEGLConfig;
/*  79 */     if (Checks.CHECKS) {
/*  80 */       Checks.check(window);
/*     */     }
/*  82 */     return JNI.invokePPI(window, config, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean glfwGetEGLConfig(@NativeType("GLFWwindow *") long window, @NativeType("EGLConfig *") PointerBuffer config) {
/*  88 */     if (Checks.CHECKS) {
/*  89 */       Checks.check((CustomBuffer)config, 1);
/*     */     }
/*  91 */     return (nglfwGetEGLConfig(window, MemoryUtil.memAddress((CustomBuffer)config)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setEGLPath(FunctionProvider sharedLibrary) {
/* 102 */     if (!(sharedLibrary instanceof SharedLibrary)) {
/* 103 */       APIUtil.apiLog("GLFW EGL path override not set: Function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/* 107 */     String path = ((SharedLibrary)sharedLibrary).getPath();
/* 108 */     if (path == null) {
/* 109 */       APIUtil.apiLog("GLFW EGL path override not set: Could not resolve the shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 114 */     setEGLPath(path);
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
/*     */   public static void setEGLPath(String path) {
/* 128 */     if (!override("_glfw_egl_library", path)) {
/* 129 */       APIUtil.apiLog("GLFW EGL path override not set: Could not resolve override symbol.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setGLESPath(FunctionProvider sharedLibrary) {
/* 141 */     if (!(sharedLibrary instanceof SharedLibrary)) {
/* 142 */       APIUtil.apiLog("GLFW OpenGL ES path override not set: Function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/* 146 */     String path = ((SharedLibrary)sharedLibrary).getPath();
/* 147 */     if (path == null) {
/* 148 */       APIUtil.apiLog("GLFW OpenGL ES path override not set: Could not resolve the shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 153 */     setGLESPath(path);
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
/*     */   public static void setGLESPath(String path) {
/* 167 */     if (!override("_glfw_opengles_library", path)) {
/* 168 */       APIUtil.apiLog("GLFW OpenGL ES path override not set: Could not resolve override symbol.");
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean override(String symbol, String path) {
/* 173 */     long override = GLFW.getLibrary().getFunctionAddress(symbol);
/* 174 */     if (override == 0L) {
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     long a = MemoryUtil.memGetAddress(override);
/* 179 */     if (a != 0L) {
/* 180 */       MemoryUtil.nmemFree(a);
/*     */     }
/* 182 */     MemoryUtil.memPutAddress(override, (path == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(path)));
/* 183 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWNativeEGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */