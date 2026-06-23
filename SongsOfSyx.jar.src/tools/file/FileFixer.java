/*    */ package tools.file;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.util.Iterator;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ class FileFixer
/*    */ {
/*    */   public static void main(String[] args) throws IOException {
/* 17 */     String root = "C:\\Users\\Jake\\Documents\\Syx\\git\\songsofsyx\\Syx\\zipdata\\data\\assets\\init\\world\\building";
/*    */     
/* 19 */     for (Path p : files(root, ".txt", true)) {
/*    */       
/* 21 */       if ((new Json(p)).has("LEVELS")) {
/* 22 */         byte b; int i; Json[] arrayOfJson; for (i = (arrayOfJson = (new Json(p)).jsons("LEVELS")).length, b = 0; b < i; ) { Json j = arrayOfJson[b];
/* 23 */           if (!j.has("CREDITS")) {
/* 24 */             System.out.println(p);
/*    */             break;
/*    */           } 
/*    */           b++; }
/*    */       
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static LIST<Path> files(String root, String type, boolean includeAll) throws IOException {
/* 62 */     Iterator<Path> it = Files.walk((new File(root)).toPath(), new java.nio.file.FileVisitOption[0]).iterator();
/* 63 */     LinkedList<Path> pps = new LinkedList();
/* 64 */     while (it.hasNext()) {
/* 65 */       Path p = it.next();
/* 66 */       String sp = String.valueOf(p);
/* 67 */       File f = new File(sp);
/* 68 */       if (f.isDirectory() || 
/* 69 */         !sp.endsWith(type) || (
/* 70 */         !includeAll && 
/* 71 */         sp.charAt(sp.lastIndexOf('\\') + 1) == '_')) {
/*    */         continue;
/*    */       }
/* 74 */       pps.add(p);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 80 */     return (LIST<Path>)pps;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\file\FileFixer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */