/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
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
/*     */ 
/*     */ 
/*     */ public class GLFWNativeOSMesa
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  34 */     public static final long GetOSMesaColorBuffer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetOSMesaColorBuffer");
/*  35 */     public static final long GetOSMesaDepthBuffer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetOSMesaDepthBuffer");
/*  36 */     public static final long GetOSMesaContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetOSMesaContext");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeOSMesa() {
/*  41 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglfwGetOSMesaColorBuffer(long window, long width, long height, long format, long buffer) {
/*  48 */     long __functionAddress = Functions.GetOSMesaColorBuffer;
/*  49 */     if (Checks.CHECKS) {
/*  50 */       Checks.check(window);
/*     */     }
/*  52 */     return JNI.invokePPPPPI(window, width, height, format, buffer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean glfwGetOSMesaColorBuffer(@NativeType("GLFWwindow *") long window, @NativeType("int *") IntBuffer width, @NativeType("int *") IntBuffer height, @NativeType("int *") IntBuffer format, @NativeType("void **") PointerBuffer buffer) {
/*  58 */     if (Checks.CHECKS) {
/*  59 */       Checks.checkSafe(width, 1);
/*  60 */       Checks.checkSafe(height, 1);
/*  61 */       Checks.checkSafe(format, 1);
/*  62 */       Checks.checkSafe((CustomBuffer)buffer, 1);
/*     */     } 
/*  64 */     return (nglfwGetOSMesaColorBuffer(window, MemoryUtil.memAddressSafe(width), MemoryUtil.memAddressSafe(height), MemoryUtil.memAddressSafe(format), MemoryUtil.memAddressSafe((Pointer)buffer)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglfwGetOSMesaDepthBuffer(long window, long width, long height, long bytesPerValue, long buffer) {
/*  71 */     long __functionAddress = Functions.GetOSMesaDepthBuffer;
/*  72 */     if (Checks.CHECKS) {
/*  73 */       Checks.check(window);
/*     */     }
/*  75 */     return JNI.invokePPPPPI(window, width, height, bytesPerValue, buffer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glfwGetOSMesaDepthBuffer(@NativeType("GLFWwindow *") long window, @NativeType("int *") IntBuffer width, @NativeType("int *") IntBuffer height, @NativeType("int *") IntBuffer bytesPerValue, @NativeType("void **") PointerBuffer buffer) {
/*  80 */     if (Checks.CHECKS) {
/*  81 */       Checks.checkSafe(width, 1);
/*  82 */       Checks.checkSafe(height, 1);
/*  83 */       Checks.checkSafe(bytesPerValue, 1);
/*  84 */       Checks.checkSafe((CustomBuffer)buffer, 1);
/*     */     } 
/*  86 */     return nglfwGetOSMesaDepthBuffer(window, MemoryUtil.memAddressSafe(width), MemoryUtil.memAddressSafe(height), MemoryUtil.memAddressSafe(bytesPerValue), MemoryUtil.memAddressSafe((Pointer)buffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("OSMesaContext")
/*     */   public static long glfwGetOSMesaContext(@NativeType("GLFWwindow *") long window) {
/*  94 */     long __functionAddress = Functions.GetOSMesaContext;
/*  95 */     if (Checks.CHECKS) {
/*  96 */       Checks.check(window);
/*     */     }
/*  98 */     return JNI.invokePP(window, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean glfwGetOSMesaColorBuffer(@NativeType("GLFWwindow *") long window, @NativeType("int *") int[] width, @NativeType("int *") int[] height, @NativeType("int *") int[] format, @NativeType("void **") PointerBuffer buffer) {
/* 104 */     long __functionAddress = Functions.GetOSMesaColorBuffer;
/* 105 */     if (Checks.CHECKS) {
/* 106 */       Checks.check(window);
/* 107 */       Checks.checkSafe(width, 1);
/* 108 */       Checks.checkSafe(height, 1);
/* 109 */       Checks.checkSafe(format, 1);
/* 110 */       Checks.checkSafe((CustomBuffer)buffer, 1);
/*     */     } 
/* 112 */     return (JNI.invokePPPPPI(window, width, height, format, MemoryUtil.memAddressSafe((Pointer)buffer), __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glfwGetOSMesaDepthBuffer(@NativeType("GLFWwindow *") long window, @NativeType("int *") int[] width, @NativeType("int *") int[] height, @NativeType("int *") int[] bytesPerValue, @NativeType("void **") PointerBuffer buffer) {
/* 117 */     long __functionAddress = Functions.GetOSMesaDepthBuffer;
/* 118 */     if (Checks.CHECKS) {
/* 119 */       Checks.check(window);
/* 120 */       Checks.checkSafe(width, 1);
/* 121 */       Checks.checkSafe(height, 1);
/* 122 */       Checks.checkSafe(bytesPerValue, 1);
/* 123 */       Checks.checkSafe((CustomBuffer)buffer, 1);
/*     */     } 
/* 125 */     return JNI.invokePPPPPI(window, width, height, bytesPerValue, MemoryUtil.memAddressSafe((Pointer)buffer), __functionAddress);
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
/* 136 */     if (!(sharedLibrary instanceof SharedLibrary)) {
/* 137 */       APIUtil.apiLog("GLFW OSMesa path override not set: Function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/* 141 */     String path = ((SharedLibrary)sharedLibrary).getPath();
/* 142 */     if (path == null) {
/* 143 */       APIUtil.apiLog("GLFW OSMesa path override not set: Could not resolve the OSMesa shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/* 147 */     setPath(path);
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
/* 161 */     long override = GLFW.getLibrary().getFunctionAddress("_glfw_mesa_library");
/* 162 */     if (override == 0L) {
/* 163 */       APIUtil.apiLog("GLFW OSMesa path override not set: Could not resolve override symbol.");
/*     */       
/*     */       return;
/*     */     } 
/* 167 */     long a = MemoryUtil.memGetAddress(override);
/* 168 */     if (a != 0L) {
/* 169 */       MemoryUtil.nmemFree(a);
/*     */     }
/* 171 */     MemoryUtil.memPutAddress(override, (path == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(path)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWNativeOSMesa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */