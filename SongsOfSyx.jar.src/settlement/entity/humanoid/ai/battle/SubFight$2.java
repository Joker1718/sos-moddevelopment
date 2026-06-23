/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
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
/*     */ class null
/*     */   extends SubFight.ResumerB
/*     */ {
/*     */   null(SubFight paramSubFight2) {}
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 114 */     if (e.type == HPoll.IMPACT_DAMAGE)
/* 115 */       return 0.0D; 
/* 116 */     return super.poll(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE setAction(Humanoid a, AIManager d) {
/* 121 */     if (d.otherEntity() != null)
/* 122 */       a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body())); 
/* 123 */     return (AI.STATES()).STAND.activate(a, d, 0.1D + BattleUtil.getAttackPause(a, d) * 5.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE res(Humanoid a, AIManager d) {
/* 128 */     return SubFight.this.beBraced.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\SubFight$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */