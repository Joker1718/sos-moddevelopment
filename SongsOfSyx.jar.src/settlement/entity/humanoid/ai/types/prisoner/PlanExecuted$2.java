/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.room.law.execution.ExecutionStation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  75 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  79 */     ExecutionStation.Client s = PlanExecuted.this.s(d);
/*  80 */     s.clientUse();
/*  81 */     d.planByte1 = (byte)TIME.hours().bitCurrent();
/*  82 */     d.planByte2 = (byte)TIME.days().bitCurrent();
/*  83 */     return res(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  89 */     if (d.planByte2 != TIME.days().bitCurrent() && TIME.hours().bitCurrent() > d.planByte1) {
/*  90 */       PlanExecuted.this.walk.can(a, d);
/*  91 */       return null;
/*     */     } 
/*     */     
/*  94 */     if (!PlanExecuted.this.walk.con(a, d)) {
/*  95 */       PlanExecuted.this.walk.can(a, d);
/*  96 */       return null;
/*     */     } 
/*     */     
/*  99 */     ExecutionStation.Client s = PlanExecuted.this.s(d);
/* 100 */     a.speed.setDirCurrent(s.clientDir());
/*     */     
/* 102 */     int type = PlanExecuted.this.ss().type(d.planTile.x(), d.planTile.y());
/*     */     
/* 104 */     if (type == 1) {
/* 105 */       return (AI.SUBS()).LAY.activateTime(a, d, 1);
/*     */     }
/*     */     
/* 108 */     if (s.clientBeingExecuted()) {
/* 109 */       if (type == 2)
/* 110 */         return PlanExecuted.this.strangled.set(a, d); 
/* 111 */       if (type == 3)
/* 112 */         return PlanExecuted.this.gibbited.set(a, d); 
/* 113 */       if (type == 4)
/* 114 */         return PlanExecuted.this.crucified.set(a, d); 
/*     */     } 
/* 116 */     return (AI.SUBS()).STAND.activateTime(a, d, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 126 */     PlanExecuted.this.walk.can(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\PlanExecuted$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */