/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVBindlessMultiDrawIndirectCount
/*    */ {
/*    */   static {
/* 17 */     GL.initialize();
/*    */   }
/*    */   protected NVBindlessMultiDrawIndirectCount() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirectBindlessCountNV(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLintptr") long drawCount, @NativeType("GLsizei") int maxDrawCount, @NativeType("GLsizei") int stride, @NativeType("GLint") int vertexBufferCount) {
/* 30 */     if (Checks.CHECKS) {
/* 31 */       Checks.check(indirect, maxDrawCount * ((stride == 0) ? (16 + vertexBufferCount * 24) : stride));
/*    */     }
/* 33 */     nglMultiDrawArraysIndirectBindlessCountNV(mode, MemoryUtil.memAddress(indirect), drawCount, maxDrawCount, stride, vertexBufferCount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirectBindlessCountNV(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect, @NativeType("GLintptr") long drawCount, @NativeType("GLsizei") int maxDrawCount, @NativeType("GLsizei") int stride, @NativeType("GLint") int vertexBufferCount) {
/* 38 */     nglMultiDrawArraysIndirectBindlessCountNV(mode, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirectBindlessCountNV(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLintptr") long drawCount, @NativeType("GLsizei") int maxDrawCount, @NativeType("GLsizei") int stride, @NativeType("GLint") int vertexBufferCount) {
/* 48 */     if (Checks.CHECKS) {
/* 49 */       Checks.check(indirect, maxDrawCount * ((stride == 0) ? ((vertexBufferCount + 2) * 24) : stride));
/*    */     }
/* 51 */     nglMultiDrawElementsIndirectBindlessCountNV(mode, type, MemoryUtil.memAddress(indirect), drawCount, maxDrawCount, stride, vertexBufferCount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirectBindlessCountNV(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect, @NativeType("GLintptr") long drawCount, @NativeType("GLsizei") int maxDrawCount, @NativeType("GLsizei") int stride, @NativeType("GLint") int vertexBufferCount) {
/* 56 */     nglMultiDrawElementsIndirectBindlessCountNV(mode, type, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
/*    */   }
/*    */   
/*    */   public static native void nglMultiDrawArraysIndirectBindlessCountNV(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   public static native void nglMultiDrawElementsIndirectBindlessCountNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVBindlessMultiDrawIndirectCount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */