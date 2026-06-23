/*    */ package org.lwjgl.system;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MathUtil
/*    */ {
/*    */   public static boolean mathIsPoT(int value) {
/* 26 */     return (Integer.bitCount(value) == 1);
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
/*    */   public static int mathRoundPoT(int value) {
/* 40 */     return 1 << 32 - Integer.numberOfLeadingZeros(value - 1);
/*    */   }
/*    */   
/*    */   public static boolean mathHasZeroByte(int value) {
/* 44 */     return ((value - 16843009 & (value ^ 0xFFFFFFFF) & 0x80808080) != 0);
/*    */   }
/*    */   
/*    */   public static boolean mathHasZeroByte(long value) {
/* 48 */     return ((value - 72340172838076673L & (value ^ 0xFFFFFFFFFFFFFFFFL) & 0x8080808080808080L) != 0L);
/*    */   }
/*    */   
/*    */   public static boolean mathHasZeroShort(int value) {
/* 52 */     return ((value - 65537 & (value ^ 0xFFFFFFFF) & 0x80008000) != 0);
/*    */   }
/*    */   
/*    */   public static boolean mathHasZeroShort(long value) {
/* 56 */     return ((value - 281479271743489L & (value ^ 0xFFFFFFFFFFFFFFFFL) & 0x8000800080008000L) != 0L);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\MathUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */