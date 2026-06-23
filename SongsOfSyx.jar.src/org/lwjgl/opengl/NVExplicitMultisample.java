/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVExplicitMultisample
/*    */ {
/*    */   public static final int GL_SAMPLE_POSITION_NV = 36432;
/*    */   public static final int GL_SAMPLE_MASK_NV = 36433;
/*    */   public static final int GL_SAMPLE_MASK_VALUE_NV = 36434;
/*    */   public static final int GL_TEXTURE_BINDING_RENDERBUFFER_NV = 36435;
/*    */   public static final int GL_TEXTURE_RENDERBUFFER_DATA_STORE_BINDING_NV = 36436;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int GL_MAX_SAMPLE_MASK_WORDS_NV = 36441;
/*    */ 
/*    */   
/*    */   public static final int GL_TEXTURE_RENDERBUFFER_NV = 36437;
/*    */ 
/*    */   
/*    */   public static final int GL_SAMPLER_RENDERBUFFER_NV = 36438;
/*    */ 
/*    */   
/*    */   public static final int GL_INT_SAMPLER_RENDERBUFFER_NV = 36439;
/*    */ 
/*    */   
/*    */   public static final int GL_UNSIGNED_INT_SAMPLER_RENDERBUFFER_NV = 36440;
/*    */ 
/*    */   
/*    */   protected NVExplicitMultisample() {
/* 39 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetMultisamplefvNV(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat *") FloatBuffer val) {
/* 49 */     if (Checks.CHECKS) {
/* 50 */       Checks.check(val, 2);
/*    */     }
/* 52 */     nglGetMultisamplefvNV(pname, index, MemoryUtil.memAddress(val));
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
/*    */   public static void glGetMultisamplefvNV(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat *") float[] val) {
/* 67 */     long __functionAddress = (GL.getICD()).glGetMultisamplefvNV;
/* 68 */     if (Checks.CHECKS) {
/* 69 */       Checks.check(__functionAddress);
/* 70 */       Checks.check(val, 2);
/*    */     } 
/* 72 */     JNI.callPV(pname, index, val, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglGetMultisamplefvNV(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void glSampleMaskIndexedNV(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2);
/*    */   
/*    */   public static native void glTexRenderbufferNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVExplicitMultisample.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */