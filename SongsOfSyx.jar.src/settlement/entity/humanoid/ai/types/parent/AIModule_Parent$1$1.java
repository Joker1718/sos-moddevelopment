/*    */ package settlement.entity.humanoid.ai.types.parent;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
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
/*    */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 63 */     return res(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 68 */     d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 < 0) {
/* 69 */       return null;
/*    */     }
/*    */     
/* 72 */     return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_BABY.aDirRND(a, d, 1.0F + RND.rFloat() * 5.0F));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 77 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\parent\AIModule_Parent$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */