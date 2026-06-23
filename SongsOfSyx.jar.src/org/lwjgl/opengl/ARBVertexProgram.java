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
/*      */ public class ARBVertexProgram
/*      */ {
/*      */   public static final int GL_VERTEX_PROGRAM_ARB = 34336;
/*      */   public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
/*      */   
/*      */   static {
/*   21 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
/*      */   
/*      */   public static final int GL_COLOR_SUM_ARB = 33880;
/*      */   
/*      */   public static final int GL_PROGRAM_FORMAT_ASCII_ARB = 34933;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
/*      */   
/*      */   public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
/*      */   
/*      */   public static final int GL_PROGRAM_LENGTH_ARB = 34343;
/*      */   
/*      */   public static final int GL_PROGRAM_FORMAT_ARB = 34934;
/*      */   
/*      */   public static final int GL_PROGRAM_BINDING_ARB = 34423;
/*      */   
/*      */   public static final int GL_PROGRAM_INSTRUCTIONS_ARB = 34976;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_INSTRUCTIONS_ARB = 34977;
/*      */   public static final int GL_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34978;
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34979;
/*      */   public static final int GL_PROGRAM_TEMPORARIES_ARB = 34980;
/*      */   public static final int GL_MAX_PROGRAM_TEMPORARIES_ARB = 34981;
/*      */   public static final int GL_PROGRAM_NATIVE_TEMPORARIES_ARB = 34982;
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_TEMPORARIES_ARB = 34983;
/*      */   public static final int GL_PROGRAM_PARAMETERS_ARB = 34984;
/*      */   public static final int GL_MAX_PROGRAM_PARAMETERS_ARB = 34985;
/*      */   public static final int GL_PROGRAM_NATIVE_PARAMETERS_ARB = 34986;
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_PARAMETERS_ARB = 34987;
/*      */   public static final int GL_PROGRAM_ATTRIBS_ARB = 34988;
/*      */   public static final int GL_MAX_PROGRAM_ATTRIBS_ARB = 34989;
/*      */   public static final int GL_PROGRAM_NATIVE_ATTRIBS_ARB = 34990;
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_ATTRIBS_ARB = 34991;
/*      */   public static final int GL_PROGRAM_ADDRESS_REGISTERS_ARB = 34992;
/*      */   public static final int GL_MAX_PROGRAM_ADDRESS_REGISTERS_ARB = 34993;
/*      */   public static final int GL_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34994;
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34995;
/*      */   public static final int GL_MAX_PROGRAM_LOCAL_PARAMETERS_ARB = 34996;
/*      */   public static final int GL_MAX_PROGRAM_ENV_PARAMETERS_ARB = 34997;
/*      */   public static final int GL_PROGRAM_UNDER_NATIVE_LIMITS_ARB = 34998;
/*      */   public static final int GL_PROGRAM_STRING_ARB = 34344;
/*      */   public static final int GL_PROGRAM_ERROR_POSITION_ARB = 34379;
/*      */   public static final int GL_CURRENT_MATRIX_ARB = 34369;
/*      */   public static final int GL_TRANSPOSE_CURRENT_MATRIX_ARB = 34999;
/*      */   public static final int GL_CURRENT_MATRIX_STACK_DEPTH_ARB = 34368;
/*      */   public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
/*      */   public static final int GL_MAX_PROGRAM_MATRICES_ARB = 34351;
/*      */   public static final int GL_MAX_PROGRAM_MATRIX_STACK_DEPTH_ARB = 34350;
/*      */   public static final int GL_PROGRAM_ERROR_STRING_ARB = 34932;
/*      */   public static final int GL_MATRIX0_ARB = 35008;
/*      */   public static final int GL_MATRIX1_ARB = 35009;
/*      */   public static final int GL_MATRIX2_ARB = 35010;
/*      */   public static final int GL_MATRIX3_ARB = 35011;
/*      */   public static final int GL_MATRIX4_ARB = 35012;
/*      */   public static final int GL_MATRIX5_ARB = 35013;
/*      */   public static final int GL_MATRIX6_ARB = 35014;
/*      */   public static final int GL_MATRIX7_ARB = 35015;
/*      */   public static final int GL_MATRIX8_ARB = 35016;
/*      */   public static final int GL_MATRIX9_ARB = 35017;
/*      */   public static final int GL_MATRIX10_ARB = 35018;
/*      */   public static final int GL_MATRIX11_ARB = 35019;
/*      */   public static final int GL_MATRIX12_ARB = 35020;
/*      */   public static final int GL_MATRIX13_ARB = 35021;
/*      */   public static final int GL_MATRIX14_ARB = 35022;
/*      */   public static final int GL_MATRIX15_ARB = 35023;
/*      */   public static final int GL_MATRIX16_ARB = 35024;
/*      */   public static final int GL_MATRIX17_ARB = 35025;
/*      */   public static final int GL_MATRIX18_ARB = 35026;
/*      */   public static final int GL_MATRIX19_ARB = 35027;
/*      */   public static final int GL_MATRIX20_ARB = 35028;
/*      */   public static final int GL_MATRIX21_ARB = 35029;
/*      */   public static final int GL_MATRIX22_ARB = 35030;
/*      */   public static final int GL_MATRIX23_ARB = 35031;
/*      */   public static final int GL_MATRIX24_ARB = 35032;
/*      */   public static final int GL_MATRIX25_ARB = 35033;
/*      */   public static final int GL_MATRIX26_ARB = 35034;
/*      */   public static final int GL_MATRIX27_ARB = 35035;
/*      */   public static final int GL_MATRIX28_ARB = 35036;
/*      */   public static final int GL_MATRIX29_ARB = 35037;
/*      */   public static final int GL_MATRIX30_ARB = 35038;
/*      */   public static final int GL_MATRIX31_ARB = 35039;
/*      */   
/*      */   protected ARBVertexProgram() {
/*  118 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1sARB(@NativeType("GLuint") int index, @NativeType("GLshort") short v0) {
/*  125 */     ARBVertexShader.glVertexAttrib1sARB(index, v0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fARB(@NativeType("GLuint") int index, @NativeType("GLfloat") float v0) {
/*  132 */     ARBVertexShader.glVertexAttrib1fARB(index, v0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dARB(@NativeType("GLuint") int index, @NativeType("GLdouble") double v0) {
/*  139 */     ARBVertexShader.glVertexAttrib1dARB(index, v0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2sARB(@NativeType("GLuint") int index, @NativeType("GLshort") short v0, @NativeType("GLshort") short v1) {
/*  146 */     ARBVertexShader.glVertexAttrib2sARB(index, v0, v1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fARB(@NativeType("GLuint") int index, @NativeType("GLfloat") float v0, @NativeType("GLfloat") float v1) {
/*  153 */     ARBVertexShader.glVertexAttrib2fARB(index, v0, v1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dARB(@NativeType("GLuint") int index, @NativeType("GLdouble") double v0, @NativeType("GLdouble") double v1) {
/*  160 */     ARBVertexShader.glVertexAttrib2dARB(index, v0, v1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3sARB(@NativeType("GLuint") int index, @NativeType("GLshort") short v0, @NativeType("GLshort") short v1, @NativeType("GLshort") short v2) {
/*  167 */     ARBVertexShader.glVertexAttrib3sARB(index, v0, v1, v2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fARB(@NativeType("GLuint") int index, @NativeType("GLfloat") float v0, @NativeType("GLfloat") float v1, @NativeType("GLfloat") float v2) {
/*  174 */     ARBVertexShader.glVertexAttrib3fARB(index, v0, v1, v2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dARB(@NativeType("GLuint") int index, @NativeType("GLdouble") double v0, @NativeType("GLdouble") double v1, @NativeType("GLdouble") double v2) {
/*  181 */     ARBVertexShader.glVertexAttrib3dARB(index, v0, v1, v2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4sARB(@NativeType("GLuint") int index, @NativeType("GLshort") short v0, @NativeType("GLshort") short v1, @NativeType("GLshort") short v2, @NativeType("GLshort") short v3) {
/*  188 */     ARBVertexShader.glVertexAttrib4sARB(index, v0, v1, v2, v3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fARB(@NativeType("GLuint") int index, @NativeType("GLfloat") float v0, @NativeType("GLfloat") float v1, @NativeType("GLfloat") float v2, @NativeType("GLfloat") float v3) {
/*  195 */     ARBVertexShader.glVertexAttrib4fARB(index, v0, v1, v2, v3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dARB(@NativeType("GLuint") int index, @NativeType("GLdouble") double v0, @NativeType("GLdouble") double v1, @NativeType("GLdouble") double v2, @NativeType("GLdouble") double v3) {
/*  202 */     ARBVertexShader.glVertexAttrib4dARB(index, v0, v1, v2, v3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NubARB(@NativeType("GLuint") int index, @NativeType("GLubyte") byte x, @NativeType("GLubyte") byte y, @NativeType("GLubyte") byte z, @NativeType("GLubyte") byte w) {
/*  209 */     ARBVertexShader.glVertexAttrib4NubARB(index, x, y, z, w);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1svARB(int index, long v) {
/*  216 */     ARBVertexShader.nglVertexAttrib1svARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  221 */     ARBVertexShader.glVertexAttrib1svARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1fvARB(int index, long v) {
/*  228 */     ARBVertexShader.nglVertexAttrib1fvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  233 */     ARBVertexShader.glVertexAttrib1fvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1dvARB(int index, long v) {
/*  240 */     ARBVertexShader.nglVertexAttrib1dvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  245 */     ARBVertexShader.glVertexAttrib1dvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2svARB(int index, long v) {
/*  252 */     ARBVertexShader.nglVertexAttrib2svARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  257 */     ARBVertexShader.glVertexAttrib2svARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2fvARB(int index, long v) {
/*  264 */     ARBVertexShader.nglVertexAttrib2fvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  269 */     ARBVertexShader.glVertexAttrib2fvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2dvARB(int index, long v) {
/*  276 */     ARBVertexShader.nglVertexAttrib2dvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  281 */     ARBVertexShader.glVertexAttrib2dvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3svARB(int index, long v) {
/*  288 */     ARBVertexShader.nglVertexAttrib3svARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  293 */     ARBVertexShader.glVertexAttrib3svARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3fvARB(int index, long v) {
/*  300 */     ARBVertexShader.nglVertexAttrib3fvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  305 */     ARBVertexShader.glVertexAttrib3fvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3dvARB(int index, long v) {
/*  312 */     ARBVertexShader.nglVertexAttrib3dvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  317 */     ARBVertexShader.glVertexAttrib3dvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4fvARB(int index, long v) {
/*  324 */     ARBVertexShader.nglVertexAttrib4fvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  329 */     ARBVertexShader.glVertexAttrib4fvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4bvARB(int index, long v) {
/*  336 */     ARBVertexShader.nglVertexAttrib4bvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4bvARB(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/*  341 */     ARBVertexShader.glVertexAttrib4bvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4svARB(int index, long v) {
/*  348 */     ARBVertexShader.nglVertexAttrib4svARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  353 */     ARBVertexShader.glVertexAttrib4svARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4ivARB(int index, long v) {
/*  360 */     ARBVertexShader.nglVertexAttrib4ivARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4ivARB(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  365 */     ARBVertexShader.glVertexAttrib4ivARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4ubvARB(int index, long v) {
/*  372 */     ARBVertexShader.nglVertexAttrib4ubvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4ubvARB(@NativeType("GLuint") int index, @NativeType("GLubyte const *") ByteBuffer v) {
/*  377 */     ARBVertexShader.glVertexAttrib4ubvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4usvARB(int index, long v) {
/*  384 */     ARBVertexShader.nglVertexAttrib4usvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usvARB(@NativeType("GLuint") int index, @NativeType("GLushort const *") ShortBuffer v) {
/*  389 */     ARBVertexShader.glVertexAttrib4usvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4uivARB(int index, long v) {
/*  396 */     ARBVertexShader.nglVertexAttrib4uivARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uivARB(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/*  401 */     ARBVertexShader.glVertexAttrib4uivARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4dvARB(int index, long v) {
/*  408 */     ARBVertexShader.nglVertexAttrib4dvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  413 */     ARBVertexShader.glVertexAttrib4dvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NbvARB(int index, long v) {
/*  420 */     ARBVertexShader.nglVertexAttrib4NbvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NbvARB(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/*  425 */     ARBVertexShader.glVertexAttrib4NbvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NsvARB(int index, long v) {
/*  432 */     ARBVertexShader.nglVertexAttrib4NsvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NsvARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  437 */     ARBVertexShader.glVertexAttrib4NsvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NivARB(int index, long v) {
/*  444 */     ARBVertexShader.nglVertexAttrib4NivARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NivARB(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  449 */     ARBVertexShader.glVertexAttrib4NivARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NubvARB(int index, long v) {
/*  456 */     ARBVertexShader.nglVertexAttrib4NubvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NubvARB(@NativeType("GLuint") int index, @NativeType("GLubyte const *") ByteBuffer v) {
/*  461 */     ARBVertexShader.glVertexAttrib4NubvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NusvARB(int index, long v) {
/*  468 */     ARBVertexShader.nglVertexAttrib4NusvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NusvARB(@NativeType("GLuint") int index, @NativeType("GLushort const *") ShortBuffer v) {
/*  473 */     ARBVertexShader.glVertexAttrib4NusvARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NuivARB(int index, long v) {
/*  480 */     ARBVertexShader.nglVertexAttrib4NuivARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NuivARB(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/*  485 */     ARBVertexShader.glVertexAttrib4NuivARB(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribPointerARB(int index, int size, int type, boolean normalized, int stride, long pointer) {
/*  492 */     ARBVertexShader.nglVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/*  497 */     ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/*  502 */     ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/*  507 */     ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/*  512 */     ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/*  517 */     ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnableVertexAttribArrayARB(@NativeType("GLuint") int index) {
/*  524 */     ARBVertexShader.glEnableVertexAttribArrayARB(index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisableVertexAttribArrayARB(@NativeType("GLuint") int index) {
/*  531 */     ARBVertexShader.glDisableVertexAttribArrayARB(index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramStringARB(@NativeType("GLenum") int target, @NativeType("GLenum") int format, @NativeType("void const *") ByteBuffer string) {
/*  541 */     nglProgramStringARB(target, format, string.remaining(), MemoryUtil.memAddress(string));
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
/*      */   public static void glDeleteProgramsARB(@NativeType("GLuint const *") IntBuffer programs) {
/*  556 */     nglDeleteProgramsARB(programs.remaining(), MemoryUtil.memAddress(programs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenProgramsARB(@NativeType("GLuint *") IntBuffer programs) {
/*  566 */     nglGenProgramsARB(programs.remaining(), MemoryUtil.memAddress(programs));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenProgramsARB() {
/*  572 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  574 */       IntBuffer programs = stack.callocInt(1);
/*  575 */       nglGenProgramsARB(1, MemoryUtil.memAddress(programs));
/*  576 */       return programs.get(0);
/*      */     } finally {
/*  578 */       stack.setPointer(stackPointer);
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
/*      */   public static void glProgramEnvParameter4dvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer params) {
/*  594 */     if (Checks.CHECKS) {
/*  595 */       Checks.check(params, 4);
/*      */     }
/*  597 */     nglProgramEnvParameter4dvARB(target, index, MemoryUtil.memAddress(params));
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
/*      */   public static void glProgramEnvParameter4fvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer params) {
/*  612 */     if (Checks.CHECKS) {
/*  613 */       Checks.check(params, 4);
/*      */     }
/*  615 */     nglProgramEnvParameter4fvARB(target, index, MemoryUtil.memAddress(params));
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
/*      */   public static void glProgramLocalParameter4dvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer params) {
/*  630 */     if (Checks.CHECKS) {
/*  631 */       Checks.check(params, 4);
/*      */     }
/*  633 */     nglProgramLocalParameter4dvARB(target, index, MemoryUtil.memAddress(params));
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
/*      */   public static void glProgramLocalParameter4fvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer params) {
/*  648 */     if (Checks.CHECKS) {
/*  649 */       Checks.check(params, 4);
/*      */     }
/*  651 */     nglProgramLocalParameter4fvARB(target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramEnvParameterfvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer params) {
/*  661 */     if (Checks.CHECKS) {
/*  662 */       Checks.check(params, 4);
/*      */     }
/*  664 */     nglGetProgramEnvParameterfvARB(target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramEnvParameterdvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") DoubleBuffer params) {
/*  674 */     if (Checks.CHECKS) {
/*  675 */       Checks.check(params, 4);
/*      */     }
/*  677 */     nglGetProgramEnvParameterdvARB(target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramLocalParameterfvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer params) {
/*  687 */     if (Checks.CHECKS) {
/*  688 */       Checks.check(params, 4);
/*      */     }
/*  690 */     nglGetProgramLocalParameterfvARB(target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramLocalParameterdvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") DoubleBuffer params) {
/*  700 */     if (Checks.CHECKS) {
/*  701 */       Checks.check(params, 4);
/*      */     }
/*  703 */     nglGetProgramLocalParameterdvARB(target, index, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramivARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  713 */     if (Checks.CHECKS) {
/*  714 */       Checks.check(params, 1);
/*      */     }
/*  716 */     nglGetProgramivARB(target, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetProgramiARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/*  722 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  724 */       IntBuffer params = stack.callocInt(1);
/*  725 */       nglGetProgramivARB(target, pname, MemoryUtil.memAddress(params));
/*  726 */       return params.get(0);
/*      */     } finally {
/*  728 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramStringARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("void *") ByteBuffer string) {
/*  739 */     if (Checks.CHECKS && 
/*  740 */       Checks.DEBUG) {
/*  741 */       Checks.check(string, glGetProgramiARB(target, 34343));
/*      */     }
/*      */     
/*  744 */     nglGetProgramStringARB(target, pname, MemoryUtil.memAddress(string));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribfvARB(int index, int pname, long params) {
/*  751 */     ARBVertexShader.nglGetVertexAttribfvARB(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfvARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/*  756 */     ARBVertexShader.glGetVertexAttribfvARB(index, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribdvARB(int index, int pname, long params) {
/*  763 */     ARBVertexShader.nglGetVertexAttribdvARB(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdvARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/*  768 */     ARBVertexShader.glGetVertexAttribdvARB(index, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribivARB(int index, int pname, long params) {
/*  775 */     ARBVertexShader.nglGetVertexAttribivARB(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribivARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  780 */     ARBVertexShader.glGetVertexAttribivARB(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexAttribiARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/*  786 */     return ARBVertexShader.glGetVertexAttribiARB(index, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribPointervARB(int index, int pname, long pointer) {
/*  793 */     ARBVertexShader.nglGetVertexAttribPointervARB(index, pname, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribPointervARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer pointer) {
/*  798 */     ARBVertexShader.glGetVertexAttribPointervARB(index, pname, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/*  804 */     return ARBVertexShader.glGetVertexAttribPointerARB(index, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/*  815 */     ARBVertexShader.glVertexAttrib1svARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/*  820 */     ARBVertexShader.glVertexAttrib1fvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/*  825 */     ARBVertexShader.glVertexAttrib1dvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/*  830 */     ARBVertexShader.glVertexAttrib2svARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/*  835 */     ARBVertexShader.glVertexAttrib2fvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/*  840 */     ARBVertexShader.glVertexAttrib2dvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/*  845 */     ARBVertexShader.glVertexAttrib3svARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/*  850 */     ARBVertexShader.glVertexAttrib3fvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/*  855 */     ARBVertexShader.glVertexAttrib3dvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/*  860 */     ARBVertexShader.glVertexAttrib4fvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/*  865 */     ARBVertexShader.glVertexAttrib4svARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4ivARB(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/*  870 */     ARBVertexShader.glVertexAttrib4ivARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usvARB(@NativeType("GLuint") int index, @NativeType("GLushort const *") short[] v) {
/*  875 */     ARBVertexShader.glVertexAttrib4usvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uivARB(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/*  880 */     ARBVertexShader.glVertexAttrib4uivARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/*  885 */     ARBVertexShader.glVertexAttrib4dvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NsvARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/*  890 */     ARBVertexShader.glVertexAttrib4NsvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NivARB(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/*  895 */     ARBVertexShader.glVertexAttrib4NivARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NusvARB(@NativeType("GLuint") int index, @NativeType("GLushort const *") short[] v) {
/*  900 */     ARBVertexShader.glVertexAttrib4NusvARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NuivARB(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/*  905 */     ARBVertexShader.glVertexAttrib4NuivARB(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") short[] pointer) {
/*  910 */     ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") int[] pointer) {
/*  915 */     ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") float[] pointer) {
/*  920 */     ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramsARB(@NativeType("GLuint const *") int[] programs) {
/*  925 */     long __functionAddress = (GL.getICD()).glDeleteProgramsARB;
/*  926 */     if (Checks.CHECKS) {
/*  927 */       Checks.check(__functionAddress);
/*      */     }
/*  929 */     JNI.callPV(programs.length, programs, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenProgramsARB(@NativeType("GLuint *") int[] programs) {
/*  934 */     long __functionAddress = (GL.getICD()).glGenProgramsARB;
/*  935 */     if (Checks.CHECKS) {
/*  936 */       Checks.check(__functionAddress);
/*      */     }
/*  938 */     JNI.callPV(programs.length, programs, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramEnvParameter4dvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] params) {
/*  943 */     long __functionAddress = (GL.getICD()).glProgramEnvParameter4dvARB;
/*  944 */     if (Checks.CHECKS) {
/*  945 */       Checks.check(__functionAddress);
/*  946 */       Checks.check(params, 4);
/*      */     } 
/*  948 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramEnvParameter4fvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] params) {
/*  953 */     long __functionAddress = (GL.getICD()).glProgramEnvParameter4fvARB;
/*  954 */     if (Checks.CHECKS) {
/*  955 */       Checks.check(__functionAddress);
/*  956 */       Checks.check(params, 4);
/*      */     } 
/*  958 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramLocalParameter4dvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] params) {
/*  963 */     long __functionAddress = (GL.getICD()).glProgramLocalParameter4dvARB;
/*  964 */     if (Checks.CHECKS) {
/*  965 */       Checks.check(__functionAddress);
/*  966 */       Checks.check(params, 4);
/*      */     } 
/*  968 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramLocalParameter4fvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] params) {
/*  973 */     long __functionAddress = (GL.getICD()).glProgramLocalParameter4fvARB;
/*  974 */     if (Checks.CHECKS) {
/*  975 */       Checks.check(__functionAddress);
/*  976 */       Checks.check(params, 4);
/*      */     } 
/*  978 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramEnvParameterfvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] params) {
/*  983 */     long __functionAddress = (GL.getICD()).glGetProgramEnvParameterfvARB;
/*  984 */     if (Checks.CHECKS) {
/*  985 */       Checks.check(__functionAddress);
/*  986 */       Checks.check(params, 4);
/*      */     } 
/*  988 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramEnvParameterdvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") double[] params) {
/*  993 */     long __functionAddress = (GL.getICD()).glGetProgramEnvParameterdvARB;
/*  994 */     if (Checks.CHECKS) {
/*  995 */       Checks.check(__functionAddress);
/*  996 */       Checks.check(params, 4);
/*      */     } 
/*  998 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramLocalParameterfvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] params) {
/* 1003 */     long __functionAddress = (GL.getICD()).glGetProgramLocalParameterfvARB;
/* 1004 */     if (Checks.CHECKS) {
/* 1005 */       Checks.check(__functionAddress);
/* 1006 */       Checks.check(params, 4);
/*      */     } 
/* 1008 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramLocalParameterdvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") double[] params) {
/* 1013 */     long __functionAddress = (GL.getICD()).glGetProgramLocalParameterdvARB;
/* 1014 */     if (Checks.CHECKS) {
/* 1015 */       Checks.check(__functionAddress);
/* 1016 */       Checks.check(params, 4);
/*      */     } 
/* 1018 */     JNI.callPV(target, index, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramivARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1023 */     long __functionAddress = (GL.getICD()).glGetProgramivARB;
/* 1024 */     if (Checks.CHECKS) {
/* 1025 */       Checks.check(__functionAddress);
/* 1026 */       Checks.check(params, 1);
/*      */     } 
/* 1028 */     JNI.callPV(target, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfvARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 1033 */     ARBVertexShader.glGetVertexAttribfvARB(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdvARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 1038 */     ARBVertexShader.glGetVertexAttribdvARB(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribivARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1043 */     ARBVertexShader.glGetVertexAttribivARB(index, pname, params);
/*      */   }
/*      */   
/*      */   public static native void nglProgramStringARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glBindProgramARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglDeleteProgramsARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenProgramsARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glProgramEnvParameter4dARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglProgramEnvParameter4dvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glProgramEnvParameter4fARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void nglProgramEnvParameter4fvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glProgramLocalParameter4dARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglProgramLocalParameter4dvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glProgramLocalParameter4fARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void nglProgramLocalParameter4fvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramEnvParameterfvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramEnvParameterdvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramLocalParameterfvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramLocalParameterdvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramStringARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsProgramARB(@NativeType("GLuint") int paramInt);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBVertexProgram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */