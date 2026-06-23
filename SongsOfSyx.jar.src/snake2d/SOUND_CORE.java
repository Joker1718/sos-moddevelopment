/*    */ package snake2d;public abstract class SOUND_CORE { public abstract void set(int paramInt1, int paramInt2); public abstract void stopAllSounds(); abstract void dis(); abstract boolean requestMono(AbsBuffer paramAbsBuffer, int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat1, float paramFloat2);
/*    */   abstract boolean requestMono(AbsBuffer paramAbsBuffer, boolean paramBoolean, float paramFloat1, float paramFloat2);
/*    */   abstract boolean requestStereo(AbsBuffer paramAbsBuffer);
/*    */   public abstract void setGain(double paramDouble, AUDIO_GAIN_TYPE paramAUDIO_GAIN_TYPE);
/*    */   public abstract void setMuteOnFocus(boolean paramBoolean);
/*  6 */   public enum AUDIO_GAIN_TYPE { MASTER,
/*  7 */     MUSIC,
/*  8 */     AMBIENCE,
/*  9 */     EFFECT; }
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
/*    */   static SOUND_CORE create(SETTINGS s) {
/* 31 */     if (s.openALDevice() != null) {
/* 32 */       SoundDevices.refresh();
/* 33 */       for (String ss : SoundDevices.get()) {
/* 34 */         if (ss.equalsIgnoreCase(s.openALDevice()))
/* 35 */           return new SoundCore(ss, s); 
/* 36 */       }  if (SoundDevices.get().size() > 0)
/* 37 */         return new SoundCore((String)SoundDevices.get().get(0), s); 
/*    */     } 
/* 39 */     return new SoundCoreDummy();
/*    */   }
/*    */   
/*    */   public abstract SoundEffect getEffect(Path paramPath);
/*    */   
/*    */   public abstract SoundStream getStream(Path paramPath, boolean paramBoolean);
/*    */   
/*    */   public abstract SoundEffectStream getStreamMono(Path paramPath);
/*    */   
/*    */   public abstract void disposeSounds(); }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SOUND_CORE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */