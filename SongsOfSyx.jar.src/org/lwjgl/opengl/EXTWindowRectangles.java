/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTWindowRectangles
/*    */ {
/*    */   public static final int GL_INCLUSIVE_EXT = 36624;
/*    */   public static final int GL_EXCLUSIVE_EXT = 36625;
/*    */   public static final int GL_WINDOW_RECTANGLE_EXT = 36626;
/*    */   public static final int GL_WINDOW_RECTANGLE_MODE_EXT = 36627;
/*    */   public static final int GL_MAX_WINDOW_RECTANGLES_EXT = 36628;
/*    */   public static final int GL_NUM_WINDOW_RECTANGLES_EXT = 36629;
/*    */   
/*    */   static {
/* 20 */     GL.initialize();
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
/*    */   protected EXTWindowRectangles() {
/* 34 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glWindowRectanglesEXT(@NativeType("GLenum") int mode, @NativeType("GLint const *") IntBuffer box) {
/* 44 */     nglWindowRectanglesEXT(mode, Checks.remainingSafe(box) >> 2, MemoryUtil.memAddressSafe(box));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glWindowRectanglesEXT(@NativeType("GLenum") int mode, @NativeType("GLint const *") int[] box) {
/* 49 */     long __functionAddress = (GL.getICD()).glWindowRectanglesEXT;
/* 50 */     if (Checks.CHECKS) {
/* 51 */       Checks.check(__functionAddress);
/*    */     }
/* 53 */     JNI.callPV(mode, Checks.lengthSafe(box) >> 2, box, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglWindowRectanglesEXT(int paramInt1, int paramInt2, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTWindowRectangles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */