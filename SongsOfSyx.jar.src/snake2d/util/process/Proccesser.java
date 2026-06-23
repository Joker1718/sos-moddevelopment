/*    */ package snake2d.util.process;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.misc.OS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Proccesser
/*    */ {
/*    */   public static Process executeLwjgl(Class<?> clazz, String[] jvmArgs, String[] args, String[] classPaths) {
/* 17 */     if (OS.get() == OS.MAC) {
/* 18 */       String[] ja = new String[jvmArgs.length + 1];
/* 19 */       for (int i = 0; i < jvmArgs.length; i++)
/* 20 */         ja[i] = jvmArgs[i]; 
/* 21 */       ja[ja.length - 1] = "-XstartOnFirstThread";
/* 22 */       jvmArgs = ja;
/*    */     } 
/* 24 */     return exec(clazz, jvmArgs, args, classPaths, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Process exec(Class<?> clazz, String[] jvmArgs, String[] args, String[] classPaths) {
/* 29 */     return exec(clazz, jvmArgs, args, classPaths, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Process exec(Class<?> clazz, String[] jvmArgs, String[] args, String[] classPaths, boolean addGameTweaks) {
/* 34 */     String javaHome = System.getProperty("java.home");
/* 35 */     String javaBin = String.valueOf(javaHome) + File.separator + "bin" + File.separator + "java";
/* 36 */     String classpath = System.getProperty("java.class.path");
/*    */     
/* 38 */     LOG.ln("java exe is: " + javaBin);
/*    */     
/* 40 */     if (classpath == null || classpath.length() == 0) {
/* 41 */       LOG.ln("java.class.path is: '" + classpath + "'" + " bin");
/* 42 */       classpath = "SongsOfSyx.jar";
/*    */     } 
/* 44 */     String className = clazz.getName();
/*    */     
/* 46 */     ArrayList<String> command = new ArrayList<>();
/* 47 */     command.add(javaBin); byte b1; int i; String[] arrayOfString1;
/* 48 */     for (i = (arrayOfString1 = jvmArgs).length, b1 = 0; b1 < i; ) { String a = arrayOfString1[b1];
/* 49 */       command.add(a); b1++; }
/* 50 */      command.add("-cp");
/* 51 */     String cp = "";
/*    */     
/* 53 */     String sep = System.getProperty("path.separator"); byte b2; int j;
/*    */     String[] arrayOfString2;
/* 55 */     for (j = (arrayOfString2 = classPaths).length, b2 = 0; b2 < j; ) { String c = arrayOfString2[b2];
/* 56 */       cp = String.valueOf(cp) + c + sep;
/*    */       b2++; }
/*    */     
/* 59 */     cp = String.valueOf(cp) + classpath;
/* 60 */     command.add(cp);
/* 61 */     command.add(className);
/* 62 */     for (j = (arrayOfString2 = args).length, b2 = 0; b2 < j; ) { String a = arrayOfString2[b2];
/* 63 */       command.add(a); b2++; }
/*    */     
/* 65 */     ProcessBuilder builder = new ProcessBuilder(command);
/*    */     
/* 67 */     if (addGameTweaks) {
/* 68 */       builder.environment().put("PULSE_PROP_application.media_role", "Game");
/* 69 */       builder.environment().put("DRI_PRIME", "1");
/* 70 */       builder.environment().put("__NV_PRIME_RENDER_OFFLOAD", "1");
/* 71 */       builder.environment().put("__GLX_VENDOR_LIBRARY_NAME", "nvidia");
/* 72 */       builder.environment().put("__VK_LAYER_NV_optimus", "NVIDIA_only");
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 80 */       Process process = builder.redirectOutput(ProcessBuilder.Redirect.INHERIT).redirectErrorStream(true).start();
/* 81 */       return process;
/* 82 */     } catch (IOException e) {
/* 83 */       e.printStackTrace();
/* 84 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\process\Proccesser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */