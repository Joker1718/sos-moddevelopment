/*    */ package game.audio;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.SoundEffect;
/*    */ import snake2d.util.sets.LISTE;
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
/*    */ class Factory
/*    */   extends AudioFactory<SoundFile>
/*    */ {
/*    */   Factory() {
/* 52 */     super("SOUND", (PATHS.AUDIO()).mono, new SoundFile((LISTE<SoundFile>)new LinkedList(), (SoundEffect)new SoundEffect.Dummy(), "DUMMY"));
/*    */   }
/*    */ 
/*    */   
/*    */   protected SoundFile create(LinkedList<SoundFile> all, Path p, String key) {
/* 57 */     return new SoundFile((LISTE<SoundFile>)all, p, key);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\SoundFactory$Factory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */