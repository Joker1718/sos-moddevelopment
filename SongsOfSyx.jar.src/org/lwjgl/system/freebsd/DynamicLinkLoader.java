/*     */ package org.lwjgl.system.freebsd;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DynamicLinkLoader
/*     */ {
/*     */   public static final int RTLD_LAZY = 1;
/*     */   public static final int RTLD_NOW = 2;
/*     */   public static final int RTLD_MODEMASK = 3;
/*     */   public static final int RTLD_GLOBAL = 256;
/*     */   
/*     */   static {
/*  20 */     Library.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int RTLD_LOCAL = 0;
/*     */   
/*     */   public static final int RTLD_TRACE = 512;
/*     */   
/*     */   public static final int RTLD_NODELETE = 4096;
/*     */   
/*     */   public static final int RTLD_NOLOAD = 8192;
/*     */   public static final int RTLD_DEEPBIND = 16384;
/*     */   
/*     */   protected DynamicLinkLoader() {
/*  34 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlopen(@NativeType("char const *") ByteBuffer filename, int mode) {
/*  45 */     if (Checks.CHECKS) {
/*  46 */       Checks.checkNT1Safe(filename);
/*     */     }
/*  48 */     return ndlopen(MemoryUtil.memAddressSafe(filename), mode);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlopen(@NativeType("char const *") CharSequence filename, int mode) {
/*  54 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  56 */       stack.nUTF8Safe(filename, true);
/*  57 */       long filenameEncoded = (filename == null) ? 0L : stack.getPointerAddress();
/*  58 */       return ndlopen(filenameEncoded, mode);
/*     */     } finally {
/*  60 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char *")
/*     */   public static String dlerror() {
/*  72 */     long __result = ndlerror();
/*  73 */     return MemoryUtil.memUTF8Safe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlsym(@NativeType("void *") long handle, @NativeType("char const *") ByteBuffer name) {
/*  84 */     if (Checks.CHECKS) {
/*  85 */       Checks.check(handle);
/*  86 */       Checks.checkNT1(name);
/*     */     } 
/*  88 */     return ndlsym(handle, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlsym(@NativeType("void *") long handle, @NativeType("char const *") CharSequence name) {
/*  94 */     if (Checks.CHECKS) {
/*  95 */       Checks.check(handle);
/*     */     }
/*  97 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  99 */       stack.nASCII(name, true);
/* 100 */       long nameEncoded = stack.getPointerAddress();
/* 101 */       return ndlsym(handle, nameEncoded);
/*     */     } finally {
/* 103 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int dlclose(@NativeType("void *") long handle) {
/* 114 */     if (Checks.CHECKS) {
/* 115 */       Checks.check(handle);
/*     */     }
/* 117 */     return ndlclose(handle);
/*     */   }
/*     */   
/*     */   public static native long ndlopen(long paramLong, int paramInt);
/*     */   
/*     */   public static native long ndlerror();
/*     */   
/*     */   public static native long ndlsym(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int ndlclose(long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\freebsd\DynamicLinkLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */