/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBVertexBlend {
/*     */   public static final int GL_MAX_VERTEX_UNITS_ARB = 34468;
/*     */   public static final int GL_ACTIVE_VERTEX_UNITS_ARB = 34469;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_WEIGHT_SUM_UNITY_ARB = 34470;
/*     */   
/*     */   public static final int GL_VERTEX_BLEND_ARB = 34471;
/*     */   
/*     */   public static final int GL_MODELVIEW0_ARB = 5888;
/*     */   
/*     */   public static final int GL_MODELVIEW1_ARB = 34058;
/*     */   
/*     */   public static final int GL_MODELVIEW2_ARB = 34594;
/*     */   
/*     */   public static final int GL_MODELVIEW3_ARB = 34595;
/*     */   
/*     */   public static final int GL_MODELVIEW4_ARB = 34596;
/*     */   
/*     */   public static final int GL_MODELVIEW5_ARB = 34597;
/*     */   
/*     */   public static final int GL_MODELVIEW6_ARB = 34598;
/*     */   
/*     */   public static final int GL_MODELVIEW7_ARB = 34599;
/*     */   
/*     */   public static final int GL_MODELVIEW8_ARB = 34600;
/*     */   public static final int GL_MODELVIEW9_ARB = 34601;
/*     */   public static final int GL_MODELVIEW10_ARB = 34602;
/*     */   public static final int GL_MODELVIEW11_ARB = 34603;
/*     */   public static final int GL_MODELVIEW12_ARB = 34604;
/*     */   public static final int GL_MODELVIEW13_ARB = 34605;
/*     */   public static final int GL_MODELVIEW14_ARB = 34606;
/*     */   public static final int GL_MODELVIEW15_ARB = 34607;
/*     */   public static final int GL_MODELVIEW16_ARB = 34608;
/*     */   public static final int GL_MODELVIEW17_ARB = 34609;
/*     */   public static final int GL_MODELVIEW18_ARB = 34610;
/*     */   public static final int GL_MODELVIEW19_ARB = 34611;
/*     */   public static final int GL_MODELVIEW20_ARB = 34612;
/*     */   public static final int GL_MODELVIEW21_ARB = 34613;
/*     */   public static final int GL_MODELVIEW22_ARB = 34614;
/*     */   public static final int GL_MODELVIEW23_ARB = 34615;
/*     */   public static final int GL_MODELVIEW24_ARB = 34616;
/*     */   public static final int GL_MODELVIEW25_ARB = 34617;
/*     */   public static final int GL_MODELVIEW26_ARB = 34618;
/*     */   public static final int GL_MODELVIEW27_ARB = 34619;
/*     */   public static final int GL_MODELVIEW28_ARB = 34620;
/*     */   public static final int GL_MODELVIEW29_ARB = 34621;
/*     */   public static final int GL_MODELVIEW30_ARB = 34622;
/*     */   public static final int GL_MODELVIEW31_ARB = 34623;
/*     */   public static final int GL_CURRENT_WEIGHT_ARB = 34472;
/*     */   public static final int GL_WEIGHT_ARRAY_TYPE_ARB = 34473;
/*     */   public static final int GL_WEIGHT_ARRAY_STRIDE_ARB = 34474;
/*     */   public static final int GL_WEIGHT_ARRAY_SIZE_ARB = 34475;
/*     */   public static final int GL_WEIGHT_ARRAY_POINTER_ARB = 34476;
/*     */   public static final int GL_WEIGHT_ARRAY_ARB = 34477;
/*     */   
/*     */   protected ARBVertexBlend() {
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightfvARB(@NativeType("GLfloat *") FloatBuffer weights) {
/*  84 */     nglWeightfvARB(weights.remaining(), MemoryUtil.memAddress(weights));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightbvARB(@NativeType("GLbyte *") ByteBuffer weights) {
/*  94 */     nglWeightbvARB(weights.remaining(), MemoryUtil.memAddress(weights));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightubvARB(@NativeType("GLubyte *") ByteBuffer weights) {
/* 104 */     nglWeightubvARB(weights.remaining(), MemoryUtil.memAddress(weights));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightsvARB(@NativeType("GLshort *") ShortBuffer weights) {
/* 114 */     nglWeightsvARB(weights.remaining(), MemoryUtil.memAddress(weights));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightusvARB(@NativeType("GLushort *") ShortBuffer weights) {
/* 124 */     nglWeightusvARB(weights.remaining(), MemoryUtil.memAddress(weights));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightivARB(@NativeType("GLint *") IntBuffer weights) {
/* 134 */     nglWeightivARB(weights.remaining(), MemoryUtil.memAddress(weights));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightuivARB(@NativeType("GLuint *") IntBuffer weights) {
/* 144 */     nglWeightuivARB(weights.remaining(), MemoryUtil.memAddress(weights));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightdvARB(@NativeType("GLdouble *") DoubleBuffer weights) {
/* 154 */     nglWeightdvARB(weights.remaining(), MemoryUtil.memAddress(weights));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 164 */     nglWeightPointerARB(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 169 */     nglWeightPointerARB(size, type, stride, pointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ShortBuffer pointer) {
/* 174 */     nglWeightPointerARB(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") IntBuffer pointer) {
/* 179 */     nglWeightPointerARB(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") FloatBuffer pointer) {
/* 184 */     nglWeightPointerARB(size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWeightfvARB(@NativeType("GLfloat *") float[] weights) {
/* 194 */     long __functionAddress = (GL.getICD()).glWeightfvARB;
/* 195 */     if (Checks.CHECKS) {
/* 196 */       Checks.check(__functionAddress);
/*     */     }
/* 198 */     JNI.callPV(weights.length, weights, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightsvARB(@NativeType("GLshort *") short[] weights) {
/* 203 */     long __functionAddress = (GL.getICD()).glWeightsvARB;
/* 204 */     if (Checks.CHECKS) {
/* 205 */       Checks.check(__functionAddress);
/*     */     }
/* 207 */     JNI.callPV(weights.length, weights, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightusvARB(@NativeType("GLushort *") short[] weights) {
/* 212 */     long __functionAddress = (GL.getICD()).glWeightusvARB;
/* 213 */     if (Checks.CHECKS) {
/* 214 */       Checks.check(__functionAddress);
/*     */     }
/* 216 */     JNI.callPV(weights.length, weights, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightivARB(@NativeType("GLint *") int[] weights) {
/* 221 */     long __functionAddress = (GL.getICD()).glWeightivARB;
/* 222 */     if (Checks.CHECKS) {
/* 223 */       Checks.check(__functionAddress);
/*     */     }
/* 225 */     JNI.callPV(weights.length, weights, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightuivARB(@NativeType("GLuint *") int[] weights) {
/* 230 */     long __functionAddress = (GL.getICD()).glWeightuivARB;
/* 231 */     if (Checks.CHECKS) {
/* 232 */       Checks.check(__functionAddress);
/*     */     }
/* 234 */     JNI.callPV(weights.length, weights, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightdvARB(@NativeType("GLdouble *") double[] weights) {
/* 239 */     long __functionAddress = (GL.getICD()).glWeightdvARB;
/* 240 */     if (Checks.CHECKS) {
/* 241 */       Checks.check(__functionAddress);
/*     */     }
/* 243 */     JNI.callPV(weights.length, weights, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") short[] pointer) {
/* 248 */     long __functionAddress = (GL.getICD()).glWeightPointerARB;
/* 249 */     if (Checks.CHECKS) {
/* 250 */       Checks.check(__functionAddress);
/*     */     }
/* 252 */     JNI.callPV(size, type, stride, pointer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") int[] pointer) {
/* 257 */     long __functionAddress = (GL.getICD()).glWeightPointerARB;
/* 258 */     if (Checks.CHECKS) {
/* 259 */       Checks.check(__functionAddress);
/*     */     }
/* 261 */     JNI.callPV(size, type, stride, pointer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") float[] pointer) {
/* 266 */     long __functionAddress = (GL.getICD()).glWeightPointerARB;
/* 267 */     if (Checks.CHECKS) {
/* 268 */       Checks.check(__functionAddress);
/*     */     }
/* 270 */     JNI.callPV(size, type, stride, pointer, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglWeightfvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightbvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightubvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightsvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightusvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightuivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightdvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightPointerARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glVertexBlendARB(@NativeType("GLint") int paramInt);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBVertexBlend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */