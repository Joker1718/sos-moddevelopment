/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
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
/*     */ public class GLFWNativeX11
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  29 */     public static final long GetX11Display = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11Display");
/*  30 */     public static final long GetX11Adapter = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11Adapter");
/*  31 */     public static final long GetX11Monitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11Monitor");
/*  32 */     public static final long GetX11Window = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11Window");
/*  33 */     public static final long SetX11SelectionString = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwSetX11SelectionString");
/*  34 */     public static final long GetX11SelectionString = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11SelectionString");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeX11() {
/*  39 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Display *")
/*     */   public static long glfwGetX11Display() {
/*  47 */     long __functionAddress = Functions.GetX11Display;
/*  48 */     return JNI.invokeP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("RRCrtc")
/*     */   public static long glfwGetX11Adapter(@NativeType("GLFWmonitor *") long monitor) {
/*  56 */     long __functionAddress = Functions.GetX11Adapter;
/*  57 */     if (Checks.CHECKS) {
/*  58 */       Checks.check(monitor);
/*     */     }
/*  60 */     return JNI.invokePN(monitor, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("RROutput")
/*     */   public static long glfwGetX11Monitor(@NativeType("GLFWmonitor *") long monitor) {
/*  68 */     long __functionAddress = Functions.GetX11Monitor;
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.check(monitor);
/*     */     }
/*  72 */     return JNI.invokePN(monitor, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Window")
/*     */   public static long glfwGetX11Window(@NativeType("GLFWwindow *") long window) {
/*  80 */     long __functionAddress = Functions.GetX11Window;
/*  81 */     if (Checks.CHECKS) {
/*  82 */       Checks.check(window);
/*     */     }
/*  84 */     return JNI.invokePN(window, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglfwSetX11SelectionString(long string) {
/*  91 */     long __functionAddress = Functions.SetX11SelectionString;
/*  92 */     JNI.invokePV(string, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glfwSetX11SelectionString(@NativeType("char const *") ByteBuffer string) {
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.checkNT1(string);
/*     */     }
/* 100 */     nglfwSetX11SelectionString(MemoryUtil.memAddress(string));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glfwSetX11SelectionString(@NativeType("char const *") CharSequence string) {
/* 105 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 107 */       stack.nUTF8(string, true);
/* 108 */       long stringEncoded = stack.getPointerAddress();
/* 109 */       nglfwSetX11SelectionString(stringEncoded);
/*     */     } finally {
/* 111 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglfwGetX11SelectionString() {
/* 119 */     long __functionAddress = Functions.GetX11SelectionString;
/* 120 */     return JNI.invokeP(__functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("char const *")
/*     */   public static String glfwGetX11SelectionString() {
/* 126 */     long __result = nglfwGetX11SelectionString();
/* 127 */     return MemoryUtil.memUTF8Safe(__result);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWNativeX11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */