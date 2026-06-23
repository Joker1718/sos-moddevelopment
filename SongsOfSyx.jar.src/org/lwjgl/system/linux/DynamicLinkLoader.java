/*     */ package org.lwjgl.system.linux;
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
/*     */   public static final int RTLD_BINDING_MASK = 3;
/*     */   public static final int RTLD_NOLOAD = 4;
/*     */   
/*     */   static {
/*  20 */     Library.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RTLD_DEEPBIND = 8;
/*     */   
/*     */   public static final int RTLD_GLOBAL = 256;
/*     */   
/*     */   public static final int RTLD_LOCAL = 0;
/*     */   
/*     */   public static final int RTLD_NODELETE = 4096;
/*     */ 
/*     */   
/*     */   protected DynamicLinkLoader() {
/*  35 */     throw new UnsupportedOperationException();
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
/*  46 */     if (Checks.CHECKS) {
/*  47 */       Checks.checkNT1Safe(filename);
/*     */     }
/*  49 */     return ndlopen(MemoryUtil.memAddressSafe(filename), mode);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlopen(@NativeType("char const *") CharSequence filename, int mode) {
/*  55 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  57 */       stack.nUTF8Safe(filename, true);
/*  58 */       long filenameEncoded = (filename == null) ? 0L : stack.getPointerAddress();
/*  59 */       return ndlopen(filenameEncoded, mode);
/*     */     } finally {
/*  61 */       stack.setPointer(stackPointer);
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
/*  73 */     long __result = ndlerror();
/*  74 */     return MemoryUtil.memUTF8Safe(__result);
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
/*  85 */     if (Checks.CHECKS) {
/*  86 */       Checks.check(handle);
/*  87 */       Checks.checkNT1(name);
/*     */     } 
/*  89 */     return ndlsym(handle, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlsym(@NativeType("void *") long handle, @NativeType("char const *") CharSequence name) {
/*  95 */     if (Checks.CHECKS) {
/*  96 */       Checks.check(handle);
/*     */     }
/*  98 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 100 */       stack.nASCII(name, true);
/* 101 */       long nameEncoded = stack.getPointerAddress();
/* 102 */       return ndlsym(handle, nameEncoded);
/*     */     } finally {
/* 104 */       stack.setPointer(stackPointer);
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
/* 115 */     if (Checks.CHECKS) {
/* 116 */       Checks.check(handle);
/*     */     }
/* 118 */     return ndlclose(handle);
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


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\DynamicLinkLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */