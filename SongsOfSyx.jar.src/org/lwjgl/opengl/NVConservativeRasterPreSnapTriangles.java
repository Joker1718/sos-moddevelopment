/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVConservativeRasterPreSnapTriangles
/*    */ {
/*    */   public static final int GL_CONSERVATIVE_RASTER_MODE_NV = 38221;
/*    */   public static final int GL_CONSERVATIVE_RASTER_MODE_POST_SNAP_NV = 38222;
/*    */   public static final int GL_CONSERVATIVE_RASTER_MODE_PRE_SNAP_TRIANGLES_NV = 38223;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glConservativeRasterParameteriNV(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*    */ 
/*    */   
/*    */   protected NVConservativeRasterPreSnapTriangles() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVConservativeRasterPreSnapTriangles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */