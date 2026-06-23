/*     */ package snake2d.util.file;
/*     */ 
/*     */ import java.awt.Desktop;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.net.URLEncoder;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.regex.Pattern;
/*     */ import snake2d.Errors;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FileManager
/*     */ {
/*     */   public static class NAME
/*     */   {
/*     */     public static final String legalChars = "aA - zZ, 0-9, -, _, 'space'";
/*     */     
/*     */     public static String timeStampString(String original) {
/*  26 */       String postfix = (new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss-SSS")).format(new Date());
/*  27 */       return String.valueOf(original) + postfix;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  32 */     private static final Pattern okChars = Pattern.compile("[-_ A-Za-z0-9]+");
/*     */     
/*     */     public static boolean okName(CharSequence filename) {
/*  35 */       return okChars.matcher(filename).matches();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class FILE
/*     */   {
/*     */     public static boolean exists(String pathname) {
/*  43 */       File f = new File(pathname);
/*  44 */       if (f.exists()) {
/*  45 */         String p2 = f.getAbsolutePath();
/*  46 */         for (int i = 0; i < p2.length(); i++) {
/*  47 */           if (p2.charAt(i) != pathname.charAt(i))
/*     */           {
/*  49 */             return false;
/*     */           }
/*     */         } 
/*  52 */         return true;
/*     */       } 
/*  54 */       return false;
/*     */     }
/*     */     
/*     */     public static String ensureExists(String pathname) {
/*  58 */       if (!exists(pathname))
/*  59 */         throw new Errors.DataError("File missing", pathname); 
/*  60 */       return pathname;
/*     */     }
/*     */     
/*     */     public static String toString(String path) {
/*     */       byte[] encoded;
/*     */       try {
/*  66 */         encoded = Files.readAllBytes(Paths.get(path, new String[0]));
/*  67 */       } catch (IOException e) {
/*  68 */         throw new RuntimeException(e);
/*     */       } 
/*  70 */       return new String(encoded, Charset.defaultCharset());
/*     */     }
/*     */     
/*     */     public static String toStringRelative(Object o, String name) {
/*     */       byte[] encoded;
/*  75 */       String path = (new File(o.getClass().getResource(name).getPath())).getAbsolutePath();
/*     */ 
/*     */       
/*     */       try {
/*  79 */         encoded = Files.readAllBytes(Paths.get(path, new String[0]));
/*  80 */       } catch (IOException e) {
/*  81 */         throw new RuntimeException(e);
/*     */       } 
/*  83 */       return new String(encoded, Charset.defaultCharset());
/*     */     }
/*     */     
/*     */     public static boolean readWriteRights() {
/*     */       try {
/*  88 */         Path p = (new File("")).toPath();
/*  89 */         return Files.isWritable(p);
/*  90 */       } catch (Exception e) {
/*  91 */         e.printStackTrace();
/*  92 */         return false;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void openDesctop(String path) {
/*  99 */     FileOpener.open(new File(path));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean sendEmail(String mail, String mess, String title) {
/*     */     try {
/* 105 */       String uri = "mailto:" + mail + "?subject=" + title + "&body=";
/* 106 */       uri = String.valueOf(uri) + URLEncoder.encode(mess, "UTF-8").replaceAll("\\+", "%20");
/*     */       
/* 108 */       Desktop.getDesktop().browse(new URI(uri));
/* 109 */     } catch (IOException|java.net.URISyntaxException e1) {
/*     */       
/* 111 */       e1.printStackTrace();
/* 112 */       return false;
/*     */     } 
/* 114 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\FileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */