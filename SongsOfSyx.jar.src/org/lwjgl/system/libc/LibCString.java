/*     */ package org.lwjgl.system.libc;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class LibCString
/*     */ {
/*     */   static {
/*  19 */     Library.initialize();
/*     */   }
/*     */   protected LibCString() {
/*  22 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") ByteBuffer dest, int c) {
/*  33 */     return nmemset(MemoryUtil.memAddress(dest), c, dest.remaining());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") ShortBuffer dest, int c) {
/*  39 */     return nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 1L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") IntBuffer dest, int c) {
/*  45 */     return nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 2L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") LongBuffer dest, int c) {
/*  51 */     return nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 3L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") FloatBuffer dest, int c) {
/*  57 */     return nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 2L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") DoubleBuffer dest, int c) {
/*  63 */     return nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") ByteBuffer dest, @NativeType("void const *") ByteBuffer src) {
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.check(dest, src.remaining());
/*     */     }
/*  77 */     return nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), src.remaining());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") ShortBuffer dest, @NativeType("void const *") ShortBuffer src) {
/*  83 */     if (Checks.CHECKS) {
/*  84 */       Checks.check(dest, src.remaining());
/*     */     }
/*  86 */     return nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 1L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") IntBuffer dest, @NativeType("void const *") IntBuffer src) {
/*  92 */     if (Checks.CHECKS) {
/*  93 */       Checks.check(dest, src.remaining());
/*     */     }
/*  95 */     return nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 2L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") LongBuffer dest, @NativeType("void const *") LongBuffer src) {
/* 101 */     if (Checks.CHECKS) {
/* 102 */       Checks.check(dest, src.remaining());
/*     */     }
/* 104 */     return nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 3L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") FloatBuffer dest, @NativeType("void const *") FloatBuffer src) {
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(dest, src.remaining());
/*     */     }
/* 113 */     return nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 2L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") DoubleBuffer dest, @NativeType("void const *") DoubleBuffer src) {
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.check(dest, src.remaining());
/*     */     }
/* 122 */     return nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") ByteBuffer dest, @NativeType("void const *") ByteBuffer src) {
/* 133 */     if (Checks.CHECKS) {
/* 134 */       Checks.check(dest, src.remaining());
/*     */     }
/* 136 */     return nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), src.remaining());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") ShortBuffer dest, @NativeType("void const *") ShortBuffer src) {
/* 142 */     if (Checks.CHECKS) {
/* 143 */       Checks.check(dest, src.remaining());
/*     */     }
/* 145 */     return nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 1L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") IntBuffer dest, @NativeType("void const *") IntBuffer src) {
/* 151 */     if (Checks.CHECKS) {
/* 152 */       Checks.check(dest, src.remaining());
/*     */     }
/* 154 */     return nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 2L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") LongBuffer dest, @NativeType("void const *") LongBuffer src) {
/* 160 */     if (Checks.CHECKS) {
/* 161 */       Checks.check(dest, src.remaining());
/*     */     }
/* 163 */     return nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 3L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") FloatBuffer dest, @NativeType("void const *") FloatBuffer src) {
/* 169 */     if (Checks.CHECKS) {
/* 170 */       Checks.check(dest, src.remaining());
/*     */     }
/* 172 */     return nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 2L);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") DoubleBuffer dest, @NativeType("void const *") DoubleBuffer src) {
/* 178 */     if (Checks.CHECKS) {
/* 179 */       Checks.check(dest, src.remaining());
/*     */     }
/* 181 */     return nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("size_t")
/*     */   public static long strlen(@NativeType("char const *") ByteBuffer str) {
/* 192 */     if (Checks.CHECKS) {
/* 193 */       Checks.checkNT1(str);
/*     */     }
/* 195 */     return nstrlen(MemoryUtil.memAddress(str));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char *")
/*     */   public static String strerror(int errnum) {
/* 206 */     long __result = nstrerror(errnum);
/* 207 */     return MemoryUtil.memASCIISafe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") byte[] dest, int c) {
/* 216 */     return nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") short[] dest, int c) {
/* 225 */     return nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") int[] dest, int c) {
/* 234 */     return nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") long[] dest, int c) {
/* 243 */     return nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") float[] dest, int c) {
/* 252 */     return nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") double[] dest, int c) {
/* 261 */     return nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") byte[] dest, @NativeType("void const *") byte[] src) {
/* 270 */     if (Checks.CHECKS) {
/* 271 */       Checks.check(dest, src.length);
/*     */     }
/* 273 */     return nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") short[] dest, @NativeType("void const *") short[] src) {
/* 282 */     if (Checks.CHECKS) {
/* 283 */       Checks.check(dest, src.length);
/*     */     }
/* 285 */     return nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") int[] dest, @NativeType("void const *") int[] src) {
/* 294 */     if (Checks.CHECKS) {
/* 295 */       Checks.check(dest, src.length);
/*     */     }
/* 297 */     return nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") long[] dest, @NativeType("void const *") long[] src) {
/* 306 */     if (Checks.CHECKS) {
/* 307 */       Checks.check(dest, src.length);
/*     */     }
/* 309 */     return nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") float[] dest, @NativeType("void const *") float[] src) {
/* 318 */     if (Checks.CHECKS) {
/* 319 */       Checks.check(dest, src.length);
/*     */     }
/* 321 */     return nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") double[] dest, @NativeType("void const *") double[] src) {
/* 330 */     if (Checks.CHECKS) {
/* 331 */       Checks.check(dest, src.length);
/*     */     }
/* 333 */     return nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") byte[] dest, @NativeType("void const *") byte[] src) {
/* 342 */     if (Checks.CHECKS) {
/* 343 */       Checks.check(dest, src.length);
/*     */     }
/* 345 */     return nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") short[] dest, @NativeType("void const *") short[] src) {
/* 354 */     if (Checks.CHECKS) {
/* 355 */       Checks.check(dest, src.length);
/*     */     }
/* 357 */     return nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") int[] dest, @NativeType("void const *") int[] src) {
/* 366 */     if (Checks.CHECKS) {
/* 367 */       Checks.check(dest, src.length);
/*     */     }
/* 369 */     return nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") long[] dest, @NativeType("void const *") long[] src) {
/* 378 */     if (Checks.CHECKS) {
/* 379 */       Checks.check(dest, src.length);
/*     */     }
/* 381 */     return nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") float[] dest, @NativeType("void const *") float[] src) {
/* 390 */     if (Checks.CHECKS) {
/* 391 */       Checks.check(dest, src.length);
/*     */     }
/* 393 */     return nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") double[] dest, @NativeType("void const *") double[] src) {
/* 402 */     if (Checks.CHECKS) {
/* 403 */       Checks.check(dest, src.length);
/*     */     }
/* 405 */     return nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 3L);
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
/*     */   @NativeType("void *")
/*     */   public static <T extends CustomBuffer<T>> long memset(@NativeType("void *") T dest, @NativeType("int") int c) {
/* 418 */     return nmemset(MemoryUtil.memAddress((CustomBuffer)dest), c, Integer.toUnsignedLong(dest.remaining()) * dest.sizeof());
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
/*     */   @NativeType("void *")
/*     */   public static <T extends CustomBuffer<T>> long memcpy(@NativeType("void *") T dest, @NativeType("void const *") T src) {
/* 431 */     if (Checks.CHECKS) {
/* 432 */       Checks.check((CustomBuffer)src, dest.remaining());
/*     */     }
/* 434 */     return nmemcpy(MemoryUtil.memAddress((CustomBuffer)dest), MemoryUtil.memAddress((CustomBuffer)src), src.remaining() * src.sizeof());
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
/*     */   @NativeType("void *")
/*     */   public static <T extends CustomBuffer<T>> long memmove(@NativeType("void *") T dest, @NativeType("void const *") T src) {
/* 450 */     if (Checks.CHECKS) {
/* 451 */       Checks.check((CustomBuffer)src, dest.remaining());
/*     */     }
/* 453 */     return nmemmove(MemoryUtil.memAddress((CustomBuffer)dest), MemoryUtil.memAddress((CustomBuffer)src), src.remaining() * src.sizeof());
/*     */   }
/*     */   
/*     */   public static native long nmemset(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native long nmemcpy(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nmemmove(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nstrlen(long paramLong);
/*     */   
/*     */   public static native long nstrerror(int paramInt);
/*     */   
/*     */   public static native long nmemset(byte[] paramArrayOfbyte, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(short[] paramArrayOfshort, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(int[] paramArrayOfint, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(long[] paramArrayOflong, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(float[] paramArrayOffloat, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(double[] paramArrayOfdouble, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(short[] paramArrayOfshort1, short[] paramArrayOfshort2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(short[] paramArrayOfshort1, short[] paramArrayOfshort2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\libc\LibCString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */