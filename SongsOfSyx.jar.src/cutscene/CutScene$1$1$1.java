/*    */ package cutscene;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Initer
/*    */ {
/*    */   public void createAssets() throws IOException {
/* 54 */     CORE.getSoundCore().stopAllSounds();
/* 55 */     CORE.getSoundCore().disposeSounds();
/* 56 */     (CutScene.null.null.access$0(CutScene.null.null.this)).e = new CutScene(data, text, after);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\cutscene\CutScene$1$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */