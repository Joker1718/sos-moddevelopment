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
/*    */ public final class CheckIntrinsics
/*    */ {
/*    */   public static int checkIndex(int index, int length) {
/* 18 */     if (index < 0 || length <= index) {
/* 19 */       throw new IndexOutOfBoundsException();
/*    */     }
/* 21 */     return index;
/*    */   }
/*    */   
/*    */   public static int checkFromToIndex(int fromIndex, int toIndex, int length) {
/* 25 */     if (fromIndex < 0 || toIndex < fromIndex || length < toIndex) {
/* 26 */       throw new IndexOutOfBoundsException();
/*    */     }
/* 28 */     return fromIndex;
/*    */   }
/*    */   
/*    */   public static int checkFromIndexSize(int fromIndex, int size, int length) {
/* 32 */     if ((length | fromIndex | size) < 0 || length - fromIndex < size) {
/* 33 */       throw new IndexOutOfBoundsException();
/*    */     }
/* 35 */     return fromIndex;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\CheckIntrinsics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */