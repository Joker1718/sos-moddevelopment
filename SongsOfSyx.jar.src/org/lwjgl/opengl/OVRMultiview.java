/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class OVRMultiview {
/*    */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_NUM_VIEWS_OVR = 38448;
/*    */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_BASE_VIEW_INDEX_OVR = 38450;
/*    */   public static final int GL_MAX_VIEWS_OVR = 38449;
/*    */   public static final int GL_FRAMEBUFFER_INCOMPLETE_VIEW_TARGETS_OVR = 38451;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glNamedFramebufferTextureMultiviewOVR(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*    */ 
/*    */   
/*    */   public static native void glFramebufferTextureMultiviewOVR(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*    */ 
/*    */   
/*    */   protected OVRMultiview() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\OVRMultiview.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */