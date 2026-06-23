/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ public class STBImageResize
/*     */ {
/*     */   public static final int STBIR_1CHANNEL = 1;
/*     */   public static final int STBIR_2CHANNEL = 2;
/*     */   public static final int STBIR_RGB = 3;
/*     */   public static final int STBIR_BGR = 0;
/*     */   public static final int STBIR_4CHANNEL = 5;
/*     */   
/*     */   static {
/*  19 */     LibSTB.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int STBIR_RGBA = 4;
/*     */   
/*     */   public static final int STBIR_BGRA = 6;
/*     */   
/*     */   public static final int STBIR_ARGB = 7;
/*     */   
/*     */   public static final int STBIR_ABGR = 8;
/*     */   
/*     */   public static final int STBIR_RA = 9;
/*     */   
/*     */   public static final int STBIR_AR = 10;
/*     */   
/*     */   public static final int STBIR_RGBA_PM = 11;
/*     */   
/*     */   public static final int STBIR_BGRA_PM = 12;
/*     */   
/*     */   public static final int STBIR_ARGB_PM = 13;
/*     */   
/*     */   public static final int STBIR_ABGR_PM = 14;
/*     */   
/*     */   public static final int STBIR_RA_PM = 15;
/*     */   public static final int STBIR_AR_PM = 16;
/*     */   public static final int STBIR_RGBA_NO_AW = 11;
/*     */   public static final int STBIR_BGRA_NO_AW = 12;
/*     */   public static final int STBIR_ARGB_NO_AW = 13;
/*     */   public static final int STBIR_ABGR_NO_AW = 14;
/*     */   public static final int STBIR_RA_NO_AW = 15;
/*     */   public static final int STBIR_AR_NO_AW = 16;
/*     */   public static final int STBIR_EDGE_CLAMP = 0;
/*     */   public static final int STBIR_EDGE_REFLECT = 1;
/*     */   public static final int STBIR_EDGE_WRAP = 2;
/*     */   public static final int STBIR_EDGE_ZERO = 3;
/*     */   public static final int STBIR_FILTER_DEFAULT = 0;
/*     */   public static final int STBIR_FILTER_BOX = 1;
/*     */   public static final int STBIR_FILTER_TRIANGLE = 2;
/*     */   public static final int STBIR_FILTER_CUBICBSPLINE = 3;
/*     */   public static final int STBIR_FILTER_CATMULLROM = 4;
/*     */   public static final int STBIR_FILTER_MITCHELL = 5;
/*     */   public static final int STBIR_FILTER_POINT_SAMPLE = 6;
/*     */   public static final int STBIR_FILTER_OTHER = 7;
/*     */   public static final int STBIR_TYPE_UINT8 = 0;
/*     */   public static final int STBIR_TYPE_UINT8_SRGB = 1;
/*     */   public static final int STBIR_TYPE_UINT8_SRGB_ALPHA = 2;
/*     */   public static final int STBIR_TYPE_UINT16 = 3;
/*     */   public static final int STBIR_TYPE_FLOAT = 4;
/*     */   public static final int STBIR_TYPE_HALF_FLOAT = 5;
/*     */   
/*     */   protected STBImageResize() {
/*  71 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned char *")
/*     */   public static ByteBuffer stbir_resize_uint8_srgb(@NativeType("unsigned char const *") ByteBuffer input_pixels, int input_w, int input_h, int input_stride_in_bytes, @NativeType("unsigned char *") ByteBuffer output_pixels, int output_w, int output_h, int output_stride_in_bytes, @NativeType("stbir_pixel_layout") int pixel_type) {
/*  82 */     int length = calculateBufferSize(output_w, output_h, output_stride_in_bytes, pixel_type, 1);
/*  83 */     if (Checks.CHECKS) {
/*  84 */       Checks.checkSafe(output_pixels, length);
/*     */     }
/*  86 */     long __result = nstbir_resize_uint8_srgb(MemoryUtil.memAddress(input_pixels), input_w, input_h, input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_w, output_h, output_stride_in_bytes, pixel_type);
/*  87 */     return MemoryUtil.memByteBufferSafe(__result, length);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("unsigned char *")
/*     */   public static ByteBuffer stbir_resize_uint8_srgb(@NativeType("unsigned char const *") ByteBuffer input_pixels, int input_w, int input_h, int input_stride_in_bytes, @NativeType("unsigned char *") ByteBuffer output_pixels, int output_w, int output_h, int output_stride_in_bytes, @NativeType("stbir_pixel_layout") int pixel_type, long length) {
/*  93 */     if (Checks.CHECKS) {
/*  94 */       Checks.checkSafe(output_pixels, length);
/*     */     }
/*  96 */     long __result = nstbir_resize_uint8_srgb(MemoryUtil.memAddress(input_pixels), input_w, input_h, input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_w, output_h, output_stride_in_bytes, pixel_type);
/*  97 */     return MemoryUtil.memByteBufferSafe(__result, (int)length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned char *")
/*     */   public static ByteBuffer stbir_resize_uint8_linear(@NativeType("unsigned char const *") ByteBuffer input_pixels, int input_w, int input_h, int input_stride_in_bytes, @NativeType("unsigned char *") ByteBuffer output_pixels, int output_w, int output_h, int output_stride_in_bytes, @NativeType("stbir_pixel_layout") int pixel_type) {
/* 108 */     int length = calculateBufferSize(output_w, output_h, output_stride_in_bytes, pixel_type, 1);
/* 109 */     if (Checks.CHECKS) {
/* 110 */       Checks.checkSafe(output_pixels, length);
/*     */     }
/* 112 */     long __result = nstbir_resize_uint8_linear(MemoryUtil.memAddress(input_pixels), input_w, input_h, input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_w, output_h, output_stride_in_bytes, pixel_type);
/* 113 */     return MemoryUtil.memByteBufferSafe(__result, length);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("unsigned char *")
/*     */   public static ByteBuffer stbir_resize_uint8_linear(@NativeType("unsigned char const *") ByteBuffer input_pixels, int input_w, int input_h, int input_stride_in_bytes, @NativeType("unsigned char *") ByteBuffer output_pixels, int output_w, int output_h, int output_stride_in_bytes, @NativeType("stbir_pixel_layout") int pixel_type, long length) {
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.checkSafe(output_pixels, length);
/*     */     }
/* 122 */     long __result = nstbir_resize_uint8_linear(MemoryUtil.memAddress(input_pixels), input_w, input_h, input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_w, output_h, output_stride_in_bytes, pixel_type);
/* 123 */     return MemoryUtil.memByteBufferSafe(__result, (int)length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbir_resize_float_linear(@NativeType("float const *") FloatBuffer input_pixels, int input_w, int input_h, int input_stride_in_bytes, @NativeType("float *") FloatBuffer output_pixels, int output_w, int output_h, int output_stride_in_bytes, @NativeType("stbir_pixel_layout") int pixel_type) {
/* 134 */     int length = calculateBufferSize(output_w, output_h, output_stride_in_bytes, pixel_type, 4);
/* 135 */     if (Checks.CHECKS) {
/* 136 */       Checks.checkSafe(output_pixels, length);
/*     */     }
/* 138 */     long __result = nstbir_resize_float_linear(MemoryUtil.memAddress(input_pixels), input_w, input_h, input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_w, output_h, output_stride_in_bytes, pixel_type);
/* 139 */     return MemoryUtil.memFloatBufferSafe(__result, length);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("float *")
/*     */   public static FloatBuffer stbir_resize_float_linear(@NativeType("float const *") FloatBuffer input_pixels, int input_w, int input_h, int input_stride_in_bytes, @NativeType("float *") FloatBuffer output_pixels, int output_w, int output_h, int output_stride_in_bytes, @NativeType("stbir_pixel_layout") int pixel_type, long length) {
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.checkSafe(output_pixels, length);
/*     */     }
/* 148 */     long __result = nstbir_resize_float_linear(MemoryUtil.memAddress(input_pixels), input_w, input_h, input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_w, output_h, output_stride_in_bytes, pixel_type);
/* 149 */     return MemoryUtil.memFloatBufferSafe(__result, (int)length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer stbir_resize(@NativeType("void const *") ByteBuffer input_pixels, int input_w, int input_h, int input_stride_in_bytes, @NativeType("void *") ByteBuffer output_pixels, int output_w, int output_h, int output_stride_in_bytes, @NativeType("stbir_pixel_layout") int pixel_layout, @NativeType("stbir_datatype") int data_type, @NativeType("stbir_edge") int edge, @NativeType("stbir_filter") int filter) {
/* 160 */     int length = calculateBufferSize(output_w, output_h, output_stride_in_bytes, pixel_layout, stbir_type_size[data_type]);
/* 161 */     if (Checks.CHECKS) {
/* 162 */       Checks.checkSafe(output_pixels, length);
/*     */     }
/* 164 */     long __result = nstbir_resize(MemoryUtil.memAddress(input_pixels), input_w, input_h, input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_w, output_h, output_stride_in_bytes, pixel_layout, data_type, edge, filter);
/* 165 */     return MemoryUtil.memByteBufferSafe(__result, length);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer stbir_resize(@NativeType("void const *") ByteBuffer input_pixels, int input_w, int input_h, int input_stride_in_bytes, @NativeType("void *") ByteBuffer output_pixels, int output_w, int output_h, int output_stride_in_bytes, @NativeType("stbir_pixel_layout") int pixel_layout, @NativeType("stbir_datatype") int data_type, @NativeType("stbir_edge") int edge, @NativeType("stbir_filter") int filter, long length) {
/* 171 */     if (Checks.CHECKS) {
/* 172 */       Checks.checkSafe(output_pixels, length);
/*     */     }
/* 174 */     long __result = nstbir_resize(MemoryUtil.memAddress(input_pixels), input_w, input_h, input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_w, output_h, output_stride_in_bytes, pixel_layout, data_type, edge, filter);
/* 175 */     return MemoryUtil.memByteBufferSafe(__result, (int)length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbir_resize_init(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("void const *") ByteBuffer input_pixels, int input_w, int input_h, int input_stride_in_bytes, @NativeType("void *") ByteBuffer output_pixels, int output_w, int output_h, int output_stride_in_bytes, @NativeType("stbir_pixel_layout") int pixel_layout, @NativeType("stbir_datatype") int data_type) {
/* 185 */     if (Checks.CHECKS) {
/* 186 */       Checks.checkSafe(output_pixels, calculateBufferSize(output_w, output_h, output_stride_in_bytes, pixel_layout, stbir_type_size[data_type]));
/*     */     }
/* 188 */     nstbir_resize_init(resize.address(), MemoryUtil.memAddress(input_pixels), input_w, input_h, input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_w, output_h, output_stride_in_bytes, pixel_layout, data_type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbir_set_datatypes(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("stbir_datatype") int input_type, @NativeType("stbir_datatype") int output_type) {
/* 198 */     nstbir_set_datatypes(resize.address(), input_type, output_type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbir_set_pixel_callbacks(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("stbir_input_callback *") STBIRInputCallbackI input_cb, @NativeType("stbir_output_callback *") STBIROutputCallbackI output_cb) {
/* 208 */     nstbir_set_pixel_callbacks(resize.address(), MemoryUtil.memAddressSafe((Pointer)input_cb), MemoryUtil.memAddressSafe((Pointer)output_cb));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbir_set_user_data(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("void *") long user_data) {
/* 218 */     nstbir_set_user_data(resize.address(), user_data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbir_set_buffer_ptrs(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("void const *") ByteBuffer input_pixels, int input_stride_in_bytes, @NativeType("void *") ByteBuffer output_pixels, int output_stride_in_bytes) {
/* 228 */     nstbir_set_buffer_ptrs(resize.address(), MemoryUtil.memAddress(input_pixels), input_stride_in_bytes, MemoryUtil.memAddressSafe(output_pixels), output_stride_in_bytes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_set_pixel_layouts(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("stbir_pixel_layout") int input_pixel_layout, @NativeType("stbir_pixel_layout") int output_pixel_layout) {
/* 238 */     return nstbir_set_pixel_layouts(resize.address(), input_pixel_layout, output_pixel_layout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_set_edgemodes(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("stbir_edge") int horizontal_edge, @NativeType("stbir_edge") int vertical_edge) {
/* 248 */     return nstbir_set_edgemodes(resize.address(), horizontal_edge, vertical_edge);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_set_filters(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("stbir_filter") int horizontal_filter, @NativeType("stbir_filter") int vertical_filter) {
/* 258 */     return nstbir_set_filters(resize.address(), horizontal_filter, vertical_filter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_set_filter_callbacks(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("stbir__kernel_callback *") STBIRKernelCallbackI horizontal_filter, @NativeType("stbir__support_callback *") STBIRSupportCallbackI horizontal_support, @NativeType("stbir__kernel_callback *") STBIRKernelCallbackI vertical_filter, @NativeType("stbir__support_callback *") STBIRSupportCallbackI vertical_support) {
/* 268 */     return nstbir_set_filter_callbacks(resize.address(), MemoryUtil.memAddressSafe((Pointer)horizontal_filter), MemoryUtil.memAddressSafe((Pointer)horizontal_support), MemoryUtil.memAddressSafe((Pointer)vertical_filter), MemoryUtil.memAddressSafe((Pointer)vertical_support));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_set_pixel_subrect(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, int subx, int suby, int subw, int subh) {
/* 278 */     return nstbir_set_pixel_subrect(resize.address(), subx, suby, subw, subh);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_set_input_subrect(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, double s0, double t0, double s1, double t1) {
/* 288 */     return nstbir_set_input_subrect(resize.address(), s0, t0, s1, t1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_set_output_pixel_subrect(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, int subx, int suby, int subw, int subh) {
/* 298 */     return nstbir_set_output_pixel_subrect(resize.address(), subx, suby, subw, subh);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_set_non_pm_alpha_speed_over_quality(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, @NativeType("int") boolean non_pma_alpha_speed_over_quality) {
/* 308 */     return nstbir_set_non_pm_alpha_speed_over_quality(resize.address(), non_pma_alpha_speed_over_quality ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_build_samplers(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize) {
/* 318 */     return nstbir_build_samplers(resize.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbir_free_samplers(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize) {
/* 328 */     nstbir_free_samplers(resize.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_resize_extended(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize) {
/* 338 */     return nstbir_resize_extended(resize.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_build_samplers_with_splits(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, int try_splits) {
/* 348 */     return nstbir_build_samplers_with_splits(resize.address(), try_splits);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbir_resize_extended_split(@NativeType("STBIR_RESIZE *") STBIR_RESIZE resize, int split_start, int split_count) {
/* 358 */     return nstbir_resize_extended_split(resize.address(), split_start, split_count);
/*     */   }
/*     */   
/* 361 */   private static final int[] stbir_pixel_layout_channels = new int[] { 3, 1, 2, 3, 4, 4, 4, 4, 4, 2, 2, 4, 4, 4, 4, 2, 2 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int calculateBufferSize(int width, int height, int stride_in_bytes, int pixel_type, int type_size) {
/* 368 */     return height * ((stride_in_bytes == 0) ? (width * stbir_pixel_layout_channels[pixel_type] * type_size) : stride_in_bytes);
/*     */   }
/*     */   
/* 371 */   private static final int[] stbir_type_size = new int[] { 1, 1, 1, 2, 4, 2 };
/*     */   
/*     */   public static native long nstbir_resize_uint8_srgb(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*     */   
/*     */   public static native long nstbir_resize_uint8_linear(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*     */   
/*     */   public static native long nstbir_resize_float_linear(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*     */   
/*     */   public static native long nstbir_resize(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
/*     */   
/*     */   public static native void nstbir_resize_init(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
/*     */   
/*     */   public static native void nstbir_set_datatypes(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   public static native void nstbir_set_pixel_callbacks(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nstbir_set_user_data(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nstbir_set_buffer_ptrs(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2);
/*     */   
/*     */   public static native int nstbir_set_pixel_layouts(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   public static native int nstbir_set_edgemodes(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   public static native int nstbir_set_filters(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   public static native int nstbir_set_filter_callbacks(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*     */   
/*     */   public static native int nstbir_set_pixel_subrect(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   public static native int nstbir_set_input_subrect(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
/*     */   
/*     */   public static native int nstbir_set_output_pixel_subrect(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   public static native int nstbir_set_non_pm_alpha_speed_over_quality(long paramLong, int paramInt);
/*     */   
/*     */   public static native int nstbir_build_samplers(long paramLong);
/*     */   
/*     */   public static native void nstbir_free_samplers(long paramLong);
/*     */   
/*     */   public static native int nstbir_resize_extended(long paramLong);
/*     */   
/*     */   public static native int nstbir_build_samplers_with_splits(long paramLong, int paramInt);
/*     */   
/*     */   public static native int nstbir_resize_extended_split(long paramLong, int paramInt1, int paramInt2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBImageResize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */