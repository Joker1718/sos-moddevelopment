/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVQueryResource {
/*    */   public static final int GL_QUERY_RESOURCE_TYPE_VIDMEM_ALLOC_NV = 38208;
/*    */   public static final int GL_QUERY_RESOURCE_MEMTYPE_VIDMEM_NV = 38210;
/*    */   public static final int GL_QUERY_RESOURCE_SYS_RESERVED_NV = 38212;
/*    */   public static final int GL_QUERY_RESOURCE_TEXTURE_NV = 38213;
/*    */   public static final int GL_QUERY_RESOURCE_RENDERBUFFER_NV = 38214;
/*    */   public static final int GL_QUERY_RESOURCE_BUFFEROBJECT_NV = 38215;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
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
/*    */   protected NVQueryResource() {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glQueryResourceNV(@NativeType("GLenum") int queryType, @NativeType("GLint") int pname, @NativeType("GLint *") IntBuffer buffer) {
/* 41 */     return nglQueryResourceNV(queryType, pname, buffer.remaining(), MemoryUtil.memAddress(buffer));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glQueryResourceNV(@NativeType("GLenum") int queryType, @NativeType("GLint") int pname, @NativeType("GLint *") int[] buffer) {
/* 47 */     long __functionAddress = (GL.getICD()).glQueryResourceNV;
/* 48 */     if (Checks.CHECKS) {
/* 49 */       Checks.check(__functionAddress);
/*    */     }
/* 51 */     return JNI.callPI(queryType, pname, buffer.length, buffer, __functionAddress);
/*    */   }
/*    */   
/*    */   public static native int nglQueryResourceNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVQueryResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */