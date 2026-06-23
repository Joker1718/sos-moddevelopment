/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBBlendFuncExtended
/*    */ {
/*    */   public static final int GL_SRC1_COLOR = 35065;
/*    */   public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
/*    */   public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
/*    */   public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
/*    */   
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBBlendFuncExtended() {
/* 24 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglBindFragDataLocationIndexed(int program, int colorNumber, int index, long name) {
/* 31 */     GL33C.nglBindFragDataLocationIndexed(program, colorNumber, index, name);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int program, @NativeType("GLuint") int colorNumber, @NativeType("GLuint") int index, @NativeType("GLchar const *") ByteBuffer name) {
/* 36 */     GL33C.glBindFragDataLocationIndexed(program, colorNumber, index, name);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int program, @NativeType("GLuint") int colorNumber, @NativeType("GLuint") int index, @NativeType("GLchar const *") CharSequence name) {
/* 41 */     GL33C.glBindFragDataLocationIndexed(program, colorNumber, index, name);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int nglGetFragDataIndex(int program, long name) {
/* 48 */     return GL33C.nglGetFragDataIndex(program, name);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glGetFragDataIndex(@NativeType("GLuint") int program, @NativeType("GLchar const *") ByteBuffer name) {
/* 54 */     return GL33C.glGetFragDataIndex(program, name);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glGetFragDataIndex(@NativeType("GLuint") int program, @NativeType("GLchar const *") CharSequence name) {
/* 60 */     return GL33C.glGetFragDataIndex(program, name);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBBlendFuncExtended.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */