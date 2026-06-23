/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ 
/*    */ final class WorkTransporterSupply
/*    */   extends WorkAbs {
/*    */   protected WorkTransporterSupply(AIModule_Work module, PlanBlueprint[] map, WorkAbs.Works w) {
/* 12 */     super("WorkTransportSupplyExtra", module, (RoomBlueprintIns<?>)(SETT.ROOMS()).SUPPLY, map, w);
/* 13 */     map[this.blueprint.index()] = null;
/* 14 */     this.deliveryman = new WorkDeliveryman(module, map, this.blueprint, false);
/*    */     
/* 16 */     map[this.blueprint.index()] = this;
/*    */   }
/*    */ 
/*    */   
/*    */   private final WorkDeliveryman deliveryman;
/*    */ 
/*    */   
/*    */   public AIPLAN.AiPlanActivation activate(Humanoid a, AIManager d) {
/* 24 */     AIPLAN.AiPlanActivation p = this.deliveryman.activate(a, d);
/* 25 */     if (p != null) {
/* 26 */       return p;
/*    */     }
/* 28 */     return super.activate(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkTransporterSupply.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */