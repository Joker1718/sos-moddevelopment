/*    */ package game.battle.state;
/*    */ 
/*    */ import game.save.GameLoader;
/*    */ import java.nio.file.Path;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GameLoader
/*    */ {
/*    */   null(Path $anonymous0, String[] $anonymous1) {
/* 13 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void doAfterSet() {
/* 18 */     BattleStateExiter.this.afterExit(r);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleStateExiter$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */