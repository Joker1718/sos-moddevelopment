/*    */ package snake2d.util.misc;
/*    */ 
/*    */ import java.util.Locale;
/*    */ 
/*    */ public enum OS
/*    */ {
/*  7 */   MAC, WINDOWS, LINUX, UNSUPPORTED;
/*    */   
/*    */   public static OS get() {
/* 10 */     String str = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
/*    */     
/* 12 */     if (str.contains("mac") || str.contains("darwin")) {
/* 13 */       return MAC;
/*    */     }
/* 15 */     if (str.contains("nix") || str.contains("nux") || str.contains("aix")) {
/* 16 */       return LINUX;
/*    */     }
/* 18 */     if (str.contains("win"))
/* 19 */       return WINDOWS; 
/* 20 */     return UNSUPPORTED;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\OS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */