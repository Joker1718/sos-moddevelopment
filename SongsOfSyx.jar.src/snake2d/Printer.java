/*    */ package snake2d;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Printer
/*    */ {
/*    */   private static final String pre = "[SNAKE2D] ";
/*    */   private static final String fin = "[SNAKE2D] ------------------------";
/*    */   
/*    */   public static void ln() {
/* 12 */     System.out.println();
/*    */   }
/*    */   
/*    */   public static void ln(Object info) {
/* 16 */     System.out.println("[SNAKE2D] " + info);
/*    */   }
/*    */   
/*    */   public static void pr(Object info) {
/* 20 */     System.out.print(info);
/*    */   }
/*    */   
/*    */   public static void err(Object info) {
/* 24 */     System.err.println("[SNAKE2D] " + info);
/*    */   }
/*    */   
/*    */   public static void ln(String title, String... info) {
/* 28 */     System.out.print("[SNAKE2D] " + title + ": "); byte b; int i; String[] arrayOfString;
/* 29 */     for (i = (arrayOfString = info).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 30 */       System.out.print(String.valueOf(s) + ", "); b++; }
/* 31 */      System.out.println();
/*    */   }
/*    */   
/*    */   public static void ln(String title, Iterable<String> info) {
/* 35 */     System.out.print("[SNAKE2D] " + title + ": ");
/* 36 */     for (String s : info)
/* 37 */       System.out.print(String.valueOf(s) + ", "); 
/* 38 */     System.out.println();
/*    */   }
/*    */   
/*    */   public static void fin() {
/* 42 */     System.out.println("[SNAKE2D] ------------------------");
/* 43 */     System.out.println();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Printer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */