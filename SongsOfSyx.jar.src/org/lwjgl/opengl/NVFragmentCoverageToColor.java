/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class NVFragmentCoverageToColor
/*    */ {
/*    */   public static final int GL_FRAGMENT_COVERAGE_TO_COLOR_NV = 37597;
/*    */   public static final int GL_FRAGMENT_COVERAGE_COLOR_NV = 37598;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glFragmentCoverageColorNV(@NativeType("GLuint") int paramInt);
/*    */   
/*    */   protected NVFragmentCoverageToColor() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVFragmentCoverageToColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */