/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.spirit.shrine.ROOM_SHRINE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  72 */     d.planByte4 = 0;
/*  73 */     for (ROOM_SHRINE t : S_PlanShrine.null.access$0(S_PlanShrine.null.this).services(a, d)) {
/*  74 */       AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(t.service()).finder, (t.service()).radius);
/*  75 */       if (s != null) {
/*  76 */         d.planByte4 = (byte)t.typeIndex();
/*  77 */         return s;
/*     */       } 
/*     */     } 
/*     */     
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  87 */     (STATS.RELIGION()).SHRINE.setAccess(a);
/*  88 */     return S_PlanShrine.null.this.pray.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 103 */     string.add((S_PlanShrine.null.this.temp(d).service()).verb);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\S_PlanShrine$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */