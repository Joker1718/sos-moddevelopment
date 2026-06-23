/*    */ package org.lwjgl.system;
/*    */ 
/*    */ import java.nio.ByteBuffer;
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
/*    */ public final class SharedLibraryUtil
/*    */ {
/*    */   private static native int getLibraryPath(long paramLong1, long paramLong2, int paramInt);
/*    */   
/*    */   public static String getLibraryPath(long pLib) {
/* 20 */     int maxLen = 256;
/*    */     
/* 22 */     ByteBuffer buffer = MemoryUtil.memAlloc(maxLen);
/*    */     try {
/*    */       while (true) {
/* 25 */         int len = getLibraryPath(pLib, MemoryUtil.memAddress(buffer), maxLen);
/* 26 */         if (len == 0) {
/* 27 */           return null;
/*    */         }
/* 29 */         if (len < maxLen) {
/* 30 */           return MemoryUtil.memUTF8(buffer, len - 1);
/*    */         }
/* 32 */         buffer = MemoryUtil.memRealloc(buffer, maxLen = maxLen * 3 / 2);
/*    */       } 
/*    */     } finally {
/* 35 */       MemoryUtil.memFree(buffer);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\SharedLibraryUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */