/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
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
/*     */ public class WGLNVGPUAffinity
/*     */ {
/*     */   public static final int ERROR_INCOMPATIBLE_AFFINITY_MASKS_NV = 8400;
/*     */   public static final int ERROR_MISSING_AFFINITY_MASK_NV = 8401;
/*     */   
/*     */   protected WGLNVGPUAffinity() {
/*  23 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglEnumGpusNV(int gpuIndex, long gpu) {
/*  30 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglEnumGpusNV;
/*  31 */     if (Checks.CHECKS) {
/*  32 */       Checks.check(__functionAddress);
/*     */     }
/*  34 */     return JNI.callPI(gpuIndex, gpu, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglEnumGpusNV(@NativeType("UINT") int gpuIndex, @NativeType("HGPUNV *") PointerBuffer gpu) {
/*  40 */     if (Checks.CHECKS) {
/*  41 */       Checks.check((CustomBuffer)gpu, 1);
/*     */     }
/*  43 */     return (nwglEnumGpusNV(gpuIndex, MemoryUtil.memAddress((CustomBuffer)gpu)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglEnumGpuDevicesNV(long gpu, int deviceIndex, long gpuDevice) {
/*  50 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglEnumGpuDevicesNV;
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.check(__functionAddress);
/*  53 */       Checks.check(gpu);
/*     */     } 
/*  55 */     return JNI.callPPI(gpu, deviceIndex, gpuDevice, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglEnumGpuDevicesNV(@NativeType("HGPUNV") long gpu, @NativeType("UINT") int deviceIndex, @NativeType("PGPU_DEVICE") GPU_DEVICE gpuDevice) {
/*  61 */     return (nwglEnumGpuDevicesNV(gpu, deviceIndex, gpuDevice.address()) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglCreateAffinityDCNV(long gpuList) {
/*  68 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglCreateAffinityDCNV;
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.check(__functionAddress);
/*     */     }
/*  72 */     return JNI.callPP(gpuList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HDC")
/*     */   public static long wglCreateAffinityDCNV(@NativeType("HGPUNV const *") PointerBuffer gpuList) {
/*  78 */     if (Checks.CHECKS) {
/*  79 */       Checks.checkNT(gpuList);
/*     */     }
/*  81 */     return nwglCreateAffinityDCNV(MemoryUtil.memAddress((CustomBuffer)gpuList));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglEnumGpusFromAffinityDCNV(long affinityDC, int gpuIndex, long gpu) {
/*  88 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglEnumGpusFromAffinityDCNV;
/*  89 */     if (Checks.CHECKS) {
/*  90 */       Checks.check(__functionAddress);
/*  91 */       Checks.check(affinityDC);
/*     */     } 
/*  93 */     return JNI.callPPI(affinityDC, gpuIndex, gpu, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglEnumGpusFromAffinityDCNV(@NativeType("HDC") long affinityDC, @NativeType("UINT") int gpuIndex, @NativeType("HGPUNV *") PointerBuffer gpu) {
/*  99 */     if (Checks.CHECKS) {
/* 100 */       Checks.check((CustomBuffer)gpu, 1);
/*     */     }
/* 102 */     return (nwglEnumGpusFromAffinityDCNV(affinityDC, gpuIndex, MemoryUtil.memAddress((CustomBuffer)gpu)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDeleteDCNV(@NativeType("HDC") long hdc) {
/* 110 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDeleteDCNV;
/* 111 */     if (Checks.CHECKS) {
/* 112 */       Checks.check(__functionAddress);
/* 113 */       Checks.check(hdc);
/*     */     } 
/* 115 */     return (JNI.callPI(hdc, __functionAddress) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLNVGPUAffinity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */