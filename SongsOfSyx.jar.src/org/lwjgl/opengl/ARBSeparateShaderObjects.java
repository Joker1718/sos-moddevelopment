/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBSeparateShaderObjects
/*     */ {
/*     */   public static final int GL_VERTEX_SHADER_BIT = 1;
/*     */   public static final int GL_FRAGMENT_SHADER_BIT = 2;
/*     */   public static final int GL_GEOMETRY_SHADER_BIT = 4;
/*     */   public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
/*     */   
/*     */   public static final int GL_ALL_SHADER_BITS = -1;
/*     */   
/*     */   public static final int GL_PROGRAM_SEPARABLE = 33368;
/*     */   
/*     */   public static final int GL_ACTIVE_PROGRAM = 33369;
/*     */   
/*     */   public static final int GL_PROGRAM_PIPELINE_BINDING = 33370;
/*     */ 
/*     */   
/*     */   protected ARBSeparateShaderObjects() {
/*  35 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUseProgramStages(@NativeType("GLuint") int pipeline, @NativeType("GLbitfield") int stages, @NativeType("GLuint") int program) {
/*  42 */     GL41C.glUseProgramStages(pipeline, stages, program);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glActiveShaderProgram(@NativeType("GLuint") int pipeline, @NativeType("GLuint") int program) {
/*  49 */     GL41C.glActiveShaderProgram(pipeline, program);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglCreateShaderProgramv(int type, int count, long strings) {
/*  56 */     return GL41C.nglCreateShaderProgramv(type, count, strings);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glCreateShaderProgramv(@NativeType("GLenum") int type, @NativeType("GLchar const * const *") PointerBuffer strings) {
/*  62 */     return GL41C.glCreateShaderProgramv(type, strings);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glCreateShaderProgramv(@NativeType("GLenum") int type, @NativeType("GLchar const * const *") CharSequence... strings) {
/*  68 */     return GL41C.glCreateShaderProgramv(type, strings);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glCreateShaderProgramv(@NativeType("GLenum") int type, @NativeType("GLchar const * const *") CharSequence string) {
/*  74 */     return GL41C.glCreateShaderProgramv(type, string);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindProgramPipeline(@NativeType("GLuint") int pipeline) {
/*  81 */     GL41C.glBindProgramPipeline(pipeline);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteProgramPipelines(int n, long pipelines) {
/*  88 */     GL41C.nglDeleteProgramPipelines(n, pipelines);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") IntBuffer pipelines) {
/*  93 */     GL41C.glDeleteProgramPipelines(pipelines);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int pipeline) {
/*  98 */     GL41C.glDeleteProgramPipelines(pipeline);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenProgramPipelines(int n, long pipelines) {
/* 105 */     GL41C.nglGenProgramPipelines(n, pipelines);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenProgramPipelines(@NativeType("GLuint *") IntBuffer pipelines) {
/* 110 */     GL41C.glGenProgramPipelines(pipelines);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenProgramPipelines() {
/* 116 */     return GL41C.glGenProgramPipelines();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsProgramPipeline(@NativeType("GLuint") int pipeline) {
/* 124 */     return GL41C.glIsProgramPipeline(pipeline);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramParameteri(@NativeType("GLuint") int program, @NativeType("GLenum") int pname, @NativeType("GLint") int value) {
/* 131 */     GL41C.glProgramParameteri(program, pname, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetProgramPipelineiv(int pipeline, int pname, long params) {
/* 138 */     GL41C.nglGetProgramPipelineiv(pipeline, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int pipeline, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 143 */     GL41C.glGetProgramPipelineiv(pipeline, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetProgramPipelinei(@NativeType("GLuint") int pipeline, @NativeType("GLenum") int pname) {
/* 149 */     return GL41C.glGetProgramPipelinei(pipeline, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint") int x) {
/* 156 */     GL41C.glProgramUniform1i(program, location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint") int x, @NativeType("GLint") int y) {
/* 163 */     GL41C.glProgramUniform2i(program, location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLint") int z) {
/* 170 */     GL41C.glProgramUniform3i(program, location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLint") int z, @NativeType("GLint") int w) {
/* 177 */     GL41C.glProgramUniform4i(program, location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint") int x) {
/* 184 */     GL41C.glProgramUniform1ui(program, location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint") int x, @NativeType("GLuint") int y) {
/* 191 */     GL41C.glProgramUniform2ui(program, location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint") int x, @NativeType("GLuint") int y, @NativeType("GLuint") int z) {
/* 198 */     GL41C.glProgramUniform3ui(program, location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint") int x, @NativeType("GLuint") int y, @NativeType("GLuint") int z, @NativeType("GLuint") int w) {
/* 205 */     GL41C.glProgramUniform4ui(program, location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1f(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat") float x) {
/* 212 */     GL41C.glProgramUniform1f(program, location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2f(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat") float x, @NativeType("GLfloat") float y) {
/* 219 */     GL41C.glProgramUniform2f(program, location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3f(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat") float x, @NativeType("GLfloat") float y, @NativeType("GLfloat") float z) {
/* 226 */     GL41C.glProgramUniform3f(program, location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4f(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat") float x, @NativeType("GLfloat") float y, @NativeType("GLfloat") float z, @NativeType("GLfloat") float w) {
/* 233 */     GL41C.glProgramUniform4f(program, location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1d(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble") double x) {
/* 240 */     GL41C.glProgramUniform1d(program, location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2d(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y) {
/* 247 */     GL41C.glProgramUniform2d(program, location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3d(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z) {
/* 254 */     GL41C.glProgramUniform3d(program, location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4d(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z, @NativeType("GLdouble") double w) {
/* 261 */     GL41C.glProgramUniform4d(program, location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform1iv(int program, int location, int count, long value) {
/* 268 */     GL41C.nglProgramUniform1iv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 273 */     GL41C.glProgramUniform1iv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform2iv(int program, int location, int count, long value) {
/* 280 */     GL41C.nglProgramUniform2iv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 285 */     GL41C.glProgramUniform2iv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform3iv(int program, int location, int count, long value) {
/* 292 */     GL41C.nglProgramUniform3iv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 297 */     GL41C.glProgramUniform3iv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform4iv(int program, int location, int count, long value) {
/* 304 */     GL41C.nglProgramUniform4iv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 309 */     GL41C.glProgramUniform4iv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform1uiv(int program, int location, int count, long value) {
/* 316 */     GL41C.nglProgramUniform1uiv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 321 */     GL41C.glProgramUniform1uiv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform2uiv(int program, int location, int count, long value) {
/* 328 */     GL41C.nglProgramUniform2uiv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 333 */     GL41C.glProgramUniform2uiv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform3uiv(int program, int location, int count, long value) {
/* 340 */     GL41C.nglProgramUniform3uiv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 345 */     GL41C.glProgramUniform3uiv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform4uiv(int program, int location, int count, long value) {
/* 352 */     GL41C.nglProgramUniform4uiv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/* 357 */     GL41C.glProgramUniform4uiv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform1fv(int program, int location, int count, long value) {
/* 364 */     GL41C.nglProgramUniform1fv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 369 */     GL41C.glProgramUniform1fv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform2fv(int program, int location, int count, long value) {
/* 376 */     GL41C.nglProgramUniform2fv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 381 */     GL41C.glProgramUniform2fv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform3fv(int program, int location, int count, long value) {
/* 388 */     GL41C.nglProgramUniform3fv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 393 */     GL41C.glProgramUniform3fv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform4fv(int program, int location, int count, long value) {
/* 400 */     GL41C.nglProgramUniform4fv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 405 */     GL41C.glProgramUniform4fv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform1dv(int program, int location, int count, long value) {
/* 412 */     GL41C.nglProgramUniform1dv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 417 */     GL41C.glProgramUniform1dv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform2dv(int program, int location, int count, long value) {
/* 424 */     GL41C.nglProgramUniform2dv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 429 */     GL41C.glProgramUniform2dv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform3dv(int program, int location, int count, long value) {
/* 436 */     GL41C.nglProgramUniform3dv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 441 */     GL41C.glProgramUniform3dv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform4dv(int program, int location, int count, long value) {
/* 448 */     GL41C.nglProgramUniform4dv(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 453 */     GL41C.glProgramUniform4dv(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix2fv(int program, int location, int count, boolean transpose, long value) {
/* 460 */     GL41C.nglProgramUniformMatrix2fv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 465 */     GL41C.glProgramUniformMatrix2fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix3fv(int program, int location, int count, boolean transpose, long value) {
/* 472 */     GL41C.nglProgramUniformMatrix3fv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 477 */     GL41C.glProgramUniformMatrix3fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix4fv(int program, int location, int count, boolean transpose, long value) {
/* 484 */     GL41C.nglProgramUniformMatrix4fv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 489 */     GL41C.glProgramUniformMatrix4fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix2dv(int program, int location, int count, boolean transpose, long value) {
/* 496 */     GL41C.nglProgramUniformMatrix2dv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 501 */     GL41C.glProgramUniformMatrix2dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix3dv(int program, int location, int count, boolean transpose, long value) {
/* 508 */     GL41C.nglProgramUniformMatrix3dv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 513 */     GL41C.glProgramUniformMatrix3dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix4dv(int program, int location, int count, boolean transpose, long value) {
/* 520 */     GL41C.nglProgramUniformMatrix4dv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 525 */     GL41C.glProgramUniformMatrix4dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix2x3fv(int program, int location, int count, boolean transpose, long value) {
/* 532 */     GL41C.nglProgramUniformMatrix2x3fv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 537 */     GL41C.glProgramUniformMatrix2x3fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix3x2fv(int program, int location, int count, boolean transpose, long value) {
/* 544 */     GL41C.nglProgramUniformMatrix3x2fv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 549 */     GL41C.glProgramUniformMatrix3x2fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix2x4fv(int program, int location, int count, boolean transpose, long value) {
/* 556 */     GL41C.nglProgramUniformMatrix2x4fv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 561 */     GL41C.glProgramUniformMatrix2x4fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix4x2fv(int program, int location, int count, boolean transpose, long value) {
/* 568 */     GL41C.nglProgramUniformMatrix4x2fv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 573 */     GL41C.glProgramUniformMatrix4x2fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix3x4fv(int program, int location, int count, boolean transpose, long value) {
/* 580 */     GL41C.nglProgramUniformMatrix3x4fv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 585 */     GL41C.glProgramUniformMatrix3x4fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix4x3fv(int program, int location, int count, boolean transpose, long value) {
/* 592 */     GL41C.nglProgramUniformMatrix4x3fv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 597 */     GL41C.glProgramUniformMatrix4x3fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix2x3dv(int program, int location, int count, boolean transpose, long value) {
/* 604 */     GL41C.nglProgramUniformMatrix2x3dv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 609 */     GL41C.glProgramUniformMatrix2x3dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix3x2dv(int program, int location, int count, boolean transpose, long value) {
/* 616 */     GL41C.nglProgramUniformMatrix3x2dv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 621 */     GL41C.glProgramUniformMatrix3x2dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix2x4dv(int program, int location, int count, boolean transpose, long value) {
/* 628 */     GL41C.nglProgramUniformMatrix2x4dv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 633 */     GL41C.glProgramUniformMatrix2x4dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix4x2dv(int program, int location, int count, boolean transpose, long value) {
/* 640 */     GL41C.nglProgramUniformMatrix4x2dv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 645 */     GL41C.glProgramUniformMatrix4x2dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix3x4dv(int program, int location, int count, boolean transpose, long value) {
/* 652 */     GL41C.nglProgramUniformMatrix3x4dv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 657 */     GL41C.glProgramUniformMatrix3x4dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniformMatrix4x3dv(int program, int location, int count, boolean transpose, long value) {
/* 664 */     GL41C.nglProgramUniformMatrix4x3dv(program, location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 669 */     GL41C.glProgramUniformMatrix4x3dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glValidateProgramPipeline(@NativeType("GLuint") int pipeline) {
/* 676 */     GL41C.glValidateProgramPipeline(pipeline);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetProgramPipelineInfoLog(int pipeline, int bufSize, long length, long infoLog) {
/* 683 */     GL41C.nglGetProgramPipelineInfoLog(pipeline, bufSize, length, infoLog);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer infoLog) {
/* 688 */     GL41C.glGetProgramPipelineInfoLog(pipeline, length, infoLog);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline, @NativeType("GLsizei") int bufSize) {
/* 694 */     return GL41C.glGetProgramPipelineInfoLog(pipeline, bufSize);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline) {
/* 700 */     return glGetProgramPipelineInfoLog(pipeline, glGetProgramPipelinei(pipeline, 35716));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int[] pipelines) {
/* 705 */     GL41C.glDeleteProgramPipelines(pipelines);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenProgramPipelines(@NativeType("GLuint *") int[] pipelines) {
/* 710 */     GL41C.glGenProgramPipelines(pipelines);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int pipeline, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 715 */     GL41C.glGetProgramPipelineiv(pipeline, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 720 */     GL41C.glProgramUniform1iv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 725 */     GL41C.glProgramUniform2iv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 730 */     GL41C.glProgramUniform3iv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 735 */     GL41C.glProgramUniform4iv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 740 */     GL41C.glProgramUniform1uiv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 745 */     GL41C.glProgramUniform2uiv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 750 */     GL41C.glProgramUniform3uiv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 755 */     GL41C.glProgramUniform4uiv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 760 */     GL41C.glProgramUniform1fv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 765 */     GL41C.glProgramUniform2fv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 770 */     GL41C.glProgramUniform3fv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 775 */     GL41C.glProgramUniform4fv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 780 */     GL41C.glProgramUniform1dv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 785 */     GL41C.glProgramUniform2dv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 790 */     GL41C.glProgramUniform3dv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 795 */     GL41C.glProgramUniform4dv(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 800 */     GL41C.glProgramUniformMatrix2fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 805 */     GL41C.glProgramUniformMatrix3fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 810 */     GL41C.glProgramUniformMatrix4fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 815 */     GL41C.glProgramUniformMatrix2dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 820 */     GL41C.glProgramUniformMatrix3dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 825 */     GL41C.glProgramUniformMatrix4dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 830 */     GL41C.glProgramUniformMatrix2x3fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 835 */     GL41C.glProgramUniformMatrix3x2fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 840 */     GL41C.glProgramUniformMatrix2x4fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 845 */     GL41C.glProgramUniformMatrix4x2fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 850 */     GL41C.glProgramUniformMatrix3x4fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 855 */     GL41C.glProgramUniformMatrix4x3fv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 860 */     GL41C.glProgramUniformMatrix2x3dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 865 */     GL41C.glProgramUniformMatrix3x2dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 870 */     GL41C.glProgramUniformMatrix2x4dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 875 */     GL41C.glProgramUniformMatrix4x2dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 880 */     GL41C.glProgramUniformMatrix3x4dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 885 */     GL41C.glProgramUniformMatrix4x3dv(program, location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer infoLog) {
/* 890 */     GL41C.glGetProgramPipelineInfoLog(pipeline, length, infoLog);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBSeparateShaderObjects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */