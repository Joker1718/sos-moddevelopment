/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.HPoll;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.util.AIPlanGladiator;
/*    */ import settlement.room.service.arena.RoomArenaWork;
/*    */ import settlement.stats.STATS;
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
/*    */   extends AIPlanGladiator
/*    */ {
/*    */   null(String $anonymous0, boolean $anonymous1, CharSequence $anonymous2) {
/* 22 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 26 */     if (e.type == HPoll.WORKING)
/* 27 */       return 1.0D; 
/* 28 */     return super.poll(a, d, e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 33 */     return WorkGladiator.this.hasEmployment(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void cancel(Humanoid a, AIManager d) {
/* 38 */     super.cancel(a, d);
/* 39 */     if (WorkGladiator.work(a) != null && WorkGladiator.work(a).employees().isOverstaffed()) {
/* 40 */       (STATS.WORK()).EMPLOYED.set(a, null);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected RoomArenaWork w(Humanoid a, AIManager d) {
/* 47 */     return g;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkGladiator$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */