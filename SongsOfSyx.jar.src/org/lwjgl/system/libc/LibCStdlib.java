/*     */ package org.lwjgl.system.libc;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LibCStdlib
/*     */ {
/*     */   static {
/*  20 */     Library.initialize();
/*     */   }
/*     */   protected LibCStdlib() {
/*  23 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer malloc(@NativeType("size_t") long size) {
/*  34 */     long __result = nmalloc(size);
/*  35 */     return MemoryUtil.memByteBufferSafe(__result, (int)size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer calloc(@NativeType("size_t") long nmemb, @NativeType("size_t") long size) {
/*  46 */     long __result = ncalloc(nmemb, size);
/*  47 */     return MemoryUtil.memByteBufferSafe(__result, (int)nmemb * (int)size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer realloc(@NativeType("void *") ByteBuffer ptr, @NativeType("size_t") long size) {
/*  58 */     long __result = nrealloc(MemoryUtil.memAddressSafe(ptr), size);
/*  59 */     return MemoryUtil.memByteBufferSafe(__result, (int)size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") ByteBuffer ptr) {
/*  69 */     nfree(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") ShortBuffer ptr) {
/*  74 */     nfree(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") IntBuffer ptr) {
/*  79 */     nfree(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") LongBuffer ptr) {
/*  84 */     nfree(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") FloatBuffer ptr) {
/*  89 */     nfree(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") DoubleBuffer ptr) {
/*  94 */     nfree(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") PointerBuffer ptr) {
/*  99 */     nfree(MemoryUtil.memAddressSafe((Pointer)ptr));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer aligned_alloc(@NativeType("size_t") long alignment, @NativeType("size_t") long size) {
/* 110 */     long __result = naligned_alloc(alignment, size);
/* 111 */     return MemoryUtil.memByteBufferSafe(__result, (int)size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") ByteBuffer ptr) {
/* 121 */     naligned_free(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") ShortBuffer ptr) {
/* 126 */     naligned_free(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") IntBuffer ptr) {
/* 131 */     naligned_free(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") LongBuffer ptr) {
/* 136 */     naligned_free(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") FloatBuffer ptr) {
/* 141 */     naligned_free(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") DoubleBuffer ptr) {
/* 146 */     naligned_free(MemoryUtil.memAddressSafe(ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") PointerBuffer ptr) {
/* 151 */     naligned_free(MemoryUtil.memAddressSafe((Pointer)ptr));
/*     */   }
/*     */   
/*     */   public static native long nmalloc(long paramLong);
/*     */   
/*     */   public static native long ncalloc(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nrealloc(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nfree(long paramLong);
/*     */   
/*     */   public static native long naligned_alloc(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void naligned_free(long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\libc\LibCStdlib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */