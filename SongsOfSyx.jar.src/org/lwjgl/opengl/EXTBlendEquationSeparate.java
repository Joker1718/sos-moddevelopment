/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTBlendEquationSeparate
/*    */ {
/*    */   public static final int GL_BLEND_EQUATION_RGB_EXT = 32777;
/*    */   public static final int GL_BLEND_EQUATION_ALPHA_EXT = 34877;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glBlendEquationSeparateEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */   
/*    */   protected EXTBlendEquationSeparate() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTBlendEquationSeparate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */