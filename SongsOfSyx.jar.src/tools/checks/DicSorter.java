/*     */ package tools.checks;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.stream.Collectors;
/*     */ 
/*     */ class DicSorter
/*     */ {
/*  18 */   private static String srcPathString = "C:\\Users\\jakob\\Desktop\\jakob\\syx\\code\\syx71";
/*     */ 
/*     */   
/*  21 */   private static final Pattern DEF_PATTERN = Pattern.compile("(public|private|protected|)\\s*static\\s+CharSequence\\s+(¤¤\\w+)");
/*     */ 
/*     */   
/*  24 */   private static final Pattern REF_PATTERN = Pattern.compile("(?:(\\w+)\\.)?(¤¤\\w+)");
/*     */   
/*     */   private static class TranslationKey {
/*     */     String fullKey;
/*     */     String shortKey;
/*     */     Path definedInFile;
/*  30 */     int usageCount = 0;
/*     */     
/*     */     TranslationKey(String shortKey, String className, Path file) {
/*  33 */       this.shortKey = shortKey;
/*  34 */       this.fullKey = className + "." + className;
/*  35 */       this.definedInFile = file;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*  43 */     Path srcDir = Paths.get(srcPathString, new String[0]);
/*     */     
/*  45 */     if (!Files.exists(srcDir, new java.nio.file.LinkOption[0])) {
/*  46 */       System.err.println("Source directory not found: " + String.valueOf(srcDir.toAbsolutePath()));
/*     */       
/*     */       return;
/*     */     } 
/*  50 */     System.out.println("Running robust, token-isolated codebase translation audit...");
/*     */ 
/*     */     
/*     */     try {
/*  54 */       List<Path> javaFiles = (List<Path>)Files.walk(srcDir, new java.nio.file.FileVisitOption[0])
/*  55 */         .filter( arg0 -> Files.isRegularFile( arg0, new java.nio.file.LinkOption[0]))
/*  56 */         .filter(p -> p.toString().endsWith(".java"))
/*  57 */         .collect(Collectors.toList());
/*     */       
/*  59 */       Map<String, TranslationKey> keysToAudit = new HashMap<>();
/*  60 */       Map<String, Integer> shortKeyGlobalCounts = new HashMap<>();
/*  61 */       int linesTot = 0;
/*     */ 
/*     */ 
/*     */       
/*  65 */       for (Path file : javaFiles) {
/*  66 */         String className = file.getFileName().toString().replace(".java", "");
/*  67 */         List<String> lines = Files.readAllLines(file);
/*  68 */         linesTot += lines.size();
/*  69 */         for (String line : lines) {
/*  70 */           Matcher m = DEF_PATTERN.matcher(line);
/*  71 */           while (m.find()) {
/*  72 */             String modifier = m.group(1);
/*  73 */             String shortKey = m.group(2);
/*     */ 
/*     */             
/*  76 */             if ("private".equals(modifier)) {
/*     */               continue;
/*     */             }
/*     */             
/*  80 */             TranslationKey tk = new TranslationKey(shortKey, className, file);
/*  81 */             keysToAudit.put(tk.fullKey, tk);
/*     */             
/*  83 */             shortKeyGlobalCounts.put(shortKey, Integer.valueOf(((Integer)shortKeyGlobalCounts.getOrDefault(shortKey, Integer.valueOf(0))).intValue() + 1));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  88 */       System.out.println("Found " + keysToAudit.size() + " non-private keys globally.");
/*  89 */       System.out.println("lines Tot:" + linesTot);
/*     */ 
/*     */ 
/*     */       
/*  93 */       for (Path file : javaFiles) {
/*  94 */         String currentClassName = file.getFileName().toString().replace(".java", "");
/*  95 */         List<String> lines = Files.readAllLines(file);
/*     */         
/*  97 */         for (String line : lines) {
/*     */           
/*  99 */           if ((line.contains("static") && line.contains("CharSequence") && line.contains("¤¤")) || 
/* 100 */             line.contains("import static"))
/*     */             continue; 
/* 102 */           Matcher matcher = REF_PATTERN.matcher(line);
/*     */           
/* 104 */           while (matcher.find()) {
/* 105 */             String classPrefix = matcher.group(1);
/* 106 */             String foundShortKey = matcher.group(2);
/*     */             
/* 108 */             String reconstructedFullKey = (classPrefix != null) ? (
/* 109 */               classPrefix + "." + classPrefix) : (
/* 110 */               currentClassName + "." + currentClassName);
/*     */ 
/*     */             
/* 113 */             if (keysToAudit.containsKey(reconstructedFullKey)) {
/* 114 */               ((TranslationKey)keysToAudit.get(reconstructedFullKey)).usageCount++;
/*     */               continue;
/*     */             } 
/* 117 */             if (classPrefix == null) {
/* 118 */               for (TranslationKey tk : keysToAudit.values()) {
/* 119 */                 if (tk.shortKey.equals(foundShortKey)) {
/* 120 */                   boolean isGloballyUniqueName = (((Integer)shortKeyGlobalCounts.get(tk.shortKey)).intValue() == 1);
/* 121 */                   boolean isLocalFile = file.equals(tk.definedInFile);
/*     */ 
/*     */ 
/*     */                   
/* 125 */                   if (isGloballyUniqueName || isLocalFile) {
/* 126 */                     tk.usageCount++;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       System.out.println("\n--- GLOBAL UNUSED TRANSLATION STRINGS ---");
/* 139 */       int totalUnusedCount = 0;
/* 140 */       List<TranslationKey> sortedKeys = new ArrayList<>(keysToAudit.values());
/* 141 */       sortedKeys.sort(Comparator.comparing(k -> k.fullKey));
/*     */       
/* 143 */       for (TranslationKey tk : sortedKeys) {
/* 144 */         if (tk.usageCount == 0) {
/* 145 */           System.out.println("❌ Unused: " + tk.fullKey + " (in " + String.valueOf(tk.definedInFile.getFileName()) + ")");
/* 146 */           totalUnusedCount++;
/*     */         } 
/*     */       } 
/* 149 */       System.out.println("Global audit complete. Total completely dead strings: " + totalUnusedCount + " / " + keysToAudit.size());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       System.out.println("\n--- DIC FILE SPECIFIC SINGLE-REFERENCE DIAGNOSTIC ---");
/* 155 */       System.out.println("Filtering for keys in util.text.Dic with an active reference count of EXACTLY 1...");
/*     */       
/* 157 */       int dicSingleRefCount = 0;
/* 158 */       int totalDicKeys = 0;
/*     */       
/* 160 */       for (TranslationKey tk : sortedKeys) {
/*     */         
/* 162 */         String standardizedPath = tk.definedInFile.toString().replace("\\", "/");
/*     */         
/* 164 */         if (standardizedPath.endsWith("util/text/Dic.java")) {
/* 165 */           totalDicKeys++;
/* 166 */           if (tk.usageCount == 1) {
/* 167 */             System.out.printf("⚠️ Single Reference Found: %-35s (Invoked exactly 1 time in code)\n", new Object[] { tk.fullKey });
/* 168 */             dicSingleRefCount++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 173 */       System.out.println("\nDic analysis complete. Single-use keys detected: " + dicSingleRefCount + " / " + totalDicKeys + " total Dic keys.");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 178 */       System.out.println("\n--- CLASH ASSURANCE: DUPLICATE SHORT-KEY TRACKING ---");
/* 179 */       shortKeyGlobalCounts.forEach((key, count) -> {
/*     */             
/*     */             if (count.intValue() > 1) {
/*     */               System.out.println("⚠️ Attention: The key name \"" + key + "\" is shared by " + String.valueOf(count) + " different classes.");
/*     */             }
/*     */           });
/* 185 */     } catch (IOException e) {
/* 186 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\checks\DicSorter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */