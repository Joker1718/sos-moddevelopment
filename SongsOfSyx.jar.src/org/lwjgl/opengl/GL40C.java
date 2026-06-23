/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL40C
/*     */   extends GL33C {
/*     */   public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
/*     */   public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;
/*     */   public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943;
/*     */   public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
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
/*     */   protected GL40C() {
/* 143 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect) {
/* 173 */     if (Checks.CHECKS) {
/* 174 */       Checks.check(indirect, 16);
/*     */     }
/* 176 */     nglDrawArraysIndirect(mode, MemoryUtil.memAddress(indirect));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect) {
/* 181 */     nglDrawArraysIndirect(mode, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indirect) {
/* 186 */     if (Checks.CHECKS) {
/* 187 */       Checks.check(indirect, 4);
/*     */     }
/* 189 */     nglDrawArraysIndirect(mode, MemoryUtil.memAddress(indirect));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect) {
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check(indirect, 20);
/*     */     }
/* 202 */     nglDrawElementsIndirect(mode, type, MemoryUtil.memAddress(indirect));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect) {
/* 207 */     nglDrawElementsIndirect(mode, type, indirect);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer indirect) {
/* 212 */     if (Checks.CHECKS) {
/* 213 */       Checks.check(indirect, 5);
/*     */     }
/* 215 */     nglDrawElementsIndirect(mode, type, MemoryUtil.memAddress(indirect));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform1dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 245 */     nglUniform1dv(location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 255 */     nglUniform2dv(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 265 */     nglUniform3dv(location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 275 */     nglUniform4dv(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 285 */     nglUniformMatrix2dv(location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 295 */     nglUniformMatrix3dv(location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 305 */     nglUniformMatrix4dv(location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 315 */     nglUniformMatrix2x3dv(location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 325 */     nglUniformMatrix2x4dv(location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 335 */     nglUniformMatrix3x2dv(location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 345 */     nglUniformMatrix3x4dv(location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 355 */     nglUniformMatrix4x2dv(location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") DoubleBuffer value) {
/* 365 */     nglUniformMatrix4x3dv(location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") DoubleBuffer params) {
/* 375 */     if (Checks.CHECKS) {
/* 376 */       Checks.check(params, 1);
/*     */     }
/* 378 */     nglGetUniformdv(program, location, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static double glGetUniformd(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 384 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 386 */       DoubleBuffer params = stack.callocDouble(1);
/* 387 */       nglGetUniformdv(program, location, MemoryUtil.memAddress(params));
/* 388 */       return params.get(0);
/*     */     } finally {
/* 390 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") ByteBuffer name) {
/* 407 */     if (Checks.CHECKS) {
/* 408 */       Checks.checkNT1(name);
/*     */     }
/* 410 */     return nglGetSubroutineUniformLocation(program, shadertype, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") CharSequence name) {
/* 416 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 418 */       stack.nASCII(name, true);
/* 419 */       long nameEncoded = stack.getPointerAddress();
/* 420 */       return nglGetSubroutineUniformLocation(program, shadertype, nameEncoded);
/*     */     } finally {
/* 422 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetSubroutineIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") ByteBuffer name) {
/* 434 */     if (Checks.CHECKS) {
/* 435 */       Checks.checkNT1(name);
/*     */     }
/* 437 */     return nglGetSubroutineIndex(program, shadertype, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetSubroutineIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") CharSequence name) {
/* 443 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 445 */       stack.nASCII(name, true);
/* 446 */       long nameEncoded = stack.getPointerAddress();
/* 447 */       return nglGetSubroutineIndex(program, shadertype, nameEncoded);
/*     */     } finally {
/* 449 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer values) {
/* 460 */     if (Checks.CHECKS) {
/* 461 */       Checks.check(values, 1);
/*     */     }
/* 463 */     nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetActiveSubroutineUniformi(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 469 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 471 */       IntBuffer values = stack.callocInt(1);
/* 472 */       nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, MemoryUtil.memAddress(values));
/* 473 */       return values.get(0);
/*     */     } finally {
/* 475 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer name) {
/* 486 */     if (Checks.CHECKS) {
/* 487 */       Checks.checkSafe(length, 1);
/*     */     }
/* 489 */     nglGetActiveSubroutineUniformName(program, shadertype, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei") int bufsize) {
/* 495 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 497 */       IntBuffer length = stack.ints(0);
/* 498 */       ByteBuffer name = stack.malloc(bufsize);
/* 499 */       nglGetActiveSubroutineUniformName(program, shadertype, index, bufsize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(name));
/* 500 */       return MemoryUtil.memASCII(name, length.get(0));
/*     */     } finally {
/* 502 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index) {
/* 509 */     return glGetActiveSubroutineUniformName(program, shadertype, index, glGetActiveSubroutineUniformi(program, shadertype, index, 35385));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer name) {
/* 519 */     if (Checks.CHECKS) {
/* 520 */       Checks.checkSafe(length, 1);
/*     */     }
/* 522 */     nglGetActiveSubroutineName(program, shadertype, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei") int bufsize) {
/* 528 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 530 */       IntBuffer length = stack.ints(0);
/* 531 */       ByteBuffer name = stack.malloc(bufsize);
/* 532 */       nglGetActiveSubroutineName(program, shadertype, index, bufsize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(name));
/* 533 */       return MemoryUtil.memASCII(name, length.get(0));
/*     */     } finally {
/* 535 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index) {
/* 542 */     return glGetActiveSubroutineName(program, shadertype, index, glGetProgramStagei(program, shadertype, 36424));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int shadertype, @NativeType("GLuint const *") IntBuffer indices) {
/* 552 */     nglUniformSubroutinesuiv(shadertype, indices.remaining(), MemoryUtil.memAddress(indices));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesui(@NativeType("GLenum") int shadertype, @NativeType("GLuint const *") int index) {
/* 557 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 559 */       IntBuffer indices = stack.ints(index);
/* 560 */       nglUniformSubroutinesuiv(shadertype, 1, MemoryUtil.memAddress(indices));
/*     */     } finally {
/* 562 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int shadertype, @NativeType("GLint") int location, @NativeType("GLuint *") IntBuffer params) {
/* 573 */     if (Checks.CHECKS) {
/* 574 */       Checks.check(params, 1);
/*     */     }
/* 576 */     nglGetUniformSubroutineuiv(shadertype, location, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformSubroutineui(@NativeType("GLenum") int shadertype, @NativeType("GLint") int location) {
/* 582 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 584 */       IntBuffer params = stack.callocInt(1);
/* 585 */       nglGetUniformSubroutineuiv(shadertype, location, MemoryUtil.memAddress(params));
/* 586 */       return params.get(0);
/*     */     } finally {
/* 588 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetProgramStageiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer values) {
/* 599 */     if (Checks.CHECKS) {
/* 600 */       Checks.check(values, 1);
/*     */     }
/* 602 */     nglGetProgramStageiv(program, shadertype, pname, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetProgramStagei(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLenum") int pname) {
/* 608 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 610 */       IntBuffer values = stack.callocInt(1);
/* 611 */       nglGetProgramStageiv(program, shadertype, pname, MemoryUtil.memAddress(values));
/* 612 */       return values.get(0);
/*     */     } finally {
/* 614 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPatchParameterfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer values) {
/* 630 */     if (Checks.CHECKS && 
/* 631 */       Checks.DEBUG) {
/* 632 */       Checks.check(values, GL11.glGetInteger(36466));
/*     */     }
/*     */     
/* 635 */     nglPatchParameterfv(pname, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") IntBuffer ids) {
/* 650 */     nglDeleteTransformFeedbacks(ids.remaining(), MemoryUtil.memAddress(ids));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int id) {
/* 655 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 657 */       IntBuffer ids = stack.ints(id);
/* 658 */       nglDeleteTransformFeedbacks(1, MemoryUtil.memAddress(ids));
/*     */     } finally {
/* 660 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") IntBuffer ids) {
/* 671 */     nglGenTransformFeedbacks(ids.remaining(), MemoryUtil.memAddress(ids));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenTransformFeedbacks() {
/* 677 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 679 */       IntBuffer ids = stack.callocInt(1);
/* 680 */       nglGenTransformFeedbacks(1, MemoryUtil.memAddress(ids));
/* 681 */       return ids.get(0);
/*     */     } finally {
/* 683 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryIndexediv(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 730 */     if (Checks.CHECKS) {
/* 731 */       Checks.check(params, 1);
/*     */     }
/* 733 */     nglGetQueryIndexediv(target, index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryIndexedi(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 739 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 741 */       IntBuffer params = stack.callocInt(1);
/* 742 */       nglGetQueryIndexediv(target, index, pname, MemoryUtil.memAddress(params));
/* 743 */       return params.get(0);
/*     */     } finally {
/* 745 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") int[] indirect) {
/* 751 */     long __functionAddress = (GL.getICD()).glDrawArraysIndirect;
/* 752 */     if (Checks.CHECKS) {
/* 753 */       Checks.check(__functionAddress);
/* 754 */       Checks.check(indirect, 4);
/*     */     } 
/* 756 */     JNI.callPV(mode, indirect, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") int[] indirect) {
/* 761 */     long __functionAddress = (GL.getICD()).glDrawElementsIndirect;
/* 762 */     if (Checks.CHECKS) {
/* 763 */       Checks.check(__functionAddress);
/* 764 */       Checks.check(indirect, 5);
/*     */     } 
/* 766 */     JNI.callPV(mode, type, indirect, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 771 */     long __functionAddress = (GL.getICD()).glUniform1dv;
/* 772 */     if (Checks.CHECKS) {
/* 773 */       Checks.check(__functionAddress);
/*     */     }
/* 775 */     JNI.callPV(location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 780 */     long __functionAddress = (GL.getICD()).glUniform2dv;
/* 781 */     if (Checks.CHECKS) {
/* 782 */       Checks.check(__functionAddress);
/*     */     }
/* 784 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 789 */     long __functionAddress = (GL.getICD()).glUniform3dv;
/* 790 */     if (Checks.CHECKS) {
/* 791 */       Checks.check(__functionAddress);
/*     */     }
/* 793 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4dv(@NativeType("GLint") int location, @NativeType("GLdouble const *") double[] value) {
/* 798 */     long __functionAddress = (GL.getICD()).glUniform4dv;
/* 799 */     if (Checks.CHECKS) {
/* 800 */       Checks.check(__functionAddress);
/*     */     }
/* 802 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 807 */     long __functionAddress = (GL.getICD()).glUniformMatrix2dv;
/* 808 */     if (Checks.CHECKS) {
/* 809 */       Checks.check(__functionAddress);
/*     */     }
/* 811 */     JNI.callPV(location, value.length >> 2, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 816 */     long __functionAddress = (GL.getICD()).glUniformMatrix3dv;
/* 817 */     if (Checks.CHECKS) {
/* 818 */       Checks.check(__functionAddress);
/*     */     }
/* 820 */     JNI.callPV(location, value.length / 9, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 825 */     long __functionAddress = (GL.getICD()).glUniformMatrix4dv;
/* 826 */     if (Checks.CHECKS) {
/* 827 */       Checks.check(__functionAddress);
/*     */     }
/* 829 */     JNI.callPV(location, value.length >> 4, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 834 */     long __functionAddress = (GL.getICD()).glUniformMatrix2x3dv;
/* 835 */     if (Checks.CHECKS) {
/* 836 */       Checks.check(__functionAddress);
/*     */     }
/* 838 */     JNI.callPV(location, value.length / 6, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 843 */     long __functionAddress = (GL.getICD()).glUniformMatrix2x4dv;
/* 844 */     if (Checks.CHECKS) {
/* 845 */       Checks.check(__functionAddress);
/*     */     }
/* 847 */     JNI.callPV(location, value.length >> 3, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 852 */     long __functionAddress = (GL.getICD()).glUniformMatrix3x2dv;
/* 853 */     if (Checks.CHECKS) {
/* 854 */       Checks.check(__functionAddress);
/*     */     }
/* 856 */     JNI.callPV(location, value.length / 6, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 861 */     long __functionAddress = (GL.getICD()).glUniformMatrix3x4dv;
/* 862 */     if (Checks.CHECKS) {
/* 863 */       Checks.check(__functionAddress);
/*     */     }
/* 865 */     JNI.callPV(location, value.length / 12, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 870 */     long __functionAddress = (GL.getICD()).glUniformMatrix4x2dv;
/* 871 */     if (Checks.CHECKS) {
/* 872 */       Checks.check(__functionAddress);
/*     */     }
/* 874 */     JNI.callPV(location, value.length >> 3, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLdouble const *") double[] value) {
/* 879 */     long __functionAddress = (GL.getICD()).glUniformMatrix4x3dv;
/* 880 */     if (Checks.CHECKS) {
/* 881 */       Checks.check(__functionAddress);
/*     */     }
/* 883 */     JNI.callPV(location, value.length / 12, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformdv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLdouble *") double[] params) {
/* 888 */     long __functionAddress = (GL.getICD()).glGetUniformdv;
/* 889 */     if (Checks.CHECKS) {
/* 890 */       Checks.check(__functionAddress);
/* 891 */       Checks.check(params, 1);
/*     */     } 
/* 893 */     JNI.callPV(program, location, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] values) {
/* 898 */     long __functionAddress = (GL.getICD()).glGetActiveSubroutineUniformiv;
/* 899 */     if (Checks.CHECKS) {
/* 900 */       Checks.check(__functionAddress);
/* 901 */       Checks.check(values, 1);
/*     */     } 
/* 903 */     JNI.callPV(program, shadertype, index, pname, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer name) {
/* 908 */     long __functionAddress = (GL.getICD()).glGetActiveSubroutineUniformName;
/* 909 */     if (Checks.CHECKS) {
/* 910 */       Checks.check(__functionAddress);
/* 911 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 913 */     JNI.callPPV(program, shadertype, index, name.remaining(), length, MemoryUtil.memAddress(name), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer name) {
/* 918 */     long __functionAddress = (GL.getICD()).glGetActiveSubroutineName;
/* 919 */     if (Checks.CHECKS) {
/* 920 */       Checks.check(__functionAddress);
/* 921 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 923 */     JNI.callPPV(program, shadertype, index, name.remaining(), length, MemoryUtil.memAddress(name), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int shadertype, @NativeType("GLuint const *") int[] indices) {
/* 928 */     long __functionAddress = (GL.getICD()).glUniformSubroutinesuiv;
/* 929 */     if (Checks.CHECKS) {
/* 930 */       Checks.check(__functionAddress);
/*     */     }
/* 932 */     JNI.callPV(shadertype, indices.length, indices, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int shadertype, @NativeType("GLint") int location, @NativeType("GLuint *") int[] params) {
/* 937 */     long __functionAddress = (GL.getICD()).glGetUniformSubroutineuiv;
/* 938 */     if (Checks.CHECKS) {
/* 939 */       Checks.check(__functionAddress);
/* 940 */       Checks.check(params, 1);
/*     */     } 
/* 942 */     JNI.callPV(shadertype, location, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramStageiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] values) {
/* 947 */     long __functionAddress = (GL.getICD()).glGetProgramStageiv;
/* 948 */     if (Checks.CHECKS) {
/* 949 */       Checks.check(__functionAddress);
/* 950 */       Checks.check(values, 1);
/*     */     } 
/* 952 */     JNI.callPV(program, shadertype, pname, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPatchParameterfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] values) {
/* 957 */     long __functionAddress = (GL.getICD()).glPatchParameterfv;
/* 958 */     if (Checks.CHECKS) {
/* 959 */       Checks.check(__functionAddress);
/* 960 */       if (Checks.DEBUG) {
/* 961 */         Checks.check(values, GL11.glGetInteger(36466));
/*     */       }
/*     */     } 
/* 964 */     JNI.callPV(pname, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int[] ids) {
/* 969 */     long __functionAddress = (GL.getICD()).glDeleteTransformFeedbacks;
/* 970 */     if (Checks.CHECKS) {
/* 971 */       Checks.check(__functionAddress);
/*     */     }
/* 973 */     JNI.callPV(ids.length, ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") int[] ids) {
/* 978 */     long __functionAddress = (GL.getICD()).glGenTransformFeedbacks;
/* 979 */     if (Checks.CHECKS) {
/* 980 */       Checks.check(__functionAddress);
/*     */     }
/* 982 */     JNI.callPV(ids.length, ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryIndexediv(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 987 */     long __functionAddress = (GL.getICD()).glGetQueryIndexediv;
/* 988 */     if (Checks.CHECKS) {
/* 989 */       Checks.check(__functionAddress);
/* 990 */       Checks.check(params, 1);
/*     */     } 
/* 992 */     JNI.callPV(target, index, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glBlendEquationi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */   
/*     */   public static native void glBlendEquationSeparatei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*     */   
/*     */   public static native void glBlendFunci(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*     */   
/*     */   public static native void glBlendFuncSeparatei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5);
/*     */   
/*     */   public static native void nglDrawArraysIndirect(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDrawElementsIndirect(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glUniform1d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void glUniform2d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void glUniform3d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void glUniform4d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*     */   
/*     */   public static native void nglUniform1dv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform2dv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform3dv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform4dv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix2x3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix2x4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix3x2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix3x4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix4x2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix4x3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformdv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glMinSampleShading(@NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native int nglGetSubroutineUniformLocation(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native int nglGetSubroutineIndex(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveSubroutineUniformiv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveSubroutineUniformName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetActiveSubroutineName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglUniformSubroutinesuiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformSubroutineuiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetProgramStageiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glPatchParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void nglPatchParameterfv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glBindTransformFeedback(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteTransformFeedbacks(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenTransformFeedbacks(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsTransformFeedback(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glPauseTransformFeedback();
/*     */   
/*     */   public static native void glResumeTransformFeedback();
/*     */   
/*     */   public static native void glDrawTransformFeedback(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glDrawTransformFeedbackStream(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glBeginQueryIndexed(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glEndQueryIndexed(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglGetQueryIndexediv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL40C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */