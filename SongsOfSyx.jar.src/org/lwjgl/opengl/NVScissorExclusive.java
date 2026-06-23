/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVScissorExclusive
/*    */ {
/*    */   public static final int GL_SCISSOR_TEST_EXCLUSIVE_NV = 38229;
/*    */   public static final int GL_SCISSOR_BOX_EXCLUSIVE_NV = 38230;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVScissorExclusive() {
/* 25 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glScissorExclusiveArrayvNV(@NativeType("GLuint") int first, @NativeType("GLint const *") IntBuffer v) {
/* 35 */     nglScissorExclusiveArrayvNV(first, v.remaining() >> 2, MemoryUtil.memAddress(v));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glScissorExclusiveArrayvNV(@NativeType("GLuint") int first, @NativeType("GLint const *") int[] v) {
/* 45 */     long __functionAddress = (GL.getICD()).glScissorExclusiveArrayvNV;
/* 46 */     if (Checks.CHECKS) {
/* 47 */       Checks.check(__functionAddress);
/*    */     }
/* 49 */     JNI.callPV(first, v.length >> 2, v, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglScissorExclusiveArrayvNV(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void glScissorExclusiveNV(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVScissorExclusive.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */