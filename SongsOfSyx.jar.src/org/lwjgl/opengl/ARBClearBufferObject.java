/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ 
/*     */ 
/*     */ public class ARBClearBufferObject
/*     */ {
/*     */   static {
/*  20 */     GL.initialize();
/*     */   }
/*     */   protected ARBClearBufferObject() {
/*  23 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglClearBufferData(int target, int internalformat, int format, int type, long data) {
/*  30 */     GL43C.nglClearBufferData(target, internalformat, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  35 */     GL43C.glClearBufferData(target, internalformat, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  40 */     GL43C.glClearBufferData(target, internalformat, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  45 */     GL43C.glClearBufferData(target, internalformat, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  50 */     GL43C.glClearBufferData(target, internalformat, format, type, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, long data) {
/*  57 */     GL43C.nglClearBufferSubData(target, internalformat, offset, size, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  62 */     GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  67 */     GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  72 */     GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/*  77 */     GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/*  87 */     nglClearNamedBufferDataEXT(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/*  92 */     nglClearNamedBufferDataEXT(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/*  97 */     nglClearNamedBufferDataEXT(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/* 102 */     nglClearNamedBufferDataEXT(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer data) {
/* 112 */     nglClearNamedBufferSubDataEXT(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") ShortBuffer data) {
/* 117 */     nglClearNamedBufferSubDataEXT(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer data) {
/* 122 */     nglClearNamedBufferSubDataEXT(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") FloatBuffer data) {
/* 127 */     nglClearNamedBufferSubDataEXT(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 132 */     GL43C.glClearBufferData(target, internalformat, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 137 */     GL43C.glClearBufferData(target, internalformat, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 142 */     GL43C.glClearBufferData(target, internalformat, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 147 */     GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 152 */     GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 157 */     GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 162 */     long __functionAddress = (GL.getICD()).glClearNamedBufferDataEXT;
/* 163 */     if (Checks.CHECKS) {
/* 164 */       Checks.check(__functionAddress);
/*     */     }
/* 166 */     JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 171 */     long __functionAddress = (GL.getICD()).glClearNamedBufferDataEXT;
/* 172 */     if (Checks.CHECKS) {
/* 173 */       Checks.check(__functionAddress);
/*     */     }
/* 175 */     JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 180 */     long __functionAddress = (GL.getICD()).glClearNamedBufferDataEXT;
/* 181 */     if (Checks.CHECKS) {
/* 182 */       Checks.check(__functionAddress);
/*     */     }
/* 184 */     JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") short[] data) {
/* 189 */     long __functionAddress = (GL.getICD()).glClearNamedBufferSubDataEXT;
/* 190 */     if (Checks.CHECKS) {
/* 191 */       Checks.check(__functionAddress);
/*     */     }
/* 193 */     JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") int[] data) {
/* 198 */     long __functionAddress = (GL.getICD()).glClearNamedBufferSubDataEXT;
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check(__functionAddress);
/*     */     }
/* 202 */     JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int buffer, @NativeType("GLenum") int internalformat, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int format, @NativeType("GLenum") int type, @NativeType("void const *") float[] data) {
/* 207 */     long __functionAddress = (GL.getICD()).glClearNamedBufferSubDataEXT;
/* 208 */     if (Checks.CHECKS) {
/* 209 */       Checks.check(__functionAddress);
/*     */     }
/* 211 */     JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglClearNamedBufferDataEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglClearNamedBufferSubDataEXT(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBClearBufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */