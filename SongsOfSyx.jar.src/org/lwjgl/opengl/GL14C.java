/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL14C
/*     */   extends GL13C
/*     */ {
/*     */   public static final int GL_CONSTANT_COLOR = 32769;
/*     */   public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
/*     */   public static final int GL_CONSTANT_ALPHA = 32771;
/*     */   
/*     */   static {
/*  20 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
/*     */   
/*     */   public static final int GL_BLEND_COLOR = 32773;
/*     */   
/*     */   public static final int GL_FUNC_ADD = 32774;
/*     */   
/*     */   public static final int GL_MIN = 32775;
/*     */   
/*     */   public static final int GL_MAX = 32776;
/*     */   
/*     */   public static final int GL_BLEND_EQUATION = 32777;
/*     */   
/*     */   public static final int GL_FUNC_SUBTRACT = 32778;
/*     */   
/*     */   public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
/*     */   
/*     */   public static final int GL_DEPTH_COMPONENT16 = 33189;
/*     */   
/*     */   public static final int GL_DEPTH_COMPONENT24 = 33190;
/*     */   
/*     */   public static final int GL_DEPTH_COMPONENT32 = 33191;
/*     */   
/*     */   public static final int GL_TEXTURE_DEPTH_SIZE = 34890;
/*     */   
/*     */   public static final int GL_TEXTURE_COMPARE_MODE = 34892;
/*     */   
/*     */   public static final int GL_TEXTURE_COMPARE_FUNC = 34893;
/*     */   
/*     */   public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064;
/*     */   
/*     */   public static final int GL_BLEND_DST_RGB = 32968;
/*     */   
/*     */   public static final int GL_BLEND_SRC_RGB = 32969;
/*     */   
/*     */   public static final int GL_BLEND_DST_ALPHA = 32970;
/*     */   
/*     */   public static final int GL_BLEND_SRC_ALPHA = 32971;
/*     */   
/*     */   public static final int GL_INCR_WRAP = 34055;
/*     */   
/*     */   public static final int GL_DECR_WRAP = 34056;
/*     */   
/*     */   public static final int GL_TEXTURE_LOD_BIAS = 34049;
/*     */   public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045;
/*     */   public static final int GL_MIRRORED_REPEAT = 33648;
/*     */   
/*     */   protected GL14C() {
/*  71 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMultiDrawArrays(@NativeType("GLenum") int mode, @NativeType("GLint const *") IntBuffer first, @NativeType("GLsizei const *") IntBuffer count) {
/*  91 */     if (Checks.CHECKS) {
/*  92 */       Checks.check(count, first.remaining());
/*     */     }
/*  94 */     nglMultiDrawArrays(mode, MemoryUtil.memAddress(first), MemoryUtil.memAddress(count), first.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElements(@NativeType("GLenum") int mode, @NativeType("GLsizei *") IntBuffer count, @NativeType("GLenum") int type, @NativeType("void const **") PointerBuffer indices) {
/* 104 */     if (Checks.CHECKS) {
/* 105 */       Checks.check((CustomBuffer)indices, count.remaining());
/*     */     }
/* 107 */     nglMultiDrawElements(mode, MemoryUtil.memAddress(count), type, MemoryUtil.memAddress((CustomBuffer)indices), count.remaining());
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
/*     */   public static void glPointParameterfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 127 */     if (Checks.CHECKS) {
/* 128 */       Checks.check(params, 3);
/*     */     }
/* 130 */     nglPointParameterfv(pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPointParameteriv(@NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 140 */     if (Checks.CHECKS) {
/* 141 */       Checks.check(params, 3);
/*     */     }
/* 143 */     nglPointParameteriv(pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArrays(@NativeType("GLenum") int mode, @NativeType("GLint const *") int[] first, @NativeType("GLsizei const *") int[] count) {
/* 153 */     long __functionAddress = (GL.getICD()).glMultiDrawArrays;
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(__functionAddress);
/* 156 */       Checks.check(count, first.length);
/*     */     } 
/* 158 */     JNI.callPPV(mode, first, count, first.length, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElements(@NativeType("GLenum") int mode, @NativeType("GLsizei *") int[] count, @NativeType("GLenum") int type, @NativeType("void const **") PointerBuffer indices) {
/* 163 */     long __functionAddress = (GL.getICD()).glMultiDrawElements;
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(__functionAddress);
/* 166 */       Checks.check((CustomBuffer)indices, count.length);
/*     */     } 
/* 168 */     JNI.callPPV(mode, count, type, MemoryUtil.memAddress((CustomBuffer)indices), count.length, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPointParameterfv(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 173 */     long __functionAddress = (GL.getICD()).glPointParameterfv;
/* 174 */     if (Checks.CHECKS) {
/* 175 */       Checks.check(__functionAddress);
/* 176 */       Checks.check(params, 3);
/*     */     } 
/* 178 */     JNI.callPV(pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPointParameteriv(@NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 183 */     long __functionAddress = (GL.getICD()).glPointParameteriv;
/* 184 */     if (Checks.CHECKS) {
/* 185 */       Checks.check(__functionAddress);
/* 186 */       Checks.check(params, 3);
/*     */     } 
/* 188 */     JNI.callPV(pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glBlendColor(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*     */   
/*     */   public static native void glBlendEquation(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglMultiDrawArrays(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native void nglMultiDrawElements(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3);
/*     */   
/*     */   public static native void glPointParameterf(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void glPointParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void nglPointParameterfv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglPointParameteriv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glBlendFuncSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL14C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */