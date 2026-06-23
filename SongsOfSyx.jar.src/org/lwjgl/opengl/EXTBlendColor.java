/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTBlendColor
/*    */ {
/*    */   public static final int GL_CONSTANT_COLOR_EXT = 32769;
/*    */   public static final int GL_ONE_MINUS_CONSTANT_COLOR_EXT = 32770;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_CONSTANT_ALPHA_EXT = 32771;
/*    */   public static final int GL_ONE_MINUS_CONSTANT_ALPHA_EXT = 32772;
/*    */   public static final int GL_BLEND_COLOR_EXT = 32773;
/*    */   
/*    */   public static native void glBlendColorEXT(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*    */   
/*    */   protected EXTBlendColor() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTBlendColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */