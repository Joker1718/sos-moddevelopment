/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  86 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  97 */     RESOURCE_TILE res = RESOURCE_TILE.GETTER.reserved(WorkFarmer.this.ress(d), d.path.destX(), d.path.destY());
/*  98 */     if (res == null) {
/*  99 */       can(a, d);
/* 100 */       return null;
/*     */     } 
/*     */     
/* 103 */     for (int i = 0; i < WorkFarmer.this.amount(d) && 
/* 104 */       res.findableReservedIs(); i++) {
/*     */       
/* 106 */       res.resourcePickup();
/* 107 */       d.resourceCarriedSet(WorkFarmer.this.ress(d));
/*     */     } 
/*     */     
/* 110 */     return WorkFarmer.this.go.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 121 */     RESOURCE_TILE res = RESOURCE_TILE.GETTER.reserved(WorkFarmer.this.ress(d), d.path.destX(), d.path.destY());
/* 122 */     for (int i = 0; i < WorkFarmer.this.amount(d) && 
/* 123 */       res.findableReservedIs(); i++)
/*     */     {
/* 125 */       res.findableReserveCancel();
/*     */     }
/* 127 */     WorkFarmer.this.go.can(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkFarmer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */