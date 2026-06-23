/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GREMEDYStringMarker
/*    */ {
/*    */   static {
/* 17 */     GL.initialize();
/*    */   }
/*    */   protected GREMEDYStringMarker() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glStringMarkerGREMEDY(@NativeType("GLchar const *") ByteBuffer string) {
/* 30 */     nglStringMarkerGREMEDY(string.remaining(), MemoryUtil.memAddress(string));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glStringMarkerGREMEDY(@NativeType("GLchar const *") CharSequence string) {
/* 35 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 37 */       int stringEncodedLength = stack.nUTF8(string, false);
/* 38 */       long stringEncoded = stack.getPointerAddress();
/* 39 */       nglStringMarkerGREMEDY(stringEncodedLength, stringEncoded);
/*    */     } finally {
/* 41 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native void nglStringMarkerGREMEDY(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GREMEDYStringMarker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */