/*      */ package org.lwjgl.stb;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Struct;
/*      */ 
/*      */ 
/*      */ public class STBTruetype
/*      */ {
/*      */   public static final byte STBTT_vmove = 1;
/*      */   public static final byte STBTT_vline = 2;
/*      */   public static final byte STBTT_vcurve = 3;
/*      */   
/*      */   static {
/*   22 */     LibSTB.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final byte STBTT_vcubic = 4;
/*      */   
/*      */   public static final int STBTT_MACSTYLE_DONTCARE = 0;
/*      */   
/*      */   public static final int STBTT_MACSTYLE_BOLD = 1;
/*      */   
/*      */   public static final int STBTT_MACSTYLE_ITALIC = 2;
/*      */   
/*      */   public static final int STBTT_MACSTYLE_UNDERSCORE = 4;
/*      */   
/*      */   public static final int STBTT_MACSTYLE_NONE = 8;
/*      */   
/*      */   public static final int STBTT_PLATFORM_ID_UNICODE = 0;
/*      */   
/*      */   public static final int STBTT_PLATFORM_ID_MAC = 1;
/*      */   
/*      */   public static final int STBTT_PLATFORM_ID_ISO = 2;
/*      */   
/*      */   public static final int STBTT_PLATFORM_ID_MICROSOFT = 3;
/*      */   
/*      */   public static final int STBTT_UNICODE_EID_UNICODE_1_0 = 0;
/*      */   
/*      */   public static final int STBTT_UNICODE_EID_UNICODE_1_1 = 1;
/*      */   
/*      */   public static final int STBTT_UNICODE_EID_ISO_10646 = 2;
/*      */   
/*      */   public static final int STBTT_UNICODE_EID_UNICODE_2_0_BMP = 3;
/*      */   
/*      */   public static final int STBTT_UNICODE_EID_UNICODE_2_0_FULL = 4;
/*      */   
/*      */   public static final int STBTT_MS_EID_SYMBOL = 0;
/*      */   
/*      */   public static final int STBTT_MS_EID_UNICODE_BMP = 1;
/*      */   public static final int STBTT_MS_EID_SHIFTJIS = 2;
/*      */   public static final int STBTT_MS_EID_UNICODE_FULL = 10;
/*      */   public static final int STBTT_MAC_EID_ROMAN = 0;
/*      */   public static final int STBTT_MAC_EID_JAPANESE = 1;
/*      */   public static final int STBTT_MAC_EID_CHINESE_TRAD = 2;
/*      */   public static final int STBTT_MAC_EID_KOREAN = 3;
/*      */   public static final int STBTT_MAC_EID_ARABIC = 4;
/*      */   public static final int STBTT_MAC_EID_HEBREW = 5;
/*      */   public static final int STBTT_MAC_EID_GREEK = 6;
/*      */   public static final int STBTT_MAC_EID_RUSSIAN = 7;
/*      */   public static final int STBTT_MS_LANG_ENGLISH = 1033;
/*      */   public static final int STBTT_MS_LANG_CHINESE = 2052;
/*      */   public static final int STBTT_MS_LANG_DUTCH = 1043;
/*      */   public static final int STBTT_MS_LANG_FRENCH = 1036;
/*      */   public static final int STBTT_MS_LANG_GERMAN = 1031;
/*      */   public static final int STBTT_MS_LANG_HEBREW = 1037;
/*      */   public static final int STBTT_MS_LANG_ITALIAN = 1040;
/*      */   public static final int STBTT_MS_LANG_JAPANESE = 1041;
/*      */   public static final int STBTT_MS_LANG_KOREAN = 1042;
/*      */   public static final int STBTT_MS_LANG_RUSSIAN = 1049;
/*      */   public static final int STBTT_MS_LANG_SPANISH = 1033;
/*      */   public static final int STBTT_MS_LANG_SWEDISH = 1053;
/*      */   public static final int STBTT_MAC_LANG_ENGLISH = 0;
/*      */   public static final int STBTT_MAC_LANG_ARABIC = 12;
/*      */   public static final int STBTT_MAC_LANG_DUTCH = 4;
/*      */   public static final int STBTT_MAC_LANG_FRENCH = 1;
/*      */   public static final int STBTT_MAC_LANG_GERMAN = 2;
/*      */   public static final int STBTT_MAC_LANG_HEBREW = 10;
/*      */   public static final int STBTT_MAC_LANG_ITALIAN = 3;
/*      */   public static final int STBTT_MAC_LANG_JAPANESE = 11;
/*      */   public static final int STBTT_MAC_LANG_KOREAN = 23;
/*      */   public static final int STBTT_MAC_LANG_RUSSIAN = 32;
/*      */   public static final int STBTT_MAC_LANG_SPANISH = 6;
/*      */   public static final int STBTT_MAC_LANG_SWEDISH = 5;
/*      */   public static final int STBTT_MAC_LANG_CHINESE_SIMPLIFIED = 33;
/*      */   public static final int STBTT_MAC_LANG_CHINESE_TRAD = 19;
/*      */   
/*      */   protected STBTruetype() {
/*   97 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_BakeFontBitmap(@NativeType("unsigned char const *") ByteBuffer data, float pixel_height, @NativeType("unsigned char *") ByteBuffer pixels, int pw, int ph, int first_char, @NativeType("stbtt_bakedchar *") STBTTBakedChar.Buffer chardata) {
/*  107 */     if (Checks.CHECKS) {
/*  108 */       Checks.check(pixels, pw * ph);
/*      */     }
/*  110 */     return nstbtt_BakeFontBitmap(MemoryUtil.memAddress(data), 0, pixel_height, MemoryUtil.memAddress(pixels), pw, ph, first_char, chardata.remaining(), chardata.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetBakedQuad(@NativeType("stbtt_bakedchar const *") STBTTBakedChar.Buffer chardata, int pw, int ph, int char_index, @NativeType("float *") FloatBuffer xpos, @NativeType("float *") FloatBuffer ypos, @NativeType("stbtt_aligned_quad *") STBTTAlignedQuad q, @NativeType("int") boolean opengl_fillrule) {
/*  120 */     if (Checks.CHECKS) {
/*  121 */       Checks.check((CustomBuffer)chardata, char_index + 1);
/*  122 */       Checks.check(xpos, 1);
/*  123 */       Checks.check(ypos, 1);
/*      */     } 
/*  125 */     nstbtt_GetBakedQuad(chardata.address(), pw, ph, char_index, MemoryUtil.memAddress(xpos), MemoryUtil.memAddress(ypos), q.address(), opengl_fillrule ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetScaledFontVMetrics(@NativeType("unsigned char const *") ByteBuffer fontdata, int index, float size, @NativeType("float *") FloatBuffer ascent, @NativeType("float *") FloatBuffer descent, @NativeType("float *") FloatBuffer lineGap) {
/*  135 */     if (Checks.CHECKS) {
/*  136 */       Checks.check(ascent, 1);
/*  137 */       Checks.check(descent, 1);
/*  138 */       Checks.check(lineGap, 1);
/*      */     } 
/*  140 */     nstbtt_GetScaledFontVMetrics(MemoryUtil.memAddress(fontdata), index, size, MemoryUtil.memAddress(ascent), MemoryUtil.memAddress(descent), MemoryUtil.memAddress(lineGap));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackBegin(@NativeType("stbtt_pack_context *") STBTTPackContext spc, @NativeType("unsigned char *") ByteBuffer pixels, int width, int height, int stride_in_bytes, int padding, @NativeType("void *") long alloc_context) {
/*  151 */     if (Checks.CHECKS) {
/*  152 */       Checks.checkSafe(pixels, ((stride_in_bytes != 0) ? stride_in_bytes : width) * height);
/*      */     }
/*  154 */     return (nstbtt_PackBegin(spc.address(), MemoryUtil.memAddressSafe(pixels), width, height, stride_in_bytes, padding, alloc_context) != 0);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackBegin(@NativeType("stbtt_pack_context *") STBTTPackContext spc, @NativeType("unsigned char *") ByteBuffer pixels, int width, int height, int stride_in_bytes, int padding) {
/*  160 */     if (Checks.CHECKS) {
/*  161 */       Checks.checkSafe(pixels, ((stride_in_bytes != 0) ? stride_in_bytes : width) * height);
/*      */     }
/*  163 */     return (nstbtt_PackBegin(spc.address(), MemoryUtil.memAddressSafe(pixels), width, height, stride_in_bytes, padding, 0L) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_PackEnd(@NativeType("stbtt_pack_context *") STBTTPackContext spc) {
/*  173 */     nstbtt_PackEnd(spc.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int STBTT_POINT_SIZE(int font_size) {
/*  180 */     return -font_size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackFontRange(@NativeType("stbtt_pack_context *") STBTTPackContext spc, @NativeType("unsigned char const *") ByteBuffer fontdata, int font_index, float font_size, int first_unicode_char_in_range, @NativeType("stbtt_packedchar *") STBTTPackedchar.Buffer chardata_for_range) {
/*  191 */     return (nstbtt_PackFontRange(spc.address(), MemoryUtil.memAddress(fontdata), font_index, font_size, first_unicode_char_in_range, chardata_for_range.remaining(), chardata_for_range.address()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackFontRanges(@NativeType("stbtt_pack_context *") STBTTPackContext spc, @NativeType("unsigned char const *") ByteBuffer fontdata, int font_index, @NativeType("stbtt_pack_range *") STBTTPackRange.Buffer ranges) {
/*  202 */     if (Checks.CHECKS) {
/*  203 */       Struct.validate(ranges.address(), ranges.remaining(), STBTTPackRange.SIZEOF, STBTTPackRange::validate);
/*      */     }
/*  205 */     return (nstbtt_PackFontRanges(spc.address(), MemoryUtil.memAddress(fontdata), font_index, ranges.address(), ranges.remaining()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_PackSetOversampling(@NativeType("stbtt_pack_context *") STBTTPackContext spc, @NativeType("unsigned int") int h_oversample, @NativeType("unsigned int") int v_oversample) {
/*  215 */     nstbtt_PackSetOversampling(spc.address(), h_oversample, v_oversample);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_PackSetSkipMissingCodepoints(@NativeType("stbtt_pack_context *") STBTTPackContext spc, @NativeType("int") boolean skip) {
/*  225 */     nstbtt_PackSetSkipMissingCodepoints(spc.address(), skip ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetPackedQuad(@NativeType("stbtt_packedchar const *") STBTTPackedchar.Buffer chardata, int pw, int ph, int char_index, @NativeType("float *") FloatBuffer xpos, @NativeType("float *") FloatBuffer ypos, @NativeType("stbtt_aligned_quad *") STBTTAlignedQuad q, @NativeType("int") boolean align_to_integer) {
/*  235 */     if (Checks.CHECKS) {
/*  236 */       Checks.check((CustomBuffer)chardata, char_index + 1);
/*  237 */       Checks.check(xpos, 1);
/*  238 */       Checks.check(ypos, 1);
/*      */     } 
/*  240 */     nstbtt_GetPackedQuad(chardata.address(), pw, ph, char_index, MemoryUtil.memAddress(xpos), MemoryUtil.memAddress(ypos), q.address(), align_to_integer ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_PackFontRangesGatherRects(@NativeType("stbtt_pack_context *") STBTTPackContext spc, @NativeType("stbtt_fontinfo *") STBTTFontinfo info, @NativeType("stbtt_pack_range *") STBTTPackRange.Buffer ranges, @NativeType("stbrp_rect *") STBRPRect.Buffer rects) {
/*  250 */     if (Checks.CHECKS) {
/*  251 */       Struct.validate(ranges.address(), ranges.remaining(), STBTTPackRange.SIZEOF, STBTTPackRange::validate);
/*      */     }
/*  253 */     return nstbtt_PackFontRangesGatherRects(spc.address(), info.address(), ranges.address(), ranges.remaining(), rects.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_PackFontRangesPackRects(@NativeType("stbtt_pack_context *") STBTTPackContext spc, @NativeType("stbrp_rect *") STBRPRect.Buffer rects) {
/*  263 */     nstbtt_PackFontRangesPackRects(spc.address(), rects.address(), rects.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackFontRangesRenderIntoRects(@NativeType("stbtt_pack_context *") STBTTPackContext spc, @NativeType("stbtt_fontinfo *") STBTTFontinfo info, @NativeType("stbtt_pack_range *") STBTTPackRange.Buffer ranges, @NativeType("stbrp_rect *") STBRPRect.Buffer rects) {
/*  274 */     if (Checks.CHECKS) {
/*  275 */       Struct.validate(ranges.address(), ranges.remaining(), STBTTPackRange.SIZEOF, STBTTPackRange::validate);
/*      */     }
/*  277 */     return (nstbtt_PackFontRangesRenderIntoRects(spc.address(), info.address(), ranges.address(), ranges.remaining(), rects.address()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetNumberOfFonts(@NativeType("unsigned char const *") ByteBuffer data) {
/*  287 */     return nstbtt_GetNumberOfFonts(MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetFontOffsetForIndex(@NativeType("unsigned char const *") ByteBuffer data, int index) {
/*  297 */     return nstbtt_GetFontOffsetForIndex(MemoryUtil.memAddress(data), index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_InitFont(@NativeType("stbtt_fontinfo *") STBTTFontinfo info, @NativeType("unsigned char const *") ByteBuffer data, int offset) {
/*  308 */     return (nstbtt_InitFont(info.address(), MemoryUtil.memAddress(data), offset) != 0);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_InitFont(@NativeType("stbtt_fontinfo *") STBTTFontinfo info, @NativeType("unsigned char const *") ByteBuffer data) {
/*  314 */     return (nstbtt_InitFont(info.address(), MemoryUtil.memAddress(data), 0) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_FindGlyphIndex(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int unicode_codepoint) {
/*  324 */     return nstbtt_FindGlyphIndex(info.address(), unicode_codepoint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float stbtt_ScaleForPixelHeight(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float pixels) {
/*  334 */     return nstbtt_ScaleForPixelHeight(info.address(), pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float stbtt_ScaleForMappingEmToPixels(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float pixels) {
/*  344 */     return nstbtt_ScaleForMappingEmToPixels(info.address(), pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetFontVMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("int *") IntBuffer ascent, @NativeType("int *") IntBuffer descent, @NativeType("int *") IntBuffer lineGap) {
/*  354 */     if (Checks.CHECKS) {
/*  355 */       Checks.checkSafe(ascent, 1);
/*  356 */       Checks.checkSafe(descent, 1);
/*  357 */       Checks.checkSafe(lineGap, 1);
/*      */     } 
/*  359 */     nstbtt_GetFontVMetrics(info.address(), MemoryUtil.memAddressSafe(ascent), MemoryUtil.memAddressSafe(descent), MemoryUtil.memAddressSafe(lineGap));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetFontVMetricsOS2(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("int *") IntBuffer typoAscent, @NativeType("int *") IntBuffer typoDescent, @NativeType("int *") IntBuffer typoLineGap) {
/*  370 */     if (Checks.CHECKS) {
/*  371 */       Checks.checkSafe(typoAscent, 1);
/*  372 */       Checks.checkSafe(typoDescent, 1);
/*  373 */       Checks.checkSafe(typoLineGap, 1);
/*      */     } 
/*  375 */     return (nstbtt_GetFontVMetricsOS2(info.address(), MemoryUtil.memAddressSafe(typoAscent), MemoryUtil.memAddressSafe(typoDescent), MemoryUtil.memAddressSafe(typoLineGap)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetFontBoundingBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("int *") IntBuffer x0, @NativeType("int *") IntBuffer y0, @NativeType("int *") IntBuffer x1, @NativeType("int *") IntBuffer y1) {
/*  385 */     if (Checks.CHECKS) {
/*  386 */       Checks.check(x0, 1);
/*  387 */       Checks.check(y0, 1);
/*  388 */       Checks.check(x1, 1);
/*  389 */       Checks.check(y1, 1);
/*      */     } 
/*  391 */     nstbtt_GetFontBoundingBox(info.address(), MemoryUtil.memAddress(x0), MemoryUtil.memAddress(y0), MemoryUtil.memAddress(x1), MemoryUtil.memAddress(y1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointHMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int codepoint, @NativeType("int *") IntBuffer advanceWidth, @NativeType("int *") IntBuffer leftSideBearing) {
/*  401 */     if (Checks.CHECKS) {
/*  402 */       Checks.checkSafe(advanceWidth, 1);
/*  403 */       Checks.checkSafe(leftSideBearing, 1);
/*      */     } 
/*  405 */     nstbtt_GetCodepointHMetrics(info.address(), codepoint, MemoryUtil.memAddressSafe(advanceWidth), MemoryUtil.memAddressSafe(leftSideBearing));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetCodepointKernAdvance(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int ch1, int ch2) {
/*  415 */     return nstbtt_GetCodepointKernAdvance(info.address(), ch1, ch2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetCodepointBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int codepoint, @NativeType("int *") IntBuffer x0, @NativeType("int *") IntBuffer y0, @NativeType("int *") IntBuffer x1, @NativeType("int *") IntBuffer y1) {
/*  426 */     if (Checks.CHECKS) {
/*  427 */       Checks.checkSafe(x0, 1);
/*  428 */       Checks.checkSafe(y0, 1);
/*  429 */       Checks.checkSafe(x1, 1);
/*  430 */       Checks.checkSafe(y1, 1);
/*      */     } 
/*  432 */     return (nstbtt_GetCodepointBox(info.address(), codepoint, MemoryUtil.memAddressSafe(x0), MemoryUtil.memAddressSafe(y0), MemoryUtil.memAddressSafe(x1), MemoryUtil.memAddressSafe(y1)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphHMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int glyph_index, @NativeType("int *") IntBuffer advanceWidth, @NativeType("int *") IntBuffer leftSideBearing) {
/*  442 */     if (Checks.CHECKS) {
/*  443 */       Checks.checkSafe(advanceWidth, 1);
/*  444 */       Checks.checkSafe(leftSideBearing, 1);
/*      */     } 
/*  446 */     nstbtt_GetGlyphHMetrics(info.address(), glyph_index, MemoryUtil.memAddressSafe(advanceWidth), MemoryUtil.memAddressSafe(leftSideBearing));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetGlyphKernAdvance(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int glyph1, int glyph2) {
/*  456 */     return nstbtt_GetGlyphKernAdvance(info.address(), glyph1, glyph2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetGlyphBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int glyph_index, @NativeType("int *") IntBuffer x0, @NativeType("int *") IntBuffer y0, @NativeType("int *") IntBuffer x1, @NativeType("int *") IntBuffer y1) {
/*  467 */     if (Checks.CHECKS) {
/*  468 */       Checks.checkSafe(x0, 1);
/*  469 */       Checks.checkSafe(y0, 1);
/*  470 */       Checks.checkSafe(x1, 1);
/*  471 */       Checks.checkSafe(y1, 1);
/*      */     } 
/*  473 */     return (nstbtt_GetGlyphBox(info.address(), glyph_index, MemoryUtil.memAddressSafe(x0), MemoryUtil.memAddressSafe(y0), MemoryUtil.memAddressSafe(x1), MemoryUtil.memAddressSafe(y1)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetKerningTableLength(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info) {
/*  483 */     return nstbtt_GetKerningTableLength(info.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetKerningTable(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("stbtt_kerningentry *") STBTTKerningentry.Buffer table) {
/*  493 */     return nstbtt_GetKerningTable(info.address(), table.address(), table.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_IsGlyphEmpty(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int glyph_index) {
/*  504 */     return (nstbtt_IsGlyphEmpty(info.address(), glyph_index) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetCodepointShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int unicode_codepoint, @NativeType("stbtt_vertex **") PointerBuffer vertices) {
/*  514 */     if (Checks.CHECKS) {
/*  515 */       Checks.check((CustomBuffer)vertices, 1);
/*      */     }
/*  517 */     return nstbtt_GetCodepointShape(info.address(), unicode_codepoint, MemoryUtil.memAddress((CustomBuffer)vertices));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static STBTTVertex.Buffer stbtt_GetCodepointShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int unicode_codepoint) {
/*  523 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  525 */       PointerBuffer vertices = stack.pointers(0L);
/*  526 */       int __result = nstbtt_GetCodepointShape(info.address(), unicode_codepoint, MemoryUtil.memAddress((CustomBuffer)vertices));
/*  527 */       return STBTTVertex.createSafe(vertices.get(0), __result);
/*      */     } finally {
/*  529 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetGlyphShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int glyph_index, @NativeType("stbtt_vertex **") PointerBuffer vertices) {
/*  540 */     if (Checks.CHECKS) {
/*  541 */       Checks.check((CustomBuffer)vertices, 1);
/*      */     }
/*  543 */     return nstbtt_GetGlyphShape(info.address(), glyph_index, MemoryUtil.memAddress((CustomBuffer)vertices));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static STBTTVertex.Buffer stbtt_GetGlyphShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int glyph_index) {
/*  549 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  551 */       PointerBuffer vertices = stack.pointers(0L);
/*  552 */       int __result = nstbtt_GetGlyphShape(info.address(), glyph_index, MemoryUtil.memAddress((CustomBuffer)vertices));
/*  553 */       return STBTTVertex.createSafe(vertices.get(0), __result);
/*      */     } finally {
/*  555 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("stbtt_vertex *") STBTTVertex.Buffer vertices) {
/*  566 */     if (Checks.CHECKS) {
/*  567 */       Checks.check((CustomBuffer)vertices, 1);
/*      */     }
/*  569 */     nstbtt_FreeShape(info.address(), vertices.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static long stbtt_FindSVGDoc(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int gl) {
/*  580 */     return nstbtt_FindSVGDoc(info.address(), gl);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetCodepointSVG(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int unicode_codepoint, @NativeType("char const **") PointerBuffer svg) {
/*  590 */     if (Checks.CHECKS) {
/*  591 */       Checks.check((CustomBuffer)svg, 1);
/*      */     }
/*  593 */     return nstbtt_GetCodepointSVG(info.address(), unicode_codepoint, MemoryUtil.memAddress((CustomBuffer)svg));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetGlyphSVG(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int gl, @NativeType("char const **") PointerBuffer svg) {
/*  603 */     if (Checks.CHECKS) {
/*  604 */       Checks.check((CustomBuffer)svg, 1);
/*      */     }
/*  606 */     return nstbtt_GetGlyphSVG(info.address(), gl, MemoryUtil.memAddress((CustomBuffer)svg));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeBitmap(@NativeType("unsigned char *") ByteBuffer bitmap, @NativeType("void *") long userdata) {
/*  616 */     nstbtt_FreeBitmap(MemoryUtil.memAddress(bitmap), userdata);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeBitmap(@NativeType("unsigned char *") ByteBuffer bitmap) {
/*  621 */     nstbtt_FreeBitmap(MemoryUtil.memAddress(bitmap), 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float scale_x, float scale_y, int codepoint, @NativeType("int *") IntBuffer width, @NativeType("int *") IntBuffer height, @NativeType("int *") IntBuffer xoff, @NativeType("int *") IntBuffer yoff) {
/*  632 */     if (Checks.CHECKS) {
/*  633 */       Checks.check(width, 1);
/*  634 */       Checks.check(height, 1);
/*  635 */       Checks.checkSafe(xoff, 1);
/*  636 */       Checks.checkSafe(yoff, 1);
/*      */     } 
/*  638 */     long __result = nstbtt_GetCodepointBitmap(info.address(), scale_x, scale_y, codepoint, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddressSafe(xoff), MemoryUtil.memAddressSafe(yoff));
/*  639 */     return MemoryUtil.memByteBufferSafe(__result, width.get(width.position()) * height.get(height.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float scale_x, float scale_y, float shift_x, float shift_y, int codepoint, @NativeType("int *") IntBuffer width, @NativeType("int *") IntBuffer height, @NativeType("int *") IntBuffer xoff, @NativeType("int *") IntBuffer yoff) {
/*  650 */     if (Checks.CHECKS) {
/*  651 */       Checks.check(width, 1);
/*  652 */       Checks.check(height, 1);
/*  653 */       Checks.checkSafe(xoff, 1);
/*  654 */       Checks.checkSafe(yoff, 1);
/*      */     } 
/*  656 */     long __result = nstbtt_GetCodepointBitmapSubpixel(info.address(), scale_x, scale_y, shift_x, shift_y, codepoint, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddressSafe(xoff), MemoryUtil.memAddressSafe(yoff));
/*  657 */     return MemoryUtil.memByteBufferSafe(__result, width.get(width.position()) * height.get(height.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeCodepointBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("unsigned char *") ByteBuffer output, int out_w, int out_h, int out_stride, float scale_x, float scale_y, int codepoint) {
/*  667 */     if (Checks.CHECKS) {
/*  668 */       Checks.check(output, ((out_stride != 0) ? out_stride : out_w) * out_h);
/*      */     }
/*  670 */     nstbtt_MakeCodepointBitmap(info.address(), MemoryUtil.memAddress(output), out_w, out_h, out_stride, scale_x, scale_y, codepoint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeCodepointBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("unsigned char *") ByteBuffer output, int out_w, int out_h, int out_stride, float scale_x, float scale_y, float shift_x, float shift_y, int codepoint) {
/*  680 */     if (Checks.CHECKS) {
/*  681 */       Checks.check(output, ((out_stride != 0) ? out_stride : out_w) * out_h);
/*      */     }
/*  683 */     nstbtt_MakeCodepointBitmapSubpixel(info.address(), MemoryUtil.memAddress(output), out_w, out_h, out_stride, scale_x, scale_y, shift_x, shift_y, codepoint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeCodepointBitmapSubpixelPrefilter(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("unsigned char *") ByteBuffer output, int out_w, int out_h, int out_stride, float scale_x, float scale_y, float shift_x, float shift_y, int oversample_x, int oversample_y, @NativeType("float *") FloatBuffer sub_x, @NativeType("float *") FloatBuffer sub_y, int codepoint) {
/*  693 */     if (Checks.CHECKS) {
/*  694 */       Checks.check(output, ((out_stride != 0) ? out_stride : out_w) * out_h);
/*  695 */       Checks.check(sub_x, 1);
/*  696 */       Checks.check(sub_y, 1);
/*      */     } 
/*  698 */     nstbtt_MakeCodepointBitmapSubpixelPrefilter(info.address(), MemoryUtil.memAddress(output), out_w, out_h, out_stride, scale_x, scale_y, shift_x, shift_y, oversample_x, oversample_y, MemoryUtil.memAddress(sub_x), MemoryUtil.memAddress(sub_y), codepoint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointBitmapBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, int codepoint, float scale_x, float scale_y, @NativeType("int *") IntBuffer ix0, @NativeType("int *") IntBuffer iy0, @NativeType("int *") IntBuffer ix1, @NativeType("int *") IntBuffer iy1) {
/*  708 */     if (Checks.CHECKS) {
/*  709 */       Checks.checkSafe(ix0, 1);
/*  710 */       Checks.checkSafe(iy0, 1);
/*  711 */       Checks.checkSafe(ix1, 1);
/*  712 */       Checks.checkSafe(iy1, 1);
/*      */     } 
/*  714 */     nstbtt_GetCodepointBitmapBox(font.address(), codepoint, scale_x, scale_y, MemoryUtil.memAddressSafe(ix0), MemoryUtil.memAddressSafe(iy0), MemoryUtil.memAddressSafe(ix1), MemoryUtil.memAddressSafe(iy1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointBitmapBoxSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, int codepoint, float scale_x, float scale_y, float shift_x, float shift_y, @NativeType("int *") IntBuffer ix0, @NativeType("int *") IntBuffer iy0, @NativeType("int *") IntBuffer ix1, @NativeType("int *") IntBuffer iy1) {
/*  724 */     if (Checks.CHECKS) {
/*  725 */       Checks.checkSafe(ix0, 1);
/*  726 */       Checks.checkSafe(iy0, 1);
/*  727 */       Checks.checkSafe(ix1, 1);
/*  728 */       Checks.checkSafe(iy1, 1);
/*      */     } 
/*  730 */     nstbtt_GetCodepointBitmapBoxSubpixel(font.address(), codepoint, scale_x, scale_y, shift_x, shift_y, MemoryUtil.memAddressSafe(ix0), MemoryUtil.memAddressSafe(iy0), MemoryUtil.memAddressSafe(ix1), MemoryUtil.memAddressSafe(iy1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float scale_x, float scale_y, int glyph, @NativeType("int *") IntBuffer width, @NativeType("int *") IntBuffer height, @NativeType("int *") IntBuffer xoff, @NativeType("int *") IntBuffer yoff) {
/*  741 */     if (Checks.CHECKS) {
/*  742 */       Checks.check(width, 1);
/*  743 */       Checks.check(height, 1);
/*  744 */       Checks.checkSafe(xoff, 1);
/*  745 */       Checks.checkSafe(yoff, 1);
/*      */     } 
/*  747 */     long __result = nstbtt_GetGlyphBitmap(info.address(), scale_x, scale_y, glyph, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddressSafe(xoff), MemoryUtil.memAddressSafe(yoff));
/*  748 */     return MemoryUtil.memByteBufferSafe(__result, width.get(width.position()) * height.get(height.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float scale_x, float scale_y, float shift_x, float shift_y, int glyph, @NativeType("int *") IntBuffer width, @NativeType("int *") IntBuffer height, @NativeType("int *") IntBuffer xoff, @NativeType("int *") IntBuffer yoff) {
/*  759 */     if (Checks.CHECKS) {
/*  760 */       Checks.check(width, 1);
/*  761 */       Checks.check(height, 1);
/*  762 */       Checks.checkSafe(xoff, 1);
/*  763 */       Checks.checkSafe(yoff, 1);
/*      */     } 
/*  765 */     long __result = nstbtt_GetGlyphBitmapSubpixel(info.address(), scale_x, scale_y, shift_x, shift_y, glyph, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddressSafe(xoff), MemoryUtil.memAddressSafe(yoff));
/*  766 */     return MemoryUtil.memByteBufferSafe(__result, width.get(width.position()) * height.get(height.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeGlyphBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("unsigned char *") ByteBuffer output, int out_w, int out_h, int out_stride, float scale_x, float scale_y, int glyph) {
/*  776 */     if (Checks.CHECKS) {
/*  777 */       Checks.check(output, ((out_stride != 0) ? out_stride : out_w) * out_h);
/*      */     }
/*  779 */     nstbtt_MakeGlyphBitmap(info.address(), MemoryUtil.memAddress(output), out_w, out_h, out_stride, scale_x, scale_y, glyph);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeGlyphBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("unsigned char *") ByteBuffer output, int out_w, int out_h, int out_stride, float scale_x, float scale_y, float shift_x, float shift_y, int glyph) {
/*  789 */     if (Checks.CHECKS) {
/*  790 */       Checks.check(output, ((out_stride != 0) ? out_stride : out_w) * out_h);
/*      */     }
/*  792 */     nstbtt_MakeGlyphBitmapSubpixel(info.address(), MemoryUtil.memAddress(output), out_w, out_h, out_stride, scale_x, scale_y, shift_x, shift_y, glyph);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeGlyphBitmapSubpixelPrefilter(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("unsigned char *") ByteBuffer output, int out_w, int out_h, int out_stride, float scale_x, float scale_y, float shift_x, float shift_y, int oversample_x, int oversample_y, @NativeType("float *") FloatBuffer sub_x, @NativeType("float *") FloatBuffer sub_y, int glyph) {
/*  802 */     if (Checks.CHECKS) {
/*  803 */       Checks.check(output, ((out_stride != 0) ? out_stride : out_w) * out_h);
/*  804 */       Checks.check(sub_x, 1);
/*  805 */       Checks.check(sub_y, 1);
/*      */     } 
/*  807 */     nstbtt_MakeGlyphBitmapSubpixelPrefilter(info.address(), MemoryUtil.memAddress(output), out_w, out_h, out_stride, scale_x, scale_y, shift_x, shift_y, oversample_x, oversample_y, MemoryUtil.memAddress(sub_x), MemoryUtil.memAddress(sub_y), glyph);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphBitmapBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, int glyph, float scale_x, float scale_y, @NativeType("int *") IntBuffer ix0, @NativeType("int *") IntBuffer iy0, @NativeType("int *") IntBuffer ix1, @NativeType("int *") IntBuffer iy1) {
/*  817 */     if (Checks.CHECKS) {
/*  818 */       Checks.checkSafe(ix0, 1);
/*  819 */       Checks.checkSafe(iy0, 1);
/*  820 */       Checks.checkSafe(ix1, 1);
/*  821 */       Checks.checkSafe(iy1, 1);
/*      */     } 
/*  823 */     nstbtt_GetGlyphBitmapBox(font.address(), glyph, scale_x, scale_y, MemoryUtil.memAddressSafe(ix0), MemoryUtil.memAddressSafe(iy0), MemoryUtil.memAddressSafe(ix1), MemoryUtil.memAddressSafe(iy1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphBitmapBoxSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, int glyph, float scale_x, float scale_y, float shift_x, float shift_y, @NativeType("int *") IntBuffer ix0, @NativeType("int *") IntBuffer iy0, @NativeType("int *") IntBuffer ix1, @NativeType("int *") IntBuffer iy1) {
/*  833 */     if (Checks.CHECKS) {
/*  834 */       Checks.checkSafe(ix0, 1);
/*  835 */       Checks.checkSafe(iy0, 1);
/*  836 */       Checks.checkSafe(ix1, 1);
/*  837 */       Checks.checkSafe(iy1, 1);
/*      */     } 
/*  839 */     nstbtt_GetGlyphBitmapBoxSubpixel(font.address(), glyph, scale_x, scale_y, shift_x, shift_y, MemoryUtil.memAddressSafe(ix0), MemoryUtil.memAddressSafe(iy0), MemoryUtil.memAddressSafe(ix1), MemoryUtil.memAddressSafe(iy1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_Rasterize(@NativeType("stbtt__bitmap *") STBTTBitmap result, float flatness_in_pixels, @NativeType("stbtt_vertex *") STBTTVertex.Buffer vertices, float scale_x, float scale_y, float shift_x, float shift_y, int x_off, int y_off, @NativeType("int") boolean invert) {
/*  849 */     nstbtt_Rasterize(result.address(), flatness_in_pixels, vertices.address(), vertices.remaining(), scale_x, scale_y, shift_x, shift_y, x_off, y_off, invert ? 1 : 0, 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeSDF(@NativeType("unsigned char *") ByteBuffer bitmap, @NativeType("void *") long userdata) {
/*  859 */     nstbtt_FreeSDF(MemoryUtil.memAddress(bitmap), userdata);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeSDF(@NativeType("unsigned char *") ByteBuffer bitmap) {
/*  864 */     nstbtt_FreeSDF(MemoryUtil.memAddress(bitmap), 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphSDF(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, float scale, int glyph, int padding, @NativeType("unsigned char") byte onedge_value, float pixel_dist_scale, @NativeType("int *") IntBuffer width, @NativeType("int *") IntBuffer height, @NativeType("int *") IntBuffer xoff, @NativeType("int *") IntBuffer yoff) {
/*  875 */     if (Checks.CHECKS) {
/*  876 */       Checks.check(width, 1);
/*  877 */       Checks.check(height, 1);
/*  878 */       Checks.check(xoff, 1);
/*  879 */       Checks.check(yoff, 1);
/*      */     } 
/*  881 */     long __result = nstbtt_GetGlyphSDF(font.address(), scale, glyph, padding, onedge_value, pixel_dist_scale, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddress(xoff), MemoryUtil.memAddress(yoff));
/*  882 */     return MemoryUtil.memByteBufferSafe(__result, width.get(width.position()) * height.get(height.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointSDF(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, float scale, int codepoint, int padding, @NativeType("unsigned char") byte onedge_value, float pixel_dist_scale, @NativeType("int *") IntBuffer width, @NativeType("int *") IntBuffer height, @NativeType("int *") IntBuffer xoff, @NativeType("int *") IntBuffer yoff) {
/*  893 */     if (Checks.CHECKS) {
/*  894 */       Checks.check(width, 1);
/*  895 */       Checks.check(height, 1);
/*  896 */       Checks.check(xoff, 1);
/*  897 */       Checks.check(yoff, 1);
/*      */     } 
/*  899 */     long __result = nstbtt_GetCodepointSDF(font.address(), scale, codepoint, padding, onedge_value, pixel_dist_scale, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddress(xoff), MemoryUtil.memAddress(yoff));
/*  900 */     return MemoryUtil.memByteBufferSafe(__result, width.get(width.position()) * height.get(height.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_FindMatchingFont(@NativeType("unsigned char const *") ByteBuffer fontdata, @NativeType("char const *") ByteBuffer name, int flags) {
/*  910 */     if (Checks.CHECKS) {
/*  911 */       Checks.checkNT1(name);
/*      */     }
/*  913 */     return nstbtt_FindMatchingFont(MemoryUtil.memAddress(fontdata), MemoryUtil.memAddress(name), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int stbtt_FindMatchingFont(@NativeType("unsigned char const *") ByteBuffer fontdata, @NativeType("char const *") CharSequence name, int flags) {
/*  918 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  920 */       stack.nUTF8(name, true);
/*  921 */       long nameEncoded = stack.getPointerAddress();
/*  922 */       return nstbtt_FindMatchingFont(MemoryUtil.memAddress(fontdata), nameEncoded, flags);
/*      */     } finally {
/*  924 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_CompareUTF8toUTF16_bigendian(@NativeType("char const *") ByteBuffer s1, @NativeType("char const *") ByteBuffer s2) {
/*  936 */     return (nstbtt_CompareUTF8toUTF16_bigendian(MemoryUtil.memAddress(s1), s1.remaining(), MemoryUtil.memAddress(s2), s2.remaining()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static ByteBuffer stbtt_GetFontNameString(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, int platformID, int encodingID, int languageID, int nameID) {
/*  947 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  948 */     IntBuffer length = stack.callocInt(1);
/*      */     try {
/*  950 */       long __result = nstbtt_GetFontNameString(font.address(), MemoryUtil.memAddress(length), platformID, encodingID, languageID, nameID);
/*  951 */       return MemoryUtil.memByteBufferSafe(__result, length.get(0));
/*      */     } finally {
/*  953 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetBakedQuad(@NativeType("stbtt_bakedchar const *") STBTTBakedChar.Buffer chardata, int pw, int ph, int char_index, @NativeType("float *") float[] xpos, @NativeType("float *") float[] ypos, @NativeType("stbtt_aligned_quad *") STBTTAlignedQuad q, @NativeType("int") boolean opengl_fillrule) {
/*  962 */     if (Checks.CHECKS) {
/*  963 */       Checks.check((CustomBuffer)chardata, char_index + 1);
/*  964 */       Checks.check(xpos, 1);
/*  965 */       Checks.check(ypos, 1);
/*      */     } 
/*  967 */     nstbtt_GetBakedQuad(chardata.address(), pw, ph, char_index, xpos, ypos, q.address(), opengl_fillrule ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetScaledFontVMetrics(@NativeType("unsigned char const *") ByteBuffer fontdata, int index, float size, @NativeType("float *") float[] ascent, @NativeType("float *") float[] descent, @NativeType("float *") float[] lineGap) {
/*  975 */     if (Checks.CHECKS) {
/*  976 */       Checks.check(ascent, 1);
/*  977 */       Checks.check(descent, 1);
/*  978 */       Checks.check(lineGap, 1);
/*      */     } 
/*  980 */     nstbtt_GetScaledFontVMetrics(MemoryUtil.memAddress(fontdata), index, size, ascent, descent, lineGap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetPackedQuad(@NativeType("stbtt_packedchar const *") STBTTPackedchar.Buffer chardata, int pw, int ph, int char_index, @NativeType("float *") float[] xpos, @NativeType("float *") float[] ypos, @NativeType("stbtt_aligned_quad *") STBTTAlignedQuad q, @NativeType("int") boolean align_to_integer) {
/*  988 */     if (Checks.CHECKS) {
/*  989 */       Checks.check((CustomBuffer)chardata, char_index + 1);
/*  990 */       Checks.check(xpos, 1);
/*  991 */       Checks.check(ypos, 1);
/*      */     } 
/*  993 */     nstbtt_GetPackedQuad(chardata.address(), pw, ph, char_index, xpos, ypos, q.address(), align_to_integer ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetFontVMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("int *") int[] ascent, @NativeType("int *") int[] descent, @NativeType("int *") int[] lineGap) {
/* 1001 */     if (Checks.CHECKS) {
/* 1002 */       Checks.checkSafe(ascent, 1);
/* 1003 */       Checks.checkSafe(descent, 1);
/* 1004 */       Checks.checkSafe(lineGap, 1);
/*      */     } 
/* 1006 */     nstbtt_GetFontVMetrics(info.address(), ascent, descent, lineGap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetFontVMetricsOS2(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("int *") int[] typoAscent, @NativeType("int *") int[] typoDescent, @NativeType("int *") int[] typoLineGap) {
/* 1015 */     if (Checks.CHECKS) {
/* 1016 */       Checks.checkSafe(typoAscent, 1);
/* 1017 */       Checks.checkSafe(typoDescent, 1);
/* 1018 */       Checks.checkSafe(typoLineGap, 1);
/*      */     } 
/* 1020 */     return (nstbtt_GetFontVMetricsOS2(info.address(), typoAscent, typoDescent, typoLineGap) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetFontBoundingBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("int *") int[] x0, @NativeType("int *") int[] y0, @NativeType("int *") int[] x1, @NativeType("int *") int[] y1) {
/* 1028 */     if (Checks.CHECKS) {
/* 1029 */       Checks.check(x0, 1);
/* 1030 */       Checks.check(y0, 1);
/* 1031 */       Checks.check(x1, 1);
/* 1032 */       Checks.check(y1, 1);
/*      */     } 
/* 1034 */     nstbtt_GetFontBoundingBox(info.address(), x0, y0, x1, y1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointHMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int codepoint, @NativeType("int *") int[] advanceWidth, @NativeType("int *") int[] leftSideBearing) {
/* 1042 */     if (Checks.CHECKS) {
/* 1043 */       Checks.checkSafe(advanceWidth, 1);
/* 1044 */       Checks.checkSafe(leftSideBearing, 1);
/*      */     } 
/* 1046 */     nstbtt_GetCodepointHMetrics(info.address(), codepoint, advanceWidth, leftSideBearing);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetCodepointBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int codepoint, @NativeType("int *") int[] x0, @NativeType("int *") int[] y0, @NativeType("int *") int[] x1, @NativeType("int *") int[] y1) {
/* 1055 */     if (Checks.CHECKS) {
/* 1056 */       Checks.checkSafe(x0, 1);
/* 1057 */       Checks.checkSafe(y0, 1);
/* 1058 */       Checks.checkSafe(x1, 1);
/* 1059 */       Checks.checkSafe(y1, 1);
/*      */     } 
/* 1061 */     return (nstbtt_GetCodepointBox(info.address(), codepoint, x0, y0, x1, y1) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphHMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int glyph_index, @NativeType("int *") int[] advanceWidth, @NativeType("int *") int[] leftSideBearing) {
/* 1069 */     if (Checks.CHECKS) {
/* 1070 */       Checks.checkSafe(advanceWidth, 1);
/* 1071 */       Checks.checkSafe(leftSideBearing, 1);
/*      */     } 
/* 1073 */     nstbtt_GetGlyphHMetrics(info.address(), glyph_index, advanceWidth, leftSideBearing);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetGlyphBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, int glyph_index, @NativeType("int *") int[] x0, @NativeType("int *") int[] y0, @NativeType("int *") int[] x1, @NativeType("int *") int[] y1) {
/* 1082 */     if (Checks.CHECKS) {
/* 1083 */       Checks.checkSafe(x0, 1);
/* 1084 */       Checks.checkSafe(y0, 1);
/* 1085 */       Checks.checkSafe(x1, 1);
/* 1086 */       Checks.checkSafe(y1, 1);
/*      */     } 
/* 1088 */     return (nstbtt_GetGlyphBox(info.address(), glyph_index, x0, y0, x1, y1) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float scale_x, float scale_y, int codepoint, @NativeType("int *") int[] width, @NativeType("int *") int[] height, @NativeType("int *") int[] xoff, @NativeType("int *") int[] yoff) {
/* 1097 */     if (Checks.CHECKS) {
/* 1098 */       Checks.check(width, 1);
/* 1099 */       Checks.check(height, 1);
/* 1100 */       Checks.checkSafe(xoff, 1);
/* 1101 */       Checks.checkSafe(yoff, 1);
/*      */     } 
/* 1103 */     long __result = nstbtt_GetCodepointBitmap(info.address(), scale_x, scale_y, codepoint, width, height, xoff, yoff);
/* 1104 */     return MemoryUtil.memByteBufferSafe(__result, width[0] * height[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float scale_x, float scale_y, float shift_x, float shift_y, int codepoint, @NativeType("int *") int[] width, @NativeType("int *") int[] height, @NativeType("int *") int[] xoff, @NativeType("int *") int[] yoff) {
/* 1113 */     if (Checks.CHECKS) {
/* 1114 */       Checks.check(width, 1);
/* 1115 */       Checks.check(height, 1);
/* 1116 */       Checks.checkSafe(xoff, 1);
/* 1117 */       Checks.checkSafe(yoff, 1);
/*      */     } 
/* 1119 */     long __result = nstbtt_GetCodepointBitmapSubpixel(info.address(), scale_x, scale_y, shift_x, shift_y, codepoint, width, height, xoff, yoff);
/* 1120 */     return MemoryUtil.memByteBufferSafe(__result, width[0] * height[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeCodepointBitmapSubpixelPrefilter(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("unsigned char *") ByteBuffer output, int out_w, int out_h, int out_stride, float scale_x, float scale_y, float shift_x, float shift_y, int oversample_x, int oversample_y, @NativeType("float *") float[] sub_x, @NativeType("float *") float[] sub_y, int codepoint) {
/* 1128 */     if (Checks.CHECKS) {
/* 1129 */       Checks.check(output, ((out_stride != 0) ? out_stride : out_w) * out_h);
/* 1130 */       Checks.check(sub_x, 1);
/* 1131 */       Checks.check(sub_y, 1);
/*      */     } 
/* 1133 */     nstbtt_MakeCodepointBitmapSubpixelPrefilter(info.address(), MemoryUtil.memAddress(output), out_w, out_h, out_stride, scale_x, scale_y, shift_x, shift_y, oversample_x, oversample_y, sub_x, sub_y, codepoint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointBitmapBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, int codepoint, float scale_x, float scale_y, @NativeType("int *") int[] ix0, @NativeType("int *") int[] iy0, @NativeType("int *") int[] ix1, @NativeType("int *") int[] iy1) {
/* 1141 */     if (Checks.CHECKS) {
/* 1142 */       Checks.checkSafe(ix0, 1);
/* 1143 */       Checks.checkSafe(iy0, 1);
/* 1144 */       Checks.checkSafe(ix1, 1);
/* 1145 */       Checks.checkSafe(iy1, 1);
/*      */     } 
/* 1147 */     nstbtt_GetCodepointBitmapBox(font.address(), codepoint, scale_x, scale_y, ix0, iy0, ix1, iy1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointBitmapBoxSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, int codepoint, float scale_x, float scale_y, float shift_x, float shift_y, @NativeType("int *") int[] ix0, @NativeType("int *") int[] iy0, @NativeType("int *") int[] ix1, @NativeType("int *") int[] iy1) {
/* 1155 */     if (Checks.CHECKS) {
/* 1156 */       Checks.checkSafe(ix0, 1);
/* 1157 */       Checks.checkSafe(iy0, 1);
/* 1158 */       Checks.checkSafe(ix1, 1);
/* 1159 */       Checks.checkSafe(iy1, 1);
/*      */     } 
/* 1161 */     nstbtt_GetCodepointBitmapBoxSubpixel(font.address(), codepoint, scale_x, scale_y, shift_x, shift_y, ix0, iy0, ix1, iy1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float scale_x, float scale_y, int glyph, @NativeType("int *") int[] width, @NativeType("int *") int[] height, @NativeType("int *") int[] xoff, @NativeType("int *") int[] yoff) {
/* 1170 */     if (Checks.CHECKS) {
/* 1171 */       Checks.check(width, 1);
/* 1172 */       Checks.check(height, 1);
/* 1173 */       Checks.checkSafe(xoff, 1);
/* 1174 */       Checks.checkSafe(yoff, 1);
/*      */     } 
/* 1176 */     long __result = nstbtt_GetGlyphBitmap(info.address(), scale_x, scale_y, glyph, width, height, xoff, yoff);
/* 1177 */     return MemoryUtil.memByteBufferSafe(__result, width[0] * height[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, float scale_x, float scale_y, float shift_x, float shift_y, int glyph, @NativeType("int *") int[] width, @NativeType("int *") int[] height, @NativeType("int *") int[] xoff, @NativeType("int *") int[] yoff) {
/* 1186 */     if (Checks.CHECKS) {
/* 1187 */       Checks.check(width, 1);
/* 1188 */       Checks.check(height, 1);
/* 1189 */       Checks.checkSafe(xoff, 1);
/* 1190 */       Checks.checkSafe(yoff, 1);
/*      */     } 
/* 1192 */     long __result = nstbtt_GetGlyphBitmapSubpixel(info.address(), scale_x, scale_y, shift_x, shift_y, glyph, width, height, xoff, yoff);
/* 1193 */     return MemoryUtil.memByteBufferSafe(__result, width[0] * height[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeGlyphBitmapSubpixelPrefilter(@NativeType("stbtt_fontinfo const *") STBTTFontinfo info, @NativeType("unsigned char *") ByteBuffer output, int out_w, int out_h, int out_stride, float scale_x, float scale_y, float shift_x, float shift_y, int oversample_x, int oversample_y, @NativeType("float *") float[] sub_x, @NativeType("float *") float[] sub_y, int glyph) {
/* 1201 */     if (Checks.CHECKS) {
/* 1202 */       Checks.check(output, ((out_stride != 0) ? out_stride : out_w) * out_h);
/* 1203 */       Checks.check(sub_x, 1);
/* 1204 */       Checks.check(sub_y, 1);
/*      */     } 
/* 1206 */     nstbtt_MakeGlyphBitmapSubpixelPrefilter(info.address(), MemoryUtil.memAddress(output), out_w, out_h, out_stride, scale_x, scale_y, shift_x, shift_y, oversample_x, oversample_y, sub_x, sub_y, glyph);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphBitmapBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, int glyph, float scale_x, float scale_y, @NativeType("int *") int[] ix0, @NativeType("int *") int[] iy0, @NativeType("int *") int[] ix1, @NativeType("int *") int[] iy1) {
/* 1214 */     if (Checks.CHECKS) {
/* 1215 */       Checks.checkSafe(ix0, 1);
/* 1216 */       Checks.checkSafe(iy0, 1);
/* 1217 */       Checks.checkSafe(ix1, 1);
/* 1218 */       Checks.checkSafe(iy1, 1);
/*      */     } 
/* 1220 */     nstbtt_GetGlyphBitmapBox(font.address(), glyph, scale_x, scale_y, ix0, iy0, ix1, iy1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphBitmapBoxSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, int glyph, float scale_x, float scale_y, float shift_x, float shift_y, @NativeType("int *") int[] ix0, @NativeType("int *") int[] iy0, @NativeType("int *") int[] ix1, @NativeType("int *") int[] iy1) {
/* 1228 */     if (Checks.CHECKS) {
/* 1229 */       Checks.checkSafe(ix0, 1);
/* 1230 */       Checks.checkSafe(iy0, 1);
/* 1231 */       Checks.checkSafe(ix1, 1);
/* 1232 */       Checks.checkSafe(iy1, 1);
/*      */     } 
/* 1234 */     nstbtt_GetGlyphBitmapBoxSubpixel(font.address(), glyph, scale_x, scale_y, shift_x, shift_y, ix0, iy0, ix1, iy1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphSDF(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, float scale, int glyph, int padding, @NativeType("unsigned char") byte onedge_value, float pixel_dist_scale, @NativeType("int *") int[] width, @NativeType("int *") int[] height, @NativeType("int *") int[] xoff, @NativeType("int *") int[] yoff) {
/* 1243 */     if (Checks.CHECKS) {
/* 1244 */       Checks.check(width, 1);
/* 1245 */       Checks.check(height, 1);
/* 1246 */       Checks.check(xoff, 1);
/* 1247 */       Checks.check(yoff, 1);
/*      */     } 
/* 1249 */     long __result = nstbtt_GetGlyphSDF(font.address(), scale, glyph, padding, onedge_value, pixel_dist_scale, width, height, xoff, yoff);
/* 1250 */     return MemoryUtil.memByteBufferSafe(__result, width[0] * height[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointSDF(@NativeType("stbtt_fontinfo const *") STBTTFontinfo font, float scale, int codepoint, int padding, @NativeType("unsigned char") byte onedge_value, float pixel_dist_scale, @NativeType("int *") int[] width, @NativeType("int *") int[] height, @NativeType("int *") int[] xoff, @NativeType("int *") int[] yoff) {
/* 1259 */     if (Checks.CHECKS) {
/* 1260 */       Checks.check(width, 1);
/* 1261 */       Checks.check(height, 1);
/* 1262 */       Checks.check(xoff, 1);
/* 1263 */       Checks.check(yoff, 1);
/*      */     } 
/* 1265 */     long __result = nstbtt_GetCodepointSDF(font.address(), scale, codepoint, padding, onedge_value, pixel_dist_scale, width, height, xoff, yoff);
/* 1266 */     return MemoryUtil.memByteBufferSafe(__result, width[0] * height[0]);
/*      */   }
/*      */   
/*      */   public static native int nstbtt_BakeFontBitmap(long paramLong1, int paramInt1, float paramFloat, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong3);
/*      */   
/*      */   public static native void nstbtt_GetBakedQuad(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_GetScaledFontVMetrics(long paramLong1, int paramInt, float paramFloat, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nstbtt_PackBegin(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong3);
/*      */   
/*      */   public static native void nstbtt_PackEnd(long paramLong);
/*      */   
/*      */   public static native int nstbtt_PackFontRange(long paramLong1, long paramLong2, int paramInt1, float paramFloat, int paramInt2, int paramInt3, long paramLong3);
/*      */   
/*      */   public static native int nstbtt_PackFontRanges(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nstbtt_PackSetOversampling(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nstbtt_PackSetSkipMissingCodepoints(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nstbtt_GetPackedQuad(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, int paramInt4);
/*      */   
/*      */   public static native int nstbtt_PackFontRangesGatherRects(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*      */   
/*      */   public static native void nstbtt_PackFontRangesPackRects(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nstbtt_PackFontRangesRenderIntoRects(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*      */   
/*      */   public static native int nstbtt_GetNumberOfFonts(long paramLong);
/*      */   
/*      */   public static native int nstbtt_GetFontOffsetForIndex(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nstbtt_InitFont(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nstbtt_FindGlyphIndex(long paramLong, int paramInt);
/*      */   
/*      */   public static native float nstbtt_ScaleForPixelHeight(long paramLong, float paramFloat);
/*      */   
/*      */   public static native float nstbtt_ScaleForMappingEmToPixels(long paramLong, float paramFloat);
/*      */   
/*      */   public static native void nstbtt_GetFontVMetrics(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nstbtt_GetFontVMetricsOS2(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void nstbtt_GetFontBoundingBox(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_GetCodepointHMetrics(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nstbtt_GetCodepointKernAdvance(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native int nstbtt_GetCodepointBox(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_GetGlyphHMetrics(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nstbtt_GetGlyphKernAdvance(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native int nstbtt_GetGlyphBox(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int nstbtt_GetKerningTableLength(long paramLong);
/*      */   
/*      */   public static native int nstbtt_GetKerningTable(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nstbtt_IsGlyphEmpty(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nstbtt_GetCodepointShape(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int nstbtt_GetGlyphShape(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void nstbtt_FreeShape(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nstbtt_FindSVGDoc(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nstbtt_GetCodepointSVG(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int nstbtt_GetGlyphSVG(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void nstbtt_FreeBitmap(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nstbtt_GetCodepointBitmap(long paramLong1, float paramFloat1, float paramFloat2, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native long nstbtt_GetCodepointBitmapSubpixel(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_MakeCodepointBitmap(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_MakeCodepointBitmapSubpixel(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_MakeCodepointBitmapSubpixelPrefilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, long paramLong3, long paramLong4, int paramInt6);
/*      */   
/*      */   public static native void nstbtt_GetCodepointBitmapBox(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_GetCodepointBitmapBoxSubpixel(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native long nstbtt_GetGlyphBitmap(long paramLong1, float paramFloat1, float paramFloat2, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native long nstbtt_GetGlyphBitmapSubpixel(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_MakeGlyphBitmap(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_MakeGlyphBitmapSubpixel(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_MakeGlyphBitmapSubpixelPrefilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, long paramLong3, long paramLong4, int paramInt6);
/*      */   
/*      */   public static native void nstbtt_GetGlyphBitmapBox(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_GetGlyphBitmapBoxSubpixel(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_Rasterize(long paramLong1, float paramFloat1, long paramLong2, int paramInt1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt2, int paramInt3, int paramInt4, long paramLong3);
/*      */   
/*      */   public static native void nstbtt_FreeSDF(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nstbtt_GetGlyphSDF(long paramLong1, float paramFloat1, int paramInt1, int paramInt2, byte paramByte, float paramFloat2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native long nstbtt_GetCodepointSDF(long paramLong1, float paramFloat1, int paramInt1, int paramInt2, byte paramByte, float paramFloat2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int nstbtt_FindMatchingFont(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nstbtt_CompareUTF8toUTF16_bigendian(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native long nstbtt_GetFontNameString(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_GetBakedQuad(long paramLong1, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong2, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_GetScaledFontVMetrics(long paramLong, int paramInt, float paramFloat, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3);
/*      */   
/*      */   public static native void nstbtt_GetPackedQuad(long paramLong1, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong2, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_GetFontVMetrics(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*      */   
/*      */   public static native int nstbtt_GetFontVMetricsOS2(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*      */   
/*      */   public static native void nstbtt_GetFontBoundingBox(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_GetCodepointHMetrics(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2);
/*      */   
/*      */   public static native int nstbtt_GetCodepointBox(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_GetGlyphHMetrics(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2);
/*      */   
/*      */   public static native int nstbtt_GetGlyphBox(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetCodepointBitmap(long paramLong, float paramFloat1, float paramFloat2, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetCodepointBitmapSubpixel(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_MakeCodepointBitmapSubpixelPrefilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt6);
/*      */   
/*      */   public static native void nstbtt_GetCodepointBitmapBox(long paramLong, int paramInt, float paramFloat1, float paramFloat2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_GetCodepointBitmapBoxSubpixel(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetGlyphBitmap(long paramLong, float paramFloat1, float paramFloat2, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetGlyphBitmapSubpixel(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_MakeGlyphBitmapSubpixelPrefilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt6);
/*      */   
/*      */   public static native void nstbtt_GetGlyphBitmapBox(long paramLong, int paramInt, float paramFloat1, float paramFloat2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_GetGlyphBitmapBoxSubpixel(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetGlyphSDF(long paramLong, float paramFloat1, int paramInt1, int paramInt2, byte paramByte, float paramFloat2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetCodepointSDF(long paramLong, float paramFloat1, int paramInt1, int paramInt2, byte paramByte, float paramFloat2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTruetype.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */