/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBMultiDrawIndirect
/*    */ {
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */   protected ARBMultiDrawIndirect() {
/* 17 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglMultiDrawArraysIndirect(int mode, long indirect, int drawcount, int stride) {
/* 24 */     GL43C.nglMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 29 */     GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 34 */     GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 39 */     GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglMultiDrawElementsIndirect(int mode, int type, long indirect, int drawcount, int stride) {
/* 46 */     GL43C.nglMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 51 */     GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 56 */     GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 61 */     GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") int[] indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 66 */     GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") int[] indirect, @NativeType("GLsizei") int drawcount, @NativeType("GLsizei") int stride) {
/* 71 */     GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBMultiDrawIndirect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */