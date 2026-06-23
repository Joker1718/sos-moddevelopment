/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Pointer;
/*      */ 
/*      */ public class GL43C
/*      */   extends GL42C {
/*      */   public static final int GL_NUM_SHADING_LANGUAGE_VERSIONS = 33513;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_LONG = 34638;
/*      */   
/*      */   static {
/*   21 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_COMPRESSED_RGB8_ETC2 = 37492;
/*      */   
/*      */   public static final int GL_COMPRESSED_SRGB8_ETC2 = 37493;
/*      */   
/*      */   public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37494;
/*      */   
/*      */   public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37495;
/*      */   
/*      */   public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 37496;
/*      */   
/*      */   public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 37497;
/*      */   
/*      */   public static final int GL_COMPRESSED_R11_EAC = 37488;
/*      */   
/*      */   public static final int GL_COMPRESSED_SIGNED_R11_EAC = 37489;
/*      */   
/*      */   public static final int GL_COMPRESSED_RG11_EAC = 37490;
/*      */   
/*      */   public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 37491;
/*      */   
/*      */   public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 36201;
/*      */   
/*      */   public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 36202;
/*      */   
/*      */   public static final int GL_MAX_ELEMENT_INDEX = 36203;
/*      */   
/*      */   public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503;
/*      */   
/*      */   public static final int GL_COMPUTE_SHADER = 37305;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 37307;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 37308;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 37309;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 33378;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 33379;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 33380;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 33381;
/*      */   
/*      */   public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 33382;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 37099;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 37310;
/*      */   
/*      */   public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 37311;
/*      */   
/*      */   public static final int GL_COMPUTE_WORK_GROUP_SIZE = 33383;
/*      */   
/*      */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 37100;
/*      */   
/*      */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 37101;
/*      */   
/*      */   public static final int GL_DISPATCH_INDIRECT_BUFFER = 37102;
/*      */   
/*      */   public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 37103;
/*      */   
/*      */   public static final int GL_COMPUTE_SHADER_BIT = 32;
/*      */   
/*      */   public static final int GL_DEBUG_OUTPUT = 37600;
/*      */   
/*      */   public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
/*      */   
/*      */   public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
/*      */   
/*      */   public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
/*      */   
/*      */   public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
/*      */   
/*      */   public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
/*      */   
/*      */   public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
/*      */   
/*      */   public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
/*      */   
/*      */   public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
/*      */   
/*      */   public static final int GL_MAX_LABEL_LENGTH = 33512;
/*      */   
/*      */   public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
/*      */   
/*      */   public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_API = 33350;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_OTHER = 33355;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_ERROR = 33356;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_OTHER = 33361;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_MARKER = 33384;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
/*      */   
/*      */   public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
/*      */   
/*      */   public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
/*      */   
/*      */   public static final int GL_DEBUG_SEVERITY_LOW = 37192;
/*      */   
/*      */   public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
/*      */   
/*      */   public static final int GL_BUFFER = 33504;
/*      */   
/*      */   public static final int GL_SHADER = 33505;
/*      */   
/*      */   public static final int GL_PROGRAM = 33506;
/*      */   
/*      */   public static final int GL_QUERY = 33507;
/*      */   
/*      */   public static final int GL_PROGRAM_PIPELINE = 33508;
/*      */   
/*      */   public static final int GL_SAMPLER = 33510;
/*      */   
/*      */   public static final int GL_MAX_UNIFORM_LOCATIONS = 33390;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
/*      */   public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
/*      */   public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
/*      */   public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
/*      */   public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;
/*      */   public static final int GL_INTERNALFORMAT_SUPPORTED = 33391;
/*      */   public static final int GL_INTERNALFORMAT_PREFERRED = 33392;
/*      */   public static final int GL_INTERNALFORMAT_RED_SIZE = 33393;
/*      */   public static final int GL_INTERNALFORMAT_GREEN_SIZE = 33394;
/*      */   public static final int GL_INTERNALFORMAT_BLUE_SIZE = 33395;
/*      */   public static final int GL_INTERNALFORMAT_ALPHA_SIZE = 33396;
/*      */   public static final int GL_INTERNALFORMAT_DEPTH_SIZE = 33397;
/*      */   public static final int GL_INTERNALFORMAT_STENCIL_SIZE = 33398;
/*      */   public static final int GL_INTERNALFORMAT_SHARED_SIZE = 33399;
/*      */   public static final int GL_INTERNALFORMAT_RED_TYPE = 33400;
/*      */   public static final int GL_INTERNALFORMAT_GREEN_TYPE = 33401;
/*      */   public static final int GL_INTERNALFORMAT_BLUE_TYPE = 33402;
/*      */   public static final int GL_INTERNALFORMAT_ALPHA_TYPE = 33403;
/*      */   public static final int GL_INTERNALFORMAT_DEPTH_TYPE = 33404;
/*      */   public static final int GL_INTERNALFORMAT_STENCIL_TYPE = 33405;
/*      */   public static final int GL_MAX_WIDTH = 33406;
/*      */   public static final int GL_MAX_HEIGHT = 33407;
/*      */   public static final int GL_MAX_DEPTH = 33408;
/*      */   public static final int GL_MAX_LAYERS = 33409;
/*      */   public static final int GL_MAX_COMBINED_DIMENSIONS = 33410;
/*      */   public static final int GL_COLOR_COMPONENTS = 33411;
/*      */   public static final int GL_DEPTH_COMPONENTS = 33412;
/*      */   public static final int GL_STENCIL_COMPONENTS = 33413;
/*      */   public static final int GL_COLOR_RENDERABLE = 33414;
/*      */   public static final int GL_DEPTH_RENDERABLE = 33415;
/*      */   public static final int GL_STENCIL_RENDERABLE = 33416;
/*      */   public static final int GL_FRAMEBUFFER_RENDERABLE = 33417;
/*      */   public static final int GL_FRAMEBUFFER_RENDERABLE_LAYERED = 33418;
/*      */   public static final int GL_FRAMEBUFFER_BLEND = 33419;
/*      */   public static final int GL_READ_PIXELS = 33420;
/*      */   public static final int GL_READ_PIXELS_FORMAT = 33421;
/*      */   public static final int GL_READ_PIXELS_TYPE = 33422;
/*      */   public static final int GL_TEXTURE_IMAGE_FORMAT = 33423;
/*      */   public static final int GL_TEXTURE_IMAGE_TYPE = 33424;
/*      */   public static final int GL_GET_TEXTURE_IMAGE_FORMAT = 33425;
/*      */   public static final int GL_GET_TEXTURE_IMAGE_TYPE = 33426;
/*      */   public static final int GL_MIPMAP = 33427;
/*      */   public static final int GL_MANUAL_GENERATE_MIPMAP = 33428;
/*      */   public static final int GL_AUTO_GENERATE_MIPMAP = 33429;
/*      */   public static final int GL_COLOR_ENCODING = 33430;
/*      */   public static final int GL_SRGB_READ = 33431;
/*      */   public static final int GL_SRGB_WRITE = 33432;
/*      */   public static final int GL_FILTER = 33434;
/*      */   public static final int GL_VERTEX_TEXTURE = 33435;
/*      */   public static final int GL_TESS_CONTROL_TEXTURE = 33436;
/*      */   public static final int GL_TESS_EVALUATION_TEXTURE = 33437;
/*      */   public static final int GL_GEOMETRY_TEXTURE = 33438;
/*      */   public static final int GL_FRAGMENT_TEXTURE = 33439;
/*      */   public static final int GL_COMPUTE_TEXTURE = 33440;
/*      */   public static final int GL_TEXTURE_SHADOW = 33441;
/*      */   public static final int GL_TEXTURE_GATHER = 33442;
/*      */   public static final int GL_TEXTURE_GATHER_SHADOW = 33443;
/*      */   public static final int GL_SHADER_IMAGE_LOAD = 33444;
/*      */   public static final int GL_SHADER_IMAGE_STORE = 33445;
/*      */   public static final int GL_SHADER_IMAGE_ATOMIC = 33446;
/*      */   public static final int GL_IMAGE_TEXEL_SIZE = 33447;
/*      */   public static final int GL_IMAGE_COMPATIBILITY_CLASS = 33448;
/*      */   public static final int GL_IMAGE_PIXEL_FORMAT = 33449;
/*      */   public static final int GL_IMAGE_PIXEL_TYPE = 33450;
/*      */   public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = 33452;
/*      */   public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = 33453;
/*      */   public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = 33454;
/*      */   public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = 33455;
/*      */   public static final int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH = 33457;
/*      */   public static final int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT = 33458;
/*      */   public static final int GL_TEXTURE_COMPRESSED_BLOCK_SIZE = 33459;
/*      */   public static final int GL_CLEAR_BUFFER = 33460;
/*      */   public static final int GL_TEXTURE_VIEW = 33461;
/*      */   public static final int GL_VIEW_COMPATIBILITY_CLASS = 33462;
/*      */   public static final int GL_FULL_SUPPORT = 33463;
/*      */   public static final int GL_CAVEAT_SUPPORT = 33464;
/*      */   public static final int GL_IMAGE_CLASS_4_X_32 = 33465;
/*      */   public static final int GL_IMAGE_CLASS_2_X_32 = 33466;
/*      */   public static final int GL_IMAGE_CLASS_1_X_32 = 33467;
/*      */   public static final int GL_IMAGE_CLASS_4_X_16 = 33468;
/*      */   public static final int GL_IMAGE_CLASS_2_X_16 = 33469;
/*      */   public static final int GL_IMAGE_CLASS_1_X_16 = 33470;
/*      */   public static final int GL_IMAGE_CLASS_4_X_8 = 33471;
/*      */   public static final int GL_IMAGE_CLASS_2_X_8 = 33472;
/*      */   public static final int GL_IMAGE_CLASS_1_X_8 = 33473;
/*      */   public static final int GL_IMAGE_CLASS_11_11_10 = 33474;
/*      */   public static final int GL_IMAGE_CLASS_10_10_10_2 = 33475;
/*      */   public static final int GL_VIEW_CLASS_128_BITS = 33476;
/*      */   public static final int GL_VIEW_CLASS_96_BITS = 33477;
/*      */   public static final int GL_VIEW_CLASS_64_BITS = 33478;
/*      */   public static final int GL_VIEW_CLASS_48_BITS = 33479;
/*      */   public static final int GL_VIEW_CLASS_32_BITS = 33480;
/*      */   public static final int GL_VIEW_CLASS_24_BITS = 33481;
/*      */   public static final int GL_VIEW_CLASS_16_BITS = 33482;
/*      */   public static final int GL_VIEW_CLASS_8_BITS = 33483;
/*      */   public static final int GL_VIEW_CLASS_S3TC_DXT1_RGB = 33484;
/*      */   public static final int GL_VIEW_CLASS_S3TC_DXT1_RGBA = 33485;
/*      */   public static final int GL_VIEW_CLASS_S3TC_DXT3_RGBA = 33486;
/*      */   public static final int GL_VIEW_CLASS_S3TC_DXT5_RGBA = 33487;
/*      */   public static final int GL_VIEW_CLASS_RGTC1_RED = 33488;
/*      */   public static final int GL_VIEW_CLASS_RGTC2_RG = 33489;
/*      */   public static final int GL_VIEW_CLASS_BPTC_UNORM = 33490;
/*      */   public static final int GL_VIEW_CLASS_BPTC_FLOAT = 33491;
/*      */   public static final int GL_UNIFORM = 37601;
/*      */   public static final int GL_UNIFORM_BLOCK = 37602;
/*      */   public static final int GL_PROGRAM_INPUT = 37603;
/*      */   public static final int GL_PROGRAM_OUTPUT = 37604;
/*      */   public static final int GL_BUFFER_VARIABLE = 37605;
/*      */   public static final int GL_SHADER_STORAGE_BLOCK = 37606;
/*      */   public static final int GL_VERTEX_SUBROUTINE = 37608;
/*      */   public static final int GL_TESS_CONTROL_SUBROUTINE = 37609;
/*      */   public static final int GL_TESS_EVALUATION_SUBROUTINE = 37610;
/*      */   public static final int GL_GEOMETRY_SUBROUTINE = 37611;
/*      */   public static final int GL_FRAGMENT_SUBROUTINE = 37612;
/*      */   public static final int GL_COMPUTE_SUBROUTINE = 37613;
/*      */   public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 37614;
/*      */   public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 37615;
/*      */   public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 37616;
/*      */   public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 37617;
/*      */   public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 37618;
/*      */   public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 37619;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_VARYING = 37620;
/*      */   public static final int GL_ACTIVE_RESOURCES = 37621;
/*      */   public static final int GL_MAX_NAME_LENGTH = 37622;
/*      */   public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 37623;
/*      */   public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 37624;
/*      */   public static final int GL_NAME_LENGTH = 37625;
/*      */   public static final int GL_TYPE = 37626;
/*      */   public static final int GL_ARRAY_SIZE = 37627;
/*      */   public static final int GL_OFFSET = 37628;
/*      */   public static final int GL_BLOCK_INDEX = 37629;
/*      */   public static final int GL_ARRAY_STRIDE = 37630;
/*      */   public static final int GL_MATRIX_STRIDE = 37631;
/*      */   public static final int GL_IS_ROW_MAJOR = 37632;
/*      */   public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 37633;
/*      */   public static final int GL_BUFFER_BINDING = 37634;
/*      */   public static final int GL_BUFFER_DATA_SIZE = 37635;
/*      */   public static final int GL_NUM_ACTIVE_VARIABLES = 37636;
/*      */   public static final int GL_ACTIVE_VARIABLES = 37637;
/*      */   public static final int GL_REFERENCED_BY_VERTEX_SHADER = 37638;
/*      */   public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639;
/*      */   public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640;
/*      */   public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641;
/*      */   public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 37642;
/*      */   public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 37643;
/*      */   public static final int GL_TOP_LEVEL_ARRAY_SIZE = 37644;
/*      */   public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 37645;
/*      */   public static final int GL_LOCATION = 37646;
/*      */   public static final int GL_LOCATION_INDEX = 37647;
/*      */   public static final int GL_IS_PER_PATCH = 37607;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER = 37074;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 37075;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER_START = 37076;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 37077;
/*      */   public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 37078;
/*      */   public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 37079;
/*      */   public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 37080;
/*      */   public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 37081;
/*      */   public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 37082;
/*      */   public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 37083;
/*      */   public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 37084;
/*      */   public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 37085;
/*      */   public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 37086;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 37087;
/*      */   public static final int GL_SHADER_STORAGE_BARRIER_BIT = 8192;
/*      */   public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 36665;
/*      */   public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 37098;
/*      */   public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
/*      */   public static final int GL_TEXTURE_BUFFER_SIZE = 37278;
/*      */   public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;
/*      */   public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499;
/*      */   public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500;
/*      */   public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501;
/*      */   public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502;
/*      */   public static final int GL_VERTEX_ATTRIB_BINDING = 33492;
/*      */   public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493;
/*      */   public static final int GL_VERTEX_BINDING_DIVISOR = 33494;
/*      */   public static final int GL_VERTEX_BINDING_OFFSET = 33495;
/*      */   public static final int GL_VERTEX_BINDING_STRIDE = 33496;
/*      */   public static final int GL_VERTEX_BINDING_BUFFER = 36687;
/*      */   public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497;
/*      */   public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498;
/*      */   
/*      */   protected GL43C() {
/*  353 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  363 */     nglClearBufferData(target, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  368 */     nglClearBufferData(target, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  373 */     nglClearBufferData(target, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  378 */     nglClearBufferData(target, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  388 */     nglClearBufferSubData(target, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  393 */     nglClearBufferSubData(target, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  398 */     nglClearBufferSubData(target, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  403 */     nglClearBufferSubData(target, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
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
/*      */   public static void glDebugMessageControl(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @NativeType("GLuint const *") IntBuffer ids, @NativeType("GLboolean") boolean enabled) {
/*  428 */     nglDebugMessageControl(source, type, severity, Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids), enabled);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDebugMessageControl(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @NativeType("GLuint const *") int id, @NativeType("GLboolean") boolean enabled) {
/*  433 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  435 */       IntBuffer ids = stack.ints(id);
/*  436 */       nglDebugMessageControl(source, type, severity, 1, MemoryUtil.memAddress(ids), enabled);
/*      */     } finally {
/*  438 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDebugMessageInsert(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLuint") int id, @NativeType("GLenum") int severity, @NativeType("GLchar const *") ByteBuffer message) {
/*  449 */     nglDebugMessageInsert(source, type, id, severity, message.remaining(), MemoryUtil.memAddress(message));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDebugMessageInsert(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLuint") int id, @NativeType("GLenum") int severity, @NativeType("GLchar const *") CharSequence message) {
/*  454 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  456 */       int messageEncodedLength = stack.nUTF8(message, false);
/*  457 */       long messageEncoded = stack.getPointerAddress();
/*  458 */       nglDebugMessageInsert(source, type, id, severity, messageEncodedLength, messageEncoded);
/*      */     } finally {
/*  460 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDebugMessageCallback(@NativeType("GLDEBUGPROC") GLDebugMessageCallbackI callback, @NativeType("void const *") long userParam) {
/*  471 */     nglDebugMessageCallback(MemoryUtil.memAddressSafe((Pointer)callback), userParam);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glGetDebugMessageLog(@NativeType("GLuint") int count, @NativeType("GLenum *") IntBuffer sources, @NativeType("GLenum *") IntBuffer types, @NativeType("GLuint *") IntBuffer ids, @NativeType("GLenum *") IntBuffer severities, @NativeType("GLsizei *") IntBuffer lengths, @NativeType("GLchar *") ByteBuffer messageLog) {
/*  482 */     if (Checks.CHECKS) {
/*  483 */       Checks.checkSafe(sources, count);
/*  484 */       Checks.checkSafe(types, count);
/*  485 */       Checks.checkSafe(ids, count);
/*  486 */       Checks.checkSafe(severities, count);
/*  487 */       Checks.checkSafe(lengths, count);
/*      */     } 
/*  489 */     return nglGetDebugMessageLog(count, Checks.remainingSafe(messageLog), MemoryUtil.memAddressSafe(sources), MemoryUtil.memAddressSafe(types), MemoryUtil.memAddressSafe(ids), MemoryUtil.memAddressSafe(severities), MemoryUtil.memAddressSafe(lengths), MemoryUtil.memAddressSafe(messageLog));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPushDebugGroup(@NativeType("GLenum") int source, @NativeType("GLuint") int id, @NativeType("GLchar const *") ByteBuffer message) {
/*  499 */     nglPushDebugGroup(source, id, message.remaining(), MemoryUtil.memAddress(message));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPushDebugGroup(@NativeType("GLenum") int source, @NativeType("GLuint") int id, @NativeType("GLchar const *") CharSequence message) {
/*  504 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  506 */       int messageEncodedLength = stack.nUTF8(message, false);
/*  507 */       long messageEncoded = stack.getPointerAddress();
/*  508 */       nglPushDebugGroup(source, id, messageEncodedLength, messageEncoded);
/*      */     } finally {
/*  510 */       stack.setPointer(stackPointer);
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
/*      */   public static void glObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLchar const *") ByteBuffer label) {
/*  526 */     nglObjectLabel(identifier, name, label.remaining(), MemoryUtil.memAddress(label));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLchar const *") CharSequence label) {
/*  531 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  533 */       int labelEncodedLength = stack.nUTF8(label, false);
/*  534 */       long labelEncoded = stack.getPointerAddress();
/*  535 */       nglObjectLabel(identifier, name, labelEncodedLength, labelEncoded);
/*      */     } finally {
/*  537 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer label) {
/*  548 */     if (Checks.CHECKS) {
/*  549 */       Checks.checkSafe(length, 1);
/*      */     }
/*  551 */     nglGetObjectLabel(identifier, name, label.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(label));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLsizei") int bufSize) {
/*  557 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  559 */       IntBuffer length = stack.ints(0);
/*  560 */       ByteBuffer label = stack.malloc(bufSize);
/*  561 */       nglGetObjectLabel(identifier, name, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(label));
/*  562 */       return MemoryUtil.memUTF8(label, length.get(0));
/*      */     } finally {
/*  564 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name) {
/*  571 */     return glGetObjectLabel(identifier, name, GL11.glGetInteger(33512));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLchar const *") ByteBuffer label) {
/*  581 */     if (Checks.CHECKS) {
/*  582 */       Checks.check(ptr);
/*      */     }
/*  584 */     nglObjectPtrLabel(ptr, label.remaining(), MemoryUtil.memAddress(label));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLchar const *") CharSequence label) {
/*  589 */     if (Checks.CHECKS) {
/*  590 */       Checks.check(ptr);
/*      */     }
/*  592 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  594 */       int labelEncodedLength = stack.nUTF8(label, false);
/*  595 */       long labelEncoded = stack.getPointerAddress();
/*  596 */       nglObjectPtrLabel(ptr, labelEncodedLength, labelEncoded);
/*      */     } finally {
/*  598 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer label) {
/*  609 */     if (Checks.CHECKS) {
/*  610 */       Checks.check(ptr);
/*  611 */       Checks.checkSafe(length, 1);
/*      */     } 
/*  613 */     nglGetObjectPtrLabel(ptr, label.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(label));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLsizei") int bufSize) {
/*  619 */     if (Checks.CHECKS) {
/*  620 */       Checks.check(ptr);
/*      */     }
/*  622 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  624 */       IntBuffer length = stack.ints(0);
/*  625 */       ByteBuffer label = stack.malloc(bufSize);
/*  626 */       nglGetObjectPtrLabel(ptr, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(label));
/*  627 */       return MemoryUtil.memUTF8(label, length.get(0));
/*      */     } finally {
/*  629 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetObjectPtrLabel(@NativeType("void *") long ptr) {
/*  636 */     return glGetObjectPtrLabel(ptr, GL11.glGetInteger(33512));
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
/*      */   public static void glGetFramebufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  651 */     if (Checks.CHECKS) {
/*  652 */       Checks.check(params, 1);
/*      */     }
/*  654 */     nglGetFramebufferParameteriv(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetFramebufferParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  660 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  662 */       IntBuffer params = stack.callocInt(1);
/*  663 */       nglGetFramebufferParameteriv(target, pname, MemoryUtil.memAddress(params));
/*  664 */       return params.get(0);
/*      */     } finally {
/*  666 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetInternalformati64v(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/*  677 */     nglGetInternalformati64v(target, internalformat, pname, params.remaining(), MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetInternalformati64(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname) {
/*  683 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  685 */       LongBuffer params = stack.callocLong(1);
/*  686 */       nglGetInternalformati64v(target, internalformat, pname, 1, MemoryUtil.memAddress(params));
/*  687 */       return params.get(0);
/*      */     } finally {
/*  689 */       stack.setPointer(stackPointer);
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
/*      */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") IntBuffer attachments) {
/*  720 */     nglInvalidateFramebuffer(target, attachments.remaining(), MemoryUtil.memAddress(attachments));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int attachment) {
/*  725 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  727 */       IntBuffer attachments = stack.ints(attachment);
/*  728 */       nglInvalidateFramebuffer(target, 1, MemoryUtil.memAddress(attachments));
/*      */     } finally {
/*  730 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") IntBuffer attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  741 */     nglInvalidateSubFramebuffer(target, attachments.remaining(), MemoryUtil.memAddress(attachments), x, y, width, height);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int attachment, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  746 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  748 */       IntBuffer attachments = stack.ints(attachment);
/*  749 */       nglInvalidateSubFramebuffer(target, 1, MemoryUtil.memAddress(attachments), x, y, width, height);
/*      */     } finally {
/*  751 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/*  762 */     if (Checks.CHECKS) {
/*  763 */       Checks.check(indirect, drawcount * ((stride == 0) ? 16 : stride));
/*      */     }
/*  765 */     nglMultiDrawArraysIndirect(mode, MemoryUtil.memAddress(indirect), drawcount, stride);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/*  770 */     nglMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/*  775 */     if (Checks.CHECKS) {
/*  776 */       Checks.check(indirect, drawcount * ((stride == 0) ? 16 : stride) >> 2);
/*      */     }
/*  778 */     nglMultiDrawArraysIndirect(mode, MemoryUtil.memAddress(indirect), drawcount, stride);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/*  788 */     if (Checks.CHECKS) {
/*  789 */       Checks.check(indirect, drawcount * ((stride == 0) ? 20 : stride));
/*      */     }
/*  791 */     nglMultiDrawElementsIndirect(mode, type, MemoryUtil.memAddress(indirect), drawcount, stride);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/*  796 */     nglMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/*  801 */     if (Checks.CHECKS) {
/*  802 */       Checks.check(indirect, drawcount * ((stride == 0) ? 20 : stride) >> 2);
/*      */     }
/*  804 */     nglMultiDrawElementsIndirect(mode, type, MemoryUtil.memAddress(indirect), drawcount, stride);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramInterfaceiv(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  814 */     if (Checks.CHECKS) {
/*  815 */       Checks.check(params, 1);
/*      */     }
/*  817 */     nglGetProgramInterfaceiv(program, programInterface, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetProgramInterfacei(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLenum") int pname) {
/*  823 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  825 */       IntBuffer params = stack.callocInt(1);
/*  826 */       nglGetProgramInterfaceiv(program, programInterface, pname, MemoryUtil.memAddress(params));
/*  827 */       return params.get(0);
/*      */     } finally {
/*  829 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glGetProgramResourceIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") ByteBuffer name) {
/*  841 */     if (Checks.CHECKS) {
/*  842 */       Checks.checkNT1(name);
/*      */     }
/*  844 */     return nglGetProgramResourceIndex(program, programInterface, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glGetProgramResourceIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") CharSequence name) {
/*  850 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  852 */       stack.nUTF8(name, true);
/*  853 */       long nameEncoded = stack.getPointerAddress();
/*  854 */       return nglGetProgramResourceIndex(program, programInterface, nameEncoded);
/*      */     } finally {
/*  856 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceName(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer name) {
/*  867 */     if (Checks.CHECKS) {
/*  868 */       Checks.checkSafe(length, 1);
/*      */     }
/*  870 */     nglGetProgramResourceName(program, programInterface, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramResourceName(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @NativeType("GLsizei") int bufSize) {
/*  876 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  878 */       IntBuffer length = stack.ints(0);
/*  879 */       ByteBuffer name = stack.malloc(bufSize);
/*  880 */       nglGetProgramResourceName(program, programInterface, index, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(name));
/*  881 */       return MemoryUtil.memASCII(name, length.get(0));
/*      */     } finally {
/*  883 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramResourceName(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index) {
/*  890 */     return glGetProgramResourceName(program, programInterface, index, glGetProgramInterfacei(program, programInterface, 37622));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceiv(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @NativeType("GLenum const *") IntBuffer props, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer params) {
/*  900 */     if (Checks.CHECKS) {
/*  901 */       Checks.checkSafe(length, 1);
/*      */     }
/*  903 */     nglGetProgramResourceiv(program, programInterface, index, props.remaining(), MemoryUtil.memAddress(props), params.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetProgramResourceLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") ByteBuffer name) {
/*  914 */     if (Checks.CHECKS) {
/*  915 */       Checks.checkNT1(name);
/*      */     }
/*  917 */     return nglGetProgramResourceLocation(program, programInterface, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetProgramResourceLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") CharSequence name) {
/*  923 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  925 */       stack.nASCII(name, true);
/*  926 */       long nameEncoded = stack.getPointerAddress();
/*  927 */       return nglGetProgramResourceLocation(program, programInterface, nameEncoded);
/*      */     } finally {
/*  929 */       stack.setPointer(stackPointer);
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
/*      */   public static int glGetProgramResourceLocationIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") ByteBuffer name) {
/*  941 */     if (Checks.CHECKS) {
/*  942 */       Checks.checkNT1(name);
/*      */     }
/*  944 */     return nglGetProgramResourceLocationIndex(program, programInterface, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetProgramResourceLocationIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") CharSequence name) {
/*  950 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  952 */       stack.nASCII(name, true);
/*  953 */       long nameEncoded = stack.getPointerAddress();
/*  954 */       return nglGetProgramResourceLocationIndex(program, programInterface, nameEncoded);
/*      */     } finally {
/*  956 */       stack.setPointer(stackPointer);
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
/*      */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 1017 */     long __functionAddress = (GL.getICD()).glClearBufferData;
/* 1018 */     if (Checks.CHECKS) {
/* 1019 */       Checks.check(__functionAddress);
/*      */     }
/* 1021 */     JNI.callPV(target, internalformat, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 1026 */     long __functionAddress = (GL.getICD()).glClearBufferData;
/* 1027 */     if (Checks.CHECKS) {
/* 1028 */       Checks.check(__functionAddress);
/*      */     }
/* 1030 */     JNI.callPV(target, internalformat, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 1035 */     long __functionAddress = (GL.getICD()).glClearBufferData;
/* 1036 */     if (Checks.CHECKS) {
/* 1037 */       Checks.check(__functionAddress);
/*      */     }
/* 1039 */     JNI.callPV(target, internalformat, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 1044 */     long __functionAddress = (GL.getICD()).glClearBufferSubData;
/* 1045 */     if (Checks.CHECKS) {
/* 1046 */       Checks.check(__functionAddress);
/*      */     }
/* 1048 */     JNI.callPPPV(target, internalformat, offset, size, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 1053 */     long __functionAddress = (GL.getICD()).glClearBufferSubData;
/* 1054 */     if (Checks.CHECKS) {
/* 1055 */       Checks.check(__functionAddress);
/*      */     }
/* 1057 */     JNI.callPPPV(target, internalformat, offset, size, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 1062 */     long __functionAddress = (GL.getICD()).glClearBufferSubData;
/* 1063 */     if (Checks.CHECKS) {
/* 1064 */       Checks.check(__functionAddress);
/*      */     }
/* 1066 */     JNI.callPPPV(target, internalformat, offset, size, format, type, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDebugMessageControl(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @NativeType("GLuint const *") int[] ids, @NativeType("GLboolean") boolean enabled) {
/* 1071 */     long __functionAddress = (GL.getICD()).glDebugMessageControl;
/* 1072 */     if (Checks.CHECKS) {
/* 1073 */       Checks.check(__functionAddress);
/*      */     }
/* 1075 */     JNI.callPV(source, type, severity, Checks.lengthSafe(ids), ids, enabled, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glGetDebugMessageLog(@NativeType("GLuint") int count, @NativeType("GLenum *") int[] sources, @NativeType("GLenum *") int[] types, @NativeType("GLuint *") int[] ids, @NativeType("GLenum *") int[] severities, @NativeType("GLsizei *") int[] lengths, @NativeType("GLchar *") ByteBuffer messageLog) {
/* 1081 */     long __functionAddress = (GL.getICD()).glGetDebugMessageLog;
/* 1082 */     if (Checks.CHECKS) {
/* 1083 */       Checks.check(__functionAddress);
/* 1084 */       Checks.checkSafe(sources, count);
/* 1085 */       Checks.checkSafe(types, count);
/* 1086 */       Checks.checkSafe(ids, count);
/* 1087 */       Checks.checkSafe(severities, count);
/* 1088 */       Checks.checkSafe(lengths, count);
/*      */     } 
/* 1090 */     return JNI.callPPPPPPI(count, Checks.remainingSafe(messageLog), sources, types, ids, severities, lengths, MemoryUtil.memAddressSafe(messageLog), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer label) {
/* 1095 */     long __functionAddress = (GL.getICD()).glGetObjectLabel;
/* 1096 */     if (Checks.CHECKS) {
/* 1097 */       Checks.check(__functionAddress);
/* 1098 */       Checks.checkSafe(length, 1);
/*      */     } 
/* 1100 */     JNI.callPPV(identifier, name, label.remaining(), length, MemoryUtil.memAddress(label), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer label) {
/* 1105 */     long __functionAddress = (GL.getICD()).glGetObjectPtrLabel;
/* 1106 */     if (Checks.CHECKS) {
/* 1107 */       Checks.check(__functionAddress);
/* 1108 */       Checks.check(ptr);
/* 1109 */       Checks.checkSafe(length, 1);
/*      */     } 
/* 1111 */     JNI.callPPPV(ptr, label.remaining(), length, MemoryUtil.memAddress(label), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1116 */     long __functionAddress = (GL.getICD()).glGetFramebufferParameteriv;
/* 1117 */     if (Checks.CHECKS) {
/* 1118 */       Checks.check(__functionAddress);
/* 1119 */       Checks.check(params, 1);
/*      */     } 
/* 1121 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetInternalformati64v(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 1126 */     long __functionAddress = (GL.getICD()).glGetInternalformati64v;
/* 1127 */     if (Checks.CHECKS) {
/* 1128 */       Checks.check(__functionAddress);
/*      */     }
/* 1130 */     JNI.callPV(target, internalformat, pname, params.length, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int[] attachments) {
/* 1135 */     long __functionAddress = (GL.getICD()).glInvalidateFramebuffer;
/* 1136 */     if (Checks.CHECKS) {
/* 1137 */       Checks.check(__functionAddress);
/*      */     }
/* 1139 */     JNI.callPV(target, attachments.length, attachments, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int[] attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 1144 */     long __functionAddress = (GL.getICD()).glInvalidateSubFramebuffer;
/* 1145 */     if (Checks.CHECKS) {
/* 1146 */       Checks.check(__functionAddress);
/*      */     }
/* 1148 */     JNI.callPV(target, attachments.length, attachments, x, y, width, height, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") int[] indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 1153 */     long __functionAddress = (GL.getICD()).glMultiDrawArraysIndirect;
/* 1154 */     if (Checks.CHECKS) {
/* 1155 */       Checks.check(__functionAddress);
/* 1156 */       Checks.check(indirect, drawcount * ((stride == 0) ? 16 : stride) >> 2);
/*      */     } 
/* 1158 */     JNI.callPV(mode, indirect, drawcount, stride, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") int[] indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 1163 */     long __functionAddress = (GL.getICD()).glMultiDrawElementsIndirect;
/* 1164 */     if (Checks.CHECKS) {
/* 1165 */       Checks.check(__functionAddress);
/* 1166 */       Checks.check(indirect, drawcount * ((stride == 0) ? 20 : stride) >> 2);
/*      */     } 
/* 1168 */     JNI.callPV(mode, type, indirect, drawcount, stride, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramInterfaceiv(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1173 */     long __functionAddress = (GL.getICD()).glGetProgramInterfaceiv;
/* 1174 */     if (Checks.CHECKS) {
/* 1175 */       Checks.check(__functionAddress);
/* 1176 */       Checks.check(params, 1);
/*      */     } 
/* 1178 */     JNI.callPV(program, programInterface, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceName(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer name) {
/* 1183 */     long __functionAddress = (GL.getICD()).glGetProgramResourceName;
/* 1184 */     if (Checks.CHECKS) {
/* 1185 */       Checks.check(__functionAddress);
/* 1186 */       Checks.checkSafe(length, 1);
/*      */     } 
/* 1188 */     JNI.callPPV(program, programInterface, index, name.remaining(), length, MemoryUtil.memAddress(name), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceiv(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @NativeType("GLenum const *") int[] props, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] params) {
/* 1193 */     long __functionAddress = (GL.getICD()).glGetProgramResourceiv;
/* 1194 */     if (Checks.CHECKS) {
/* 1195 */       Checks.check(__functionAddress);
/* 1196 */       Checks.checkSafe(length, 1);
/*      */     } 
/* 1198 */     JNI.callPPPV(program, programInterface, index, props.length, props, params.length, length, params, __functionAddress);
/*      */   }
/*      */   
/*      */   public static native void nglClearBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglClearBufferSubData(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3);
/*      */   
/*      */   public static native void glDispatchCompute(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glDispatchComputeIndirect(@NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glCopyImageSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLint") int paramInt11, @NativeType("GLint") int paramInt12, @NativeType("GLsizei") int paramInt13, @NativeType("GLsizei") int paramInt14, @NativeType("GLsizei") int paramInt15);
/*      */   
/*      */   public static native void nglDebugMessageControl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean);
/*      */   
/*      */   public static native void nglDebugMessageInsert(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglDebugMessageCallback(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nglGetDebugMessageLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*      */   
/*      */   public static native void nglPushDebugGroup(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glPopDebugGroup();
/*      */   
/*      */   public static native void nglObjectLabel(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetObjectLabel(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglObjectPtrLabel(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void nglGetObjectPtrLabel(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void glFramebufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglGetFramebufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetInternalformati64v(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glInvalidateTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8);
/*      */   
/*      */   public static native void glInvalidateTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glInvalidateBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glInvalidateBufferData(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglInvalidateFramebuffer(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglInvalidateSubFramebuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
/*      */   
/*      */   public static native void nglMultiDrawArraysIndirect(int paramInt1, long paramLong, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nglMultiDrawElementsIndirect(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nglGetProgramInterfaceiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native int nglGetProgramResourceIndex(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramResourceName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglGetProgramResourceiv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nglGetProgramResourceLocation(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native int nglGetProgramResourceLocationIndex(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glShaderStorageBlockBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glTexBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glTexStorage2DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glTexStorage3DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glTextureView(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLuint") int paramInt8);
/*      */   
/*      */   public static native void glBindVertexBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribIFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribLFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexBindingDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL43C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */