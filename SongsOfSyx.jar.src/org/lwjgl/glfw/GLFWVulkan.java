/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Platform;
/*     */ import org.lwjgl.system.Pointer;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ import org.lwjgl.vulkan.VK;
/*     */ import org.lwjgl.vulkan.VkAllocationCallbacks;
/*     */ import org.lwjgl.vulkan.VkInstance;
/*     */ import org.lwjgl.vulkan.VkPhysicalDevice;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLFWVulkan
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  33 */     public static final long InitVulkanLoader = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwInitVulkanLoader");
/*  34 */     public static final long VulkanSupported = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwVulkanSupported");
/*  35 */     public static final long GetRequiredInstanceExtensions = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetRequiredInstanceExtensions");
/*  36 */     public static final long GetInstanceProcAddress = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetInstanceProcAddress");
/*  37 */     public static final long GetPhysicalDevicePresentationSupport = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetPhysicalDevicePresentationSupport");
/*  38 */     public static final long CreateWindowSurface = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwCreateWindowSurface");
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/*  43 */     if (Platform.get() == Platform.MACOSX) {
/*  44 */       setPath(VK.getFunctionProvider());
/*     */     }
/*     */   }
/*     */   
/*     */   protected GLFWVulkan() {
/*  49 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glfwInitVulkanLoader(@NativeType("PFN_vkGetInstanceProcAddr") long loader) {
/*  56 */     long __functionAddress = Functions.InitVulkanLoader;
/*  57 */     JNI.invokePV(loader, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean glfwVulkanSupported() {
/*  65 */     long __functionAddress = Functions.VulkanSupported;
/*  66 */     return (JNI.invokeI(__functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglfwGetRequiredInstanceExtensions(long count) {
/*  73 */     long __functionAddress = Functions.GetRequiredInstanceExtensions;
/*  74 */     return JNI.invokePP(count, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("char const **")
/*     */   public static PointerBuffer glfwGetRequiredInstanceExtensions() {
/*  80 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  81 */     IntBuffer count = stack.callocInt(1);
/*     */     try {
/*  83 */       long __result = nglfwGetRequiredInstanceExtensions(MemoryUtil.memAddress(count));
/*  84 */       return MemoryUtil.memPointerBufferSafe(__result, count.get(0));
/*     */     } finally {
/*  86 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglfwGetInstanceProcAddress(long instance, long procname) {
/*  94 */     long __functionAddress = Functions.GetInstanceProcAddress;
/*  95 */     return JNI.invokePPP(instance, procname, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLFWvkproc")
/*     */   public static long glfwGetInstanceProcAddress(@NativeType("VkInstance") VkInstance instance, @NativeType("char const *") ByteBuffer procname) {
/* 101 */     if (Checks.CHECKS) {
/* 102 */       Checks.checkNT1(procname);
/*     */     }
/* 104 */     return nglfwGetInstanceProcAddress(MemoryUtil.memAddressSafe((Pointer)instance), MemoryUtil.memAddress(procname));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLFWvkproc")
/*     */   public static long glfwGetInstanceProcAddress(@NativeType("VkInstance") VkInstance instance, @NativeType("char const *") CharSequence procname) {
/* 110 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 112 */       stack.nASCII(procname, true);
/* 113 */       long procnameEncoded = stack.getPointerAddress();
/* 114 */       return nglfwGetInstanceProcAddress(MemoryUtil.memAddressSafe((Pointer)instance), procnameEncoded);
/*     */     } finally {
/* 116 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean glfwGetPhysicalDevicePresentationSupport(VkInstance instance, VkPhysicalDevice device, @NativeType("uint32_t") int queuefamily) {
/* 125 */     long __functionAddress = Functions.GetPhysicalDevicePresentationSupport;
/* 126 */     return (JNI.invokePPI(instance.address(), device.address(), queuefamily, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglfwCreateWindowSurface(long instance, long window, long allocator, long surface) {
/* 133 */     long __functionAddress = Functions.CreateWindowSurface;
/* 134 */     if (Checks.CHECKS) {
/* 135 */       Checks.check(window);
/*     */     }
/* 137 */     return JNI.invokePPPPI(instance, window, allocator, surface, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("VkResult")
/*     */   public static int glfwCreateWindowSurface(VkInstance instance, @NativeType("GLFWwindow *") long window, @NativeType("VkAllocationCallbacks const *") VkAllocationCallbacks allocator, @NativeType("VkSurfaceKHR *") LongBuffer surface) {
/* 143 */     if (Checks.CHECKS) {
/* 144 */       Checks.check(surface, 1);
/*     */     }
/* 146 */     return nglfwCreateWindowSurface(instance.address(), window, MemoryUtil.memAddressSafe((Pointer)allocator), MemoryUtil.memAddress(surface));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("VkResult")
/*     */   public static int glfwCreateWindowSurface(VkInstance instance, @NativeType("GLFWwindow *") long window, @NativeType("VkAllocationCallbacks const *") VkAllocationCallbacks allocator, @NativeType("VkSurfaceKHR *") long[] surface) {
/* 152 */     long __functionAddress = Functions.CreateWindowSurface;
/* 153 */     if (Checks.CHECKS) {
/* 154 */       Checks.check(window);
/* 155 */       Checks.check(surface, 1);
/*     */     } 
/* 157 */     return JNI.invokePPPPI(instance.address(), window, MemoryUtil.memAddressSafe((Pointer)allocator), surface, __functionAddress);
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
/* 168 */     if (!(sharedLibrary instanceof SharedLibrary)) {
/* 169 */       APIUtil.apiLog("GLFW Vulkan path override not set: function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/* 173 */     String path = ((SharedLibrary)sharedLibrary).getPath();
/* 174 */     if (path == null) {
/* 175 */       APIUtil.apiLog("GLFW Vulkan path override not set: Could not resolve the shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/* 179 */     setPath(path);
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
/* 193 */     long override = GLFW.getLibrary().getFunctionAddress("_glfw_vulkan_library");
/* 194 */     if (override == 0L) {
/* 195 */       APIUtil.apiLog("GLFW Vulkan path override not set: Could not resolve override symbol.");
/*     */       
/*     */       return;
/*     */     } 
/* 199 */     long a = MemoryUtil.memGetAddress(override);
/* 200 */     if (a != 0L) {
/* 201 */       MemoryUtil.nmemFree(a);
/*     */     }
/* 203 */     MemoryUtil.memPutAddress(override, (path == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(path)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWVulkan.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */