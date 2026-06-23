/*    */ package tools.checks;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.util.List;
/*    */ import java.util.function.Consumer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements Consumer<Path>
/*    */ {
/*    */   public void accept(Path t) {
/* 18 */     String e = String.valueOf(t.getFileName());
/* 19 */     if (e.endsWith(".java"))
/*    */       
/*    */       try {
/* 22 */         List<String> lines = Files.readAllLines(t);
/*    */         
/* 24 */         String ref = "";
/*    */         
/* 26 */         String pp = " = new " + e.split(".java")[0] + "(";
/*    */         
/* 28 */         for (String s : lines) {
/* 29 */           if (s.contains(pp)) {
/* 30 */             ref = s.substring(s.indexOf(pp), s.length());
/*    */ 
/*    */             
/* 33 */             ref = s.substring(0, s.indexOf(pp));
/* 34 */             if (ref.lastIndexOf(' ') >= 0)
/* 35 */               ref = ref.substring(ref.lastIndexOf(' '), ref.length()); 
/* 36 */             ref = ref.trim();
/*    */           } 
/*    */         } 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 43 */         if (ref.length() > 0)
/*    */         {
/* 45 */           boolean bobo = false;
/* 46 */           pp = "if (" + ref;
/*    */           
/* 48 */           for (String s : lines) {
/* 49 */             if (s.contains(pp)) {
/* 50 */               bobo = true;
/*    */             }
/*    */           } 
/*    */ 
/*    */           
/* 55 */           if (bobo) {
/* 56 */             System.out.println(t.toAbsolutePath());
/*    */           
/*    */           }
/*    */         }
/*    */       
/*    */       }
/* 62 */       catch (IOException e1) {
/*    */         
/* 64 */         e1.printStackTrace();
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\checks\JavaFileCheck$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */