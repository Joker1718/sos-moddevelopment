/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class AMDGPUShaderInt64
/*     */ {
/*     */   public static final int GL_INT64_NV = 5134;
/*     */   public static final int GL_UNSIGNED_INT64_NV = 5135;
/*     */   public static final int GL_INT8_NV = 36832;
/*     */   
/*     */   static {
/*  14 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_INT8_VEC2_NV = 36833;
/*     */   
/*     */   public static final int GL_INT8_VEC3_NV = 36834;
/*     */   
/*     */   public static final int GL_INT8_VEC4_NV = 36835;
/*     */   public static final int GL_INT16_NV = 36836;
/*     */   public static final int GL_INT16_VEC2_NV = 36837;
/*     */   public static final int GL_INT16_VEC3_NV = 36838;
/*     */   public static final int GL_INT16_VEC4_NV = 36839;
/*     */   public static final int GL_INT64_VEC2_NV = 36841;
/*     */   public static final int GL_INT64_VEC3_NV = 36842;
/*     */   public static final int GL_INT64_VEC4_NV = 36843;
/*     */   public static final int GL_UNSIGNED_INT8_NV = 36844;
/*     */   public static final int GL_UNSIGNED_INT8_VEC2_NV = 36845;
/*     */   public static final int GL_UNSIGNED_INT8_VEC3_NV = 36846;
/*     */   public static final int GL_UNSIGNED_INT8_VEC4_NV = 36847;
/*     */   public static final int GL_UNSIGNED_INT16_NV = 36848;
/*     */   public static final int GL_UNSIGNED_INT16_VEC2_NV = 36849;
/*     */   public static final int GL_UNSIGNED_INT16_VEC3_NV = 36850;
/*     */   public static final int GL_UNSIGNED_INT16_VEC4_NV = 36851;
/*     */   public static final int GL_UNSIGNED_INT64_VEC2_NV = 36853;
/*     */   public static final int GL_UNSIGNED_INT64_VEC3_NV = 36854;
/*     */   public static final int GL_UNSIGNED_INT64_VEC4_NV = 36855;
/*     */   public static final int GL_FLOAT16_NV = 36856;
/*     */   public static final int GL_FLOAT16_VEC2_NV = 36857;
/*     */   public static final int GL_FLOAT16_VEC3_NV = 36858;
/*     */   public static final int GL_FLOAT16_VEC4_NV = 36859;
/*     */   
/*     */   protected AMDGPUShaderInt64() {
/*  47 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform1i64NV(@NativeType("GLint") int location, @NativeType("GLint64EXT") long x) {
/*  54 */     NVGPUShader5.glUniform1i64NV(location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2i64NV(@NativeType("GLint") int location, @NativeType("GLint64EXT") long x, @NativeType("GLint64EXT") long y) {
/*  61 */     NVGPUShader5.glUniform2i64NV(location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3i64NV(@NativeType("GLint") int location, @NativeType("GLint64EXT") long x, @NativeType("GLint64EXT") long y, @NativeType("GLint64EXT") long z) {
/*  68 */     NVGPUShader5.glUniform3i64NV(location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4i64NV(@NativeType("GLint") int location, @NativeType("GLint64EXT") long x, @NativeType("GLint64EXT") long y, @NativeType("GLint64EXT") long z, @NativeType("GLint64EXT") long w) {
/*  75 */     NVGPUShader5.glUniform4i64NV(location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform1i64vNV(int location, int count, long value) {
/*  82 */     NVGPUShader5.nglUniform1i64vNV(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/*  87 */     NVGPUShader5.glUniform1i64vNV(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform2i64vNV(int location, int count, long value) {
/*  94 */     NVGPUShader5.nglUniform2i64vNV(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/*  99 */     NVGPUShader5.glUniform2i64vNV(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform3i64vNV(int location, int count, long value) {
/* 106 */     NVGPUShader5.nglUniform3i64vNV(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 111 */     NVGPUShader5.glUniform3i64vNV(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform4i64vNV(int location, int count, long value) {
/* 118 */     NVGPUShader5.nglUniform4i64vNV(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 123 */     NVGPUShader5.glUniform4i64vNV(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform1ui64NV(@NativeType("GLint") int location, @NativeType("GLuint64EXT") long x) {
/* 130 */     NVGPUShader5.glUniform1ui64NV(location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64NV(@NativeType("GLint") int location, @NativeType("GLuint64EXT") long x, @NativeType("GLuint64EXT") long y) {
/* 137 */     NVGPUShader5.glUniform2ui64NV(location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64NV(@NativeType("GLint") int location, @NativeType("GLuint64EXT") long x, @NativeType("GLuint64EXT") long y, @NativeType("GLuint64EXT") long z) {
/* 144 */     NVGPUShader5.glUniform3ui64NV(location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64NV(@NativeType("GLint") int location, @NativeType("GLuint64EXT") long x, @NativeType("GLuint64EXT") long y, @NativeType("GLuint64EXT") long z, @NativeType("GLuint64EXT") long w) {
/* 151 */     NVGPUShader5.glUniform4ui64NV(location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform1ui64vNV(int location, int count, long value) {
/* 158 */     NVGPUShader5.nglUniform1ui64vNV(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 163 */     NVGPUShader5.glUniform1ui64vNV(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform2ui64vNV(int location, int count, long value) {
/* 170 */     NVGPUShader5.nglUniform2ui64vNV(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT *") LongBuffer value) {
/* 175 */     NVGPUShader5.glUniform2ui64vNV(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform3ui64vNV(int location, int count, long value) {
/* 182 */     NVGPUShader5.nglUniform3ui64vNV(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 187 */     NVGPUShader5.glUniform3ui64vNV(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform4ui64vNV(int location, int count, long value) {
/* 194 */     NVGPUShader5.nglUniform4ui64vNV(location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 199 */     NVGPUShader5.glUniform4ui64vNV(location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformi64vNV(int program, int location, long params) {
/* 206 */     NVGPUShader5.nglGetUniformi64vNV(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT *") LongBuffer params) {
/* 211 */     NVGPUShader5.glGetUniformi64vNV(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformi64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 217 */     return NVGPUShader5.glGetUniformi64NV(program, location);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformui64vNV(int program, int location, long params) {
/* 224 */     NVShaderBufferLoad.nglGetUniformui64vNV(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT *") LongBuffer params) {
/* 229 */     NVShaderBufferLoad.glGetUniformui64vNV(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformui64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location) {
/* 235 */     return NVShaderBufferLoad.glGetUniformui64NV(program, location);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT") long x) {
/* 242 */     NVGPUShader5.glProgramUniform1i64NV(program, location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT") long x, @NativeType("GLint64EXT") long y) {
/* 249 */     NVGPUShader5.glProgramUniform2i64NV(program, location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT") long x, @NativeType("GLint64EXT") long y, @NativeType("GLint64EXT") long z) {
/* 256 */     NVGPUShader5.glProgramUniform3i64NV(program, location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT") long x, @NativeType("GLint64EXT") long y, @NativeType("GLint64EXT") long z, @NativeType("GLint64EXT") long w) {
/* 263 */     NVGPUShader5.glProgramUniform4i64NV(program, location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform1i64vNV(int program, int location, int count, long value) {
/* 270 */     NVGPUShader5.nglProgramUniform1i64vNV(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 275 */     NVGPUShader5.glProgramUniform1i64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform2i64vNV(int program, int location, int count, long value) {
/* 282 */     NVGPUShader5.nglProgramUniform2i64vNV(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 287 */     NVGPUShader5.glProgramUniform2i64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform3i64vNV(int program, int location, int count, long value) {
/* 294 */     NVGPUShader5.nglProgramUniform3i64vNV(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 299 */     NVGPUShader5.glProgramUniform3i64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform4i64vNV(int program, int location, int count, long value) {
/* 306 */     NVGPUShader5.nglProgramUniform4i64vNV(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") LongBuffer value) {
/* 311 */     NVGPUShader5.glProgramUniform4i64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT") long x) {
/* 318 */     NVGPUShader5.glProgramUniform1ui64NV(program, location, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT") long x, @NativeType("GLuint64EXT") long y) {
/* 325 */     NVGPUShader5.glProgramUniform2ui64NV(program, location, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT") long x, @NativeType("GLuint64EXT") long y, @NativeType("GLuint64EXT") long z) {
/* 332 */     NVGPUShader5.glProgramUniform3ui64NV(program, location, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64NV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT") long x, @NativeType("GLuint64EXT") long y, @NativeType("GLuint64EXT") long z, @NativeType("GLuint64EXT") long w) {
/* 339 */     NVGPUShader5.glProgramUniform4ui64NV(program, location, x, y, z, w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform1ui64vNV(int program, int location, int count, long value) {
/* 346 */     NVGPUShader5.nglProgramUniform1ui64vNV(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 351 */     NVGPUShader5.glProgramUniform1ui64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform2ui64vNV(int program, int location, int count, long value) {
/* 358 */     NVGPUShader5.nglProgramUniform2ui64vNV(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 363 */     NVGPUShader5.glProgramUniform2ui64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform3ui64vNV(int program, int location, int count, long value) {
/* 370 */     NVGPUShader5.nglProgramUniform3ui64vNV(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 375 */     NVGPUShader5.glProgramUniform3ui64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform4ui64vNV(int program, int location, int count, long value) {
/* 382 */     NVGPUShader5.nglProgramUniform4ui64vNV(program, location, count, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") LongBuffer value) {
/* 387 */     NVGPUShader5.glProgramUniform4ui64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 392 */     NVGPUShader5.glUniform1i64vNV(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 397 */     NVGPUShader5.glUniform2i64vNV(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 402 */     NVGPUShader5.glUniform3i64vNV(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4i64vNV(@NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 407 */     NVGPUShader5.glUniform4i64vNV(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 412 */     NVGPUShader5.glUniform1ui64vNV(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT *") long[] value) {
/* 417 */     NVGPUShader5.glUniform2ui64vNV(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 422 */     NVGPUShader5.glUniform3ui64vNV(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64vNV(@NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 427 */     NVGPUShader5.glUniform4ui64vNV(location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT *") long[] params) {
/* 432 */     NVGPUShader5.glGetUniformi64vNV(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT *") long[] params) {
/* 437 */     NVShaderBufferLoad.glGetUniformui64vNV(program, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 442 */     NVGPUShader5.glProgramUniform1i64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 447 */     NVGPUShader5.glProgramUniform2i64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 452 */     NVGPUShader5.glProgramUniform3i64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLint64EXT const *") long[] value) {
/* 457 */     NVGPUShader5.glProgramUniform4i64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 462 */     NVGPUShader5.glProgramUniform1ui64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 467 */     NVGPUShader5.glProgramUniform2ui64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 472 */     NVGPUShader5.glProgramUniform3ui64vNV(program, location, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64vNV(@NativeType("GLuint") int program, @NativeType("GLint") int location, @NativeType("GLuint64EXT const *") long[] value) {
/* 477 */     NVGPUShader5.glProgramUniform4ui64vNV(program, location, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\AMDGPUShaderInt64.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */