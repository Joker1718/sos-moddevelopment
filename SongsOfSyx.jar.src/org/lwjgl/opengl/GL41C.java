/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL41C extends GL40C {
/*      */   public static final int GL_SHADER_COMPILER = 36346;
/*      */   public static final int GL_SHADER_BINARY_FORMATS = 36344;
/*      */   public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345;
/*      */   public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347;
/*      */   
/*      */   static {
/*   23 */     GL.initialize();
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
/*      */   protected GL41C() {
/*   79 */     throw new UnsupportedOperationException();
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
/*      */   public static void glShaderBinary(@NativeType("GLuint const *") IntBuffer shaders, @NativeType("GLenum") int binaryformat, @NativeType("void const *") ByteBuffer binary) {
/*   94 */     nglShaderBinary(shaders.remaining(), MemoryUtil.memAddress(shaders), binaryformat, MemoryUtil.memAddress(binary), binary.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int shadertype, @NativeType("GLenum") int precisiontype, @NativeType("GLint *") IntBuffer range, @NativeType("GLint *") IntBuffer precision) {
/*  104 */     if (Checks.CHECKS) {
/*  105 */       Checks.check(range, 2);
/*  106 */       Checks.check(precision, 1);
/*      */     } 
/*  108 */     nglGetShaderPrecisionFormat(shadertype, precisiontype, MemoryUtil.memAddress(range), MemoryUtil.memAddress(precision));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetShaderPrecisionFormat(@NativeType("GLenum") int shadertype, @NativeType("GLenum") int precisiontype, @NativeType("GLint *") IntBuffer range) {
/*  114 */     if (Checks.CHECKS) {
/*  115 */       Checks.check(range, 2);
/*      */     }
/*  117 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  119 */       IntBuffer precision = stack.callocInt(1);
/*  120 */       nglGetShaderPrecisionFormat(shadertype, precisiontype, MemoryUtil.memAddress(range), MemoryUtil.memAddress(precision));
/*  121 */       return precision.get(0);
/*      */     } finally {
/*  123 */       stack.setPointer(stackPointer);
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
/*      */   public static void glGetProgramBinary(@NativeType("GLuint") int program, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLenum *") IntBuffer binaryFormat, @NativeType("void *") ByteBuffer binary) {
/*  144 */     if (Checks.CHECKS) {
/*  145 */       Checks.checkSafe(length, 1);
/*  146 */       Checks.check(binaryFormat, 1);
/*      */     } 
/*  148 */     nglGetProgramBinary(program, binary.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(binaryFormat), MemoryUtil.memAddress(binary));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramBinary(@NativeType("GLuint") int program, @NativeType("GLenum") int binaryFormat, @NativeType("void const *") ByteBuffer binary) {
/*  158 */     nglProgramBinary(program, binaryFormat, MemoryUtil.memAddress(binary), binary.remaining());
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
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int type, @NativeType("GLchar const * const *") PointerBuffer strings) {
/*  184 */     return nglCreateShaderProgramv(type, strings.remaining(), MemoryUtil.memAddress((CustomBuffer)strings));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int type, @NativeType("GLchar const * const *") CharSequence... strings) {
/*  190 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  192 */       long stringsAddress = APIUtil.apiArray(stack, MemoryUtil::memUTF8, strings);
/*  193 */       int __result = nglCreateShaderProgramv(type, strings.length, stringsAddress);
/*  194 */       APIUtil.apiArrayFree(stringsAddress, strings.length);
/*  195 */       return __result;
/*      */     } finally {
/*  197 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int type, @NativeType("GLchar const * const *") CharSequence string) {
/*  204 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  206 */       long stringsAddress = APIUtil.apiArray(stack, MemoryUtil::memUTF8, new CharSequence[] { string });
/*  207 */       int __result = nglCreateShaderProgramv(type, 1, stringsAddress);
/*  208 */       APIUtil.apiArrayFree(stringsAddress, 1);
/*  209 */       return __result;
/*      */     } finally {
/*  211 */       stack.setPointer(stackPointer);
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
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") IntBuffer pipelines) {
/*  227 */     nglDeleteProgramPipelines(pipelines.remaining(), MemoryUtil.memAddress(pipelines));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int pipeline) {
/*  232 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  234 */       IntBuffer pipelines = stack.ints(pipeline);
/*  235 */       nglDeleteProgramPipelines(1, MemoryUtil.memAddress(pipelines));
/*      */     } finally {
/*  237 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") IntBuffer pipelines) {
/*  248 */     nglGenProgramPipelines(pipelines.remaining(), MemoryUtil.memAddress(pipelines));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenProgramPipelines() {
/*  254 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  256 */       IntBuffer pipelines = stack.callocInt(1);
/*  257 */       nglGenProgramPipelines(1, MemoryUtil.memAddress(pipelines));
/*  258 */       return pipelines.get(0);
/*      */     } finally {
/*  260 */       stack.setPointer(stackPointer);
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
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int pipeline, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  277 */     if (Checks.CHECKS) {
/*  278 */       Checks.check(params, 1);
/*      */     }
/*  280 */     nglGetProgramPipelineiv(pipeline, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetProgramPipelinei(@NativeType("GLuint") int pipeline, @NativeType("GLenum") int pname) {
/*  286 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  288 */       IntBuffer params = stack.callocInt(1);
/*  289 */       nglGetProgramPipelineiv(pipeline, pname, MemoryUtil.memAddress(params));
/*  290 */       return params.get(0);
/*      */     } finally {
/*  292 */       stack.setPointer(stackPointer);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  383 */     nglProgramUniform1iv(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  393 */     nglProgramUniform2iv(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  403 */     nglProgramUniform3iv(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  413 */     nglProgramUniform4iv(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  423 */     nglProgramUniform1uiv(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  433 */     nglProgramUniform2uiv(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  443 */     nglProgramUniform3uiv(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") IntBuffer value) {
/*  453 */     nglProgramUniform4uiv(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  463 */     nglProgramUniform1fv(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  473 */     nglProgramUniform2fv(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  483 */     nglProgramUniform3fv(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  493 */     nglProgramUniform4fv(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  503 */     nglProgramUniform1dv(program, location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  513 */     nglProgramUniform2dv(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  523 */     nglProgramUniform3dv(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  533 */     nglProgramUniform4dv(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  543 */     nglProgramUniformMatrix2fv(program, location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  553 */     nglProgramUniformMatrix3fv(program, location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  563 */     nglProgramUniformMatrix4fv(program, location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  573 */     nglProgramUniformMatrix2dv(program, location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  583 */     nglProgramUniformMatrix3dv(program, location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  593 */     nglProgramUniformMatrix4dv(program, location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  603 */     nglProgramUniformMatrix2x3fv(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  613 */     nglProgramUniformMatrix3x2fv(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  623 */     nglProgramUniformMatrix2x4fv(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  633 */     nglProgramUniformMatrix4x2fv(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  643 */     nglProgramUniformMatrix3x4fv(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  653 */     nglProgramUniformMatrix4x3fv(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  663 */     nglProgramUniformMatrix2x3dv(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  673 */     nglProgramUniformMatrix3x2dv(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  683 */     nglProgramUniformMatrix2x4dv(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  693 */     nglProgramUniformMatrix4x2dv(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  703 */     nglProgramUniformMatrix3x4dv(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/*  713 */     nglProgramUniformMatrix4x3dv(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
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
/*      */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer infoLog) {
/*  728 */     if (Checks.CHECKS) {
/*  729 */       Checks.checkSafe(length, 1);
/*      */     }
/*  731 */     nglGetProgramPipelineInfoLog(pipeline, infoLog.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(infoLog));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline, @NativeType("GLsizei") int bufSize) {
/*  737 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  738 */     ByteBuffer infoLog = MemoryUtil.memAlloc(bufSize);
/*      */     try {
/*  740 */       IntBuffer length = stack.ints(0);
/*  741 */       nglGetProgramPipelineInfoLog(pipeline, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(infoLog));
/*  742 */       return MemoryUtil.memUTF8(infoLog, length.get(0));
/*      */     } finally {
/*  744 */       MemoryUtil.memFree(infoLog);
/*  745 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline) {
/*  752 */     return glGetProgramPipelineInfoLog(pipeline, glGetProgramPipelinei(pipeline, 35716));
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
/*      */   public static void glVertexAttribL1dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  782 */     if (Checks.CHECKS) {
/*  783 */       Checks.check(v, 1);
/*      */     }
/*  785 */     nglVertexAttribL1dv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL2dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  795 */     if (Checks.CHECKS) {
/*  796 */       Checks.check(v, 2);
/*      */     }
/*  798 */     nglVertexAttribL2dv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL3dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  808 */     if (Checks.CHECKS) {
/*  809 */       Checks.check(v, 3);
/*      */     }
/*  811 */     nglVertexAttribL3dv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL4dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  821 */     if (Checks.CHECKS) {
/*  822 */       Checks.check(v, 4);
/*      */     }
/*  824 */     nglVertexAttribL4dv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribLPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/*  834 */     nglVertexAttribLPointer(index, size, type, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribLPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/*  839 */     nglVertexAttribLPointer(index, size, type, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribLPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLsizei") int stride, @NativeType("void const *") DoubleBuffer pointer) {
/*  844 */     nglVertexAttribLPointer(index, size, 5130, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribLdv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/*  854 */     if (Checks.CHECKS) {
/*  855 */       Checks.check(params, 1);
/*      */     }
/*  857 */     nglGetVertexAttribLdv(index, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glViewportArrayv(@NativeType("GLuint") int first, @NativeType("GLfloat const *") FloatBuffer v) {
/*  867 */     nglViewportArrayv(first, v.remaining() >> 2, MemoryUtil.memAddress(v));
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
/*      */   public static void glViewportIndexedfv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  882 */     if (Checks.CHECKS) {
/*  883 */       Checks.check(v, 4);
/*      */     }
/*  885 */     nglViewportIndexedfv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glScissorArrayv(@NativeType("GLuint") int first, @NativeType("GLint const *") IntBuffer v) {
/*  895 */     nglScissorArrayv(first, v.remaining() >> 2, MemoryUtil.memAddress(v));
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
/*      */   public static void glScissorIndexedv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  910 */     if (Checks.CHECKS) {
/*  911 */       Checks.check(v, 4);
/*      */     }
/*  913 */     nglScissorIndexedv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthRangeArrayv(@NativeType("GLuint") int first, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  923 */     nglDepthRangeArrayv(first, v.remaining() >> 1, MemoryUtil.memAddress(v));
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
/*      */   public static void glGetFloati_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer data) {
/*  938 */     if (Checks.CHECKS) {
/*  939 */       Checks.check(data, 1);
/*      */     }
/*  941 */     nglGetFloati_v(target, index, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetFloati(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/*  947 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  949 */       FloatBuffer data = stack.callocFloat(1);
/*  950 */       nglGetFloati_v(target, index, MemoryUtil.memAddress(data));
/*  951 */       return data.get(0);
/*      */     } finally {
/*  953 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") DoubleBuffer data) {
/*  964 */     if (Checks.CHECKS) {
/*  965 */       Checks.check(data, 1);
/*      */     }
/*  967 */     nglGetDoublei_v(target, index, MemoryUtil.memAddress(data));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetDoublei(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/*  973 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  975 */       DoubleBuffer data = stack.callocDouble(1);
/*  976 */       nglGetDoublei_v(target, index, MemoryUtil.memAddress(data));
/*  977 */       return data.get(0);
/*      */     } finally {
/*  979 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderBinary(@NativeType("GLuint const *") int[] shaders, @NativeType("GLenum") int binaryformat, @NativeType("void const *") ByteBuffer binary) {
/*  985 */     long __functionAddress = (GL.getICD()).glShaderBinary;
/*  986 */     if (Checks.CHECKS) {
/*  987 */       Checks.check(__functionAddress);
/*      */     }
/*  989 */     JNI.callPPV(shaders.length, shaders, binaryformat, MemoryUtil.memAddress(binary), binary.remaining(), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int shadertype, @NativeType("GLenum") int precisiontype, @NativeType("GLint *") int[] range, @NativeType("GLint *") int[] precision) {
/*  994 */     long __functionAddress = (GL.getICD()).glGetShaderPrecisionFormat;
/*  995 */     if (Checks.CHECKS) {
/*  996 */       Checks.check(__functionAddress);
/*  997 */       Checks.check(range, 2);
/*  998 */       Checks.check(precision, 1);
/*      */     } 
/* 1000 */     JNI.callPPV(shadertype, precisiontype, range, precision, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramBinary(@NativeType("GLuint") int program, @NativeType("GLsizei *") int[] length, @NativeType("GLenum *") int[] binaryFormat, @NativeType("void *") ByteBuffer binary) {
/* 1005 */     long __functionAddress = (GL.getICD()).glGetProgramBinary;
/* 1006 */     if (Checks.CHECKS) {
/* 1007 */       Checks.check(__functionAddress);
/* 1008 */       Checks.checkSafe(length, 1);
/* 1009 */       Checks.check(binaryFormat, 1);
/*      */     } 
/* 1011 */     JNI.callPPPV(program, binary.remaining(), length, binaryFormat, MemoryUtil.memAddress(binary), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int[] pipelines) {
/* 1016 */     long __functionAddress = (GL.getICD()).glDeleteProgramPipelines;
/* 1017 */     if (Checks.CHECKS) {
/* 1018 */       Checks.check(__functionAddress);
/*      */     }
/* 1020 */     JNI.callPV(pipelines.length, pipelines, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") int[] pipelines) {
/* 1025 */     long __functionAddress = (GL.getICD()).glGenProgramPipelines;
/* 1026 */     if (Checks.CHECKS) {
/* 1027 */       Checks.check(__functionAddress);
/*      */     }
/* 1029 */     JNI.callPV(pipelines.length, pipelines, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int pipeline, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1034 */     long __functionAddress = (GL.getICD()).glGetProgramPipelineiv;
/* 1035 */     if (Checks.CHECKS) {
/* 1036 */       Checks.check(__functionAddress);
/* 1037 */       Checks.check(params, 1);
/*      */     } 
/* 1039 */     JNI.callPV(pipeline, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1044 */     long __functionAddress = (GL.getICD()).glProgramUniform1iv;
/* 1045 */     if (Checks.CHECKS) {
/* 1046 */       Checks.check(__functionAddress);
/*      */     }
/* 1048 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1053 */     long __functionAddress = (GL.getICD()).glProgramUniform2iv;
/* 1054 */     if (Checks.CHECKS) {
/* 1055 */       Checks.check(__functionAddress);
/*      */     }
/* 1057 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1062 */     long __functionAddress = (GL.getICD()).glProgramUniform3iv;
/* 1063 */     if (Checks.CHECKS) {
/* 1064 */       Checks.check(__functionAddress);
/*      */     }
/* 1066 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4iv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1071 */     long __functionAddress = (GL.getICD()).glProgramUniform4iv;
/* 1072 */     if (Checks.CHECKS) {
/* 1073 */       Checks.check(__functionAddress);
/*      */     }
/* 1075 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1080 */     long __functionAddress = (GL.getICD()).glProgramUniform1uiv;
/* 1081 */     if (Checks.CHECKS) {
/* 1082 */       Checks.check(__functionAddress);
/*      */     }
/* 1084 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1089 */     long __functionAddress = (GL.getICD()).glProgramUniform2uiv;
/* 1090 */     if (Checks.CHECKS) {
/* 1091 */       Checks.check(__functionAddress);
/*      */     }
/* 1093 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1098 */     long __functionAddress = (GL.getICD()).glProgramUniform3uiv;
/* 1099 */     if (Checks.CHECKS) {
/* 1100 */       Checks.check(__functionAddress);
/*      */     }
/* 1102 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint const *") int[] value) {
/* 1107 */     long __functionAddress = (GL.getICD()).glProgramUniform4uiv;
/* 1108 */     if (Checks.CHECKS) {
/* 1109 */       Checks.check(__functionAddress);
/*      */     }
/* 1111 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1116 */     long __functionAddress = (GL.getICD()).glProgramUniform1fv;
/* 1117 */     if (Checks.CHECKS) {
/* 1118 */       Checks.check(__functionAddress);
/*      */     }
/* 1120 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1125 */     long __functionAddress = (GL.getICD()).glProgramUniform2fv;
/* 1126 */     if (Checks.CHECKS) {
/* 1127 */       Checks.check(__functionAddress);
/*      */     }
/* 1129 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1134 */     long __functionAddress = (GL.getICD()).glProgramUniform3fv;
/* 1135 */     if (Checks.CHECKS) {
/* 1136 */       Checks.check(__functionAddress);
/*      */     }
/* 1138 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1143 */     long __functionAddress = (GL.getICD()).glProgramUniform4fv;
/* 1144 */     if (Checks.CHECKS) {
/* 1145 */       Checks.check(__functionAddress);
/*      */     }
/* 1147 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 1152 */     long __functionAddress = (GL.getICD()).glProgramUniform1dv;
/* 1153 */     if (Checks.CHECKS) {
/* 1154 */       Checks.check(__functionAddress);
/*      */     }
/* 1156 */     JNI.callPV(program, location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 1161 */     long __functionAddress = (GL.getICD()).glProgramUniform2dv;
/* 1162 */     if (Checks.CHECKS) {
/* 1163 */       Checks.check(__functionAddress);
/*      */     }
/* 1165 */     JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 1170 */     long __functionAddress = (GL.getICD()).glProgramUniform3dv;
/* 1171 */     if (Checks.CHECKS) {
/* 1172 */       Checks.check(__functionAddress);
/*      */     }
/* 1174 */     JNI.callPV(program, location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 1179 */     long __functionAddress = (GL.getICD()).glProgramUniform4dv;
/* 1180 */     if (Checks.CHECKS) {
/* 1181 */       Checks.check(__functionAddress);
/*      */     }
/* 1183 */     JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1188 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2fv;
/* 1189 */     if (Checks.CHECKS) {
/* 1190 */       Checks.check(__functionAddress);
/*      */     }
/* 1192 */     JNI.callPV(program, location, value.length >> 2, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1197 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3fv;
/* 1198 */     if (Checks.CHECKS) {
/* 1199 */       Checks.check(__functionAddress);
/*      */     }
/* 1201 */     JNI.callPV(program, location, value.length / 9, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1206 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4fv;
/* 1207 */     if (Checks.CHECKS) {
/* 1208 */       Checks.check(__functionAddress);
/*      */     }
/* 1210 */     JNI.callPV(program, location, value.length >> 4, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1215 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2dv;
/* 1216 */     if (Checks.CHECKS) {
/* 1217 */       Checks.check(__functionAddress);
/*      */     }
/* 1219 */     JNI.callPV(program, location, value.length >> 2, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1224 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3dv;
/* 1225 */     if (Checks.CHECKS) {
/* 1226 */       Checks.check(__functionAddress);
/*      */     }
/* 1228 */     JNI.callPV(program, location, value.length / 9, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1233 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4dv;
/* 1234 */     if (Checks.CHECKS) {
/* 1235 */       Checks.check(__functionAddress);
/*      */     }
/* 1237 */     JNI.callPV(program, location, value.length >> 4, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1242 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2x3fv;
/* 1243 */     if (Checks.CHECKS) {
/* 1244 */       Checks.check(__functionAddress);
/*      */     }
/* 1246 */     JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1251 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3x2fv;
/* 1252 */     if (Checks.CHECKS) {
/* 1253 */       Checks.check(__functionAddress);
/*      */     }
/* 1255 */     JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1260 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2x4fv;
/* 1261 */     if (Checks.CHECKS) {
/* 1262 */       Checks.check(__functionAddress);
/*      */     }
/* 1264 */     JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1269 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4x2fv;
/* 1270 */     if (Checks.CHECKS) {
/* 1271 */       Checks.check(__functionAddress);
/*      */     }
/* 1273 */     JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1278 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3x4fv;
/* 1279 */     if (Checks.CHECKS) {
/* 1280 */       Checks.check(__functionAddress);
/*      */     }
/* 1282 */     JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1287 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4x3fv;
/* 1288 */     if (Checks.CHECKS) {
/* 1289 */       Checks.check(__functionAddress);
/*      */     }
/* 1291 */     JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1296 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2x3dv;
/* 1297 */     if (Checks.CHECKS) {
/* 1298 */       Checks.check(__functionAddress);
/*      */     }
/* 1300 */     JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1305 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3x2dv;
/* 1306 */     if (Checks.CHECKS) {
/* 1307 */       Checks.check(__functionAddress);
/*      */     }
/* 1309 */     JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1314 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix2x4dv;
/* 1315 */     if (Checks.CHECKS) {
/* 1316 */       Checks.check(__functionAddress);
/*      */     }
/* 1318 */     JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1323 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4x2dv;
/* 1324 */     if (Checks.CHECKS) {
/* 1325 */       Checks.check(__functionAddress);
/*      */     }
/* 1327 */     JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1332 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix3x4dv;
/* 1333 */     if (Checks.CHECKS) {
/* 1334 */       Checks.check(__functionAddress);
/*      */     }
/* 1336 */     JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 1341 */     long __functionAddress = (GL.getICD()).glProgramUniformMatrix4x3dv;
/* 1342 */     if (Checks.CHECKS) {
/* 1343 */       Checks.check(__functionAddress);
/*      */     }
/* 1345 */     JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int pipeline, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer infoLog) {
/* 1350 */     long __functionAddress = (GL.getICD()).glGetProgramPipelineInfoLog;
/* 1351 */     if (Checks.CHECKS) {
/* 1352 */       Checks.check(__functionAddress);
/* 1353 */       Checks.checkSafe(length, 1);
/*      */     } 
/* 1355 */     JNI.callPPV(pipeline, infoLog.remaining(), length, MemoryUtil.memAddress(infoLog), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL1dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1360 */     long __functionAddress = (GL.getICD()).glVertexAttribL1dv;
/* 1361 */     if (Checks.CHECKS) {
/* 1362 */       Checks.check(__functionAddress);
/* 1363 */       Checks.check(v, 1);
/*      */     } 
/* 1365 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL2dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1370 */     long __functionAddress = (GL.getICD()).glVertexAttribL2dv;
/* 1371 */     if (Checks.CHECKS) {
/* 1372 */       Checks.check(__functionAddress);
/* 1373 */       Checks.check(v, 2);
/*      */     } 
/* 1375 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL3dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1380 */     long __functionAddress = (GL.getICD()).glVertexAttribL3dv;
/* 1381 */     if (Checks.CHECKS) {
/* 1382 */       Checks.check(__functionAddress);
/* 1383 */       Checks.check(v, 3);
/*      */     } 
/* 1385 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL4dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1390 */     long __functionAddress = (GL.getICD()).glVertexAttribL4dv;
/* 1391 */     if (Checks.CHECKS) {
/* 1392 */       Checks.check(__functionAddress);
/* 1393 */       Checks.check(v, 4);
/*      */     } 
/* 1395 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribLdv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 1400 */     long __functionAddress = (GL.getICD()).glGetVertexAttribLdv;
/* 1401 */     if (Checks.CHECKS) {
/* 1402 */       Checks.check(__functionAddress);
/* 1403 */       Checks.check(params, 1);
/*      */     } 
/* 1405 */     JNI.callPV(index, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glViewportArrayv(@NativeType("GLuint") int first, @NativeType("GLfloat const *") float[] v) {
/* 1410 */     long __functionAddress = (GL.getICD()).glViewportArrayv;
/* 1411 */     if (Checks.CHECKS) {
/* 1412 */       Checks.check(__functionAddress);
/*      */     }
/* 1414 */     JNI.callPV(first, v.length >> 2, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glViewportIndexedfv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1419 */     long __functionAddress = (GL.getICD()).glViewportIndexedfv;
/* 1420 */     if (Checks.CHECKS) {
/* 1421 */       Checks.check(__functionAddress);
/* 1422 */       Checks.check(v, 4);
/*      */     } 
/* 1424 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glScissorArrayv(@NativeType("GLuint") int first, @NativeType("GLint const *") int[] v) {
/* 1429 */     long __functionAddress = (GL.getICD()).glScissorArrayv;
/* 1430 */     if (Checks.CHECKS) {
/* 1431 */       Checks.check(__functionAddress);
/*      */     }
/* 1433 */     JNI.callPV(first, v.length >> 2, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glScissorIndexedv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1438 */     long __functionAddress = (GL.getICD()).glScissorIndexedv;
/* 1439 */     if (Checks.CHECKS) {
/* 1440 */       Checks.check(__functionAddress);
/* 1441 */       Checks.check(v, 4);
/*      */     } 
/* 1443 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDepthRangeArrayv(@NativeType("GLuint") int first, @NativeType("GLdouble const *") double[] v) {
/* 1448 */     long __functionAddress = (GL.getICD()).glDepthRangeArrayv;
/* 1449 */     if (Checks.CHECKS) {
/* 1450 */       Checks.check(__functionAddress);
/*      */     }
/* 1452 */     JNI.callPV(first, v.length >> 1, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloati_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] data) {
/* 1457 */     long __functionAddress = (GL.getICD()).glGetFloati_v;
/* 1458 */     if (Checks.CHECKS) {
/* 1459 */       Checks.check(__functionAddress);
/* 1460 */       Checks.check(data, 1);
/*      */     } 
/* 1462 */     JNI.callPV(target, index, data, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_v(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLdouble *") double[] data) {
/* 1467 */     long __functionAddress = (GL.getICD()).glGetDoublei_v;
/* 1468 */     if (Checks.CHECKS) {
/* 1469 */       Checks.check(__functionAddress);
/* 1470 */       Checks.check(data, 1);
/*      */     } 
/* 1472 */     JNI.callPV(target, index, data, __functionAddress);
/*      */   }
/*      */   
/*      */   public static native void glReleaseShaderCompiler();
/*      */   
/*      */   public static native void nglShaderBinary(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native void nglGetShaderPrecisionFormat(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glDepthRangef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glClearDepthf(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglGetProgramBinary(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nglProgramBinary(int paramInt1, int paramInt2, long paramLong, int paramInt3);
/*      */   
/*      */   public static native void glProgramParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glUseProgramStages(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glActiveShaderProgram(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native int nglCreateShaderProgramv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glBindProgramPipeline(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglDeleteProgramPipelines(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenProgramPipelines(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsProgramPipeline(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglGetProgramPipelineiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glProgramUniform1i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glProgramUniform2i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glProgramUniform3i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glProgramUniform4i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*      */   
/*      */   public static native void glProgramUniform1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glProgramUniform2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glProgramUniform3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glProgramUniform4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6);
/*      */   
/*      */   public static native void glProgramUniform1f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glProgramUniform2f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glProgramUniform3f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glProgramUniform4f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glProgramUniform1d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glProgramUniform2d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glProgramUniform3d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glProgramUniform4d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglProgramUniform1iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform1uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform1fv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2fv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3fv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4fv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform1dv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2dv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3dv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4dv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x3fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x2fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x4fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x2fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x4fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x3fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x3dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x2dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x4dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x2dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x4dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x3dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void glValidateProgramPipeline(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglGetProgramPipelineInfoLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glVertexAttribL1d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glVertexAttribL2d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glVertexAttribL3d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glVertexAttribL4d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglVertexAttribL1dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribL2dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribL3dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribL4dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribLPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribLdv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglViewportArrayv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glViewportIndexedf(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void nglViewportIndexedfv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglScissorArrayv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glScissorIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void nglScissorIndexedv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglDepthRangeArrayv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glDepthRangeIndexed(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglGetFloati_v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetDoublei_v(int paramInt1, int paramInt2, long paramLong);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL41C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */