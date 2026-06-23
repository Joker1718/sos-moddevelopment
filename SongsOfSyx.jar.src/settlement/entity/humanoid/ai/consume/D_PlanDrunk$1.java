/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import snake2d.util.datatypes.DIR;
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
/*    */ class null
/*    */   extends AISUB.Simple
/*    */ {
/*    */   null(String $anonymous0) {
/* 35 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 39 */     if (d.subByte == 0) {
/* 40 */       a.speed.turnRandom();
/* 41 */       AISTATE s = (AI.STATES()).WALK.activate(a, d, (4 + RND.rInt(5)));
/* 42 */       a.speed.magnitudeTargetSet(0.2D);
/* 43 */       a.speed.setDirCurrent((DIR)DIR.ALL.rnd());
/* 44 */       d.subByte = 1;
/* 45 */       return s;
/*    */     } 
/* 47 */     a.speed.magnitudeInit(0.0D);
/* 48 */     a.speed.magnitudeTargetSet(0.0D);
/* 49 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 54 */     if (e.event == HEvent.COLLISION_TILE) {
/* 55 */       return true;
/*    */     }
/* 57 */     return super.event(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\D_PlanDrunk$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */