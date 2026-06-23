/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVConditionalRender {
/*    */   public static final int GL_QUERY_WAIT_NV = 36371;
/*    */   public static final int GL_QUERY_NO_WAIT_NV = 36372;
/*    */   public static final int GL_QUERY_BY_REGION_WAIT_NV = 36373;
/*    */   public static final int GL_QUERY_BY_REGION_NO_WAIT_NV = 36374;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glEndConditionalRenderNV();
/*    */   
/*    */   public static native void glBeginConditionalRenderNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */   
/*    */   protected NVConditionalRender() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVConditionalRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */