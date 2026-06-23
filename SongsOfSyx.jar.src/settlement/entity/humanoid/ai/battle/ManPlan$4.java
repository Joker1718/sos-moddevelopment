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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 165 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 169 */     return (AI.SUBS()).WORK_HANDS.activate(a, d, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 174 */     SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/* 175 */     if (f == null)
/* 176 */       return null; 
/* 177 */     f.work(5.0D, a);
/* 178 */     if (!(AI.modules()).battle.moduleCanContinue(a, d)) {
/* 179 */       can(a, d);
/* 180 */       return null;
/*     */     } 
/* 182 */     if (a.division() != null && a.division().settings().mustering()) {
/* 183 */       can(a, d);
/* 184 */       return null;
/*     */     } 
/* 186 */     return ManPlan.this.stand.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 191 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 196 */     SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/* 197 */     if (f != null) {
/* 198 */       f.findableReserveCancel();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 204 */     if (e.event == HEvent.CHECK_MORALE && 
/* 205 */       a.indu().army() == GAME.ARMIES().enemy() && GAME.ARMIES().enemy().morale() < 0.2D) {
/* 206 */       (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1);
/* 207 */       d.overwrite(a, (AI.modules()).battle.dessert);
/* 208 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 212 */     return super.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\ManPlan$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */