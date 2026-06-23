/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBInternalformatQuery
/*    */ {
/*    */   public static final int GL_NUM_SAMPLE_COUNTS = 37760;
/*    */   
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ARBInternalformatQuery() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglGetInternalformativ(int target, int internalformat, int pname, int bufSize, long params) {
/* 26 */     GL42C.nglGetInternalformativ(target, internalformat, pname, bufSize, params);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetInternalformativ(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 31 */     GL42C.glGetInternalformativ(target, internalformat, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void")
/*    */   public static int glGetInternalformati(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname) {
/* 37 */     return GL42C.glGetInternalformati(target, internalformat, pname);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetInternalformativ(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 42 */     GL42C.glGetInternalformativ(target, internalformat, pname, params);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBInternalformatQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */