/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTStencilClearTag
/*    */ {
/*    */   public static final int GL_STENCIL_TAG_BITS_EXT = 35058;
/*    */   public static final int GL_STENCIL_CLEAR_TAG_VALUE_EXT = 35059;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glStencilClearTagEXT(@NativeType("GLsizei") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */   
/*    */   protected EXTStencilClearTag() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTStencilClearTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */