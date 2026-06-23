/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ 
/*     */ public class Crypt32 {
/*     */   public static final int CRYPTPROTECT_UI_FORBIDDEN = 1;
/*     */   public static final int CRYPTPROTECT_LOCAL_MACHINE = 4;
/*     */   public static final int CRYPTPROTECT_AUDIT = 16;
/*     */   public static final int CRYPTPROTECT_VERIFY_PROTECTION = 64;
/*     */   public static final int CRYPTPROTECTMEMORY_SAME_PROCESS = 0;
/*  23 */   private static final SharedLibrary CRYPT32 = Library.loadNative(Crypt32.class, "org.lwjgl", "crypt32");
/*     */   public static final int CRYPTPROTECTMEMORY_CROSS_PROCESS = 1;
/*     */   public static final int CRYPTPROTECTMEMORY_SAME_LOGON = 2;
/*     */   public static final int CRYPTPROTECT_PROMPT_ON_UNPROTECT = 1;
/*     */   public static final int CRYPTPROTECT_PROMPT_ON_PROTECT = 2;
/*     */   public static final int CRYPTPROTECTMEMORY_BLOCK_SIZE = 16;
/*     */   
/*     */   public static final class Functions
/*     */   {
/*  32 */     public static final long CryptProtectData = APIUtil.apiGetFunctionAddress((FunctionProvider)Crypt32.CRYPT32, "CryptProtectData");
/*  33 */     public static final long CryptProtectMemory = APIUtil.apiGetFunctionAddressOptional(Crypt32.CRYPT32, "CryptProtectMemory");
/*  34 */     public static final long CryptUnprotectData = APIUtil.apiGetFunctionAddress((FunctionProvider)Crypt32.CRYPT32, "CryptUnprotectData");
/*  35 */     public static final long CryptUnprotectMemory = APIUtil.apiGetFunctionAddressOptional(Crypt32.CRYPT32, "CryptUnprotectMemory");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  41 */     return CRYPT32;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Crypt32() {
/*  62 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nCryptProtectData(long _GetLastError, long pDataIn, long szDataDescr, long pOptionalEntropy, long pvReserved, long pPromptStruct, int dwFlags, long pDataOut) {
/*  72 */     long __functionAddress = Functions.CryptProtectData;
/*  73 */     return nCryptProtectData(_GetLastError, pDataIn, szDataDescr, pOptionalEntropy, pvReserved, pPromptStruct, dwFlags, pDataOut, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptProtectData(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("DATA_BLOB *") DATA_BLOB pDataIn, @NativeType("LPCWSTR") ByteBuffer szDataDescr, @NativeType("DATA_BLOB *") DATA_BLOB pOptionalEntropy, @NativeType("PVOID") long pvReserved, @NativeType("CRYPTPROTECT_PROMPTSTRUCT *") CRYPTPROTECT_PROMPTSTRUCT pPromptStruct, @NativeType("DWORD") int dwFlags, @NativeType("DATA_BLOB *") DATA_BLOB pDataOut) {
/*  79 */     if (Checks.CHECKS) {
/*  80 */       Checks.checkSafe(_GetLastError, 1);
/*  81 */       Checks.checkNT2Safe(szDataDescr);
/*     */     } 
/*  83 */     return (nCryptProtectData(MemoryUtil.memAddressSafe(_GetLastError), pDataIn.address(), MemoryUtil.memAddressSafe(szDataDescr), MemoryUtil.memAddressSafe((Pointer)pOptionalEntropy), pvReserved, MemoryUtil.memAddressSafe((Pointer)pPromptStruct), dwFlags, pDataOut.address()) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptProtectData(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("DATA_BLOB *") DATA_BLOB pDataIn, @NativeType("LPCWSTR") CharSequence szDataDescr, @NativeType("DATA_BLOB *") DATA_BLOB pOptionalEntropy, @NativeType("PVOID") long pvReserved, @NativeType("CRYPTPROTECT_PROMPTSTRUCT *") CRYPTPROTECT_PROMPTSTRUCT pPromptStruct, @NativeType("DWORD") int dwFlags, @NativeType("DATA_BLOB *") DATA_BLOB pDataOut) {
/*  89 */     if (Checks.CHECKS) {
/*  90 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/*  92 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  94 */       stack.nUTF16Safe(szDataDescr, true);
/*  95 */       long szDataDescrEncoded = (szDataDescr == null) ? 0L : stack.getPointerAddress();
/*  96 */       return (nCryptProtectData(MemoryUtil.memAddressSafe(_GetLastError), pDataIn.address(), szDataDescrEncoded, MemoryUtil.memAddressSafe((Pointer)pOptionalEntropy), pvReserved, MemoryUtil.memAddressSafe((Pointer)pPromptStruct), dwFlags, pDataOut.address()) != 0);
/*     */     } finally {
/*  98 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nCryptProtectMemory(long _GetLastError, long pDataIn, int cbDataIn, int dwFlags) {
/* 109 */     long __functionAddress = Functions.CryptProtectMemory;
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(__functionAddress);
/*     */     }
/* 113 */     return nCryptProtectMemory(_GetLastError, pDataIn, cbDataIn, dwFlags, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptProtectMemory(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("LPVOID") ByteBuffer pDataIn, @NativeType("DWORD") int dwFlags) {
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 122 */     return (nCryptProtectMemory(MemoryUtil.memAddressSafe(_GetLastError), MemoryUtil.memAddress(pDataIn), pDataIn.remaining(), dwFlags) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nCryptUnprotectData(long _GetLastError, long pDataIn, long ppszDataDescr, long pOptionalEntropy, long pvReserved, long pPromptStruct, int dwFlags, long pDataOut) {
/* 132 */     long __functionAddress = Functions.CryptUnprotectData;
/* 133 */     return nCryptUnprotectData(_GetLastError, pDataIn, ppszDataDescr, pOptionalEntropy, pvReserved, pPromptStruct, dwFlags, pDataOut, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptUnprotectData(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("DATA_BLOB *") DATA_BLOB pDataIn, @NativeType("LPWSTR *") PointerBuffer ppszDataDescr, @NativeType("DATA_BLOB *") DATA_BLOB pOptionalEntropy, @NativeType("PVOID") long pvReserved, @NativeType("CRYPTPROTECT_PROMPTSTRUCT *") CRYPTPROTECT_PROMPTSTRUCT pPromptStruct, @NativeType("DWORD") int dwFlags, @NativeType("DATA_BLOB *") DATA_BLOB pDataOut) {
/* 139 */     if (Checks.CHECKS) {
/* 140 */       Checks.checkSafe(_GetLastError, 1);
/* 141 */       Checks.checkSafe((CustomBuffer)ppszDataDescr, 1);
/*     */     } 
/* 143 */     return (nCryptUnprotectData(MemoryUtil.memAddressSafe(_GetLastError), pDataIn.address(), MemoryUtil.memAddressSafe((Pointer)ppszDataDescr), MemoryUtil.memAddressSafe((Pointer)pOptionalEntropy), pvReserved, MemoryUtil.memAddressSafe((Pointer)pPromptStruct), dwFlags, pDataOut.address()) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nCryptUnprotectMemory(long _GetLastError, long pDataIn, int cbDataIn, int dwFlags) {
/* 153 */     long __functionAddress = Functions.CryptUnprotectMemory;
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(__functionAddress);
/*     */     }
/* 157 */     return nCryptUnprotectMemory(_GetLastError, pDataIn, cbDataIn, dwFlags, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptUnprotectMemory(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("LPVOID") ByteBuffer pDataIn, @NativeType("DWORD") int dwFlags) {
/* 163 */     if (Checks.CHECKS) {
/* 164 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 166 */     return (nCryptUnprotectMemory(MemoryUtil.memAddressSafe(_GetLastError), MemoryUtil.memAddress(pDataIn), pDataIn.remaining(), dwFlags) != 0);
/*     */   }
/*     */   
/*     */   public static native int nCryptProtectData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt, long paramLong7, long paramLong8);
/*     */   
/*     */   public static native int nCryptProtectMemory(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*     */   
/*     */   public static native int nCryptUnprotectData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt, long paramLong7, long paramLong8);
/*     */   
/*     */   public static native int nCryptUnprotectMemory(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\Crypt32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */