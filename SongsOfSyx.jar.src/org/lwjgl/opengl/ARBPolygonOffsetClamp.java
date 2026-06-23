/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBPolygonOffsetClamp
/*    */ {
/*    */   public static final int GL_POLYGON_OFFSET_CLAMP = 36379;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ARBPolygonOffsetClamp() {
/* 17 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glPolygonOffsetClamp(@NativeType("GLfloat") float factor, @NativeType("GLfloat") float units, @NativeType("GLfloat") float clamp) {
/* 24 */     GL46C.glPolygonOffsetClamp(factor, units, clamp);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBPolygonOffsetClamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */