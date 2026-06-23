package snake2d;

abstract class AbsBuffer {
  abstract void reclaimSource(SoundCore.Source paramSource);
  
  abstract boolean refillBuffers(SoundCore.Source paramSource);
  
  abstract void dis();
  
  abstract void setBuffer(SoundCore.Source paramSource);
  
  abstract SOUND_CORE.AUDIO_GAIN_TYPE type();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\AbsBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */