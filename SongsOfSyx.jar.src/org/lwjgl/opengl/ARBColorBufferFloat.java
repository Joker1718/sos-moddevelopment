/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class ARBColorBufferFloat
/*    */ {
/*    */   public static final int GL_RGBA_FLOAT_MODE_ARB = 34848;
/*    */   public static final int GL_CLAMP_VERTEX_COLOR_ARB = 35098;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_CLAMP_FRAGMENT_COLOR_ARB = 35099;
/*    */   
/*    */   public static final int GL_CLAMP_READ_COLOR_ARB = 35100;
/*    */   public static final int GL_FIXED_ONLY_ARB = 35101;
/*    */   
/*    */   public static native void glClampColorARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */   
/*    */   protected ARBColorBufferFloat() {
/* 24 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBColorBufferFloat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */