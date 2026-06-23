/*    */ package settlement.entity.humanoid.ai.battle;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
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
/*    */   extends MarchSoftCollision.ResumerB
/*    */ {
/*    */   null(MarchSoftCollision paramMarchSoftCollision2) {}
/*    */   
/*    */   protected AISTATE setAction(Humanoid a, AIManager d) {
/* 81 */     d.subPathByte = (short)(d.subPathByte - 1);
/* 82 */     return (AI.STATES()).PUSH_TO.move(a, d, (a.division()).reporter.getPixel(a).x(), (a.division()).reporter.getPixel(a).y(), 1.0D, 0.75D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected AISTATE res(Humanoid a, AIManager d) {
/* 88 */     if (d.subPathByte < 0 && d.subByte >= 0) {
/* 89 */       AIPLAN p = (AI.modules()).battle.escape.plan(a, d);
/* 90 */       if (p != null) {
/* 91 */         return d.resumeOtherPlanState(a, p);
/*    */       }
/*    */     } 
/* 94 */     return MarchSoftCollision.this.strike.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchSoftCollision$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */