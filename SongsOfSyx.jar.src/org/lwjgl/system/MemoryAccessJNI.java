/*     */ package org.lwjgl.system;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MemoryAccessJNI
/*     */ {
/*     */   static {
/*  13 */     Library.initialize();
/*     */   }
/*     */   private MemoryAccessJNI() {
/*  16 */     throw new UnsupportedOperationException();
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
/*  30 */   static final long malloc = malloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   static final long calloc = calloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   static final long realloc = realloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   static final long free = free();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   static final long aligned_alloc = aligned_alloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   static final long aligned_free = aligned_free();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int8_t")
/*     */   static byte getByte(@NativeType("void *") long ptr) {
/*  80 */     if (Checks.CHECKS) {
/*  81 */       Checks.check(ptr);
/*     */     }
/*  83 */     return ngetByte(ptr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int16_t")
/*     */   static short getShort(@NativeType("void *") long ptr) {
/*  94 */     if (Checks.CHECKS) {
/*  95 */       Checks.check(ptr);
/*     */     }
/*  97 */     return ngetShort(ptr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int32_t")
/*     */   static int getInt(@NativeType("void *") long ptr) {
/* 108 */     if (Checks.CHECKS) {
/* 109 */       Checks.check(ptr);
/*     */     }
/* 111 */     return ngetInt(ptr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int64_t")
/*     */   static long getLong(@NativeType("void *") long ptr) {
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.check(ptr);
/*     */     }
/* 125 */     return ngetLong(ptr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static float getFloat(@NativeType("void *") long ptr) {
/* 135 */     if (Checks.CHECKS) {
/* 136 */       Checks.check(ptr);
/*     */     }
/* 138 */     return ngetFloat(ptr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static double getDouble(@NativeType("void *") long ptr) {
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.check(ptr);
/*     */     }
/* 151 */     return ngetDouble(ptr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("uintptr_t")
/*     */   static long getAddress(@NativeType("void *") long ptr) {
/* 162 */     if (Checks.CHECKS) {
/* 163 */       Checks.check(ptr);
/*     */     }
/* 165 */     return ngetAddress(ptr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void putByte(@NativeType("void *") long ptr, @NativeType("int8_t") byte value) {
/* 175 */     if (Checks.CHECKS) {
/* 176 */       Checks.check(ptr);
/*     */     }
/* 178 */     nputByte(ptr, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void putShort(@NativeType("void *") long ptr, @NativeType("int16_t") short value) {
/* 188 */     if (Checks.CHECKS) {
/* 189 */       Checks.check(ptr);
/*     */     }
/* 191 */     nputShort(ptr, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void putInt(@NativeType("void *") long ptr, @NativeType("int32_t") int value) {
/* 201 */     if (Checks.CHECKS) {
/* 202 */       Checks.check(ptr);
/*     */     }
/* 204 */     nputInt(ptr, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void putLong(@NativeType("void *") long ptr, @NativeType("int64_t") long value) {
/* 214 */     if (Checks.CHECKS) {
/* 215 */       Checks.check(ptr);
/*     */     }
/* 217 */     nputLong(ptr, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void putFloat(@NativeType("void *") long ptr, float value) {
/* 227 */     if (Checks.CHECKS) {
/* 228 */       Checks.check(ptr);
/*     */     }
/* 230 */     nputFloat(ptr, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void putDouble(@NativeType("void *") long ptr, double value) {
/* 240 */     if (Checks.CHECKS) {
/* 241 */       Checks.check(ptr);
/*     */     }
/* 243 */     nputDouble(ptr, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void putAddress(@NativeType("void *") long ptr, @NativeType("uintptr_t") long value) {
/* 253 */     if (Checks.CHECKS) {
/* 254 */       Checks.check(ptr);
/*     */     }
/* 256 */     nputAddress(ptr, value);
/*     */   }
/*     */   
/*     */   static native int getPointerSize();
/*     */   
/*     */   @NativeType("void * (*) (size_t)")
/*     */   private static native long malloc();
/*     */   
/*     */   @NativeType("void * (*) (size_t, size_t)")
/*     */   private static native long calloc();
/*     */   
/*     */   @NativeType("void * (*) (void *, size_t)")
/*     */   private static native long realloc();
/*     */   
/*     */   @NativeType("void (*) (void *)")
/*     */   private static native long free();
/*     */   
/*     */   @NativeType("void * (*) (size_t, size_t)")
/*     */   private static native long aligned_alloc();
/*     */   
/*     */   @NativeType("void (*) (void *)")
/*     */   private static native long aligned_free();
/*     */   
/*     */   static native byte ngetByte(long paramLong);
/*     */   
/*     */   static native short ngetShort(long paramLong);
/*     */   
/*     */   static native int ngetInt(long paramLong);
/*     */   
/*     */   static native long ngetLong(long paramLong);
/*     */   
/*     */   static native float ngetFloat(long paramLong);
/*     */   
/*     */   static native double ngetDouble(long paramLong);
/*     */   
/*     */   static native long ngetAddress(long paramLong);
/*     */   
/*     */   static native void nputByte(long paramLong, byte paramByte);
/*     */   
/*     */   static native void nputShort(long paramLong, short paramShort);
/*     */   
/*     */   static native void nputInt(long paramLong, int paramInt);
/*     */   
/*     */   static native void nputLong(long paramLong1, long paramLong2);
/*     */   
/*     */   static native void nputFloat(long paramLong, float paramFloat);
/*     */   
/*     */   static native void nputDouble(long paramLong, double paramDouble);
/*     */   
/*     */   static native void nputAddress(long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\MemoryAccessJNI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */