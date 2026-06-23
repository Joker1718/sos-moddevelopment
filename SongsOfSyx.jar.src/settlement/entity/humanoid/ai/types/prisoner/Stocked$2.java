/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  73 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  78 */     DIR dir = Stocked.this.blue.stockDir(d.planTile.x(), d.planTile.y(), a.speed.dir());
/*  79 */     a.speed.setDirCurrent(dir);
/*  80 */     Stocked.this.blue.stockUse(d.planTile.x(), d.planTile.y());
/*  81 */     return res(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  87 */     if (TIME.light().nightIs()) {
/*  88 */       can(a, d);
/*  89 */       PrisonerData.self.stocked.setMax(d);
/*  90 */       return null;
/*     */     } 
/*  92 */     return (AI.SUBS()).LAY.activateTime(a, d, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/*  97 */     return Stocked.this.blue.stockIsReserved(d.planTile.x(), d.planTile.y());
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 102 */     Stocked.this.blue.stockCancel(d.planTile.x(), d.planTile.y());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\Stocked$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */