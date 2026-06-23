/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class EXTFramebufferBlit {
/*    */   public static final int GL_READ_FRAMEBUFFER_EXT = 36008;
/*    */   public static final int GL_DRAW_FRAMEBUFFER_EXT = 36009;
/*    */   public static final int GL_DRAW_FRAMEBUFFER_BINDING_EXT = 36006;
/*    */   public static final int GL_READ_FRAMEBUFFER_BINDING_EXT = 36010;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glBlitFramebufferEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLbitfield") int paramInt9, @NativeType("GLenum") int paramInt10);
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTFramebufferBlit() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTFramebufferBlit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */