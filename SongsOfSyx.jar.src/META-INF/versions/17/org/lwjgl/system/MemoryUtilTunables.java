/*     */ package META-INF.versions.17.org.lwjgl.system;
/*     */ 
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.Pointer;
/*     */ import org.lwjgl.system.libc.LibCString;
/*     */ import sun.misc.Unsafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MemoryUtilTunables
/*     */ {
/*  16 */   private static final int FILL_PATTERN_32 = Integer.divideUnsigned(-1, 255);
/*  17 */   private static final long FILL_PATTERN_64 = Long.divideUnsigned(-1L, 255L);
/*     */   
/*     */   static {
/*  20 */     APIUtil.apiLog("Java 17 memcpy enabled");
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
/*     */   static void memset(long ptr, int value, long bytes) {
/*  32 */     if (bytes < 256L) {
/*  33 */       int p = (int)ptr;
/*  34 */       if (Pointer.BITS64) {
/*  35 */         if ((p & 0x7) == 0) {
/*  36 */           memset64(ptr, value, bytes);
/*     */           
/*     */           return;
/*     */         } 
/*  40 */       } else if ((p & 0x3) == 0) {
/*  41 */         memset32(p, value, bytes);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  46 */     LibCString.nmemset(ptr, value, bytes);
/*     */   }
/*     */   
/*     */   private static void memset64(long ptr, int value, long bytes) {
/*  50 */     int limit = (int)bytes & 0xFF;
/*     */     
/*  52 */     long l = (value & 0xFF) * FILL_PATTERN_64;
/*     */     
/*  54 */     int offset = 0;
/*     */ 
/*     */     
/*  57 */     for (int aligned = limit & 0xFFFFFFF8; offset < aligned; offset += 8) {
/*  58 */       MemoryUtil.UNSAFE.putLong(null, ptr + offset, l);
/*     */     }
/*     */ 
/*     */     
/*  62 */     if (offset < (limit & 0xFFFFFFFC)) {
/*  63 */       MemoryUtil.UNSAFE.putInt(null, ptr + offset, (int)l);
/*  64 */       offset += 4;
/*     */     } 
/*     */     
/*  67 */     if (offset < (limit & 0xFFFFFFFE)) {
/*  68 */       MemoryUtil.UNSAFE.putShort(null, ptr + offset, (short)(int)l);
/*  69 */       offset += 2;
/*     */     } 
/*     */     
/*  72 */     if (offset < limit) {
/*  73 */       MemoryUtil.UNSAFE.putByte(null, ptr + offset, (byte)(int)l);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void memset32(int ptr, int value, long bytes) {
/*  78 */     int limit = (int)bytes & 0xFF;
/*     */     
/*  80 */     int i = (value & 0xFF) * FILL_PATTERN_32;
/*     */     
/*  82 */     int offset = 0;
/*     */ 
/*     */     
/*  85 */     for (int aligned = limit & 0xFFFFFFFC; offset < aligned; offset += 4) {
/*  86 */       MemoryUtil.UNSAFE.putInt(null, (ptr + offset) & 0xFFFFFFFFL, i);
/*     */     }
/*     */ 
/*     */     
/*  90 */     if (offset < (limit & 0xFFFFFFFE)) {
/*  91 */       MemoryUtil.UNSAFE.putShort(null, (ptr + offset), (short)i);
/*  92 */       offset += 2;
/*     */     } 
/*     */     
/*  95 */     if (offset < limit) {
/*  96 */       MemoryUtil.UNSAFE.putByte(null, (ptr + offset), (byte)i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void memcpy(long src, long dst, long bytes) {
/* 107 */     if (bytes <= 0L) {
/*     */       return;
/*     */     }
/*     */     
/* 111 */     long lastByteIndex = bytes - 1L;
/* 112 */     MemoryUtil.UNSAFE.copyMemory(null, src, null, dst, lastByteIndex + (bytes & 0x1L));
/* 113 */     MemoryUtil.UNSAFE.putByte(null, dst + lastByteIndex, MemoryUtil.UNSAFE.getByte(null, src + lastByteIndex));
/*     */   }
/*     */   
/* 116 */   private static final long BASE_OFFSET_BYTE = Integer.toUnsignedLong(Unsafe.ARRAY_BYTE_BASE_OFFSET);
/* 117 */   private static final long BASE_OFFSET_SHORT = Integer.toUnsignedLong(Unsafe.ARRAY_SHORT_BASE_OFFSET);
/* 118 */   private static final long BASE_OFFSET_INT = Integer.toUnsignedLong(Unsafe.ARRAY_INT_BASE_OFFSET);
/* 119 */   private static final long BASE_OFFSET_LONG = Integer.toUnsignedLong(Unsafe.ARRAY_LONG_BASE_OFFSET);
/* 120 */   private static final long BASE_OFFSET_FLOAT = Integer.toUnsignedLong(Unsafe.ARRAY_FLOAT_BASE_OFFSET);
/* 121 */   private static final long BASE_OFFSET_DOUBLE = Integer.toUnsignedLong(Unsafe.ARRAY_DOUBLE_BASE_OFFSET);
/*     */   
/*     */   private static void memcpy(Object src, long dst, long srcOffset, long bytes) {
/* 124 */     if (bytes <= 0L) {
/*     */       return;
/*     */     }
/*     */     
/* 128 */     long lastByteIndex = bytes - 1L;
/*     */     
/* 130 */     MemoryUtil.UNSAFE.copyMemory(src, srcOffset, null, dst, lastByteIndex + (bytes & 0x1L));
/* 131 */     MemoryUtil.UNSAFE.putByte(null, dst + lastByteIndex, MemoryUtil.UNSAFE.getByte(src, srcOffset + lastByteIndex));
/*     */   }
/*     */   static void memcpy(byte[] src, long dst, int offset, int size) {
/* 134 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 135 */     memcpy(src, dst, BASE_OFFSET_BYTE + offset, size);
/*     */   }
/*     */   static void memcpy(short[] src, long dst, int offset, int size) {
/* 138 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 139 */     memcpy(src, dst, BASE_OFFSET_SHORT + APIUtil.apiGetBytes(offset, 1), APIUtil.apiGetBytes(size, 1));
/*     */   }
/*     */   static void memcpy(int[] src, long dst, int offset, int size) {
/* 142 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 143 */     memcpy(src, dst, BASE_OFFSET_INT + APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(long[] src, long dst, int offset, int size) {
/* 146 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 147 */     memcpy(src, dst, BASE_OFFSET_LONG + APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */   static void memcpy(float[] src, long dst, int offset, int size) {
/* 150 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 151 */     memcpy(src, dst, BASE_OFFSET_FLOAT + APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(double[] src, long dst, int offset, int size) {
/* 154 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 155 */     memcpy(src, dst, BASE_OFFSET_DOUBLE + APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */   
/*     */   private static void memcpy(long src, Object dst, long dstOffset, long bytes) {
/* 159 */     if (bytes <= 0L) {
/*     */       return;
/*     */     }
/*     */     
/* 163 */     long lastByteIndex = bytes - 1L;
/*     */     
/* 165 */     MemoryUtil.UNSAFE.copyMemory(null, src, dst, dstOffset, lastByteIndex + (bytes & 0x1L));
/* 166 */     MemoryUtil.UNSAFE.putByte(dst, dstOffset + lastByteIndex, MemoryUtil.UNSAFE.getByte(null, src + lastByteIndex));
/*     */   }
/*     */   static void memcpy(long src, byte[] dst, int offset, int size) {
/* 169 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 170 */     memcpy(src, dst, BASE_OFFSET_BYTE + offset, size);
/*     */   }
/*     */   static void memcpy(long src, short[] dst, int offset, int size) {
/* 173 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 174 */     memcpy(src, dst, BASE_OFFSET_SHORT + APIUtil.apiGetBytes(offset, 1), APIUtil.apiGetBytes(size, 1));
/*     */   }
/*     */   static void memcpy(long src, int[] dst, int offset, int size) {
/* 177 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 178 */     memcpy(src, dst, BASE_OFFSET_INT + APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(long src, long[] dst, int offset, int size) {
/* 181 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 182 */     memcpy(src, dst, BASE_OFFSET_LONG + APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */   static void memcpy(long src, float[] dst, int offset, int size) {
/* 185 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 186 */     memcpy(src, dst, BASE_OFFSET_FLOAT + APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(long src, double[] dst, int offset, int size) {
/* 189 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 190 */     memcpy(src, dst, BASE_OFFSET_DOUBLE + APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\17\org\lwjgl\system\MemoryUtilTunables.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */