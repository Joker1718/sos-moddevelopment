/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import init.type.NEED;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.stats.service.StatService;
/*    */ 
/*    */ abstract class S_Plan
/*    */ {
/*    */   public final StatService service;
/*    */   public final NEED need;
/*    */   public final double usage;
/*    */   
/*    */   S_Plan(StatService service, double usage) {
/* 16 */     this.need = service.need;
/* 17 */     this.service = service;
/* 18 */     this.usage = usage;
/*    */   }
/*    */   
/*    */   public abstract boolean hasAccess(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */   
/*    */   public abstract boolean allowed(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */   
/*    */   public abstract boolean goodTime(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */   
/*    */   public abstract AIPLAN.AiPlanActivation getPlan(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */   
/*    */   public abstract AIPLAN.AiPlanActivation getPlan(Humanoid paramHumanoid, AIManager paramAIManager, int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\S_Plan.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */