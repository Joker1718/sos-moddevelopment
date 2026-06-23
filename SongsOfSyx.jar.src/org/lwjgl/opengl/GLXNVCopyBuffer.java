/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GLXNVCopyBuffer
/*    */ {
/*    */   protected GLXNVCopyBuffer() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glXCopyBufferSubDataNV(@NativeType("Display *") long display, @NativeType("GLXContext") long readCtx, @NativeType("GLXContext") long writeCtx, @NativeType("GLenum") int readTarget, @NativeType("GLenum") int writeTarget, @NativeType("GLintptr") long readOffset, @NativeType("GLintptr") long writeOffset, @NativeType("GLsizeiptr") long size) {
/* 23 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCopyBufferSubDataNV;
/* 24 */     if (Checks.CHECKS) {
/* 25 */       Checks.check(__functionAddress);
/* 26 */       Checks.check(display);
/* 27 */       Checks.check(readCtx);
/* 28 */       Checks.check(writeCtx);
/*    */     } 
/* 30 */     JNI.callPPPPPPV(display, readCtx, writeCtx, readTarget, writeTarget, readOffset, writeOffset, size, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glXNamedCopyBufferSubDataNV(@NativeType("Display *") long display, @NativeType("GLXContext") long readCtx, @NativeType("GLXContext") long writeCtx, @NativeType("GLuint") int readBuffer, @NativeType("GLuint") int writeBuffer, @NativeType("GLintptr") long readOffset, @NativeType("GLintptr") long writeOffset, @NativeType("GLsizeiptr") long size) {
/* 37 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXNamedCopyBufferSubDataNV;
/* 38 */     if (Checks.CHECKS) {
/* 39 */       Checks.check(__functionAddress);
/* 40 */       Checks.check(display);
/* 41 */       Checks.check(readCtx);
/* 42 */       Checks.check(writeCtx);
/*    */     } 
/* 44 */     JNI.callPPPPPPV(display, readCtx, writeCtx, readBuffer, writeBuffer, readOffset, writeOffset, size, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXNVCopyBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */