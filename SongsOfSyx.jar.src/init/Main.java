/*     */ package init;
/*     */ 
/*     */ import game.VERSION;
/*     */ import init.paths.PATHS;
/*     */ import java.io.File;
/*     */ import java.io.PrintWriter;
/*     */ import java.nio.file.Files;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import launcher.LSettings;
/*     */ import launcher.Launcher;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.OS;
/*     */ import snake2d.util.process.Proccesser;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Main
/*     */ {
/*     */   public static void main(String[] args) {
/*  23 */     macWarning();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  28 */       if (args != null && args.length > 0 && args[0].equalsIgnoreCase("launcher")) {
/*     */         
/*  30 */         LOG.ln("*************************************");
/*  31 */         LOG.ln("* LAUNCHER " + VERSION.VERSION_STRING);
/*  32 */         LOG.ln("*************************************");
/*     */         
/*  34 */         String[] arrayOfString = new String[0];
/*     */         
/*     */         try {
/*  37 */           File f = new File(System.getProperty("user.dir") + System.getProperty("user.dir") + "/jvmargs-launcher.txt");
/*  38 */           if (f.exists()) {
/*  39 */             List<String> jj = Files.readAllLines(f.toPath());
/*  40 */             arrayOfString = new String[jj.size()];
/*  41 */             int si = 0;
/*  42 */             for (String str : jj) {
/*  43 */               arrayOfString[si++] = str;
/*  44 */               LOG.ln("Launcher arg: " + str);
/*     */             } 
/*     */           } else {
/*  47 */             LOG.ln("could not read launcher arguments: file does not exist");
/*     */           }
/*     */         
/*  50 */         } catch (Exception e) {
/*  51 */           e.printStackTrace();
/*  52 */           LOG.ln("could not read launcher arguments");
/*     */         } 
/*     */         
/*  55 */         Process p = Proccesser.executeLwjgl(Launcher.class, new String[0], arrayOfString, new String[0]);
/*     */         
/*  57 */         if (p != null) {
/*  58 */           while (p.isAlive()) {
/*     */             try {
/*  60 */               Thread.sleep(0L);
/*  61 */             } catch (InterruptedException e1) {
/*     */               
/*  63 */               e1.printStackTrace();
/*     */             } 
/*     */           } 
/*  66 */           if (p.exitValue() != 0)
/*     */             return; 
/*     */         } 
/*     */       } 
/*  70 */       LOG.ln("*************************************");
/*  71 */       LOG.ln("* STARTING " + VERSION.VERSION_STRING);
/*  72 */       LOG.ln("*************************************");
/*     */       
/*  74 */       LSettings s = new LSettings();
/*     */       
/*  76 */       PATHS.init(s.mods.get(), null, false);
/*     */       
/*  78 */       LIST<String> jars = PATHS.SCRIPT().modClasspaths();
/*  79 */       String[] cps = new String[jars.size()];
/*     */       
/*  81 */       for (int i = 0; i < jars.size(); i++) {
/*  82 */         cps[i] = (String)jars.get(i);
/*     */       }
/*     */       
/*  85 */       String[] jvmArgs = s.jvmArguments.get();
/*     */       
/*  87 */       if (s.debug.get() == 1) {
/*  88 */         String[] aa = new String[jvmArgs.length + 3];
/*  89 */         for (int j = 0; j < jvmArgs.length; j++) {
/*  90 */           aa[3 + j] = jvmArgs[j];
/*     */         }
/*  92 */         aa[0] = "-Dorg.lwjgl.util.Debug=true";
/*  93 */         aa[1] = "-Dorg.lwjgl.util.DebugAllocator=true";
/*  94 */         aa[2] = "-Dorg.lwjgl.util.DebugStack=true";
/*  95 */         jvmArgs = aa;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 100 */       Proccesser.executeLwjgl(MainProcess.class, jvmArgs, new String[0], cps);
/*     */ 
/*     */       
/* 103 */       if (OS.get() == OS.MAC) {
/* 104 */         File f = new File(System.getProperty("user.dir") + System.getProperty("user.dir") + "/hasRunOnceOnMac.txt");
/* 105 */         if (f.exists()) {
/*     */           return;
/*     */         }
/* 108 */         f.createNewFile();
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 115 */     catch (Exception e) {
/* 116 */       e.printStackTrace();
/*     */       
/*     */       try {
/* 119 */         PrintWriter writer = new PrintWriter("SEVERE_ERROR.txt", "UTF-8");
/* 120 */         String timeStamp = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(Calendar.getInstance().getTime());
/* 121 */         writer.println(timeStamp);
/* 122 */         e.printStackTrace(writer);
/* 123 */         writer.close();
/*     */       }
/* 125 */       catch (Exception ex) {
/* 126 */         ex.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void macWarning() {
/*     */     try {
/* 136 */       if (OS.get() == OS.MAC && PATHS.isSteam())
/*     */       {
/* 138 */         File f = new File(System.getProperty("user.dir") + System.getProperty("user.dir") + "/hasRunOnceOnMac.txt");
/* 139 */         if (f.exists()) {
/*     */           return;
/*     */         }
/*     */         
/* 143 */         String message = "Dear Mac User\n\nYou are playing Songs of Syx through Mac, this is good.\nUnfortunately, the steam overlay breaks the visuals of the game.\nThe overlay can not be disabled by us developers, it has to be done manually by the user.\n\nSteam > Right click Songs of Syx > Properties > General > Uncheck 'Enable the Steam Overlay while in-game'\n\nIf having trouble: www.reddit.com/r/songsofsyx/comments/umzi1t/deactivate_steam_overlay_to_run_game_on_mac\n\nPlease also report this as a bug so that steam will fix this issue.\nhttps://help.steampowered.com/en/\n\nThe game also works fine to run like a normal app from the installation directory, being completely DRM free.\n\nApologies for the inconvenience, the alternative is to delist the game for mac, which would be a travesty.\n\nCLOSE THIS MESSAGE TO CONTINUE TO THE GAME";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 155 */         String escapedMessage = message.replace("\"", "\\\"");
/*     */ 
/*     */ 
/*     */         
/* 159 */         String script = String.format(
/* 160 */             "tell application \"System Events\" to display dialog \"%s\" with title \"Steam Overlay Warning\" buttons {\"OK\"} default button \"OK\"", new Object[] {
/* 161 */               escapedMessage
/*     */             });
/* 163 */         ProcessBuilder pb = new ProcessBuilder(new String[] { "osascript", "-e", script });
/* 164 */         Process process = pb.start();
/* 165 */         process.waitFor();
/*     */       }
/*     */     
/*     */     }
/* 169 */     catch (Exception e) {
/* 170 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\Main.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */