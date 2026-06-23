/*    */ package game.battle.thread.position;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.battle.thread.BattleThread;
/*    */ import init.constant.Config;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ 
/*    */ public final class DivCentres
/*    */   extends BattleThread
/*    */ {
/* 12 */   private Context current = new Context();
/*    */   
/* 14 */   private Context[] next = new Context[] {
/* 15 */       new Context(), 
/* 16 */       new Context()
/*    */     };
/* 18 */   private volatile int ci = 0;
/* 19 */   private final Updater updater = new Updater();
/*    */   
/*    */   public DivCentres() {
/* 22 */     super(0.016666666666666666D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DivCentre centre(Div d) {
/* 30 */     return this.current.statuses[d.index()];
/*    */   }
/*    */   
/*    */   public DivCentre centre(int di) {
/* 34 */     return this.current.statuses[di];
/*    */   }
/*    */ 
/*    */   
/*    */   protected void stop() {
/* 39 */     this.updater.stop = true;
/* 40 */     super.stop();
/* 41 */     this.updater.stop = false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init() {
/* 46 */     this.updater.init(this.current);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(Div div) {
/* 51 */     boolean started = this.thread.working();
/* 52 */     stop();
/* 53 */     this.updater.init(this.current, div);
/* 54 */     if (started) {
/* 55 */       start();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {}
/*    */ 
/*    */   
/*    */   protected void doThreadJob() {
/* 65 */     this.updater.init(this.next[this.ci]);
/* 66 */     if (this.updater.stop)
/*    */       return; 
/* 68 */     Context c = this.current;
/* 69 */     this.current = this.next[this.ci];
/* 70 */     this.next[this.ci] = c;
/* 71 */     this.ci++;
/* 72 */     this.ci %= this.next.length;
/*    */   }
/*    */ 
/*    */   
/*    */   static class Context
/*    */   {
/* 78 */     final DivCentre[] statuses = new DivCentre[(Config.battle()).DIVISIONS_PER_BATTLE];
/*    */     
/*    */     Context() {
/* 81 */       for (int i = 0; i < this.statuses.length; i++)
/* 82 */         this.statuses[i] = new DivCentre(); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\position\DivCentres.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */