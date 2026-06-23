/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVFramebufferMixedSamples
/*    */ {
/*    */   public static final int GL_RASTER_MULTISAMPLE_EXT = 37671;
/*    */   public static final int GL_COVERAGE_MODULATION_TABLE_NV = 37681;
/*    */   public static final int GL_RASTER_SAMPLES_EXT = 37672;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_MAX_RASTER_SAMPLES_EXT = 37673;
/*    */   
/*    */   public static final int GL_RASTER_FIXED_SAMPLE_LOCATIONS_EXT = 37674;
/*    */   
/*    */   public static final int GL_MULTISAMPLE_RASTERIZATION_ALLOWED_EXT = 37675;
/*    */   
/*    */   public static final int GL_EFFECTIVE_RASTER_SAMPLES_EXT = 37676;
/*    */   
/*    */   public static final int GL_COLOR_SAMPLES_NV = 36384;
/*    */   public static final int GL_DEPTH_SAMPLES_NV = 37677;
/*    */   public static final int GL_STENCIL_SAMPLES_NV = 37678;
/*    */   public static final int GL_MIXED_DEPTH_SAMPLES_SUPPORTED_NV = 37679;
/*    */   public static final int GL_MIXED_STENCIL_SAMPLES_SUPPORTED_NV = 37680;
/*    */   public static final int GL_COVERAGE_MODULATION_NV = 37682;
/*    */   public static final int GL_COVERAGE_MODULATION_TABLE_SIZE_NV = 37683;
/*    */   
/*    */   protected NVFramebufferMixedSamples() {
/* 39 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glRasterSamplesEXT(@NativeType("GLuint") int samples, @NativeType("GLboolean") boolean fixedsamplelocations) {
/* 46 */     EXTRasterMultisample.glRasterSamplesEXT(samples, fixedsamplelocations);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glCoverageModulationTableNV(@NativeType("GLfloat const *") FloatBuffer v) {
/* 56 */     nglCoverageModulationTableNV(v.remaining(), MemoryUtil.memAddress(v));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetCoverageModulationTableNV(@NativeType("GLfloat *") FloatBuffer v) {
/* 66 */     nglGetCoverageModulationTableNV(v.remaining(), MemoryUtil.memAddress(v));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glCoverageModulationTableNV(@NativeType("GLfloat const *") float[] v) {
/* 76 */     long __functionAddress = (GL.getICD()).glCoverageModulationTableNV;
/* 77 */     if (Checks.CHECKS) {
/* 78 */       Checks.check(__functionAddress);
/*    */     }
/* 80 */     JNI.callPV(v.length, v, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetCoverageModulationTableNV(@NativeType("GLfloat *") float[] v) {
/* 85 */     long __functionAddress = (GL.getICD()).glGetCoverageModulationTableNV;
/* 86 */     if (Checks.CHECKS) {
/* 87 */       Checks.check(__functionAddress);
/*    */     }
/* 89 */     JNI.callPV(v.length, v, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglCoverageModulationTableNV(int paramInt, long paramLong);
/*    */   
/*    */   public static native void nglGetCoverageModulationTableNV(int paramInt, long paramLong);
/*    */   
/*    */   public static native void glCoverageModulationNV(@NativeType("GLenum") int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVFramebufferMixedSamples.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */