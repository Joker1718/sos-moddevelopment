/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBInvalidateSubdata
/*    */ {
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */   protected ARBInvalidateSubdata() {
/* 17 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glInvalidateTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth) {
/* 24 */     GL43C.glInvalidateTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glInvalidateTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level) {
/* 31 */     GL43C.glInvalidateTexImage(texture, level);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glInvalidateBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length) {
/* 38 */     GL43C.glInvalidateBufferSubData(buffer, offset, length);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glInvalidateBufferData(@NativeType("GLuint") int buffer) {
/* 45 */     GL43C.glInvalidateBufferData(buffer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglInvalidateFramebuffer(int target, int numAttachments, long attachments) {
/* 52 */     GL43C.nglInvalidateFramebuffer(target, numAttachments, attachments);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") IntBuffer attachments) {
/* 57 */     GL43C.glInvalidateFramebuffer(target, attachments);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int attachment) {
/* 62 */     GL43C.glInvalidateFramebuffer(target, attachment);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglInvalidateSubFramebuffer(int target, int numAttachments, long attachments, int x, int y, int width, int height) {
/* 69 */     GL43C.nglInvalidateSubFramebuffer(target, numAttachments, attachments, x, y, width, height);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") IntBuffer attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 74 */     GL43C.glInvalidateSubFramebuffer(target, attachments, x, y, width, height);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int attachment, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 79 */     GL43C.glInvalidateSubFramebuffer(target, attachment, x, y, width, height);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int[] attachments) {
/* 84 */     GL43C.glInvalidateFramebuffer(target, attachments);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int[] attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 89 */     GL43C.glInvalidateSubFramebuffer(target, attachments, x, y, width, height);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBInvalidateSubdata.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */