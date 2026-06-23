/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTPointParameters
/*    */ {
/*    */   public static final int GL_POINT_SIZE_MIN_EXT = 33062;
/*    */   public static final int GL_POINT_SIZE_MAX_EXT = 33063;
/*    */   public static final int GL_POINT_FADE_THRESHOLD_SIZE_EXT = 33064;
/*    */   public static final int GL_DISTANCE_ATTENUATION_EXT = 33065;
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
/*    */   protected EXTPointParameters() {
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
/*    */   public static void glPointParameterfvEXT(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 42 */     if (Checks.CHECKS) {
/* 43 */       Checks.check(params, 1);
/*    */     }
/* 45 */     nglPointParameterfvEXT(pname, MemoryUtil.memAddress(params));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glPointParameterfvEXT(@NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 50 */     long __functionAddress = (GL.getICD()).glPointParameterfvEXT;
/* 51 */     if (Checks.CHECKS) {
/* 52 */       Checks.check(__functionAddress);
/* 53 */       Checks.check(params, 1);
/*    */     } 
/* 55 */     JNI.callPV(pname, params, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void glPointParameterfEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*    */   
/*    */   public static native void nglPointParameterfvEXT(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTPointParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */