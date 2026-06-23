/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.HPoll;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.stats.STATS;
/*    */ 
/*    */ abstract class PlanBlueprint
/*    */   extends PlanWork
/*    */ {
/*    */   protected final RoomBlueprintIns<?> blueprint;
/*    */   protected final AIModule_Work module;
/* 14 */   static int maxCarry = AIModule_Work.MAX_FETCH_AMOUNT;
/*    */   
/*    */   protected PlanBlueprint(AIModule_Work module, RoomBlueprintIns<?> blueprint, PlanBlueprint[] map) {
/* 17 */     this("work_" + blueprint.key, module, blueprint, map);
/*    */   }
/*    */   
/*    */   protected PlanBlueprint(String key, AIModule_Work module, RoomBlueprintIns<?> blueprint, PlanBlueprint[] map) {
/* 21 */     super(key);
/* 22 */     if (map[blueprint.index()] != null)
/* 23 */       throw new RuntimeException(); 
/* 24 */     map[blueprint.index()] = this;
/* 25 */     this.blueprint = blueprint;
/* 26 */     this.module = module;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldReportWorkFailure(Humanoid a, AIManager d) {
/* 37 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void cancel(Humanoid a, AIManager d) {
/* 43 */     super.cancel(a, d);
/* 44 */     if (work(a) != null && work(a).employees().isOverstaffed()) {
/* 45 */       (STATS.WORK()).EMPLOYED.set(a, null);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 52 */     if (e.type == HPoll.WORKING) {
/* 53 */       return 1.0D;
/*    */     }
/* 55 */     return super.poll(a, d, e);
/*    */   }
/*    */   
/*    */   protected double transportAmount(Humanoid a, AIManager d) {
/* 59 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanBlueprint.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */