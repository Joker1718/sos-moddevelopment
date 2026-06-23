/*    */ package game.battle.state;
/*    */ 
/*    */ import game.save.GameLoader;
/*    */ import init.paths.PATHS;
/*    */ import java.nio.file.Path;
/*    */ import world.battle.spec.BATTLE_RESULT;
/*    */ 
/*    */ public abstract class BattleStateExiter {
/*    */   public abstract void afterExit(BattleStateResult paramBattleStateResult);
/*    */   
/*    */   public void exit(BATTLE_RESULT res, int plosses, int elosses) {
/* 12 */     final BattleStateResult r = new BattleStateResult(res, elosses, plosses);
/* 13 */     (new GameLoader(PATHS.local().save().get("__beforeBattle"), new String[0])
/*    */       {
/*    */         
/*    */         public void doAfterSet()
/*    */         {
/* 18 */           BattleStateExiter.this.afterExit(r);
/*    */         }
/* 22 */       }).set();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleStateExiter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */