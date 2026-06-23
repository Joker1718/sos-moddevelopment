/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL11
/*      */ {
/*      */   public static final int GL_ACCUM = 256;
/*      */   public static final int GL_LOAD = 257;
/*      */   public static final int GL_RETURN = 258;
/*      */   public static final int GL_MULT = 259;
/*      */   
/*      */   static {
/*   23 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_ADD = 260;
/*      */   
/*      */   public static final int GL_NEVER = 512;
/*      */   
/*      */   public static final int GL_LESS = 513;
/*      */   
/*      */   public static final int GL_EQUAL = 514;
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
/*      */   public static final int GL_CURRENT_BIT = 1;
/*      */   
/*      */   public static final int GL_POINT_BIT = 2;
/*      */   
/*      */   public static final int GL_LINE_BIT = 4;
/*      */   
/*      */   public static final int GL_POLYGON_BIT = 8;
/*      */   
/*      */   public static final int GL_POLYGON_STIPPLE_BIT = 16;
/*      */   
/*      */   public static final int GL_PIXEL_MODE_BIT = 32;
/*      */   
/*      */   public static final int GL_LIGHTING_BIT = 64;
/*      */   
/*      */   public static final int GL_FOG_BIT = 128;
/*      */   
/*      */   public static final int GL_DEPTH_BUFFER_BIT = 256;
/*      */   
/*      */   public static final int GL_ACCUM_BUFFER_BIT = 512;
/*      */   
/*      */   public static final int GL_STENCIL_BUFFER_BIT = 1024;
/*      */   
/*      */   public static final int GL_VIEWPORT_BIT = 2048;
/*      */   
/*      */   public static final int GL_TRANSFORM_BIT = 4096;
/*      */   
/*      */   public static final int GL_ENABLE_BIT = 8192;
/*      */   
/*      */   public static final int GL_COLOR_BUFFER_BIT = 16384;
/*      */   
/*      */   public static final int GL_HINT_BIT = 32768;
/*      */   
/*      */   public static final int GL_EVAL_BIT = 65536;
/*      */   
/*      */   public static final int GL_LIST_BIT = 131072;
/*      */   
/*      */   public static final int GL_TEXTURE_BIT = 262144;
/*      */   
/*      */   public static final int GL_SCISSOR_BIT = 524288;
/*      */   
/*      */   public static final int GL_ALL_ATTRIB_BITS = 1048575;
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
/*      */   public static final int GL_QUAD_STRIP = 8;
/*      */   
/*      */   public static final int GL_POLYGON = 9;
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
/*      */   public static final int GL_CLIP_PLANE0 = 12288;
/*      */   
/*      */   public static final int GL_CLIP_PLANE1 = 12289;
/*      */   
/*      */   public static final int GL_CLIP_PLANE2 = 12290;
/*      */   
/*      */   public static final int GL_CLIP_PLANE3 = 12291;
/*      */   
/*      */   public static final int GL_CLIP_PLANE4 = 12292;
/*      */   
/*      */   public static final int GL_CLIP_PLANE5 = 12293;
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
/*      */   public static final int GL_2_BYTES = 5127;
/*      */   
/*      */   public static final int GL_3_BYTES = 5128;
/*      */   
/*      */   public static final int GL_4_BYTES = 5129;
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
/*      */   public static final int GL_AUX0 = 1033;
/*      */   
/*      */   public static final int GL_AUX1 = 1034;
/*      */   
/*      */   public static final int GL_AUX2 = 1035;
/*      */   
/*      */   public static final int GL_AUX3 = 1036;
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
/*      */   
/*      */   public static final int GL_2D = 1536;
/*      */   
/*      */   public static final int GL_3D = 1537;
/*      */   
/*      */   public static final int GL_3D_COLOR = 1538;
/*      */   
/*      */   public static final int GL_3D_COLOR_TEXTURE = 1539;
/*      */   
/*      */   public static final int GL_4D_COLOR_TEXTURE = 1540;
/*      */   public static final int GL_PASS_THROUGH_TOKEN = 1792;
/*      */   public static final int GL_POINT_TOKEN = 1793;
/*      */   public static final int GL_LINE_TOKEN = 1794;
/*      */   public static final int GL_POLYGON_TOKEN = 1795;
/*      */   public static final int GL_BITMAP_TOKEN = 1796;
/*      */   public static final int GL_DRAW_PIXEL_TOKEN = 1797;
/*      */   public static final int GL_COPY_PIXEL_TOKEN = 1798;
/*      */   public static final int GL_LINE_RESET_TOKEN = 1799;
/*      */   public static final int GL_EXP = 2048;
/*      */   public static final int GL_EXP2 = 2049;
/*      */   public static final int GL_CW = 2304;
/*      */   public static final int GL_CCW = 2305;
/*      */   public static final int GL_COEFF = 2560;
/*      */   public static final int GL_ORDER = 2561;
/*      */   public static final int GL_DOMAIN = 2562;
/*      */   public static final int GL_CURRENT_COLOR = 2816;
/*      */   public static final int GL_CURRENT_INDEX = 2817;
/*      */   public static final int GL_CURRENT_NORMAL = 2818;
/*      */   public static final int GL_CURRENT_TEXTURE_COORDS = 2819;
/*      */   public static final int GL_CURRENT_RASTER_COLOR = 2820;
/*      */   public static final int GL_CURRENT_RASTER_INDEX = 2821;
/*      */   public static final int GL_CURRENT_RASTER_TEXTURE_COORDS = 2822;
/*      */   public static final int GL_CURRENT_RASTER_POSITION = 2823;
/*      */   public static final int GL_CURRENT_RASTER_POSITION_VALID = 2824;
/*      */   public static final int GL_CURRENT_RASTER_DISTANCE = 2825;
/*      */   public static final int GL_POINT_SMOOTH = 2832;
/*      */   public static final int GL_POINT_SIZE = 2833;
/*      */   public static final int GL_POINT_SIZE_RANGE = 2834;
/*      */   public static final int GL_POINT_SIZE_GRANULARITY = 2835;
/*      */   public static final int GL_LINE_SMOOTH = 2848;
/*      */   public static final int GL_LINE_WIDTH = 2849;
/*      */   public static final int GL_LINE_WIDTH_RANGE = 2850;
/*      */   public static final int GL_LINE_WIDTH_GRANULARITY = 2851;
/*      */   public static final int GL_LINE_STIPPLE = 2852;
/*      */   public static final int GL_LINE_STIPPLE_PATTERN = 2853;
/*      */   public static final int GL_LINE_STIPPLE_REPEAT = 2854;
/*      */   public static final int GL_LIST_MODE = 2864;
/*      */   public static final int GL_MAX_LIST_NESTING = 2865;
/*      */   public static final int GL_LIST_BASE = 2866;
/*      */   public static final int GL_LIST_INDEX = 2867;
/*      */   public static final int GL_POLYGON_MODE = 2880;
/*      */   public static final int GL_POLYGON_SMOOTH = 2881;
/*      */   public static final int GL_POLYGON_STIPPLE = 2882;
/*      */   public static final int GL_EDGE_FLAG = 2883;
/*      */   public static final int GL_CULL_FACE = 2884;
/*      */   public static final int GL_CULL_FACE_MODE = 2885;
/*      */   public static final int GL_FRONT_FACE = 2886;
/*      */   public static final int GL_LIGHTING = 2896;
/*      */   public static final int GL_LIGHT_MODEL_LOCAL_VIEWER = 2897;
/*      */   public static final int GL_LIGHT_MODEL_TWO_SIDE = 2898;
/*      */   public static final int GL_LIGHT_MODEL_AMBIENT = 2899;
/*      */   public static final int GL_SHADE_MODEL = 2900;
/*      */   public static final int GL_COLOR_MATERIAL_FACE = 2901;
/*      */   public static final int GL_COLOR_MATERIAL_PARAMETER = 2902;
/*      */   public static final int GL_COLOR_MATERIAL = 2903;
/*      */   public static final int GL_FOG = 2912;
/*      */   public static final int GL_FOG_INDEX = 2913;
/*      */   public static final int GL_FOG_DENSITY = 2914;
/*      */   public static final int GL_FOG_START = 2915;
/*      */   public static final int GL_FOG_END = 2916;
/*      */   public static final int GL_FOG_MODE = 2917;
/*      */   public static final int GL_FOG_COLOR = 2918;
/*      */   public static final int GL_DEPTH_RANGE = 2928;
/*      */   public static final int GL_DEPTH_TEST = 2929;
/*      */   public static final int GL_DEPTH_WRITEMASK = 2930;
/*      */   public static final int GL_DEPTH_CLEAR_VALUE = 2931;
/*      */   public static final int GL_DEPTH_FUNC = 2932;
/*      */   public static final int GL_ACCUM_CLEAR_VALUE = 2944;
/*      */   public static final int GL_STENCIL_TEST = 2960;
/*      */   public static final int GL_STENCIL_CLEAR_VALUE = 2961;
/*      */   public static final int GL_STENCIL_FUNC = 2962;
/*      */   public static final int GL_STENCIL_VALUE_MASK = 2963;
/*      */   public static final int GL_STENCIL_FAIL = 2964;
/*      */   public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965;
/*      */   public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966;
/*      */   public static final int GL_STENCIL_REF = 2967;
/*      */   public static final int GL_STENCIL_WRITEMASK = 2968;
/*      */   public static final int GL_MATRIX_MODE = 2976;
/*      */   public static final int GL_NORMALIZE = 2977;
/*      */   public static final int GL_VIEWPORT = 2978;
/*      */   public static final int GL_MODELVIEW_STACK_DEPTH = 2979;
/*      */   public static final int GL_PROJECTION_STACK_DEPTH = 2980;
/*      */   public static final int GL_TEXTURE_STACK_DEPTH = 2981;
/*      */   public static final int GL_MODELVIEW_MATRIX = 2982;
/*      */   public static final int GL_PROJECTION_MATRIX = 2983;
/*      */   public static final int GL_TEXTURE_MATRIX = 2984;
/*      */   public static final int GL_ATTRIB_STACK_DEPTH = 2992;
/*      */   public static final int GL_CLIENT_ATTRIB_STACK_DEPTH = 2993;
/*      */   public static final int GL_ALPHA_TEST = 3008;
/*      */   public static final int GL_ALPHA_TEST_FUNC = 3009;
/*      */   public static final int GL_ALPHA_TEST_REF = 3010;
/*      */   public static final int GL_DITHER = 3024;
/*      */   public static final int GL_BLEND_DST = 3040;
/*      */   public static final int GL_BLEND_SRC = 3041;
/*      */   public static final int GL_BLEND = 3042;
/*      */   public static final int GL_LOGIC_OP_MODE = 3056;
/*      */   public static final int GL_INDEX_LOGIC_OP = 3057;
/*      */   public static final int GL_LOGIC_OP = 3057;
/*      */   public static final int GL_COLOR_LOGIC_OP = 3058;
/*      */   public static final int GL_AUX_BUFFERS = 3072;
/*      */   public static final int GL_DRAW_BUFFER = 3073;
/*      */   public static final int GL_READ_BUFFER = 3074;
/*      */   public static final int GL_SCISSOR_BOX = 3088;
/*      */   public static final int GL_SCISSOR_TEST = 3089;
/*      */   public static final int GL_INDEX_CLEAR_VALUE = 3104;
/*      */   public static final int GL_INDEX_WRITEMASK = 3105;
/*      */   public static final int GL_COLOR_CLEAR_VALUE = 3106;
/*      */   public static final int GL_COLOR_WRITEMASK = 3107;
/*      */   public static final int GL_INDEX_MODE = 3120;
/*      */   public static final int GL_RGBA_MODE = 3121;
/*      */   public static final int GL_DOUBLEBUFFER = 3122;
/*      */   public static final int GL_STEREO = 3123;
/*      */   public static final int GL_RENDER_MODE = 3136;
/*      */   public static final int GL_PERSPECTIVE_CORRECTION_HINT = 3152;
/*      */   public static final int GL_POINT_SMOOTH_HINT = 3153;
/*      */   public static final int GL_LINE_SMOOTH_HINT = 3154;
/*      */   public static final int GL_POLYGON_SMOOTH_HINT = 3155;
/*      */   public static final int GL_FOG_HINT = 3156;
/*      */   public static final int GL_TEXTURE_GEN_S = 3168;
/*      */   public static final int GL_TEXTURE_GEN_T = 3169;
/*      */   public static final int GL_TEXTURE_GEN_R = 3170;
/*      */   public static final int GL_TEXTURE_GEN_Q = 3171;
/*      */   public static final int GL_PIXEL_MAP_I_TO_I = 3184;
/*      */   public static final int GL_PIXEL_MAP_S_TO_S = 3185;
/*      */   public static final int GL_PIXEL_MAP_I_TO_R = 3186;
/*      */   public static final int GL_PIXEL_MAP_I_TO_G = 3187;
/*      */   public static final int GL_PIXEL_MAP_I_TO_B = 3188;
/*      */   public static final int GL_PIXEL_MAP_I_TO_A = 3189;
/*      */   public static final int GL_PIXEL_MAP_R_TO_R = 3190;
/*      */   public static final int GL_PIXEL_MAP_G_TO_G = 3191;
/*      */   public static final int GL_PIXEL_MAP_B_TO_B = 3192;
/*      */   public static final int GL_PIXEL_MAP_A_TO_A = 3193;
/*      */   public static final int GL_PIXEL_MAP_I_TO_I_SIZE = 3248;
/*      */   public static final int GL_PIXEL_MAP_S_TO_S_SIZE = 3249;
/*      */   public static final int GL_PIXEL_MAP_I_TO_R_SIZE = 3250;
/*      */   public static final int GL_PIXEL_MAP_I_TO_G_SIZE = 3251;
/*      */   public static final int GL_PIXEL_MAP_I_TO_B_SIZE = 3252;
/*      */   public static final int GL_PIXEL_MAP_I_TO_A_SIZE = 3253;
/*      */   public static final int GL_PIXEL_MAP_R_TO_R_SIZE = 3254;
/*      */   public static final int GL_PIXEL_MAP_G_TO_G_SIZE = 3255;
/*      */   public static final int GL_PIXEL_MAP_B_TO_B_SIZE = 3256;
/*      */   public static final int GL_PIXEL_MAP_A_TO_A_SIZE = 3257;
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
/*      */   public static final int GL_MAP_COLOR = 3344;
/*      */   public static final int GL_MAP_STENCIL = 3345;
/*      */   public static final int GL_INDEX_SHIFT = 3346;
/*      */   public static final int GL_INDEX_OFFSET = 3347;
/*      */   public static final int GL_RED_SCALE = 3348;
/*      */   public static final int GL_RED_BIAS = 3349;
/*      */   public static final int GL_ZOOM_X = 3350;
/*      */   public static final int GL_ZOOM_Y = 3351;
/*      */   public static final int GL_GREEN_SCALE = 3352;
/*      */   public static final int GL_GREEN_BIAS = 3353;
/*      */   public static final int GL_BLUE_SCALE = 3354;
/*      */   public static final int GL_BLUE_BIAS = 3355;
/*      */   public static final int GL_ALPHA_SCALE = 3356;
/*      */   public static final int GL_ALPHA_BIAS = 3357;
/*      */   public static final int GL_DEPTH_SCALE = 3358;
/*      */   public static final int GL_DEPTH_BIAS = 3359;
/*      */   public static final int GL_MAX_EVAL_ORDER = 3376;
/*      */   public static final int GL_MAX_LIGHTS = 3377;
/*      */   public static final int GL_MAX_CLIP_PLANES = 3378;
/*      */   public static final int GL_MAX_TEXTURE_SIZE = 3379;
/*      */   public static final int GL_MAX_PIXEL_MAP_TABLE = 3380;
/*      */   public static final int GL_MAX_ATTRIB_STACK_DEPTH = 3381;
/*      */   public static final int GL_MAX_MODELVIEW_STACK_DEPTH = 3382;
/*      */   public static final int GL_MAX_NAME_STACK_DEPTH = 3383;
/*      */   public static final int GL_MAX_PROJECTION_STACK_DEPTH = 3384;
/*      */   public static final int GL_MAX_TEXTURE_STACK_DEPTH = 3385;
/*      */   public static final int GL_MAX_VIEWPORT_DIMS = 3386;
/*      */   public static final int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 3387;
/*      */   public static final int GL_SUBPIXEL_BITS = 3408;
/*      */   public static final int GL_INDEX_BITS = 3409;
/*      */   public static final int GL_RED_BITS = 3410;
/*      */   public static final int GL_GREEN_BITS = 3411;
/*      */   public static final int GL_BLUE_BITS = 3412;
/*      */   public static final int GL_ALPHA_BITS = 3413;
/*      */   public static final int GL_DEPTH_BITS = 3414;
/*      */   public static final int GL_STENCIL_BITS = 3415;
/*      */   public static final int GL_ACCUM_RED_BITS = 3416;
/*      */   public static final int GL_ACCUM_GREEN_BITS = 3417;
/*      */   public static final int GL_ACCUM_BLUE_BITS = 3418;
/*      */   public static final int GL_ACCUM_ALPHA_BITS = 3419;
/*      */   public static final int GL_NAME_STACK_DEPTH = 3440;
/*      */   public static final int GL_AUTO_NORMAL = 3456;
/*      */   public static final int GL_MAP1_COLOR_4 = 3472;
/*      */   public static final int GL_MAP1_INDEX = 3473;
/*      */   public static final int GL_MAP1_NORMAL = 3474;
/*      */   public static final int GL_MAP1_TEXTURE_COORD_1 = 3475;
/*      */   public static final int GL_MAP1_TEXTURE_COORD_2 = 3476;
/*      */   public static final int GL_MAP1_TEXTURE_COORD_3 = 3477;
/*      */   public static final int GL_MAP1_TEXTURE_COORD_4 = 3478;
/*      */   public static final int GL_MAP1_VERTEX_3 = 3479;
/*      */   public static final int GL_MAP1_VERTEX_4 = 3480;
/*      */   public static final int GL_MAP2_COLOR_4 = 3504;
/*      */   public static final int GL_MAP2_INDEX = 3505;
/*      */   public static final int GL_MAP2_NORMAL = 3506;
/*      */   public static final int GL_MAP2_TEXTURE_COORD_1 = 3507;
/*      */   public static final int GL_MAP2_TEXTURE_COORD_2 = 3508;
/*      */   public static final int GL_MAP2_TEXTURE_COORD_3 = 3509;
/*      */   public static final int GL_MAP2_TEXTURE_COORD_4 = 3510;
/*      */   public static final int GL_MAP2_VERTEX_3 = 3511;
/*      */   public static final int GL_MAP2_VERTEX_4 = 3512;
/*      */   public static final int GL_MAP1_GRID_DOMAIN = 3536;
/*      */   public static final int GL_MAP1_GRID_SEGMENTS = 3537;
/*      */   public static final int GL_MAP2_GRID_DOMAIN = 3538;
/*      */   public static final int GL_MAP2_GRID_SEGMENTS = 3539;
/*      */   public static final int GL_TEXTURE_1D = 3552;
/*      */   public static final int GL_TEXTURE_2D = 3553;
/*      */   public static final int GL_FEEDBACK_BUFFER_POINTER = 3568;
/*      */   public static final int GL_FEEDBACK_BUFFER_SIZE = 3569;
/*      */   public static final int GL_FEEDBACK_BUFFER_TYPE = 3570;
/*      */   public static final int GL_SELECTION_BUFFER_POINTER = 3571;
/*      */   public static final int GL_SELECTION_BUFFER_SIZE = 3572;
/*      */   public static final int GL_TEXTURE_WIDTH = 4096;
/*      */   public static final int GL_TEXTURE_HEIGHT = 4097;
/*      */   public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099;
/*      */   public static final int GL_TEXTURE_COMPONENTS = 4099;
/*      */   public static final int GL_TEXTURE_BORDER_COLOR = 4100;
/*      */   public static final int GL_TEXTURE_BORDER = 4101;
/*      */   public static final int GL_DONT_CARE = 4352;
/*      */   public static final int GL_FASTEST = 4353;
/*      */   public static final int GL_NICEST = 4354;
/*      */   public static final int GL_LIGHT0 = 16384;
/*      */   public static final int GL_LIGHT1 = 16385;
/*      */   public static final int GL_LIGHT2 = 16386;
/*      */   public static final int GL_LIGHT3 = 16387;
/*      */   public static final int GL_LIGHT4 = 16388;
/*      */   public static final int GL_LIGHT5 = 16389;
/*      */   public static final int GL_LIGHT6 = 16390;
/*      */   public static final int GL_LIGHT7 = 16391;
/*      */   public static final int GL_AMBIENT = 4608;
/*      */   public static final int GL_DIFFUSE = 4609;
/*      */   public static final int GL_SPECULAR = 4610;
/*      */   public static final int GL_POSITION = 4611;
/*      */   public static final int GL_SPOT_DIRECTION = 4612;
/*      */   public static final int GL_SPOT_EXPONENT = 4613;
/*      */   public static final int GL_SPOT_CUTOFF = 4614;
/*      */   public static final int GL_CONSTANT_ATTENUATION = 4615;
/*      */   public static final int GL_LINEAR_ATTENUATION = 4616;
/*      */   public static final int GL_QUADRATIC_ATTENUATION = 4617;
/*      */   public static final int GL_COMPILE = 4864;
/*      */   public static final int GL_COMPILE_AND_EXECUTE = 4865;
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
/*      */   public static final int GL_EMISSION = 5632;
/*      */   public static final int GL_SHININESS = 5633;
/*      */   public static final int GL_AMBIENT_AND_DIFFUSE = 5634;
/*      */   public static final int GL_COLOR_INDEXES = 5635;
/*      */   public static final int GL_MODELVIEW = 5888;
/*      */   public static final int GL_PROJECTION = 5889;
/*      */   public static final int GL_TEXTURE = 5890;
/*      */   public static final int GL_COLOR = 6144;
/*      */   public static final int GL_DEPTH = 6145;
/*      */   public static final int GL_STENCIL = 6146;
/*      */   public static final int GL_COLOR_INDEX = 6400;
/*      */   public static final int GL_STENCIL_INDEX = 6401;
/*      */   public static final int GL_DEPTH_COMPONENT = 6402;
/*      */   public static final int GL_RED = 6403;
/*      */   public static final int GL_GREEN = 6404;
/*      */   public static final int GL_BLUE = 6405;
/*      */   public static final int GL_ALPHA = 6406;
/*      */   public static final int GL_RGB = 6407;
/*      */   public static final int GL_RGBA = 6408;
/*      */   public static final int GL_LUMINANCE = 6409;
/*      */   public static final int GL_LUMINANCE_ALPHA = 6410;
/*      */   public static final int GL_BITMAP = 6656;
/*      */   public static final int GL_POINT = 6912;
/*      */   public static final int GL_LINE = 6913;
/*      */   public static final int GL_FILL = 6914;
/*      */   public static final int GL_RENDER = 7168;
/*      */   public static final int GL_FEEDBACK = 7169;
/*      */   public static final int GL_SELECT = 7170;
/*      */   public static final int GL_FLAT = 7424;
/*      */   public static final int GL_SMOOTH = 7425;
/*      */   public static final int GL_KEEP = 7680;
/*      */   public static final int GL_REPLACE = 7681;
/*      */   public static final int GL_INCR = 7682;
/*      */   public static final int GL_DECR = 7683;
/*      */   public static final int GL_VENDOR = 7936;
/*      */   public static final int GL_RENDERER = 7937;
/*      */   public static final int GL_VERSION = 7938;
/*      */   public static final int GL_EXTENSIONS = 7939;
/*      */   public static final int GL_S = 8192;
/*      */   public static final int GL_T = 8193;
/*      */   public static final int GL_R = 8194;
/*      */   public static final int GL_Q = 8195;
/*      */   public static final int GL_MODULATE = 8448;
/*      */   public static final int GL_DECAL = 8449;
/*      */   public static final int GL_TEXTURE_ENV_MODE = 8704;
/*      */   public static final int GL_TEXTURE_ENV_COLOR = 8705;
/*      */   public static final int GL_TEXTURE_ENV = 8960;
/*      */   public static final int GL_EYE_LINEAR = 9216;
/*      */   public static final int GL_OBJECT_LINEAR = 9217;
/*      */   public static final int GL_SPHERE_MAP = 9218;
/*      */   public static final int GL_TEXTURE_GEN_MODE = 9472;
/*      */   public static final int GL_OBJECT_PLANE = 9473;
/*      */   public static final int GL_EYE_PLANE = 9474;
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
/*      */   public static final int GL_CLAMP = 10496;
/*      */   public static final int GL_REPEAT = 10497;
/*      */   public static final int GL_CLIENT_PIXEL_STORE_BIT = 1;
/*      */   public static final int GL_CLIENT_VERTEX_ARRAY_BIT = 2;
/*      */   public static final int GL_CLIENT_ALL_ATTRIB_BITS = -1;
/*      */   public static final int GL_POLYGON_OFFSET_FACTOR = 32824;
/*      */   public static final int GL_POLYGON_OFFSET_UNITS = 10752;
/*      */   public static final int GL_POLYGON_OFFSET_POINT = 10753;
/*      */   public static final int GL_POLYGON_OFFSET_LINE = 10754;
/*      */   public static final int GL_POLYGON_OFFSET_FILL = 32823;
/*      */   public static final int GL_ALPHA4 = 32827;
/*      */   public static final int GL_ALPHA8 = 32828;
/*      */   public static final int GL_ALPHA12 = 32829;
/*      */   public static final int GL_ALPHA16 = 32830;
/*      */   public static final int GL_LUMINANCE4 = 32831;
/*      */   public static final int GL_LUMINANCE8 = 32832;
/*      */   public static final int GL_LUMINANCE12 = 32833;
/*      */   public static final int GL_LUMINANCE16 = 32834;
/*      */   public static final int GL_LUMINANCE4_ALPHA4 = 32835;
/*      */   public static final int GL_LUMINANCE6_ALPHA2 = 32836;
/*      */   public static final int GL_LUMINANCE8_ALPHA8 = 32837;
/*      */   public static final int GL_LUMINANCE12_ALPHA4 = 32838;
/*      */   public static final int GL_LUMINANCE12_ALPHA12 = 32839;
/*      */   public static final int GL_LUMINANCE16_ALPHA16 = 32840;
/*      */   public static final int GL_INTENSITY = 32841;
/*      */   public static final int GL_INTENSITY4 = 32842;
/*      */   public static final int GL_INTENSITY8 = 32843;
/*      */   public static final int GL_INTENSITY12 = 32844;
/*      */   public static final int GL_INTENSITY16 = 32845;
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
/*      */   public static final int GL_TEXTURE_LUMINANCE_SIZE = 32864;
/*      */   public static final int GL_TEXTURE_INTENSITY_SIZE = 32865;
/*      */   public static final int GL_PROXY_TEXTURE_1D = 32867;
/*      */   public static final int GL_PROXY_TEXTURE_2D = 32868;
/*      */   public static final int GL_TEXTURE_PRIORITY = 32870;
/*      */   public static final int GL_TEXTURE_RESIDENT = 32871;
/*      */   public static final int GL_TEXTURE_BINDING_1D = 32872;
/*      */   public static final int GL_TEXTURE_BINDING_2D = 32873;
/*      */   public static final int GL_VERTEX_ARRAY = 32884;
/*      */   public static final int GL_NORMAL_ARRAY = 32885;
/*      */   public static final int GL_COLOR_ARRAY = 32886;
/*      */   public static final int GL_INDEX_ARRAY = 32887;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY = 32888;
/*      */   public static final int GL_EDGE_FLAG_ARRAY = 32889;
/*      */   public static final int GL_VERTEX_ARRAY_SIZE = 32890;
/*      */   public static final int GL_VERTEX_ARRAY_TYPE = 32891;
/*      */   public static final int GL_VERTEX_ARRAY_STRIDE = 32892;
/*      */   public static final int GL_NORMAL_ARRAY_TYPE = 32894;
/*      */   public static final int GL_NORMAL_ARRAY_STRIDE = 32895;
/*      */   public static final int GL_COLOR_ARRAY_SIZE = 32897;
/*      */   public static final int GL_COLOR_ARRAY_TYPE = 32898;
/*      */   public static final int GL_COLOR_ARRAY_STRIDE = 32899;
/*      */   public static final int GL_INDEX_ARRAY_TYPE = 32901;
/*      */   public static final int GL_INDEX_ARRAY_STRIDE = 32902;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY_SIZE = 32904;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY_TYPE = 32905;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY_STRIDE = 32906;
/*      */   public static final int GL_EDGE_FLAG_ARRAY_STRIDE = 32908;
/*      */   public static final int GL_VERTEX_ARRAY_POINTER = 32910;
/*      */   public static final int GL_NORMAL_ARRAY_POINTER = 32911;
/*      */   public static final int GL_COLOR_ARRAY_POINTER = 32912;
/*      */   public static final int GL_INDEX_ARRAY_POINTER = 32913;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY_POINTER = 32914;
/*      */   public static final int GL_EDGE_FLAG_ARRAY_POINTER = 32915;
/*      */   public static final int GL_V2F = 10784;
/*      */   public static final int GL_V3F = 10785;
/*      */   public static final int GL_C4UB_V2F = 10786;
/*      */   public static final int GL_C4UB_V3F = 10787;
/*      */   public static final int GL_C3F_V3F = 10788;
/*      */   public static final int GL_N3F_V3F = 10789;
/*      */   public static final int GL_C4F_N3F_V3F = 10790;
/*      */   public static final int GL_T2F_V3F = 10791;
/*      */   public static final int GL_T4F_V4F = 10792;
/*      */   public static final int GL_T2F_C4UB_V3F = 10793;
/*      */   public static final int GL_T2F_C3F_V3F = 10794;
/*      */   public static final int GL_T2F_N3F_V3F = 10795;
/*      */   public static final int GL_T2F_C4F_N3F_V3F = 10796;
/*      */   public static final int GL_T4F_C4F_N3F_V4F = 10797;
/*      */   
/*      */   protected GL11() {
/*  648 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnable(@NativeType("GLenum") int target) {
/*  655 */     GL11C.glEnable(target);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisable(@NativeType("GLenum") int target) {
/*  662 */     GL11C.glDisable(target);
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glAreTexturesResident(@NativeType("GLuint const *") IntBuffer textures, @NativeType("GLboolean *") ByteBuffer residences) {
/*  683 */     if (Checks.CHECKS) {
/*  684 */       Checks.check(residences, textures.remaining());
/*      */     }
/*  686 */     return nglAreTexturesResident(textures.remaining(), MemoryUtil.memAddress(textures), MemoryUtil.memAddress(residences));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glAreTexturesResident(@NativeType("GLuint const *") int texture, @NativeType("GLboolean *") ByteBuffer residences) {
/*  692 */     if (Checks.CHECKS) {
/*  693 */       Checks.check(residences, 1);
/*      */     }
/*  695 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  697 */       IntBuffer textures = stack.ints(texture);
/*  698 */       return nglAreTexturesResident(1, MemoryUtil.memAddress(textures), MemoryUtil.memAddress(residences));
/*      */     } finally {
/*  700 */       stack.setPointer(stackPointer);
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
/*      */   public static void glBindTexture(@NativeType("GLenum") int target, @NativeType("GLuint") int texture) {
/*  718 */     GL11C.glBindTexture(target, texture);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBitmap(@NativeType("GLsizei") int w, @NativeType("GLsizei") int h, @NativeType("GLfloat") float xOrig, @NativeType("GLfloat") float yOrig, @NativeType("GLfloat") float xInc, @NativeType("GLfloat") float yInc, @NativeType("GLubyte const *") ByteBuffer data) {
/*  728 */     if (Checks.CHECKS) {
/*  729 */       Checks.checkSafe(data, (w + 7 >> 3) * h);
/*      */     }
/*  731 */     nglBitmap(w, h, xOrig, yOrig, xInc, yInc, MemoryUtil.memAddressSafe(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glBitmap(@NativeType("GLsizei") int w, @NativeType("GLsizei") int h, @NativeType("GLfloat") float xOrig, @NativeType("GLfloat") float yOrig, @NativeType("GLfloat") float xInc, @NativeType("GLfloat") float yInc, @NativeType("GLubyte const *") long data) {
/*  736 */     nglBitmap(w, h, xOrig, yOrig, xInc, yInc, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBlendFunc(@NativeType("GLenum") int sfactor, @NativeType("GLenum") int dfactor) {
/*  743 */     GL11C.glBlendFunc(sfactor, dfactor);
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
/*      */   public static void glCallLists(@NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer lists) {
/*  758 */     nglCallLists(lists.remaining() / GLChecks.typeToBytes(type), type, MemoryUtil.memAddress(lists));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCallLists(@NativeType("void const *") ByteBuffer lists) {
/*  763 */     nglCallLists(lists.remaining(), 5121, MemoryUtil.memAddress(lists));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCallLists(@NativeType("void const *") ShortBuffer lists) {
/*  768 */     nglCallLists(lists.remaining(), 5123, MemoryUtil.memAddress(lists));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCallLists(@NativeType("void const *") IntBuffer lists) {
/*  773 */     nglCallLists(lists.remaining(), 5125, MemoryUtil.memAddress(lists));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClear(@NativeType("GLbitfield") int mask) {
/*  780 */     GL11C.glClear(mask);
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
/*      */   public static void glClearColor(@NativeType("GLfloat") float red, @NativeType("GLfloat") float green, @NativeType("GLfloat") float blue, @NativeType("GLfloat") float alpha) {
/*  792 */     GL11C.glClearColor(red, green, blue, alpha);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearDepth(@NativeType("GLdouble") double depth) {
/*  799 */     GL11C.glClearDepth(depth);
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
/*      */   public static void glClearStencil(@NativeType("GLint") int s) {
/*  811 */     GL11C.glClearStencil(s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClipPlane(@NativeType("GLenum") int plane, @NativeType("GLdouble const *") DoubleBuffer equation) {
/*  821 */     if (Checks.CHECKS) {
/*  822 */       Checks.check(equation, 4);
/*      */     }
/*  824 */     nglClipPlane(plane, MemoryUtil.memAddress(equation));
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
/*      */   public static void glColor3bv(@NativeType("GLbyte const *") ByteBuffer v) {
/*  874 */     if (Checks.CHECKS) {
/*  875 */       Checks.check(v, 3);
/*      */     }
/*  877 */     nglColor3bv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3sv(@NativeType("GLshort const *") ShortBuffer v) {
/*  887 */     if (Checks.CHECKS) {
/*  888 */       Checks.check(v, 3);
/*      */     }
/*  890 */     nglColor3sv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3iv(@NativeType("GLint const *") IntBuffer v) {
/*  900 */     if (Checks.CHECKS) {
/*  901 */       Checks.check(v, 3);
/*      */     }
/*  903 */     nglColor3iv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3fv(@NativeType("GLfloat const *") FloatBuffer v) {
/*  913 */     if (Checks.CHECKS) {
/*  914 */       Checks.check(v, 3);
/*      */     }
/*  916 */     nglColor3fv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3dv(@NativeType("GLdouble const *") DoubleBuffer v) {
/*  926 */     if (Checks.CHECKS) {
/*  927 */       Checks.check(v, 3);
/*      */     }
/*  929 */     nglColor3dv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3ubv(@NativeType("GLubyte const *") ByteBuffer v) {
/*  939 */     if (Checks.CHECKS) {
/*  940 */       Checks.check(v, 3);
/*      */     }
/*  942 */     nglColor3ubv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3usv(@NativeType("GLushort const *") ShortBuffer v) {
/*  952 */     if (Checks.CHECKS) {
/*  953 */       Checks.check(v, 3);
/*      */     }
/*  955 */     nglColor3usv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3uiv(@NativeType("GLuint const *") IntBuffer v) {
/*  965 */     if (Checks.CHECKS) {
/*  966 */       Checks.check(v, 3);
/*      */     }
/*  968 */     nglColor3uiv(MemoryUtil.memAddress(v));
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
/*      */   public static void glColor4bv(@NativeType("GLbyte const *") ByteBuffer v) {
/* 1018 */     if (Checks.CHECKS) {
/* 1019 */       Checks.check(v, 4);
/*      */     }
/* 1021 */     nglColor4bv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4sv(@NativeType("GLshort const *") ShortBuffer v) {
/* 1031 */     if (Checks.CHECKS) {
/* 1032 */       Checks.check(v, 4);
/*      */     }
/* 1034 */     nglColor4sv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4iv(@NativeType("GLint const *") IntBuffer v) {
/* 1044 */     if (Checks.CHECKS) {
/* 1045 */       Checks.check(v, 4);
/*      */     }
/* 1047 */     nglColor4iv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4fv(@NativeType("GLfloat const *") FloatBuffer v) {
/* 1057 */     if (Checks.CHECKS) {
/* 1058 */       Checks.check(v, 4);
/*      */     }
/* 1060 */     nglColor4fv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4dv(@NativeType("GLdouble const *") DoubleBuffer v) {
/* 1070 */     if (Checks.CHECKS) {
/* 1071 */       Checks.check(v, 4);
/*      */     }
/* 1073 */     nglColor4dv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4ubv(@NativeType("GLubyte const *") ByteBuffer v) {
/* 1083 */     if (Checks.CHECKS) {
/* 1084 */       Checks.check(v, 4);
/*      */     }
/* 1086 */     nglColor4ubv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4usv(@NativeType("GLushort const *") ShortBuffer v) {
/* 1096 */     if (Checks.CHECKS) {
/* 1097 */       Checks.check(v, 4);
/*      */     }
/* 1099 */     nglColor4usv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4uiv(@NativeType("GLuint const *") IntBuffer v) {
/* 1109 */     if (Checks.CHECKS) {
/* 1110 */       Checks.check(v, 4);
/*      */     }
/* 1112 */     nglColor4uiv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorMask(@NativeType("GLboolean") boolean red, @NativeType("GLboolean") boolean green, @NativeType("GLboolean") boolean blue, @NativeType("GLboolean") boolean alpha) {
/* 1119 */     GL11C.glColorMask(red, green, blue, alpha);
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
/*      */   public static void glColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 1134 */     nglColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 1139 */     nglColorPointer(size, type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 1144 */     nglColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 1149 */     nglColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColorPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 1154 */     nglColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
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
/*      */   public static void glCullFace(@NativeType("GLenum") int mode) {
/* 1166 */     GL11C.glCullFace(mode);
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
/*      */   public static void glDepthFunc(@NativeType("GLenum") int func) {
/* 1178 */     GL11C.glDepthFunc(func);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthMask(@NativeType("GLboolean") boolean flag) {
/* 1185 */     GL11C.glDepthMask(flag);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthRange(@NativeType("GLdouble") double zNear, @NativeType("GLdouble") double zFar) {
/* 1192 */     GL11C.glDepthRange(zNear, zFar);
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
/*      */   public static void glDrawArrays(@NativeType("GLenum") int mode, @NativeType("GLint") int first, @NativeType("GLsizei") int count) {
/* 1204 */     GL11C.glDrawArrays(mode, first, count);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawBuffer(@NativeType("GLenum") int buf) {
/* 1211 */     GL11C.glDrawBuffer(buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDrawElements(int mode, int count, int type, long indices) {
/* 1218 */     GL11C.nglDrawElements(mode, count, type, indices);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices) {
/* 1223 */     GL11C.glDrawElements(mode, count, type, indices);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices) {
/* 1228 */     GL11C.glDrawElements(mode, type, indices);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices) {
/* 1233 */     GL11C.glDrawElements(mode, indices);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices) {
/* 1238 */     GL11C.glDrawElements(mode, indices);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices) {
/* 1243 */     GL11C.glDrawElements(mode, indices);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/* 1253 */     nglDrawPixels(width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/* 1258 */     nglDrawPixels(width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/* 1263 */     nglDrawPixels(width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 1268 */     nglDrawPixels(width, height, format, type, MemoryUtil.memAddress(pixels));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 1273 */     nglDrawPixels(width, height, format, type, MemoryUtil.memAddress(pixels));
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
/*      */   public static void glEdgeFlagv(@NativeType("GLboolean const *") ByteBuffer flag) {
/* 1288 */     if (Checks.CHECKS) {
/* 1289 */       Checks.check(flag, 1);
/*      */     }
/* 1291 */     nglEdgeFlagv(MemoryUtil.memAddress(flag));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEdgeFlagPointer(@NativeType("GLsizei") int stride, @NativeType("GLboolean const *") ByteBuffer pointer) {
/* 1301 */     nglEdgeFlagPointer(stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glEdgeFlagPointer(@NativeType("GLsizei") int stride, @NativeType("GLboolean const *") long pointer) {
/* 1306 */     nglEdgeFlagPointer(stride, pointer);
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
/*      */   public static void glEvalCoord1fv(@NativeType("GLfloat const *") FloatBuffer u) {
/* 1331 */     if (Checks.CHECKS) {
/* 1332 */       Checks.check(u, 1);
/*      */     }
/* 1334 */     nglEvalCoord1fv(MemoryUtil.memAddress(u));
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
/*      */   public static void glEvalCoord1dv(@NativeType("GLdouble const *") DoubleBuffer u) {
/* 1349 */     if (Checks.CHECKS) {
/* 1350 */       Checks.check(u, 1);
/*      */     }
/* 1352 */     nglEvalCoord1dv(MemoryUtil.memAddress(u));
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
/*      */   public static void glEvalCoord2fv(@NativeType("GLfloat const *") FloatBuffer u) {
/* 1367 */     if (Checks.CHECKS) {
/* 1368 */       Checks.check(u, 2);
/*      */     }
/* 1370 */     nglEvalCoord2fv(MemoryUtil.memAddress(u));
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
/*      */   public static void glEvalCoord2dv(@NativeType("GLdouble const *") DoubleBuffer u) {
/* 1385 */     if (Checks.CHECKS) {
/* 1386 */       Checks.check(u, 2);
/*      */     }
/* 1388 */     nglEvalCoord2dv(MemoryUtil.memAddress(u));
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
/*      */   public static void glFeedbackBuffer(@NativeType("GLenum") int type, @NativeType("GLfloat *") FloatBuffer buffer) {
/* 1418 */     nglFeedbackBuffer(buffer.remaining(), type, MemoryUtil.memAddress(buffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFinish() {
/* 1425 */     GL11C.glFinish();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFlush() {
/* 1432 */     GL11C.glFlush();
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
/*      */   public static void glFogiv(@NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 1447 */     if (Checks.CHECKS) {
/* 1448 */       Checks.check(params, 1);
/*      */     }
/* 1450 */     nglFogiv(pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glFogfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 1465 */     if (Checks.CHECKS) {
/* 1466 */       Checks.check(params, 1);
/*      */     }
/* 1468 */     nglFogfv(pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFrontFace(@NativeType("GLenum") int dir) {
/* 1475 */     GL11C.glFrontFace(dir);
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
/*      */   public static void nglGenTextures(int n, long textures) {
/* 1488 */     GL11C.nglGenTextures(n, textures);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenTextures(@NativeType("GLuint *") IntBuffer textures) {
/* 1493 */     GL11C.glGenTextures(textures);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenTextures() {
/* 1499 */     return GL11C.glGenTextures();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteTextures(int n, long textures) {
/* 1506 */     GL11C.nglDeleteTextures(n, textures);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") IntBuffer textures) {
/* 1511 */     GL11C.glDeleteTextures(textures);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") int texture) {
/* 1516 */     GL11C.glDeleteTextures(texture);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetClipPlane(@NativeType("GLenum") int plane, @NativeType("GLdouble *") DoubleBuffer equation) {
/* 1526 */     if (Checks.CHECKS) {
/* 1527 */       Checks.check(equation, 4);
/*      */     }
/* 1529 */     nglGetClipPlane(plane, MemoryUtil.memAddress(equation));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetBooleanv(int pname, long params) {
/* 1536 */     GL11C.nglGetBooleanv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetBooleanv(@NativeType("GLenum") int pname, @NativeType("GLboolean *") ByteBuffer params) {
/* 1541 */     GL11C.glGetBooleanv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static boolean glGetBoolean(@NativeType("GLenum") int pname) {
/* 1547 */     return GL11C.glGetBoolean(pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetFloatv(int pname, long params) {
/* 1554 */     GL11C.nglGetFloatv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloatv(@NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1559 */     GL11C.glGetFloatv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetFloat(@NativeType("GLenum") int pname) {
/* 1565 */     return GL11C.glGetFloat(pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetIntegerv(int pname, long params) {
/* 1572 */     GL11C.nglGetIntegerv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetIntegerv(@NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1577 */     GL11C.glGetIntegerv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetInteger(@NativeType("GLenum") int pname) {
/* 1583 */     return GL11C.glGetInteger(pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetDoublev(int pname, long params) {
/* 1590 */     GL11C.nglGetDoublev(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoublev(@NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/* 1595 */     GL11C.glGetDoublev(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetDouble(@NativeType("GLenum") int pname) {
/* 1601 */     return GL11C.glGetDouble(pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glGetError() {
/* 1609 */     return GL11C.glGetError();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetLightiv(@NativeType("GLenum") int light, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer data) {
/* 1619 */     if (Checks.CHECKS) {
/* 1620 */       Checks.check(data, 4);
/*      */     }
/* 1622 */     nglGetLightiv(light, pname, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetLighti(@NativeType("GLenum") int light, @NativeType("GLenum") int pname) {
/* 1628 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1630 */       IntBuffer data = stack.callocInt(1);
/* 1631 */       nglGetLightiv(light, pname, MemoryUtil.memAddress(data));
/* 1632 */       return data.get(0);
/*      */     } finally {
/* 1634 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetLightfv(@NativeType("GLenum") int light, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer data) {
/* 1645 */     if (Checks.CHECKS) {
/* 1646 */       Checks.check(data, 4);
/*      */     }
/* 1648 */     nglGetLightfv(light, pname, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetLightf(@NativeType("GLenum") int light, @NativeType("GLenum") int pname) {
/* 1654 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1656 */       FloatBuffer data = stack.callocFloat(1);
/* 1657 */       nglGetLightfv(light, pname, MemoryUtil.memAddress(data));
/* 1658 */       return data.get(0);
/*      */     } finally {
/* 1660 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMapiv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLint *") IntBuffer data) {
/* 1671 */     if (Checks.CHECKS) {
/* 1672 */       Checks.check(data, 4);
/*      */     }
/* 1674 */     nglGetMapiv(target, query, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetMapi(@NativeType("GLenum") int target, @NativeType("GLenum") int query) {
/* 1680 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1682 */       IntBuffer data = stack.callocInt(1);
/* 1683 */       nglGetMapiv(target, query, MemoryUtil.memAddress(data));
/* 1684 */       return data.get(0);
/*      */     } finally {
/* 1686 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMapfv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLfloat *") FloatBuffer data) {
/* 1697 */     if (Checks.CHECKS) {
/* 1698 */       Checks.check(data, 4);
/*      */     }
/* 1700 */     nglGetMapfv(target, query, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetMapf(@NativeType("GLenum") int target, @NativeType("GLenum") int query) {
/* 1706 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1708 */       FloatBuffer data = stack.callocFloat(1);
/* 1709 */       nglGetMapfv(target, query, MemoryUtil.memAddress(data));
/* 1710 */       return data.get(0);
/*      */     } finally {
/* 1712 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMapdv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLdouble *") DoubleBuffer data) {
/* 1723 */     if (Checks.CHECKS) {
/* 1724 */       Checks.check(data, 4);
/*      */     }
/* 1726 */     nglGetMapdv(target, query, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetMapd(@NativeType("GLenum") int target, @NativeType("GLenum") int query) {
/* 1732 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1734 */       DoubleBuffer data = stack.callocDouble(1);
/* 1735 */       nglGetMapdv(target, query, MemoryUtil.memAddress(data));
/* 1736 */       return data.get(0);
/*      */     } finally {
/* 1738 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMaterialiv(@NativeType("GLenum") int face, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer data) {
/* 1749 */     if (Checks.CHECKS) {
/* 1750 */       Checks.check(data, 1);
/*      */     }
/* 1752 */     nglGetMaterialiv(face, pname, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMaterialfv(@NativeType("GLenum") int face, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer data) {
/* 1762 */     if (Checks.CHECKS) {
/* 1763 */       Checks.check(data, 1);
/*      */     }
/* 1765 */     nglGetMaterialfv(face, pname, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapfv(@NativeType("GLenum") int map, @NativeType("GLfloat *") FloatBuffer data) {
/* 1775 */     if (Checks.CHECKS) {
/* 1776 */       Checks.check(data, 32);
/*      */     }
/* 1778 */     nglGetPixelMapfv(map, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapfv(@NativeType("GLenum") int map, @NativeType("GLfloat *") long data) {
/* 1783 */     nglGetPixelMapfv(map, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapusv(@NativeType("GLenum") int map, @NativeType("GLushort *") ShortBuffer data) {
/* 1793 */     if (Checks.CHECKS) {
/* 1794 */       Checks.check(data, 32);
/*      */     }
/* 1796 */     nglGetPixelMapusv(map, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapusv(@NativeType("GLenum") int map, @NativeType("GLushort *") long data) {
/* 1801 */     nglGetPixelMapusv(map, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapuiv(@NativeType("GLenum") int map, @NativeType("GLuint *") IntBuffer data) {
/* 1811 */     if (Checks.CHECKS) {
/* 1812 */       Checks.check(data, 32);
/*      */     }
/* 1814 */     nglGetPixelMapuiv(map, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapuiv(@NativeType("GLenum") int map, @NativeType("GLuint *") long data) {
/* 1819 */     nglGetPixelMapuiv(map, data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetPointerv(int pname, long params) {
/* 1826 */     GL11C.nglGetPointerv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPointerv(@NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer params) {
/* 1831 */     GL11C.glGetPointerv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetPointer(@NativeType("GLenum") int pname) {
/* 1837 */     return GL11C.glGetPointer(pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPolygonStipple(@NativeType("void *") ByteBuffer pattern) {
/* 1847 */     if (Checks.CHECKS) {
/* 1848 */       Checks.check(pattern, 128);
/*      */     }
/* 1850 */     nglGetPolygonStipple(MemoryUtil.memAddress(pattern));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPolygonStipple(@NativeType("void *") long pattern) {
/* 1855 */     nglGetPolygonStipple(pattern);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglGetString(int name) {
/* 1862 */     return GL11C.nglGetString(name);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLubyte const *")
/*      */   public static String glGetString(@NativeType("GLenum") int name) {
/* 1868 */     return GL11C.glGetString(name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexEnviv(@NativeType("GLenum") int env, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer data) {
/* 1878 */     if (Checks.CHECKS) {
/* 1879 */       Checks.check(data, 1);
/*      */     }
/* 1881 */     nglGetTexEnviv(env, pname, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTexEnvi(@NativeType("GLenum") int env, @NativeType("GLenum") int pname) {
/* 1887 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1889 */       IntBuffer data = stack.callocInt(1);
/* 1890 */       nglGetTexEnviv(env, pname, MemoryUtil.memAddress(data));
/* 1891 */       return data.get(0);
/*      */     } finally {
/* 1893 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexEnvfv(@NativeType("GLenum") int env, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer data) {
/* 1904 */     if (Checks.CHECKS) {
/* 1905 */       Checks.check(data, 1);
/*      */     }
/* 1907 */     nglGetTexEnvfv(env, pname, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTexEnvf(@NativeType("GLenum") int env, @NativeType("GLenum") int pname) {
/* 1913 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1915 */       FloatBuffer data = stack.callocFloat(1);
/* 1916 */       nglGetTexEnvfv(env, pname, MemoryUtil.memAddress(data));
/* 1917 */       return data.get(0);
/*      */     } finally {
/* 1919 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexGeniv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer data) {
/* 1930 */     if (Checks.CHECKS) {
/* 1931 */       Checks.check(data, 1);
/*      */     }
/* 1933 */     nglGetTexGeniv(coord, pname, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTexGeni(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname) {
/* 1939 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1941 */       IntBuffer data = stack.callocInt(1);
/* 1942 */       nglGetTexGeniv(coord, pname, MemoryUtil.memAddress(data));
/* 1943 */       return data.get(0);
/*      */     } finally {
/* 1945 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexGenfv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer data) {
/* 1956 */     if (Checks.CHECKS) {
/* 1957 */       Checks.check(data, 4);
/*      */     }
/* 1959 */     nglGetTexGenfv(coord, pname, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTexGenf(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname) {
/* 1965 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1967 */       FloatBuffer data = stack.callocFloat(1);
/* 1968 */       nglGetTexGenfv(coord, pname, MemoryUtil.memAddress(data));
/* 1969 */       return data.get(0);
/*      */     } finally {
/* 1971 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexGendv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer data) {
/* 1982 */     if (Checks.CHECKS) {
/* 1983 */       Checks.check(data, 4);
/*      */     }
/* 1985 */     nglGetTexGendv(coord, pname, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetTexGend(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname) {
/* 1991 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1993 */       DoubleBuffer data = stack.callocDouble(1);
/* 1994 */       nglGetTexGendv(coord, pname, MemoryUtil.memAddress(data));
/* 1995 */       return data.get(0);
/*      */     } finally {
/* 1997 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexImage(int tex, int level, int format, int type, long pixels) {
/* 2005 */     GL11C.nglGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 2010 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long pixels) {
/* 2015 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 2020 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 2025 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 2030 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") DoubleBuffer pixels) {
/* 2035 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexLevelParameteriv(int target, int level, int pname, long params) {
/* 2042 */     GL11C.nglGetTexLevelParameteriv(target, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameteriv(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 2047 */     GL11C.glGetTexLevelParameteriv(target, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTexLevelParameteri(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 2053 */     return GL11C.glGetTexLevelParameteri(target, level, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexLevelParameterfv(int target, int level, int pname, long params) {
/* 2060 */     GL11C.nglGetTexLevelParameterfv(target, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameterfv(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 2065 */     GL11C.glGetTexLevelParameterfv(target, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTexLevelParameterf(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname) {
/* 2071 */     return GL11C.glGetTexLevelParameterf(target, level, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexParameteriv(int target, int pname, long params) {
/* 2078 */     GL11C.nglGetTexParameteriv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 2083 */     GL11C.glGetTexParameteriv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTexParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 2089 */     return GL11C.glGetTexParameteri(target, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexParameterfv(int target, int pname, long params) {
/* 2096 */     GL11C.nglGetTexParameterfv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 2101 */     GL11C.glGetTexParameterfv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTexParameterf(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 2107 */     return GL11C.glGetTexParameterf(target, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glHint(@NativeType("GLenum") int target, @NativeType("GLenum") int hint) {
/* 2114 */     GL11C.glHint(target, hint);
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
/*      */   public static void glIndexiv(@NativeType("GLint const *") IntBuffer index) {
/* 2149 */     if (Checks.CHECKS) {
/* 2150 */       Checks.check(index, 1);
/*      */     }
/* 2152 */     nglIndexiv(MemoryUtil.memAddress(index));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexubv(@NativeType("GLubyte const *") ByteBuffer index) {
/* 2162 */     if (Checks.CHECKS) {
/* 2163 */       Checks.check(index, 1);
/*      */     }
/* 2165 */     nglIndexubv(MemoryUtil.memAddress(index));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexsv(@NativeType("GLshort const *") ShortBuffer index) {
/* 2175 */     if (Checks.CHECKS) {
/* 2176 */       Checks.check(index, 1);
/*      */     }
/* 2178 */     nglIndexsv(MemoryUtil.memAddress(index));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexfv(@NativeType("GLfloat const *") FloatBuffer index) {
/* 2188 */     if (Checks.CHECKS) {
/* 2189 */       Checks.check(index, 1);
/*      */     }
/* 2191 */     nglIndexfv(MemoryUtil.memAddress(index));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexdv(@NativeType("GLdouble const *") DoubleBuffer index) {
/* 2201 */     if (Checks.CHECKS) {
/* 2202 */       Checks.check(index, 1);
/*      */     }
/* 2204 */     nglIndexdv(MemoryUtil.memAddress(index));
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
/*      */   public static void glIndexPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 2219 */     nglIndexPointer(type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glIndexPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 2224 */     nglIndexPointer(type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glIndexPointer(@NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 2229 */     nglIndexPointer(5121, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glIndexPointer(@NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 2234 */     nglIndexPointer(5122, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glIndexPointer(@NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 2239 */     nglIndexPointer(5124, stride, MemoryUtil.memAddress(pointer));
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
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 2254 */     nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 2259 */     nglInterleavedArrays(format, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 2264 */     nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 2269 */     nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 2274 */     nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") DoubleBuffer pointer) {
/* 2279 */     nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsEnabled(@NativeType("GLenum") int cap) {
/* 2287 */     return GL11C.glIsEnabled(cap);
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsTexture(@NativeType("GLuint") int texture) {
/* 2301 */     return GL11C.glIsTexture(texture);
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
/*      */   public static void glLightModeliv(@NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 2321 */     if (Checks.CHECKS) {
/* 2322 */       Checks.check(params, 4);
/*      */     }
/* 2324 */     nglLightModeliv(pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightModelfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 2334 */     if (Checks.CHECKS) {
/* 2335 */       Checks.check(params, 4);
/*      */     }
/* 2337 */     nglLightModelfv(pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glLightiv(@NativeType("GLenum") int light, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 2357 */     if (Checks.CHECKS) {
/* 2358 */       Checks.check(params, 4);
/*      */     }
/* 2360 */     nglLightiv(light, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightfv(@NativeType("GLenum") int light, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 2370 */     if (Checks.CHECKS) {
/* 2371 */       Checks.check(params, 4);
/*      */     }
/* 2373 */     nglLightfv(light, pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glLineWidth(@NativeType("GLfloat") float width) {
/* 2385 */     GL11C.glLineWidth(width);
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
/*      */   public static void glLoadMatrixf(@NativeType("GLfloat const *") FloatBuffer m) {
/* 2400 */     if (Checks.CHECKS) {
/* 2401 */       Checks.check(m, 16);
/*      */     }
/* 2403 */     nglLoadMatrixf(MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLoadMatrixd(@NativeType("GLdouble const *") DoubleBuffer m) {
/* 2413 */     if (Checks.CHECKS) {
/* 2414 */       Checks.check(m, 16);
/*      */     }
/* 2416 */     nglLoadMatrixd(MemoryUtil.memAddress(m));
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
/*      */   public static void glLogicOp(@NativeType("GLenum") int op) {
/* 2433 */     GL11C.glLogicOp(op);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap1f(@NativeType("GLenum") int target, @NativeType("GLfloat") float u1, @NativeType("GLfloat") float u2, @NativeType("GLint") int stride, @NativeType("GLint") int order, @NativeType("GLfloat const *") FloatBuffer points) {
/* 2443 */     if (Checks.CHECKS) {
/* 2444 */       Checks.check(points, order * stride);
/*      */     }
/* 2446 */     nglMap1f(target, u1, u2, stride, order, MemoryUtil.memAddress(points));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap1d(@NativeType("GLenum") int target, @NativeType("GLdouble") double u1, @NativeType("GLdouble") double u2, @NativeType("GLint") int stride, @NativeType("GLint") int order, @NativeType("GLdouble const *") DoubleBuffer points) {
/* 2456 */     if (Checks.CHECKS) {
/* 2457 */       Checks.check(points, stride * order);
/*      */     }
/* 2459 */     nglMap1d(target, u1, u2, stride, order, MemoryUtil.memAddress(points));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap2f(@NativeType("GLenum") int target, @NativeType("GLfloat") float u1, @NativeType("GLfloat") float u2, @NativeType("GLint") int ustride, @NativeType("GLint") int uorder, @NativeType("GLfloat") float v1, @NativeType("GLfloat") float v2, @NativeType("GLint") int vstride, @NativeType("GLint") int vorder, @NativeType("GLfloat const *") FloatBuffer points) {
/* 2469 */     if (Checks.CHECKS) {
/* 2470 */       Checks.check(points, ustride * uorder * vstride * vorder);
/*      */     }
/* 2472 */     nglMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, MemoryUtil.memAddress(points));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap2d(@NativeType("GLenum") int target, @NativeType("GLdouble") double u1, @NativeType("GLdouble") double u2, @NativeType("GLint") int ustride, @NativeType("GLint") int uorder, @NativeType("GLdouble") double v1, @NativeType("GLdouble") double v2, @NativeType("GLint") int vstride, @NativeType("GLint") int vorder, @NativeType("GLdouble const *") DoubleBuffer points) {
/* 2482 */     if (Checks.CHECKS) {
/* 2483 */       Checks.check(points, ustride * uorder * vstride * vorder);
/*      */     }
/* 2485 */     nglMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, MemoryUtil.memAddress(points));
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
/*      */   public static void glMaterialiv(@NativeType("GLenum") int face, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 2525 */     if (Checks.CHECKS) {
/* 2526 */       Checks.check(params, 4);
/*      */     }
/* 2528 */     nglMaterialiv(face, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMaterialfv(@NativeType("GLenum") int face, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 2538 */     if (Checks.CHECKS) {
/* 2539 */       Checks.check(params, 4);
/*      */     }
/* 2541 */     nglMaterialfv(face, pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glMultMatrixf(@NativeType("GLfloat const *") FloatBuffer m) {
/* 2556 */     if (Checks.CHECKS) {
/* 2557 */       Checks.check(m, 16);
/*      */     }
/* 2559 */     nglMultMatrixf(MemoryUtil.memAddress(m));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultMatrixd(@NativeType("GLdouble const *") DoubleBuffer m) {
/* 2569 */     if (Checks.CHECKS) {
/* 2570 */       Checks.check(m, 16);
/*      */     }
/* 2572 */     nglMultMatrixd(MemoryUtil.memAddress(m));
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
/*      */   public static void glNormal3fv(@NativeType("GLfloat const *") FloatBuffer v) {
/* 2622 */     if (Checks.CHECKS) {
/* 2623 */       Checks.check(v, 3);
/*      */     }
/* 2625 */     nglNormal3fv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3bv(@NativeType("GLbyte const *") ByteBuffer v) {
/* 2635 */     if (Checks.CHECKS) {
/* 2636 */       Checks.check(v, 3);
/*      */     }
/* 2638 */     nglNormal3bv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3sv(@NativeType("GLshort const *") ShortBuffer v) {
/* 2648 */     if (Checks.CHECKS) {
/* 2649 */       Checks.check(v, 3);
/*      */     }
/* 2651 */     nglNormal3sv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3iv(@NativeType("GLint const *") IntBuffer v) {
/* 2661 */     if (Checks.CHECKS) {
/* 2662 */       Checks.check(v, 3);
/*      */     }
/* 2664 */     nglNormal3iv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3dv(@NativeType("GLdouble const *") DoubleBuffer v) {
/* 2674 */     if (Checks.CHECKS) {
/* 2675 */       Checks.check(v, 3);
/*      */     }
/* 2677 */     nglNormal3dv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 2687 */     nglNormalPointer(type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 2692 */     nglNormalPointer(type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 2697 */     nglNormalPointer(type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 2702 */     nglNormalPointer(type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 2707 */     nglNormalPointer(type, stride, MemoryUtil.memAddress(pointer));
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
/*      */   public static void glPixelMapfv(@NativeType("GLenum") int map, @NativeType("GLsizei") int size, @NativeType("GLfloat const *") long values) {
/* 2727 */     nglPixelMapfv(map, size, values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPixelMapfv(@NativeType("GLenum") int map, @NativeType("GLfloat const *") FloatBuffer values) {
/* 2732 */     nglPixelMapfv(map, values.remaining(), MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapusv(@NativeType("GLenum") int map, @NativeType("GLsizei") int size, @NativeType("GLushort const *") long values) {
/* 2742 */     nglPixelMapusv(map, size, values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPixelMapusv(@NativeType("GLenum") int map, @NativeType("GLushort const *") ShortBuffer values) {
/* 2747 */     nglPixelMapusv(map, values.remaining(), MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapuiv(@NativeType("GLenum") int map, @NativeType("GLsizei") int size, @NativeType("GLuint const *") long values) {
/* 2757 */     nglPixelMapuiv(map, size, values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPixelMapuiv(@NativeType("GLenum") int map, @NativeType("GLuint const *") IntBuffer values) {
/* 2762 */     nglPixelMapuiv(map, values.remaining(), MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelStorei(@NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/* 2769 */     GL11C.glPixelStorei(pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelStoref(@NativeType("GLenum") int pname, @NativeType("GLfloat") float param) {
/* 2776 */     GL11C.glPixelStoref(pname, param);
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
/*      */   public static void glPointSize(@NativeType("GLfloat") float size) {
/* 2798 */     GL11C.glPointSize(size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPolygonMode(@NativeType("GLenum") int face, @NativeType("GLenum") int mode) {
/* 2805 */     GL11C.glPolygonMode(face, mode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPolygonOffset(@NativeType("GLfloat") float factor, @NativeType("GLfloat") float units) {
/* 2812 */     GL11C.glPolygonOffset(factor, units);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPolygonStipple(@NativeType("GLubyte const *") ByteBuffer pattern) {
/* 2822 */     if (Checks.CHECKS) {
/* 2823 */       Checks.check(pattern, 128);
/*      */     }
/* 2825 */     nglPolygonStipple(MemoryUtil.memAddress(pattern));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPolygonStipple(@NativeType("GLubyte const *") long pattern) {
/* 2830 */     nglPolygonStipple(pattern);
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
/*      */   public static void glPrioritizeTextures(@NativeType("GLuint const *") IntBuffer textures, @NativeType("GLfloat const *") FloatBuffer priorities) {
/* 2870 */     if (Checks.CHECKS) {
/* 2871 */       Checks.check(priorities, textures.remaining());
/*      */     }
/* 2873 */     nglPrioritizeTextures(textures.remaining(), MemoryUtil.memAddress(textures), MemoryUtil.memAddress(priorities));
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
/*      */   public static void glRasterPos2iv(@NativeType("GLint const *") IntBuffer coords) {
/* 2913 */     if (Checks.CHECKS) {
/* 2914 */       Checks.check(coords, 2);
/*      */     }
/* 2916 */     nglRasterPos2iv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2sv(@NativeType("GLshort const *") ShortBuffer coords) {
/* 2926 */     if (Checks.CHECKS) {
/* 2927 */       Checks.check(coords, 2);
/*      */     }
/* 2929 */     nglRasterPos2sv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2fv(@NativeType("GLfloat const *") FloatBuffer coords) {
/* 2939 */     if (Checks.CHECKS) {
/* 2940 */       Checks.check(coords, 2);
/*      */     }
/* 2942 */     nglRasterPos2fv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2dv(@NativeType("GLdouble const *") DoubleBuffer coords) {
/* 2952 */     if (Checks.CHECKS) {
/* 2953 */       Checks.check(coords, 2);
/*      */     }
/* 2955 */     nglRasterPos2dv(MemoryUtil.memAddress(coords));
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
/*      */   public static void glRasterPos3iv(@NativeType("GLint const *") IntBuffer coords) {
/* 2985 */     if (Checks.CHECKS) {
/* 2986 */       Checks.check(coords, 3);
/*      */     }
/* 2988 */     nglRasterPos3iv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3sv(@NativeType("GLshort const *") ShortBuffer coords) {
/* 2998 */     if (Checks.CHECKS) {
/* 2999 */       Checks.check(coords, 3);
/*      */     }
/* 3001 */     nglRasterPos3sv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3fv(@NativeType("GLfloat const *") FloatBuffer coords) {
/* 3011 */     if (Checks.CHECKS) {
/* 3012 */       Checks.check(coords, 3);
/*      */     }
/* 3014 */     nglRasterPos3fv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3dv(@NativeType("GLdouble const *") DoubleBuffer coords) {
/* 3024 */     if (Checks.CHECKS) {
/* 3025 */       Checks.check(coords, 3);
/*      */     }
/* 3027 */     nglRasterPos3dv(MemoryUtil.memAddress(coords));
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
/*      */   public static void glRasterPos4iv(@NativeType("GLint const *") IntBuffer coords) {
/* 3057 */     if (Checks.CHECKS) {
/* 3058 */       Checks.check(coords, 4);
/*      */     }
/* 3060 */     nglRasterPos4iv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4sv(@NativeType("GLshort const *") ShortBuffer coords) {
/* 3070 */     if (Checks.CHECKS) {
/* 3071 */       Checks.check(coords, 4);
/*      */     }
/* 3073 */     nglRasterPos4sv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4fv(@NativeType("GLfloat const *") FloatBuffer coords) {
/* 3083 */     if (Checks.CHECKS) {
/* 3084 */       Checks.check(coords, 4);
/*      */     }
/* 3086 */     nglRasterPos4fv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4dv(@NativeType("GLdouble const *") DoubleBuffer coords) {
/* 3096 */     if (Checks.CHECKS) {
/* 3097 */       Checks.check(coords, 4);
/*      */     }
/* 3099 */     nglRasterPos4dv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadBuffer(@NativeType("GLenum") int src) {
/* 3106 */     GL11C.glReadBuffer(src);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglReadPixels(int x, int y, int width, int height, int format, int type, long pixels) {
/* 3113 */     GL11C.nglReadPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ByteBuffer pixels) {
/* 3118 */     GL11C.glReadPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") long pixels) {
/* 3123 */     GL11C.glReadPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") ShortBuffer pixels) {
/* 3128 */     GL11C.glReadPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") IntBuffer pixels) {
/* 3133 */     GL11C.glReadPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") FloatBuffer pixels) {
/* 3138 */     GL11C.glReadPixels(x, y, width, height, format, type, pixels);
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
/*      */   public static void glRectiv(@NativeType("GLint const *") IntBuffer v1, @NativeType("GLint const *") IntBuffer v2) {
/* 3168 */     if (Checks.CHECKS) {
/* 3169 */       Checks.check(v1, 2);
/* 3170 */       Checks.check(v2, 2);
/*      */     } 
/* 3172 */     nglRectiv(MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectsv(@NativeType("GLshort const *") ShortBuffer v1, @NativeType("GLshort const *") ShortBuffer v2) {
/* 3182 */     if (Checks.CHECKS) {
/* 3183 */       Checks.check(v1, 2);
/* 3184 */       Checks.check(v2, 2);
/*      */     } 
/* 3186 */     nglRectsv(MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectfv(@NativeType("GLfloat const *") FloatBuffer v1, @NativeType("GLfloat const *") FloatBuffer v2) {
/* 3196 */     if (Checks.CHECKS) {
/* 3197 */       Checks.check(v1, 2);
/* 3198 */       Checks.check(v2, 2);
/*      */     } 
/* 3200 */     nglRectfv(MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectdv(@NativeType("GLdouble const *") DoubleBuffer v1, @NativeType("GLdouble const *") DoubleBuffer v2) {
/* 3210 */     if (Checks.CHECKS) {
/* 3211 */       Checks.check(v1, 2);
/* 3212 */       Checks.check(v2, 2);
/*      */     } 
/* 3214 */     nglRectdv(MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2));
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
/*      */   public static void glScissor(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 3247 */     GL11C.glScissor(x, y, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSelectBuffer(@NativeType("GLuint *") IntBuffer buffer) {
/* 3257 */     nglSelectBuffer(buffer.remaining(), MemoryUtil.memAddress(buffer));
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
/*      */   public static void glStencilFunc(@NativeType("GLenum") int func, @NativeType("GLint") int ref, @NativeType("GLuint") int mask) {
/* 3269 */     GL11C.glStencilFunc(func, ref, mask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilMask(@NativeType("GLuint") int mask) {
/* 3276 */     GL11C.glStencilMask(mask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilOp(@NativeType("GLenum") int sfail, @NativeType("GLenum") int dpfail, @NativeType("GLenum") int dppass) {
/* 3283 */     GL11C.glStencilOp(sfail, dpfail, dppass);
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
/*      */   public static void glTexCoord1fv(@NativeType("GLfloat const *") FloatBuffer v) {
/* 3313 */     if (Checks.CHECKS) {
/* 3314 */       Checks.check(v, 1);
/*      */     }
/* 3316 */     nglTexCoord1fv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1sv(@NativeType("GLshort const *") ShortBuffer v) {
/* 3326 */     if (Checks.CHECKS) {
/* 3327 */       Checks.check(v, 1);
/*      */     }
/* 3329 */     nglTexCoord1sv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1iv(@NativeType("GLint const *") IntBuffer v) {
/* 3339 */     if (Checks.CHECKS) {
/* 3340 */       Checks.check(v, 1);
/*      */     }
/* 3342 */     nglTexCoord1iv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1dv(@NativeType("GLdouble const *") DoubleBuffer v) {
/* 3352 */     if (Checks.CHECKS) {
/* 3353 */       Checks.check(v, 1);
/*      */     }
/* 3355 */     nglTexCoord1dv(MemoryUtil.memAddress(v));
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
/*      */   public static void glTexCoord2fv(@NativeType("GLfloat const *") FloatBuffer v) {
/* 3385 */     if (Checks.CHECKS) {
/* 3386 */       Checks.check(v, 2);
/*      */     }
/* 3388 */     nglTexCoord2fv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2sv(@NativeType("GLshort const *") ShortBuffer v) {
/* 3398 */     if (Checks.CHECKS) {
/* 3399 */       Checks.check(v, 2);
/*      */     }
/* 3401 */     nglTexCoord2sv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2iv(@NativeType("GLint const *") IntBuffer v) {
/* 3411 */     if (Checks.CHECKS) {
/* 3412 */       Checks.check(v, 2);
/*      */     }
/* 3414 */     nglTexCoord2iv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2dv(@NativeType("GLdouble const *") DoubleBuffer v) {
/* 3424 */     if (Checks.CHECKS) {
/* 3425 */       Checks.check(v, 2);
/*      */     }
/* 3427 */     nglTexCoord2dv(MemoryUtil.memAddress(v));
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
/*      */   public static void glTexCoord3fv(@NativeType("GLfloat const *") FloatBuffer v) {
/* 3457 */     if (Checks.CHECKS) {
/* 3458 */       Checks.check(v, 3);
/*      */     }
/* 3460 */     nglTexCoord3fv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3sv(@NativeType("GLshort const *") ShortBuffer v) {
/* 3470 */     if (Checks.CHECKS) {
/* 3471 */       Checks.check(v, 3);
/*      */     }
/* 3473 */     nglTexCoord3sv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3iv(@NativeType("GLint const *") IntBuffer v) {
/* 3483 */     if (Checks.CHECKS) {
/* 3484 */       Checks.check(v, 3);
/*      */     }
/* 3486 */     nglTexCoord3iv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3dv(@NativeType("GLdouble const *") DoubleBuffer v) {
/* 3496 */     if (Checks.CHECKS) {
/* 3497 */       Checks.check(v, 3);
/*      */     }
/* 3499 */     nglTexCoord3dv(MemoryUtil.memAddress(v));
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
/*      */   public static void glTexCoord4fv(@NativeType("GLfloat const *") FloatBuffer v) {
/* 3529 */     if (Checks.CHECKS) {
/* 3530 */       Checks.check(v, 4);
/*      */     }
/* 3532 */     nglTexCoord4fv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4sv(@NativeType("GLshort const *") ShortBuffer v) {
/* 3542 */     if (Checks.CHECKS) {
/* 3543 */       Checks.check(v, 4);
/*      */     }
/* 3545 */     nglTexCoord4sv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4iv(@NativeType("GLint const *") IntBuffer v) {
/* 3555 */     if (Checks.CHECKS) {
/* 3556 */       Checks.check(v, 4);
/*      */     }
/* 3558 */     nglTexCoord4iv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4dv(@NativeType("GLdouble const *") DoubleBuffer v) {
/* 3568 */     if (Checks.CHECKS) {
/* 3569 */       Checks.check(v, 4);
/*      */     }
/* 3571 */     nglTexCoord4dv(MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 3581 */     nglTexCoordPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 3586 */     nglTexCoordPointer(size, type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 3591 */     nglTexCoordPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 3596 */     nglTexCoordPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 3601 */     nglTexCoordPointer(size, type, stride, MemoryUtil.memAddress(pointer));
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
/*      */   public static void glTexEnviv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 3616 */     if (Checks.CHECKS) {
/* 3617 */       Checks.check(params, 4);
/*      */     }
/* 3619 */     nglTexEnviv(target, pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glTexEnvfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 3634 */     if (Checks.CHECKS) {
/* 3635 */       Checks.check(params, 4);
/*      */     }
/* 3637 */     nglTexEnvfv(target, pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glTexGeniv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 3652 */     if (Checks.CHECKS) {
/* 3653 */       Checks.check(params, 4);
/*      */     }
/* 3655 */     nglTexGeniv(coord, pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glTexGenfv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 3670 */     if (Checks.CHECKS) {
/* 3671 */       Checks.check(params, 4);
/*      */     }
/* 3673 */     nglTexGenfv(coord, pname, MemoryUtil.memAddress(params));
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
/*      */   public static void glTexGendv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLdouble const *") DoubleBuffer params) {
/* 3688 */     if (Checks.CHECKS) {
/* 3689 */       Checks.check(params, 4);
/*      */     }
/* 3691 */     nglTexGendv(coord, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, long pixels) {
/* 3698 */     GL11C.nglTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/* 3703 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/* 3708 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/* 3713 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 3718 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 3723 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 3728 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, long pixels) {
/* 3735 */     GL11C.nglTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/* 3740 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/* 3745 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/* 3750 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 3755 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 3760 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 3765 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalFormat, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLint") int border) {
/* 3772 */     GL11C.glCopyTexImage1D(target, level, internalFormat, x, y, width, border);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int internalFormat, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border) {
/* 3779 */     GL11C.glCopyTexImage2D(target, level, internalFormat, x, y, width, height, border);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width) {
/* 3786 */     GL11C.glCopyTexSubImage1D(target, level, xoffset, x, y, width);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 3793 */     GL11C.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/* 3800 */     GL11C.glTexParameteri(target, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexParameteriv(int target, int pname, long params) {
/* 3807 */     GL11C.nglTexParameteriv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 3812 */     GL11C.glTexParameteriv(target, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterf(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat") float param) {
/* 3819 */     GL11C.glTexParameterf(target, pname, param);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexParameterfv(int target, int pname, long params) {
/* 3826 */     GL11C.nglTexParameterfv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 3831 */     GL11C.glTexParameterfv(target, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, long pixels) {
/* 3838 */     GL11C.nglTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/* 3843 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/* 3848 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/* 3853 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 3858 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 3863 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 3868 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels) {
/* 3875 */     GL11C.nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer pixels) {
/* 3880 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") long pixels) {
/* 3885 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer pixels) {
/* 3890 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer pixels) {
/* 3895 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer pixels) {
/* 3900 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") DoubleBuffer pixels) {
/* 3905 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
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
/*      */   public static void glVertex2fv(@NativeType("GLfloat const *") FloatBuffer coords) {
/* 3945 */     if (Checks.CHECKS) {
/* 3946 */       Checks.check(coords, 2);
/*      */     }
/* 3948 */     nglVertex2fv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2sv(@NativeType("GLshort const *") ShortBuffer coords) {
/* 3958 */     if (Checks.CHECKS) {
/* 3959 */       Checks.check(coords, 2);
/*      */     }
/* 3961 */     nglVertex2sv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2iv(@NativeType("GLint const *") IntBuffer coords) {
/* 3971 */     if (Checks.CHECKS) {
/* 3972 */       Checks.check(coords, 2);
/*      */     }
/* 3974 */     nglVertex2iv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2dv(@NativeType("GLdouble const *") DoubleBuffer coords) {
/* 3984 */     if (Checks.CHECKS) {
/* 3985 */       Checks.check(coords, 2);
/*      */     }
/* 3987 */     nglVertex2dv(MemoryUtil.memAddress(coords));
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
/*      */   public static void glVertex3fv(@NativeType("GLfloat const *") FloatBuffer coords) {
/* 4017 */     if (Checks.CHECKS) {
/* 4018 */       Checks.check(coords, 3);
/*      */     }
/* 4020 */     nglVertex3fv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3sv(@NativeType("GLshort const *") ShortBuffer coords) {
/* 4030 */     if (Checks.CHECKS) {
/* 4031 */       Checks.check(coords, 3);
/*      */     }
/* 4033 */     nglVertex3sv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3iv(@NativeType("GLint const *") IntBuffer coords) {
/* 4043 */     if (Checks.CHECKS) {
/* 4044 */       Checks.check(coords, 3);
/*      */     }
/* 4046 */     nglVertex3iv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3dv(@NativeType("GLdouble const *") DoubleBuffer coords) {
/* 4056 */     if (Checks.CHECKS) {
/* 4057 */       Checks.check(coords, 3);
/*      */     }
/* 4059 */     nglVertex3dv(MemoryUtil.memAddress(coords));
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
/*      */   public static void glVertex4fv(@NativeType("GLfloat const *") FloatBuffer coords) {
/* 4089 */     if (Checks.CHECKS) {
/* 4090 */       Checks.check(coords, 4);
/*      */     }
/* 4092 */     nglVertex4fv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4sv(@NativeType("GLshort const *") ShortBuffer coords) {
/* 4102 */     if (Checks.CHECKS) {
/* 4103 */       Checks.check(coords, 4);
/*      */     }
/* 4105 */     nglVertex4sv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4iv(@NativeType("GLint const *") IntBuffer coords) {
/* 4115 */     if (Checks.CHECKS) {
/* 4116 */       Checks.check(coords, 4);
/*      */     }
/* 4118 */     nglVertex4iv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4dv(@NativeType("GLdouble const *") DoubleBuffer coords) {
/* 4128 */     if (Checks.CHECKS) {
/* 4129 */       Checks.check(coords, 4);
/*      */     }
/* 4131 */     nglVertex4dv(MemoryUtil.memAddress(coords));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 4141 */     nglVertexPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 4146 */     nglVertexPointer(size, type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 4151 */     nglVertexPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 4156 */     nglVertexPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 4161 */     nglVertexPointer(size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glViewport(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int w, @NativeType("GLsizei") int h) {
/* 4168 */     GL11C.glViewport(x, y, w, h);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glAreTexturesResident(@NativeType("GLuint const *") int[] textures, @NativeType("GLboolean *") ByteBuffer residences) {
/* 4174 */     long __functionAddress = (GL.getICD()).glAreTexturesResident;
/* 4175 */     if (Checks.CHECKS) {
/* 4176 */       Checks.check(__functionAddress);
/* 4177 */       Checks.check(residences, textures.length);
/*      */     } 
/* 4179 */     return JNI.callPPZ(textures.length, textures, MemoryUtil.memAddress(residences), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClipPlane(@NativeType("GLenum") int plane, @NativeType("GLdouble const *") double[] equation) {
/* 4184 */     long __functionAddress = (GL.getICD()).glClipPlane;
/* 4185 */     if (Checks.CHECKS) {
/* 4186 */       Checks.check(__functionAddress);
/* 4187 */       Checks.check(equation, 4);
/*      */     } 
/* 4189 */     JNI.callPV(plane, equation, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor3sv(@NativeType("GLshort const *") short[] v) {
/* 4194 */     long __functionAddress = (GL.getICD()).glColor3sv;
/* 4195 */     if (Checks.CHECKS) {
/* 4196 */       Checks.check(__functionAddress);
/* 4197 */       Checks.check(v, 3);
/*      */     } 
/* 4199 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor3iv(@NativeType("GLint const *") int[] v) {
/* 4204 */     long __functionAddress = (GL.getICD()).glColor3iv;
/* 4205 */     if (Checks.CHECKS) {
/* 4206 */       Checks.check(__functionAddress);
/* 4207 */       Checks.check(v, 3);
/*      */     } 
/* 4209 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor3fv(@NativeType("GLfloat const *") float[] v) {
/* 4214 */     long __functionAddress = (GL.getICD()).glColor3fv;
/* 4215 */     if (Checks.CHECKS) {
/* 4216 */       Checks.check(__functionAddress);
/* 4217 */       Checks.check(v, 3);
/*      */     } 
/* 4219 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor3dv(@NativeType("GLdouble const *") double[] v) {
/* 4224 */     long __functionAddress = (GL.getICD()).glColor3dv;
/* 4225 */     if (Checks.CHECKS) {
/* 4226 */       Checks.check(__functionAddress);
/* 4227 */       Checks.check(v, 3);
/*      */     } 
/* 4229 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor3usv(@NativeType("GLushort const *") short[] v) {
/* 4234 */     long __functionAddress = (GL.getICD()).glColor3usv;
/* 4235 */     if (Checks.CHECKS) {
/* 4236 */       Checks.check(__functionAddress);
/* 4237 */       Checks.check(v, 3);
/*      */     } 
/* 4239 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor3uiv(@NativeType("GLuint const *") int[] v) {
/* 4244 */     long __functionAddress = (GL.getICD()).glColor3uiv;
/* 4245 */     if (Checks.CHECKS) {
/* 4246 */       Checks.check(__functionAddress);
/* 4247 */       Checks.check(v, 3);
/*      */     } 
/* 4249 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor4sv(@NativeType("GLshort const *") short[] v) {
/* 4254 */     long __functionAddress = (GL.getICD()).glColor4sv;
/* 4255 */     if (Checks.CHECKS) {
/* 4256 */       Checks.check(__functionAddress);
/* 4257 */       Checks.check(v, 4);
/*      */     } 
/* 4259 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor4iv(@NativeType("GLint const *") int[] v) {
/* 4264 */     long __functionAddress = (GL.getICD()).glColor4iv;
/* 4265 */     if (Checks.CHECKS) {
/* 4266 */       Checks.check(__functionAddress);
/* 4267 */       Checks.check(v, 4);
/*      */     } 
/* 4269 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor4fv(@NativeType("GLfloat const *") float[] v) {
/* 4274 */     long __functionAddress = (GL.getICD()).glColor4fv;
/* 4275 */     if (Checks.CHECKS) {
/* 4276 */       Checks.check(__functionAddress);
/* 4277 */       Checks.check(v, 4);
/*      */     } 
/* 4279 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor4dv(@NativeType("GLdouble const *") double[] v) {
/* 4284 */     long __functionAddress = (GL.getICD()).glColor4dv;
/* 4285 */     if (Checks.CHECKS) {
/* 4286 */       Checks.check(__functionAddress);
/* 4287 */       Checks.check(v, 4);
/*      */     } 
/* 4289 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor4usv(@NativeType("GLushort const *") short[] v) {
/* 4294 */     long __functionAddress = (GL.getICD()).glColor4usv;
/* 4295 */     if (Checks.CHECKS) {
/* 4296 */       Checks.check(__functionAddress);
/* 4297 */       Checks.check(v, 4);
/*      */     } 
/* 4299 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor4uiv(@NativeType("GLuint const *") int[] v) {
/* 4304 */     long __functionAddress = (GL.getICD()).glColor4uiv;
/* 4305 */     if (Checks.CHECKS) {
/* 4306 */       Checks.check(__functionAddress);
/* 4307 */       Checks.check(v, 4);
/*      */     } 
/* 4309 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 4314 */     long __functionAddress = (GL.getICD()).glDrawPixels;
/* 4315 */     if (Checks.CHECKS) {
/* 4316 */       Checks.check(__functionAddress);
/*      */     }
/* 4318 */     JNI.callPV(width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 4323 */     long __functionAddress = (GL.getICD()).glDrawPixels;
/* 4324 */     if (Checks.CHECKS) {
/* 4325 */       Checks.check(__functionAddress);
/*      */     }
/* 4327 */     JNI.callPV(width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 4332 */     long __functionAddress = (GL.getICD()).glDrawPixels;
/* 4333 */     if (Checks.CHECKS) {
/* 4334 */       Checks.check(__functionAddress);
/*      */     }
/* 4336 */     JNI.callPV(width, height, format, type, pixels, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glEvalCoord1fv(@NativeType("GLfloat const *") float[] u) {
/* 4341 */     long __functionAddress = (GL.getICD()).glEvalCoord1fv;
/* 4342 */     if (Checks.CHECKS) {
/* 4343 */       Checks.check(__functionAddress);
/* 4344 */       Checks.check(u, 1);
/*      */     } 
/* 4346 */     JNI.callPV(u, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glEvalCoord1dv(@NativeType("GLdouble const *") double[] u) {
/* 4351 */     long __functionAddress = (GL.getICD()).glEvalCoord1dv;
/* 4352 */     if (Checks.CHECKS) {
/* 4353 */       Checks.check(__functionAddress);
/* 4354 */       Checks.check(u, 1);
/*      */     } 
/* 4356 */     JNI.callPV(u, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glEvalCoord2fv(@NativeType("GLfloat const *") float[] u) {
/* 4361 */     long __functionAddress = (GL.getICD()).glEvalCoord2fv;
/* 4362 */     if (Checks.CHECKS) {
/* 4363 */       Checks.check(__functionAddress);
/* 4364 */       Checks.check(u, 2);
/*      */     } 
/* 4366 */     JNI.callPV(u, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glEvalCoord2dv(@NativeType("GLdouble const *") double[] u) {
/* 4371 */     long __functionAddress = (GL.getICD()).glEvalCoord2dv;
/* 4372 */     if (Checks.CHECKS) {
/* 4373 */       Checks.check(__functionAddress);
/* 4374 */       Checks.check(u, 2);
/*      */     } 
/* 4376 */     JNI.callPV(u, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glFeedbackBuffer(@NativeType("GLenum") int type, @NativeType("GLfloat *") float[] buffer) {
/* 4381 */     long __functionAddress = (GL.getICD()).glFeedbackBuffer;
/* 4382 */     if (Checks.CHECKS) {
/* 4383 */       Checks.check(__functionAddress);
/*      */     }
/* 4385 */     JNI.callPV(buffer.length, type, buffer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glFogiv(@NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 4390 */     long __functionAddress = (GL.getICD()).glFogiv;
/* 4391 */     if (Checks.CHECKS) {
/* 4392 */       Checks.check(__functionAddress);
/* 4393 */       Checks.check(params, 1);
/*      */     } 
/* 4395 */     JNI.callPV(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glFogfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 4400 */     long __functionAddress = (GL.getICD()).glFogfv;
/* 4401 */     if (Checks.CHECKS) {
/* 4402 */       Checks.check(__functionAddress);
/* 4403 */       Checks.check(params, 1);
/*      */     } 
/* 4405 */     JNI.callPV(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenTextures(@NativeType("GLuint *") int[] textures) {
/* 4410 */     GL11C.glGenTextures(textures);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") int[] textures) {
/* 4415 */     GL11C.glDeleteTextures(textures);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetClipPlane(@NativeType("GLenum") int plane, @NativeType("GLdouble *") double[] equation) {
/* 4420 */     long __functionAddress = (GL.getICD()).glGetClipPlane;
/* 4421 */     if (Checks.CHECKS) {
/* 4422 */       Checks.check(__functionAddress);
/* 4423 */       Checks.check(equation, 4);
/*      */     } 
/* 4425 */     JNI.callPV(plane, equation, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloatv(@NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 4430 */     GL11C.glGetFloatv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetIntegerv(@NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 4435 */     GL11C.glGetIntegerv(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoublev(@NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 4440 */     GL11C.glGetDoublev(pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetLightiv(@NativeType("GLenum") int light, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] data) {
/* 4445 */     long __functionAddress = (GL.getICD()).glGetLightiv;
/* 4446 */     if (Checks.CHECKS) {
/* 4447 */       Checks.check(__functionAddress);
/* 4448 */       Checks.check(data, 4);
/*      */     } 
/* 4450 */     JNI.callPV(light, pname, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetLightfv(@NativeType("GLenum") int light, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] data) {
/* 4455 */     long __functionAddress = (GL.getICD()).glGetLightfv;
/* 4456 */     if (Checks.CHECKS) {
/* 4457 */       Checks.check(__functionAddress);
/* 4458 */       Checks.check(data, 4);
/*      */     } 
/* 4460 */     JNI.callPV(light, pname, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMapiv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLint *") int[] data) {
/* 4465 */     long __functionAddress = (GL.getICD()).glGetMapiv;
/* 4466 */     if (Checks.CHECKS) {
/* 4467 */       Checks.check(__functionAddress);
/* 4468 */       Checks.check(data, 4);
/*      */     } 
/* 4470 */     JNI.callPV(target, query, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMapfv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLfloat *") float[] data) {
/* 4475 */     long __functionAddress = (GL.getICD()).glGetMapfv;
/* 4476 */     if (Checks.CHECKS) {
/* 4477 */       Checks.check(__functionAddress);
/* 4478 */       Checks.check(data, 4);
/*      */     } 
/* 4480 */     JNI.callPV(target, query, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMapdv(@NativeType("GLenum") int target, @NativeType("GLenum") int query, @NativeType("GLdouble *") double[] data) {
/* 4485 */     long __functionAddress = (GL.getICD()).glGetMapdv;
/* 4486 */     if (Checks.CHECKS) {
/* 4487 */       Checks.check(__functionAddress);
/* 4488 */       Checks.check(data, 4);
/*      */     } 
/* 4490 */     JNI.callPV(target, query, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMaterialiv(@NativeType("GLenum") int face, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] data) {
/* 4495 */     long __functionAddress = (GL.getICD()).glGetMaterialiv;
/* 4496 */     if (Checks.CHECKS) {
/* 4497 */       Checks.check(__functionAddress);
/* 4498 */       Checks.check(data, 1);
/*      */     } 
/* 4500 */     JNI.callPV(face, pname, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMaterialfv(@NativeType("GLenum") int face, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] data) {
/* 4505 */     long __functionAddress = (GL.getICD()).glGetMaterialfv;
/* 4506 */     if (Checks.CHECKS) {
/* 4507 */       Checks.check(__functionAddress);
/* 4508 */       Checks.check(data, 1);
/*      */     } 
/* 4510 */     JNI.callPV(face, pname, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapfv(@NativeType("GLenum") int map, @NativeType("GLfloat *") float[] data) {
/* 4515 */     long __functionAddress = (GL.getICD()).glGetPixelMapfv;
/* 4516 */     if (Checks.CHECKS) {
/* 4517 */       Checks.check(__functionAddress);
/* 4518 */       Checks.check(data, 32);
/*      */     } 
/* 4520 */     JNI.callPV(map, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapusv(@NativeType("GLenum") int map, @NativeType("GLushort *") short[] data) {
/* 4525 */     long __functionAddress = (GL.getICD()).glGetPixelMapusv;
/* 4526 */     if (Checks.CHECKS) {
/* 4527 */       Checks.check(__functionAddress);
/* 4528 */       Checks.check(data, 32);
/*      */     } 
/* 4530 */     JNI.callPV(map, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapuiv(@NativeType("GLenum") int map, @NativeType("GLuint *") int[] data) {
/* 4535 */     long __functionAddress = (GL.getICD()).glGetPixelMapuiv;
/* 4536 */     if (Checks.CHECKS) {
/* 4537 */       Checks.check(__functionAddress);
/* 4538 */       Checks.check(data, 32);
/*      */     } 
/* 4540 */     JNI.callPV(map, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexEnviv(@NativeType("GLenum") int env, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] data) {
/* 4545 */     long __functionAddress = (GL.getICD()).glGetTexEnviv;
/* 4546 */     if (Checks.CHECKS) {
/* 4547 */       Checks.check(__functionAddress);
/* 4548 */       Checks.check(data, 1);
/*      */     } 
/* 4550 */     JNI.callPV(env, pname, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexEnvfv(@NativeType("GLenum") int env, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] data) {
/* 4555 */     long __functionAddress = (GL.getICD()).glGetTexEnvfv;
/* 4556 */     if (Checks.CHECKS) {
/* 4557 */       Checks.check(__functionAddress);
/* 4558 */       Checks.check(data, 1);
/*      */     } 
/* 4560 */     JNI.callPV(env, pname, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexGeniv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] data) {
/* 4565 */     long __functionAddress = (GL.getICD()).glGetTexGeniv;
/* 4566 */     if (Checks.CHECKS) {
/* 4567 */       Checks.check(__functionAddress);
/* 4568 */       Checks.check(data, 1);
/*      */     } 
/* 4570 */     JNI.callPV(coord, pname, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexGenfv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] data) {
/* 4575 */     long __functionAddress = (GL.getICD()).glGetTexGenfv;
/* 4576 */     if (Checks.CHECKS) {
/* 4577 */       Checks.check(__functionAddress);
/* 4578 */       Checks.check(data, 4);
/*      */     } 
/* 4580 */     JNI.callPV(coord, pname, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexGendv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] data) {
/* 4585 */     long __functionAddress = (GL.getICD()).glGetTexGendv;
/* 4586 */     if (Checks.CHECKS) {
/* 4587 */       Checks.check(__functionAddress);
/* 4588 */       Checks.check(data, 4);
/*      */     } 
/* 4590 */     JNI.callPV(coord, pname, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 4595 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 4600 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 4605 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int tex, @NativeType("GLint") int level, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") double[] pixels) {
/* 4610 */     GL11C.glGetTexImage(tex, level, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameteriv(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 4615 */     GL11C.glGetTexLevelParameteriv(target, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameterfv(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 4620 */     GL11C.glGetTexLevelParameterfv(target, level, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 4625 */     GL11C.glGetTexParameteriv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 4630 */     GL11C.glGetTexParameterfv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glIndexiv(@NativeType("GLint const *") int[] index) {
/* 4635 */     long __functionAddress = (GL.getICD()).glIndexiv;
/* 4636 */     if (Checks.CHECKS) {
/* 4637 */       Checks.check(__functionAddress);
/* 4638 */       Checks.check(index, 1);
/*      */     } 
/* 4640 */     JNI.callPV(index, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glIndexsv(@NativeType("GLshort const *") short[] index) {
/* 4645 */     long __functionAddress = (GL.getICD()).glIndexsv;
/* 4646 */     if (Checks.CHECKS) {
/* 4647 */       Checks.check(__functionAddress);
/* 4648 */       Checks.check(index, 1);
/*      */     } 
/* 4650 */     JNI.callPV(index, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glIndexfv(@NativeType("GLfloat const *") float[] index) {
/* 4655 */     long __functionAddress = (GL.getICD()).glIndexfv;
/* 4656 */     if (Checks.CHECKS) {
/* 4657 */       Checks.check(__functionAddress);
/* 4658 */       Checks.check(index, 1);
/*      */     } 
/* 4660 */     JNI.callPV(index, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glIndexdv(@NativeType("GLdouble const *") double[] index) {
/* 4665 */     long __functionAddress = (GL.getICD()).glIndexdv;
/* 4666 */     if (Checks.CHECKS) {
/* 4667 */       Checks.check(__functionAddress);
/* 4668 */       Checks.check(index, 1);
/*      */     } 
/* 4670 */     JNI.callPV(index, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") short[] pointer) {
/* 4675 */     long __functionAddress = (GL.getICD()).glInterleavedArrays;
/* 4676 */     if (Checks.CHECKS) {
/* 4677 */       Checks.check(__functionAddress);
/*      */     }
/* 4679 */     JNI.callPV(format, stride, pointer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") int[] pointer) {
/* 4684 */     long __functionAddress = (GL.getICD()).glInterleavedArrays;
/* 4685 */     if (Checks.CHECKS) {
/* 4686 */       Checks.check(__functionAddress);
/*      */     }
/* 4688 */     JNI.callPV(format, stride, pointer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") float[] pointer) {
/* 4693 */     long __functionAddress = (GL.getICD()).glInterleavedArrays;
/* 4694 */     if (Checks.CHECKS) {
/* 4695 */       Checks.check(__functionAddress);
/*      */     }
/* 4697 */     JNI.callPV(format, stride, pointer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int format, @NativeType("GLsizei") int stride, @NativeType("void const *") double[] pointer) {
/* 4702 */     long __functionAddress = (GL.getICD()).glInterleavedArrays;
/* 4703 */     if (Checks.CHECKS) {
/* 4704 */       Checks.check(__functionAddress);
/*      */     }
/* 4706 */     JNI.callPV(format, stride, pointer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glLightModeliv(@NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 4711 */     long __functionAddress = (GL.getICD()).glLightModeliv;
/* 4712 */     if (Checks.CHECKS) {
/* 4713 */       Checks.check(__functionAddress);
/* 4714 */       Checks.check(params, 4);
/*      */     } 
/* 4716 */     JNI.callPV(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glLightModelfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 4721 */     long __functionAddress = (GL.getICD()).glLightModelfv;
/* 4722 */     if (Checks.CHECKS) {
/* 4723 */       Checks.check(__functionAddress);
/* 4724 */       Checks.check(params, 4);
/*      */     } 
/* 4726 */     JNI.callPV(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glLightiv(@NativeType("GLenum") int light, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 4731 */     long __functionAddress = (GL.getICD()).glLightiv;
/* 4732 */     if (Checks.CHECKS) {
/* 4733 */       Checks.check(__functionAddress);
/* 4734 */       Checks.check(params, 4);
/*      */     } 
/* 4736 */     JNI.callPV(light, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glLightfv(@NativeType("GLenum") int light, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 4741 */     long __functionAddress = (GL.getICD()).glLightfv;
/* 4742 */     if (Checks.CHECKS) {
/* 4743 */       Checks.check(__functionAddress);
/* 4744 */       Checks.check(params, 4);
/*      */     } 
/* 4746 */     JNI.callPV(light, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glLoadMatrixf(@NativeType("GLfloat const *") float[] m) {
/* 4751 */     long __functionAddress = (GL.getICD()).glLoadMatrixf;
/* 4752 */     if (Checks.CHECKS) {
/* 4753 */       Checks.check(__functionAddress);
/* 4754 */       Checks.check(m, 16);
/*      */     } 
/* 4756 */     JNI.callPV(m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glLoadMatrixd(@NativeType("GLdouble const *") double[] m) {
/* 4761 */     long __functionAddress = (GL.getICD()).glLoadMatrixd;
/* 4762 */     if (Checks.CHECKS) {
/* 4763 */       Checks.check(__functionAddress);
/* 4764 */       Checks.check(m, 16);
/*      */     } 
/* 4766 */     JNI.callPV(m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMap1f(@NativeType("GLenum") int target, @NativeType("GLfloat") float u1, @NativeType("GLfloat") float u2, @NativeType("GLint") int stride, @NativeType("GLint") int order, @NativeType("GLfloat const *") float[] points) {
/* 4771 */     long __functionAddress = (GL.getICD()).glMap1f;
/* 4772 */     if (Checks.CHECKS) {
/* 4773 */       Checks.check(__functionAddress);
/* 4774 */       Checks.check(points, order * stride);
/*      */     } 
/* 4776 */     JNI.callPV(target, u1, u2, stride, order, points, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMap1d(@NativeType("GLenum") int target, @NativeType("GLdouble") double u1, @NativeType("GLdouble") double u2, @NativeType("GLint") int stride, @NativeType("GLint") int order, @NativeType("GLdouble const *") double[] points) {
/* 4781 */     long __functionAddress = (GL.getICD()).glMap1d;
/* 4782 */     if (Checks.CHECKS) {
/* 4783 */       Checks.check(__functionAddress);
/* 4784 */       Checks.check(points, stride * order);
/*      */     } 
/* 4786 */     JNI.callPV(target, u1, u2, stride, order, points, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMap2f(@NativeType("GLenum") int target, @NativeType("GLfloat") float u1, @NativeType("GLfloat") float u2, @NativeType("GLint") int ustride, @NativeType("GLint") int uorder, @NativeType("GLfloat") float v1, @NativeType("GLfloat") float v2, @NativeType("GLint") int vstride, @NativeType("GLint") int vorder, @NativeType("GLfloat const *") float[] points) {
/* 4791 */     long __functionAddress = (GL.getICD()).glMap2f;
/* 4792 */     if (Checks.CHECKS) {
/* 4793 */       Checks.check(__functionAddress);
/* 4794 */       Checks.check(points, ustride * uorder * vstride * vorder);
/*      */     } 
/* 4796 */     JNI.callPV(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMap2d(@NativeType("GLenum") int target, @NativeType("GLdouble") double u1, @NativeType("GLdouble") double u2, @NativeType("GLint") int ustride, @NativeType("GLint") int uorder, @NativeType("GLdouble") double v1, @NativeType("GLdouble") double v2, @NativeType("GLint") int vstride, @NativeType("GLint") int vorder, @NativeType("GLdouble const *") double[] points) {
/* 4801 */     long __functionAddress = (GL.getICD()).glMap2d;
/* 4802 */     if (Checks.CHECKS) {
/* 4803 */       Checks.check(__functionAddress);
/* 4804 */       Checks.check(points, ustride * uorder * vstride * vorder);
/*      */     } 
/* 4806 */     JNI.callPV(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMaterialiv(@NativeType("GLenum") int face, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 4811 */     long __functionAddress = (GL.getICD()).glMaterialiv;
/* 4812 */     if (Checks.CHECKS) {
/* 4813 */       Checks.check(__functionAddress);
/* 4814 */       Checks.check(params, 4);
/*      */     } 
/* 4816 */     JNI.callPV(face, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMaterialfv(@NativeType("GLenum") int face, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 4821 */     long __functionAddress = (GL.getICD()).glMaterialfv;
/* 4822 */     if (Checks.CHECKS) {
/* 4823 */       Checks.check(__functionAddress);
/* 4824 */       Checks.check(params, 4);
/*      */     } 
/* 4826 */     JNI.callPV(face, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultMatrixf(@NativeType("GLfloat const *") float[] m) {
/* 4831 */     long __functionAddress = (GL.getICD()).glMultMatrixf;
/* 4832 */     if (Checks.CHECKS) {
/* 4833 */       Checks.check(__functionAddress);
/* 4834 */       Checks.check(m, 16);
/*      */     } 
/* 4836 */     JNI.callPV(m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultMatrixd(@NativeType("GLdouble const *") double[] m) {
/* 4841 */     long __functionAddress = (GL.getICD()).glMultMatrixd;
/* 4842 */     if (Checks.CHECKS) {
/* 4843 */       Checks.check(__functionAddress);
/* 4844 */       Checks.check(m, 16);
/*      */     } 
/* 4846 */     JNI.callPV(m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNormal3fv(@NativeType("GLfloat const *") float[] v) {
/* 4851 */     long __functionAddress = (GL.getICD()).glNormal3fv;
/* 4852 */     if (Checks.CHECKS) {
/* 4853 */       Checks.check(__functionAddress);
/* 4854 */       Checks.check(v, 3);
/*      */     } 
/* 4856 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNormal3sv(@NativeType("GLshort const *") short[] v) {
/* 4861 */     long __functionAddress = (GL.getICD()).glNormal3sv;
/* 4862 */     if (Checks.CHECKS) {
/* 4863 */       Checks.check(__functionAddress);
/* 4864 */       Checks.check(v, 3);
/*      */     } 
/* 4866 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNormal3iv(@NativeType("GLint const *") int[] v) {
/* 4871 */     long __functionAddress = (GL.getICD()).glNormal3iv;
/* 4872 */     if (Checks.CHECKS) {
/* 4873 */       Checks.check(__functionAddress);
/* 4874 */       Checks.check(v, 3);
/*      */     } 
/* 4876 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNormal3dv(@NativeType("GLdouble const *") double[] v) {
/* 4881 */     long __functionAddress = (GL.getICD()).glNormal3dv;
/* 4882 */     if (Checks.CHECKS) {
/* 4883 */       Checks.check(__functionAddress);
/* 4884 */       Checks.check(v, 3);
/*      */     } 
/* 4886 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPixelMapfv(@NativeType("GLenum") int map, @NativeType("GLfloat const *") float[] values) {
/* 4891 */     long __functionAddress = (GL.getICD()).glPixelMapfv;
/* 4892 */     if (Checks.CHECKS) {
/* 4893 */       Checks.check(__functionAddress);
/*      */     }
/* 4895 */     JNI.callPV(map, values.length, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPixelMapusv(@NativeType("GLenum") int map, @NativeType("GLushort const *") short[] values) {
/* 4900 */     long __functionAddress = (GL.getICD()).glPixelMapusv;
/* 4901 */     if (Checks.CHECKS) {
/* 4902 */       Checks.check(__functionAddress);
/*      */     }
/* 4904 */     JNI.callPV(map, values.length, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPixelMapuiv(@NativeType("GLenum") int map, @NativeType("GLuint const *") int[] values) {
/* 4909 */     long __functionAddress = (GL.getICD()).glPixelMapuiv;
/* 4910 */     if (Checks.CHECKS) {
/* 4911 */       Checks.check(__functionAddress);
/*      */     }
/* 4913 */     JNI.callPV(map, values.length, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPrioritizeTextures(@NativeType("GLuint const *") int[] textures, @NativeType("GLfloat const *") float[] priorities) {
/* 4918 */     long __functionAddress = (GL.getICD()).glPrioritizeTextures;
/* 4919 */     if (Checks.CHECKS) {
/* 4920 */       Checks.check(__functionAddress);
/* 4921 */       Checks.check(priorities, textures.length);
/*      */     } 
/* 4923 */     JNI.callPPV(textures.length, textures, priorities, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos2iv(@NativeType("GLint const *") int[] coords) {
/* 4928 */     long __functionAddress = (GL.getICD()).glRasterPos2iv;
/* 4929 */     if (Checks.CHECKS) {
/* 4930 */       Checks.check(__functionAddress);
/* 4931 */       Checks.check(coords, 2);
/*      */     } 
/* 4933 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos2sv(@NativeType("GLshort const *") short[] coords) {
/* 4938 */     long __functionAddress = (GL.getICD()).glRasterPos2sv;
/* 4939 */     if (Checks.CHECKS) {
/* 4940 */       Checks.check(__functionAddress);
/* 4941 */       Checks.check(coords, 2);
/*      */     } 
/* 4943 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos2fv(@NativeType("GLfloat const *") float[] coords) {
/* 4948 */     long __functionAddress = (GL.getICD()).glRasterPos2fv;
/* 4949 */     if (Checks.CHECKS) {
/* 4950 */       Checks.check(__functionAddress);
/* 4951 */       Checks.check(coords, 2);
/*      */     } 
/* 4953 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos2dv(@NativeType("GLdouble const *") double[] coords) {
/* 4958 */     long __functionAddress = (GL.getICD()).glRasterPos2dv;
/* 4959 */     if (Checks.CHECKS) {
/* 4960 */       Checks.check(__functionAddress);
/* 4961 */       Checks.check(coords, 2);
/*      */     } 
/* 4963 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos3iv(@NativeType("GLint const *") int[] coords) {
/* 4968 */     long __functionAddress = (GL.getICD()).glRasterPos3iv;
/* 4969 */     if (Checks.CHECKS) {
/* 4970 */       Checks.check(__functionAddress);
/* 4971 */       Checks.check(coords, 3);
/*      */     } 
/* 4973 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos3sv(@NativeType("GLshort const *") short[] coords) {
/* 4978 */     long __functionAddress = (GL.getICD()).glRasterPos3sv;
/* 4979 */     if (Checks.CHECKS) {
/* 4980 */       Checks.check(__functionAddress);
/* 4981 */       Checks.check(coords, 3);
/*      */     } 
/* 4983 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos3fv(@NativeType("GLfloat const *") float[] coords) {
/* 4988 */     long __functionAddress = (GL.getICD()).glRasterPos3fv;
/* 4989 */     if (Checks.CHECKS) {
/* 4990 */       Checks.check(__functionAddress);
/* 4991 */       Checks.check(coords, 3);
/*      */     } 
/* 4993 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos3dv(@NativeType("GLdouble const *") double[] coords) {
/* 4998 */     long __functionAddress = (GL.getICD()).glRasterPos3dv;
/* 4999 */     if (Checks.CHECKS) {
/* 5000 */       Checks.check(__functionAddress);
/* 5001 */       Checks.check(coords, 3);
/*      */     } 
/* 5003 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos4iv(@NativeType("GLint const *") int[] coords) {
/* 5008 */     long __functionAddress = (GL.getICD()).glRasterPos4iv;
/* 5009 */     if (Checks.CHECKS) {
/* 5010 */       Checks.check(__functionAddress);
/* 5011 */       Checks.check(coords, 4);
/*      */     } 
/* 5013 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos4sv(@NativeType("GLshort const *") short[] coords) {
/* 5018 */     long __functionAddress = (GL.getICD()).glRasterPos4sv;
/* 5019 */     if (Checks.CHECKS) {
/* 5020 */       Checks.check(__functionAddress);
/* 5021 */       Checks.check(coords, 4);
/*      */     } 
/* 5023 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos4fv(@NativeType("GLfloat const *") float[] coords) {
/* 5028 */     long __functionAddress = (GL.getICD()).glRasterPos4fv;
/* 5029 */     if (Checks.CHECKS) {
/* 5030 */       Checks.check(__functionAddress);
/* 5031 */       Checks.check(coords, 4);
/*      */     } 
/* 5033 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRasterPos4dv(@NativeType("GLdouble const *") double[] coords) {
/* 5038 */     long __functionAddress = (GL.getICD()).glRasterPos4dv;
/* 5039 */     if (Checks.CHECKS) {
/* 5040 */       Checks.check(__functionAddress);
/* 5041 */       Checks.check(coords, 4);
/*      */     } 
/* 5043 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") short[] pixels) {
/* 5048 */     GL11C.glReadPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") int[] pixels) {
/* 5053 */     GL11C.glReadPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void *") float[] pixels) {
/* 5058 */     GL11C.glReadPixels(x, y, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRectiv(@NativeType("GLint const *") int[] v1, @NativeType("GLint const *") int[] v2) {
/* 5063 */     long __functionAddress = (GL.getICD()).glRectiv;
/* 5064 */     if (Checks.CHECKS) {
/* 5065 */       Checks.check(__functionAddress);
/* 5066 */       Checks.check(v1, 2);
/* 5067 */       Checks.check(v2, 2);
/*      */     } 
/* 5069 */     JNI.callPPV(v1, v2, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRectsv(@NativeType("GLshort const *") short[] v1, @NativeType("GLshort const *") short[] v2) {
/* 5074 */     long __functionAddress = (GL.getICD()).glRectsv;
/* 5075 */     if (Checks.CHECKS) {
/* 5076 */       Checks.check(__functionAddress);
/* 5077 */       Checks.check(v1, 2);
/* 5078 */       Checks.check(v2, 2);
/*      */     } 
/* 5080 */     JNI.callPPV(v1, v2, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRectfv(@NativeType("GLfloat const *") float[] v1, @NativeType("GLfloat const *") float[] v2) {
/* 5085 */     long __functionAddress = (GL.getICD()).glRectfv;
/* 5086 */     if (Checks.CHECKS) {
/* 5087 */       Checks.check(__functionAddress);
/* 5088 */       Checks.check(v1, 2);
/* 5089 */       Checks.check(v2, 2);
/*      */     } 
/* 5091 */     JNI.callPPV(v1, v2, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glRectdv(@NativeType("GLdouble const *") double[] v1, @NativeType("GLdouble const *") double[] v2) {
/* 5096 */     long __functionAddress = (GL.getICD()).glRectdv;
/* 5097 */     if (Checks.CHECKS) {
/* 5098 */       Checks.check(__functionAddress);
/* 5099 */       Checks.check(v1, 2);
/* 5100 */       Checks.check(v2, 2);
/*      */     } 
/* 5102 */     JNI.callPPV(v1, v2, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glSelectBuffer(@NativeType("GLuint *") int[] buffer) {
/* 5107 */     long __functionAddress = (GL.getICD()).glSelectBuffer;
/* 5108 */     if (Checks.CHECKS) {
/* 5109 */       Checks.check(__functionAddress);
/*      */     }
/* 5111 */     JNI.callPV(buffer.length, buffer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord1fv(@NativeType("GLfloat const *") float[] v) {
/* 5116 */     long __functionAddress = (GL.getICD()).glTexCoord1fv;
/* 5117 */     if (Checks.CHECKS) {
/* 5118 */       Checks.check(__functionAddress);
/* 5119 */       Checks.check(v, 1);
/*      */     } 
/* 5121 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord1sv(@NativeType("GLshort const *") short[] v) {
/* 5126 */     long __functionAddress = (GL.getICD()).glTexCoord1sv;
/* 5127 */     if (Checks.CHECKS) {
/* 5128 */       Checks.check(__functionAddress);
/* 5129 */       Checks.check(v, 1);
/*      */     } 
/* 5131 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord1iv(@NativeType("GLint const *") int[] v) {
/* 5136 */     long __functionAddress = (GL.getICD()).glTexCoord1iv;
/* 5137 */     if (Checks.CHECKS) {
/* 5138 */       Checks.check(__functionAddress);
/* 5139 */       Checks.check(v, 1);
/*      */     } 
/* 5141 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord1dv(@NativeType("GLdouble const *") double[] v) {
/* 5146 */     long __functionAddress = (GL.getICD()).glTexCoord1dv;
/* 5147 */     if (Checks.CHECKS) {
/* 5148 */       Checks.check(__functionAddress);
/* 5149 */       Checks.check(v, 1);
/*      */     } 
/* 5151 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord2fv(@NativeType("GLfloat const *") float[] v) {
/* 5156 */     long __functionAddress = (GL.getICD()).glTexCoord2fv;
/* 5157 */     if (Checks.CHECKS) {
/* 5158 */       Checks.check(__functionAddress);
/* 5159 */       Checks.check(v, 2);
/*      */     } 
/* 5161 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord2sv(@NativeType("GLshort const *") short[] v) {
/* 5166 */     long __functionAddress = (GL.getICD()).glTexCoord2sv;
/* 5167 */     if (Checks.CHECKS) {
/* 5168 */       Checks.check(__functionAddress);
/* 5169 */       Checks.check(v, 2);
/*      */     } 
/* 5171 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord2iv(@NativeType("GLint const *") int[] v) {
/* 5176 */     long __functionAddress = (GL.getICD()).glTexCoord2iv;
/* 5177 */     if (Checks.CHECKS) {
/* 5178 */       Checks.check(__functionAddress);
/* 5179 */       Checks.check(v, 2);
/*      */     } 
/* 5181 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord2dv(@NativeType("GLdouble const *") double[] v) {
/* 5186 */     long __functionAddress = (GL.getICD()).glTexCoord2dv;
/* 5187 */     if (Checks.CHECKS) {
/* 5188 */       Checks.check(__functionAddress);
/* 5189 */       Checks.check(v, 2);
/*      */     } 
/* 5191 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord3fv(@NativeType("GLfloat const *") float[] v) {
/* 5196 */     long __functionAddress = (GL.getICD()).glTexCoord3fv;
/* 5197 */     if (Checks.CHECKS) {
/* 5198 */       Checks.check(__functionAddress);
/* 5199 */       Checks.check(v, 3);
/*      */     } 
/* 5201 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord3sv(@NativeType("GLshort const *") short[] v) {
/* 5206 */     long __functionAddress = (GL.getICD()).glTexCoord3sv;
/* 5207 */     if (Checks.CHECKS) {
/* 5208 */       Checks.check(__functionAddress);
/* 5209 */       Checks.check(v, 3);
/*      */     } 
/* 5211 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord3iv(@NativeType("GLint const *") int[] v) {
/* 5216 */     long __functionAddress = (GL.getICD()).glTexCoord3iv;
/* 5217 */     if (Checks.CHECKS) {
/* 5218 */       Checks.check(__functionAddress);
/* 5219 */       Checks.check(v, 3);
/*      */     } 
/* 5221 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord3dv(@NativeType("GLdouble const *") double[] v) {
/* 5226 */     long __functionAddress = (GL.getICD()).glTexCoord3dv;
/* 5227 */     if (Checks.CHECKS) {
/* 5228 */       Checks.check(__functionAddress);
/* 5229 */       Checks.check(v, 3);
/*      */     } 
/* 5231 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord4fv(@NativeType("GLfloat const *") float[] v) {
/* 5236 */     long __functionAddress = (GL.getICD()).glTexCoord4fv;
/* 5237 */     if (Checks.CHECKS) {
/* 5238 */       Checks.check(__functionAddress);
/* 5239 */       Checks.check(v, 4);
/*      */     } 
/* 5241 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord4sv(@NativeType("GLshort const *") short[] v) {
/* 5246 */     long __functionAddress = (GL.getICD()).glTexCoord4sv;
/* 5247 */     if (Checks.CHECKS) {
/* 5248 */       Checks.check(__functionAddress);
/* 5249 */       Checks.check(v, 4);
/*      */     } 
/* 5251 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord4iv(@NativeType("GLint const *") int[] v) {
/* 5256 */     long __functionAddress = (GL.getICD()).glTexCoord4iv;
/* 5257 */     if (Checks.CHECKS) {
/* 5258 */       Checks.check(__functionAddress);
/* 5259 */       Checks.check(v, 4);
/*      */     } 
/* 5261 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexCoord4dv(@NativeType("GLdouble const *") double[] v) {
/* 5266 */     long __functionAddress = (GL.getICD()).glTexCoord4dv;
/* 5267 */     if (Checks.CHECKS) {
/* 5268 */       Checks.check(__functionAddress);
/* 5269 */       Checks.check(v, 4);
/*      */     } 
/* 5271 */     JNI.callPV(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexEnviv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 5276 */     long __functionAddress = (GL.getICD()).glTexEnviv;
/* 5277 */     if (Checks.CHECKS) {
/* 5278 */       Checks.check(__functionAddress);
/* 5279 */       Checks.check(params, 4);
/*      */     } 
/* 5281 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexEnvfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 5286 */     long __functionAddress = (GL.getICD()).glTexEnvfv;
/* 5287 */     if (Checks.CHECKS) {
/* 5288 */       Checks.check(__functionAddress);
/* 5289 */       Checks.check(params, 4);
/*      */     } 
/* 5291 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexGeniv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 5296 */     long __functionAddress = (GL.getICD()).glTexGeniv;
/* 5297 */     if (Checks.CHECKS) {
/* 5298 */       Checks.check(__functionAddress);
/* 5299 */       Checks.check(params, 4);
/*      */     } 
/* 5301 */     JNI.callPV(coord, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexGenfv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 5306 */     long __functionAddress = (GL.getICD()).glTexGenfv;
/* 5307 */     if (Checks.CHECKS) {
/* 5308 */       Checks.check(__functionAddress);
/* 5309 */       Checks.check(params, 4);
/*      */     } 
/* 5311 */     JNI.callPV(coord, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexGendv(@NativeType("GLenum") int coord, @NativeType("GLenum") int pname, @NativeType("GLdouble const *") double[] params) {
/* 5316 */     long __functionAddress = (GL.getICD()).glTexGendv;
/* 5317 */     if (Checks.CHECKS) {
/* 5318 */       Checks.check(__functionAddress);
/* 5319 */       Checks.check(params, 4);
/*      */     } 
/* 5321 */     JNI.callPV(coord, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 5326 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 5331 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 5336 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 5341 */     GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 5346 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 5351 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 5356 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int border, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 5361 */     GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 5366 */     GL11C.glTexParameteriv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexParameterfv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 5371 */     GL11C.glTexParameterfv(target, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 5376 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 5381 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 5386 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLsizei") int width, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 5391 */     GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] pixels) {
/* 5396 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] pixels) {
/* 5401 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] pixels) {
/* 5406 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int target, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") double[] pixels) {
/* 5411 */     GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex2fv(@NativeType("GLfloat const *") float[] coords) {
/* 5416 */     long __functionAddress = (GL.getICD()).glVertex2fv;
/* 5417 */     if (Checks.CHECKS) {
/* 5418 */       Checks.check(__functionAddress);
/* 5419 */       Checks.check(coords, 2);
/*      */     } 
/* 5421 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex2sv(@NativeType("GLshort const *") short[] coords) {
/* 5426 */     long __functionAddress = (GL.getICD()).glVertex2sv;
/* 5427 */     if (Checks.CHECKS) {
/* 5428 */       Checks.check(__functionAddress);
/* 5429 */       Checks.check(coords, 2);
/*      */     } 
/* 5431 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex2iv(@NativeType("GLint const *") int[] coords) {
/* 5436 */     long __functionAddress = (GL.getICD()).glVertex2iv;
/* 5437 */     if (Checks.CHECKS) {
/* 5438 */       Checks.check(__functionAddress);
/* 5439 */       Checks.check(coords, 2);
/*      */     } 
/* 5441 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex2dv(@NativeType("GLdouble const *") double[] coords) {
/* 5446 */     long __functionAddress = (GL.getICD()).glVertex2dv;
/* 5447 */     if (Checks.CHECKS) {
/* 5448 */       Checks.check(__functionAddress);
/* 5449 */       Checks.check(coords, 2);
/*      */     } 
/* 5451 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex3fv(@NativeType("GLfloat const *") float[] coords) {
/* 5456 */     long __functionAddress = (GL.getICD()).glVertex3fv;
/* 5457 */     if (Checks.CHECKS) {
/* 5458 */       Checks.check(__functionAddress);
/* 5459 */       Checks.check(coords, 3);
/*      */     } 
/* 5461 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex3sv(@NativeType("GLshort const *") short[] coords) {
/* 5466 */     long __functionAddress = (GL.getICD()).glVertex3sv;
/* 5467 */     if (Checks.CHECKS) {
/* 5468 */       Checks.check(__functionAddress);
/* 5469 */       Checks.check(coords, 3);
/*      */     } 
/* 5471 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex3iv(@NativeType("GLint const *") int[] coords) {
/* 5476 */     long __functionAddress = (GL.getICD()).glVertex3iv;
/* 5477 */     if (Checks.CHECKS) {
/* 5478 */       Checks.check(__functionAddress);
/* 5479 */       Checks.check(coords, 3);
/*      */     } 
/* 5481 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex3dv(@NativeType("GLdouble const *") double[] coords) {
/* 5486 */     long __functionAddress = (GL.getICD()).glVertex3dv;
/* 5487 */     if (Checks.CHECKS) {
/* 5488 */       Checks.check(__functionAddress);
/* 5489 */       Checks.check(coords, 3);
/*      */     } 
/* 5491 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex4fv(@NativeType("GLfloat const *") float[] coords) {
/* 5496 */     long __functionAddress = (GL.getICD()).glVertex4fv;
/* 5497 */     if (Checks.CHECKS) {
/* 5498 */       Checks.check(__functionAddress);
/* 5499 */       Checks.check(coords, 4);
/*      */     } 
/* 5501 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex4sv(@NativeType("GLshort const *") short[] coords) {
/* 5506 */     long __functionAddress = (GL.getICD()).glVertex4sv;
/* 5507 */     if (Checks.CHECKS) {
/* 5508 */       Checks.check(__functionAddress);
/* 5509 */       Checks.check(coords, 4);
/*      */     } 
/* 5511 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex4iv(@NativeType("GLint const *") int[] coords) {
/* 5516 */     long __functionAddress = (GL.getICD()).glVertex4iv;
/* 5517 */     if (Checks.CHECKS) {
/* 5518 */       Checks.check(__functionAddress);
/* 5519 */       Checks.check(coords, 4);
/*      */     } 
/* 5521 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertex4dv(@NativeType("GLdouble const *") double[] coords) {
/* 5526 */     long __functionAddress = (GL.getICD()).glVertex4dv;
/* 5527 */     if (Checks.CHECKS) {
/* 5528 */       Checks.check(__functionAddress);
/* 5529 */       Checks.check(coords, 4);
/*      */     } 
/* 5531 */     JNI.callPV(coords, __functionAddress);
/*      */   }
/*      */   
/*      */   public static native void glAccum(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glAlphaFunc(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native boolean nglAreTexturesResident(int paramInt, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glArrayElement(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glBegin(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglBitmap(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong);
/*      */   
/*      */   public static native void glCallList(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglCallLists(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glClearAccum(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glClearIndex(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglClipPlane(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glColor3b(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3);
/*      */   
/*      */   public static native void glColor3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glColor3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glColor3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glColor3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glColor3ub(@NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3);
/*      */   
/*      */   public static native void glColor3us(@NativeType("GLushort") short paramShort1, @NativeType("GLushort") short paramShort2, @NativeType("GLushort") short paramShort3);
/*      */   
/*      */   public static native void glColor3ui(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglColor3bv(long paramLong);
/*      */   
/*      */   public static native void nglColor3sv(long paramLong);
/*      */   
/*      */   public static native void nglColor3iv(long paramLong);
/*      */   
/*      */   public static native void nglColor3fv(long paramLong);
/*      */   
/*      */   public static native void nglColor3dv(long paramLong);
/*      */   
/*      */   public static native void nglColor3ubv(long paramLong);
/*      */   
/*      */   public static native void nglColor3usv(long paramLong);
/*      */   
/*      */   public static native void nglColor3uiv(long paramLong);
/*      */   
/*      */   public static native void glColor4b(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3, @NativeType("GLbyte") byte paramByte4);
/*      */   
/*      */   public static native void glColor4s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glColor4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glColor4f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glColor4d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glColor4ub(@NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3, @NativeType("GLubyte") byte paramByte4);
/*      */   
/*      */   public static native void glColor4us(@NativeType("GLushort") short paramShort1, @NativeType("GLushort") short paramShort2, @NativeType("GLushort") short paramShort3, @NativeType("GLushort") short paramShort4);
/*      */   
/*      */   public static native void glColor4ui(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglColor4bv(long paramLong);
/*      */   
/*      */   public static native void nglColor4sv(long paramLong);
/*      */   
/*      */   public static native void nglColor4iv(long paramLong);
/*      */   
/*      */   public static native void nglColor4fv(long paramLong);
/*      */   
/*      */   public static native void nglColor4dv(long paramLong);
/*      */   
/*      */   public static native void nglColor4ubv(long paramLong);
/*      */   
/*      */   public static native void nglColor4usv(long paramLong);
/*      */   
/*      */   public static native void nglColor4uiv(long paramLong);
/*      */   
/*      */   public static native void glColorMaterial(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglColorPointer(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glCopyPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5);
/*      */   
/*      */   public static native void glDeleteLists(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2);
/*      */   
/*      */   public static native void glDisableClientState(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglDrawPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glEdgeFlag(@NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void nglEdgeFlagv(long paramLong);
/*      */   
/*      */   public static native void nglEdgeFlagPointer(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glEnableClientState(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glEnd();
/*      */   
/*      */   public static native void glEvalCoord1f(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglEvalCoord1fv(long paramLong);
/*      */   
/*      */   public static native void glEvalCoord1d(@NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglEvalCoord1dv(long paramLong);
/*      */   
/*      */   public static native void glEvalCoord2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void nglEvalCoord2fv(long paramLong);
/*      */   
/*      */   public static native void glEvalCoord2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglEvalCoord2dv(long paramLong);
/*      */   
/*      */   public static native void glEvalMesh1(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glEvalMesh2(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glEvalPoint1(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glEvalPoint2(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void nglFeedbackBuffer(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glFogi(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void nglFogiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glFogf(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglFogfv(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static native int glGenLists(@NativeType("GLsizei") int paramInt);
/*      */   
/*      */   public static native void nglGetClipPlane(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetLightiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetLightfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMapiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMapfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMapdv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMaterialiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMaterialfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPixelMapfv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPixelMapusv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPixelMapuiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPolygonStipple(long paramLong);
/*      */   
/*      */   public static native void nglGetTexEnviv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexEnvfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexGeniv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexGenfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexGendv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glIndexi(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glIndexub(@NativeType("GLubyte") byte paramByte);
/*      */   
/*      */   public static native void glIndexs(@NativeType("GLshort") short paramShort);
/*      */   
/*      */   public static native void glIndexf(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glIndexd(@NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglIndexiv(long paramLong);
/*      */   
/*      */   public static native void nglIndexubv(long paramLong);
/*      */   
/*      */   public static native void nglIndexsv(long paramLong);
/*      */   
/*      */   public static native void nglIndexfv(long paramLong);
/*      */   
/*      */   public static native void nglIndexdv(long paramLong);
/*      */   
/*      */   public static native void glIndexMask(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglIndexPointer(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glInitNames();
/*      */   
/*      */   public static native void nglInterleavedArrays(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsList(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glLightModeli(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glLightModelf(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglLightModeliv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglLightModelfv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glLighti(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glLightf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglLightiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglLightfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glLineStipple(@NativeType("GLint") int paramInt, @NativeType("GLushort") short paramShort);
/*      */   
/*      */   public static native void glListBase(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglLoadMatrixf(long paramLong);
/*      */   
/*      */   public static native void nglLoadMatrixd(long paramLong);
/*      */   
/*      */   public static native void glLoadIdentity();
/*      */   
/*      */   public static native void glLoadName(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglMap1f(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMap1d(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMap2f(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglMap2d(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, double paramDouble3, double paramDouble4, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void glMapGrid1f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glMapGrid1d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glMapGrid2f(@NativeType("GLint") int paramInt1, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glMapGrid2d(@NativeType("GLint") int paramInt1, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glMateriali(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glMaterialf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglMaterialiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglMaterialfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glMatrixMode(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglMultMatrixf(long paramLong);
/*      */   
/*      */   public static native void nglMultMatrixd(long paramLong);
/*      */   
/*      */   public static native void glFrustum(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLdouble") double paramDouble5, @NativeType("GLdouble") double paramDouble6);
/*      */   
/*      */   public static native void glNewList(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glEndList();
/*      */   
/*      */   public static native void glNormal3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glNormal3b(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3);
/*      */   
/*      */   public static native void glNormal3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glNormal3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glNormal3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglNormal3fv(long paramLong);
/*      */   
/*      */   public static native void nglNormal3bv(long paramLong);
/*      */   
/*      */   public static native void nglNormal3sv(long paramLong);
/*      */   
/*      */   public static native void nglNormal3iv(long paramLong);
/*      */   
/*      */   public static native void nglNormal3dv(long paramLong);
/*      */   
/*      */   public static native void nglNormalPointer(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glOrtho(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLdouble") double paramDouble5, @NativeType("GLdouble") double paramDouble6);
/*      */   
/*      */   public static native void glPassThrough(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglPixelMapfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglPixelMapusv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglPixelMapuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glPixelTransferi(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glPixelTransferf(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glPixelZoom(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void nglPolygonStipple(long paramLong);
/*      */   
/*      */   public static native void glPushAttrib(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void glPushClientAttrib(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void glPopAttrib();
/*      */   
/*      */   public static native void glPopClientAttrib();
/*      */   
/*      */   public static native void glPopMatrix();
/*      */   
/*      */   public static native void glPopName();
/*      */   
/*      */   public static native void nglPrioritizeTextures(int paramInt, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glPushMatrix();
/*      */   
/*      */   public static native void glPushName(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glRasterPos2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glRasterPos2s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glRasterPos2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glRasterPos2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglRasterPos2iv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos2sv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos2fv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos2dv(long paramLong);
/*      */   
/*      */   public static native void glRasterPos3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glRasterPos3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glRasterPos3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glRasterPos3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglRasterPos3iv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos3sv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos3fv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos3dv(long paramLong);
/*      */   
/*      */   public static native void glRasterPos4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glRasterPos4s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glRasterPos4f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glRasterPos4d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglRasterPos4iv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos4sv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos4fv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos4dv(long paramLong);
/*      */   
/*      */   public static native void glRecti(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glRects(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glRectf(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glRectd(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglRectiv(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglRectsv(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglRectfv(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglRectdv(long paramLong1, long paramLong2);
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static native int glRenderMode(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glRotatef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glRotated(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glScalef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glScaled(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglSelectBuffer(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glShadeModel(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glTexCoord1f(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glTexCoord1s(@NativeType("GLshort") short paramShort);
/*      */   
/*      */   public static native void glTexCoord1i(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glTexCoord1d(@NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglTexCoord1fv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord1sv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord1iv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord1dv(long paramLong);
/*      */   
/*      */   public static native void glTexCoord2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glTexCoord2s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glTexCoord2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glTexCoord2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglTexCoord2fv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord2sv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord2iv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord2dv(long paramLong);
/*      */   
/*      */   public static native void glTexCoord3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glTexCoord3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glTexCoord3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glTexCoord3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglTexCoord3fv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord3sv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord3iv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord3dv(long paramLong);
/*      */   
/*      */   public static native void glTexCoord4f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glTexCoord4s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glTexCoord4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glTexCoord4d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglTexCoord4fv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord4sv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord4iv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord4dv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoordPointer(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glTexEnvi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglTexEnviv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexEnvf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTexEnvfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexGeni(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglTexGeniv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexGenf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTexGenfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexGend(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglTexGendv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTranslatef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glTranslated(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glVertex2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glVertex2s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glVertex2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glVertex2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglVertex2fv(long paramLong);
/*      */   
/*      */   public static native void nglVertex2sv(long paramLong);
/*      */   
/*      */   public static native void nglVertex2iv(long paramLong);
/*      */   
/*      */   public static native void nglVertex2dv(long paramLong);
/*      */   
/*      */   public static native void glVertex3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glVertex3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glVertex3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glVertex3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglVertex3fv(long paramLong);
/*      */   
/*      */   public static native void nglVertex3sv(long paramLong);
/*      */   
/*      */   public static native void nglVertex3iv(long paramLong);
/*      */   
/*      */   public static native void nglVertex3dv(long paramLong);
/*      */   
/*      */   public static native void glVertex4f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glVertex4s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glVertex4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glVertex4d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglVertex4fv(long paramLong);
/*      */   
/*      */   public static native void nglVertex4sv(long paramLong);
/*      */   
/*      */   public static native void nglVertex4iv(long paramLong);
/*      */   
/*      */   public static native void nglVertex4dv(long paramLong);
/*      */   
/*      */   public static native void nglVertexPointer(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */