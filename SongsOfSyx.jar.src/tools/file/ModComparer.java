/*     */ package tools.file;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ 
/*     */ 
/*     */ public class ModComparer
/*     */ {
/*  15 */   static String root = String.valueOf(new File((new File("")).getAbsolutePath())) + String.valueOf(new File((new File("")).getAbsolutePath())) + "zipdata" + File.separator + "data" + File.separator + "assets" + File.separator;
/*  16 */   static String input = String.valueOf(new File((new File("")).getAbsolutePath())) + String.valueOf(new File((new File("")).getAbsolutePath())) + "tool" + File.separator + "modcompare" + File.separator;
/*     */   
/*  18 */   static String s = String.valueOf(new File((new File("")).getAbsolutePath())) + String.valueOf(new File((new File("")).getAbsolutePath())) + "tool" + File.separator + "compare" + File.separator;
/*  19 */   static String pathO = s + "old" + s;
/*  20 */   static String pathN = s + "new" + s;
/*     */ 
/*     */   
/*     */   public static void main(String[] args) throws IOException {
/*  24 */     KeyMap<Boolean> map = new KeyMap(); byte b;
/*     */     int i;
/*     */     String[] arrayOfString;
/*  27 */     for (i = (arrayOfString = (new File(pathO)).list()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/*  28 */       map.put(f, Boolean.valueOf(false));
/*     */       b++; }
/*     */     
/*  31 */     for (i = (arrayOfString = (new File(pathN)).list()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/*  32 */       if (!map.containsKey(f)) {
/*  33 */         System.out.println("old Missing: " + f);
/*     */       } else {
/*  35 */         map.putReplace(f, Boolean.valueOf(true));
/*     */       }  b++; }
/*     */     
/*  38 */     for (String f : map.keysSorted()) {
/*  39 */       if (!((Boolean)map.get(f)).booleanValue()) {
/*  40 */         System.out.println("new Missing: " + f);
/*     */       }
/*     */     } 
/*  43 */     System.out.println();
/*     */     
/*  45 */     Iterator<Path> s = Files.walk((new File(input)).toPath(), new java.nio.file.FileVisitOption[0]).iterator();
/*  46 */     while (s.hasNext()) {
/*  47 */       Path p = s.next();
/*  48 */       String fi = String.valueOf(p.toAbsolutePath());
/*     */       
/*  50 */       String f2 = fi.replace(input, root);
/*  51 */       if (fi.endsWith(".txt") && !(new File(f2)).exists()) {
/*  52 */         System.out.println("new File: " + fi);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     System.out.println();
/*     */     
/*  61 */     s = Files.walk((new File(input)).toPath(), new java.nio.file.FileVisitOption[0]).iterator();
/*  62 */     while (s.hasNext()) {
/*  63 */       Path p = s.next();
/*  64 */       String fi = String.valueOf(p.toAbsolutePath());
/*     */       
/*  66 */       String f2 = fi.replace(input, root);
/*     */       
/*  68 */       if (fi.endsWith(".txt") && (new File(f2)).exists()) {
/*  69 */         compare(f2, fi);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void compare(String pathOld, String pathNew) throws IOException {
/*  85 */     BufferedReader or = new BufferedReader(new FileReader(new File(pathOld)));
/*  86 */     BufferedReader nr = new BufferedReader(new FileReader(new File(pathNew)));
/*     */     
/*  88 */     int diffs = 0;
/*  89 */     String o = read(or);
/*  90 */     String n = read(nr);
/*  91 */     while (o != null && n != null) {
/*  92 */       if (o.compareTo(n) != 0)
/*  93 */         diffs++; 
/*  94 */       o = read(or);
/*  95 */       n = read(nr);
/*     */     } 
/*  97 */     if (diffs != 0) {
/*  98 */       System.out.println(pathNew + " " + pathNew);
/*     */     }
/*     */   }
/*     */   
/*     */   static String read(BufferedReader nr) throws IOException {
/* 103 */     String r = nr.readLine();
/* 104 */     if (r == null)
/* 105 */       return r; 
/* 106 */     r = r.trim();
/* 107 */     if (r.length() == 0)
/* 108 */       return read(nr); 
/* 109 */     return r;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\file\ModComparer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */