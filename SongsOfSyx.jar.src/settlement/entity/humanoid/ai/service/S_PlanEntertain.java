/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import init.type.HCLASS_RACE;
/*    */ import init.type.NEED;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.room.service.module.RoomServiceNeed;
/*    */ import settlement.stats.service.StatService;
/*    */ 
/*    */ final class S_PlanEntertain extends S_Plan {
/*    */   private final RoomServiceNeed.ROOM_SERVICE_NEED_HASER sh;
/*    */   private final M_PlanSpectator plan;
/*    */   
/*    */   S_PlanEntertain(NEED need, RoomServiceNeed.ROOM_SERVICE_NEED_HASER sh, M_PlanSpectator plan) {
/* 16 */     super((StatService)sh.service().stats(), (sh.service()).usage);
/* 17 */     this.sh = sh;
/* 18 */     this.plan = plan;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasAccess(Humanoid a, AIManager d) {
/* 23 */     return this.sh.service().stats().access(a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean allowed(Humanoid a, AIManager d) {
/* 28 */     return this.sh.service().stats().permission().is(HCLASS_RACE.clP(a.indu()));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean goodTime(Humanoid a, AIManager d) {
/* 33 */     return this.sh.service().isGoodTime();
/*    */   }
/*    */ 
/*    */   
/*    */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/* 38 */     return getPlan(a, d, this.sh.service().radius());
/*    */   }
/*    */ 
/*    */   
/*    */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d, int dist) {
/* 43 */     d.planByte3 = (byte)this.sh.service().room().typeIndex();
/* 44 */     MPlan.dist = dist;
/* 45 */     return this.plan.activate(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\S_PlanEntertain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */