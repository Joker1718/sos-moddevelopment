/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends MarchSoftCollision.ResumerB
/*     */ {
/*     */   private final AISTATE state;
/*     */   private final float time;
/*     */   
/*     */   null(MarchSoftCollision paramMarchSoftCollision2) {
/* 117 */     this.state = (AI.STATES()).SWORD.strike;
/* 118 */     this.time = (float)HSprites.SWORD_OUT.time;
/*     */   }
/*     */   
/*     */   public AISTATE setAction(Humanoid a, AIManager d) {
/* 122 */     a.spriteTimer = 0.0F;
/* 123 */     d.stateTimer = this.time;
/* 124 */     a.speed.magnitudeTargetSet(0.0D);
/*     */ 
/*     */ 
/*     */     
/* 128 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE res(Humanoid a, AIManager d) {
/* 133 */     return MarchSoftCollision.this.strike2.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchSoftCollision$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */