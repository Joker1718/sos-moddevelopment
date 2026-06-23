/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVAlphaToCoverageDitherControl {
/*    */   public static final int GL_ALPHA_TO_COVERAGE_DITHER_DEFAULT_NV = 37709;
/*    */   public static final int GL_ALPHA_TO_COVERAGE_DITHER_ENABLE_NV = 37710;
/*    */   public static final int GL_ALPHA_TO_COVERAGE_DITHER_DISABLE_NV = 37711;
/*    */   public static final int GL_ALPHA_TO_COVERAGE_DITHER_MODE_NV = 37567;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glAlphaToCoverageDitherControlNV(@NativeType("GLenum") int paramInt);
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVAlphaToCoverageDitherControl() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVAlphaToCoverageDitherControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */