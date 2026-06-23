/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL32 extends GL31 {
/*     */   public static final int GL_CONTEXT_PROFILE_MASK = 37158;
/*     */   public static final int GL_CONTEXT_CORE_PROFILE_BIT = 1;
/*     */   public static final int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT = 2;
/*     */   public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 37154;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
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
/*     */   protected GL32() {
/* 130 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetBufferParameteri64v(int target, int pname, long params) {
/* 137 */     GL32C.nglGetBufferParameteri64v(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameteri64v(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/* 142 */     GL32C.glGetBufferParameteri64v(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetBufferParameteri64(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 148 */     return GL32C.glGetBufferParameteri64(target, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawElementsBaseVertex(int mode, int count, int type, long indices, int basevertex) {
/* 155 */     GL32C.nglDrawElementsBaseVertex(mode, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLint") int basevertex) {
/* 160 */     GL32C.glDrawElementsBaseVertex(mode, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/* 165 */     GL32C.glDrawElementsBaseVertex(mode, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/* 170 */     GL32C.glDrawElementsBaseVertex(mode, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices, @NativeType("GLint") int basevertex) {
/* 175 */     GL32C.glDrawElementsBaseVertex(mode, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices, @NativeType("GLint") int basevertex) {
/* 180 */     GL32C.glDrawElementsBaseVertex(mode, indices, basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, long indices, int basevertex) {
/* 187 */     GL32C.nglDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLint") int basevertex) {
/* 192 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/* 197 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/* 202 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") ShortBuffer indices, @NativeType("GLint") int basevertex) {
/* 207 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") IntBuffer indices, @NativeType("GLint") int basevertex) {
/* 212 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawElementsInstancedBaseVertex(int mode, int count, int type, long indices, int primcount, int basevertex) {
/* 219 */     GL32C.nglDrawElementsInstancedBaseVertex(mode, count, type, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 224 */     GL32C.glDrawElementsInstancedBaseVertex(mode, count, type, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 229 */     GL32C.glDrawElementsInstancedBaseVertex(mode, type, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 234 */     GL32C.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 239 */     GL32C.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 244 */     GL32C.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiDrawElementsBaseVertex(int mode, long count, int type, long indices, int drawcount, long basevertex) {
/* 251 */     GL32C.nglMultiDrawElementsBaseVertex(mode, count, type, indices, drawcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei const *") IntBuffer count, @NativeType("GLenum") int type, @NativeType("void const * const *") PointerBuffer indices, @NativeType("GLint *") IntBuffer basevertex) {
/* 256 */     GL32C.glMultiDrawElementsBaseVertex(mode, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProvokingVertex(@NativeType("GLenum") int mode) {
/* 263 */     GL32C.glProvokingVertex(mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexImage2DMultisample(@NativeType("GLenum") int target, @NativeType("GLsizei") int samples, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLboolean") boolean fixedsamplelocations) {
/* 270 */     GL32C.glTexImage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexImage3DMultisample(@NativeType("GLenum") int target, @NativeType("GLsizei") int samples, @NativeType("GLint") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLboolean") boolean fixedsamplelocations) {
/* 277 */     GL32C.glTexImage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetMultisamplefv(int pname, int index, long val) {
/* 284 */     GL32C.nglGetMultisamplefv(pname, index, val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer val) {
/* 289 */     GL32C.glGetMultisamplefv(pname, index, val);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetMultisamplef(@NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/* 295 */     return GL32C.glGetMultisamplef(pname, index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSampleMaski(@NativeType("GLuint") int index, @NativeType("GLbitfield") int mask) {
/* 302 */     GL32C.glSampleMaski(index, mask);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFramebufferTexture(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLuint") int texture, @NativeType("GLint") int level) {
/* 309 */     GL32C.glFramebufferTexture(target, attachment, texture, level);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLsync")
/*     */   public static long glFenceSync(@NativeType("GLenum") int condition, @NativeType("GLbitfield") int flags) {
/* 317 */     return GL32C.glFenceSync(condition, flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nglIsSync(long sync) {
/* 324 */     return GL32C.nglIsSync(sync);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsSync(@NativeType("GLsync") long sync) {
/* 330 */     return GL32C.glIsSync(sync);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteSync(@NativeType("GLsync") long sync) {
/* 337 */     GL32C.glDeleteSync(sync);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglClientWaitSync(long sync, int flags, long timeout) {
/* 344 */     return GL32C.nglClientWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLenum")
/*     */   public static int glClientWaitSync(@NativeType("GLsync") long sync, @NativeType("GLbitfield") int flags, @NativeType("GLuint64") long timeout) {
/* 350 */     return GL32C.glClientWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglWaitSync(long sync, int flags, long timeout) {
/* 357 */     GL32C.nglWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWaitSync(@NativeType("GLsync") long sync, @NativeType("GLbitfield") int flags, @NativeType("GLuint64") long timeout) {
/* 362 */     GL32C.glWaitSync(sync, flags, timeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetInteger64v(int pname, long params) {
/* 369 */     GL32C.nglGetInteger64v(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/* 374 */     GL32C.glGetInteger64v(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetInteger64(@NativeType("GLenum") int pname) {
/* 380 */     return GL32C.glGetInteger64(pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetInteger64i_v(int pname, int index, long params) {
/* 387 */     GL32C.nglGetInteger64i_v(pname, index, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInteger64i_v(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") LongBuffer params) {
/* 392 */     GL32C.glGetInteger64i_v(pname, index, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetInteger64i(@NativeType("GLenum") int pname, @NativeType("GLuint") int index) {
/* 398 */     return GL32C.glGetInteger64i(pname, index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSynciv(long sync, int pname, int bufSize, long length, long values) {
/* 405 */     GL32C.nglGetSynciv(sync, pname, bufSize, length, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSynciv(@NativeType("GLsync") long sync, @NativeType("GLenum") int pname, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer values) {
/* 410 */     GL32C.glGetSynciv(sync, pname, length, values);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSynci(@NativeType("GLsync") long sync, @NativeType("GLenum") int pname, @NativeType("GLsizei *") IntBuffer length) {
/* 416 */     return GL32C.glGetSynci(sync, pname, length);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameteri64v(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 421 */     GL32C.glGetBufferParameteri64v(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei const *") int[] count, @NativeType("GLenum") int type, @NativeType("void const * const *") PointerBuffer indices, @NativeType("GLint *") int[] basevertex) {
/* 426 */     GL32C.glMultiDrawElementsBaseVertex(mode, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] val) {
/* 431 */     GL32C.glGetMultisamplefv(pname, index, val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 436 */     GL32C.glGetInteger64v(pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInteger64i_v(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLint64 *") long[] params) {
/* 441 */     GL32C.glGetInteger64i_v(pname, index, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSynciv(@NativeType("GLsync") long sync, @NativeType("GLenum") int pname, @NativeType("GLsizei *") int[] length, @NativeType("GLint *") int[] values) {
/* 446 */     GL32C.glGetSynciv(sync, pname, length, values);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */