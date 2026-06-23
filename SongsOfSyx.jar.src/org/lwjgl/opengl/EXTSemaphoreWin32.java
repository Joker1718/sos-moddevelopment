/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTSemaphoreWin32
/*    */ {
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_EXT = 38279;
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_KMT_EXT = 38280;
/*    */   public static final int GL_DEVICE_LUID_EXT = 38297;
/*    */   
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int GL_DEVICE_NODE_MASK_EXT = 38298;
/*    */ 
/*    */   
/*    */   public static final int GL_LUID_SIZE_EXT = 8;
/*    */ 
/*    */   
/*    */   public static final int GL_HANDLE_TYPE_D3D12_FENCE_EXT = 38292;
/*    */   
/*    */   public static final int GL_D3D12_FENCE_VALUE_EXT = 38293;
/*    */ 
/*    */   
/*    */   protected EXTSemaphoreWin32() {
/* 31 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glImportSemaphoreWin32HandleEXT(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int handleType, @NativeType("void *") long handle) {
/* 41 */     if (Checks.CHECKS) {
/* 42 */       Checks.check(handle);
/*    */     }
/* 44 */     nglImportSemaphoreWin32HandleEXT(semaphore, handleType, handle);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glImportSemaphoreWin32NameEXT(@NativeType("GLuint") int semaphore, @NativeType("GLenum") int handleType, @NativeType("void const *") long name) {
/* 54 */     if (Checks.CHECKS) {
/* 55 */       Checks.check(name);
/*    */     }
/* 57 */     nglImportSemaphoreWin32NameEXT(semaphore, handleType, name);
/*    */   }
/*    */   
/*    */   public static native void nglImportSemaphoreWin32HandleEXT(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void nglImportSemaphoreWin32NameEXT(int paramInt1, int paramInt2, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTSemaphoreWin32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */