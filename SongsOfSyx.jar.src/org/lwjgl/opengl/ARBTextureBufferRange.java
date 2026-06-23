/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBTextureBufferRange
/*    */ {
/*    */   public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
/*    */   public static final int GL_TEXTURE_BUFFER_SIZE = 37278;
/*    */   public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBTextureBufferRange() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glTexBufferRange(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size) {
/* 28 */     GL43C.glTexBufferRange(target, internalformat, buffer, offset, size);
/*    */   }
/*    */   
/*    */   public static native void glTextureBufferRangeEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTextureBufferRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */