/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class NVSampleLocations
/*    */ {
/*    */   public static final int GL_SAMPLE_LOCATION_SUBPIXEL_BITS_NV = 37693;
/*    */   public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_NV = 37694;
/*    */   public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_NV = 37695;
/*    */   public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_NV = 37696;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int GL_SAMPLE_LOCATION_NV = 36432;
/*    */ 
/*    */   
/*    */   public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_NV = 37697;
/*    */ 
/*    */   
/*    */   public static final int GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_NV = 37698;
/*    */   
/*    */   public static final int GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_NV = 37699;
/*    */ 
/*    */   
/*    */   protected NVSampleLocations() {
/* 35 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glFramebufferSampleLocationsfvNV(@NativeType("GLenum") int target, @NativeType("GLuint") int start, @NativeType("GLfloat const *") FloatBuffer v) {
/* 45 */     nglFramebufferSampleLocationsfvNV(target, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glNamedFramebufferSampleLocationsfvNV(@NativeType("GLuint") int framebuffer, @NativeType("GLuint") int start, @NativeType("GLfloat const *") FloatBuffer v) {
/* 55 */     nglNamedFramebufferSampleLocationsfvNV(framebuffer, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glFramebufferSampleLocationsfvNV(@NativeType("GLenum") int target, @NativeType("GLuint") int start, @NativeType("GLfloat const *") float[] v) {
/* 65 */     long __functionAddress = (GL.getICD()).glFramebufferSampleLocationsfvNV;
/* 66 */     if (Checks.CHECKS) {
/* 67 */       Checks.check(__functionAddress);
/*    */     }
/* 69 */     JNI.callPV(target, start, v.length >> 1, v, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glNamedFramebufferSampleLocationsfvNV(@NativeType("GLuint") int framebuffer, @NativeType("GLuint") int start, @NativeType("GLfloat const *") float[] v) {
/* 74 */     long __functionAddress = (GL.getICD()).glNamedFramebufferSampleLocationsfvNV;
/* 75 */     if (Checks.CHECKS) {
/* 76 */       Checks.check(__functionAddress);
/*    */     }
/* 78 */     JNI.callPV(framebuffer, start, v.length >> 1, v, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglFramebufferSampleLocationsfvNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void nglNamedFramebufferSampleLocationsfvNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void glResolveDepthValuesNV();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVSampleLocations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */