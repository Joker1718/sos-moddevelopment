/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.ENTITY;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 140 */     this.state = (AI.STATES()).SWORD.strikeIn;
/* 141 */     this.time = (float)HSprites.SWORD_IN.time;
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE setAction(Humanoid a, AIManager d) {
/* 146 */     if (d.otherEntity() != null) {
/* 147 */       int dist = a.body().getDistance(d.otherEntity().body());
/* 148 */       if (dist <= (a.body().width() + d.otherEntity().body().width()) / 2 + 24) {
/* 149 */         Humanoid enemy = d.otherEntity();
/* 150 */         (GAME.battle()).fight.attack(a, (ENTITY)enemy);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 156 */     a.spriteTimer = 0.0F;
/* 157 */     d.stateTimer = this.time;
/* 158 */     a.speed.magnitudeTargetSet(0.0D);
/*     */     
/* 160 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE res(Humanoid a, AIManager d) {
/* 167 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchSoftCollision$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */