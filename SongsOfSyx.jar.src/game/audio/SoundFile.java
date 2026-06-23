/*    */ package game.audio;
/*    */ 
/*    */ import java.nio.file.Path;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SoundEffect;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public final class SoundFile
/*    */   implements MAPPED
/*    */ {
/*    */   private final int index;
/*    */   private final String key;
/*    */   public final SoundEffect sound;
/* 17 */   public double gain = 1.0D;
/* 18 */   public double pitch = 0.3D;
/*    */   
/*    */   SoundFile(LISTE<SoundFile> all, Path p, String key) {
/* 21 */     this.sound = CORE.getSoundCore().getEffect(p);
/* 22 */     this.index = all.add(this);
/* 23 */     this.key = key;
/*    */   }
/*    */   
/*    */   SoundFile(LISTE<SoundFile> all, SoundEffect p, String key) {
/* 27 */     this.sound = p;
/* 28 */     this.index = all.add(this);
/* 29 */     this.key = key;
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 34 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 39 */     return this.key;
/*    */   }
/*    */   
/*    */   public void rnd(RECTANGLE body) {
/* 43 */     rnd(body, (0.8F + RND.rFloat(0.2D)));
/*    */   }
/*    */   
/*    */   public void rnd(RECTANGLE body, double gain) {
/* 47 */     rnd(body.cX(), body.cY(), gain);
/*    */   }
/*    */   
/*    */   public void rnd(int x, int y, double gain) {
/* 51 */     gain *= this.gain;
/* 52 */     if (gain <= 0.0D)
/*    */       return; 
/* 54 */     float pitch = RND.rFloat1(this.pitch);
/* 55 */     this.sound.play(x, y, pitch, (float)gain, false);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\SoundFile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */