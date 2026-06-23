/*     */ package settlement.entity.humanoid.ai.danger;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/*  79 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  83 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.service(a, d, (SFinderFindable)(SubPlanSeekHospital.this.b.service()).finder, SubPlanSeekHospital.this.b.service().radius());
/*  84 */     if (s != null) {
/*  85 */       d.planTile.set(d.path.destX(), d.path.destY());
/*     */     }
/*  87 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  92 */     FSERVICE s = SubPlanSeekHospital.this.b.service().service(d.planTile.x(), d.planTile.y());
/*  93 */     if (s == null || !s.findableReservedIs()) {
/*  94 */       return null;
/*     */     }
/*  96 */     int x = d.planTile.x() * 64 + 32;
/*  97 */     int y = d.planTile.y() * 64 + 32;
/*  98 */     DIR dir = (SETT.ROOMS()).HOSPITAL.layCoo(d.planTile.x(), d.planTile.y());
/*  99 */     x += dir.x() * 30;
/* 100 */     y += dir.y() * 30;
/* 101 */     a.physics.body().moveC(x, y);
/* 102 */     a.speed.setDirCurrent(dir);
/* 103 */     return rest.set(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\danger\SubPlanSeekHospital$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */