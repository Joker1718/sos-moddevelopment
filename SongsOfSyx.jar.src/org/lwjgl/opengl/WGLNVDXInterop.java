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
/*     */ public class WGLNVDXInterop
/*     */ {
/*     */   public static final int WGL_ACCESS_READ_ONLY_NV = 0;
/*     */   public static final int WGL_ACCESS_READ_WRITE_NV = 1;
/*     */   public static final int WGL_ACCESS_WRITE_DISCARD_NV = 2;
/*     */   
/*     */   protected WGLNVDXInterop() {
/*  24 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXSetResourceShareHandleNV(@NativeType("void *") long dxObject, @NativeType("HANDLE") long shareHandle) {
/*  32 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDXSetResourceShareHandleNV;
/*  33 */     if (Checks.CHECKS) {
/*  34 */       Checks.check(__functionAddress);
/*  35 */       Checks.check(dxObject);
/*  36 */       Checks.check(shareHandle);
/*     */     } 
/*  38 */     return (JNI.callPPI(dxObject, shareHandle, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HANDLE")
/*     */   public static long wglDXOpenDeviceNV(@NativeType("void *") long dxDevice) {
/*  46 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDXOpenDeviceNV;
/*  47 */     if (Checks.CHECKS) {
/*  48 */       Checks.check(__functionAddress);
/*  49 */       Checks.check(dxDevice);
/*     */     } 
/*  51 */     return JNI.callPP(dxDevice, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXCloseDeviceNV(@NativeType("HANDLE") long device) {
/*  59 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDXCloseDeviceNV;
/*  60 */     if (Checks.CHECKS) {
/*  61 */       Checks.check(__functionAddress);
/*  62 */       Checks.check(device);
/*     */     } 
/*  64 */     return (JNI.callPI(device, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HANDLE")
/*     */   public static long wglDXRegisterObjectNV(@NativeType("HANDLE") long device, @NativeType("void *") long dxResource, @NativeType("GLuint") int name, @NativeType("GLenum") int type, @NativeType("GLenum") int access) {
/*  72 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDXRegisterObjectNV;
/*  73 */     if (Checks.CHECKS) {
/*  74 */       Checks.check(__functionAddress);
/*  75 */       Checks.check(device);
/*  76 */       Checks.check(dxResource);
/*     */     } 
/*  78 */     return JNI.callPPP(device, dxResource, name, type, access, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXUnregisterObjectNV(@NativeType("HANDLE") long device, @NativeType("HANDLE") long object) {
/*  86 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDXUnregisterObjectNV;
/*  87 */     if (Checks.CHECKS) {
/*  88 */       Checks.check(__functionAddress);
/*  89 */       Checks.check(device);
/*  90 */       Checks.check(object);
/*     */     } 
/*  92 */     return (JNI.callPPI(device, object, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXObjectAccessNV(@NativeType("HANDLE") long object, @NativeType("GLenum") int access) {
/* 100 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDXObjectAccessNV;
/* 101 */     if (Checks.CHECKS) {
/* 102 */       Checks.check(__functionAddress);
/* 103 */       Checks.check(object);
/*     */     } 
/* 105 */     return (JNI.callPI(object, access, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglDXLockObjectsNV(long device, int count, long objects) {
/* 112 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDXLockObjectsNV;
/* 113 */     if (Checks.CHECKS) {
/* 114 */       Checks.check(__functionAddress);
/* 115 */       Checks.check(device);
/*     */     } 
/* 117 */     return JNI.callPPI(device, count, objects, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXLockObjectsNV(@NativeType("HANDLE") long device, @NativeType("HANDLE *") PointerBuffer objects) {
/* 123 */     return (nwglDXLockObjectsNV(device, objects.remaining(), MemoryUtil.memAddress((CustomBuffer)objects)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglDXUnlockObjectsNV(long device, int count, long objects) {
/* 130 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDXUnlockObjectsNV;
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(__functionAddress);
/* 133 */       Checks.check(device);
/*     */     } 
/* 135 */     return JNI.callPPI(device, count, objects, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXUnlockObjectsNV(@NativeType("HANDLE") long device, @NativeType("HANDLE *") PointerBuffer objects) {
/* 141 */     return (nwglDXUnlockObjectsNV(device, objects.remaining(), MemoryUtil.memAddress((CustomBuffer)objects)) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLNVDXInterop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */