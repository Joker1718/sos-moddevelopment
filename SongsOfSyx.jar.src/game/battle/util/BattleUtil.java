/*    */ package game.battle.util;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.boosting.Boostable;
/*    */ 
/*    */ public final class BattleUtil
/*    */ {
/*  8 */   public final Power power = new Power();
/*  9 */   private final Boosts boosts = new Boosts();
/* 10 */   public final DivTypes types = new DivTypes();
/* 11 */   public final FightingUtil fight = new FightingUtil();
/* 12 */   public final ArmyFormations formations = new ArmyFormations();
/*    */ 
/*    */   
/*    */   public BattleUtil(GAME game) {}
/*    */ 
/*    */   
/*    */   public double boost(DIV_SPEC div, Boostable bo) {
/* 19 */     return this.boosts.get(div, bo);
/*    */   }
/*    */   
/*    */   public double boostMax(Boostable bo) {
/* 23 */     return this.boosts.max(bo);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\BattleUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */