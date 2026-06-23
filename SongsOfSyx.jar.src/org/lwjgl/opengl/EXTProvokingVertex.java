/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class EXTProvokingVertex {
/*    */   public static final int GL_FIRST_VERTEX_CONVENTION_EXT = 36429;
/*    */   public static final int GL_LAST_VERTEX_CONVENTION_EXT = 36430;
/*    */   public static final int GL_PROVOKING_VERTEX_EXT = 36431;
/*    */   public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION_EXT = 36428;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glProvokingVertexEXT(@NativeType("GLenum") int paramInt);
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTProvokingVertex() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTProvokingVertex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */