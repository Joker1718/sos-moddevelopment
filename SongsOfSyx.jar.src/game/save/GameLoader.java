/*    */ package game.save;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.GameSpec;
/*    */ import game.VERSION;
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.CORE;
/*    */ import snake2d.CORE_STATE;
/*    */ import snake2d.Errors;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ 
/*    */ public class GameLoader
/*    */   implements CORE_STATE.Constructor
/*    */ {
/*    */   public final Path saveFile;
/*    */   public final String[] newScripts;
/*    */   
/*    */   public GameLoader(Path path, String... newScripts) {
/* 24 */     this.saveFile = path;
/* 25 */     this.newScripts = newScripts;
/*    */   }
/*    */ 
/*    */   
/*    */   public CORE_STATE getState() {
/* 30 */     FileGetter fg = null;
/* 31 */     GameSpec ss = null;
/* 32 */     CharSequence error = "No detectable error";
/*    */     
/*    */     try {
/* 35 */       fg = new FileGetter(this.saveFile, true);
/* 36 */       ss = GameSpec.get(fg, this.newScripts);
/* 37 */       CharSequence s = ss.crashCause();
/* 38 */       if (s != null)
/* 39 */         error = s; 
/* 40 */     } catch (IOException e) {
/* 41 */       e.printStackTrace();
/* 42 */       throw new Errors.DataError("Save is corrupted and can not be loaded!" + System.lineSeparator() + " " + String.valueOf(e), this.saveFile);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 47 */     LOG.ln("LOADING GAME", "Game version: " + VERSION.VERSION_STRING + " save: " + VERSION.versionString(VERSION.VERSION));
/* 48 */     String m = ""; byte b; int i; String[] arrayOfString;
/* 49 */     for (i = (arrayOfString = ss.mods).length, b = 0; b < i; ) { String mm = arrayOfString[b];
/* 50 */       m = m + m + " | "; b++; }
/* 51 */      LOG.ln("mod: " + m);
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 56 */       VIEW v = GAME.create(ss);
/* 57 */       (VIEW.inters()).load.activate();
/* 58 */       CORE.getInput().clearAllInput();
/* 59 */       GAME.saver().load(fg);
/* 60 */       return (CORE_STATE)v;
/* 61 */     } catch (snake2d.Errors.GameError ee) {
/*    */       
/* 63 */       throw ee;
/* 64 */     } catch (Exception e) {
/* 65 */       e.printStackTrace(System.out);
/* 66 */       throw new Errors.DataError("Save is corrupted and can not be loaded!" + System.lineSeparator() + " " + String.valueOf(error) + System.lineSeparator() + " " + String.valueOf(e), this.saveFile);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void set() {
/* 75 */     CORE.setCurrentState(this);
/*    */   }
/*    */   
/*    */   public static boolean quickload() {
/* 79 */     String ff = null;
/* 80 */     long time = -1L; byte b; int i; String[] arrayOfString;
/* 81 */     for (i = (arrayOfString = PATHS.local().save().getFiles()).length, b = 0; b < i; ) { String s = arrayOfString[b];
/*    */       
/* 83 */       if (ff == null || SaveFile.time(s) > time) {
/* 84 */         time = SaveFile.time(s);
/* 85 */         ff = s;
/*    */       } 
/*    */       b++; }
/*    */     
/* 89 */     if (ff != null) {
/* 90 */       CORE.setCurrentState(new GameLoader(PATHS.local().save().get(ff), new String[0]));
/* 91 */       return true;
/*    */     } 
/* 93 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\save\GameLoader.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */