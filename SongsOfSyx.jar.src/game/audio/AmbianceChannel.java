/*    */ package game.audio;
/*    */ 
/*    */ import snake2d.SoundStream;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ final class AmbianceChannel
/*    */ {
/*    */   private Ambiance current;
/*    */   private SoundStream stream;
/*    */   private double gain;
/*    */   private boolean play;
/*    */   
/*    */   public void update(double ds) {
/* 14 */     if (this.current == null)
/*    */       return; 
/* 16 */     if (!this.stream.isPlaying()) {
/* 17 */       this.current = null;
/*    */       return;
/*    */     } 
/* 20 */     if (!this.play || this.current.priority <= 0.0D) {
/* 21 */       this.gain -= ds * 2.0D;
/* 22 */       if (this.gain <= 0.0D) {
/* 23 */         this.gain = 0.0D;
/* 24 */         this.stream.stop();
/* 25 */         this.play = false;
/*    */       } 
/*    */     } 
/*    */     
/* 29 */     if (this.gain < this.current.gain()) {
/* 30 */       this.gain += ds * 2.0D;
/* 31 */       if (this.gain > this.current.gain())
/* 32 */         this.gain = this.current.gain(); 
/* 33 */     } else if (this.gain > this.current.gain()) {
/* 34 */       this.gain -= ds * 2.0D;
/* 35 */       if (this.gain < this.current.gain())
/* 36 */         this.gain = this.current.gain(); 
/*    */     } 
/* 38 */     this.gain = CLAMP.d(this.gain, 0.0D, 1.0D);
/* 39 */     this.stream.setGain(this.gain);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(Ambiance c) {
/* 44 */     this.current = c;
/* 45 */     this.stream = (SoundStream)c.streams.rnd();
/* 46 */     this.stream.setLooping(false);
/* 47 */     this.gain = 0.0D;
/* 48 */     this.stream.setGain(this.gain);
/* 49 */     this.stream.play();
/* 50 */     this.play = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\AmbianceChannel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */