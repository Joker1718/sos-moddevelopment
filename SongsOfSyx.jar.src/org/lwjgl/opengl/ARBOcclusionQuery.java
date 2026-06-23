/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBOcclusionQuery
/*     */ {
/*     */   public static final int GL_SAMPLES_PASSED_ARB = 35092;
/*     */   public static final int GL_QUERY_COUNTER_BITS_ARB = 34916;
/*     */   public static final int GL_CURRENT_QUERY_ARB = 34917;
/*     */   public static final int GL_QUERY_RESULT_ARB = 34918;
/*     */   public static final int GL_QUERY_RESULT_AVAILABLE_ARB = 34919;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
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
/*     */   protected ARBOcclusionQuery() {
/*  32 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenQueriesARB(@NativeType("GLuint *") IntBuffer ids) {
/*  42 */     nglGenQueriesARB(ids.remaining(), MemoryUtil.memAddress(ids));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenQueriesARB() {
/*  48 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  50 */       IntBuffer ids = stack.callocInt(1);
/*  51 */       nglGenQueriesARB(1, MemoryUtil.memAddress(ids));
/*  52 */       return ids.get(0);
/*     */     } finally {
/*  54 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteQueriesARB(@NativeType("GLuint const *") IntBuffer ids) {
/*  65 */     nglDeleteQueriesARB(ids.remaining(), MemoryUtil.memAddress(ids));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueriesARB(@NativeType("GLuint const *") int id) {
/*  70 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  72 */       IntBuffer ids = stack.ints(id);
/*  73 */       nglDeleteQueriesARB(1, MemoryUtil.memAddress(ids));
/*     */     } finally {
/*  75 */       stack.setPointer(stackPointer);
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
/*     */   public static void glGetQueryivARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(params, 1);
/*     */     }
/* 105 */     nglGetQueryivARB(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryiARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 111 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 113 */       IntBuffer params = stack.callocInt(1);
/* 114 */       nglGetQueryivARB(target, pname, MemoryUtil.memAddress(params));
/* 115 */       return params.get(0);
/*     */     } finally {
/* 117 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectivARB(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 128 */     if (Checks.CHECKS) {
/* 129 */       Checks.check(params, 1);
/*     */     }
/* 131 */     nglGetQueryObjectivARB(id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectivARB(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") long params) {
/* 136 */     nglGetQueryObjectivARB(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryObjectiARB(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 142 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 144 */       IntBuffer params = stack.callocInt(1);
/* 145 */       nglGetQueryObjectivARB(id, pname, MemoryUtil.memAddress(params));
/* 146 */       return params.get(0);
/*     */     } finally {
/* 148 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuivARB(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 159 */     if (Checks.CHECKS) {
/* 160 */       Checks.check(params, 1);
/*     */     }
/* 162 */     nglGetQueryObjectuivARB(id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuivARB(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") long params) {
/* 167 */     nglGetQueryObjectuivARB(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryObjectuiARB(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 173 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 175 */       IntBuffer params = stack.callocInt(1);
/* 176 */       nglGetQueryObjectuivARB(id, pname, MemoryUtil.memAddress(params));
/* 177 */       return params.get(0);
/*     */     } finally {
/* 179 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenQueriesARB(@NativeType("GLuint *") int[] ids) {
/* 185 */     long __functionAddress = (GL.getICD()).glGenQueriesARB;
/* 186 */     if (Checks.CHECKS) {
/* 187 */       Checks.check(__functionAddress);
/*     */     }
/* 189 */     JNI.callPV(ids.length, ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueriesARB(@NativeType("GLuint const *") int[] ids) {
/* 194 */     long __functionAddress = (GL.getICD()).glDeleteQueriesARB;
/* 195 */     if (Checks.CHECKS) {
/* 196 */       Checks.check(__functionAddress);
/*     */     }
/* 198 */     JNI.callPV(ids.length, ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryivARB(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 203 */     long __functionAddress = (GL.getICD()).glGetQueryivARB;
/* 204 */     if (Checks.CHECKS) {
/* 205 */       Checks.check(__functionAddress);
/* 206 */       Checks.check(params, 1);
/*     */     } 
/* 208 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectivARB(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 213 */     long __functionAddress = (GL.getICD()).glGetQueryObjectivARB;
/* 214 */     if (Checks.CHECKS) {
/* 215 */       Checks.check(__functionAddress);
/* 216 */       Checks.check(params, 1);
/*     */     } 
/* 218 */     JNI.callPV(id, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuivARB(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 223 */     long __functionAddress = (GL.getICD()).glGetQueryObjectuivARB;
/* 224 */     if (Checks.CHECKS) {
/* 225 */       Checks.check(__functionAddress);
/* 226 */       Checks.check(params, 1);
/*     */     } 
/* 228 */     JNI.callPV(id, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglGenQueriesARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteQueriesARB(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsQueryARB(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glBeginQueryARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glEndQueryARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglGetQueryivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetQueryObjectivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetQueryObjectuivARB(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBOcclusionQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */