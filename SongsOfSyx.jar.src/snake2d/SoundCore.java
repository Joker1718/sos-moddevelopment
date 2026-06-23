/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.file.Path;
/*     */ import java.util.Arrays;
/*     */ import org.lwjgl.openal.AL;
/*     */ import org.lwjgl.openal.AL10;
/*     */ import org.lwjgl.openal.ALC;
/*     */ import org.lwjgl.openal.ALC10;
/*     */ import org.lwjgl.openal.ALCCapabilities;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SoundCore
/*     */   extends SOUND_CORE
/*     */ {
/*     */   private volatile boolean lock;
/*     */   private volatile boolean yippieKayey;
/*     */   private long context;
/*     */   private long device;
/*     */   private Thread t;
/*     */   private static final int MONO_SOURCES = 10;
/*     */   private final Source[] monoSources;
/*     */   private volatile int lastMon;
/*     */   private volatile double largestDistance;
/*     */   private final int max;
/*     */   private static final int STEREO_SOURCES = 6;
/*     */   private final Source[] stereoSources;
/*     */   private volatile int lastStereo;
/*     */   private volatile int stereoCount;
/*     */   private volatile boolean muteOnFocus;
/*  44 */   private static double[] gains = new double[(SOUND_CORE.AUDIO_GAIN_TYPE.values()).length];
/*  45 */   private static double masterGain = 1.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LinkedList<AbsBuffer> sounds;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sleep() {
/*     */     try {
/*     */       Thread.sleep(128L);
/*     */     } catch (InterruptedException interruptedException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int cX, int cY) {
/*     */     while (!lock()) {
/*     */       if (!this.yippieKayey) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     if (Source.centreX != cX || Source.centreY != cY) {
/*     */       Source.centreX = cX;
/*     */       Source.centreY = cY;
/*     */       for (int i = 0; i < this.lastMon; i++) {
/*     */         if ((this.monoSources[i]).relative) {
/*     */           this.monoSources[i].setPosition((this.monoSources[i]).x, (this.monoSources[i]).y);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     unlock();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopAllSounds() {
/*     */     while (!lock()) {
/*     */       if (!this.yippieKayey) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     int i;
/*     */     for (i = 0; i < this.monoSources.length; i++) {
/*     */       this.monoSources[i].stop();
/*     */     }
/*     */     for (i = 0; i < 6; i++) {
/*     */       this.stereoSources[i].stop();
/*     */     }
/*     */     this.lastMon = 0;
/*     */     this.lastStereo = 0;
/*     */     checkErrors();
/*     */     if (ALC10.alcGetError(this.device) != 0) {
/*     */       throw new RuntimeException("stopping error");
/*     */     }
/*     */     unlock();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void dis() {
/*     */     this.yippieKayey = false;
/*     */     if (this.t != null && this.t.isAlive()) {
/*     */       while (this.t.isAlive()) {
/*     */         this.t.interrupt();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized boolean lock() {
/*     */     if (this.lock || !this.yippieKayey) {
/*     */       return false;
/*     */     }
/*     */     this.lock = true;
/*     */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void unlock() {
/*     */     this.lock = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean requestMono(AbsBuffer buff, int x, int y, boolean prio, float gain, float pitch) {
/*     */     return requestMono(buff, x, y, true, prio, gain, pitch);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SoundCore(String d, SETTINGS settings) {
/*     */     ALCCapabilities caps;
/*     */     this.yippieKayey = false;
/*     */     this.context = -1L;
/*     */     this.device = -1L;
/*     */     this.monoSources = new Source[10];
/*     */     this.lastMon = 0;
/*     */     this.stereoSources = new Source[6];
/*     */     this.lastStereo = 0;
/*     */     this.stereoCount = 0;
/* 548 */     this.sounds = new LinkedList(); Printer.ln("SOUND"); Arrays.fill(gains, 1.0D); masterGain = 1.0D; this.device = ALC10.alcOpenDevice(d); if (this.device == 0L) throw new IllegalStateException("Failed to open an OpenAL device.");  this.max = ((settings.getNativeWidth() > settings.getNativeHeight()) ? settings.getNativeWidth() : settings.getNativeHeight()) * 4; if (this.device == 0L) throw new Errors.GameError("Problems with sound device: " + d + ". Could not be opened. Try a different device.");  try { caps = ALC.createCapabilities(this.device); Source.posTransX = 1.0F / settings.getNativeWidth(); Source.posTransY = 1.0F / settings.getNativeHeight(); if (!caps.OpenALC10) throw new Errors.GameError("No OpenALC 10 support found for: " + d + ". Make sure your computer has got this support. Try enabling sound and or / plug in/out speakers/earphones or restart your computer.");  this.context = ALC10.alcCreateContext(this.device, null); ALC10.alcMakeContextCurrent(this.context); AL.createCapabilities(caps); } catch (Throwable e) { e.printStackTrace(); throw new Errors.GameError("No OpenALC 10 support found for: " + d + ". Make sure your computer has got this support. Try enabling sound and or / plug in/out speakers/earphones or restart your computer. If you're on linux you might have to adjust settings in pulseaudio"); }  AL10.alListener3f(4102, 0.0F, 0.0F, 0.0F); AL10.alDistanceModel(53250); AL10.alListener3f(4100, 0.0F, 0.0F, 0.5F); int i; for (i = 0; i < this.monoSources.length; i++) this.monoSources[i] = new Source(false, null);  for (i = 0; i < 6; i++) this.stereoSources[i] = new Source(true, null);  Printer.ln("---AL version : " + AL10.alGetString(45058)); Printer.ln("---AL vendor : " + AL10.alGetString(45057)); Printer.ln("---AL renderer : " + AL10.alGetString(45059)); Printer.ln("---OpenALC10: " + caps.OpenALC10); Printer.ln("---OpenALC11: " + caps.OpenALC11); Printer.ln("---ALC_FREQUENCY: " + ALC10.alcGetInteger(this.device, 4103) + "Hz"); Printer.ln("---ALC_REFRESH: " + ALC10.alcGetInteger(this.device, 4104) + "Hz"); Printer.ln("---ALC_SYNC: " + ((ALC10.alcGetInteger(this.device, 4105) == 1) ? 1 : 0)); Printer.ln("---Created Mono Sources : 10"); Printer.ln("---Created Stereo Sources : 6"); Printer.fin(); checkErrors(); this.yippieKayey = true; Runnable r = new Runnable() { public void run() { while (SoundCore.this.yippieKayey) { while (!SoundCore.this.lock()) { if (!SoundCore.this.yippieKayey) return;  Thread.yield(); }  double mg = SoundCore.masterGain; if (CORE.getGraphics().focused() || !SoundCore.this.muteOnFocus) { mg += 0.25D; } else if (SoundCore.this.muteOnFocus) { mg -= 0.1D; }  mg = CLAMP.d(mg, 0.0D, SoundCore.gains[SOUND_CORE.AUDIO_GAIN_TYPE.MASTER.ordinal()]); if (mg != SoundCore.masterGain) { SoundCore.masterGain = mg; int k; for (k = 0; k < SoundCore.this.lastMon; k++) SoundCore.this.monoSources[k].setGain((SoundCore.this.monoSources[k]).gain);  for (k = 0; k < SoundCore.this.lastStereo; k++) SoundCore.this.stereoSources[k].setGain((SoundCore.this.stereoSources[k]).gain);  }  SoundCore.checkErrors(); SoundCore.this.largestDistance = 0.0D; int j; for (j = 0; j < SoundCore.this.lastMon; j++) { if (!SoundCore.this.monoSources[j].update()) { SoundCore.this.lastMon = SoundCore.this.lastMon - 1; if (SoundCore.this.lastMon > 0) { SoundCore.Source fin = SoundCore.this.monoSources[j]; SoundCore.this.monoSources[j] = SoundCore.this.monoSources[SoundCore.this.lastMon]; SoundCore.this.monoSources[SoundCore.this.lastMon] = fin; j--; }  } else if ((SoundCore.this.monoSources[j]).distance > SoundCore.this.largestDistance) { SoundCore.this.largestDistance = (SoundCore.this.monoSources[j]).distance; }  }  for (j = 0; j < SoundCore.this.lastStereo; j++) { if (!SoundCore.this.stereoSources[j].update()) { SoundCore.this.lastStereo = SoundCore.this.lastStereo - 1; if (SoundCore.this.lastStereo > 0) { SoundCore.Source fin = SoundCore.this.stereoSources[j]; SoundCore.this.stereoSources[j] = SoundCore.this.stereoSources[SoundCore.this.lastStereo]; SoundCore.this.stereoSources[SoundCore.this.lastStereo] = fin; j--; }  }  }  SoundCore.checkErrors(); SoundCore.this.unlock(); SoundCore.this.sleep(); }  int i; for (i = 0; i < SoundCore.this.monoSources.length; i++) SoundCore.this.monoSources[i].dispose();  for (i = 0; i < 6; i++) SoundCore.this.stereoSources[i].dispose();  SoundCore.checkErrors(); SoundCore.this.disposeSounds(); SoundCore.checkErrors(); SoundCore.checkErrors(); ALC10.alcMakeContextCurrent(0L); if (ALC10.alcGetError(SoundCore.this.device) != 0)
/*     */             throw new RuntimeException("context not destroyed");  if (!ALC10.alcCloseDevice(SoundCore.this.device))
/*     */             throw new RuntimeException("device not destroyed");  Printer.ln(SoundCore.class + " sucessfully destroyed"); } }
/*     */       ; this.t = new Thread(r); this.t.setName("Sounder"); this.t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { public void uncaughtException(Thread t, Throwable e) { SoundCore.this.yippieKayey = false; SoundCore.this.lock = false; e.printStackTrace(); CORE.annihilate(e); } }); this.t.start();
/* 552 */   } public SoundEffect getEffect(Path path) { SoundEffect.SoundEffectImp e = new SoundEffect.SoundEffectImp(path);
/* 553 */     this.sounds.add(e);
/* 554 */     return e; } boolean requestMono(AbsBuffer buff, boolean prio, float gain, float pitch) { return requestMono(buff, Source.centreX, Source.centreY, false, prio, gain, pitch); }
/*     */   private boolean requestMono(AbsBuffer buff, int x, int y, boolean rel, boolean prio, float gain, float pitch) { if (!this.yippieKayey) return false;  if (!lock()) return false;  double d = 0.0D; if (rel) { d = COORDINATE.tileDistance(x, y, Source.centreX, Source.centreY); if (d > this.max) { unlock(); return false; }  }  if (this.lastMon < 9) { (this.monoSources[this.lastMon]).relative = rel; (this.monoSources[this.lastMon]).buffer = buff; if (d > this.largestDistance) this.largestDistance = d;  Source s = this.monoSources[this.lastMon++]; setSource(s, buff, x, y, rel, prio, gain, pitch); unlock(); return true; }  if (d < this.largestDistance) { for (int i = 0; i < this.monoSources.length; i++) { if (d < (this.monoSources[i]).distance) { this.monoSources[i].stop(); setSource(this.monoSources[i], buff, x, y, rel, prio, gain, pitch); unlock(); return true; }  }  } else if (prio) { int lowest = -1; int dist = -1; for (int i = 0; i < this.monoSources.length; i++) { if (!(this.monoSources[i]).prio && (this.monoSources[i]).distance > dist)
/*     */           lowest = i;  }  if (lowest != -1) { this.monoSources[lowest].stop(); setSource(this.monoSources[lowest], buff, x, y, rel, prio, gain, pitch); unlock(); return true; }  }  unlock(); return false; }
/*     */   private void setSource(Source s, AbsBuffer buff, int x, int y, boolean rel, boolean prio, float gain, float pitch) { s.buffer = buff; s.relative = rel; s.prio = prio; buff.setBuffer(s); s.setGain(gain); s.setPitch(pitch); s.setPosition(x, y); s.play(); }
/*     */   boolean requestStereo(AbsBuffer buff) { if (this.yippieKayey && lock()) { if (this.lastStereo < 6) { (this.stereoSources[this.lastStereo]).buffer = buff; (this.stereoSources[this.lastStereo]).distance = this.stereoCount++; this.lastStereo++; buff.setBuffer(this.stereoSources[this.lastStereo - 1]); }  unlock(); return true; }  return false; }
/* 559 */   public SoundStream getStream(Path path, boolean music) { SoundStream.SoundStreamImp m = new SoundStream.SoundStreamImp(path, music);
/* 560 */     this.sounds.add(m);
/* 561 */     return m; } public void setGain(double gain, SOUND_CORE.AUDIO_GAIN_TYPE type) { if (gains[type.ordinal()] == gain) return;  gains[type.ordinal()] = gain; while (!lock()) { if (!this.yippieKayey)
/*     */         return;  }  int i; for (i = 0; i < this.lastMon; i++)
/*     */       this.monoSources[i].setGain((this.monoSources[i]).gain);  for (i = 0; i < this.lastStereo; i++)
/*     */       this.stereoSources[i].setGain((this.stereoSources[i]).gain);  unlock(); }
/*     */   public void setMuteOnFocus(boolean muteOnFocus) { this.muteOnFocus = muteOnFocus; }
/* 566 */   public SoundEffectStream getStreamMono(Path path) { SoundEffectStream.SoundEffectStreamImp m = new SoundEffectStream.SoundEffectStreamImp(path, false);
/* 567 */     this.sounds.add(m);
/* 568 */     return m; } static class Source {
/*     */     private static float posTransX = 1.0F; private static float posTransY = 1.0F; private static int centreX = 0; private static int centreY = 0; private final int id; private boolean relative; private int x; private int y; private double distance; private AbsBuffer buffer; private float gain; boolean prio; private Source(boolean stereo) { this.id = AL10.alGenSources(); if (!stereo) { AL10.alSourcef(this.id, 4129, 5.0F); AL10.alSourcef(this.id, 4128, 1.0F); AL10.alSourcef(this.id, 4131, 2.0F); }  } void setBuffer(int buffID) { AL10.alSourcei(this.id, 4105, buffID); } void enqueueBuffer(int buffID) { AL10.alSourceQueueBuffers(this.id, buffID); } int getProcessedBuffers() { return AL10.alSourceUnqueueBuffers(this.id); } boolean hasProcessedBuffer() { return (1 == AL10.alGetSourcei(this.id, 4118)); } void setPosition(int x, int y) { this.x = x; this.y = y; this.distance = COORDINATE.tileDistance(x, y, centreX, centreY); AL10.alSource3f(this.id, 4100, (x - centreX) * posTransX, (y - centreY) * posTransY, 0.0F); } void setPitch(float pitch) { AL10.alSourcef(this.id, 4099, pitch); } void setGain(float gain) { this.gain = gain; if (gain > 1.0F || gain < 0.0F) { (new RuntimeException(gain)).printStackTrace(); return; }  float ff = (float)(gain * SoundCore.masterGain * SoundCore.gains[this.buffer.type().ordinal()]); if (ff < 0.0F || ff > 1.0F) System.out.println(String.valueOf(ff) + " " + gain + " " + SoundCore.masterGain + " " + SoundCore.gains[SOUND_CORE.AUDIO_GAIN_TYPE.MASTER.ordinal()] + " " + SoundCore.gains[this.buffer.type().ordinal()]);  AL10.alSourcef(this.id, 4106, ff); SoundCore.checkErrors(); } void play() { AL10.alSourcePlay(this.id); } boolean isPlaying() { return (AL10.alGetSourcei(this.id, 4112) == 4114); } void setBufferOffset(float offset) { AL10.alSourcef(this.id, 4133, offset); } float getOffset() { return AL10.alGetSourcef(this.id, 4134); } private boolean update() { if (this.buffer.refillBuffers(this)) { if (!isPlaying()) AL10.alSourcePlay(this.id);  return true; }  if (isPlaying()) return true;  stop(); return false; }
/*     */     void stop() { if (this.buffer != null) { this.buffer.reclaimSource(this); this.buffer = null; }  AL10.alSourceStop(this.id); AL10.alSourcei(this.id, 4105, 0); }
/*     */     private void dispose() { AL10.alSourceStop(this.id); AL10.alSourcei(this.id, 4105, 0); AL10.alDeleteSources(this.id); } }
/*     */   static void checkErrors() { switch (AL10.alGetError()) { case 40961: throw new RuntimeException("AL_INVALID_NAME");case 40962: throw new RuntimeException("AL_INVALID_ENUM");case 40963: throw new RuntimeException("AL_INVALID_VALUE");case 40964: throw new RuntimeException("AL_INVALID_OPERATION");case 40965: throw new RuntimeException("AL_OUT_OF_MEMORY"); }  }
/* 573 */   public void disposeSounds() { if (this.sounds.size() > 0) {
/*     */       
/* 575 */       for (AbsBuffer e : this.sounds) {
/* 576 */         e.dis();
/*     */       }
/* 578 */       this.sounds.clear();
/*     */     }  }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SoundCore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */