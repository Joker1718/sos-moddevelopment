/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTDepthBoundsTest
/*    */ {
/*    */   public static final int GL_DEPTH_BOUNDS_TEST_EXT = 34960;
/*    */   public static final int GL_DEPTH_BOUNDS_EXT = 34961;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glDepthBoundsEXT(double paramDouble1, double paramDouble2);
/*    */   
/*    */   protected EXTDepthBoundsTest() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTDepthBoundsTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */