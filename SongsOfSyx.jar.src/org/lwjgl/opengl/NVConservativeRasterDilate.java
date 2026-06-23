/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVConservativeRasterDilate
/*    */ {
/*    */   public static final int GL_CONSERVATIVE_RASTER_DILATE_NV = 37753;
/*    */   public static final int GL_CONSERVATIVE_RASTER_DILATE_RANGE_NV = 37754;
/*    */   public static final int GL_CONSERVATIVE_RASTER_DILATE_GRANULARITY_NV = 37755;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glConservativeRasterParameterfNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*    */ 
/*    */   
/*    */   protected NVConservativeRasterDilate() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVConservativeRasterDilate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */