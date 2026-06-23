/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.stats.service.StatService;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends S_Plan
/*     */ {
/*     */   null(StatService $anonymous0, double $anonymous1) {
/*  78 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public boolean hasAccess(Humanoid a, AIManager d) {
/*  82 */     return (n.stats().access().indu().get(a.indu()) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*  87 */     return getPlan(a, d, n.radius());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean allowed(Humanoid a, AIManager d) {
/*  92 */     return (n.stats().accessRequest(a) && n.finder.has(a.tc()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean goodTime(Humanoid a, AIManager d) {
/*  97 */     return n.isGoodTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d, int dist) {
/* 102 */     if (n.stats().accessRequest(a) && n.finder.has(a.tc())) {
/* 103 */       d.planByte3 = (byte)n.room().typeIndex();
/* 104 */       MPlan.dist = dist;
/* 105 */       AIPLAN.AiPlanActivation p = plan.activate(a, d);
/* 106 */       if (p != null)
/* 107 */         return p; 
/*     */     } 
/* 109 */     n.clearAccess(a);
/* 110 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\S_Plans$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */