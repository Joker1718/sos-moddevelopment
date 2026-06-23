/*    */ package snake2d;
/*    */ 
/*    */ import snake2d.util.misc.OS;
/*    */ import snake2d.util.process.Proccesser;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class PreLoader
/*    */ {
/*    */   private static Process preloader;
/*    */   
/*    */   public static void load(String version, String pathToImage, String pathToIcon) {
/* 13 */     exit();
/*    */     try {
/* 15 */       if (OS.get() != OS.MAC)
/* 16 */         preloader = Proccesser.exec(PreLoaderSwing.class, new String[0], new String[] { version, pathToImage, pathToIcon }, new String[0]); 
/* 17 */     } catch (Exception e) {
/* 18 */       exit();
/* 19 */       e.printStackTrace();
/*    */       return;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void exit() {
/* 30 */     Process p = preloader;
/* 31 */     preloader = null;
/* 32 */     if (p == null) {
/*    */       return;
/*    */     }
/*    */     
/* 36 */     if (p.isAlive()) {
/*    */       try {
/* 38 */         p.getOutputStream().write(115);
/* 39 */         p.getOutputStream().write(115);
/* 40 */         p.getOutputStream().write(115);
/* 41 */         p.getOutputStream().write(115);
/* 42 */         p.getOutputStream().flush();
/*    */       
/*    */       }
/* 45 */       catch (Exception e) {
/* 46 */         e.printStackTrace();
/*    */       } 
/*    */     }
/* 49 */     preloader = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\PreLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */