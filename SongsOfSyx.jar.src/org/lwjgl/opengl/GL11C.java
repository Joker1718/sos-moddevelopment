/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL11C
/*      */ {
/*      */   public static final int GL_NEVER = 512;
/*      */   public static final int GL_LESS = 513;
/*      */   public static final int GL_EQUAL = 514;
/*      */   
/*      */   static {
/*   23 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_LEQUAL = 515;
/*      */   
/*      */   public static final int GL_GREATER = 516;
/*      */   
/*      */   public static final int GL_NOTEQUAL = 517;
/*      */   
/*      */   public static final int GL_GEQUAL = 518;
/*      */   
/*      */   public static final int GL_ALWAYS = 519;
/*      */   
/*      */   public static final int GL_DEPTH_BUFFER_BIT = 256;
/*      */   
/*      */   public static final int GL_STENCIL_BUFFER_BIT = 1024;
/*      */   
/*      */   public static final int GL_COLOR_BUFFER_BIT = 16384;
/*      */   
/*      */   public static final int GL_POINTS = 0;
/*      */   
/*      */   public static final int GL_LINES = 1;
/*      */   
/*      */   public static final int GL_LINE_LOOP = 2;
/*      */   
/*      */   public static final int GL_LINE_STRIP = 3;
/*      */   
/*      */   public static final int GL_TRIANGLES = 4;
/*      */   
/*      */   public static final int GL_TRIANGLE_STRIP = 5;
/*      */   
/*      */   public static final int GL_TRIANGLE_FAN = 6;
/*      */   
/*      */   public static final int GL_QUADS = 7;
/*      */   
/*      */   public static final int GL_ZERO = 0;
/*      */   
/*      */   public static final int GL_ONE = 1;
/*      */   
/*      */   public static final int GL_SRC_COLOR = 768;
/*      */   
/*      */   public static final int GL_ONE_MINUS_SRC_COLOR = 769;
/*      */   
/*      */   public static final int GL_SRC_ALPHA = 770;
/*      */   
/*      */   public static final int GL_ONE_MINUS_SRC_ALPHA = 771;
/*      */   
/*      */   public static final int GL_DST_ALPHA = 772;
/*      */   
/*      */   public static final int GL_ONE_MINUS_DST_ALPHA = 773;
/*      */   
/*      */   public static final int GL_DST_COLOR = 774;
/*      */   
/*      */   public static final int GL_ONE_MINUS_DST_COLOR = 775;
/*      */   
/*      */   public static final int GL_SRC_ALPHA_SATURATE = 776;
/*      */   
/*      */   public static final int GL_TRUE = 1;
/*      */   
/*      */   public static final int GL_FALSE = 0;
/*      */   
/*      */   public static final int GL_BYTE = 5120;
/*      */   
/*      */   public static final int GL_UNSIGNED_BYTE = 5121;
/*      */   
/*      */   public static final int GL_SHORT = 5122;
/*      */   
/*      */   public static final int GL_UNSIGNED_SHORT = 5123;
/*      */   
/*      */   public static final int GL_INT = 5124;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT = 5125;
/*      */   
/*      */   public static final int GL_FLOAT = 5126;
/*      */   
/*      */   public static final int GL_DOUBLE = 5130;
/*      */   
/*      */   public static final int GL_NONE = 0;
/*      */   
/*      */   public static final int GL_FRONT_LEFT = 1024;
/*      */   
/*      */   public static final int GL_FRONT_RIGHT = 1025;
/*      */   
/*      */   public static final int GL_BACK_LEFT = 1026;
/*      */   
/*      */   public static final int GL_BACK_RIGHT = 1027;
/*      */   
/*      */   public static final int GL_FRONT = 1028;
/*      */   
/*      */   public static final int GL_BACK = 1029;
/*      */   
/*      */   public static final int GL_LEFT = 1030;
/*      */   
/*      */   public static final int GL_RIGHT = 1031;
/*      */   
/*      */   public static final int GL_FRONT_AND_BACK = 1032;
/*      */   
/*      */   public static final int GL_NO_ERROR = 0;
/*      */   
/*      */   public static final int GL_INVALID_ENUM = 1280;
/*      */   
/*      */   public static final int GL_INVALID_VALUE = 1281;
/*      */   
/*      */   public static final int GL_INVALID_OPERATION = 1282;
/*      */   
/*      */   public static final int GL_STACK_OVERFLOW = 1283;
/*      */   
/*      */   public static final int GL_STACK_UNDERFLOW = 1284;
/*      */   
/*      */   public static final int GL_OUT_OF_MEMORY = 1285;
/*      */   public static final int GL_CW = 2304;
/*      */   public static final int GL_CCW = 2305;
/*      */   public static final int GL_POINT_SIZE = 2833;
/*      */   public static final int GL_POINT_SIZE_RANGE = 2834;
/*      */   public static final int GL_POINT_SIZE_GRANULARITY = 2835;
/*      */   public static final int GL_LINE_SMOOTH = 2848;
/*      */   public static final int GL_LINE_WIDTH = 2849;
/*      */   public static final int GL_LINE_WIDTH_RANGE = 2850;
/*      */   public static final int GL_LINE_WIDTH_GRANULARITY = 2851;
/*      */   public static final int GL_POLYGON_MODE = 2880;
/*      */   public static final int GL_POLYGON_SMOOTH = 2881;
/*      */   public static final int GL_CULL_FACE = 2884;
/*      */   public static final int GL_CULL_FACE_MODE = 2885;
/*      */   public static final int GL_FRONT_FACE = 2886;
/*      */   public static final int GL_DEPTH_RANGE = 2928;
/*      */   public static final int GL_DEPTH_TEST = 2929;
/*      */   public static final int GL_DEPTH_WRITEMASK = 2930;
/*      */   public static final int GL_DEPTH_CLEAR_VALUE = 2931;
/*      */   public static final int GL_DEPTH_FUNC = 2932;
/*      */   public static final int GL_STENCIL_TEST = 2960;
/*      */   public static final int GL_STENCIL_CLEAR_VALUE = 2961;
/*      */   public static final int GL_STENCIL_FUNC = 2962;
/*      */   public static final int GL_STENCIL_VALUE_MASK = 2963;
/*      */   public static final int GL_STENCIL_FAIL = 2964;
/*      */   public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965;
/*      */   public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966;
/*      */   public static final int GL_STENCIL_REF = 2967;
/*      */   public static final int GL_STENCIL_WRITEMASK = 2968;
/*      */   public static final int GL_VIEWPORT = 2978;
/*      */   public static final int GL_DITHER = 3024;
/*      */   public static final int GL_BLEND_DST = 3040;
/*      */   public static final int GL_BLEND_SRC = 3041;
/*      */   public static final int GL_BLEND = 3042;
/*      */   public static final int GL_LOGIC_OP_MODE = 3056;
/*      */   public static final int GL_COLOR_LOGIC_OP = 3058;
/*      */   public static final int GL_DRAW_BUFFER = 3073;
/*      */   public static final int GL_READ_BUFFER = 3074;
/*      */   public static final int GL_SCISSOR_BOX = 3088;
/*      */   public static final int GL_SCISSOR_TEST = 3089;
/*      */   public static final int GL_COLOR_CLEAR_VALUE = 3106;
/*      */   public static final int GL_COLOR_WRITEMASK = 3107;
/*      */   public static final int GL_DOUBLEBUFFER = 3122;
/*      */   public static final int GL_STEREO = 3123;
/*      */   public static final int GL_LINE_SMOOTH_HINT = 3154;
/*      */   public static final int GL_POLYGON_SMOOTH_HINT = 3155;
/*      */   public static final int GL_UNPACK_SWAP_BYTES = 3312;
/*      */   public static final int GL_UNPACK_LSB_FIRST = 3313;
/*      */   public static final int GL_UNPACK_ROW_LENGTH = 3314;
/*      */   public static final int GL_UNPACK_SKIP_ROWS = 3315;
/*      */   public static final int GL_UNPACK_SKIP_PIXELS = 3316;
/*      */   public static final int GL_UNPACK_ALIGNMENT = 3317;
/*      */   public static final int GL_PACK_SWAP_BYTES = 3328;
/*      */   public static final int GL_PACK_LSB_FIRST = 3329;
/*      */   public static final int GL_PACK_ROW_LENGTH = 3330;
/*      */   public static final int GL_PACK_SKIP_ROWS = 3331;
/*      */   public static final int GL_PACK_SKIP_PIXELS = 3332;
/*      */   public static final int GL_PACK_ALIGNMENT = 3333;
/*      */   public static final int GL_MAX_TEXTURE_SIZE = 3379;
/*      */   public static final int GL_MAX_VIEWPORT_DIMS = 3386;
/*      */   public static final int GL_SUBPIXEL_BITS = 3408;
/*      */   public static final int GL_TEXTURE_1D = 3552;
/*      */   public static final int GL_TEXTURE_2D = 3553;
/*      */   public static final int GL_TEXTURE_WIDTH = 4096;
/*      */   public static final int GL_TEXTURE_HEIGHT = 4097;
/*      */   public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099;
/*      */   public static final int GL_TEXTURE_BORDER_COLOR = 4100;
/*      */   public static final int GL_DONT_CARE = 4352;
/*      */   public static final int GL_FASTEST = 4353;
/*      */   public static final int GL_NICEST = 4354;
/*      */   public static final int GL_CLEAR = 5376;
/*      */   public static final int GL_AND = 5377;
/*      */   public static final int GL_AND_REVERSE = 5378;
/*      */   public static final int GL_COPY = 5379;
/*      */   public static final int GL_AND_INVERTED = 5380;
/*      */   public static final int GL_NOOP = 5381;
/*      */   public static final int GL_XOR = 5382;
/*      */   public static final int GL_OR = 5383;
/*      */   public static final int GL_NOR = 5384;
/*      */   public static final int GL_EQUIV = 5385;
/*      */   public static final int GL_INVERT = 5386;
/*      */   public static final int GL_OR_REVERSE = 5387;
/*      */   public static final int GL_COPY_INVERTED = 5388;
/*      */   public static final int GL_OR_INVERTED = 5389;
/*      */   public static final int GL_NAND = 5390;
/*      */   public static final int GL_SET = 5391;
/*      */   public static final int GL_TEXTURE = 5890;
/*      */   public static final int GL_COLOR = 6144;
/*      */   public static final int GL_DEPTH = 6145;
/*      */   public static final int GL_STENCIL = 6146;
/*      */   public static final int GL_STENCIL_INDEX = 6401;
/*      */   public static final int GL_DEPTH_COMPONENT = 6402;
/*      */   public static final int GL_RED = 6403;
/*      */   public static final int GL_GREEN = 6404;
/*      */   public static final int GL_BLUE = 6405;
/*      */   public static final int GL_ALPHA = 6406;
/*      */   public static final int GL_RGB = 6407;
/*      */   public static final int GL_RGBA = 6408;
/*      */   public static final int GL_POINT = 6912;
/*      */   public static final int GL_LINE = 6913;
/*      */   public static final int GL_FILL = 6914;
/*      */   public static final int GL_KEEP = 7680;
/*      */   public static final int GL_REPLACE = 7681;
/*      */   public static final int GL_INCR = 7682;
/*      */   public static final int GL_DECR = 7683;
/*      */   public static final int GL_VENDOR = 7936;
/*      */   public static final int GL_RENDERER = 7937;
/*      */   public static final int GL_VERSION = 7938;
/*      */   public static final int GL_EXTENSIONS = 7939;
/*      */   public static final int GL_NEAREST = 9728;
/*      */   public static final int GL_LINEAR = 9729;
/*      */   public static final int GL_NEAREST_MIPMAP_NEAREST = 9984;
/*      */   public static final int GL_LINEAR_MIPMAP_NEAREST = 9985;
/*      */   public static final int GL_NEAREST_MIPMAP_LINEAR = 9986;
/*      */   public static final int GL_LINEAR_MIPMAP_LINEAR = 9987;
/*      */   public static final int GL_TEXTURE_MAG_FILTER = 10240;
/*      */   public static final int GL_TEXTURE_MIN_FILTER = 10241;
/*      */   public static final int GL_TEXTURE_WRAP_S = 10242;
/*      */   public static final int GL_TEXTURE_WRAP_T = 10243;
/*      */   public static final int GL_REPEAT = 10497;
/*      */   public static final int GL_POLYGON_OFFSET_FACTOR = 32824;
/*      */   public static final int GL_POLYGON_OFFSET_UNITS = 10752;
/*      */   public static final int GL_POLYGON_OFFSET_POINT = 10753;
/*      */   public static final int GL_POLYGON_OFFSET_LINE = 10754;
/*      */   public static final int GL_POLYGON_OFFSET_FILL = 32823;
/*      */   public static final int GL_R3_G3_B2 = 10768;
/*      */   public static final int GL_RGB4 = 32847;
/*      */   public static final int GL_RGB5 = 32848;
/*      */   public static final int GL_RGB8 = 32849;
/*      */   public static final int GL_RGB10 = 32850;
/*      */   public static final int GL_RGB12 = 32851;
/*      */   public static final int GL_RGB16 = 32852;
/*      */   public static final int GL_RGBA2 = 32853;
/*      */   public static final int GL_RGBA4 = 32854;
/*      */   public static final int GL_RGB5_A1 = 32855;
/*      */   public static final int GL_RGBA8 = 32856;
/*      */   public static final int GL_RGB10_A2 = 32857;
/*      */   public static final int GL_RGBA12 = 32858;
/*      */   public static final int GL_RGBA16 = 32859;
/*      */   public static final int GL_TEXTURE_RED_SIZE = 32860;
/*      */   public static final int GL_TEXTURE_GREEN_SIZE = 32861;
/*      */   public static final int GL_TEXTURE_BLUE_SIZE = 32862;
/*      */   public static final int GL_TEXTURE_ALPHA_SIZE = 32863;
/*      */   public static final int GL_PROXY_TEXTURE_1D = 32867;
/*      */   public static final int GL_PROXY_TEXTURE_2D = 32868;
/*      */   public static final int GL_TEXTURE_BINDING_1D = 32872;
/*      */   public static final int GL_TEXTURE_BINDING_2D = 32873;
/*      */   public static final int GL_VERTEX_ARRAY = 32884;
/*      */   
/*      */   protected GL11C() {
/*  283 */     throw new UnsupportedOperationException();
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
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices) {
/*  368 */     nglDrawElements(mode, count, type, indices);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices) {
/*  373 */     nglDrawElements(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices) {
/*  378 */     nglDrawElements(mode, indices.remaining(), 5121, MemoryUtil.memAddress(indices));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices) {
/*  383 */     nglDrawElements(mode, indices.remaining(), 5123, MemoryUtil.memAddress(indices));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices) {
/*  388 */     nglDrawElements(mode, indices.remaining(), 5125, MemoryUtil.memAddress(indices));
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
/*      */   public static void glGenTextures(@NativeType("GLuint *") IntBuffer textures) {
/*  413 */     nglGenTextures(textures.remaining(), MemoryUtil.memAddress(textures));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenTextures() {
/*  419 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  421 */       IntBuffer textures = stack.callocInt(1);
/*  422 */       nglGenTextures(1, MemoryUtil.memAddress(textures));
/*  423 */       return textures.get(0);
/*      */     } finally {
/*  425 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") IntBuffer textures) {
/*  436 */     nglDeleteTextures(textures.remaining(), MemoryUtil.memAddress(textures));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") int texture) {
/*  441 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  443 */       IntBuffer textures = stack.ints(texture);
/*  444 */       nglDeleteTextures(1, MemoryUtil.memAddress(textures));
/*      */     } finally {
/*  446 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBooleanv(@NativeType("GLenum") int pname, @NativeType("GLboolean *") ByteBuffer params) {
/*  457 */     if (Checks.CHECKS) {
/*  458 */       Checks.check(params, 1);
/*      */     }
/*  460 */     nglGetBooleanv(pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static boolean glGetBoolean(@NativeType("GLenum") int pname) {
/*  466 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  468 */       ByteBuffer params = stack.calloc(1);
/*  469 */       nglGetBooleanv(pname, MemoryUtil.memAddress(params));
/*  470 */       return (params.get(0) != 0);
/*      */     } finally {
/*  472 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFloatv(@NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/*  483 */     if (Checks.CHECKS) {
/*  484 */       Checks.check(params, 1);
/*      */     }
/*  486 */     nglGetFloatv(pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetFloat(@NativeType("GLenum") int pname) {
/*  492 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  494 */       FloatBuffer params = stack.callocFloat(1);
/*  495 */       nglGetFloatv(pname, MemoryUtil.memAddress(params));
/*  496 */       return params.get(0);
/*      */     } finally {
/*  498 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetIntegerv(@NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  509 */     if (Checks.CHECKS) {
/*  510 */       Checks.check(params, 1);
/*      */     }
/*  512 */     nglGetIntegerv(pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetInteger(@NativeType("GLenum") int pname) {
/*  518 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  520 */       IntBuffer params = stack.callocInt(1);
/*  521 */       nglGetIntegerv(pname, MemoryUtil.memAddress(params));
/*  522 */       return params.get(0);
/*      */     } finally {
/*  524 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoublev(@NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/*  535 */     if (Checks.CHECKS) {
/*  536 */       Checks.check(params, 1);
/*      */     }
/*  538 */     nglGetDoublev(pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetDouble(@NativeType("GLenum") int pname) {
/*  544 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  546 */       DoubleBuffer params = stack.callocDouble(1);
/*  547 */       nglGetDoublev(pname, MemoryUtil.memAddress(params));
/*  548 */       return params.get(0);
/*      */     } finally {
/*  550 */       stack.setPointer(stackPointer);
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
/*      */   public static void glGetPointerv(@NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer params) {
/*  567 */     if (Checks.CHECKS) {
/*  568 */       Checks.check((CustomBuffer)params, 1);
/*      */     }
/*  570 */     nglGetPointerv(pname, MemoryUtil.memAddress((CustomBuffer)params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetPointer(@NativeType("GLenum") int pname) {
/*  576 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  578 */       PointerBuffer params = stack.callocPointer(1);
/*  579 */       nglGetPointerv(pname, MemoryUtil.memAddress((CustomBuffer)params));
/*  580 */       return params.get(0);
/*      */     } finally {
/*  582 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLubyte const *")
/*      */   public static String glGetString(@NativeType("GLenum") int name) {
/*  594 */     long __result = nglGetString(name);
/*  595 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/*  605 */     nglGetTexImage(tex, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long pixels) {
/*  610 */     nglGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/*  615 */     nglGetTexImage(tex, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/*  620 */     nglGetTexImage(tex, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/*  625 */     nglGetTexImage(tex, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/*  630 */     nglGetTexImage(tex, level, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameteriv(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  640 */     if (Checks.CHECKS) {
/*  641 */       Checks.check(params, 1);
/*      */     }
/*  643 */     nglGetTexLevelParameteriv(target, level, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTexLevelParameteri(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/*  649 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  651 */       IntBuffer params = stack.callocInt(1);
/*  652 */       nglGetTexLevelParameteriv(target, level, pname, MemoryUtil.memAddress(params));
/*  653 */       return params.get(0);
/*      */     } finally {
/*  655 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameterfv(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/*  666 */     if (Checks.CHECKS) {
/*  667 */       Checks.check(params, 1);
/*      */     }
/*  669 */     nglGetTexLevelParameterfv(target, level, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTexLevelParameterf(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/*  675 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  677 */       FloatBuffer params = stack.callocFloat(1);
/*  678 */       nglGetTexLevelParameterfv(target, level, pname, MemoryUtil.memAddress(params));
/*  679 */       return params.get(0);
/*      */     } finally {
/*  681 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  692 */     if (Checks.CHECKS) {
/*  693 */       Checks.check(params, 1);
/*      */     }
/*  695 */     nglGetTexParameteriv(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTexParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  701 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  703 */       IntBuffer params = stack.callocInt(1);
/*  704 */       nglGetTexParameteriv(target, pname, MemoryUtil.memAddress(params));
/*  705 */       return params.get(0);
/*      */     } finally {
/*  707 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/*  718 */     if (Checks.CHECKS) {
/*  719 */       Checks.check(params, 1);
/*      */     }
/*  721 */     nglGetTexParameterfv(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTexParameterf(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  727 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  729 */       FloatBuffer params = stack.callocFloat(1);
/*  730 */       nglGetTexParameterfv(target, pname, MemoryUtil.memAddress(params));
/*  731 */       return params.get(0);
/*      */     } finally {
/*  733 */       stack.setPointer(stackPointer);
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
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/*  801 */     nglReadPixels(x, y, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long pixels) {
/*  806 */     nglReadPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/*  811 */     nglReadPixels(x, y, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/*  816 */     nglReadPixels(x, y, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/*  821 */     nglReadPixels(x, y, width, height, format, type, MemoryUtil.memAddress(pixels));
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
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  851 */     nglTexImage1D(target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  856 */     nglTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  861 */     nglTexImage1D(target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  866 */     nglTexImage1D(target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  871 */     nglTexImage1D(target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  876 */     nglTexImage1D(target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  886 */     nglTexImage2D(target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  891 */     nglTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  896 */     nglTexImage2D(target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  901 */     nglTexImage2D(target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  906 */     nglTexImage2D(target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/*  911 */     nglTexImage2D(target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
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
/*      */   public static void glTexParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/*  946 */     if (Checks.CHECKS) {
/*  947 */       Checks.check(params, 4);
/*      */     }
/*  949 */     nglTexParameteriv(target, pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glTexParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/*  964 */     if (Checks.CHECKS) {
/*  965 */       Checks.check(params, 4);
/*      */     }
/*  967 */     nglTexParameterfv(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/*  977 */     nglTexSubImage1D(target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/*  982 */     nglTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/*  987 */     nglTexSubImage1D(target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/*  992 */     nglTexSubImage1D(target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/*  997 */     nglTexSubImage1D(target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 1002 */     nglTexSubImage1D(target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/* 1012 */     nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/* 1017 */     nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/* 1022 */     nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 1027 */     nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 1032 */     nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 1037 */     nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenTextures(@NativeType("GLuint *") int[] textures) {
/* 1047 */     long __functionAddress = (GL.getICD()).glGenTextures;
/* 1048 */     if (Checks.CHECKS) {
/* 1049 */       Checks.check(__functionAddress);
/*      */     }
/* 1051 */     JNI.callPV(textures.length, textures, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") int[] textures) {
/* 1056 */     long __functionAddress = (GL.getICD()).glDeleteTextures;
/* 1057 */     if (Checks.CHECKS) {
/* 1058 */       Checks.check(__functionAddress);
/*      */     }
/* 1060 */     JNI.callPV(textures.length, textures, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloatv(@NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 1065 */     long __functionAddress = (GL.getICD()).glGetFloatv;
/* 1066 */     if (Checks.CHECKS) {
/* 1067 */       Checks.check(__functionAddress);
/* 1068 */       Checks.check(params, 1);
/*      */     } 
/* 1070 */     JNI.callPV(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetIntegerv(@NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1075 */     long __functionAddress = (GL.getICD()).glGetIntegerv;
/* 1076 */     if (Checks.CHECKS) {
/* 1077 */       Checks.check(__functionAddress);
/* 1078 */       Checks.check(params, 1);
/*      */     } 
/* 1080 */     JNI.callPV(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoublev(@NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 1085 */     long __functionAddress = (GL.getICD()).glGetDoublev;
/* 1086 */     if (Checks.CHECKS) {
/* 1087 */       Checks.check(__functionAddress);
/* 1088 */       Checks.check(params, 1);
/*      */     } 
/* 1090 */     JNI.callPV(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 1095 */     long __functionAddress = (GL.getICD()).glGetTexImage;
/* 1096 */     if (Checks.CHECKS) {
/* 1097 */       Checks.check(__functionAddress);
/*      */     }
/* 1099 */     JNI.callPV(tex, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 1104 */     long __functionAddress = (GL.getICD()).glGetTexImage;
/* 1105 */     if (Checks.CHECKS) {
/* 1106 */       Checks.check(__functionAddress);
/*      */     }
/* 1108 */     JNI.callPV(tex, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 1113 */     long __functionAddress = (GL.getICD()).glGetTexImage;
/* 1114 */     if (Checks.CHECKS) {
/* 1115 */       Checks.check(__functionAddress);
/*      */     }
/* 1117 */     JNI.callPV(tex, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 1122 */     long __functionAddress = (GL.getICD()).glGetTexImage;
/* 1123 */     if (Checks.CHECKS) {
/* 1124 */       Checks.check(__functionAddress);
/*      */     }
/* 1126 */     JNI.callPV(tex, level, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameteriv(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1131 */     long __functionAddress = (GL.getICD()).glGetTexLevelParameteriv;
/* 1132 */     if (Checks.CHECKS) {
/* 1133 */       Checks.check(__functionAddress);
/* 1134 */       Checks.check(params, 1);
/*      */     } 
/* 1136 */     JNI.callPV(target, level, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameterfv(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 1141 */     long __functionAddress = (GL.getICD()).glGetTexLevelParameterfv;
/* 1142 */     if (Checks.CHECKS) {
/* 1143 */       Checks.check(__functionAddress);
/* 1144 */       Checks.check(params, 1);
/*      */     } 
/* 1146 */     JNI.callPV(target, level, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1151 */     long __functionAddress = (GL.getICD()).glGetTexParameteriv;
/* 1152 */     if (Checks.CHECKS) {
/* 1153 */       Checks.check(__functionAddress);
/* 1154 */       Checks.check(params, 1);
/*      */     } 
/* 1156 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 1161 */     long __functionAddress = (GL.getICD()).glGetTexParameterfv;
/* 1162 */     if (Checks.CHECKS) {
/* 1163 */       Checks.check(__functionAddress);
/* 1164 */       Checks.check(params, 1);
/*      */     } 
/* 1166 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 1171 */     long __functionAddress = (GL.getICD()).glReadPixels;
/* 1172 */     if (Checks.CHECKS) {
/* 1173 */       Checks.check(__functionAddress);
/*      */     }
/* 1175 */     JNI.callPV(x, y, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 1180 */     long __functionAddress = (GL.getICD()).glReadPixels;
/* 1181 */     if (Checks.CHECKS) {
/* 1182 */       Checks.check(__functionAddress);
/*      */     }
/* 1184 */     JNI.callPV(x, y, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 1189 */     long __functionAddress = (GL.getICD()).glReadPixels;
/* 1190 */     if (Checks.CHECKS) {
/* 1191 */       Checks.check(__functionAddress);
/*      */     }
/* 1193 */     JNI.callPV(x, y, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 1198 */     long __functionAddress = (GL.getICD()).glTexImage1D;
/* 1199 */     if (Checks.CHECKS) {
/* 1200 */       Checks.check(__functionAddress);
/*      */     }
/* 1202 */     JNI.callPV(target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 1207 */     long __functionAddress = (GL.getICD()).glTexImage1D;
/* 1208 */     if (Checks.CHECKS) {
/* 1209 */       Checks.check(__functionAddress);
/*      */     }
/* 1211 */     JNI.callPV(target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 1216 */     long __functionAddress = (GL.getICD()).glTexImage1D;
/* 1217 */     if (Checks.CHECKS) {
/* 1218 */       Checks.check(__functionAddress);
/*      */     }
/* 1220 */     JNI.callPV(target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 1225 */     long __functionAddress = (GL.getICD()).glTexImage1D;
/* 1226 */     if (Checks.CHECKS) {
/* 1227 */       Checks.check(__functionAddress);
/*      */     }
/* 1229 */     JNI.callPV(target, level, internalformat, width, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 1234 */     long __functionAddress = (GL.getICD()).glTexImage2D;
/* 1235 */     if (Checks.CHECKS) {
/* 1236 */       Checks.check(__functionAddress);
/*      */     }
/* 1238 */     JNI.callPV(target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 1243 */     long __functionAddress = (GL.getICD()).glTexImage2D;
/* 1244 */     if (Checks.CHECKS) {
/* 1245 */       Checks.check(__functionAddress);
/*      */     }
/* 1247 */     JNI.callPV(target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 1252 */     long __functionAddress = (GL.getICD()).glTexImage2D;
/* 1253 */     if (Checks.CHECKS) {
/* 1254 */       Checks.check(__functionAddress);
/*      */     }
/* 1256 */     JNI.callPV(target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 1261 */     long __functionAddress = (GL.getICD()).glTexImage2D;
/* 1262 */     if (Checks.CHECKS) {
/* 1263 */       Checks.check(__functionAddress);
/*      */     }
/* 1265 */     JNI.callPV(target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 1270 */     long __functionAddress = (GL.getICD()).glTexParameteriv;
/* 1271 */     if (Checks.CHECKS) {
/* 1272 */       Checks.check(__functionAddress);
/* 1273 */       Checks.check(params, 4);
/*      */     } 
/* 1275 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 1280 */     long __functionAddress = (GL.getICD()).glTexParameterfv;
/* 1281 */     if (Checks.CHECKS) {
/* 1282 */       Checks.check(__functionAddress);
/* 1283 */       Checks.check(params, 4);
/*      */     } 
/* 1285 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 1290 */     long __functionAddress = (GL.getICD()).glTexSubImage1D;
/* 1291 */     if (Checks.CHECKS) {
/* 1292 */       Checks.check(__functionAddress);
/*      */     }
/* 1294 */     JNI.callPV(target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 1299 */     long __functionAddress = (GL.getICD()).glTexSubImage1D;
/* 1300 */     if (Checks.CHECKS) {
/* 1301 */       Checks.check(__functionAddress);
/*      */     }
/* 1303 */     JNI.callPV(target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 1308 */     long __functionAddress = (GL.getICD()).glTexSubImage1D;
/* 1309 */     if (Checks.CHECKS) {
/* 1310 */       Checks.check(__functionAddress);
/*      */     }
/* 1312 */     JNI.callPV(target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 1317 */     long __functionAddress = (GL.getICD()).glTexSubImage1D;
/* 1318 */     if (Checks.CHECKS) {
/* 1319 */       Checks.check(__functionAddress);
/*      */     }
/* 1321 */     JNI.callPV(target, level, xoffset, width, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 1326 */     long __functionAddress = (GL.getICD()).glTexSubImage2D;
/* 1327 */     if (Checks.CHECKS) {
/* 1328 */       Checks.check(__functionAddress);
/*      */     }
/* 1330 */     JNI.callPV(target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 1335 */     long __functionAddress = (GL.getICD()).glTexSubImage2D;
/* 1336 */     if (Checks.CHECKS) {
/* 1337 */       Checks.check(__functionAddress);
/*      */     }
/* 1339 */     JNI.callPV(target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 1344 */     long __functionAddress = (GL.getICD()).glTexSubImage2D;
/* 1345 */     if (Checks.CHECKS) {
/* 1346 */       Checks.check(__functionAddress);
/*      */     }
/* 1348 */     JNI.callPV(target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 1353 */     long __functionAddress = (GL.getICD()).glTexSubImage2D;
/* 1354 */     if (Checks.CHECKS) {
/* 1355 */       Checks.check(__functionAddress);
/*      */     }
/* 1357 */     JNI.callPV(target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */   
/*      */   public static native void glEnable(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glDisable(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glBindTexture(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glBlendFunc(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glClear(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void glClearColor(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glClearDepth(@NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glClearStencil(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glColorMask(@NativeType("GLboolean") boolean paramBoolean1, @NativeType("GLboolean") boolean paramBoolean2, @NativeType("GLboolean") boolean paramBoolean3, @NativeType("GLboolean") boolean paramBoolean4);
/*      */   
/*      */   public static native void glCullFace(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glDepthFunc(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glDepthMask(@NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glDepthRange(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glDrawArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3);
/*      */   
/*      */   public static native void glDrawBuffer(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglDrawElements(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glFinish();
/*      */   
/*      */   public static native void glFlush();
/*      */   
/*      */   public static native void glFrontFace(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglGenTextures(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglDeleteTextures(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetBooleanv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetFloatv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetIntegerv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetDoublev(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glGetError();
/*      */   
/*      */   public static native void nglGetPointerv(int paramInt, long paramLong);
/*      */   
/*      */   public static native long nglGetString(int paramInt);
/*      */   
/*      */   public static native void nglGetTexImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetTexLevelParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTexLevelParameterfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTexParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glHint(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsEnabled(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsTexture(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glLineWidth(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glLogicOp(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glPixelStorei(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glPixelStoref(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glPointSize(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glPolygonMode(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glPolygonOffset(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glReadBuffer(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglReadPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void glScissor(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void glStencilFunc(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glStencilMask(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glStencilOp(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*      */   
/*      */   public static native void nglTexImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void glCopyTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7);
/*      */   
/*      */   public static native void glCopyTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8);
/*      */   
/*      */   public static native void glCopyTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*      */   
/*      */   public static native void glCopyTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8);
/*      */   
/*      */   public static native void glTexParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglTexParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTexParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglTexSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void nglTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void glViewport(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL11C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */