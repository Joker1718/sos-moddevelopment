/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBVertexShader
/*     */ {
/*     */   public static final int GL_VERTEX_SHADER_ARB = 35633;
/*     */   public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS_ARB = 35658;
/*     */   public static final int GL_MAX_VARYING_FLOATS_ARB = 35659;
/*     */   
/*     */   static {
/*  23 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
/*     */   
/*     */   public static final int GL_MAX_TEXTURE_IMAGE_UNITS_ARB = 34930;
/*     */   
/*     */   public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS_ARB = 35660;
/*     */   
/*     */   public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS_ARB = 35661;
/*     */   
/*     */   public static final int GL_MAX_TEXTURE_COORDS_ARB = 34929;
/*     */   
/*     */   public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
/*     */   
/*     */   public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
/*     */   
/*     */   public static final int GL_OBJECT_ACTIVE_ATTRIBUTES_ARB = 35721;
/*     */   
/*     */   public static final int GL_OBJECT_ACTIVE_ATTRIBUTE_MAX_LENGTH_ARB = 35722;
/*     */   
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
/*     */   
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
/*     */   
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
/*     */   
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
/*     */   public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
/*     */   public static final int GL_FLOAT_VEC2_ARB = 35664;
/*     */   public static final int GL_FLOAT_VEC3_ARB = 35665;
/*     */   public static final int GL_FLOAT_VEC4_ARB = 35666;
/*     */   public static final int GL_FLOAT_MAT2_ARB = 35674;
/*     */   public static final int GL_FLOAT_MAT3_ARB = 35675;
/*     */   public static final int GL_FLOAT_MAT4_ARB = 35676;
/*     */   
/*     */   protected ARBVertexShader() {
/*  63 */     throw new UnsupportedOperationException();
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
/*     */   public static void glVertexAttrib1fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/* 138 */     if (Checks.CHECKS) {
/* 139 */       Checks.check(v, 1);
/*     */     }
/* 141 */     nglVertexAttrib1fvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib1svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/* 151 */     if (Checks.CHECKS) {
/* 152 */       Checks.check(v, 1);
/*     */     }
/* 154 */     nglVertexAttrib1svARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib1dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(v, 1);
/*     */     }
/* 167 */     nglVertexAttrib1dvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib2fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/* 177 */     if (Checks.CHECKS) {
/* 178 */       Checks.check(v, 2);
/*     */     }
/* 180 */     nglVertexAttrib2fvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib2svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/* 190 */     if (Checks.CHECKS) {
/* 191 */       Checks.check(v, 2);
/*     */     }
/* 193 */     nglVertexAttrib2svARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib2dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 203 */     if (Checks.CHECKS) {
/* 204 */       Checks.check(v, 2);
/*     */     }
/* 206 */     nglVertexAttrib2dvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib3fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/* 216 */     if (Checks.CHECKS) {
/* 217 */       Checks.check(v, 3);
/*     */     }
/* 219 */     nglVertexAttrib3fvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib3svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/* 229 */     if (Checks.CHECKS) {
/* 230 */       Checks.check(v, 3);
/*     */     }
/* 232 */     nglVertexAttrib3svARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib3dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 242 */     if (Checks.CHECKS) {
/* 243 */       Checks.check(v, 3);
/*     */     }
/* 245 */     nglVertexAttrib3dvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer v) {
/* 255 */     if (Checks.CHECKS) {
/* 256 */       Checks.check(v, 4);
/*     */     }
/* 258 */     nglVertexAttrib4fvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/* 268 */     if (Checks.CHECKS) {
/* 269 */       Checks.check(v, 4);
/*     */     }
/* 271 */     nglVertexAttrib4svARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 281 */     if (Checks.CHECKS) {
/* 282 */       Checks.check(v, 4);
/*     */     }
/* 284 */     nglVertexAttrib4dvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4ivARB(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/* 294 */     if (Checks.CHECKS) {
/* 295 */       Checks.check(v, 4);
/*     */     }
/* 297 */     nglVertexAttrib4ivARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4bvARB(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/* 307 */     if (Checks.CHECKS) {
/* 308 */       Checks.check(v, 4);
/*     */     }
/* 310 */     nglVertexAttrib4bvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4ubvARB(@NativeType("GLuint") int index, @NativeType("GLubyte const *") ByteBuffer v) {
/* 320 */     if (Checks.CHECKS) {
/* 321 */       Checks.check(v, 4);
/*     */     }
/* 323 */     nglVertexAttrib4ubvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4usvARB(@NativeType("GLuint") int index, @NativeType("GLushort const *") ShortBuffer v) {
/* 333 */     if (Checks.CHECKS) {
/* 334 */       Checks.check(v, 4);
/*     */     }
/* 336 */     nglVertexAttrib4usvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4uivARB(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/* 346 */     if (Checks.CHECKS) {
/* 347 */       Checks.check(v, 4);
/*     */     }
/* 349 */     nglVertexAttrib4uivARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NbvARB(@NativeType("GLuint") int index, @NativeType("GLbyte const *") ByteBuffer v) {
/* 359 */     if (Checks.CHECKS) {
/* 360 */       Checks.check(v, 4);
/*     */     }
/* 362 */     nglVertexAttrib4NbvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NsvARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") ShortBuffer v) {
/* 372 */     if (Checks.CHECKS) {
/* 373 */       Checks.check(v, 4);
/*     */     }
/* 375 */     nglVertexAttrib4NsvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NivARB(@NativeType("GLuint") int index, @NativeType("GLint const *") IntBuffer v) {
/* 385 */     if (Checks.CHECKS) {
/* 386 */       Checks.check(v, 4);
/*     */     }
/* 388 */     nglVertexAttrib4NivARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NubvARB(@NativeType("GLuint") int index, @NativeType("GLubyte const *") ByteBuffer v) {
/* 398 */     if (Checks.CHECKS) {
/* 399 */       Checks.check(v, 4);
/*     */     }
/* 401 */     nglVertexAttrib4NubvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NusvARB(@NativeType("GLuint") int index, @NativeType("GLushort const *") ShortBuffer v) {
/* 411 */     if (Checks.CHECKS) {
/* 412 */       Checks.check(v, 4);
/*     */     }
/* 414 */     nglVertexAttrib4NusvARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NuivARB(@NativeType("GLuint") int index, @NativeType("GLuint const *") IntBuffer v) {
/* 424 */     if (Checks.CHECKS) {
/* 425 */       Checks.check(v, 4);
/*     */     }
/* 427 */     nglVertexAttrib4NuivARB(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 437 */     nglVertexAttribPointerARB(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 442 */     nglVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 447 */     nglVertexAttribPointerARB(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 452 */     nglVertexAttribPointerARB(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 457 */     nglVertexAttribPointerARB(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
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
/*     */   public static void glBindAttribLocationARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLchar const *") ByteBuffer name) {
/* 477 */     if (Checks.CHECKS) {
/* 478 */       Checks.checkNT1(name);
/*     */     }
/* 480 */     nglBindAttribLocationARB(programObj, index, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindAttribLocationARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLchar const *") CharSequence name) {
/* 485 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 487 */       stack.nASCII(name, true);
/* 488 */       long nameEncoded = stack.getPointerAddress();
/* 489 */       nglBindAttribLocationARB(programObj, index, nameEncoded);
/*     */     } finally {
/* 491 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveAttribARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type, @NativeType("GLchar *") ByteBuffer name) {
/* 502 */     if (Checks.CHECKS) {
/* 503 */       Checks.checkSafe(length, 1);
/* 504 */       Checks.check(size, 1);
/* 505 */       Checks.check(type, 1);
/*     */     } 
/* 507 */     nglGetActiveAttribARB(programObj, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveAttribARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLsizei") int maxLength, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 513 */     if (Checks.CHECKS) {
/* 514 */       Checks.check(size, 1);
/* 515 */       Checks.check(type, 1);
/*     */     } 
/* 517 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 519 */       IntBuffer length = stack.ints(0);
/* 520 */       ByteBuffer name = stack.malloc(maxLength);
/* 521 */       nglGetActiveAttribARB(programObj, index, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/* 522 */       return MemoryUtil.memASCII(name, length.get(0));
/*     */     } finally {
/* 524 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveAttribARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer size, @NativeType("GLenum *") IntBuffer type) {
/* 531 */     return glGetActiveAttribARB(programObj, index, ARBShaderObjects.glGetObjectParameteriARB(programObj, 35722), size, type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetAttribLocationARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLchar const *") ByteBuffer name) {
/* 542 */     if (Checks.CHECKS) {
/* 543 */       Checks.checkNT1(name);
/*     */     }
/* 545 */     return nglGetAttribLocationARB(programObj, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetAttribLocationARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLchar const *") CharSequence name) {
/* 551 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 553 */       stack.nASCII(name, true);
/* 554 */       long nameEncoded = stack.getPointerAddress();
/* 555 */       return nglGetAttribLocationARB(programObj, nameEncoded);
/*     */     } finally {
/* 557 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribivARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 568 */     if (Checks.CHECKS) {
/* 569 */       Checks.check(params, 1);
/*     */     }
/* 571 */     nglGetVertexAttribivARB(index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetVertexAttribiARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 577 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 579 */       IntBuffer params = stack.callocInt(1);
/* 580 */       nglGetVertexAttribivARB(index, pname, MemoryUtil.memAddress(params));
/* 581 */       return params.get(0);
/*     */     } finally {
/* 583 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribfvARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 594 */     if (Checks.CHECKS) {
/* 595 */       Checks.check(params, 4);
/*     */     }
/* 597 */     nglGetVertexAttribfvARB(index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribdvARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/* 607 */     if (Checks.CHECKS) {
/* 608 */       Checks.check(params, 4);
/*     */     }
/* 610 */     nglGetVertexAttribdvARB(index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribPointervARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer pointer) {
/* 620 */     if (Checks.CHECKS) {
/* 621 */       Checks.check((CustomBuffer)pointer, 1);
/*     */     }
/* 623 */     nglGetVertexAttribPointervARB(index, pname, MemoryUtil.memAddress((CustomBuffer)pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 629 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 631 */       PointerBuffer pointer = stack.callocPointer(1);
/* 632 */       nglGetVertexAttribPointervARB(index, pname, MemoryUtil.memAddress((CustomBuffer)pointer));
/* 633 */       return pointer.get(0);
/*     */     } finally {
/* 635 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib1fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 641 */     long __functionAddress = (GL.getICD()).glVertexAttrib1fvARB;
/* 642 */     if (Checks.CHECKS) {
/* 643 */       Checks.check(__functionAddress);
/* 644 */       Checks.check(v, 1);
/*     */     } 
/* 646 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib1svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 651 */     long __functionAddress = (GL.getICD()).glVertexAttrib1svARB;
/* 652 */     if (Checks.CHECKS) {
/* 653 */       Checks.check(__functionAddress);
/* 654 */       Checks.check(v, 1);
/*     */     } 
/* 656 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib1dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 661 */     long __functionAddress = (GL.getICD()).glVertexAttrib1dvARB;
/* 662 */     if (Checks.CHECKS) {
/* 663 */       Checks.check(__functionAddress);
/* 664 */       Checks.check(v, 1);
/*     */     } 
/* 666 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib2fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 671 */     long __functionAddress = (GL.getICD()).glVertexAttrib2fvARB;
/* 672 */     if (Checks.CHECKS) {
/* 673 */       Checks.check(__functionAddress);
/* 674 */       Checks.check(v, 2);
/*     */     } 
/* 676 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib2svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 681 */     long __functionAddress = (GL.getICD()).glVertexAttrib2svARB;
/* 682 */     if (Checks.CHECKS) {
/* 683 */       Checks.check(__functionAddress);
/* 684 */       Checks.check(v, 2);
/*     */     } 
/* 686 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib2dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 691 */     long __functionAddress = (GL.getICD()).glVertexAttrib2dvARB;
/* 692 */     if (Checks.CHECKS) {
/* 693 */       Checks.check(__functionAddress);
/* 694 */       Checks.check(v, 2);
/*     */     } 
/* 696 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib3fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 701 */     long __functionAddress = (GL.getICD()).glVertexAttrib3fvARB;
/* 702 */     if (Checks.CHECKS) {
/* 703 */       Checks.check(__functionAddress);
/* 704 */       Checks.check(v, 3);
/*     */     } 
/* 706 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib3svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 711 */     long __functionAddress = (GL.getICD()).glVertexAttrib3svARB;
/* 712 */     if (Checks.CHECKS) {
/* 713 */       Checks.check(__functionAddress);
/* 714 */       Checks.check(v, 3);
/*     */     } 
/* 716 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib3dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 721 */     long __functionAddress = (GL.getICD()).glVertexAttrib3dvARB;
/* 722 */     if (Checks.CHECKS) {
/* 723 */       Checks.check(__functionAddress);
/* 724 */       Checks.check(v, 3);
/*     */     } 
/* 726 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4fvARB(@NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] v) {
/* 731 */     long __functionAddress = (GL.getICD()).glVertexAttrib4fvARB;
/* 732 */     if (Checks.CHECKS) {
/* 733 */       Checks.check(__functionAddress);
/* 734 */       Checks.check(v, 4);
/*     */     } 
/* 736 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4svARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 741 */     long __functionAddress = (GL.getICD()).glVertexAttrib4svARB;
/* 742 */     if (Checks.CHECKS) {
/* 743 */       Checks.check(__functionAddress);
/* 744 */       Checks.check(v, 4);
/*     */     } 
/* 746 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4dvARB(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 751 */     long __functionAddress = (GL.getICD()).glVertexAttrib4dvARB;
/* 752 */     if (Checks.CHECKS) {
/* 753 */       Checks.check(__functionAddress);
/* 754 */       Checks.check(v, 4);
/*     */     } 
/* 756 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4ivARB(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 761 */     long __functionAddress = (GL.getICD()).glVertexAttrib4ivARB;
/* 762 */     if (Checks.CHECKS) {
/* 763 */       Checks.check(__functionAddress);
/* 764 */       Checks.check(v, 4);
/*     */     } 
/* 766 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4usvARB(@NativeType("GLuint") int index, @NativeType("GLushort const *") short[] v) {
/* 771 */     long __functionAddress = (GL.getICD()).glVertexAttrib4usvARB;
/* 772 */     if (Checks.CHECKS) {
/* 773 */       Checks.check(__functionAddress);
/* 774 */       Checks.check(v, 4);
/*     */     } 
/* 776 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4uivARB(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 781 */     long __functionAddress = (GL.getICD()).glVertexAttrib4uivARB;
/* 782 */     if (Checks.CHECKS) {
/* 783 */       Checks.check(__functionAddress);
/* 784 */       Checks.check(v, 4);
/*     */     } 
/* 786 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NsvARB(@NativeType("GLuint") int index, @NativeType("GLshort const *") short[] v) {
/* 791 */     long __functionAddress = (GL.getICD()).glVertexAttrib4NsvARB;
/* 792 */     if (Checks.CHECKS) {
/* 793 */       Checks.check(__functionAddress);
/* 794 */       Checks.check(v, 4);
/*     */     } 
/* 796 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NivARB(@NativeType("GLuint") int index, @NativeType("GLint const *") int[] v) {
/* 801 */     long __functionAddress = (GL.getICD()).glVertexAttrib4NivARB;
/* 802 */     if (Checks.CHECKS) {
/* 803 */       Checks.check(__functionAddress);
/* 804 */       Checks.check(v, 4);
/*     */     } 
/* 806 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NusvARB(@NativeType("GLuint") int index, @NativeType("GLushort const *") short[] v) {
/* 811 */     long __functionAddress = (GL.getICD()).glVertexAttrib4NusvARB;
/* 812 */     if (Checks.CHECKS) {
/* 813 */       Checks.check(__functionAddress);
/* 814 */       Checks.check(v, 4);
/*     */     } 
/* 816 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4NuivARB(@NativeType("GLuint") int index, @NativeType("GLuint const *") int[] v) {
/* 821 */     long __functionAddress = (GL.getICD()).glVertexAttrib4NuivARB;
/* 822 */     if (Checks.CHECKS) {
/* 823 */       Checks.check(__functionAddress);
/* 824 */       Checks.check(v, 4);
/*     */     } 
/* 826 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") short[] pointer) {
/* 831 */     long __functionAddress = (GL.getICD()).glVertexAttribPointerARB;
/* 832 */     if (Checks.CHECKS) {
/* 833 */       Checks.check(__functionAddress);
/*     */     }
/* 835 */     JNI.callPV(index, size, type, normalized, stride, pointer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") int[] pointer) {
/* 840 */     long __functionAddress = (GL.getICD()).glVertexAttribPointerARB;
/* 841 */     if (Checks.CHECKS) {
/* 842 */       Checks.check(__functionAddress);
/*     */     }
/* 844 */     JNI.callPV(index, size, type, normalized, stride, pointer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLsizei") int stride, @NativeType("void const *") float[] pointer) {
/* 849 */     long __functionAddress = (GL.getICD()).glVertexAttribPointerARB;
/* 850 */     if (Checks.CHECKS) {
/* 851 */       Checks.check(__functionAddress);
/*     */     }
/* 853 */     JNI.callPV(index, size, type, normalized, stride, pointer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveAttribARB(@NativeType("GLhandleARB") int programObj, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] size, @NativeType("GLenum *") int[] type, @NativeType("GLchar *") ByteBuffer name) {
/* 858 */     long __functionAddress = (GL.getICD()).glGetActiveAttribARB;
/* 859 */     if (Checks.CHECKS) {
/* 860 */       Checks.check(__functionAddress);
/* 861 */       Checks.checkSafe(length, 1);
/* 862 */       Checks.check(size, 1);
/* 863 */       Checks.check(type, 1);
/*     */     } 
/* 865 */     JNI.callPPPPV(programObj, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribivARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 870 */     long __functionAddress = (GL.getICD()).glGetVertexAttribivARB;
/* 871 */     if (Checks.CHECKS) {
/* 872 */       Checks.check(__functionAddress);
/* 873 */       Checks.check(params, 1);
/*     */     } 
/* 875 */     JNI.callPV(index, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribfvARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 880 */     long __functionAddress = (GL.getICD()).glGetVertexAttribfvARB;
/* 881 */     if (Checks.CHECKS) {
/* 882 */       Checks.check(__functionAddress);
/* 883 */       Checks.check(params, 4);
/*     */     } 
/* 885 */     JNI.callPV(index, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribdvARB(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 890 */     long __functionAddress = (GL.getICD()).glGetVertexAttribdvARB;
/* 891 */     if (Checks.CHECKS) {
/* 892 */       Checks.check(__functionAddress);
/* 893 */       Checks.check(params, 4);
/*     */     } 
/* 895 */     JNI.callPV(index, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glVertexAttrib1fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void glVertexAttrib1sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort);
/*     */   
/*     */   public static native void glVertexAttrib1dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void glVertexAttrib2fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */   
/*     */   public static native void glVertexAttrib2sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*     */   
/*     */   public static native void glVertexAttrib2dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void glVertexAttrib3fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glVertexAttrib3sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glVertexAttrib3dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void glVertexAttrib4fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*     */   
/*     */   public static native void glVertexAttrib4sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*     */   
/*     */   public static native void glVertexAttrib4dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*     */   
/*     */   public static native void glVertexAttrib4NubARB(@NativeType("GLuint") int paramInt, @NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3, @NativeType("GLubyte") byte paramByte4);
/*     */   
/*     */   public static native void nglVertexAttrib1fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib1svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib1dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib2fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib2svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib2dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib3fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib3svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib3dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4ivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4bvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4ubvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4usvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4uivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4NbvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4NsvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4NivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4NubvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4NusvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttrib4NuivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribPointerARB(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void glEnableVertexAttribArrayARB(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glDisableVertexAttribArrayARB(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglBindAttribLocationARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveAttribARB(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nglGetAttribLocationARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribfvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribdvARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribPointervARB(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBVertexShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */