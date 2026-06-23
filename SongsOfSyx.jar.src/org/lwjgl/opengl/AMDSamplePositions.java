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
/*    */ 
/*    */ 
/*    */ public class AMDSamplePositions
/*    */ {
/*    */   public static final int GL_SUBSAMPLE_DISTANCE_AMD = 34879;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected AMDSamplePositions() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glSetMultisamplefvAMD(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer val) {
/* 33 */     if (Checks.CHECKS) {
/* 34 */       Checks.check(val, 2);
/*    */     }
/* 36 */     nglSetMultisamplefvAMD(pname, index, MemoryUtil.memAddress(val));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glSetMultisamplefvAMD(@NativeType("GLenum") int pname, @NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] val) {
/* 41 */     long __functionAddress = (GL.getICD()).glSetMultisamplefvAMD;
/* 42 */     if (Checks.CHECKS) {
/* 43 */       Checks.check(__functionAddress);
/* 44 */       Checks.check(val, 2);
/*    */     } 
/* 46 */     JNI.callPV(pname, index, val, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglSetMultisamplefvAMD(int paramInt1, int paramInt2, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\AMDSamplePositions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */