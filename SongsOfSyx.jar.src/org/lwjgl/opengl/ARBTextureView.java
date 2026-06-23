/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class ARBTextureView
/*    */ {
/*    */   public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499;
/*    */   public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501;
/*    */   
/*    */   public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502;
/*    */   public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503;
/*    */   
/*    */   protected ARBTextureView() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glTextureView(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLuint") int origtexture, @NativeType("GLenum") int internalformat, @NativeType("GLuint") int minlevel, @NativeType("GLuint") int numlevels, @NativeType("GLuint") int minlayer, @NativeType("GLuint") int numlayers) {
/* 29 */     GL43C.glTextureView(texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTextureView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */