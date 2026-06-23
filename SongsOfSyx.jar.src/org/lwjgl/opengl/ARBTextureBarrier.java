/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBTextureBarrier
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected ARBTextureBarrier() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glTextureBarrier() {
/* 22 */     GL45C.glTextureBarrier();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTextureBarrier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */