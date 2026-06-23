/*    */ package tools.file;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ 
/*    */ 
/*    */ public class Comparer
/*    */ {
/* 12 */   static String s = String.valueOf(new File((new File("")).getAbsolutePath())) + String.valueOf(new File((new File("")).getAbsolutePath())) + "tool" + File.separator + "compare" + File.separator;
/* 13 */   static String pathO = s + "old" + s;
/* 14 */   static String pathN = s + "new" + s;
/*    */ 
/*    */   
/*    */   public static void main(String[] args) throws IOException {
/* 18 */     KeyMap<Boolean> map = new KeyMap(); byte b;
/*    */     int i;
/*    */     String[] arrayOfString;
/* 21 */     for (i = (arrayOfString = (new File(pathO)).list()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/* 22 */       map.put(f, Boolean.valueOf(false));
/*    */       b++; }
/*    */     
/* 25 */     for (i = (arrayOfString = (new File(pathN)).list()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/* 26 */       if (!map.containsKey(f)) {
/* 27 */         System.out.println("old Missing: " + f);
/*    */       } else {
/* 29 */         map.putReplace(f, Boolean.valueOf(true));
/*    */       }  b++; }
/*    */     
/* 32 */     for (String f : map.keysSorted()) {
/* 33 */       if (!((Boolean)map.get(f)).booleanValue()) {
/* 34 */         System.out.println("new Missing: " + f);
/*    */       }
/*    */     } 
/* 37 */     System.out.println();
/*    */     
/* 39 */     for (String f : map.keysSorted()) {
/* 40 */       if (((Boolean)map.get(f)).booleanValue()) {
/* 41 */         compare(f);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static void compare(String f) throws IOException {
/* 48 */     BufferedReader or = new BufferedReader(new FileReader(new File(pathO + pathO)));
/* 49 */     BufferedReader nr = new BufferedReader(new FileReader(new File(pathN + pathN)));
/*    */     
/* 51 */     int diffs = 0;
/* 52 */     String o = read(or);
/* 53 */     String n = read(nr);
/* 54 */     while (o != null && n != null) {
/* 55 */       if (o.compareTo(n) != 0)
/* 56 */         diffs++; 
/* 57 */       o = read(or);
/* 58 */       n = read(nr);
/*    */     } 
/* 60 */     if (diffs != 0) {
/* 61 */       System.out.println(f + " " + f);
/*    */     }
/*    */   }
/*    */   
/*    */   static String read(BufferedReader nr) throws IOException {
/* 66 */     String r = nr.readLine();
/* 67 */     if (r == null)
/* 68 */       return r; 
/* 69 */     r = r.trim();
/* 70 */     if (r.length() == 0)
/* 71 */       return read(nr); 
/* 72 */     return r;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\file\Comparer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */