/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBShaderObjects
/*     */ {
/*     */   public static final int GL_PROGRAM_OBJECT_ARB = 35648;
/*     */   public static final int GL_OBJECT_TYPE_ARB = 35662;
/*     */   public static final int GL_OBJECT_SUBTYPE_ARB = 35663;
/*     */   public static final int GL_OBJECT_DELETE_STATUS_ARB = 35712;
/*     */   
/*     */   static {
/*  23 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_OBJECT_COMPILE_STATUS_ARB = 35713;
/*     */   
/*     */   public static final int GL_OBJECT_LINK_STATUS_ARB = 35714;
/*     */   
/*     */   public static final int GL_OBJECT_VALIDATE_STATUS_ARB = 35715;
/*     */   
/*     */   public static final int GL_OBJECT_INFO_LOG_LENGTH_ARB = 35716;
/*     */   
/*     */   public static final int GL_OBJECT_ATTACHED_OBJECTS_ARB = 35717;
/*     */   
/*     */   public static final int GL_OBJECT_ACTIVE_UNIFORMS_ARB = 35718;
/*     */   
/*     */   public static final int GL_OBJECT_ACTIVE_UNIFORM_MAX_LENGTH_ARB = 35719;
/*     */   
/*     */   public static final int GL_OBJECT_SHADER_SOURCE_LENGTH_ARB = 35720;
/*     */   public static final int GL_SHADER_OBJECT_ARB = 35656;
/*     */   public static final int GL_FLOAT_VEC2_ARB = 35664;
/*     */   public static final int GL_FLOAT_VEC3_ARB = 35665;
/*     */   public static final int GL_FLOAT_VEC4_ARB = 35666;
/*     */   public static final int GL_INT_VEC2_ARB = 35667;
/*     */   public static final int GL_INT_VEC3_ARB = 35668;
/*     */   public static final int GL_INT_VEC4_ARB = 35669;
/*     */   public static final int GL_BOOL_ARB = 35670;
/*     */   public static final int GL_BOOL_VEC2_ARB = 35671;
/*     */   public static final int GL_BOOL_VEC3_ARB = 35672;
/*     */   public static final int GL_BOOL_VEC4_ARB = 35673;
/*     */   public static final int GL_FLOAT_MAT2_ARB = 35674;
/*     */   public static final int GL_FLOAT_MAT3_ARB = 35675;
/*     */   public static final int GL_FLOAT_MAT4_ARB = 35676;
/*     */   public static final int GL_SAMPLER_1D_ARB = 35677;
/*     */   public static final int GL_SAMPLER_2D_ARB = 35678;
/*     */   public static final int GL_SAMPLER_3D_ARB = 35679;
/*     */   public static final int GL_SAMPLER_CUBE_ARB = 35680;
/*     */   public static final int GL_SAMPLER_1D_SHADOW_ARB = 35681;
/*     */   public static final int GL_SAMPLER_2D_SHADOW_ARB = 35682;
/*     */   public static final int GL_SAMPLER_2D_RECT_ARB = 35683;
/*     */   public static final int GL_SAMPLER_2D_RECT_SHADOW_ARB = 35684;
/*     */   
/*     */   protected ARBShaderObjects() {
/*  66 */     throw new UnsupportedOperationException();
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
/*     */   public static void glShaderSourceARB(@NativeType("GLhandleARB") int shaderObj, @NativeType("GLcharARB const **") PointerBuffer string, @NativeType("GLint const *") IntBuffer length) {
/*  98 */     if (Checks.CHECKS) {
/*  99 */       Checks.checkSafe(length, string.remaining());
/*     */     }
/* 101 */     nglShaderSourceARB(shaderObj, string.remaining(), MemoryUtil.memAddress((CustomBuffer)string), MemoryUtil.memAddressSafe(length));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShaderSourceARB(@NativeType("GLhandleARB") int shaderObj, @NativeType("GLcharARB const **") CharSequence... string) {
/* 106 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 108 */       long stringAddress = APIUtil.apiArrayi(stack, MemoryUtil::memUTF8, string);
/* 109 */       nglShaderSourceARB(shaderObj, string.length, stringAddress, stringAddress - (string.length << 2));
/* 110 */       APIUtil.apiArrayFree(stringAddress, string.length);
/*     */     } finally {
/* 112 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShaderSourceARB(@NativeType("GLhandleARB") int shaderObj, @NativeType("GLcharARB const **") CharSequence string) {
/* 118 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 120 */       long stringAddress = APIUtil.apiArrayi(stack, MemoryUtil::memUTF8, new CharSequence[] { string });
/* 121 */       nglShaderSourceARB(shaderObj, 1, stringAddress, stringAddress - 4L);
/* 122 */       APIUtil.apiArrayFree(stringAddress, 1);
/*     */     } finally {
/* 124 */       stack.setPointer(stackPointer);
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
/*     */   public static void glUniform1fvARB(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 206 */     nglUniform1fvARB(location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2fvARB(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 216 */     nglUniform2fvARB(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3fvARB(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 226 */     nglUniform3fvARB(location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4fvARB(@NativeType("GLint") int location, @NativeType("GLfloat const *") FloatBuffer value) {
/* 236 */     nglUniform4fvARB(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform1ivARB(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 246 */     nglUniform1ivARB(location, value.remaining(), MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2ivARB(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 256 */     nglUniform2ivARB(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3ivARB(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 266 */     nglUniform3ivARB(location, value.remaining() / 3, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4ivARB(@NativeType("GLint") int location, @NativeType("GLint const *") IntBuffer value) {
/* 276 */     nglUniform4ivARB(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2fvARB(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 286 */     nglUniformMatrix2fvARB(location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3fvARB(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 296 */     nglUniformMatrix3fvARB(location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4fvARB(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") FloatBuffer value) {
/* 306 */     nglUniformMatrix4fvARB(location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetObjectParameterfvARB(@NativeType("GLhandleARB") int obj, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 316 */     if (Checks.CHECKS) {
/* 317 */       Checks.check(params, 1);
/*     */     }
/* 319 */     nglGetObjectParameterfvARB(obj, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetObjectParameterivARB(@NativeType("GLhandleARB") int obj, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 329 */     if (Checks.CHECKS) {
/* 330 */       Checks.check(params, 1);
/*     */     }
/* 332 */     nglGetObjectParameterivARB(obj, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetObjectParameteriARB(@NativeType("GLhandleARB") int obj, @NativeType("GLenum") int pname) {
/* 338 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 340 */       IntBuffer params = stack.callocInt(1);
/* 341 */       nglGetObjectParameterivARB(obj, pname, MemoryUtil.memAddress(params));
/* 342 */       return params.get(0);
/*     */     } finally {
/* 344 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetInfoLogARB(@NativeType("GLhandleARB") int obj, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLcharARB *") ByteBuffer infoLog) {
/* 355 */     if (Checks.CHECKS) {
/* 356 */       Checks.checkSafe(length, 1);
/*     */     }
/* 358 */     nglGetInfoLogARB(obj, infoLog.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(infoLog));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetInfoLogARB(@NativeType("GLhandleARB") int obj, @NativeType("GLsizei") int maxLength) {
/* 364 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 365 */     ByteBuffer infoLog = MemoryUtil.memAlloc(maxLength);
/*     */     try {
/* 367 */       IntBuffer length = stack.ints(0);
/* 368 */       nglGetInfoLogARB(obj, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(infoLog));
/* 369 */       return MemoryUtil.memUTF8(infoLog, length.get(0));
/*     */     } finally {
/* 371 */       MemoryUtil.memFree(infoLog);
/* 372 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetInfoLogARB(@NativeType("GLhandleARB") int obj) {
/* 379 */     return glGetInfoLogARB(obj, glGetObjectParameteriARB(obj, 35716));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetAttachedObjectsARB(@NativeType("GLhandleARB") int containerObj, @NativeType("GLsizei *") IntBuffer count, @NativeType("GLhandleARB *") IntBuffer obj) {
/* 389 */     if (Checks.CHECKS) {
/* 390 */       Checks.checkSafe(count, 1);
/*     */     }
/* 392 */     nglGetAttachedObjectsARB(containerObj, obj.remaining(), MemoryUtil.memAddressSafe(count), MemoryUtil.memAddress(obj));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetUniformLocationARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLcharARB const *") ByteBuffer name) {
/* 403 */     if (Checks.CHECKS) {
/* 404 */       Checks.checkNT1(name);
/*     */     }
/* 406 */     return nglGetUniformLocationARB(programObj, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetUniformLocationARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLcharARB const *") CharSequence name) {
/* 412 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 414 */       stack.nUTF8(name, true);
/* 415 */       long nameEncoded = stack.getPointerAddress();
/* 416 */       return nglGetUniformLocationARB(programObj, nameEncoded);
/*     */     } finally {
/* 418 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type, @NativeType("GLcharARB *") ByteBuffer name) {
/* 429 */     if (Checks.CHECKS) {
/* 430 */       Checks.checkSafe(length, 1);
/* 431 */       Checks.check(size, 1);
/* 432 */       Checks.check(type, 1);
/*     */     } 
/* 434 */     nglGetActiveUniformARB(programObj, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLsizei") int maxLength, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 440 */     if (Checks.CHECKS) {
/* 441 */       Checks.check(size, 1);
/* 442 */       Checks.check(type, 1);
/*     */     } 
/* 444 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 446 */       IntBuffer length = stack.ints(0);
/* 447 */       ByteBuffer name = stack.malloc(maxLength);
/* 448 */       nglGetActiveUniformARB(programObj, index, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/* 449 */       return MemoryUtil.memUTF8(name, length.get(0));
/*     */     } finally {
/* 451 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 458 */     return glGetActiveUniformARB(programObj, index, glGetObjectParameteriARB(programObj, 35719), size, type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformfvARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLint") int location, @NativeType("GLfloat *") FloatBuffer params) {
/* 468 */     if (Checks.CHECKS) {
/* 469 */       Checks.check(params, 1);
/*     */     }
/* 471 */     nglGetUniformfvARB(programObj, location, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetUniformfARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLint") int location) {
/* 477 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 479 */       FloatBuffer params = stack.callocFloat(1);
/* 480 */       nglGetUniformfvARB(programObj, location, MemoryUtil.memAddress(params));
/* 481 */       return params.get(0);
/*     */     } finally {
/* 483 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformivARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLint") int location, @NativeType("GLint *") IntBuffer params) {
/* 494 */     if (Checks.CHECKS) {
/* 495 */       Checks.check(params, 1);
/*     */     }
/* 497 */     nglGetUniformivARB(programObj, location, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformiARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLint") int location) {
/* 503 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 505 */       IntBuffer params = stack.callocInt(1);
/* 506 */       nglGetUniformivARB(programObj, location, MemoryUtil.memAddress(params));
/* 507 */       return params.get(0);
/*     */     } finally {
/* 509 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetShaderSourceARB(@NativeType("GLhandleARB") int obj, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLcharARB *") ByteBuffer source) {
/* 520 */     if (Checks.CHECKS) {
/* 521 */       Checks.checkSafe(length, 1);
/*     */     }
/* 523 */     nglGetShaderSourceARB(obj, source.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(source));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetShaderSourceARB(@NativeType("GLhandleARB") int obj, @NativeType("GLsizei") int maxLength) {
/* 529 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 530 */     ByteBuffer source = MemoryUtil.memAlloc(maxLength);
/*     */     try {
/* 532 */       IntBuffer length = stack.ints(0);
/* 533 */       nglGetShaderSourceARB(obj, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(source));
/* 534 */       return MemoryUtil.memUTF8(source, length.get(0));
/*     */     } finally {
/* 536 */       MemoryUtil.memFree(source);
/* 537 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetShaderSourceARB(@NativeType("GLhandleARB") int obj) {
/* 544 */     return glGetShaderSourceARB(obj, glGetObjectParameteriARB(obj, 35720));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShaderSourceARB(@NativeType("GLhandleARB") int shaderObj, @NativeType("GLcharARB const **") PointerBuffer string, @NativeType("GLint const *") int[] length) {
/* 549 */     long __functionAddress = (GL.getICD()).glShaderSourceARB;
/* 550 */     if (Checks.CHECKS) {
/* 551 */       Checks.check(__functionAddress);
/* 552 */       Checks.checkSafe(length, string.remaining());
/*     */     } 
/* 554 */     JNI.callPPV(shaderObj, string.remaining(), MemoryUtil.memAddress((CustomBuffer)string), length, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1fvARB(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 559 */     long __functionAddress = (GL.getICD()).glUniform1fvARB;
/* 560 */     if (Checks.CHECKS) {
/* 561 */       Checks.check(__functionAddress);
/*     */     }
/* 563 */     JNI.callPV(location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2fvARB(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 568 */     long __functionAddress = (GL.getICD()).glUniform2fvARB;
/* 569 */     if (Checks.CHECKS) {
/* 570 */       Checks.check(__functionAddress);
/*     */     }
/* 572 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3fvARB(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 577 */     long __functionAddress = (GL.getICD()).glUniform3fvARB;
/* 578 */     if (Checks.CHECKS) {
/* 579 */       Checks.check(__functionAddress);
/*     */     }
/* 581 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4fvARB(@NativeType("GLint") int location, @NativeType("GLfloat const *") float[] value) {
/* 586 */     long __functionAddress = (GL.getICD()).glUniform4fvARB;
/* 587 */     if (Checks.CHECKS) {
/* 588 */       Checks.check(__functionAddress);
/*     */     }
/* 590 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1ivARB(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 595 */     long __functionAddress = (GL.getICD()).glUniform1ivARB;
/* 596 */     if (Checks.CHECKS) {
/* 597 */       Checks.check(__functionAddress);
/*     */     }
/* 599 */     JNI.callPV(location, value.length, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2ivARB(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 604 */     long __functionAddress = (GL.getICD()).glUniform2ivARB;
/* 605 */     if (Checks.CHECKS) {
/* 606 */       Checks.check(__functionAddress);
/*     */     }
/* 608 */     JNI.callPV(location, value.length >> 1, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3ivARB(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 613 */     long __functionAddress = (GL.getICD()).glUniform3ivARB;
/* 614 */     if (Checks.CHECKS) {
/* 615 */       Checks.check(__functionAddress);
/*     */     }
/* 617 */     JNI.callPV(location, value.length / 3, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4ivARB(@NativeType("GLint") int location, @NativeType("GLint const *") int[] value) {
/* 622 */     long __functionAddress = (GL.getICD()).glUniform4ivARB;
/* 623 */     if (Checks.CHECKS) {
/* 624 */       Checks.check(__functionAddress);
/*     */     }
/* 626 */     JNI.callPV(location, value.length >> 2, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2fvARB(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 631 */     long __functionAddress = (GL.getICD()).glUniformMatrix2fvARB;
/* 632 */     if (Checks.CHECKS) {
/* 633 */       Checks.check(__functionAddress);
/*     */     }
/* 635 */     JNI.callPV(location, value.length >> 2, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3fvARB(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 640 */     long __functionAddress = (GL.getICD()).glUniformMatrix3fvARB;
/* 641 */     if (Checks.CHECKS) {
/* 642 */       Checks.check(__functionAddress);
/*     */     }
/* 644 */     JNI.callPV(location, value.length / 9, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4fvARB(@NativeType("GLint") int location, @NativeType("GLboolean") boolean transpose, @NativeType("GLfloat const *") float[] value) {
/* 649 */     long __functionAddress = (GL.getICD()).glUniformMatrix4fvARB;
/* 650 */     if (Checks.CHECKS) {
/* 651 */       Checks.check(__functionAddress);
/*     */     }
/* 653 */     JNI.callPV(location, value.length >> 4, transpose, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetObjectParameterfvARB(@NativeType("GLhandleARB") int obj, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 658 */     long __functionAddress = (GL.getICD()).glGetObjectParameterfvARB;
/* 659 */     if (Checks.CHECKS) {
/* 660 */       Checks.check(__functionAddress);
/* 661 */       Checks.check(params, 1);
/*     */     } 
/* 663 */     JNI.callPV(obj, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetObjectParameterivARB(@NativeType("GLhandleARB") int obj, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 668 */     long __functionAddress = (GL.getICD()).glGetObjectParameterivARB;
/* 669 */     if (Checks.CHECKS) {
/* 670 */       Checks.check(__functionAddress);
/* 671 */       Checks.check(params, 1);
/*     */     } 
/* 673 */     JNI.callPV(obj, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInfoLogARB(@NativeType("GLhandleARB") int obj, @NativeType("GLsizei *") int[] length, @NativeType("GLcharARB *") ByteBuffer infoLog) {
/* 678 */     long __functionAddress = (GL.getICD()).glGetInfoLogARB;
/* 679 */     if (Checks.CHECKS) {
/* 680 */       Checks.check(__functionAddress);
/* 681 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 683 */     JNI.callPPV(obj, infoLog.remaining(), length, MemoryUtil.memAddress(infoLog), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetAttachedObjectsARB(@NativeType("GLhandleARB") int containerObj, @NativeType("GLsizei *") int[] count, @NativeType("GLhandleARB *") int[] obj) {
/* 688 */     long __functionAddress = (GL.getICD()).glGetAttachedObjectsARB;
/* 689 */     if (Checks.CHECKS) {
/* 690 */       Checks.check(__functionAddress);
/* 691 */       Checks.checkSafe(count, 1);
/*     */     } 
/* 693 */     JNI.callPPV(containerObj, obj.length, count, obj, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] size, @NativeType("GLenum *") int[] type, @NativeType("GLcharARB *") ByteBuffer name) {
/* 698 */     long __functionAddress = (GL.getICD()).glGetActiveUniformARB;
/* 699 */     if (Checks.CHECKS) {
/* 700 */       Checks.check(__functionAddress);
/* 701 */       Checks.checkSafe(length, 1);
/* 702 */       Checks.check(size, 1);
/* 703 */       Checks.check(type, 1);
/*     */     } 
/* 705 */     JNI.callPPPPV(programObj, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformfvARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLint") int location, @NativeType("GLfloat *") float[] params) {
/* 710 */     long __functionAddress = (GL.getICD()).glGetUniformfvARB;
/* 711 */     if (Checks.CHECKS) {
/* 712 */       Checks.check(__functionAddress);
/* 713 */       Checks.check(params, 1);
/*     */     } 
/* 715 */     JNI.callPV(programObj, location, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformivARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLint") int location, @NativeType("GLint *") int[] params) {
/* 720 */     long __functionAddress = (GL.getICD()).glGetUniformivARB;
/* 721 */     if (Checks.CHECKS) {
/* 722 */       Checks.check(__functionAddress);
/* 723 */       Checks.check(params, 1);
/*     */     } 
/* 725 */     JNI.callPV(programObj, location, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetShaderSourceARB(@NativeType("GLhandleARB") int obj, @NativeType("GLsizei *") int[] length, @NativeType("GLcharARB *") ByteBuffer source) {
/* 730 */     long __functionAddress = (GL.getICD()).glGetShaderSourceARB;
/* 731 */     if (Checks.CHECKS) {
/* 732 */       Checks.check(__functionAddress);
/* 733 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 735 */     JNI.callPPV(obj, source.remaining(), length, MemoryUtil.memAddress(source), __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glDeleteObjectARB(@NativeType("GLhandleARB") int paramInt);
/*     */   
/*     */   @NativeType("GLhandleARB")
/*     */   public static native int glGetHandleARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glDetachObjectARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLhandleARB") int paramInt2);
/*     */   
/*     */   @NativeType("GLhandleARB")
/*     */   public static native int glCreateShaderObjectARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglShaderSourceARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void glCompileShaderARB(@NativeType("GLhandleARB") int paramInt);
/*     */   
/*     */   @NativeType("GLhandleARB")
/*     */   public static native int glCreateProgramObjectARB();
/*     */   
/*     */   public static native void glAttachObjectARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLhandleARB") int paramInt2);
/*     */   
/*     */   public static native void glLinkProgramARB(@NativeType("GLhandleARB") int paramInt);
/*     */   
/*     */   public static native void glUseProgramObjectARB(@NativeType("GLhandleARB") int paramInt);
/*     */   
/*     */   public static native void glValidateProgramARB(@NativeType("GLhandleARB") int paramInt);
/*     */   
/*     */   public static native void glUniform1fARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void glUniform2fARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */   
/*     */   public static native void glUniform3fARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glUniform4fARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*     */   
/*     */   public static native void glUniform1iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void glUniform2iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glUniform3iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glUniform4iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void nglUniform1fvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform2fvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform3fvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform4fvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform1ivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform2ivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform3ivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform4ivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix2fvARB(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix3fvARB(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix4fvARB(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglGetObjectParameterfvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetObjectParameterivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetInfoLogARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetAttachedObjectsARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nglGetUniformLocationARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveUniformARB(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native void nglGetUniformfvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetShaderSourceARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBShaderObjects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */