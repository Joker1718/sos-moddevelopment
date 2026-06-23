/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
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
/*    */ public class WGLNVVertexArrayRange
/*    */ {
/*    */   protected WGLNVVertexArrayRange() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nwglAllocateMemoryNV(int size, float readfreq, float writefreq, float priority) {
/* 28 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglAllocateMemoryNV;
/* 29 */     if (Checks.CHECKS) {
/* 30 */       Checks.check(__functionAddress);
/*    */     }
/* 32 */     return JNI.callP(size, readfreq, writefreq, priority, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void *")
/*    */   public static ByteBuffer wglAllocateMemoryNV(@NativeType("GLsizei") int size, @NativeType("GLfloat") float readfreq, @NativeType("GLfloat") float writefreq, @NativeType("GLfloat") float priority) {
/* 38 */     long __result = nwglAllocateMemoryNV(size, readfreq, writefreq, priority);
/* 39 */     return MemoryUtil.memByteBufferSafe(__result, size);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nwglFreeMemoryNV(long pointer) {
/* 46 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglFreeMemoryNV;
/* 47 */     if (Checks.CHECKS) {
/* 48 */       Checks.check(__functionAddress);
/*    */     }
/* 50 */     JNI.callPV(pointer, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void wglFreeMemoryNV(@NativeType("void *") ByteBuffer pointer) {
/* 55 */     nwglFreeMemoryNV(MemoryUtil.memAddress(pointer));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLNVVertexArrayRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */