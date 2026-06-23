/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderSoldierManning;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 116 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 120 */     return (AI.SUBS()).STAND.activateTime(a, d, (int)(2.0F + RND.rFloat() * 2.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 125 */     if (!(AI.modules()).battle.moduleCanContinue(a, d)) {
/* 126 */       can(a, d);
/* 127 */       return null;
/*     */     } 
/* 129 */     SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/* 130 */     if (f == null) {
/* 131 */       return null;
/*     */     }
/* 133 */     if (f.needsWork())
/* 134 */       return ManPlan.this.work.set(a, d); 
/* 135 */     return (AI.SUBS()).STAND.activateTime(a, d, (int)(2.0F + RND.rFloat() * 2.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 145 */     SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/* 146 */     if (f != null) {
/* 147 */       f.findableReserveCancel();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 153 */     if (e.event == HEvent.CHECK_MORALE && 
/* 154 */       a.indu().army() == GAME.ARMIES().enemy() && GAME.ARMIES().enemy().morale() < 0.2D) {
/* 155 */       (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1);
/* 156 */       d.overwrite(a, (AI.modules()).battle.dessert);
/* 157 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 161 */     return super.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\ManPlan$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */