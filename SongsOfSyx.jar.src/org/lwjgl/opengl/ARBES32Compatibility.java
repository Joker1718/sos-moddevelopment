/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBES32Compatibility
/*    */ {
/*    */   public static final int GL_PRIMITIVE_BOUNDING_BOX_ARB = 37566;
/*    */   public static final int GL_MULTISAMPLE_LINE_WIDTH_RANGE_ARB = 37761;
/*    */   public static final int GL_MULTISAMPLE_LINE_WIDTH_GRANULARITY_ARB = 37762;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glPrimitiveBoundingBoxARB(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4, @NativeType("GLfloat") float paramFloat5, @NativeType("GLfloat") float paramFloat6, @NativeType("GLfloat") float paramFloat7, @NativeType("GLfloat") float paramFloat8);
/*    */ 
/*    */   
/*    */   protected ARBES32Compatibility() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBES32Compatibility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */