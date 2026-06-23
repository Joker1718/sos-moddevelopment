/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class EXTMemoryObjectWin32
/*    */ {
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_EXT = 38279;
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_KMT_EXT = 38280;
/*    */   public static final int GL_DEVICE_LUID_EXT = 38297;
/*    */   public static final int GL_DEVICE_NODE_MASK_EXT = 38298;
/*    */   
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int GL_LUID_SIZE_EXT = 8;
/*    */ 
/*    */   
/*    */   public static final int GL_HANDLE_TYPE_D3D12_TILEPOOL_EXT = 38281;
/*    */ 
/*    */   
/*    */   public static final int GL_HANDLE_TYPE_D3D12_RESOURCE_EXT = 38282;
/*    */ 
/*    */   
/*    */   public static final int GL_HANDLE_TYPE_D3D11_IMAGE_EXT = 38283;
/*    */   
/*    */   public static final int GL_HANDLE_TYPE_D3D11_IMAGE_KMT_EXT = 38284;
/*    */ 
/*    */   
/*    */   protected EXTMemoryObjectWin32() {
/* 34 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glImportMemoryWin32HandleEXT(@NativeType("GLuint") int memory, @NativeType("GLuint64") long size, @NativeType("GLenum") int handleType, @NativeType("void *") long handle) {
/* 44 */     if (Checks.CHECKS) {
/* 45 */       Checks.check(handle);
/*    */     }
/* 47 */     nglImportMemoryWin32HandleEXT(memory, size, handleType, handle);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glImportMemoryWin32NameEXT(@NativeType("GLuint") int memory, @NativeType("GLuint64") long size, @NativeType("GLenum") int handleType, @NativeType("void const *") long name) {
/* 57 */     if (Checks.CHECKS) {
/* 58 */       Checks.check(name);
/*    */     }
/* 60 */     nglImportMemoryWin32NameEXT(memory, size, handleType, name);
/*    */   }
/*    */   
/*    */   public static native void nglImportMemoryWin32HandleEXT(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void nglImportMemoryWin32NameEXT(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTMemoryObjectWin32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */