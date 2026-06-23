/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class EXTBlendFuncSeparate {
/*    */   public static final int GL_BLEND_DST_RGB_EXT = 32968;
/*    */   public static final int GL_BLEND_SRC_RGB_EXT = 32969;
/*    */   public static final int GL_BLEND_DST_ALPHA_EXT = 32970;
/*    */   public static final int GL_BLEND_SRC_ALPHA_EXT = 32971;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glBlendFuncSeparateEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4);
/*    */ 
/*    */   
/*    */   protected EXTBlendFuncSeparate() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTBlendFuncSeparate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */