/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class ARBSampleShading
/*    */ {
/*    */   public static final int GL_SAMPLE_SHADING_ARB = 35894;
/*    */   public static final int GL_MIN_SAMPLE_SHADING_VALUE_ARB = 35895;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glMinSampleShadingARB(@NativeType("GLfloat") float paramFloat);
/*    */   
/*    */   protected ARBSampleShading() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBSampleShading.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */