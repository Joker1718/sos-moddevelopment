/*    */ package snake2d;
/*    */ 
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
/*    */ final class SoundCoreDummy
/*    */   extends SOUND_CORE
/*    */ {
/*    */   public void set(int cX, int cY) {}
/*    */   
/*    */   public void stopAllSounds() {}
/*    */   
/*    */   void dis() {}
/*    */   
/*    */   boolean requestMono(AbsBuffer buff, int x, int y, boolean prio, float gain, float pitch) {
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   boolean requestMono(AbsBuffer buff, boolean prio, float gain, float pitch) {
/* 31 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   boolean requestStereo(AbsBuffer buff) {
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundEffect getEffect(Path path) {
/* 41 */     return new SoundEffect.Dummy();
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundStream getStream(Path path, boolean music) {
/* 46 */     return new SoundStream.Dummy();
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundEffectStream getStreamMono(Path path) {
/* 51 */     return new SoundEffectStream.Dummy();
/*    */   }
/*    */   
/*    */   public void disposeSounds() {}
/*    */   
/*    */   public void setGain(double gain, SOUND_CORE.AUDIO_GAIN_TYPE type) {}
/*    */   
/*    */   public void setMuteOnFocus(boolean muteOnFocus) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SoundCoreDummy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */