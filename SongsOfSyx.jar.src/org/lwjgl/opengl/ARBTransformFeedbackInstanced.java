/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBTransformFeedbackInstanced
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected ARBTransformFeedbackInstanced() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glDrawTransformFeedbackInstanced(@NativeType("GLenum") int mode, @NativeType("GLuint") int id, @NativeType("GLsizei") int primcount) {
/* 22 */     GL42C.glDrawTransformFeedbackInstanced(mode, id, primcount);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glDrawTransformFeedbackStreamInstanced(@NativeType("GLenum") int mode, @NativeType("GLuint") int id, @NativeType("GLuint") int stream, @NativeType("GLsizei") int primcount) {
/* 29 */     GL42C.glDrawTransformFeedbackStreamInstanced(mode, id, stream, primcount);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTransformFeedbackInstanced.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */