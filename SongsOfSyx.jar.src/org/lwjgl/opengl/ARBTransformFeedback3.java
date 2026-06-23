/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBTransformFeedback3
/*    */ {
/*    */   public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
/*    */   public static final int GL_MAX_VERTEX_STREAMS = 36465;
/*    */   
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBTransformFeedback3() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glDrawTransformFeedbackStream(@NativeType("GLenum") int mode, @NativeType("GLuint") int id, @NativeType("GLuint") int stream) {
/* 28 */     GL40C.glDrawTransformFeedbackStream(mode, id, stream);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glBeginQueryIndexed(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLuint") int id) {
/* 35 */     GL40C.glBeginQueryIndexed(target, index, id);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glEndQueryIndexed(@NativeType("GLenum") int target, @NativeType("GLuint") int index) {
/* 42 */     GL40C.glEndQueryIndexed(target, index);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglGetQueryIndexediv(int target, int index, int pname, long params) {
/* 49 */     GL40C.nglGetQueryIndexediv(target, index, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetQueryIndexediv(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 54 */     GL40C.glGetQueryIndexediv(target, index, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void")
/*    */   public static int glGetQueryIndexedi(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/* 60 */     return GL40C.glGetQueryIndexedi(target, index, pname);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetQueryIndexediv(@NativeType("GLenum") int target, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 65 */     GL40C.glGetQueryIndexediv(target, index, pname, params);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTransformFeedback3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */