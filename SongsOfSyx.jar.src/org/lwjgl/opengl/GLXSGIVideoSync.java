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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GLXSGIVideoSync
/*    */ {
/*    */   protected GLXSGIVideoSync() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int nglXGetVideoSyncSGI(long count) {
/* 26 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetVideoSyncSGI;
/* 27 */     if (Checks.CHECKS) {
/* 28 */       Checks.check(__functionAddress);
/*    */     }
/* 30 */     return JNI.callPI(count, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glXGetVideoSyncSGI(@NativeType("unsigned int *") IntBuffer count) {
/* 36 */     if (Checks.CHECKS) {
/* 37 */       Checks.check(count, 1);
/*    */     }
/* 39 */     return nglXGetVideoSyncSGI(MemoryUtil.memAddress(count));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int nglXWaitVideoSyncSGI(int divisor, int remainder, long count) {
/* 46 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXWaitVideoSyncSGI;
/* 47 */     if (Checks.CHECKS) {
/* 48 */       Checks.check(__functionAddress);
/*    */     }
/* 50 */     return JNI.callPI(divisor, remainder, count, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glXWaitVideoSyncSGI(int divisor, int remainder, @NativeType("unsigned int *") IntBuffer count) {
/* 56 */     if (Checks.CHECKS) {
/* 57 */       Checks.check(count, 1);
/*    */     }
/* 59 */     return nglXWaitVideoSyncSGI(divisor, remainder, MemoryUtil.memAddress(count));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glXGetVideoSyncSGI(@NativeType("unsigned int *") int[] count) {
/* 65 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetVideoSyncSGI;
/* 66 */     if (Checks.CHECKS) {
/* 67 */       Checks.check(__functionAddress);
/* 68 */       Checks.check(count, 1);
/*    */     } 
/* 70 */     return JNI.callPI(count, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glXWaitVideoSyncSGI(int divisor, int remainder, @NativeType("unsigned int *") int[] count) {
/* 76 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXWaitVideoSyncSGI;
/* 77 */     if (Checks.CHECKS) {
/* 78 */       Checks.check(__functionAddress);
/* 79 */       Checks.check(count, 1);
/*    */     } 
/* 81 */     return JNI.callPI(divisor, remainder, count, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXSGIVideoSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */