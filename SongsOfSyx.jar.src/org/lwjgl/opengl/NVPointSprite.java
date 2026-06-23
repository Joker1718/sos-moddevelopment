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
/*    */ public class NVPointSprite
/*    */ {
/*    */   public static final int GL_POINT_SPRITE_NV = 34913;
/*    */   public static final int GL_COORD_REPLACE_NV = 34914;
/*    */   public static final int GL_POINT_SPRITE_R_MODE_NV = 34915;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVPointSprite() {
/* 27 */     throw new UnsupportedOperationException();
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
/*    */   public static void glPointParameterivNV(@NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 42 */     if (Checks.CHECKS) {
/* 43 */       Checks.check(params, 1);
/*    */     }
/* 45 */     nglPointParameterivNV(pname, MemoryUtil.memAddress(params));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glPointParameterivNV(@NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 50 */     long __functionAddress = (GL.getICD()).glPointParameterivNV;
/* 51 */     if (Checks.CHECKS) {
/* 52 */       Checks.check(__functionAddress);
/* 53 */       Checks.check(params, 1);
/*    */     } 
/* 55 */     JNI.callPV(pname, params, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void glPointParameteriNV(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*    */   
/*    */   public static native void nglPointParameterivNV(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVPointSprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */