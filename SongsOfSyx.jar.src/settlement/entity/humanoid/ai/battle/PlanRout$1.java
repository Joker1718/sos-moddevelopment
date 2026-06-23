/*    */ package settlement.entity.humanoid.ai.battle;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.div.Div;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.stats.STATS;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 34 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 38 */     (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1);
/* 39 */     Div div = a.division();
/* 40 */     if (div != null) {
/* 41 */       (GAME.ARMIES()).factors.reportRout(div);
/* 42 */       int di = RND.rInt(DIR.ALL.size());
/* 43 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 44 */         DIR dir = (DIR)DIR.ALL.getC(di + i);
/* 45 */         if (!div.status().threat(dir) && !div.status().threat(dir.next(1)) && !div.status().threat(dir.next(-1))) {
/* 46 */           a.setDivision(null);
/* 47 */           a.speed.turn2(dir);
/* 48 */           return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 5);
/*    */         } 
/*    */       } 
/* 51 */       a.setDivision(null);
/*    */     } 
/*    */     
/* 54 */     a.speed.turn90().turn90();
/* 55 */     a.speed.turnWithAngel(RND.rFloat0(20.0D));
/* 56 */     return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 5);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 61 */     if (RND.oneIn(5)) {
/* 62 */       return PlanRout.this.path.set(a, d);
/*    */     }
/* 64 */     return PlanRout.this.surrendered.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 69 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\PlanRout$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */