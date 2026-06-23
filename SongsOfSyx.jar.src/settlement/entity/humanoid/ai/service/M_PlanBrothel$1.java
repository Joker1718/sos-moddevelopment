/*    */ package settlement.entity.humanoid.ai.service;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 25 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 29 */     d.planByte2 = (byte)(25 + RND.rInt(10));
/* 30 */     d.planByte1 = 0;
/* 31 */     M_PlanBrothel.this.get(a, d).startUsing();
/* 32 */     return res(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 38 */     d.planByte2 = (byte)(d.planByte2 - 1);
/*    */     
/* 40 */     if (M_PlanBrothel.this.blue(d).clientShouldUndress(d.planTile.x(), d.planTile.y()) || d.planByte2 <= 0) {
/* 41 */       (STATS.POP()).NAKED.set(a.indu(), 1);
/* 42 */       if (d.planByte1 == 1) {
/* 43 */         M_PlanBrothel.this.blue(d).clientUndress(d.planTile.x(), d.planTile.y());
/* 44 */         return M_PlanBrothel.this.second.set(a, d);
/*    */       } 
/* 46 */       d.planByte1 = 1;
/*    */     } 
/*    */     
/* 49 */     return (AI.SUBS()).STAND.activateRndDir(a, d, 3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 55 */     FSERVICE fSERVICE = M_PlanBrothel.this.get(a, d);
/* 56 */     return (fSERVICE != null && fSERVICE.findableReservedIs());
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 61 */     (STATS.POP()).NAKED.set(a.indu(), 0);
/* 62 */     FSERVICE s = M_PlanBrothel.this.get(a, d);
/* 63 */     if (s != null && s.findableReservedIs())
/* 64 */       s.consume(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanBrothel$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */