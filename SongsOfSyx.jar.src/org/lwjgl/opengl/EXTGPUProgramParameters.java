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
/*    */ 
/*    */ 
/*    */ public class EXTGPUProgramParameters
/*    */ {
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */   protected EXTGPUProgramParameters() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glProgramEnvParameters4fvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer params) {
/* 31 */     nglProgramEnvParameters4fvEXT(target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glProgramLocalParameters4fvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") FloatBuffer params) {
/* 41 */     nglProgramLocalParameters4fvEXT(target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glProgramEnvParameters4fvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] params) {
/* 46 */     long __functionAddress = (GL.getICD()).glProgramEnvParameters4fvEXT;
/* 47 */     if (Checks.CHECKS) {
/* 48 */       Checks.check(__functionAddress);
/*    */     }
/* 50 */     JNI.callPV(target, index, params.length >> 2, params, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glProgramLocalParameters4fvEXT(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLfloat const *") float[] params) {
/* 55 */     long __functionAddress = (GL.getICD()).glProgramLocalParameters4fvEXT;
/* 56 */     if (Checks.CHECKS) {
/* 57 */       Checks.check(__functionAddress);
/*    */     }
/* 59 */     JNI.callPV(target, index, params.length >> 2, params, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglProgramEnvParameters4fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void nglProgramLocalParameters4fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTGPUProgramParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */