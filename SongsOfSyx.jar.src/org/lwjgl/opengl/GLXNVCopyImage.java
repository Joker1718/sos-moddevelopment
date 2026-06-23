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
/*    */ public class GLXNVCopyImage
/*    */ {
/*    */   protected GLXNVCopyImage() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glXCopyImageSubDataNV(@NativeType("Display *") long display, @NativeType("GLXContext") long srcCtx, @NativeType("GLuint") int srcName, @NativeType("GLenum") int srcTarget, @NativeType("GLint") int srcLevel, @NativeType("GLint") int srcX, @NativeType("GLint") int srcY, @NativeType("GLint") int srcZ, @NativeType("GLXContext") long dstCtx, @NativeType("GLuint") int dstName, @NativeType("GLenum") int dstTarget, @NativeType("GLint") int dstLevel, @NativeType("GLint") int dstX, @NativeType("GLint") int dstY, @NativeType("GLint") int dstZ, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth) {
/* 23 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCopyImageSubDataNV;
/* 24 */     if (Checks.CHECKS) {
/* 25 */       Checks.check(__functionAddress);
/* 26 */       Checks.check(display);
/*    */     } 
/* 28 */     JNI.callPPPV(display, srcCtx, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstCtx, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXNVCopyImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */