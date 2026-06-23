/*     */ package settlement.entity.humanoid.ai.types.recruit;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.rnd.RND;
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
/*     */   extends PlanBarracks.Res
/*     */ {
/*     */   private final AISUB.Simple sub;
/*     */   
/*     */   null(PlanBarracks paramPlanBarracks2) {
/* 118 */     this.sub = new AISUB.Simple("Barracksfight")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d) {
/* 121 */           d.subByte = (byte)(d.subByte + 1);
/* 122 */           if (PlanBarracks.null.access$0(PlanBarracks.null.this).job(a, d) == null)
/* 123 */             return null; 
/* 124 */           if (d.subByte == 1)
/* 125 */             return (AI.STATES()).anima.sword_out.activate(a, d); 
/* 126 */           if (d.subByte == 2) {
/* 127 */             PlanBarracks.null.access$0(PlanBarracks.null.this).job(a, d).jobSound().rnd(a);
/* 128 */             return (AI.STATES()).anima.sword_in.activate(a, d);
/*     */           } 
/*     */           
/* 131 */           return null;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 137 */     SETT_JOB j = PlanBarracks.this.job(a, d);
/* 138 */     j.jobStartPerforming();
/* 139 */     return this.sub.activate(a, d, (AI.STATES()).anima.sword.activate(a, d, (5.0F + RND.rFloat(5.0D))));
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 144 */     if (PlanBarracks.this.job(a, d) == null)
/* 145 */       return null; 
/* 146 */     if (!PlanBarracks.this.module.planShouldContinue(a, d)) {
/* 147 */       can(a, d);
/* 148 */       return null;
/*     */     } 
/*     */     
/* 151 */     return this.sub.activate(a, d, (AI.STATES()).anima.sword.activate(a, d, (5.0F + RND.rFloat(5.0D))));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\recruit\PlanBarracks$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */