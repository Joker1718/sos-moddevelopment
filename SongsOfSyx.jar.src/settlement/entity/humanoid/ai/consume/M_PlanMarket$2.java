/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.service.market.ROOM_MARKET;
/*    */ import settlement.stats.equip.WearableResource;
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
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 54 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 59 */     return (AI.SUBS()).STAND.activateRndDir(a, d, 5);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 64 */     ROOM_MARKET m = M_PlanMarket.this.blue(d);
/* 65 */     if (m == null || !m.is(a.tc())) {
/* 66 */       return d.resumeOtherPlan(a, (AIPLAN)M_PlanMarket.this.mm.ground);
/*    */     }
/* 68 */     boolean bought = false;
/*    */     
/* 70 */     for (WearableResource e : RACES.res().all(a.indu().popCL())) {
/* 71 */       int needed = e.needed(a.indu());
/* 72 */       if (needed > 0) {
/* 73 */         int am = m.buy(RACES.res().get(e.resource(a.indu())), needed, a.tc().x(), a.tc().y());
/* 74 */         if (am > 0) {
/* 75 */           bought = true;
/* 76 */           e.wearOut(a.indu());
/* 77 */           e.inc(a.indu(), am);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 82 */     d.planByte1 = (byte)(d.planByte1 - 1);
/* 83 */     if (bought || d.planByte1 > 0) {
/* 84 */       return M_PlanMarket.this.walk.set(a, d);
/*    */     }
/* 86 */     return d.resumeOtherPlan(a, (AIPLAN)M_PlanMarket.this.mm.ground);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 91 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\M_PlanMarket$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */