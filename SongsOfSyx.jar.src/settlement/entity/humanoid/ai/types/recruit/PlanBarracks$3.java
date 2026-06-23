/*     */ package settlement.entity.humanoid.ai.types.recruit;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(PlanBarracks paramPlanBarracks2) {}
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  98 */     COORDINATE man = PlanBarracks.this.blue(a).faceCoo(d.planTile.x(), d.planTile.y());
/*  99 */     DIR dir = DIR.get((COORDINATE)d.planTile, man);
/* 100 */     AISTATE s = (AI.STATES()).WALK2.edge(a, d, dir);
/* 101 */     a.speed.setDirCurrent(dir);
/* 102 */     return (AI.SUBS()).DUMMY.activate(a, d, s);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 107 */     if (PlanBarracks.this.job(a, d) == null)
/* 108 */       return null; 
/* 109 */     a.speed.magnitudeTargetSet(0.0D);
/* 110 */     a.speed.magnitudeInit(0.0D);
/* 111 */     return PlanBarracks.this.fight.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\recruit\PlanBarracks$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */