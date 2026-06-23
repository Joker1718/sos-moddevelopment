/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class AMDVertexShaderTessellator
/*    */ {
/*    */   public static final int GL_SAMPLER_BUFFER_AMD = 36865;
/*    */   public static final int GL_INT_SAMPLER_BUFFER_AMD = 36866;
/*    */   public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_AMD = 36867;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_DISCRETE_AMD = 36870;
/*    */   
/*    */   public static final int GL_CONTINUOUS_AMD = 36871;
/*    */   
/*    */   public static final int GL_TESSELLATION_MODE_AMD = 36868;
/*    */   public static final int GL_TESSELLATION_FACTOR_AMD = 36869;
/*    */   
/*    */   public static native void glTessellationModeAMD(@NativeType("GLenum") int paramInt);
/*    */   
/*    */   public static native void glTessellationFactorAMD(@NativeType("GLfloat") float paramFloat);
/*    */   
/*    */   protected AMDVertexShaderTessellator() {
/* 28 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\AMDVertexShaderTessellator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */