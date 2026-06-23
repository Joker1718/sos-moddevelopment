/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBDrawElementsBaseVertex
/*     */ {
/*     */   static {
/*  16 */     GL.initialize();
/*     */   }
/*     */   protected ARBDrawElementsBaseVertex() {
/*  19 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawElementsBaseVertex(int mode, int count, int type, long indices, int basevertex) {
/*  26 */     GL32C.nglDrawElementsBaseVertex(mode, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLint") int basevertex) {
/*  31 */     GL32C.glDrawElementsBaseVertex(mode, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/*  36 */     GL32C.glDrawElementsBaseVertex(mode, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/*  41 */     GL32C.glDrawElementsBaseVertex(mode, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices, @NativeType("GLint") int basevertex) {
/*  46 */     GL32C.glDrawElementsBaseVertex(mode, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices, @NativeType("GLint") int basevertex) {
/*  51 */     GL32C.glDrawElementsBaseVertex(mode, indices, basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, long indices, int basevertex) {
/*  58 */     GL32C.nglDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLint") int basevertex) {
/*  63 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/*  68 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") ByteBuffer indices, @NativeType("GLint") int basevertex) {
/*  73 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") ShortBuffer indices, @NativeType("GLint") int basevertex) {
/*  78 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLuint") int start, @NativeType("GLuint") int end, @NativeType("void const *") IntBuffer indices, @NativeType("GLint") int basevertex) {
/*  83 */     GL32C.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawElementsInstancedBaseVertex(int mode, int count, int type, long indices, int primcount, int basevertex) {
/*  90 */     GL32C.nglDrawElementsInstancedBaseVertex(mode, count, type, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/*  95 */     GL32C.glDrawElementsInstancedBaseVertex(mode, count, type, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 100 */     GL32C.glDrawElementsInstancedBaseVertex(mode, type, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 105 */     GL32C.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 110 */     GL32C.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices, @NativeType("GLsizei") int primcount, @NativeType("GLint") int basevertex) {
/* 115 */     GL32C.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiDrawElementsBaseVertex(int mode, long count, int type, long indices, int drawcount, long basevertex) {
/* 122 */     GL32C.nglMultiDrawElementsBaseVertex(mode, count, type, indices, drawcount, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei const *") IntBuffer count, @NativeType("GLenum") int type, @NativeType("void const * const *") PointerBuffer indices, @NativeType("GLint *") IntBuffer basevertex) {
/* 127 */     GL32C.glMultiDrawElementsBaseVertex(mode, count, type, indices, basevertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int mode, @NativeType("GLsizei const *") int[] count, @NativeType("GLenum") int type, @NativeType("void const * const *") PointerBuffer indices, @NativeType("GLint *") int[] basevertex) {
/* 132 */     GL32C.glMultiDrawElementsBaseVertex(mode, count, type, indices, basevertex);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBDrawElementsBaseVertex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */