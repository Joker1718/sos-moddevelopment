/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.misc.util.FSERVICE;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 25 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 29 */     M_PlanCourt.this.get(a, d).startUsing();
/* 30 */     d.planByte1 = (byte)(4 + RND.rInt(8));
/* 31 */     return (AI.SUBS()).STAND.activate(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 37 */     d.planByte1 = (byte)(d.planByte1 - 1);
/* 38 */     if (d.planByte1 >= 0) {
/* 39 */       return (AI.SUBS()).STAND.activateRndDir(a, d);
/*    */     }
/*    */     
/* 42 */     FSERVICE s = M_PlanCourt.this.get(a, d);
/* 43 */     if (s != null)
/* 44 */       s.consume(); 
/* 45 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 50 */     FSERVICE fSERVICE = M_PlanCourt.this.get(a, d);
/* 51 */     return (fSERVICE != null && fSERVICE.findableReservedIs());
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 56 */     FSERVICE fSERVICE = M_PlanCourt.this.get(a, d);
/* 57 */     if (fSERVICE != null)
/* 58 */       fSERVICE.findableReserveCancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanCourt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */