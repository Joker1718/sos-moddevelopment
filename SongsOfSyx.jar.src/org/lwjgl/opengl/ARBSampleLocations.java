/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBSampleLocations {
/*    */   public static final int GL_SAMPLE_LOCATION_SUBPIXEL_BITS_ARB = 37693;
/*    */   public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_ARB = 37694;
/*    */   public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_ARB = 37695;
/*    */   public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_ARB = 37696;
/*    */   public static final int GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_ARB = 37698;
/*    */   public static final int GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_ARB = 37699;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
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
/*    */   protected ARBSampleLocations() {
/* 31 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glFramebufferSampleLocationsfvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int start, @NativeType("GLfloat const *") FloatBuffer v) {
/* 41 */     nglFramebufferSampleLocationsfvARB(target, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glNamedFramebufferSampleLocationsfvARB(@NativeType("GLuint") int framebuffer, @NativeType("GLuint") int start, @NativeType("GLfloat const *") FloatBuffer v) {
/* 51 */     nglNamedFramebufferSampleLocationsfvARB(framebuffer, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glFramebufferSampleLocationsfvARB(@NativeType("GLenum") int target, @NativeType("GLuint") int start, @NativeType("GLfloat const *") float[] v) {
/* 61 */     long __functionAddress = (GL.getICD()).glFramebufferSampleLocationsfvARB;
/* 62 */     if (Checks.CHECKS) {
/* 63 */       Checks.check(__functionAddress);
/*    */     }
/* 65 */     JNI.callPV(target, start, v.length >> 1, v, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glNamedFramebufferSampleLocationsfvARB(@NativeType("GLuint") int framebuffer, @NativeType("GLuint") int start, @NativeType("GLfloat const *") float[] v) {
/* 70 */     long __functionAddress = (GL.getICD()).glNamedFramebufferSampleLocationsfvARB;
/* 71 */     if (Checks.CHECKS) {
/* 72 */       Checks.check(__functionAddress);
/*    */     }
/* 74 */     JNI.callPV(framebuffer, start, v.length >> 1, v, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglFramebufferSampleLocationsfvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void nglNamedFramebufferSampleLocationsfvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void glEvaluateDepthValuesARB();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBSampleLocations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */