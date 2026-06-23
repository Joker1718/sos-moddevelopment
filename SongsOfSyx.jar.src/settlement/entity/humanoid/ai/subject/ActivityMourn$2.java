/*    */ package settlement.entity.humanoid.ai.subject;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FSERVICE;
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
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 56 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 60 */     d.planByte1 = (byte)(4 + RND.rInt(8));
/* 61 */     return (AI.SUBS()).STAND.activate(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 67 */     d.planByte1 = (byte)(d.planByte1 - 1);
/* 68 */     if (d.planByte1 >= 0) {
/* 69 */       return (AI.SUBS()).STAND.activateRndDir(a, d);
/*    */     }
/*    */     
/* 72 */     FSERVICE s = (FSERVICE)(SETT.ROOMS()).graveServiceSpots.get(d.path.destX(), d.path.destY());
/* 73 */     if (s != null)
/* 74 */       s.consume(); 
/* 75 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 80 */     return ((SETT.ROOMS()).graveServiceSpots.get(d.path.destX(), d.path.destY()) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 85 */     FSERVICE s = (FSERVICE)(SETT.ROOMS()).graveServiceSpots.get(d.path.destX(), d.path.destY());
/* 86 */     if (s != null)
/* 87 */       s.findableReserveCancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\ActivityMourn$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */