/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class ARBDrawBuffers
/*    */ {
/*    */   public static final int GL_MAX_DRAW_BUFFERS_ARB = 34852;
/*    */   public static final int GL_DRAW_BUFFER0_ARB = 34853;
/*    */   public static final int GL_DRAW_BUFFER1_ARB = 34854;
/*    */   public static final int GL_DRAW_BUFFER2_ARB = 34855;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_DRAW_BUFFER3_ARB = 34856;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER4_ARB = 34857;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER5_ARB = 34858;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER6_ARB = 34859;
/*    */   public static final int GL_DRAW_BUFFER7_ARB = 34860;
/*    */   public static final int GL_DRAW_BUFFER8_ARB = 34861;
/*    */   public static final int GL_DRAW_BUFFER9_ARB = 34862;
/*    */   public static final int GL_DRAW_BUFFER10_ARB = 34863;
/*    */   public static final int GL_DRAW_BUFFER11_ARB = 34864;
/*    */   public static final int GL_DRAW_BUFFER12_ARB = 34865;
/*    */   public static final int GL_DRAW_BUFFER13_ARB = 34866;
/*    */   public static final int GL_DRAW_BUFFER14_ARB = 34867;
/*    */   public static final int GL_DRAW_BUFFER15_ARB = 34868;
/*    */   
/*    */   protected ARBDrawBuffers() {
/* 40 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glDrawBuffersARB(@NativeType("GLenum const *") IntBuffer bufs) {
/* 50 */     nglDrawBuffersARB(bufs.remaining(), MemoryUtil.memAddress(bufs));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawBuffersARB(@NativeType("GLenum const *") int[] bufs) {
/* 55 */     long __functionAddress = (GL.getICD()).glDrawBuffersARB;
/* 56 */     if (Checks.CHECKS) {
/* 57 */       Checks.check(__functionAddress);
/*    */     }
/* 59 */     JNI.callPV(bufs.length, bufs, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglDrawBuffersARB(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBDrawBuffers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */