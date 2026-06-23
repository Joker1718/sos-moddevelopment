/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class EXTFragmentShadingRate {
/*    */   public static final int GL_SHADING_RATE_ATTACHMENT_EXT = 38609;
/*    */   public static final int GL_SHADING_RATE_1X1_PIXELS_EXT = 38566;
/*    */   public static final int GL_SHADING_RATE_1X2_PIXELS_EXT = 38567;
/*    */   public static final int GL_SHADING_RATE_1X4_PIXELS_EXT = 38570;
/*    */   public static final int GL_SHADING_RATE_2X1_PIXELS_EXT = 38568;
/*    */   public static final int GL_SHADING_RATE_2X2_PIXELS_EXT = 38569;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_SHADING_RATE_2X4_PIXELS_EXT = 38573;
/*    */   
/*    */   public static final int GL_SHADING_RATE_4X1_PIXELS_EXT = 38571;
/*    */   
/*    */   public static final int GL_SHADING_RATE_4X2_PIXELS_EXT = 38572;
/*    */   
/*    */   public static final int GL_SHADING_RATE_4X4_PIXELS_EXT = 38574;
/*    */   
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_COMBINER_OP_KEEP_EXT = 38610;
/*    */   
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_COMBINER_OP_REPLACE_EXT = 38611;
/*    */   
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_COMBINER_OP_MIN_EXT = 38612;
/*    */   
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_COMBINER_OP_MAX_EXT = 38613;
/*    */   
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_COMBINER_OP_MUL_EXT = 38614;
/*    */   
/*    */   public static final int GL_SHADING_RATE_EXT = 38608;
/*    */   
/*    */   public static final int GL_MIN_FRAGMENT_SHADING_RATE_ATTACHMENT_TEXEL_WIDTH_EXT = 38615;
/*    */   public static final int GL_MAX_FRAGMENT_SHADING_RATE_ATTACHMENT_TEXEL_WIDTH_EXT = 38616;
/*    */   public static final int GL_MIN_FRAGMENT_SHADING_RATE_ATTACHMENT_TEXEL_HEIGHT_EXT = 38617;
/*    */   public static final int GL_MAX_FRAGMENT_SHADING_RATE_ATTACHMENT_TEXEL_HEIGHT_EXT = 38618;
/*    */   public static final int GL_MAX_FRAGMENT_SHADING_RATE_ATTACHMENT_TEXEL_ASPECT_RATIO_EXT = 38619;
/*    */   public static final int GL_MAX_FRAGMENT_SHADING_RATE_ATTACHMENT_LAYERS_EXT = 38620;
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_WITH_SHADER_DEPTH_STENCIL_WRITES_SUPPORTED_EXT = 38621;
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_WITH_SAMPLE_MASK_SUPPORTED_EXT = 38622;
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_ATTACHMENT_WITH_DEFAULT_FRAMEBUFFER_SUPPORTED_EXT = 38623;
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_NON_TRIVIAL_COMBINERS_SUPPORTED_EXT = 36719;
/*    */   public static final int GL_FRAGMENT_SHADING_RATE_PRIMITIVE_RATE_WITH_MULTI_VIEWPORT_SUPPORTED_EXT = 38784;
/*    */   
/*    */   protected EXTFragmentShadingRate() {
/* 55 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetFragmentShadingRatesEXT(@NativeType("GLsizei") int samples, @NativeType("GLsizei *") IntBuffer count, @NativeType("GLenum *") IntBuffer shadingRates) {
/* 80 */     if (Checks.CHECKS) {
/* 81 */       Checks.check(count, 1);
/*    */     }
/* 83 */     nglGetFragmentShadingRatesEXT(samples, shadingRates.remaining(), MemoryUtil.memAddress(count), MemoryUtil.memAddress(shadingRates));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetFragmentShadingRatesEXT(@NativeType("GLsizei") int samples, @NativeType("GLsizei *") int[] count, @NativeType("GLenum *") int[] shadingRates) {
/* 88 */     long __functionAddress = (GL.getICD()).glGetFragmentShadingRatesEXT;
/* 89 */     if (Checks.CHECKS) {
/* 90 */       Checks.check(__functionAddress);
/* 91 */       Checks.check(count, 1);
/*    */     } 
/* 93 */     JNI.callPPV(samples, shadingRates.length, count, shadingRates, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void glShadingRateEXT(@NativeType("GLenum") int paramInt);
/*    */   
/*    */   public static native void glShadingRateCombinerOpsEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */   
/*    */   public static native void glFramebufferShadingRateEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7);
/*    */   
/*    */   public static native void nglGetFragmentShadingRatesEXT(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTFragmentShadingRate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */