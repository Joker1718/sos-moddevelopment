/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ 
/*    */ final class WorkTransporter
/*    */   extends WorkAbs {
/*    */   protected WorkTransporter(AIModule_Work module, PlanBlueprint[] map, WorkAbs.Works w) {
/* 12 */     super("WorkTransportExtra", module, (RoomBlueprintIns<?>)(SETT.ROOMS()).TRANSPORT, map, w);
/* 13 */     map[(SETT.ROOMS()).TRANSPORT.index()] = null;
/* 14 */     this.deliveryman = new WorkDeliveryman(module, map, this.blueprint, false);
/* 15 */     map[(SETT.ROOMS()).TRANSPORT.index()] = this;
/*    */   }
/*    */ 
/*    */   
/*    */   private final WorkDeliveryman deliveryman;
/*    */   
/*    */   public AIPLAN.AiPlanActivation activate(Humanoid a, AIManager d) {
/* 22 */     AIPLAN.AiPlanActivation p = super.activate(a, d);
/* 23 */     if (p != null) {
/* 24 */       return p;
/*    */     }
/* 26 */     return this.deliveryman.activate(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkTransporter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */