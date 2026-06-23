/*    */ package snake2d.util.file;
/*    */ 
/*    */ import java.awt.Desktop;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Locale;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class FileOpener
/*    */ {
/*    */   public static void open(File file) {
/* 16 */     if (!openSystem(file.getPath()) && !openDESKTOP(file)) {
/* 17 */       System.err.println("unable to open file " + System.getProperty("os.name"));
/*    */     }
/*    */   }
/*    */   
/*    */   private static boolean openSystem(String what) {
/* 22 */     String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
/*    */     
/* 24 */     if (os.contains("win")) {
/* 25 */       return run("explorer", "%s", what);
/*    */     }
/*    */     
/* 28 */     if (os.contains("mac")) {
/* 29 */       return run("open", "%s", what);
/*    */     }
/*    */     
/* 32 */     return !(!run("kde-open", "%s", what) && !run("gnome-open", "%s", what) && !run("xdg-open", "%s", what));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean openDESKTOP(File file) {
/* 38 */     if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
/*    */       try {
/* 40 */         Desktop.getDesktop().open(file);
/* 41 */         return true;
/* 42 */       } catch (IOException e) {
/* 43 */         e.printStackTrace();
/*    */       } 
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean run(String command, String arg, String file) {
/* 52 */     String[] args = arg.split(" ");
/* 53 */     String[] parts = new String[args.length + 1];
/* 54 */     parts[0] = command;
/* 55 */     for (int i = 0; i < args.length; i++) {
/* 56 */       parts[i + 1] = String.format(args[0], new Object[] { file }).trim();
/*    */     } 
/*    */     
/*    */     try {
/* 60 */       Process p = Runtime.getRuntime().exec(parts);
/* 61 */       if (p == null) {
/* 62 */         return false;
/*    */       }
/*    */       try {
/* 65 */         if (p.exitValue() == 0)
/* 66 */           return true; 
/* 67 */         return false;
/* 68 */       } catch (IllegalThreadStateException itse) {
/* 69 */         return true;
/*    */       } 
/* 71 */     } catch (IOException e) {
/*    */       
/* 73 */       return false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\FileOpener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */