/*     */ package settlement.entity.humanoid.ai.crime;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderRND;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.rnd.RND;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 110 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 114 */     if ((SETT.PATH().finders()).randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 64, SFinderRND.noPeople)) {
/* 115 */       return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */     }
/* 117 */     return (AI.SUBS()).STAND.activateRndDir(a, d, 2 + RND.rInt(4));
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 122 */     if (!SerialKiller.this.isVictim((ENTITY)d.otherEntity())) {
/* 123 */       return null;
/*     */     }
/* 125 */     if (VIEW.s().getWindow().zoomout() <= 1 && VIEW.s().getWindow().pixels().touches((BODY_HOLDER)d.otherEntity())) {
/* 126 */       return null;
/*     */     }
/* 128 */     Humanoid v = d.otherEntity();
/* 129 */     int tx = v.tc().x();
/* 130 */     int ty = v.tc().y();
/* 131 */     v.kill(false, CAUSE_LEAVES.MURDER());
/* 132 */     ThingsCorpses.Corpse c = (ThingsCorpses.Corpse)(SETT.THINGS()).corpses.tGet.get(tx, ty);
/* 133 */     if (c != null)
/* 134 */       (GAME.events()).killer.reportKill(c); 
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\SerialKiller$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */