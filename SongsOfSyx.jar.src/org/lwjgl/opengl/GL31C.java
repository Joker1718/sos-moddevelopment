/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL31C
/*     */   extends GL30C
/*     */ {
/*     */   public static final int GL_R8_SNORM = 36756;
/*     */   public static final int GL_RG8_SNORM = 36757;
/*     */   public static final int GL_RGB8_SNORM = 36758;
/*     */   
/*     */   static {
/*  23 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_RGBA8_SNORM = 36759;
/*     */   
/*     */   public static final int GL_R16_SNORM = 36760;
/*     */   
/*     */   public static final int GL_RG16_SNORM = 36761;
/*     */   
/*     */   public static final int GL_RGB16_SNORM = 36762;
/*     */   
/*     */   public static final int GL_RGBA16_SNORM = 36763;
/*     */   
/*     */   public static final int GL_SIGNED_NORMALIZED = 36764;
/*     */   
/*     */   public static final int GL_SAMPLER_BUFFER = 36290;
/*     */   
/*     */   public static final int GL_INT_SAMPLER_2D_RECT = 36301;
/*     */   
/*     */   public static final int GL_INT_SAMPLER_BUFFER = 36304;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 36309;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312;
/*     */   
/*     */   public static final int GL_COPY_READ_BUFFER = 36662;
/*     */   
/*     */   public static final int GL_COPY_WRITE_BUFFER = 36663;
/*     */   
/*     */   public static final int GL_PRIMITIVE_RESTART = 36765;
/*     */   
/*     */   public static final int GL_PRIMITIVE_RESTART_INDEX = 36766;
/*     */   
/*     */   public static final int GL_TEXTURE_BUFFER = 35882;
/*     */   
/*     */   public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883;
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_BUFFER = 35884;
/*     */   
/*     */   public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885;
/*     */   
/*     */   public static final int GL_TEXTURE_RECTANGLE = 34037;
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_RECTANGLE = 34038;
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_RECTANGLE = 34039;
/*     */   
/*     */   public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 34040;
/*     */   
/*     */   public static final int GL_SAMPLER_2D_RECT = 35683;
/*     */   
/*     */   public static final int GL_SAMPLER_2D_RECT_SHADOW = 35684;
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER = 35345;
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_BINDING = 35368;
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_START = 35369;
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_SIZE = 35370;
/*     */   
/*     */   public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371;
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
/*     */   
/*     */   public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373;
/*     */   public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374;
/*     */   public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375;
/*     */   public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376;
/*     */   public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377;
/*     */   public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
/*     */   public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379;
/*     */   public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380;
/*     */   public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381;
/*     */   public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382;
/*     */   public static final int GL_UNIFORM_TYPE = 35383;
/*     */   public static final int GL_UNIFORM_SIZE = 35384;
/*     */   public static final int GL_UNIFORM_NAME_LENGTH = 35385;
/*     */   public static final int GL_UNIFORM_BLOCK_INDEX = 35386;
/*     */   public static final int GL_UNIFORM_OFFSET = 35387;
/*     */   public static final int GL_UNIFORM_ARRAY_STRIDE = 35388;
/*     */   public static final int GL_UNIFORM_MATRIX_STRIDE = 35389;
/*     */   public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390;
/*     */   public static final int GL_UNIFORM_BLOCK_BINDING = 35391;
/*     */   public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392;
/*     */   public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393;
/*     */   public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394;
/*     */   public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395;
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396;
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 35397;
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398;
/*     */   public static final int GL_INVALID_INDEX = -1;
/*     */   
/*     */   protected GL31C() {
/* 118 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLsizei") int primcount) {
/* 133 */     nglDrawElementsInstanced(mode, count, type, indices, primcount);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount) {
/* 138 */     nglDrawElementsInstanced(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), primcount);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount) {
/* 143 */     nglDrawElementsInstanced(mode, indices.remaining(), 5121, MemoryUtil.memAddress(indices), primcount);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices, @NativeType("GLsizei") int primcount) {
/* 148 */     nglDrawElementsInstanced(mode, indices.remaining(), 5123, MemoryUtil.memAddress(indices), primcount);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices, @NativeType("GLsizei") int primcount) {
/* 153 */     nglDrawElementsInstanced(mode, indices.remaining(), 5125, MemoryUtil.memAddress(indices), primcount);
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
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int program, @NativeType("GLchar const * const *") PointerBuffer uniformNames, @NativeType("GLuint *") IntBuffer uniformIndices) {
/* 178 */     if (Checks.CHECKS) {
/* 179 */       Checks.check(uniformIndices, uniformNames.remaining());
/*     */     }
/* 181 */     nglGetUniformIndices(program, uniformNames.remaining(), MemoryUtil.memAddress((CustomBuffer)uniformNames), MemoryUtil.memAddress(uniformIndices));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int program, @NativeType("GLchar const * const *") CharSequence[] uniformNames, @NativeType("GLuint *") IntBuffer uniformIndices) {
/* 186 */     if (Checks.CHECKS) {
/* 187 */       Checks.check(uniformIndices, uniformNames.length);
/*     */     }
/* 189 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 191 */       long uniformNamesAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, uniformNames);
/* 192 */       nglGetUniformIndices(program, uniformNames.length, uniformNamesAddress, MemoryUtil.memAddress(uniformIndices));
/* 193 */       APIUtil.apiArrayFree(uniformNamesAddress, uniformNames.length);
/*     */     } finally {
/* 195 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformIndices(@NativeType("GLuint") int program, @NativeType("GLchar const * const *") CharSequence uniformName) {
/* 202 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 204 */       long uniformNamesAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, new CharSequence[] { uniformName });
/* 205 */       IntBuffer uniformIndices = stack.callocInt(1);
/* 206 */       nglGetUniformIndices(program, 1, uniformNamesAddress, MemoryUtil.memAddress(uniformIndices));
/* 207 */       APIUtil.apiArrayFree(uniformNamesAddress, 1);
/* 208 */       return uniformIndices.get(0);
/*     */     } finally {
/* 210 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformsiv(@NativeType("GLuint") int program, @NativeType("GLuint const *") IntBuffer uniformIndices, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 221 */     if (Checks.CHECKS) {
/* 222 */       Checks.check(params, uniformIndices.remaining());
/*     */     }
/* 224 */     nglGetActiveUniformsiv(program, uniformIndices.remaining(), MemoryUtil.memAddress(uniformIndices), pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetActiveUniformsi(@NativeType("GLuint") int program, @NativeType("GLuint const *") int uniformIndex, @NativeType("GLenum") int pname) {
/* 230 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 232 */       IntBuffer params = stack.callocInt(1);
/* 233 */       IntBuffer uniformIndices = stack.ints(uniformIndex);
/* 234 */       nglGetActiveUniformsiv(program, 1, MemoryUtil.memAddress(uniformIndices), pname, MemoryUtil.memAddress(params));
/* 235 */       return params.get(0);
/*     */     } finally {
/* 237 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformName(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformIndex, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer uniformName) {
/* 248 */     if (Checks.CHECKS) {
/* 249 */       Checks.checkSafe(length, 1);
/*     */     }
/* 251 */     nglGetActiveUniformName(program, uniformIndex, uniformName.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(uniformName));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformName(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformIndex, @NativeType("GLsizei") int bufSize) {
/* 257 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 259 */       IntBuffer length = stack.ints(0);
/* 260 */       ByteBuffer uniformName = stack.malloc(bufSize);
/* 261 */       nglGetActiveUniformName(program, uniformIndex, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(uniformName));
/* 262 */       return MemoryUtil.memASCII(uniformName, length.get(0));
/*     */     } finally {
/* 264 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformName(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformIndex) {
/* 271 */     return glGetActiveUniformName(program, uniformIndex, glGetActiveUniformsi(program, uniformIndex, 35385));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetUniformBlockIndex(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer uniformBlockName) {
/* 282 */     if (Checks.CHECKS) {
/* 283 */       Checks.checkNT1(uniformBlockName);
/*     */     }
/* 285 */     return nglGetUniformBlockIndex(program, MemoryUtil.memAddress(uniformBlockName));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetUniformBlockIndex(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence uniformBlockName) {
/* 291 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 293 */       stack.nASCII(uniformBlockName, true);
/* 294 */       long uniformBlockNameEncoded = stack.getPointerAddress();
/* 295 */       return nglGetUniformBlockIndex(program, uniformBlockNameEncoded);
/*     */     } finally {
/* 297 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockiv(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformBlockIndex, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 308 */     if (Checks.CHECKS) {
/* 309 */       Checks.check(params, 1);
/*     */     }
/* 311 */     nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetActiveUniformBlocki(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformBlockIndex, @NativeType("GLenum") int pname) {
/* 317 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 319 */       IntBuffer params = stack.callocInt(1);
/* 320 */       nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, MemoryUtil.memAddress(params));
/* 321 */       return params.get(0);
/*     */     } finally {
/* 323 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockName(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformBlockIndex, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer uniformBlockName) {
/* 334 */     if (Checks.CHECKS) {
/* 335 */       Checks.checkSafe(length, 1);
/*     */     }
/* 337 */     nglGetActiveUniformBlockName(program, uniformBlockIndex, uniformBlockName.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(uniformBlockName));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformBlockName(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformBlockIndex, @NativeType("GLsizei") int bufSize) {
/* 343 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 345 */       IntBuffer length = stack.ints(0);
/* 346 */       ByteBuffer uniformBlockName = stack.malloc(bufSize);
/* 347 */       nglGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(uniformBlockName));
/* 348 */       return MemoryUtil.memASCII(uniformBlockName, length.get(0));
/*     */     } finally {
/* 350 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformBlockName(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformBlockIndex) {
/* 357 */     return glGetActiveUniformBlockName(program, uniformBlockIndex, glGetActiveUniformBlocki(program, uniformBlockIndex, 35393));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int program, @NativeType("GLchar const * const *") PointerBuffer uniformNames, @NativeType("GLuint *") int[] uniformIndices) {
/* 367 */     long __functionAddress = (GL.getICD()).glGetUniformIndices;
/* 368 */     if (Checks.CHECKS) {
/* 369 */       Checks.check(__functionAddress);
/* 370 */       Checks.check(uniformIndices, uniformNames.remaining());
/*     */     } 
/* 372 */     JNI.callPPV(program, uniformNames.remaining(), MemoryUtil.memAddress((CustomBuffer)uniformNames), uniformIndices, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformsiv(@NativeType("GLuint") int program, @NativeType("GLuint const *") int[] uniformIndices, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 377 */     long __functionAddress = (GL.getICD()).glGetActiveUniformsiv;
/* 378 */     if (Checks.CHECKS) {
/* 379 */       Checks.check(__functionAddress);
/* 380 */       Checks.check(params, uniformIndices.length);
/*     */     } 
/* 382 */     JNI.callPPV(program, uniformIndices.length, uniformIndices, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformName(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformIndex, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer uniformName) {
/* 387 */     long __functionAddress = (GL.getICD()).glGetActiveUniformName;
/* 388 */     if (Checks.CHECKS) {
/* 389 */       Checks.check(__functionAddress);
/* 390 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 392 */     JNI.callPPV(program, uniformIndex, uniformName.remaining(), length, MemoryUtil.memAddress(uniformName), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockiv(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformBlockIndex, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 397 */     long __functionAddress = (GL.getICD()).glGetActiveUniformBlockiv;
/* 398 */     if (Checks.CHECKS) {
/* 399 */       Checks.check(__functionAddress);
/* 400 */       Checks.check(params, 1);
/*     */     } 
/* 402 */     JNI.callPV(program, uniformBlockIndex, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockName(@NativeType("GLuint") int program, @NativeType("GLuint") int uniformBlockIndex, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer uniformBlockName) {
/* 407 */     long __functionAddress = (GL.getICD()).glGetActiveUniformBlockName;
/* 408 */     if (Checks.CHECKS) {
/* 409 */       Checks.check(__functionAddress);
/* 410 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 412 */     JNI.callPPV(program, uniformBlockIndex, uniformBlockName.remaining(), length, MemoryUtil.memAddress(uniformBlockName), __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glDrawArraysInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*     */   
/*     */   public static native void nglDrawElementsInstanced(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
/*     */   
/*     */   public static native void glCopyBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3);
/*     */   
/*     */   public static native void glPrimitiveRestartIndex(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glTexBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void nglGetUniformIndices(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetActiveUniformsiv(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2);
/*     */   
/*     */   public static native void nglGetActiveUniformName(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nglGetUniformBlockIndex(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveUniformBlockiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveUniformBlockName(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void glUniformBlockBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL31C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */