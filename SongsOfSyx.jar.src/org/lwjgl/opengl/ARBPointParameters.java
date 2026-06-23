/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class ARBPointParameters
/*    */ {
/*    */   public static final int GL_POINT_SIZE_MIN_ARB = 33062;
/*    */   public static final int GL_POINT_SIZE_MAX_ARB = 33063;
/*    */   public static final int GL_POINT_FADE_THRESHOLD_SIZE_ARB = 33064;
/*    */   public static final int GL_POINT_DISTANCE_ATTENUATION_ARB = 33065;
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
/*    */   protected ARBPointParameters() {
/* 27 */     throw new UnsupportedOperationException();
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
/*    */   public static void glPointParameterfvARB(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 42 */     if (Checks.CHECKS) {
/* 43 */       Checks.check(params, 3);
/*    */     }
/* 45 */     nglPointParameterfvARB(pname, MemoryUtil.memAddress(params));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glPointParameterfvARB(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 50 */     long __functionAddress = (GL.getICD()).glPointParameterfvARB;
/* 51 */     if (Checks.CHECKS) {
/* 52 */       Checks.check(__functionAddress);
/* 53 */       Checks.check(params, 3);
/*    */     } 
/* 55 */     JNI.callPV(pname, params, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void glPointParameterfARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*    */   
/*    */   public static native void nglPointParameterfvARB(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBPointParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */