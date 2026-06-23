/*    */ package game.audio;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.paths.PATHS;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.SoundEffect;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class SoundFactory
/*    */ {
/*    */   double sGain;
/* 19 */   private final KeyMap<Sound> map = new KeyMap();
/*    */   
/* 21 */   public final AudioFactory<SoundFile> factory = new Factory();
/* 22 */   public final Sound DUMMY = new Sound((LIST<SoundFile>)new ArrayList(this.factory.DUMMY()));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Sound get(String key) {
/* 29 */     if (!this.map.containsKey(key)) {
/* 30 */       GAME.Warn("no sound by the key of: " + key);
/* 31 */       return new Sound(this.factory.LDUMMY());
/*    */     } 
/* 33 */     return (Sound)this.map.get(key);
/*    */   }
/*    */   
/*    */   public Sound read(Json json) {
/* 37 */     return read("SOUND", json);
/*    */   }
/*    */   
/*    */   public Sound read(String key, Json json) {
/* 41 */     LIST<SoundFile> ss = this.factory.read(key, json);
/* 42 */     return new Sound(ss);
/*    */   }
/*    */   
/*    */   public void settGain(double gain) {
/* 46 */     this.sGain = gain;
/*    */   }
/*    */   
/*    */   static class Factory
/*    */     extends AudioFactory<SoundFile> {
/*    */     Factory() {
/* 52 */       super("SOUND", (PATHS.AUDIO()).mono, new SoundFile((LISTE<SoundFile>)new LinkedList(), (SoundEffect)new SoundEffect.Dummy(), "DUMMY"));
/*    */     }
/*    */ 
/*    */     
/*    */     protected SoundFile create(LinkedList<SoundFile> all, Path p, String key) {
/* 57 */       return new SoundFile((LISTE<SoundFile>)all, p, key);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\SoundFactory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */