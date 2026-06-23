/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBDrawBuffersBlend
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected ARBDrawBuffersBlend() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glBlendFuncSeparateiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5);
/*    */   
/*    */   public static native void glBlendFunciARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*    */   
/*    */   public static native void glBlendEquationSeparateiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*    */   
/*    */   public static native void glBlendEquationiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBDrawBuffersBlend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */