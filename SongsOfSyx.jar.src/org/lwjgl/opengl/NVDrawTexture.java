/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVDrawTexture
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected NVDrawTexture() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glDrawTextureNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4, @NativeType("GLfloat") float paramFloat5, @NativeType("GLfloat") float paramFloat6, @NativeType("GLfloat") float paramFloat7, @NativeType("GLfloat") float paramFloat8, @NativeType("GLfloat") float paramFloat9);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVDrawTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */