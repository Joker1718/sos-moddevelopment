/*    */ package game.audio;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SoundStream;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ 
/*    */ 
/*    */ public final class MusicFactory
/*    */   extends AudioFactory<SoundStream>
/*    */ {
/*    */   public MusicFactory() {
/* 14 */     super("MUSIC", (PATHS.AUDIO()).music, new SoundStream.Dummy());
/*    */   }
/*    */ 
/*    */   
/*    */   protected SoundStream create(LinkedList<SoundStream> all, Path p, String key) {
/* 19 */     return CORE.getSoundCore().getStream(p, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\MusicFactory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */