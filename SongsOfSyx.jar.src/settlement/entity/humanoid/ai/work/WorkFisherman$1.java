/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.food.fish.ROOM_FISHERY;
/*    */ import snake2d.util.MATH;
/*    */ import snake2d.util.sprite.text.Str;
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
/* 34 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 38 */     SETT.ENTITIES().moveIntoTheTheUnknown((ENTITY)a);
/* 39 */     a.speed.magnitudeInit(0.0D);
/* 40 */     d.planByte2 = (byte)TIME.days().bitsSinceStart();
/* 41 */     d.planByte3 = 0;
/* 42 */     WorkFisherman.this.jobGet(a, d).jobStartPerforming();
/* 43 */     return (AI.SUBS()).STAND.activate(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 49 */     if (d.planByte3 == 1) {
/* 50 */       return WorkFisherman.this.init(a, d);
/*    */     }
/*    */     
/* 53 */     if (MATH.distanceC(d.planByte2 & 0xFF, TIME.days().bitsSinceStart() & 0xFF, 4095) >= 2) {
/* 54 */       can(a, d);
/* 55 */       return null;
/*    */     } 
/*    */     
/* 58 */     return (AI.SUBS()).STAND.activate(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 63 */     WorkFisherman.access$0(WorkFisherman.this).can(a, d);
/* 64 */     SETT.ENTITIES().returnFromTheTheUnknown((ENTITY)a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 69 */     return (WorkFisherman.this.jobGet(a, d) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void name(Humanoid a, AIManager d, Str string) {
/* 74 */     if (WorkFisherman.this.jobGet(a, d) != null) {
/* 75 */       string.add(WorkFisherman.this.jobGet(a, d).jobName());
/*    */     } else {
/* 77 */       super.name(a, d, string);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 83 */     if (e.event == HEvent.FISHINGTRIP_OVER) {
/* 84 */       if (WorkFisherman.work(a) != null && WorkFisherman.work(a).blueprintI() instanceof ROOM_FISHERY) {
/* 85 */         ROOM_FISHERY f = (ROOM_FISHERY)WorkFisherman.work(a).blueprintI();
/* 86 */         f.performFishingTrip(a, d.planTile.x(), d.planTile.y(), 0.0D);
/* 87 */         d.planByte3 = 1;
/*    */       } else {
/* 89 */         can(a, d);
/* 90 */         d.planByte3 = 1;
/*    */       } 
/*    */     }
/* 93 */     return super.event(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkFisherman$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */