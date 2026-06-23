/*    */ package game.battle.thread.trajectory;
/*    */ 
/*    */ import init.constant.Config;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.thing.projectiles.Trajectory;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ 
/*    */ final class DivTrajectory
/*    */ {
/* 14 */   int targets = 0;
/*    */   boolean potential;
/* 16 */   private final float[] data = new float[(Config.battle()).MEN_PER_DIVISION * 3];
/* 17 */   private static Trajectory tra = new Trajectory();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void set(int pos, Trajectory t) {
/* 25 */     int i = pos * 3;
/* 26 */     this.targets++;
/* 27 */     this.data[i] = (float)t.vx();
/* 28 */     this.data[i + 1] = (float)t.vy();
/* 29 */     this.data[i + 2] = (float)t.vz();
/*    */   }
/*    */   
/*    */   public boolean has(int pos) {
/* 33 */     return !Float.isNaN(this.data[pos * 3]);
/*    */   }
/*    */ 
/*    */   
/*    */   public Trajectory get(int pos, Humanoid a) {
/* 38 */     int i = pos * 3;
/* 39 */     if (Float.isNaN(this.data[i])) {
/* 40 */       return null;
/*    */     }
/* 42 */     tra.set(this.data[i], this.data[i + 1], this.data[i + 2]);
/* 43 */     return tra;
/*    */   }
/*    */   
/*    */   public void save(FilePutter file) {
/* 47 */     file.fs(this.data);
/* 48 */     file.i(this.targets);
/* 49 */     file.bool(this.potential);
/*    */   }
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 53 */     file.fs(this.data);
/* 54 */     this.targets = file.i();
/* 55 */     this.potential = file.bool();
/*    */   }
/*    */   
/*    */   public void clear() {
/* 59 */     Arrays.fill(this.data, Float.NaN);
/* 60 */     this.targets = 0;
/* 61 */     this.potential = false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\trajectory\DivTrajectory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */