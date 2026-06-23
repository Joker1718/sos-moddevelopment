/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.stats.STATS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  77 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  86 */     if (!WorkPolice.this.reserved(d)) {
/*  87 */       can(a, d);
/*  88 */       return null;
/*     */     } 
/*     */ 
/*     */     
/*  92 */     if ((AI.SUBS()).walkTo.followSucess(a, d))
/*  93 */       return WorkPolice.this.knockSuspect.set(a, d); 
/*  94 */     if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) < 0.5D) {
/*  95 */       AISUB.AISubActivation s = (AI.SUBS()).walkTo.follow(a, d, (ENTITY)WorkPolice.this.victim(d), false, (byte)20);
/*  96 */       if (s != null) {
/*  97 */         return s;
/*     */       }
/*     */     } 
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 110 */     SETT_JOB j = WorkPolice.this.work(d);
/* 111 */     if (j != null && j.jobReservedIs(null)) {
/* 112 */       j.jobReserveCancel(null);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 117 */     if (e.event == HEvent.MEET_HARMLESS && 
/* 118 */       e.other == WorkPolice.this.victim(d)) {
/* 119 */       d.overwrite(a, WorkPolice.this.knockSuspect.set(a, d));
/*     */       
/* 121 */       return true;
/*     */     } 
/*     */     
/* 124 */     return super.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkPolice$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */