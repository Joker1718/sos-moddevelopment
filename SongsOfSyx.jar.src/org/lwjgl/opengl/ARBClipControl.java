/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBClipControl
/*    */ {
/*    */   public static final int GL_LOWER_LEFT = 36001;
/*    */   public static final int GL_UPPER_LEFT = 36002;
/*    */   public static final int GL_NEGATIVE_ONE_TO_ONE = 37726;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int GL_ZERO_TO_ONE = 37727;
/*    */ 
/*    */   
/*    */   public static final int GL_CLIP_ORIGIN = 37724;
/*    */ 
/*    */   
/*    */   public static final int GL_CLIP_DEPTH_MODE = 37725;
/*    */ 
/*    */   
/*    */   protected ARBClipControl() {
/* 27 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glClipControl(@NativeType("GLenum") int origin, @NativeType("GLenum") int depth) {
/* 34 */     GL45C.glClipControl(origin, depth);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBClipControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */