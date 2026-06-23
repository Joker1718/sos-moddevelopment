/*    */ package game.audio;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SoundStream;
/*    */ import snake2d.util.sets.LinkedList;
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
/*    */   extends AudioFactory<SoundStream>
/*    */ {
/*    */   null(String $anonymous0, PATH $anonymous1, SoundStream $anonymous2) {
/* 34 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected SoundStream create(LinkedList<SoundStream> all, Path p, String key) {
/* 39 */     return CORE.getSoundCore().getStream(p, false);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\Ambiances$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */