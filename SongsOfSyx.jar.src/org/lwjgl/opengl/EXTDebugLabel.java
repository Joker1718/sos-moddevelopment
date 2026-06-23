/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTDebugLabel
/*    */ {
/*    */   public static final int GL_BUFFER_OBJECT_EXT = 37201;
/*    */   public static final int GL_SHADER_OBJECT_EXT = 35656;
/*    */   public static final int GL_PROGRAM_OBJECT_EXT = 35648;
/*    */   
/*    */   static {
/* 19 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_VERTEX_ARRAY_OBJECT_EXT = 37204;
/*    */   
/*    */   public static final int GL_QUERY_OBJECT_EXT = 37203;
/*    */   
/*    */   public static final int GL_PROGRAM_PIPELINE_OBJECT_EXT = 35407;
/*    */   
/*    */   protected EXTDebugLabel() {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glLabelObjectEXT(@NativeType("GLenum") int type, @NativeType("GLuint") int object, @NativeType("GLchar const *") ByteBuffer label) {
/* 40 */     nglLabelObjectEXT(type, object, label.remaining(), MemoryUtil.memAddress(label));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glLabelObjectEXT(@NativeType("GLenum") int type, @NativeType("GLuint") int object, @NativeType("GLchar const *") CharSequence label) {
/* 45 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 47 */       int labelEncodedLength = stack.nUTF8(label, false);
/* 48 */       long labelEncoded = stack.getPointerAddress();
/* 49 */       nglLabelObjectEXT(type, object, labelEncodedLength, labelEncoded);
/*    */     } finally {
/* 51 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetObjectLabelEXT(@NativeType("GLenum") int type, @NativeType("GLuint") int object, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer label) {
/* 62 */     if (Checks.CHECKS) {
/* 63 */       Checks.check(length, 1);
/*    */     }
/* 65 */     nglGetObjectLabelEXT(type, object, label.remaining(), MemoryUtil.memAddress(length), MemoryUtil.memAddress(label));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void")
/*    */   public static String glGetObjectLabelEXT(@NativeType("GLenum") int type, @NativeType("GLuint") int object, @NativeType("GLsizei") int bufSize) {
/* 71 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 73 */       IntBuffer length = stack.ints(0);
/* 74 */       ByteBuffer label = stack.malloc(bufSize);
/* 75 */       nglGetObjectLabelEXT(type, object, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(label));
/* 76 */       return MemoryUtil.memUTF8(label, length.get(0));
/*    */     } finally {
/* 78 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetObjectLabelEXT(@NativeType("GLenum") int type, @NativeType("GLuint") int object, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer label) {
/* 84 */     long __functionAddress = (GL.getICD()).glGetObjectLabelEXT;
/* 85 */     if (Checks.CHECKS) {
/* 86 */       Checks.check(__functionAddress);
/* 87 */       Checks.check(length, 1);
/*    */     } 
/* 89 */     JNI.callPPV(type, object, label.remaining(), length, MemoryUtil.memAddress(label), __functionAddress);
/*    */   }
/*    */   
/*    */   public static native void nglLabelObjectEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void nglGetObjectLabelEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTDebugLabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */