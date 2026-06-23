/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVViewportSwizzle
/*    */ {
/*    */   public static final int GL_VIEWPORT_SWIZZLE_POSITIVE_X_NV = 37712;
/*    */   public static final int GL_VIEWPORT_SWIZZLE_NEGATIVE_X_NV = 37713;
/*    */   public static final int GL_VIEWPORT_SWIZZLE_POSITIVE_Y_NV = 37714;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_VIEWPORT_SWIZZLE_NEGATIVE_Y_NV = 37715;
/*    */   
/*    */   public static final int GL_VIEWPORT_SWIZZLE_POSITIVE_Z_NV = 37716;
/*    */   
/*    */   public static final int GL_VIEWPORT_SWIZZLE_NEGATIVE_Z_NV = 37717;
/*    */   public static final int GL_VIEWPORT_SWIZZLE_POSITIVE_W_NV = 37718;
/*    */   public static final int GL_VIEWPORT_SWIZZLE_NEGATIVE_W_NV = 37719;
/*    */   public static final int GL_VIEWPORT_SWIZZLE_X_NV = 37720;
/*    */   public static final int GL_VIEWPORT_SWIZZLE_Y_NV = 37721;
/*    */   public static final int GL_VIEWPORT_SWIZZLE_Z_NV = 37722;
/*    */   public static final int GL_VIEWPORT_SWIZZLE_W_NV = 37723;
/*    */   
/*    */   public static native void glViewportSwizzleNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5);
/*    */   
/*    */   protected NVViewportSwizzle() {
/* 31 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVViewportSwizzle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */