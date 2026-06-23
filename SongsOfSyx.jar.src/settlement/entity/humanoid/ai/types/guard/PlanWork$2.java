/*     */ package settlement.entity.humanoid.ai.types.guard;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.law.guard.GuardInstance;
/*     */ import settlement.stats.STATS;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/*  78 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  82 */     GuardInstance ins = PlanWork.work(a);
/*  83 */     a.speed.turn2(ins.guardDir(a.tc().x(), a.tc().y()));
/*  84 */     d.planByte1 = (byte)(2 + RND.rInt(5));
/*     */     
/*  86 */     if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) > 0.8D) {
/*  87 */       d.planByte2 = 1;
/*  88 */       can(a, d);
/*  89 */       d.planByte2 = 0;
/*     */     } else {
/*  91 */       d.planByte2 = 1;
/*     */     } 
/*  93 */     return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_SWORD.activate(a, d, (5 + RND.rInt(5))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 100 */     GuardInstance ins = PlanWork.work(a);
/*     */     
/* 102 */     if (!AIModules.current(d).moduleCanContinue(a, d) || (STATS.WORK()).WORK_TIME.indu().getD(a.indu()) > 1.0D) {
/* 103 */       can(a, d);
/* 104 */       return null;
/*     */     } 
/*     */     
/* 107 */     if (d.planByte2 == 0 && 
/* 108 */       SETT.ENTITIES().getAtTileSingle(a.tc().x(), a.tc().y()) instanceof Humanoid) {
/* 109 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 114 */     Humanoid c = (SETT.ROOMS()).GUARD.reporter.pollCriminal(ins);
/*     */     
/* 116 */     if (c != null) {
/* 117 */       can(a, d);
/* 118 */       return d.resumeOtherPlan(a, AI.listeners().catchCriminal(c));
/*     */     } 
/*     */     
/* 121 */     d.planByte1 = (byte)(d.planByte1 - 1);
/*     */     
/* 123 */     if (d.planByte1 <= 0) {
/* 124 */       can(a, d);
/* 125 */       if ((SETT.ROOMS()).GUARD.instancesSize() > 1 && RND.oneIn(10) && (STATS.WORK()).WORK_TIME.indu().get(a.indu()) <= 0.5D)
/* 126 */         return PlanWork.this.patrol.set(a, d); 
/* 127 */       return null;
/*     */     } 
/* 129 */     a.speed.turn2(ins.guardDir(a.tc().x(), a.tc().y()));
/* 130 */     return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_SWORD.activate(a, d, (15 + RND.rInt(5))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 136 */     return (PlanWork.work(a) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 141 */     if (d.planByte2 == 1) {
/* 142 */       GuardInstance ins = PlanWork.work(a);
/* 143 */       if (ins != null)
/* 144 */         ins.guardSpotReturn(d.planTile.x(), d.planTile.y()); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\PlanWork$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */