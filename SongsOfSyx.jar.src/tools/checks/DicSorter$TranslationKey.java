/*    */ package tools.checks;
/*    */ 
/*    */ import java.nio.file.Path;
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
/*    */ class TranslationKey
/*    */ {
/*    */   String fullKey;
/*    */   String shortKey;
/*    */   Path definedInFile;
/* 30 */   int usageCount = 0;
/*    */   
/*    */   TranslationKey(String shortKey, String className, Path file) {
/* 33 */     this.shortKey = shortKey;
/* 34 */     this.fullKey = className + "." + className;
/* 35 */     this.definedInFile = file;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\checks\DicSorter$TranslationKey.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */