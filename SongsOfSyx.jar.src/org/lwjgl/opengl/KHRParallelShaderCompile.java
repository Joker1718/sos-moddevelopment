/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class KHRParallelShaderCompile
/*    */ {
/*    */   public static final int GL_MAX_SHADER_COMPILER_THREADS_KHR = 37296;
/*    */   public static final int GL_COMPLETION_STATUS_KHR = 37297;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glMaxShaderCompilerThreadsKHR(@NativeType("GLuint") int paramInt);
/*    */   
/*    */   protected KHRParallelShaderCompile() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\KHRParallelShaderCompile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */