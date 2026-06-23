/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVXConditionalRender
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected NVXConditionalRender() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glEndConditionalRenderNVX();
/*    */   
/*    */   public static native void glBeginConditionalRenderNVX(@NativeType("GLuint") int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVXConditionalRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */