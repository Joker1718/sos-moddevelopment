/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.room.service.lavatory.LavatoryInstance;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  72 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  78 */     LavatoryInstance b = (LavatoryInstance)M_PlanLavatory.this.blue(d).get(a.physics.tileC().x(), a.physics.tileC().y());
/*  79 */     if (b != null) {
/*  80 */       COORDINATE c = b.getExtra();
/*     */       
/*  82 */       if (c != null) {
/*  83 */         AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, c);
/*  84 */         if (s == null) {
/*  85 */           can(a, d);
/*  86 */           return null;
/*     */         } 
/*  88 */         return s;
/*     */       } 
/*     */     } 
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  96 */     return M_PlanLavatory.this.washing.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 101 */     return M_PlanLavatory.this.blue(d).isExtra(d.path.destX(), d.path.destY());
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 106 */     if (M_PlanLavatory.this.blue(d).isExtra(d.path.destX(), d.path.destY())) {
/* 107 */       LavatoryInstance b = (LavatoryInstance)M_PlanLavatory.this.blue(d).get(d.path.destX(), d.path.destY());
/* 108 */       b.returnExtra(d.path.destX(), d.path.destY());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanLavatory$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */