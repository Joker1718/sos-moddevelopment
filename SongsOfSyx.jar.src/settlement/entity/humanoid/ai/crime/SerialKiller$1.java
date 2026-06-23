/*    */ package settlement.entity.humanoid.ai.crime;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.finders.SFinderRND;
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
/* 44 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 49 */     if (SerialKiller.this.isVictim((ENTITY)d.otherEntity())) {
/* 50 */       return SerialKiller.this.leave.set(a, d);
/*    */     }
/*    */     
/* 53 */     d.planByte1 = (byte)(d.planByte1 + 1); if (d.planByte1 > 8) {
/* 54 */       return null;
/*    */     }
/* 56 */     if ((SETT.PATH().finders()).randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 64, SFinderRND.otherPeople)) {
/* 57 */       return (AI.SUBS()).walkTo.pathFull(a, d);
/*    */     }
/* 59 */     return SerialKiller.this.stand.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 64 */     return SerialKiller.this.stand.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 69 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\SerialKiller$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */