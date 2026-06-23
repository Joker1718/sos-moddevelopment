/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.humanoid.Humanoid;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*  91 */   private AISUB sub = new AISUB.Simple("UNR_DROWN")
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*     */       public AISTATE resume(Humanoid a, AIManager d)
/*     */       {
/*  98 */         if (d.subByte > 20 && RND.oneIn(3)) {
/*  99 */           return null;
/*     */         }
/* 101 */         d.subByte = (byte)(d.subByte + 1);
/*     */         
/* 103 */         return (AI.STATES()).STAND.aDirRND(a, d, (float)(0.2D + RND.rFloat(0.3D)));
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 109 */     return this.sub.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 114 */     AIManager.dead = CAUSE_LEAVES.DROWNED();
/* 115 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIPlans$1$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */