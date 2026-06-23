/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class EXTFramebufferMultisample
/*    */ {
/*    */   public static final int GL_RENDERBUFFER_SAMPLES_EXT = 36011;
/*    */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE_EXT = 36182;
/*    */   public static final int GL_MAX_SAMPLES_EXT = 36183;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glRenderbufferStorageMultisampleEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*    */ 
/*    */   
/*    */   protected EXTFramebufferMultisample() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTFramebufferMultisample.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */