/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBVertexArrayObject
/*    */ {
/*    */   public static final int GL_VERTEX_ARRAY_BINDING = 34229;
/*    */   
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ARBVertexArrayObject() {
/* 19 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glBindVertexArray(@NativeType("GLuint") int array) {
/* 26 */     GL30C.glBindVertexArray(array);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglDeleteVertexArrays(int n, long arrays) {
/* 33 */     GL30C.nglDeleteVertexArrays(n, arrays);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") IntBuffer arrays) {
/* 38 */     GL30C.glDeleteVertexArrays(arrays);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int array) {
/* 43 */     GL30C.glDeleteVertexArrays(array);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglGenVertexArrays(int n, long arrays) {
/* 50 */     GL30C.nglGenVertexArrays(n, arrays);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGenVertexArrays(@NativeType("GLuint *") IntBuffer arrays) {
/* 55 */     GL30C.glGenVertexArrays(arrays);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void")
/*    */   public static int glGenVertexArrays() {
/* 61 */     return GL30C.glGenVertexArrays();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLboolean")
/*    */   public static boolean glIsVertexArray(@NativeType("GLuint") int array) {
/* 69 */     return GL30C.glIsVertexArray(array);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int[] arrays) {
/* 74 */     GL30C.glDeleteVertexArrays(arrays);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGenVertexArrays(@NativeType("GLuint *") int[] arrays) {
/* 79 */     GL30C.glGenVertexArrays(arrays);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBVertexArrayObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */