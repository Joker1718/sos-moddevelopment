/*    */ package game.audio;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.CORE;
/*    */ 
/*    */ 
/*    */ public class AUDIO
/*    */ {
/*    */   private static AUDIO s;
/*    */   private SoundRaces races;
/*    */   private final Music music;
/*    */   private final SoundFactory mono;
/*    */   private final Ambiances ambiences;
/*    */   private final AmbianceUpdater aUpdater;
/*    */   
/*    */   public AUDIO(GAME game) {
/* 17 */     CORE.getSoundCore().disposeSounds();
/* 18 */     s = this;
/* 19 */     this.mono = new SoundFactory();
/* 20 */     this.music = new Music();
/* 21 */     this.ambiences = new Ambiances();
/* 22 */     this.aUpdater = new AmbianceUpdater(this.ambiences);
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(double ds) {
/* 27 */     this.music.update(ds);
/* 28 */     this.aUpdater.update();
/*    */   }
/*    */   
/*    */   public static void setSettGain(double gain) {
/* 32 */     s.mono.settGain(gain);
/*    */   }
/*    */   
/*    */   public static SoundRace race(String key) {
/* 36 */     return s.races.get(key);
/*    */   }
/*    */   
/*    */   static SoundFactory mono() {
/* 40 */     return s.mono;
/*    */   }
/*    */   
/*    */   public static Music music() {
/* 44 */     return s.music;
/*    */   }
/*    */   
/*    */   public static Ambiances AMBI() {
/* 48 */     return s.ambiences;
/*    */   }
/*    */   
/*    */   public static AmbianceUpdater AMBI_UP() {
/* 52 */     return s.aUpdater;
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {
/* 57 */     this.races = new SoundRaces(this.mono);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\AUDIO.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */