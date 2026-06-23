/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 31 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 35 */     AISUB.AISubActivation s = null;
/*    */     
/* 37 */     if (MPlan.this.include) {
/* 38 */       s = (AI.SUBS()).walkTo.serviceInclude(a, d, (RoomService)MPlan.this.blue(d).service(), MPlan.dist);
/*    */     } else {
/* 40 */       s = (AI.SUBS()).walkTo.service(a, d, (SFinderFindable)(MPlan.this.blue(d).service()).finder, MPlan.dist);
/* 41 */     }  if (s == null)
/* 42 */       return null; 
/* 43 */     d.planTile.set(d.path.destX(), d.path.destY());
/* 44 */     MPlan.this.blue(d).service().reportAccess(a, (COORDINATE)d.planTile);
/* 45 */     MPlan.this.blue(d).service().reportDistance(a);
/* 46 */     MPlan.this.blue(d).service().reportAccess(a, (COORDINATE)d.planTile);
/* 47 */     return s;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 52 */     return MPlan.this.arrive(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 57 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\MPlan$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */