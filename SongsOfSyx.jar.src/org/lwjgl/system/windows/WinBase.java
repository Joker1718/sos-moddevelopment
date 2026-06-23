/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WinBase
/*     */ {
/*     */   public static final int FALSE = 0;
/*     */   public static final int TRUE = 1;
/*     */   
/*     */   static {
/*  20 */     Library.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinBase() {
/*  27 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HLOCAL")
/*     */   public static long LocalFree(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HLOCAL") long hMem) {
/*  38 */     if (Checks.CHECKS) {
/*  39 */       Checks.checkSafe(_GetLastError, 1);
/*  40 */       Checks.check(hMem);
/*     */     } 
/*  42 */     return nLocalFree(MemoryUtil.memAddressSafe(_GetLastError), hMem);
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
/*     */ 
/*     */   
/*     */   @NativeType("HMODULE")
/*     */   public static long GetModuleHandle(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("LPCTSTR") ByteBuffer moduleName) {
/*  59 */     if (Checks.CHECKS) {
/*  60 */       Checks.checkSafe(_GetLastError, 1);
/*  61 */       Checks.checkNT2Safe(moduleName);
/*     */     } 
/*  63 */     return nGetModuleHandle(MemoryUtil.memAddressSafe(_GetLastError), MemoryUtil.memAddressSafe(moduleName));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HMODULE")
/*     */   public static long GetModuleHandle(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("LPCTSTR") CharSequence moduleName) {
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/*  72 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  74 */       stack.nUTF16Safe(moduleName, true);
/*  75 */       long moduleNameEncoded = (moduleName == null) ? 0L : stack.getPointerAddress();
/*  76 */       return nGetModuleHandle(MemoryUtil.memAddressSafe(_GetLastError), moduleNameEncoded);
/*     */     } finally {
/*  78 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetModuleFileName(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HMODULE") long hModule, @NativeType("LPTSTR") ByteBuffer lpFilename) {
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/*  93 */     return nGetModuleFileName(MemoryUtil.memAddressSafe(_GetLastError), hModule, MemoryUtil.memAddress(lpFilename), lpFilename.remaining() >> 1);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static String GetModuleFileName(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HMODULE") long hModule, @NativeType("DWORD") int nSize) {
/*  99 */     if (Checks.CHECKS) {
/* 100 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 102 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 104 */       ByteBuffer lpFilename = stack.malloc(nSize << 1);
/* 105 */       int __result = nGetModuleFileName(MemoryUtil.memAddressSafe(_GetLastError), hModule, MemoryUtil.memAddress(lpFilename), nSize);
/* 106 */       return MemoryUtil.memUTF16(lpFilename, __result);
/*     */     } finally {
/* 108 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HMODULE")
/*     */   public static long LoadLibrary(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("LPCTSTR") ByteBuffer name) {
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.checkSafe(_GetLastError, 1);
/* 122 */       Checks.checkNT2(name);
/*     */     } 
/* 124 */     return nLoadLibrary(MemoryUtil.memAddressSafe(_GetLastError), MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HMODULE")
/*     */   public static long LoadLibrary(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("LPCTSTR") CharSequence name) {
/* 130 */     if (Checks.CHECKS) {
/* 131 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 133 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 135 */       stack.nUTF16(name, true);
/* 136 */       long nameEncoded = stack.getPointerAddress();
/* 137 */       return nLoadLibrary(MemoryUtil.memAddressSafe(_GetLastError), nameEncoded);
/*     */     } finally {
/* 139 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("FARPROC")
/*     */   public static long GetProcAddress(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HMODULE") long handle, @NativeType("LPCSTR") ByteBuffer name) {
/* 151 */     if (Checks.CHECKS) {
/* 152 */       Checks.checkSafe(_GetLastError, 1);
/* 153 */       Checks.check(handle);
/* 154 */       Checks.checkNT1(name);
/*     */     } 
/* 156 */     return nGetProcAddress(MemoryUtil.memAddressSafe(_GetLastError), handle, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("FARPROC")
/*     */   public static long GetProcAddress(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HMODULE") long handle, @NativeType("LPCSTR") CharSequence name) {
/* 162 */     if (Checks.CHECKS) {
/* 163 */       Checks.checkSafe(_GetLastError, 1);
/* 164 */       Checks.check(handle);
/*     */     } 
/* 166 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 168 */       stack.nASCII(name, true);
/* 169 */       long nameEncoded = stack.getPointerAddress();
/* 170 */       return nGetProcAddress(MemoryUtil.memAddressSafe(_GetLastError), handle, nameEncoded);
/*     */     } finally {
/* 172 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean FreeLibrary(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HMODULE") long handle) {
/* 184 */     if (Checks.CHECKS) {
/* 185 */       Checks.checkSafe(_GetLastError, 1);
/* 186 */       Checks.check(handle);
/*     */     } 
/* 188 */     return (nFreeLibrary(MemoryUtil.memAddressSafe(_GetLastError), handle) != 0);
/*     */   }
/*     */   
/*     */   public static native long nLocalFree(long paramLong1, long paramLong2);
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static native int GetLastError();
/*     */   
/*     */   public static native long nGetModuleHandle(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nGetModuleFileName(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*     */   
/*     */   public static native long nLoadLibrary(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nGetProcAddress(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nFreeLibrary(long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\WinBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */