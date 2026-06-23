/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ public interface SoundEffectStream
/*     */   extends SoundStream {
/*     */   void setCoos(int paramInt1, int paramInt2);
/*     */   
/*     */   public static class Dummy
/*     */     implements SoundEffectStream {
/*  12 */     long millis = 0L;
/*     */     
/*     */     private boolean looping = false;
/*     */     
/*     */     public boolean play() {
/*  17 */       this.millis = (long)(System.currentTimeMillis() + getLengthInSeconds() * 1000.0D);
/*  18 */       return true;
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
/*  29 */       this.millis = 0L;
/*     */     }
/*     */ 
/*     */     
/*     */     public void resume() {
/*  34 */       play();
/*     */     }
/*     */ 
/*     */     
/*     */     public void setLooping(boolean yes) {
/*  39 */       this.looping = yes;
/*     */     }
/*     */ 
/*     */     
/*     */     public double getProgress() {
/*  44 */       double p = 1.0D - (this.millis - System.currentTimeMillis()) / (1000.0D + getLengthInSeconds());
/*  45 */       if (this.looping && this.millis != 0L)
/*  46 */         p %= 1.0D; 
/*  47 */       return CLAMP.d(p, 0.0D, 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isPlaying() {
/*  52 */       if (this.looping && this.millis != 0L)
/*  53 */         return true; 
/*  54 */       return (getProgress() < 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getLengthInSeconds() {
/*  59 */       return 5.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void playOnce() {
/*  64 */       play();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setCoos(int x, int y) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SoundEffectStreamImp
/*     */     extends SoundStream.SoundStreamImp
/*     */     implements SoundEffectStream
/*     */   {
/*  80 */     private int x = 0;
/*  81 */     private int y = 0;
/*     */     private boolean posChanged = false;
/*     */     
/*     */     SoundEffectStreamImp(Path path, boolean music) {
/*  85 */       super(path, music);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setCoos(int x, int y) {
/*  90 */       this.x = x;
/*  91 */       this.y = y;
/*  92 */       this.posChanged = true;
/*  93 */       isPlaying();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void set(SoundCore.Source source) {
/* 100 */       source.setPosition(this.x, this.y);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean refillBuffers(SoundCore.Source source) {
/* 112 */       if (super.refillBuffers(source)) {
/* 113 */         if (this.posChanged) {
/* 114 */           this.posChanged = false;
/* 115 */           source.setPosition(this.x, this.y);
/*     */         } 
/* 117 */         return true;
/*     */       } 
/* 119 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SoundEffectStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */