/*    */ package settlement.entity.humanoid.ai.util;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.battle.SubFight;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
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
/*    */   extends SubFight
/*    */ {
/*    */   null(String $anonymous0) {
/* 52 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 56 */     if (!AIPlanGladiator.this.shouldFight(a, d))
/* 57 */       return null; 
/* 58 */     if (!AIPlanGladiator.this.isFighter((ENTITY)d.otherEntity()))
/* 59 */       return null; 
/* 60 */     return super.resume(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 65 */     if (AIPlanGladiator.this.isFighter(e.other) && (
/* 66 */       e.event == HEvent.MEET_HARMLESS || e.event == HEvent.COLLISION_SOFT)) {
/* 67 */       e.event = HEvent.MEET_ENEMY;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 73 */     return super.event(a, d, e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void attack(Humanoid a, AIManager d, Humanoid enemy) {
/* 78 */     (AI.modules()).battle.soundSword.rnd(a);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\a\\util\AIPlanGladiator$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */