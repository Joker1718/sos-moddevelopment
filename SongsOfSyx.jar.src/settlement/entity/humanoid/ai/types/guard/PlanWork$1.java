/*    */ package settlement.entity.humanoid.ai.types.guard;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.law.guard.GuardInstance;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.COORDINATEE;
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
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 37 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 41 */     GuardInstance ins = PlanWork.work(a);
/*    */     
/* 43 */     if (!ins.guardSpot((COORDINATEE)d.planTile, a.tc())) {
/* 44 */       return null;
/*    */     }
/*    */     
/* 47 */     if (d.planTile.isSameAs(a.tc())) {
/* 48 */       return PlanWork.this.guard.set(a, d);
/*    */     }
/* 50 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*    */     
/* 52 */     if (s == null) {
/* 53 */       ins.guardSpotReturn(d.planTile.x(), d.planTile.y());
/*    */     }
/* 55 */     return s;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 60 */     return PlanWork.this.guard.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 65 */     return (PlanWork.work(a) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 70 */     GuardInstance ins = PlanWork.work(a);
/* 71 */     if (ins != null)
/* 72 */       ins.guardSpotReturn(d.planTile.x(), d.planTile.y()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\PlanWork$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */