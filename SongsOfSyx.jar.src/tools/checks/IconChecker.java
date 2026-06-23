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
/*     */ class IconChecker
/*     */ {
/*     */   public static void main(String[] args) throws IOException {
/*  16 */     String root = (new File("")).getAbsolutePath();
/*  17 */     System.out.println(root);
/*     */     
/*  19 */     String pin = root + "\\game\\init\\sprite\\UI\\Icons.java";
/*  20 */     if (!(new File(pin)).exists()) {
/*  21 */       System.out.println("fix file!");
/*     */       
/*     */       return;
/*     */     } 
/*  25 */     List<String> ss = Files.readAllLines((new File(pin)).toPath());
/*     */     
/*  27 */     check("\tpublic static class S extends IconMaker{", "\t}", "\t\tpublic final IconS ", ss, "s");
/*  28 */     check("\tpublic static class M extends IconMaker{", "\t}", "\t\tpublic final Icon ", ss, "m");
/*     */   }
/*     */ 
/*     */   
/*     */   private static void check(String start, String end, String match, List<String> ss, String mm) throws IOException {
/*  33 */     final KeyMap<II> keys = keys(start, end, match, ss);
/*     */     
/*  35 */     final String[] matches = {
/*  36 */         "UI.icons()." + mm + ".", "SPRITES.icons()." + 
/*  37 */         mm + "."
/*     */       };
/*     */     
/*  40 */     Files.walk((new File("")).toPath(), new java.nio.file.FileVisitOption[0]).forEach(new Consumer<Path>()
/*     */         {
/*     */           public void accept(Path t)
/*     */           {
/*  44 */             String e = String.valueOf(t.getFileName());
/*  45 */             if (e.endsWith(".java")) {
/*     */               try {
/*  47 */                 IconChecker.process(t, matches, keys);
/*  48 */               } catch (IOException e1) {
/*     */                 
/*  50 */                 e1.printStackTrace();
/*     */               } 
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  57 */     System.out.println();
/*  58 */     System.out.println("----" + mm);
/*  59 */     for (II ii : keys.all()) {
/*  60 */       if (!ii.used)
/*  61 */         System.out.println(ii.key + " " + ii.key); 
/*     */     } 
/*  63 */     System.out.println();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void process(Path file, String[] matches, KeyMap<II> keys) throws IOException {
/*  69 */     List<String> lines = Files.readAllLines(file);
/*     */     
/*  71 */     for (String line : lines) {
/*     */       byte b; int i; String[] arrayOfString;
/*  73 */       for (i = (arrayOfString = matches).length, b = 0; b < i; ) { String m = arrayOfString[b];
/*     */         
/*  75 */         int si = line.indexOf(m, 0);
/*  76 */         while (si >= 0) {
/*     */ 
/*     */ 
/*     */           
/*  80 */           String k = extract(line, si + m.length());
/*  81 */           si = line.indexOf(m, si + 1);
/*     */           
/*  83 */           if (k == null) {
/*     */             continue;
/*     */           }
/*  86 */           if (!keys.containsKey(k)) {
/*  87 */             System.err.println(k + " " + k); continue;
/*     */           } 
/*  89 */           ((II)keys.get(k)).used = true;
/*     */         } 
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String extract(String line, int start) {
/* 101 */     for (int i = start; i < line.length(); i++) {
/* 102 */       if (line.charAt(i) == '(')
/* 103 */         return null; 
/* 104 */       if (line.charAt(i) == ' ' || line.charAt(i) == ',' || line.charAt(i) == ')' || line.charAt(i) == ';' || line.charAt(i) == '.')
/*     */       {
/* 106 */         return line.substring(start, i);
/*     */       }
/*     */     } 
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static KeyMap<II> keys(String start, String end, String match, List<String> ss) {
/* 115 */     KeyMap<II> keys = new KeyMap();
/*     */ 
/*     */     
/* 118 */     for (int i = 0; i < ss.size(); i++) {
/* 119 */       String l = ss.get(i);
/* 120 */       if (l.equals(start)) {
/* 121 */         i++;
/* 122 */         for (; i < ss.size(); i++) {
/* 123 */           l = ss.get(i);
/* 124 */           if (l.equals(end)) {
/* 125 */             return keys;
/*     */           }
/* 127 */           if (l.startsWith(match)) {
/* 128 */             String k = l.substring(match.length(), l.indexOf(' ', match.length()));
/* 129 */             keys.put(k, new II(k, i));
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 134 */         throw new RuntimeException(end);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     throw new RuntimeException(start);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class II
/*     */   {
/*     */     public String key;
/*     */     
/*     */     public int line;
/*     */     
/*     */     public boolean used = false;
/*     */ 
/*     */     
/*     */     II(String key, int line) {
/* 155 */       this.key = key;
/* 156 */       this.line = line;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\checks\IconChecker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */