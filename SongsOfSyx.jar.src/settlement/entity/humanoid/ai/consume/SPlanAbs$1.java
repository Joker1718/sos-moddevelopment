/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import settlement.stats.STATS;
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
/* 37 */     if (SPlanAbs.this.include) {
/* 38 */       s = (AI.SUBS()).walkTo.serviceInclude(a, d, (RoomService)SPlanAbs.this.blue(d).service(), ((STATS.FOOD()).STARVATION.indu().get(a.indu()) > 0) ? Integer.MAX_VALUE : (SPlanAbs.this.blue(d).service()).radius);
/*    */     } else {
/* 40 */       s = (AI.SUBS()).walkTo.service(a, d, (SFinderFindable)(SPlanAbs.this.blue(d).service()).finder, ((STATS.FOOD()).STARVATION.indu().get(a.indu()) > 0) ? Integer.MAX_VALUE : (SPlanAbs.this.blue(d).service()).radius);
/* 41 */     }  if (s == null)
/* 42 */       return null; 
/* 43 */     d.planTile.set(d.path.destX(), d.path.destY());
/* 44 */     SPlanAbs.this.blue(d).service().reportDistance(a);
/* 45 */     SPlanAbs.this.blue(d).service().reportAccess(a, (COORDINATE)d.planTile);
/* 46 */     return s;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 51 */     return SPlanAbs.this.arrive(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\SPlanAbs$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */