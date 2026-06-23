/*    */ package settlement.entity.humanoid.ai.subject;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ import world.army.AD;
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
/* 48 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 52 */     if ((SETT.PATH()).finders.entity.findExitNoEnemies(a, a.physics.tileC().x(), a.physics.tileC().y(), d.path, 2147483647)) {
/* 53 */       PlanJoinArmy.this.dequip(a, d);
/* 54 */       return (AI.SUBS()).walkTo.pathFull(a, d);
/*    */     } 
/* 56 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 61 */     if ((STATS.BATTLE()).DIV.get(a) == null)
/* 62 */       return null; 
/* 63 */     AIManager.dead = CAUSE_LEAVES.ARMY();
/* 64 */     AD.cityDivs().add(a, (Div)(STATS.BATTLE()).DIV.get(a));
/* 65 */     return (AI.SUBS()).STAND.activate(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 70 */     return (SETT.BATTLE()).info.shouldJoinArmy(a);
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\PlanJoinArmy$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */