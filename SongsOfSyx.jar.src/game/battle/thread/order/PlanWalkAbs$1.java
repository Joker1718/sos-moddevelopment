/*    */ package game.battle.thread.order;
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
/*    */   extends BattleOrderUpdater.Plan.STATE
/*    */ {
/*    */   null(BattleOrderUpdater.Plan paramPlan, String $anonymous0) {
/* 66 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   void update(int gameMillis) {
/* 71 */     if (!PlanWalkAbs.div.active() || PlanWalkAbs.men <= 0) {
/*    */       return;
/*    */     }
/* 74 */     if (PlanWalkAbs.amountOfPaths > 1)
/*    */       return; 
/* 76 */     PlanWalkAbs.amountOfPaths++;
/* 77 */     PlanWalkAbs.this.destId.set(PlanWalkAbs.m, PlanWalkAbs.order.dest.setI() & 0xF);
/* 78 */     PlanWalkAbs.this.setStart.set();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   boolean setAction() {
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanWalkAbs$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */