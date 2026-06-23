/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTExternalBuffer
/*    */ {
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */   protected EXTExternalBuffer() {
/* 17 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glBufferStorageExternalEXT(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLeglClientBufferEXT") long clientBuffer, @NativeType("GLbitfield") int flags) {
/* 27 */     if (Checks.CHECKS) {
/* 28 */       Checks.check(clientBuffer);
/*    */     }
/* 30 */     nglBufferStorageExternalEXT(target, offset, size, clientBuffer, flags);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glNamedBufferStorageExternalEXT(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size, @NativeType("GLeglClientBufferEXT") long clientBuffer, @NativeType("GLbitfield") int flags) {
/* 40 */     if (Checks.CHECKS) {
/* 41 */       Checks.check(clientBuffer);
/*    */     }
/* 43 */     nglNamedBufferStorageExternalEXT(buffer, offset, size, clientBuffer, flags);
/*    */   }
/*    */   
/*    */   public static native void nglBufferStorageExternalEXT(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2);
/*    */   
/*    */   public static native void nglNamedBufferStorageExternalEXT(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTExternalBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */