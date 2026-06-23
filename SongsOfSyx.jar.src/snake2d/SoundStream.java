/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.file.Path;
/*     */ import org.lwjgl.openal.AL10;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface SoundStream
/*     */ {
/*     */   boolean play();
/*     */   
/*     */   void playOnce();
/*     */   
/*     */   void setGain(double paramDouble);
/*     */   
/*     */   void stop();
/*     */   
/*     */   void resume();
/*     */   
/*     */   void setLooping(boolean paramBoolean);
/*     */   
/*     */   double getProgress();
/*     */   
/*     */   boolean isPlaying();
/*     */   
/*     */   double getLengthInSeconds();
/*     */   
/*     */   public static class Dummy
/*     */     implements SoundStream
/*     */   {
/*  33 */     long millis = 0L;
/*     */     
/*     */     private boolean looping = false;
/*     */     
/*     */     public boolean play() {
/*  38 */       this.millis = (long)(System.currentTimeMillis() + getLengthInSeconds() * 1000.0D);
/*  39 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setGain(double gain) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void stop() {
/*  50 */       this.millis = 0L;
/*     */     }
/*     */ 
/*     */     
/*     */     public void resume() {
/*  55 */       play();
/*     */     }
/*     */ 
/*     */     
/*     */     public void setLooping(boolean yes) {
/*  60 */       this.looping = yes;
/*     */     }
/*     */ 
/*     */     
/*     */     public double getProgress() {
/*  65 */       double p = 1.0D - (this.millis - System.currentTimeMillis()) / (1000.0D + getLengthInSeconds());
/*  66 */       if (this.looping && this.millis != 0L)
/*  67 */         p %= 1.0D; 
/*  68 */       return CLAMP.d(p, 0.0D, 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isPlaying() {
/*  73 */       if (this.looping && this.millis != 0L)
/*  74 */         return true; 
/*  75 */       return (getProgress() < 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getLengthInSeconds() {
/*  80 */       return 60.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void playOnce() {
/*  85 */       play();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SoundStreamImp
/*     */     extends AbsBuffer
/*     */     implements SoundStream
/*     */   {
/*     */     protected final int[] bufferIDs;
/*     */     private final DATA_STREAM data;
/*     */     private boolean looping;
/*     */     private volatile boolean playing = false;
/*     */     private boolean wantsToStop = false;
/*     */     private boolean gainChanged = false;
/* 100 */     protected float gain = 1.0F;
/*     */     
/* 102 */     protected float bufferOffset = 0.0F;
/*     */     private final SOUND_CORE.AUDIO_GAIN_TYPE type;
/*     */     
/*     */     SoundStreamImp(Path path, boolean music) {
/* 106 */       this.type = music ? SOUND_CORE.AUDIO_GAIN_TYPE.MUSIC : SOUND_CORE.AUDIO_GAIN_TYPE.AMBIENCE;
/* 107 */       this.data = DATA_STREAM.getStream(path);
/* 108 */       int nrOfBuffers = 3;
/* 109 */       this.bufferIDs = Alloc.ii(3);
/* 110 */       for (int i = 0; i < this.bufferIDs.length; i++) {
/* 111 */         this.bufferIDs[i] = AL10.alGenBuffers();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean play() {
/* 121 */       this.wantsToStop = false;
/* 122 */       if (this.playing)
/* 123 */         return true; 
/* 124 */       return play(0.0F);
/*     */     }
/*     */     
/*     */     private boolean play(float off) {
/* 128 */       this.bufferOffset = off;
/* 129 */       this.playing = CORE.getSoundCore().requestStereo(this);
/* 130 */       return this.playing;
/*     */     }
/*     */ 
/*     */     
/*     */     public void playOnce() {
/* 135 */       if (this.playing) {
/* 136 */         this.wantsToStop = true;
/*     */         return;
/*     */       } 
/* 139 */       this.bufferOffset = 0.0F;
/* 140 */       this.playing = CORE.getSoundCore().requestMono(this, true, this.gain, 1.0F);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void setBuffer(SoundCore.Source source) {
/* 146 */       reset();
/* 147 */       for (int i = 0; i < this.bufferIDs.length; i++) {
/* 148 */         source.enqueueBuffer(this.bufferIDs[i]);
/*     */       }
/* 150 */       source.setPitch(1.0F);
/* 151 */       source.setGain(this.gain);
/* 152 */       set(source);
/* 153 */       source.play();
/* 154 */       this.playing = true;
/* 155 */       this.gainChanged = false;
/* 156 */       this.wantsToStop = false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void set(SoundCore.Source source) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void setGain(double gain) {
/* 166 */       if (gain < 0.0D || gain > 1.0D)
/* 167 */         throw new RuntimeException(gain); 
/* 168 */       if (gain != this.gain) {
/* 169 */         this.gain = (float)gain;
/* 170 */         this.gainChanged = true;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void stop() {
/* 179 */       this.wantsToStop = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void resume() {
/* 190 */       if (this.playing)
/*     */         return; 
/* 192 */       play(this.bufferOffset);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setLooping(boolean yes) {
/* 201 */       this.looping = yes;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double getLengthInSeconds() {
/* 209 */       return this.data.getLengthInSeconds();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double getProgress() {
/* 218 */       if (this.playing) {
/* 219 */         return this.data.getProgress();
/*     */       }
/* 221 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isPlaying() {
/* 226 */       return this.playing;
/*     */     }
/*     */     
/*     */     private void reset() {
/* 230 */       this.data.rewind();
/* 231 */       for (int i = 0; i < this.bufferIDs.length; i++) {
/* 232 */         this.data.setNext(this.bufferIDs[i]);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void reclaimSource(SoundCore.Source source) {
/* 239 */       this.bufferOffset = source.getOffset();
/* 240 */       this.playing = false;
/* 241 */       source = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void dis() {
/* 248 */       this.data.dispose(); byte b; int i, arrayOfInt[];
/* 249 */       for (i = (arrayOfInt = this.bufferIDs).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/* 250 */         AL10.alDeleteBuffers(j);
/*     */         b++; }
/*     */     
/*     */     }
/*     */     
/*     */     boolean refillBuffers(SoundCore.Source source) {
/* 256 */       if (this.wantsToStop) {
/* 257 */         return false;
/*     */       }
/*     */       
/* 260 */       while (source.hasProcessedBuffer()) {
/* 261 */         if (this.data.hasMoreBuffers()) {
/* 262 */           for (int i = 0; i < this.bufferIDs.length - 1; i++)
/* 263 */             this.bufferIDs[i] = this.bufferIDs[i + 1]; 
/* 264 */           int buff = source.getProcessedBuffers();
/* 265 */           this.data.setNext(buff);
/* 266 */           source.enqueueBuffer(buff);
/* 267 */           this.bufferIDs[this.bufferIDs.length - 1] = buff;
/* 268 */           if (!source.isPlaying())
/* 269 */             source.play();  continue;
/* 270 */         }  if (this.looping) {
/* 271 */           this.data.rewind();
/* 272 */           refillBuffers(source); continue;
/*     */         } 
/* 274 */         source.getProcessedBuffers();
/* 275 */         return false;
/*     */       } 
/*     */ 
/*     */       
/* 279 */       if (this.gainChanged) {
/* 280 */         source.setGain(this.gain);
/* 281 */         this.gainChanged = false;
/*     */       } 
/*     */       
/* 284 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     SOUND_CORE.AUDIO_GAIN_TYPE type() {
/* 289 */       return this.type;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SoundStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */