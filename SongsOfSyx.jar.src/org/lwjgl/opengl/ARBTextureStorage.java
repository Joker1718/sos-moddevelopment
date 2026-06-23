/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBTextureStorage
/*    */ {
/*    */   public static final int GL_TEXTURE_IMMUTABLE_FORMAT = 37167;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ARBTextureStorage() {
/* 17 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glTexStorage1D(@NativeType("GLenum") int target, @NativeType("GLsizei") int levels, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width) {
/* 24 */     GL42C.glTexStorage1D(target, levels, internalformat, width);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glTexStorage2D(@NativeType("GLenum") int target, @NativeType("GLsizei") int levels, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 31 */     GL42C.glTexStorage2D(target, levels, internalformat, width, height);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glTexStorage3D(@NativeType("GLenum") int target, @NativeType("GLsizei") int levels, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth) {
/* 38 */     GL42C.glTexStorage3D(target, levels, internalformat, width, height, depth);
/*    */   }
/*    */   
/*    */   public static native void glTextureStorage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*    */   
/*    */   public static native void glTextureStorage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*    */   
/*    */   public static native void glTextureStorage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTextureStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */