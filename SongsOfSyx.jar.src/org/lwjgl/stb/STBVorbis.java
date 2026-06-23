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
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ public class STBVorbis
/*     */ {
/*     */   public static final int VORBIS__no_error = 0;
/*     */   public static final int VORBIS_need_more_data = 1;
/*     */   public static final int VORBIS_invalid_api_mixing = 2;
/*     */   public static final int VORBIS_outofmem = 3;
/*     */   public static final int VORBIS_feature_not_supported = 4;
/*     */   
/*     */   static {
/*  24 */     LibSTB.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int VORBIS_too_many_channels = 5;
/*     */   
/*     */   public static final int VORBIS_file_open_failure = 6;
/*     */   
/*     */   public static final int VORBIS_seek_without_length = 7;
/*     */   
/*     */   public static final int VORBIS_unexpected_eof = 10;
/*     */   
/*     */   public static final int VORBIS_seek_invalid = 11;
/*     */   public static final int VORBIS_invalid_setup = 20;
/*     */   public static final int VORBIS_invalid_stream = 21;
/*     */   public static final int VORBIS_missing_capture_pattern = 30;
/*     */   public static final int VORBIS_invalid_stream_structure_version = 31;
/*     */   public static final int VORBIS_continued_packet_flag_invalid = 32;
/*     */   public static final int VORBIS_incorrect_stream_serial_number = 33;
/*     */   public static final int VORBIS_invalid_first_page = 34;
/*     */   public static final int VORBIS_bad_packet_type = 35;
/*     */   public static final int VORBIS_cant_find_last_page = 36;
/*     */   public static final int VORBIS_seek_failed = 37;
/*     */   public static final int VORBIS_ogg_skeleton_not_supported = 38;
/*     */   
/*     */   protected STBVorbis() {
/*  50 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis_info")
/*     */   public static STBVorbisInfo stb_vorbis_get_info(@NativeType("stb_vorbis *") long f, @NativeType("stb_vorbis_info") STBVorbisInfo __result) {
/*  61 */     if (Checks.CHECKS) {
/*  62 */       Checks.check(f);
/*     */     }
/*  64 */     nstb_vorbis_get_info(f, __result.address());
/*  65 */     return __result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis_comment")
/*     */   public static STBVorbisComment stb_vorbis_get_comment(@NativeType("stb_vorbis *") long f, @NativeType("stb_vorbis_comment") STBVorbisComment __result) {
/*  76 */     if (Checks.CHECKS) {
/*  77 */       Checks.check(f);
/*     */     }
/*  79 */     nstb_vorbis_get_comment(f, __result.address());
/*  80 */     return __result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_error(@NativeType("stb_vorbis *") long f) {
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.check(f);
/*     */     }
/*  93 */     return nstb_vorbis_get_error(f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stb_vorbis_close(@NativeType("stb_vorbis *") long f) {
/* 103 */     if (Checks.CHECKS) {
/* 104 */       Checks.check(f);
/*     */     }
/* 106 */     nstb_vorbis_close(f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_sample_offset(@NativeType("stb_vorbis *") long f) {
/* 116 */     if (Checks.CHECKS) {
/* 117 */       Checks.check(f);
/*     */     }
/* 119 */     return nstb_vorbis_get_sample_offset(f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static int stb_vorbis_get_file_offset(@NativeType("stb_vorbis *") long f) {
/* 130 */     if (Checks.CHECKS) {
/* 131 */       Checks.check(f);
/*     */     }
/* 133 */     return nstb_vorbis_get_file_offset(f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_pushdata(@NativeType("unsigned char const *") ByteBuffer datablock, @NativeType("int *") IntBuffer datablock_memory_consumed_in_bytes, @NativeType("int *") IntBuffer error, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc alloc_buffer) {
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(datablock_memory_consumed_in_bytes, 1);
/* 146 */       Checks.check(error, 1);
/* 147 */       if (alloc_buffer != null) STBVorbisAlloc.validate(alloc_buffer.address()); 
/*     */     } 
/* 149 */     return nstb_vorbis_open_pushdata(MemoryUtil.memAddress(datablock), datablock.remaining(), MemoryUtil.memAddress(datablock_memory_consumed_in_bytes), MemoryUtil.memAddress(error), MemoryUtil.memAddressSafe((Pointer)alloc_buffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_frame_pushdata(@NativeType("stb_vorbis *") long f, @NativeType("unsigned char const *") ByteBuffer datablock, @NativeType("int *") IntBuffer channels, @NativeType("float ***") PointerBuffer output, @NativeType("int *") IntBuffer samples) {
/* 159 */     if (Checks.CHECKS) {
/* 160 */       Checks.check(f);
/* 161 */       Checks.checkSafe(channels, 1);
/* 162 */       Checks.check((CustomBuffer)output, 1);
/* 163 */       Checks.check(samples, 1);
/*     */     } 
/* 165 */     return nstb_vorbis_decode_frame_pushdata(f, MemoryUtil.memAddress(datablock), datablock.remaining(), MemoryUtil.memAddressSafe(channels), MemoryUtil.memAddress((CustomBuffer)output), MemoryUtil.memAddress(samples));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stb_vorbis_flush_pushdata(@NativeType("stb_vorbis *") long f) {
/* 175 */     if (Checks.CHECKS) {
/* 176 */       Checks.check(f);
/*     */     }
/* 178 */     nstb_vorbis_flush_pushdata(f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_filename(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") IntBuffer channels, @NativeType("int *") IntBuffer sample_rate, @NativeType("short **") PointerBuffer output) {
/* 188 */     if (Checks.CHECKS) {
/* 189 */       Checks.checkNT1(filename);
/* 190 */       Checks.check(channels, 1);
/* 191 */       Checks.check(sample_rate, 1);
/* 192 */       Checks.check((CustomBuffer)output, 1);
/*     */     } 
/* 194 */     return nstb_vorbis_decode_filename(MemoryUtil.memAddress(filename), MemoryUtil.memAddress(channels), MemoryUtil.memAddress(sample_rate), MemoryUtil.memAddress((CustomBuffer)output));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_filename(@NativeType("char const *") CharSequence filename, @NativeType("int *") IntBuffer channels, @NativeType("int *") IntBuffer sample_rate, @NativeType("short **") PointerBuffer output) {
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check(channels, 1);
/* 201 */       Checks.check(sample_rate, 1);
/* 202 */       Checks.check((CustomBuffer)output, 1);
/*     */     } 
/* 204 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 206 */       stack.nASCII(filename, true);
/* 207 */       long filenameEncoded = stack.getPointerAddress();
/* 208 */       return nstb_vorbis_decode_filename(filenameEncoded, MemoryUtil.memAddress(channels), MemoryUtil.memAddress(sample_rate), MemoryUtil.memAddress((CustomBuffer)output));
/*     */     } finally {
/* 210 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static ShortBuffer stb_vorbis_decode_filename(@NativeType("char const *") CharSequence filename, @NativeType("int *") IntBuffer channels, @NativeType("int *") IntBuffer sample_rate) {
/* 217 */     if (Checks.CHECKS) {
/* 218 */       Checks.check(channels, 1);
/* 219 */       Checks.check(sample_rate, 1);
/*     */     } 
/* 221 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 223 */       stack.nASCII(filename, true);
/* 224 */       long filenameEncoded = stack.getPointerAddress();
/* 225 */       PointerBuffer output = stack.pointers(0L);
/* 226 */       int __result = nstb_vorbis_decode_filename(filenameEncoded, MemoryUtil.memAddress(channels), MemoryUtil.memAddress(sample_rate), MemoryUtil.memAddress((CustomBuffer)output));
/* 227 */       return MemoryUtil.memShortBufferSafe(output.get(0), __result * channels.get(0));
/*     */     } finally {
/* 229 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_memory(@NativeType("unsigned char const *") ByteBuffer mem, @NativeType("int *") IntBuffer channels, @NativeType("int *") IntBuffer sample_rate, @NativeType("short **") PointerBuffer output) {
/* 240 */     if (Checks.CHECKS) {
/* 241 */       Checks.check(channels, 1);
/* 242 */       Checks.check(sample_rate, 1);
/* 243 */       Checks.check((CustomBuffer)output, 1);
/*     */     } 
/* 245 */     return nstb_vorbis_decode_memory(MemoryUtil.memAddress(mem), mem.remaining(), MemoryUtil.memAddress(channels), MemoryUtil.memAddress(sample_rate), MemoryUtil.memAddress((CustomBuffer)output));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static ShortBuffer stb_vorbis_decode_memory(@NativeType("unsigned char const *") ByteBuffer mem, @NativeType("int *") IntBuffer channels, @NativeType("int *") IntBuffer sample_rate) {
/* 251 */     if (Checks.CHECKS) {
/* 252 */       Checks.check(channels, 1);
/* 253 */       Checks.check(sample_rate, 1);
/*     */     } 
/* 255 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 257 */       PointerBuffer output = stack.pointers(0L);
/* 258 */       int __result = nstb_vorbis_decode_memory(MemoryUtil.memAddress(mem), mem.remaining(), MemoryUtil.memAddress(channels), MemoryUtil.memAddress(sample_rate), MemoryUtil.memAddress((CustomBuffer)output));
/* 259 */       return MemoryUtil.memShortBufferSafe(output.get(0), __result * channels.get(0));
/*     */     } finally {
/* 261 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_memory(@NativeType("unsigned char const *") ByteBuffer mem, @NativeType("int *") IntBuffer error, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc alloc_buffer) {
/* 273 */     if (Checks.CHECKS) {
/* 274 */       Checks.check(error, 1);
/* 275 */       if (alloc_buffer != null) STBVorbisAlloc.validate(alloc_buffer.address()); 
/*     */     } 
/* 277 */     return nstb_vorbis_open_memory(MemoryUtil.memAddress(mem), mem.remaining(), MemoryUtil.memAddress(error), MemoryUtil.memAddressSafe((Pointer)alloc_buffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_filename(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") IntBuffer error, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc alloc_buffer) {
/* 288 */     if (Checks.CHECKS) {
/* 289 */       Checks.checkNT1(filename);
/* 290 */       Checks.check(error, 1);
/* 291 */       if (alloc_buffer != null) STBVorbisAlloc.validate(alloc_buffer.address()); 
/*     */     } 
/* 293 */     return nstb_vorbis_open_filename(MemoryUtil.memAddress(filename), MemoryUtil.memAddress(error), MemoryUtil.memAddressSafe((Pointer)alloc_buffer));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_filename(@NativeType("char const *") CharSequence filename, @NativeType("int *") IntBuffer error, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc alloc_buffer) {
/* 299 */     if (Checks.CHECKS) {
/* 300 */       Checks.check(error, 1);
/* 301 */       if (alloc_buffer != null) STBVorbisAlloc.validate(alloc_buffer.address()); 
/*     */     } 
/* 303 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 305 */       stack.nASCII(filename, true);
/* 306 */       long filenameEncoded = stack.getPointerAddress();
/* 307 */       return nstb_vorbis_open_filename(filenameEncoded, MemoryUtil.memAddress(error), MemoryUtil.memAddressSafe((Pointer)alloc_buffer));
/*     */     } finally {
/* 309 */       stack.setPointer(stackPointer);
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
/*     */   public static boolean stb_vorbis_seek_frame(@NativeType("stb_vorbis *") long f, @NativeType("unsigned int") int sample_number) {
/* 321 */     if (Checks.CHECKS) {
/* 322 */       Checks.check(f);
/*     */     }
/* 324 */     return (nstb_vorbis_seek_frame(f, sample_number) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stb_vorbis_seek(@NativeType("stb_vorbis *") long f, @NativeType("unsigned int") int sample_number) {
/* 335 */     if (Checks.CHECKS) {
/* 336 */       Checks.check(f);
/*     */     }
/* 338 */     return (nstb_vorbis_seek(f, sample_number) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stb_vorbis_seek_start(@NativeType("stb_vorbis *") long f) {
/* 349 */     if (Checks.CHECKS) {
/* 350 */       Checks.check(f);
/*     */     }
/* 352 */     return (nstb_vorbis_seek_start(f) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static int stb_vorbis_stream_length_in_samples(@NativeType("stb_vorbis *") long f) {
/* 363 */     if (Checks.CHECKS) {
/* 364 */       Checks.check(f);
/*     */     }
/* 366 */     return nstb_vorbis_stream_length_in_samples(f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float stb_vorbis_stream_length_in_seconds(@NativeType("stb_vorbis *") long f) {
/* 376 */     if (Checks.CHECKS) {
/* 377 */       Checks.check(f);
/*     */     }
/* 379 */     return nstb_vorbis_stream_length_in_seconds(f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_float(@NativeType("stb_vorbis *") long f, @NativeType("int *") IntBuffer channels, @NativeType("float ***") PointerBuffer output) {
/* 389 */     if (Checks.CHECKS) {
/* 390 */       Checks.check(f);
/* 391 */       Checks.checkSafe(channels, 1);
/* 392 */       Checks.check((CustomBuffer)output, 1);
/*     */     } 
/* 394 */     return nstb_vorbis_get_frame_float(f, MemoryUtil.memAddressSafe(channels), MemoryUtil.memAddress((CustomBuffer)output));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_short(@NativeType("stb_vorbis *") long f, @NativeType("short **") PointerBuffer buffer, int num_samples) {
/* 404 */     if (Checks.CHECKS) {
/* 405 */       Checks.check(f);
/*     */     }
/* 407 */     return nstb_vorbis_get_frame_short(f, buffer.remaining(), MemoryUtil.memAddress((CustomBuffer)buffer), num_samples);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_short_interleaved(@NativeType("stb_vorbis *") long f, int num_c, @NativeType("short *") ShortBuffer buffer) {
/* 417 */     if (Checks.CHECKS) {
/* 418 */       Checks.check(f);
/*     */     }
/* 420 */     return nstb_vorbis_get_frame_short_interleaved(f, num_c, MemoryUtil.memAddress(buffer), buffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_float(@NativeType("stb_vorbis *") long f, @NativeType("float **") PointerBuffer buffer, int num_samples) {
/* 430 */     if (Checks.CHECKS) {
/* 431 */       Checks.check(f);
/*     */     }
/* 433 */     return nstb_vorbis_get_samples_float(f, buffer.remaining(), MemoryUtil.memAddress((CustomBuffer)buffer), num_samples);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_float_interleaved(@NativeType("stb_vorbis *") long f, int channels, @NativeType("float *") FloatBuffer buffer) {
/* 443 */     if (Checks.CHECKS) {
/* 444 */       Checks.check(f);
/*     */     }
/* 446 */     return nstb_vorbis_get_samples_float_interleaved(f, channels, MemoryUtil.memAddress(buffer), buffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_short(@NativeType("stb_vorbis *") long f, @NativeType("short **") PointerBuffer buffer, int num_samples) {
/* 456 */     if (Checks.CHECKS) {
/* 457 */       Checks.check(f);
/*     */     }
/* 459 */     return nstb_vorbis_get_samples_short(f, buffer.remaining(), MemoryUtil.memAddress((CustomBuffer)buffer), num_samples);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_short_interleaved(@NativeType("stb_vorbis *") long f, int channels, @NativeType("short *") ShortBuffer buffer) {
/* 469 */     if (Checks.CHECKS) {
/* 470 */       Checks.check(f);
/*     */     }
/* 472 */     return nstb_vorbis_get_samples_short_interleaved(f, channels, MemoryUtil.memAddress(buffer), buffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_pushdata(@NativeType("unsigned char const *") ByteBuffer datablock, @NativeType("int *") int[] datablock_memory_consumed_in_bytes, @NativeType("int *") int[] error, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc alloc_buffer) {
/* 481 */     if (Checks.CHECKS) {
/* 482 */       Checks.check(datablock_memory_consumed_in_bytes, 1);
/* 483 */       Checks.check(error, 1);
/* 484 */       if (alloc_buffer != null) STBVorbisAlloc.validate(alloc_buffer.address()); 
/*     */     } 
/* 486 */     return nstb_vorbis_open_pushdata(MemoryUtil.memAddress(datablock), datablock.remaining(), datablock_memory_consumed_in_bytes, error, MemoryUtil.memAddressSafe((Pointer)alloc_buffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_frame_pushdata(@NativeType("stb_vorbis *") long f, @NativeType("unsigned char const *") ByteBuffer datablock, @NativeType("int *") int[] channels, @NativeType("float ***") PointerBuffer output, @NativeType("int *") int[] samples) {
/* 494 */     if (Checks.CHECKS) {
/* 495 */       Checks.check(f);
/* 496 */       Checks.checkSafe(channels, 1);
/* 497 */       Checks.check((CustomBuffer)output, 1);
/* 498 */       Checks.check(samples, 1);
/*     */     } 
/* 500 */     return nstb_vorbis_decode_frame_pushdata(f, MemoryUtil.memAddress(datablock), datablock.remaining(), channels, MemoryUtil.memAddress((CustomBuffer)output), samples);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_filename(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") int[] channels, @NativeType("int *") int[] sample_rate, @NativeType("short **") PointerBuffer output) {
/* 508 */     if (Checks.CHECKS) {
/* 509 */       Checks.checkNT1(filename);
/* 510 */       Checks.check(channels, 1);
/* 511 */       Checks.check(sample_rate, 1);
/* 512 */       Checks.check((CustomBuffer)output, 1);
/*     */     } 
/* 514 */     return nstb_vorbis_decode_filename(MemoryUtil.memAddress(filename), channels, sample_rate, MemoryUtil.memAddress((CustomBuffer)output));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_filename(@NativeType("char const *") CharSequence filename, @NativeType("int *") int[] channels, @NativeType("int *") int[] sample_rate, @NativeType("short **") PointerBuffer output) {
/* 519 */     if (Checks.CHECKS) {
/* 520 */       Checks.check(channels, 1);
/* 521 */       Checks.check(sample_rate, 1);
/* 522 */       Checks.check((CustomBuffer)output, 1);
/*     */     } 
/* 524 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 526 */       stack.nASCII(filename, true);
/* 527 */       long filenameEncoded = stack.getPointerAddress();
/* 528 */       return nstb_vorbis_decode_filename(filenameEncoded, channels, sample_rate, MemoryUtil.memAddress((CustomBuffer)output));
/*     */     } finally {
/* 530 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_memory(@NativeType("unsigned char const *") ByteBuffer mem, @NativeType("int *") int[] channels, @NativeType("int *") int[] sample_rate, @NativeType("short **") PointerBuffer output) {
/* 539 */     if (Checks.CHECKS) {
/* 540 */       Checks.check(channels, 1);
/* 541 */       Checks.check(sample_rate, 1);
/* 542 */       Checks.check((CustomBuffer)output, 1);
/*     */     } 
/* 544 */     return nstb_vorbis_decode_memory(MemoryUtil.memAddress(mem), mem.remaining(), channels, sample_rate, MemoryUtil.memAddress((CustomBuffer)output));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_memory(@NativeType("unsigned char const *") ByteBuffer mem, @NativeType("int *") int[] error, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc alloc_buffer) {
/* 553 */     if (Checks.CHECKS) {
/* 554 */       Checks.check(error, 1);
/* 555 */       if (alloc_buffer != null) STBVorbisAlloc.validate(alloc_buffer.address()); 
/*     */     } 
/* 557 */     return nstb_vorbis_open_memory(MemoryUtil.memAddress(mem), mem.remaining(), error, MemoryUtil.memAddressSafe((Pointer)alloc_buffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_filename(@NativeType("char const *") ByteBuffer filename, @NativeType("int *") int[] error, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc alloc_buffer) {
/* 566 */     if (Checks.CHECKS) {
/* 567 */       Checks.checkNT1(filename);
/* 568 */       Checks.check(error, 1);
/* 569 */       if (alloc_buffer != null) STBVorbisAlloc.validate(alloc_buffer.address()); 
/*     */     } 
/* 571 */     return nstb_vorbis_open_filename(MemoryUtil.memAddress(filename), error, MemoryUtil.memAddressSafe((Pointer)alloc_buffer));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_filename(@NativeType("char const *") CharSequence filename, @NativeType("int *") int[] error, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc alloc_buffer) {
/* 577 */     if (Checks.CHECKS) {
/* 578 */       Checks.check(error, 1);
/* 579 */       if (alloc_buffer != null) STBVorbisAlloc.validate(alloc_buffer.address()); 
/*     */     } 
/* 581 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 583 */       stack.nASCII(filename, true);
/* 584 */       long filenameEncoded = stack.getPointerAddress();
/* 585 */       return nstb_vorbis_open_filename(filenameEncoded, error, MemoryUtil.memAddressSafe((Pointer)alloc_buffer));
/*     */     } finally {
/* 587 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_float(@NativeType("stb_vorbis *") long f, @NativeType("int *") int[] channels, @NativeType("float ***") PointerBuffer output) {
/* 596 */     if (Checks.CHECKS) {
/* 597 */       Checks.check(f);
/* 598 */       Checks.checkSafe(channels, 1);
/* 599 */       Checks.check((CustomBuffer)output, 1);
/*     */     } 
/* 601 */     return nstb_vorbis_get_frame_float(f, channels, MemoryUtil.memAddress((CustomBuffer)output));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_short_interleaved(@NativeType("stb_vorbis *") long f, int num_c, @NativeType("short *") short[] buffer) {
/* 609 */     if (Checks.CHECKS) {
/* 610 */       Checks.check(f);
/*     */     }
/* 612 */     return nstb_vorbis_get_frame_short_interleaved(f, num_c, buffer, buffer.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_float_interleaved(@NativeType("stb_vorbis *") long f, int channels, @NativeType("float *") float[] buffer) {
/* 620 */     if (Checks.CHECKS) {
/* 621 */       Checks.check(f);
/*     */     }
/* 623 */     return nstb_vorbis_get_samples_float_interleaved(f, channels, buffer, buffer.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_short_interleaved(@NativeType("stb_vorbis *") long f, int channels, @NativeType("short *") short[] buffer) {
/* 631 */     if (Checks.CHECKS) {
/* 632 */       Checks.check(f);
/*     */     }
/* 634 */     return nstb_vorbis_get_samples_short_interleaved(f, channels, buffer, buffer.length);
/*     */   }
/*     */   
/*     */   public static native void nstb_vorbis_get_info(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nstb_vorbis_get_comment(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_get_error(long paramLong);
/*     */   
/*     */   public static native void nstb_vorbis_close(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_get_sample_offset(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_get_file_offset(long paramLong);
/*     */   
/*     */   public static native long nstb_vorbis_open_pushdata(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nstb_vorbis_decode_frame_pushdata(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*     */   
/*     */   public static native void nstb_vorbis_flush_pushdata(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_decode_filename(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nstb_vorbis_decode_memory(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native long nstb_vorbis_open_memory(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nstb_vorbis_open_filename(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nstb_vorbis_seek_frame(long paramLong, int paramInt);
/*     */   
/*     */   public static native int nstb_vorbis_seek(long paramLong, int paramInt);
/*     */   
/*     */   public static native int nstb_vorbis_seek_start(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_stream_length_in_samples(long paramLong);
/*     */   
/*     */   public static native float nstb_vorbis_stream_length_in_seconds(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_float(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_short(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_short_interleaved(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_float(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_float_interleaved(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_short(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_short_interleaved(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native long nstb_vorbis_open_pushdata(long paramLong1, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_decode_frame_pushdata(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint1, long paramLong3, int[] paramArrayOfint2);
/*     */   
/*     */   public static native int nstb_vorbis_decode_filename(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_decode_memory(long paramLong1, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*     */   
/*     */   public static native long nstb_vorbis_open_memory(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2);
/*     */   
/*     */   public static native long nstb_vorbis_open_filename(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_float(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_short_interleaved(long paramLong, int paramInt1, short[] paramArrayOfshort, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_float_interleaved(long paramLong, int paramInt1, float[] paramArrayOffloat, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_short_interleaved(long paramLong, int paramInt1, short[] paramArrayOfshort, int paramInt2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBVorbis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */