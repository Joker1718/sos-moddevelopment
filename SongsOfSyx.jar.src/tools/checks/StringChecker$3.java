/*    */ package tools.checks;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import java.util.function.Consumer;
/*    */ import snake2d.util.sets.KeyMap;
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
/*    */ class null
/*    */   implements Consumer<Path>
/*    */ {
/*    */   public void accept(Path t) {
/* 59 */     String e = String.valueOf(t.getFileName());
/* 60 */     if (e.endsWith(".java"))
/*    */       try {
/* 62 */         StringChecker.check(t, map);
/* 63 */       } catch (IOException e1) {
/*    */         
/* 65 */         e1.printStackTrace();
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\checks\StringChecker$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */