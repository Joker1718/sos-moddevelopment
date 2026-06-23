/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.service.module.ROOM_SPECTATOR;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.rnd.RND;
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
/*    */   extends M_PlanSpectator.R
/*    */ {
/*    */   null(M_PlanSpectator paramM_PlanSpectator2) {}
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 57 */     COORDINATE c = (M_PlanSpectator.this.s(d).service()).finder.reserve(a.tc(), (M_PlanSpectator.this.s(d).service()).radius);
/* 58 */     if (c == null)
/* 59 */       return null; 
/* 60 */     d.planTile.set(c);
/* 61 */     ROOM_SPECTATOR s = M_PlanSpectator.this.s(d);
/* 62 */     c = s.getDestination(c);
/* 63 */     AISUB.AISubActivation sub = (AI.SUBS()).walkTo.cooFull(a, d, c);
/* 64 */     if (sub == null) {
/* 65 */       can(a, d);
/* 66 */       return null;
/*    */     } 
/* 68 */     s.service().reportDistance(a);
/* 69 */     s.service().reportAccess(a, (COORDINATE)d.planTile);
/*    */     
/* 71 */     s.doSomeThingExtraWhenAccess(a);
/* 72 */     return sub;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 77 */     d.planByte1 = (byte)(8 + RND.rInt(8));
/* 78 */     return M_PlanSpectator.this.move.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanSpectator$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */