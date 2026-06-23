/*    */ package settlement.entity.humanoid.ai.types.prisoner;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.food.cannibal.Cage;
/*    */ import snake2d.util.MATH;
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
/* 51 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 55 */     d.planByte1 = -1;
/* 56 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 61 */     Cage c = ExecuteCannibal.this.b.cage(d.planTile.x(), d.planTile.y());
/* 62 */     if (c == null || !c.prisonerOk()) {
/* 63 */       can(a, d);
/* 64 */       return null;
/*    */     } 
/* 66 */     if (d.planByte1 == -1) {
/* 67 */       d.planByte1 = (byte)(TIME.days().bitsSinceStart() & 0xF);
/* 68 */       c.prisonerArrive();
/*    */     }
/* 70 */     else if (MATH.distance(d.planByte1, TIME.days().bitsSinceStart() & 0xF, 15) >= 2) {
/* 71 */       can(a, d);
/* 72 */       return null;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 77 */     return (AI.SUBS()).STAND.activateRndDir(a, d, 10);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 82 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 87 */     Cage c = ExecuteCannibal.this.b.cage(d.planTile.x(), d.planTile.y());
/* 88 */     if (c != null)
/* 89 */       c.prisonerCancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\ExecuteCannibal$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */