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
/*    */ public class EXTDebugMarker
/*    */ {
/*    */   static {
/* 17 */     GL.initialize();
/*    */   }
/*    */   protected EXTDebugMarker() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glInsertEventMarkerEXT(@NativeType("GLchar const *") ByteBuffer marker) {
/* 30 */     nglInsertEventMarkerEXT(marker.remaining(), MemoryUtil.memAddress(marker));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glInsertEventMarkerEXT(@NativeType("GLchar const *") CharSequence marker) {
/* 35 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 37 */       int markerEncodedLength = stack.nUTF8(marker, false);
/* 38 */       long markerEncoded = stack.getPointerAddress();
/* 39 */       nglInsertEventMarkerEXT(markerEncodedLength, markerEncoded);
/*    */     } finally {
/* 41 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glPushGroupMarkerEXT(@NativeType("GLchar const *") ByteBuffer marker) {
/* 52 */     nglPushGroupMarkerEXT(marker.remaining(), MemoryUtil.memAddress(marker));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glPushGroupMarkerEXT(@NativeType("GLchar const *") CharSequence marker) {
/* 57 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 59 */       int markerEncodedLength = stack.nUTF8(marker, false);
/* 60 */       long markerEncoded = stack.getPointerAddress();
/* 61 */       nglPushGroupMarkerEXT(markerEncodedLength, markerEncoded);
/*    */     } finally {
/* 63 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native void nglInsertEventMarkerEXT(int paramInt, long paramLong);
/*    */   
/*    */   public static native void nglPushGroupMarkerEXT(int paramInt, long paramLong);
/*    */   
/*    */   public static native void glPopGroupMarkerEXT();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTDebugMarker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */