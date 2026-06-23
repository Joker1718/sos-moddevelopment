/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBWindowPos
/*     */ {
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */   protected ARBWindowPos() {
/*  21 */     throw new UnsupportedOperationException();
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
/*     */   public static void glWindowPos2ivARB(@NativeType("GLint const *") IntBuffer p) {
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.check(p, 2);
/*     */     }
/*  54 */     nglWindowPos2ivARB(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos2svARB(@NativeType("GLshort const *") ShortBuffer p) {
/*  64 */     if (Checks.CHECKS) {
/*  65 */       Checks.check(p, 2);
/*     */     }
/*  67 */     nglWindowPos2svARB(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos2fvARB(@NativeType("GLfloat const *") FloatBuffer p) {
/*  77 */     if (Checks.CHECKS) {
/*  78 */       Checks.check(p, 2);
/*     */     }
/*  80 */     nglWindowPos2fvARB(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos2dvARB(@NativeType("GLdouble const *") DoubleBuffer p) {
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.check(p, 2);
/*     */     }
/*  93 */     nglWindowPos2dvARB(MemoryUtil.memAddress(p));
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
/*     */   public static void glWindowPos3ivARB(@NativeType("GLint const *") IntBuffer p) {
/* 123 */     if (Checks.CHECKS) {
/* 124 */       Checks.check(p, 3);
/*     */     }
/* 126 */     nglWindowPos3ivARB(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos3svARB(@NativeType("GLshort const *") ShortBuffer p) {
/* 136 */     if (Checks.CHECKS) {
/* 137 */       Checks.check(p, 3);
/*     */     }
/* 139 */     nglWindowPos3svARB(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos3fvARB(@NativeType("GLfloat const *") FloatBuffer p) {
/* 149 */     if (Checks.CHECKS) {
/* 150 */       Checks.check(p, 3);
/*     */     }
/* 152 */     nglWindowPos3fvARB(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWindowPos3dvARB(@NativeType("GLdouble const *") DoubleBuffer p) {
/* 162 */     if (Checks.CHECKS) {
/* 163 */       Checks.check(p, 3);
/*     */     }
/* 165 */     nglWindowPos3dvARB(MemoryUtil.memAddress(p));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2ivARB(@NativeType("GLint const *") int[] p) {
/* 170 */     long __functionAddress = (GL.getICD()).glWindowPos2ivARB;
/* 171 */     if (Checks.CHECKS) {
/* 172 */       Checks.check(__functionAddress);
/* 173 */       Checks.check(p, 2);
/*     */     } 
/* 175 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2svARB(@NativeType("GLshort const *") short[] p) {
/* 180 */     long __functionAddress = (GL.getICD()).glWindowPos2svARB;
/* 181 */     if (Checks.CHECKS) {
/* 182 */       Checks.check(__functionAddress);
/* 183 */       Checks.check(p, 2);
/*     */     } 
/* 185 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2fvARB(@NativeType("GLfloat const *") float[] p) {
/* 190 */     long __functionAddress = (GL.getICD()).glWindowPos2fvARB;
/* 191 */     if (Checks.CHECKS) {
/* 192 */       Checks.check(__functionAddress);
/* 193 */       Checks.check(p, 2);
/*     */     } 
/* 195 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2dvARB(@NativeType("GLdouble const *") double[] p) {
/* 200 */     long __functionAddress = (GL.getICD()).glWindowPos2dvARB;
/* 201 */     if (Checks.CHECKS) {
/* 202 */       Checks.check(__functionAddress);
/* 203 */       Checks.check(p, 2);
/*     */     } 
/* 205 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3ivARB(@NativeType("GLint const *") int[] p) {
/* 210 */     long __functionAddress = (GL.getICD()).glWindowPos3ivARB;
/* 211 */     if (Checks.CHECKS) {
/* 212 */       Checks.check(__functionAddress);
/* 213 */       Checks.check(p, 3);
/*     */     } 
/* 215 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3svARB(@NativeType("GLshort const *") short[] p) {
/* 220 */     long __functionAddress = (GL.getICD()).glWindowPos3svARB;
/* 221 */     if (Checks.CHECKS) {
/* 222 */       Checks.check(__functionAddress);
/* 223 */       Checks.check(p, 3);
/*     */     } 
/* 225 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3fvARB(@NativeType("GLfloat const *") float[] p) {
/* 230 */     long __functionAddress = (GL.getICD()).glWindowPos3fvARB;
/* 231 */     if (Checks.CHECKS) {
/* 232 */       Checks.check(__functionAddress);
/* 233 */       Checks.check(p, 3);
/*     */     } 
/* 235 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3dvARB(@NativeType("GLdouble const *") double[] p) {
/* 240 */     long __functionAddress = (GL.getICD()).glWindowPos3dvARB;
/* 241 */     if (Checks.CHECKS) {
/* 242 */       Checks.check(__functionAddress);
/* 243 */       Checks.check(p, 3);
/*     */     } 
/* 245 */     JNI.callPV(p, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glWindowPos2iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void glWindowPos2sARB(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*     */   
/*     */   public static native void glWindowPos2fARB(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */   
/*     */   public static native void glWindowPos2dARB(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void nglWindowPos2ivARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos2svARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos2fvARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos2dvARB(long paramLong);
/*     */   
/*     */   public static native void glWindowPos3iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glWindowPos3sARB(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glWindowPos3fARB(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glWindowPos3dARB(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void nglWindowPos3ivARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos3svARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos3fvARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos3dvARB(long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBWindowPos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */