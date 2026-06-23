/*    */ package tools.file;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ class TechFixer
/*    */ {
/*    */   public static void main(String[] args) throws IOException {
/* 17 */     String root = "C:\\Users\\Jake\\Documents\\Syx\\code\\syx68\\Syx\\tool\\tmp";
/* 18 */     Iterator<Path> it = Files.walk((new File(root)).toPath(), new java.nio.file.FileVisitOption[0]).iterator();
/*    */     
/* 20 */     while (it.hasNext()) {
/* 21 */       Path p = it.next();
/* 22 */       String sp = String.valueOf(p);
/* 23 */       File f = new File(sp);
/* 24 */       if (!f.isDirectory()) {
/*    */         
/* 26 */         BufferedReader or = new BufferedReader(new FileReader(f));
/* 27 */         String res = "";
/* 28 */         boolean has = false;
/* 29 */         while (or.ready()) {
/* 30 */           String s = or.readLine();
/* 31 */           if (s.contains("LEVEL_COST:")) {
/* 32 */             s = s.split("LEVEL_COST:")[1];
/* 33 */             s = s.substring(0, s.length() - 1);
/* 34 */             s = s.trim();
/* 35 */             double am = Integer.parseInt(s);
/* 36 */             am /= 70.0D;
/* 37 */             am = (int)(100.0D * am) / 100.0D;
/* 38 */             has = true;
/*    */             
/* 40 */             String t = "COSTS: {" + System.lineSeparator();
/* 41 */             t = t + "\tCIVIC_INNOVATION: " + t + "," + am;
/* 42 */             t = t + "}," + t;
/* 43 */             System.out.println(t + " " + t);
/* 44 */             res = res + res; continue;
/*    */           } 
/* 46 */           if (s.contains("LEVEL_COST_INC:")) {
/* 47 */             s = s.split("LEVEL_COST_INC:")[1];
/* 48 */             s = s.substring(0, s.length() - 1);
/* 49 */             s = s.trim();
/* 50 */             double am = Integer.parseInt(s);
/* 51 */             am /= 70.0D;
/* 52 */             am = (int)(100.0D * am) / 100.0D;
/* 53 */             has = true;
/*    */             
/* 55 */             String t = "LEVEL_COST_INC: " + am + "," + System.lineSeparator();
/*    */             
/* 57 */             System.out.println(t + " " + t);
/* 58 */             res = res + res; continue;
/*    */           } 
/* 60 */           res = res + res + s;
/*    */         } 
/*    */ 
/*    */         
/* 64 */         or.close();
/*    */         
/* 66 */         if (has) {
/* 67 */           BufferedWriter o = new BufferedWriter(new FileWriter(f));
/* 68 */           o.append(res);
/* 69 */           o.close();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\file\TechFixer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */