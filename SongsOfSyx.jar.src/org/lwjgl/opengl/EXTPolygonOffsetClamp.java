/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTPolygonOffsetClamp
/*    */ {
/*    */   public static final int GL_POLYGON_OFFSET_CLAMP_EXT = 36379;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected EXTPolygonOffsetClamp() {
/* 17 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glPolygonOffsetClampEXT(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTPolygonOffsetClamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */