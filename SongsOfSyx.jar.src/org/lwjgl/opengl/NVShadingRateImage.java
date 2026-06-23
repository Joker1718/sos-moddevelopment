/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class NVShadingRateImage
/*     */ {
/*     */   public static final int GL_SHADING_RATE_IMAGE_NV = 38243;
/*     */   public static final int GL_SHADING_RATE_NO_INVOCATIONS_NV = 38244;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_PIXEL_NV = 38245;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_1X2_PIXELS_NV = 38246;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_2X1_PIXELS_NV = 38247;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_2X2_PIXELS_NV = 38248;
/*     */   
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_2X4_PIXELS_NV = 38249;
/*     */   
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_4X2_PIXELS_NV = 38250;
/*     */   
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_4X4_PIXELS_NV = 38251;
/*     */   
/*     */   public static final int GL_SHADING_RATE_2_INVOCATIONS_PER_PIXEL_NV = 38252;
/*     */   
/*     */   public static final int GL_SHADING_RATE_4_INVOCATIONS_PER_PIXEL_NV = 38253;
/*     */   
/*     */   public static final int GL_SHADING_RATE_8_INVOCATIONS_PER_PIXEL_NV = 38254;
/*     */   
/*     */   public static final int GL_SHADING_RATE_16_INVOCATIONS_PER_PIXEL_NV = 38255;
/*     */   
/*     */   public static final int GL_SHADING_RATE_IMAGE_BINDING_NV = 38235;
/*     */   
/*     */   public static final int GL_SHADING_RATE_IMAGE_TEXEL_WIDTH_NV = 38236;
/*     */   public static final int GL_SHADING_RATE_IMAGE_TEXEL_HEIGHT_NV = 38237;
/*     */   public static final int GL_SHADING_RATE_IMAGE_PALETTE_SIZE_NV = 38238;
/*     */   public static final int GL_MAX_COARSE_FRAGMENT_SAMPLES_NV = 38239;
/*     */   public static final int GL_SHADING_RATE_SAMPLE_ORDER_DEFAULT_NV = 38318;
/*     */   public static final int GL_SHADING_RATE_SAMPLE_ORDER_PIXEL_MAJOR_NV = 38319;
/*     */   public static final int GL_SHADING_RATE_SAMPLE_ORDER_SAMPLE_MAJOR_NV = 38320;
/*     */   
/*     */   protected NVShadingRateImage() {
/*  49 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glShadingRateImagePaletteNV(@NativeType("GLuint") int viewport, @NativeType("GLuint") int first, @NativeType("GLenum const *") IntBuffer rates) {
/*  64 */     nglShadingRateImagePaletteNV(viewport, first, rates.remaining(), MemoryUtil.memAddress(rates));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetShadingRateImagePaletteNV(@NativeType("GLuint") int viewport, @NativeType("GLuint") int entry, @NativeType("GLenum *") IntBuffer rate) {
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.check(rate, 1);
/*     */     }
/*  77 */     nglGetShadingRateImagePaletteNV(viewport, entry, MemoryUtil.memAddress(rate));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glShadingRateSampleOrderCustomNV(@NativeType("GLenum") int rate, @NativeType("GLuint") int samples, @NativeType("GLint const *") IntBuffer locations) {
/*  97 */     nglShadingRateSampleOrderCustomNV(rate, samples, MemoryUtil.memAddress(locations));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetShadingRateSampleLocationivNV(@NativeType("GLenum") int rate, @NativeType("GLuint") int samples, @NativeType("GLuint") int index, @NativeType("GLint *") IntBuffer location) {
/* 107 */     if (Checks.CHECKS) {
/* 108 */       Checks.check(location, 3);
/*     */     }
/* 110 */     nglGetShadingRateSampleLocationivNV(rate, samples, index, MemoryUtil.memAddress(location));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShadingRateImagePaletteNV(@NativeType("GLuint") int viewport, @NativeType("GLuint") int first, @NativeType("GLenum const *") int[] rates) {
/* 115 */     long __functionAddress = (GL.getICD()).glShadingRateImagePaletteNV;
/* 116 */     if (Checks.CHECKS) {
/* 117 */       Checks.check(__functionAddress);
/*     */     }
/* 119 */     JNI.callPV(viewport, first, rates.length, rates, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetShadingRateImagePaletteNV(@NativeType("GLuint") int viewport, @NativeType("GLuint") int entry, @NativeType("GLenum *") int[] rate) {
/* 124 */     long __functionAddress = (GL.getICD()).glGetShadingRateImagePaletteNV;
/* 125 */     if (Checks.CHECKS) {
/* 126 */       Checks.check(__functionAddress);
/* 127 */       Checks.check(rate, 1);
/*     */     } 
/* 129 */     JNI.callPV(viewport, entry, rate, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShadingRateSampleOrderCustomNV(@NativeType("GLenum") int rate, @NativeType("GLuint") int samples, @NativeType("GLint const *") int[] locations) {
/* 134 */     long __functionAddress = (GL.getICD()).glShadingRateSampleOrderCustomNV;
/* 135 */     if (Checks.CHECKS) {
/* 136 */       Checks.check(__functionAddress);
/*     */     }
/* 138 */     JNI.callPV(rate, samples, locations, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetShadingRateSampleLocationivNV(@NativeType("GLenum") int rate, @NativeType("GLuint") int samples, @NativeType("GLuint") int index, @NativeType("GLint *") int[] location) {
/* 143 */     long __functionAddress = (GL.getICD()).glGetShadingRateSampleLocationivNV;
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(__functionAddress);
/* 146 */       Checks.check(location, 3);
/*     */     } 
/* 148 */     JNI.callPV(rate, samples, index, location, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glBindShadingRateImageNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglShadingRateImagePaletteNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetShadingRateImagePaletteNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glShadingRateImageBarrierNV(@NativeType("GLboolean") boolean paramBoolean);
/*     */   
/*     */   public static native void glShadingRateSampleOrderNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglShadingRateSampleOrderCustomNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetShadingRateSampleLocationivNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVShadingRateImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */