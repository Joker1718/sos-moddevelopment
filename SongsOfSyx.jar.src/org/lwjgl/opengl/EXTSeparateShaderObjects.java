/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTSeparateShaderObjects
/*    */ {
/*    */   public static final int GL_ACTIVE_PROGRAM_EXT = 35725;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected EXTSeparateShaderObjects() {
/* 23 */     throw new UnsupportedOperationException();
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLuint")
/*    */   public static int glCreateShaderProgramEXT(@NativeType("GLenum") int type, @NativeType("GLchar const *") ByteBuffer string) {
/* 44 */     if (Checks.CHECKS) {
/* 45 */       Checks.checkNT1(string);
/*    */     }
/* 47 */     return nglCreateShaderProgramEXT(type, MemoryUtil.memAddress(string));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLuint")
/*    */   public static int glCreateShaderProgramEXT(@NativeType("GLenum") int type, @NativeType("GLchar const *") CharSequence string) {
/* 53 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 55 */       stack.nUTF8(string, true);
/* 56 */       long stringEncoded = stack.getPointerAddress();
/* 57 */       return nglCreateShaderProgramEXT(type, stringEncoded);
/*    */     } finally {
/* 59 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native void glUseShaderProgramEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */   
/*    */   public static native void glActiveProgramEXT(@NativeType("GLuint") int paramInt);
/*    */   
/*    */   public static native int nglCreateShaderProgramEXT(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTSeparateShaderObjects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */