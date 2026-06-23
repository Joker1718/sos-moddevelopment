/*    */ package tools.techgen;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.CopyOption;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.StandardCopyOption;
/*    */ 
/*    */ class TechTreeGen
/*    */ {
/*    */   public static void main(String[] args) throws IOException {
/* 13 */     boolean save = true;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 19 */     if (save) {
/* 20 */       byte b; int i; String[] arrayOfString; for (i = (arrayOfString = (new File((new File("")).getAbsolutePath() + "\\tool\\techTrees\\init")).list()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/* 21 */         move(f.split(".txt")[0]);
/*    */         b++; }
/*    */     
/*    */     } 
/*    */   }
/*    */   private static void move(String key) throws IOException {
/* 27 */     Path sinit = (new File((new File("")).getAbsolutePath() + "\\tool\\techTrees\\init\\" + (new File("")).getAbsolutePath() + ".txt")).toPath();
/* 28 */     Path dinit = (new File((new File("")).getAbsolutePath() + "\\zipdata\\data\\assets\\init\\tech\\" + (new File("")).getAbsolutePath() + ".txt")).toPath();
/* 29 */     Path stext = (new File((new File("")).getAbsolutePath() + "\\tool\\techTrees\\text\\" + (new File("")).getAbsolutePath() + ".txt")).toPath();
/* 30 */     Path dtext = (new File((new File("")).getAbsolutePath() + "\\zipdata\\data\\assets\\text\\tech\\" + (new File("")).getAbsolutePath() + ".txt")).toPath();
/*    */     
/* 32 */     Files.copy(sinit, dinit, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/* 33 */     Files.copy(stext, dtext, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\techgen\TechTreeGen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */