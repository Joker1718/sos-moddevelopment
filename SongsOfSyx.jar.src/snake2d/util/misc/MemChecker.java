/*    */ package snake2d.util.misc;
/*    */ 
/*    */ public final class MemChecker
/*    */ {
/*  5 */   private static long memo = 0L;
/*    */   
/*    */   public static boolean check() {
/*  8 */     Runtime rt = Runtime.getRuntime();
/*  9 */     long mem = rt.totalMemory() - rt.freeMemory();
/*    */     
/* 11 */     if (mem != memo) {
/* 12 */       System.out.println(mem - memo);
/* 13 */       memo = mem;
/* 14 */       return true;
/*    */     } 
/* 16 */     return false;
/*    */   }
/*    */   
/*    */   public static boolean check(int i) {
/* 20 */     Runtime rt = Runtime.getRuntime();
/* 21 */     long mem = rt.totalMemory() - rt.freeMemory();
/*    */     
/* 23 */     if (mem != memo) {
/* 24 */       System.out.println(String.valueOf(i) + " " + (mem - memo));
/* 25 */       memo = mem;
/* 26 */       return true;
/*    */     } 
/* 28 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void clear() {
/* 33 */     Runtime rt = Runtime.getRuntime();
/* 34 */     memo = rt.totalMemory() - rt.freeMemory();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\MemChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */