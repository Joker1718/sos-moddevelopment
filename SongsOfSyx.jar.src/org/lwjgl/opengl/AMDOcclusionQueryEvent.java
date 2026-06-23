/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class AMDOcclusionQueryEvent
/*    */ {
/*    */   public static final int GL_OCCLUSION_QUERY_EVENT_MASK_AMD = 34639;
/*    */   public static final int GL_QUERY_DEPTH_PASS_EVENT_BIT_AMD = 1;
/*    */   public static final int GL_QUERY_DEPTH_FAIL_EVENT_BIT_AMD = 2;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_QUERY_STENCIL_FAIL_EVENT_BIT_AMD = 4;
/*    */   
/*    */   public static final int GL_QUERY_DEPTH_BOUNDS_FAIL_EVENT_BIT_AMD = 8;
/*    */   public static final int GL_QUERY_ALL_EVENT_BITS_AMD = -1;
/*    */   
/*    */   public static native void glQueryObjectParameteruiAMD(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*    */   
/*    */   protected AMDOcclusionQueryEvent() {
/* 24 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\AMDOcclusionQueryEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */