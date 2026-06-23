/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.datatypes.DIR;
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
/* 26 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 31 */     (STATS.POP()).NAKED.set(a.indu(), 1);
/* 32 */     DIR dir = M_PlanPhysician.this.blue(d).getLayDir(d.planTile.x(), d.planTile.y());
/* 33 */     a.speed.setDirCurrent(dir);
/* 34 */     int x = d.planTile.x() * 64 + 32 + dir.x() * 30;
/* 35 */     int y = d.planTile.y() * 64 + 32 + dir.y() * 30;
/* 36 */     a.physics.body().moveC(x, y);
/* 37 */     return (AI.SUBS()).LAY.activateTime(a, d, 25);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 42 */     M_PlanPhysician.this.get(a, d).consume();
/* 43 */     can(a, d);
/* 44 */     for (DIR dir : DIR.ORTHO) {
/* 45 */       if (!(SETT.PATH()).solidity.is(a.tc(), dir)) {
/* 46 */         int x = a.tc().x() * 64 + 32 + dir.x() * 64;
/* 47 */         int y = a.tc().y() * 64 + 32 + dir.y() * 64;
/* 48 */         a.physics.body().moveC(x, y);
/*    */         
/*    */         break;
/*    */       } 
/*    */     } 
/*    */     
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 59 */     return (M_PlanPhysician.this.get(a, d) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 64 */     (STATS.POP()).NAKED.set(a.indu(), 0);
/* 65 */     if ((M_PlanPhysician.this.blue(d).service()).finder.getReserved(d.planTile.x(), d.planTile.y()) != null) {
/* 66 */       (M_PlanPhysician.this.blue(d).service()).finder.getReserved(d.planTile.x(), d.planTile.y()).findableReserveCancel();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 71 */     if (e.event == HEvent.COLLISION_UNREACHABLE)
/* 72 */       return true; 
/* 73 */     return super.event(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanPhysician$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */