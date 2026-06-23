/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTStencilTwoSide
/*    */ {
/*    */   public static final int GL_STENCIL_TEST_TWO_SIDE_EXT = 35088;
/*    */   public static final int GL_ACTIVE_STENCIL_FACE_EXT = 35089;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glActiveStencilFaceEXT(@NativeType("GLenum") int paramInt);
/*    */   
/*    */   protected EXTStencilTwoSide() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTStencilTwoSide.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */