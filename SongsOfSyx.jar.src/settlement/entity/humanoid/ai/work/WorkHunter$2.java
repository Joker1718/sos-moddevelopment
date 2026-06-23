/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES) {
/* 100 */     super(paramPLANRES);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 104 */     if ((SETT.PATH()).finders.entryPoints.any(a.tc().x(), a.tc().y(), d.path, 2147483647)) {
/* 105 */       WorkHunter.this.b.reportSkill(WorkHunter.work(a), a);
/* 106 */       return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */     } 
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 113 */     return WorkHunter.this.hunt.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 118 */     WorkHunter.this.b.workFinish((COORDINATE)d.planTile);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 123 */     return (WorkHunter.work(a) != null && WorkHunter.work(a).blueprint() == WorkHunter.this.b);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkHunter$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */