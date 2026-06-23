/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL40 extends GL33 {
/*     */   public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
/*     */   public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;
/*     */   public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943;
/*     */   public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442;
/*     */   
/*     */   static {
/*  16 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443;
/*     */   
/*     */   public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444;
/*     */   
/*     */   public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445;
/*     */   
/*     */   public static final int GL_DOUBLE_VEC2 = 36860;
/*     */   
/*     */   public static final int GL_DOUBLE_VEC3 = 36861;
/*     */   
/*     */   public static final int GL_DOUBLE_VEC4 = 36862;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT2 = 36678;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT3 = 36679;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT4 = 36680;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT2x3 = 36681;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT2x4 = 36682;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT3x2 = 36683;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT3x4 = 36684;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT4x2 = 36685;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT4x3 = 36686;
/*     */   
/*     */   public static final int GL_SAMPLE_SHADING = 35894;
/*     */   
/*     */   public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895;
/*     */   
/*     */   public static final int GL_ACTIVE_SUBROUTINES = 36325;
/*     */   
/*     */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
/*     */   
/*     */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
/*     */   
/*     */   public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
/*     */   
/*     */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
/*     */   
/*     */   public static final int GL_MAX_SUBROUTINES = 36327;
/*     */   
/*     */   public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
/*     */   
/*     */   public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
/*     */   
/*     */   public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
/*     */   
/*     */   public static final int GL_PATCHES = 14;
/*     */   
/*     */   public static final int GL_PATCH_VERTICES = 36466;
/*     */   
/*     */   public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 36467;
/*     */   
/*     */   public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 36468;
/*     */   
/*     */   public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469;
/*     */   
/*     */   public static final int GL_TESS_GEN_MODE = 36470;
/*     */   
/*     */   public static final int GL_TESS_GEN_SPACING = 36471;
/*     */   
/*     */   public static final int GL_TESS_GEN_VERTEX_ORDER = 36472;
/*     */   
/*     */   public static final int GL_TESS_GEN_POINT_MODE = 36473;
/*     */   
/*     */   public static final int GL_ISOLINES = 36474;
/*     */   
/*     */   public static final int GL_FRACTIONAL_ODD = 36475;
/*     */   
/*     */   public static final int GL_FRACTIONAL_EVEN = 36476;
/*     */   
/*     */   public static final int GL_MAX_PATCH_VERTICES = 36477;
/*     */   
/*     */   public static final int GL_MAX_TESS_GEN_LEVEL = 36478;
/*     */   
/*     */   public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479;
/*     */   
/*     */   public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480;
/*     */   
/*     */   public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481;
/*     */   
/*     */   public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482;
/*     */   public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483;
/*     */   public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484;
/*     */   public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485;
/*     */   public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486;
/*     */   public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489;
/*     */   public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490;
/*     */   public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924;
/*     */   public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925;
/*     */   public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382;
/*     */   public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383;
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 34032;
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 34033;
/*     */   public static final int GL_TESS_EVALUATION_SHADER = 36487;
/*     */   public static final int GL_TESS_CONTROL_SHADER = 36488;
/*     */   public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873;
/*     */   public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874;
/*     */   public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 36875;
/*     */   public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876;
/*     */   public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877;
/*     */   public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879;
/*     */   public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET = 36446;
/*     */   public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET = 36447;
/*     */   public static final int GL_TRANSFORM_FEEDBACK = 36386;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
/*     */   public static final int GL_MAX_VERTEX_STREAMS = 36465;
/*     */   
/*     */   protected GL40() {
/* 138 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlendEquationi(@NativeType("GLuint") int buf, @NativeType("GLenum") int mode) {
/* 145 */     GL40C.glBlendEquationi(buf, mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlendEquationSeparatei(@NativeType("GLuint") int buf, @NativeType("GLenum") int modeRGB, @NativeType("GLenum") int modeAlpha) {
/* 152 */     GL40C.glBlendEquationSeparatei(buf, modeRGB, modeAlpha);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlendFunci(@NativeType("GLuint") int buf, @NativeType("GLenum") int sfactor, @NativeType("GLenum") int dfactor) {
/* 159 */     GL40C.glBlendFunci(buf, sfactor, dfactor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlendFuncSeparatei(@NativeType("GLuint") int buf, @NativeType("GLenum") int srcRGB, @NativeType("GLenum") int dstRGB, @NativeType("GLenum") int srcAlpha, @NativeType("GLenum") int dstAlpha) {
/* 166 */     GL40C.glBlendFuncSeparatei(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawArraysIndirect(int mode, long indirect) {
/* 173 */     GL40C.nglDrawArraysIndirect(mode, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect) {
/* 178 */     GL40C.glDrawArraysIndirect(mode, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect) {
/* 183 */     GL40C.glDrawArraysIndirect(mode, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indirect) {
/* 188 */     GL40C.glDrawArraysIndirect(mode, indirect);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawElementsIndirect(int mode, int type, long indirect) {
/* 195 */     GL40C.nglDrawElementsIndirect(mode, type, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect) {
/* 200 */     GL40C.glDrawElementsIndirect(mode, type, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect) {
/* 205 */     GL40C.glDrawElementsIndirect(mode, type, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer indirect) {
/* 210 */     GL40C.glDrawElementsIndirect(mode, type, indirect);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform1d(@NativeType("GLint") int location, @NativeType("GLdouble") double x) {
/* 217 */     GL40C.glUniform1d(location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2d(@NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y) {
/* 224 */     GL40C.glUniform2d(location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3d(@NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z) {
/* 231 */     GL40C.glUniform3d(location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4d(@NativeType("GLint") int location, @NativeType("GLdouble") double x, @NativeType("GLdouble") double y, @NativeType("GLdouble") double z, @NativeType("GLdouble") double w) {
/* 238 */     GL40C.glUniform4d(location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform1dv(int location, int count, long value) {
/* 245 */     GL40C.nglUniform1dv(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 250 */     GL40C.glUniform1dv(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform2dv(int location, int count, long value) {
/* 257 */     GL40C.nglUniform2dv(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 262 */     GL40C.glUniform2dv(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform3dv(int location, int count, long value) {
/* 269 */     GL40C.nglUniform3dv(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 274 */     GL40C.glUniform3dv(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform4dv(int location, int count, long value) {
/* 281 */     GL40C.nglUniform4dv(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 286 */     GL40C.glUniform4dv(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2dv(int location, int count, boolean transpose, long value) {
/* 293 */     GL40C.nglUniformMatrix2dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 298 */     GL40C.glUniformMatrix2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3dv(int location, int count, boolean transpose, long value) {
/* 305 */     GL40C.nglUniformMatrix3dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 310 */     GL40C.glUniformMatrix3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4dv(int location, int count, boolean transpose, long value) {
/* 317 */     GL40C.nglUniformMatrix4dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 322 */     GL40C.glUniformMatrix4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2x3dv(int location, int count, boolean transpose, long value) {
/* 329 */     GL40C.nglUniformMatrix2x3dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 334 */     GL40C.glUniformMatrix2x3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2x4dv(int location, int count, boolean transpose, long value) {
/* 341 */     GL40C.nglUniformMatrix2x4dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 346 */     GL40C.glUniformMatrix2x4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3x2dv(int location, int count, boolean transpose, long value) {
/* 353 */     GL40C.nglUniformMatrix3x2dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 358 */     GL40C.glUniformMatrix3x2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3x4dv(int location, int count, boolean transpose, long value) {
/* 365 */     GL40C.nglUniformMatrix3x4dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 370 */     GL40C.glUniformMatrix3x4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4x2dv(int location, int count, boolean transpose, long value) {
/* 377 */     GL40C.nglUniformMatrix4x2dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 382 */     GL40C.glUniformMatrix4x2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4x3dv(int location, int count, boolean transpose, long value) {
/* 389 */     GL40C.nglUniformMatrix4x3dv(location, count, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 394 */     GL40C.glUniformMatrix4x3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformdv(int program, int location, long params) {
/* 401 */     GL40C.nglGetUniformdv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") DoubleBuffer params) {
/* 406 */     GL40C.glGetUniformdv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static double glGetUniformd(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 412 */     return GL40C.glGetUniformd(program, location);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMinSampleShading(@NativeType("GLfloat") float value) {
/* 419 */     GL40C.glMinSampleShading(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetSubroutineUniformLocation(int program, int shadertype, long name) {
/* 426 */     return GL40C.nglGetSubroutineUniformLocation(program, shadertype, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") ByteBuffer name) {
/* 432 */     return GL40C.glGetSubroutineUniformLocation(program, shadertype, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") CharSequence name) {
/* 438 */     return GL40C.glGetSubroutineUniformLocation(program, shadertype, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetSubroutineIndex(int program, int shadertype, long name) {
/* 445 */     return GL40C.nglGetSubroutineIndex(program, shadertype, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetSubroutineIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") ByteBuffer name) {
/* 451 */     return GL40C.glGetSubroutineIndex(program, shadertype, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetSubroutineIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") CharSequence name) {
/* 457 */     return GL40C.glGetSubroutineIndex(program, shadertype, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, long values) {
/* 464 */     GL40C.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer values) {
/* 469 */     GL40C.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetActiveSubroutineUniformi(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 475 */     return GL40C.glGetActiveSubroutineUniformi(program, shadertype, index, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufsize, long length, long name) {
/* 482 */     GL40C.nglGetActiveSubroutineUniformName(program, shadertype, index, bufsize, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer name) {
/* 487 */     GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei") int bufsize) {
/* 493 */     return GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, bufsize);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index) {
/* 499 */     return glGetActiveSubroutineUniformName(program, shadertype, index, glGetActiveSubroutineUniformi(program, shadertype, index, 35385));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveSubroutineName(int program, int shadertype, int index, int bufsize, long length, long name) {
/* 506 */     GL40C.nglGetActiveSubroutineName(program, shadertype, index, bufsize, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer name) {
/* 511 */     GL40C.glGetActiveSubroutineName(program, shadertype, index, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei") int bufsize) {
/* 517 */     return GL40C.glGetActiveSubroutineName(program, shadertype, index, bufsize);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index) {
/* 523 */     return glGetActiveSubroutineName(program, shadertype, index, glGetProgramStagei(program, shadertype, 36424));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformSubroutinesuiv(int shadertype, int count, long indices) {
/* 530 */     GL40C.nglUniformSubroutinesuiv(shadertype, count, indices);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int shadertype, @NativeType("GLuint const *") IntBuffer indices) {
/* 535 */     GL40C.glUniformSubroutinesuiv(shadertype, indices);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesui(@NativeType("GLenum") int shadertype, @NativeType("GLuint const *") int index) {
/* 540 */     GL40C.glUniformSubroutinesui(shadertype, index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformSubroutineuiv(int shadertype, int location, long params) {
/* 547 */     GL40C.nglGetUniformSubroutineuiv(shadertype, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int shadertype, @NativeType("GLint") int location, @NativeType("GLuint *") IntBuffer params) {
/* 552 */     GL40C.glGetUniformSubroutineuiv(shadertype, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformSubroutineui(@NativeType("GLenum") int shadertype, @NativeType("GLint") int location) {
/* 558 */     return GL40C.glGetUniformSubroutineui(shadertype, location);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetProgramStageiv(int program, int shadertype, int pname, long values) {
/* 565 */     GL40C.nglGetProgramStageiv(program, shadertype, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramStageiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer values) {
/* 570 */     GL40C.glGetProgramStageiv(program, shadertype, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetProgramStagei(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLenum") int pname) {
/* 576 */     return GL40C.glGetProgramStagei(program, shadertype, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPatchParameteri(@NativeType("GLenum") int pname, @NativeType("GLint") int value) {
/* 583 */     GL40C.glPatchParameteri(pname, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglPatchParameterfv(int pname, long values) {
/* 590 */     GL40C.nglPatchParameterfv(pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPatchParameterfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer values) {
/* 595 */     GL40C.glPatchParameterfv(pname, values);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindTransformFeedback(@NativeType("GLenum") int target, @NativeType("GLuint") int id) {
/* 602 */     GL40C.glBindTransformFeedback(target, id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteTransformFeedbacks(int n, long ids) {
/* 609 */     GL40C.nglDeleteTransformFeedbacks(n, ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") IntBuffer ids) {
/* 614 */     GL40C.glDeleteTransformFeedbacks(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int id) {
/* 619 */     GL40C.glDeleteTransformFeedbacks(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenTransformFeedbacks(int n, long ids) {
/* 626 */     GL40C.nglGenTransformFeedbacks(n, ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") IntBuffer ids) {
/* 631 */     GL40C.glGenTransformFeedbacks(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenTransformFeedbacks() {
/* 637 */     return GL40C.glGenTransformFeedbacks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsTransformFeedback(@NativeType("GLuint") int id) {
/* 645 */     return GL40C.glIsTransformFeedback(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPauseTransformFeedback() {
/* 652 */     GL40C.glPauseTransformFeedback();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glResumeTransformFeedback() {
/* 659 */     GL40C.glResumeTransformFeedback();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawTransformFeedback(@NativeType("GLenum") int mode, @NativeType("GLuint") int id) {
/* 666 */     GL40C.glDrawTransformFeedback(mode, id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawTransformFeedbackStream(@NativeType("GLenum") int mode, @NativeType("GLuint") int id, @NativeType("GLuint") int stream) {
/* 673 */     GL40C.glDrawTransformFeedbackStream(mode, id, stream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBeginQueryIndexed(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLuint") int id) {
/* 680 */     GL40C.glBeginQueryIndexed(target, index, id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glEndQueryIndexed(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 687 */     GL40C.glEndQueryIndexed(target, index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetQueryIndexediv(int target, int index, int pname, long params) {
/* 694 */     GL40C.nglGetQueryIndexediv(target, index, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryIndexediv(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 699 */     GL40C.glGetQueryIndexediv(target, index, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryIndexedi(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 705 */     return GL40C.glGetQueryIndexedi(target, index, pname);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") int[] indirect) {
/* 710 */     GL40C.glDrawArraysIndirect(mode, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") int[] indirect) {
/* 715 */     GL40C.glDrawElementsIndirect(mode, type, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 720 */     GL40C.glUniform1dv(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 725 */     GL40C.glUniform2dv(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 730 */     GL40C.glUniform3dv(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 735 */     GL40C.glUniform4dv(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 740 */     GL40C.glUniformMatrix2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 745 */     GL40C.glUniformMatrix3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 750 */     GL40C.glUniformMatrix4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 755 */     GL40C.glUniformMatrix2x3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 760 */     GL40C.glUniformMatrix2x4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 765 */     GL40C.glUniformMatrix3x2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 770 */     GL40C.glUniformMatrix3x4dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 775 */     GL40C.glUniformMatrix4x2dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 780 */     GL40C.glUniformMatrix4x3dv(location, transpose, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") double[] params) {
/* 785 */     GL40C.glGetUniformdv(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] values) {
/* 790 */     GL40C.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer name) {
/* 795 */     GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer name) {
/* 800 */     GL40C.glGetActiveSubroutineName(program, shadertype, index, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int shadertype, @NativeType("GLuint const *") int[] indices) {
/* 805 */     GL40C.glUniformSubroutinesuiv(shadertype, indices);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int shadertype, @NativeType("GLint") int location, @NativeType("GLuint *") int[] params) {
/* 810 */     GL40C.glGetUniformSubroutineuiv(shadertype, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramStageiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] values) {
/* 815 */     GL40C.glGetProgramStageiv(program, shadertype, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPatchParameterfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] values) {
/* 820 */     GL40C.glPatchParameterfv(pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int[] ids) {
/* 825 */     GL40C.glDeleteTransformFeedbacks(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") int[] ids) {
/* 830 */     GL40C.glGenTransformFeedbacks(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryIndexediv(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 835 */     GL40C.glGetQueryIndexediv(target, index, pname, params);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL40.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */