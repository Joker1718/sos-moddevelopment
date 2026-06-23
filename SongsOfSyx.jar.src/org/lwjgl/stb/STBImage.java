/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class STBImage {
/*     */   public static final int STBI_default = 0;
/*     */   public static final int STBI_grey = 1;
/*     */   public static final int STBI_grey_alpha = 2;
/*     */   public static final int STBI_rgb = 3;
/*     */   public static final int STBI_rgb_alpha = 4;
/*     */   
/*     */   static {
/*  22 */     LibSTB.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected STBImage() {
/*  32 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/*  43 */     if (Checks.CHECKS) {
/*  44 */       Checks.checkNT1(filename);
/*  45 */       Checks.check(x, 1);
/*  46 */       Checks.check(y, 1);
/*  47 */       Checks.check(channels_in_file, 1);
/*     */     } 
/*  49 */     long __result = nstbi_load(MemoryUtil.memAddress(filename), MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/*  50 */     return MemoryUtil.memByteBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load(@NativeType("char const *") CharSequence filename, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/*  56 */     if (Checks.CHECKS) {
/*  57 */       Checks.check(x, 1);
/*  58 */       Checks.check(y, 1);
/*  59 */       Checks.check(channels_in_file, 1);
/*     */     } 
/*  61 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  63 */       stack.nUTF8(filename, true);
/*  64 */       long filenameEncoded = stack.getPointerAddress();
/*  65 */       long __result = nstbi_load(filenameEncoded, MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/*  66 */       return MemoryUtil.memByteBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */     } finally {
/*  68 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/*  80 */     if (Checks.CHECKS) {
/*  81 */       Checks.check(x, 1);
/*  82 */       Checks.check(y, 1);
/*  83 */       Checks.check(channels_in_file, 1);
/*     */     } 
/*  85 */     long __result = nstbi_load_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/*  86 */     return MemoryUtil.memByteBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check(x, 1);
/*  99 */       Checks.check(y, 1);
/* 100 */       Checks.check(channels_in_file, 1);
/* 101 */       STBIIOCallbacks.validate(clbk.address());
/*     */     } 
/* 103 */     long __result = nstbi_load_from_callbacks(clbk.address(), user, MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 104 */     return MemoryUtil.memByteBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load_gif_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int **") PointerBuffer delays, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer z, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/* 115 */     if (Checks.CHECKS) {
/* 116 */       Checks.check((CustomBuffer)delays, 1);
/* 117 */       Checks.check(x, 1);
/* 118 */       Checks.check(y, 1);
/* 119 */       Checks.check(z, 1);
/* 120 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 122 */     long __result = nstbi_load_gif_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), MemoryUtil.memAddress((CustomBuffer)delays), MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(z), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 123 */     return MemoryUtil.memByteBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * z.get(z.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_us *")
/*     */   public static ShortBuffer stbi_load_16(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/* 134 */     if (Checks.CHECKS) {
/* 135 */       Checks.checkNT1(filename);
/* 136 */       Checks.check(x, 1);
/* 137 */       Checks.check(y, 1);
/* 138 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 140 */     long __result = nstbi_load_16(MemoryUtil.memAddress(filename), MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 141 */     return MemoryUtil.memShortBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("stbi_us *")
/*     */   public static ShortBuffer stbi_load_16(@NativeType("char const *") CharSequence filename, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/* 147 */     if (Checks.CHECKS) {
/* 148 */       Checks.check(x, 1);
/* 149 */       Checks.check(y, 1);
/* 150 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 152 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 154 */       stack.nUTF8(filename, true);
/* 155 */       long filenameEncoded = stack.getPointerAddress();
/* 156 */       long __result = nstbi_load_16(filenameEncoded, MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 157 */       return MemoryUtil.memShortBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */     } finally {
/* 159 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_us *")
/*     */   public static ShortBuffer stbi_load_16_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/* 171 */     if (Checks.CHECKS) {
/* 172 */       Checks.check(x, 1);
/* 173 */       Checks.check(y, 1);
/* 174 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 176 */     long __result = nstbi_load_16_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 177 */     return MemoryUtil.memShortBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_us *")
/*     */   public static ShortBuffer stbi_load_16_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/* 188 */     if (Checks.CHECKS) {
/* 189 */       Checks.check(x, 1);
/* 190 */       Checks.check(y, 1);
/* 191 */       Checks.check(channels_in_file, 1);
/* 192 */       STBIIOCallbacks.validate(clbk.address());
/*     */     } 
/* 194 */     long __result = nstbi_load_16_from_callbacks(clbk.address(), user, MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 195 */     return MemoryUtil.memShortBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbi_loadf(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/* 206 */     if (Checks.CHECKS) {
/* 207 */       Checks.checkNT1(filename);
/* 208 */       Checks.check(x, 1);
/* 209 */       Checks.check(y, 1);
/* 210 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 212 */     long __result = nstbi_loadf(MemoryUtil.memAddress(filename), MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 213 */     return MemoryUtil.memFloatBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbi_loadf(@NativeType("char const *") CharSequence filename, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/* 219 */     if (Checks.CHECKS) {
/* 220 */       Checks.check(x, 1);
/* 221 */       Checks.check(y, 1);
/* 222 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 224 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 226 */       stack.nUTF8(filename, true);
/* 227 */       long filenameEncoded = stack.getPointerAddress();
/* 228 */       long __result = nstbi_loadf(filenameEncoded, MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 229 */       return MemoryUtil.memFloatBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */     } finally {
/* 231 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbi_loadf_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/* 243 */     if (Checks.CHECKS) {
/* 244 */       Checks.check(x, 1);
/* 245 */       Checks.check(y, 1);
/* 246 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 248 */     long __result = nstbi_loadf_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 249 */     return MemoryUtil.memFloatBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbi_loadf_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer channels_in_file, int desired_channels) {
/* 260 */     if (Checks.CHECKS) {
/* 261 */       Checks.check(x, 1);
/* 262 */       Checks.check(y, 1);
/* 263 */       Checks.check(channels_in_file, 1);
/* 264 */       STBIIOCallbacks.validate(clbk.address());
/*     */     } 
/* 266 */     long __result = nstbi_loadf_from_callbacks(clbk.address(), user, MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(channels_in_file), desired_channels);
/* 267 */     return MemoryUtil.memFloatBufferSafe(__result, x.get(x.position()) * y.get(y.position()) * ((desired_channels != 0) ? desired_channels : channels_in_file.get(channels_in_file.position())));
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
/*     */   @NativeType("int")
/*     */   public static boolean stbi_is_hdr(@NativeType("char const *") ByteBuffer filename) {
/* 298 */     if (Checks.CHECKS) {
/* 299 */       Checks.checkNT1(filename);
/*     */     }
/* 301 */     return (nstbi_is_hdr(MemoryUtil.memAddress(filename)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_is_hdr(@NativeType("char const *") CharSequence filename) {
/* 307 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 309 */       stack.nUTF8(filename, true);
/* 310 */       long filenameEncoded = stack.getPointerAddress();
/* 311 */       return (nstbi_is_hdr(filenameEncoded) != 0);
/*     */     } finally {
/* 313 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_is_hdr_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer) {
/* 325 */     return (nstbi_is_hdr_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining()) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_is_hdr_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user) {
/* 336 */     if (Checks.CHECKS) {
/* 337 */       STBIIOCallbacks.validate(clbk.address());
/*     */     }
/* 339 */     return (nstbi_is_hdr_from_callbacks(clbk.address(), user) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char const *")
/*     */   public static String stbi_failure_reason() {
/* 350 */     long __result = nstbi_failure_reason();
/* 351 */     return MemoryUtil.memASCIISafe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbi_image_free(@NativeType("void *") ByteBuffer retval_from_stbi_load) {
/* 361 */     nstbi_image_free(MemoryUtil.memAddress(retval_from_stbi_load));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void stbi_image_free(@NativeType("void *") ShortBuffer retval_from_stbi_load) {
/* 366 */     nstbi_image_free(MemoryUtil.memAddress(retval_from_stbi_load));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void stbi_image_free(@NativeType("void *") FloatBuffer retval_from_stbi_load) {
/* 371 */     nstbi_image_free(MemoryUtil.memAddress(retval_from_stbi_load));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_info(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer comp) {
/* 382 */     if (Checks.CHECKS) {
/* 383 */       Checks.checkNT1(filename);
/* 384 */       Checks.check(x, 1);
/* 385 */       Checks.check(y, 1);
/* 386 */       Checks.check(comp, 1);
/*     */     } 
/* 388 */     return (nstbi_info(MemoryUtil.memAddress(filename), MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(comp)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_info(@NativeType("char const *") CharSequence filename, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer comp) {
/* 394 */     if (Checks.CHECKS) {
/* 395 */       Checks.check(x, 1);
/* 396 */       Checks.check(y, 1);
/* 397 */       Checks.check(comp, 1);
/*     */     } 
/* 399 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 401 */       stack.nUTF8(filename, true);
/* 402 */       long filenameEncoded = stack.getPointerAddress();
/* 403 */       return (nstbi_info(filenameEncoded, MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(comp)) != 0);
/*     */     } finally {
/* 405 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_info_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer comp) {
/* 417 */     if (Checks.CHECKS) {
/* 418 */       Checks.check(x, 1);
/* 419 */       Checks.check(y, 1);
/* 420 */       Checks.check(comp, 1);
/*     */     } 
/* 422 */     return (nstbi_info_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(comp)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_info_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user, @NativeType("int *") IntBuffer x, @NativeType("int *") IntBuffer y, @NativeType("int *") IntBuffer comp) {
/* 433 */     if (Checks.CHECKS) {
/* 434 */       Checks.check(x, 1);
/* 435 */       Checks.check(y, 1);
/* 436 */       Checks.check(comp, 1);
/* 437 */       STBIIOCallbacks.validate(clbk.address());
/*     */     } 
/* 439 */     return (nstbi_info_from_callbacks(clbk.address(), user, MemoryUtil.memAddress(x), MemoryUtil.memAddress(y), MemoryUtil.memAddress(comp)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_is_16_bit(@NativeType("char const *") ByteBuffer filename) {
/* 450 */     if (Checks.CHECKS) {
/* 451 */       Checks.checkNT1(filename);
/*     */     }
/* 453 */     return (nstbi_is_16_bit(MemoryUtil.memAddress(filename)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_is_16_bit(@NativeType("char const *") CharSequence filename) {
/* 459 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 461 */       stack.nUTF8(filename, true);
/* 462 */       long filenameEncoded = stack.getPointerAddress();
/* 463 */       return (nstbi_is_16_bit(filenameEncoded) != 0);
/*     */     } finally {
/* 465 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_is_16_bit_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer) {
/* 477 */     return (nstbi_is_16_bit_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining()) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_is_16_bit_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user) {
/* 488 */     if (Checks.CHECKS) {
/* 489 */       STBIIOCallbacks.validate(clbk.address());
/*     */     }
/* 491 */     return (nstbi_is_16_bit_from_callbacks(clbk.address(), user) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbi_set_unpremultiply_on_load(@NativeType("int") boolean flag_true_if_should_unpremultiply) {
/* 501 */     nstbi_set_unpremultiply_on_load(flag_true_if_should_unpremultiply ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbi_convert_iphone_png_to_rgb(@NativeType("int") boolean flag_true_if_should_convert) {
/* 511 */     nstbi_convert_iphone_png_to_rgb(flag_true_if_should_convert ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbi_set_flip_vertically_on_load(@NativeType("int") boolean flag_true_if_should_flip) {
/* 521 */     nstbi_set_flip_vertically_on_load(flag_true_if_should_flip ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbi_set_unpremultiply_on_load_thread(@NativeType("int") boolean flag_true_if_should_unpremultiply) {
/* 531 */     nstbi_set_unpremultiply_on_load_thread(flag_true_if_should_unpremultiply ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbi_convert_iphone_png_to_rgb_thread(@NativeType("int") boolean flag_true_if_should_convert) {
/* 541 */     nstbi_convert_iphone_png_to_rgb_thread(flag_true_if_should_convert ? 1 : 0);
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
/*     */   @NativeType("char *")
/*     */   public static ByteBuffer stbi_zlib_decode_malloc_guesssize(@NativeType("char const *") ByteBuffer buffer, int initial_size) {
/* 557 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 559 */       IntBuffer outlen = stack.callocInt(1);
/* 560 */       long __result = nstbi_zlib_decode_malloc_guesssize(MemoryUtil.memAddress(buffer), buffer.remaining(), initial_size, MemoryUtil.memAddress(outlen));
/* 561 */       return MemoryUtil.memByteBufferSafe(__result, outlen.get(0));
/*     */     } finally {
/* 563 */       stack.setPointer(stackPointer);
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
/*     */   public static ByteBuffer stbi_zlib_decode_malloc_guesssize_headerflag(@NativeType("char const *") ByteBuffer buffer, int initial_size, @NativeType("int") boolean parse_header) {
/* 575 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 577 */       IntBuffer outlen = stack.callocInt(1);
/* 578 */       long __result = nstbi_zlib_decode_malloc_guesssize_headerflag(MemoryUtil.memAddress(buffer), buffer.remaining(), initial_size, MemoryUtil.memAddress(outlen), parse_header ? 1 : 0);
/* 579 */       return MemoryUtil.memByteBufferSafe(__result, outlen.get(0));
/*     */     } finally {
/* 581 */       stack.setPointer(stackPointer);
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
/*     */   public static ByteBuffer stbi_zlib_decode_malloc(@NativeType("char const *") ByteBuffer buffer) {
/* 593 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 595 */       IntBuffer outlen = stack.callocInt(1);
/* 596 */       long __result = nstbi_zlib_decode_malloc(MemoryUtil.memAddress(buffer), buffer.remaining(), MemoryUtil.memAddress(outlen));
/* 597 */       return MemoryUtil.memByteBufferSafe(__result, outlen.get(0));
/*     */     } finally {
/* 599 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbi_zlib_decode_buffer(@NativeType("char *") ByteBuffer obuffer, @NativeType("char const *") ByteBuffer ibuffer) {
/* 610 */     return nstbi_zlib_decode_buffer(MemoryUtil.memAddress(obuffer), obuffer.remaining(), MemoryUtil.memAddress(ibuffer), ibuffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char *")
/*     */   public static ByteBuffer stbi_zlib_decode_noheader_malloc(@NativeType("char const *") ByteBuffer buffer) {
/* 621 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 623 */       IntBuffer outlen = stack.callocInt(1);
/* 624 */       long __result = nstbi_zlib_decode_noheader_malloc(MemoryUtil.memAddress(buffer), buffer.remaining(), MemoryUtil.memAddress(outlen));
/* 625 */       return MemoryUtil.memByteBufferSafe(__result, outlen.get(0));
/*     */     } finally {
/* 627 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbi_zlib_decode_noheader_buffer(@NativeType("char *") ByteBuffer obuffer, @NativeType("char const *") ByteBuffer ibuffer) {
/* 638 */     return nstbi_zlib_decode_noheader_buffer(MemoryUtil.memAddress(obuffer), obuffer.remaining(), MemoryUtil.memAddress(ibuffer), ibuffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 647 */     if (Checks.CHECKS) {
/* 648 */       Checks.checkNT1(filename);
/* 649 */       Checks.check(x, 1);
/* 650 */       Checks.check(y, 1);
/* 651 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 653 */     long __result = nstbi_load(MemoryUtil.memAddress(filename), x, y, channels_in_file, desired_channels);
/* 654 */     return MemoryUtil.memByteBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load(@NativeType("char const *") CharSequence filename, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 660 */     if (Checks.CHECKS) {
/* 661 */       Checks.check(x, 1);
/* 662 */       Checks.check(y, 1);
/* 663 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 665 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 667 */       stack.nUTF8(filename, true);
/* 668 */       long filenameEncoded = stack.getPointerAddress();
/* 669 */       long __result = nstbi_load(filenameEncoded, x, y, channels_in_file, desired_channels);
/* 670 */       return MemoryUtil.memByteBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */     } finally {
/* 672 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 682 */     if (Checks.CHECKS) {
/* 683 */       Checks.check(x, 1);
/* 684 */       Checks.check(y, 1);
/* 685 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 687 */     long __result = nstbi_load_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), x, y, channels_in_file, desired_channels);
/* 688 */     return MemoryUtil.memByteBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 697 */     if (Checks.CHECKS) {
/* 698 */       Checks.check(x, 1);
/* 699 */       Checks.check(y, 1);
/* 700 */       Checks.check(channels_in_file, 1);
/* 701 */       STBIIOCallbacks.validate(clbk.address());
/*     */     } 
/* 703 */     long __result = nstbi_load_from_callbacks(clbk.address(), user, x, y, channels_in_file, desired_channels);
/* 704 */     return MemoryUtil.memByteBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_uc *")
/*     */   public static ByteBuffer stbi_load_gif_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int **") PointerBuffer delays, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] z, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 713 */     if (Checks.CHECKS) {
/* 714 */       Checks.check((CustomBuffer)delays, 1);
/* 715 */       Checks.check(x, 1);
/* 716 */       Checks.check(y, 1);
/* 717 */       Checks.check(z, 1);
/* 718 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 720 */     long __result = nstbi_load_gif_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), MemoryUtil.memAddress((CustomBuffer)delays), x, y, z, channels_in_file, desired_channels);
/* 721 */     return MemoryUtil.memByteBufferSafe(__result, x[0] * y[0] * z[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_us *")
/*     */   public static ShortBuffer stbi_load_16(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 730 */     if (Checks.CHECKS) {
/* 731 */       Checks.checkNT1(filename);
/* 732 */       Checks.check(x, 1);
/* 733 */       Checks.check(y, 1);
/* 734 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 736 */     long __result = nstbi_load_16(MemoryUtil.memAddress(filename), x, y, channels_in_file, desired_channels);
/* 737 */     return MemoryUtil.memShortBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("stbi_us *")
/*     */   public static ShortBuffer stbi_load_16(@NativeType("char const *") CharSequence filename, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 743 */     if (Checks.CHECKS) {
/* 744 */       Checks.check(x, 1);
/* 745 */       Checks.check(y, 1);
/* 746 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 748 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 750 */       stack.nUTF8(filename, true);
/* 751 */       long filenameEncoded = stack.getPointerAddress();
/* 752 */       long __result = nstbi_load_16(filenameEncoded, x, y, channels_in_file, desired_channels);
/* 753 */       return MemoryUtil.memShortBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */     } finally {
/* 755 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_us *")
/*     */   public static ShortBuffer stbi_load_16_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 765 */     if (Checks.CHECKS) {
/* 766 */       Checks.check(x, 1);
/* 767 */       Checks.check(y, 1);
/* 768 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 770 */     long __result = nstbi_load_16_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), x, y, channels_in_file, desired_channels);
/* 771 */     return MemoryUtil.memShortBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbi_us *")
/*     */   public static ShortBuffer stbi_load_16_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 780 */     if (Checks.CHECKS) {
/* 781 */       Checks.check(x, 1);
/* 782 */       Checks.check(y, 1);
/* 783 */       Checks.check(channels_in_file, 1);
/* 784 */       STBIIOCallbacks.validate(clbk.address());
/*     */     } 
/* 786 */     long __result = nstbi_load_16_from_callbacks(clbk.address(), user, x, y, channels_in_file, desired_channels);
/* 787 */     return MemoryUtil.memShortBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbi_loadf(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 796 */     if (Checks.CHECKS) {
/* 797 */       Checks.checkNT1(filename);
/* 798 */       Checks.check(x, 1);
/* 799 */       Checks.check(y, 1);
/* 800 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 802 */     long __result = nstbi_loadf(MemoryUtil.memAddress(filename), x, y, channels_in_file, desired_channels);
/* 803 */     return MemoryUtil.memFloatBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbi_loadf(@NativeType("char const *") CharSequence filename, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 809 */     if (Checks.CHECKS) {
/* 810 */       Checks.check(x, 1);
/* 811 */       Checks.check(y, 1);
/* 812 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 814 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 816 */       stack.nUTF8(filename, true);
/* 817 */       long filenameEncoded = stack.getPointerAddress();
/* 818 */       long __result = nstbi_loadf(filenameEncoded, x, y, channels_in_file, desired_channels);
/* 819 */       return MemoryUtil.memFloatBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */     } finally {
/* 821 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbi_loadf_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 831 */     if (Checks.CHECKS) {
/* 832 */       Checks.check(x, 1);
/* 833 */       Checks.check(y, 1);
/* 834 */       Checks.check(channels_in_file, 1);
/*     */     } 
/* 836 */     long __result = nstbi_loadf_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), x, y, channels_in_file, desired_channels);
/* 837 */     return MemoryUtil.memFloatBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbi_loadf_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] channels_in_file, int desired_channels) {
/* 846 */     if (Checks.CHECKS) {
/* 847 */       Checks.check(x, 1);
/* 848 */       Checks.check(y, 1);
/* 849 */       Checks.check(channels_in_file, 1);
/* 850 */       STBIIOCallbacks.validate(clbk.address());
/*     */     } 
/* 852 */     long __result = nstbi_loadf_from_callbacks(clbk.address(), user, x, y, channels_in_file, desired_channels);
/* 853 */     return MemoryUtil.memFloatBufferSafe(__result, x[0] * y[0] * ((desired_channels != 0) ? desired_channels : channels_in_file[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_info(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] comp) {
/* 862 */     if (Checks.CHECKS) {
/* 863 */       Checks.checkNT1(filename);
/* 864 */       Checks.check(x, 1);
/* 865 */       Checks.check(y, 1);
/* 866 */       Checks.check(comp, 1);
/*     */     } 
/* 868 */     return (nstbi_info(MemoryUtil.memAddress(filename), x, y, comp) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_info(@NativeType("char const *") CharSequence filename, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] comp) {
/* 874 */     if (Checks.CHECKS) {
/* 875 */       Checks.check(x, 1);
/* 876 */       Checks.check(y, 1);
/* 877 */       Checks.check(comp, 1);
/*     */     } 
/* 879 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 881 */       stack.nUTF8(filename, true);
/* 882 */       long filenameEncoded = stack.getPointerAddress();
/* 883 */       return (nstbi_info(filenameEncoded, x, y, comp) != 0);
/*     */     } finally {
/* 885 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_info_from_memory(@NativeType("stbi_uc const *") ByteBuffer buffer, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] comp) {
/* 895 */     if (Checks.CHECKS) {
/* 896 */       Checks.check(x, 1);
/* 897 */       Checks.check(y, 1);
/* 898 */       Checks.check(comp, 1);
/*     */     } 
/* 900 */     return (nstbi_info_from_memory(MemoryUtil.memAddress(buffer), buffer.remaining(), x, y, comp) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_info_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks clbk, @NativeType("void *") long user, @NativeType("int *") int[] x, @NativeType("int *") int[] y, @NativeType("int *") int[] comp) {
/* 909 */     if (Checks.CHECKS) {
/* 910 */       Checks.check(x, 1);
/* 911 */       Checks.check(y, 1);
/* 912 */       Checks.check(comp, 1);
/* 913 */       STBIIOCallbacks.validate(clbk.address());
/*     */     } 
/* 915 */     return (nstbi_info_from_callbacks(clbk.address(), user, x, y, comp) != 0);
/*     */   }
/*     */   
/*     */   public static native long nstbi_load(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*     */   
/*     */   public static native long nstbi_load_from_memory(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2);
/*     */   
/*     */   public static native long nstbi_load_from_callbacks(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt);
/*     */   
/*     */   public static native long nstbi_load_gif_from_memory(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2);
/*     */   
/*     */   public static native long nstbi_load_16(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*     */   
/*     */   public static native long nstbi_load_16_from_memory(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2);
/*     */   
/*     */   public static native long nstbi_load_16_from_callbacks(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt);
/*     */   
/*     */   public static native long nstbi_loadf(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*     */   
/*     */   public static native long nstbi_loadf_from_memory(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2);
/*     */   
/*     */   public static native long nstbi_loadf_from_callbacks(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt);
/*     */   
/*     */   public static native void stbi_hdr_to_ldr_gamma(float paramFloat);
/*     */   
/*     */   public static native void stbi_hdr_to_ldr_scale(float paramFloat);
/*     */   
/*     */   public static native void stbi_ldr_to_hdr_gamma(float paramFloat);
/*     */   
/*     */   public static native void stbi_ldr_to_hdr_scale(float paramFloat);
/*     */   
/*     */   public static native int nstbi_is_hdr(long paramLong);
/*     */   
/*     */   public static native int nstbi_is_hdr_from_memory(long paramLong, int paramInt);
/*     */   
/*     */   public static native int nstbi_is_hdr_from_callbacks(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nstbi_failure_reason();
/*     */   
/*     */   public static native void nstbi_image_free(long paramLong);
/*     */   
/*     */   public static native int nstbi_info(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nstbi_info_from_memory(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nstbi_info_from_callbacks(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*     */   
/*     */   public static native int nstbi_is_16_bit(long paramLong);
/*     */   
/*     */   public static native int nstbi_is_16_bit_from_memory(long paramLong, int paramInt);
/*     */   
/*     */   public static native int nstbi_is_16_bit_from_callbacks(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nstbi_set_unpremultiply_on_load(int paramInt);
/*     */   
/*     */   public static native void nstbi_convert_iphone_png_to_rgb(int paramInt);
/*     */   
/*     */   public static native void nstbi_set_flip_vertically_on_load(int paramInt);
/*     */   
/*     */   public static native void nstbi_set_unpremultiply_on_load_thread(int paramInt);
/*     */   
/*     */   public static native void nstbi_convert_iphone_png_to_rgb_thread(int paramInt);
/*     */   
/*     */   public static native void stbi_set_flip_vertically_on_load_thread(int paramInt);
/*     */   
/*     */   public static native long nstbi_zlib_decode_malloc_guesssize(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*     */   
/*     */   public static native long nstbi_zlib_decode_malloc_guesssize_headerflag(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*     */   
/*     */   public static native long nstbi_zlib_decode_malloc(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native int nstbi_zlib_decode_buffer(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native long nstbi_zlib_decode_noheader_malloc(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native int nstbi_zlib_decode_noheader_buffer(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native long nstbi_load(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*     */   
/*     */   public static native long nstbi_load_from_memory(long paramLong, int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt2);
/*     */   
/*     */   public static native long nstbi_load_from_callbacks(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*     */   
/*     */   public static native long nstbi_load_gif_from_memory(long paramLong1, int paramInt1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, int paramInt2);
/*     */   
/*     */   public static native long nstbi_load_16(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*     */   
/*     */   public static native long nstbi_load_16_from_memory(long paramLong, int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt2);
/*     */   
/*     */   public static native long nstbi_load_16_from_callbacks(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*     */   
/*     */   public static native long nstbi_loadf(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*     */   
/*     */   public static native long nstbi_loadf_from_memory(long paramLong, int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt2);
/*     */   
/*     */   public static native long nstbi_loadf_from_callbacks(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*     */   
/*     */   public static native int nstbi_info(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*     */   
/*     */   public static native int nstbi_info_from_memory(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*     */   
/*     */   public static native int nstbi_info_from_callbacks(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */