/*    */ package settlement.entity.humanoid.ai.work;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.law.court.CourtStation;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ final class WorkJudge extends PlanBlueprint {
/* 13 */   private final ROOM_COURT b = (SETT.ROOMS()).COURT; final AIPLAN.PLANRES.Resumer walk; private final AIPLAN.PLANRES.Resumer init;
/*    */   
/*    */   protected WorkJudge(AIModule_Work module, PlanBlueprint[] map) {
/* 16 */     super(module, (RoomBlueprintIns<?>)(SETT.ROOMS()).COURT, map);
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
/* 28 */     this.walk = new AIPLAN.PLANRES.Resumer(this, (this.blueprint.employment()).verb)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 32 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/* 33 */           if (s == null) {
/* 34 */             can(a, d);
/* 35 */             return null;
/*    */           } 
/* 37 */           return s;
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 42 */           return WorkJudge.this.init.set(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 47 */           CourtStation s = WorkJudge.this.b.executionSpot((COORDINATE)d.planTile);
/* 48 */           return (WorkJudge.this.hasEmployment(a, d) && s != null && s.workReserved());
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 53 */           CourtStation s = WorkJudge.this.b.executionSpot((COORDINATE)d.planTile);
/* 54 */           if (s != null) {
/* 55 */             s.workCancel();
/*    */           }
/*    */         }
/*    */       };
/* 59 */     this.init = new AIPLAN.PLANRES.Resumer(this, (this.blueprint.employment()).verb)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 63 */           CourtStation s = WorkJudge.this.b.executionSpot((COORDINATE)d.planTile);
/* 64 */           a.speed.setDirCurrent(s.jundgeDir());
/* 65 */           d.planByte1 = 20;
/* 66 */           s.workUse();
/* 67 */           return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(5));
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 73 */           CourtStation s = WorkJudge.this.b.executionSpot((COORDINATE)d.planTile);
/*    */           
/* 75 */           d.planByte1 = (byte)(d.planByte1 - 1); if (s == null || d.planByte1 <= 0 || !s.workReserved()) {
/* 76 */             can(a, d);
/* 77 */             return null;
/*    */           } 
/*    */           
/* 80 */           if (RND.oneIn(5)) {
/* 81 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.fist.activate(a, d));
/*    */           }
/* 83 */           return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(5));
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 89 */           return true;
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 94 */           WorkJudge.this.walk.can(a, d);
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     CourtStation s = this.b.workReserve((Room)work(a));
/*    */     if (s == null)
/*    */       return null; 
/*    */     d.planTile.set(s.cooJudge());
/*    */     return this.walk.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkJudge.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */