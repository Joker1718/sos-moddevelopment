/*     */ package org.lwjgl.system.libc;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LibCStdio
/*     */ {
/*     */   static {
/*  20 */     Library.initialize();
/*     */   }
/*     */   protected LibCStdio() {
/*  23 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  32 */   public static final long stdin = stdin();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   public static final long stdout = stdout();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   public static final long stderr = stderr();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int fflush(@NativeType("FILE *") long stream) {
/*  57 */     if (Checks.CHECKS) {
/*  58 */       Checks.check(stream);
/*     */     }
/*  60 */     return nfflush(stream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int feof(@NativeType("FILE *") long stream) {
/*  70 */     if (Checks.CHECKS) {
/*  71 */       Checks.check(stream);
/*     */     }
/*  73 */     return nfeof(stream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ferror(@NativeType("FILE *") long stream) {
/*  83 */     if (Checks.CHECKS) {
/*  84 */       Checks.check(stream);
/*     */     }
/*  86 */     return nferror(stream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public static final long fscanf = fscanf();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public static final long sscanf = sscanf();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int vsscanf(@NativeType("char const *") ByteBuffer buffer, @NativeType("char const *") ByteBuffer format, @NativeType("va_list") long vlist) {
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.checkNT1(buffer);
/* 114 */       Checks.checkNT1(format);
/* 115 */       Checks.check(vlist);
/*     */     } 
/* 117 */     return nvsscanf(MemoryUtil.memAddress(buffer), MemoryUtil.memAddress(format), vlist);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int vsscanf(@NativeType("char const *") CharSequence buffer, @NativeType("char const *") CharSequence format, @NativeType("va_list") long vlist) {
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.check(vlist);
/*     */     }
/* 125 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 127 */       stack.nASCII(buffer, true);
/* 128 */       long bufferEncoded = stack.getPointerAddress();
/* 129 */       stack.nASCII(format, true);
/* 130 */       long formatEncoded = stack.getPointerAddress();
/* 131 */       return nvsscanf(bufferEncoded, formatEncoded, vlist);
/*     */     } finally {
/* 133 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   public static final long fprintf = fprintf();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   public static final long snprintf = snprintf();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int vsnprintf(@NativeType("char *") ByteBuffer buffer, @NativeType("char const *") ByteBuffer format, @NativeType("va_list") long vlist) {
/* 160 */     if (Checks.CHECKS) {
/* 161 */       Checks.checkNT1(format);
/* 162 */       Checks.check(vlist);
/*     */     } 
/* 164 */     return nvsnprintf(MemoryUtil.memAddressSafe(buffer), Checks.remainingSafe(buffer), MemoryUtil.memAddress(format), vlist);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int vsnprintf(@NativeType("char *") ByteBuffer buffer, @NativeType("char const *") CharSequence format, @NativeType("va_list") long vlist) {
/* 169 */     if (Checks.CHECKS) {
/* 170 */       Checks.check(vlist);
/*     */     }
/* 172 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 174 */       stack.nASCII(format, true);
/* 175 */       long formatEncoded = stack.getPointerAddress();
/* 176 */       return nvsnprintf(MemoryUtil.memAddressSafe(buffer), Checks.remainingSafe(buffer), formatEncoded, vlist);
/*     */     } finally {
/* 178 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */   
/*     */   @NativeType("FILE *")
/*     */   private static native long stdin();
/*     */   
/*     */   @NativeType("FILE *")
/*     */   private static native long stdout();
/*     */   
/*     */   @NativeType("FILE *")
/*     */   private static native long stderr();
/*     */   
/*     */   public static native int nfflush(long paramLong);
/*     */   
/*     */   public static native int nfeof(long paramLong);
/*     */   
/*     */   public static native int nferror(long paramLong);
/*     */   
/*     */   @NativeType("void *")
/*     */   private static native long fscanf();
/*     */   
/*     */   @NativeType("void *")
/*     */   private static native long sscanf();
/*     */   
/*     */   public static native int nvsscanf(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   @NativeType("void *")
/*     */   private static native long fprintf();
/*     */   
/*     */   @NativeType("void *")
/*     */   private static native long snprintf();
/*     */   
/*     */   public static native int nvsnprintf(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\libc\LibCStdio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */