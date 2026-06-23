/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class ARBDrawIndirect
/*    */ {
/*    */   public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
/*    */   public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;
/*    */   
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBDrawIndirect() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglDrawArraysIndirect(int mode, long indirect) {
/* 28 */     GL40C.nglDrawArraysIndirect(mode, indirect);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect) {
/* 33 */     GL40C.glDrawArraysIndirect(mode, indirect);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect) {
/* 38 */     GL40C.glDrawArraysIndirect(mode, indirect);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indirect) {
/* 43 */     GL40C.glDrawArraysIndirect(mode, indirect);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglDrawElementsIndirect(int mode, int type, long indirect) {
/* 50 */     GL40C.nglDrawElementsIndirect(mode, type, indirect);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect) {
/* 55 */     GL40C.glDrawElementsIndirect(mode, type, indirect);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect) {
/* 60 */     GL40C.glDrawElementsIndirect(mode, type, indirect);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer indirect) {
/* 65 */     GL40C.glDrawElementsIndirect(mode, type, indirect);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") int[] indirect) {
/* 70 */     GL40C.glDrawArraysIndirect(mode, indirect);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") int[] indirect) {
/* 75 */     GL40C.glDrawElementsIndirect(mode, type, indirect);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBDrawIndirect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */