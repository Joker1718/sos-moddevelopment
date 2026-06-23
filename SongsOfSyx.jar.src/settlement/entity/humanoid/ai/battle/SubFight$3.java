/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends SubFight.ResumerB
/*     */ {
/*     */   null(SubFight paramSubFight2) {}
/*     */   
/*     */   public AISTATE setAction(Humanoid a, AIManager d) {
/* 137 */     if (d.otherEntity() == null)
/* 138 */       return SubFight.this.exit.set(a, d); 
/* 139 */     a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/* 140 */     return (AI.STATES()).SWORD.STOP_SWORD.activate(a, d, 0.1D + BattleUtil.getAttackPause(a, d) * 5.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE res(Humanoid a, AIManager d) {
/* 145 */     Humanoid ene = d.otherEntity();
/*     */     
/* 147 */     AIPLAN p = (AI.modules()).battle.escape.plan(a, d);
/* 148 */     if (p != null) {
/* 149 */       return d.resumeOtherPlanState(a, p);
/*     */     }
/* 151 */     AISTATE s = SubFight.this.escape.set(a, d);
/* 152 */     if (s != null) {
/* 153 */       return s;
/*     */     }
/* 155 */     if (ene == null || ene.isRemoved()) {
/* 156 */       return SubFight.this.exit.set(a, d);
/*     */     }
/*     */     
/* 159 */     int dist = a.body().getDistance(ene.body());
/* 160 */     if (dist > 640)
/* 161 */       return SubFight.this.exit.set(a, d); 
/* 162 */     if (dist <= (a.body().width() + ene.body().width()) / 2 - 6)
/* 163 */       return SubFight.this.backup.set(a, d); 
/* 164 */     if (dist > 256)
/* 165 */       return SubFight.this.charge.set(a, d); 
/* 166 */     if (dist > (a.body().width() + a.body().width()) / 2 + 8) {
/* 167 */       return SubFight.this.move_closer.set(a, d);
/*     */     }
/* 169 */     return SubFight.this.strike.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\SubFight$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */