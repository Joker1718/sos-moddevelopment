/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 57 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 61 */     if (RND.rBoolean())
/* 62 */       return (AI.SUBS()).STAND.activate(a, d, (AI.STATES()).anima.wave.activate(a, d, 2.0D)); 
/* 63 */     return (AI.SUBS()).STAND.activateRndDir(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 68 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 73 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanHangArround$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */