/*     */ package init.paths;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.attribute.FileAttribute;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Util
/*     */ {
/*     */   static String getLocal() {
/*  20 */     String OS = System.getProperty("os.name").toUpperCase(Locale.ROOT);
/*     */     
/*  22 */     if (OS.contains("MAC") || OS.contains("DARWIN")) {
/*  23 */       String s = System.getProperty("user.home");
/*  24 */       s = s + s + "Library" + File.separator + "Application Support" + File.separator + "songsofsyx";
/*  25 */       return s;
/*  26 */     }  if (OS.contains("WIN"))
/*  27 */       return System.getenv("AppData") + System.getenv("AppData") + "songsofsyx"; 
/*  28 */     if (OS.contains("NUX")) {
/*  29 */       String s = System.getProperty("user.home");
/*  30 */       s = s + s + ".local" + File.separator + "share" + File.separator + "songsofsyx";
/*  31 */       return s;
/*     */     } 
/*  33 */     throw new RuntimeException("could not figure out OS " + System.getProperty("os.name").toUpperCase(Locale.ROOT));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void makeDirs(Path dir) {
/*  41 */     if (!Files.exists(dir, new java.nio.file.LinkOption[0])) {
/*     */       
/*     */       try {
/*  44 */         Files.createDirectories(dir, (FileAttribute<?>[])new FileAttribute[0]);
/*  45 */       } catch (Exception e) {
/*  46 */         e.printStackTrace();
/*     */       } 
/*     */       
/*  49 */       if (!Files.exists(dir, new java.nio.file.LinkOption[0])) {
/*  50 */         throw new Errors.DataError("The game could not create a directory for game files. Please check permissions", 
/*  51 */             dir);
/*     */       }
/*     */     } 
/*  54 */     if (!Files.isReadable(dir)) {
/*  55 */       throw new Errors.DataError("The game could not read from its file directory. Please check permissions", 
/*  56 */           dir);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String abort(String missingfile) throws Errors.DataError {
/*  64 */     String ending = "";
/*     */     
/*  66 */     String root = missingfile;
/*     */ 
/*     */     
/*  69 */     throw new Errors.DataError("The file or directory does not exist. Try to reinstall the game.", root + root);
/*     */   }
/*     */   
/*     */   static boolean check(Path path) {
/*  73 */     if (path == null)
/*  74 */       return false; 
/*  75 */     if (!Files.exists(path, new java.nio.file.LinkOption[0])) {
/*  76 */       return false;
/*     */     }
/*  78 */     Path pa = path.getParent();
/*     */     
/*  80 */     String cmp = String.valueOf(path.getFileName());
/*  81 */     if (cmp.endsWith(File.pathSeparator))
/*  82 */       cmp = cmp.substring(0, cmp.length() - File.pathSeparator.length()); 
/*  83 */     for (Path p : listFiles(pa)) {
/*     */       
/*  85 */       if (String.valueOf(p.getFileName()).startsWith(cmp)) {
/*  86 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Path checkHard(Path path, String file) {
/* 102 */     path = path.resolve(file);
/* 103 */     if (!Files.exists(path, new java.nio.file.LinkOption[0])) {
/* 104 */       throw new Errors.DataError("The file or directory does not exist. Try to reinstall the game.", path);
/*     */     }
/* 106 */     return path;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static LinkedList<Path> listFiles(Path path) {
/* 112 */     LinkedList<Path> res = new LinkedList();
/*     */     
/* 114 */     if (path == null || !Files.exists(path, new java.nio.file.LinkOption[0])) {
/* 115 */       return res;
/*     */     }
/*     */     try {
/* 118 */       Iterator<Path> it = Files.list(path).iterator();
/* 119 */       while (it.hasNext())
/*     */       {
/* 121 */         Path p = it.next();
/* 122 */         res.add(p);
/*     */       }
/*     */     
/* 125 */     } catch (IOException e) {
/* 126 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 129 */     return res;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\Util.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */