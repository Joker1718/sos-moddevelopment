/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class NVVertexBufferUnifiedMemory
/*     */ {
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_UNIFIED_NV = 36638;
/*     */   public static final int GL_ELEMENT_ARRAY_UNIFIED_NV = 36639;
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_ADDRESS_NV = 36640;
/*     */   public static final int GL_TEXTURE_COORD_ARRAY_ADDRESS_NV = 36645;
/*     */   public static final int GL_VERTEX_ARRAY_ADDRESS_NV = 36641;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_NORMAL_ARRAY_ADDRESS_NV = 36642;
/*     */   
/*     */   public static final int GL_COLOR_ARRAY_ADDRESS_NV = 36643;
/*     */   
/*     */   public static final int GL_INDEX_ARRAY_ADDRESS_NV = 36644;
/*     */   
/*     */   public static final int GL_EDGE_FLAG_ARRAY_ADDRESS_NV = 36646;
/*     */   
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_ADDRESS_NV = 36647;
/*     */   
/*     */   public static final int GL_FOG_COORD_ARRAY_ADDRESS_NV = 36648;
/*     */   
/*     */   public static final int GL_ELEMENT_ARRAY_ADDRESS_NV = 36649;
/*     */   
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_LENGTH_NV = 36650;
/*     */   
/*     */   public static final int GL_TEXTURE_COORD_ARRAY_LENGTH_NV = 36655;
/*     */   
/*     */   public static final int GL_VERTEX_ARRAY_LENGTH_NV = 36651;
/*     */   
/*     */   public static final int GL_NORMAL_ARRAY_LENGTH_NV = 36652;
/*     */   
/*     */   public static final int GL_COLOR_ARRAY_LENGTH_NV = 36653;
/*     */   
/*     */   public static final int GL_INDEX_ARRAY_LENGTH_NV = 36654;
/*     */   public static final int GL_EDGE_FLAG_ARRAY_LENGTH_NV = 36656;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_LENGTH_NV = 36657;
/*     */   public static final int GL_FOG_COORD_ARRAY_LENGTH_NV = 36658;
/*     */   public static final int GL_ELEMENT_ARRAY_LENGTH_NV = 36659;
/*     */   
/*     */   protected NVVertexBufferUnifiedMemory() {
/*  54 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetIntegerui64i_vNV(@NativeType("GLenum") int value, @NativeType("GLuint") int index, @NativeType("GLuint64EXT *") LongBuffer result) {
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.check(result, 1);
/*     */     }
/* 122 */     nglGetIntegerui64i_vNV(value, index, MemoryUtil.memAddress(result));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetIntegerui64iNV(@NativeType("GLenum") int value, @NativeType("GLuint") int index) {
/* 128 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 130 */       LongBuffer result = stack.callocLong(1);
/* 131 */       nglGetIntegerui64i_vNV(value, index, MemoryUtil.memAddress(result));
/* 132 */       return result.get(0);
/*     */     } finally {
/* 134 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetIntegerui64i_vNV(@NativeType("GLenum") int value, @NativeType("GLuint") int index, @NativeType("GLuint64EXT *") long[] result) {
/* 140 */     long __functionAddress = (GL.getICD()).glGetIntegerui64i_vNV;
/* 141 */     if (Checks.CHECKS) {
/* 142 */       Checks.check(__functionAddress);
/* 143 */       Checks.check(result, 1);
/*     */     } 
/* 145 */     JNI.callPV(value, index, result, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glBufferAddressRangeNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*     */   
/*     */   public static native void glVertexFormatNV(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3);
/*     */   
/*     */   public static native void glNormalFormatNV(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2);
/*     */   
/*     */   public static native void glColorFormatNV(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3);
/*     */   
/*     */   public static native void glIndexFormatNV(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2);
/*     */   
/*     */   public static native void glTexCoordFormatNV(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3);
/*     */   
/*     */   public static native void glEdgeFlagFormatNV(@NativeType("GLsizei") int paramInt);
/*     */   
/*     */   public static native void glSecondaryColorFormatNV(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3);
/*     */   
/*     */   public static native void glFogCoordFormatNV(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2);
/*     */   
/*     */   public static native void glVertexAttribFormatNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4);
/*     */   
/*     */   public static native void glVertexAttribIFormatNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*     */   
/*     */   public static native void nglGetIntegerui64i_vNV(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVVertexBufferUnifiedMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */