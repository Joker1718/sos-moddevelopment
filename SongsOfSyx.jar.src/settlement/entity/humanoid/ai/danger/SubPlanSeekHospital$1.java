/*    */ package settlement.entity.humanoid.ai.danger;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
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
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 36 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 40 */     d.planByte1 = (byte)(4 + RND.rInt(4));
/* 41 */     double liveChance = SubPlanSeekHospital.this.b.recoverRate(d.planTile.x(), d.planTile.y());
/* 42 */     if ((STATS.NEEDS()).INJURIES.inDanger(a.indu()) && 
/* 43 */       !(STATS.NEEDS()).INJURIES.willDie(a.indu(), liveChance)) {
/* 44 */       (STATS.NEEDS()).INJURIES.setNonDanger(a.indu());
/*    */     }
/*    */ 
/*    */     
/* 48 */     return (AI.SUBS()).LAY.activateTime(a, d, 15);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 53 */     FSERVICE s = SubPlanSeekHospital.this.b.service().service(d.planTile.x(), d.planTile.y());
/* 54 */     if (s == null) {
/* 55 */       return null;
/*    */     }
/* 57 */     SubPlanSeekHospital.this.sound.rnd(a);
/* 58 */     double liveChance = SubPlanSeekHospital.this.b.recoverRate(d.planTile.x(), d.planTile.y());
/*    */     
/* 60 */     if ((STATS.DISEASE().status(a.indu())).active && !STATS.DISEASE().diseaseIsDone(a, liveChance))
/* 61 */       return (AI.SUBS()).LAY.activateTime(a, d, 60); 
/* 62 */     return SubPlanSeekHospital.this.fix(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 68 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 73 */     FSERVICE s = SubPlanSeekHospital.this.b.service().service(d.planTile.x(), d.planTile.y());
/* 74 */     if (s != null && s.findableReservedIs())
/* 75 */       s.consume(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\danger\SubPlanSeekHospital$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */