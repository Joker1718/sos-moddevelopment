/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVPixelDataRange {
/*    */   public static final int GL_WRITE_PIXEL_DATA_RANGE_NV = 34936;
/*    */   public static final int GL_READ_PIXEL_DATA_RANGE_NV = 34937;
/*    */   public static final int GL_WRITE_PIXEL_DATA_RANGE_LENGTH_NV = 34938;
/*    */   public static final int GL_READ_PIXEL_DATA_RANGE_LENGTH_NV = 34939;
/*    */   public static final int GL_WRITE_PIXEL_DATA_RANGE_POINTER_NV = 34940;
/*    */   public static final int GL_READ_PIXEL_DATA_RANGE_POINTER_NV = 34941;
/*    */   
/*    */   static {
/* 16 */     GL.initialize();
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
/*    */   protected NVPixelDataRange() {
/* 31 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glPixelDataRangeNV(@NativeType("GLenum") int target, @NativeType("void const *") ByteBuffer pointer) {
/* 41 */     nglPixelDataRangeNV(target, pointer.remaining(), MemoryUtil.memAddress(pointer));
/*    */   }
/*    */   
/*    */   public static native void nglPixelDataRangeNV(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void glFlushPixelDataRangeNV(@NativeType("GLenum") int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVPixelDataRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */