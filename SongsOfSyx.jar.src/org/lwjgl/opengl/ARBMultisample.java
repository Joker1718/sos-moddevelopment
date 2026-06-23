/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBMultisample {
/*    */   public static final int GL_MULTISAMPLE_ARB = 32925;
/*    */   public static final int GL_SAMPLE_ALPHA_TO_COVERAGE_ARB = 32926;
/*    */   public static final int GL_SAMPLE_ALPHA_TO_ONE_ARB = 32927;
/*    */   public static final int GL_SAMPLE_COVERAGE_ARB = 32928;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_MULTISAMPLE_BIT_ARB = 536870912;
/*    */   
/*    */   public static final int GL_SAMPLE_BUFFERS_ARB = 32936;
/*    */   
/*    */   public static final int GL_SAMPLES_ARB = 32937;
/*    */   
/*    */   public static final int GL_SAMPLE_COVERAGE_VALUE_ARB = 32938;
/*    */   
/*    */   public static final int GL_SAMPLE_COVERAGE_INVERT_ARB = 32939;
/*    */   
/*    */   public static native void glSampleCoverageARB(@NativeType("GLfloat") float paramFloat, @NativeType("GLboolean") boolean paramBoolean);
/*    */   
/*    */   protected ARBMultisample() {
/* 29 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBMultisample.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */