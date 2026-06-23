/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ public class NVPathRendering
/*      */ {
/*      */   public static final byte GL_CLOSE_PATH_NV = 0;
/*      */   public static final byte GL_MOVE_TO_NV = 2;
/*      */   public static final byte GL_RELATIVE_MOVE_TO_NV = 3;
/*      */   public static final byte GL_LINE_TO_NV = 4;
/*      */   public static final byte GL_RELATIVE_LINE_TO_NV = 5;
/*      */   
/*      */   static {
/*   23 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final byte GL_HORIZONTAL_LINE_TO_NV = 6;
/*      */   
/*      */   public static final byte GL_RELATIVE_HORIZONTAL_LINE_TO_NV = 7;
/*      */   
/*      */   public static final byte GL_VERTICAL_LINE_TO_NV = 8;
/*      */   
/*      */   public static final byte GL_RELATIVE_VERTICAL_LINE_TO_NV = 9;
/*      */   
/*      */   public static final byte GL_QUADRATIC_CURVE_TO_NV = 10;
/*      */   
/*      */   public static final byte GL_RELATIVE_QUADRATIC_CURVE_TO_NV = 11;
/*      */   
/*      */   public static final byte GL_CUBIC_CURVE_TO_NV = 12;
/*      */   
/*      */   public static final byte GL_RELATIVE_CUBIC_CURVE_TO_NV = 13;
/*      */   
/*      */   public static final byte GL_SMOOTH_QUADRATIC_CURVE_TO_NV = 14;
/*      */   
/*      */   public static final byte GL_RELATIVE_SMOOTH_QUADRATIC_CURVE_TO_NV = 15;
/*      */   
/*      */   public static final byte GL_SMOOTH_CUBIC_CURVE_TO_NV = 16;
/*      */   
/*      */   public static final byte GL_RELATIVE_SMOOTH_CUBIC_CURVE_TO_NV = 17;
/*      */   
/*      */   public static final byte GL_SMALL_CCW_ARC_TO_NV = 18;
/*      */   
/*      */   public static final byte GL_RELATIVE_SMALL_CCW_ARC_TO_NV = 19;
/*      */   
/*      */   public static final byte GL_SMALL_CW_ARC_TO_NV = 20;
/*      */   
/*      */   public static final byte GL_RELATIVE_SMALL_CW_ARC_TO_NV = 21;
/*      */   
/*      */   public static final byte GL_LARGE_CCW_ARC_TO_NV = 22;
/*      */   
/*      */   public static final byte GL_RELATIVE_LARGE_CCW_ARC_TO_NV = 23;
/*      */   
/*      */   public static final byte GL_LARGE_CW_ARC_TO_NV = 24;
/*      */   
/*      */   public static final byte GL_RELATIVE_LARGE_CW_ARC_TO_NV = 25;
/*      */   
/*      */   public static final byte GL_CONIC_CURVE_TO_NV = 26;
/*      */   
/*      */   public static final byte GL_RELATIVE_CONIC_CURVE_TO_NV = 27;
/*      */   
/*      */   public static final byte GL_ROUNDED_RECT_NV = -24;
/*      */   
/*      */   public static final byte GL_RELATIVE_ROUNDED_RECT_NV = -23;
/*      */   
/*      */   public static final byte GL_ROUNDED_RECT2_NV = -22;
/*      */   
/*      */   public static final byte GL_RELATIVE_ROUNDED_RECT2_NV = -21;
/*      */   
/*      */   public static final byte GL_ROUNDED_RECT4_NV = -20;
/*      */   
/*      */   public static final byte GL_RELATIVE_ROUNDED_RECT4_NV = -19;
/*      */   
/*      */   public static final byte GL_ROUNDED_RECT8_NV = -18;
/*      */   
/*      */   public static final byte GL_RELATIVE_ROUNDED_RECT8_NV = -17;
/*      */   
/*      */   public static final byte GL_RESTART_PATH_NV = -16;
/*      */   
/*      */   public static final byte GL_DUP_FIRST_CUBIC_CURVE_TO_NV = -14;
/*      */   
/*      */   public static final byte GL_DUP_LAST_CUBIC_CURVE_TO_NV = -12;
/*      */   
/*      */   public static final byte GL_RECT_NV = -10;
/*      */   
/*      */   public static final byte GL_RELATIVE_RECT_NV = -9;
/*      */   
/*      */   public static final byte GL_CIRCULAR_CCW_ARC_TO_NV = -8;
/*      */   
/*      */   public static final byte GL_CIRCULAR_CW_ARC_TO_NV = -6;
/*      */   
/*      */   public static final byte GL_CIRCULAR_TANGENT_ARC_TO_NV = -4;
/*      */   
/*      */   public static final byte GL_ARC_TO_NV = -2;
/*      */   
/*      */   public static final byte GL_RELATIVE_ARC_TO_NV = -1;
/*      */   
/*      */   public static final int GL_PATH_FORMAT_SVG_NV = 36976;
/*      */   
/*      */   public static final int GL_PATH_FORMAT_PS_NV = 36977;
/*      */   
/*      */   public static final int GL_STANDARD_FONT_NAME_NV = 36978;
/*      */   
/*      */   public static final int GL_SYSTEM_FONT_NAME_NV = 36979;
/*      */   
/*      */   public static final int GL_FILE_NAME_NV = 36980;
/*      */   
/*      */   public static final int GL_STANDARD_FONT_FORMAT_NV = 37740;
/*      */   
/*      */   public static final int GL_SKIP_MISSING_GLYPH_NV = 37033;
/*      */   
/*      */   public static final int GL_USE_MISSING_GLYPH_NV = 37034;
/*      */   
/*      */   public static final int GL_FONT_GLYPHS_AVAILABLE_NV = 37736;
/*      */   
/*      */   public static final int GL_FONT_TARGET_UNAVAILABLE_NV = 37737;
/*      */   
/*      */   public static final int GL_FONT_UNAVAILABLE_NV = 37738;
/*      */   
/*      */   public static final int GL_FONT_UNINTELLIGIBLE_NV = 37739;
/*      */   
/*      */   public static final int GL_PATH_STROKE_WIDTH_NV = 36981;
/*      */   
/*      */   public static final int GL_PATH_INITIAL_END_CAP_NV = 36983;
/*      */   
/*      */   public static final int GL_PATH_TERMINAL_END_CAP_NV = 36984;
/*      */   public static final int GL_PATH_JOIN_STYLE_NV = 36985;
/*      */   public static final int GL_PATH_MITER_LIMIT_NV = 36986;
/*      */   public static final int GL_PATH_INITIAL_DASH_CAP_NV = 36988;
/*      */   public static final int GL_PATH_TERMINAL_DASH_CAP_NV = 36989;
/*      */   public static final int GL_PATH_DASH_OFFSET_NV = 36990;
/*      */   public static final int GL_PATH_CLIENT_LENGTH_NV = 36991;
/*      */   public static final int GL_PATH_DASH_OFFSET_RESET_NV = 37044;
/*      */   public static final int GL_PATH_FILL_MODE_NV = 36992;
/*      */   public static final int GL_PATH_FILL_MASK_NV = 36993;
/*      */   public static final int GL_PATH_FILL_COVER_MODE_NV = 36994;
/*      */   public static final int GL_PATH_STROKE_COVER_MODE_NV = 36995;
/*      */   public static final int GL_PATH_STROKE_MASK_NV = 36996;
/*      */   public static final int GL_PATH_STROKE_BOUND_NV = 36998;
/*      */   public static final int GL_PATH_END_CAPS_NV = 36982;
/*      */   public static final int GL_PATH_DASH_CAPS_NV = 36987;
/*      */   public static final int GL_COUNT_UP_NV = 37000;
/*      */   public static final int GL_COUNT_DOWN_NV = 37001;
/*      */   public static final int GL_PRIMARY_COLOR_NV = 34092;
/*      */   public static final int GL_SECONDARY_COLOR_NV = 34093;
/*      */   public static final int GL_PATH_OBJECT_BOUNDING_BOX_NV = 37002;
/*      */   public static final int GL_CONVEX_HULL_NV = 37003;
/*      */   public static final int GL_BOUNDING_BOX_NV = 37005;
/*      */   public static final int GL_TRANSLATE_X_NV = 37006;
/*      */   public static final int GL_TRANSLATE_Y_NV = 37007;
/*      */   public static final int GL_TRANSLATE_2D_NV = 37008;
/*      */   public static final int GL_TRANSLATE_3D_NV = 37009;
/*      */   public static final int GL_AFFINE_2D_NV = 37010;
/*      */   public static final int GL_AFFINE_3D_NV = 37012;
/*      */   public static final int GL_TRANSPOSE_AFFINE_2D_NV = 37014;
/*      */   public static final int GL_TRANSPOSE_AFFINE_3D_NV = 37016;
/*      */   public static final int GL_UTF8_NV = 37018;
/*      */   public static final int GL_UTF16_NV = 37019;
/*      */   public static final int GL_BOUNDING_BOX_OF_BOUNDING_BOXES_NV = 37020;
/*      */   public static final int GL_PATH_COMMAND_COUNT_NV = 37021;
/*      */   public static final int GL_PATH_COORD_COUNT_NV = 37022;
/*      */   public static final int GL_PATH_DASH_ARRAY_COUNT_NV = 37023;
/*      */   public static final int GL_PATH_COMPUTED_LENGTH_NV = 37024;
/*      */   public static final int GL_PATH_FILL_BOUNDING_BOX_NV = 37025;
/*      */   public static final int GL_PATH_STROKE_BOUNDING_BOX_NV = 37026;
/*      */   public static final int GL_SQUARE_NV = 37027;
/*      */   public static final int GL_ROUND_NV = 37028;
/*      */   public static final int GL_TRIANGULAR_NV = 37029;
/*      */   public static final int GL_BEVEL_NV = 37030;
/*      */   public static final int GL_MITER_REVERT_NV = 37031;
/*      */   public static final int GL_MITER_TRUNCATE_NV = 37032;
/*      */   public static final int GL_MOVE_TO_RESETS_NV = 37045;
/*      */   public static final int GL_MOVE_TO_CONTINUES_NV = 37046;
/*      */   public static final int GL_BOLD_BIT_NV = 1;
/*      */   public static final int GL_ITALIC_BIT_NV = 2;
/*      */   public static final int GL_PATH_ERROR_POSITION_NV = 37035;
/*      */   public static final int GL_PATH_FOG_GEN_MODE_NV = 37036;
/*      */   public static final int GL_PATH_STENCIL_FUNC_NV = 37047;
/*      */   public static final int GL_PATH_STENCIL_REF_NV = 37048;
/*      */   public static final int GL_PATH_STENCIL_VALUE_MASK_NV = 37049;
/*      */   public static final int GL_PATH_STENCIL_DEPTH_OFFSET_FACTOR_NV = 37053;
/*      */   public static final int GL_PATH_STENCIL_DEPTH_OFFSET_UNITS_NV = 37054;
/*      */   public static final int GL_PATH_COVER_DEPTH_FUNC_NV = 37055;
/*      */   public static final int GL_GLYPH_WIDTH_BIT_NV = 1;
/*      */   public static final int GL_GLYPH_HEIGHT_BIT_NV = 2;
/*      */   public static final int GL_GLYPH_HORIZONTAL_BEARING_X_BIT_NV = 4;
/*      */   public static final int GL_GLYPH_HORIZONTAL_BEARING_Y_BIT_NV = 8;
/*      */   public static final int GL_GLYPH_HORIZONTAL_BEARING_ADVANCE_BIT_NV = 16;
/*      */   public static final int GL_GLYPH_VERTICAL_BEARING_X_BIT_NV = 32;
/*      */   public static final int GL_GLYPH_VERTICAL_BEARING_Y_BIT_NV = 64;
/*      */   public static final int GL_GLYPH_VERTICAL_BEARING_ADVANCE_BIT_NV = 128;
/*      */   public static final int GL_GLYPH_HAS_KERNING_BIT_NV = 256;
/*      */   public static final int GL_FONT_X_MIN_BOUNDS_BIT_NV = 65536;
/*      */   public static final int GL_FONT_Y_MIN_BOUNDS_BIT_NV = 131072;
/*      */   public static final int GL_FONT_X_MAX_BOUNDS_BIT_NV = 262144;
/*      */   public static final int GL_FONT_Y_MAX_BOUNDS_BIT_NV = 524288;
/*      */   public static final int GL_FONT_UNITS_PER_EM_BIT_NV = 1048576;
/*      */   public static final int GL_FONT_ASCENDER_BIT_NV = 2097152;
/*      */   public static final int GL_FONT_DESCENDER_BIT_NV = 4194304;
/*      */   public static final int GL_FONT_HEIGHT_BIT_NV = 8388608;
/*      */   public static final int GL_FONT_MAX_ADVANCE_WIDTH_BIT_NV = 16777216;
/*      */   public static final int GL_FONT_MAX_ADVANCE_HEIGHT_BIT_NV = 33554432;
/*      */   public static final int GL_FONT_UNDERLINE_POSITION_BIT_NV = 67108864;
/*      */   public static final int GL_FONT_UNDERLINE_THICKNESS_BIT_NV = 134217728;
/*      */   public static final int GL_FONT_HAS_KERNING_BIT_NV = 268435456;
/*      */   public static final int GL_FONT_NUM_GLYPH_INDICES_BIT_NV = 536870912;
/*      */   public static final int GL_ACCUM_ADJACENT_PAIRS_NV = 37037;
/*      */   public static final int GL_ADJACENT_PAIRS_NV = 37038;
/*      */   public static final int GL_FIRST_TO_REST_NV = 37039;
/*      */   public static final int GL_PATH_GEN_MODE_NV = 37040;
/*      */   public static final int GL_PATH_GEN_COEFF_NV = 37041;
/*      */   public static final int GL_PATH_GEN_COLOR_FORMAT_NV = 37042;
/*      */   public static final int GL_PATH_GEN_COMPONENTS_NV = 37043;
/*      */   public static final int GL_FRAGMENT_INPUT_NV = 37741;
/*      */   public static final int GL_PATH_PROJECTION_NV = 5889;
/*      */   public static final int GL_PATH_MODELVIEW_NV = 5888;
/*      */   public static final int GL_PATH_MODELVIEW_STACK_DEPTH_NV = 2979;
/*      */   public static final int GL_PATH_MODELVIEW_MATRIX_NV = 2982;
/*      */   public static final int GL_PATH_MAX_MODELVIEW_STACK_DEPTH_NV = 3382;
/*      */   public static final int GL_PATH_TRANSPOSE_MODELVIEW_MATRIX_NV = 34019;
/*      */   public static final int GL_PATH_PROJECTION_STACK_DEPTH_NV = 2980;
/*      */   public static final int GL_PATH_PROJECTION_MATRIX_NV = 2983;
/*      */   public static final int GL_PATH_MAX_PROJECTION_STACK_DEPTH_NV = 3384;
/*      */   public static final int GL_PATH_TRANSPOSE_PROJECTION_MATRIX_NV = 34020;
/*      */   public static final int GL_2_BYTES_NV = 5127;
/*      */   public static final int GL_3_BYTES_NV = 5128;
/*      */   public static final int GL_4_BYTES_NV = 5129;
/*      */   public static final int GL_EYE_LINEAR_NV = 9216;
/*      */   public static final int GL_OBJECT_LINEAR_NV = 9217;
/*      */   public static final int GL_CONSTANT_NV = 34166;
/*      */   
/*      */   protected NVPathRendering() {
/*  242 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int path, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") ByteBuffer coords) {
/*  252 */     nglPathCommandsNV(path, commands.remaining(), MemoryUtil.memAddress(commands), coords.remaining() >> GLChecks.typeToByteShift(coordType), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int path, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") ShortBuffer coords) {
/*  257 */     nglPathCommandsNV(path, commands.remaining(), MemoryUtil.memAddress(commands), (int)(coords.remaining() << 1L >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int path, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") FloatBuffer coords) {
/*  262 */     nglPathCommandsNV(path, commands.remaining(), MemoryUtil.memAddress(commands), (int)(coords.remaining() << 2L >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int path, @NativeType("GLenum") int coordType, @NativeType("void const *") ByteBuffer coords) {
/*  272 */     nglPathCoordsNV(path, coords.remaining() >> GLChecks.typeToByteShift(coordType), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int path, @NativeType("GLenum") int coordType, @NativeType("void const *") ShortBuffer coords) {
/*  277 */     nglPathCoordsNV(path, (int)(coords.remaining() << 1L >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int path, @NativeType("GLenum") int coordType, @NativeType("void const *") FloatBuffer coords) {
/*  282 */     nglPathCoordsNV(path, (int)(coords.remaining() << 2L >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int commandStart, @NativeType("GLsizei") int commandsToDelete, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") ByteBuffer coords) {
/*  292 */     nglPathSubCommandsNV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), coords.remaining() >> GLChecks.typeToByteShift(coordType), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int commandStart, @NativeType("GLsizei") int commandsToDelete, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") ShortBuffer coords) {
/*  297 */     nglPathSubCommandsNV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), (int)(coords.remaining() << 1L >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int commandStart, @NativeType("GLsizei") int commandsToDelete, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") FloatBuffer coords) {
/*  302 */     nglPathSubCommandsNV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), (int)(coords.remaining() << 2L >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int coordStart, @NativeType("GLenum") int coordType, @NativeType("void const *") ByteBuffer coords) {
/*  312 */     nglPathSubCoordsNV(path, coordStart, coords.remaining() >> GLChecks.typeToByteShift(coordType), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int coordStart, @NativeType("GLenum") int coordType, @NativeType("void const *") ShortBuffer coords) {
/*  317 */     nglPathSubCoordsNV(path, coordStart, (int)(coords.remaining() << 1L >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int coordStart, @NativeType("GLenum") int coordType, @NativeType("void const *") FloatBuffer coords) {
/*  322 */     nglPathSubCoordsNV(path, coordStart, (int)(coords.remaining() << 2L >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathStringNV(@NativeType("GLuint") int path, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer pathString) {
/*  332 */     nglPathStringNV(path, format, pathString.remaining(), MemoryUtil.memAddress(pathString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathGlyphsNV(@NativeType("GLuint") int firstPathName, @NativeType("GLenum") int fontTarget, @NativeType("void const *") ByteBuffer fontName, @NativeType("GLbitfield") int fontStyle, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer charcodes, @NativeType("GLenum") int handleMissingGlyphs, @NativeType("GLuint") int pathParameterTemplate, @NativeType("GLfloat") float emScale) {
/*  342 */     if (Checks.CHECKS) {
/*  343 */       Checks.checkNT1(fontName);
/*      */     }
/*  345 */     nglPathGlyphsNV(firstPathName, fontTarget, MemoryUtil.memAddress(fontName), fontStyle, charcodes.remaining() / charcodeTypeToBytes(type), type, MemoryUtil.memAddress(charcodes), handleMissingGlyphs, pathParameterTemplate, emScale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathGlyphRangeNV(@NativeType("GLuint") int firstPathName, @NativeType("GLenum") int fontTarget, @NativeType("void const *") ByteBuffer fontName, @NativeType("GLbitfield") int fontStyle, @NativeType("GLuint") int firstGlyph, @NativeType("GLsizei") int numGlyphs, @NativeType("GLenum") int handleMissingGlyphs, @NativeType("GLuint") int pathParameterTemplate, @NativeType("GLfloat") float emScale) {
/*  355 */     if (Checks.CHECKS) {
/*  356 */       Checks.checkNT1(fontName);
/*      */     }
/*  358 */     nglPathGlyphRangeNV(firstPathName, fontTarget, MemoryUtil.memAddress(fontName), fontStyle, firstGlyph, numGlyphs, handleMissingGlyphs, pathParameterTemplate, emScale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glPathGlyphIndexArrayNV(@NativeType("GLuint") int firstPathName, @NativeType("GLenum") int fontTarget, @NativeType("void const *") ByteBuffer fontName, @NativeType("GLbitfield") int fontStyle, @NativeType("GLuint") int firstGlyphIndex, @NativeType("GLsizei") int numGlyphs, @NativeType("GLuint") int pathParameterTemplate, @NativeType("GLfloat") float emScale) {
/*  369 */     if (Checks.CHECKS) {
/*  370 */       Checks.checkNT1(fontName);
/*      */     }
/*  372 */     return nglPathGlyphIndexArrayNV(firstPathName, fontTarget, MemoryUtil.memAddress(fontName), fontStyle, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glPathMemoryGlyphIndexArrayNV(@NativeType("GLuint") int firstPathName, @NativeType("GLenum") int fontTarget, @NativeType("void const *") ByteBuffer fontData, @NativeType("GLsizei") int faceIndex, @NativeType("GLuint") int firstGlyphIndex, @NativeType("GLsizei") int numGlyphs, @NativeType("GLuint") int pathParameterTemplate, @NativeType("GLfloat") float emScale) {
/*  383 */     return nglPathMemoryGlyphIndexArrayNV(firstPathName, fontTarget, fontData.remaining(), MemoryUtil.memAddress(fontData), faceIndex, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWeightPathsNV(@NativeType("GLuint") int resultPath, @NativeType("GLuint const *") IntBuffer paths, @NativeType("GLfloat const *") FloatBuffer weights) {
/*  398 */     if (Checks.CHECKS) {
/*  399 */       Checks.check(weights, paths.remaining());
/*      */     }
/*  401 */     nglWeightPathsNV(resultPath, paths.remaining(), MemoryUtil.memAddress(paths), MemoryUtil.memAddress(weights));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTransformPathNV(@NativeType("GLuint") int resultPath, @NativeType("GLuint") int srcPath, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") FloatBuffer transformValues) {
/*  416 */     if (Checks.CHECKS) {
/*  417 */       Checks.check(transformValues, transformTypeToElements(transformType));
/*      */     }
/*  419 */     nglTransformPathNV(resultPath, srcPath, transformType, MemoryUtil.memAddress(transformValues));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathParameterivNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer value) {
/*  429 */     if (Checks.CHECKS) {
/*  430 */       Checks.check(value, 1);
/*      */     }
/*  432 */     nglPathParameterivNV(path, pname, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathParameterfvNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer value) {
/*  447 */     if (Checks.CHECKS) {
/*  448 */       Checks.check(value, 1);
/*      */     }
/*  450 */     nglPathParameterfvNV(path, pname, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathDashArrayNV(@NativeType("GLuint") int path, @NativeType("GLfloat const *") FloatBuffer dashArray) {
/*  465 */     nglPathDashArrayNV(path, dashArray.remaining(), MemoryUtil.memAddress(dashArray));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilFillPathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLenum") int fillMode, @NativeType("GLuint") int mask, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") FloatBuffer transformValues) {
/*  512 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/*  513 */     if (Checks.CHECKS) {
/*  514 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     }
/*  516 */     nglStencilFillPathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, fillMode, mask, transformType, MemoryUtil.memAddress(transformValues));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilStrokePathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLint") int reference, @NativeType("GLuint") int mask, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") FloatBuffer transformValues) {
/*  526 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/*  527 */     if (Checks.CHECKS) {
/*  528 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     }
/*  530 */     nglStencilStrokePathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, reference, mask, transformType, MemoryUtil.memAddress(transformValues));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathColorGenNV(@NativeType("GLenum") int color, @NativeType("GLenum") int genMode, @NativeType("GLenum") int colorFormat, @NativeType("GLfloat const *") FloatBuffer coeffs) {
/*  545 */     if (Checks.CHECKS) {
/*  546 */       Checks.check(coeffs, genModeToElements(genMode) * colorFormatToComponents(colorFormat));
/*      */     }
/*  548 */     nglPathColorGenNV(color, genMode, colorFormat, MemoryUtil.memAddress(coeffs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathTexGenNV(@NativeType("GLenum") int texCoordSet, @NativeType("GLenum") int genMode, @NativeType("GLint") int components, @NativeType("GLfloat const *") FloatBuffer coeffs) {
/*  558 */     if (Checks.CHECKS) {
/*  559 */       Checks.check(coeffs, genModeToElements(genMode) * components);
/*      */     }
/*  561 */     nglPathTexGenNV(texCoordSet, genMode, components, MemoryUtil.memAddress(coeffs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCoverFillPathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLenum") int coverMode, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") FloatBuffer transformValues) {
/*  586 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/*  587 */     if (Checks.CHECKS) {
/*  588 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     }
/*  590 */     nglCoverFillPathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, coverMode, transformType, MemoryUtil.memAddress(transformValues));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCoverStrokePathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLenum") int coverMode, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") FloatBuffer transformValues) {
/*  600 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/*  601 */     if (Checks.CHECKS) {
/*  602 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     }
/*  604 */     nglCoverStrokePathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, coverMode, transformType, MemoryUtil.memAddress(transformValues));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilThenCoverFillPathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLenum") int fillMode, @NativeType("GLuint") int mask, @NativeType("GLenum") int coverMode, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") FloatBuffer transformValues) {
/*  624 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/*  625 */     if (Checks.CHECKS) {
/*  626 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     }
/*  628 */     nglStencilThenCoverFillPathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, fillMode, mask, coverMode, transformType, MemoryUtil.memAddress(transformValues));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilThenCoverStrokePathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLint") int reference, @NativeType("GLuint") int mask, @NativeType("GLenum") int coverMode, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") FloatBuffer transformValues) {
/*  638 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/*  639 */     if (Checks.CHECKS) {
/*  640 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     }
/*  642 */     nglStencilThenCoverStrokePathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, reference, mask, coverMode, transformType, MemoryUtil.memAddress(transformValues));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glPathGlyphIndexRangeNV(@NativeType("GLenum") int fontTarget, @NativeType("void const *") ByteBuffer fontName, @NativeType("GLbitfield") int fontStyle, @NativeType("GLuint") int pathParameterTemplate, @NativeType("GLfloat") float emScale, @NativeType("GLuint *") IntBuffer baseAndCount) {
/*  653 */     if (Checks.CHECKS) {
/*  654 */       Checks.checkNT1(fontName);
/*  655 */       Checks.check(baseAndCount, 2);
/*      */     } 
/*  657 */     return nglPathGlyphIndexRangeNV(fontTarget, MemoryUtil.memAddress(fontName), fontStyle, pathParameterTemplate, emScale, MemoryUtil.memAddress(baseAndCount));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramPathFragmentInputGenNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLenum") int genMode, @NativeType("GLint") int components, @NativeType("GLfloat const *") FloatBuffer coeffs) {
/*  667 */     if (Checks.CHECKS) {
/*  668 */       Checks.check(coeffs, genModeToElements(genMode) * components);
/*      */     }
/*  670 */     nglProgramPathFragmentInputGenNV(program, location, genMode, components, MemoryUtil.memAddress(coeffs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathParameterivNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer value) {
/*  680 */     if (Checks.CHECKS) {
/*  681 */       Checks.check(value, 1);
/*      */     }
/*  683 */     nglGetPathParameterivNV(path, pname, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetPathParameteriNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname) {
/*  689 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  691 */       IntBuffer value = stack.callocInt(1);
/*  692 */       nglGetPathParameterivNV(path, pname, MemoryUtil.memAddress(value));
/*  693 */       return value.get(0);
/*      */     } finally {
/*  695 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathParameterfvNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer value) {
/*  706 */     if (Checks.CHECKS) {
/*  707 */       Checks.check(value, 1);
/*      */     }
/*  709 */     nglGetPathParameterfvNV(path, pname, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetPathParameterfNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname) {
/*  715 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  717 */       FloatBuffer value = stack.callocFloat(1);
/*  718 */       nglGetPathParameterfvNV(path, pname, MemoryUtil.memAddress(value));
/*  719 */       return value.get(0);
/*      */     } finally {
/*  721 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathCommandsNV(@NativeType("GLuint") int path, @NativeType("GLubyte *") ByteBuffer commands) {
/*  732 */     if (Checks.CHECKS && 
/*  733 */       Checks.DEBUG) {
/*  734 */       Checks.check(commands, glGetPathParameteriNV(path, 37021));
/*      */     }
/*      */     
/*  737 */     nglGetPathCommandsNV(path, MemoryUtil.memAddress(commands));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathCoordsNV(@NativeType("GLuint") int path, @NativeType("GLfloat *") FloatBuffer coords) {
/*  747 */     if (Checks.CHECKS && 
/*  748 */       Checks.DEBUG) {
/*  749 */       Checks.check(coords, glGetPathParameteriNV(path, 37022));
/*      */     }
/*      */     
/*  752 */     nglGetPathCoordsNV(path, MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathDashArrayNV(@NativeType("GLuint") int path, @NativeType("GLfloat *") FloatBuffer dashArray) {
/*  762 */     if (Checks.CHECKS && 
/*  763 */       Checks.DEBUG) {
/*  764 */       Checks.check(dashArray, glGetPathParameteriNV(path, 37023));
/*      */     }
/*      */     
/*  767 */     nglGetPathDashArrayNV(path, MemoryUtil.memAddress(dashArray));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathMetricsNV(@NativeType("GLbitfield") int metricQueryMask, @NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLsizei") int stride, @NativeType("GLfloat *") FloatBuffer metrics) {
/*  777 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/*  778 */     if (Checks.CHECKS) {
/*  779 */       Checks.check(metrics, numPaths * ((stride == 0) ? Integer.bitCount(metricQueryMask) : (stride >> 2)));
/*      */     }
/*  781 */     nglGetPathMetricsNV(metricQueryMask, numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, stride, MemoryUtil.memAddress(metrics));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathMetricRangeNV(@NativeType("GLbitfield") int metricQueryMask, @NativeType("GLuint") int firstPathName, @NativeType("GLsizei") int numPaths, @NativeType("GLsizei") int stride, @NativeType("GLfloat *") FloatBuffer metrics) {
/*  791 */     if (Checks.CHECKS) {
/*  792 */       Checks.check(metrics, numPaths * ((stride == 0) ? Integer.bitCount(metricQueryMask) : (stride >> 2)));
/*      */     }
/*  794 */     nglGetPathMetricRangeNV(metricQueryMask, firstPathName, numPaths, stride, MemoryUtil.memAddress(metrics));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathSpacingNV(@NativeType("GLenum") int pathListMode, @NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLfloat") float advanceScale, @NativeType("GLfloat") float kerningScale, @NativeType("GLenum") int transformType, @NativeType("GLfloat *") FloatBuffer returnedSpacing) {
/*  804 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/*  805 */     if (Checks.CHECKS) {
/*  806 */       Checks.check(returnedSpacing, (numPaths - 1) * ((transformType == 37006) ? 1 : 2));
/*      */     }
/*  808 */     nglGetPathSpacingNV(pathListMode, numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, advanceScale, kerningScale, transformType, MemoryUtil.memAddress(returnedSpacing));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathColorGenivNV(@NativeType("GLenum") int color, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer value) {
/*  818 */     if (Checks.CHECKS) {
/*  819 */       Checks.check(value, 1);
/*      */     }
/*  821 */     nglGetPathColorGenivNV(color, pname, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetPathColorGeniNV(@NativeType("GLenum") int color, @NativeType("GLenum") int pname) {
/*  827 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  829 */       IntBuffer value = stack.callocInt(1);
/*  830 */       nglGetPathColorGenivNV(color, pname, MemoryUtil.memAddress(value));
/*  831 */       return value.get(0);
/*      */     } finally {
/*  833 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathColorGenfvNV(@NativeType("GLenum") int color, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer value) {
/*  844 */     if (Checks.CHECKS) {
/*  845 */       Checks.check(value, 1);
/*      */     }
/*  847 */     nglGetPathColorGenfvNV(color, pname, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetPathColorGenfNV(@NativeType("GLenum") int color, @NativeType("GLenum") int pname) {
/*  853 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  855 */       FloatBuffer value = stack.callocFloat(1);
/*  856 */       nglGetPathColorGenfvNV(color, pname, MemoryUtil.memAddress(value));
/*  857 */       return value.get(0);
/*      */     } finally {
/*  859 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathTexGenivNV(@NativeType("GLenum") int texCoordSet, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer value) {
/*  870 */     if (Checks.CHECKS) {
/*  871 */       Checks.check(value, 1);
/*      */     }
/*  873 */     nglGetPathTexGenivNV(texCoordSet, pname, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetPathTexGeniNV(@NativeType("GLenum") int texCoordSet, @NativeType("GLenum") int pname) {
/*  879 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  881 */       IntBuffer value = stack.callocInt(1);
/*  882 */       nglGetPathTexGenivNV(texCoordSet, pname, MemoryUtil.memAddress(value));
/*  883 */       return value.get(0);
/*      */     } finally {
/*  885 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathTexGenfvNV(@NativeType("GLenum") int texCoordSet, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer value) {
/*  896 */     if (Checks.CHECKS) {
/*  897 */       Checks.check(value, 1);
/*      */     }
/*  899 */     nglGetPathTexGenfvNV(texCoordSet, pname, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetPathTexGenfNV(@NativeType("GLenum") int texCoordSet, @NativeType("GLenum") int pname) {
/*  905 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  907 */       FloatBuffer value = stack.callocFloat(1);
/*  908 */       nglGetPathTexGenfvNV(texCoordSet, pname, MemoryUtil.memAddress(value));
/*  909 */       return value.get(0);
/*      */     } finally {
/*  911 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glPointAlongPathNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int startSegment, @NativeType("GLsizei") int numSegments, @NativeType("GLfloat") float distance, @NativeType("GLfloat *") FloatBuffer x, @NativeType("GLfloat *") FloatBuffer y, @NativeType("GLfloat *") FloatBuffer tangentX, @NativeType("GLfloat *") FloatBuffer tangentY) {
/*  941 */     if (Checks.CHECKS) {
/*  942 */       Checks.checkSafe(x, 1);
/*  943 */       Checks.checkSafe(y, 1);
/*  944 */       Checks.checkSafe(tangentX, 1);
/*  945 */       Checks.checkSafe(tangentY, 1);
/*      */     } 
/*  947 */     return nglPointAlongPathNV(path, startSegment, numSegments, distance, MemoryUtil.memAddressSafe(x), MemoryUtil.memAddressSafe(y), MemoryUtil.memAddressSafe(tangentX), MemoryUtil.memAddressSafe(tangentY));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoad3x2fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/*  957 */     if (Checks.CHECKS) {
/*  958 */       Checks.check(m, 6);
/*      */     }
/*  960 */     nglMatrixLoad3x2fNV(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoad3x3fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/*  970 */     if (Checks.CHECKS) {
/*  971 */       Checks.check(m, 9);
/*      */     }
/*  973 */     nglMatrixLoad3x3fNV(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTranspose3x3fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/*  983 */     if (Checks.CHECKS) {
/*  984 */       Checks.check(m, 9);
/*      */     }
/*  986 */     nglMatrixLoadTranspose3x3fNV(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMult3x2fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/*  996 */     if (Checks.CHECKS) {
/*  997 */       Checks.check(m, 6);
/*      */     }
/*  999 */     nglMatrixMult3x2fNV(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMult3x3fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/* 1009 */     if (Checks.CHECKS) {
/* 1010 */       Checks.check(m, 9);
/*      */     }
/* 1012 */     nglMatrixMult3x3fNV(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTranspose3x3fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") FloatBuffer m) {
/* 1022 */     if (Checks.CHECKS) {
/* 1023 */       Checks.check(m, 9);
/*      */     }
/* 1025 */     nglMatrixMultTranspose3x3fNV(matrixMode, MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourcefvNV(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @NativeType("GLenum const *") IntBuffer props, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLfloat *") FloatBuffer params) {
/* 1035 */     if (Checks.CHECKS) {
/* 1036 */       Checks.checkSafe(length, 1);
/*      */     }
/* 1038 */     nglGetProgramResourcefvNV(program, programInterface, index, props.remaining(), MemoryUtil.memAddress(props), params.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int path, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") short[] coords) {
/* 1043 */     long __functionAddress = (GL.getICD()).glPathCommandsNV;
/* 1044 */     if (Checks.CHECKS) {
/* 1045 */       Checks.check(__functionAddress);
/*      */     }
/* 1047 */     JNI.callPPV(path, commands.remaining(), MemoryUtil.memAddress(commands), coords.length, coordType, coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int path, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") float[] coords) {
/* 1052 */     long __functionAddress = (GL.getICD()).glPathCommandsNV;
/* 1053 */     if (Checks.CHECKS) {
/* 1054 */       Checks.check(__functionAddress);
/*      */     }
/* 1056 */     JNI.callPPV(path, commands.remaining(), MemoryUtil.memAddress(commands), coords.length, coordType, coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int path, @NativeType("GLenum") int coordType, @NativeType("void const *") short[] coords) {
/* 1061 */     long __functionAddress = (GL.getICD()).glPathCoordsNV;
/* 1062 */     if (Checks.CHECKS) {
/* 1063 */       Checks.check(__functionAddress);
/*      */     }
/* 1065 */     JNI.callPV(path, coords.length, coordType, coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int path, @NativeType("GLenum") int coordType, @NativeType("void const *") float[] coords) {
/* 1070 */     long __functionAddress = (GL.getICD()).glPathCoordsNV;
/* 1071 */     if (Checks.CHECKS) {
/* 1072 */       Checks.check(__functionAddress);
/*      */     }
/* 1074 */     JNI.callPV(path, coords.length, coordType, coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int commandStart, @NativeType("GLsizei") int commandsToDelete, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") short[] coords) {
/* 1079 */     long __functionAddress = (GL.getICD()).glPathSubCommandsNV;
/* 1080 */     if (Checks.CHECKS) {
/* 1081 */       Checks.check(__functionAddress);
/*      */     }
/* 1083 */     JNI.callPPV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), coords.length, coordType, coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int commandStart, @NativeType("GLsizei") int commandsToDelete, @NativeType("GLubyte const *") ByteBuffer commands, @NativeType("GLenum") int coordType, @NativeType("void const *") float[] coords) {
/* 1088 */     long __functionAddress = (GL.getICD()).glPathSubCommandsNV;
/* 1089 */     if (Checks.CHECKS) {
/* 1090 */       Checks.check(__functionAddress);
/*      */     }
/* 1092 */     JNI.callPPV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), coords.length, coordType, coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int coordStart, @NativeType("GLenum") int coordType, @NativeType("void const *") short[] coords) {
/* 1097 */     long __functionAddress = (GL.getICD()).glPathSubCoordsNV;
/* 1098 */     if (Checks.CHECKS) {
/* 1099 */       Checks.check(__functionAddress);
/*      */     }
/* 1101 */     JNI.callPV(path, coordStart, coords.length, coordType, coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int coordStart, @NativeType("GLenum") int coordType, @NativeType("void const *") float[] coords) {
/* 1106 */     long __functionAddress = (GL.getICD()).glPathSubCoordsNV;
/* 1107 */     if (Checks.CHECKS) {
/* 1108 */       Checks.check(__functionAddress);
/*      */     }
/* 1110 */     JNI.callPV(path, coordStart, coords.length, coordType, coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glWeightPathsNV(@NativeType("GLuint") int resultPath, @NativeType("GLuint const *") int[] paths, @NativeType("GLfloat const *") float[] weights) {
/* 1115 */     long __functionAddress = (GL.getICD()).glWeightPathsNV;
/* 1116 */     if (Checks.CHECKS) {
/* 1117 */       Checks.check(__functionAddress);
/* 1118 */       Checks.check(weights, paths.length);
/*      */     } 
/* 1120 */     JNI.callPPV(resultPath, paths.length, paths, weights, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTransformPathNV(@NativeType("GLuint") int resultPath, @NativeType("GLuint") int srcPath, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") float[] transformValues) {
/* 1125 */     long __functionAddress = (GL.getICD()).glTransformPathNV;
/* 1126 */     if (Checks.CHECKS) {
/* 1127 */       Checks.check(__functionAddress);
/* 1128 */       Checks.check(transformValues, transformTypeToElements(transformType));
/*      */     } 
/* 1130 */     JNI.callPV(resultPath, srcPath, transformType, transformValues, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathParameterivNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] value) {
/* 1135 */     long __functionAddress = (GL.getICD()).glPathParameterivNV;
/* 1136 */     if (Checks.CHECKS) {
/* 1137 */       Checks.check(__functionAddress);
/* 1138 */       Checks.check(value, 1);
/*      */     } 
/* 1140 */     JNI.callPV(path, pname, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathParameterfvNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] value) {
/* 1145 */     long __functionAddress = (GL.getICD()).glPathParameterfvNV;
/* 1146 */     if (Checks.CHECKS) {
/* 1147 */       Checks.check(__functionAddress);
/* 1148 */       Checks.check(value, 1);
/*      */     } 
/* 1150 */     JNI.callPV(path, pname, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathDashArrayNV(@NativeType("GLuint") int path, @NativeType("GLfloat const *") float[] dashArray) {
/* 1155 */     long __functionAddress = (GL.getICD()).glPathDashArrayNV;
/* 1156 */     if (Checks.CHECKS) {
/* 1157 */       Checks.check(__functionAddress);
/*      */     }
/* 1159 */     JNI.callPV(path, dashArray.length, dashArray, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glStencilFillPathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLenum") int fillMode, @NativeType("GLuint") int mask, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") float[] transformValues) {
/* 1164 */     long __functionAddress = (GL.getICD()).glStencilFillPathInstancedNV;
/* 1165 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/* 1166 */     if (Checks.CHECKS) {
/* 1167 */       Checks.check(__functionAddress);
/* 1168 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     } 
/* 1170 */     JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, fillMode, mask, transformType, transformValues, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glStencilStrokePathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLint") int reference, @NativeType("GLuint") int mask, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") float[] transformValues) {
/* 1175 */     long __functionAddress = (GL.getICD()).glStencilStrokePathInstancedNV;
/* 1176 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/* 1177 */     if (Checks.CHECKS) {
/* 1178 */       Checks.check(__functionAddress);
/* 1179 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     } 
/* 1181 */     JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, reference, mask, transformType, transformValues, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathColorGenNV(@NativeType("GLenum") int color, @NativeType("GLenum") int genMode, @NativeType("GLenum") int colorFormat, @NativeType("GLfloat const *") float[] coeffs) {
/* 1186 */     long __functionAddress = (GL.getICD()).glPathColorGenNV;
/* 1187 */     if (Checks.CHECKS) {
/* 1188 */       Checks.check(__functionAddress);
/* 1189 */       Checks.check(coeffs, genModeToElements(genMode) * colorFormatToComponents(colorFormat));
/*      */     } 
/* 1191 */     JNI.callPV(color, genMode, colorFormat, coeffs, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathTexGenNV(@NativeType("GLenum") int texCoordSet, @NativeType("GLenum") int genMode, @NativeType("GLint") int components, @NativeType("GLfloat const *") float[] coeffs) {
/* 1196 */     long __functionAddress = (GL.getICD()).glPathTexGenNV;
/* 1197 */     if (Checks.CHECKS) {
/* 1198 */       Checks.check(__functionAddress);
/* 1199 */       Checks.check(coeffs, genModeToElements(genMode) * components);
/*      */     } 
/* 1201 */     JNI.callPV(texCoordSet, genMode, components, coeffs, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCoverFillPathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLenum") int coverMode, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") float[] transformValues) {
/* 1206 */     long __functionAddress = (GL.getICD()).glCoverFillPathInstancedNV;
/* 1207 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/* 1208 */     if (Checks.CHECKS) {
/* 1209 */       Checks.check(__functionAddress);
/* 1210 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     } 
/* 1212 */     JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, coverMode, transformType, transformValues, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCoverStrokePathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLenum") int coverMode, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") float[] transformValues) {
/* 1217 */     long __functionAddress = (GL.getICD()).glCoverStrokePathInstancedNV;
/* 1218 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/* 1219 */     if (Checks.CHECKS) {
/* 1220 */       Checks.check(__functionAddress);
/* 1221 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     } 
/* 1223 */     JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, coverMode, transformType, transformValues, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glStencilThenCoverFillPathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLenum") int fillMode, @NativeType("GLuint") int mask, @NativeType("GLenum") int coverMode, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") float[] transformValues) {
/* 1228 */     long __functionAddress = (GL.getICD()).glStencilThenCoverFillPathInstancedNV;
/* 1229 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/* 1230 */     if (Checks.CHECKS) {
/* 1231 */       Checks.check(__functionAddress);
/* 1232 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     } 
/* 1234 */     JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, fillMode, mask, coverMode, transformType, transformValues, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glStencilThenCoverStrokePathInstancedNV(@NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLint") int reference, @NativeType("GLuint") int mask, @NativeType("GLenum") int coverMode, @NativeType("GLenum") int transformType, @NativeType("GLfloat const *") float[] transformValues) {
/* 1239 */     long __functionAddress = (GL.getICD()).glStencilThenCoverStrokePathInstancedNV;
/* 1240 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/* 1241 */     if (Checks.CHECKS) {
/* 1242 */       Checks.check(__functionAddress);
/* 1243 */       Checks.check(transformValues, numPaths * transformTypeToElements(transformType));
/*      */     } 
/* 1245 */     JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, reference, mask, coverMode, transformType, transformValues, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glPathGlyphIndexRangeNV(@NativeType("GLenum") int fontTarget, @NativeType("void const *") ByteBuffer fontName, @NativeType("GLbitfield") int fontStyle, @NativeType("GLuint") int pathParameterTemplate, @NativeType("GLfloat") float emScale, @NativeType("GLuint *") int[] baseAndCount) {
/* 1251 */     long __functionAddress = (GL.getICD()).glPathGlyphIndexRangeNV;
/* 1252 */     if (Checks.CHECKS) {
/* 1253 */       Checks.check(__functionAddress);
/* 1254 */       Checks.checkNT1(fontName);
/* 1255 */       Checks.check(baseAndCount, 2);
/*      */     } 
/* 1257 */     return JNI.callPPI(fontTarget, MemoryUtil.memAddress(fontName), fontStyle, pathParameterTemplate, emScale, baseAndCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramPathFragmentInputGenNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLenum") int genMode, @NativeType("GLint") int components, @NativeType("GLfloat const *") float[] coeffs) {
/* 1262 */     long __functionAddress = (GL.getICD()).glProgramPathFragmentInputGenNV;
/* 1263 */     if (Checks.CHECKS) {
/* 1264 */       Checks.check(__functionAddress);
/* 1265 */       Checks.check(coeffs, genModeToElements(genMode) * components);
/*      */     } 
/* 1267 */     JNI.callPV(program, location, genMode, components, coeffs, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathParameterivNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] value) {
/* 1272 */     long __functionAddress = (GL.getICD()).glGetPathParameterivNV;
/* 1273 */     if (Checks.CHECKS) {
/* 1274 */       Checks.check(__functionAddress);
/* 1275 */       Checks.check(value, 1);
/*      */     } 
/* 1277 */     JNI.callPV(path, pname, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathParameterfvNV(@NativeType("GLuint") int path, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] value) {
/* 1282 */     long __functionAddress = (GL.getICD()).glGetPathParameterfvNV;
/* 1283 */     if (Checks.CHECKS) {
/* 1284 */       Checks.check(__functionAddress);
/* 1285 */       Checks.check(value, 1);
/*      */     } 
/* 1287 */     JNI.callPV(path, pname, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathCoordsNV(@NativeType("GLuint") int path, @NativeType("GLfloat *") float[] coords) {
/* 1292 */     long __functionAddress = (GL.getICD()).glGetPathCoordsNV;
/* 1293 */     if (Checks.CHECKS) {
/* 1294 */       Checks.check(__functionAddress);
/* 1295 */       if (Checks.DEBUG) {
/* 1296 */         Checks.check(coords, glGetPathParameteriNV(path, 37022));
/*      */       }
/*      */     } 
/* 1299 */     JNI.callPV(path, coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathDashArrayNV(@NativeType("GLuint") int path, @NativeType("GLfloat *") float[] dashArray) {
/* 1304 */     long __functionAddress = (GL.getICD()).glGetPathDashArrayNV;
/* 1305 */     if (Checks.CHECKS) {
/* 1306 */       Checks.check(__functionAddress);
/* 1307 */       if (Checks.DEBUG) {
/* 1308 */         Checks.check(dashArray, glGetPathParameteriNV(path, 37023));
/*      */       }
/*      */     } 
/* 1311 */     JNI.callPV(path, dashArray, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathMetricsNV(@NativeType("GLbitfield") int metricQueryMask, @NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLsizei") int stride, @NativeType("GLfloat *") float[] metrics) {
/* 1316 */     long __functionAddress = (GL.getICD()).glGetPathMetricsNV;
/* 1317 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/* 1318 */     if (Checks.CHECKS) {
/* 1319 */       Checks.check(__functionAddress);
/* 1320 */       Checks.check(metrics, numPaths * ((stride == 0) ? Integer.bitCount(metricQueryMask) : (stride >> 2)));
/*      */     } 
/* 1322 */     JNI.callPPV(metricQueryMask, numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, stride, metrics, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathMetricRangeNV(@NativeType("GLbitfield") int metricQueryMask, @NativeType("GLuint") int firstPathName, @NativeType("GLsizei") int numPaths, @NativeType("GLsizei") int stride, @NativeType("GLfloat *") float[] metrics) {
/* 1327 */     long __functionAddress = (GL.getICD()).glGetPathMetricRangeNV;
/* 1328 */     if (Checks.CHECKS) {
/* 1329 */       Checks.check(__functionAddress);
/* 1330 */       Checks.check(metrics, numPaths * ((stride == 0) ? Integer.bitCount(metricQueryMask) : (stride >> 2)));
/*      */     } 
/* 1332 */     JNI.callPV(metricQueryMask, firstPathName, numPaths, stride, metrics, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathSpacingNV(@NativeType("GLenum") int pathListMode, @NativeType("GLenum") int pathNameType, @NativeType("void const *") ByteBuffer paths, @NativeType("GLuint") int pathBase, @NativeType("GLfloat") float advanceScale, @NativeType("GLfloat") float kerningScale, @NativeType("GLenum") int transformType, @NativeType("GLfloat *") float[] returnedSpacing) {
/* 1337 */     long __functionAddress = (GL.getICD()).glGetPathSpacingNV;
/* 1338 */     int numPaths = paths.remaining() / pathNameTypeToBytes(pathNameType);
/* 1339 */     if (Checks.CHECKS) {
/* 1340 */       Checks.check(__functionAddress);
/* 1341 */       Checks.check(returnedSpacing, (numPaths - 1) * ((transformType == 37006) ? 1 : 2));
/*      */     } 
/* 1343 */     JNI.callPPV(pathListMode, numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, advanceScale, kerningScale, transformType, returnedSpacing, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathColorGenivNV(@NativeType("GLenum") int color, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] value) {
/* 1348 */     long __functionAddress = (GL.getICD()).glGetPathColorGenivNV;
/* 1349 */     if (Checks.CHECKS) {
/* 1350 */       Checks.check(__functionAddress);
/* 1351 */       Checks.check(value, 1);
/*      */     } 
/* 1353 */     JNI.callPV(color, pname, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathColorGenfvNV(@NativeType("GLenum") int color, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] value) {
/* 1358 */     long __functionAddress = (GL.getICD()).glGetPathColorGenfvNV;
/* 1359 */     if (Checks.CHECKS) {
/* 1360 */       Checks.check(__functionAddress);
/* 1361 */       Checks.check(value, 1);
/*      */     } 
/* 1363 */     JNI.callPV(color, pname, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathTexGenivNV(@NativeType("GLenum") int texCoordSet, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] value) {
/* 1368 */     long __functionAddress = (GL.getICD()).glGetPathTexGenivNV;
/* 1369 */     if (Checks.CHECKS) {
/* 1370 */       Checks.check(__functionAddress);
/* 1371 */       Checks.check(value, 1);
/*      */     } 
/* 1373 */     JNI.callPV(texCoordSet, pname, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathTexGenfvNV(@NativeType("GLenum") int texCoordSet, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] value) {
/* 1378 */     long __functionAddress = (GL.getICD()).glGetPathTexGenfvNV;
/* 1379 */     if (Checks.CHECKS) {
/* 1380 */       Checks.check(__functionAddress);
/* 1381 */       Checks.check(value, 1);
/*      */     } 
/* 1383 */     JNI.callPV(texCoordSet, pname, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glPointAlongPathNV(@NativeType("GLuint") int path, @NativeType("GLsizei") int startSegment, @NativeType("GLsizei") int numSegments, @NativeType("GLfloat") float distance, @NativeType("GLfloat *") float[] x, @NativeType("GLfloat *") float[] y, @NativeType("GLfloat *") float[] tangentX, @NativeType("GLfloat *") float[] tangentY) {
/* 1389 */     long __functionAddress = (GL.getICD()).glPointAlongPathNV;
/* 1390 */     if (Checks.CHECKS) {
/* 1391 */       Checks.check(__functionAddress);
/* 1392 */       Checks.checkSafe(x, 1);
/* 1393 */       Checks.checkSafe(y, 1);
/* 1394 */       Checks.checkSafe(tangentX, 1);
/* 1395 */       Checks.checkSafe(tangentY, 1);
/*      */     } 
/* 1397 */     return JNI.callPPPPZ(path, startSegment, numSegments, distance, x, y, tangentX, tangentY, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoad3x2fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 1402 */     long __functionAddress = (GL.getICD()).glMatrixLoad3x2fNV;
/* 1403 */     if (Checks.CHECKS) {
/* 1404 */       Checks.check(__functionAddress);
/* 1405 */       Checks.check(m, 6);
/*      */     } 
/* 1407 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoad3x3fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 1412 */     long __functionAddress = (GL.getICD()).glMatrixLoad3x3fNV;
/* 1413 */     if (Checks.CHECKS) {
/* 1414 */       Checks.check(__functionAddress);
/* 1415 */       Checks.check(m, 9);
/*      */     } 
/* 1417 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTranspose3x3fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 1422 */     long __functionAddress = (GL.getICD()).glMatrixLoadTranspose3x3fNV;
/* 1423 */     if (Checks.CHECKS) {
/* 1424 */       Checks.check(__functionAddress);
/* 1425 */       Checks.check(m, 9);
/*      */     } 
/* 1427 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMult3x2fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 1432 */     long __functionAddress = (GL.getICD()).glMatrixMult3x2fNV;
/* 1433 */     if (Checks.CHECKS) {
/* 1434 */       Checks.check(__functionAddress);
/* 1435 */       Checks.check(m, 6);
/*      */     } 
/* 1437 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMult3x3fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 1442 */     long __functionAddress = (GL.getICD()).glMatrixMult3x3fNV;
/* 1443 */     if (Checks.CHECKS) {
/* 1444 */       Checks.check(__functionAddress);
/* 1445 */       Checks.check(m, 9);
/*      */     } 
/* 1447 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTranspose3x3fNV(@NativeType("GLenum") int matrixMode, @NativeType("GLfloat const *") float[] m) {
/* 1452 */     long __functionAddress = (GL.getICD()).glMatrixMultTranspose3x3fNV;
/* 1453 */     if (Checks.CHECKS) {
/* 1454 */       Checks.check(__functionAddress);
/* 1455 */       Checks.check(m, 9);
/*      */     } 
/* 1457 */     JNI.callPV(matrixMode, m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourcefvNV(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @NativeType("GLenum const *") int[] props, @NativeType("GLsizei *") int[] length, @NativeType("GLfloat *") float[] params) {
/* 1462 */     long __functionAddress = (GL.getICD()).glGetProgramResourcefvNV;
/* 1463 */     if (Checks.CHECKS) {
/* 1464 */       Checks.check(__functionAddress);
/* 1465 */       Checks.checkSafe(length, 1);
/*      */     } 
/* 1467 */     JNI.callPPPV(program, programInterface, index, props.length, props, params.length, length, params, __functionAddress);
/*      */   }
/*      */   
/*      */   private static int charcodeTypeToBytes(int type) {
/* 1471 */     switch (type) {
/*      */       case 5121:
/*      */       case 37018:
/* 1474 */         return 1;
/*      */       case 5123:
/*      */       case 5127:
/*      */       case 37019:
/* 1478 */         return 2;
/*      */       case 5128:
/* 1480 */         return 3;
/*      */       case 5125:
/*      */       case 5129:
/* 1483 */         return 4;
/*      */     } 
/* 1485 */     throw new IllegalArgumentException(String.format("Unsupported charcode type: 0x%X", new Object[] { Integer.valueOf(type) }));
/*      */   }
/*      */ 
/*      */   
/*      */   private static int pathNameTypeToBytes(int type) {
/* 1490 */     switch (type) {
/*      */       case 5120:
/*      */       case 5121:
/*      */       case 37018:
/* 1494 */         return 1;
/*      */       case 5122:
/*      */       case 5123:
/*      */       case 5127:
/*      */       case 37019:
/* 1499 */         return 2;
/*      */       case 5128:
/* 1501 */         return 3;
/*      */       case 5124:
/*      */       case 5125:
/*      */       case 5129:
/* 1505 */         return 4;
/*      */     } 
/* 1507 */     throw new IllegalArgumentException(String.format("Unsupported path name type: 0x%X", new Object[] { Integer.valueOf(type) }));
/*      */   }
/*      */ 
/*      */   
/*      */   private static int transformTypeToElements(int type) {
/* 1512 */     switch (type) {
/*      */       case 0:
/* 1514 */         return 0;
/*      */       case 37006:
/*      */       case 37007:
/* 1517 */         return 1;
/*      */       case 37008:
/* 1519 */         return 2;
/*      */       case 37009:
/* 1521 */         return 3;
/*      */       case 37010:
/*      */       case 37014:
/* 1524 */         return 6;
/*      */       case 37012:
/*      */       case 37016:
/* 1527 */         return 12;
/*      */     } 
/* 1529 */     throw new IllegalArgumentException(String.format("Unsupported transform type: 0x%X", new Object[] { Integer.valueOf(type) }));
/*      */   }
/*      */ 
/*      */   
/*      */   private static int colorFormatToComponents(int colorFormat) {
/* 1534 */     switch (colorFormat) {
/*      */       case 6406:
/*      */       case 6409:
/*      */       case 32841:
/* 1538 */         return 1;
/*      */       case 6410:
/* 1540 */         return 2;
/*      */       case 6407:
/* 1542 */         return 3;
/*      */       case 6408:
/* 1544 */         return 4;
/*      */     } 
/* 1546 */     throw new IllegalArgumentException(String.format("Unsupported colorFormat specified: 0x%X", new Object[] { Integer.valueOf(colorFormat) }));
/*      */   }
/*      */ 
/*      */   
/*      */   private static int genModeToElements(int genMode) {
/* 1551 */     switch (genMode) {
/*      */       case 0:
/* 1553 */         return 0;
/*      */       case 34166:
/* 1555 */         return 1;
/*      */       case 9217:
/*      */       case 37002:
/* 1558 */         return 3;
/*      */       case 9216:
/* 1560 */         return 4;
/*      */     } 
/* 1562 */     throw new IllegalArgumentException(String.format("Unsupported genMode specified: 0x%X", new Object[] { Integer.valueOf(genMode) }));
/*      */   }
/*      */   
/*      */   public static native void nglPathCommandsNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, long paramLong2);
/*      */   
/*      */   public static native void nglPathCoordsNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglPathSubCommandsNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, long paramLong2);
/*      */   
/*      */   public static native void nglPathSubCoordsNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglPathStringNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglPathGlyphsNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2, int paramInt6, int paramInt7, float paramFloat);
/*      */   
/*      */   public static native void nglPathGlyphRangeNV(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat);
/*      */   
/*      */   public static native int nglPathGlyphIndexArrayNV(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat);
/*      */   
/*      */   public static native int nglPathMemoryGlyphIndexArrayNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat);
/*      */   
/*      */   public static native void glCopyPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglWeightPathsNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glInterpolatePathsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTransformPathNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglPathParameterivNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glPathParameteriNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglPathParameterfvNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glPathParameterfNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglPathDashArrayNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static native int glGenPathsNV(@NativeType("GLsizei") int paramInt);
/*      */   
/*      */   public static native void glDeletePathsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsPathNV(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glPathStencilFuncNV(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glPathStencilDepthOffsetNV(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glStencilFillPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glStencilStrokePathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void nglStencilFillPathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2);
/*      */   
/*      */   public static native void nglStencilStrokePathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2);
/*      */   
/*      */   public static native void glPathCoverDepthFuncNV(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglPathColorGenNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglPathTexGenNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glPathFogGenNV(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glCoverFillPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glCoverStrokePathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglCoverFillPathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
/*      */   
/*      */   public static native void nglCoverStrokePathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
/*      */   
/*      */   public static native void glStencilThenCoverFillPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4);
/*      */   
/*      */   public static native void glStencilThenCoverStrokePathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4);
/*      */   
/*      */   public static native void nglStencilThenCoverFillPathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2);
/*      */   
/*      */   public static native void nglStencilThenCoverStrokePathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2);
/*      */   
/*      */   public static native int nglPathGlyphIndexRangeNV(int paramInt1, long paramLong1, int paramInt2, int paramInt3, float paramFloat, long paramLong2);
/*      */   
/*      */   public static native void nglProgramPathFragmentInputGenNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetPathParameterivNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathParameterfvNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathCommandsNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPathCoordsNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPathDashArrayNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPathMetricsNV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, int paramInt5, long paramLong2);
/*      */   
/*      */   public static native void nglGetPathMetricRangeNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetPathSpacingNV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, long paramLong2);
/*      */   
/*      */   public static native void nglGetPathColorGenivNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathColorGenfvNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathTexGenivNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathTexGenfvNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsPointInFillPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsPointInStrokePathNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   @NativeType("GLfloat")
/*      */   public static native float glGetPathLengthNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3);
/*      */   
/*      */   public static native boolean nglPointAlongPathNV(int paramInt1, int paramInt2, int paramInt3, float paramFloat, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void nglMatrixLoad3x2fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoad3x3fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoadTranspose3x3fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMult3x2fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMult3x3fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultTranspose3x3fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramResourcefvNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVPathRendering.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */