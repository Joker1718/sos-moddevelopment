/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class NVVertexArrayRange
/*    */ {
/*    */   public static final int GL_VERTEX_ARRAY_RANGE_NV = 34077;
/*    */   public static final int GL_VERTEX_ARRAY_RANGE_LENGTH_NV = 34078;
/*    */   public static final int GL_VERTEX_ARRAY_RANGE_VALID_NV = 34079;
/*    */   public static final int GL_MAX_VERTEX_ARRAY_RANGE_ELEMENT_NV = 34080;
/*    */   public static final int GL_VERTEX_ARRAY_RANGE_POINTER_NV = 34081;
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
/*    */   protected NVVertexArrayRange() {
/* 28 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glVertexArrayRangeNV(@NativeType("void *") ByteBuffer pointer) {
/* 38 */     nglVertexArrayRangeNV(pointer.remaining(), MemoryUtil.memAddress(pointer));
/*    */   }
/*    */   
/*    */   public static native void nglVertexArrayRangeNV(int paramInt, long paramLong);
/*    */   
/*    */   public static native void glFlushVertexArrayRangeNV();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVVertexArrayRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */