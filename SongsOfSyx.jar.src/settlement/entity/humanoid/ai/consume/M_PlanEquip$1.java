/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.equip.WearableResource;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends AIPlanResourceMany
/*     */ {
/*     */   null(AIPLAN.PLANRES $anonymous0, int $anonymous1) {
/*  82 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation next(Humanoid a, AIManager d) {
/*  86 */     RESOURCE res = d.resourceCarried();
/*  87 */     int am = d.resourceA();
/*  88 */     Induvidual i = a.indu();
/*     */     
/*  90 */     if (res == null || am <= 0) {
/*  91 */       return null;
/*     */     }
/*  93 */     for (WearableResource r : RACES.res().get(i.popCL(), res)) {
/*  94 */       r.wearOut(i);
/*  95 */       int dam = CLAMP.i(am, 0, r.needed(a.indu()));
/*  96 */       r.inc(i, dam);
/*  97 */       am -= dam;
/*  98 */       d.resourceAInc(-dam);
/*  99 */       if (am <= 0) {
/*     */         break;
/*     */       }
/*     */     } 
/* 103 */     if (AIModules.current(d).moduleCanContinue(a, d))
/* 104 */       return M_PlanEquip.this.init(a, d); 
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public void cancel(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\M_PlanEquip$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */