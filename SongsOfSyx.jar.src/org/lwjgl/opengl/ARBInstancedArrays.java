/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBInstancedArrays
/*    */ {
/*    */   public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB = 35070;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ARBInstancedArrays() {
/* 17 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glVertexArrayVertexAttribDivisorEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*    */   
/*    */   public static native void glVertexAttribDivisorARB(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBInstancedArrays.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */