/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Kernel32
/*     */ {
/*  16 */   private static final SharedLibrary KERNEL32 = Library.loadNative(Kernel32.class, "org.lwjgl", "kernel32");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Functions
/*     */   {
/*  25 */     public static final long GetCurrentProcess = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetCurrentProcess");
/*  26 */     public static final long GetCurrentProcessId = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetCurrentProcessId");
/*  27 */     public static final long GetProcessId = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetProcessId");
/*  28 */     public static final long GetCurrentThread = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetCurrentThread");
/*  29 */     public static final long GetCurrentThreadId = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetCurrentThreadId");
/*  30 */     public static final long GetThreadId = APIUtil.apiGetFunctionAddressOptional(Kernel32.KERNEL32, "GetThreadId");
/*  31 */     public static final long GetProcessIdOfThread = APIUtil.apiGetFunctionAddressOptional(Kernel32.KERNEL32, "GetProcessIdOfThread");
/*  32 */     public static final long GetCurrentProcessorNumber = APIUtil.apiGetFunctionAddressOptional(Kernel32.KERNEL32, "GetCurrentProcessorNumber");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  38 */     return KERNEL32;
/*     */   }
/*     */   
/*     */   protected Kernel32() {
/*  42 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HANDLE")
/*     */   public static long GetCurrentProcess() {
/*  50 */     long __functionAddress = Functions.GetCurrentProcess;
/*  51 */     return JNI.callP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetCurrentProcessId() {
/*  59 */     long __functionAddress = Functions.GetCurrentProcessId;
/*  60 */     return JNI.callI(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetProcessId(@NativeType("HANDLE") long Process) {
/*  68 */     long __functionAddress = Functions.GetProcessId;
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.check(Process);
/*     */     }
/*  72 */     return JNI.callPI(Process, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HANDLE")
/*     */   public static long GetCurrentThread() {
/*  80 */     long __functionAddress = Functions.GetCurrentThread;
/*  81 */     return JNI.callP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetCurrentThreadId() {
/*  89 */     long __functionAddress = Functions.GetCurrentThreadId;
/*  90 */     return JNI.callI(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetThreadId(@NativeType("HANDLE") long Thread) {
/*  98 */     long __functionAddress = Functions.GetThreadId;
/*  99 */     if (Checks.CHECKS) {
/* 100 */       Checks.check(__functionAddress);
/* 101 */       Checks.check(Thread);
/*     */     } 
/* 103 */     return JNI.callPI(Thread, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetProcessIdOfThread(@NativeType("HANDLE") long Thread) {
/* 111 */     long __functionAddress = Functions.GetProcessIdOfThread;
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check(__functionAddress);
/* 114 */       Checks.check(Thread);
/*     */     } 
/* 116 */     return JNI.callPI(Thread, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetCurrentProcessorNumber() {
/* 124 */     long __functionAddress = Functions.GetCurrentProcessorNumber;
/* 125 */     if (Checks.CHECKS) {
/* 126 */       Checks.check(__functionAddress);
/*     */     }
/* 128 */     return JNI.callI(__functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\Kernel32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */