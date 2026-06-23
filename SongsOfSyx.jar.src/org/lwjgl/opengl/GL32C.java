/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL32C extends GL31C {
/*     */   public static final int GL_CONTEXT_PROFILE_MASK = 37158;
/*     */   public static final int GL_CONTEXT_CORE_PROFILE_BIT = 1;
/*     */   public static final int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT = 2;
/*     */   public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 37154;
/*     */   
/*     */   static {
/*  23 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 37155;
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 37156;
/*     */   
/*     */   public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS = 37157;
/*     */   
/*     */   public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
/*     */   
/*     */   public static final int GL_LAST_VERTEX_CONVENTION = 36430;
/*     */   
/*     */   public static final int GL_PROVOKING_VERTEX = 36431;
/*     */   
/*     */   public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 36428;
/*     */   
/*     */   public static final int GL_TEXTURE_CUBE_MAP_SEAMLESS = 34895;
/*     */   
/*     */   public static final int GL_SAMPLE_POSITION = 36432;
/*     */   
/*     */   public static final int GL_SAMPLE_MASK = 36433;
/*     */   
/*     */   public static final int GL_SAMPLE_MASK_VALUE = 36434;
/*     */   
/*     */   public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
/*     */   
/*     */   public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
/*     */   
/*     */   public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
/*     */   
/*     */   public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
/*     */   
/*     */   public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
/*     */   
/*     */   public static final int GL_MAX_INTEGER_SAMPLES = 37136;
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
/*     */   
/*     */   public static final int GL_TEXTURE_SAMPLES = 37126;
/*     */   
/*     */   public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
/*     */   
/*     */   public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
/*     */   
/*     */   public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
/*     */   
/*     */   public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
/*     */   
/*     */   public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;
/*     */   
/*     */   public static final int GL_DEPTH_CLAMP = 34383;
/*     */   
/*     */   public static final int GL_GEOMETRY_SHADER = 36313;
/*     */   
/*     */   public static final int GL_GEOMETRY_VERTICES_OUT = 36314;
/*     */   
/*     */   public static final int GL_GEOMETRY_INPUT_TYPE = 36315;
/*     */   
/*     */   public static final int GL_GEOMETRY_OUTPUT_TYPE = 36316;
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 35881;
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 36319;
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 36320;
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 36321;
/*     */   
/*     */   public static final int GL_LINES_ADJACENCY = 10;
/*     */   
/*     */   public static final int GL_LINE_STRIP_ADJACENCY = 11;
/*     */   
/*     */   public static final int GL_TRIANGLES_ADJACENCY = 12;
/*     */   
/*     */   public static final int GL_TRIANGLE_STRIP_ADJACENCY = 13;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 36264;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 36263;
/*     */   
/*     */   public static final int GL_PROGRAM_POINT_SIZE = 34370;
/*     */   
/*     */   public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
/*     */   
/*     */   public static final int GL_OBJECT_TYPE = 37138;
/*     */   public static final int GL_SYNC_CONDITION = 37139;
/*     */   public static final int GL_SYNC_STATUS = 37140;
/*     */   public static final int GL_SYNC_FLAGS = 37141;
/*     */   public static final int GL_SYNC_FENCE = 37142;
/*     */   public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
/*     */   public static final int GL_UNSIGNALED = 37144;
/*     */   public static final int GL_SIGNALED = 37145;
/*     */   public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
/*     */   public static final long GL_TIMEOUT_IGNORED = -1L;
/*     */   public static final int GL_ALREADY_SIGNALED = 37146;
/*     */   public static final int GL_TIMEOUT_EXPIRED = 37147;
/*     */   public static final int GL_CONDITION_SATISFIED = 37148;
/*     */   public static final int GL_WAIT_FAILED = 37149;
/*     */   
/*     */   protected GL32C() {
/* 135 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameteri64v(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check(params, 1);
/*     */     }
/* 148 */     nglGetBufferParameteri64v(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetBufferParameteri64(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 154 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 156 */       LongBuffer params = stack.callocLong(1);
/* 157 */       nglGetBufferParameteri64v(target, pname, MemoryUtil.memAddress(params));
/* 158 */       return params.get(0);
/*     */     } finally {
/* 160 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLint") int basevertex) {
/* 171 */     nglDrawElementsBaseVertex(mode, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/* 176 */     nglDrawElementsBaseVertex(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/* 181 */     nglDrawElementsBaseVertex(mode, indices.remaining(), 5121, MemoryUtil.memAddress(indices), basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices, @NativeType("GLint") int basevertex) {
/* 186 */     nglDrawElementsBaseVertex(mode, indices.remaining(), 5123, MemoryUtil.memAddress(indices), basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices, @NativeType("GLint") int basevertex) {
/* 191 */     nglDrawElementsBaseVertex(mode, indices.remaining(), 5125, MemoryUtil.memAddress(indices), basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLint") int basevertex) {
/* 201 */     nglDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/* 206 */     nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/* 211 */     nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining(), 5121, MemoryUtil.memAddress(indices), basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") ShortBuffer indices, @NativeType("GLint") int basevertex) {
/* 216 */     nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining(), 5123, MemoryUtil.memAddress(indices), basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") IntBuffer indices, @NativeType("GLint") int basevertex) {
/* 221 */     nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining(), 5125, MemoryUtil.memAddress(indices), basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 231 */     nglDrawElementsInstancedBaseVertex(mode, count, type, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 236 */     nglDrawElementsInstancedBaseVertex(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 241 */     nglDrawElementsInstancedBaseVertex(mode, indices.remaining(), 5121, MemoryUtil.memAddress(indices), primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 246 */     nglDrawElementsInstancedBaseVertex(mode, indices.remaining(), 5123, MemoryUtil.memAddress(indices), primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 251 */     nglDrawElementsInstancedBaseVertex(mode, indices.remaining(), 5125, MemoryUtil.memAddress(indices), primcount, basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei const *") IntBuffer count, @NativeType("GLenum") int type, @NativeType("void const * const *") PointerBuffer indices, @NativeType("GLint *") IntBuffer basevertex) {
/* 261 */     if (Checks.CHECKS) {
/* 262 */       Checks.check((CustomBuffer)indices, count.remaining());
/* 263 */       Checks.check(basevertex, count.remaining());
/*     */     } 
/* 265 */     nglMultiDrawElementsBaseVertex(mode, MemoryUtil.memAddress(count), type, MemoryUtil.memAddress((CustomBuffer)indices), count.remaining(), MemoryUtil.memAddress(basevertex));
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
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer val) {
/* 290 */     if (Checks.CHECKS) {
/* 291 */       Checks.check(val, 1);
/*     */     }
/* 293 */     nglGetMultisamplefv(pname, index, MemoryUtil.memAddress(val));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetMultisamplef(@NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/* 299 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 301 */       FloatBuffer val = stack.callocFloat(1);
/* 302 */       nglGetMultisamplefv(pname, index, MemoryUtil.memAddress(val));
/* 303 */       return val.get(0);
/*     */     } finally {
/* 305 */       stack.setPointer(stackPointer);
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
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsSync(@NativeType("GLsync") long sync) {
/* 333 */     if (Checks.CHECKS) {
/* 334 */       Checks.check(sync);
/*     */     }
/* 336 */     return nglIsSync(sync);
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
/*     */   @NativeType("GLenum")
/*     */   public static int glClientWaitSync(@NativeType("GLsync") long sync, @NativeType("GLbitfield") int flags, @NativeType("GLuint64") long timeout) {
/* 352 */     if (Checks.CHECKS) {
/* 353 */       Checks.check(sync);
/*     */     }
/* 355 */     return nglClientWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWaitSync(@NativeType("GLsync") long sync, @NativeType("GLbitfield") int flags, @NativeType("GLuint64") long timeout) {
/* 365 */     if (Checks.CHECKS) {
/* 366 */       Checks.check(sync);
/*     */     }
/* 368 */     nglWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/* 378 */     if (Checks.CHECKS) {
/* 379 */       Checks.check(params, 1);
/*     */     }
/* 381 */     nglGetInteger64v(pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetInteger64(@NativeType("GLenum") int pname) {
/* 387 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 389 */       LongBuffer params = stack.callocLong(1);
/* 390 */       nglGetInteger64v(pname, MemoryUtil.memAddress(params));
/* 391 */       return params.get(0);
/*     */     } finally {
/* 393 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetInteger64i_v(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") LongBuffer params) {
/* 404 */     if (Checks.CHECKS) {
/* 405 */       Checks.check(params, 1);
/*     */     }
/* 407 */     nglGetInteger64i_v(pname, index, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetInteger64i(@NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/* 413 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 415 */       LongBuffer params = stack.callocLong(1);
/* 416 */       nglGetInteger64i_v(pname, index, MemoryUtil.memAddress(params));
/* 417 */       return params.get(0);
/*     */     } finally {
/* 419 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSynciv(@NativeType("GLsync") long sync, @NativeType("GLenum") int pname, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer values) {
/* 430 */     if (Checks.CHECKS) {
/* 431 */       Checks.check(sync);
/* 432 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 434 */     nglGetSynciv(sync, pname, values.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSynci(@NativeType("GLsync") long sync, @NativeType("GLenum") int pname, @NativeType("GLsizei *") IntBuffer length) {
/* 440 */     if (Checks.CHECKS) {
/* 441 */       Checks.check(sync);
/* 442 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 444 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 446 */       IntBuffer values = stack.callocInt(1);
/* 447 */       nglGetSynciv(sync, pname, 1, MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(values));
/* 448 */       return values.get(0);
/*     */     } finally {
/* 450 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameteri64v(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 456 */     long __functionAddress = (GL.getICD()).glGetBufferParameteri64v;
/* 457 */     if (Checks.CHECKS) {
/* 458 */       Checks.check(__functionAddress);
/* 459 */       Checks.check(params, 1);
/*     */     } 
/* 461 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei const *") int[] count, @NativeType("GLenum") int type, @NativeType("void const * const *") PointerBuffer indices, @NativeType("GLint *") int[] basevertex) {
/* 466 */     long __functionAddress = (GL.getICD()).glMultiDrawElementsBaseVertex;
/* 467 */     if (Checks.CHECKS) {
/* 468 */       Checks.check(__functionAddress);
/* 469 */       Checks.check((CustomBuffer)indices, count.length);
/* 470 */       Checks.check(basevertex, count.length);
/*     */     } 
/* 472 */     JNI.callPPPV(mode, count, type, MemoryUtil.memAddress((CustomBuffer)indices), count.length, basevertex, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] val) {
/* 477 */     long __functionAddress = (GL.getICD()).glGetMultisamplefv;
/* 478 */     if (Checks.CHECKS) {
/* 479 */       Checks.check(__functionAddress);
/* 480 */       Checks.check(val, 1);
/*     */     } 
/* 482 */     JNI.callPV(pname, index, val, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 487 */     long __functionAddress = (GL.getICD()).glGetInteger64v;
/* 488 */     if (Checks.CHECKS) {
/* 489 */       Checks.check(__functionAddress);
/* 490 */       Checks.check(params, 1);
/*     */     } 
/* 492 */     JNI.callPV(pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInteger64i_v(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") long[] params) {
/* 497 */     long __functionAddress = (GL.getICD()).glGetInteger64i_v;
/* 498 */     if (Checks.CHECKS) {
/* 499 */       Checks.check(__functionAddress);
/* 500 */       Checks.check(params, 1);
/*     */     } 
/* 502 */     JNI.callPV(pname, index, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSynciv(@NativeType("GLsync") long sync, @NativeType("GLenum") int pname, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] values) {
/* 507 */     long __functionAddress = (GL.getICD()).glGetSynciv;
/* 508 */     if (Checks.CHECKS) {
/* 509 */       Checks.check(__functionAddress);
/* 510 */       Checks.check(sync);
/* 511 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 513 */     JNI.callPPPV(sync, pname, values.length, length, values, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglGetBufferParameteri64v(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglDrawElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
/*     */   
/*     */   public static native void nglDrawRangeElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6);
/*     */   
/*     */   public static native void nglDrawElementsInstancedBaseVertex(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5);
/*     */   
/*     */   public static native void nglMultiDrawElementsBaseVertex(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, long paramLong3);
/*     */   
/*     */   public static native void glProvokingVertex(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glTexImage2DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean);
/*     */   
/*     */   public static native void glTexImage3DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean);
/*     */   
/*     */   public static native void nglGetMultisamplefv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glSampleMaski(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2);
/*     */   
/*     */   public static native void glFramebufferTexture(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   @NativeType("GLsync")
/*     */   public static native long glFenceSync(@NativeType("GLenum") int paramInt1, @NativeType("GLbitfield") int paramInt2);
/*     */   
/*     */   public static native boolean nglIsSync(long paramLong);
/*     */   
/*     */   public static native void glDeleteSync(@NativeType("GLsync") long paramLong);
/*     */   
/*     */   public static native int nglClientWaitSync(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native void nglWaitSync(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native void nglGetInteger64v(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetInteger64i_v(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSynciv(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL32C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */