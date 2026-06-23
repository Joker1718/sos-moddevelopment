/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.employment.RoomEquip;
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
/*    */   extends AIPlanResourceMany
/*    */ {
/*    */   null(AIPLAN.PLANRES $anonymous0, int $anonymous1) {
/* 81 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation next(Humanoid a, AIManager d) {
/* 85 */     AISUB.AISubActivation s = PlanFetchEquip.this.toRoom.set(a, d);
/* 86 */     return s;
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancel(Humanoid a, AIManager d) {
/* 91 */     RoomInstance ins = PlanFetchEquip.work(a);
/* 92 */     if (ins == null)
/*    */       return; 
/* 94 */     RESOURCE res = resource(a, d);
/* 95 */     if (res == null)
/*    */       return; 
/* 97 */     RoomEquip w = PlanFetchEquip.this.eq(res, ins);
/* 98 */     ins.employees().toolReserve(w, -target(a, d));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanFetchEquip$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */