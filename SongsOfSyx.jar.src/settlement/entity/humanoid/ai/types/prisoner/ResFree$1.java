/*    */ package settlement.entity.humanoid.ai.types.prisoner;
/*    */ 
/*    */ import init.type.CAUSE_ARRIVES;
/*    */ import init.type.CRIMES;
/*    */ import init.type.HCLASSES;
/*    */ import init.type.HTYPE;
/*    */ import init.type.HTYPES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.stats.STATS;
/*    */ 
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 19 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 23 */     return (AI.SUBS()).STAND.activateRndDir(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 28 */     HTYPE t = (((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu())).cl == HCLASSES.SLAVE()) ? HTYPES.SLAVE() : HTYPES.SUBJECT();
/* 29 */     a.HTypeSet(t, null, CAUSE_ARRIVES.PAROLE());
/* 30 */     (STATS.LAW()).EX_CON.indu().setD(a.indu(), 1.0D);
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\ResFree$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */