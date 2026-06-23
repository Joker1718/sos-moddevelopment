/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  72 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  76 */     a.speed.setDirCurrent(a.speed.dir().perpendicular());
/*  77 */     d.planByte1 = (byte)a.speed.dir().id();
/*  78 */     return (AI.SUBS()).STAND.activateTime(a, d, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  85 */     if (!WorkHooker.this.module.moduleCanContinue(a, d) || !WorkHooker.this.hasEmployment(a, d) || (STATS.WORK()).WORK_TIME.indu().getD(a.indu()) == 1.0D) {
/*  86 */       can(a, d);
/*  87 */       return null;
/*     */     } 
/*     */     
/*  90 */     if (WorkHooker.this.b.workerReadyShouldUndress(d.planTile.x(), d.planTile.y())) {
/*  91 */       (STATS.POP()).NAKED.set(a.indu(), 1);
/*     */     } else {
/*  93 */       (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */     } 
/*     */     
/*  96 */     if (RND.oneIn(10)) {
/*  97 */       a.speed.setDirCurrent(((DIR)DIR.ALL.get(d.planByte1)).next(-1).next(RND.rInt(3)));
/*     */     }
/*     */     
/* 100 */     return (AI.SUBS()).STAND.activateTime(a, d, 4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 106 */     return WorkHooker.this.walk.con(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 111 */     SETT_JOB j = WorkHooker.this.jobGet(a, d);
/* 112 */     if (j != null)
/* 113 */       j.jobPerform(a, null, 0); 
/* 114 */     (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 119 */     if (WorkHooker.this.b.workerReadyShouldUndress(d.planTile.x(), d.planTile.y())) {
/* 120 */       super.name(a, d, string);
/*     */     } else {
/* 122 */       string.add(WorkHooker.¤¤waiting);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkHooker$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */