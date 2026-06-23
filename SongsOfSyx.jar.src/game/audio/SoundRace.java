/*    */ package game.audio;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import snake2d.SoundSimple;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public final class SoundRace
/*    */   implements MAPPED, SoundSimple {
/*    */   private Sound[] all;
/*    */   private final int index;
/*    */   private final String key;
/*    */   
/*    */   SoundRace(int index, String key, Sound sound) {
/* 19 */     this.all = new Sound[RACES.all().size()];
/* 20 */     set(sound);
/*    */     
/* 22 */     this.key = key;
/* 23 */     this.index = index;
/*    */   }
/*    */ 
/*    */   
/*    */   void set(Sound monos) {
/* 28 */     for (int ri = 0; ri < this.all.length; ri++) {
/* 29 */       set(ri, monos);
/*    */     }
/*    */   }
/*    */   
/*    */   void set(int ri, Sound monos) {
/* 34 */     this.all[ri] = monos;
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 39 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 44 */     return this.key;
/*    */   }
/*    */   
/*    */   public void rnd(Humanoid a) {
/* 48 */     rnd(a.race()).rnd(a.body());
/*    */   }
/*    */   
/*    */   private Sound rnd(Race race) {
/* 52 */     return this.all[race.index];
/*    */   }
/*    */   
/*    */   public void rnd(Race race, RECTANGLE body) {
/* 56 */     this.all[race.index].rnd(body);
/*    */   }
/*    */   
/*    */   public void play(Race race, int cx, int cy) {
/* 60 */     SoundFile f = (SoundFile)(this.all[(FACTIONS.player().race()).index]).all.rnd();
/* 61 */     f.sound.play(cx, cy, 1.0F, (float)f.gain, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean play(boolean priority) {
/* 66 */     SoundFile f = (SoundFile)(this.all[(FACTIONS.player().race()).index]).all.rnd();
/* 67 */     return f.sound.play(1.0F, (float)f.gain, false);
/*    */   }
/*    */   
/*    */   public void rnd(RECTANGLE body) {
/* 71 */     rnd(body, (0.8F + RND.rFloat(0.2D)));
/*    */   }
/*    */   
/*    */   public void rnd(RECTANGLE body, double gain) {
/* 75 */     rnd(body.cX(), body.cY(), gain);
/*    */   }
/*    */ 
/*    */   
/*    */   public void rnd(int x, int y, double gain) {
/* 80 */     rnd(FACTIONS.player().race()).rnd(x, y, gain * (AUDIO.mono()).sGain);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\SoundRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */