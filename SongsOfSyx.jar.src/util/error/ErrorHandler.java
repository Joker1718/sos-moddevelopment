/*     */ package util.error;
/*     */ 
/*     */ import game.VERSION;
/*     */ import init.paths.PATHS;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.nio.file.Files;
/*     */ import snake2d.Errors;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileManager;
/*     */ import snake2d.util.misc.ERROR_HANDLER;
/*     */ import snake2d.util.process.Proccesser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ErrorHandler
/*     */   implements ERROR_HANDLER
/*     */ {
/*     */   private static final String bugMail = "info@songsofsyx.com";
/*     */   private static final String pgmname = "Songs of syx";
/*     */   
/*     */   public void handle(String output, String dump) {
/*  30 */     String path = null;
/*     */ 
/*     */     
/*     */     try {
/*  34 */       if ((PATHS.local()).LOGS.exists("UnhandledDump"))
/*  35 */         (PATHS.local()).LOGS.delete("UnhandledDump"); 
/*  36 */       String p = String.valueOf((PATHS.local()).LOGS.get()) + String.valueOf((PATHS.local()).LOGS.get()) + "UnhandledDump.txt";
/*  37 */       if ((new File(p)).createNewFile()) {
/*  38 */         PrintWriter out = new PrintWriter(p);
/*  39 */         out.println(dump);
/*  40 */         out.close();
/*  41 */         LOG.ln("saved " + p);
/*  42 */         path = p;
/*     */       } 
/*  44 */     } catch (IOException e1) {
/*     */       
/*  46 */       e1.printStackTrace();
/*     */     } 
/*     */     
/*  49 */     error(null, 2, "Unhandled error output: " + System.lineSeparator() + output, dump, path);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handle(Errors.DataError e, String dump) {
/*  54 */     error((Throwable)e, 0, e.error, dump, e.path);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handle(Errors.GameError e, String dump) {
/*  60 */     error((Throwable)e, 1, e.error, dump, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handle(Throwable e, String dump) {
/*  67 */     if (isModError(e)) {
/*  68 */       e.printStackTrace();
/*  69 */       handle(new Errors.DataError("An error has occured caused by a code mod. Please inform the modders of this error."), dump);
/*     */     } else {
/*  71 */       error(e, 3, e.getClass().getName() + ": " + e.getClass().getName(), dump, null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isModError(Throwable e) {
/*  76 */     if (e instanceof NoSuchFieldError) {
/*  77 */       return true;
/*     */     }
/*     */     
/*  80 */     if (e instanceof NoSuchMethodError) {
/*  81 */       return true;
/*     */     }
/*     */     
/*  84 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void error(Throwable ee, int type, String message, String dump, String dataPath) {
/*  91 */     String p = (new File("error.txt")).getAbsolutePath();
/*     */     
/*     */     try {
/*  94 */       if (((PATHS.local()).LOGS.getFiles()).length > 50) {
/*  95 */         int am = ((PATHS.local()).LOGS.getFiles()).length - 25; byte b; int i; String[] arrayOfString;
/*  96 */         for (i = (arrayOfString = (PATHS.local()).LOGS.getFiles()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/*  97 */           (PATHS.local()).LOGS.get(f).toFile().deleteOnExit();
/*  98 */           if (am-- < 0)
/*     */             break;  b++; }
/*     */       
/*     */       } else {
/* 102 */         while (((PATHS.local()).LOGS.getFiles()).length > 25) {
/* 103 */           String l = null;
/* 104 */           long ff = Long.MAX_VALUE; byte b; int i; String[] arrayOfString;
/* 105 */           for (i = (arrayOfString = (PATHS.local()).LOGS.getFiles()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/* 106 */             long lm = (PATHS.local()).LOGS.get(f).toFile().lastModified();
/* 107 */             if (lm < ff) {
/* 108 */               l = f;
/* 109 */               ff = lm;
/*     */             }  b++; }
/*     */           
/* 112 */           if (l != null) {
/* 113 */             Files.delete((PATHS.local()).LOGS.get(l));
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 120 */       p = FileManager.NAME.timeStampString(String.valueOf((PATHS.local()).LOGS.get()) + String.valueOf((PATHS.local()).LOGS.get()) + "error") + ".txt";
/* 121 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/* 125 */     if (type == 3) {
/*     */       
/*     */       try {
/*     */ 
/*     */         
/* 130 */         if ((new File(p)).createNewFile()) {
/* 131 */           PrintWriter out = new PrintWriter(p);
/* 132 */           out.println(dump);
/* 133 */           out.close();
/* 134 */           LOG.ln("saved " + p);
/*     */         } 
/* 136 */       } catch (IOException e1) {
/*     */         
/* 138 */         e1.printStackTrace();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 143 */     String dumpFile = p;
/*     */ 
/*     */     
/* 146 */     if (dataPath == null)
/* 147 */       dataPath = "none"; 
/* 148 */     if (message == null)
/* 149 */       message = "no message"; 
/* 150 */     if (dumpFile == null) {
/* 151 */       dumpFile = "none";
/*     */     }
/* 153 */     message = message.replaceAll("\"", "Quote");
/* 154 */     if (message.length() > 8000) {
/* 155 */       message = message.substring(0, 8000);
/*     */     }
/* 157 */     String eee = "unhandled " + System.currentTimeMillis();
/* 158 */     if (ee != null)
/* 159 */       eee = VERSION.VERSION_STRING + " " + VERSION.VERSION_STRING + " "; 
/* 160 */     if (ee != null && (ee.getStackTrace()).length > 0) {
/* 161 */       eee = eee + eee + ":" + ee.getStackTrace()[0].getClassName();
/*     */     }
/*     */     
/* 164 */     String[] args = {
/* 165 */         "Songs of syx", 
/* 166 */         "info@songsofsyx.com", "" + 
/* 167 */         type, 
/* 168 */         message, 
/* 169 */         dumpFile, 
/* 170 */         dataPath, 
/* 171 */         eee
/*     */       };
/*     */     
/* 174 */     Proccesser.exec(ErrorMessage.class, new String[0], args, new String[0]);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\error\ErrorHandler.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */