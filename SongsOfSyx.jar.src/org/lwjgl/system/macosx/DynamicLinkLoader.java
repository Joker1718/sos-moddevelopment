/*     */ package org.lwjgl.system.macosx;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class DynamicLinkLoader
/*     */ {
/*     */   public static final int RTLD_LAZY = 1;
/*     */   public static final int RTLD_NOW = 2;
/*     */   public static final int RTLD_LOCAL = 4;
/*     */   public static final int RTLD_GLOBAL = 8;
/*     */   public static final int RTLD_NOLOAD = 16;
/*     */   
/*     */   static {
/*  20 */     Library.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RTLD_NODELETE = 128;
/*     */ 
/*     */   
/*     */   public static final int RTLD_FIRST = 256;
/*     */   
/*     */   public static final long RTLD_NEXT = -1L;
/*     */   
/*     */   public static final long RTLD_DEFAULT = -2L;
/*     */   
/*     */   public static final long RTLD_SELF = -3L;
/*     */   
/*     */   public static final long RTLD_MAIN_ONLY = -5L;
/*     */ 
/*     */   
/*     */   protected DynamicLinkLoader() {
/*  40 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlopen(@NativeType("char const *") ByteBuffer path, int mode) {
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.checkNT1Safe(path);
/*     */     }
/*  54 */     return ndlopen(MemoryUtil.memAddressSafe(path), mode);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlopen(@NativeType("char const *") CharSequence path, int mode) {
/*  60 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  62 */       stack.nUTF8Safe(path, true);
/*  63 */       long pathEncoded = (path == null) ? 0L : stack.getPointerAddress();
/*  64 */       return ndlopen(pathEncoded, mode);
/*     */     } finally {
/*  66 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char const *")
/*     */   public static String dlerror() {
/*  78 */     long __result = ndlerror();
/*  79 */     return MemoryUtil.memUTF8Safe(__result);
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
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.check(handle);
/*  92 */       Checks.checkNT1(name);
/*     */     } 
/*  94 */     return ndlsym(handle, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlsym(@NativeType("void *") long handle, @NativeType("char const *") CharSequence name) {
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.check(handle);
/*     */     }
/* 103 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 105 */       stack.nASCII(name, true);
/* 106 */       long nameEncoded = stack.getPointerAddress();
/* 107 */       return ndlsym(handle, nameEncoded);
/*     */     } finally {
/* 109 */       stack.setPointer(stackPointer);
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
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(handle);
/*     */     }
/* 123 */     return ndlclose(handle);
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


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\DynamicLinkLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */