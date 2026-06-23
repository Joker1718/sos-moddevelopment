/*    */ package game.battle.thread.order;
/*    */ 
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class PlanWalkToDest
/*    */   extends PlanWalkAbs
/*    */ {
/*    */   public PlanWalkToDest(Tools tools, LISTE<BattleOrderUpdater.Plan> all, BattleOrderUpdater.Data data) {
/* 12 */     super(tools, all, data, BattleOrderTask.DIVTASK.MOVE);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void init() {
/* 18 */     setWalkToDest();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void update(int gamemillis) {
/* 24 */     state(m).update(gamemillis);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void finished() {
/* 30 */     task.stop(div);
/* 31 */     order.task.set(task);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   boolean continueWhenFighting() {
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanWalkToDest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */