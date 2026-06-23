/*     */ package META-INF.versions.25.org.lwjgl.system;
/*     */ 
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MemoryUtilTunables
/*     */ {
/*     */   private static final String PROPERTY_PATH = "java.lang.foreign.native.threshold.power.";
/*  17 */   private static final long NATIVE_THRESHOLD_FILL = powerOfPropertyOr("fill", 5);
/*     */   
/*     */   private static final long VECTOR_THRESHOLD_FILL = 16384L;
/*     */   private static final long VECTOR_THRESHOLD_BATCH = 16383L;
/*  21 */   private static final long NATIVE_THRESHOLD_COPY = powerOfPropertyOr("copy", 6);
/*     */   
/*     */   private static final long VECTOR_THRESHOLD_COPY = 16384L;
/*  24 */   private static final long FILL_PATTERN_64 = Long.divideUnsigned(-1L, 255L);
/*     */   
/*     */   static {
/*  27 */     APIUtil.apiLog("Java 25 memset/memcpy enabled");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long powerOfPropertyOr(String name, int defaultPower) {
/*  34 */     int power = Integer.getInteger("java.lang.foreign.native.threshold.power." + name, defaultPower).intValue();
/*  35 */     return 1L << Math.clamp(power, 0, 30);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void memset(long ptr, int value, long bytes) {
/*  44 */     byte b = (byte)(value & 0xFF);
/*     */     
/*  46 */     if (bytes < NATIVE_THRESHOLD_FILL) {
/*     */       
/*  48 */       MemorySegment.ofAddress(ptr)
/*  49 */         .reinterpret(bytes)
/*  50 */         .fill(b);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  61 */       long lastByteIndex = bytes - 1L;
/*     */ 
/*     */       
/*  64 */       MemorySegment.ofAddress(ptr)
/*  65 */         .reinterpret(lastByteIndex + (bytes & 0x1L))
/*  66 */         .fill(b);
/*     */ 
/*     */ 
/*     */       
/*  70 */       MemorySegment.ofAddress(ptr + lastByteIndex)
/*  71 */         .reinterpret(1L)
/*  72 */         .set(ValueLayout.JAVA_BYTE, 0L, b);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void memsetMid(long ptr, byte b, long bytes) {
/*  77 */     int limit = (int)(bytes & 0x3FFFL);
/*     */     
/*  79 */     long longValue = FILL_PATTERN_64 * b;
/*     */     
/*  81 */     int offset = 0;
/*  82 */     for (int aligned = limit & 0xFFFFFFF8; offset < aligned; offset += 8) {
/*  83 */       MemoryUtil.memPutLong(ptr + offset, longValue);
/*     */     }
/*     */     
/*  86 */     if (offset < (limit & 0xFFFFFFFC)) {
/*  87 */       MemoryUtil.memPutInt(ptr + offset, (int)longValue);
/*  88 */       offset += 4;
/*     */     } 
/*     */     
/*  91 */     if (offset < (limit & 0xFFFFFFFE)) {
/*  92 */       MemoryUtil.memPutShort(ptr + offset, (short)(int)longValue);
/*  93 */       offset += 2;
/*     */     } 
/*     */     
/*  96 */     if (offset < limit) {
/*  97 */       MemoryUtil.memPutByte(ptr + offset, b);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void memsetHigh(long ptr, byte b, long bytes) {
/* 102 */     long longValue = FILL_PATTERN_64 * b;
/*     */     
/* 104 */     int offset = 0;
/* 105 */     for (long aligned = bytes & 0xFFFFFFFFFFFFFFF8L; offset < aligned; offset += 8) {
/* 106 */       MemoryUtil.memPutLong(ptr + offset, longValue);
/*     */     }
/*     */     
/* 109 */     if (offset < (bytes & 0xFFFFFFFFFFFFFFFCL)) {
/* 110 */       MemoryUtil.memPutInt(ptr + offset, (int)longValue);
/* 111 */       offset += 4;
/*     */     } 
/*     */     
/* 114 */     if (offset < (bytes & 0xFFFFFFFFFFFFFFFEL)) {
/* 115 */       MemoryUtil.memPutShort(ptr + offset, (short)(int)longValue);
/* 116 */       offset += 2;
/*     */     } 
/*     */     
/* 119 */     if (offset < bytes) {
/* 120 */       MemoryUtil.memPutByte(ptr + offset, b);
/*     */     }
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
/*     */ 
/*     */ 
/*     */   
/*     */   static void memcpy(long src, long dst, long bytes) {
/* 151 */     if (bytes < NATIVE_THRESHOLD_COPY) {
/* 152 */       MemorySegment S = MemorySegment.ofAddress(src).reinterpret(bytes);
/* 153 */       MemorySegment D = MemorySegment.ofAddress(dst).reinterpret(bytes);
/*     */       
/* 155 */       D.copyFrom(S);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 166 */       long lastByteIndex = bytes - 1L;
/* 167 */       long copyBytes = lastByteIndex + (bytes & 0x1L);
/*     */       
/* 169 */       MemorySegment S = MemorySegment.ofAddress(src).reinterpret(copyBytes);
/* 170 */       MemorySegment D = MemorySegment.ofAddress(dst).reinterpret(copyBytes);
/*     */       
/* 172 */       D.copyFrom(S);
/*     */       
/* 174 */       MemoryUtil.memPutByte(dst + lastByteIndex, MemoryUtil.memGetByte(src + lastByteIndex));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void memcpyMid(long src, long dst, long bytes) {
/* 179 */     int limit = (int)(bytes & 0x3FFFL);
/*     */     
/* 181 */     int offset = 0;
/* 182 */     for (int aligned = limit & 0xFFFFFFF8; offset < aligned; offset += 8) {
/* 183 */       MemoryUtil.memPutLong(dst + offset, MemoryUtil.memGetLong(src + offset));
/*     */     }
/*     */ 
/*     */     
/* 187 */     if (offset < (limit & 0xFFFFFFFC)) {
/* 188 */       MemoryUtil.memPutInt(dst + offset, MemoryUtil.memGetInt(src + offset));
/* 189 */       offset += 4;
/*     */     } 
/*     */ 
/*     */     
/* 193 */     if (offset < (limit & 0xFFFFFFFE)) {
/* 194 */       MemoryUtil.memPutShort(dst + offset, MemoryUtil.memGetShort(src + offset));
/* 195 */       offset += 2;
/*     */     } 
/*     */ 
/*     */     
/* 199 */     if (offset < limit) {
/* 200 */       MemoryUtil.memPutByte(dst + offset, MemoryUtil.memGetByte(src + offset));
/*     */     }
/*     */   }
/*     */   
/*     */   private static void memcpyHigh(long src, long dst, long bytes) {
/* 205 */     long offset = 0L;
/* 206 */     for (long limit = bytes & 0xFFFFFFFFFFFFFFF8L; offset < limit; offset += 8L) {
/* 207 */       MemoryUtil.memPutLong(dst + offset, MemoryUtil.memGetLong(src + offset));
/*     */     }
/*     */ 
/*     */     
/* 211 */     if (offset < (bytes & 0xFFFFFFFFFFFFFFFCL)) {
/* 212 */       MemoryUtil.memPutInt(dst + offset, MemoryUtil.memGetInt(src + offset));
/* 213 */       offset += 4L;
/*     */     } 
/*     */ 
/*     */     
/* 217 */     if (offset < (bytes & 0xFFFFFFFFFFFFFFFEL)) {
/* 218 */       MemoryUtil.memPutShort(dst + offset, MemoryUtil.memGetShort(src + offset));
/* 219 */       offset += 2L;
/*     */     } 
/*     */ 
/*     */     
/* 223 */     if (offset < bytes) {
/* 224 */       MemoryUtil.memPutByte(dst + offset, MemoryUtil.memGetByte(src + offset));
/*     */     }
/*     */   }
/*     */   
/*     */   private static void memcpy(MemorySegment src, long dst, long offset, long bytes) {
/* 229 */     if (bytes < NATIVE_THRESHOLD_COPY) {
/* 230 */       MemorySegment S = src.asSlice(offset, bytes);
/* 231 */       MemorySegment D = MemorySegment.ofAddress(dst).reinterpret(bytes);
/*     */       
/* 233 */       D.copyFrom(S);
/*     */     } else {
/* 235 */       long lastByteIndex = bytes - 1L;
/* 236 */       long copyBytes = lastByteIndex + (bytes & 0x1L);
/*     */       
/* 238 */       MemorySegment S = src.asSlice(offset, copyBytes);
/* 239 */       MemorySegment D = MemorySegment.ofAddress(dst).reinterpret(copyBytes);
/*     */       
/* 241 */       D.copyFrom(S);
/*     */       
/* 243 */       MemoryUtil.memPutByte(dst + lastByteIndex, src.get(ValueLayout.JAVA_BYTE, offset + lastByteIndex));
/*     */     } 
/*     */   }
/*     */   static void memcpy(byte[] src, long dst, int offset, int size) {
/* 247 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 248 */     memcpy(MemorySegment.ofArray(src), dst, offset, size);
/*     */   }
/*     */   static void memcpy(short[] src, long dst, int offset, int size) {
/* 251 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 252 */     memcpy(MemorySegment.ofArray(src), dst, APIUtil.apiGetBytes(offset, 1), APIUtil.apiGetBytes(size, 1));
/*     */   }
/*     */   static void memcpy(int[] src, long dst, int offset, int size) {
/* 255 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 256 */     memcpy(MemorySegment.ofArray(src), dst, APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(long[] src, long dst, int offset, int size) {
/* 259 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 260 */     memcpy(MemorySegment.ofArray(src), dst, APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */   static void memcpy(float[] src, long dst, int offset, int size) {
/* 263 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 264 */     memcpy(MemorySegment.ofArray(src), dst, APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(double[] src, long dst, int offset, int size) {
/* 267 */     Checks.checkMemcpy(dst, offset, size, src.length);
/* 268 */     memcpy(MemorySegment.ofArray(src), dst, APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */   
/*     */   private static void memcpy(long src, MemorySegment dst, long offset, long bytes) {
/* 272 */     if (bytes < NATIVE_THRESHOLD_COPY) {
/* 273 */       MemorySegment S = MemorySegment.ofAddress(src).reinterpret(bytes);
/* 274 */       MemorySegment D = dst.asSlice(offset, bytes);
/*     */       
/* 276 */       D.copyFrom(S);
/*     */     } else {
/* 278 */       long lastByteIndex = bytes - 1L;
/* 279 */       long copyBytes = lastByteIndex + (bytes & 0x1L);
/*     */       
/* 281 */       MemorySegment S = MemorySegment.ofAddress(src).reinterpret(copyBytes);
/* 282 */       MemorySegment D = dst.asSlice(offset, copyBytes);
/*     */       
/* 284 */       D.copyFrom(S);
/*     */       
/* 286 */       dst.set(ValueLayout.JAVA_BYTE, offset + lastByteIndex, MemoryUtil.memGetByte(src + lastByteIndex));
/*     */     } 
/*     */   }
/*     */   static void memcpy(long src, byte[] dst, int offset, int size) {
/* 290 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 291 */     memcpy(src, MemorySegment.ofArray(dst), offset, size);
/*     */   }
/*     */   static void memcpy(long src, short[] dst, int offset, int size) {
/* 294 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 295 */     memcpy(src, MemorySegment.ofArray(dst), APIUtil.apiGetBytes(offset, 1), APIUtil.apiGetBytes(size, 1));
/*     */   }
/*     */   static void memcpy(long src, int[] dst, int offset, int size) {
/* 298 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 299 */     memcpy(src, MemorySegment.ofArray(dst), APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(long src, long[] dst, int offset, int size) {
/* 302 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 303 */     memcpy(src, MemorySegment.ofArray(dst), APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */   static void memcpy(long src, float[] dst, int offset, int size) {
/* 306 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 307 */     memcpy(src, MemorySegment.ofArray(dst), APIUtil.apiGetBytes(offset, 2), APIUtil.apiGetBytes(size, 2));
/*     */   }
/*     */   static void memcpy(long src, double[] dst, int offset, int size) {
/* 310 */     Checks.checkMemcpy(src, offset, size, dst.length);
/* 311 */     memcpy(src, MemorySegment.ofArray(dst), APIUtil.apiGetBytes(offset, 3), APIUtil.apiGetBytes(size, 3));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\MemoryUtilTunables.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */