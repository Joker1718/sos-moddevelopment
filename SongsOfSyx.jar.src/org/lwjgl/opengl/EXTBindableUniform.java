/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class EXTBindableUniform
/*    */ {
/*    */   public static final int GL_MAX_VERTEX_BINDABLE_UNIFORMS_EXT = 36322;
/*    */   public static final int GL_MAX_FRAGMENT_BINDABLE_UNIFORMS_EXT = 36323;
/*    */   public static final int GL_MAX_GEOMETRY_BINDABLE_UNIFORMS_EXT = 36324;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   public static final int GL_MAX_BINDABLE_UNIFORM_SIZE_EXT = 36333; public static final int GL_UNIFORM_BUFFER_BINDING_EXT = 36335; public static final int GL_UNIFORM_BUFFER_EXT = 36334;
/*    */   @NativeType("GLintptr")
/*    */   public static native long glGetUniformOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static native int glGetUniformBufferSizeEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*    */   
/*    */   public static native void glUniformBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*    */   
/*    */   protected EXTBindableUniform() {
/* 24 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTBindableUniform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */