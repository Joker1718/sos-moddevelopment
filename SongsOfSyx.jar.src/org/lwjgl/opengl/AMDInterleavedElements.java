/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class AMDInterleavedElements
/*    */ {
/*    */   public static final int GL_VERTEX_ELEMENT_SWIZZLE_AMD = 37284;
/*    */   public static final int GL_VERTEX_ID_SWIZZLE_AMD = 37285;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glVertexAttribParameteriAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*    */   
/*    */   protected AMDInterleavedElements() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\AMDInterleavedElements.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */