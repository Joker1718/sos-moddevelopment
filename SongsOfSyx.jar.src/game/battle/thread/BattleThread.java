/*    */ package game.battle.thread;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.SlaveThread;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.misc.ACTION;
/*    */ 
/*    */ 
/*    */ public abstract class BattleThread
/*    */ {
/*    */   protected final SlaveThread thread;
/*    */   
/* 14 */   private final ACTION job = new ACTION()
/*    */     {
/*    */       public void exe()
/*    */       {
/* 18 */         BattleThread.this.doThreadJob();
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   protected BattleThread(double interval) {
/* 24 */     this.thread = new SlaveThread(getClass().getSimpleName(), interval);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void stop() {
/* 40 */     this.thread.setStopFlag();
/* 41 */     this.thread.waitUntilStopped();
/*    */   }
/*    */   
/*    */   protected void start() {
/* 45 */     this.thread.start(this.job);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract void doThreadJob();
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {}
/*    */ 
/*    */   
/*    */   protected void init() {}
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 60 */     init();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\BattleThread.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */