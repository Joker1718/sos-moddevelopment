/*    */ package game.battle;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.formation.DivDeployerUser;
/*    */ import snake2d.util.sets.LIST;
/*    */ import view.main.VIEW;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends DivDeployerUser
/*    */ {
/*    */   null(LIST<Army> $anonymous0) {
/* 57 */     super($anonymous0);
/*    */   }
/*    */   protected boolean blocked(int x, int y, Army a) {
/* 60 */     if (VIEW.b().state() != null && VIEW.b().state().deploying()) {
/* 61 */       if (a == GAME.ARMIES().player())
/* 62 */         return !VIEW.b().state().deploymentBounds().holdsPoint((x >> 6), (y >> 6)); 
/* 63 */       return VIEW.b().state().deploymentBounds().holdsPoint((x >> 6), (y >> 6));
/*    */     } 
/* 65 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\Armies$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */