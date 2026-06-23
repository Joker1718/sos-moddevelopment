/*    */ package game.battle.formation;
/*    */ 
/*    */ import game.battle.Army;
/*    */ import snake2d.PathUtilOnline;
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
/*    */   extends DivDeployer
/*    */ {
/*    */   null(PathUtilOnline $anonymous0) {
/* 43 */     super($anonymous0);
/*    */   }
/*    */   protected boolean isDeployable(int px, int py, Army a) {
/* 46 */     return !DivDeployerUser.this.blocked(px, py, a);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivDeployerUser$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */