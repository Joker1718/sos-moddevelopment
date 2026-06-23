/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBMapBufferRange
/*    */ {
/*    */   public static final int GL_MAP_READ_BIT = 1;
/*    */   public static final int GL_MAP_WRITE_BIT = 2;
/*    */   public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
/*    */   public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
/*    */   public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
/*    */   public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;
/*    */   
/*    */   static {
/* 16 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBMapBufferRange() {
/* 27 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglMapBufferRange(int target, long offset, long length, int access) {
/* 34 */     return GL30C.nglMapBufferRange(target, offset, length, access);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void *")
/*    */   public static ByteBuffer glMapBufferRange(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access) {
/* 40 */     return GL30C.glMapBufferRange(target, offset, length, access);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void *")
/*    */   public static ByteBuffer glMapBufferRange(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length, @NativeType("GLbitfield") int access, ByteBuffer old_buffer) {
/* 46 */     return GL30C.glMapBufferRange(target, offset, length, access, old_buffer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glFlushMappedBufferRange(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length) {
/* 53 */     GL30C.glFlushMappedBufferRange(target, offset, length);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBMapBufferRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */