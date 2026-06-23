/*    */ package settlement.entity.humanoid.ai.crime;
/*    */ 
/*    */ import init.type.CRIMES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 34 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 38 */     Flasher.this.m.commitCrime(a, d, true, (CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu()));
/* 39 */     (STATS.POP()).NAKED.set(a.indu(), 1);
/* 40 */     return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 48 */     if (!RND.oneIn(4)) {
/* 49 */       (STATS.POP()).NAKED.set(a.indu(), 0);
/* 50 */       return null;
/*    */     } 
/*    */     
/* 53 */     AIModule_Crime.notify(a);
/* 54 */     return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 60 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\Flasher$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */