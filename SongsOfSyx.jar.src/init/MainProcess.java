/*    */ package init;
/*    */ 
/*    */ import game.VERSION;
/*    */ import game.faction.player.PTitles;
/*    */ import init.paths.PATHS;
/*    */ import launcher.LSettings;
/*    */ import menu.Menu;
/*    */ import snake2d.CORE;
/*    */ import snake2d.LOG;
/*    */ import snake2d.PreLoader;
/*    */ import snake2d.util.misc.ERROR_HANDLER;
/*    */ import util.error.ErrorHandler;
/*    */ import util.text.D;
/*    */ 
/*    */ 
/*    */ class MainProcess
/*    */ {
/*    */   public static void main(String[] args) {
/* 19 */     PreLoader.load(VERSION.VERSION_STRING, PATHS.PATHS_BASE.PRELOADER, PATHS.PATHS_BASE.ICON_FOLDER + "Icon64.png");
/* 20 */     CORE.init((ERROR_HANDLER)new ErrorHandler());
/*    */     
/* 22 */     LOG.ln("*******************************");
/* 23 */     LOG.ln("* GAME " + VERSION.VERSION_STRING);
/* 24 */     LOG.ln("*******************************");
/*    */     
/* 26 */     LSettings s = new LSettings();
/*    */     
/* 28 */     String l = s.lang.get();
/* 29 */     PATHS.init(s.mods.get(), (l != null && l.length() > 0) ? l : null, (s.easy.get() == 1));
/*    */     
/* 31 */     D.init();
/*    */ 
/*    */     
/* 34 */     Menu.start();
/* 35 */     PTitles.achieve();
/* 36 */     PreLoader.exit();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\MainProcess.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */