/*     */ package game.audio;
/*     */ 
/*     */ import snake2d.SoundStream;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Channel
/*     */ {
/*     */   private Ambiance current;
/*     */   private SoundStream stream;
/*     */   private double gain;
/*     */   
/*     */   public void update(double ds) {
/* 102 */     if (this.current == null) {
/*     */       return;
/*     */     }
/* 105 */     if (!this.stream.isPlaying()) {
/* 106 */       if (this.current.priority > 0.0D) {
/* 107 */         init(this.current);
/*     */       } else {
/* 109 */         this.current.channel = null;
/* 110 */         this.current = null;
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 115 */     if (this.current.priority <= 0.0D) {
/* 116 */       this.gain -= ds;
/* 117 */       if (this.gain <= 0.0D) {
/* 118 */         this.gain = 0.0D;
/* 119 */         this.stream.stop();
/*     */       } 
/*     */     } else {
/* 122 */       double g = this.current.gain();
/* 123 */       if (this.gain < g) {
/* 124 */         this.gain += ds;
/* 125 */         if (this.gain > g)
/* 126 */           this.gain = g; 
/* 127 */       } else if (this.gain > g) {
/* 128 */         this.gain -= ds;
/* 129 */         if (this.gain < g) {
/* 130 */           this.gain = g;
/*     */         }
/*     */       } 
/*     */     } 
/* 134 */     this.gain = CLAMP.d(this.gain, 0.0D, 1.0D);
/* 135 */     this.stream.setGain(this.gain);
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(Ambiance c) {
/* 140 */     c.channel = this;
/* 141 */     this.current = c;
/* 142 */     this.stream = (SoundStream)c.streams.rnd();
/* 143 */     this.stream.setLooping(false);
/* 144 */     this.gain = 0.0D;
/* 145 */     this.stream.setGain(this.gain);
/* 146 */     this.stream.play();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\AmbianceUpdater$Channel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */