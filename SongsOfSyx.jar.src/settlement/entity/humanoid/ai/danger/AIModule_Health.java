/*    */ package settlement.entity.humanoid.ai.danger;
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIModule;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ 
/*    */ final class AIModule_Health extends AIModule {
/* 14 */   private final PlanSick sick = new PlanSick("dangerSick");
/* 15 */   private final PlanInjured bleed = new PlanInjured("dangerInjured");
/* 16 */   private static CharSequence ¤¤name = "Recover";
/* 17 */   private static CharSequence ¤¤desc = "Recover from injuries or illness, either at home or at a hospital.";
/*    */   static {
/* 19 */     D.ts(AIModule_Health.class);
/*    */   }
/*    */   
/*    */   public AIModule_Health() {
/* 23 */     super((SPRITE)(UI.icons()).s.plus, ¤¤name, ¤¤desc);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/* 29 */     if ((STATS.WORK()).incap.stat.indu().get(a.indu()) == 0) {
/* 30 */       (STATS.WORK()).incap.stat.indu().set(a.indu(), 1);
/*    */     }
/* 32 */     if ((STATS.WORK()).EMPLOYED.get(a) != null && ((RoomInstance)(STATS.WORK()).EMPLOYED.get(a)).blueprintI() == (SETT.ROOMS()).HOSPITAL) {
/* 33 */       (STATS.WORK()).EMPLOYED.set(a, null);
/*    */     }
/*    */     
/* 36 */     if ((STATS.DISEASE().status(a.indu())).active) {
/* 37 */       return this.sick.activate(a, d);
/*    */     }
/* 39 */     if ((STATS.NEEDS()).INJURIES.inDanger(a.indu())) {
/* 40 */       return this.bleed.activate(a, d);
/*    */     }
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPriority(Humanoid a, AIManager d) {
/* 49 */     if ((STATS.DISEASE().status(a.indu())).active) {
/* 50 */       return 7;
/*    */     }
/*    */     
/* 53 */     if ((STATS.NEEDS()).INJURIES.inDanger(a.indu())) {
/* 54 */       return 7;
/*    */     }
/*    */     
/* 57 */     return 0;
/*    */   }
/*    */   
/*    */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\danger\AIModule_Health.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */