/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTCompiledVertexArray
/*    */ {
/*    */   public static final int GL_ARRAY_ELEMENT_LOCK_FIRST_EXT = 33192;
/*    */   public static final int GL_ARRAY_ELEMENT_LOCK_COUNT_EXT = 33193;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glUnlockArraysEXT();
/*    */   
/*    */   protected EXTCompiledVertexArray() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glLockArraysEXT(@NativeType("GLint") int paramInt1, @NativeType("GLsizei") int paramInt2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTCompiledVertexArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */