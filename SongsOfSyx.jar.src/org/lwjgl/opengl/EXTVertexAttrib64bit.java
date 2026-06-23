/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class EXTVertexAttrib64bit
/*     */ {
/*     */   public static final int GL_DOUBLE_VEC2_EXT = 36860;
/*     */   public static final int GL_DOUBLE_VEC3_EXT = 36861;
/*     */   public static final int GL_DOUBLE_VEC4_EXT = 36862;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_DOUBLE_MAT2_EXT = 36678;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT3_EXT = 36679;
/*     */   
/*     */   public static final int GL_DOUBLE_MAT4_EXT = 36680;
/*     */   public static final int GL_DOUBLE_MAT2x3_EXT = 36681;
/*     */   public static final int GL_DOUBLE_MAT2x4_EXT = 36682;
/*     */   public static final int GL_DOUBLE_MAT3x2_EXT = 36683;
/*     */   public static final int GL_DOUBLE_MAT3x4_EXT = 36684;
/*     */   public static final int GL_DOUBLE_MAT4x2_EXT = 36685;
/*     */   public static final int GL_DOUBLE_MAT4x3_EXT = 36686;
/*     */   
/*     */   protected EXTVertexAttrib64bit() {
/*  35 */     throw new UnsupportedOperationException();
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
/*     */   public static void glVertexAttribL1dvEXT(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(v, 1);
/*     */     }
/*  68 */     nglVertexAttribL1dvEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2dvEXT(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  78 */     if (Checks.CHECKS) {
/*  79 */       Checks.check(v, 2);
/*     */     }
/*  81 */     nglVertexAttribL2dvEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3dvEXT(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/*  91 */     if (Checks.CHECKS) {
/*  92 */       Checks.check(v, 3);
/*     */     }
/*  94 */     nglVertexAttribL3dvEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4dvEXT(@NativeType("GLuint") int index, @NativeType("GLdouble const *") DoubleBuffer v) {
/* 104 */     if (Checks.CHECKS) {
/* 105 */       Checks.check(v, 4);
/*     */     }
/* 107 */     nglVertexAttribL4dvEXT(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribLPointerEXT(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") ByteBuffer pointer) {
/* 117 */     nglVertexAttribLPointerEXT(index, size, type, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribLPointerEXT(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("void const *") long pointer) {
/* 122 */     nglVertexAttribLPointerEXT(index, size, type, stride, pointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribLPointerEXT(@NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLsizei") int stride, @NativeType("void const *") DoubleBuffer pointer) {
/* 127 */     nglVertexAttribLPointerEXT(index, size, 5130, stride, MemoryUtil.memAddress(pointer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLdvEXT(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") DoubleBuffer params) {
/* 137 */     if (Checks.CHECKS) {
/* 138 */       Checks.check(params, 4);
/*     */     }
/* 140 */     nglGetVertexAttribLdvEXT(index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexArrayVertexAttribLOffsetEXT(@NativeType("GLuint") int vaobj, @NativeType("GLuint") int buffer, @NativeType("GLuint") int index, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLsizei") int stride, @NativeType("GLintptr") long offset) {
/* 147 */     ARBVertexAttrib64Bit.glVertexArrayVertexAttribLOffsetEXT(vaobj, buffer, index, size, type, stride, offset);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL1dvEXT(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 152 */     long __functionAddress = (GL.getICD()).glVertexAttribL1dvEXT;
/* 153 */     if (Checks.CHECKS) {
/* 154 */       Checks.check(__functionAddress);
/* 155 */       Checks.check(v, 1);
/*     */     } 
/* 157 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2dvEXT(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 162 */     long __functionAddress = (GL.getICD()).glVertexAttribL2dvEXT;
/* 163 */     if (Checks.CHECKS) {
/* 164 */       Checks.check(__functionAddress);
/* 165 */       Checks.check(v, 2);
/*     */     } 
/* 167 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3dvEXT(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 172 */     long __functionAddress = (GL.getICD()).glVertexAttribL3dvEXT;
/* 173 */     if (Checks.CHECKS) {
/* 174 */       Checks.check(__functionAddress);
/* 175 */       Checks.check(v, 3);
/*     */     } 
/* 177 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4dvEXT(@NativeType("GLuint") int index, @NativeType("GLdouble const *") double[] v) {
/* 182 */     long __functionAddress = (GL.getICD()).glVertexAttribL4dvEXT;
/* 183 */     if (Checks.CHECKS) {
/* 184 */       Checks.check(__functionAddress);
/* 185 */       Checks.check(v, 4);
/*     */     } 
/* 187 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLdvEXT(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLdouble *") double[] params) {
/* 192 */     long __functionAddress = (GL.getICD()).glGetVertexAttribLdvEXT;
/* 193 */     if (Checks.CHECKS) {
/* 194 */       Checks.check(__functionAddress);
/* 195 */       Checks.check(params, 4);
/*     */     } 
/* 197 */     JNI.callPV(index, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glVertexAttribL1dEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void glVertexAttribL2dEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void glVertexAttribL3dEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void glVertexAttribL4dEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*     */   
/*     */   public static native void nglVertexAttribL1dvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL2dvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL3dvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL4dvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribLPointerEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribLdvEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTVertexAttrib64bit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */