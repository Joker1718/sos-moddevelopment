/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL41
/*      */   extends GL40 {
/*      */   public static final int GL_SHADER_COMPILER = 36346;
/*      */   public static final int GL_SHADER_BINARY_FORMATS = 36344;
/*      */   public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345;
/*      */   public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347;
/*      */   
/*      */   static {
/*   18 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_VARYING_VECTORS = 36348;
/*      */   
/*      */   public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349;
/*      */   
/*      */   public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738;
/*      */   
/*      */   public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739;
/*      */   
/*      */   public static final int GL_FIXED = 5132;
/*      */   
/*      */   public static final int GL_LOW_FLOAT = 36336;
/*      */   
/*      */   public static final int GL_MEDIUM_FLOAT = 36337;
/*      */   
/*      */   public static final int GL_HIGH_FLOAT = 36338;
/*      */   
/*      */   public static final int GL_LOW_INT = 36339;
/*      */   
/*      */   public static final int GL_MEDIUM_INT = 36340;
/*      */   
/*      */   public static final int GL_HIGH_INT = 36341;
/*      */   
/*      */   public static final int GL_RGB565 = 36194;
/*      */   
/*      */   public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;
/*      */   
/*      */   public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
/*      */   
/*      */   public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
/*      */   
/*      */   public static final int GL_PROGRAM_BINARY_FORMATS = 34815;
/*      */   
/*      */   public static final int GL_VERTEX_SHADER_BIT = 1;
/*      */   
/*      */   public static final int GL_FRAGMENT_SHADER_BIT = 2;
/*      */   
/*      */   public static final int GL_GEOMETRY_SHADER_BIT = 4;
/*      */   
/*      */   public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
/*      */   public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
/*      */   public static final int GL_ALL_SHADER_BITS = -1;
/*      */   public static final int GL_PROGRAM_SEPARABLE = 33368;
/*      */   public static final int GL_ACTIVE_PROGRAM = 33369;
/*      */   public static final int GL_PROGRAM_PIPELINE_BINDING = 33370;
/*      */   public static final int GL_MAX_VIEWPORTS = 33371;
/*      */   public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;
/*      */   public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
/*      */   public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
/*      */   public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
/*      */   public static final int GL_UNDEFINED_VERTEX = 33376;
/*      */   
/*      */   protected GL41() {
/*   74 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReleaseShaderCompiler() {
/*   81 */     GL41C.glReleaseShaderCompiler();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglShaderBinary(int count, long shaders, int binaryformat, long binary, int length) {
/*   88 */     GL41C.nglShaderBinary(count, shaders, binaryformat, binary, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderBinary(@NativeType("GLuint const *") IntBuffer shaders, @NativeType("GLenum") int binaryformat, @NativeType("void const *") ByteBuffer binary) {
/*   93 */     GL41C.glShaderBinary(shaders, binaryformat, binary);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetShaderPrecisionFormat(int shadertype, int precisiontype, long range, long precision) {
/*  100 */     GL41C.nglGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int shadertype, @NativeType("GLenum") int precisiontype, @NativeType("GLint *") IntBuffer range, @NativeType("GLint *") IntBuffer precision) {
/*  105 */     GL41C.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetShaderPrecisionFormat(@NativeType("GLenum") int shadertype, @NativeType("GLenum") int precisiontype, @NativeType("GLint *") IntBuffer range) {
/*  111 */     return GL41C.glGetShaderPrecisionFormat(shadertype, precisiontype, range);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthRangef(@NativeType("GLfloat") float zNear, @NativeType("GLfloat") float zFar) {
/*  118 */     GL41C.glDepthRangef(zNear, zFar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearDepthf(@NativeType("GLfloat") float depth) {
/*  125 */     GL41C.glClearDepthf(depth);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramBinary(int program, int bufSize, long length, long binaryFormat, long binary) {
/*  132 */     GL41C.nglGetProgramBinary(program, bufSize, length, binaryFormat, binary);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramBinary(@NativeType("GLuint") int program, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLenum *") IntBuffer binaryFormat, @NativeType("void *") ByteBuffer binary) {
/*  137 */     GL41C.glGetProgramBinary(program, length, binaryFormat, binary);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramBinary(int program, int binaryFormat, long binary, int length) {
/*  144 */     GL41C.nglProgramBinary(program, binaryFormat, binary, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramBinary(@NativeType("GLuint") int program, @NativeType("GLenum") int binaryFormat, @NativeType("void const *") ByteBuffer binary) {
/*  149 */     GL41C.glProgramBinary(program, binaryFormat, binary);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramParameteri(@NativeType("GLuint") int program, @NativeType("GLenum") int pname, @NativeType("GLint") int value) {
/*  156 */     GL41C.glProgramParameteri(program, pname, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUseProgramStages(@NativeType("GLuint") int pipeline, @NativeType("GLbitfield") int stages, @NativeType("GLuint") int program) {
/*  163 */     GL41C.glUseProgramStages(pipeline, stages, program);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glActiveShaderProgram(@NativeType("GLuint") int pipeline, @NativeType("GLuint") int program) {
/*  170 */     GL41C.glActiveShaderProgram(pipeline, program);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglCreateShaderProgramv(int type, int count, long strings) {
/*  177 */     return GL41C.nglCreateShaderProgramv(type, count, strings);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int type, @NativeType("GLchar const * const *") PointerBuffer strings) {
/*  183 */     return GL41C.glCreateShaderProgramv(type, strings);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int type, @NativeType("GLchar const * const *") CharSequence... strings) {
/*  189 */     return GL41C.glCreateShaderProgramv(type, strings);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int type, @NativeType("GLchar const * const *") CharSequence string) {
/*  195 */     return GL41C.glCreateShaderProgramv(type, string);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindProgramPipeline(@NativeType("GLuint") int pipeline) {
/*  202 */     GL41C.glBindProgramPipeline(pipeline);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteProgramPipelines(int n, long pipelines) {
/*  209 */     GL41C.nglDeleteProgramPipelines(n, pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") IntBuffer pipelines) {
/*  214 */     GL41C.glDeleteProgramPipelines(pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int pipeline) {
/*  219 */     GL41C.glDeleteProgramPipelines(pipeline);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenProgramPipelines(int n, long pipelines) {
/*  226 */     GL41C.nglGenProgramPipelines(n, pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") IntBuffer pipelines) {
/*  231 */     GL41C.glGenProgramPipelines(pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenProgramPipelines() {
/*  237 */     return GL41C.glGenProgramPipelines();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsProgramPipeline(@NativeType("GLuint") int pipeline) {
/*  245 */     return GL41C.glIsProgramPipeline(pipeline);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramPipelineiv(int pipeline, int pname, long params) {
/*  252 */     GL41C.nglGetProgramPipelineiv(pipeline, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int pipeline, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  257 */     GL41C.glGetProgramPipelineiv(pipeline, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetProgramPipelinei(@NativeType("GLuint") int pipeline, @NativeType("GLenum") int pname) {
/*  263 */     return GL41C.glGetProgramPipelinei(pipeline, pname);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1i(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint") int x) {
/*  270 */     GL41C.glProgramUniform1i(program, location, x);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2i(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint") int x, @NativeType("GLint") int y) {
/*  277 */     GL41C.glProgramUniform2i(program, location, x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3i(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLint") int z) {
/*  284 */     GL41C.glProgramUniform3i(program, location, x, y, z);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4i(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLint") int z, @NativeType("GLint") int w) {
/*  291 */     GL41C.glProgramUniform4i(program, location, x, y, z, w);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1ui(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint") int x) {
/*  298 */     GL41C.glProgramUniform1ui(program, location, x);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2ui(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint") int x, @NativeType("GLuint") int y) {
/*  305 */     GL41C.glProgramUniform2ui(program, location, x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3ui(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint") int x, @NativeType("GLuint") int y, @NativeType("GLuint") int z) {
/*  312 */     GL41C.glProgramUniform3ui(program, location, x, y, z);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4ui(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint") int x, @NativeType("GLuint") int y, @NativeType("GLuint") int z, @NativeType("GLuint") int w) {
/*  319 */     GL41C.glProgramUniform4ui(program, location, x, y, z, w);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1f(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat") float x) {
/*  326 */     GL41C.glProgramUniform1f(program, location, x);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2f(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat") float x, @NativeType("GLfloat") float y) {
/*  333 */     GL41C.glProgramUniform2f(program, location, x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3f(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat") float x, @NativeType("GLfloat") float y, @NativeType("GLfloat") float z) {
/*  340 */     GL41C.glProgramUniform3f(program, location, x, y, z);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4f(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat") float x, @NativeType("GLfloat") float y, @NativeType("GLfloat") float z, @NativeType("GLfloat") float w) {
/*  347 */     GL41C.glProgramUniform4f(program, location, x, y, z, w);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1d(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble") double x) {
/*  354 */     GL41C.glProgramUniform1d(program, location, x);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2d(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y) {
/*  361 */     GL41C.glProgramUniform2d(program, location, x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3d(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z) {
/*  368 */     GL41C.glProgramUniform3d(program, location, x, y, z);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4d(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z, @NativeType("GLdouble") double w) {
/*  375 */     GL41C.glProgramUniform4d(program, location, x, y, z, w);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform1iv(int program, int location, int count, long value) {
/*  382 */     GL41C.nglProgramUniform1iv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  387 */     GL41C.glProgramUniform1iv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform2iv(int program, int location, int count, long value) {
/*  394 */     GL41C.nglProgramUniform2iv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  399 */     GL41C.glProgramUniform2iv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform3iv(int program, int location, int count, long value) {
/*  406 */     GL41C.nglProgramUniform3iv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  411 */     GL41C.glProgramUniform3iv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform4iv(int program, int location, int count, long value) {
/*  418 */     GL41C.nglProgramUniform4iv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  423 */     GL41C.glProgramUniform4iv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform1uiv(int program, int location, int count, long value) {
/*  430 */     GL41C.nglProgramUniform1uiv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  435 */     GL41C.glProgramUniform1uiv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform2uiv(int program, int location, int count, long value) {
/*  442 */     GL41C.nglProgramUniform2uiv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  447 */     GL41C.glProgramUniform2uiv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform3uiv(int program, int location, int count, long value) {
/*  454 */     GL41C.nglProgramUniform3uiv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  459 */     GL41C.glProgramUniform3uiv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform4uiv(int program, int location, int count, long value) {
/*  466 */     GL41C.nglProgramUniform4uiv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  471 */     GL41C.glProgramUniform4uiv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform1fv(int program, int location, int count, long value) {
/*  478 */     GL41C.nglProgramUniform1fv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  483 */     GL41C.glProgramUniform1fv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform2fv(int program, int location, int count, long value) {
/*  490 */     GL41C.nglProgramUniform2fv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  495 */     GL41C.glProgramUniform2fv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform3fv(int program, int location, int count, long value) {
/*  502 */     GL41C.nglProgramUniform3fv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  507 */     GL41C.glProgramUniform3fv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform4fv(int program, int location, int count, long value) {
/*  514 */     GL41C.nglProgramUniform4fv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  519 */     GL41C.glProgramUniform4fv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform1dv(int program, int location, int count, long value) {
/*  526 */     GL41C.nglProgramUniform1dv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  531 */     GL41C.glProgramUniform1dv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform2dv(int program, int location, int count, long value) {
/*  538 */     GL41C.nglProgramUniform2dv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  543 */     GL41C.glProgramUniform2dv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform3dv(int program, int location, int count, long value) {
/*  550 */     GL41C.nglProgramUniform3dv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  555 */     GL41C.glProgramUniform3dv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform4dv(int program, int location, int count, long value) {
/*  562 */     GL41C.nglProgramUniform4dv(program, location, count, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  567 */     GL41C.glProgramUniform4dv(program, location, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2fv(int program, int location, int count, boolean transpose, long value) {
/*  574 */     GL41C.nglProgramUniformMatrix2fv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  579 */     GL41C.glProgramUniformMatrix2fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3fv(int program, int location, int count, boolean transpose, long value) {
/*  586 */     GL41C.nglProgramUniformMatrix3fv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  591 */     GL41C.glProgramUniformMatrix3fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4fv(int program, int location, int count, boolean transpose, long value) {
/*  598 */     GL41C.nglProgramUniformMatrix4fv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  603 */     GL41C.glProgramUniformMatrix4fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2dv(int program, int location, int count, boolean transpose, long value) {
/*  610 */     GL41C.nglProgramUniformMatrix2dv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  615 */     GL41C.glProgramUniformMatrix2dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3dv(int program, int location, int count, boolean transpose, long value) {
/*  622 */     GL41C.nglProgramUniformMatrix3dv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  627 */     GL41C.glProgramUniformMatrix3dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4dv(int program, int location, int count, boolean transpose, long value) {
/*  634 */     GL41C.nglProgramUniformMatrix4dv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  639 */     GL41C.glProgramUniformMatrix4dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2x3fv(int program, int location, int count, boolean transpose, long value) {
/*  646 */     GL41C.nglProgramUniformMatrix2x3fv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  651 */     GL41C.glProgramUniformMatrix2x3fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3x2fv(int program, int location, int count, boolean transpose, long value) {
/*  658 */     GL41C.nglProgramUniformMatrix3x2fv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  663 */     GL41C.glProgramUniformMatrix3x2fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2x4fv(int program, int location, int count, boolean transpose, long value) {
/*  670 */     GL41C.nglProgramUniformMatrix2x4fv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  675 */     GL41C.glProgramUniformMatrix2x4fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4x2fv(int program, int location, int count, boolean transpose, long value) {
/*  682 */     GL41C.nglProgramUniformMatrix4x2fv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  687 */     GL41C.glProgramUniformMatrix4x2fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3x4fv(int program, int location, int count, boolean transpose, long value) {
/*  694 */     GL41C.nglProgramUniformMatrix3x4fv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  699 */     GL41C.glProgramUniformMatrix3x4fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4x3fv(int program, int location, int count, boolean transpose, long value) {
/*  706 */     GL41C.nglProgramUniformMatrix4x3fv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  711 */     GL41C.glProgramUniformMatrix4x3fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2x3dv(int program, int location, int count, boolean transpose, long value) {
/*  718 */     GL41C.nglProgramUniformMatrix2x3dv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  723 */     GL41C.glProgramUniformMatrix2x3dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3x2dv(int program, int location, int count, boolean transpose, long value) {
/*  730 */     GL41C.nglProgramUniformMatrix3x2dv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  735 */     GL41C.glProgramUniformMatrix3x2dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2x4dv(int program, int location, int count, boolean transpose, long value) {
/*  742 */     GL41C.nglProgramUniformMatrix2x4dv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  747 */     GL41C.glProgramUniformMatrix2x4dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4x2dv(int program, int location, int count, boolean transpose, long value) {
/*  754 */     GL41C.nglProgramUniformMatrix4x2dv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  759 */     GL41C.glProgramUniformMatrix4x2dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3x4dv(int program, int location, int count, boolean transpose, long value) {
/*  766 */     GL41C.nglProgramUniformMatrix3x4dv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  771 */     GL41C.glProgramUniformMatrix3x4dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4x3dv(int program, int location, int count, boolean transpose, long value) {
/*  778 */     GL41C.nglProgramUniformMatrix4x3dv(program, location, count, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  783 */     GL41C.glProgramUniformMatrix4x3dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glValidateProgramPipeline(@NativeType("GLuint") int pipeline) {
/*  790 */     GL41C.glValidateProgramPipeline(pipeline);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramPipelineInfoLog(int pipeline, int bufSize, long length, long infoLog) {
/*  797 */     GL41C.nglGetProgramPipelineInfoLog(pipeline, bufSize, length, infoLog);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer infoLog) {
/*  802 */     GL41C.glGetProgramPipelineInfoLog(pipeline, length, infoLog);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline, @NativeType("GLsizei") int bufSize) {
/*  808 */     return GL41C.glGetProgramPipelineInfoLog(pipeline, bufSize);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline) {
/*  814 */     return glGetProgramPipelineInfoLog(pipeline, glGetProgramPipelinei(pipeline, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL1d(@NativeType("GLuint") int index, @NativeType("GLdouble") double x) {
/*  821 */     GL41C.glVertexAttribL1d(index, x);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL2d(@NativeType("GLuint") int index, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y) {
/*  828 */     GL41C.glVertexAttribL2d(index, x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL3d(@NativeType("GLuint") int index, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z) {
/*  835 */     GL41C.glVertexAttribL3d(index, x, y, z);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL4d(@NativeType("GLuint") int index, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z, @NativeType("GLdouble") double w) {
/*  842 */     GL41C.glVertexAttribL4d(index, x, y, z, w);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribL1dv(int index, long v) {
/*  849 */     GL41C.nglVertexAttribL1dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL1dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  854 */     GL41C.glVertexAttribL1dv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribL2dv(int index, long v) {
/*  861 */     GL41C.nglVertexAttribL2dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL2dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  866 */     GL41C.glVertexAttribL2dv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribL3dv(int index, long v) {
/*  873 */     GL41C.nglVertexAttribL3dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL3dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  878 */     GL41C.glVertexAttribL3dv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribL4dv(int index, long v) {
/*  885 */     GL41C.nglVertexAttribL4dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL4dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  890 */     GL41C.glVertexAttribL4dv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribLPointer(int index, int size, int type, int stride, long pointer) {
/*  897 */     GL41C.nglVertexAttribLPointer(index, size, type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribLPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/*  902 */     GL41C.glVertexAttribLPointer(index, size, type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribLPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/*  907 */     GL41C.glVertexAttribLPointer(index, size, type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribLPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLsizei") int stride, @NativeType("void const *") DoubleBuffer pointer) {
/*  912 */     GL41C.glVertexAttribLPointer(index, size, stride, pointer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribLdv(int index, int pname, long params) {
/*  919 */     GL41C.nglGetVertexAttribLdv(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribLdv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/*  924 */     GL41C.glGetVertexAttribLdv(index, pname, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglViewportArrayv(int first, int count, long v) {
/*  931 */     GL41C.nglViewportArrayv(first, count, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glViewportArrayv(@NativeType("GLuint") int first, @NativeType("GLfloat const *") FloatBuffer v) {
/*  936 */     GL41C.glViewportArrayv(first, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glViewportIndexedf(@NativeType("GLuint") int index, @NativeType("GLfloat") float x, @NativeType("GLfloat") float y, @NativeType("GLfloat") float w, @NativeType("GLfloat") float h) {
/*  943 */     GL41C.glViewportIndexedf(index, x, y, w, h);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglViewportIndexedfv(int index, long v) {
/*  950 */     GL41C.nglViewportIndexedfv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glViewportIndexedfv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  955 */     GL41C.glViewportIndexedfv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglScissorArrayv(int first, int count, long v) {
/*  962 */     GL41C.nglScissorArrayv(first, count, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glScissorArrayv(@NativeType("GLuint") int first, @NativeType("GLint const *") IntBuffer v) {
/*  967 */     GL41C.glScissorArrayv(first, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glScissorIndexed(@NativeType("GLuint") int index, @NativeType("GLint") int left, @NativeType("GLint") int bottom, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/*  974 */     GL41C.glScissorIndexed(index, left, bottom, width, height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglScissorIndexedv(int index, long v) {
/*  981 */     GL41C.nglScissorIndexedv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glScissorIndexedv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  986 */     GL41C.glScissorIndexedv(index, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDepthRangeArrayv(int first, int count, long v) {
/*  993 */     GL41C.nglDepthRangeArrayv(first, count, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDepthRangeArrayv(@NativeType("GLuint") int first, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  998 */     GL41C.glDepthRangeArrayv(first, v);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthRangeIndexed(@NativeType("GLuint") int index, @NativeType("GLdouble") double zNear, @NativeType("GLdouble") double zFar) {
/* 1005 */     GL41C.glDepthRangeIndexed(index, zNear, zFar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetFloati_v(int target, int index, long data) {
/* 1012 */     GL41C.nglGetFloati_v(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloati_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer data) {
/* 1017 */     GL41C.glGetFloati_v(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetFloati(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1023 */     return GL41C.glGetFloati(target, index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetDoublei_v(int target, int index, long data) {
/* 1030 */     GL41C.nglGetDoublei_v(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") DoubleBuffer data) {
/* 1035 */     GL41C.glGetDoublei_v(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetDoublei(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 1041 */     return GL41C.glGetDoublei(target, index);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderBinary(@NativeType("GLuint const *") int[] shaders, @NativeType("GLenum") int binaryformat, @NativeType("void const *") ByteBuffer binary) {
/* 1046 */     GL41C.glShaderBinary(shaders, binaryformat, binary);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int shadertype, @NativeType("GLenum") int precisiontype, @NativeType("GLint *") int[] range, @NativeType("GLint *") int[] precision) {
/* 1051 */     GL41C.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramBinary(@NativeType("GLuint") int program, @NativeType("GLsizei *") int[] length, @NativeType("GLenum *") int[] binaryFormat, @NativeType("void *") ByteBuffer binary) {
/* 1056 */     GL41C.glGetProgramBinary(program, length, binaryFormat, binary);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int[] pipelines) {
/* 1061 */     GL41C.glDeleteProgramPipelines(pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") int[] pipelines) {
/* 1066 */     GL41C.glGenProgramPipelines(pipelines);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int pipeline, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1071 */     GL41C.glGetProgramPipelineiv(pipeline, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1076 */     GL41C.glProgramUniform1iv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1081 */     GL41C.glProgramUniform2iv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1086 */     GL41C.glProgramUniform3iv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1091 */     GL41C.glProgramUniform4iv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1096 */     GL41C.glProgramUniform1uiv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1101 */     GL41C.glProgramUniform2uiv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1106 */     GL41C.glProgramUniform3uiv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1111 */     GL41C.glProgramUniform4uiv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1116 */     GL41C.glProgramUniform1fv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1121 */     GL41C.glProgramUniform2fv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1126 */     GL41C.glProgramUniform3fv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1131 */     GL41C.glProgramUniform4fv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 1136 */     GL41C.glProgramUniform1dv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 1141 */     GL41C.glProgramUniform2dv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 1146 */     GL41C.glProgramUniform3dv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 1151 */     GL41C.glProgramUniform4dv(program, location, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1156 */     GL41C.glProgramUniformMatrix2fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1161 */     GL41C.glProgramUniformMatrix3fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1166 */     GL41C.glProgramUniformMatrix4fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1171 */     GL41C.glProgramUniformMatrix2dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1176 */     GL41C.glProgramUniformMatrix3dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1181 */     GL41C.glProgramUniformMatrix4dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1186 */     GL41C.glProgramUniformMatrix2x3fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1191 */     GL41C.glProgramUniformMatrix3x2fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1196 */     GL41C.glProgramUniformMatrix2x4fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1201 */     GL41C.glProgramUniformMatrix4x2fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1206 */     GL41C.glProgramUniformMatrix3x4fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1211 */     GL41C.glProgramUniformMatrix4x3fv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1216 */     GL41C.glProgramUniformMatrix2x3dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1221 */     GL41C.glProgramUniformMatrix3x2dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1226 */     GL41C.glProgramUniformMatrix2x4dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1231 */     GL41C.glProgramUniformMatrix4x2dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1236 */     GL41C.glProgramUniformMatrix3x4dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1241 */     GL41C.glProgramUniformMatrix4x3dv(program, location, transpose, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer infoLog) {
/* 1246 */     GL41C.glGetProgramPipelineInfoLog(pipeline, length, infoLog);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL1dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1251 */     GL41C.glVertexAttribL1dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL2dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1256 */     GL41C.glVertexAttribL2dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL3dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1261 */     GL41C.glVertexAttribL3dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL4dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1266 */     GL41C.glVertexAttribL4dv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribLdv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 1271 */     GL41C.glGetVertexAttribLdv(index, pname, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glViewportArrayv(@NativeType("GLuint") int first, @NativeType("GLfloat const *") float[] v) {
/* 1276 */     GL41C.glViewportArrayv(first, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glViewportIndexedfv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1281 */     GL41C.glViewportIndexedfv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glScissorArrayv(@NativeType("GLuint") int first, @NativeType("GLint const *") int[] v) {
/* 1286 */     GL41C.glScissorArrayv(first, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glScissorIndexedv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1291 */     GL41C.glScissorIndexedv(index, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDepthRangeArrayv(@NativeType("GLuint") int first, @NativeType("GLdouble const *") double[] v) {
/* 1296 */     GL41C.glDepthRangeArrayv(first, v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloati_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] data) {
/* 1301 */     GL41C.glGetFloati_v(target, index, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") double[] data) {
/* 1306 */     GL41C.glGetDoublei_v(target, index, data);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL41.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */