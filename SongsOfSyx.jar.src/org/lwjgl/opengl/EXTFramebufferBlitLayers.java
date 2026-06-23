/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTFramebufferBlitLayers
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected EXTFramebufferBlitLayers() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glBlitFramebufferLayerEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLbitfield") int paramInt11, @NativeType("GLenum") int paramInt12);
/*    */   
/*    */   public static native void glBlitFramebufferLayersEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLbitfield") int paramInt9, @NativeType("GLenum") int paramInt10);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTFramebufferBlitLayers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */