/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.file.Path;
/*     */ import org.lwjgl.openal.AL10;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface SoundEffect
/*     */   extends SoundSimple
/*     */ {
/*     */   boolean play(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean);
/*     */   
/*     */   boolean play(RECTANGLE paramRECTANGLE, float paramFloat1, float paramFloat2, boolean paramBoolean);
/*     */   
/*     */   boolean play(int paramInt1, int paramInt2, boolean paramBoolean);
/*     */   
/*     */   boolean play(float paramFloat1, float paramFloat2, boolean paramBoolean);
/*     */   
/*     */   float lengthInSeconds();
/*     */   
/*     */   public static class SoundEffectImp
/*     */     extends AbsBuffer
/*     */     implements SoundEffect
/*     */   {
/*     */     final int ID;
/*     */     private final Data data;
/*     */     
/*     */     SoundEffectImp(Path path) {
/*  31 */       this.data = new Data(path);
/*     */       
/*  33 */       this.ID = AL10.alGenBuffers();
/*     */       
/*  35 */       AL10.alBufferData(this.ID, this.data.alFormat, this.data.data, this.data.samplerate);
/*     */       
/*  37 */       this.data.dispose();
/*     */     }
/*     */ 
/*     */     
/*     */     void dis() {
/*  42 */       AL10.alDeleteBuffers(this.ID);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean play(int x, int y, float pitch, float gain, boolean priority) {
/*  48 */       return CORE.getSoundCore().requestMono(this, x, y, priority, gain, pitch);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean play(RECTANGLE rec, float pitch, float gain, boolean priority) {
/*  53 */       return play(rec.cX(), rec.cY(), pitch, gain, priority);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean play(int x, int y, boolean priority) {
/*  58 */       return play(x, y, 1.0F, 1.0F, priority);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean play(boolean priority) {
/*  63 */       return play(1.0F, 1.0F, priority);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean play(float pitch, float gain, boolean priority) {
/*  68 */       return CORE.getSoundCore().requestMono(this, priority, gain, pitch);
/*     */     }
/*     */ 
/*     */     
/*     */     public float lengthInSeconds() {
/*  73 */       return this.data.length;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void reclaimSource(SoundCore.Source source) {}
/*     */ 
/*     */ 
/*     */     
/*     */     boolean refillBuffers(SoundCore.Source source) {
/*  84 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     void setBuffer(SoundCore.Source source) {
/*  89 */       source.setBuffer(this.ID);
/*     */     }
/*     */ 
/*     */     
/*     */     SOUND_CORE.AUDIO_GAIN_TYPE type() {
/*  94 */       return SOUND_CORE.AUDIO_GAIN_TYPE.EFFECT;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Dummy
/*     */     implements SoundEffect
/*     */   {
/*     */     public boolean play(int x, int y, float pitch, float gain, boolean priority) {
/* 104 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean play(RECTANGLE rec, float pitch, float gain, boolean priority) {
/* 109 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean play(int x, int y, boolean priority) {
/* 114 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean play(boolean priority) {
/* 119 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean play(float pitch, float gain, boolean priority) {
/* 124 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public float lengthInSeconds() {
/* 129 */       return 5.0F;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SoundEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */