/*    */ package settlement.entity.humanoid.ai.battle;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ 
/*    */ public final class BattleUtil
/*    */ {
/*    */   static double getAttackPause(Humanoid a, AIManager d) {
/* 12 */     return 1.0D;
/*    */   }
/*    */   
/*    */   static boolean isInPosition(COORDINATE dest, Humanoid a, AIManager d) {
/* 16 */     return dest.isSameAs(a.physics.body().cX(), a.physics.body().cY());
/*    */   }
/*    */   
/*    */   static boolean hasSpot(Humanoid a, AIManager d) {
/* 20 */     Div div = a.division();
/* 21 */     return (div != null && div.reporter.posHas(a));
/*    */   }
/*    */   
/*    */   static boolean shouldMoveIntoDivPosition(Humanoid a, AIManager d) {
/* 25 */     if (a.division() == null)
/* 26 */       return false; 
/* 27 */     if (!a.division().settings().mustering())
/* 28 */       return false; 
/* 29 */     if (a.division().settings().moppingUp())
/* 30 */       return false; 
/* 31 */     if (!(a.division()).reporter.posHas(a))
/* 32 */       return false; 
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\BattleUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */