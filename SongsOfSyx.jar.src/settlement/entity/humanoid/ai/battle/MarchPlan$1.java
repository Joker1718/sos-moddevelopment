/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 103 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 107 */     d.planByte1 = 0;
/* 108 */     return res(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 113 */     if (!should(a, d))
/* 114 */       return null; 
/* 115 */     Div div = a.division();
/* 116 */     if (div.deployed() == 0) {
/* 117 */       d.planByte1 = (byte)(d.planByte1 + 1); if (d.planByte1 > 8)
/* 118 */         return null; 
/* 119 */       return (AI.SUBS()).single.activate(a, d, MarchPlan.this.stand.activate(a, d, 0.5D));
/*     */     } 
/*     */     
/* 122 */     AISUB.AISubActivation s = MarchPlan.this.retry2(a, d);
/*     */     
/* 124 */     if (s == null) {
/* 125 */       div.reporter.reportReachable(a, false);
/* 126 */       d.planByte1 = (byte)(d.planByte1 + 1); if (d.planByte1 > 8)
/* 127 */         return null; 
/* 128 */       return (AI.SUBS()).single.activate(a, d, MarchPlan.this.stand.activate(a, d, 0.5D));
/*     */     } 
/* 130 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 135 */     Div div = a.division();
/* 136 */     if (div == null || !div.settings().mustering()) {
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     if (!(AI.modules()).battle.moduleCanContinue(a, d)) {
/* 141 */       return false;
/*     */     }
/* 143 */     return true;
/*     */   }
/*     */   
/*     */   private boolean should(Humanoid a, AIManager d) {
/* 147 */     Div div = a.division();
/* 148 */     if (div == null || !div.settings().mustering()) {
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     if (!(AI.modules()).battle.moduleCanContinue(a, d)) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchPlan$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */