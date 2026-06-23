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
/*    */ 
/*    */ public class EXTEGLImageStorage
/*    */ {
/*    */   static {
/* 20 */     GL.initialize();
/*    */   }
/*    */   protected EXTEGLImageStorage() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glEGLImageTargetTexStorageEXT(@NativeType("GLenum") int target, @NativeType("GLeglImageOES") long image, @NativeType("int const *") IntBuffer attrib_list) {
/* 33 */     if (Checks.CHECKS) {
/* 34 */       Checks.check(image);
/* 35 */       Checks.checkNTSafe(attrib_list);
/*    */     } 
/* 37 */     nglEGLImageTargetTexStorageEXT(target, image, MemoryUtil.memAddressSafe(attrib_list));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glEGLImageTargetTextureStorageEXT(@NativeType("GLuint") int texture, @NativeType("GLeglImageOES") long image, @NativeType("int const *") IntBuffer attrib_list) {
/* 47 */     if (Checks.CHECKS) {
/* 48 */       Checks.check(image);
/* 49 */       Checks.checkNTSafe(attrib_list);
/*    */     } 
/* 51 */     nglEGLImageTargetTextureStorageEXT(texture, image, MemoryUtil.memAddressSafe(attrib_list));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glEGLImageTargetTexStorageEXT(@NativeType("GLenum") int target, @NativeType("GLeglImageOES") long image, @NativeType("int const *") int[] attrib_list) {
/* 56 */     long __functionAddress = (GL.getICD()).glEGLImageTargetTexStorageEXT;
/* 57 */     if (Checks.CHECKS) {
/* 58 */       Checks.check(__functionAddress);
/* 59 */       Checks.check(image);
/* 60 */       Checks.checkNTSafe(attrib_list);
/*    */     } 
/* 62 */     JNI.callPPV(target, image, attrib_list, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glEGLImageTargetTextureStorageEXT(@NativeType("GLuint") int texture, @NativeType("GLeglImageOES") long image, @NativeType("int const *") int[] attrib_list) {
/* 67 */     long __functionAddress = (GL.getICD()).glEGLImageTargetTextureStorageEXT;
/* 68 */     if (Checks.CHECKS) {
/* 69 */       Checks.check(__functionAddress);
/* 70 */       Checks.check(image);
/* 71 */       Checks.checkNTSafe(attrib_list);
/*    */     } 
/* 73 */     JNI.callPPV(texture, image, attrib_list, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglEGLImageTargetTexStorageEXT(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void nglEGLImageTargetTextureStorageEXT(int paramInt, long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTEGLImageStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */