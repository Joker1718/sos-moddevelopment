/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVDepthBufferFloat {
/*    */   public static final int GL_DEPTH_COMPONENT32F_NV = 36267;
/*    */   public static final int GL_DEPTH32F_STENCIL8_NV = 36268;
/*    */   public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV_NV = 36269;
/*    */   public static final int GL_DEPTH_BUFFER_FLOAT_MODE_NV = 36271;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glDepthBoundsdNV(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*    */   
/*    */   public static native void glClearDepthdNV(@NativeType("GLdouble") double paramDouble);
/*    */   
/*    */   public static native void glDepthRangedNV(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*    */   
/*    */   protected NVDepthBufferFloat() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVDepthBufferFloat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */