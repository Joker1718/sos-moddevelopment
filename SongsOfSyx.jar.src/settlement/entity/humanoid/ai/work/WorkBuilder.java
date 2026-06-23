/*    */ package settlement.entity.humanoid.ai.work;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.job.ROOM_RADIUS;
/*    */ 
/*    */ final class WorkBuilder extends PlanBlueprint {
/*    */   protected WorkBuilder(AIModule_Work module, PlanBlueprint[] map) {
/* 14 */     super(module, (RoomBlueprintIns<?>)(SETT.ROOMS()).BUILDER, map);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AIPLAN.AiPlanActivation activate(Humanoid a, AIManager d) {
/* 20 */     RoomInstance i = work(a);
/* 21 */     ROOM_RADIUS.ROOM_RADIUS_INSTANCE r = (ROOM_RADIUS.ROOM_RADIUS_INSTANCE)i;
/* 22 */     if (!r.searching()) {
/* 23 */       return null;
/*    */     }
/*    */     
/* 26 */     int sx = i.body().cX();
/* 27 */     int sy = i.body().cY();
/*    */     
/* 29 */     return (AI.modules()).work.oddjobber.activateWorker(a, d, sx, sy, r.radius());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/* 35 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldReportWorkFailure(Humanoid a, AIManager d) {
/* 40 */     return (d.plan() != (AI.modules()).work.oddjobber);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkBuilder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */