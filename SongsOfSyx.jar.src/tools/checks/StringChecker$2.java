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
/*    */ class null
/*    */   implements Consumer<Path>
/*    */ {
/*    */   public void accept(Path t) {
/* 39 */     String e = String.valueOf(t.getFileName());
/* 40 */     if (e.endsWith(".java"))
/*    */       try {
/* 42 */         StringChecker.add(t, map);
/* 43 */       } catch (IOException e1) {
/*    */         
/* 45 */         e1.printStackTrace();
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\checks\StringChecker$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */