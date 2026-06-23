/*    */ package game.nobility;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ 
/*    */ class Init
/*    */ {
/*  9 */   final PATH pData = PATHS.INIT().getFolder("race").getFolder("nobility");
/* 10 */   final PATH pText = PATHS.TEXT().getFolder("race").getFolder("nobility");
/* 11 */   final ArrayList<Noble> all = new ArrayList(100);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\nobility\Init.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */