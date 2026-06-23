/*     */ package tools.checks;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.List;
/*     */ import java.util.function.Consumer;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ class StringChecker
/*     */ {
/*     */   public static void main(String[] args) throws IOException {
/*  16 */     final KeyMap<Word> map = new KeyMap();
/*  17 */     Files.walk((new File("")).toPath(), new java.nio.file.FileVisitOption[0]).forEach(new Consumer<Path>()
/*     */         {
/*     */           public void accept(Path t)
/*     */           {
/*  21 */             String e = String.valueOf(t.getFileName());
/*  22 */             if (e.endsWith(".java")) {
/*     */               try {
/*  24 */                 StringChecker.add(t, map);
/*  25 */               } catch (IOException e1) {
/*     */                 
/*  27 */                 e1.printStackTrace();
/*     */               } 
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  35 */     Files.walk((new File("")).toPath(), new java.nio.file.FileVisitOption[0]).forEach(new Consumer<Path>()
/*     */         {
/*     */           public void accept(Path t)
/*     */           {
/*  39 */             String e = String.valueOf(t.getFileName());
/*  40 */             if (e.endsWith(".java")) {
/*     */               try {
/*  42 */                 StringChecker.add(t, map);
/*  43 */               } catch (IOException e1) {
/*     */                 
/*  45 */                 e1.printStackTrace();
/*     */               } 
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     Files.walk((new File("")).toPath(), new java.nio.file.FileVisitOption[0]).forEach(new Consumer<Path>()
/*     */         {
/*     */           public void accept(Path t)
/*     */           {
/*  59 */             String e = String.valueOf(t.getFileName());
/*  60 */             if (e.endsWith(".java")) {
/*     */               try {
/*  62 */                 StringChecker.check(t, map);
/*  63 */               } catch (IOException e1) {
/*     */                 
/*  65 */                 e1.printStackTrace();
/*     */               } 
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  73 */     for (Word s : map.allSorted()) {
/*  74 */       if (!s.used) {
/*  75 */         System.out.println(s.name);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void add(Path file, KeyMap<Word> map) throws IOException {
/*  81 */     if (String.valueOf(file.toAbsolutePath()).contains("StringChecker")) {
/*     */       return;
/*     */     }
/*  84 */     List<String> lines = Files.readAllLines(file);
/*     */     
/*  86 */     for (String line : lines) {
/*     */       
/*  88 */       if (line.indexOf("public static CharSequence ¤¤") >= 0) {
/*  89 */         line = line.split("¤¤")[1];
/*  90 */         line = line.split(" ")[0];
/*  91 */         line = "¤¤" + line;
/*  92 */         String pa = String.valueOf(file.toAbsolutePath());
/*  93 */         pa = pa.split(".java")[0];
/*  94 */         pa = pa.substring(pa.lastIndexOf('\\') + 1);
/*     */         
/*  96 */         String key = pa + "." + pa;
/*     */         
/*  98 */         map.putReplace(key, new Word(key, String.valueOf(file.toAbsolutePath())));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void check(Path file, KeyMap<Word> map) throws IOException {
/* 110 */     if (String.valueOf(file.toAbsolutePath()).contains("StringChecker")) {
/*     */       return;
/*     */     }
/* 113 */     List<String> lines = Files.readAllLines(file);
/*     */     
/* 115 */     for (String line : lines) {
/* 116 */       while (line.indexOf(".¤¤") >= 0) {
/* 117 */         int end = line.indexOf(".¤¤");
/* 118 */         int start = end;
/* 119 */         if (start >= 0) {
/* 120 */           start--;
/* 121 */           while (start > 0 && (Character.isLetter(line.charAt(start)) || line.charAt(start) == '_')) {
/* 122 */             start--;
/*     */           }
/* 124 */           start++;
/* 125 */           end += 3;
/* 126 */           while (end < line.length() && (Character.isLetter(line.charAt(end)) || line.charAt(end) == '_')) {
/* 127 */             end++;
/*     */           }
/* 129 */           String f = line.substring(start, end);
/*     */           
/* 131 */           if (map.containsKey(f)) {
/* 132 */             ((Word)map.get(f)).used = true;
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 138 */         line = line.substring(line.indexOf(".¤¤") + 3);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Word
/*     */   {
/*     */     public final String name;
/*     */ 
/*     */     
/*     */     public boolean used = false;
/*     */ 
/*     */     
/*     */     Word(String name, String location) {
/* 154 */       this.name = name;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\checks\StringChecker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */