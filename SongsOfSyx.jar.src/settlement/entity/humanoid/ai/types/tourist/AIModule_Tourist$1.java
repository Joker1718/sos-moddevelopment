/*     */ package settlement.entity.humanoid.ai.types.tourist;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanWalkPath;
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
/*     */   extends AIPlanWalkPath
/*     */ {
/*     */   final AIPLAN.PLANRES.Resumer res;
/*     */   
/*     */   null(String $anonymous0, CharSequence $anonymous1) {
/* 151 */     super($anonymous0, $anonymous1);
/* 152 */     this.res = new AIPLAN.PLANRES.Resumer((AIPLAN.PLANRES)this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 156 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 162 */           AIModule_Tourist.service(d).startUsing();
/* 163 */           (AIModules.data()).byte1.orSet(d, 1);
/*     */           
/* 165 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 170 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation next(Humanoid a, AIManager d) {
/* 181 */     return this.res.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 186 */     return (AIModule_Tourist.service(d) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/* 191 */     AIModule_Tourist.consume(d);
/* 192 */     super.cancel(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\tourist\AIModule_Tourist$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */