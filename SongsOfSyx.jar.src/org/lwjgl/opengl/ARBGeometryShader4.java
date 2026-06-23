/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBGeometryShader4 {
/*    */   public static final int GL_GEOMETRY_SHADER_ARB = 36313;
/*    */   public static final int GL_GEOMETRY_VERTICES_OUT_ARB = 36314;
/*    */   public static final int GL_GEOMETRY_INPUT_TYPE_ARB = 36315;
/*    */   public static final int GL_GEOMETRY_OUTPUT_TYPE_ARB = 36316;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS_ARB = 35881;
/*    */   
/*    */   public static final int GL_MAX_GEOMETRY_VARYING_COMPONENTS_ARB = 36317;
/*    */   
/*    */   public static final int GL_MAX_VERTEX_VARYING_COMPONENTS_ARB = 36318;
/*    */   
/*    */   public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS_ARB = 36319;
/*    */   
/*    */   public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES_ARB = 36320;
/*    */   
/*    */   public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS_ARB = 36321;
/*    */   public static final int GL_LINES_ADJACENCY_ARB = 10;
/*    */   public static final int GL_LINE_STRIP_ADJACENCY_ARB = 11;
/*    */   public static final int GL_TRIANGLES_ADJACENCY_ARB = 12;
/*    */   public static final int GL_TRIANGLE_STRIP_ADJACENCY_ARB = 13;
/*    */   public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS_ARB = 36264;
/*    */   public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_COUNT_ARB = 36265;
/*    */   public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED_ARB = 36263;
/*    */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
/*    */   public static final int GL_PROGRAM_POINT_SIZE_ARB = 34370;
/*    */   
/*    */   public static native void glFramebufferTextureFaceARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5);
/*    */   
/*    */   public static native void glFramebufferTextureLayerARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*    */   
/*    */   public static native void glFramebufferTextureARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4);
/*    */   
/*    */   public static native void glProgramParameteriARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*    */   
/*    */   protected ARBGeometryShader4() {
/* 46 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBGeometryShader4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */