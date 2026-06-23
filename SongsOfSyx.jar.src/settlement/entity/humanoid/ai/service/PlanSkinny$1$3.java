/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 167 */     (STATS.POP()).NAKED.set(a.indu(), 1);
/* 168 */     (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/* 169 */     d.planByte1 = (byte)(5 + RND.rInt(10));
/* 170 */     return PlanSkinny.null.this.sub.activate(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 176 */     (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/* 177 */     (STATS.NEEDS()).DIRTINESS.set(a.indu(), 0);
/*     */     
/* 179 */     if (!conn(a, d)) {
/* 180 */       can(a, d);
/* 181 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 185 */     d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 > 0 && AIModules.current(d) != null && AIModules.current(d).moduleCanContinue(a, d) && (SETT.WEATHER()).ice.canBatheOutside()) {
/* 186 */       return PlanSkinny.null.this.sub.activate(a, d);
/*     */     }
/* 188 */     can(a, d);
/* 189 */     return null;
/*     */   }
/*     */   
/*     */   private boolean conn(Humanoid a, AIManager d) {
/* 193 */     FINDABLE s = (SETT.PATH()).finders.water.getReserved(d.path.destX(), d.path.destY());
/* 194 */     return (s != null && s.findableReservedIs());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 199 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 204 */     FINDABLE s = (SETT.PATH()).finders.water.getReserved(d.path.destX(), d.path.destY());
/* 205 */     if (s != null)
/* 206 */       s.findableReserveCancel(); 
/* 207 */     (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\PlanSkinny$1$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */