/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
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
/*      */ public class GL20C
/*      */   extends GL15C {
/*      */   public static final int GL_SHADING_LANGUAGE_VERSION = 35724;
/*      */   public static final int GL_CURRENT_PROGRAM = 35725;
/*      */   
/*      */   static {
/*   23 */     GL.initialize();
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
/*      */   public static final int GL_SAMPLER_1D = 35677;
/*      */   public static final int GL_SAMPLER_2D = 35678;
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
/*      */   public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;
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
/*      */   protected GL20C() {
/*  131 */     throw new UnsupportedOperationException();
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
/*      */   public static void glShaderSource(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") PointerBuffer strings, @NativeType("GLint const *") IntBuffer length) {
/*  185 */     if (Checks.CHECKS) {
/*  186 */       Checks.checkSafe(length, strings.remaining());
/*      */     }
/*  188 */     nglShaderSource(shader, strings.remaining(), MemoryUtil.memAddress((CustomBuffer)strings), MemoryUtil.memAddressSafe(length));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderSource(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") CharSequence... strings) {
/*  193 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  195 */       long stringsAddress = APIUtil.apiArrayi(stack, MemoryUtil::memUTF8, strings);
/*  196 */       nglShaderSource(shader, strings.length, stringsAddress, stringsAddress - (strings.length << 2));
/*  197 */       APIUtil.apiArrayFree(stringsAddress, strings.length);
/*      */     } finally {
/*  199 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderSource(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") CharSequence string) {
/*  205 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  207 */       long stringsAddress = APIUtil.apiArrayi(stack, MemoryUtil::memUTF8, new CharSequence[] { string });
/*  208 */       nglShaderSource(shader, 1, stringsAddress, stringsAddress - 4L);
/*  209 */       APIUtil.apiArrayFree(stringsAddress, 1);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  282 */     nglUniform1fv(location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  292 */     nglUniform2fv(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  302 */     nglUniform3fv(location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/*  312 */     nglUniform4fv(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1iv(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  322 */     nglUniform1iv(location, value.remaining(), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2iv(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  332 */     nglUniform2iv(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3iv(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  342 */     nglUniform3iv(location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4iv(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/*  352 */     nglUniform4iv(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  362 */     nglUniformMatrix2fv(location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  372 */     nglUniformMatrix3fv(location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/*  382 */     nglUniformMatrix4fv(location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderiv(@NativeType("GLuint") int shader, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  392 */     if (Checks.CHECKS) {
/*  393 */       Checks.check(params, 1);
/*      */     }
/*  395 */     nglGetShaderiv(shader, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetShaderi(@NativeType("GLuint") int shader, @NativeType("GLenum") int pname) {
/*  401 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  403 */       IntBuffer params = stack.callocInt(1);
/*  404 */       nglGetShaderiv(shader, pname, MemoryUtil.memAddress(params));
/*  405 */       return params.get(0);
/*      */     } finally {
/*  407 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramiv(@NativeType("GLuint") int program, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  418 */     if (Checks.CHECKS) {
/*  419 */       Checks.check(params, 1);
/*      */     }
/*  421 */     nglGetProgramiv(program, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetProgrami(@NativeType("GLuint") int program, @NativeType("GLenum") int pname) {
/*  427 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  429 */       IntBuffer params = stack.callocInt(1);
/*  430 */       nglGetProgramiv(program, pname, MemoryUtil.memAddress(params));
/*  431 */       return params.get(0);
/*      */     } finally {
/*  433 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderInfoLog(@NativeType("GLuint") int shader, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer infoLog) {
/*  444 */     if (Checks.CHECKS) {
/*  445 */       Checks.checkSafe(length, 1);
/*      */     }
/*  447 */     nglGetShaderInfoLog(shader, infoLog.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(infoLog));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderInfoLog(@NativeType("GLuint") int shader, @NativeType("GLsizei") int maxLength) {
/*  453 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  454 */     ByteBuffer infoLog = MemoryUtil.memAlloc(maxLength);
/*      */     try {
/*  456 */       IntBuffer length = stack.ints(0);
/*  457 */       nglGetShaderInfoLog(shader, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(infoLog));
/*  458 */       return MemoryUtil.memUTF8(infoLog, length.get(0));
/*      */     } finally {
/*  460 */       MemoryUtil.memFree(infoLog);
/*  461 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderInfoLog(@NativeType("GLuint") int shader) {
/*  468 */     return glGetShaderInfoLog(shader, glGetShaderi(shader, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramInfoLog(@NativeType("GLuint") int program, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer infoLog) {
/*  478 */     if (Checks.CHECKS) {
/*  479 */       Checks.checkSafe(length, 1);
/*      */     }
/*  481 */     nglGetProgramInfoLog(program, infoLog.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(infoLog));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramInfoLog(@NativeType("GLuint") int program, @NativeType("GLsizei") int maxLength) {
/*  487 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  488 */     ByteBuffer infoLog = MemoryUtil.memAlloc(maxLength);
/*      */     try {
/*  490 */       IntBuffer length = stack.ints(0);
/*  491 */       nglGetProgramInfoLog(program, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(infoLog));
/*  492 */       return MemoryUtil.memUTF8(infoLog, length.get(0));
/*      */     } finally {
/*  494 */       MemoryUtil.memFree(infoLog);
/*  495 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramInfoLog(@NativeType("GLuint") int program) {
/*  502 */     return glGetProgramInfoLog(program, glGetProgrami(program, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetAttachedShaders(@NativeType("GLuint") int program, @NativeType("GLsizei *") IntBuffer count, @NativeType("GLuint *") IntBuffer shaders) {
/*  512 */     if (Checks.CHECKS) {
/*  513 */       Checks.checkSafe(count, 1);
/*      */     }
/*  515 */     nglGetAttachedShaders(program, shaders.remaining(), MemoryUtil.memAddressSafe(count), MemoryUtil.memAddress(shaders));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetUniformLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/*  526 */     if (Checks.CHECKS) {
/*  527 */       Checks.checkNT1(name);
/*      */     }
/*  529 */     return nglGetUniformLocation(program, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetUniformLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/*  535 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  537 */       stack.nASCII(name, true);
/*  538 */       long nameEncoded = stack.getPointerAddress();
/*  539 */       return nglGetUniformLocation(program, nameEncoded);
/*      */     } finally {
/*  541 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveUniform(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type, @NativeType("GLchar *") ByteBuffer name) {
/*  552 */     if (Checks.CHECKS) {
/*  553 */       Checks.checkSafe(length, 1);
/*  554 */       Checks.check(size, 1);
/*  555 */       Checks.check(type, 1);
/*      */     } 
/*  557 */     nglGetActiveUniform(program, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveUniform(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei") int maxLength, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/*  563 */     if (Checks.CHECKS) {
/*  564 */       Checks.check(size, 1);
/*  565 */       Checks.check(type, 1);
/*      */     } 
/*  567 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  569 */       IntBuffer length = stack.ints(0);
/*  570 */       ByteBuffer name = stack.malloc(maxLength);
/*  571 */       nglGetActiveUniform(program, index, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/*  572 */       return MemoryUtil.memASCII(name, length.get(0));
/*      */     } finally {
/*  574 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveUniform(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/*  581 */     return glGetActiveUniform(program, index, glGetProgrami(program, 35719), size, type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") FloatBuffer params) {
/*  591 */     if (Checks.CHECKS) {
/*  592 */       Checks.check(params, 1);
/*      */     }
/*  594 */     nglGetUniformfv(program, location, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetUniformf(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/*  600 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  602 */       FloatBuffer params = stack.callocFloat(1);
/*  603 */       nglGetUniformfv(program, location, MemoryUtil.memAddress(params));
/*  604 */       return params.get(0);
/*      */     } finally {
/*  606 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") IntBuffer params) {
/*  617 */     if (Checks.CHECKS) {
/*  618 */       Checks.check(params, 1);
/*      */     }
/*  620 */     nglGetUniformiv(program, location, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetUniformi(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/*  626 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  628 */       IntBuffer params = stack.callocInt(1);
/*  629 */       nglGetUniformiv(program, location, MemoryUtil.memAddress(params));
/*  630 */       return params.get(0);
/*      */     } finally {
/*  632 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderSource(@NativeType("GLuint") int shader, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer source) {
/*  643 */     if (Checks.CHECKS) {
/*  644 */       Checks.checkSafe(length, 1);
/*      */     }
/*  646 */     nglGetShaderSource(shader, source.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(source));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderSource(@NativeType("GLuint") int shader, @NativeType("GLsizei") int maxLength) {
/*  652 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  653 */     ByteBuffer source = MemoryUtil.memAlloc(maxLength);
/*      */     try {
/*  655 */       IntBuffer length = stack.ints(0);
/*  656 */       nglGetShaderSource(shader, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(source));
/*  657 */       return MemoryUtil.memUTF8(source, length.get(0));
/*      */     } finally {
/*  659 */       MemoryUtil.memFree(source);
/*  660 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderSource(@NativeType("GLuint") int shader) {
/*  667 */     return glGetShaderSource(shader, glGetShaderi(shader, 35720));
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
/*      */   public static void glVertexAttrib1fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  742 */     if (Checks.CHECKS) {
/*  743 */       Checks.check(v, 1);
/*      */     }
/*  745 */     nglVertexAttrib1fv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  755 */     if (Checks.CHECKS) {
/*  756 */       Checks.check(v, 1);
/*      */     }
/*  758 */     nglVertexAttrib1sv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  768 */     if (Checks.CHECKS) {
/*  769 */       Checks.check(v, 1);
/*      */     }
/*  771 */     nglVertexAttrib1dv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  781 */     if (Checks.CHECKS) {
/*  782 */       Checks.check(v, 2);
/*      */     }
/*  784 */     nglVertexAttrib2fv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  794 */     if (Checks.CHECKS) {
/*  795 */       Checks.check(v, 2);
/*      */     }
/*  797 */     nglVertexAttrib2sv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  807 */     if (Checks.CHECKS) {
/*  808 */       Checks.check(v, 2);
/*      */     }
/*  810 */     nglVertexAttrib2dv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  820 */     if (Checks.CHECKS) {
/*  821 */       Checks.check(v, 3);
/*      */     }
/*  823 */     nglVertexAttrib3fv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  833 */     if (Checks.CHECKS) {
/*  834 */       Checks.check(v, 3);
/*      */     }
/*  836 */     nglVertexAttrib3sv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  846 */     if (Checks.CHECKS) {
/*  847 */       Checks.check(v, 3);
/*      */     }
/*  849 */     nglVertexAttrib3dv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/*  859 */     if (Checks.CHECKS) {
/*  860 */       Checks.check(v, 4);
/*      */     }
/*  862 */     nglVertexAttrib4fv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  872 */     if (Checks.CHECKS) {
/*  873 */       Checks.check(v, 4);
/*      */     }
/*  875 */     nglVertexAttrib4sv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  885 */     if (Checks.CHECKS) {
/*  886 */       Checks.check(v, 4);
/*      */     }
/*  888 */     nglVertexAttrib4dv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4iv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  898 */     if (Checks.CHECKS) {
/*  899 */       Checks.check(v, 4);
/*      */     }
/*  901 */     nglVertexAttrib4iv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4bv(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/*  911 */     if (Checks.CHECKS) {
/*  912 */       Checks.check(v, 4);
/*      */     }
/*  914 */     nglVertexAttrib4bv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4ubv(@NativeType("GLuint") int index, @NativeType("GLubyte const *") ByteBuffer v) {
/*  924 */     if (Checks.CHECKS) {
/*  925 */       Checks.check(v, 4);
/*      */     }
/*  927 */     nglVertexAttrib4ubv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usv(@NativeType("GLuint") int index, @NativeType("GLushort const *") ShortBuffer v) {
/*  937 */     if (Checks.CHECKS) {
/*  938 */       Checks.check(v, 4);
/*      */     }
/*  940 */     nglVertexAttrib4usv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/*  950 */     if (Checks.CHECKS) {
/*  951 */       Checks.check(v, 4);
/*      */     }
/*  953 */     nglVertexAttrib4uiv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nbv(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/*  963 */     if (Checks.CHECKS) {
/*  964 */       Checks.check(v, 4);
/*      */     }
/*  966 */     nglVertexAttrib4Nbv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nsv(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/*  976 */     if (Checks.CHECKS) {
/*  977 */       Checks.check(v, 4);
/*      */     }
/*  979 */     nglVertexAttrib4Nsv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Niv(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/*  989 */     if (Checks.CHECKS) {
/*  990 */       Checks.check(v, 4);
/*      */     }
/*  992 */     nglVertexAttrib4Niv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nubv(@NativeType("GLuint") int index, @NativeType("GLubyte const *") ByteBuffer v) {
/* 1002 */     if (Checks.CHECKS) {
/* 1003 */       Checks.check(v, 4);
/*      */     }
/* 1005 */     nglVertexAttrib4Nubv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nusv(@NativeType("GLuint") int index, @NativeType("GLushort const *") ShortBuffer v) {
/* 1015 */     if (Checks.CHECKS) {
/* 1016 */       Checks.check(v, 4);
/*      */     }
/* 1018 */     nglVertexAttrib4Nusv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nuiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/* 1028 */     if (Checks.CHECKS) {
/* 1029 */       Checks.check(v, 4);
/*      */     }
/* 1031 */     nglVertexAttrib4Nuiv(index, MemoryUtil.memAddress(v));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 1041 */     nglVertexAttribPointer(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 1046 */     nglVertexAttribPointer(index, size, type, normalized, stride, pointer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 1051 */     nglVertexAttribPointer(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 1056 */     nglVertexAttribPointer(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 1061 */     nglVertexAttribPointer(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
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
/*      */   public static void glBindAttribLocation(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLchar const *") ByteBuffer name) {
/* 1081 */     if (Checks.CHECKS) {
/* 1082 */       Checks.checkNT1(name);
/*      */     }
/* 1084 */     nglBindAttribLocation(program, index, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glBindAttribLocation(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLchar const *") CharSequence name) {
/* 1089 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1091 */       stack.nASCII(name, true);
/* 1092 */       long nameEncoded = stack.getPointerAddress();
/* 1093 */       nglBindAttribLocation(program, index, nameEncoded);
/*      */     } finally {
/* 1095 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveAttrib(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type, @NativeType("GLchar *") ByteBuffer name) {
/* 1106 */     if (Checks.CHECKS) {
/* 1107 */       Checks.checkSafe(length, 1);
/* 1108 */       Checks.check(size, 1);
/* 1109 */       Checks.check(type, 1);
/*      */     } 
/* 1111 */     nglGetActiveAttrib(program, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveAttrib(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei") int maxLength, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 1117 */     if (Checks.CHECKS) {
/* 1118 */       Checks.check(size, 1);
/* 1119 */       Checks.check(type, 1);
/*      */     } 
/* 1121 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1123 */       IntBuffer length = stack.ints(0);
/* 1124 */       ByteBuffer name = stack.malloc(maxLength);
/* 1125 */       nglGetActiveAttrib(program, index, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/* 1126 */       return MemoryUtil.memASCII(name, length.get(0));
/*      */     } finally {
/* 1128 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveAttrib(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 1135 */     return glGetActiveAttrib(program, index, glGetProgrami(program, 35722), size, type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetAttribLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/* 1146 */     if (Checks.CHECKS) {
/* 1147 */       Checks.checkNT1(name);
/*      */     }
/* 1149 */     return nglGetAttribLocation(program, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetAttribLocation(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/* 1155 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1157 */       stack.nASCII(name, true);
/* 1158 */       long nameEncoded = stack.getPointerAddress();
/* 1159 */       return nglGetAttribLocation(program, nameEncoded);
/*      */     } finally {
/* 1161 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribiv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 1172 */     if (Checks.CHECKS) {
/* 1173 */       Checks.check(params, 1);
/*      */     }
/* 1175 */     nglGetVertexAttribiv(index, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexAttribi(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1181 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1183 */       IntBuffer params = stack.callocInt(1);
/* 1184 */       nglGetVertexAttribiv(index, pname, MemoryUtil.memAddress(params));
/* 1185 */       return params.get(0);
/*      */     } finally {
/* 1187 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 1198 */     if (Checks.CHECKS) {
/* 1199 */       Checks.check(params, 4);
/*      */     }
/* 1201 */     nglGetVertexAttribfv(index, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/* 1211 */     if (Checks.CHECKS) {
/* 1212 */       Checks.check(params, 4);
/*      */     }
/* 1214 */     nglGetVertexAttribdv(index, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribPointerv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer pointer) {
/* 1224 */     if (Checks.CHECKS) {
/* 1225 */       Checks.check((CustomBuffer)pointer, 1);
/*      */     }
/* 1227 */     nglGetVertexAttribPointerv(index, pname, MemoryUtil.memAddress((CustomBuffer)pointer));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexAttribPointer(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 1233 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1235 */       PointerBuffer pointer = stack.callocPointer(1);
/* 1236 */       nglGetVertexAttribPointerv(index, pname, MemoryUtil.memAddress((CustomBuffer)pointer));
/* 1237 */       return pointer.get(0);
/*      */     } finally {
/* 1239 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") IntBuffer bufs) {
/* 1250 */     nglDrawBuffers(bufs.remaining(), MemoryUtil.memAddress(bufs));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") int buf) {
/* 1255 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1257 */       IntBuffer bufs = stack.ints(buf);
/* 1258 */       nglDrawBuffers(1, MemoryUtil.memAddress(bufs));
/*      */     } finally {
/* 1260 */       stack.setPointer(stackPointer);
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
/*      */   public static void glShaderSource(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") PointerBuffer strings, @NativeType("GLint const *") int[] length) {
/* 1286 */     long __functionAddress = (GL.getICD()).glShaderSource;
/* 1287 */     if (Checks.CHECKS) {
/* 1288 */       Checks.check(__functionAddress);
/* 1289 */       Checks.checkSafe(length, strings.remaining());
/*      */     } 
/* 1291 */     JNI.callPPV(shader, strings.remaining(), MemoryUtil.memAddress((CustomBuffer)strings), length, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform1fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1296 */     long __functionAddress = (GL.getICD()).glUniform1fv;
/* 1297 */     if (Checks.CHECKS) {
/* 1298 */       Checks.check(__functionAddress);
/*      */     }
/* 1300 */     JNI.callPV(location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform2fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1305 */     long __functionAddress = (GL.getICD()).glUniform2fv;
/* 1306 */     if (Checks.CHECKS) {
/* 1307 */       Checks.check(__functionAddress);
/*      */     }
/* 1309 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform3fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1314 */     long __functionAddress = (GL.getICD()).glUniform3fv;
/* 1315 */     if (Checks.CHECKS) {
/* 1316 */       Checks.check(__functionAddress);
/*      */     }
/* 1318 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform4fv(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 1323 */     long __functionAddress = (GL.getICD()).glUniform4fv;
/* 1324 */     if (Checks.CHECKS) {
/* 1325 */       Checks.check(__functionAddress);
/*      */     }
/* 1327 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform1iv(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1332 */     long __functionAddress = (GL.getICD()).glUniform1iv;
/* 1333 */     if (Checks.CHECKS) {
/* 1334 */       Checks.check(__functionAddress);
/*      */     }
/* 1336 */     JNI.callPV(location, value.length, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform2iv(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1341 */     long __functionAddress = (GL.getICD()).glUniform2iv;
/* 1342 */     if (Checks.CHECKS) {
/* 1343 */       Checks.check(__functionAddress);
/*      */     }
/* 1345 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform3iv(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1350 */     long __functionAddress = (GL.getICD()).glUniform3iv;
/* 1351 */     if (Checks.CHECKS) {
/* 1352 */       Checks.check(__functionAddress);
/*      */     }
/* 1354 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform4iv(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 1359 */     long __functionAddress = (GL.getICD()).glUniform4iv;
/* 1360 */     if (Checks.CHECKS) {
/* 1361 */       Checks.check(__functionAddress);
/*      */     }
/* 1363 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1368 */     long __functionAddress = (GL.getICD()).glUniformMatrix2fv;
/* 1369 */     if (Checks.CHECKS) {
/* 1370 */       Checks.check(__functionAddress);
/*      */     }
/* 1372 */     JNI.callPV(location, value.length >> 2, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1377 */     long __functionAddress = (GL.getICD()).glUniformMatrix3fv;
/* 1378 */     if (Checks.CHECKS) {
/* 1379 */       Checks.check(__functionAddress);
/*      */     }
/* 1381 */     JNI.callPV(location, value.length / 9, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4fv(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 1386 */     long __functionAddress = (GL.getICD()).glUniformMatrix4fv;
/* 1387 */     if (Checks.CHECKS) {
/* 1388 */       Checks.check(__functionAddress);
/*      */     }
/* 1390 */     JNI.callPV(location, value.length >> 4, transpose, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderiv(@NativeType("GLuint") int shader, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1395 */     long __functionAddress = (GL.getICD()).glGetShaderiv;
/* 1396 */     if (Checks.CHECKS) {
/* 1397 */       Checks.check(__functionAddress);
/* 1398 */       Checks.check(params, 1);
/*      */     } 
/* 1400 */     JNI.callPV(shader, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramiv(@NativeType("GLuint") int program, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1405 */     long __functionAddress = (GL.getICD()).glGetProgramiv;
/* 1406 */     if (Checks.CHECKS) {
/* 1407 */       Checks.check(__functionAddress);
/* 1408 */       Checks.check(params, 1);
/*      */     } 
/* 1410 */     JNI.callPV(program, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderInfoLog(@NativeType("GLuint") int shader, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer infoLog) {
/* 1415 */     long __functionAddress = (GL.getICD()).glGetShaderInfoLog;
/* 1416 */     if (Checks.CHECKS) {
/* 1417 */       Checks.check(__functionAddress);
/* 1418 */       Checks.checkSafe(length, 1);
/*      */     } 
/* 1420 */     JNI.callPPV(shader, infoLog.remaining(), length, MemoryUtil.memAddress(infoLog), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramInfoLog(@NativeType("GLuint") int program, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer infoLog) {
/* 1425 */     long __functionAddress = (GL.getICD()).glGetProgramInfoLog;
/* 1426 */     if (Checks.CHECKS) {
/* 1427 */       Checks.check(__functionAddress);
/* 1428 */       Checks.checkSafe(length, 1);
/*      */     } 
/* 1430 */     JNI.callPPV(program, infoLog.remaining(), length, MemoryUtil.memAddress(infoLog), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetAttachedShaders(@NativeType("GLuint") int program, @NativeType("GLsizei *") int[] count, @NativeType("GLuint *") int[] shaders) {
/* 1435 */     long __functionAddress = (GL.getICD()).glGetAttachedShaders;
/* 1436 */     if (Checks.CHECKS) {
/* 1437 */       Checks.check(__functionAddress);
/* 1438 */       Checks.checkSafe(count, 1);
/*      */     } 
/* 1440 */     JNI.callPPV(program, shaders.length, count, shaders, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetActiveUniform(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] size, @NativeType("GLenum *") int[] type, @NativeType("GLchar *") ByteBuffer name) {
/* 1445 */     long __functionAddress = (GL.getICD()).glGetActiveUniform;
/* 1446 */     if (Checks.CHECKS) {
/* 1447 */       Checks.check(__functionAddress);
/* 1448 */       Checks.checkSafe(length, 1);
/* 1449 */       Checks.check(size, 1);
/* 1450 */       Checks.check(type, 1);
/*      */     } 
/* 1452 */     JNI.callPPPPV(program, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetUniformfv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLfloat *") float[] params) {
/* 1457 */     long __functionAddress = (GL.getICD()).glGetUniformfv;
/* 1458 */     if (Checks.CHECKS) {
/* 1459 */       Checks.check(__functionAddress);
/* 1460 */       Checks.check(params, 1);
/*      */     } 
/* 1462 */     JNI.callPV(program, location, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetUniformiv(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint *") int[] params) {
/* 1467 */     long __functionAddress = (GL.getICD()).glGetUniformiv;
/* 1468 */     if (Checks.CHECKS) {
/* 1469 */       Checks.check(__functionAddress);
/* 1470 */       Checks.check(params, 1);
/*      */     } 
/* 1472 */     JNI.callPV(program, location, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderSource(@NativeType("GLuint") int shader, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer source) {
/* 1477 */     long __functionAddress = (GL.getICD()).glGetShaderSource;
/* 1478 */     if (Checks.CHECKS) {
/* 1479 */       Checks.check(__functionAddress);
/* 1480 */       Checks.checkSafe(length, 1);
/*      */     } 
/* 1482 */     JNI.callPPV(shader, source.remaining(), length, MemoryUtil.memAddress(source), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1487 */     long __functionAddress = (GL.getICD()).glVertexAttrib1fv;
/* 1488 */     if (Checks.CHECKS) {
/* 1489 */       Checks.check(__functionAddress);
/* 1490 */       Checks.check(v, 1);
/*      */     } 
/* 1492 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1497 */     long __functionAddress = (GL.getICD()).glVertexAttrib1sv;
/* 1498 */     if (Checks.CHECKS) {
/* 1499 */       Checks.check(__functionAddress);
/* 1500 */       Checks.check(v, 1);
/*      */     } 
/* 1502 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1507 */     long __functionAddress = (GL.getICD()).glVertexAttrib1dv;
/* 1508 */     if (Checks.CHECKS) {
/* 1509 */       Checks.check(__functionAddress);
/* 1510 */       Checks.check(v, 1);
/*      */     } 
/* 1512 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1517 */     long __functionAddress = (GL.getICD()).glVertexAttrib2fv;
/* 1518 */     if (Checks.CHECKS) {
/* 1519 */       Checks.check(__functionAddress);
/* 1520 */       Checks.check(v, 2);
/*      */     } 
/* 1522 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1527 */     long __functionAddress = (GL.getICD()).glVertexAttrib2sv;
/* 1528 */     if (Checks.CHECKS) {
/* 1529 */       Checks.check(__functionAddress);
/* 1530 */       Checks.check(v, 2);
/*      */     } 
/* 1532 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1537 */     long __functionAddress = (GL.getICD()).glVertexAttrib2dv;
/* 1538 */     if (Checks.CHECKS) {
/* 1539 */       Checks.check(__functionAddress);
/* 1540 */       Checks.check(v, 2);
/*      */     } 
/* 1542 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1547 */     long __functionAddress = (GL.getICD()).glVertexAttrib3fv;
/* 1548 */     if (Checks.CHECKS) {
/* 1549 */       Checks.check(__functionAddress);
/* 1550 */       Checks.check(v, 3);
/*      */     } 
/* 1552 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1557 */     long __functionAddress = (GL.getICD()).glVertexAttrib3sv;
/* 1558 */     if (Checks.CHECKS) {
/* 1559 */       Checks.check(__functionAddress);
/* 1560 */       Checks.check(v, 3);
/*      */     } 
/* 1562 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1567 */     long __functionAddress = (GL.getICD()).glVertexAttrib3dv;
/* 1568 */     if (Checks.CHECKS) {
/* 1569 */       Checks.check(__functionAddress);
/* 1570 */       Checks.check(v, 3);
/*      */     } 
/* 1572 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fv(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 1577 */     long __functionAddress = (GL.getICD()).glVertexAttrib4fv;
/* 1578 */     if (Checks.CHECKS) {
/* 1579 */       Checks.check(__functionAddress);
/* 1580 */       Checks.check(v, 4);
/*      */     } 
/* 1582 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4sv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1587 */     long __functionAddress = (GL.getICD()).glVertexAttrib4sv;
/* 1588 */     if (Checks.CHECKS) {
/* 1589 */       Checks.check(__functionAddress);
/* 1590 */       Checks.check(v, 4);
/*      */     } 
/* 1592 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dv(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 1597 */     long __functionAddress = (GL.getICD()).glVertexAttrib4dv;
/* 1598 */     if (Checks.CHECKS) {
/* 1599 */       Checks.check(__functionAddress);
/* 1600 */       Checks.check(v, 4);
/*      */     } 
/* 1602 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4iv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1607 */     long __functionAddress = (GL.getICD()).glVertexAttrib4iv;
/* 1608 */     if (Checks.CHECKS) {
/* 1609 */       Checks.check(__functionAddress);
/* 1610 */       Checks.check(v, 4);
/*      */     } 
/* 1612 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usv(@NativeType("GLuint") int index, @NativeType("GLushort const *") short[] v) {
/* 1617 */     long __functionAddress = (GL.getICD()).glVertexAttrib4usv;
/* 1618 */     if (Checks.CHECKS) {
/* 1619 */       Checks.check(__functionAddress);
/* 1620 */       Checks.check(v, 4);
/*      */     } 
/* 1622 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 1627 */     long __functionAddress = (GL.getICD()).glVertexAttrib4uiv;
/* 1628 */     if (Checks.CHECKS) {
/* 1629 */       Checks.check(__functionAddress);
/* 1630 */       Checks.check(v, 4);
/*      */     } 
/* 1632 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nsv(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 1637 */     long __functionAddress = (GL.getICD()).glVertexAttrib4Nsv;
/* 1638 */     if (Checks.CHECKS) {
/* 1639 */       Checks.check(__functionAddress);
/* 1640 */       Checks.check(v, 4);
/*      */     } 
/* 1642 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Niv(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 1647 */     long __functionAddress = (GL.getICD()).glVertexAttrib4Niv;
/* 1648 */     if (Checks.CHECKS) {
/* 1649 */       Checks.check(__functionAddress);
/* 1650 */       Checks.check(v, 4);
/*      */     } 
/* 1652 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nusv(@NativeType("GLuint") int index, @NativeType("GLushort const *") short[] v) {
/* 1657 */     long __functionAddress = (GL.getICD()).glVertexAttrib4Nusv;
/* 1658 */     if (Checks.CHECKS) {
/* 1659 */       Checks.check(__functionAddress);
/* 1660 */       Checks.check(v, 4);
/*      */     } 
/* 1662 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nuiv(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 1667 */     long __functionAddress = (GL.getICD()).glVertexAttrib4Nuiv;
/* 1668 */     if (Checks.CHECKS) {
/* 1669 */       Checks.check(__functionAddress);
/* 1670 */       Checks.check(v, 4);
/*      */     } 
/* 1672 */     JNI.callPV(index, v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetActiveAttrib(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] size, @NativeType("GLenum *") int[] type, @NativeType("GLchar *") ByteBuffer name) {
/* 1677 */     long __functionAddress = (GL.getICD()).glGetActiveAttrib;
/* 1678 */     if (Checks.CHECKS) {
/* 1679 */       Checks.check(__functionAddress);
/* 1680 */       Checks.checkSafe(length, 1);
/* 1681 */       Checks.check(size, 1);
/* 1682 */       Checks.check(type, 1);
/*      */     } 
/* 1684 */     JNI.callPPPPV(program, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribiv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 1689 */     long __functionAddress = (GL.getICD()).glGetVertexAttribiv;
/* 1690 */     if (Checks.CHECKS) {
/* 1691 */       Checks.check(__functionAddress);
/* 1692 */       Checks.check(params, 1);
/*      */     } 
/* 1694 */     JNI.callPV(index, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 1699 */     long __functionAddress = (GL.getICD()).glGetVertexAttribfv;
/* 1700 */     if (Checks.CHECKS) {
/* 1701 */       Checks.check(__functionAddress);
/* 1702 */       Checks.check(params, 4);
/*      */     } 
/* 1704 */     JNI.callPV(index, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdv(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 1709 */     long __functionAddress = (GL.getICD()).glGetVertexAttribdv;
/* 1710 */     if (Checks.CHECKS) {
/* 1711 */       Checks.check(__functionAddress);
/* 1712 */       Checks.check(params, 4);
/*      */     } 
/* 1714 */     JNI.callPV(index, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") int[] bufs) {
/* 1719 */     long __functionAddress = (GL.getICD()).glDrawBuffers;
/* 1720 */     if (Checks.CHECKS) {
/* 1721 */       Checks.check(__functionAddress);
/*      */     }
/* 1723 */     JNI.callPV(bufs.length, bufs, __functionAddress);
/*      */   }
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static native int glCreateProgram();
/*      */   
/*      */   public static native void glDeleteProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static native int glCreateShader(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glDeleteShader(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsShader(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glAttachShader(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDetachShader(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglShaderSource(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glCompileShader(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glLinkProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glUseProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glValidateProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glUniform1f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glUniform2f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glUniform3f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glUniform4f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glUniform1i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glUniform2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glUniform3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glUniform4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void nglUniform1fv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform2fv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform3fv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform4fv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform1iv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform2iv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform3iv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform4iv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglGetShaderiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetShaderInfoLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglGetProgramInfoLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglGetAttachedShaders(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nglGetUniformLocation(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetActiveUniform(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void nglGetUniformfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetUniformiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetShaderSource(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glVertexAttrib1f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glVertexAttrib1s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort);
/*      */   
/*      */   public static native void glVertexAttrib1d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glVertexAttrib2f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glVertexAttrib2s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glVertexAttrib2d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glVertexAttrib3f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glVertexAttrib3s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glVertexAttrib3d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glVertexAttrib4f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glVertexAttrib4s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glVertexAttrib4d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glVertexAttrib4Nub(@NativeType("GLuint") int paramInt, @NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3, @NativeType("GLubyte") byte paramByte4);
/*      */   
/*      */   public static native void nglVertexAttrib1fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib1sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib1dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib2fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib2sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib2dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib3fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib3sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib3dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4bv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4ubv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4usv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nbv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nsv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Niv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nubv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nusv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nuiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glEnableVertexAttribArray(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glDisableVertexAttribArray(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglBindAttribLocation(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetActiveAttrib(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nglGetAttribLocation(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribdv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribPointerv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglDrawBuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glBlendEquationSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glStencilOpSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4);
/*      */   
/*      */   public static native void glStencilFuncSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glStencilMaskSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL20C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */