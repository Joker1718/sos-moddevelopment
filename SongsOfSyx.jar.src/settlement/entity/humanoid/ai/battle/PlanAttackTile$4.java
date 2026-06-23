/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import snake2d.util.datatypes.COORDINATE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 161 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 166 */     if (!PlanAttackTile.this.shouldattackTile(d, a, d.planTile.x(), d.planTile.y())) {
/* 167 */       return null;
/*     */     }
/* 169 */     double mom = 64.0D * (BOOSTABLES.BATTLE()).BLUNT_ATTACK.get((BOOSTABLE_O)a.indu());
/*     */     
/* 171 */     double str = (GAME.ARMIES()).map.strength.get((COORDINATE)d.planTile);
/*     */ 
/*     */ 
/*     */     
/* 175 */     while (mom > 0.0D) {
/* 176 */       if (mom > RND.rFloat() * str)
/* 177 */         d.planByte1 = (byte)(d.planByte1 + 1); 
/* 178 */       mom -= str;
/*     */     } 
/*     */ 
/*     */     
/* 182 */     if (d.planByte1 >= 4) {
/* 183 */       (GAME.ARMIES()).map.breakIt(d.planTile.x(), d.planTile.y());
/* 184 */       return null;
/*     */     } 
/*     */     
/* 187 */     return PlanAttackTile.this.wait.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 192 */     return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.stab.activate(a, d));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 197 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\PlanAttackTile$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */