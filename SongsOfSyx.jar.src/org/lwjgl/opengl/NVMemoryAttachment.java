/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVMemoryAttachment
/*    */ {
/*    */   public static final int GL_ATTACHED_MEMORY_OBJECT_NV = 38308;
/*    */   public static final int GL_ATTACHED_MEMORY_OFFSET_NV = 38309;
/*    */   public static final int GL_MEMORY_ATTACHABLE_ALIGNMENT_NV = 38310;
/*    */   public static final int GL_MEMORY_ATTACHABLE_SIZE_NV = 38311;
/*    */   public static final int GL_MEMORY_ATTACHABLE_NV = 38312;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int GL_DETACHED_MEMORY_INCARNATION_NV = 38313;
/*    */ 
/*    */   
/*    */   public static final int GL_DETACHED_TEXTURES_NV = 38314;
/*    */ 
/*    */   
/*    */   public static final int GL_DETACHED_BUFFERS_NV = 38315;
/*    */ 
/*    */   
/*    */   public static final int GL_MAX_DETACHED_TEXTURES_NV = 38316;
/*    */   
/*    */   public static final int GL_MAX_DETACHED_BUFFERS_NV = 38317;
/*    */ 
/*    */   
/*    */   protected NVMemoryAttachment() {
/* 38 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetMemoryObjectDetachedResourcesuivNV(@NativeType("GLuint") int memory, @NativeType("GLenum") int pname, @NativeType("GLint") int first, @NativeType("GLuint *") IntBuffer params) {
/* 48 */     nglGetMemoryObjectDetachedResourcesuivNV(memory, pname, first, params.remaining(), MemoryUtil.memAddress(params));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetMemoryObjectDetachedResourcesuivNV(@NativeType("GLuint") int memory, @NativeType("GLenum") int pname, @NativeType("GLint") int first, @NativeType("GLuint *") int[] params) {
/* 78 */     long __functionAddress = (GL.getICD()).glGetMemoryObjectDetachedResourcesuivNV;
/* 79 */     if (Checks.CHECKS) {
/* 80 */       Checks.check(__functionAddress);
/*    */     }
/* 82 */     JNI.callPV(memory, pname, first, params.length, params, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglGetMemoryObjectDetachedResourcesuivNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void glResetMemoryObjectParameterNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */   
/*    */   public static native void glTexAttachMemoryNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glBufferAttachMemoryNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glTextureAttachMemoryNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glNamedBufferAttachMemoryNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVMemoryAttachment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */