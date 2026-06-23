/*     */ package init.paths;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PathParser
/*     */ {
/*     */   public static final String split = "->";
/*     */   
/*     */   public static Path get(PATH base, String relPath, Json json, String jsonKey, int off) {
/*  17 */     String[] ss = relPath.split("->");
/*  18 */     if (ss.length < 1 - off || ss.length - 1 - off < 0) {
/*  19 */       String e = relPath + " does not specify a path with the root of: " + relPath + " paths are specifided by folder->folder->file, where the folder part is optional. Both the folders and the file must exist.";
/*  20 */       error(e, json, jsonKey);
/*  21 */       return null;
/*     */     } 
/*     */     
/*  24 */     PATH p = base;
/*  25 */     for (int i = 0; i < ss.length - 1 - off; i++) {
/*  26 */       if (!p.existsFolder(ss[i])) {
/*  27 */         String e = "The folder specified: " + ss[i] + ", does not exist in: " + String.valueOf(p.get().toAbsolutePath());
/*  28 */         error(e, json, jsonKey);
/*  29 */         return null;
/*     */       } 
/*  31 */       p = p.getFolder(ss[i]);
/*     */     } 
/*  33 */     String file = ss[ss.length - 1 - off];
/*     */     
/*  35 */     if (!p.exists(file)) {
/*     */       
/*  37 */       String e = "The file: " + file + p.fileEnding() + ", does not exist in: " + String.valueOf(p.get().toAbsolutePath());
/*  38 */       error(e, json, jsonKey);
/*  39 */       return null;
/*     */     } 
/*     */     
/*  42 */     return p.get(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<Path> getMany(PATH base, String relPath, Json json, String jsonKey) {
/*  48 */     LinkedList<Path> res = new LinkedList();
/*     */     
/*  50 */     String[] ss = relPath.split("->");
/*  51 */     if (ss.length < 1) {
/*  52 */       String e = relPath + " does not specify a path with the root of: " + relPath + " paths are specifided by folder->folder->file, where the folder part is optional. Both the folders and the file must exist.";
/*  53 */       error(e, json, jsonKey);
/*  54 */       return null;
/*     */     } 
/*     */     
/*  57 */     PATH p = base;
/*  58 */     for (int i = 0; i < ss.length - 1; i++) {
/*  59 */       if (!p.existsFolder(ss[i])) {
/*  60 */         String e = "The folder specified: " + ss[i] + ", does not exist in: " + String.valueOf(p.get().toAbsolutePath());
/*  61 */         error(e, json, jsonKey);
/*  62 */         return null;
/*     */       } 
/*  64 */       p = p.getFolder(ss[i]);
/*     */     } 
/*  66 */     String file = ss[ss.length - 1];
/*     */     
/*  68 */     if (file.charAt(file.length() - 1) == '*') {
/*  69 */       String begin = file.substring(0, file.length() - 1); byte b; int j; String[] arrayOfString;
/*  70 */       for (j = (arrayOfString = p.getFiles()).length, b = 0; b < j; ) { String f = arrayOfString[b];
/*  71 */         if (f.startsWith(begin))
/*  72 */           res.add(p.get(f)); 
/*     */         b++; }
/*     */       
/*  75 */       if (res.size() == 0) {
/*  76 */         String e = "There are no files: " + relPath + ", that match this pattern: " + String.valueOf(p.get().toAbsolutePath());
/*  77 */         error(e, json, jsonKey);
/*     */       } 
/*     */       
/*  80 */       return (LIST<Path>)res;
/*     */     } 
/*     */     
/*  83 */     if (!p.exists(file)) {
/*  84 */       String e = "The file: " + file + p.fileEnding() + ", does not exist in: " + String.valueOf(p.get().toAbsolutePath());
/*  85 */       error(e, json, jsonKey);
/*  86 */       return null;
/*     */     } 
/*     */     
/*  89 */     res.add(p.get(file));
/*     */     
/*  91 */     return (LIST<Path>)res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void error(String error, Json json, String jsonKey) {
/*  97 */     if (json != null) {
/*  98 */       GAME.Warn(json.errorGet(error, jsonKey));
/*     */     } else {
/* 100 */       throw new Errors.DataError(error);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\PathParser.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */