/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DIV_FORMATION;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.battle.util.Copyable;
/*     */ import init.constant.Config;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Strategos2000UpdaterOffense.State
/*     */ {
/*     */   private final BattleOrderTask task;
/*     */   
/*     */   null(String $anonymous0) {
/* 122 */     super($anonymous0);
/*     */     
/* 124 */     this.task = new BattleOrderTask();
/*     */   }
/*     */   
/*     */   public boolean is() {
/* 128 */     Strategos2000UpdaterOffense.this.c.deployedToLine.clear();
/*     */     
/* 130 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 131 */       Div d = (Div)Strategos2000UpdaterOffense.this.u.getArmy().divisions().get(di);
/* 132 */       if (d.active() && d.settings().ammo() != null && BattleTrajectories.trajectories(d) > d.men() / 2) {
/* 133 */         (d.settings()).fireAtWill = true;
/* 134 */         (d.settings()).formation = DIV_FORMATION.LOOSE;
/* 135 */         this.task.stop(d);
/* 136 */         (d.order()).task.set((Copyable)this.task);
/* 137 */         Strategos2000UpdaterOffense.this.c.deployedToLine.set(di, true);
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\Strategos2000UpdaterOffense$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */