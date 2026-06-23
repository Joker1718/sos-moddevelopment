/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class NVPrimitiveRestart
/*    */ {
/*    */   public static final int GL_PRIMITIVE_RESTART_NV = 34136;
/*    */   public static final int GL_PRIMITIVE_RESTART_INDEX_NV = 34137;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glPrimitiveRestartIndexNV(@NativeType("GLuint") int paramInt);
/*    */   
/*    */   protected NVPrimitiveRestart() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glPrimitiveRestartNV();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVPrimitiveRestart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */