/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 33 */     d.subByte = (byte)(d.subByte + 1);
/*    */     
/* 35 */     if (d.subByte > 4 + RND.rInt(5)) {
/* 36 */       return null;
/*    */     }
/* 38 */     if ((M_PlanLavatory.null.access$0(M_PlanLavatory.null.this).blue(d).service()).usageSound != null && RND.oneIn(2)) {
/* 39 */       (M_PlanLavatory.null.access$0(M_PlanLavatory.null.this).blue(d).service()).usageSound.rnd(a);
/*    */     }
/* 41 */     return (AI.STATES()).STAND.activate(a, d, 5.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanLavatory$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */