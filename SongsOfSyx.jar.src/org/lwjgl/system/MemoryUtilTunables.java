/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import org.lwjgl.system.libc.LibCString;
/*     */ import sun.misc.Unsafe;
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
/*     */ final class MemoryUtilTunables
/*     */ {
/*  17 */   private static final int FILL_PATTERN_32 = Integer.divideUnsigned(-1, 255);
/*  18 */   private static final long FILL_PATTERN_64 = Long.divideUnsigned(-1L, 255L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void memset(long ptr, int value, long bytes) {
/*  29 */     if (bytes < 256L) {
/*  30 */       int p = (int)ptr;
/*  31 */       if (Pointer.BITS64) {
/*  32 */         if ((p & 0x7) == 0) {
/*  33 */           memset64(ptr, value, bytes);
/*     */           
/*     */           return;
/*     */         } 
/*  37 */       } else if ((p & 0x3) == 0) {
/*  38 */         memset32(p, value, bytes);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  43 */     LibCString.nmemset(ptr, value, bytes);
/*     */   }
/*     */   private static void memset64(long ptr, int value, long bytes) {
/*  46 */     int limit = (int)bytes & 0xFF;
/*     */     
/*  48 */     long l = (value & 0xFF) * FILL_PATTERN_64;
/*     */     
/*  50 */     int offset = 0;
/*     */ 
/*     */     
/*  53 */     for (int aligned = limit & 0xFFFFFFF8; offset < aligned; offset += 8) {
/*  54 */       MemoryUtil.UNSAFE.putLong(null, ptr + offset, l);
/*     */     }
/*     */ 
/*     */     
/*  58 */     if (offset < (limit & 0xFFFFFFFC)) {
/*  59 */       MemoryUtil.UNSAFE.putInt(null, ptr + offset, (int)l);
/*  60 */       offset += 4;
/*     */     } 
/*     */     
/*  63 */     if (offset < (limit & 0xFFFFFFFE)) {
/*  64 */       MemoryUtil.UNSAFE.putShort(null, ptr + offset, (short)(int)l);
/*  65 */       offset += 2;
/*     */     } 
/*     */     
/*  68 */     if (offset < limit)
/*  69 */       MemoryUtil.UNSAFE.putByte(null, ptr + offset, (byte)(int)l); 
/*     */   }
/*     */   
/*     */   private static void memset32(int ptr, int value, long bytes) {
/*  73 */     int limit = (int)bytes & 0xFF;
/*     */     
/*  75 */     int i = (value & 0xFF) * FILL_PATTERN_32;
/*     */     
/*  77 */     int offset = 0;
/*     */ 
/*     */     
/*  80 */     for (int aligned = limit & 0xFFFFFFFC; offset < aligned; offset += 4) {
/*  81 */       MemoryUtil.UNSAFE.putInt(null, Integer.toUnsignedLong(ptr + offset), i);
/*     */     }
/*     */ 
/*     */     
/*  85 */     if (offset < (limit & 0xFFFFFFFE)) {
/*  86 */       MemoryUtil.UNSAFE.putShort(null, Integer.toUnsignedLong(ptr + offset), (short)i);
/*  87 */       offset += 2;
/*     */     } 
/*     */     
/*  90 */     if (offset < limit) {
/*  91 */       MemoryUtil.UNSAFE.putByte(null, Integer.toUnsignedLong(ptr + offset), (byte)i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void memcpy(long src, long dst, long bytes) {
/*  97 */     if (Pointer.BITS64 && bytes <= 160L && ((src | dst) & 0x7L) == 0L) {
/*     */       
/*  99 */       memcpyAligned64(src, dst, bytes);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 104 */     LibCString.nmemcpy(dst, src, bytes);
/*     */   }
/*     */   private static void memcpyAligned64(long src, long dst, long bytes) {
/* 107 */     int limit = (int)bytes & 0xFF;
/*     */ 
/*     */     
/* 110 */     int offset = 0;
/* 111 */     for (int aligned = limit & 0xFFFFFFF8; offset < aligned; offset += 8) {
/* 112 */       MemoryUtil.UNSAFE.putLong(null, dst + offset, MemoryUtil.UNSAFE.getLong(null, src + offset));
/*     */     }
/*     */ 
/*     */     
/* 116 */     if (offset < (limit & 0xFFFFFFFC)) {
/* 117 */       MemoryUtil.UNSAFE.putInt(null, dst + offset, MemoryUtil.UNSAFE.getInt(null, src + offset));
/* 118 */       offset += 4;
/*     */     } 
/*     */     
/* 121 */     if (offset < (limit & 0xFFFFFFFE)) {
/* 122 */       MemoryUtil.UNSAFE.putShort(null, dst + offset, MemoryUtil.UNSAFE.getShort(null, src + offset));
/* 123 */       offset += 2;
/*     */     } 
/*     */     
/* 126 */     if (offset < limit) {
/* 127 */       MemoryUtil.UNSAFE.putByte(null, dst + offset, MemoryUtil.UNSAFE.getByte(null, src + offset));
/*     */     }
/*     */   }
/*     */   
/* 131 */   private static final long BASE_OFFSET_BYTE = Integer.toUnsignedLong(Unsafe.ARRAY_BYTE_BASE_OFFSET);
/* 132 */   private static final long BASE_OFFSET_SHORT = Integer.toUnsignedLong(Unsafe.ARRAY_SHORT_BASE_OFFSET);
/* 133 */   private static final long BASE_OFFSET_INT = Integer.toUnsignedLong(Unsafe.ARRAY_INT_BASE_OFFSET);
/* 134 */   private static final long BASE_OFFSET_LONG = Integer.toUnsignedLong(Unsafe.ARRAY_LONG_BASE_OFFSET);
/* 135 */   private static final long BASE_OFFSET_FLOAT = Integer.toUnsignedLong(Unsafe.ARRAY_FLOAT_BASE_OFFSET);
/* 136 */   private static final long BASE_OFFSET_DOUBLE = Integer.toUnsignedLong(Unsafe.ARRAY_DOUBLE_BASE_OFFSET);
/*     */   
/*     */   static void memcpy(byte[] src, long dst, int offset, int size) {
/* 139 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 140 */     MemoryUtil.UNSAFE.copyMemory(src, BASE_OFFSET_BYTE + offset, null, dst, size);
/*     */   }
/*     */   static void memcpy(short[] src, long dst, int offset, int size) {
/* 143 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 144 */     MemoryUtil.UNSAFE.copyMemory(src, BASE_OFFSET_SHORT + APIUtil.apiGetBytes(offset, 1), null, dst, APIUtil.apiGetBytes(size, 1));
/*     */   }
/*     */   static void memcpy(int[] src, long dst, int offset, int size) {
/* 147 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 148 */     MemoryUtil.UNSAFE.copyMemory(src, BASE_OFFSET_INT + APIUtil.apiGetBytes(offset, 2), null, dst, APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(long[] src, long dst, int offset, int size) {
/* 151 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 152 */     MemoryUtil.UNSAFE.copyMemory(src, BASE_OFFSET_LONG + APIUtil.apiGetBytes(offset, 3), null, dst, APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */   static void memcpy(float[] src, long dst, int offset, int size) {
/* 155 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 156 */     MemoryUtil.UNSAFE.copyMemory(src, BASE_OFFSET_FLOAT + APIUtil.apiGetBytes(offset, 2), null, dst, APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(double[] src, long dst, int offset, int size) {
/* 159 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 160 */     MemoryUtil.UNSAFE.copyMemory(src, BASE_OFFSET_DOUBLE + APIUtil.apiGetBytes(offset, 3), null, dst, APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */   
/*     */   static void memcpy(long src, byte[] dst, int offset, int size) {
/* 164 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 165 */     MemoryUtil.UNSAFE.copyMemory(null, src, dst, BASE_OFFSET_BYTE + offset, size);
/*     */   }
/*     */   static void memcpy(long src, short[] dst, int offset, int size) {
/* 168 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 169 */     MemoryUtil.UNSAFE.copyMemory(null, src, dst, BASE_OFFSET_SHORT + APIUtil.apiGetBytes(offset, 1), APIUtil.apiGetBytes(size, 1));
/*     */   }
/*     */   static void memcpy(long src, int[] dst, int offset, int size) {
/* 172 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 173 */     MemoryUtil.UNSAFE.copyMemory(null, src, dst, BASE_OFFSET_INT + APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(long src, long[] dst, int offset, int size) {
/* 176 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 177 */     MemoryUtil.UNSAFE.copyMemory(null, src, dst, BASE_OFFSET_LONG + APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */   static void memcpy(long src, float[] dst, int offset, int size) {
/* 180 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 181 */     MemoryUtil.UNSAFE.copyMemory(null, src, dst, BASE_OFFSET_FLOAT + APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(long src, double[] dst, int offset, int size) {
/* 184 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 185 */     MemoryUtil.UNSAFE.copyMemory(null, src, dst, BASE_OFFSET_DOUBLE + APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\MemoryUtilTunables.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */