/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class ARBVertexAttribBinding {
/*    */   public static final int GL_VERTEX_ATTRIB_BINDING = 33492;
/*    */   public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493;
/*    */   public static final int GL_VERTEX_BINDING_DIVISOR = 33494;
/*    */   public static final int GL_VERTEX_BINDING_OFFSET = 33495;
/*    */   
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int GL_VERTEX_BINDING_STRIDE = 33496;
/*    */ 
/*    */   
/*    */   public static final int GL_VERTEX_BINDING_BUFFER = 36687;
/*    */ 
/*    */   
/*    */   public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497;
/*    */   
/*    */   public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498;
/*    */ 
/*    */   
/*    */   protected ARBVertexAttribBinding() {
/* 29 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glBindVertexBuffer(@NativeType("GLuint") int bindingindex, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizei") int stride) {
/* 36 */     GL43C.glBindVertexBuffer(bindingindex, buffer, offset, stride);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glVertexAttribFormat(@NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int relativeoffset) {
/* 43 */     GL43C.glVertexAttribFormat(attribindex, size, type, normalized, relativeoffset);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glVertexAttribIFormat(@NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLuint") int relativeoffset) {
/* 50 */     GL43C.glVertexAttribIFormat(attribindex, size, type, relativeoffset);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glVertexAttribLFormat(@NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLuint") int relativeoffset) {
/* 57 */     GL43C.glVertexAttribLFormat(attribindex, size, type, relativeoffset);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glVertexAttribBinding(@NativeType("GLuint") int attribindex, @NativeType("GLuint") int bindingindex) {
/* 64 */     GL43C.glVertexAttribBinding(attribindex, bindingindex);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glVertexBindingDivisor(@NativeType("GLuint") int bindingindex, @NativeType("GLuint") int divisor) {
/* 71 */     GL43C.glVertexBindingDivisor(bindingindex, divisor);
/*    */   }
/*    */   
/*    */   public static native void glVertexArrayBindVertexBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt4);
/*    */   
/*    */   public static native void glVertexArrayVertexAttribFormatEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt5);
/*    */   
/*    */   public static native void glVertexArrayVertexAttribIFormatEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5);
/*    */   
/*    */   public static native void glVertexArrayVertexAttribLFormatEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5);
/*    */   
/*    */   public static native void glVertexArrayVertexAttribBindingEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*    */   
/*    */   public static native void glVertexArrayVertexBindingDivisorEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBVertexAttribBinding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */