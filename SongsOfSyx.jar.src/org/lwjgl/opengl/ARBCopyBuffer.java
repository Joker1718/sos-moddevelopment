/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class ARBCopyBuffer
/*    */ {
/*    */   public static final int GL_COPY_READ_BUFFER = 36662;
/*    */   public static final int GL_COPY_WRITE_BUFFER = 36663;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBCopyBuffer() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glCopyBufferSubData(@NativeType("GLenum") int readTarget, @NativeType("GLenum") int writeTarget, @NativeType("GLintptr") long readOffset, @NativeType("GLintptr") long writeOffset, @NativeType("GLsizeiptr") long size) {
/* 26 */     GL31C.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBCopyBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */