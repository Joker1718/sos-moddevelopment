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
/*    */ 
/*    */ public class MESAFramebufferFlipY
/*    */ {
/*    */   public static final int GL_FRAMEBUFFER_FLIP_Y_MESA = 35771;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected MESAFramebufferFlipY() {
/* 23 */     throw new UnsupportedOperationException();
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
/*    */   public static void glGetFramebufferParameterivMESA(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 38 */     if (Checks.CHECKS) {
/* 39 */       Checks.check(params, 1);
/*    */     }
/* 41 */     nglGetFramebufferParameterivMESA(target, pname, MemoryUtil.memAddress(params));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetFramebufferParameterivMESA(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 46 */     long __functionAddress = (GL.getICD()).glGetFramebufferParameterivMESA;
/* 47 */     if (Checks.CHECKS) {
/* 48 */       Checks.check(__functionAddress);
/* 49 */       Checks.check(params, 1);
/*    */     } 
/* 51 */     JNI.callPV(target, pname, params, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void glFramebufferParameteriMESA(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*    */   
/*    */   public static native void nglGetFramebufferParameterivMESA(int paramInt1, int paramInt2, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\MESAFramebufferFlipY.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */