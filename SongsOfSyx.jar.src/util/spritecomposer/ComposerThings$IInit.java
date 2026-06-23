/*    */ package util.spritecomposer;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IInit
/*    */ {
/*    */   public IInit(Path path, int width, int height) throws IOException {
/* 38 */     Resources.c.setSource(path, width, height);
/* 39 */     if (Resources.g == null)
/* 40 */       init(Resources.c, Resources.sources, Resources.dests); 
/*    */   }
/*    */   
/*    */   public IInit() throws IOException {
/* 44 */     if (Resources.g == null)
/* 45 */       init(Resources.c, Resources.sources, Resources.dests); 
/*    */   }
/*    */   
/*    */   protected void init(ComposerUtil c, ComposerSources s, ComposerDests d) throws IOException {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerThings$IInit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */