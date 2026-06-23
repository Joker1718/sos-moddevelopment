/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AMDDrawBuffersBlend
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected AMDDrawBuffersBlend() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glBlendEquationSeparateIndexedAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*    */   
/*    */   public static native void glBlendEquationIndexedAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */   
/*    */   public static native void glBlendFuncSeparateIndexedAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5);
/*    */   
/*    */   public static native void glBlendFuncIndexedAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\AMDDrawBuffersBlend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */