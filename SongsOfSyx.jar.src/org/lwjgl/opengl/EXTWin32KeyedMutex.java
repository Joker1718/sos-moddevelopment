/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTWin32KeyedMutex
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected EXTWin32KeyedMutex() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   @NativeType("GLboolean")
/*    */   public static native boolean glReleaseKeyedMutexWin32EXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint64") long paramLong);
/*    */   
/*    */   @NativeType("GLboolean")
/*    */   public static native boolean glAcquireKeyedMutexWin32EXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint64") long paramLong, @NativeType("GLuint") int paramInt2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTWin32KeyedMutex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */