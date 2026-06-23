/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVClipSpaceWScaling
/*    */ {
/*    */   public static final int GL_VIEWPORT_POSITION_W_SCALE_NV = 37756;
/*    */   public static final int GL_VIEWPORT_POSITION_W_SCALE_X_COEFF = 37757;
/*    */   public static final int GL_VIEWPORT_POSITION_W_SCALE_Y_COEFF = 37758;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glViewportPositionWScaleNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*    */ 
/*    */   
/*    */   protected NVClipSpaceWScaling() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVClipSpaceWScaling.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */