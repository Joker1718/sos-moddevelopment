/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTMemoryObjectFD
/*    */ {
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_FD_EXT = 38278;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected EXTMemoryObjectFD() {
/* 17 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glImportMemoryFdEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint64") long paramLong, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTMemoryObjectFD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */