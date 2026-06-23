/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.law.court.CourtStation;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 59 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 63 */     CourtStation s = WorkJudge.this.b.executionSpot((COORDINATE)d.planTile);
/* 64 */     a.speed.setDirCurrent(s.jundgeDir());
/* 65 */     d.planByte1 = 20;
/* 66 */     s.workUse();
/* 67 */     return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(5));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 73 */     CourtStation s = WorkJudge.this.b.executionSpot((COORDINATE)d.planTile);
/*    */     
/* 75 */     d.planByte1 = (byte)(d.planByte1 - 1); if (s == null || d.planByte1 <= 0 || !s.workReserved()) {
/* 76 */       can(a, d);
/* 77 */       return null;
/*    */     } 
/*    */     
/* 80 */     if (RND.oneIn(5)) {
/* 81 */       return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.fist.activate(a, d));
/*    */     }
/* 83 */     return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(5));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 89 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 94 */     WorkJudge.this.walk.can(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkJudge$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */