/*    */ package org.lwjgl.system;
/*    */ 
/*    */ import java.nio.charset.StandardCharsets;
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
/*    */ 
/*    */ final class MultiReleaseTextDecoding
/*    */ {
/*    */   static String decodeUTF8(long source, int length) {
/* 25 */     if (length <= 0) {
/* 26 */       return "";
/*    */     }
/*    */     
/* 29 */     if (Checks.DEBUG)
/*    */     {
/* 31 */       return jdkFallback(source, length);
/*    */     }
/*    */     
/* 34 */     char[] string = (length <= MemoryUtil.ARRAY_TLC_SIZE) ? MemoryUtil.ARRAY_TLC_CHAR.get() : new char[length];
/*    */     
/* 36 */     int i = 0, position = 0;
/*    */     
/* 38 */     while (position < length) {
/*    */       char c;
/*    */       
/* 41 */       int b0 = MemoryUtil.UNSAFE.getByte(null, source + position++) & 0xFF;
/* 42 */       if (b0 < 128) {
/* 43 */         c = (char)b0;
/*    */       } else {
/* 45 */         int b1 = MemoryUtil.UNSAFE.getByte(null, source + position++) & 0x3F;
/* 46 */         if ((b0 & 0xE0) == 192) {
/* 47 */           c = (char)((b0 & 0x1F) << 6 | b1);
/*    */         } else {
/* 49 */           int b2 = MemoryUtil.UNSAFE.getByte(null, source + position++) & 0x3F;
/* 50 */           if ((b0 & 0xF0) == 224) {
/* 51 */             c = (char)((b0 & 0xF) << 12 | b1 << 6 | b2);
/*    */           } else {
/* 53 */             int b3 = MemoryUtil.UNSAFE.getByte(null, source + position++) & 0x3F;
/* 54 */             int cp = (b0 & 0x7) << 18 | b1 << 12 | b2 << 6 | b3;
/*    */             
/* 56 */             if (i < length) {
/* 57 */               string[i++] = (char)((cp >>> 10) + 55232);
/*    */             }
/* 59 */             c = (char)((cp & 0x3FF) + 56320);
/*    */           } 
/*    */         } 
/*    */       } 
/* 63 */       if (i < length) {
/* 64 */         string[i++] = c;
/*    */       }
/*    */     } 
/*    */     
/* 68 */     return new String(string, 0, Math.min(i, length));
/*    */   }
/*    */   
/*    */   private static String jdkFallback(long source, int length) {
/* 72 */     byte[] bytes = (length <= MemoryUtil.ARRAY_TLC_SIZE) ? MemoryUtil.ARRAY_TLC_BYTE.get() : new byte[length];
/* 73 */     MemoryUtil.memByteBuffer(source, length).get(bytes, 0, length);
/* 74 */     return new String(bytes, 0, length, StandardCharsets.UTF_8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\MultiReleaseTextDecoding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */