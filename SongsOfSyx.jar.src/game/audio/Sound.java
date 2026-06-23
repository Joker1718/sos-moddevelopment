/*    */ package game.audio;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.LIST;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ final class Sound
/*    */ {
/*    */   private static double playCount;
/*    */   public final LIST<SoundFile> all;
/*    */   
/*    */   Sound(LIST<SoundFile> all) {
/* 15 */     this.all = all;
/*    */   }
/*    */   
/*    */   public void rnd(RECTANGLE body) {
/* 19 */     rnd(body, (0.8F + RND.rFloat(0.2D)));
/*    */   }
/*    */   
/*    */   public void rnd(RECTANGLE body, double gain) {
/* 23 */     rnd(body.cX(), body.cY(), gain);
/*    */   }
/*    */   
/*    */   public void rnd(int cx, int cy) {
/* 27 */     rnd(cx, cy, (0.8F + RND.rFloat(0.2D)));
/*    */   }
/*    */   
/*    */   public void rnd(int x, int y, double gain) {
/* 31 */     playCount += GAME.SPEED.speedI();
/* 32 */     if (playCount >= 1.0D) {
/* 33 */       playCount--;
/*    */     } else {
/*    */       return;
/*    */     } 
/* 37 */     if (VIEW.world().isActive())
/*    */       return; 
/* 39 */     ((SoundFile)this.all.rnd()).rnd(x, y, gain * (AUDIO.mono()).sGain);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\Sound.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */