/*    */ package game.raiding;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import util.updating.IUpdater;
/*    */ 
/*    */ class Updater
/*    */   extends IUpdater
/*    */ {
/* 13 */   private static double raidingInterval = (96 * TIME.secondsPerDay());
/* 14 */   private double timer = 0.0D;
/*    */   
/*    */   public Updater(RAIDING r) {
/* 17 */     super(100, TIME.secondsPerDay());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 22 */     if ((GAME.raiders()).current.current() != null) {
/*    */       return;
/*    */     }
/*    */     
/* 26 */     Raider r = (Raider)GAME.raiders().ALL().get(i);
/* 27 */     if (!r.defeated && r.hasInterrest() && !r.isScared()) {
/* 28 */       this.timer += timeSinceLast;
/*    */       
/* 30 */       if (this.timer >= raidingInterval) {
/* 31 */         r.text.set(r, (r.raids == 0));
/* 32 */         (GAME.raiders()).current.raid(r);
/* 33 */         this.timer -= raidingInterval * Math.sqrt(GAME.raiders().ALL().size());
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 40 */     file.d(this.timer);
/* 41 */     super.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 46 */     this.timer = file.d();
/* 47 */     super.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 52 */     this.timer = 0.0D;
/* 53 */     super.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */