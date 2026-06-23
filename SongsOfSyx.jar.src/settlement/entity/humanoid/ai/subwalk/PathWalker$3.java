/*     */ package settlement.entity.humanoid.ai.subwalk;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends AISUB.Resumable.Resumer
/*     */ {
/*     */   null(AISUB.Resumable paramResumable) {
/* 138 */     super(paramResumable);
/*     */   }
/*     */   
/*     */   public AISTATE res(Humanoid a, AIManager d) {
/* 142 */     if (PathWalker.this.hasFailed(a, d) || !d.path.isSuccessful()) {
/* 143 */       return PathWalker.this.failure.set(a, d);
/*     */     }
/* 145 */     PathWalker.this.arrive(a, d);
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean success(Humanoid a, AIManager d) {
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE setAction(Humanoid a, AIManager d) {
/* 156 */     a.speed.magnitudeInit(0.0D);
/* 157 */     return (AI.STATES()).STAND.activate(a, d, 0.5D);
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 161 */     PathWalker.this.abort(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subwalk\PathWalker$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */