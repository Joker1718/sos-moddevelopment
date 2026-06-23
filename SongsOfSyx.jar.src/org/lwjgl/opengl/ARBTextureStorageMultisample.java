/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBTextureStorageMultisample
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected ARBTextureStorageMultisample() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glTexStorage2DMultisample(@NativeType("GLenum") int target, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLboolean") boolean fixedsamplelocations) {
/* 22 */     GL43C.glTexStorage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glTexStorage3DMultisample(@NativeType("GLenum") int target, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLboolean") boolean fixedsamplelocations) {
/* 29 */     GL43C.glTexStorage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations);
/*    */   }
/*    */   
/*    */   public static native void glTextureStorage2DMultisampleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean);
/*    */   
/*    */   public static native void glTextureStorage3DMultisampleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLboolean") boolean paramBoolean);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTextureStorageMultisample.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */