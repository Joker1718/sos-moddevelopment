/*    */ package game.boosting.superb;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.faction.royalty.Royalty;
/*    */ 
/*    */ public class SuperBoostables
/*    */ {
/*  9 */   public SuperBoostable<Royalty> OPINION = new SuperBoostable<>((BOOSTABLES.CIVICS()).bOpinion);
/* 10 */   public SuperBoostable<Royalty> TRUST = new SuperBoostable<>((BOOSTABLES.CIVICS()).TRUST);
/*    */   
/*    */   public SuperBoostables(GAME game) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperBoostables.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */