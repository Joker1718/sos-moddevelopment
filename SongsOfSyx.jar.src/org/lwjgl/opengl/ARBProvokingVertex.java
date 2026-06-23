/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBProvokingVertex {
/*    */   public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
/*    */   public static final int GL_LAST_VERTEX_CONVENTION = 36430;
/*    */   public static final int GL_PROVOKING_VERTEX = 36431;
/*    */   public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 36428;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBProvokingVertex() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glProvokingVertex(@NativeType("GLenum") int mode) {
/* 30 */     GL32C.glProvokingVertex(mode);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBProvokingVertex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */