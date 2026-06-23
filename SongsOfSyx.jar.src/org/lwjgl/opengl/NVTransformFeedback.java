/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class NVTransformFeedback
/*     */ {
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_NV = 35982;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_NV = 35972;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_NV = 35973;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_RECORD_NV = 35974;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_NV = 35983;
/*     */   public static final int GL_INTERLEAVED_ATTRIBS_NV = 35980;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_SEPARATE_ATTRIBS_NV = 35981;
/*     */   
/*     */   public static final int GL_PRIMITIVES_GENERATED_NV = 35975;
/*     */   
/*     */   public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_NV = 35976;
/*     */   
/*     */   public static final int GL_RASTERIZER_DISCARD_NV = 35977;
/*     */   
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_NV = 35978;
/*     */   
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_NV = 35979;
/*     */   
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_NV = 35968;
/*     */   
/*     */   public static final int GL_TRANSFORM_FEEDBACK_ATTRIBS_NV = 35966;
/*     */   
/*     */   public static final int GL_ACTIVE_VARYINGS_NV = 35969;
/*     */   
/*     */   public static final int GL_ACTIVE_VARYING_MAX_LENGTH_NV = 35970;
/*     */   
/*     */   public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_NV = 35971;
/*     */   
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_NV = 35967;
/*     */   
/*     */   public static final int GL_BACK_PRIMARY_COLOR_NV = 35959;
/*     */   
/*     */   public static final int GL_BACK_SECONDARY_COLOR_NV = 35960;
/*     */   
/*     */   public static final int GL_TEXTURE_COORD_NV = 35961;
/*     */   
/*     */   public static final int GL_CLIP_DISTANCE_NV = 35962;
/*     */   
/*     */   public static final int GL_VERTEX_ID_NV = 35963;
/*     */   
/*     */   public static final int GL_PRIMITIVE_ID_NV = 35964;
/*     */   
/*     */   public static final int GL_GENERIC_ATTRIB_NV = 35965;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_NV = 34093;
/*     */   public static final int GL_LAYER_NV = 36266;
/*     */   
/*     */   protected NVTransformFeedback() {
/*  67 */     throw new UnsupportedOperationException();
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
/*     */   public static void glTransformFeedbackAttribsNV(@NativeType("GLint const *") IntBuffer attribs, @NativeType("GLenum") int bufferMode) {
/*  87 */     nglTransformFeedbackAttribsNV(attribs.remaining(), MemoryUtil.memAddress(attribs), bufferMode);
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
/*     */   public static void glTransformFeedbackVaryingsNV(@NativeType("GLuint") int program, @NativeType("GLint const *") IntBuffer locations, @NativeType("GLenum") int bufferMode) {
/* 112 */     nglTransformFeedbackVaryingsNV(program, locations.remaining(), MemoryUtil.memAddress(locations), bufferMode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glActiveVaryingNV(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.checkNT1(name);
/*     */     }
/* 125 */     nglActiveVaryingNV(program, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glActiveVaryingNV(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/* 130 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 132 */       stack.nASCII(name, true);
/* 133 */       long nameEncoded = stack.getPointerAddress();
/* 134 */       nglActiveVaryingNV(program, nameEncoded);
/*     */     } finally {
/* 136 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetVaryingLocationNV(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.checkNT1(name);
/*     */     }
/* 151 */     return nglGetVaryingLocationNV(program, MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetVaryingLocationNV(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/* 157 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 159 */       stack.nASCII(name, true);
/* 160 */       long nameEncoded = stack.getPointerAddress();
/* 161 */       return nglGetVaryingLocationNV(program, nameEncoded);
/*     */     } finally {
/* 163 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveVaryingNV(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLsizei *") IntBuffer size, @NativeType("GLenum *") IntBuffer type, @NativeType("GLchar *") ByteBuffer name) {
/* 174 */     if (Checks.CHECKS) {
/* 175 */       Checks.checkSafe(length, 1);
/* 176 */       Checks.check(size, 1);
/* 177 */       Checks.check(type, 1);
/*     */     } 
/* 179 */     nglGetActiveVaryingNV(program, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetTransformFeedbackVaryingNV(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer location) {
/* 189 */     if (Checks.CHECKS) {
/* 190 */       Checks.check(location, 1);
/*     */     }
/* 192 */     nglGetTransformFeedbackVaryingNV(program, index, MemoryUtil.memAddress(location));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetTransformFeedbackVaryingNV(@NativeType("GLuint") int program, @NativeType("GLuint") int index) {
/* 198 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 200 */       IntBuffer location = stack.callocInt(1);
/* 201 */       nglGetTransformFeedbackVaryingNV(program, index, MemoryUtil.memAddress(location));
/* 202 */       return location.get(0);
/*     */     } finally {
/* 204 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackStreamAttribsNV(@NativeType("GLint const *") IntBuffer attribs, @NativeType("GLint const *") IntBuffer bufstreams, @NativeType("GLenum") int bufferMode) {
/* 215 */     nglTransformFeedbackStreamAttribsNV(attribs.remaining(), MemoryUtil.memAddress(attribs), bufstreams.remaining(), MemoryUtil.memAddress(bufstreams), bufferMode);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackAttribsNV(@NativeType("GLint const *") int[] attribs, @NativeType("GLenum") int bufferMode) {
/* 220 */     long __functionAddress = (GL.getICD()).glTransformFeedbackAttribsNV;
/* 221 */     if (Checks.CHECKS) {
/* 222 */       Checks.check(__functionAddress);
/*     */     }
/* 224 */     JNI.callPV(attribs.length, attribs, bufferMode, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackVaryingsNV(@NativeType("GLuint") int program, @NativeType("GLint const *") int[] locations, @NativeType("GLenum") int bufferMode) {
/* 229 */     long __functionAddress = (GL.getICD()).glTransformFeedbackVaryingsNV;
/* 230 */     if (Checks.CHECKS) {
/* 231 */       Checks.check(__functionAddress);
/*     */     }
/* 233 */     JNI.callPV(program, locations.length, locations, bufferMode, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveVaryingNV(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLsizei *") int[] size, @NativeType("GLenum *") int[] type, @NativeType("GLchar *") ByteBuffer name) {
/* 238 */     long __functionAddress = (GL.getICD()).glGetActiveVaryingNV;
/* 239 */     if (Checks.CHECKS) {
/* 240 */       Checks.check(__functionAddress);
/* 241 */       Checks.checkSafe(length, 1);
/* 242 */       Checks.check(size, 1);
/* 243 */       Checks.check(type, 1);
/*     */     } 
/* 245 */     JNI.callPPPPV(program, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTransformFeedbackVaryingNV(@NativeType("GLuint") int program, @NativeType("GLuint") int index, @NativeType("GLint *") int[] location) {
/* 250 */     long __functionAddress = (GL.getICD()).glGetTransformFeedbackVaryingNV;
/* 251 */     if (Checks.CHECKS) {
/* 252 */       Checks.check(__functionAddress);
/* 253 */       Checks.check(location, 1);
/*     */     } 
/* 255 */     JNI.callPV(program, index, location, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackStreamAttribsNV(@NativeType("GLint const *") int[] attribs, @NativeType("GLint const *") int[] bufstreams, @NativeType("GLenum") int bufferMode) {
/* 260 */     long __functionAddress = (GL.getICD()).glTransformFeedbackStreamAttribsNV;
/* 261 */     if (Checks.CHECKS) {
/* 262 */       Checks.check(__functionAddress);
/*     */     }
/* 264 */     JNI.callPPV(attribs.length, attribs, bufstreams.length, bufstreams, bufferMode, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glBeginTransformFeedbackNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glEndTransformFeedbackNV();
/*     */   
/*     */   public static native void nglTransformFeedbackAttribsNV(int paramInt1, long paramLong, int paramInt2);
/*     */   
/*     */   public static native void glBindBufferRangeNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*     */   
/*     */   public static native void glBindBufferOffsetNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong);
/*     */   
/*     */   public static native void glBindBufferBaseNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void nglTransformFeedbackVaryingsNV(int paramInt1, int paramInt2, long paramLong, int paramInt3);
/*     */   
/*     */   public static native void nglActiveVaryingNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native int nglGetVaryingLocationNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveVaryingNV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native void nglGetTransformFeedbackVaryingNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglTransformFeedbackStreamAttribsNV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVTransformFeedback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */