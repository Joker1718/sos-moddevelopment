/*    */ package settlement.entity.humanoid.ai.idle;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.HPoll;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIModules;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
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
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 66 */     d.planByte1 = (byte)(10 + RND.rInt(10));
/*    */     
/* 68 */     if ((SETT.PATH()).finders.getOutofWay.shouldFind((ENTITY)a)) {
/* 69 */       (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/* 70 */       return PlanInterract.null.this.walking.set(a, d);
/*    */     } 
/*    */     
/* 73 */     return res(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 78 */     d.planByte1 = (byte)(d.planByte1 - 1); if (AIModules.current(d).moduleCanContinue(a, d) && d.planByte1 > 0) {
/* 79 */       (AI.SUBS()).STAND.activateRndDir(a, d);
/*    */     }
/* 81 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 86 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 96 */     if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/* 97 */       return 1.0D; 
/* 98 */     return super.poll(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\PlanInterract$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */