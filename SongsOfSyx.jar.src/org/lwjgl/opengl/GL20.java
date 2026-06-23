/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL20
/*      */   extends GL15
/*      */ {
/*      */   public static final int GL_SHADING_LANGUAGE_VERSION = 35724;
/*      */   public static final int GL_CURRENT_PROGRAM = 35725;
/*      */   
/*      */   static {
/*   18 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_SHADER_TYPE = 35663;
/*      */   
/*      */   public static final int GL_DELETE_STATUS = 35712;
/*      */   
/*      */   public static final int GL_COMPILE_STATUS = 35713;
/*      */   
/*      */   public static final int GL_LINK_STATUS = 35714;
/*      */   
/*      */   public static final int GL_VALIDATE_STATUS = 35715;
/*      */   
/*      */   public static final int GL_INFO_LOG_LENGTH = 35716;
/*      */   
/*      */   public static final int GL_ATTACHED_SHADERS = 35717;
/*      */   
/*      */   public static final int GL_ACTIVE_UNIFORMS = 35718;
/*      */   
/*      */   public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719;
/*      */   
/*      */   public static final int GL_ACTIVE_ATTRIBUTES = 35721;
/*      */   
/*      */   public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722;
/*      */   
/*      */   public static final int GL_SHADER_SOURCE_LENGTH = 35720;
/*      */   
/*      */   public static final int GL_FLOAT_VEC2 = 35664;
/*      */   
/*      */   public static final int GL_FLOAT_VEC3 = 35665;
/*      */   
/*      */   public static final int GL_FLOAT_VEC4 = 35666;
/*      */   
/*      */   public static final int GL_INT_VEC2 = 35667;
/*      */   
/*      */   public static final int GL_INT_VEC3 = 35668;
/*      */   
/*      */   public static final int GL_INT_VEC4 = 35669;
/*      */   
/*      */   public static final int GL_BOOL = 35670;
/*      */   
/*      */   public static final int GL_BOOL_VEC2 = 35671;
/*      */   
/*      */   public static final int GL_BOOL_VEC3 = 35672;
/*      */   
/*      */   public static final int GL_BOOL_VEC4 = 35673;
/*      */   
/*      */   public static final int GL_FLOAT_MAT2 = 35674;
/*      */   
/*      */   public static final int GL_FLOAT_MAT3 = 35675;
/*      */   
/*      */   public static final int GL_FLOAT_MAT4 = 35676;
/*      */   
/*      */   public static final int GL_SAMPLER_1D = 35677;
/*      */   
/*      */   public static final int GL_SAMPLER_2D = 35678;
/*      */   
/*      */   public static final int GL_SAMPLER_3D = 35679;
/*      */   public static final int GL_SAMPLER_CUBE = 35680;
/*      */   public static final int GL_SAMPLER_1D_SHADOW = 35681;
/*      */   public static final int GL_SAMPLER_2D_SHADOW = 35682;
/*      */   public static final int GL_VERTEX_SHADER = 35633;
/*      */   public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658;
/*      */   public static final int GL_MAX_VARYING_FLOATS = 35659;
/*      */   public static final int GL_MAX_VERTEX_ATTRIBS = 34921;
/*      */   public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930;
/*      */   public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660;
/*      */   public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661;
/*      */   public static final int GL_MAX_TEXTURE_COORDS = 34929;
/*      */   public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;
/*      */   public static final int GL_VERTEX_PROGRAM_TWO_SIDE = 34371;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922;
/*      */   public static final int GL_CURRENT_VERTEX_ATTRIB = 34342;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373;
/*      */   public static final int GL_FRAGMENT_SHADER = 35632;
/*      */   public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657;
/*      */   public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723;
/*      */   public static final int GL_MAX_DRAW_BUFFERS = 34852;
/*      */   public static final int GL_DRAW_BUFFER0 = 34853;
/*      */   public static final int GL_DRAW_BUFFER1 = 34854;
/*      */   public static final int GL_DRAW_BUFFER2 = 34855;
/*      */   public static final int GL_DRAW_BUFFER3 = 34856;
/*      */   public static final int GL_DRAW_BUFFER4 = 34857;
/*      */   public static final int GL_DRAW_BUFFER5 = 34858;
/*      */   public static final int GL_DRAW_BUFFER6 = 34859;
/*      */   public static final int GL_DRAW_BUFFER7 = 34860;
/*      */   public static final int GL_DRAW_BUFFER8 = 34861;
/*      */   public static final int GL_DRAW_BUFFER9 = 34862;
/*      */   public static final int GL_DRAW_BUFFER10 = 34863;
/*      */   public static final int GL_DRAW_BUFFER11 = 34864;
/*      */   public static final int GL_DRAW_BUFFER12 = 34865;
/*      */   public static final int GL_DRAW_BUFFER13 = 34866;
/*      */   public static final int GL_DRAW_BUFFER14 = 34867;
/*      */   public static final int GL_DRAW_BUFFER15 = 34868;
/*      */   public static final int GL_POINT_SPRITE = 34913;
/*      */   public static final int GL_COORD_REPLACE = 34914;
/*      */   public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000;
/*      */   public static final int GL_LOWER_LEFT = 36001;
/*      */   public static final int GL_UPPER_LEFT = 36002;
/*      */   public static final int GL_BLEND_EQUATION_RGB = 32777;
/*      */   public static final int GL_BLEND_EQUATION_ALPHA = 34877;
/*      */   public static final int GL_STENCIL_BACK_FUNC = 34816;
/*      */   public static final int GL_STENCIL_BACK_FAIL = 34817;
/*      */   public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818;
/*      */   public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819;
/*      */   public static final int GL_STENCIL_BACK_REF = 36003;
/*      */   public static final int GL_STENCIL_BACK_VALUE_MASK = 36004;
/*      */   public static final int GL_STENCIL_BACK_WRITEMASK = 36005;
/*      */   
/*      */   protected GL20() {
/*  133 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateProgram() {
/*  141 */     return GL20C.glCreateProgram();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteProgram(@NativeType("GLuint") int program) {
/*  148 */     GL20C.glDeleteProgram(program);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsProgram(@NativeType("GLuint") int program) {
/*  156 */     return GL20C.glIsProgram(program);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShader(@NativeType("GLenum") int type) {
/*  164 */     return GL20C.glCreateShader(type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteShader(@NativeType("GLuint") int shader) {
/*  171 */     GL20C.glDeleteShader(shader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsShader(@NativeType("GLuint") int shader) {
/*  179 */     return GL20C.glIsShader(shader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glAttachShader(@NativeType("GLuint") int program, @NativeType("GLuint") int shader) {
/*  186 */     GL20C.glAttachShader(program, shader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDetachShader(@NativeType("GLuint") int program, @NativeType("GLuint") int shader) {
/*  193 */     GL20C.glDetachShader(program, shader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglShaderSource(int shader, int count, long strings, long length) {
/*  200 */     GL20C.nglShaderSource(shader, count, strings, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderSource(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") PointerBuffer strings, @NativeType("GLint const *") IntBuffer length) {
/*  205 */     GL20C.glShaderSource(shader, strings, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderSource(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") CharSequence... strings) {
/*  210 */     GL20C.glShaderSource(shader, strings);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderSource(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") CharSequence string) {
/*  215 */     GL20C.glShaderSource(shader, string);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompileShader(@NativeType("GLuint") int shader) {
/*  222 */     GL20C.glCompileShader(shader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLinkProgram(@NativeType("GLuint") int program) {
/*  229 */     GL20C.glLinkProgram(program);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUseProgram(@NativeType("GLuint") int program) {
/*  236 */     GL20C.glUseProgram(program);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glValidateProgram(@NativeType("GLuint") int program) {
/*  243 */     GL20C.glValidateProgram(program);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1f(@NativeType("GLint") int location, @NativeType("GLfloat") float v0) {
/*  250 */     GL20C.glUniform1f(location, v0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2f(@NativeType("GLint") int location, @NativeType("GLfloat") float v0, @NativeType("GLfloat") float v1) {
/*  257 */     GL20C.glUniform2f(location, v0, v1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3f(@NativeType("GLint") int location, @NativeType("GLfloat") float v0, @NativeType("GLfloat") float v1, @NativeType("GLfloat") float v2) {
/*  264 */     GL20C.glUniform3f(location, v0, v1, v2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4f(@NativeType("GLint") int location, @NativeType("GLfloat") float v0, @NativeType("GLfloat") float v1, @NativeType("GLfloat") float v2, @NativeType("GLfloat") float v3) {
/*  271 */     GL20C.glUniform4f(location, v0, v1, v2, v3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1i(@NativeType("GLint") int location, @NativeType("GLint") int v0) {
/*  278 */     GL20C.glUniform1i(location, v0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2i(@NativeType("GLint") int location, @NativeType("GLint") int v0, @NativeType("GLint") int v1) {
/*  285 */     GL20C.glUniform2i(location, v0, v1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3i(@NativeType("GLint") int location, @NativeType("GLint") int v0, @NativeType("GLint") int v1, @NativeType("GLint") int v2) {
/*  292 */     GL20C.glUniform3i(location, v0, v1, v2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4i(@NativeType("GLint") int location, @NativeType("GLint") int v0, @NativeType("GLint") int v1, @NativeType("GLint") int v2, @NativeType("GLint") int v3) {
/*  299 */     GL20C.glUniform4i(location, v0, v1, v2, v3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform1fv(int location, int count, long value) {
/*  306 */     GL20C.nglUniform1fv(location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform1fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  311 */     GL20C.glUniform1fv(location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform2fv(int location, int count, long value) {
/*  318 */     GL20C.nglUniform2fv(location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform2fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  323 */     GL20C.glUniform2fv(location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform3fv(int location, int count, long value) {
/*  330 */     GL20C.nglUniform3fv(location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform3fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  335 */     GL20C.glUniform3fv(location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform4fv(int location, int count, long value) {
/*  342 */     GL20C.nglUniform4fv(location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform4fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  347 */     GL20C.glUniform4fv(location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform1iv(int location, int count, long value) {
/*  354 */     GL20C.nglUniform1iv(location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform1iv(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  359 */     GL20C.glUniform1iv(location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform2iv(int location, int count, long value) {
/*  366 */     GL20C.nglUniform2iv(location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform2iv(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  371 */     GL20C.glUniform2iv(location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform3iv(int location, int count, long value) {
/*  378 */     GL20C.nglUniform3iv(location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform3iv(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  383 */     GL20C.glUniform3iv(location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform4iv(int location, int count, long value) {
/*  390 */     GL20C.nglUniform4iv(location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform4iv(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  395 */     GL20C.glUniform4iv(location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix2fv(int location, int count, boolean transpose, long value) {
/*  402 */     GL20C.nglUniformMatrix2fv(location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  407 */     GL20C.glUniformMatrix2fv(location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix3fv(int location, int count, boolean transpose, long value) {
/*  414 */     GL20C.nglUniformMatrix3fv(location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  419 */     GL20C.glUniformMatrix3fv(location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix4fv(int location, int count, boolean transpose, long value) {
/*  426 */     GL20C.nglUniformMatrix4fv(location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  431 */     GL20C.glUniformMatrix4fv(location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetShaderiv(int shader, int pname, long params) {
/*  438 */     GL20C.nglGetShaderiv(shader, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderiv(@NativeType("GLuint") int shader, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  443 */     GL20C.glGetShaderiv(shader, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetShaderi(@NativeType("GLuint") int shader, @NativeType("GLenum") int pname) {
/*  449 */     return GL20C.glGetShaderi(shader, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramiv(int program, int pname, long params) {
/*  456 */     GL20C.nglGetProgramiv(program, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramiv(@NativeType("GLuint") int program, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  461 */     GL20C.glGetProgramiv(program, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetProgrami(@NativeType("GLuint") int program, @NativeType("GLenum") int pname) {
/*  467 */     return GL20C.glGetProgrami(program, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetShaderInfoLog(int shader, int maxLength, long length, long infoLog) {
/*  474 */     GL20C.nglGetShaderInfoLog(shader, maxLength, length, infoLog);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderInfoLog(@NativeType("GLuint") int shader, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer infoLog) {
/*  479 */     GL20C.glGetShaderInfoLog(shader, length, infoLog);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderInfoLog(@NativeType("GLuint") int shader, @NativeType("GLsizei") int maxLength) {
/*  485 */     return GL20C.glGetShaderInfoLog(shader, maxLength);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderInfoLog(@NativeType("GLuint") int shader) {
/*  491 */     return glGetShaderInfoLog(shader, glGetShaderi(shader, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramInfoLog(int program, int maxLength, long length, long infoLog) {
/*  498 */     GL20C.nglGetProgramInfoLog(program, maxLength, length, infoLog);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramInfoLog(@NativeType("GLuint") int program, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer infoLog) {
/*  503 */     GL20C.glGetProgramInfoLog(program, length, infoLog);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramInfoLog(@NativeType("GLuint") int program, @NativeType("GLsizei") int maxLength) {
/*  509 */     return GL20C.glGetProgramInfoLog(program, maxLength);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramInfoLog(@NativeType("GLuint") int program) {
/*  515 */     return glGetProgramInfoLog(program, glGetProgrami(program, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetAttachedShaders(int program, int maxCount, long count, long shaders) {
/*  522 */     GL20C.nglGetAttachedShaders(program, maxCount, count, shaders);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetAttachedShaders(@NativeType("GLuint") int program, @NativeType("GLsizei *") IntBuffer count, @NativeType("GLuint *") IntBuffer shaders) {
/*  527 */     GL20C.glGetAttachedShaders(program, count, shaders);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetUniformLocation(int program, long name) {
/*  534 */     return GL20C.nglGetUniformLocation(program, name);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetUniformLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/*  540 */     return GL20C.glGetUniformLocation(program, name);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetUniformLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/*  546 */     return GL20C.glGetUniformLocation(program, name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetActiveUniform(int program, int index, int maxLength, long length, long size, long type, long name) {
/*  553 */     GL20C.nglGetActiveUniform(program, index, maxLength, length, size, type, name);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetActiveUniform(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type, @NativeType("GLchar *") ByteBuffer name) {
/*  558 */     GL20C.glGetActiveUniform(program, index, length, size, type, name);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveUniform(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei") int maxLength, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/*  564 */     return GL20C.glGetActiveUniform(program, index, maxLength, size, type);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveUniform(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/*  570 */     return glGetActiveUniform(program, index, glGetProgrami(program, 35719), size, type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetUniformfv(int program, int location, long params) {
/*  577 */     GL20C.nglGetUniformfv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") FloatBuffer params) {
/*  582 */     GL20C.glGetUniformfv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetUniformf(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/*  588 */     return GL20C.glGetUniformf(program, location);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetUniformiv(int program, int location, long params) {
/*  595 */     GL20C.nglGetUniformiv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") IntBuffer params) {
/*  600 */     GL20C.glGetUniformiv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetUniformi(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/*  606 */     return GL20C.glGetUniformi(program, location);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetShaderSource(int shader, int maxLength, long length, long source) {
/*  613 */     GL20C.nglGetShaderSource(shader, maxLength, length, source);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderSource(@NativeType("GLuint") int shader, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer source) {
/*  618 */     GL20C.glGetShaderSource(shader, length, source);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderSource(@NativeType("GLuint") int shader, @NativeType("GLsizei") int maxLength) {
/*  624 */     return GL20C.glGetShaderSource(shader, maxLength);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderSource(@NativeType("GLuint") int shader) {
/*  630 */     return glGetShaderSource(shader, glGetShaderi(shader, 35720));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1f(@NativeType("GLuint") int index, @NativeType("GLfloat") float v0) {
/*  637 */     GL20C.glVertexAttrib1f(index, v0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1s(@NativeType("GLuint") int index, @NativeType("GLshort") short v0) {
/*  644 */     GL20C.glVertexAttrib1s(index, v0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1d(@NativeType("GLuint") int index, @NativeType("GLdouble") double v0) {
/*  651 */     GL20C.glVertexAttrib1d(index, v0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2f(@NativeType("GLuint") int index, @NativeType("GLfloat") float v0, @NativeType("GLfloat") float v1) {
/*  658 */     GL20C.glVertexAttrib2f(index, v0, v1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2s(@NativeType("GLuint") int index, @NativeType("GLshort") short v0, @NativeType("GLshort") short v1) {
/*  665 */     GL20C.glVertexAttrib2s(index, v0, v1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2d(@NativeType("GLuint") int index, @NativeType("GLdouble") double v0, @NativeType("GLdouble") double v1) {
/*  672 */     GL20C.glVertexAttrib2d(index, v0, v1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3f(@NativeType("GLuint") int index, @NativeType("GLfloat") float v0, @NativeType("GLfloat") float v1, @NativeType("GLfloat") float v2) {
/*  679 */     GL20C.glVertexAttrib3f(index, v0, v1, v2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3s(@NativeType("GLuint") int index, @NativeType("GLshort") short v0, @NativeType("GLshort") short v1, @NativeType("GLshort") short v2) {
/*  686 */     GL20C.glVertexAttrib3s(index, v0, v1, v2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3d(@NativeType("GLuint") int index, @NativeType("GLdouble") double v0, @NativeType("GLdouble") double v1, @NativeType("GLdouble") double v2) {
/*  693 */     GL20C.glVertexAttrib3d(index, v0, v1, v2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4f(@NativeType("GLuint") int index, @NativeType("GLfloat") float v0, @NativeType("GLfloat") float v1, @NativeType("GLfloat") float v2, @NativeType("GLfloat") float v3) {
/*  700 */     GL20C.glVertexAttrib4f(index, v0, v1, v2, v3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4s(@NativeType("GLuint") int index, @NativeType("GLshort") short v0, @NativeType("GLshort") short v1, @NativeType("GLshort") short v2, @NativeType("GLshort") short v3) {
/*  707 */     GL20C.glVertexAttrib4s(index, v0, v1, v2, v3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4d(@NativeType("GLuint") int index, @NativeType("GLdouble") double v0, @NativeType("GLdouble") double v1, @NativeType("GLdouble") double v2, @NativeType("GLdouble") double v3) {
/*  714 */     GL20C.glVertexAttrib4d(index, v0, v1, v2, v3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nub(@NativeType("GLuint") int index, @NativeType("GLubyte") byte x, @NativeType("GLubyte") byte y, @NativeType("GLubyte") byte z, @NativeType("GLubyte") byte w) {
/*  721 */     GL20C.glVertexAttrib4Nub(index, x, y, z, w);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1fv(int index, long v) {
/*  728 */     GL20C.nglVertexAttrib1fv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  733 */     GL20C.glVertexAttrib1fv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1sv(int index, long v) {
/*  740 */     GL20C.nglVertexAttrib1sv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  745 */     GL20C.glVertexAttrib1sv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1dv(int index, long v) {
/*  752 */     GL20C.nglVertexAttrib1dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  757 */     GL20C.glVertexAttrib1dv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2fv(int index, long v) {
/*  764 */     GL20C.nglVertexAttrib2fv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  769 */     GL20C.glVertexAttrib2fv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2sv(int index, long v) {
/*  776 */     GL20C.nglVertexAttrib2sv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  781 */     GL20C.glVertexAttrib2sv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2dv(int index, long v) {
/*  788 */     GL20C.nglVertexAttrib2dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  793 */     GL20C.glVertexAttrib2dv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3fv(int index, long v) {
/*  800 */     GL20C.nglVertexAttrib3fv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  805 */     GL20C.glVertexAttrib3fv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3sv(int index, long v) {
/*  812 */     GL20C.nglVertexAttrib3sv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  817 */     GL20C.glVertexAttrib3sv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3dv(int index, long v) {
/*  824 */     GL20C.nglVertexAttrib3dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  829 */     GL20C.glVertexAttrib3dv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4fv(int index, long v) {
/*  836 */     GL20C.nglVertexAttrib4fv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  841 */     GL20C.glVertexAttrib4fv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4sv(int index, long v) {
/*  848 */     GL20C.nglVertexAttrib4sv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  853 */     GL20C.glVertexAttrib4sv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4dv(int index, long v) {
/*  860 */     GL20C.nglVertexAttrib4dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  865 */     GL20C.glVertexAttrib4dv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4iv(int index, long v) {
/*  872 */     GL20C.nglVertexAttrib4iv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4iv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  877 */     GL20C.glVertexAttrib4iv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4bv(int index, long v) {
/*  884 */     GL20C.nglVertexAttrib4bv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4bv(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/*  889 */     GL20C.glVertexAttrib4bv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4ubv(int index, long v) {
/*  896 */     GL20C.nglVertexAttrib4ubv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4ubv(@NativeType("GLuint") int index, @NativeType("GLubyte const *") ByteBuffer v) {
/*  901 */     GL20C.glVertexAttrib4ubv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4usv(int index, long v) {
/*  908 */     GL20C.nglVertexAttrib4usv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usv(@NativeType("GLuint") int index, @NativeType("GLushort const *") ShortBuffer v) {
/*  913 */     GL20C.glVertexAttrib4usv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4uiv(int index, long v) {
/*  920 */     GL20C.nglVertexAttrib4uiv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/*  925 */     GL20C.glVertexAttrib4uiv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nbv(int index, long v) {
/*  932 */     GL20C.nglVertexAttrib4Nbv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nbv(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/*  937 */     GL20C.glVertexAttrib4Nbv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nsv(int index, long v) {
/*  944 */     GL20C.nglVertexAttrib4Nsv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nsv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  949 */     GL20C.glVertexAttrib4Nsv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Niv(int index, long v) {
/*  956 */     GL20C.nglVertexAttrib4Niv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Niv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  961 */     GL20C.glVertexAttrib4Niv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nubv(int index, long v) {
/*  968 */     GL20C.nglVertexAttrib4Nubv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nubv(@NativeType("GLuint") int index, @NativeType("GLubyte const *") ByteBuffer v) {
/*  973 */     GL20C.glVertexAttrib4Nubv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nusv(int index, long v) {
/*  980 */     GL20C.nglVertexAttrib4Nusv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nusv(@NativeType("GLuint") int index, @NativeType("GLushort const *") ShortBuffer v) {
/*  985 */     GL20C.glVertexAttrib4Nusv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nuiv(int index, long v) {
/*  992 */     GL20C.nglVertexAttrib4Nuiv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nuiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/*  997 */     GL20C.glVertexAttrib4Nuiv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer) {
/* 1004 */     GL20C.nglVertexAttribPointer(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 1009 */     GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 1014 */     GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 1019 */     GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 1024 */     GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 1029 */     GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnableVertexAttribArray(@NativeType("GLuint") int index) {
/* 1036 */     GL20C.glEnableVertexAttribArray(index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisableVertexAttribArray(@NativeType("GLuint") int index) {
/* 1043 */     GL20C.glDisableVertexAttribArray(index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindAttribLocation(int program, int index, long name) {
/* 1050 */     GL20C.nglBindAttribLocation(program, index, name);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glBindAttribLocation(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLchar const *") ByteBuffer name) {
/* 1055 */     GL20C.glBindAttribLocation(program, index, name);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glBindAttribLocation(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLchar const *") CharSequence name) {
/* 1060 */     GL20C.glBindAttribLocation(program, index, name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetActiveAttrib(int program, int index, int maxLength, long length, long size, long type, long name) {
/* 1067 */     GL20C.nglGetActiveAttrib(program, index, maxLength, length, size, type, name);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetActiveAttrib(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type, @NativeType("GLchar *") ByteBuffer name) {
/* 1072 */     GL20C.glGetActiveAttrib(program, index, length, size, type, name);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveAttrib(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei") int maxLength, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 1078 */     return GL20C.glGetActiveAttrib(program, index, maxLength, size, type);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveAttrib(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 1084 */     return glGetActiveAttrib(program, index, glGetProgrami(program, 35722), size, type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetAttribLocation(int program, long name) {
/* 1091 */     return GL20C.nglGetAttribLocation(program, name);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetAttribLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/* 1097 */     return GL20C.glGetAttribLocation(program, name);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetAttribLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/* 1103 */     return GL20C.glGetAttribLocation(program, name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribiv(int index, int pname, long params) {
/* 1110 */     GL20C.nglGetVertexAttribiv(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribiv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1115 */     GL20C.glGetVertexAttribiv(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexAttribi(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1121 */     return GL20C.glGetVertexAttribi(index, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribfv(int index, int pname, long params) {
/* 1128 */     GL20C.nglGetVertexAttribfv(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1133 */     GL20C.glGetVertexAttribfv(index, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribdv(int index, int pname, long params) {
/* 1140 */     GL20C.nglGetVertexAttribdv(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/* 1145 */     GL20C.glGetVertexAttribdv(index, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribPointerv(int index, int pname, long pointer) {
/* 1152 */     GL20C.nglGetVertexAttribPointerv(index, pname, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribPointerv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer pointer) {
/* 1157 */     GL20C.glGetVertexAttribPointerv(index, pname, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1163 */     return GL20C.glGetVertexAttribPointer(index, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDrawBuffers(int n, long bufs) {
/* 1170 */     GL20C.nglDrawBuffers(n, bufs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") IntBuffer bufs) {
/* 1175 */     GL20C.glDrawBuffers(bufs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") int buf) {
/* 1180 */     GL20C.glDrawBuffers(buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBlendEquationSeparate(@NativeType("GLenum") int modeRGB, @NativeType("GLenum") int modeAlpha) {
/* 1187 */     GL20C.glBlendEquationSeparate(modeRGB, modeAlpha);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilOpSeparate(@NativeType("GLenum") int face, @NativeType("GLenum") int sfail, @NativeType("GLenum") int dpfail, @NativeType("GLenum") int dppass) {
/* 1194 */     GL20C.glStencilOpSeparate(face, sfail, dpfail, dppass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilFuncSeparate(@NativeType("GLenum") int face, @NativeType("GLenum") int func, @NativeType("GLint") int ref, @NativeType("GLuint") int mask) {
/* 1201 */     GL20C.glStencilFuncSeparate(face, func, ref, mask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilMaskSeparate(@NativeType("GLenum") int face, @NativeType("GLuint") int mask) {
/* 1208 */     GL20C.glStencilMaskSeparate(face, mask);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderSource(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") PointerBuffer strings, @NativeType("GLint const *") int[] length) {
/* 1213 */     GL20C.glShaderSource(shader, strings, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform1fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1218 */     GL20C.glUniform1fv(location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform2fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1223 */     GL20C.glUniform2fv(location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform3fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1228 */     GL20C.glUniform3fv(location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform4fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1233 */     GL20C.glUniform4fv(location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform1iv(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1238 */     GL20C.glUniform1iv(location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform2iv(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1243 */     GL20C.glUniform2iv(location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform3iv(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1248 */     GL20C.glUniform3iv(location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform4iv(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1253 */     GL20C.glUniform4iv(location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1258 */     GL20C.glUniformMatrix2fv(location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1263 */     GL20C.glUniformMatrix3fv(location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1268 */     GL20C.glUniformMatrix4fv(location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderiv(@NativeType("GLuint") int shader, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1273 */     GL20C.glGetShaderiv(shader, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramiv(@NativeType("GLuint") int program, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1278 */     GL20C.glGetProgramiv(program, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderInfoLog(@NativeType("GLuint") int shader, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer infoLog) {
/* 1283 */     GL20C.glGetShaderInfoLog(shader, length, infoLog);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramInfoLog(@NativeType("GLuint") int program, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer infoLog) {
/* 1288 */     GL20C.glGetProgramInfoLog(program, length, infoLog);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetAttachedShaders(@NativeType("GLuint") int program, @NativeType("GLsizei *") int[] count, @NativeType("GLuint *") int[] shaders) {
/* 1293 */     GL20C.glGetAttachedShaders(program, count, shaders);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetActiveUniform(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] size, @NativeType("GLenum *") int[] type, @NativeType("GLchar *") ByteBuffer name) {
/* 1298 */     GL20C.glGetActiveUniform(program, index, length, size, type, name);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") float[] params) {
/* 1303 */     GL20C.glGetUniformfv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") int[] params) {
/* 1308 */     GL20C.glGetUniformiv(program, location, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderSource(@NativeType("GLuint") int shader, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer source) {
/* 1313 */     GL20C.glGetShaderSource(shader, length, source);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1318 */     GL20C.glVertexAttrib1fv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1323 */     GL20C.glVertexAttrib1sv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1328 */     GL20C.glVertexAttrib1dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1333 */     GL20C.glVertexAttrib2fv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1338 */     GL20C.glVertexAttrib2sv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1343 */     GL20C.glVertexAttrib2dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1348 */     GL20C.glVertexAttrib3fv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1353 */     GL20C.glVertexAttrib3sv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1358 */     GL20C.glVertexAttrib3dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1363 */     GL20C.glVertexAttrib4fv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1368 */     GL20C.glVertexAttrib4sv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1373 */     GL20C.glVertexAttrib4dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4iv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1378 */     GL20C.glVertexAttrib4iv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usv(@NativeType("GLuint") int index, @NativeType("GLushort const *") short[] v) {
/* 1383 */     GL20C.glVertexAttrib4usv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 1388 */     GL20C.glVertexAttrib4uiv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nsv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1393 */     GL20C.glVertexAttrib4Nsv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Niv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1398 */     GL20C.glVertexAttrib4Niv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nusv(@NativeType("GLuint") int index, @NativeType("GLushort const *") short[] v) {
/* 1403 */     GL20C.glVertexAttrib4Nusv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nuiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 1408 */     GL20C.glVertexAttrib4Nuiv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetActiveAttrib(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] size, @NativeType("GLenum *") int[] type, @NativeType("GLchar *") ByteBuffer name) {
/* 1413 */     GL20C.glGetActiveAttrib(program, index, length, size, type, name);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribiv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1418 */     GL20C.glGetVertexAttribiv(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 1423 */     GL20C.glGetVertexAttribfv(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 1428 */     GL20C.glGetVertexAttribdv(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") int[] bufs) {
/* 1433 */     GL20C.glDrawBuffers(bufs);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL20.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */