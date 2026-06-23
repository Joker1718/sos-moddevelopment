/*    */ package snake2d.util.misc;
/*    */ 
/*    */ 
/*    */ public class Numbers
/*    */ {
/*    */   public static String getSuffix(int nr) {
/*  7 */     nr = Math.abs(nr);
/*    */     
/*  9 */     if (nr == 1) {
/* 10 */       return "1st";
/*    */     }
/* 12 */     if (nr == 2) {
/* 13 */       return "2nd";
/*    */     }
/* 15 */     if (nr == 3) {
/* 16 */       return "3rd";
/*    */     }
/* 18 */     return String.valueOf(Integer.toString(nr)) + "th";
/*    */   }
/*    */ 
/*    */   
/*    */   public static void printBits(byte b) {
/* 23 */     printBits(Byte.toUnsignedLong(b), 8);
/*    */   }
/*    */   
/*    */   public static void printBits(long l) {
/* 27 */     printBits(l, 64);
/*    */   }
/*    */ 
/*    */   
/*    */   private static void printBits(long l, int bits) {
/* 32 */     StringBuilder s = new StringBuilder(bits);
/* 33 */     for (; bits > 0; bits--) {
/* 34 */       s.append(((l & 0x1L) == 1L) ? 49 : 48);
/* 35 */       l >>= 1L;
/*    */     } 
/* 37 */     s.reverse();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\Numbers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */