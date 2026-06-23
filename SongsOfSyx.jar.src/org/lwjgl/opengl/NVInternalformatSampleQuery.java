/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class NVInternalformatSampleQuery
/*    */ {
/*    */   public static final int GL_MULTISAMPLES_NV = 37745;
/*    */   public static final int GL_SUPERSAMPLE_SCALE_X_NV = 37746;
/*    */   public static final int GL_SUPERSAMPLE_SCALE_Y_NV = 37747;
/*    */   public static final int GL_CONFORMANT_NV = 37748;
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
/*    */   protected NVInternalformatSampleQuery() {
/* 27 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetInternalformatSampleivNV(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int samples, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 37 */     nglGetInternalformatSampleivNV(target, internalformat, samples, pname, params.remaining(), MemoryUtil.memAddress(params));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetInternalformatSampleivNV(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int samples, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 42 */     long __functionAddress = (GL.getICD()).glGetInternalformatSampleivNV;
/* 43 */     if (Checks.CHECKS) {
/* 44 */       Checks.check(__functionAddress);
/*    */     }
/* 46 */     JNI.callPV(target, internalformat, samples, pname, params.length, params, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglGetInternalformatSampleivNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVInternalformatSampleQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */