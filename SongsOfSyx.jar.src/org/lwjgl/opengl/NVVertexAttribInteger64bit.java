/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVVertexAttribInteger64bit
/*     */ {
/*     */   public static final int GL_INT64_NV = 5134;
/*     */   public static final int GL_UNSIGNED_INT64_NV = 5135;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected NVVertexAttribInteger64bit() {
/*  26 */     throw new UnsupportedOperationException();
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
/*     */   public static void glVertexAttribL1i64vNV(@NativeType("GLuint") int index, @NativeType("GLint64EXT const *") LongBuffer v) {
/*  56 */     if (Checks.CHECKS) {
/*  57 */       Checks.check(v, 1);
/*     */     }
/*  59 */     nglVertexAttribL1i64vNV(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2i64vNV(@NativeType("GLuint") int index, @NativeType("GLint64EXT const *") LongBuffer v) {
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.check(v, 2);
/*     */     }
/*  72 */     nglVertexAttribL2i64vNV(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3i64vNV(@NativeType("GLuint") int index, @NativeType("GLint64EXT const *") LongBuffer v) {
/*  82 */     if (Checks.CHECKS) {
/*  83 */       Checks.check(v, 3);
/*     */     }
/*  85 */     nglVertexAttribL3i64vNV(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4i64vNV(@NativeType("GLuint") int index, @NativeType("GLint64EXT const *") LongBuffer v) {
/*  95 */     if (Checks.CHECKS) {
/*  96 */       Checks.check(v, 4);
/*     */     }
/*  98 */     nglVertexAttribL4i64vNV(index, MemoryUtil.memAddress(v));
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
/*     */   public static void glVertexAttribL1ui64vNV(@NativeType("GLuint") int index, @NativeType("GLuint64EXT const *") LongBuffer v) {
/* 128 */     if (Checks.CHECKS) {
/* 129 */       Checks.check(v, 1);
/*     */     }
/* 131 */     nglVertexAttribL1ui64vNV(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2ui64vNV(@NativeType("GLuint") int index, @NativeType("GLuint64EXT const *") LongBuffer v) {
/* 141 */     if (Checks.CHECKS) {
/* 142 */       Checks.check(v, 2);
/*     */     }
/* 144 */     nglVertexAttribL2ui64vNV(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3ui64vNV(@NativeType("GLuint") int index, @NativeType("GLuint64EXT const *") LongBuffer v) {
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(v, 3);
/*     */     }
/* 157 */     nglVertexAttribL3ui64vNV(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4ui64vNV(@NativeType("GLuint") int index, @NativeType("GLuint64EXT const *") LongBuffer v) {
/* 167 */     if (Checks.CHECKS) {
/* 168 */       Checks.check(v, 4);
/*     */     }
/* 170 */     nglVertexAttribL4ui64vNV(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLi64vNV(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint64EXT *") LongBuffer params) {
/* 180 */     if (Checks.CHECKS) {
/* 181 */       Checks.check(params, 1);
/*     */     }
/* 183 */     nglGetVertexAttribLi64vNV(index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetVertexAttribLi64NV(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 189 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 191 */       LongBuffer params = stack.callocLong(1);
/* 192 */       nglGetVertexAttribLi64vNV(index, pname, MemoryUtil.memAddress(params));
/* 193 */       return params.get(0);
/*     */     } finally {
/* 195 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLui64vNV(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLuint64EXT *") LongBuffer params) {
/* 206 */     if (Checks.CHECKS) {
/* 207 */       Checks.check(params, 1);
/*     */     }
/* 209 */     nglGetVertexAttribLui64vNV(index, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetVertexAttribLui64NV(@NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 215 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 217 */       LongBuffer params = stack.callocLong(1);
/* 218 */       nglGetVertexAttribLui64vNV(index, pname, MemoryUtil.memAddress(params));
/* 219 */       return params.get(0);
/*     */     } finally {
/* 221 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL1i64vNV(@NativeType("GLuint") int index, @NativeType("GLint64EXT const *") long[] v) {
/* 232 */     long __functionAddress = (GL.getICD()).glVertexAttribL1i64vNV;
/* 233 */     if (Checks.CHECKS) {
/* 234 */       Checks.check(__functionAddress);
/* 235 */       Checks.check(v, 1);
/*     */     } 
/* 237 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2i64vNV(@NativeType("GLuint") int index, @NativeType("GLint64EXT const *") long[] v) {
/* 242 */     long __functionAddress = (GL.getICD()).glVertexAttribL2i64vNV;
/* 243 */     if (Checks.CHECKS) {
/* 244 */       Checks.check(__functionAddress);
/* 245 */       Checks.check(v, 2);
/*     */     } 
/* 247 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3i64vNV(@NativeType("GLuint") int index, @NativeType("GLint64EXT const *") long[] v) {
/* 252 */     long __functionAddress = (GL.getICD()).glVertexAttribL3i64vNV;
/* 253 */     if (Checks.CHECKS) {
/* 254 */       Checks.check(__functionAddress);
/* 255 */       Checks.check(v, 3);
/*     */     } 
/* 257 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4i64vNV(@NativeType("GLuint") int index, @NativeType("GLint64EXT const *") long[] v) {
/* 262 */     long __functionAddress = (GL.getICD()).glVertexAttribL4i64vNV;
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.check(__functionAddress);
/* 265 */       Checks.check(v, 4);
/*     */     } 
/* 267 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL1ui64vNV(@NativeType("GLuint") int index, @NativeType("GLuint64EXT const *") long[] v) {
/* 272 */     long __functionAddress = (GL.getICD()).glVertexAttribL1ui64vNV;
/* 273 */     if (Checks.CHECKS) {
/* 274 */       Checks.check(__functionAddress);
/* 275 */       Checks.check(v, 1);
/*     */     } 
/* 277 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2ui64vNV(@NativeType("GLuint") int index, @NativeType("GLuint64EXT const *") long[] v) {
/* 282 */     long __functionAddress = (GL.getICD()).glVertexAttribL2ui64vNV;
/* 283 */     if (Checks.CHECKS) {
/* 284 */       Checks.check(__functionAddress);
/* 285 */       Checks.check(v, 2);
/*     */     } 
/* 287 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3ui64vNV(@NativeType("GLuint") int index, @NativeType("GLuint64EXT const *") long[] v) {
/* 292 */     long __functionAddress = (GL.getICD()).glVertexAttribL3ui64vNV;
/* 293 */     if (Checks.CHECKS) {
/* 294 */       Checks.check(__functionAddress);
/* 295 */       Checks.check(v, 3);
/*     */     } 
/* 297 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4ui64vNV(@NativeType("GLuint") int index, @NativeType("GLuint64EXT const *") long[] v) {
/* 302 */     long __functionAddress = (GL.getICD()).glVertexAttribL4ui64vNV;
/* 303 */     if (Checks.CHECKS) {
/* 304 */       Checks.check(__functionAddress);
/* 305 */       Checks.check(v, 4);
/*     */     } 
/* 307 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLi64vNV(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint64EXT *") long[] params) {
/* 312 */     long __functionAddress = (GL.getICD()).glGetVertexAttribLi64vNV;
/* 313 */     if (Checks.CHECKS) {
/* 314 */       Checks.check(__functionAddress);
/* 315 */       Checks.check(params, 1);
/*     */     } 
/* 317 */     JNI.callPV(index, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLui64vNV(@NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLuint64EXT *") long[] params) {
/* 322 */     long __functionAddress = (GL.getICD()).glGetVertexAttribLui64vNV;
/* 323 */     if (Checks.CHECKS) {
/* 324 */       Checks.check(__functionAddress);
/* 325 */       Checks.check(params, 1);
/*     */     } 
/* 327 */     JNI.callPV(index, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glVertexAttribL1i64NV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT") long paramLong);
/*     */   
/*     */   public static native void glVertexAttribL2i64NV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glVertexAttribL3i64NV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glVertexAttribL4i64NV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3, @NativeType("GLint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglVertexAttribL1i64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL2i64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL3i64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL4i64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glVertexAttribL1ui64NV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void glVertexAttribL2ui64NV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glVertexAttribL3ui64NV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glVertexAttribL4ui64NV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3, @NativeType("GLuint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglVertexAttribL1ui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL2ui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL3ui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL4ui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribLi64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribLui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glVertexAttribLFormatNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVVertexAttribInteger64bit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */