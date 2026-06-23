/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBMultiBind
/*     */ {
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */   protected ARBMultiBind() {
/*  21 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindBuffersBase(int target, int first, int count, long buffers) {
/*  28 */     GL44C.nglBindBuffersBase(target, first, count, buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersBase(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers) {
/*  33 */     GL44C.glBindBuffersBase(target, first, buffers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindBuffersRange(int target, int first, int count, long buffers, long offsets, long sizes) {
/*  40 */     GL44C.nglBindBuffersRange(target, first, count, buffers, offsets, sizes);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersRange(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizeiptr const *") PointerBuffer sizes) {
/*  45 */     GL44C.glBindBuffersRange(target, first, buffers, offsets, sizes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindTextures(int first, int count, long textures) {
/*  52 */     GL44C.nglBindTextures(first, count, textures);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer textures) {
/*  57 */     GL44C.glBindTextures(first, textures);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindSamplers(int first, int count, long samplers) {
/*  64 */     GL44C.nglBindSamplers(first, count, samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindSamplers(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer samplers) {
/*  69 */     GL44C.glBindSamplers(first, samplers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindImageTextures(int first, int count, long textures) {
/*  76 */     GL44C.nglBindImageTextures(first, count, textures);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindImageTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer textures) {
/*  81 */     GL44C.glBindImageTextures(first, textures);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindVertexBuffers(int first, int count, long buffers, long offsets, long strides) {
/*  88 */     GL44C.nglBindVertexBuffers(first, count, buffers, offsets, strides);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindVertexBuffers(@NativeType("GLuint") int first, @NativeType("GLuint const *") IntBuffer buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") IntBuffer strides) {
/*  93 */     GL44C.glBindVertexBuffers(first, buffers, offsets, strides);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersBase(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers) {
/*  98 */     GL44C.glBindBuffersBase(target, first, buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindBuffersRange(@NativeType("GLenum") int target, @NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizeiptr const *") PointerBuffer sizes) {
/* 103 */     GL44C.glBindBuffersRange(target, first, buffers, offsets, sizes);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] textures) {
/* 108 */     GL44C.glBindTextures(first, textures);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindSamplers(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] samplers) {
/* 113 */     GL44C.glBindSamplers(first, samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindImageTextures(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] textures) {
/* 118 */     GL44C.glBindImageTextures(first, textures);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBindVertexBuffers(@NativeType("GLuint") int first, @NativeType("GLuint const *") int[] buffers, @NativeType("GLintptr const *") PointerBuffer offsets, @NativeType("GLsizei const *") int[] strides) {
/* 123 */     GL44C.glBindVertexBuffers(first, buffers, offsets, strides);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBMultiBind.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */