/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import java.nio.ShortBuffer;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTDrawInstanced
/*    */ {
/*    */   static {
/* 16 */     GL.initialize();
/*    */   }
/*    */   protected EXTDrawInstanced() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int mode, @NativeType("GLsizei") int count, @NativeType("GLenum") int type, @NativeType("void const *") long indices, @NativeType("GLsizei") int primcount) {
/* 34 */     nglDrawElementsInstancedEXT(mode, count, type, indices, primcount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount) {
/* 39 */     nglDrawElementsInstancedEXT(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), primcount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indices, @NativeType("GLsizei") int primcount) {
/* 44 */     nglDrawElementsInstancedEXT(mode, indices.remaining(), 5121, MemoryUtil.memAddress(indices), primcount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int mode, @NativeType("void const *") ShortBuffer indices, @NativeType("GLsizei") int primcount) {
/* 49 */     nglDrawElementsInstancedEXT(mode, indices.remaining(), 5123, MemoryUtil.memAddress(indices), primcount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indices, @NativeType("GLsizei") int primcount) {
/* 54 */     nglDrawElementsInstancedEXT(mode, indices.remaining(), 5125, MemoryUtil.memAddress(indices), primcount);
/*    */   }
/*    */   
/*    */   public static native void glDrawArraysInstancedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*    */   
/*    */   public static native void nglDrawElementsInstancedEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTDrawInstanced.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */