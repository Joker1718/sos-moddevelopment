/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL30C
/*      */   extends GL21C
/*      */ {
/*      */   public static final int GL_MAJOR_VERSION = 33307;
/*      */   public static final int GL_MINOR_VERSION = 33308;
/*      */   public static final int GL_NUM_EXTENSIONS = 33309;
/*      */   
/*      */   static {
/*   24 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_CONTEXT_FLAGS = 33310;
/*      */   
/*      */   public static final int GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT = 1;
/*      */   
/*      */   public static final int GL_COMPARE_REF_TO_TEXTURE = 34894;
/*      */   
/*      */   public static final int GL_CLIP_DISTANCE0 = 12288;
/*      */   
/*      */   public static final int GL_CLIP_DISTANCE1 = 12289;
/*      */   
/*      */   public static final int GL_CLIP_DISTANCE2 = 12290;
/*      */   
/*      */   public static final int GL_CLIP_DISTANCE3 = 12291;
/*      */   
/*      */   public static final int GL_CLIP_DISTANCE4 = 12292;
/*      */   
/*      */   public static final int GL_CLIP_DISTANCE5 = 12293;
/*      */   
/*      */   public static final int GL_CLIP_DISTANCE6 = 12294;
/*      */   
/*      */   public static final int GL_CLIP_DISTANCE7 = 12295;
/*      */   
/*      */   public static final int GL_MAX_CLIP_DISTANCES = 3378;
/*      */   
/*      */   public static final int GL_MAX_VARYING_COMPONENTS = 35659;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 35069;
/*      */   
/*      */   public static final int GL_SAMPLER_1D_ARRAY = 36288;
/*      */   
/*      */   public static final int GL_SAMPLER_2D_ARRAY = 36289;
/*      */   
/*      */   public static final int GL_SAMPLER_1D_ARRAY_SHADOW = 36291;
/*      */   
/*      */   public static final int GL_SAMPLER_2D_ARRAY_SHADOW = 36292;
/*      */   
/*      */   public static final int GL_SAMPLER_CUBE_SHADOW = 36293;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_VEC2 = 36294;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_VEC3 = 36295;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_VEC4 = 36296;
/*      */   
/*      */   public static final int GL_INT_SAMPLER_1D = 36297;
/*      */   
/*      */   public static final int GL_INT_SAMPLER_2D = 36298;
/*      */   
/*      */   public static final int GL_INT_SAMPLER_3D = 36299;
/*      */   
/*      */   public static final int GL_INT_SAMPLER_CUBE = 36300;
/*      */   
/*      */   public static final int GL_INT_SAMPLER_1D_ARRAY = 36302;
/*      */   
/*      */   public static final int GL_INT_SAMPLER_2D_ARRAY = 36303;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_1D = 36305;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_2D = 36306;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_3D = 36307;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_CUBE = 36308;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY = 36310;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 36311;
/*      */   
/*      */   public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 35076;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_TEXEL_OFFSET = 35077;
/*      */   
/*      */   public static final int GL_QUERY_WAIT = 36371;
/*      */   
/*      */   public static final int GL_QUERY_NO_WAIT = 36372;
/*      */   
/*      */   public static final int GL_QUERY_BY_REGION_WAIT = 36373;
/*      */   
/*      */   public static final int GL_QUERY_BY_REGION_NO_WAIT = 36374;
/*      */   
/*      */   public static final int GL_MAP_READ_BIT = 1;
/*      */   
/*      */   public static final int GL_MAP_WRITE_BIT = 2;
/*      */   
/*      */   public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
/*      */   
/*      */   public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
/*      */   
/*      */   public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
/*      */   
/*      */   public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;
/*      */   
/*      */   public static final int GL_BUFFER_ACCESS_FLAGS = 37151;
/*      */   
/*      */   public static final int GL_BUFFER_MAP_LENGTH = 37152;
/*      */   
/*      */   public static final int GL_BUFFER_MAP_OFFSET = 37153;
/*      */   
/*      */   public static final int GL_CLAMP_READ_COLOR = 35100;
/*      */   
/*      */   public static final int GL_FIXED_ONLY = 35101;
/*      */   
/*      */   public static final int GL_DEPTH_COMPONENT32F = 36012;
/*      */   
/*      */   public static final int GL_DEPTH32F_STENCIL8 = 36013;
/*      */   
/*      */   public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 36269;
/*      */   
/*      */   public static final int GL_TEXTURE_RED_TYPE = 35856;
/*      */   
/*      */   public static final int GL_TEXTURE_GREEN_TYPE = 35857;
/*      */   
/*      */   public static final int GL_TEXTURE_BLUE_TYPE = 35858;
/*      */   
/*      */   public static final int GL_TEXTURE_ALPHA_TYPE = 35859;
/*      */   
/*      */   public static final int GL_TEXTURE_DEPTH_TYPE = 35862;
/*      */   
/*      */   public static final int GL_UNSIGNED_NORMALIZED = 35863;
/*      */   
/*      */   public static final int GL_RGBA32F = 34836;
/*      */   
/*      */   public static final int GL_RGB32F = 34837;
/*      */   
/*      */   public static final int GL_RGBA16F = 34842;
/*      */   
/*      */   public static final int GL_RGB16F = 34843;
/*      */   
/*      */   public static final int GL_R11F_G11F_B10F = 35898;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 35899;
/*      */   
/*      */   public static final int GL_RGB9_E5 = 35901;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 35902;
/*      */   
/*      */   public static final int GL_TEXTURE_SHARED_SIZE = 35903;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER = 36160;
/*      */   
/*      */   public static final int GL_READ_FRAMEBUFFER = 36008;
/*      */   
/*      */   public static final int GL_DRAW_FRAMEBUFFER = 36009;
/*      */   
/*      */   public static final int GL_RENDERBUFFER = 36161;
/*      */   
/*      */   public static final int GL_STENCIL_INDEX1 = 36166;
/*      */   
/*      */   public static final int GL_STENCIL_INDEX4 = 36167;
/*      */   
/*      */   public static final int GL_STENCIL_INDEX8 = 36168;
/*      */   
/*      */   public static final int GL_STENCIL_INDEX16 = 36169;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_WIDTH = 36162;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_HEIGHT = 36163;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_RED_SIZE = 36176;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179;
/*      */   public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180;
/*      */   public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181;
/*      */   public static final int GL_RENDERBUFFER_SAMPLES = 36011;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 33296;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 33297;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 33298;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 33299;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 33300;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 33301;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 33302;
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 33303;
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT = 33304;
/*      */   public static final int GL_COLOR_ATTACHMENT0 = 36064;
/*      */   public static final int GL_COLOR_ATTACHMENT1 = 36065;
/*      */   public static final int GL_COLOR_ATTACHMENT2 = 36066;
/*      */   public static final int GL_COLOR_ATTACHMENT3 = 36067;
/*      */   public static final int GL_COLOR_ATTACHMENT4 = 36068;
/*      */   public static final int GL_COLOR_ATTACHMENT5 = 36069;
/*      */   public static final int GL_COLOR_ATTACHMENT6 = 36070;
/*      */   public static final int GL_COLOR_ATTACHMENT7 = 36071;
/*      */   public static final int GL_COLOR_ATTACHMENT8 = 36072;
/*      */   public static final int GL_COLOR_ATTACHMENT9 = 36073;
/*      */   public static final int GL_COLOR_ATTACHMENT10 = 36074;
/*      */   public static final int GL_COLOR_ATTACHMENT11 = 36075;
/*      */   public static final int GL_COLOR_ATTACHMENT12 = 36076;
/*      */   public static final int GL_COLOR_ATTACHMENT13 = 36077;
/*      */   public static final int GL_COLOR_ATTACHMENT14 = 36078;
/*      */   public static final int GL_COLOR_ATTACHMENT15 = 36079;
/*      */   public static final int GL_COLOR_ATTACHMENT16 = 36080;
/*      */   public static final int GL_COLOR_ATTACHMENT17 = 36081;
/*      */   public static final int GL_COLOR_ATTACHMENT18 = 36082;
/*      */   public static final int GL_COLOR_ATTACHMENT19 = 36083;
/*      */   public static final int GL_COLOR_ATTACHMENT20 = 36084;
/*      */   public static final int GL_COLOR_ATTACHMENT21 = 36085;
/*      */   public static final int GL_COLOR_ATTACHMENT22 = 36086;
/*      */   public static final int GL_COLOR_ATTACHMENT23 = 36087;
/*      */   public static final int GL_COLOR_ATTACHMENT24 = 36088;
/*      */   public static final int GL_COLOR_ATTACHMENT25 = 36089;
/*      */   public static final int GL_COLOR_ATTACHMENT26 = 36090;
/*      */   public static final int GL_COLOR_ATTACHMENT27 = 36091;
/*      */   public static final int GL_COLOR_ATTACHMENT28 = 36092;
/*      */   public static final int GL_COLOR_ATTACHMENT29 = 36093;
/*      */   public static final int GL_COLOR_ATTACHMENT30 = 36094;
/*      */   public static final int GL_COLOR_ATTACHMENT31 = 36095;
/*      */   public static final int GL_DEPTH_ATTACHMENT = 36096;
/*      */   public static final int GL_STENCIL_ATTACHMENT = 36128;
/*      */   public static final int GL_DEPTH_STENCIL_ATTACHMENT = 33306;
/*      */   public static final int GL_MAX_SAMPLES = 36183;
/*      */   public static final int GL_FRAMEBUFFER_COMPLETE = 36053;
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054;
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055;
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 36059;
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 36060;
/*      */   public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061;
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182;
/*      */   public static final int GL_FRAMEBUFFER_UNDEFINED = 33305;
/*      */   public static final int GL_FRAMEBUFFER_BINDING = 36006;
/*      */   public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006;
/*      */   public static final int GL_READ_FRAMEBUFFER_BINDING = 36010;
/*      */   public static final int GL_RENDERBUFFER_BINDING = 36007;
/*      */   public static final int GL_MAX_COLOR_ATTACHMENTS = 36063;
/*      */   public static final int GL_MAX_RENDERBUFFER_SIZE = 34024;
/*      */   public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286;
/*      */   public static final int GL_DEPTH_STENCIL = 34041;
/*      */   public static final int GL_UNSIGNED_INT_24_8 = 34042;
/*      */   public static final int GL_DEPTH24_STENCIL8 = 35056;
/*      */   public static final int GL_TEXTURE_STENCIL_SIZE = 35057;
/*      */   public static final int GL_HALF_FLOAT = 5131;
/*      */   public static final int GL_RGBA32UI = 36208;
/*      */   public static final int GL_RGB32UI = 36209;
/*      */   public static final int GL_RGBA16UI = 36214;
/*      */   public static final int GL_RGB16UI = 36215;
/*      */   public static final int GL_RGBA8UI = 36220;
/*      */   public static final int GL_RGB8UI = 36221;
/*      */   public static final int GL_RGBA32I = 36226;
/*      */   public static final int GL_RGB32I = 36227;
/*      */   public static final int GL_RGBA16I = 36232;
/*      */   public static final int GL_RGB16I = 36233;
/*      */   public static final int GL_RGBA8I = 36238;
/*      */   public static final int GL_RGB8I = 36239;
/*      */   public static final int GL_RED_INTEGER = 36244;
/*      */   public static final int GL_GREEN_INTEGER = 36245;
/*      */   public static final int GL_BLUE_INTEGER = 36246;
/*      */   public static final int GL_RGB_INTEGER = 36248;
/*      */   public static final int GL_RGBA_INTEGER = 36249;
/*      */   public static final int GL_BGR_INTEGER = 36250;
/*      */   public static final int GL_BGRA_INTEGER = 36251;
/*      */   public static final int GL_TEXTURE_1D_ARRAY = 35864;
/*      */   public static final int GL_TEXTURE_2D_ARRAY = 35866;
/*      */   public static final int GL_PROXY_TEXTURE_2D_ARRAY = 35867;
/*      */   public static final int GL_PROXY_TEXTURE_1D_ARRAY = 35865;
/*      */   public static final int GL_TEXTURE_BINDING_1D_ARRAY = 35868;
/*      */   public static final int GL_TEXTURE_BINDING_2D_ARRAY = 35869;
/*      */   public static final int GL_MAX_ARRAY_TEXTURE_LAYERS = 35071;
/*      */   public static final int GL_COMPRESSED_RED_RGTC1 = 36283;
/*      */   public static final int GL_COMPRESSED_SIGNED_RED_RGTC1 = 36284;
/*      */   public static final int GL_COMPRESSED_RG_RGTC2 = 36285;
/*      */   public static final int GL_COMPRESSED_SIGNED_RG_RGTC2 = 36286;
/*      */   public static final int GL_R8 = 33321;
/*      */   public static final int GL_R16 = 33322;
/*      */   public static final int GL_RG8 = 33323;
/*      */   public static final int GL_RG16 = 33324;
/*      */   public static final int GL_R16F = 33325;
/*      */   public static final int GL_R32F = 33326;
/*      */   public static final int GL_RG16F = 33327;
/*      */   public static final int GL_RG32F = 33328;
/*      */   public static final int GL_R8I = 33329;
/*      */   public static final int GL_R8UI = 33330;
/*      */   public static final int GL_R16I = 33331;
/*      */   public static final int GL_R16UI = 33332;
/*      */   public static final int GL_R32I = 33333;
/*      */   public static final int GL_R32UI = 33334;
/*      */   public static final int GL_RG8I = 33335;
/*      */   public static final int GL_RG8UI = 33336;
/*      */   public static final int GL_RG16I = 33337;
/*      */   public static final int GL_RG16UI = 33338;
/*      */   public static final int GL_RG32I = 33339;
/*      */   public static final int GL_RG32UI = 33340;
/*      */   public static final int GL_RG = 33319;
/*      */   public static final int GL_COMPRESSED_RED = 33317;
/*      */   public static final int GL_COMPRESSED_RG = 33318;
/*      */   public static final int GL_RG_INTEGER = 33320;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 35982;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 35972;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 35973;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 35983;
/*      */   public static final int GL_INTERLEAVED_ATTRIBS = 35980;
/*      */   public static final int GL_SEPARATE_ATTRIBS = 35981;
/*      */   public static final int GL_PRIMITIVES_GENERATED = 35975;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 35976;
/*      */   public static final int GL_RASTERIZER_DISCARD = 35977;
/*      */   public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 35978;
/*      */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 35979;
/*      */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 35968;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 35971;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 35967;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 35958;
/*      */   public static final int GL_VERTEX_ARRAY_BINDING = 34229;
/*      */   public static final int GL_FRAMEBUFFER_SRGB = 36281;
/*      */   
/*      */   protected GL30C() {
/*  341 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLubyte const *")
/*      */   public static String glGetStringi(@NativeType("GLenum") int name, @NativeType("GLuint") int index) {
/*  352 */     long __result = nglGetStringi(name, index);
/*  353 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferiv(@NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") IntBuffer value) {
/*  363 */     if (Checks.CHECKS) {
/*  364 */       Checks.check(value, 1);
/*      */     }
/*  366 */     nglClearBufferiv(buffer, drawbuffer, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferuiv(@NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") IntBuffer value) {
/*  376 */     if (Checks.CHECKS) {
/*  377 */       Checks.check(value, 4);
/*      */     }
/*  379 */     nglClearBufferuiv(buffer, drawbuffer, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferfv(@NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat const *") FloatBuffer value) {
/*  389 */     if (Checks.CHECKS) {
/*  390 */       Checks.check(value, 1);
/*      */     }
/*  392 */     nglClearBufferfv(buffer, drawbuffer, MemoryUtil.memAddress(value));
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
/*      */   public static void glVertexAttribI1iv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  447 */     if (Checks.CHECKS) {
/*  448 */       Checks.check(v, 1);
/*      */     }
/*  450 */     nglVertexAttribI1iv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI2iv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  460 */     if (Checks.CHECKS) {
/*  461 */       Checks.check(v, 2);
/*      */     }
/*  463 */     nglVertexAttribI2iv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI3iv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  473 */     if (Checks.CHECKS) {
/*  474 */       Checks.check(v, 3);
/*      */     }
/*  476 */     nglVertexAttribI3iv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4iv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  486 */     if (Checks.CHECKS) {
/*  487 */       Checks.check(v, 4);
/*      */     }
/*  489 */     nglVertexAttribI4iv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI1uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/*  499 */     if (Checks.CHECKS) {
/*  500 */       Checks.check(v, 1);
/*      */     }
/*  502 */     nglVertexAttribI1uiv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI2uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/*  512 */     if (Checks.CHECKS) {
/*  513 */       Checks.check(v, 2);
/*      */     }
/*  515 */     nglVertexAttribI2uiv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI3uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/*  525 */     if (Checks.CHECKS) {
/*  526 */       Checks.check(v, 3);
/*      */     }
/*  528 */     nglVertexAttribI3uiv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/*  538 */     if (Checks.CHECKS) {
/*  539 */       Checks.check(v, 4);
/*      */     }
/*  541 */     nglVertexAttribI4uiv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4bv(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/*  551 */     if (Checks.CHECKS) {
/*  552 */       Checks.check(v, 4);
/*      */     }
/*  554 */     nglVertexAttribI4bv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  564 */     if (Checks.CHECKS) {
/*  565 */       Checks.check(v, 4);
/*      */     }
/*  567 */     nglVertexAttribI4sv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4ubv(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/*  577 */     if (Checks.CHECKS) {
/*  578 */       Checks.check(v, 4);
/*      */     }
/*  580 */     nglVertexAttribI4ubv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4usv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  590 */     if (Checks.CHECKS) {
/*  591 */       Checks.check(v, 4);
/*      */     }
/*  593 */     nglVertexAttribI4usv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribIPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/*  603 */     nglVertexAttribIPointer(index, size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribIPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/*  608 */     nglVertexAttribIPointer(index, size, type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribIPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/*  613 */     nglVertexAttribIPointer(index, size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribIPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/*  618 */     nglVertexAttribIPointer(index, size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribIiv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  628 */     if (Checks.CHECKS) {
/*  629 */       Checks.check(params, 4);
/*      */     }
/*  631 */     nglGetVertexAttribIiv(index, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexAttribIi(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/*  637 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  639 */       IntBuffer params = stack.callocInt(1);
/*  640 */       nglGetVertexAttribIiv(index, pname, MemoryUtil.memAddress(params));
/*  641 */       return params.get(0);
/*      */     } finally {
/*  643 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribIuiv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/*  654 */     if (Checks.CHECKS) {
/*  655 */       Checks.check(params, 4);
/*      */     }
/*  657 */     nglGetVertexAttribIuiv(index, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexAttribIui(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/*  663 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  665 */       IntBuffer params = stack.callocInt(1);
/*  666 */       nglGetVertexAttribIuiv(index, pname, MemoryUtil.memAddress(params));
/*  667 */       return params.get(0);
/*      */     } finally {
/*  669 */       stack.setPointer(stackPointer);
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
/*      */   public static void glUniform1uiv(@NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  700 */     nglUniform1uiv(location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2uiv(@NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  710 */     nglUniform2uiv(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3uiv(@NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  720 */     nglUniform3uiv(location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4uiv(@NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  730 */     nglUniform4uiv(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformuiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") IntBuffer params) {
/*  740 */     if (Checks.CHECKS) {
/*  741 */       Checks.check(params, 1);
/*      */     }
/*  743 */     nglGetUniformuiv(program, location, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetUniformui(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/*  749 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  751 */       IntBuffer params = stack.callocInt(1);
/*  752 */       nglGetUniformuiv(program, location, MemoryUtil.memAddress(params));
/*  753 */       return params.get(0);
/*      */     } finally {
/*  755 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindFragDataLocation(@NativeType("GLuint") int program, @NativeType("GLuint") int colorNumber, @NativeType("GLchar const *") ByteBuffer name) {
/*  766 */     if (Checks.CHECKS) {
/*  767 */       Checks.checkNT1(name);
/*      */     }
/*  769 */     nglBindFragDataLocation(program, colorNumber, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glBindFragDataLocation(@NativeType("GLuint") int program, @NativeType("GLuint") int colorNumber, @NativeType("GLchar const *") CharSequence name) {
/*  774 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  776 */       stack.nASCII(name, true);
/*  777 */       long nameEncoded = stack.getPointerAddress();
/*  778 */       nglBindFragDataLocation(program, colorNumber, nameEncoded);
/*      */     } finally {
/*  780 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetFragDataLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/*  792 */     if (Checks.CHECKS) {
/*  793 */       Checks.checkNT1(name);
/*      */     }
/*  795 */     return nglGetFragDataLocation(program, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetFragDataLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/*  801 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  803 */       stack.nASCII(name, true);
/*  804 */       long nameEncoded = stack.getPointerAddress();
/*  805 */       return nglGetFragDataLocation(program, nameEncoded);
/*      */     } finally {
/*  807 */       stack.setPointer(stackPointer);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapBufferRange(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access) {
/*  829 */     long __result = nglMapBufferRange(target, offset, length, access);
/*  830 */     return MemoryUtil.memByteBufferSafe(__result, (int)length);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapBufferRange(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access, ByteBuffer old_buffer) {
/*  836 */     long __result = nglMapBufferRange(target, offset, length, access);
/*  837 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
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
/*      */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") IntBuffer renderbuffers) {
/*  868 */     nglDeleteRenderbuffers(renderbuffers.remaining(), MemoryUtil.memAddress(renderbuffers));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int renderbuffer) {
/*  873 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  875 */       IntBuffer renderbuffers = stack.ints(renderbuffer);
/*  876 */       nglDeleteRenderbuffers(1, MemoryUtil.memAddress(renderbuffers));
/*      */     } finally {
/*  878 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenRenderbuffers(@NativeType("GLuint *") IntBuffer renderbuffers) {
/*  889 */     nglGenRenderbuffers(renderbuffers.remaining(), MemoryUtil.memAddress(renderbuffers));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenRenderbuffers() {
/*  895 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  897 */       IntBuffer renderbuffers = stack.callocInt(1);
/*  898 */       nglGenRenderbuffers(1, MemoryUtil.memAddress(renderbuffers));
/*  899 */       return renderbuffers.get(0);
/*      */     } finally {
/*  901 */       stack.setPointer(stackPointer);
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
/*      */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  922 */     if (Checks.CHECKS) {
/*  923 */       Checks.check(params, 1);
/*      */     }
/*  925 */     nglGetRenderbufferParameteriv(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetRenderbufferParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  931 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  933 */       IntBuffer params = stack.callocInt(1);
/*  934 */       nglGetRenderbufferParameteriv(target, pname, MemoryUtil.memAddress(params));
/*  935 */       return params.get(0);
/*      */     } finally {
/*  937 */       stack.setPointer(stackPointer);
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
/*      */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") IntBuffer framebuffers) {
/*  959 */     nglDeleteFramebuffers(framebuffers.remaining(), MemoryUtil.memAddress(framebuffers));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int framebuffer) {
/*  964 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  966 */       IntBuffer framebuffers = stack.ints(framebuffer);
/*  967 */       nglDeleteFramebuffers(1, MemoryUtil.memAddress(framebuffers));
/*      */     } finally {
/*  969 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenFramebuffers(@NativeType("GLuint *") IntBuffer framebuffers) {
/*  980 */     nglGenFramebuffers(framebuffers.remaining(), MemoryUtil.memAddress(framebuffers));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenFramebuffers() {
/*  986 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  988 */       IntBuffer framebuffers = stack.callocInt(1);
/*  989 */       nglGenFramebuffers(1, MemoryUtil.memAddress(framebuffers));
/*  990 */       return framebuffers.get(0);
/*      */     } finally {
/*  992 */       stack.setPointer(stackPointer);
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
/*      */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1034 */     if (Checks.CHECKS) {
/* 1035 */       Checks.check(params, 1);
/*      */     }
/* 1037 */     nglGetFramebufferAttachmentParameteriv(target, attachment, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetFramebufferAttachmentParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname) {
/* 1043 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1045 */       IntBuffer params = stack.callocInt(1);
/* 1046 */       nglGetFramebufferAttachmentParameteriv(target, attachment, pname, MemoryUtil.memAddress(params));
/* 1047 */       return params.get(0);
/*      */     } finally {
/* 1049 */       stack.setPointer(stackPointer);
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
/*      */   public static void glTexParameterIiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 1070 */     if (Checks.CHECKS) {
/* 1071 */       Checks.check(params, 1);
/*      */     }
/* 1073 */     nglTexParameterIiv(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameterIi(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int param) {
/* 1078 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1080 */       IntBuffer params = stack.ints(param);
/* 1081 */       nglTexParameterIiv(target, pname, MemoryUtil.memAddress(params));
/*      */     } finally {
/* 1083 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterIuiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint const *") IntBuffer params) {
/* 1094 */     if (Checks.CHECKS) {
/* 1095 */       Checks.check(params, 1);
/*      */     }
/* 1097 */     nglTexParameterIuiv(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameterIui(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int param) {
/* 1102 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1104 */       IntBuffer params = stack.ints(param);
/* 1105 */       nglTexParameterIuiv(target, pname, MemoryUtil.memAddress(params));
/*      */     } finally {
/* 1107 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterIiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1118 */     if (Checks.CHECKS) {
/* 1119 */       Checks.check(params, 1);
/*      */     }
/* 1121 */     nglGetTexParameterIiv(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTexParameterIi(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 1127 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1129 */       IntBuffer params = stack.callocInt(1);
/* 1130 */       nglGetTexParameterIiv(target, pname, MemoryUtil.memAddress(params));
/* 1131 */       return params.get(0);
/*      */     } finally {
/* 1133 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterIuiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 1144 */     if (Checks.CHECKS) {
/* 1145 */       Checks.check(params, 1);
/*      */     }
/* 1147 */     nglGetTexParameterIuiv(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTexParameterIui(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 1153 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1155 */       IntBuffer params = stack.callocInt(1);
/* 1156 */       nglGetTexParameterIuiv(target, pname, MemoryUtil.memAddress(params));
/* 1157 */       return params.get(0);
/*      */     } finally {
/* 1159 */       stack.setPointer(stackPointer);
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
/*      */   public static void glGetBooleani_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLboolean *") ByteBuffer data) {
/* 1175 */     if (Checks.CHECKS) {
/* 1176 */       Checks.check(data, 1);
/*      */     }
/* 1178 */     nglGetBooleani_v(target, index, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static boolean glGetBooleani(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1184 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1186 */       ByteBuffer data = stack.calloc(1);
/* 1187 */       nglGetBooleani_v(target, index, MemoryUtil.memAddress(data));
/* 1188 */       return (data.get(0) != 0);
/*      */     } finally {
/* 1190 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetIntegeri_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer data) {
/* 1201 */     if (Checks.CHECKS) {
/* 1202 */       Checks.check(data, 1);
/*      */     }
/* 1204 */     nglGetIntegeri_v(target, index, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetIntegeri(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1210 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1212 */       IntBuffer data = stack.callocInt(1);
/* 1213 */       nglGetIntegeri_v(target, index, MemoryUtil.memAddress(data));
/* 1214 */       return data.get(0);
/*      */     } finally {
/* 1216 */       stack.setPointer(stackPointer);
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
/*      */   public static void glTransformFeedbackVaryings(@NativeType("GLuint") int program, @NativeType("GLchar const * const *") PointerBuffer varyings, @NativeType("GLenum") int bufferMode) {
/* 1263 */     nglTransformFeedbackVaryings(program, varyings.remaining(), MemoryUtil.memAddress((CustomBuffer)varyings), bufferMode);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTransformFeedbackVaryings(@NativeType("GLuint") int program, @NativeType("GLchar const * const *") CharSequence[] varyings, @NativeType("GLenum") int bufferMode) {
/* 1268 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1270 */       long varyingsAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, varyings);
/* 1271 */       nglTransformFeedbackVaryings(program, varyings.length, varyingsAddress, bufferMode);
/* 1272 */       APIUtil.apiArrayFree(varyingsAddress, varyings.length);
/*      */     } finally {
/* 1274 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTransformFeedbackVaryings(@NativeType("GLuint") int program, @NativeType("GLchar const * const *") CharSequence varying, @NativeType("GLenum") int bufferMode) {
/* 1280 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1282 */       long varyingsAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, new CharSequence[] { varying });
/* 1283 */       nglTransformFeedbackVaryings(program, 1, varyingsAddress, bufferMode);
/* 1284 */       APIUtil.apiArrayFree(varyingsAddress, 1);
/*      */     } finally {
/* 1286 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackVarying(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLsizei *") IntBuffer size, @NativeType("GLenum *") IntBuffer type, @NativeType("GLchar *") ByteBuffer name) {
/* 1297 */     if (Checks.CHECKS) {
/* 1298 */       Checks.checkSafe(length, 1);
/* 1299 */       Checks.check(size, 1);
/* 1300 */       Checks.check(type, 1);
/*      */     } 
/* 1302 */     nglGetTransformFeedbackVarying(program, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetTransformFeedbackVarying(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei") int bufSize, @NativeType("GLsizei *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 1308 */     if (Checks.CHECKS) {
/* 1309 */       Checks.check(size, 1);
/* 1310 */       Checks.check(type, 1);
/*      */     } 
/* 1312 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1314 */       IntBuffer length = stack.ints(0);
/* 1315 */       ByteBuffer name = stack.malloc(bufSize);
/* 1316 */       nglGetTransformFeedbackVarying(program, index, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/* 1317 */       return MemoryUtil.memASCII(name, length.get(0));
/*      */     } finally {
/* 1319 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetTransformFeedbackVarying(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 1326 */     return glGetTransformFeedbackVarying(program, index, GL20.glGetProgrami(program, 35958), size, type);
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
/*      */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") IntBuffer arrays) {
/* 1341 */     nglDeleteVertexArrays(arrays.remaining(), MemoryUtil.memAddress(arrays));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int array) {
/* 1346 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1348 */       IntBuffer arrays = stack.ints(array);
/* 1349 */       nglDeleteVertexArrays(1, MemoryUtil.memAddress(arrays));
/*      */     } finally {
/* 1351 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenVertexArrays(@NativeType("GLuint *") IntBuffer arrays) {
/* 1362 */     nglGenVertexArrays(arrays.remaining(), MemoryUtil.memAddress(arrays));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenVertexArrays() {
/* 1368 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1370 */       IntBuffer arrays = stack.callocInt(1);
/* 1371 */       nglGenVertexArrays(1, MemoryUtil.memAddress(arrays));
/* 1372 */       return arrays.get(0);
/*      */     } finally {
/* 1374 */       stack.setPointer(stackPointer);
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
/*      */   public static void glClearBufferiv(@NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") int[] value) {
/* 1386 */     long __functionAddress = (GL.getICD()).glClearBufferiv;
/* 1387 */     if (Checks.CHECKS) {
/* 1388 */       Checks.check(__functionAddress);
/* 1389 */       Checks.check(value, 1);
/*      */     } 
/* 1391 */     JNI.callPV(buffer, drawbuffer, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferuiv(@NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLint const *") int[] value) {
/* 1396 */     long __functionAddress = (GL.getICD()).glClearBufferuiv;
/* 1397 */     if (Checks.CHECKS) {
/* 1398 */       Checks.check(__functionAddress);
/* 1399 */       Checks.check(value, 4);
/*      */     } 
/* 1401 */     JNI.callPV(buffer, drawbuffer, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferfv(@NativeType("GLenum") int buffer, @NativeType("GLint") int drawbuffer, @NativeType("GLfloat const *") float[] value) {
/* 1406 */     long __functionAddress = (GL.getICD()).glClearBufferfv;
/* 1407 */     if (Checks.CHECKS) {
/* 1408 */       Checks.check(__functionAddress);
/* 1409 */       Checks.check(value, 1);
/*      */     } 
/* 1411 */     JNI.callPV(buffer, drawbuffer, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI1iv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1416 */     long __functionAddress = (GL.getICD()).glVertexAttribI1iv;
/* 1417 */     if (Checks.CHECKS) {
/* 1418 */       Checks.check(__functionAddress);
/* 1419 */       Checks.check(v, 1);
/*      */     } 
/* 1421 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI2iv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1426 */     long __functionAddress = (GL.getICD()).glVertexAttribI2iv;
/* 1427 */     if (Checks.CHECKS) {
/* 1428 */       Checks.check(__functionAddress);
/* 1429 */       Checks.check(v, 2);
/*      */     } 
/* 1431 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI3iv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1436 */     long __functionAddress = (GL.getICD()).glVertexAttribI3iv;
/* 1437 */     if (Checks.CHECKS) {
/* 1438 */       Checks.check(__functionAddress);
/* 1439 */       Checks.check(v, 3);
/*      */     } 
/* 1441 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4iv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1446 */     long __functionAddress = (GL.getICD()).glVertexAttribI4iv;
/* 1447 */     if (Checks.CHECKS) {
/* 1448 */       Checks.check(__functionAddress);
/* 1449 */       Checks.check(v, 4);
/*      */     } 
/* 1451 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI1uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 1456 */     long __functionAddress = (GL.getICD()).glVertexAttribI1uiv;
/* 1457 */     if (Checks.CHECKS) {
/* 1458 */       Checks.check(__functionAddress);
/* 1459 */       Checks.check(v, 1);
/*      */     } 
/* 1461 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI2uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 1466 */     long __functionAddress = (GL.getICD()).glVertexAttribI2uiv;
/* 1467 */     if (Checks.CHECKS) {
/* 1468 */       Checks.check(__functionAddress);
/* 1469 */       Checks.check(v, 2);
/*      */     } 
/* 1471 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI3uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 1476 */     long __functionAddress = (GL.getICD()).glVertexAttribI3uiv;
/* 1477 */     if (Checks.CHECKS) {
/* 1478 */       Checks.check(__functionAddress);
/* 1479 */       Checks.check(v, 3);
/*      */     } 
/* 1481 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 1486 */     long __functionAddress = (GL.getICD()).glVertexAttribI4uiv;
/* 1487 */     if (Checks.CHECKS) {
/* 1488 */       Checks.check(__functionAddress);
/* 1489 */       Checks.check(v, 4);
/*      */     } 
/* 1491 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1496 */     long __functionAddress = (GL.getICD()).glVertexAttribI4sv;
/* 1497 */     if (Checks.CHECKS) {
/* 1498 */       Checks.check(__functionAddress);
/* 1499 */       Checks.check(v, 4);
/*      */     } 
/* 1501 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4usv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1506 */     long __functionAddress = (GL.getICD()).glVertexAttribI4usv;
/* 1507 */     if (Checks.CHECKS) {
/* 1508 */       Checks.check(__functionAddress);
/* 1509 */       Checks.check(v, 4);
/*      */     } 
/* 1511 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribIiv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1516 */     long __functionAddress = (GL.getICD()).glGetVertexAttribIiv;
/* 1517 */     if (Checks.CHECKS) {
/* 1518 */       Checks.check(__functionAddress);
/* 1519 */       Checks.check(params, 4);
/*      */     } 
/* 1521 */     JNI.callPV(index, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribIuiv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 1526 */     long __functionAddress = (GL.getICD()).glGetVertexAttribIuiv;
/* 1527 */     if (Checks.CHECKS) {
/* 1528 */       Checks.check(__functionAddress);
/* 1529 */       Checks.check(params, 4);
/*      */     } 
/* 1531 */     JNI.callPV(index, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform1uiv(@NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1536 */     long __functionAddress = (GL.getICD()).glUniform1uiv;
/* 1537 */     if (Checks.CHECKS) {
/* 1538 */       Checks.check(__functionAddress);
/*      */     }
/* 1540 */     JNI.callPV(location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform2uiv(@NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1545 */     long __functionAddress = (GL.getICD()).glUniform2uiv;
/* 1546 */     if (Checks.CHECKS) {
/* 1547 */       Checks.check(__functionAddress);
/*      */     }
/* 1549 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform3uiv(@NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1554 */     long __functionAddress = (GL.getICD()).glUniform3uiv;
/* 1555 */     if (Checks.CHECKS) {
/* 1556 */       Checks.check(__functionAddress);
/*      */     }
/* 1558 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform4uiv(@NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1563 */     long __functionAddress = (GL.getICD()).glUniform4uiv;
/* 1564 */     if (Checks.CHECKS) {
/* 1565 */       Checks.check(__functionAddress);
/*      */     }
/* 1567 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetUniformuiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint *") int[] params) {
/* 1572 */     long __functionAddress = (GL.getICD()).glGetUniformuiv;
/* 1573 */     if (Checks.CHECKS) {
/* 1574 */       Checks.check(__functionAddress);
/* 1575 */       Checks.check(params, 1);
/*      */     } 
/* 1577 */     JNI.callPV(program, location, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int[] renderbuffers) {
/* 1582 */     long __functionAddress = (GL.getICD()).glDeleteRenderbuffers;
/* 1583 */     if (Checks.CHECKS) {
/* 1584 */       Checks.check(__functionAddress);
/*      */     }
/* 1586 */     JNI.callPV(renderbuffers.length, renderbuffers, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenRenderbuffers(@NativeType("GLuint *") int[] renderbuffers) {
/* 1591 */     long __functionAddress = (GL.getICD()).glGenRenderbuffers;
/* 1592 */     if (Checks.CHECKS) {
/* 1593 */       Checks.check(__functionAddress);
/*      */     }
/* 1595 */     JNI.callPV(renderbuffers.length, renderbuffers, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1600 */     long __functionAddress = (GL.getICD()).glGetRenderbufferParameteriv;
/* 1601 */     if (Checks.CHECKS) {
/* 1602 */       Checks.check(__functionAddress);
/* 1603 */       Checks.check(params, 1);
/*      */     } 
/* 1605 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int[] framebuffers) {
/* 1610 */     long __functionAddress = (GL.getICD()).glDeleteFramebuffers;
/* 1611 */     if (Checks.CHECKS) {
/* 1612 */       Checks.check(__functionAddress);
/*      */     }
/* 1614 */     JNI.callPV(framebuffers.length, framebuffers, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenFramebuffers(@NativeType("GLuint *") int[] framebuffers) {
/* 1619 */     long __functionAddress = (GL.getICD()).glGenFramebuffers;
/* 1620 */     if (Checks.CHECKS) {
/* 1621 */       Checks.check(__functionAddress);
/*      */     }
/* 1623 */     JNI.callPV(framebuffers.length, framebuffers, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1628 */     long __functionAddress = (GL.getICD()).glGetFramebufferAttachmentParameteriv;
/* 1629 */     if (Checks.CHECKS) {
/* 1630 */       Checks.check(__functionAddress);
/* 1631 */       Checks.check(params, 1);
/*      */     } 
/* 1633 */     JNI.callPV(target, attachment, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameterIiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 1638 */     long __functionAddress = (GL.getICD()).glTexParameterIiv;
/* 1639 */     if (Checks.CHECKS) {
/* 1640 */       Checks.check(__functionAddress);
/* 1641 */       Checks.check(params, 1);
/*      */     } 
/* 1643 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameterIuiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int[] params) {
/* 1648 */     long __functionAddress = (GL.getICD()).glTexParameterIuiv;
/* 1649 */     if (Checks.CHECKS) {
/* 1650 */       Checks.check(__functionAddress);
/* 1651 */       Checks.check(params, 1);
/*      */     } 
/* 1653 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterIiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1658 */     long __functionAddress = (GL.getICD()).glGetTexParameterIiv;
/* 1659 */     if (Checks.CHECKS) {
/* 1660 */       Checks.check(__functionAddress);
/* 1661 */       Checks.check(params, 1);
/*      */     } 
/* 1663 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterIuiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 1668 */     long __functionAddress = (GL.getICD()).glGetTexParameterIuiv;
/* 1669 */     if (Checks.CHECKS) {
/* 1670 */       Checks.check(__functionAddress);
/* 1671 */       Checks.check(params, 1);
/*      */     } 
/* 1673 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetIntegeri_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLint *") int[] data) {
/* 1678 */     long __functionAddress = (GL.getICD()).glGetIntegeri_v;
/* 1679 */     if (Checks.CHECKS) {
/* 1680 */       Checks.check(__functionAddress);
/* 1681 */       Checks.check(data, 1);
/*      */     } 
/* 1683 */     JNI.callPV(target, index, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackVarying(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLsizei *") int[] size, @NativeType("GLenum *") int[] type, @NativeType("GLchar *") ByteBuffer name) {
/* 1688 */     long __functionAddress = (GL.getICD()).glGetTransformFeedbackVarying;
/* 1689 */     if (Checks.CHECKS) {
/* 1690 */       Checks.check(__functionAddress);
/* 1691 */       Checks.checkSafe(length, 1);
/* 1692 */       Checks.check(size, 1);
/* 1693 */       Checks.check(type, 1);
/*      */     } 
/* 1695 */     JNI.callPPPPV(program, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int[] arrays) {
/* 1700 */     long __functionAddress = (GL.getICD()).glDeleteVertexArrays;
/* 1701 */     if (Checks.CHECKS) {
/* 1702 */       Checks.check(__functionAddress);
/*      */     }
/* 1704 */     JNI.callPV(arrays.length, arrays, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenVertexArrays(@NativeType("GLuint *") int[] arrays) {
/* 1709 */     long __functionAddress = (GL.getICD()).glGenVertexArrays;
/* 1710 */     if (Checks.CHECKS) {
/* 1711 */       Checks.check(__functionAddress);
/*      */     }
/* 1713 */     JNI.callPV(arrays.length, arrays, __functionAddress);
/*      */   }
/*      */   
/*      */   public static native long nglGetStringi(int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nglClearBufferiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglClearBufferuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglClearBufferfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glClearBufferfi(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribI1i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glVertexAttribI2i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribI3i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribI4i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glVertexAttribI1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexAttribI2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribI3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribI4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void nglVertexAttribI1iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI2iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI3iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI1uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI2uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI3uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4bv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4ubv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4usv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribIPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glUniform1ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glUniform2ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glUniform3ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glUniform4ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void nglUniform1uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform2uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform3uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform4uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetUniformuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglBindFragDataLocation(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native int nglGetFragDataLocation(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glBeginConditionalRender(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glEndConditionalRender();
/*      */   
/*      */   public static native long nglMapBufferRange(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void glFlushMappedBufferRange(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glClampColor(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsRenderbuffer(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glBindRenderbuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglDeleteRenderbuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenRenderbuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glRenderbufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void glRenderbufferStorageMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void nglGetRenderbufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsFramebuffer(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glBindFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglDeleteFramebuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenFramebuffers(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glCheckFramebufferStatus(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glFramebufferTexture1D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glFramebufferTexture2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glFramebufferTexture3D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*      */   
/*      */   public static native void glFramebufferTextureLayer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glFramebufferRenderbuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void nglGetFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glBlitFramebuffer(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLbitfield") int paramInt9, @NativeType("GLenum") int paramInt10);
/*      */   
/*      */   public static native void glGenerateMipmap(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglTexParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglTexParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glColorMaski(@NativeType("GLuint") int paramInt, @NativeType("GLboolean") boolean paramBoolean1, @NativeType("GLboolean") boolean paramBoolean2, @NativeType("GLboolean") boolean paramBoolean3, @NativeType("GLboolean") boolean paramBoolean4);
/*      */   
/*      */   public static native void nglGetBooleani_v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetIntegeri_v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glEnablei(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDisablei(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsEnabledi(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glBindBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glBindBufferBase(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glBeginTransformFeedback(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glEndTransformFeedback();
/*      */   
/*      */   public static native void nglTransformFeedbackVaryings(int paramInt1, int paramInt2, long paramLong, int paramInt3);
/*      */   
/*      */   public static native void nglGetTransformFeedbackVarying(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void glBindVertexArray(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglDeleteVertexArrays(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenVertexArrays(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsVertexArray(@NativeType("GLuint") int paramInt);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL30C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */