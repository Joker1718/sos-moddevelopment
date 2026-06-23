/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class ARBGetProgramBinary
/*    */ {
/*    */   public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;
/*    */   public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
/*    */   public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
/*    */   public static final int GL_PROGRAM_BINARY_FORMATS = 34815;
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
/*    */   protected ARBGetProgramBinary() {
/* 27 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglGetProgramBinary(int program, int bufSize, long length, long binaryFormat, long binary) {
/* 34 */     GL41C.nglGetProgramBinary(program, bufSize, length, binaryFormat, binary);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetProgramBinary(@NativeType("GLuint") int program, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLenum *") IntBuffer binaryFormat, @NativeType("void *") ByteBuffer binary) {
/* 39 */     GL41C.glGetProgramBinary(program, length, binaryFormat, binary);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglProgramBinary(int program, int binaryFormat, long binary, int length) {
/* 46 */     GL41C.nglProgramBinary(program, binaryFormat, binary, length);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glProgramBinary(@NativeType("GLuint") int program, @NativeType("GLenum") int binaryFormat, @NativeType("void const *") ByteBuffer binary) {
/* 51 */     GL41C.glProgramBinary(program, binaryFormat, binary);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glProgramParameteri(@NativeType("GLuint") int program, @NativeType("GLenum") int pname, @NativeType("GLint") int value) {
/* 58 */     GL41C.glProgramParameteri(program, pname, value);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetProgramBinary(@NativeType("GLuint") int program, @NativeType("GLsizei *") int[] length, @NativeType("GLenum *") int[] binaryFormat, @NativeType("void *") ByteBuffer binary) {
/* 63 */     GL41C.glGetProgramBinary(program, length, binaryFormat, binary);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBGetProgramBinary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */