/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIModules;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
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
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 65 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 69 */     SETT.ENTITIES().moveIntoTheTheUnknown((ENTITY)a);
/* 70 */     a.speed.magnitudeInit(0.0D);
/* 71 */     return (AI.SUBS()).STAND.activate(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 76 */     if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) > 0.9D) {
/* 77 */       can(a, d);
/* 78 */       return null;
/*    */     } 
/* 80 */     if (AIModules.nextPrio(d) > 7) {
/* 81 */       can(a, d);
/* 82 */       return null;
/*    */     } 
/* 84 */     return (AI.SUBS()).STAND.activate(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 89 */     SETT.ENTITIES().returnFromTheTheUnknown((ENTITY)a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkEmissary$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */