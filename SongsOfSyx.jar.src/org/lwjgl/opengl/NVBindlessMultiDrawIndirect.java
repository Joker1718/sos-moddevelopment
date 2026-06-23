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
/*    */ public class NVBindlessMultiDrawIndirect
/*    */ {
/*    */   static {
/* 17 */     GL.initialize();
/*    */   }
/*    */   protected NVBindlessMultiDrawIndirect() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirectBindlessNV(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLsizei") int drawCount, @NativeType("GLsizei") int stride, @NativeType("GLint") int vertexBufferCount) {
/* 30 */     if (Checks.CHECKS) {
/* 31 */       Checks.check(indirect, drawCount * ((stride == 0) ? (16 + vertexBufferCount * 24) : stride));
/*    */     }
/* 33 */     nglMultiDrawArraysIndirectBindlessNV(mode, MemoryUtil.memAddress(indirect), drawCount, stride, vertexBufferCount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawArraysIndirectBindlessNV(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect, @NativeType("GLsizei") int drawCount, @NativeType("GLsizei") int stride, @NativeType("GLint") int vertexBufferCount) {
/* 38 */     nglMultiDrawArraysIndirectBindlessNV(mode, indirect, drawCount, stride, vertexBufferCount);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirectBindlessNV(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLsizei") int drawCount, @NativeType("GLsizei") int stride, @NativeType("GLint") int vertexBufferCount) {
/* 48 */     if (Checks.CHECKS) {
/* 49 */       Checks.check(indirect, drawCount * ((stride == 0) ? ((vertexBufferCount + 2) * 24) : stride));
/*    */     }
/* 51 */     nglMultiDrawElementsIndirectBindlessNV(mode, type, MemoryUtil.memAddress(indirect), drawCount, stride, vertexBufferCount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glMultiDrawElementsIndirectBindlessNV(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect, @NativeType("GLsizei") int drawCount, @NativeType("GLsizei") int stride, @NativeType("GLint") int vertexBufferCount) {
/* 56 */     nglMultiDrawElementsIndirectBindlessNV(mode, type, indirect, drawCount, stride, vertexBufferCount);
/*    */   }
/*    */   
/*    */   public static native void nglMultiDrawArraysIndirectBindlessNV(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   public static native void nglMultiDrawElementsIndirectBindlessNV(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVBindlessMultiDrawIndirect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */