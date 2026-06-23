/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.LongBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBTimerQuery
/*    */ {
/*    */   public static final int GL_TIME_ELAPSED = 35007;
/*    */   public static final int GL_TIMESTAMP = 36392;
/*    */   
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBTimerQuery() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glQueryCounter(@NativeType("GLuint") int id, @NativeType("GLenum") int target) {
/* 28 */     GL33C.glQueryCounter(id, target);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglGetQueryObjecti64v(int id, int pname, long params) {
/* 35 */     GL33C.nglGetQueryObjecti64v(id, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
/* 40 */     GL33C.glGetQueryObjecti64v(id, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long params) {
/* 45 */     GL33C.glGetQueryObjecti64v(id, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void")
/*    */   public static long glGetQueryObjecti64(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 51 */     return GL33C.glGetQueryObjecti64(id, pname);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglGetQueryObjectui64v(int id, int pname, long params) {
/* 58 */     GL33C.nglGetQueryObjectui64v(id, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") LongBuffer params) {
/* 63 */     GL33C.glGetQueryObjectui64v(id, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long params) {
/* 68 */     GL33C.glGetQueryObjectui64v(id, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void")
/*    */   public static long glGetQueryObjectui64(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 74 */     return GL33C.glGetQueryObjectui64(id, pname);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint64 *") long[] params) {
/* 79 */     GL33C.glGetQueryObjecti64v(id, pname, params);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint64 *") long[] params) {
/* 84 */     GL33C.glGetQueryObjectui64v(id, pname, params);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTimerQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */