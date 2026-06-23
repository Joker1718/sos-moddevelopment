/*    */ package game.battle.thread;
/*    */ 
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ACTION.ACTION_O<Path>
/*    */ {
/*    */   public void exe(Path t) {
/* 52 */     boolean s = BattleThreads.this.started;
/*    */     
/* 54 */     BattleThreads.this.centres.init();
/* 55 */     BattleThreads.this.status.init();
/*    */     
/* 57 */     if (s)
/* 58 */       BattleThreads.this.unpause(false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\BattleThreads$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */