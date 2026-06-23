/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 122 */     if ((SETT.PATH()).finders.water.reserve(a.physics.tileC(), d.path, (PlanSkinny.null.access$0(PlanSkinny.null.this)).dist)) {
/* 123 */       AISUB.AISubActivation ss = (AI.SUBS()).walkTo.pathFull(a, d);
/* 124 */       if (ss != null) {
/* 125 */         (PlanSkinny.null.access$0(PlanSkinny.null.this)).stat.setAccess(a, true);
/* 126 */         return ss;
/*     */       } 
/* 128 */       can(a, d);
/*     */     } 
/* 130 */     (PlanSkinny.null.access$0(PlanSkinny.null.this)).stat.setAccess(a, false);
/* 131 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 137 */     FINDABLE s = (SETT.PATH()).finders.water.get(d.path.destX(), d.path.destY());
/* 138 */     if (s == null)
/* 139 */       return null; 
/* 140 */     if (!s.findableReservedIs()) {
/* 141 */       if (!s.findableReservedCanBe())
/* 142 */         return null; 
/* 143 */       s.findableReserve();
/*     */     } 
/* 145 */     return PlanSkinny.null.this.bathe.set(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 156 */     FINDABLE s = (SETT.PATH()).finders.water.getReserved(d.path.destX(), d.path.destY());
/* 157 */     if (s != null)
/* 158 */       s.findableReserveCancel(); 
/* 159 */     (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\PlanSkinny$1$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */