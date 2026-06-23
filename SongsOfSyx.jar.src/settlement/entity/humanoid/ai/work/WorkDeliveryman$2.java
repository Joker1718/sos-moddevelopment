/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 139 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 143 */     if (!con(a, d)) {
/* 144 */       can(a, d);
/* 145 */       return WorkDeliveryman.access$0(WorkDeliveryman.this).set(a, d);
/*     */     } 
/* 147 */     return (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 153 */     if (!con(a, d)) {
/* 154 */       can(a, d);
/* 155 */       return WorkDeliveryman.access$0(WorkDeliveryman.this).set(a, d);
/*     */     } 
/* 157 */     TILE_STORAGE c = WorkDeliveryman.this.targetStorage(a, d);
/* 158 */     int am = d.resourceA();
/* 159 */     am = CLAMP.i(am, 0, c.storageReserved());
/* 160 */     c.storageDeposit(am);
/*     */     
/* 162 */     int res = d.planByte1 - am;
/* 163 */     if (res > 0) {
/* 164 */       c.storageUnreserve(res);
/*     */     }
/* 166 */     if (d.resourceCarried() != null)
/* 167 */       d.resourceAInc(-am); 
/* 168 */     d.resourceDrop(a);
/*     */     
/* 170 */     int i = d.resourceA() - am;
/* 171 */     if (i > 0)
/* 172 */       d.resourceDrop(a); 
/* 173 */     d.resourceCarriedSet(null);
/* 174 */     STATS.WORK().fetchProximityEnd(a);
/* 175 */     return WorkDeliveryman.access$0(WorkDeliveryman.this).set(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 181 */     if (WorkDeliveryman.work(a) != null) {
/* 182 */       TILE_STORAGE c = WorkDeliveryman.this.targetStorage(a, d);
/*     */       
/* 184 */       if (c != null && c.storageReserved() > 0 && c.resource() != null && c.resource().bIndex() == d.planByte2) {
/* 185 */         return true;
/*     */       }
/*     */     } 
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 193 */     WorkDeliveryman.this.unreserve(a, d);
/* 194 */     STATS.WORK().fetchProximityEnd(a);
/* 195 */     d.resourceDrop(a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkDeliveryman$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */