/*    */ package cutscene;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import snake2d.CORE;
/*    */ import snake2d.CORE_STATE;
/*    */ import snake2d.util.file.Json;
/*    */ import util.spritecomposer.Initer;
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
/*    */   extends CORE.GlJob
/*    */ {
/*    */   public void doJob() {
/* 48 */     if (PATHS.CACHE_DATA().exists("cutscene"))
/* 49 */       PATHS.CACHE_DATA().delete("cutscene"); 
/* 50 */     (new Initer()
/*    */       {
/*    */         public void createAssets() throws IOException
/*    */         {
/* 54 */           CORE.getSoundCore().stopAllSounds();
/* 55 */           CORE.getSoundCore().disposeSounds();
/* 56 */           (CutScene.null.null.access$0(CutScene.null.null.this)).e = new CutScene(data, text, after);
/*    */         }
/* 58 */       }).get("cutscene", PATHS.textureSize(), 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\cutscene\CutScene$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */